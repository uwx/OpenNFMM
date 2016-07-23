package nfm.open;

/* nfm.open.Trackers - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
class Trackers {
    final int[][] c = new int[95000][3];
    final int[] dam = new int[95000];
    final boolean[] decor = new boolean[95000];
    int ncx = 0;
    int ncz = 0;
    final boolean[] notwall = new boolean[95000];
    int nt = 0;
    final int[] radx = new int[95000];
    final int[] rady = new int[95000];
    final int[] radz = new int[95000];
    int[][][] sect = null;
    final int[] skd = new int[95000];
    int sx = 0;
    int sz = 0;
    final int[] x = new int[95000];
    final int[] xy = new int[95000];
    final int[] y = new int[95000];
    final int[] z = new int[95000];
    final int[] zy = new int[95000];

    public void devidetrackers(final int i, final int i_0_, final int i_1_, final int i_2_) {
        sect = null;
        sx = i;
        sz = i_1_;
        ncx = i_0_ / 3000;
        if (ncx <= 0)
            ncx = 1;
        ncz = i_2_ / 3000;
        if (ncz <= 0)
            ncz = 1;
        sect = new int[ncx][ncz][];
        for (int i_3_ = 0; i_3_ < ncx; i_3_++)
            for (int i_4_ = 0; i_4_ < ncz; i_4_++) {
                final int i_5_ = sx + i_3_ * 3000 + 1500;
                final int i_6_ = sz + i_4_ * 3000 + 1500;
                final int[] is = new int[6700];
                int i_7_ = 0;
                for (int i_8_ = 0; i_8_ < nt; i_8_++) {
                    final int i_9_ = py(i_5_, x[i_8_], i_6_, z[i_8_]);
                    if (i_9_ < 20250000 && i_9_ > 0 && dam[i_8_] != 167) {
                        is[i_7_] = i_8_;
                        i_7_++;
                    }
                }
                if (i_3_ == 0 || i_4_ == 0 || i_3_ == ncx - 1 || i_4_ == ncz - 1)
                    for (int i_10_ = 0; i_10_ < nt; i_10_++)
                        if (dam[i_10_] == 167) {
                            is[i_7_] = i_10_;
                            i_7_++;
                        }
                if (i_7_ == 0) {
                    is[i_7_] = 0;
                    i_7_++;
                }
                sect[i_3_][i_4_] = new int[i_7_];
                System.arraycopy(is, 0, sect[i_3_][i_4_], 0, i_7_);
            }
        for (int i_12_ = 0; i_12_ < nt; i_12_++)
            if (dam[i_12_] == 167)
                dam[i_12_] = 1;
        ncx--;
        ncz--;
    }

    private int py(final int i, final int i_13_, final int i_14_, final int i_15_) {
        return (i - i_13_) * (i - i_13_) + (i_14_ - i_15_) * (i_14_ - i_15_);
    }
}
