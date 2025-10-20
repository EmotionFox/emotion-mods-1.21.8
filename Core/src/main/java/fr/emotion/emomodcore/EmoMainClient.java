package fr.emotion.emomodcore;

import fr.emotion.emomodcore.utils.DreamClientData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.BossHealthOverlay;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
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

import java.lang.reflect.Field;
import java.util.Map;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    private static final ResourceLocation ICONS = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/gui/icons.png");
    private static final ResourceLocation DREAM_BAR_OVERLAY = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/gui/dream_bar_overlay.png");
    private static final ResourceLocation DREAM_BAR_PROGRESS = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/gui/dream_bar_progress.png");
    private static final ResourceLocation DREAM_BAR_BACKGROUND = ResourceLocation.withDefaultNamespace("textures/gui/sprites/boss_bar/white_background.png");

    public EmoMainClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();

        if (mc.player==null) return;

        if (DreamClientData.isDreaming()) {
            int bossBarCount = 0;

            try {
                BossHealthOverlay bossOverlay = mc.gui.getBossOverlay();
                Field eventsField = BossHealthOverlay.class.getDeclaredField("events");
                eventsField.setAccessible(true);
                Map<?, ?> events = (Map<?, ?>) eventsField.get(bossOverlay);
                bossBarCount = events.size();
            } catch (NoSuchFieldException | IllegalAccessException ignored) {
                EmoMain.LOGGER.info("No field events in BossHealthOverlay.class");
            }

            if (DreamClientData.getAwakening() - mc.player.level().getGameTime() > 0) {
                long awakening = (DreamClientData.getAwakening() - mc.player.level().getGameTime());
                long awakeningSecond = awakening / 20;
                Component text = Component.translatable("dream.awakening_in").append(String.valueOf(awakeningSecond));
                int posX = event.getGuiGraphics().guiWidth() / 2;
                int posY = 12 + (10 * bossBarCount);
                float test = (float) awakening / DreamClientData.getPeriod();
                int progressWidth = (int) Math.max(0, Math.min(182, test * 182));

                if (awakening <= 100 && awakening % 20==0) mc.player.displayClientMessage(text, true);

                event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, DREAM_BAR_BACKGROUND, posX - 91, posY, 0, 0, 182, 5, 182, 5);
                event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, DREAM_BAR_PROGRESS, posX - 91, posY, 0, 0, progressWidth, 5, 182, 5);
                event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, DREAM_BAR_OVERLAY, posX - 134, posY - 2, 0, 0, 268, 9, 268, 9);
            }
        }

        if (Config.GUI_HEALTH.isFalse() || mc.player.isCreative() || mc.player.isSpectator() || !(mc.crosshairPickEntity instanceof LivingEntity entity) || entity instanceof EnderDragon || entity instanceof WitherBoss)
            return;

        int color;
        if (entity instanceof Animal) color = 0xFF00b21d; // Lime
        else if (entity instanceof Player) color = 0xFF1b82ba; // Cyan
        else color = 0xFF91438c; // Purple

        int maxHearts = (int) Math.ceil(entity.getMaxHealth() / 2F);
        // Clamp to 10
        maxHearts = Math.min(maxHearts, 10);
        int fullHearts = (int) (entity.getHealth() / 2F);
        boolean half = (entity.getHealth() % 2F) > 0F;
        boolean hasArmor = mc.player!=null && (mc.player.getArmorValue() > 0);
        boolean hasAbsorption = mc.player!=null && (mc.player.getAbsorptionAmount() > 0.0F);
        // Vanilla offset for health, food, armor...
        int vanillaOffset = 91;

        Config.GuiPosition position = Config.GUI_POSITION.get();

        int posX = event.getGuiGraphics().guiWidth() / 2;
        int posY = event.getGuiGraphics().guiHeight() - 49;

        String text = entity.getName().getString();
        int textWidth = mc.font.width(text);
        int textX = event.getGuiGraphics().guiWidth() / 2;
        int textY = posY;

        switch (position) {
            case FULL_RIGHT:
                posX += vanillaOffset - ((maxHearts) * 4);
                textX += vanillaOffset - textWidth;
                textY -= 10;
                break;
            case BOTTOM_LEFT:
                posX = 10 + ((maxHearts) * 4);
                posY = event.getGuiGraphics().guiHeight() - 20;
                textX = 10;
                textY = posY - 10;
                break;
            case BOTTOM_RIGHT:
                posX = event.getGuiGraphics().guiWidth() - (10 + ((maxHearts) * 4));
                posY = event.getGuiGraphics().guiHeight() - 20;
                textX = event.getGuiGraphics().guiWidth() - (10 + textWidth);
                textY = posY - 10;
                break;
            case LEFT_RIGHT:
                posX -= (vanillaOffset - ((maxHearts) * 4));
                textX += vanillaOffset - textWidth;
                posY -= hasArmor ? 10:0;
                posY -= hasAbsorption ? 10:0;
                textY = posY;
                break;
        }

        int offset = maxHearts * 8;

        for (int i = 0; i < maxHearts; i++) {
            int x = posX - (offset / 2) + (i * 8);
            event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x, posY, 0, 0, 9, 9, 16, 16, 0xFFFFFFFF);

            if (i < fullHearts) {
                event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x + 1, posY + 1, 0.0F, 9.0F, 7, 7, 16, 16, color);
            } else if (i==fullHearts && half) {
                event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ICONS, x + 1, posY + 1, 0.0F, 9.0F, 4, 7, 16, 16, color);
            }
        }

        event.getGuiGraphics().drawString(mc.font, text, textX, textY, color);
    }
}
