package fr.emotion.emomodcore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    public EmoMainClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    private static final ResourceLocation ICONS = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/gui/icons.png");
    private static float width;
    private static int height;
    private static int color = 0xFFFFFFFF; // White DECIMAL

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        if (Config.GUI_HEALTH.isTrue()) {
            Minecraft mc = Minecraft.getInstance();
            ClientLevel level = mc.level;

            if (mc.crosshairPickEntity instanceof LivingEntity entity) {
                if (entity instanceof Animal) {
                    height = 9; // Height on the screen in pixel
                    color = 0xFF00b21d; // Lime Color DECIMAL
                } else if (entity instanceof Player) {
                    height = 23; // Height on the screen in pixel
                    color = 0xFF1b82ba; // Cyan Color DECIMAL
                } else {
                    height = 16; // Height on the screen in pixel
                    color = 0xFF91438c; // Purple Color DECIMAL
                }

                float health = entity.getHealth() / entity.getMaxHealth();
                String name = entity.getName().getString();
                width = health * 71;

                boolean flag = entity instanceof EnderDragon || entity instanceof WitherBoss;

                if (!flag && mc.player!=null && !mc.player.isCreative()) {
                    int maxHearts = (int) Math.ceil(entity.getMaxHealth() / 2.0);
                    maxHearts = Math.min(maxHearts, 10);
                    int hearts = (int) Math.ceil(entity.getHealth() / 2.0);

                    int posX = event.getGuiGraphics().guiWidth() / 2;
                    int posY = event.getGuiGraphics().guiHeight() - 68;

                    int offset = maxHearts * 8;

                    for (int i = 0; i < maxHearts; i++) {
                        int x = posX - (offset / 2) + (i * 8);
                        event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x, posY + 10, 0, 0, 9, 9, 16, 16, 0xFFFFFFFF);

                        if (i < hearts)
                            event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x + 1, posY + 11, 0, 9, 7, 7, 16, 16, color);
                    }

                    event.getGuiGraphics().drawCenteredString(mc.font, "" + name + " [" + entity.getHealth() + "]", posX, posY, color);
                }
            }
        }
    }
}
