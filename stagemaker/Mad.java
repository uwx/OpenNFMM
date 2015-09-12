package stagemaker;

/* Mad - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.awt.Color;
public class Mad
{
    Medium m;
    Record rpd;
    xtGraphics xt;
    int cn = 0;
    int im = 0;
    int mxz = 0;
    int cxz = 0;
    CarDefine cd;
    boolean[] dominate = new boolean[7];
    boolean[] caught = new boolean[7];
    int pzy = 0;
    int pxy = 0;
    float speed = 0.0F;
    float forca = 0.0F;
    float[] scy = new float[4];
    float[] scz = new float[4];
    float[] scx = new float[4];
    float drag = 0.5F;
    boolean mtouch = false;
    boolean wtouch = false;
    int cntouch = 0;
    boolean capsized = false;
    int txz = 0;
    int fxz = 0;
    int pmlt = 1;
    int nmlt = 1;
    int dcnt = 0;
    int skid = 0;
    boolean pushed = false;
    boolean gtouch = false;
    boolean pl = false;
    boolean pr = false;
    boolean pd = false;
    boolean pu = false;
    int loop = 0;
    float ucomp = 0.0F;
    float dcomp = 0.0F;
    float lcomp = 0.0F;
    float rcomp = 0.0F;
    int lxz = 0;
    int travxy = 0;
    int travzy = 0;
    int travxz = 0;
    int trcnt = 0;
    int capcnt = 0;
    int srfcnt = 0;
    boolean rtab = false;
    boolean ftab = false;
    boolean btab = false;
    boolean surfer = false;
    float powerup = 0.0F;
    int xtpower = 0;
    float tilt = 0.0F;
    int[][] crank = new int[4][4];
    int[][] lcrank = new int[4][4];
    int squash = 0;
    int nbsq = 0;
    int hitmag = 0;
    int cntdest = 0;
    boolean dest = false;
    boolean newcar = false;
    int pan = 0;
    int pcleared = 0;
    int clear = 0;
    int nlaps = 0;
    int focus = -1;
    float power = 75.0F;
    int missedcp = 0;
    int lastcolido = 0;
    int point = 0;
    boolean nofocus = false;
    int rpdcatch = 0;
    int newedcar = 0;
    int fixes = -1;
    boolean colidim = false;
    
    public Mad(CarDefine cardefine, Medium medium, Record record, xtGraphics var_xtGraphics, int i) {
        this.cd = cardefine;
        this.m = medium;
        this.rpd = record;
        this.xt = var_xtGraphics;
        this.im = i;
    }
    
    public void reseto(int i, ContO conto, CheckPoints checkpoints) {
        this.cn = i;
        for (int i_0_ = 0; i_0_ < 7; i_0_++) {
            this.dominate[i_0_] = false;
            this.caught[i_0_] = false;
        }
        this.mxz = 0;
        this.cxz = 0;
        this.pzy = 0;
        this.pxy = 0;
        this.speed = 0.0F;
        for (int i_1_ = 0; i_1_ < 4; i_1_++) {
            this.scy[i_1_] = 0.0F;
            this.scx[i_1_] = 0.0F;
            this.scz[i_1_] = 0.0F;
        }
        this.forca = ((float) Math.sqrt((double) ((conto).keyz[0] * (conto).keyz[0] + (conto).keyx[0] * (conto).keyx[0])) + (float) Math.sqrt((double) ((conto).keyz[1] * (conto).keyz[1] + (conto).keyx[1] * (conto).keyx[1])) + (float) Math.sqrt((double) ((conto).keyz[2] * (conto).keyz[2] + (conto).keyx[2] * (conto).keyx[2])) + (float) Math.sqrt((double) ((conto).keyz[3] * (conto).keyz[3] + (conto).keyx[3] * (conto).keyx[3]))) / 10000.0F * (float) ((double) (this.cd).bounce[this.cn] - 0.3);
        this.mtouch = false;
        this.wtouch = false;
        this.txz = 0;
        this.fxz = 0;
        this.pmlt = 1;
        this.nmlt = 1;
        this.dcnt = 0;
        this.skid = 0;
        this.pushed = false;
        this.gtouch = false;
        this.pl = false;
        this.pr = false;
        this.pd = false;
        this.pu = false;
        this.loop = 0;
        this.ucomp = 0.0F;
        this.dcomp = 0.0F;
        this.lcomp = 0.0F;
        this.rcomp = 0.0F;
        this.lxz = 0;
        this.travxy = 0;
        this.travzy = 0;
        this.travxz = 0;
        this.rtab = false;
        this.ftab = false;
        this.btab = false;
        this.powerup = 0.0F;
        this.xtpower = 0;
        this.trcnt = 0;
        this.capcnt = 0;
        this.tilt = 0.0F;
        for (int i_2_ = 0; i_2_ < 4; i_2_++) {
            for (int i_3_ = 0; i_3_ < 4; i_3_++) {
                this.crank[i_2_][i_3_] = 0;
                this.lcrank[i_2_][i_3_] = 0;
            }
        }
        this.pan = 0;
        this.pcleared = (checkpoints).pcs;
        this.clear = 0;
        this.nlaps = 0;
        this.focus = -1;
        this.missedcp = 0;
        this.nofocus = false;
        this.power = 98.0F;
        this.lastcolido = 0;
        (checkpoints).dested[this.im] = 0;
        this.squash = 0;
        this.nbsq = 0;
        this.hitmag = 0;
        this.cntdest = 0;
        this.dest = false;
        this.newcar = false;
        if (this.im == (this.xt).im) {
            (this.m).checkpoint = -1;
            (this.m).lastcheck = false;
        }
        this.rpdcatch = 0;
        this.newedcar = 0;
        this.fixes = -1;
        if ((checkpoints).nfix == 1)
            this.fixes = 4;
        if ((checkpoints).nfix == 2)
            this.fixes = 3;
        if ((checkpoints).nfix == 3)
            this.fixes = 2;
        if ((checkpoints).nfix == 4)
            this.fixes = 1;
    }
    
    public void drive(Control control, ContO conto, Trackers trackers, CheckPoints checkpoints) {
        int i = 1;
        int i_4_ = 1;
        boolean bool = false;
        boolean bool_5_ = false;
        boolean bool_6_ = false;
        this.capsized = false;
        int i_7_;
        for (i_7_ = Math.abs(this.pzy); i_7_ > 270; i_7_ -= 360) {
            /* empty */
        }
        i_7_ = Math.abs(i_7_);
        if (i_7_ > 90)
            bool = true;
        boolean bool_8_ = false;
        int i_9_;
        for (i_9_ = Math.abs(this.pxy); i_9_ > 270; i_9_ -= 360) {
            /* empty */
        }
        i_9_ = Math.abs(i_9_);
        if (i_9_ > 90) {
            bool_8_ = true;
            i_4_ = -1;
        }
        int i_10_ = (conto).grat;
        if (bool) {
            if (bool_8_) {
                bool_8_ = false;
                bool_5_ = true;
            } else {
                bool_8_ = true;
                this.capsized = true;
            }
            i = -1;
        } else if (bool_8_)
            this.capsized = true;
        if (this.capsized)
            i_10_ = (this.cd).flipy[this.cn] + this.squash;
        (control).zyinv = bool;
        float f = 0.0F;
        float f_11_ = 0.0F;
        float f_12_ = 0.0F;
        if (this.mtouch)
            this.loop = 0;
        if (this.wtouch) {
            if (this.loop == 2 || this.loop == -1) {
                this.loop = -1;
                if ((control).left)
                    this.pl = true;
                if ((control).right)
                    this.pr = true;
                if ((control).up)
                    this.pu = true;
                if ((control).down)
                    this.pd = true;
            }
            this.ucomp = 0.0F;
            this.dcomp = 0.0F;
            this.lcomp = 0.0F;
            this.rcomp = 0.0F;
        }
        if ((control).handb) {
            if (!this.pushed) {
                if (!this.wtouch) {
                    if (this.loop == 0)
                        this.loop = 1;
                } else if (this.gtouch)
                    this.pushed = true;
            }
        } else
            this.pushed = false;
        if (this.loop == 1) {
            float f_13_ = (this.scy[0] + this.scy[1] + this.scy[2] + this.scy[3]) / 4.0F;
            for (int i_14_ = 0; i_14_ < 4; i_14_++)
                this.scy[i_14_] = f_13_;
            this.loop = 2;
        }
        if (!this.dest) {
            if (this.loop == 2) {
                if ((control).up) {
                    if (this.ucomp == 0.0F) {
                        this.ucomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F;
                        if (this.ucomp < 5.0F)
                            this.ucomp = 5.0F;
                        if (this.ucomp > 10.0F)
                            this.ucomp = 10.0F;
                        this.ucomp *= (this.cd).airs[this.cn];
                    }
                    if (this.ucomp < 20.0F)
                        this.ucomp += 0.5 * (double) (this.cd).airs[this.cn];
                    f = (float) -(this.cd).airc[this.cn] * this.m.sin((conto).xz) * (float) i_4_;
                    f_11_ = (float) (this.cd).airc[this.cn] * this.m.cos((conto).xz) * (float) i_4_;
                } else if (this.ucomp != 0.0F && this.ucomp > -2.0F)
                    this.ucomp -= 0.5 * (double) (this.cd).airs[this.cn];
                if ((control).down) {
                    if (this.dcomp == 0.0F) {
                        this.dcomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F;
                        if (this.dcomp < 5.0F)
                            this.dcomp = 5.0F;
                        if (this.dcomp > 10.0F)
                            this.dcomp = 10.0F;
                        this.dcomp *= (this.cd).airs[this.cn];
                    }
                    if (this.dcomp < 20.0F)
                        this.dcomp += 0.5 * (double) (this.cd).airs[this.cn];
                    f_12_ = (float) -(this.cd).airc[this.cn];
                } else if (this.dcomp != 0.0F && this.ucomp > -2.0F)
                    this.dcomp -= 0.5 * (double) (this.cd).airs[this.cn];
                if ((control).left) {
                    if (this.lcomp == 0.0F)
                        this.lcomp = 5.0F;
                    if (this.lcomp < 20.0F)
                        this.lcomp += 2.0F * (this.cd).airs[this.cn];
                    f = (float) -(this.cd).airc[this.cn] * this.m.cos((conto).xz) * (float) i;
                    f_11_ = (float) -(this.cd).airc[this.cn] * this.m.sin((conto).xz) * (float) i;
                } else if (this.lcomp > 0.0F)
                    this.lcomp -= 2.0F * (this.cd).airs[this.cn];
                if ((control).right) {
                    if (this.rcomp == 0.0F)
                        this.rcomp = 5.0F;
                    if (this.rcomp < 20.0F)
                        this.rcomp += 2.0F * (this.cd).airs[this.cn];
                    f = (float) (this.cd).airc[this.cn] * this.m.cos((conto).xz) * (float) i;
                    f_11_ = (float) (this.cd).airc[this.cn] * this.m.sin((conto).xz) * (float) i;
                } else if (this.rcomp > 0.0F)
                    this.rcomp -= 2.0F * (this.cd).airs[this.cn];
                this.pzy += (this.dcomp - this.ucomp) * this.m.cos(this.pxy);
                if (bool)
                    (conto).xz += (this.dcomp - this.ucomp) * this.m.sin(this.pxy);
                else
                    (conto).xz -= (this.dcomp - this.ucomp) * this.m.sin(this.pxy);
                this.pxy += this.rcomp - this.lcomp;
            } else {
                float f_15_ = this.power;
                if (f_15_ < 40.0F)
                    f_15_ = 40.0F;
                if ((control).down) {
                    if (this.speed > 0.0F)
                        this.speed -= (float) ((this.cd).handb[this.cn] / 2);
                    else {
                        int i_16_ = 0;
                        for (int i_17_ = 0; i_17_ < 2; i_17_++) {
                            if (this.speed <= -((float) ((this.cd).swits[this.cn][i_17_] / 2) + f_15_ * (float) (this.cd).swits[this.cn][i_17_] / 196.0F))
                                i_16_++;
                        }
                        if (i_16_ != 2)
                            this.speed -= (this.cd).acelf[this.cn][i_16_] / 2.0F + f_15_ * (this.cd).acelf[this.cn][i_16_] / 196.0F;
                        else
                            this.speed = -((float) ((this.cd).swits[this.cn][1] / 2) + f_15_ * (float) (this.cd).swits[this.cn][1] / 196.0F);
                    }
                }
                if ((control).up) {
                    if (this.speed < 0.0F)
                        this.speed += (float) (this.cd).handb[this.cn];
                    else {
                        int i_18_ = 0;
                        for (int i_19_ = 0; i_19_ < 3; i_19_++) {
                            if (this.speed >= (float) ((this.cd).swits[this.cn][i_19_] / 2) + f_15_ * (float) (this.cd).swits[this.cn][i_19_] / 196.0F)
                                i_18_++;
                        }
                        if (i_18_ != 3)
                            this.speed += (this.cd).acelf[this.cn][i_18_] / 2.0F + f_15_ * (this.cd).acelf[this.cn][i_18_] / 196.0F;
                        else
                            this.speed = (float) ((this.cd).swits[this.cn][2] / 2) + f_15_ * (float) (this.cd).swits[this.cn][2] / 196.0F;
                    }
                }
                if ((control).handb && Math.abs(this.speed) > (float) (this.cd).handb[this.cn]) {
                    if (this.speed < 0.0F)
                        this.speed += (float) (this.cd).handb[this.cn];
                    else
                        this.speed -= (float) (this.cd).handb[this.cn];
                }
                if (this.loop == -1 && (conto).y < 100) {
                    if ((control).left) {
                        if (!this.pl) {
                            if (this.lcomp == 0.0F)
                                this.lcomp = 5.0F * (this.cd).airs[this.cn];
                            if (this.lcomp < 20.0F)
                                this.lcomp += 2.0F * (this.cd).airs[this.cn];
                        }
                    } else {
                        if (this.lcomp > 0.0F)
                            this.lcomp -= 2.0F * (this.cd).airs[this.cn];
                        this.pl = false;
                    }
                    if ((control).right) {
                        if (!this.pr) {
                            if (this.rcomp == 0.0F)
                                this.rcomp = 5.0F * (this.cd).airs[this.cn];
                            if (this.rcomp < 20.0F)
                                this.rcomp += 2.0F * (this.cd).airs[this.cn];
                        }
                    } else {
                        if (this.rcomp > 0.0F)
                            this.rcomp -= 2.0F * (this.cd).airs[this.cn];
                        this.pr = false;
                    }
                    if ((control).up) {
                        if (!this.pu) {
                            if (this.ucomp == 0.0F)
                                this.ucomp = 5.0F * (this.cd).airs[this.cn];
                            if (this.ucomp < 20.0F)
                                this.ucomp += 2.0F * (this.cd).airs[this.cn];
                        }
                    } else {
                        if (this.ucomp > 0.0F)
                            this.ucomp -= 2.0F * (this.cd).airs[this.cn];
                        this.pu = false;
                    }
                    if ((control).down) {
                        if (!this.pd) {
                            if (this.dcomp == 0.0F)
                                this.dcomp = 5.0F * (this.cd).airs[this.cn];
                            if (this.dcomp < 20.0F)
                                this.dcomp += 2.0F * (this.cd).airs[this.cn];
                        }
                    } else {
                        if (this.dcomp > 0.0F)
                            this.dcomp -= 2.0F * (this.cd).airs[this.cn];
                        this.pd = false;
                    }
                    this.pzy += (this.dcomp - this.ucomp) * this.m.cos(this.pxy);
                    if (bool)
                        (conto).xz += (this.dcomp - this.ucomp) * this.m.sin(this.pxy);
                    else
                        (conto).xz -= (this.dcomp - this.ucomp) * this.m.sin(this.pxy);
                    this.pxy += this.rcomp - this.lcomp;
                }
            }
        }
        float f_20_ = 20.0F * this.speed / (154.0F * (this.cd).simag[this.cn]);
        if (f_20_ > 20.0F)
            f_20_ = 20.0F;
        (conto).wzy -= f_20_;
        if ((conto).wzy < -30)
            (conto).wzy += 30;
        if ((conto).wzy > 30)
            (conto).wzy -= 30;
        if ((control).right) {
            (conto).wxz -= (this.cd).turn[this.cn];
            if ((conto).wxz < -36)
                (conto).wxz = -36;
        }
        if ((control).left) {
            (conto).wxz += (this.cd).turn[this.cn];
            if ((conto).wxz > 36)
                (conto).wxz = 36;
        }
        if ((conto).wxz != 0 && !(control).left && !(control).right) {
            if (Math.abs(this.speed) < 10.0F) {
                if (Math.abs((conto).wxz) == 1)
                    (conto).wxz = 0;
                if ((conto).wxz > 0)
                    (conto).wxz--;
                if ((conto).wxz < 0)
                    (conto).wxz++;
            } else {
                if (Math.abs((conto).wxz) < (this.cd).turn[this.cn] * 2)
                    (conto).wxz = 0;
                if ((conto).wxz > 0)
                    (conto).wxz -= (this.cd).turn[this.cn] * 2;
                if ((conto).wxz < 0)
                    (conto).wxz += (this.cd).turn[this.cn] * 2;
            }
        }
        int i_21_ = (int) (3600.0F / (this.speed * this.speed));
        if (i_21_ < 5)
            i_21_ = 5;
        if (this.speed < 0.0F)
            i_21_ = -i_21_;
        if (this.wtouch) {
            if (!this.capsized) {
                if (!(control).handb)
                    this.fxz = (conto).wxz / (i_21_ * 3);
                else
                    this.fxz = (conto).wxz / i_21_;
                (conto).xz += (conto).wxz / i_21_;
            }
            this.wtouch = false;
            this.gtouch = false;
        } else
            (conto).xz += this.fxz;
        if (this.speed > 30.0F || this.speed < -100.0F) {
            while (Math.abs(this.mxz - this.cxz) > 180) {
                if (this.cxz > this.mxz)
                    this.cxz -= 360;
                else if (this.cxz < this.mxz)
                    this.cxz += 360;
            }
            if (Math.abs(this.mxz - this.cxz) < 30)
                this.cxz += (float) (this.mxz - this.cxz) / 4.0F;
            else {
                if (this.cxz > this.mxz)
                    this.cxz -= 10;
                if (this.cxz < this.mxz)
                    this.cxz += 10;
            }
        }
        float[] fs = new float[4];
        float[] fs_22_ = new float[4];
        float[] fs_23_ = new float[4];
        for (int i_24_ = 0; i_24_ < 4; i_24_++) {
            fs[i_24_] = (float) ((conto).keyx[i_24_] + (conto).x);
            fs_23_[i_24_] = (float) (i_10_ + (conto).y);
            fs_22_[i_24_] = (float) ((conto).z + (conto).keyz[i_24_]);
            this.scy[i_24_] += 7.0F;
        }
        rot(fs, fs_23_, (conto).x, (conto).y, this.pxy, 4);
        rot(fs_23_, fs_22_, (conto).y, (conto).z, this.pzy, 4);
        rot(fs, fs_22_, (conto).x, (conto).z, (conto).xz, 4);
        boolean bool_25_ = false;
        double d = 0.0;
        int i_26_ = (int) ((this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F);
        int i_27_ = (int) ((this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F);
        for (int i_28_ = 0; i_28_ < 4; i_28_++) {
            if (this.scx[i_28_] - (float) i_26_ > 200.0F)
                this.scx[i_28_] = (float) (200 + i_26_);
            if (this.scx[i_28_] - (float) i_26_ < -200.0F)
                this.scx[i_28_] = (float) (i_26_ - 200);
            if (this.scz[i_28_] - (float) i_27_ > 200.0F)
                this.scz[i_28_] = (float) (200 + i_27_);
            if (this.scz[i_28_] - (float) i_27_ < -200.0F)
                this.scz[i_28_] = (float) (i_27_ - 200);
        }
        for (int i_29_ = 0; i_29_ < 4; i_29_++) {
            fs_23_[i_29_] += this.scy[i_29_];
            fs[i_29_] += (this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F;
            fs_22_[i_29_] += (this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F;
        }
        int i_30_ = ((conto).x - (trackers).sx) / 3000;
        if (i_30_ > (trackers).ncx)
            i_30_ = (trackers).ncx;
        if (i_30_ < 0)
            i_30_ = 0;
        int i_31_ = ((conto).z - (trackers).sz) / 3000;
        if (i_31_ > (trackers).ncz)
            i_31_ = (trackers).ncz;
        if (i_31_ < 0)
            i_31_ = 0;
        int i_32_ = 1;
        for (int i_33_ = 0; i_33_ < (trackers).sect[i_30_][i_31_].length; i_33_++) {
            int i_34_ = (trackers).sect[i_30_][i_31_][i_33_];
            if (Math.abs((trackers).zy[i_34_]) != 90 && Math.abs((trackers).xy[i_34_]) != 90 && Math.abs((conto).x - (trackers).x[i_34_]) < (trackers).radx[i_34_] && Math.abs((conto).z - (trackers).z[i_34_]) < (trackers).radz[i_34_] && (!(trackers).decor[i_34_] || (this.m).resdown != 2 || (this.xt).multion != 0))
                i_32_ = (trackers).skd[i_34_];
        }
        if (this.mtouch) {
            float f_35_ = (this.cd).grip[this.cn];
            f_35_ -= (float) Math.abs(this.txz - (conto).xz) * this.speed / 250.0F;
            if ((control).handb)
                f_35_ -= (float) (Math.abs(this.txz - (conto).xz) * 4);
            if (f_35_ < (this.cd).grip[this.cn]) {
                if (this.skid != 2)
                    this.skid = 1;
                this.speed -= this.speed / 100.0F;
            } else if (this.skid == 1)
                this.skid = 2;
            if (i_32_ == 1)
                f_35_ *= 0.75;
            if (i_32_ == 2)
                f_35_ *= 0.55;
            int i_36_ = -(int) (this.speed * this.m.sin((conto).xz) * this.m.cos(this.pzy));
            int i_37_ = (int) (this.speed * this.m.cos((conto).xz) * this.m.cos(this.pzy));
            int i_38_ = -(int) (this.speed * this.m.sin(this.pzy));
            if (this.capsized || this.dest || (checkpoints).haltall) {
                i_36_ = 0;
                i_37_ = 0;
                i_38_ = 0;
                f_35_ = (this.cd).grip[this.cn] / 5.0F;
                if (this.speed > 0.0F)
                    this.speed -= 2.0F;
                else
                    this.speed += 2.0F;
            }
            if (Math.abs(this.speed) > this.drag) {
                if (this.speed > 0.0F)
                    this.speed -= this.drag;
                else
                    this.speed += this.drag;
            } else
                this.speed = 0.0F;
            if (this.cn == 8 && f_35_ < 5.0F)
                f_35_ = 5.0F;
            if (f_35_ < 1.0F)
                f_35_ = 1.0F;
            float f_39_ = 0.0F;
            float f_40_ = 0.0F;
            for (int i_41_ = 0; i_41_ < 4; i_41_++) {
                if (Math.abs(this.scx[i_41_] - (float) i_36_) > f_35_) {
                    if (this.scx[i_41_] < (float) i_36_)
                        this.scx[i_41_] += f_35_;
                    else
                        this.scx[i_41_] -= f_35_;
                } else
                    this.scx[i_41_] = (float) i_36_;
                if (Math.abs(this.scz[i_41_] - (float) i_37_) > f_35_) {
                    if (this.scz[i_41_] < (float) i_37_)
                        this.scz[i_41_] += f_35_;
                    else
                        this.scz[i_41_] -= f_35_;
                } else
                    this.scz[i_41_] = (float) i_37_;
                if (Math.abs(this.scy[i_41_] - (float) i_38_) > f_35_) {
                    if (this.scy[i_41_] < (float) i_38_)
                        this.scy[i_41_] += f_35_;
                    else
                        this.scy[i_41_] -= f_35_;
                } else
                    this.scy[i_41_] = (float) i_38_;
                if (f_35_ < (this.cd).grip[this.cn]) {
                    if (this.txz != (conto).xz)
                        this.dcnt++;
                    else if (this.dcnt != 0)
                        this.dcnt = 0;
                    if ((float) this.dcnt > 40.0F * f_35_ / (this.cd).grip[this.cn] || this.capsized) {
                        float f_42_ = 1.0F;
                        if (i_32_ != 0)
                            f_42_ = 1.2F;
                        if ((double) this.m.random() > 0.65) {
                            //conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) this.scx[i_41_], (int) this.scz[i_41_], f_42_ * (this.cd).simag[this.cn], (int) this.tilt, this.capsized && this.mtouch);
                            if (this.im == (this.xt).im && !this.capsized)
                                this.xt.skid(i_32_, (float) Math.sqrt((double) (this.scx[i_41_] * this.scx[i_41_] + this.scz[i_41_] * this.scz[i_41_])));
                        }
                    } else {
                        if (i_32_ == 1 && (double) this.m.random() > 0.8)
                            conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) this.scx[i_41_], (int) this.scz[i_41_], 1.1F * (this.cd).simag[this.cn], (int) this.tilt, this.capsized && this.mtouch);
                        if ((i_32_ == 2 || i_32_ == 3) && (double) this.m.random() > 0.6)
                            conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) this.scx[i_41_], (int) this.scz[i_41_], 1.15F * (this.cd).simag[this.cn], (int) this.tilt, this.capsized && this.mtouch);
                    }
                } else if (this.dcnt != 0) {
                    this.dcnt -= 2;
                    if (this.dcnt < 0)
                        this.dcnt = 0;
                }
                if (i_32_ == 3) {
                    int i_43_ = (int) (this.m.random() * 4.0F);
                    this.scy[i_43_] = (float) ((double) (-100.0F * this.m.random() * (this.speed / (float) (this.cd).swits[this.cn][2])) * ((double) (this.cd).bounce[this.cn] - 0.3));
                }
                if (i_32_ == 4) {
                    int i_44_ = (int) (this.m.random() * 4.0F);
                    this.scy[i_44_] = (float) ((double) (-150.0F * this.m.random() * (this.speed / (float) (this.cd).swits[this.cn][2])) * ((double) (this.cd).bounce[this.cn] - 0.3));
                }
                f_39_ += this.scx[i_41_];
                f_40_ += this.scz[i_41_];
            }
            this.txz = (conto).xz;
            if (f_39_ > 0.0F)
                i = -1;
            else
                i = 1;
            d = (double) f_40_ / Math.sqrt((double) (f_39_ * f_39_ + f_40_ * f_40_));
            this.mxz = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
            if (this.skid == 2) {
                if (!this.capsized) {
                    f_39_ /= 4.0F;
                    f_40_ /= 4.0F;
                    if (bool_5_)
                        this.speed = -((float) Math.sqrt((double) (f_39_ * f_39_ + f_40_ * f_40_)) * this.m.cos(this.mxz - (conto).xz));
                    else
                        this.speed = (float) Math.sqrt((double) (f_39_ * f_39_ + f_40_ * f_40_)) * this.m.cos(this.mxz - (conto).xz);
                }
                this.skid = 0;
            }
            if (this.capsized && f_39_ == 0.0F && f_40_ == 0.0F)
                i_32_ = 0;
            this.mtouch = false;
            bool_25_ = true;
        } else if (this.skid != 2)
            this.skid = 2;
        int i_45_ = 0;
        boolean[] bools = new boolean[4];
        boolean[] bools_46_ = new boolean[4];
        boolean[] bools_47_ = new boolean[4];
        float f_48_ = 0.0F;
        for (int i_49_ = 0; i_49_ < 4; i_49_++) {
            bools_46_[i_49_] = false;
            bools_47_[i_49_] = false;
            if (fs_23_[i_49_] > 245.0F) {
                i_45_++;
                this.wtouch = true;
                this.gtouch = true;
                if (!bool_25_ && this.scy[i_49_] != 7.0F) {
                    float f_50_ = this.scy[i_49_] / 333.33F;
                    if ((double) f_50_ > 0.3)
                        f_50_ = 0.3F;
                    if (i_32_ == 0)
                        f_50_ += 1.1;
                    else
                        f_50_ += 1.2;
                    //conto.dust(i_49_, fs[i_49_], fs_23_[i_49_], fs_22_[i_49_], (int) this.scx[i_49_], (int) this.scz[i_49_], f_50_ * (this.cd).simag[this.cn], 0, this.capsized && this.mtouch);
                }
                fs_23_[i_49_] = 250.0F;
                bools_47_[i_49_] = true;
                f_48_ += fs_23_[i_49_] - 250.0F;
                float f_51_ = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
                f_51_ /= 3.0F;
                if ((double) f_51_ > 0.4)
                    f_51_ = 0.4F;
                f_51_ += (this.cd).bounce[this.cn];
                if ((double) f_51_ < 1.1)
                    f_51_ = 1.1F;
                regy(i_49_, Math.abs(this.scy[i_49_] * f_51_), conto);
                if (this.scy[i_49_] > 0.0F)
                    this.scy[i_49_] -= Math.abs(this.scy[i_49_] * f_51_);
                if (this.capsized)
                    bools_46_[i_49_] = true;
            }
            bools[i_49_] = false;
        }
        if (i_45_ != 0) {
            f_48_ /= (float) i_45_;
            for (int i_52_ = 0; i_52_ < 4; i_52_++) {
                if (!bools_47_[i_52_])
                    fs_23_[i_52_] -= f_48_;
            }
        }
        int i_53_ = 0;
        for (int i_54_ = 0; i_54_ < (trackers).sect[i_30_][i_31_].length; i_54_++) {
            int i_55_ = (trackers).sect[i_30_][i_31_][i_54_];
            int i_56_ = 0;
            int i_57_ = 0;
            for (int i_58_ = 0; i_58_ < 4; i_58_++) {
                if (bools_46_[i_58_] && ((trackers).skd[i_55_] == 0 || (trackers).skd[i_55_] == 1) && fs[i_58_] > (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]) && fs[i_58_] < (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]) && fs_22_[i_58_] > (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]) && fs_22_[i_58_] < (float) ((trackers).z[i_55_] + (trackers).radz[i_55_])) {
                    conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 1);
                    if (this.im == (this.xt).im)
                        this.xt.gscrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                }
                if (!bools[i_58_] && fs[i_58_] > (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]) && fs[i_58_] < (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]) && fs_22_[i_58_] > (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]) && fs_22_[i_58_] < (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]) && fs_23_[i_58_] > (float) ((trackers).y[i_55_] - (trackers).rady[i_55_]) && fs_23_[i_58_] < (float) ((trackers).y[i_55_] + (trackers).rady[i_55_]) && (!(trackers).decor[i_55_] || (this.m).resdown != 2 || (this.xt).multion != 0)) {
                    if ((trackers).xy[i_55_] == 0 && (trackers).zy[i_55_] == 0 && (trackers).y[i_55_] != 250 && fs_23_[i_58_] > (float) ((trackers).y[i_55_] - 5)) {
                        i_57_++;
                        this.wtouch = true;
                        this.gtouch = true;
                        if (!bool_25_ && this.scy[i_58_] != 7.0F) {
                            float f_59_ = this.scy[i_58_] / 333.33F;
                            if ((double) f_59_ > 0.3)
                                f_59_ = 0.3F;
                            if (i_32_ == 0)
                                f_59_ += 1.1;
                            else
                                f_59_ += 1.2;
                            conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) this.scx[i_58_], (int) this.scz[i_58_], f_59_ * (this.cd).simag[this.cn], 0, this.capsized && this.mtouch);
                        }
                        fs_23_[i_58_] = (float) (trackers).y[i_55_];
                        if (this.capsized && ((trackers).skd[i_55_] == 0 || (trackers).skd[i_55_] == 1)) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 1);
                            if (this.im == (this.xt).im)
                                this.xt.gscrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                        }
                        float f_60_ = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
                        f_60_ /= 3.0F;
                        if ((double) f_60_ > 0.4)
                            f_60_ = 0.4F;
                        f_60_ += (this.cd).bounce[this.cn];
                        if ((double) f_60_ < 1.1)
                            f_60_ = 1.1F;
                        regy(i_58_, Math.abs(this.scy[i_58_] * f_60_), conto);
                        if (this.scy[i_58_] > 0.0F)
                            this.scy[i_58_] -= Math.abs(this.scy[i_58_] * f_60_);
                        bools[i_58_] = true;
                    }
                    if ((trackers).zy[i_55_] == -90 && fs_22_[i_58_] < (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]) && (this.scz[i_58_] < 0.0F || (trackers).radz[i_55_] == 287)) {
                        for (int i_61_ = 0; i_61_ < 4; i_61_++) {
                            if (i_58_ != i_61_ && fs_22_[i_61_] >= (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]))
                                fs_22_[i_61_] -= fs_22_[i_58_] - (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]);
                        }
                        fs_22_[i_58_] = (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            this.crank[0][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && this.m.random() > this.m.random())
                            this.crank[0][i_58_]++;
                        if (this.crank[0][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 0);
                            if (this.im == (this.xt).im)
                                this.xt.scrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                        }
                        float f_62_ = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                        f_62_ /= 4.0F;
                        if ((double) f_62_ > 0.3)
                            f_62_ = 0.3F;
                        if (bool_25_)
                            f_62_ = 0.0F;
                        f_62_ += (double) (this.cd).bounce[this.cn] - 0.2;
                        if ((double) f_62_ < 1.1)
                            f_62_ = 1.1F;
                        regz(i_58_, Math.abs(this.scz[i_58_] * f_62_ * (float) (trackers).dam[i_55_]), conto);
                        this.scz[i_58_] += Math.abs(this.scz[i_58_] * f_62_);
                        this.skid = 2;
                        bool_6_ = true;
                        bools[i_58_] = true;
                        if (!(trackers).notwall[i_55_])
                            (control).wall = i_55_;
                    }
                    if ((trackers).zy[i_55_] == 90 && fs_22_[i_58_] > (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]) && (this.scz[i_58_] > 0.0F || (trackers).radz[i_55_] == 287)) {
                        for (int i_63_ = 0; i_63_ < 4; i_63_++) {
                            if (i_58_ != i_63_ && fs_22_[i_63_] <= (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]))
                                fs_22_[i_63_] -= fs_22_[i_58_] - (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]);
                        }
                        fs_22_[i_58_] = (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            this.crank[1][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && this.m.random() > this.m.random())
                            this.crank[1][i_58_]++;
                        if (this.crank[1][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 0);
                            if (this.im == (this.xt).im)
                                this.xt.scrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                        }
                        float f_64_ = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                        f_64_ /= 4.0F;
                        if ((double) f_64_ > 0.3)
                            f_64_ = 0.3F;
                        if (bool_25_)
                            f_64_ = 0.0F;
                        f_64_ += (double) (this.cd).bounce[this.cn] - 0.2;
                        if ((double) f_64_ < 1.1)
                            f_64_ = 1.1F;
                        regz(i_58_, -Math.abs(this.scz[i_58_] * f_64_ * (float) (trackers).dam[i_55_]), conto);
                        this.scz[i_58_] -= Math.abs(this.scz[i_58_] * f_64_);
                        this.skid = 2;
                        bool_6_ = true;
                        bools[i_58_] = true;
                        if (!(trackers).notwall[i_55_])
                            (control).wall = i_55_;
                    }
                    if ((trackers).xy[i_55_] == -90 && fs[i_58_] < (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]) && (this.scx[i_58_] < 0.0F || (trackers).radx[i_55_] == 287)) {
                        for (int i_65_ = 0; i_65_ < 4; i_65_++) {
                            if (i_58_ != i_65_ && fs[i_65_] >= (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]))
                                fs[i_65_] -= fs[i_58_] - (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]);
                        }
                        fs[i_58_] = (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            this.crank[2][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && this.m.random() > this.m.random())
                            this.crank[2][i_58_]++;
                        if (this.crank[2][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 0);
                            if (this.im == (this.xt).im)
                                this.xt.scrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                        }
                        float f_66_ = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                        f_66_ /= 4.0F;
                        if ((double) f_66_ > 0.3)
                            f_66_ = 0.3F;
                        if (bool_25_)
                            f_66_ = 0.0F;
                        f_66_ += (double) (this.cd).bounce[this.cn] - 0.2;
                        if ((double) f_66_ < 1.1)
                            f_66_ = 1.1F;
                        regx(i_58_, Math.abs(this.scx[i_58_] * f_66_ * (float) (trackers).dam[i_55_]), conto);
                        this.scx[i_58_] += Math.abs(this.scx[i_58_] * f_66_);
                        this.skid = 2;
                        bool_6_ = true;
                        bools[i_58_] = true;
                        if (!(trackers).notwall[i_55_])
                            (control).wall = i_55_;
                    }
                    if ((trackers).xy[i_55_] == 90 && fs[i_58_] > (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]) && (this.scx[i_58_] > 0.0F || (trackers).radx[i_55_] == 287)) {
                        for (int i_67_ = 0; i_67_ < 4; i_67_++) {
                            if (i_58_ != i_67_ && fs[i_67_] <= (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]))
                                fs[i_67_] -= fs[i_58_] - (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]);
                        }
                        fs[i_58_] = (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            this.crank[3][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && this.m.random() > this.m.random())
                            this.crank[3][i_58_]++;
                        if (this.crank[3][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 0);
                            if (this.im == (this.xt).im)
                                this.xt.scrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                        }
                        float f_68_ = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                        f_68_ /= 4.0F;
                        if ((double) f_68_ > 0.3)
                            f_68_ = 0.3F;
                        if (bool_25_)
                            f_68_ = 0.0F;
                        f_68_ += (double) (this.cd).bounce[this.cn] - 0.2;
                        if ((double) f_68_ < 1.1)
                            f_68_ = 1.1F;
                        regx(i_58_, -Math.abs(this.scx[i_58_] * f_68_ * (float) (trackers).dam[i_55_]), conto);
                        this.scx[i_58_] -= Math.abs(this.scx[i_58_] * f_68_);
                        this.skid = 2;
                        bool_6_ = true;
                        bools[i_58_] = true;
                        if (!(trackers).notwall[i_55_])
                            (control).wall = i_55_;
                    }
                    if ((trackers).zy[i_55_] != 0 && (trackers).zy[i_55_] != 90 && (trackers).zy[i_55_] != -90) {
                        int i_69_ = 90 + (trackers).zy[i_55_];
                        float f_70_ = 1.0F + (float) (50 - Math.abs((trackers).zy[i_55_])) / 30.0F;
                        if (f_70_ < 1.0F)
                            f_70_ = 1.0F;
                        float f_71_ = (float) (trackers).y[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * this.m.cos(i_69_) - (fs_22_[i_58_] - (float) (trackers).z[i_55_]) * this.m.sin(i_69_));
                        float f_72_ = (float) (trackers).z[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * this.m.sin(i_69_) + (fs_22_[i_58_] - (float) (trackers).z[i_55_]) * this.m.cos(i_69_));
                        if (f_72_ > (float) (trackers).z[i_55_] && f_72_ < (float) ((trackers).z[i_55_] + 200)) {
                            this.scy[i_58_] -= (f_72_ - (float) (trackers).z[i_55_]) / f_70_;
                            f_72_ = (float) (trackers).z[i_55_];
                        }
                        if (f_72_ > (float) ((trackers).z[i_55_] - 30)) {
                            if ((trackers).skd[i_55_] == 2)
                                i_56_++;
                            else
                                i_53_++;
                            this.wtouch = true;
                            this.gtouch = false;
                            if (this.capsized && ((trackers).skd[i_55_] == 0 || (trackers).skd[i_55_] == 1)) {
                                conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 1);
                                if (this.im == (this.xt).im)
                                    this.xt.gscrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                            }
                            if (!bool_25_ && i_32_ != 0) {
                                float f_73_ = 1.4F;
                                conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) this.scx[i_58_], (int) this.scz[i_58_], f_73_ * (this.cd).simag[this.cn], 0, this.capsized && this.mtouch);
                            }
                        }
                        fs_23_[i_58_] = (float) (trackers).y[i_55_] + ((f_71_ - (float) (trackers).y[i_55_]) * this.m.cos(-i_69_) - (f_72_ - (float) (trackers).z[i_55_]) * this.m.sin(-i_69_));
                        fs_22_[i_58_] = (float) (trackers).z[i_55_] + ((f_71_ - (float) (trackers).y[i_55_]) * this.m.sin(-i_69_) + (f_72_ - (float) (trackers).z[i_55_]) * this.m.cos(-i_69_));
                        bools[i_58_] = true;
                    }
                    if ((trackers).xy[i_55_] != 0 && (trackers).xy[i_55_] != 90 && (trackers).xy[i_55_] != -90) {
                        int i_74_ = 90 + (trackers).xy[i_55_];
                        float f_75_ = 1.0F + (float) (50 - Math.abs((trackers).xy[i_55_])) / 30.0F;
                        if (f_75_ < 1.0F)
                            f_75_ = 1.0F;
                        float f_76_ = (float) (trackers).y[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * this.m.cos(i_74_) - (fs[i_58_] - (float) (trackers).x[i_55_]) * this.m.sin(i_74_));
                        float f_77_ = (float) (trackers).x[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * this.m.sin(i_74_) + (fs[i_58_] - (float) (trackers).x[i_55_]) * this.m.cos(i_74_));
                        if (f_77_ > (float) (trackers).x[i_55_] && f_77_ < (float) ((trackers).x[i_55_] + 200)) {
                            this.scy[i_58_] -= (f_77_ - (float) (trackers).x[i_55_]) / f_75_;
                            f_77_ = (float) (trackers).x[i_55_];
                        }
                        if (f_77_ > (float) ((trackers).x[i_55_] - 30)) {
                            if ((trackers).skd[i_55_] == 2)
                                i_56_++;
                            else
                                i_53_++;
                            this.wtouch = true;
                            this.gtouch = false;
                            if (this.capsized && ((trackers).skd[i_55_] == 0 || (trackers).skd[i_55_] == 1)) {
                                conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], this.scx[i_58_], this.scy[i_58_], this.scz[i_58_], 1);
                                if (this.im == (this.xt).im)
                                    this.xt.gscrape((int) this.scx[i_58_], (int) this.scy[i_58_], (int) this.scz[i_58_]);
                            }
                            if (!bool_25_ && i_32_ != 0) {
                                float f_78_ = 1.4F;
                                conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) this.scx[i_58_], (int) this.scz[i_58_], f_78_ * (this.cd).simag[this.cn], 0, this.capsized && this.mtouch);
                            }
                        }
                        fs_23_[i_58_] = (float) (trackers).y[i_55_] + ((f_76_ - (float) (trackers).y[i_55_]) * this.m.cos(-i_74_) - (f_77_ - (float) (trackers).x[i_55_]) * this.m.sin(-i_74_));
                        fs[i_58_] = (float) (trackers).x[i_55_] + ((f_76_ - (float) (trackers).y[i_55_]) * this.m.sin(-i_74_) + (f_77_ - (float) (trackers).x[i_55_]) * this.m.cos(-i_74_));
                        bools[i_58_] = true;
                    }
                }
            }
            if (i_56_ == 4)
                this.mtouch = true;
            if (i_57_ == 4)
                i_45_ = 4;
        }
        if (i_53_ == 4)
            this.mtouch = true;
        for (int i_79_ = 0; i_79_ < 4; i_79_++) {
            for (int i_80_ = 0; i_80_ < 4; i_80_++) {
                if (this.crank[i_79_][i_80_] == this.lcrank[i_79_][i_80_])
                    this.crank[i_79_][i_80_] = 0;
                this.lcrank[i_79_][i_80_] = this.crank[i_79_][i_80_];
            }
        }
        int i_81_ = 0;
        int i_82_ = 0;
        int i_83_ = 0;
        int i_84_ = 0;
        if (this.scy[2] != this.scy[0]) {
            if (this.scy[2] < this.scy[0])
                i = -1;
            else
                i = 1;
            d = Math.sqrt((double) ((fs_22_[0] - fs_22_[2]) * (fs_22_[0] - fs_22_[2]) + (fs_23_[0] - fs_23_[2]) * (fs_23_[0] - fs_23_[2]) + (fs[0] - fs[2]) * (fs[0] - fs[2]))) / (double) (Math.abs((conto).keyz[0]) + Math.abs((conto).keyz[2]));
            if (d >= 0.9998)
                i_81_ = i;
            else
                i_81_ = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
        }
        if (this.scy[3] != this.scy[1]) {
            if (this.scy[3] < this.scy[1])
                i = -1;
            else
                i = 1;
            d = Math.sqrt((double) ((fs_22_[1] - fs_22_[3]) * (fs_22_[1] - fs_22_[3]) + (fs_23_[1] - fs_23_[3]) * (fs_23_[1] - fs_23_[3]) + (fs[1] - fs[3]) * (fs[1] - fs[3]))) / (double) (Math.abs((conto).keyz[1]) + Math.abs((conto).keyz[3]));
            if (d >= 0.9998)
                i_82_ = i;
            else
                i_82_ = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
        }
        if (this.scy[1] != this.scy[0]) {
            if (this.scy[1] < this.scy[0])
                i = -1;
            else
                i = 1;
            d = Math.sqrt((double) ((fs_22_[0] - fs_22_[1]) * (fs_22_[0] - fs_22_[1]) + (fs_23_[0] - fs_23_[1]) * (fs_23_[0] - fs_23_[1]) + (fs[0] - fs[1]) * (fs[0] - fs[1]))) / (double) (Math.abs((conto).keyx[0]) + Math.abs((conto).keyx[1]));
            if (d >= 0.9998)
                i_83_ = i;
            else
                i_83_ = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
        }
        if (this.scy[3] != this.scy[2]) {
            if (this.scy[3] < this.scy[2])
                i = -1;
            else
                i = 1;
            d = Math.sqrt((double) ((fs_22_[2] - fs_22_[3]) * (fs_22_[2] - fs_22_[3]) + (fs_23_[2] - fs_23_[3]) * (fs_23_[2] - fs_23_[3]) + (fs[2] - fs[3]) * (fs[2] - fs[3]))) / (double) (Math.abs((conto).keyx[2]) + Math.abs((conto).keyx[3]));
            if (d >= 0.9998)
                i_84_ = i;
            else
                i_84_ = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
        }
        if (bool_6_) {
            int i_85_;
            for (i_85_ = Math.abs((conto).xz + 45); i_85_ > 180; i_85_ -= 360) {
                /* empty */
            }
            if (Math.abs(i_85_) > 90)
                this.pmlt = 1;
            else
                this.pmlt = -1;
            for (i_85_ = Math.abs((conto).xz - 45); i_85_ > 180; i_85_ -= 360) {
                /* empty */
            }
            if (Math.abs(i_85_) > 90)
                this.nmlt = 1;
            else
                this.nmlt = -1;
        }
        (conto).xz += this.forca * (this.scz[0] * (float) this.nmlt - this.scz[1] * (float) this.pmlt + this.scz[2] * (float) this.pmlt - this.scz[3] * (float) this.nmlt + this.scx[0] * (float) this.pmlt + this.scx[1] * (float) this.nmlt - this.scx[2] * (float) this.nmlt - this.scx[3] * (float) this.pmlt);
        if (Math.abs(i_82_) > Math.abs(i_81_))
            i_81_ = i_82_;
        if (Math.abs(i_84_) > Math.abs(i_83_))
            i_83_ = i_84_;
        if (!bool)
            this.pzy += i_81_;
        else
            this.pzy -= i_81_;
        if (!bool_8_)
            this.pxy += i_83_;
        else
            this.pxy -= i_83_;
        if (i_45_ == 4) {
            int i_86_ = 0;
            while (this.pzy < 360) {
                this.pzy += 360;
                (conto).zy += 360;
            }
            while (this.pzy > 360) {
                this.pzy -= 360;
                (conto).zy -= 360;
            }
            if (this.pzy < 190 && this.pzy > 170) {
                this.pzy = 180;
                (conto).zy = 180;
                i_86_++;
            }
            if (this.pzy > 350 || this.pzy < 10) {
                this.pzy = 0;
                (conto).zy = 0;
                i_86_++;
            }
            while (this.pxy < 360) {
                this.pxy += 360;
                (conto).xy += 360;
            }
            while (this.pxy > 360) {
                this.pxy -= 360;
                (conto).xy -= 360;
            }
            if (this.pxy < 190 && this.pxy > 170) {
                this.pxy = 180;
                (conto).xy = 180;
                i_86_++;
            }
            if (this.pxy > 350 || this.pxy < 10) {
                this.pxy = 0;
                (conto).xy = 0;
                i_86_++;
            }
            if (i_86_ == 2)
                this.mtouch = true;
        }
        if (!this.mtouch && this.wtouch) {
            if (this.cntouch == 10)
                this.mtouch = true;
            else
                this.cntouch++;
        } else
            this.cntouch = 0;
        (conto).y = (int) ((fs_23_[0] + fs_23_[1] + fs_23_[2] + fs_23_[3]) / 4.0F - (float) i_10_ * this.m.cos(this.pzy) * this.m.cos(this.pxy) + f_12_);
        if (bool)
            i = -1;
        else
            i = 1;
        (conto).x = (int) ((fs[0] - (float) (conto).keyx[0] * this.m.cos((conto).xz) + (float) (i * (conto).keyz[0]) * this.m.sin((conto).xz) + fs[1] - (float) (conto).keyx[1] * this.m.cos((conto).xz) + (float) (i * (conto).keyz[1]) * this.m.sin((conto).xz) + fs[2] - (float) (conto).keyx[2] * this.m.cos((conto).xz) + (float) (i * (conto).keyz[2]) * this.m.sin((conto).xz) + fs[3] - (float) (conto).keyx[3] * this.m.cos((conto).xz) + (float) (i * (conto).keyz[3]) * this.m.sin((conto).xz)) / 4.0F + (float) i_10_ * this.m.sin(this.pxy) * this.m.cos((conto).xz) - (float) i_10_ * this.m.sin(this.pzy) * this.m.sin((conto).xz) + f);
        (conto).z = (int) ((fs_22_[0] - (float) (i * (conto).keyz[0]) * this.m.cos((conto).xz) - (float) (conto).keyx[0] * this.m.sin((conto).xz) + fs_22_[1] - (float) (i * (conto).keyz[1]) * this.m.cos((conto).xz) - (float) (conto).keyx[1] * this.m.sin((conto).xz) + fs_22_[2] - (float) (i * (conto).keyz[2]) * this.m.cos((conto).xz) - (float) (conto).keyx[2] * this.m.sin((conto).xz) + fs_22_[3] - (float) (i * (conto).keyz[3]) * this.m.cos((conto).xz) - (float) (conto).keyx[3] * this.m.sin((conto).xz)) / 4.0F + (float) i_10_ * this.m.sin(this.pxy) * this.m.sin((conto).xz) - (float) i_10_ * this.m.sin(this.pzy) * this.m.cos((conto).xz) + f_11_);
        if (Math.abs(this.speed) > 10.0F || !this.mtouch) {
            if (Math.abs(this.pxy - (conto).xy) >= 4) {
                if (this.pxy > (conto).xy)
                    (conto).xy += 2 + (this.pxy - (conto).xy) / 2;
                else
                    (conto).xy -= 2 + ((conto).xy - this.pxy) / 2;
            } else
                (conto).xy = this.pxy;
            if (Math.abs(this.pzy - (conto).zy) >= 4) {
                if (this.pzy > (conto).zy)
                    (conto).zy += 2 + (this.pzy - (conto).zy) / 2;
                else
                    (conto).zy -= 2 + ((conto).zy - this.pzy) / 2;
            } else
                (conto).zy = this.pzy;
        }
        if (this.wtouch && !this.capsized) {
            float f_87_ = (float) ((double) (this.speed / (float) (this.cd).swits[this.cn][2] * 14.0F) * ((double) (this.cd).bounce[this.cn] - 0.4));
            if ((control).left && this.tilt < f_87_ && this.tilt >= 0.0F)
                this.tilt += 0.4;
            else if ((control).right && this.tilt > -f_87_ && this.tilt <= 0.0F)
                this.tilt -= 0.4;
            else if ((double) Math.abs(this.tilt) > 3.0 * ((double) (this.cd).bounce[this.cn] - 0.4)) {
                if (this.tilt > 0.0F)
                    this.tilt -= 3.0 * ((double) (this.cd).bounce[this.cn] - 0.3);
                else
                    this.tilt += 3.0 * ((double) (this.cd).bounce[this.cn] - 0.3);
            } else
                this.tilt = 0.0F;
            (conto).xy += this.tilt;
            if (this.gtouch)
                (conto).y -= (double) this.tilt / 1.5;
        } else if (this.tilt != 0.0F)
            this.tilt = 0.0F;
        if (this.wtouch && i_32_ == 2) {
            (conto).zy += (int) ((double) (this.m.random() * 6.0F * this.speed / (float) (this.cd).swits[this.cn][2] - 3.0F * this.speed / (float) (this.cd).swits[this.cn][2]) * ((double) (this.cd).bounce[this.cn] - 0.3));
            (conto).xy += (int) ((double) (this.m.random() * 6.0F * this.speed / (float) (this.cd).swits[this.cn][2] - 3.0F * this.speed / (float) (this.cd).swits[this.cn][2]) * ((double) (this.cd).bounce[this.cn] - 0.3));
        }
        if (this.wtouch && i_32_ == 1) {
            (conto).zy += (int) ((double) (this.m.random() * 4.0F * this.speed / (float) (this.cd).swits[this.cn][2] - 2.0F * this.speed / (float) (this.cd).swits[this.cn][2]) * ((double) (this.cd).bounce[this.cn] - 0.3));
            (conto).xy += (int) ((double) (this.m.random() * 4.0F * this.speed / (float) (this.cd).swits[this.cn][2] - 2.0F * this.speed / (float) (this.cd).swits[this.cn][2]) * ((double) (this.cd).bounce[this.cn] - 0.3));
        }
        if (this.hitmag >= (this.cd).maxmag[this.cn] && !this.dest) {
            distruct(conto);
            if (this.cntdest == 7)
                this.dest = true;
            else
                this.cntdest++;
            if (this.cntdest == 1)
                (this.rpd).dest[this.im] = 300;
        }
        if ((conto).dist == 0) {
            for (int i_88_ = 0; i_88_ < (conto).npl; i_88_++) {
                if (((conto).p[i_88_]).chip != 0)
                    ((conto).p[i_88_]).chip = 0;
                if (((conto).p[i_88_]).embos != 0)
                    ((conto).p[i_88_]).embos = 13;
            }
        }
        int i_89_ = 0;
        int i_90_ = 0;
        int i_91_ = 0;
        if (this.nofocus)
            i_4_ = 1;
        else
            i_4_ = 7;
        for (int i_92_ = 0; i_92_ < (checkpoints).n; i_92_++) {
            if ((checkpoints).typ[i_92_] > 0) {
                i_91_++;
                if ((checkpoints).typ[i_92_] == 1) {
                    if (this.clear == i_91_ + this.nlaps * (checkpoints).nsp)
                        i_4_ = 1;
                    if ((float) Math.abs((conto).z - (checkpoints).z[i_92_]) < 60.0F + Math.abs(this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F && Math.abs((conto).x - (checkpoints).x[i_92_]) < 700 && Math.abs((conto).y - (checkpoints).y[i_92_] + 350) < 450 && this.clear == i_91_ + this.nlaps * (checkpoints).nsp - 1) {
                        this.clear = i_91_ + this.nlaps * (checkpoints).nsp;
                        this.pcleared = i_92_;
                        this.focus = -1;
                    }
                }
                if ((checkpoints).typ[i_92_] == 2) {
                    if (this.clear == i_91_ + this.nlaps * (checkpoints).nsp)
                        i_4_ = 1;
                    if ((float) Math.abs((conto).x - (checkpoints).x[i_92_]) < 60.0F + Math.abs(this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F && Math.abs((conto).z - (checkpoints).z[i_92_]) < 700 && Math.abs((conto).y - (checkpoints).y[i_92_] + 350) < 450 && this.clear == i_91_ + this.nlaps * (checkpoints).nsp - 1) {
                        this.clear = i_91_ + this.nlaps * (checkpoints).nsp;
                        this.pcleared = i_92_;
                        this.focus = -1;
                    }
                }
            }
            if (py((conto).x / 100, (checkpoints).x[i_92_] / 100, (conto).z / 100, (checkpoints).z[i_92_] / 100) * i_4_ < i_90_ || i_90_ == 0) {
                i_89_ = i_92_;
                i_90_ = py((conto).x / 100, (checkpoints).x[i_92_] / 100, (conto).z / 100, (checkpoints).z[i_92_] / 100) * i_4_;
            }
        }
        if (this.clear == i_91_ + this.nlaps * (checkpoints).nsp)
            this.nlaps++;
        if (this.im == (this.xt).im) {
            for ((this.m).checkpoint = this.clear; (this.m).checkpoint >= (checkpoints).nsp; (this.m).checkpoint -= (checkpoints).nsp) {
                /* empty */
            }
            if (this.clear == (checkpoints).nlaps * (checkpoints).nsp - 1)
                (this.m).lastcheck = true;
            if ((checkpoints).haltall)
                (this.m).lastcheck = false;
        }
        if (this.focus == -1) {
            if (this.im == (this.xt).im)
                i_89_ += 2;
            else
                i_89_++;
            if (!this.nofocus) {
                i_91_ = this.pcleared + 1;
                if (i_91_ >= (checkpoints).n)
                    i_91_ = 0;
                while ((checkpoints).typ[i_91_] <= 0) {
                    if (++i_91_ >= (checkpoints).n)
                        i_91_ = 0;
                }
                if (i_89_ > i_91_ && (this.clear != this.nlaps * (checkpoints).nsp || i_89_ < this.pcleared)) {
                    i_89_ = i_91_;
                    this.focus = i_89_;
                }
            }
            if (i_89_ >= (checkpoints).n)
                i_89_ -= (checkpoints).n;
            if ((checkpoints).typ[i_89_] == -3)
                i_89_ = 0;
            if (this.im == (this.xt).im) {
                if (this.missedcp != -1)
                    this.missedcp = -1;
            } else if (this.missedcp != 0)
                this.missedcp = 0;
        } else {
            i_89_ = this.focus;
            if (this.im == (this.xt).im) {
                if (this.missedcp == 0 && this.mtouch && Math.sqrt((double) py((conto).x / 10, (checkpoints).x[this.focus] / 10, (conto).z / 10, (checkpoints).z[this.focus] / 10)) > 800.0)
                    this.missedcp = 1;
                if (this.missedcp == -2 && Math.sqrt((double) py((conto).x / 10, (checkpoints).x[this.focus] / 10, (conto).z / 10, (checkpoints).z[this.focus] / 10)) < 400.0)
                    this.missedcp = 0;
                if (this.missedcp != 0 && this.mtouch && Math.sqrt((double) py((conto).x / 10, (checkpoints).x[this.focus] / 10, (conto).z / 10, (checkpoints).z[this.focus] / 10)) < 250.0)
                    this.missedcp = 68;
            } else
                this.missedcp = 1;
            if (this.nofocus) {
                this.focus = -1;
                this.missedcp = 0;
            }
        }
        if (this.nofocus)
            this.nofocus = false;
        this.point = i_89_;
        if (this.fixes != 0) {
            if ((this.m).noelec == 0) {
                for (int i_93_ = 0; i_93_ < (checkpoints).fn; i_93_++) {
                    if (!(checkpoints).roted[i_93_]) {
                        if (Math.abs((conto).z - (checkpoints).fz[i_93_]) < 200 && py((conto).x / 100, (checkpoints).fx[i_93_] / 100, (conto).y / 100, (checkpoints).fy[i_93_] / 100) < 30) {
                            if ((conto).dist == 0)
                                (conto).fcnt = 8;
                            else {
                                if (this.im == (this.xt).im && !(conto).fix && !(this.xt).mutes)
                                    (this.xt).carfixed.play();
                                (conto).fix = true;
                            }
                            (this.rpd).fix[this.im] = 300;
                        }
                    } else if (Math.abs((conto).x - (checkpoints).fx[i_93_]) < 200 && py((conto).z / 100, (checkpoints).fz[i_93_] / 100, (conto).y / 100, (checkpoints).fy[i_93_] / 100) < 30) {
                        if ((conto).dist == 0)
                            (conto).fcnt = 8;
                        else {
                            if (this.im == (this.xt).im && !(conto).fix && !(this.xt).mutes)
                                (this.xt).carfixed.play();
                            (conto).fix = true;
                        }
                        (this.rpd).fix[this.im] = 300;
                    }
                }
            }
        } else {
            for (int i_94_ = 0; i_94_ < (checkpoints).fn; i_94_++) {
                if (rpy((float) ((conto).x / 100), (float) ((checkpoints).fx[i_94_] / 100), (float) ((conto).y / 100), (float) ((checkpoints).fy[i_94_] / 100), (float) ((conto).z / 100), (float) ((checkpoints).fz[i_94_] / 100)) < 760)
                    (this.m).noelec = 2;
            }
        }
        if ((conto).fcnt == 7 || (conto).fcnt == 8) {
            this.squash = 0;
            this.nbsq = 0;
            this.hitmag = 0;
            this.cntdest = 0;
            this.dest = false;
            this.newcar = true;
            (conto).fcnt = 9;
            if (this.fixes > 0)
                this.fixes--;
        }
        if (this.newedcar != 0) {
            this.newedcar--;
            if (this.newedcar == 10)
                this.newcar = false;
        }
        if (!this.mtouch) {
            if (this.trcnt != 1) {
                this.trcnt = 1;
                this.lxz = (conto).xz;
            }
            if (this.loop == 2 || this.loop == -1) {
                this.travxy += this.rcomp - this.lcomp;
                if (Math.abs(this.travxy) > 135)
                    this.rtab = true;
                this.travzy += this.ucomp - this.dcomp;
                if (this.travzy > 135)
                    this.ftab = true;
                if (this.travzy < -135)
                    this.btab = true;
            }
            if (this.lxz != (conto).xz) {
                this.travxz += this.lxz - (conto).xz;
                this.lxz = (conto).xz;
            }
            if (this.srfcnt < 10) {
                if ((control).wall != -1)
                    this.surfer = true;
                this.srfcnt++;
            }
        } else if (!this.dest) {
            if (!this.capsized) {
                if (this.capcnt != 0)
                    this.capcnt = 0;
                if (this.gtouch && this.trcnt != 0) {
                    if (this.trcnt == 9) {
                        this.powerup = 0.0F;
                        if (Math.abs(this.travxy) > 90)
                            this.powerup += (float) Math.abs(this.travxy) / 24.0F;
                        else if (this.rtab)
                            this.powerup += 30.0F;
                        if (Math.abs(this.travzy) > 90)
                            this.powerup += (float) Math.abs(this.travzy) / 18.0F;
                        else {
                            if (this.ftab)
                                this.powerup += 40.0F;
                            if (this.btab)
                                this.powerup += 40.0F;
                        }
                        if (Math.abs(this.travxz) > 90)
                            this.powerup += (float) Math.abs(this.travxz) / 18.0F;
                        if (this.surfer)
                            this.powerup += 30.0F;
                        this.power += this.powerup;
                        if (this.im == (this.xt).im && (int) this.powerup > (this.rpd).powered && (this.rpd).wasted == 0 && (this.powerup > 60.0F || (checkpoints).stage == 1 || (checkpoints).stage == 2)) {
                            this.rpdcatch = 30;
                            if ((this.rpd).hcaught)
                                (this.rpd).powered = (int) this.powerup;
                        }
                        if (this.power > 98.0F) {
                            this.power = 98.0F;
                            if (this.powerup > 150.0F)
                                this.xtpower = 200;
                            else
                                this.xtpower = 100;
                        }
                    }
                    if (this.trcnt == 10) {
                        this.travxy = 0;
                        this.travzy = 0;
                        this.travxz = 0;
                        this.ftab = false;
                        this.rtab = false;
                        this.btab = false;
                        this.trcnt = 0;
                        this.srfcnt = 0;
                        this.surfer = false;
                    } else
                        this.trcnt++;
                }
            } else {
                if (this.trcnt != 0) {
                    this.travxy = 0;
                    this.travzy = 0;
                    this.travxz = 0;
                    this.ftab = false;
                    this.rtab = false;
                    this.btab = false;
                    this.trcnt = 0;
                    this.srfcnt = 0;
                    this.surfer = false;
                }
                if (this.capcnt == 0) {
                    int i_95_ = 0;
                    for (int i_96_ = 0; i_96_ < 4; i_96_++) {
                        if (Math.abs(this.scz[i_96_]) < 70.0F && Math.abs(this.scx[i_96_]) < 70.0F)
                            i_95_++;
                    }
                    if (i_95_ == 4)
                        this.capcnt = 1;
                } else {
                    this.capcnt++;
                    if (this.capcnt == 30) {
                        this.speed = 0.0F;
                        (conto).y += (this.cd).flipy[this.cn];
                        this.pxy += 180;
                        (conto).xy += 180;
                        this.capcnt = 0;
                    }
                }
            }
            if (this.trcnt == 0 && this.speed != 0.0F) {
                if (this.xtpower == 0) {
                    if (this.power > 0.0F)
                        this.power -= this.power * this.power * this.power / (float) (this.cd).powerloss[this.cn];
                    else
                        this.power = 0.0F;
                } else
                    this.xtpower--;
            }
        }
        if (this.im == (this.xt).im) {
            if ((control).wall != -1)
                (control).wall = -1;
        } else if (this.lastcolido != 0 && !this.dest)
            this.lastcolido--;
        if (this.dest) {
            if ((checkpoints).dested[this.im] == 0) {
                if (this.lastcolido == 0)
                    (checkpoints).dested[this.im] = 1;
                else
                    (checkpoints).dested[this.im] = 2;
            }
        } else if ((checkpoints).dested[this.im] != 0 && (checkpoints).dested[this.im] != 3)
            (checkpoints).dested[this.im] = 0;
        if (this.im == (this.xt).im && (this.rpd).wasted == 0 && this.rpdcatch != 0) {
            this.rpdcatch--;
            if (this.rpdcatch == 0) {
                this.rpd.cotchinow(this.im);
                if ((this.rpd).hcaught)
                    (this.rpd).whenwasted = (int) (185.0F + this.m.random() * 20.0F);
            }
        }
    }
    
    public void distruct(ContO conto) {
        for (int i = 0; i < (conto).npl; i++) {
            if (((conto).p[i]).wz == 0 || ((conto).p[i]).gr == -17 || ((conto).p[i]).gr == -16)
                ((conto).p[i]).embos = 1;
        }
    }
    
    public void regy(int i, float f, ContO conto) {
        boolean bool = true;
        if ((this.xt).multion == 1 && (this.xt).im != this.im)
            bool = false;
        if ((this.xt).multion >= 2)
            bool = false;
        if ((this.xt).lan && (this.xt).multion >= 1 && (this.xt).isbot[this.im])
            bool = true;
        f *= (this.cd).dammult[this.cn];
        if (f > 100.0F) {
            this.rpd.recy(i, f, this.mtouch, this.im);
            f -= 100.0F;
            int i_97_ = 0;
            int i_98_ = 0;
            int i_99_ = (conto).zy;
            int i_100_ = (conto).xy;
            for (/**/; i_99_ < 360; i_99_ += 360) {
                /* empty */
            }
            for (/**/; i_99_ > 360; i_99_ -= 360) {
                /* empty */
            }
            if (i_99_ < 210 && i_99_ > 150)
                i_97_ = -1;
            if (i_99_ > 330 || i_99_ < 30)
                i_97_ = 1;
            for (/**/; i_100_ < 360; i_100_ += 360) {
                /* empty */
            }
            for (/**/; i_100_ > 360; i_100_ -= 360) {
                /* empty */
            }
            if (i_100_ < 210 && i_100_ > 150)
                i_98_ = -1;
            if (i_100_ > 330 || i_100_ < 30)
                i_98_ = 1;
            if (this.im == (this.xt).im || this.colidim)
                this.xt.crash(f, i_98_ * i_97_);
            if (i_98_ * i_97_ == 0 || this.mtouch) {
                for (int i_101_ = 0; i_101_ < (conto).npl; i_101_++) {
                    float f_102_ = 0.0F;
                    for (int i_103_ = 0; i_103_ < ((conto).p[i_101_]).n; i_103_++) {
                        if (((conto).p[i_101_]).wz == 0 && py((conto).keyx[i], ((conto).p[i_101_]).ox[i_103_], (conto).keyz[i], ((conto).p[i_101_]).oz[i_103_]) < (this.cd).clrad[this.cn]) {
                            f_102_ = f / 20.0F * this.m.random();
                            ((conto).p[i_101_]).oz[i_103_] += f_102_ * this.m.sin(i_99_);
                            ((conto).p[i_101_]).ox[i_103_] -= f_102_ * this.m.sin(i_100_);
                            if (bool)
                                this.hitmag += Math.abs(f_102_);
                        }
                    }
                    if (f_102_ != 0.0F) {
                        if (Math.abs(f_102_) >= 1.0F) {
                            ((conto).p[i_101_]).chip = 1;
                            ((conto).p[i_101_]).ctmag = f_102_;
                        }
                        if (!((conto).p[i_101_]).nocol && ((conto).p[i_101_]).glass != 1) {
                            if (((conto).p[i_101_]).bfase > 20 && (double) ((conto).p[i_101_]).hsb[1] > 0.25)
                                ((conto).p[i_101_]).hsb[1] = 0.25F;
                            if (((conto).p[i_101_]).bfase > 25 && (double) ((conto).p[i_101_]).hsb[2] > 0.7)
                                ((conto).p[i_101_]).hsb[2] = 0.7F;
                            if (((conto).p[i_101_]).bfase > 30 && (double) ((conto).p[i_101_]).hsb[1] > 0.15)
                                ((conto).p[i_101_]).hsb[1] = 0.15F;
                            if (((conto).p[i_101_]).bfase > 35 && (double) ((conto).p[i_101_]).hsb[2] > 0.6)
                                ((conto).p[i_101_]).hsb[2] = 0.6F;
                            if (((conto).p[i_101_]).bfase > 40)
                                ((conto).p[i_101_]).hsb[0] = 0.075F;
                            if (((conto).p[i_101_]).bfase > 50 && (double) ((conto).p[i_101_]).hsb[2] > 0.5)
                                ((conto).p[i_101_]).hsb[2] = 0.5F;
                            if (((conto).p[i_101_]).bfase > 60)
                                ((conto).p[i_101_]).hsb[0] = 0.05F;
                            ((conto).p[i_101_]).bfase += f_102_;
                            new Color(((conto).p[i_101_]).c[0], ((conto).p[i_101_]).c[1], ((conto).p[i_101_]).c[2]);
                            Color color = Color.getHSBColor(((conto).p[i_101_]).hsb[0], ((conto).p[i_101_]).hsb[1], ((conto).p[i_101_]).hsb[2]);
                            ((conto).p[i_101_]).c[0] = color.getRed();
                            ((conto).p[i_101_]).c[1] = color.getGreen();
                            ((conto).p[i_101_]).c[2] = color.getBlue();
                        }
                        if (((conto).p[i_101_]).glass == 1)
                            ((conto).p[i_101_]).gr += Math.abs((double) f_102_ * 1.5);
                    }
                }
            }
            if (i_98_ * i_97_ == -1) {
                if (this.nbsq > 0) {
                    int i_104_ = 0;
                    int i_105_ = 1;
                    for (int i_106_ = 0; i_106_ < (conto).npl; i_106_++) {
                        float f_107_ = 0.0F;
                        for (int i_108_ = 0; i_108_ < ((conto).p[i_106_]).n; i_108_++) {
                            if (((conto).p[i_106_]).wz == 0) {
                                f_107_ = f / 15.0F * this.m.random();
                                if ((Math.abs(((conto).p[i_106_]).oy[i_108_] - (this.cd).flipy[this.cn] - this.squash) < (this.cd).msquash[this.cn] * 3 || ((conto).p[i_106_]).oy[i_108_] < (this.cd).flipy[this.cn] + this.squash) && this.squash < (this.cd).msquash[this.cn]) {
                                    ((conto).p[i_106_]).oy[i_108_] += f_107_;
                                    i_104_ += f_107_;
                                    i_105_++;
                                    if (bool)
                                        this.hitmag += Math.abs(f_107_);
                                }
                            }
                        }
                        if (((conto).p[i_106_]).glass == 1)
                            ((conto).p[i_106_]).gr += 5;
                        else if (f_107_ != 0.0F)
                            ((conto).p[i_106_]).bfase += f_107_;
                        if (Math.abs(f_107_) >= 1.0F) {
                            ((conto).p[i_106_]).chip = 1;
                            ((conto).p[i_106_]).ctmag = f_107_;
                        }
                    }
                    this.squash += i_104_ / i_105_;
                    this.nbsq = 0;
                } else
                    this.nbsq++;
            }
        }
    }
    
    public void regx(int i, float f, ContO conto) {
        boolean bool = true;
        if ((this.xt).multion == 1 && (this.xt).im != this.im)
            bool = false;
        if ((this.xt).multion >= 2)
            bool = false;
        if ((this.xt).lan && (this.xt).multion >= 1 && (this.xt).isbot[this.im])
            bool = true;
        f *= (this.cd).dammult[this.cn];
        if (Math.abs(f) > 100.0F) {
            this.rpd.recx(i, f, this.im);
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            if (this.im == (this.xt).im || this.colidim)
                this.xt.crash(f, 0);
            for (int i_109_ = 0; i_109_ < (conto).npl; i_109_++) {
                float f_110_ = 0.0F;
                for (int i_111_ = 0; i_111_ < ((conto).p[i_109_]).n; i_111_++) {
                    if (((conto).p[i_109_]).wz == 0 && py((conto).keyx[i], ((conto).p[i_109_]).ox[i_111_], (conto).keyz[i], ((conto).p[i_109_]).oz[i_111_]) < (this.cd).clrad[this.cn]) {
                        f_110_ = f / 20.0F * this.m.random();
                        ((conto).p[i_109_]).oz[i_111_] -= f_110_ * this.m.sin((conto).xz) * this.m.cos((conto).zy);
                        ((conto).p[i_109_]).ox[i_111_] += f_110_ * this.m.cos((conto).xz) * this.m.cos((conto).xy);
                        if (bool)
                            this.hitmag += Math.abs(f_110_);
                    }
                }
                if (f_110_ != 0.0F) {
                    if (Math.abs(f_110_) >= 1.0F) {
                        ((conto).p[i_109_]).chip = 1;
                        ((conto).p[i_109_]).ctmag = f_110_;
                    }
                    if (!((conto).p[i_109_]).nocol && ((conto).p[i_109_]).glass != 1) {
                        if (((conto).p[i_109_]).bfase > 20 && (double) ((conto).p[i_109_]).hsb[1] > 0.25)
                            ((conto).p[i_109_]).hsb[1] = 0.25F;
                        if (((conto).p[i_109_]).bfase > 25 && (double) ((conto).p[i_109_]).hsb[2] > 0.7)
                            ((conto).p[i_109_]).hsb[2] = 0.7F;
                        if (((conto).p[i_109_]).bfase > 30 && (double) ((conto).p[i_109_]).hsb[1] > 0.15)
                            ((conto).p[i_109_]).hsb[1] = 0.15F;
                        if (((conto).p[i_109_]).bfase > 35 && (double) ((conto).p[i_109_]).hsb[2] > 0.6)
                            ((conto).p[i_109_]).hsb[2] = 0.6F;
                        if (((conto).p[i_109_]).bfase > 40)
                            ((conto).p[i_109_]).hsb[0] = 0.075F;
                        if (((conto).p[i_109_]).bfase > 50 && (double) ((conto).p[i_109_]).hsb[2] > 0.5)
                            ((conto).p[i_109_]).hsb[2] = 0.5F;
                        if (((conto).p[i_109_]).bfase > 60)
                            ((conto).p[i_109_]).hsb[0] = 0.05F;
                        ((conto).p[i_109_]).bfase += Math.abs(f_110_);
                        new Color(((conto).p[i_109_]).c[0], ((conto).p[i_109_]).c[1], ((conto).p[i_109_]).c[2]);
                        Color color = Color.getHSBColor(((conto).p[i_109_]).hsb[0], ((conto).p[i_109_]).hsb[1], ((conto).p[i_109_]).hsb[2]);
                        ((conto).p[i_109_]).c[0] = color.getRed();
                        ((conto).p[i_109_]).c[1] = color.getGreen();
                        ((conto).p[i_109_]).c[2] = color.getBlue();
                    }
                    if (((conto).p[i_109_]).glass == 1)
                        ((conto).p[i_109_]).gr += Math.abs((double) f_110_ * 1.5);
                }
            }
        }
    }
    
    public void regz(int i, float f, ContO conto) {
        boolean bool = true;
        if ((this.xt).multion == 1 && (this.xt).im != this.im)
            bool = false;
        if ((this.xt).multion >= 2)
            bool = false;
        if ((this.xt).lan && (this.xt).multion >= 1 && (this.xt).isbot[this.im])
            bool = true;
        f *= (this.cd).dammult[this.cn];
        if (Math.abs(f) > 100.0F) {
            this.rpd.recz(i, f, this.im);
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            if (this.im == (this.xt).im || this.colidim)
                this.xt.crash(f, 0);
            for (int i_112_ = 0; i_112_ < (conto).npl; i_112_++) {
                float f_113_ = 0.0F;
                for (int i_114_ = 0; i_114_ < ((conto).p[i_112_]).n; i_114_++) {
                    if (((conto).p[i_112_]).wz == 0 && py((conto).keyx[i], ((conto).p[i_112_]).ox[i_114_], (conto).keyz[i], ((conto).p[i_112_]).oz[i_114_]) < (this.cd).clrad[this.cn]) {
                        f_113_ = f / 20.0F * this.m.random();
                        ((conto).p[i_112_]).oz[i_114_] += f_113_ * this.m.cos((conto).xz) * this.m.cos((conto).zy);
                        ((conto).p[i_112_]).ox[i_114_] += f_113_ * this.m.sin((conto).xz) * this.m.cos((conto).xy);
                        if (bool)
                            this.hitmag += Math.abs(f_113_);
                    }
                }
                if (f_113_ != 0.0F) {
                    if (Math.abs(f_113_) >= 1.0F) {
                        ((conto).p[i_112_]).chip = 1;
                        ((conto).p[i_112_]).ctmag = f_113_;
                    }
                    if (!((conto).p[i_112_]).nocol && ((conto).p[i_112_]).glass != 1) {
                        if (((conto).p[i_112_]).bfase > 20 && (double) ((conto).p[i_112_]).hsb[1] > 0.25)
                            ((conto).p[i_112_]).hsb[1] = 0.25F;
                        if (((conto).p[i_112_]).bfase > 25 && (double) ((conto).p[i_112_]).hsb[2] > 0.7)
                            ((conto).p[i_112_]).hsb[2] = 0.7F;
                        if (((conto).p[i_112_]).bfase > 30 && (double) ((conto).p[i_112_]).hsb[1] > 0.15)
                            ((conto).p[i_112_]).hsb[1] = 0.15F;
                        if (((conto).p[i_112_]).bfase > 35 && (double) ((conto).p[i_112_]).hsb[2] > 0.6)
                            ((conto).p[i_112_]).hsb[2] = 0.6F;
                        if (((conto).p[i_112_]).bfase > 40)
                            ((conto).p[i_112_]).hsb[0] = 0.075F;
                        if (((conto).p[i_112_]).bfase > 50 && (double) ((conto).p[i_112_]).hsb[2] > 0.5)
                            ((conto).p[i_112_]).hsb[2] = 0.5F;
                        if (((conto).p[i_112_]).bfase > 60)
                            ((conto).p[i_112_]).hsb[0] = 0.05F;
                        ((conto).p[i_112_]).bfase += Math.abs(f_113_);
                        new Color(((conto).p[i_112_]).c[0], ((conto).p[i_112_]).c[1], ((conto).p[i_112_]).c[2]);
                        Color color = Color.getHSBColor(((conto).p[i_112_]).hsb[0], ((conto).p[i_112_]).hsb[1], ((conto).p[i_112_]).hsb[2]);
                        ((conto).p[i_112_]).c[0] = color.getRed();
                        ((conto).p[i_112_]).c[1] = color.getGreen();
                        ((conto).p[i_112_]).c[2] = color.getBlue();
                    }
                    if (((conto).p[i_112_]).glass == 1)
                        ((conto).p[i_112_]).gr += Math.abs((double) f_113_ * 1.5);
                }
            }
        }
    }
    
    public void colide(ContO conto, Mad mad_115_, ContO conto_116_) {
        float[] fs = new float[4];
        float[] fs_117_ = new float[4];
        float[] fs_118_ = new float[4];
        float[] fs_119_ = new float[4];
        float[] fs_120_ = new float[4];
        float[] fs_121_ = new float[4];
        for (int i = 0; i < 4; i++) {
            fs[i] = (float) ((conto).x + (conto).keyx[i]);
            if (this.capsized)
                fs_117_[i] = (float) ((conto).y + (this.cd).flipy[this.cn] + this.squash);
            else
                fs_117_[i] = (float) ((conto).y + (conto).grat);
            fs_118_[i] = (float) ((conto).z + (conto).keyz[i]);
            fs_119_[i] = (float) ((conto_116_).x + (conto_116_).keyx[i]);
            if (this.capsized)
                fs_120_[i] = (float) ((conto_116_).y + (this.cd).flipy[(mad_115_).cn] + (mad_115_).squash);
            else
                fs_120_[i] = (float) ((conto_116_).y + (conto_116_).grat);
            fs_121_[i] = (float) ((conto_116_).z + (conto_116_).keyz[i]);
        }
        rot(fs, fs_117_, (conto).x, (conto).y, (conto).xy, 4);
        rot(fs_117_, fs_118_, (conto).y, (conto).z, (conto).zy, 4);
        rot(fs, fs_118_, (conto).x, (conto).z, (conto).xz, 4);
        rot(fs_119_, fs_120_, (conto_116_).x, (conto_116_).y, (conto_116_).xy, 4);
        rot(fs_120_, fs_121_, (conto_116_).y, (conto_116_).z, (conto_116_).zy, 4);
        rot(fs_119_, fs_121_, (conto_116_).x, (conto_116_).z, (conto_116_).xz, 4);
        if ((double) rpy((float) (conto).x, (float) (conto_116_).x, (float) (conto).y, (float) (conto_116_).y, (float) (conto).z, (float) (conto_116_).z) < (double) ((conto).maxR * (conto).maxR + (conto_116_).maxR * (conto_116_).maxR) * 1.5) {
            if (!this.caught[(mad_115_).im] && (this.speed != 0.0F || (mad_115_).speed != 0.0F)) {
                if (Math.abs(this.power * this.speed * (this.cd).moment[this.cn]) != Math.abs((mad_115_).power * (mad_115_).speed * (this.cd).moment[(mad_115_).cn])) {
                    if (Math.abs(this.power * this.speed * (this.cd).moment[this.cn]) > Math.abs((mad_115_).power * (mad_115_).speed * (this.cd).moment[(mad_115_).cn]))
                        this.dominate[(mad_115_).im] = true;
                    else
                        this.dominate[(mad_115_).im] = false;
                } else if ((this.cd).moment[this.cn] > (this.cd).moment[(mad_115_).cn])
                    this.dominate[(mad_115_).im] = true;
                else
                    this.dominate[(mad_115_).im] = false;
                this.caught[(mad_115_).im] = true;
            }
        } else if (this.caught[(mad_115_).im])
            this.caught[(mad_115_).im] = false;
        if (this.dominate[(mad_115_).im]) {
            int i = (int) (((this.scz[0] - (mad_115_).scz[0] + this.scz[1] - (mad_115_).scz[1] + this.scz[2] - (mad_115_).scz[2] + this.scz[3] - (mad_115_).scz[3]) * (this.scz[0] - (mad_115_).scz[0] + this.scz[1] - (mad_115_).scz[1] + this.scz[2] - (mad_115_).scz[2] + this.scz[3] - (mad_115_).scz[3]) + (this.scx[0] - (mad_115_).scx[0] + this.scx[1] - (mad_115_).scx[1] + this.scx[2] - (mad_115_).scx[2] + this.scx[3] - (mad_115_).scx[3]) * (this.scx[0] - (mad_115_).scx[0] + this.scx[1] - (mad_115_).scx[1] + this.scx[2] - (mad_115_).scx[2] + this.scx[3] - (mad_115_).scx[3])) / 16.0F);
            int i_122_ = 7000;
            float f = 1.0F;
            if ((this.xt).multion != 0) {
                i_122_ = 28000;
                f = 1.27F;
            }
            for (int i_123_ = 0; i_123_ < 4; i_123_++) {
                for (int i_124_ = 0; i_124_ < 4; i_124_++) {
                    if ((float) rpy(fs[i_123_], fs_119_[i_124_], fs_117_[i_123_], fs_120_[i_124_], fs_118_[i_123_], fs_121_[i_124_]) < (float) (i + i_122_) * ((this.cd).comprad[(mad_115_).cn] + (this.cd).comprad[this.cn])) {
                        if (Math.abs(this.scx[i_123_] * (this.cd).moment[this.cn]) > Math.abs((mad_115_).scx[i_124_] * (this.cd).moment[(mad_115_).cn])) {
                            float f_125_ = (mad_115_).scx[i_124_] * (float) (this.cd).revpush[this.cn];
                            if (f_125_ > 300.0F)
                                f_125_ = 300.0F;
                            if (f_125_ < -300.0F)
                                f_125_ = -300.0F;
                            float f_126_ = this.scx[i_123_] * (float) (this.cd).push[this.cn];
                            if (f_126_ > 300.0F)
                                f_126_ = 300.0F;
                            if (f_126_ < -300.0F)
                                f_126_ = -300.0F;
                            (mad_115_).scx[i_124_] += f_126_;
                            if (this.im == (this.xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regx(i_124_, f_126_ * (this.cd).moment[this.cn] * f, conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            this.scx[i_123_] -= f_125_;
                            regx(i_123_, -f_125_ * (this.cd).moment[this.cn] * f, conto);
                            this.scy[i_123_] -= (float) (this.cd).revlift[this.cn];
                            if (this.im == (this.xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regy(i_124_, (float) ((this.cd).revlift[this.cn] * 7), conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            if (this.m.random() > this.m.random())
                                conto_116_.sprk((fs[i_123_] + fs_119_[i_124_]) / 2.0F, (fs_117_[i_123_] + fs_120_[i_124_]) / 2.0F, (fs_118_[i_123_] + fs_121_[i_124_]) / 2.0F, ((mad_115_).scx[i_124_] + this.scx[i_123_]) / 4.0F, ((mad_115_).scy[i_124_] + this.scy[i_123_]) / 4.0F, ((mad_115_).scz[i_124_] + this.scz[i_123_]) / 4.0F, 2);
                        }
                        if (Math.abs(this.scz[i_123_] * (this.cd).moment[this.cn]) > Math.abs((mad_115_).scz[i_124_] * (this.cd).moment[(mad_115_).cn])) {
                            float f_127_ = (mad_115_).scz[i_124_] * (float) (this.cd).revpush[this.cn];
                            if (f_127_ > 300.0F)
                                f_127_ = 300.0F;
                            if (f_127_ < -300.0F)
                                f_127_ = -300.0F;
                            float f_128_ = this.scz[i_123_] * (float) (this.cd).push[this.cn];
                            if (f_128_ > 300.0F)
                                f_128_ = 300.0F;
                            if (f_128_ < -300.0F)
                                f_128_ = -300.0F;
                            (mad_115_).scz[i_124_] += f_128_;
                            if (this.im == (this.xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regz(i_124_, f_128_ * (this.cd).moment[this.cn] * f, conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            this.scz[i_123_] -= f_127_;
                            regz(i_123_, -f_127_ * (this.cd).moment[this.cn] * f, conto);
                            this.scy[i_123_] -= (float) (this.cd).revlift[this.cn];
                            if (this.im == (this.xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regy(i_124_, (float) ((this.cd).revlift[this.cn] * 7), conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            if (this.m.random() > this.m.random())
                                conto_116_.sprk((fs[i_123_] + fs_119_[i_124_]) / 2.0F, (fs_117_[i_123_] + fs_120_[i_124_]) / 2.0F, (fs_118_[i_123_] + fs_121_[i_124_]) / 2.0F, ((mad_115_).scx[i_124_] + this.scx[i_123_]) / 4.0F, ((mad_115_).scy[i_124_] + this.scy[i_123_]) / 4.0F, ((mad_115_).scz[i_124_] + this.scz[i_123_]) / 4.0F, 2);
                        }
                        if (this.im == (this.xt).im)
                            (mad_115_).lastcolido = 70;
                        if ((mad_115_).im == (this.xt).im)
                            this.lastcolido = 70;
                        (mad_115_).scy[i_124_] -= (float) (this.cd).lift[this.cn];
                    }
                }
            }
        }
    }
    
    public void rot(float[] fs, float[] fs_129_, int i, int i_130_, int i_131_, int i_132_) {
        if (i_131_ != 0) {
            for (int i_133_ = 0; i_133_ < i_132_; i_133_++) {
                float f = fs[i_133_];
                float f_134_ = fs_129_[i_133_];
                fs[i_133_] = (float) i + ((f - (float) i) * this.m.cos(i_131_) - (f_134_ - (float) i_130_) * this.m.sin(i_131_));
                fs_129_[i_133_] = (float) i_130_ + ((f - (float) i) * this.m.sin(i_131_) + (f_134_ - (float) i_130_) * this.m.cos(i_131_));
            }
        }
    }
    
    public int rpy(float f, float f_135_, float f_136_, float f_137_, float f_138_, float f_139_) {
        return (int) ((f - f_135_) * (f - f_135_) + (f_136_ - f_137_) * (f_136_ - f_137_) + (f_138_ - f_139_) * (f_138_ - f_139_));
    }
    
    public int py(int i, int i_140_, int i_141_, int i_142_) {
        return (i - i_140_) * (i - i_140_) + (i_141_ - i_142_) * (i_141_ - i_142_);
    }
}
