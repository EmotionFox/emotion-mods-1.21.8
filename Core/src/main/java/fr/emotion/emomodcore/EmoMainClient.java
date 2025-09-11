package fr.emotion.emomodcore;

import net.minecraft.client.Minecraft;
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

import java.text.DecimalFormat;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    private static final ResourceLocation ICONS = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/gui/icons.png");
    private static int color = 0xFFFFFFFF; // White

    public EmoMainClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        if (Config.GUI_HEALTH.isTrue()) {
            Minecraft mc = Minecraft.getInstance();

            if (mc.crosshairPickEntity instanceof LivingEntity entity) {
                if (entity instanceof Animal) color = 0xFF00b21d; // Lime
                else if (entity instanceof Player) color = 0xFF1b82ba; // Cyan
                else color = 0xFF91438c; // Purple

                String name = entity.getName().getString();

                boolean boss = entity instanceof EnderDragon || entity instanceof WitherBoss;

                if (!boss && mc.player!=null && !mc.player.isCreative()) {
                    int maxHearts = (int) Math.ceil(entity.getMaxHealth() / 2.0);
                    maxHearts = Math.min(maxHearts, 10);

                    int fullHearts = (int) (entity.getHealth() / 2F);
                    boolean half = (entity.getHealth() % 2F) > 0F;

                    DecimalFormat df = new DecimalFormat("0.0");

                    int posX = event.getGuiGraphics().guiWidth() / 2;
                    int posY = event.getGuiGraphics().guiHeight() - 68;
                    int offset = maxHearts * 8;

                    for (int i = 0; i < maxHearts; i++) {
                        int x = posX - (offset / 2) + (i * 8);
                        event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x, posY + 10, 0, 0, 9, 9, 16, 16, 0xFFFFFFFF);

                        if (i < fullHearts) {
                            event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x + 1, posY + 11, 0.0F, 9.0F, 7, 7, 16, 16, color);
                        } else if (i==fullHearts && half) {
                            event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x + 1, posY + 11, 0.0F, 9.0F, 4, 7, 16, 16, color);
                        }
                    }

                    event.getGuiGraphics().drawCenteredString(mc.font, name + " [" + df.format(entity.getHealth()) + "]", posX, posY, color);
                }
            }
        }
    }
}
