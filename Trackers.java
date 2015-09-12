/* Trackers - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
public class Trackers
{
    int[] x = new int[6700000];
    int[] y = new int[6700000];
    int[] z = new int[6700000];
    int[] xy = new int[6700000];
    int[] zy = new int[6700000];
    int[] skd = new int[6700000];
    int[] dam = new int[6700000];
    boolean[] notwall = new boolean[6700000];
    boolean[] decor = new boolean[6700000];
    int[][] c = new int[6700000][3];
    int[] radx = new int[6700000];
    int[] radz = new int[6700000];
    int[] rady = new int[6700000];
    int nt = 0;
    int sx = 0;
    int sz = 0;
    int ncx = 0;
    int ncz = 0;
    int[][][] sect = null;
    
    public void devidetrackers(int i, int i_0_, int i_1_, int i_2_) {
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
        for (int i_3_ = 0; i_3_ < ncx; i_3_++) {
            for (int i_4_ = 0; i_4_ < ncz; i_4_++) {
                int i_5_ = sx + i_3_ * 3000 + 1500;
                int i_6_ = sz + i_4_ * 3000 + 1500;
                int[] is = new int[6700];
                int i_7_ = 0;
                for (int i_8_ = 0; i_8_ < nt; i_8_++) {
                    int i_9_ = py(i_5_, x[i_8_], i_6_, z[i_8_]);
                    if (i_9_ < 20250000 && i_9_ > 0 && dam[i_8_] != 167) {
                        is[i_7_] = i_8_;
                        i_7_++;
                    }
                }
                if (i_3_ == 0 || i_4_ == 0 || i_3_ == ncx - 1 || i_4_ == ncz - 1) {
                    for (int i_10_ = 0; i_10_ < nt; i_10_++) {
                        if (dam[i_10_] == 167) {
                            is[i_7_] = i_10_;
                            i_7_++;
                        }
                    }
                }
                if (i_7_ == 0) {
                    is[i_7_] = 0;
                    i_7_++;
                }
                sect[i_3_][i_4_] = new int[i_7_];
                for (int i_11_ = 0; i_11_ < i_7_; i_11_++)
                    sect[i_3_][i_4_][i_11_] = is[i_11_];
            }
        }
        for (int i_12_ = 0; i_12_ < nt; i_12_++) {
            if (dam[i_12_] == 167)
                dam[i_12_] = 1;
        }
        ncx--;
        ncz--;
    }
    
    public int py(int i, int i_13_, int i_14_, int i_15_) {
        return (i - i_13_) * (i - i_13_) + (i_14_ - i_15_) * (i_14_ - i_15_);
    }
}
