package fr.emotion.emomodworld.utils;

import java.awt.*;

public class EmoColor {
    public static int blendColors(int color1, int color2, float ratio) {
        float inverseRatio = 1.0F - ratio;
        int r = (int) (((color1 >> 16 & 0xFF) * ratio) + ((color2 >> 16 & 0xFF) * inverseRatio));
        int g = (int) (((color1 >> 8 & 0xFF) * ratio) + ((color2 >> 8 & 0xFF) * inverseRatio));
        int b = (int) (((color1 & 0xFF) * ratio) + ((color2 & 0xFF) * inverseRatio));

        return (r << 16) | (g << 8) | b;
    }

    public static int blendColorsByHeight(int color1, int color2, float percent, float dif, float min) {
        Color c1 = new Color(color1);
        Color c2 = new Color(color2);

        int r = 0;
        int g = 0;
        int b = 0;

        if (c1.getRed() < c2.getRed())
            r = Math.round(c1.getRed() + ((c2.getRed() - c1.getRed()) / dif * (percent - min)));
        else if (c1.getRed() > c2.getRed())
            r = Math.round(c1.getRed() - ((c1.getRed() - c2.getRed()) / dif * (percent - min)));

        if (c1.getGreen() < c2.getGreen())
            g = Math.round(c1.getGreen() + ((c2.getGreen() - c1.getGreen()) / dif * (percent - min)));
        else if (c1.getGreen() > c2.getGreen())
            g = Math.round(c1.getGreen() - ((c1.getGreen() - c2.getGreen()) / dif * (percent - min)));

        if (c1.getBlue() < c2.getBlue())
            b = Math.round(c1.getBlue() + ((c2.getBlue() - c1.getBlue()) / dif * (percent - min)));
        else if (c1.getBlue() > c2.getBlue())
            b = Math.round(c1.getBlue() - ((c1.getBlue() - c2.getBlue()) / dif * (percent - min)));

        r = r < 0 ? 0:Math.min(r, 255);
        g = g < 0 ? 0:Math.min(g, 255);
        b = b < 0 ? 0:Math.min(b, 255);

        return (r << 16) | (g << 8) | b;
    }
}
