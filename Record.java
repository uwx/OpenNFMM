
/* Record - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;

public class Record {
    ContO[][] car = new ContO[6][8];
    int caught = 0;
    int[] checkpoint = new int[300];
    int closefinish = 0;
    int[] cntdest = new int[8];
    int cntf = 50;
    int[] dest = new int[8];
    int[] fix = new int[8];
    boolean hcaught = false;
    int[] hcheckpoint = new int[300];
    int[] hdest = {
            -1, -1, -1, -1, -1, -1, -1, -1
    };
    int[] hfix = {
            -1, -1, -1, -1, -1, -1, -1, -1
    };
    boolean[] hlastcheck = new boolean[300];
    int[][][] hmagx = new int[8][4][7];
    int[][][] hmagy = new int[8][4][7];
    int[][][] hmagz = new int[8][4][7];
    boolean[][] hmtouch = new boolean[8][7];
    float[][] hrcx = new float[8][200];
    float[][] hrcy = new float[8][200];
    float[][] hrcz = new float[8][200];
    int[][] hrspark = new int[8][200];
    int[][][] hrx = new int[8][4][7];
    int[][][] hry = new int[8][4][7];
    int[][][] hrz = new int[8][4][7];
    int[][][] hscx = new int[8][20][30];
    int[][][] hscz = new int[8][20][30];
    float[][][] hsmag = new float[8][20][30];
    int[][] hsprk = new int[8][200];
    int[] hsquash = {
            0, 0, 0, 0, 0, 0, 0, 0
    };
    int[][] hsrx = new int[8][200];
    int[][] hsry = new int[8][200];
    int[][] hsrz = new int[8][200];
    int[][][] hsspark = new int[8][20][30];
    int[][][] hsx = new int[8][20][30];
    int[][][] hsy = new int[8][20][30];
    int[][][] hsz = new int[8][20][30];
    int[][] hwxz = new int[300][8];
    int[][] hwzy = new int[300][8];
    int[][] hx = new int[300][8];
    int[][] hxy = new int[300][8];
    int[][] hxz = new int[300][8];
    int[][] hy = new int[300][8];
    int[][] hz = new int[300][8];
    int[][] hzy = new int[300][8];
    boolean[] lastcheck = new boolean[300];
    int lastfr = 0;
    Medium m;
    int[][][] magx = new int[8][4][7];
    int[][][] magy = new int[8][4][7];
    int[][][] magz = new int[8][4][7];
    boolean[][] mtouch = new boolean[8][7];
    int[] nr = new int[8];
    int[][] nrx = new int[8][4];
    int[][] nry = new int[8][4];
    int[][] nrz = new int[8][4];
    int[][] ns = new int[8][20];
    ContO[] ocar = new ContO[8];
    int powered = 0;
    boolean prepit = true;
    float[][] rcx = new float[8][200];
    float[][] rcy = new float[8][200];
    float[][] rcz = new float[8][200];
    int[][] rspark = new int[8][200];
    int[][][] rx = new int[8][4][7];
    int[][][] ry = new int[8][4][7];
    int[][][] rz = new int[8][4][7];
    int[][][] scx = new int[8][20][30];
    int[][][] scz = new int[8][20][30];
    float[][][] smag = new float[8][20][30];
    int[][] sprk = new int[8][200];
    int[][] squash = new int[6][8];
    int[][] srx = new int[8][200];
    int[][] sry = new int[8][200];
    int[][] srz = new int[8][200];
    int[][][] sspark = new int[8][20][30];
    ContO[] starcar = new ContO[8];
    int[][][] sx = new int[8][20][30];
    int[][][] sy = new int[8][20][30];
    int[][][] sz = new int[8][20][30];
    int wasted = 0;
    int whenwasted = 0;
    int[][] wxz = new int[300][8];
    int[][] wzy = new int[300][8];
    int[][] x = new int[300][8];
    int[][] xy = new int[300][8];
    int[][] xz = new int[300][8];
    int[][] y = new int[300][8];
    int[][] z = new int[300][8];
    int[][] zy = new int[300][8];

    public Record(final Medium medium) {
        m = medium;
        caught = 0;
        cotchinow(0);
    }

    public void chipx(final int i, float f, final ContO conto, final Mad mad) {
        if (Math.abs(f) > 100.0F) {
            if (f > 100.0F) {
                f -= 100.0F;
            }
            if (f < -100.0F) {
                f += 100.0F;
            }
            for (int i_68_ = 0; i_68_ < conto.npl; i_68_++) {
                float f_69_ = 0.0F;
                for (int i_70_ = 0; i_70_ < conto.p[i_68_].n; i_70_++)
                    if (conto.p[i_68_].wz == 0 && py(conto.keyx[i], conto.p[i_68_].ox[i_70_], conto.keyz[i], conto.p[i_68_].oz[i_70_]) < mad.cd.clrad[mad.cn]) {
                        f_69_ = f / 20.0F * m.random();
                    }
                if (f_69_ != 0.0F && Math.abs(f_69_) >= 1.0F) {
                    conto.p[i_68_].chip = 1;
                    conto.p[i_68_].ctmag = f_69_;
                }
            }
        }
    }

    public void chipz(final int i, float f, final ContO conto, final Mad mad) {
        if (Math.abs(f) > 100.0F) {
            if (f > 100.0F) {
                f -= 100.0F;
            }
            if (f < -100.0F) {
                f += 100.0F;
            }
            for (int i_71_ = 0; i_71_ < conto.npl; i_71_++) {
                float f_72_ = 0.0F;
                for (int i_73_ = 0; i_73_ < conto.p[i_71_].n; i_73_++)
                    if (conto.p[i_71_].wz == 0 && py(conto.keyx[i], conto.p[i_71_].ox[i_73_], conto.keyz[i], conto.p[i_71_].oz[i_73_]) < mad.cd.clrad[mad.cn]) {
                        f_72_ = f / 20.0F * m.random();
                    }
                if (f_72_ != 0.0F && Math.abs(f_72_) >= 1.0F) {
                    conto.p[i_71_].chip = 1;
                    conto.p[i_71_].ctmag = f_72_;
                }
            }
        }
    }

    public void cotchinow(final int i) {
        if (caught >= 300) {
            wasted = i;
            for (int i_6_ = 0; i_6_ < 8; i_6_++) {
                starcar[i_6_] = new ContO(car[0][i_6_], 0, 0, 0, 0);
                hsquash[i_6_] = squash[0][i_6_];
                hfix[i_6_] = fix[i_6_];
                hdest[i_6_] = dest[i_6_];
            }
            for (int i_7_ = 0; i_7_ < 300; i_7_++) {
                for (int i_8_ = 0; i_8_ < 8; i_8_++) {
                    hx[i_7_][i_8_] = x[i_7_][i_8_];
                    hy[i_7_][i_8_] = y[i_7_][i_8_];
                    hz[i_7_][i_8_] = z[i_7_][i_8_];
                    hxy[i_7_][i_8_] = xy[i_7_][i_8_];
                    hzy[i_7_][i_8_] = zy[i_7_][i_8_];
                    hxz[i_7_][i_8_] = xz[i_7_][i_8_];
                    hwxz[i_7_][i_8_] = wxz[i_7_][i_8_];
                    hwzy[i_7_][i_8_] = wzy[i_7_][i_8_];
                }
                hcheckpoint[i_7_] = checkpoint[i_7_];
                hlastcheck[i_7_] = lastcheck[i_7_];
            }
            for (int i_9_ = 0; i_9_ < 8; i_9_++) {
                for (int i_10_ = 0; i_10_ < 20; i_10_++) {
                    for (int i_11_ = 0; i_11_ < 30; i_11_++) {
                        hsspark[i_9_][i_10_][i_11_] = sspark[i_9_][i_10_][i_11_];
                        hsx[i_9_][i_10_][i_11_] = sx[i_9_][i_10_][i_11_];
                        hsy[i_9_][i_10_][i_11_] = sy[i_9_][i_10_][i_11_];
                        hsz[i_9_][i_10_][i_11_] = sz[i_9_][i_10_][i_11_];
                        hsmag[i_9_][i_10_][i_11_] = smag[i_9_][i_10_][i_11_];
                        hscx[i_9_][i_10_][i_11_] = scx[i_9_][i_10_][i_11_];
                        hscz[i_9_][i_10_][i_11_] = scz[i_9_][i_10_][i_11_];
                    }
                }
                for (int i_12_ = 0; i_12_ < 200; i_12_++) {
                    hrspark[i_9_][i_12_] = rspark[i_9_][i_12_];
                    hsprk[i_9_][i_12_] = sprk[i_9_][i_12_];
                    hsrx[i_9_][i_12_] = srx[i_9_][i_12_];
                    hsry[i_9_][i_12_] = sry[i_9_][i_12_];
                    hsrz[i_9_][i_12_] = srz[i_9_][i_12_];
                    hrcx[i_9_][i_12_] = rcx[i_9_][i_12_];
                    hrcy[i_9_][i_12_] = rcy[i_9_][i_12_];
                    hrcz[i_9_][i_12_] = rcz[i_9_][i_12_];
                }
            }
            for (int i_13_ = 0; i_13_ < 8; i_13_++) {
                for (int i_14_ = 0; i_14_ < 4; i_14_++) {
                    for (int i_15_ = 0; i_15_ < 7; i_15_++) {
                        hry[i_13_][i_14_][i_15_] = ry[i_13_][i_14_][i_15_];
                        hmagy[i_13_][i_14_][i_15_] = magy[i_13_][i_14_][i_15_];
                        hrx[i_13_][i_14_][i_15_] = rx[i_13_][i_14_][i_15_];
                        hmagx[i_13_][i_14_][i_15_] = magx[i_13_][i_14_][i_15_];
                        hrz[i_13_][i_14_][i_15_] = rz[i_13_][i_14_][i_15_];
                        hmagz[i_13_][i_14_][i_15_] = magz[i_13_][i_14_][i_15_];
                    }
                }
            }
            for (int i_16_ = 0; i_16_ < 8; i_16_++) {
                for (int i_17_ = 0; i_17_ < 7; i_17_++) {
                    hmtouch[i_16_][i_17_] = mtouch[i_16_][i_17_];
                }
            }
            hcaught = true;
        }
    }

    public void play(final ContO conto, final Mad mad, final int i, final int i_30_) {
        conto.x = x[i_30_][i];
        conto.y = y[i_30_][i];
        conto.z = z[i_30_][i];
        conto.zy = zy[i_30_][i];
        conto.xy = xy[i_30_][i];
        conto.xz = xz[i_30_][i];
        conto.wxz = wxz[i_30_][i];
        conto.wzy = wzy[i_30_][i];
        if (i == 0) {
            conto.m.checkpoint = checkpoint[i_30_];
            conto.m.lastcheck = lastcheck[i_30_];
        }
        if (i_30_ == 0) {
            cntdest[i] = 0;
        }
        if (dest[i] == i_30_) {
            cntdest[i] = 7;
        }
        if (i_30_ == 0 && dest[i] < -1) {
            for (int i_31_ = 0; i_31_ < conto.npl; i_31_++)
                if (conto.p[i_31_].wz == 0 || conto.p[i_31_].gr == -17 || conto.p[i_31_].gr == -16) {
                    conto.p[i_31_].embos = 13;
                }
        }
        if (cntdest[i] != 0) {
            for (int i_32_ = 0; i_32_ < conto.npl; i_32_++)
                if (conto.p[i_32_].wz == 0 || conto.p[i_32_].gr == -17 || conto.p[i_32_].gr == -16) {
                    conto.p[i_32_].embos = 1;
                }
            cntdest[i]--;
        }
        for (int i_33_ = 0; i_33_ < 20; i_33_++) {
            for (int i_34_ = 0; i_34_ < 30; i_34_++)
                if (sspark[i][i_33_][i_34_] == i_30_) {
                    conto.stg[i_33_] = 1;
                    conto.sx[i_33_] = sx[i][i_33_][i_34_];
                    conto.sy[i_33_] = sy[i][i_33_][i_34_];
                    conto.sz[i_33_] = sz[i][i_33_][i_34_];
                    conto.osmag[i_33_] = smag[i][i_33_][i_34_];
                    conto.scx[i_33_] = scx[i][i_33_][i_34_];
                    conto.scz[i_33_] = scz[i][i_33_][i_34_];
                }
        }
        for (int i_35_ = 0; i_35_ < 200; i_35_++)
            if (rspark[i][i_35_] == i_30_) {
                conto.sprk = sprk[i][i_35_];
                conto.srx = srx[i][i_35_];
                conto.sry = sry[i][i_35_];
                conto.srz = srz[i][i_35_];
                conto.rcx = rcx[i][i_35_];
                conto.rcy = rcy[i][i_35_];
                conto.rcz = rcz[i][i_35_];
            }
        for (int i_36_ = 0; i_36_ < 4; i_36_++) {
            for (int i_37_ = 0; i_37_ < 7; i_37_++) {
                if (ry[i][i_36_][i_37_] == i_30_) {
                    regy(i_36_, magy[i][i_36_][i_37_], mtouch[i][i_37_], conto, mad);
                }
                if (rx[i][i_36_][i_37_] == i_30_) {
                    regx(i_36_, magx[i][i_36_][i_37_], conto, mad);
                }
                if (rz[i][i_36_][i_37_] == i_30_) {
                    regz(i_36_, magz[i][i_36_][i_37_], conto, mad);
                }
            }
        }
    }

    public void playh(final ContO conto, final Mad mad, final int i, final int i_38_, final int i_39_) {
        conto.x = hx[i_38_][i];
        conto.y = hy[i_38_][i];
        conto.z = hz[i_38_][i];
        conto.zy = hzy[i_38_][i];
        conto.xy = hxy[i_38_][i];
        conto.xz = hxz[i_38_][i];
        conto.wxz = hwxz[i_38_][i];
        conto.wzy = hwzy[i_38_][i];
        if (i == i_39_) {
            conto.m.checkpoint = hcheckpoint[i_38_];
            conto.m.lastcheck = hlastcheck[i_38_];
        }
        if (i_38_ == 0) {
            cntdest[i] = 0;
        }
        if (hdest[i] == i_38_) {
            cntdest[i] = 7;
        }
        if (i_38_ == 0 && hdest[i] < -1) {
            for (int i_40_ = 0; i_40_ < conto.npl; i_40_++)
                if (conto.p[i_40_].wz == 0 || conto.p[i_40_].gr == -17 || conto.p[i_40_].gr == -16) {
                    conto.p[i_40_].embos = 13;
                }
        }
        if (cntdest[i] != 0) {
            for (int i_41_ = 0; i_41_ < conto.npl; i_41_++)
                if (conto.p[i_41_].wz == 0 || conto.p[i_41_].gr == -17 || conto.p[i_41_].gr == -16) {
                    conto.p[i_41_].embos = 1;
                }
            cntdest[i]--;
        }
        for (int i_42_ = 0; i_42_ < 20; i_42_++) {
            for (int i_43_ = 0; i_43_ < 30; i_43_++)
                if (hsspark[i][i_42_][i_43_] == i_38_) {
                    conto.stg[i_42_] = 1;
                    conto.sx[i_42_] = hsx[i][i_42_][i_43_];
                    conto.sy[i_42_] = hsy[i][i_42_][i_43_];
                    conto.sz[i_42_] = hsz[i][i_42_][i_43_];
                    conto.osmag[i_42_] = hsmag[i][i_42_][i_43_];
                    conto.scx[i_42_] = hscx[i][i_42_][i_43_];
                    conto.scz[i_42_] = hscz[i][i_42_][i_43_];
                }
        }
        for (int i_44_ = 0; i_44_ < 200; i_44_++)
            if (hrspark[i][i_44_] == i_38_) {
                conto.sprk = hsprk[i][i_44_];
                conto.srx = hsrx[i][i_44_];
                conto.sry = hsry[i][i_44_];
                conto.srz = hsrz[i][i_44_];
                conto.rcx = hrcx[i][i_44_];
                conto.rcy = hrcy[i][i_44_];
                conto.rcz = hrcz[i][i_44_];
            }
        for (int i_45_ = 0; i_45_ < 4; i_45_++) {
            for (int i_46_ = 0; i_46_ < 7; i_46_++) {
                if (hry[i][i_45_][i_46_] == i_38_ && lastfr != i_38_) {
                    regy(i_45_, hmagy[i][i_45_][i_46_], hmtouch[i][i_46_], conto, mad);
                }
                if (hrx[i][i_45_][i_46_] == i_38_)
                    if (lastfr != i_38_) {
                        regx(i_45_, hmagx[i][i_45_][i_46_], conto, mad);
                    } else {
                        chipx(i_45_, hmagx[i][i_45_][i_46_], conto, mad);
                    }
                if (hrz[i][i_45_][i_46_] == i_38_)
                    if (lastfr != i_38_) {
                        regz(i_45_, hmagz[i][i_45_][i_46_], conto, mad);
                    } else {
                        chipz(i_45_, hmagz[i][i_45_][i_46_], conto, mad);
                    }
            }
        }
        lastfr = i_38_;
    }

    public int py(final int i, final int i_74_, final int i_75_, final int i_76_) {
        return (i - i_74_) * (i - i_74_) + (i_75_ - i_76_) * (i_75_ - i_76_);
    }

    public void rec(final ContO conto, final int i, final int i_18_, final int i_19_, final int i_20_, final int i_21_) {
        if (i == i_21_) {
            caught++;
        }
        if (cntf == 50) {
            for (int i_22_ = 0; i_22_ < 5; i_22_++) {
                car[i_22_][i] = new ContO(car[i_22_ + 1][i], 0, 0, 0, 0);
                squash[i_22_][i] = squash[i_22_ + 1][i];
            }
            car[5][i] = new ContO(conto, 0, 0, 0, 0);
            squash[5][i] = i_18_;
            cntf = 0;
        } else {
            cntf++;
        }
        fix[i]--;
        if (i_20_ != 0) {
            dest[i]--;
        }
        if (dest[i] == 230)
            if (i == i_21_) {
                cotchinow(i_21_);
                whenwasted = 229;
            } else if (i_19_ != 0) {
                cotchinow(i);
                whenwasted = 165 + i_19_;
            }
        for (int i_23_ = 0; i_23_ < 299; i_23_++) {
            x[i_23_][i] = x[i_23_ + 1][i];
            y[i_23_][i] = y[i_23_ + 1][i];
            z[i_23_][i] = z[i_23_ + 1][i];
            zy[i_23_][i] = zy[i_23_ + 1][i];
            xy[i_23_][i] = xy[i_23_ + 1][i];
            xz[i_23_][i] = xz[i_23_ + 1][i];
            wxz[i_23_][i] = wxz[i_23_ + 1][i];
            wzy[i_23_][i] = wzy[i_23_ + 1][i];
        }
        x[299][i] = conto.x;
        y[299][i] = conto.y;
        z[299][i] = conto.z;
        xy[299][i] = conto.xy;
        zy[299][i] = conto.zy;
        xz[299][i] = conto.xz;
        wxz[299][i] = conto.wxz;
        wzy[299][i] = conto.wzy;
        if (i == i_21_) {
            for (int i_24_ = 0; i_24_ < 299; i_24_++) {
                checkpoint[i_24_] = checkpoint[i_24_ + 1];
                lastcheck[i_24_] = lastcheck[i_24_ + 1];
            }
            checkpoint[299] = conto.m.checkpoint;
            lastcheck[299] = conto.m.lastcheck;
        }
        for (int i_25_ = 0; i_25_ < 20; i_25_++) {
            if (conto.stg != null && conto.stg[i_25_] == 1) {
                sspark[i][i_25_][ns[i][i_25_]] = 300;
                sx[i][i_25_][ns[i][i_25_]] = conto.sx[i_25_];
                sy[i][i_25_][ns[i][i_25_]] = conto.sy[i_25_];
                sz[i][i_25_][ns[i][i_25_]] = conto.sz[i_25_];
                smag[i][i_25_][ns[i][i_25_]] = conto.osmag[i_25_];
                scx[i][i_25_][ns[i][i_25_]] = conto.scx[i_25_];
                scz[i][i_25_][ns[i][i_25_]] = conto.scz[i_25_];
                ns[i][i_25_]++;
                if (ns[i][i_25_] == 30) {
                    ns[i][i_25_] = 0;
                }
            }
            for (int i_26_ = 0; i_26_ < 30; i_26_++) {
                sspark[i][i_25_][i_26_]--;
            }
        }
        if (conto.sprk != 0) {
            rspark[i][nr[i]] = 300;
            sprk[i][nr[i]] = conto.sprk;
            srx[i][nr[i]] = conto.srx;
            sry[i][nr[i]] = conto.sry;
            srz[i][nr[i]] = conto.srz;
            rcx[i][nr[i]] = conto.rcx;
            rcy[i][nr[i]] = conto.rcy;
            rcz[i][nr[i]] = conto.rcz;
            nr[i]++;
            if (nr[i] == 200) {
                nr[i] = 0;
            }
        }
        for (int i_27_ = 0; i_27_ < 200; i_27_++) {
            rspark[i][i_27_]--;
        }
        for (int i_28_ = 0; i_28_ < 4; i_28_++) {
            for (int i_29_ = 0; i_29_ < 7; i_29_++) {
                ry[i][i_28_][i_29_]--;
                rx[i][i_28_][i_29_]--;
                rz[i][i_28_][i_29_]--;
            }
        }
    }

    public void recx(final int i, final float f, final int i_48_) {
        rx[i_48_][i][nry[i_48_][i]] = 300;
        magx[i_48_][i][nry[i_48_][i]] = (int) f;
        nrx[i_48_][i]++;
        if (nrx[i_48_][i] == 7) {
            nrx[i_48_][i] = 0;
        }
    }

    public void recy(final int i, final float f, final boolean bool, final int i_47_) {
        ry[i_47_][i][nry[i_47_][i]] = 300;
        magy[i_47_][i][nry[i_47_][i]] = (int) f;
        mtouch[i_47_][nry[i_47_][i]] = bool;
        nry[i_47_][i]++;
        if (nry[i_47_][i] == 7) {
            nry[i_47_][i] = 0;
        }
    }

    public void recz(final int i, final float f, final int i_49_) {
        rz[i_49_][i][nry[i_49_][i]] = 300;
        magz[i_49_][i][nry[i_49_][i]] = (int) f;
        nrz[i_49_][i]++;
        if (nrz[i_49_][i] == 7) {
            nrz[i_49_][i] = 0;
        }
    }

    public void regx(final int i, float f, final ContO conto, final Mad mad) {
        if (Math.abs(f) > 100.0F) {
            if (f > 100.0F) {
                f -= 100.0F;
            }
            if (f < -100.0F) {
                f += 100.0F;
            }
            for (int i_62_ = 0; i_62_ < conto.npl; i_62_++) {
                float f_63_ = 0.0F;
                for (int i_64_ = 0; i_64_ < conto.p[i_62_].n; i_64_++)
                    if (conto.p[i_62_].wz == 0 && py(conto.keyx[i], conto.p[i_62_].ox[i_64_], conto.keyz[i], conto.p[i_62_].oz[i_64_]) < mad.cd.clrad[mad.cn]) {
                        f_63_ = f / 20.0F * m.random();
                        conto.p[i_62_].oz[i_64_] -= f_63_ * m.sin(conto.xz) * m.cos(conto.zy);
                        conto.p[i_62_].ox[i_64_] += f_63_ * m.cos(conto.xz) * m.cos(conto.xy);
                    }
                if (f_63_ != 0.0F) {
                    if (Math.abs(f_63_) >= 1.0F) {
                        conto.p[i_62_].chip = 1;
                        conto.p[i_62_].ctmag = f_63_;
                    }
                    if (!conto.p[i_62_].nocol && conto.p[i_62_].glass != 1) {
                        if (conto.p[i_62_].bfase > 20 && conto.p[i_62_].hsb[1] > 0.2) {
                            conto.p[i_62_].hsb[1] = 0.2F;
                        }
                        if (conto.p[i_62_].bfase > 30) {
                            if (conto.p[i_62_].hsb[2] < 0.5) {
                                conto.p[i_62_].hsb[2] = 0.5F;
                            }
                            if (conto.p[i_62_].hsb[1] > 0.1) {
                                conto.p[i_62_].hsb[1] = 0.1F;
                            }
                        }
                        if (conto.p[i_62_].bfase > 40) {
                            conto.p[i_62_].hsb[1] = 0.05F;
                        }
                        if (conto.p[i_62_].bfase > 50) {
                            if (conto.p[i_62_].hsb[2] > 0.8) {
                                conto.p[i_62_].hsb[2] = 0.8F;
                            }
                            conto.p[i_62_].hsb[0] = 0.075F;
                            conto.p[i_62_].hsb[1] = 0.05F;
                        }
                        if (conto.p[i_62_].bfase > 60) {
                            conto.p[i_62_].hsb[0] = 0.05F;
                        }
                        conto.p[i_62_].bfase += Math.abs(f_63_);
                        new Color(conto.p[i_62_].c[0], conto.p[i_62_].c[1], conto.p[i_62_].c[2]);
                        final Color color = Color.getHSBColor(conto.p[i_62_].hsb[0], conto.p[i_62_].hsb[1], conto.p[i_62_].hsb[2]);
                        conto.p[i_62_].c[0] = color.getRed();
                        conto.p[i_62_].c[1] = color.getGreen();
                        conto.p[i_62_].c[2] = color.getBlue();
                    }
                    if (conto.p[i_62_].glass == 1) {
                        conto.p[i_62_].gr += Math.abs(f_63_ * 1.5);
                    }
                }
            }
        }
    }

    public void regy(final int i, float f, final boolean bool, final ContO conto, final Mad mad) {
        if (f > 100.0F) {
            f -= 100.0F;
            int i_50_ = 0;
            int i_51_ = 0;
            int i_52_ = conto.zy;
            int i_53_ = conto.xy;
            for (/**/; i_52_ < 360; i_52_ += 360) {
                /* empty */
            }
            for (/**/; i_52_ > 360; i_52_ -= 360) {
                /* empty */
            }
            if (i_52_ < 210 && i_52_ > 150) {
                i_50_ = -1;
            }
            if (i_52_ > 330 || i_52_ < 30) {
                i_50_ = 1;
            }
            for (/**/; i_53_ < 360; i_53_ += 360) {
                /* empty */
            }
            for (/**/; i_53_ > 360; i_53_ -= 360) {
                /* empty */
            }
            if (i_53_ < 210 && i_53_ > 150) {
                i_51_ = -1;
            }
            if (i_53_ > 330 || i_53_ < 30) {
                i_51_ = 1;
            }
            if (i_51_ * i_50_ == 0 || bool) {
                for (int i_54_ = 0; i_54_ < conto.npl; i_54_++) {
                    float f_55_ = 0.0F;
                    for (int i_56_ = 0; i_56_ < conto.p[i_54_].n; i_56_++)
                        if (conto.p[i_54_].wz == 0 && py(conto.keyx[i], conto.p[i_54_].ox[i_56_], conto.keyz[i], conto.p[i_54_].oz[i_56_]) < mad.cd.clrad[mad.cn]) {
                            f_55_ = f / 20.0F * m.random();
                            conto.p[i_54_].oz[i_56_] += f_55_ * m.sin(i_52_);
                            conto.p[i_54_].ox[i_56_] -= f_55_ * m.sin(i_53_);
                        }
                    if (f_55_ != 0.0F) {
                        if (Math.abs(f_55_) >= 1.0F) {
                            conto.p[i_54_].chip = 1;
                            conto.p[i_54_].ctmag = f_55_;
                        }
                        if (!conto.p[i_54_].nocol && conto.p[i_54_].glass != 1) {
                            if (conto.p[i_54_].bfase > 20 && conto.p[i_54_].hsb[1] > 0.2) {
                                conto.p[i_54_].hsb[1] = 0.2F;
                            }
                            if (conto.p[i_54_].bfase > 30) {
                                if (conto.p[i_54_].hsb[2] < 0.5) {
                                    conto.p[i_54_].hsb[2] = 0.5F;
                                }
                                if (conto.p[i_54_].hsb[1] > 0.1) {
                                    conto.p[i_54_].hsb[1] = 0.1F;
                                }
                            }
                            if (conto.p[i_54_].bfase > 40) {
                                conto.p[i_54_].hsb[1] = 0.05F;
                            }
                            if (conto.p[i_54_].bfase > 50) {
                                if (conto.p[i_54_].hsb[2] > 0.8) {
                                    conto.p[i_54_].hsb[2] = 0.8F;
                                }
                                conto.p[i_54_].hsb[0] = 0.075F;
                                conto.p[i_54_].hsb[1] = 0.05F;
                            }
                            if (conto.p[i_54_].bfase > 60) {
                                conto.p[i_54_].hsb[0] = 0.05F;
                            }
                            conto.p[i_54_].bfase += f_55_;
                            new Color(conto.p[i_54_].c[0], conto.p[i_54_].c[1], conto.p[i_54_].c[2]);
                            final Color color = Color.getHSBColor(conto.p[i_54_].hsb[0], conto.p[i_54_].hsb[1], conto.p[i_54_].hsb[2]);
                            conto.p[i_54_].c[0] = color.getRed();
                            conto.p[i_54_].c[1] = color.getGreen();
                            conto.p[i_54_].c[2] = color.getBlue();
                        }
                        if (conto.p[i_54_].glass == 1) {
                            conto.p[i_54_].gr += Math.abs(f_55_ * 1.5);
                        }
                    }
                }
            }
            if (i_51_ * i_50_ == -1) {
                int i_57_ = 0;
                int i_58_ = 1;
                for (int i_59_ = 0; i_59_ < conto.npl; i_59_++) {
                    float f_60_ = 0.0F;
                    for (int i_61_ = 0; i_61_ < conto.p[i_59_].n; i_61_++)
                        if (conto.p[i_59_].wz == 0) {
                            f_60_ = f / 15.0F * m.random();
                            if ((Math.abs(conto.p[i_59_].oy[i_61_] - mad.cd.flipy[mad.cn] - squash[0][mad.im]) < mad.cd.msquash[mad.cn] * 3 || conto.p[i_59_].oy[i_61_] < mad.cd.flipy[mad.cn] + squash[0][mad.im]) && squash[0][mad.im] < mad.cd.msquash[mad.cn]) {
                                conto.p[i_59_].oy[i_61_] += f_60_;
                                i_57_ += f_60_;
                                i_58_++;
                            }
                        }
                    if (conto.p[i_59_].glass == 1) {
                        conto.p[i_59_].gr += 5;
                    } else if (f_60_ != 0.0F) {
                        conto.p[i_59_].bfase += f_60_;
                    }
                    if (Math.abs(f_60_) >= 1.0F) {
                        conto.p[i_59_].chip = 1;
                        conto.p[i_59_].ctmag = f_60_;
                    }
                }
                squash[0][mad.im] += i_57_ / i_58_;
            }
        }
    }

    public void regz(final int i, float f, final ContO conto, final Mad mad) {
        if (Math.abs(f) > 100.0F) {
            if (f > 100.0F) {
                f -= 100.0F;
            }
            if (f < -100.0F) {
                f += 100.0F;
            }
            for (int i_65_ = 0; i_65_ < conto.npl; i_65_++) {
                float f_66_ = 0.0F;
                for (int i_67_ = 0; i_67_ < conto.p[i_65_].n; i_67_++)
                    if (conto.p[i_65_].wz == 0 && py(conto.keyx[i], conto.p[i_65_].ox[i_67_], conto.keyz[i], conto.p[i_65_].oz[i_67_]) < mad.cd.clrad[mad.cn]) {
                        f_66_ = f / 20.0F * m.random();
                        conto.p[i_65_].oz[i_67_] += f_66_ * m.cos(conto.xz) * m.cos(conto.zy);
                        conto.p[i_65_].ox[i_67_] += f_66_ * m.sin(conto.xz) * m.cos(conto.xy);
                    }
                if (f_66_ != 0.0F) {
                    if (Math.abs(f_66_) >= 1.0F) {
                        conto.p[i_65_].chip = 1;
                        conto.p[i_65_].ctmag = f_66_;
                    }
                    if (!conto.p[i_65_].nocol && conto.p[i_65_].glass != 1) {
                        if (conto.p[i_65_].bfase > 20 && conto.p[i_65_].hsb[1] > 0.2) {
                            conto.p[i_65_].hsb[1] = 0.2F;
                        }
                        if (conto.p[i_65_].bfase > 30) {
                            if (conto.p[i_65_].hsb[2] < 0.5) {
                                conto.p[i_65_].hsb[2] = 0.5F;
                            }
                            if (conto.p[i_65_].hsb[1] > 0.1) {
                                conto.p[i_65_].hsb[1] = 0.1F;
                            }
                        }
                        if (conto.p[i_65_].bfase > 40) {
                            conto.p[i_65_].hsb[1] = 0.05F;
                        }
                        if (conto.p[i_65_].bfase > 50) {
                            if (conto.p[i_65_].hsb[2] > 0.8) {
                                conto.p[i_65_].hsb[2] = 0.8F;
                            }
                            conto.p[i_65_].hsb[0] = 0.075F;
                            conto.p[i_65_].hsb[1] = 0.05F;
                        }
                        if (conto.p[i_65_].bfase > 60) {
                            conto.p[i_65_].hsb[0] = 0.05F;
                        }
                        conto.p[i_65_].bfase += Math.abs(f_66_);
                        new Color(conto.p[i_65_].c[0], conto.p[i_65_].c[1], conto.p[i_65_].c[2]);
                        final Color color = Color.getHSBColor(conto.p[i_65_].hsb[0], conto.p[i_65_].hsb[1], conto.p[i_65_].hsb[2]);
                        conto.p[i_65_].c[0] = color.getRed();
                        conto.p[i_65_].c[1] = color.getGreen();
                        conto.p[i_65_].c[2] = color.getBlue();
                    }
                    if (conto.p[i_65_].glass == 1) {
                        conto.p[i_65_].gr += Math.abs(f_66_ * 1.5);
                    }
                }
            }
        }
    }

    public void reset(final ContO[] contos) {
        caught = 0;
        hcaught = false;
        wasted = 0;
        whenwasted = 0;
        closefinish = 0;
        powered = 0;
        for (int i = 0; i < 8; i++) {
            if (prepit) {
                starcar[i] = new ContO(contos[i], 0, 0, 0, 0);
            }
            fix[i] = -1;
            dest[i] = -1;
            cntdest[i] = 0;
        }
        for (int i = 0; i < 6; i++) {
            for (int i_0_ = 0; i_0_ < 8; i_0_++) {
                car[i][i_0_] = new ContO(contos[i_0_], 0, 0, 0, 0);
                squash[i][i_0_] = 0;
            }
        }
        for (int i = 0; i < 8; i++) {
            nr[i] = 0;
            for (int i_1_ = 0; i_1_ < 200; i_1_++) {
                rspark[i][i_1_] = -1;
            }
            for (int i_2_ = 0; i_2_ < 20; i_2_++) {
                ns[i][i_2_] = 0;
                for (int i_3_ = 0; i_3_ < 30; i_3_++) {
                    sspark[i][i_2_][i_3_] = -1;
                }
            }
            for (int i_4_ = 0; i_4_ < 4; i_4_++) {
                nry[i][i_4_] = 0;
                nrx[i][i_4_] = 0;
                nrz[i][i_4_] = 0;
                for (int i_5_ = 0; i_5_ < 7; i_5_++) {
                    ry[i][i_4_][i_5_] = -1;
                    rx[i][i_4_][i_5_] = -1;
                    rz[i][i_4_][i_5_] = -1;
                }
            }
        }
        prepit = false;
    }
}
