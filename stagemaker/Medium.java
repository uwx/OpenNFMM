package stagemaker;

/* Medium - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
public class Medium
{
    int focus_point = 400;
    int ground = 250;
    int skyline = -300;
    int[] fade = { 3000, 4500, 6000, 7500, 9000, 10500, 12000, 13500, 15000, 16500, 18000, 19500, 21000, 22500, 24000, 25500 };
    int[] cldd = { 210, 210, 210, 1, -1000 };
    int[] clds = { 210, 210, 210 };
    int[] osky = { 170, 220, 255 };
    int[] csky = { 170, 220, 255 };
    int[] ogrnd = { 205, 200, 200 };
    int[] cgrnd = { 205, 200, 200 };
    int[] texture = { 0, 0, 0, 50 };
    int[] cpol = { 215, 210, 210 };
    int[] crgrnd = { 205, 200, 200 };
    int[] cfade = { 255, 220, 220 };
    int[] snap = { 0, 0, 0 };
    int fogd = 7;
    int mgen = (int) (Math.random() * 100000.0);
    boolean loadnew = false;
    boolean lightson = false;
    boolean darksky = false;
    int lightn = -1;
    int lilo = 217;
    boolean lton = false;
    int noelec = 0;
    int trk = 0;
    boolean crs = false;
    int cx = 400;
    int cy = 225;
    int cz = 50;
    int xz = 0;
    int zy = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    int iw = 0;
    int ih = 0;
    int w = 800;
    int h = 450;
    int nsp = 0;
    int[] spx = new int[7];
    int[] spz = new int[7];
    int[] sprad = new int[7];
    boolean td = false;
    int bcxz = 0;
    boolean bt = false;
    int vxz = 180;
    int adv = 500;
    boolean vert = false;
    float[] tcos = new float[360];
    float[] tsin = new float[360];
    int lastmaf = 0;
    int checkpoint = -1;
    boolean lastcheck = false;
    float elecr = 0.0F;
    boolean cpflik = false;
    boolean nochekflk = false;
    int cntrn = 0;
    boolean[] diup = { false, false, false };
    int[] rand = { 0, 0, 0 };
    int trn = 0;
    int hit = 45000;
    int ptr = 0;
    int ptcnt = -10;
    int nrnd = 0;
    long trx = 0L;
    long trz = 0L;
    long atrx = 0L;
    long atrz = 0L;
    int fallen = 0;
    float fo = 1.0F;
    float gofo = (float) (0.33000001311302185 + Math.random() * 1.34);
    int fvect = 200;
    int[][] ogpx = null;
    int[][] ogpz = null;
    float[][] pvr = null;
    int[] cgpx = null;
    int[] cgpz = null;
    int[] pmx = null;
    float[] pcv = null;
    int sgpx = 0;
    int sgpz = 0;
    int nrw = 0;
    int ncl = 0;
    int noc = 0;
    int[] clx = null;
    int[] clz = null;
    int[] cmx = null;
    int[][][] clax = null;
    int[][][] clay = null;
    int[][][] claz = null;
    int[][][][] clc = null;
    int nmt = 0;
    int[] mrd = null;
    int[] nmv = null;
    int[][] mtx = null;
    int[][] mty = null;
    int[][] mtz = null;
    int[][][] mtc = null;
    int nst = 0;
    int[] stx = null;
    int[] stz = null;
    int[][][] stc = null;
    boolean[] bst = null;
    int[] twn = null;
    int resdown = 0;
    int rescnt = 0;
    boolean resi = false;
    
    public Medium() {
        for (int i = 0; i < 360; i++)
            this.tcos[i] = (float) Math.cos((double) i * 0.017453292519943295);
        for (int i = 0; i < 360; i++)
            this.tsin[i] = (float) Math.sin((double) i * 0.017453292519943295);
    }
    
    public float random() {
        if (this.cntrn == 0) {
            for (int i = 0; i < 3; i++) {
                this.rand[i] = (int) (10.0 * Math.random());
                if (Math.random() > Math.random())
                    this.diup[i] = false;
                else
                    this.diup[i] = true;
            }
            this.cntrn = 20;
        } else
            this.cntrn--;
        for (int i = 0; i < 3; i++) {
            if (this.diup[i]) {
                this.rand[i]++;
                if (this.rand[i] == 10)
                    this.rand[i] = 0;
            } else {
                this.rand[i]--;
                if (this.rand[i] == -1)
                    this.rand[i] = 9;
            }
        }
        this.trn++;
        if (this.trn == 3)
            this.trn = 0;
        return (float) this.rand[this.trn] / 10.0F;
    }
    
    public void watch(ContO conto, int i) {
        if (this.td) {
            this.y = (int) ((float) ((conto).y - 300) - 1100.0F * random());
            this.x = (conto).x + (int) ((float) ((conto).x + 400 - (conto).x) * cos(i) - (float) ((conto).z + 5000 - (conto).z) * sin(i));
            this.z = (conto).z + (int) ((float) ((conto).x + 400 - (conto).x) * sin(i) + (float) ((conto).z + 5000 - (conto).z) * cos(i));
            this.td = false;
        }
        int i_0_ = 0;
        if ((conto).x - this.x - this.cx > 0)
            i_0_ = 180;
        int i_1_ = -(int) ((double) (90 + i_0_) + Math.atan((double) ((conto).z - this.z) / (double) ((conto).x - this.x - this.cx)) / 0.017453292519943295);
        i_0_ = 0;
        if ((conto).y - this.y - this.cy < 0)
            i_0_ = -180;
        int i_2_ = (int) Math.sqrt((double) (((conto).z - this.z) * ((conto).z - this.z) + ((conto).x - this.x - this.cx) * ((conto).x - this.x - this.cx)));
        int i_3_ = (int) ((double) (90 + i_0_) - Math.atan((double) i_2_ / (double) ((conto).y - this.y - this.cy)) / 0.017453292519943295);
        for (/**/; i_1_ < 0; i_1_ += 360) {
            /* empty */
        }
        for (/**/; i_1_ > 360; i_1_ -= 360) {
            /* empty */
        }
        this.xz = i_1_;
        this.zy += (i_3_ - this.zy) / 5;
        if ((int) Math.sqrt((double) (((conto).z - this.z) * ((conto).z - this.z) + ((conto).x - this.x - this.cx) * ((conto).x - this.x - this.cx) + ((conto).y - this.y - this.cy) * ((conto).y - this.y - this.cy))) > 6000)
            this.td = true;
    }
    
    public void aroundtrack(CheckPoints checkpoints) {
        this.y = -this.hit;
        this.x = this.cx + (int) this.trx + (int) (17000.0F * cos(this.vxz));
        this.z = (int) this.trz + (int) (17000.0F * sin(this.vxz));
        if (this.hit > 5000) {
            if (this.hit == 45000) {
                this.fo = 1.0F;
                this.zy = 67;
                this.atrx = ((long) (checkpoints).x[0] - this.trx) / 116L;
                this.atrz = ((long) (checkpoints).z[0] - this.trz) / 116L;
                this.focus_point = 400;
            }
            this.hit -= this.fallen;
            this.fallen += 7;
            this.trx += this.atrx;
            this.trz += this.atrz;
            if (this.hit < 17600)
                this.zy -= 2;
            if (this.fallen > 500)
                this.fallen = 500;
            if (this.hit <= 5000) {
                this.hit = 5000;
                this.fallen = 0;
            }
            this.vxz += 3;
        } else {
            this.focus_point = (int) (400.0F * this.fo);
            if ((double) Math.abs(this.fo - this.gofo) > 0.005) {
                if (this.fo < this.gofo)
                    this.fo += 0.005F;
                else
                    this.fo -= 0.005F;
            } else
                this.gofo = (float) (0.3499999940395355 + Math.random() * 1.3);
            this.vxz++;
            this.trx -= (this.trx - (long) (checkpoints).x[this.ptr]) / 10L;
            this.trz -= (this.trz - (long) (checkpoints).z[this.ptr]) / 10L;
            if (this.ptcnt == 7) {
                this.ptr++;
                if (this.ptr == (checkpoints).n) {
                    this.ptr = 0;
                    this.nrnd++;
                }
                this.ptcnt = 0;
            } else
                this.ptcnt++;
        }
        if (this.vxz > 360)
            this.vxz -= 360;
        this.xz = -this.vxz - 90;
        boolean bool = false;
        if (-this.y - this.cy < 0) {
            int i = -180;
        }
        int i = (int) Math.sqrt((double) ((this.trz - (long) this.z + (long) this.cz) * (this.trz - (long) this.z + (long) this.cz) + (this.trx - (long) this.x - (long) this.cx) * (this.trx - (long) this.x - (long) this.cx)));
        if (this.cpflik)
            this.cpflik = false;
        else
            this.cpflik = true;
    }
    
    public void around(ContO conto, boolean bool) {
        if (!bool) {
            if (!this.vert)
                this.adv += 2;
            else
                this.adv -= 2;
            if (this.adv > 900)
                this.vert = true;
            if (this.adv < -500)
                this.vert = false;
        } else {
            this.adv -= 14;
            if (this.adv < 617)
                this.adv = 617;
        }
        int i = 500 + this.adv;
        if (bool && i < 1300)
            i = 1300;
        if (i < 1000)
            i = 1000;
        this.y = (conto).y - this.adv;
        if (this.y > 10)
            this.vert = false;
        this.x = (conto).x + (int) ((float) ((conto).x - i - (conto).x) * cos(this.vxz));
        this.z = (conto).z + (int) ((float) ((conto).x - i - (conto).x) * sin(this.vxz));
        if (!bool)
            this.vxz += 2;
        else
            this.vxz += 4;
        int i_4_ = 0;
        int i_5_ = this.y;
        if (i_5_ > 0)
            i_5_ = 0;
        if ((conto).y - i_5_ - this.cy < 0)
            i_4_ = -180;
        int i_6_ = (int) Math.sqrt((double) (((conto).z - this.z + this.cz) * ((conto).z - this.z + this.cz) + ((conto).x - this.x - this.cx) * ((conto).x - this.x - this.cx)));
        int i_7_ = (int) ((double) (90 + i_4_) - Math.atan((double) i_6_ / (double) ((conto).y - i_5_ - this.cy)) / 0.017453292519943295);
        this.xz = -this.vxz + 90;
        if (bool)
            i_7_ -= 15;
        this.zy += (i_7_ - this.zy) / 10;
    }
    
    public void getaround(ContO conto) {
        if (!this.vert)
            this.adv += 2;
        else
            this.adv -= 2;
        if (this.adv > 1700)
            this.vert = true;
        if (this.adv < -500)
            this.vert = false;
        if ((conto).y - this.adv > 10)
            this.vert = false;
        int i = 500 + this.adv;
        if (i < 1000)
            i = 1000;
        int i_8_ = (conto).y - this.adv;
        int i_9_ = (conto).x + (int) ((float) ((conto).x - i - (conto).x) * cos(this.vxz));
        int i_10_ = (conto).z + (int) ((float) ((conto).x - i - (conto).x) * sin(this.vxz));
        int i_11_ = 0;
        if (Math.abs(i_8_ - this.y) > this.fvect) {
            if (this.y < i_8_)
                this.y += this.fvect;
            else
                this.y -= this.fvect;
        } else {
            this.y = i_8_;
            i_11_++;
        }
        if (Math.abs(i_9_ - this.x) > this.fvect) {
            if (this.x < i_9_)
                this.x += this.fvect;
            else
                this.x -= this.fvect;
        } else {
            this.x = i_9_;
            i_11_++;
        }
        if (Math.abs(i_10_ - this.z) > this.fvect) {
            if (this.z < i_10_)
                this.z += this.fvect;
            else
                this.z -= this.fvect;
        } else {
            this.z = i_10_;
            i_11_++;
        }
        if (i_11_ == 3)
            this.fvect = 200;
        else
            this.fvect += 2;
        for (this.vxz += 2; this.vxz > 360; this.vxz -= 360) {
            /* empty */
        }
        int i_12_ = -this.vxz + 90;
        int i_13_ = 0;
        if ((conto).x - this.x - this.cx > 0)
            i_13_ = 180;
        int i_14_ = -(int) ((double) (90 + i_13_) + Math.atan((double) ((conto).z - this.z) / (double) ((conto).x - this.x - this.cx)) / 0.017453292519943295);
        int i_15_ = this.y;
        i_13_ = 0;
        if (i_15_ > 0)
            i_15_ = 0;
        if ((conto).y - i_15_ - this.cy < 0)
            i_13_ = -180;
        int i_16_ = (int) Math.sqrt((double) (((conto).z - this.z + this.cz) * ((conto).z - this.z + this.cz) + ((conto).x - this.x - this.cx) * ((conto).x - this.x - this.cx)));
        int i_17_ = 25;
        if (i_16_ != 0)
            i_17_ = (int) ((double) (90 + i_13_) - Math.atan((double) i_16_ / (double) ((conto).y - i_15_ - this.cy)) / 0.017453292519943295);
        for (/**/; i_12_ < 0; i_12_ += 360) {
            /* empty */
        }
        for (/**/; i_12_ > 360; i_12_ -= 360) {
            /* empty */
        }
        for (/**/; i_14_ < 0; i_14_ += 360) {
            /* empty */
        }
        for (/**/; i_14_ > 360; i_14_ -= 360) {
            /* empty */
        }
        if ((Math.abs(i_12_ - i_14_) < 30 || Math.abs(i_12_ - i_14_) > 330) && i_11_ == 3) {
            if (Math.abs(i_12_ - this.xz) > 7 && Math.abs(i_12_ - this.xz) < 353) {
                if (Math.abs(i_12_ - this.xz) > 180) {
                    if (this.xz > i_12_)
                        this.xz += 7;
                    else
                        this.xz -= 7;
                } else if (this.xz < i_12_)
                    this.xz += 7;
                else
                    this.xz -= 7;
            } else
                this.xz = i_12_;
        } else if (Math.abs(i_14_ - this.xz) > 6 && Math.abs(i_14_ - this.xz) < 354) {
            if (Math.abs(i_14_ - this.xz) > 180) {
                if (this.xz > i_14_)
                    this.xz += 3;
                else
                    this.xz -= 3;
            } else if (this.xz < i_14_)
                this.xz += 3;
            else
                this.xz -= 3;
        } else
            this.xz = i_14_;
        this.zy += (i_17_ - this.zy) / 10;
    }
    
    public void transaround(ContO conto, ContO conto_18_, int i) {
        int i_19_ = ((conto).x * (20 - i) + (conto_18_).x * i) / 20;
        int i_20_ = ((conto).y * (20 - i) + (conto_18_).y * i) / 20;
        int i_21_ = ((conto).z * (20 - i) + (conto_18_).z * i) / 20;
        if (!this.vert)
            this.adv += 2;
        else
            this.adv -= 2;
        if (this.adv > 900)
            this.vert = true;
        if (this.adv < -500)
            this.vert = false;
        int i_22_ = 500 + this.adv;
        if (i_22_ < 1000)
            i_22_ = 1000;
        this.y = i_20_ - this.adv;
        if (this.y > 10)
            this.vert = false;
        this.x = i_19_ + (int) ((float) (i_19_ - i_22_ - i_19_) * cos(this.vxz));
        this.z = i_21_ + (int) ((float) (i_19_ - i_22_ - i_19_) * sin(this.vxz));
        this.vxz += 2;
        int i_23_ = 0;
        int i_24_ = this.y;
        if (i_24_ > 0)
            i_24_ = 0;
        if (i_20_ - i_24_ - this.cy < 0)
            i_23_ = -180;
        int i_25_ = (int) Math.sqrt((double) ((i_21_ - this.z + this.cz) * (i_21_ - this.z + this.cz) + (i_19_ - this.x - this.cx) * (i_19_ - this.x - this.cx)));
        int i_26_ = (int) ((double) (90 + i_23_) - Math.atan((double) i_25_ / (double) (i_20_ - i_24_ - this.cy)) / 0.017453292519943295);
        this.xz = -this.vxz + 90;
        this.zy += (i_26_ - this.zy) / 10;
    }
    
    public void follow(ContO conto, int i, int i_27_) {
        this.zy = 10;
        int i_28_ = 2 + Math.abs(this.bcxz) / 4;
        if (i_28_ > 20)
            i_28_ = 20;
        if (i_27_ != 0) {
            if (i_27_ == 1) {
                if (this.bcxz < 180)
                    this.bcxz += i_28_;
                if (this.bcxz > 180)
                    this.bcxz = 180;
            }
            if (i_27_ == -1) {
                if (this.bcxz > -180)
                    this.bcxz -= i_28_;
                if (this.bcxz < -180)
                    this.bcxz = -180;
            }
        } else if (Math.abs(this.bcxz) > i_28_) {
            if (this.bcxz > 0)
                this.bcxz -= i_28_;
            else
                this.bcxz += i_28_;
        } else if (this.bcxz != 0)
            this.bcxz = 0;
        i += this.bcxz;
        this.xz = -i;
        this.x = (conto).x - this.cx + (int) ((float) -((conto).z - 800 - (conto).z) * sin(i));
        this.z = (conto).z - this.cz + (int) ((float) ((conto).z - 800 - (conto).z) * cos(i));
        this.y = (conto).y - 250 - this.cy;
    }
    
    public void getfollow(ContO conto, int i, int i_29_) {
        this.zy = 10;
        int i_30_ = 2 + Math.abs(this.bcxz) / 4;
        if (i_30_ > 20)
            i_30_ = 20;
        if (i_29_ != 0) {
            if (i_29_ == 1) {
                if (this.bcxz < 180)
                    this.bcxz += i_30_;
                if (this.bcxz > 180)
                    this.bcxz = 180;
            }
            if (i_29_ == -1) {
                if (this.bcxz > -180)
                    this.bcxz -= i_30_;
                if (this.bcxz < -180)
                    this.bcxz = -180;
            }
        } else if (Math.abs(this.bcxz) > i_30_) {
            if (this.bcxz > 0)
                this.bcxz -= i_30_;
            else
                this.bcxz += i_30_;
        } else if (this.bcxz != 0)
            this.bcxz = 0;
        i += this.bcxz;
        this.xz = -i;
        int i_31_ = (conto).x - this.cx + (int) ((float) -((conto).z - 800 - (conto).z) * sin(i));
        int i_32_ = (conto).z - this.cz + (int) ((float) ((conto).z - 800 - (conto).z) * cos(i));
        int i_33_ = (conto).y - 250 - this.cy;
        int i_34_ = 0;
        if (Math.abs(i_33_ - this.y) > this.fvect) {
            if (this.y < i_33_)
                this.y += this.fvect;
            else
                this.y -= this.fvect;
        } else {
            this.y = i_33_;
            i_34_++;
        }
        if (Math.abs(i_31_ - this.x) > this.fvect) {
            if (this.x < i_31_)
                this.x += this.fvect;
            else
                this.x -= this.fvect;
        } else {
            this.x = i_31_;
            i_34_++;
        }
        if (Math.abs(i_32_ - this.z) > this.fvect) {
            if (this.z < i_32_)
                this.z += this.fvect;
            else
                this.z -= this.fvect;
        } else {
            this.z = i_32_;
            i_34_++;
        }
        if (i_34_ == 3)
            this.fvect = 200;
        else
            this.fvect += 2;
    }
    
    public void newpolys(int i, int i_35_, int i_36_, int i_37_, Trackers trackers, int i_38_) {
        Random random = new Random((long) ((i_38_ + this.cgrnd[0] + this.cgrnd[1] + this.cgrnd[2]) * 1671));
        this.nrw = i_35_ / 1200 + 9;
        this.ncl = i_37_ / 1200 + 9;
        this.sgpx = i - 4800;
        this.sgpz = i_36_ - 4800;
        this.ogpx = null;
        this.ogpz = null;
        this.pvr = null;
        this.cgpx = null;
        this.cgpz = null;
        this.pmx = null;
        this.pcv = null;
        this.ogpx = new int[this.nrw * this.ncl][8];
        this.ogpz = new int[this.nrw * this.ncl][8];
        this.pvr = new float[this.nrw * this.ncl][8];
        this.cgpx = new int[this.nrw * this.ncl];
        this.cgpz = new int[this.nrw * this.ncl];
        this.pmx = new int[this.nrw * this.ncl];
        this.pcv = new float[this.nrw * this.ncl];
        int i_39_ = 0;
        int i_40_ = 0;
        for (int i_41_ = 0; i_41_ < this.nrw * this.ncl; i_41_++) {
            this.cgpx[i_41_] = this.sgpx + i_39_ * 1200 + (int) (random.nextDouble() * 1000.0 - 500.0);
            this.cgpz[i_41_] = this.sgpz + i_40_ * 1200 + (int) (random.nextDouble() * 1000.0 - 500.0);
            for (int i_42_ = 0; i_42_ < (trackers).nt; i_42_++) {
                if ((trackers).zy[i_42_] == 0 && (trackers).xy[i_42_] == 0) {
                    if ((trackers).radx[i_42_] < (trackers).radz[i_42_] && Math.abs(this.cgpz[i_41_] - (trackers).z[i_42_]) < (trackers).radz[i_42_]) {
                        for (/**/; Math.abs(this.cgpx[i_41_] - (trackers).x[i_42_]) < (trackers).radx[i_42_]; this.cgpx[i_41_] += random.nextDouble() * (double) (trackers).radx[i_42_] * 2.0 - (double) (trackers).radx[i_42_]) {
                            /* empty */
                        }
                    }
                    if ((trackers).radz[i_42_] < (trackers).radx[i_42_] && Math.abs(this.cgpx[i_41_] - (trackers).x[i_42_]) < (trackers).radx[i_42_]) {
                        for (/**/; Math.abs(this.cgpz[i_41_] - (trackers).z[i_42_]) < (trackers).radz[i_42_]; this.cgpz[i_41_] += random.nextDouble() * (double) (trackers).radz[i_42_] * 2.0 - (double) (trackers).radz[i_42_]) {
                            /* empty */
                        }
                    }
                }
            }
            if (++i_39_ == this.nrw) {
                i_39_ = 0;
                i_40_++;
            }
        }
        for (int i_43_ = 0; i_43_ < this.nrw * this.ncl; i_43_++) {
            float f = (float) (0.3 + 1.6 * random.nextDouble());
            this.ogpx[i_43_][0] = 0;
            this.ogpz[i_43_][0] = (int) ((100.0 + random.nextDouble() * 760.0) * (double) f);
            this.ogpx[i_43_][1] = (int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * (double) f);
            this.ogpz[i_43_][1] = this.ogpx[i_43_][1];
            this.ogpx[i_43_][2] = (int) ((100.0 + random.nextDouble() * 760.0) * (double) f);
            this.ogpz[i_43_][2] = 0;
            this.ogpx[i_43_][3] = (int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * (double) f);
            this.ogpz[i_43_][3] = -this.ogpx[i_43_][3];
            this.ogpx[i_43_][4] = 0;
            this.ogpz[i_43_][4] = -(int) ((100.0 + random.nextDouble() * 760.0) * (double) f);
            this.ogpx[i_43_][5] = -(int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * (double) f);
            this.ogpz[i_43_][5] = this.ogpx[i_43_][5];
            this.ogpx[i_43_][6] = -(int) ((100.0 + random.nextDouble() * 760.0) * (double) f);
            this.ogpz[i_43_][6] = 0;
            this.ogpx[i_43_][7] = -(int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * (double) f);
            this.ogpz[i_43_][7] = -this.ogpx[i_43_][7];
            for (int i_44_ = 0; i_44_ < 8; i_44_++) {
                int i_45_ = i_44_ - 1;
                if (i_45_ == -1)
                    i_45_ = 7;
                int i_46_ = i_44_ + 1;
                if (i_46_ == 8)
                    i_46_ = 0;
                this.ogpx[i_43_][i_44_] = ((this.ogpx[i_43_][i_45_] + this.ogpx[i_43_][i_46_]) / 2 + this.ogpx[i_43_][i_44_]) / 2;
                this.ogpz[i_43_][i_44_] = ((this.ogpz[i_43_][i_45_] + this.ogpz[i_43_][i_46_]) / 2 + this.ogpz[i_43_][i_44_]) / 2;
                this.pvr[i_43_][i_44_] = (float) (1.1 + random.nextDouble() * 0.8);
                int i_47_ = (int) Math.sqrt((double) (int) ((float) (this.ogpx[i_43_][i_44_] * this.ogpx[i_43_][i_44_]) * this.pvr[i_43_][i_44_] * this.pvr[i_43_][i_44_] + (float) (this.ogpz[i_43_][i_44_] * this.ogpz[i_43_][i_44_]) * this.pvr[i_43_][i_44_] * this.pvr[i_43_][i_44_]));
                if (i_47_ > this.pmx[i_43_])
                    this.pmx[i_43_] = i_47_;
            }
            this.pcv[i_43_] = (float) (0.97 + random.nextDouble() * 0.03);
            if (this.pcv[i_43_] > 1.0F)
                this.pcv[i_43_] = 1.0F;
            if (random.nextDouble() > random.nextDouble())
                this.pcv[i_43_] = 1.0F;
        }
    }
    
    public void groundpolys(Graphics2D graphics2d) {
        int i = (this.x - this.sgpx) / 1200 - 12;
        if (i < 0)
            i = 0;
        int i_48_ = i + 25;
        if (i_48_ > this.nrw)
            i_48_ = this.nrw;
        if (i_48_ < i)
            i_48_ = i;
        int i_49_ = (this.z - this.sgpz) / 1200 - 12;
        if (i_49_ < 0)
            i_49_ = 0;
        int i_50_ = i_49_ + 25;
        if (i_50_ > this.ncl)
            i_50_ = this.ncl;
        if (i_50_ < i_49_)
            i_50_ = i_49_;
        int[][] is = new int[i_48_ - i][i_50_ - i_49_];
        for (int i_51_ = i; i_51_ < i_48_; i_51_++) {
            for (int i_52_ = i_49_; i_52_ < i_50_; i_52_++) {
                is[i_51_ - i][i_52_ - i_49_] = 0;
                int i_53_ = i_51_ + i_52_ * this.nrw;
                if (this.resdown < 2 || i_53_ % 2 == 0) {
                    int i_54_ = this.cx + (int) ((float) (this.cgpx[i_53_] - this.x - this.cx) * cos(this.xz) - (float) (this.cgpz[i_53_] - this.z - this.cz) * sin(this.xz));
                    int i_55_ = this.cz + (int) ((float) (this.cgpx[i_53_] - this.x - this.cx) * sin(this.xz) + (float) (this.cgpz[i_53_] - this.z - this.cz) * cos(this.xz));
                    int i_56_ = this.cz + (int) ((float) (250 - this.y - this.cy) * sin(this.zy) + (float) (i_55_ - this.cz) * cos(this.zy));
                    if (xs(i_54_ + this.pmx[i_53_], i_56_) > 0 && xs(i_54_ - this.pmx[i_53_], i_56_) < this.w && i_56_ > -this.pmx[i_53_] && i_56_ < this.fade[2]) {
                        is[i_51_ - i][i_52_ - i_49_] = i_56_;
                        int[] is_57_ = new int[8];
                        int[] is_58_ = new int[8];
                        int[] is_59_ = new int[8];
                        for (int i_60_ = 0; i_60_ < 8; i_60_++) {
                            is_57_[i_60_] = (int) ((float) this.ogpx[i_53_][i_60_] * this.pvr[i_53_][i_60_] + (float) this.cgpx[i_53_] - (float) this.x);
                            is_58_[i_60_] = (int) ((float) this.ogpz[i_53_][i_60_] * this.pvr[i_53_][i_60_] + (float) this.cgpz[i_53_] - (float) this.z);
                            is_59_[i_60_] = this.ground;
                        }
                        rot(is_57_, is_58_, this.cx, this.cz, this.xz, 8);
                        rot(is_59_, is_58_, this.cy, this.cz, this.zy, 8);
                        int[] is_61_ = new int[8];
                        int[] is_62_ = new int[8];
                        int i_63_ = 0;
                        int i_64_ = 0;
                        int i_65_ = 0;
                        int i_66_ = 0;
                        boolean bool = true;
                        for (int i_67_ = 0; i_67_ < 8; i_67_++) {
                            is_61_[i_67_] = xs(is_57_[i_67_], is_58_[i_67_]);
                            is_62_[i_67_] = ys(is_59_[i_67_], is_58_[i_67_]);
                            if (is_62_[i_67_] < 0 || is_58_[i_67_] < 10)
                                i_63_++;
                            if (is_62_[i_67_] > this.h || is_58_[i_67_] < 10)
                                i_64_++;
                            if (is_61_[i_67_] < 0 || is_58_[i_67_] < 10)
                                i_65_++;
                            if (is_61_[i_67_] > this.w || is_58_[i_67_] < 10)
                                i_66_++;
                        }
                        if (i_65_ == 8 || i_63_ == 8 || i_64_ == 8 || i_66_ == 8)
                            bool = false;
                        if (bool) {
                            int i_68_ = (int) (((float) this.cpol[0] * this.pcv[i_53_] + (float) this.cgrnd[0]) / 2.0F);
                            int i_69_ = (int) (((float) this.cpol[1] * this.pcv[i_53_] + (float) this.cgrnd[1]) / 2.0F);
                            int i_70_ = (int) (((float) this.cpol[2] * this.pcv[i_53_] + (float) this.cgrnd[2]) / 2.0F);
                            if (i_56_ - this.pmx[i_53_] > this.fade[0]) {
                                i_68_ = (i_68_ * 7 + this.cfade[0]) / 8;
                                i_69_ = (i_69_ * 7 + this.cfade[1]) / 8;
                                i_70_ = (i_70_ * 7 + this.cfade[2]) / 8;
                            }
                            if (i_56_ - this.pmx[i_53_] > this.fade[1]) {
                                i_68_ = (i_68_ * 7 + this.cfade[0]) / 8;
                                i_69_ = (i_69_ * 7 + this.cfade[1]) / 8;
                                i_70_ = (i_70_ * 7 + this.cfade[2]) / 8;
                            }
                            graphics2d.setColor(new Color(i_68_, i_69_, i_70_));
                            graphics2d.fillPolygon(is_61_, is_62_, 8);
                        }
                    }
                }
            }
        }
        for (int i_71_ = i; i_71_ < i_48_; i_71_++) {
            for (int i_72_ = i_49_; i_72_ < i_50_; i_72_++) {
                if (is[i_71_ - i][i_72_ - i_49_] != 0) {
                    int i_73_ = i_71_ + i_72_ * this.nrw;
                    int[] is_74_ = new int[8];
                    int[] is_75_ = new int[8];
                    int[] is_76_ = new int[8];
                    for (int i_77_ = 0; i_77_ < 8; i_77_++) {
                        is_74_[i_77_] = this.ogpx[i_73_][i_77_] + this.cgpx[i_73_] - this.x;
                        is_75_[i_77_] = this.ogpz[i_73_][i_77_] + this.cgpz[i_73_] - this.z;
                        is_76_[i_77_] = this.ground;
                    }
                    rot(is_74_, is_75_, this.cx, this.cz, this.xz, 8);
                    rot(is_76_, is_75_, this.cy, this.cz, this.zy, 8);
                    int[] is_78_ = new int[8];
                    int[] is_79_ = new int[8];
                    int i_80_ = 0;
                    int i_81_ = 0;
                    int i_82_ = 0;
                    int i_83_ = 0;
                    boolean bool = true;
                    for (int i_84_ = 0; i_84_ < 8; i_84_++) {
                        is_78_[i_84_] = xs(is_74_[i_84_], is_75_[i_84_]);
                        is_79_[i_84_] = ys(is_76_[i_84_], is_75_[i_84_]);
                        if (is_79_[i_84_] < 0 || is_75_[i_84_] < 10)
                            i_80_++;
                        if (is_79_[i_84_] > this.h || is_75_[i_84_] < 10)
                            i_81_++;
                        if (is_78_[i_84_] < 0 || is_75_[i_84_] < 10)
                            i_82_++;
                        if (is_78_[i_84_] > this.w || is_75_[i_84_] < 10)
                            i_83_++;
                    }
                    if (i_82_ == 8 || i_80_ == 8 || i_81_ == 8 || i_83_ == 8)
                        bool = false;
                    if (bool) {
                        int i_85_ = (int) ((float) this.cpol[0] * this.pcv[i_73_]);
                        int i_86_ = (int) ((float) this.cpol[1] * this.pcv[i_73_]);
                        int i_87_ = (int) ((float) this.cpol[2] * this.pcv[i_73_]);
                        if (is[i_71_ - i][i_72_ - i_49_] - this.pmx[i_73_] > this.fade[0]) {
                            i_85_ = (i_85_ * 7 + this.cfade[0]) / 8;
                            i_86_ = (i_86_ * 7 + this.cfade[1]) / 8;
                            i_87_ = (i_87_ * 7 + this.cfade[2]) / 8;
                        }
                        if (is[i_71_ - i][i_72_ - i_49_] - this.pmx[i_73_] > this.fade[1]) {
                            i_85_ = (i_85_ * 7 + this.cfade[0]) / 8;
                            i_86_ = (i_86_ * 7 + this.cfade[1]) / 8;
                            i_87_ = (i_87_ * 7 + this.cfade[2]) / 8;
                        }
                        graphics2d.setColor(new Color(i_85_, i_86_, i_87_));
                        graphics2d.fillPolygon(is_78_, is_79_, 8);
                    }
                }
            }
        }
    }
    
    public void newclouds(int i, int i_88_, int i_89_, int i_90_) {
        this.clx = null;
        this.clz = null;
        this.cmx = null;
        this.clax = null;
        this.clay = null;
        this.claz = null;
        this.clc = null;
        i = i / 20 - 10000;
        i_88_ = i_88_ / 20 + 10000;
        i_89_ = i_89_ / 20 - 10000;
        i_90_ = i_90_ / 20 + 10000;
        this.noc = (i_88_ - i) * (i_90_ - i_89_) / 16666667;
        this.clx = new int[this.noc];
        this.clz = new int[this.noc];
        this.cmx = new int[this.noc];
        this.clax = new int[this.noc][3][12];
        this.clay = new int[this.noc][3][12];
        this.claz = new int[this.noc][3][12];
        this.clc = new int[this.noc][2][6][3];
        for (int i_91_ = 0; i_91_ < this.noc; i_91_++) {
            this.clx[i_91_] = (int) ((double) i + (double) (i_88_ - i) * Math.random());
            this.clz[i_91_] = (int) ((double) i_89_ + (double) (i_90_ - i_89_) * Math.random());
            float f = (float) (0.25 + Math.random() * 1.25);
            float f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][0] = (int) ((double) f_92_ * 0.3826);
            this.claz[i_91_][0][0] = (int) ((double) f_92_ * 0.9238);
            this.clay[i_91_][0][0] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][1] = (int) ((double) f_92_ * 0.7071);
            this.claz[i_91_][0][1] = (int) ((double) f_92_ * 0.7071);
            this.clay[i_91_][0][1] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][2] = (int) ((double) f_92_ * 0.9238);
            this.claz[i_91_][0][2] = (int) ((double) f_92_ * 0.3826);
            this.clay[i_91_][0][2] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][3] = (int) ((double) f_92_ * 0.9238);
            this.claz[i_91_][0][3] = -(int) ((double) f_92_ * 0.3826);
            this.clay[i_91_][0][3] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][4] = (int) ((double) f_92_ * 0.7071);
            this.claz[i_91_][0][4] = -(int) ((double) f_92_ * 0.7071);
            this.clay[i_91_][0][4] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][5] = (int) ((double) f_92_ * 0.3826);
            this.claz[i_91_][0][5] = -(int) ((double) f_92_ * 0.9238);
            this.clay[i_91_][0][5] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][6] = -(int) ((double) f_92_ * 0.3826);
            this.claz[i_91_][0][6] = -(int) ((double) f_92_ * 0.9238);
            this.clay[i_91_][0][6] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][7] = -(int) ((double) f_92_ * 0.7071);
            this.claz[i_91_][0][7] = -(int) ((double) f_92_ * 0.7071);
            this.clay[i_91_][0][7] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][8] = -(int) ((double) f_92_ * 0.9238);
            this.claz[i_91_][0][8] = -(int) ((double) f_92_ * 0.3826);
            this.clay[i_91_][0][8] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][9] = -(int) ((double) f_92_ * 0.9238);
            this.claz[i_91_][0][9] = (int) ((double) f_92_ * 0.3826);
            this.clay[i_91_][0][9] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][10] = -(int) ((double) f_92_ * 0.7071);
            this.claz[i_91_][0][10] = (int) ((double) f_92_ * 0.7071);
            this.clay[i_91_][0][10] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            f_92_ = (float) ((200.0 + Math.random() * 700.0) * (double) f);
            this.clax[i_91_][0][11] = -(int) ((double) f_92_ * 0.3826);
            this.claz[i_91_][0][11] = (int) ((double) f_92_ * 0.9238);
            this.clay[i_91_][0][11] = (int) ((25.0 - Math.random() * 50.0) * (double) f);
            for (int i_93_ = 0; i_93_ < 12; i_93_++) {
                int i_94_ = i_93_ - 1;
                if (i_94_ == -1)
                    i_94_ = 11;
                int i_95_ = i_93_ + 1;
                if (i_95_ == 12)
                    i_95_ = 0;
                this.clax[i_91_][0][i_93_] = ((this.clax[i_91_][0][i_94_] + this.clax[i_91_][0][i_95_]) / 2 + this.clax[i_91_][0][i_93_]) / 2;
                this.clay[i_91_][0][i_93_] = ((this.clay[i_91_][0][i_94_] + this.clay[i_91_][0][i_95_]) / 2 + this.clay[i_91_][0][i_93_]) / 2;
                this.claz[i_91_][0][i_93_] = ((this.claz[i_91_][0][i_94_] + this.claz[i_91_][0][i_95_]) / 2 + this.claz[i_91_][0][i_93_]) / 2;
            }
            for (int i_96_ = 0; i_96_ < 12; i_96_++) {
                f_92_ = (float) (1.2 + 0.6 * Math.random());
                this.clax[i_91_][1][i_96_] = (int) ((float) this.clax[i_91_][0][i_96_] * f_92_);
                this.claz[i_91_][1][i_96_] = (int) ((float) this.claz[i_91_][0][i_96_] * f_92_);
                this.clay[i_91_][1][i_96_] = (int) ((double) this.clay[i_91_][0][i_96_] - 100.0 * Math.random());
                f_92_ = (float) (1.1 + 0.3 * Math.random());
                this.clax[i_91_][2][i_96_] = (int) ((float) this.clax[i_91_][1][i_96_] * f_92_);
                this.claz[i_91_][2][i_96_] = (int) ((float) this.claz[i_91_][1][i_96_] * f_92_);
                this.clay[i_91_][2][i_96_] = (int) ((double) this.clay[i_91_][1][i_96_] - 240.0 * Math.random());
            }
            this.cmx[i_91_] = 0;
            for (int i_97_ = 0; i_97_ < 12; i_97_++) {
                int i_98_ = i_97_ - 1;
                if (i_98_ == -1)
                    i_98_ = 11;
                int i_99_ = i_97_ + 1;
                if (i_99_ == 12)
                    i_99_ = 0;
                this.clay[i_91_][1][i_97_] = ((this.clay[i_91_][1][i_98_] + this.clay[i_91_][1][i_99_]) / 2 + this.clay[i_91_][1][i_97_]) / 2;
                this.clay[i_91_][2][i_97_] = ((this.clay[i_91_][2][i_98_] + this.clay[i_91_][2][i_99_]) / 2 + this.clay[i_91_][2][i_97_]) / 2;
                int i_100_ = (int) Math.sqrt((double) (this.clax[i_91_][2][i_97_] * this.clax[i_91_][2][i_97_] + this.claz[i_91_][2][i_97_] * this.claz[i_91_][2][i_97_]));
                if (i_100_ > this.cmx[i_91_])
                    this.cmx[i_91_] = i_100_;
            }
            for (int i_101_ = 0; i_101_ < 6; i_101_++) {
                double d = Math.random();
                double d_102_ = Math.random();
                for (int i_103_ = 0; i_103_ < 3; i_103_++) {
                    f_92_ = (float) this.clds[i_103_] * 1.05F - (float) this.clds[i_103_];
                    this.clc[i_91_][0][i_101_][i_103_] = (int) ((double) this.clds[i_103_] + (double) f_92_ * d);
                    if (this.clc[i_91_][0][i_101_][i_103_] > 255)
                        this.clc[i_91_][0][i_101_][i_103_] = 255;
                    if (this.clc[i_91_][0][i_101_][i_103_] < 0)
                        this.clc[i_91_][0][i_101_][i_103_] = 0;
                    this.clc[i_91_][1][i_101_][i_103_] = (int) ((double) ((float) this.clds[i_103_] * 1.05F) + (double) f_92_ * d_102_);
                    if (this.clc[i_91_][1][i_101_][i_103_] > 255)
                        this.clc[i_91_][1][i_101_][i_103_] = 255;
                    if (this.clc[i_91_][1][i_101_][i_103_] < 0)
                        this.clc[i_91_][1][i_101_][i_103_] = 0;
                }
            }
        }
    }
    
    public void drawclouds(Graphics2D graphics2d) {
        for (int i = 0; i < this.noc; i++) {
            int i_104_ = this.cx + (int) ((float) (this.clx[i] - this.x / 20 - this.cx) * cos(this.xz) - (float) (this.clz[i] - this.z / 20 - this.cz) * sin(this.xz));
            int i_105_ = this.cz + (int) ((float) (this.clx[i] - this.x / 20 - this.cx) * sin(this.xz) + (float) (this.clz[i] - this.z / 20 - this.cz) * cos(this.xz));
            int i_106_ = this.cz + (int) ((float) (this.cldd[4] - this.y / 20 - this.cy) * sin(this.zy) + (float) (i_105_ - this.cz) * cos(this.zy));
            int i_107_ = xs(i_104_ + this.cmx[i], i_106_);
            int i_108_ = xs(i_104_ - this.cmx[i], i_106_);
            if (i_107_ > 0 && i_108_ < this.w && i_106_ > -this.cmx[i] && i_107_ - i_108_ > 20) {
                int[][] is = new int[3][12];
                int[][] is_109_ = new int[3][12];
                int[][] is_110_ = new int[3][12];
                int[] is_111_ = new int[12];
                int[] is_112_ = new int[12];
                boolean bool = false;
                boolean bool_113_ = false;
                boolean bool_114_ = false;
                boolean bool_115_ = false;
                boolean bool_116_ = true;
                boolean bool_117_ = false;
                boolean bool_118_ = false;
                boolean bool_119_ = false;
                for (int i_120_ = 0; i_120_ < 3; i_120_++) {
                    for (int i_121_ = 0; i_121_ < 12; i_121_++) {
                        is[i_120_][i_121_] = this.clax[i][i_120_][i_121_] + this.clx[i] - this.x / 20;
                        is_110_[i_120_][i_121_] = this.claz[i][i_120_][i_121_] + this.clz[i] - this.z / 20;
                        is_109_[i_120_][i_121_] = this.clay[i][i_120_][i_121_] + this.cldd[4] - this.y / 20;
                    }
                    rot(is[i_120_], is_110_[i_120_], this.cx, this.cz, this.xz, 12);
                    rot(is_109_[i_120_], is_110_[i_120_], this.cy, this.cz, this.zy, 12);
                }
                for (int i_122_ = 0; i_122_ < 12; i_122_ += 2) {
                    int i_123_ = 0;
                    int i_124_ = 0;
                    int i_125_ = 0;
                    int i_126_ = 0;
                    bool_116_ = true;
                    int i_127_ = 0;
                    int i_128_ = 0;
                    int i_129_ = 0;
                    for (int i_130_ = 0; i_130_ < 6; i_130_++) {
                        int i_131_ = 0;
                        int i_132_ = 1;
                        if (i_130_ == 0)
                            i_131_ = i_122_;
                        if (i_130_ == 1) {
                            i_131_ = i_122_ + 1;
                            if (i_131_ >= 12)
                                i_131_ -= 12;
                        }
                        if (i_130_ == 2) {
                            i_131_ = i_122_ + 2;
                            if (i_131_ >= 12)
                                i_131_ -= 12;
                        }
                        if (i_130_ == 3) {
                            i_131_ = i_122_ + 2;
                            if (i_131_ >= 12)
                                i_131_ -= 12;
                            i_132_ = 2;
                        }
                        if (i_130_ == 4) {
                            i_131_ = i_122_ + 1;
                            if (i_131_ >= 12)
                                i_131_ -= 12;
                            i_132_ = 2;
                        }
                        if (i_130_ == 5) {
                            i_131_ = i_122_;
                            i_132_ = 2;
                        }
                        is_111_[i_130_] = xs(is[i_132_][i_131_], is_110_[i_132_][i_131_]);
                        is_112_[i_130_] = ys(is_109_[i_132_][i_131_], is_110_[i_132_][i_131_]);
                        i_128_ += is[i_132_][i_131_];
                        i_127_ += is_109_[i_132_][i_131_];
                        i_129_ += is_110_[i_132_][i_131_];
                        if (is_112_[i_130_] < 0 || is_110_[0][i_130_] < 10)
                            i_123_++;
                        if (is_112_[i_130_] > this.h || is_110_[0][i_130_] < 10)
                            i_124_++;
                        if (is_111_[i_130_] < 0 || is_110_[0][i_130_] < 10)
                            i_125_++;
                        if (is_111_[i_130_] > this.w || is_110_[0][i_130_] < 10)
                            i_126_++;
                    }
                    if (i_125_ == 6 || i_123_ == 6 || i_124_ == 6 || i_126_ == 6)
                        bool_116_ = false;
                    if (bool_116_) {
                        i_128_ /= 6;
                        i_127_ /= 6;
                        i_129_ /= 6;
                        int i_133_ = (int) Math.sqrt((double) ((this.cy - i_127_) * (this.cy - i_127_) + (this.cx - i_128_) * (this.cx - i_128_) + i_129_ * i_129_));
                        if (i_133_ < this.fade[7]) {
                            int i_134_ = this.clc[i][1][i_122_ / 2][0];
                            int i_135_ = this.clc[i][1][i_122_ / 2][1];
                            int i_136_ = this.clc[i][1][i_122_ / 2][2];
                            for (int i_137_ = 0; i_137_ < 16; i_137_++) {
                                if (i_133_ > this.fade[i_137_]) {
                                    i_134_ = (i_134_ * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                    i_135_ = (i_135_ * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                    i_136_ = (i_136_ * this.fogd + this.cfade[2]) / (this.fogd + 1);
                                }
                            }
                            graphics2d.setColor(new Color(i_134_, i_135_, i_136_));
                            graphics2d.fillPolygon(is_111_, is_112_, 6);
                        }
                    }
                }
                for (int i_138_ = 0; i_138_ < 12; i_138_ += 2) {
                    int i_139_ = 0;
                    int i_140_ = 0;
                    int i_141_ = 0;
                    int i_142_ = 0;
                    bool_116_ = true;
                    int i_143_ = 0;
                    int i_144_ = 0;
                    int i_145_ = 0;
                    for (int i_146_ = 0; i_146_ < 6; i_146_++) {
                        int i_147_ = 0;
                        int i_148_ = 0;
                        if (i_146_ == 0)
                            i_147_ = i_138_;
                        if (i_146_ == 1) {
                            i_147_ = i_138_ + 1;
                            if (i_147_ >= 12)
                                i_147_ -= 12;
                        }
                        if (i_146_ == 2) {
                            i_147_ = i_138_ + 2;
                            if (i_147_ >= 12)
                                i_147_ -= 12;
                        }
                        if (i_146_ == 3) {
                            i_147_ = i_138_ + 2;
                            if (i_147_ >= 12)
                                i_147_ -= 12;
                            i_148_ = 1;
                        }
                        if (i_146_ == 4) {
                            i_147_ = i_138_ + 1;
                            if (i_147_ >= 12)
                                i_147_ -= 12;
                            i_148_ = 1;
                        }
                        if (i_146_ == 5) {
                            i_147_ = i_138_;
                            i_148_ = 1;
                        }
                        is_111_[i_146_] = xs(is[i_148_][i_147_], is_110_[i_148_][i_147_]);
                        is_112_[i_146_] = ys(is_109_[i_148_][i_147_], is_110_[i_148_][i_147_]);
                        i_144_ += is[i_148_][i_147_];
                        i_143_ += is_109_[i_148_][i_147_];
                        i_145_ += is_110_[i_148_][i_147_];
                        if (is_112_[i_146_] < 0 || is_110_[0][i_146_] < 10)
                            i_139_++;
                        if (is_112_[i_146_] > this.h || is_110_[0][i_146_] < 10)
                            i_140_++;
                        if (is_111_[i_146_] < 0 || is_110_[0][i_146_] < 10)
                            i_141_++;
                        if (is_111_[i_146_] > this.w || is_110_[0][i_146_] < 10)
                            i_142_++;
                    }
                    if (i_141_ == 6 || i_139_ == 6 || i_140_ == 6 || i_142_ == 6)
                        bool_116_ = false;
                    if (bool_116_) {
                        i_144_ /= 6;
                        i_143_ /= 6;
                        i_145_ /= 6;
                        int i_149_ = (int) Math.sqrt((double) ((this.cy - i_143_) * (this.cy - i_143_) + (this.cx - i_144_) * (this.cx - i_144_) + i_145_ * i_145_));
                        if (i_149_ < this.fade[7]) {
                            int i_150_ = this.clc[i][0][i_138_ / 2][0];
                            int i_151_ = this.clc[i][0][i_138_ / 2][1];
                            int i_152_ = this.clc[i][0][i_138_ / 2][2];
                            for (int i_153_ = 0; i_153_ < 16; i_153_++) {
                                if (i_149_ > this.fade[i_153_]) {
                                    i_150_ = (i_150_ * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                    i_151_ = (i_151_ * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                    i_152_ = (i_152_ * this.fogd + this.cfade[2]) / (this.fogd + 1);
                                }
                            }
                            graphics2d.setColor(new Color(i_150_, i_151_, i_152_));
                            graphics2d.fillPolygon(is_111_, is_112_, 6);
                        }
                    }
                }
                int i_154_ = 0;
                int i_155_ = 0;
                int i_156_ = 0;
                int i_157_ = 0;
                bool_116_ = true;
                int i_158_ = 0;
                int i_159_ = 0;
                int i_160_ = 0;
                for (int i_161_ = 0; i_161_ < 12; i_161_++) {
                    is_111_[i_161_] = xs(is[0][i_161_], is_110_[0][i_161_]);
                    is_112_[i_161_] = ys(is_109_[0][i_161_], is_110_[0][i_161_]);
                    i_159_ += is[0][i_161_];
                    i_158_ += is_109_[0][i_161_];
                    i_160_ += is_110_[0][i_161_];
                    if (is_112_[i_161_] < 0 || is_110_[0][i_161_] < 10)
                        i_154_++;
                    if (is_112_[i_161_] > this.h || is_110_[0][i_161_] < 10)
                        i_155_++;
                    if (is_111_[i_161_] < 0 || is_110_[0][i_161_] < 10)
                        i_156_++;
                    if (is_111_[i_161_] > this.w || is_110_[0][i_161_] < 10)
                        i_157_++;
                }
                if (i_156_ == 12 || i_154_ == 12 || i_155_ == 12 || i_157_ == 12)
                    bool_116_ = false;
                if (bool_116_) {
                    i_159_ /= 12;
                    i_158_ /= 12;
                    i_160_ /= 12;
                    int i_162_ = (int) Math.sqrt((double) ((this.cy - i_158_) * (this.cy - i_158_) + (this.cx - i_159_) * (this.cx - i_159_) + i_160_ * i_160_));
                    if (i_162_ < this.fade[7]) {
                        int i_163_ = this.clds[0];
                        int i_164_ = this.clds[1];
                        int i_165_ = this.clds[2];
                        for (int i_166_ = 0; i_166_ < 16; i_166_++) {
                            if (i_162_ > this.fade[i_166_]) {
                                i_163_ = (i_163_ * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                i_164_ = (i_164_ * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                i_165_ = (i_165_ * this.fogd + this.cfade[2]) / (this.fogd + 1);
                            }
                        }
                        graphics2d.setColor(new Color(i_163_, i_164_, i_165_));
                        graphics2d.fillPolygon(is_111_, is_112_, 12);
                    }
                }
            }
        }
    }
    
    public void newmountains(int i, int i_167_, int i_168_, int i_169_) {
        Random random = new Random((long) this.mgen);
        this.nmt = (int) (20.0 + 10.0 * random.nextDouble());
        int i_170_ = (i + i_167_) / 60;
        int i_171_ = (i_168_ + i_169_) / 60;
        int i_172_ = Math.max(i_167_ - i, i_169_ - i_168_) / 60;
        this.mrd = null;
        this.nmv = null;
        this.mtx = null;
        this.mty = null;
        this.mtz = null;
        this.mtc = null;
        this.mrd = new int[this.nmt];
        this.nmv = new int[this.nmt];
        this.mtx = new int[this.nmt][];
        this.mty = new int[this.nmt][];
        this.mtz = new int[this.nmt][];
        this.mtc = new int[this.nmt][][];
        int[] is = new int[this.nmt];
        int[] is_173_ = new int[this.nmt];
        for (int i_174_ = 0; i_174_ < this.nmt; i_174_++) {
            int i_175_ = 85;
            float f = 0.5F;
            float f_176_ = 0.5F;
            is[i_174_] = (int) (10000.0 + random.nextDouble() * 10000.0);
            int i_177_ = (int) (random.nextDouble() * 360.0);
            if (random.nextDouble() > random.nextDouble()) {
                f = (float) (0.2 + random.nextDouble() * 0.35);
                f_176_ = (float) (0.2 + random.nextDouble() * 0.35);
                this.nmv[i_174_] = (int) ((double) f * (24.0 + 16.0 * random.nextDouble()));
                i_175_ = (int) (85.0 + 10.0 * random.nextDouble());
            } else {
                f = (float) (0.3 + random.nextDouble() * 1.1);
                f_176_ = (float) (0.2 + random.nextDouble() * 0.35);
                this.nmv[i_174_] = (int) ((double) f * (12.0 + 8.0 * random.nextDouble()));
                i_175_ = (int) (104.0 - 10.0 * random.nextDouble());
            }
            this.mtx[i_174_] = new int[this.nmv[i_174_] * 2];
            this.mty[i_174_] = new int[this.nmv[i_174_] * 2];
            this.mtz[i_174_] = new int[this.nmv[i_174_] * 2];
            this.mtc[i_174_] = new int[this.nmv[i_174_]][3];
            for (int i_178_ = 0; i_178_ < this.nmv[i_174_]; i_178_++) {
                this.mtx[i_174_][i_178_] = (int) (((double) (i_178_ * 500) + (random.nextDouble() * 800.0 - 400.0) - (double) (250 * (this.nmv[i_174_] - 1))) * (double) f);
                this.mtx[i_174_][i_178_ + this.nmv[i_174_]] = (int) (((double) (i_178_ * 500) + (random.nextDouble() * 800.0 - 400.0) - (double) (250 * (this.nmv[i_174_] - 1))) * (double) f);
                this.mtx[i_174_][this.nmv[i_174_]] = (int) ((double) this.mtx[i_174_][0] - (100.0 + random.nextDouble() * 600.0) * (double) f);
                this.mtx[i_174_][this.nmv[i_174_] * 2 - 1] = (int) ((double) this.mtx[i_174_][this.nmv[i_174_] - 1] + (100.0 + random.nextDouble() * 600.0) * (double) f);
                if (i_178_ == 0 || i_178_ == this.nmv[i_174_] - 1)
                    this.mty[i_174_][i_178_] = (int) ((-400.0 - 1200.0 * random.nextDouble()) * (double) f_176_ + (double) this.ground);
                if (i_178_ == 1 || i_178_ == this.nmv[i_174_] - 2)
                    this.mty[i_174_][i_178_] = (int) ((-1000.0 - 1450.0 * random.nextDouble()) * (double) f_176_ + (double) this.ground);
                if (i_178_ > 1 && i_178_ < this.nmv[i_174_] - 2)
                    this.mty[i_174_][i_178_] = (int) ((-1600.0 - 1700.0 * random.nextDouble()) * (double) f_176_ + (double) this.ground);
                this.mty[i_174_][i_178_ + this.nmv[i_174_]] = this.ground - 70;
                this.mtz[i_174_][i_178_] = i_171_ + i_172_ + is[i_174_];
                this.mtz[i_174_][i_178_ + this.nmv[i_174_]] = i_171_ + i_172_ + is[i_174_];
                float f_179_ = (float) (0.5 + random.nextDouble() * 0.5);
                this.mtc[i_174_][i_178_][0] = (int) (170.0F * f_179_ + 170.0F * f_179_ * ((float) this.snap[0] / 100.0F));
                if (this.mtc[i_174_][i_178_][0] > 255)
                    this.mtc[i_174_][i_178_][0] = 255;
                if (this.mtc[i_174_][i_178_][0] < 0)
                    this.mtc[i_174_][i_178_][0] = 0;
                this.mtc[i_174_][i_178_][1] = (int) ((float) i_175_ * f_179_ + 85.0F * f_179_ * ((float) this.snap[1] / 100.0F));
                if (this.mtc[i_174_][i_178_][1] > 255)
                    this.mtc[i_174_][i_178_][1] = 255;
                if (this.mtc[i_174_][i_178_][1] < 1)
                    this.mtc[i_174_][i_178_][1] = 0;
                this.mtc[i_174_][i_178_][2] = 0;
            }
            for (int i_180_ = 1; i_180_ < this.nmv[i_174_] - 1; i_180_++) {
                int i_181_ = i_180_ - 1;
                int i_182_ = i_180_ + 1;
                this.mty[i_174_][i_180_] = ((this.mty[i_174_][i_181_] + this.mty[i_174_][i_182_]) / 2 + this.mty[i_174_][i_180_]) / 2;
            }
            rot(this.mtx[i_174_], this.mtz[i_174_], i_170_, i_171_, i_177_, this.nmv[i_174_] * 2);
            is_173_[i_174_] = 0;
        }
        for (int i_183_ = 0; i_183_ < this.nmt; i_183_++) {
            for (int i_184_ = i_183_ + 1; i_184_ < this.nmt; i_184_++) {
                if (is[i_183_] < is[i_184_])
                    is_173_[i_183_]++;
                else
                    is_173_[i_184_]++;
            }
            this.mrd[is_173_[i_183_]] = i_183_;
        }
    }
    
    public void drawmountains(Graphics2D graphics2d) {
        for (int i = 0; i < this.nmt; i++) {
            int i_185_ = this.mrd[i];
            int i_186_ = this.cx + (int) ((float) (this.mtx[i_185_][0] - this.x / 30 - this.cx) * cos(this.xz) - (float) (this.mtz[i_185_][0] - this.z / 30 - this.cz) * sin(this.xz));
            int i_187_ = this.cz + (int) ((float) (this.mtx[i_185_][0] - this.x / 30 - this.cx) * sin(this.xz) + (float) (this.mtz[i_185_][0] - this.z / 30 - this.cz) * cos(this.xz));
            int i_188_ = this.cz + (int) ((float) (this.mty[i_185_][0] - this.y / 30 - this.cy) * sin(this.zy) + (float) (i_187_ - this.cz) * cos(this.zy));
            int i_189_ = this.cx + (int) ((float) (this.mtx[i_185_][this.nmv[i_185_] - 1] - this.x / 30 - this.cx) * cos(this.xz) - (float) (this.mtz[i_185_][this.nmv[i_185_] - 1] - this.z / 30 - this.cz) * sin(this.xz));
            int i_190_ = this.cz + (int) ((float) (this.mtx[i_185_][this.nmv[i_185_] - 1] - this.x / 30 - this.cx) * sin(this.xz) + (float) (this.mtz[i_185_][this.nmv[i_185_] - 1] - this.z / 30 - this.cz) * cos(this.xz));
            int i_191_ = this.cz + (int) ((float) (this.mty[i_185_][this.nmv[i_185_] - 1] - this.y / 30 - this.cy) * sin(this.zy) + (float) (i_190_ - this.cz) * cos(this.zy));
            if (xs(i_189_, i_191_) > 0 && xs(i_186_, i_188_) < this.w) {
                int[] is = new int[this.nmv[i_185_] * 2];
                int[] is_192_ = new int[this.nmv[i_185_] * 2];
                int[] is_193_ = new int[this.nmv[i_185_] * 2];
                for (int i_194_ = 0; i_194_ < this.nmv[i_185_] * 2; i_194_++) {
                    is[i_194_] = this.mtx[i_185_][i_194_] - this.x / 30;
                    is_192_[i_194_] = this.mty[i_185_][i_194_] - this.y / 30;
                    is_193_[i_194_] = this.mtz[i_185_][i_194_] - this.z / 30;
                }
                int i_195_ = (int) Math.sqrt((double) (is[this.nmv[i_185_] / 4] * is[this.nmv[i_185_] / 4] + is_193_[this.nmv[i_185_] / 4] * is_193_[this.nmv[i_185_] / 4]));
                rot(is, is_193_, this.cx, this.cz, this.xz, this.nmv[i_185_] * 2);
                rot(is_192_, is_193_, this.cy, this.cz, this.zy, this.nmv[i_185_] * 2);
                int[] is_196_ = new int[4];
                int[] is_197_ = new int[4];
                boolean bool = false;
                boolean bool_198_ = false;
                boolean bool_199_ = false;
                boolean bool_200_ = false;
                boolean bool_201_ = true;
                for (int i_202_ = 0; i_202_ < this.nmv[i_185_] - 1; i_202_++) {
                    int i_203_ = 0;
                    int i_204_ = 0;
                    int i_205_ = 0;
                    int i_206_ = 0;
                    bool_201_ = true;
                    for (int i_207_ = 0; i_207_ < 4; i_207_++) {
                        int i_208_ = i_207_ + i_202_;
                        if (i_207_ == 2)
                            i_208_ = i_202_ + this.nmv[i_185_] + 1;
                        if (i_207_ == 3)
                            i_208_ = i_202_ + this.nmv[i_185_];
                        is_196_[i_207_] = xs(is[i_208_], is_193_[i_208_]);
                        is_197_[i_207_] = ys(is_192_[i_208_], is_193_[i_208_]);
                        if (is_197_[i_207_] < 0 || is_193_[i_208_] < 10)
                            i_203_++;
                        if (is_197_[i_207_] > this.h || is_193_[i_208_] < 10)
                            i_204_++;
                        if (is_196_[i_207_] < 0 || is_193_[i_208_] < 10)
                            i_205_++;
                        if (is_196_[i_207_] > this.w || is_193_[i_208_] < 10)
                            i_206_++;
                    }
                    if (i_205_ == 4 || i_203_ == 4 || i_204_ == 4 || i_206_ == 4)
                        bool_201_ = false;
                    if (bool_201_) {
                        float f = (float) i_195_ / 2500.0F + (8000.0F - (float) this.fade[0]) / 1000.0F - 2.0F - ((float) Math.abs(this.y) - 250.0F) / 5000.0F;
                        if (f > 0.0F && f < 10.0F) {
                            if ((double) f < 3.5)
                                f = 3.5F;
                            int i_209_ = (int) (((float) (this.mtc[i_185_][i_202_][0] + this.cgrnd[0]) + (float) this.csky[0] * f + (float) this.cfade[0] * f) / (2.0F + f * 2.0F));
                            int i_210_ = (int) (((float) (this.mtc[i_185_][i_202_][1] + this.cgrnd[1]) + (float) this.csky[1] * f + (float) this.cfade[1] * f) / (2.0F + f * 2.0F));
                            int i_211_ = (int) (((float) (this.mtc[i_185_][i_202_][2] + this.cgrnd[2]) + (float) this.csky[2] * f + (float) this.cfade[2] * f) / (2.0F + f * 2.0F));
                            graphics2d.setColor(new Color(i_209_, i_210_, i_211_));
                            graphics2d.fillPolygon(is_196_, is_197_, 4);
                        }
                    }
                }
            }
        }
    }
    
    public void newstars() {
        this.stx = null;
        this.stz = null;
        this.stc = null;
        this.bst = null;
        this.twn = null;
        this.nst = 0;
        if (this.lightson) {
            Random random = new Random((long) (Math.random() * 100000.0));
            this.nst = 40;
            this.stx = new int[this.nst];
            this.stz = new int[this.nst];
            this.stc = new int[this.nst][2][3];
            this.bst = new boolean[this.nst];
            this.twn = new int[this.nst];
            for (int i = 0; i < this.nst; i++) {
                this.stx[i] = (int) (2000.0 * random.nextDouble() - 1000.0);
                this.stz[i] = (int) (2000.0 * random.nextDouble() - 1000.0);
                int i_212_ = (int) (3.0 * random.nextDouble());
                if (i_212_ >= 3)
                    i_212_ = 0;
                if (i_212_ <= -1)
                    i_212_ = 2;
                int i_213_ = i_212_ + 1;
                if (random.nextDouble() > random.nextDouble())
                    i_213_ = i_212_ - 1;
                if (i_213_ == 3)
                    i_213_ = 0;
                if (i_213_ == -1)
                    i_213_ = 2;
                for (int i_214_ = 0; i_214_ < 3; i_214_++) {
                    this.stc[i][0][i_214_] = 200;
                    if (i_212_ == i_214_)
                        this.stc[i][0][i_214_] += (int) (55.0 * random.nextDouble());
                    if (i_213_ == i_214_)
                        this.stc[i][0][i_214_] += 55;
                    this.stc[i][0][i_214_] = (this.stc[i][0][i_214_] * 2 + this.csky[i_214_]) / 3;
                    this.stc[i][1][i_214_] = (this.stc[i][0][i_214_] + this.csky[i_214_]) / 2;
                }
                this.twn[i] = (int) (4.0 * random.nextDouble());
                if (random.nextDouble() > 0.8)
                    this.bst[i] = true;
                else
                    this.bst[i] = false;
            }
        }
    }
    
    public void drawstars(Graphics2D graphics2d) {
        for (int i = 0; i < this.nst; i++) {
            int i_215_ = this.cx + (int) ((float) this.stx[i] * cos(this.xz) - (float) this.stz[i] * sin(this.xz));
            int i_216_ = this.cz + (int) ((float) this.stx[i] * sin(this.xz) + (float) this.stz[i] * cos(this.xz));
            int i_217_ = this.cy + (int) (-200.0F * cos(this.zy) - (float) i_216_ * sin(this.zy));
            int i_218_ = this.cz + (int) (-200.0F * sin(this.zy) + (float) i_216_ * cos(this.zy));
            i_215_ = xs(i_215_, i_218_);
            i_217_ = ys(i_217_, i_218_);
            if (i_215_ - 1 > this.iw && i_215_ + 3 < this.w && i_217_ - 1 > this.ih && i_217_ + 3 < this.h) {
                if (this.twn[i] == 0) {
                    int i_219_ = (int) (3.0 * Math.random());
                    if (i_219_ >= 3)
                        i_219_ = 0;
                    if (i_219_ <= -1)
                        i_219_ = 2;
                    int i_220_ = i_219_ + 1;
                    if (Math.random() > Math.random())
                        i_220_ = i_219_ - 1;
                    if (i_220_ == 3)
                        i_220_ = 0;
                    if (i_220_ == -1)
                        i_220_ = 2;
                    for (int i_221_ = 0; i_221_ < 3; i_221_++) {
                        this.stc[i][0][i_221_] = 200;
                        if (i_219_ == i_221_)
                            this.stc[i][0][i_221_] += (int) (55.0 * Math.random());
                        if (i_220_ == i_221_)
                            this.stc[i][0][i_221_] += 55;
                        this.stc[i][0][i_221_] = (this.stc[i][0][i_221_] * 2 + this.csky[i_221_]) / 3;
                        this.stc[i][1][i_221_] = (this.stc[i][0][i_221_] + this.csky[i_221_]) / 2;
                    }
                    this.twn[i] = 3;
                } else
                    this.twn[i]--;
                int i_222_ = 0;
                if (this.bst[i])
                    i_222_ = 1;
                graphics2d.setColor(new Color(this.stc[i][1][0], this.stc[i][1][1], this.stc[i][1][2]));
                graphics2d.fillRect(i_215_ - 1, i_217_, 3 + i_222_, 1 + i_222_);
                graphics2d.fillRect(i_215_, i_217_ - 1, 1 + i_222_, 3 + i_222_);
                graphics2d.setColor(new Color(this.stc[i][0][0], this.stc[i][0][1], this.stc[i][0][2]));
                graphics2d.fillRect(i_215_, i_217_, 1 + i_222_, 1 + i_222_);
            }
        }
    }
    
    public void d(Graphics2D graphics2d) {
        this.nsp = 0;
        if (this.zy > 90)
            this.zy = 90;
        if (this.zy < -90)
            this.zy = -90;
        if (this.xz > 360)
            this.xz -= 360;
        if (this.xz < 0)
            this.xz += 360;
        if (this.y > 0)
            this.y = 0;
        this.ground = 250 - this.y;
        int[] is = new int[4];
        int[] is_223_ = new int[4];
        int i = this.cgrnd[0];
        int i_224_ = this.cgrnd[1];
        int i_225_ = this.cgrnd[2];
        int i_226_ = this.crgrnd[0];
        int i_227_ = this.crgrnd[1];
        int i_228_ = this.crgrnd[2];
        int i_229_ = this.h;
        for (int i_230_ = 0; i_230_ < 16; i_230_++) {
            int i_231_ = this.fade[i_230_];
            int i_232_ = this.ground;
            if (this.zy != 0) {
                i_232_ = this.cy + (int) ((float) (this.ground - this.cy) * cos(this.zy) - (float) (this.fade[i_230_] - this.cz) * sin(this.zy));
                i_231_ = this.cz + (int) ((float) (this.ground - this.cy) * sin(this.zy) + (float) (this.fade[i_230_] - this.cz) * cos(this.zy));
            }
            is[0] = this.iw;
            is_223_[0] = ys(i_232_, i_231_);
            if (is_223_[0] < this.ih)
                is_223_[0] = this.ih;
            if (is_223_[0] > this.h)
                is_223_[0] = this.h;
            is[1] = this.iw;
            is_223_[1] = i_229_;
            is[2] = this.w;
            is_223_[2] = i_229_;
            is[3] = this.w;
            is_223_[3] = is_223_[0];
            i_229_ = is_223_[0];
            if (i_230_ > 0) {
                i_226_ = (i_226_ * 7 + this.cfade[0]) / 8;
                i_227_ = (i_227_ * 7 + this.cfade[1]) / 8;
                i_228_ = (i_228_ * 7 + this.cfade[2]) / 8;
                if (i_230_ < 3) {
                    i = (i * 7 + this.cfade[0]) / 8;
                    i_224_ = (i_224_ * 7 + this.cfade[1]) / 8;
                    i_225_ = (i_225_ * 7 + this.cfade[2]) / 8;
                } else {
                    i = i_226_;
                    i_224_ = i_227_;
                    i_225_ = i_228_;
                }
            }
            if (is_223_[0] < this.h && is_223_[1] > this.ih) {
                graphics2d.setColor(new Color(i, i_224_, i_225_));
                graphics2d.fillPolygon(is, is_223_, 4);
            }
        }
        if (this.lightn != -1 && this.lton) {
            if (this.lightn < 16) {
                if (this.lilo > this.lightn + 217)
                    this.lilo -= 3;
                else
                    this.lightn = (int) (16.0F + 16.0F * random());
            } else if (this.lilo < this.lightn + 217)
                this.lilo += 7;
            else
                this.lightn = (int) (16.0F * random());
            this.csky[0] = (int) ((float) this.lilo + (float) this.lilo * ((float) this.snap[0] / 100.0F));
            if (this.csky[0] > 255)
                this.csky[0] = 255;
            if (this.csky[0] < 0)
                this.csky[0] = 0;
            this.csky[1] = (int) ((float) this.lilo + (float) this.lilo * ((float) this.snap[1] / 100.0F));
            if (this.csky[1] > 255)
                this.csky[1] = 255;
            if (this.csky[1] < 0)
                this.csky[1] = 0;
            this.csky[2] = (int) ((float) this.lilo + (float) this.lilo * ((float) this.snap[2] / 100.0F));
            if (this.csky[2] > 255)
                this.csky[2] = 255;
            if (this.csky[2] < 0)
                this.csky[2] = 0;
        }
        i = this.csky[0];
        i_224_ = this.csky[1];
        i_225_ = this.csky[2];
        int i_233_ = i;
        int i_234_ = i_224_;
        int i_235_ = i_225_;
        int i_236_ = this.cy + (int) ((float) (this.skyline - 700 - this.cy) * cos(this.zy) - (float) (7000 - this.cz) * sin(this.zy));
        int i_237_ = this.cz + (int) ((float) (this.skyline - 700 - this.cy) * sin(this.zy) + (float) (7000 - this.cz) * cos(this.zy));
        i_236_ = ys(i_236_, i_237_);
        int i_238_ = this.ih;
        for (int i_239_ = 0; i_239_ < 16; i_239_++) {
            int i_240_ = this.fade[i_239_];
            int i_241_ = this.skyline;
            if (this.zy != 0) {
                i_241_ = this.cy + (int) ((float) (this.skyline - this.cy) * cos(this.zy) - (float) (this.fade[i_239_] - this.cz) * sin(this.zy));
                i_240_ = this.cz + (int) ((float) (this.skyline - this.cy) * sin(this.zy) + (float) (this.fade[i_239_] - this.cz) * cos(this.zy));
            }
            is[0] = this.iw;
            is_223_[0] = ys(i_241_, i_240_);
            if (is_223_[0] > this.h)
                is_223_[0] = this.h;
            if (is_223_[0] < this.ih)
                is_223_[0] = this.ih;
            is[1] = this.iw;
            is_223_[1] = i_238_;
            is[2] = this.w;
            is_223_[2] = i_238_;
            is[3] = this.w;
            is_223_[3] = is_223_[0];
            i_238_ = is_223_[0];
            if (i_239_ > 0) {
                i = (i * 7 + this.cfade[0]) / 8;
                i_224_ = (i_224_ * 7 + this.cfade[1]) / 8;
                i_225_ = (i_225_ * 7 + this.cfade[2]) / 8;
            }
            if (is_223_[1] < i_236_) {
                i_233_ = i;
                i_234_ = i_224_;
                i_235_ = i_225_;
            }
            if (is_223_[0] > this.ih && is_223_[1] < this.h) {
                graphics2d.setColor(new Color(i, i_224_, i_225_));
                graphics2d.fillPolygon(is, is_223_, 4);
            }
        }
        is[0] = this.iw;
        is_223_[0] = i_238_;
        is[1] = this.iw;
        is_223_[1] = i_229_;
        is[2] = this.w;
        is_223_[2] = i_229_;
        is[3] = this.w;
        is_223_[3] = i_238_;
        if (is_223_[0] < this.h && is_223_[1] > this.ih) {
            float f = ((float) Math.abs(this.y) - 250.0F) / (float) (this.fade[0] * 2);
            if (f < 0.0F)
                f = 0.0F;
            if (f > 1.0F)
                f = 1.0F;
            i = (int) (((float) i * (1.0F - f) + (float) i_226_ * (1.0F + f)) / 2.0F);
            i_224_ = (int) (((float) i_224_ * (1.0F - f) + (float) i_227_ * (1.0F + f)) / 2.0F);
            i_225_ = (int) (((float) i_225_ * (1.0F - f) + (float) i_228_ * (1.0F + f)) / 2.0F);
            graphics2d.setColor(new Color(i, i_224_, i_225_));
            graphics2d.fillPolygon(is, is_223_, 4);
        }
        if (this.resdown != 2) {
            for (int i_242_ = 1; i_242_ < 20; i_242_++) {
                int i_243_ = 7000;
                int i_244_ = this.skyline - 700 - i_242_ * 70;
                if (this.zy != 0 && i_242_ != 19) {
                    i_244_ = this.cy + (int) ((float) (this.skyline - 700 - i_242_ * 70 - this.cy) * cos(this.zy) - (float) (7000 - this.cz) * sin(this.zy));
                    i_243_ = this.cz + (int) ((float) (this.skyline - 700 - i_242_ * 70 - this.cy) * sin(this.zy) + (float) (7000 - this.cz) * cos(this.zy));
                }
                is[0] = this.iw;
                if (i_242_ != 19) {
                    is_223_[0] = ys(i_244_, i_243_);
                    if (is_223_[0] > this.h)
                        is_223_[0] = this.h;
                    if (is_223_[0] < this.ih)
                        is_223_[0] = this.ih;
                } else
                    is_223_[0] = this.ih;
                is[1] = this.iw;
                is_223_[1] = i_236_;
                is[2] = this.w;
                is_223_[2] = i_236_;
                is[3] = this.w;
                is_223_[3] = is_223_[0];
                i_236_ = is_223_[0];
                i_233_ *= 0.991;
                i_234_ *= 0.991;
                i_235_ *= 0.998;
                if (is_223_[1] > this.ih && is_223_[0] < this.h) {
                    graphics2d.setColor(new Color(i_233_, i_234_, i_235_));
                    graphics2d.fillPolygon(is, is_223_, 4);
                }
            }
            if (this.lightson)
                drawstars(graphics2d);
            drawmountains(graphics2d);
            drawclouds(graphics2d);
        }
        groundpolys(graphics2d);
        if (this.noelec != 0)
            this.noelec--;
        if (this.cpflik)
            this.cpflik = false;
        else {
            this.cpflik = true;
            this.elecr = random() * 15.0F - 6.0F;
        }
    }
    
    public void addsp(int i, int i_245_, int i_246_) {
        if (this.nsp != 7) {
            this.spx[this.nsp] = i;
            this.spz[this.nsp] = i_245_;
            this.sprad[this.nsp] = i_246_;
            this.nsp++;
        }
    }
    
    public void setsnap(int i, int i_247_, int i_248_) {
        this.snap[0] = i;
        this.snap[1] = i_247_;
        this.snap[2] = i_248_;
    }
    
    public void setsky(int i, int i_249_, int i_250_) {
        this.osky[0] = i;
        this.osky[1] = i_249_;
        this.osky[2] = i_250_;
        for (int i_251_ = 0; i_251_ < 3; i_251_++) {
            this.clds[i_251_] = (this.osky[i_251_] * this.cldd[3] + this.cldd[i_251_]) / (this.cldd[3] + 1);
            this.clds[i_251_] = (int) ((float) this.clds[i_251_] + (float) this.clds[i_251_] * ((float) this.snap[i_251_] / 100.0F));
            if (this.clds[i_251_] > 255)
                this.clds[i_251_] = 255;
            if (this.clds[i_251_] < 0)
                this.clds[i_251_] = 0;
        }
        this.csky[0] = (int) ((float) i + (float) i * ((float) this.snap[0] / 100.0F));
        if (this.csky[0] > 255)
            this.csky[0] = 255;
        if (this.csky[0] < 0)
            this.csky[0] = 0;
        this.csky[1] = (int) ((float) i_249_ + (float) i_249_ * ((float) this.snap[1] / 100.0F));
        if (this.csky[1] > 255)
            this.csky[1] = 255;
        if (this.csky[1] < 0)
            this.csky[1] = 0;
        this.csky[2] = (int) ((float) i_250_ + (float) i_250_ * ((float) this.snap[2] / 100.0F));
        if (this.csky[2] > 255)
            this.csky[2] = 255;
        if (this.csky[2] < 0)
            this.csky[2] = 0;
        float[] fs = new float[3];
        Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], fs);
        if ((double) fs[2] < 0.6)
            this.darksky = true;
        else
            this.darksky = false;
    }
    
    public void setcloads(int i, int i_252_, int i_253_, int i_254_, int i_255_) {
        if (i_254_ < 0)
            i_254_ = 0;
        if (i_254_ > 10)
            i_254_ = 10;
        if (i_255_ < -1500)
            i_255_ = -1500;
        if (i_255_ > -500)
            i_255_ = -500;
        this.cldd[0] = i;
        this.cldd[1] = i_252_;
        this.cldd[2] = i_253_;
        this.cldd[3] = i_254_;
        this.cldd[4] = i_255_;
        for (int i_256_ = 0; i_256_ < 3; i_256_++) {
            this.clds[i_256_] = (this.osky[i_256_] * this.cldd[3] + this.cldd[i_256_]) / (this.cldd[3] + 1);
            this.clds[i_256_] = (int) ((float) this.clds[i_256_] + (float) this.clds[i_256_] * ((float) this.snap[i_256_] / 100.0F));
            if (this.clds[i_256_] > 255)
                this.clds[i_256_] = 255;
            if (this.clds[i_256_] < 0)
                this.clds[i_256_] = 0;
        }
    }
    
    public void setgrnd(int i, int i_257_, int i_258_) {
        this.ogrnd[0] = i;
        this.ogrnd[1] = i_257_;
        this.ogrnd[2] = i_258_;
        for (int i_259_ = 0; i_259_ < 3; i_259_++) {
            this.cpol[i_259_] = (this.ogrnd[i_259_] * this.texture[3] + this.texture[i_259_]) / (1 + this.texture[3]);
            this.cpol[i_259_] = (int) ((float) this.cpol[i_259_] + (float) this.cpol[i_259_] * ((float) this.snap[i_259_] / 100.0F));
            if (this.cpol[i_259_] > 255)
                this.cpol[i_259_] = 255;
            if (this.cpol[i_259_] < 0)
                this.cpol[i_259_] = 0;
        }
        this.cgrnd[0] = (int) ((float) i + (float) i * ((float) this.snap[0] / 100.0F));
        if (this.cgrnd[0] > 255)
            this.cgrnd[0] = 255;
        if (this.cgrnd[0] < 0)
            this.cgrnd[0] = 0;
        this.cgrnd[1] = (int) ((float) i_257_ + (float) i_257_ * ((float) this.snap[1] / 100.0F));
        if (this.cgrnd[1] > 255)
            this.cgrnd[1] = 255;
        if (this.cgrnd[1] < 0)
            this.cgrnd[1] = 0;
        this.cgrnd[2] = (int) ((float) i_258_ + (float) i_258_ * ((float) this.snap[2] / 100.0F));
        if (this.cgrnd[2] > 255)
            this.cgrnd[2] = 255;
        if (this.cgrnd[2] < 0)
            this.cgrnd[2] = 0;
        for (int i_260_ = 0; i_260_ < 3; i_260_++)
            this.crgrnd[i_260_] = (int) (((double) this.cpol[i_260_] * 0.99 + (double) this.cgrnd[i_260_]) / 2.0);
    }
    
    public void setexture(int i, int i_261_, int i_262_, int i_263_) {
        if (i_263_ < 20)
            i_263_ = 20;
        if (i_263_ > 60)
            i_263_ = 60;
        this.texture[0] = i;
        this.texture[1] = i_261_;
        this.texture[2] = i_262_;
        this.texture[3] = i_263_;
        i = (this.ogrnd[0] * i_263_ + i) / (1 + i_263_);
        i_261_ = (this.ogrnd[1] * i_263_ + i_261_) / (1 + i_263_);
        i_262_ = (this.ogrnd[2] * i_263_ + i_262_) / (1 + i_263_);
        this.cpol[0] = (int) ((float) i + (float) i * ((float) this.snap[0] / 100.0F));
        if (this.cpol[0] > 255)
            this.cpol[0] = 255;
        if (this.cpol[0] < 0)
            this.cpol[0] = 0;
        this.cpol[1] = (int) ((float) i_261_ + (float) i_261_ * ((float) this.snap[1] / 100.0F));
        if (this.cpol[1] > 255)
            this.cpol[1] = 255;
        if (this.cpol[1] < 0)
            this.cpol[1] = 0;
        this.cpol[2] = (int) ((float) i_262_ + (float) i_262_ * ((float) this.snap[2] / 100.0F));
        if (this.cpol[2] > 255)
            this.cpol[2] = 255;
        if (this.cpol[2] < 0)
            this.cpol[2] = 0;
        for (int i_264_ = 0; i_264_ < 3; i_264_++)
            this.crgrnd[i_264_] = (int) (((double) this.cpol[i_264_] * 0.99 + (double) this.cgrnd[i_264_]) / 2.0);
    }
    
    public void setpolys(int i, int i_265_, int i_266_) {
        this.cpol[0] = (int) ((float) i + (float) i * ((float) this.snap[0] / 100.0F));
        if (this.cpol[0] > 255)
            this.cpol[0] = 255;
        if (this.cpol[0] < 0)
            this.cpol[0] = 0;
        this.cpol[1] = (int) ((float) i_265_ + (float) i_265_ * ((float) this.snap[1] / 100.0F));
        if (this.cpol[1] > 255)
            this.cpol[1] = 255;
        if (this.cpol[1] < 0)
            this.cpol[1] = 0;
        this.cpol[2] = (int) ((float) i_266_ + (float) i_266_ * ((float) this.snap[2] / 100.0F));
        if (this.cpol[2] > 255)
            this.cpol[2] = 255;
        if (this.cpol[2] < 0)
            this.cpol[2] = 0;
        for (int i_267_ = 0; i_267_ < 3; i_267_++)
            this.crgrnd[i_267_] = (int) (((double) this.cpol[i_267_] * 0.99 + (double) this.cgrnd[i_267_]) / 2.0);
    }
    
    public void setfade(int i, int i_268_, int i_269_) {
        this.cfade[0] = (int) ((float) i + (float) i * ((float) this.snap[0] / 100.0F));
        if (this.cfade[0] > 255)
            this.cfade[0] = 255;
        if (this.cfade[0] < 0)
            this.cfade[0] = 0;
        this.cfade[1] = (int) ((float) i_268_ + (float) i_268_ * ((float) this.snap[1] / 100.0F));
        if (this.cfade[1] > 255)
            this.cfade[1] = 255;
        if (this.cfade[1] < 0)
            this.cfade[1] = 0;
        this.cfade[2] = (int) ((float) i_269_ + (float) i_269_ * ((float) this.snap[2] / 100.0F));
        if (this.cfade[2] > 255)
            this.cfade[2] = 255;
        if (this.cfade[2] < 0)
            this.cfade[2] = 0;
    }
    
    public void fadfrom(int i) {
        if (i > 8000)
            i = 8000;
        for (int i_270_ = 1; i_270_ < 17; i_270_++)
            this.fade[i_270_ - 1] = i / 2 * (i_270_ + 1);
    }
    
    public void adjstfade(float f, int i) {
        if (this.resdown != 2) {
            if (f == 5.0F) {
                if (this.resdown == 0 && this.rescnt == 0) {
                    this.fade[0] = 3000;
                    fadfrom(this.fade[0]);
                    this.resdown = 1;
                    if (this.resi)
                        this.rescnt = 20;
                    else
                        this.rescnt = 40;
                }
                if (this.resdown == 1 && this.rescnt == 0) {
                    this.resdown = 2;
                    this.resi = true;
                }
                if (i == 0 || this.resdown == 0)
                    this.rescnt--;
            } else if (this.resdown == 0)
                this.rescnt = 5;
            else if (this.resi)
                this.rescnt = 20;
            else
                this.rescnt = 40;
        }
    }
    
    public int xs(int i, int i_271_) {
        if (i_271_ < this.cz)
            i_271_ = this.cz;
        return (i_271_ - this.focus_point) * (this.cx - i) / i_271_ + i;
    }
    
    public int ys(int i, int i_272_) {
        if (i_272_ < 10)
            i_272_ = 10;
        return (i_272_ - this.focus_point) * (this.cy - i) / i_272_ + i;
    }
    
    public float cos(int i) {
        for (/**/; i >= 360; i -= 360) {
            /* empty */
        }
        for (/**/; i < 0; i += 360) {
            /* empty */
        }
        return this.tcos[i];
    }
    
    public float sin(int i) {
        for (/**/; i >= 360; i -= 360) {
            /* empty */
        }
        for (/**/; i < 0; i += 360) {
            /* empty */
        }
        return this.tsin[i];
    }
    
    public void rot(int[] is, int[] is_273_, int i, int i_274_, int i_275_, int i_276_) {
        if (i_275_ != 0) {
            for (int i_277_ = 0; i_277_ < i_276_; i_277_++) {
                int i_278_ = is[i_277_];
                int i_279_ = is_273_[i_277_];
                is[i_277_] = i + (int) ((float) (i_278_ - i) * cos(i_275_) - (float) (i_279_ - i_274_) * sin(i_275_));
                is_273_[i_277_] = i_274_ + (int) ((float) (i_278_ - i) * sin(i_275_) + (float) (i_279_ - i_274_) * cos(i_275_));
            }
        }
    }
}
