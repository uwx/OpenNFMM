package stagemaker;

/* CheckPoints - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
public class CheckPoints
{
    int[] x = new int[10000];
    int[] z = new int[10000];
    int[] y = new int[10000];
    int[] typ = new int[10000];
    int pcs = 0;
    int nsp = 0;
    int n = 0;
    int[] fx = new int[5];
    int[] fz = new int[5];
    int[] fy = new int[5];
    boolean[] roted = new boolean[5];
    boolean[] special = new boolean[5];
    int fn = 0;
    int stage = (int) (Math.random() * 27.0) + 1;
    int nlaps = 0;
    int nfix = 0;
    boolean notb = false;
    String name = "hogan rewish";
    String maker = "";
    int pubt = 0;
    String trackname = "";
    int trackvol = 200;
    int top20 = 0;
    int nto = 0;
    int[] pos = { 6, 6, 6, 6, 6, 6, 6 };
    int[] clear = { 0, 0, 0, 0, 0, 0, 0 };
    int[] dested = { 0, 0, 0, 0, 0, 0, 0 };
    float[] magperc = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    int wasted = 0;
    boolean haltall = false;
    int pcleared = 0;
    int[] opx = new int[7];
    int[] opz = new int[7];
    int[] onscreen = new int[7];
    int[] omxz = new int[7];
    int catchfin = 0;
    int postwo = 0;
    
    public void checkstat(Mad[] mads, ContO[] contos, Record record, int i, int i_0_, int i_1_) {
        if (!this.haltall) {
            this.pcleared = (mads[i_0_]).pcleared;
            for (int i_2_ = 0; i_2_ < i; i_2_++) {
                this.magperc[i_2_] = (float) (mads[i_2_]).hitmag / (float) ((mads[i_2_]).cd).maxmag[(mads[i_2_]).cn];
                if (this.magperc[i_2_] > 1.0F)
                    this.magperc[i_2_] = 1.0F;
                this.pos[i_2_] = 0;
                this.onscreen[i_2_] = (contos[i_2_]).dist;
                this.opx[i_2_] = (contos[i_2_]).x;
                this.opz[i_2_] = (contos[i_2_]).z;
                this.omxz[i_2_] = (mads[i_2_]).mxz;
                if (this.dested[i_2_] == 0)
                    this.clear[i_2_] = (mads[i_2_]).clear;
                else
                    this.clear[i_2_] = -1;
            }
            for (int i_3_ = 0; i_3_ < i; i_3_++) {
                for (int i_4_ = i_3_ + 1; i_4_ < i; i_4_++) {
                    if (this.clear[i_3_] != this.clear[i_4_]) {
                        if (this.clear[i_3_] < this.clear[i_4_])
                            this.pos[i_3_]++;
                        else
                            this.pos[i_4_]++;
                    } else {
                        int i_5_ = (mads[i_3_]).pcleared + 1;
                        if (i_5_ >= this.n)
                            i_5_ = 0;
                        while (this.typ[i_5_] <= 0) {
                            if (++i_5_ >= this.n)
                                i_5_ = 0;
                        }
                        if (py((contos[i_3_]).x / 100, this.x[i_5_] / 100, (contos[i_3_]).z / 100, this.z[i_5_] / 100) > py((contos[i_4_]).x / 100, this.x[i_5_] / 100, (contos[i_4_]).z / 100, this.z[i_5_] / 100))
                            this.pos[i_3_]++;
                        else
                            this.pos[i_4_]++;
                    }
                }
            }
            if (this.stage > 2) {
                for (int i_6_ = 0; i_6_ < i; i_6_++) {
                    if (this.clear[i_6_] == this.nlaps * this.nsp && this.pos[i_6_] == 0) {
                        if (i_6_ == i_0_) {
                            for (int i_7_ = 0; i_7_ < i; i_7_++) {
                                if (this.pos[i_7_] == 1)
                                    this.postwo = i_7_;
                            }
                            if (py(this.opx[i_0_] / 100, this.opx[this.postwo] / 100, this.opz[i_0_] / 100, this.opz[this.postwo] / 100) < 14000 && this.clear[i_0_] - this.clear[this.postwo] == 1)
                                this.catchfin = 30;
                        } else if (this.pos[i_0_] == 1 && py(this.opx[i_0_] / 100, this.opx[i_6_] / 100, this.opz[i_0_] / 100, this.opz[i_6_] / 100) < 14000 && this.clear[i_6_] - this.clear[i_0_] == 1) {
                            this.catchfin = 30;
                            this.postwo = i_6_;
                        }
                    }
                }
            }
        }
        this.wasted = 0;
        for (int i_8_ = 0; i_8_ < i; i_8_++) {
            if ((i_0_ != i_8_ || i_1_ >= 2) && (mads[i_8_]).dest)
                this.wasted++;
        }
        if (this.catchfin != 0 && i_1_ < 2) {
            this.catchfin--;
            if (this.catchfin == 0) {
                record.cotchinow(this.postwo);
                (record).closefinish = this.pos[i_0_] + 1;
            }
        }
    }
    
    public int py(int i, int i_9_, int i_10_, int i_11_) {
        return (i - i_9_) * (i - i_9_) + (i_10_ - i_11_) * (i_10_ - i_11_);
    }
}
