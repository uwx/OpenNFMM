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
        this.sect = null;
        this.sx = i;
        this.sz = i_1_;
        this.ncx = i_0_ / 3000;
        if (this.ncx <= 0)
            this.ncx = 1;
        this.ncz = i_2_ / 3000;
        if (this.ncz <= 0)
            this.ncz = 1;
        this.sect = new int[this.ncx][this.ncz][];
        for (int i_3_ = 0; i_3_ < this.ncx; i_3_++) {
            for (int i_4_ = 0; i_4_ < this.ncz; i_4_++) {
                int i_5_ = this.sx + i_3_ * 3000 + 1500;
                int i_6_ = this.sz + i_4_ * 3000 + 1500;
                int[] is = new int[6700];
                int i_7_ = 0;
                for (int i_8_ = 0; i_8_ < this.nt; i_8_++) {
                    int i_9_ = py(i_5_, this.x[i_8_], i_6_, this.z[i_8_]);
                    if (i_9_ < 20250000 && i_9_ > 0 && this.dam[i_8_] != 167) {
                        is[i_7_] = i_8_;
                        i_7_++;
                    }
                }
                if (i_3_ == 0 || i_4_ == 0 || i_3_ == this.ncx - 1 || i_4_ == this.ncz - 1) {
                    for (int i_10_ = 0; i_10_ < this.nt; i_10_++) {
                        if (this.dam[i_10_] == 167) {
                            is[i_7_] = i_10_;
                            i_7_++;
                        }
                    }
                }
                if (i_7_ == 0) {
                    is[i_7_] = 0;
                    i_7_++;
                }
                this.sect[i_3_][i_4_] = new int[i_7_];
                for (int i_11_ = 0; i_11_ < i_7_; i_11_++)
                    this.sect[i_3_][i_4_][i_11_] = is[i_11_];
            }
        }
        for (int i_12_ = 0; i_12_ < this.nt; i_12_++) {
            if (this.dam[i_12_] == 167)
                this.dam[i_12_] = 1;
        }
        this.ncx--;
        this.ncz--;
    }
    
    public int py(int i, int i_13_, int i_14_, int i_15_) {
        return (i - i_13_) * (i - i_13_) + (i_14_ - i_15_) * (i_14_ - i_15_);
    }
}
