package nfm.open.util;

import java.awt.Color;
import java.text.NumberFormat;

public class GradientUtil {
    private GradientUtil() {
    }

    /**
     * Blends an array of colors into a fading gradient
     * <p>
     *
     * <pre>
     * private float[] fractions = new float[] {
     *         0f, 0.25f, 0.5f, 1f
     * };
     * private Color[] colors = new Color[] {
     *         Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED
     * };
     * </pre>
     *
     * @param fractions The starting point of each color
     * @param colors The colors of the gradient
     * @param progress How far into the gradient you are
     * @return A color
     * @author <a href="http://stackoverflow.com/users/992484/madprogrammer">MadProgrammer</a>
     */
    public static Color blendColors(final float[] fractions, final Color[] colors, final float progress) {
        final Color color;
        if (fractions != null) {
            if (colors != null) {
                if (fractions.length == colors.length) {
                    final int[] indicies = getFractionIndicies(fractions, progress);

                    final float[] range = new float[] {
                            fractions[indicies[0]], fractions[indicies[1]]
                    };
                    final Color[] colorRange = new Color[] {
                            colors[indicies[0]], colors[indicies[1]]
                    };

                    final float max = range[1] - range[0];
                    final float value = progress - range[0];
                    final float weight = value / max;

                    color = blend(colorRange[0], colorRange[1], 1f - weight);
                } else
                    throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
            } else
                throw new IllegalArgumentException("Colours can't be null");
        } else
            throw new IllegalArgumentException("Fractions can't be null");
        return color;
    }

    /**
     * Unchecked version of {@link #blendColors(float[], Color[], float)}
     *
     * @param fractions The starting point of each color
     * @param colors The colors of the gradient
     * @param progress How far into the gradient you are
     * @return A color
     * @author Rafael
     * @see Utility.GradientUtil#blendColors(float[], Color[], float)
     */
    public static Color blendColorsUnsafe(final float[] fractions, final Color[] colors, final float progress) {
        final Color color;

        final int[] indicies = getFractionIndicies(fractions, progress);

        final float[] range = new float[] {
                fractions[indicies[0]], fractions[indicies[1]]
        };
        final Color[] colorRange = new Color[] {
                colors[indicies[0]], colors[indicies[1]]
        };

        final float max = range[1] - range[0];
        final float value = progress - range[0];
        final float weight = value / max;

        color = blend(colorRange[0], colorRange[1], 1f - weight);

        return color;
    }

    public static int[] getFractionIndicies(final float[] fractions, final float progress) {
        final int[] range = new int[2];

        int startPoint = 0;
        while (startPoint < fractions.length && fractions[startPoint] <= progress) {
            startPoint++;
        }

        if (startPoint >= fractions.length) {
            startPoint = fractions.length - 1;
        }

        range[0] = startPoint - 1;
        range[1] = startPoint;

        return range;
    }

    public static Color blend(final Color color1, final Color color2, final double ratio) {
        final float r = (float) ratio;
        final float ir = (float) 1.0 - r;

        final float rgb1[] = new float[3];
        final float rgb2[] = new float[3];

        color1.getColorComponents(rgb1);
        color2.getColorComponents(rgb2);

        float red = rgb1[0] * r + rgb2[0] * ir;
        float green = rgb1[1] * r + rgb2[1] * ir;
        float blue = rgb1[2] * r + rgb2[2] * ir;

        if (red < 0) {
            red = 0;
        } else if (red > 255) {
            red = 255;
        }
        if (green < 0) {
            green = 0;
        } else if (green > 255) {
            green = 255;
        }
        if (blue < 0) {
            blue = 0;
        } else if (blue > 255) {
            blue = 255;
        }

        Color color = null;
        try {
            color = new Color(red, green, blue);
        } catch (final IllegalArgumentException exp) {
            final NumberFormat nf = NumberFormat.getNumberInstance();
            System.out.println(nf.format(red) + "; " + nf.format(green) + "; " + nf.format(blue));
            exp.printStackTrace();
        }
        return color;
    }
}
