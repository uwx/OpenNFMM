package nfm.open;

import nfm.open.util.MathUtil;

public class SpecialAbilities {
    /**
     * Ability affects nothing when activated.
     */
    public static final byte AFFECT_NONE = 0;
    /**
     * Ability affects the activatee when activated.
     */
    public static final byte AFFECT_SOURCE = 1;
    /**
     * Ability affects the possible target when activated.
     */
    public static final byte AFFECT_TARGET = 2;

    public static interface Ability {
        /**
         * @param sc selected car
         * @param possibleTarget
         * @return {@link #AFFECT_NONE}, {@link #AFFECT_SOURCE} or {@link #AFFECT_TARGET}. Info in their specific javadocs
         */
        byte activate(int sc, int possibleTarget);

        /**
         * @param im id of the affected
         * @param c conto of the affected
         * @return time left, 0 to destroy
         */
        int iterateStatusEffect(int im, ContO c);
    }

    /**
     * Freezes a car when used
     *
     * @author Rafael
     */
    public static class Freeze implements Ability {

        static int[] affectedTimer = new int[8];

        @Override
        public byte activate(final int sc, final int possibleTarget) {
            affectedTimer[possibleTarget] = 35;
            return AFFECT_TARGET;
        }

        @Override
        public int iterateStatusEffect(final int im, final ContO c) {
            GameSparker.mads[im].speed = 0;
            return --affectedTimer[im];
        }
    }

    /**
     * Gives the activatee a speed boost
     *
     * @author Rafael
     */
    public static class Boost implements Ability {

        static int affectedTimer;

        @Override
        public byte activate(final int sc, final int possibleTarget) {
            affectedTimer = 35;
            return AFFECT_SOURCE;
        }

        @Override
        public int iterateStatusEffect(final int im, final ContO c) {
            GameSparker.mads[im].speed += affectedTimer * 1.8F;
            return --affectedTimer;
        }
    }

    /**
     * Blinds a player when used, heavily capping their speed
     *
     * @author Rafael
     */
    public static class Thunderstorm implements Ability {

        static int[] affectedTimer = new int[8];
        static float[] sourceSpeed = new float[8];

        @Override
        public byte activate(final int sc, final int possibleTarget) {
            affectedTimer[possibleTarget] = 35;
            sourceSpeed[possibleTarget] = GameSparker.mads[possibleTarget].speed;
            return AFFECT_TARGET;
        }

        @Override
        public int iterateStatusEffect(final int im, final ContO c) {
            GameSparker.mads[im].speed = MathUtil.lerp(GameSparker.mads[im].speed, sourceSpeed[im], (float) Math.random());
            return --affectedTimer[im];
        }
    }
}
