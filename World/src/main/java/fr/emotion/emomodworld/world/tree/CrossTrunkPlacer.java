package fr.emotion.emomodworld.world.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoTrunkPlacerType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class CrossTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<CrossTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> trunkPlacerParts(instance)
                    .and(Codec.BOOL.fieldOf("height_dependent").forGetter(tp -> tp.heightDependent))
                    .and(Codec.BOOL.fieldOf("rooted").forGetter(tp -> tp.rooted))
                    .apply(instance, CrossTrunkPlacer::new)
    );

    private final boolean heightDependent;
    private final boolean rooted;

    public CrossTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, boolean heightDependent, boolean rooted) {
        super(baseHeight, heightRandA, heightRandB);
        this.heightDependent = heightDependent;
        this.rooted = rooted;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return EmoTrunkPlacerType.CROSS_TRUNK_PLACER.get();
    }

    private int layer = 0;
    private float heightPercentage;
    private float smallChancePourcentage;

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        setDirtAt(level, blockSetter, random, pos.below(), config);

        int newHeight = freeTreeHeight;

        if (heightDependent) {
            if (level instanceof WorldGenLevel worldGenLevel) {
                heightPercentage = (float) ((pos.getY() - 65) * 100) / (worldGenLevel.getHeight() - 65);
                smallChancePourcentage = 25.0F + ((float) random.nextInt(25));
                EmoMain.LOGGER.info("Height Percentage: " + heightPercentage);

                if (heightPercentage <= 10.0F) {
                    newHeight += random.nextInt(3);
                    layer = 3;
                } else if (heightPercentage <= 20.0F) {
                    layer = 2;
                } else if (heightPercentage <= 30.0F) {
                    newHeight -= random.nextInt(3);
                    layer = 1;
                    smallChancePourcentage += 25.0F + ((float) random.nextInt(25));
                } else {
                    smallChancePourcentage += 50.0F + ((float) random.nextInt(25));
                }

                if (random.nextInt(100) <= ((int) Math.ceil(smallChancePourcentage))) {
                    newHeight = rooted ? 5:3;
                    layer = 0;
                }
            }
        }

        List<FoliagePlacer.FoliageAttachment> list = new ArrayList<>();

        if (rooted) {
            for (int y = 0; y < newHeight; y++) {
                this.placeLog(level, blockSetter, random, pos.above(y), config);
            }

            for (int xz = -1; xz <= 1; xz++) {
                this.placeLog(level, blockSetter, random, pos.offset(xz, 2, 0), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
                this.placeLog(level, blockSetter, random, pos.offset(0, 2, xz), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
            }


            for (int r = 0; r <= 4; r++) {
                BlockPos rootPos;
                Direction dir;

                switch (r) {
                    case 1:
                        rootPos = pos.offset(0, 1, 2);
                        dir = Direction.NORTH;
                        break;
                    case 2:
                        rootPos = pos.offset(2, 1, 0);
                        dir = Direction.WEST;
                        break;
                    case 3:
                        rootPos = pos.offset(-2, 1, 0);
                        dir = Direction.EAST;
                        break;
                    default:
                        rootPos = pos.offset(0, 1, -2);
                        dir = Direction.SOUTH;
                        break;
                }

                int rootLenght = 10;

                for (int i = 0; validTreePos(level, rootPos.offset(0, i, 0)) && i >= -rootLenght; i--) {
                    this.placeLog(level, blockSetter, random, rootPos.offset(0, i, 0), config);

                    if (i==-rootLenght) {
                        rootPos = rootPos.offset(dir.getUnitVec3i().offset(0, -(rootLenght + 1), 0));
                        this.placeLog(level, blockSetter, random, rootPos, config, state -> state.trySetValue(RotatedPillarBlock.AXIS, dir.getAxis()));
                        rootPos = rootPos.offset(dir.getUnitVec3i());

                        for (int y = 1; y <= 2; y++) {
                            this.placeLog(level, blockSetter, random, rootPos.above(y), config);
                            if (y==2) list.add(new FoliagePlacer.FoliageAttachment(rootPos.above(y + 1), 1, false));
                        }
                    }
                }
            }
        } else {
            for (int y = 0; y < newHeight; y++) {
                this.placeLog(level, blockSetter, random, pos.above(y), config);
            }
        }

        if (layer > 0 && heightDependent) {
            for (int l = 0; l < layer; l++) {
                int yHeight = (newHeight - (l * 3)) - 3;
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yHeight, 0), 1, false));

                for (int xz = -(2 + l); xz <= (2 + l); xz++) {
                    boolean flag = (xz==-(2 + l) || xz==(2 + l));
                    boolean flag1 = l > 0 && flag;
                    boolean flag2 = (xz==-(1 + l) || xz==(1 + l));

                    if (flag2) {
                        this.placeLog(level, blockSetter, random, pos.offset(-xz, yHeight, xz), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.Y));
                        this.placeLog(level, blockSetter, random, pos.offset(xz, yHeight, -xz), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.Y));
                        this.placeLog(level, blockSetter, random, pos.offset(-xz, yHeight, -xz), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.Y));
                    }
                    this.placeLog(level, blockSetter, random, pos.offset(xz, yHeight + (flag1 ? 1:0), 0), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
                    this.placeLog(level, blockSetter, random, pos.offset(0, yHeight + (flag1 ? 1:0), xz), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));

                    if (flag) {
                        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(xz, yHeight + (flag1 ? 1:0), 0), 0, false));
                        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yHeight + (flag1 ? 1:0), xz), 0, false));
                    } else if (flag2) {
                        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-xz, yHeight, xz), 0, false));
                        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(xz, yHeight, -xz), 0, false));
                        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-xz, yHeight, -xz), 0, false));
                    }
                }
            }
        } else if (!heightDependent) {
            for (int xz = -2; xz <= 2; xz++) {
                this.placeLog(level, blockSetter, random, pos.offset(xz, newHeight - 3, 0), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
                this.placeLog(level, blockSetter, random, pos.offset(0, newHeight - 3, xz), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
            }
        }

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, newHeight - 1, 0), 0, false));

        return list;
    }

    public static boolean isReplaceable(LevelSimulatedReader level, BlockPos pos) {
        return level.isStateAtPosition(pos, BlockBehaviour.BlockStateBase::canBeReplaced);
    }
}
