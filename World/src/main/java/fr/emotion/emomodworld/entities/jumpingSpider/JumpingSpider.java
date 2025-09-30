package fr.emotion.emomodworld.entities.jumpingSpider;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class JumpingSpider extends Spider {
    public JumpingSpider(EntityType<? extends Spider> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createJumpingSpiderAttributes() {
        return Spider.createAttributes().add(Attributes.MAX_HEALTH, 12.0);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData) {
        return groupData;
    }
}
