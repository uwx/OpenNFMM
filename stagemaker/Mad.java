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
        cd = cardefine;
        m = medium;
        rpd = record;
        xt = var_xtGraphics;
        im = i;
    }
    
    public void reseto(int i, ContO conto, CheckPoints checkpoints) {
        cn = i;
        for (int i_0_ = 0; i_0_ < 7; i_0_++) {
            dominate[i_0_] = false;
            caught[i_0_] = false;
        }
        mxz = 0;
        cxz = 0;
        pzy = 0;
        pxy = 0;
        speed = 0.0F;
        for (int i_1_ = 0; i_1_ < 4; i_1_++) {
            scy[i_1_] = 0.0F;
            scx[i_1_] = 0.0F;
            scz[i_1_] = 0.0F;
        }
        forca = ((float) Math.sqrt((double) ((conto).keyz[0] * (conto).keyz[0] + (conto).keyx[0] * (conto).keyx[0])) + (float) Math.sqrt((double) ((conto).keyz[1] * (conto).keyz[1] + (conto).keyx[1] * (conto).keyx[1])) + (float) Math.sqrt((double) ((conto).keyz[2] * (conto).keyz[2] + (conto).keyx[2] * (conto).keyx[2])) + (float) Math.sqrt((double) ((conto).keyz[3] * (conto).keyz[3] + (conto).keyx[3] * (conto).keyx[3]))) / 10000.0F * (float) ((double) (cd).bounce[cn] - 0.3);
        mtouch = false;
        wtouch = false;
        txz = 0;
        fxz = 0;
        pmlt = 1;
        nmlt = 1;
        dcnt = 0;
        skid = 0;
        pushed = false;
        gtouch = false;
        pl = false;
        pr = false;
        pd = false;
        pu = false;
        loop = 0;
        ucomp = 0.0F;
        dcomp = 0.0F;
        lcomp = 0.0F;
        rcomp = 0.0F;
        lxz = 0;
        travxy = 0;
        travzy = 0;
        travxz = 0;
        rtab = false;
        ftab = false;
        btab = false;
        powerup = 0.0F;
        xtpower = 0;
        trcnt = 0;
        capcnt = 0;
        tilt = 0.0F;
        for (int i_2_ = 0; i_2_ < 4; i_2_++) {
            for (int i_3_ = 0; i_3_ < 4; i_3_++) {
                crank[i_2_][i_3_] = 0;
                lcrank[i_2_][i_3_] = 0;
            }
        }
        pan = 0;
        pcleared = (checkpoints).pcs;
        clear = 0;
        nlaps = 0;
        focus = -1;
        missedcp = 0;
        nofocus = false;
        power = 98.0F;
        lastcolido = 0;
        (checkpoints).dested[im] = 0;
        squash = 0;
        nbsq = 0;
        hitmag = 0;
        cntdest = 0;
        dest = false;
        newcar = false;
        if (im == (xt).im) {
            (m).checkpoint = -1;
            (m).lastcheck = false;
        }
        rpdcatch = 0;
        newedcar = 0;
        fixes = -1;
        if ((checkpoints).nfix == 1)
            fixes = 4;
        if ((checkpoints).nfix == 2)
            fixes = 3;
        if ((checkpoints).nfix == 3)
            fixes = 2;
        if ((checkpoints).nfix == 4)
            fixes = 1;
    }
    
    public void drive(Control control, ContO conto, Trackers trackers, CheckPoints checkpoints) {
        int i = 1;
        int i_4_ = 1;
        boolean bool = false;
        boolean bool_5_ = false;
        boolean bool_6_ = false;
        capsized = false;
        int i_7_;
        for (i_7_ = Math.abs(pzy); i_7_ > 270; i_7_ -= 360) {
            /* empty */
        }
        i_7_ = Math.abs(i_7_);
        if (i_7_ > 90)
            bool = true;
        boolean bool_8_ = false;
        int i_9_;
        for (i_9_ = Math.abs(pxy); i_9_ > 270; i_9_ -= 360) {
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
                capsized = true;
            }
            i = -1;
        } else if (bool_8_)
            capsized = true;
        if (capsized)
            i_10_ = (cd).flipy[cn] + squash;
        (control).zyinv = bool;
        float f = 0.0F;
        float f_11_ = 0.0F;
        float f_12_ = 0.0F;
        if (mtouch)
            loop = 0;
        if (wtouch) {
            if (loop == 2 || loop == -1) {
                loop = -1;
                if ((control).left)
                    pl = true;
                if ((control).right)
                    pr = true;
                if ((control).up)
                    pu = true;
                if ((control).down)
                    pd = true;
            }
            ucomp = 0.0F;
            dcomp = 0.0F;
            lcomp = 0.0F;
            rcomp = 0.0F;
        }
        if ((control).handb) {
            if (!pushed) {
                if (!wtouch) {
                    if (loop == 0)
                        loop = 1;
                } else if (gtouch)
                    pushed = true;
            }
        } else
            pushed = false;
        if (loop == 1) {
            float f_13_ = (scy[0] + scy[1] + scy[2] + scy[3]) / 4.0F;
            for (int i_14_ = 0; i_14_ < 4; i_14_++)
                scy[i_14_] = f_13_;
            loop = 2;
        }
        if (!dest) {
            if (loop == 2) {
                if ((control).up) {
                    if (ucomp == 0.0F) {
                        ucomp = 10.0F + (scy[0] + 50.0F) / 20.0F;
                        if (ucomp < 5.0F)
                            ucomp = 5.0F;
                        if (ucomp > 10.0F)
                            ucomp = 10.0F;
                        ucomp *= (cd).airs[cn];
                    }
                    if (ucomp < 20.0F)
                        ucomp += 0.5 * (double) (cd).airs[cn];
                    f = (float) -(cd).airc[cn] * m.sin((conto).xz) * (float) i_4_;
                    f_11_ = (float) (cd).airc[cn] * m.cos((conto).xz) * (float) i_4_;
                } else if (ucomp != 0.0F && ucomp > -2.0F)
                    ucomp -= 0.5 * (double) (cd).airs[cn];
                if ((control).down) {
                    if (dcomp == 0.0F) {
                        dcomp = 10.0F + (scy[0] + 50.0F) / 20.0F;
                        if (dcomp < 5.0F)
                            dcomp = 5.0F;
                        if (dcomp > 10.0F)
                            dcomp = 10.0F;
                        dcomp *= (cd).airs[cn];
                    }
                    if (dcomp < 20.0F)
                        dcomp += 0.5 * (double) (cd).airs[cn];
                    f_12_ = (float) -(cd).airc[cn];
                } else if (dcomp != 0.0F && ucomp > -2.0F)
                    dcomp -= 0.5 * (double) (cd).airs[cn];
                if ((control).left) {
                    if (lcomp == 0.0F)
                        lcomp = 5.0F;
                    if (lcomp < 20.0F)
                        lcomp += 2.0F * (cd).airs[cn];
                    f = (float) -(cd).airc[cn] * m.cos((conto).xz) * (float) i;
                    f_11_ = (float) -(cd).airc[cn] * m.sin((conto).xz) * (float) i;
                } else if (lcomp > 0.0F)
                    lcomp -= 2.0F * (cd).airs[cn];
                if ((control).right) {
                    if (rcomp == 0.0F)
                        rcomp = 5.0F;
                    if (rcomp < 20.0F)
                        rcomp += 2.0F * (cd).airs[cn];
                    f = (float) (cd).airc[cn] * m.cos((conto).xz) * (float) i;
                    f_11_ = (float) (cd).airc[cn] * m.sin((conto).xz) * (float) i;
                } else if (rcomp > 0.0F)
                    rcomp -= 2.0F * (cd).airs[cn];
                pzy += (dcomp - ucomp) * m.cos(pxy);
                if (bool)
                    (conto).xz += (dcomp - ucomp) * m.sin(pxy);
                else
                    (conto).xz -= (dcomp - ucomp) * m.sin(pxy);
                pxy += rcomp - lcomp;
            } else {
                float f_15_ = power;
                if (f_15_ < 40.0F)
                    f_15_ = 40.0F;
                if ((control).down) {
                    if (speed > 0.0F)
                        speed -= (float) ((cd).handb[cn] / 2);
                    else {
                        int i_16_ = 0;
                        for (int i_17_ = 0; i_17_ < 2; i_17_++) {
                            if (speed <= -((float) ((cd).swits[cn][i_17_] / 2) + f_15_ * (float) (cd).swits[cn][i_17_] / 196.0F))
                                i_16_++;
                        }
                        if (i_16_ != 2)
                            speed -= (cd).acelf[cn][i_16_] / 2.0F + f_15_ * (cd).acelf[cn][i_16_] / 196.0F;
                        else
                            speed = -((float) ((cd).swits[cn][1] / 2) + f_15_ * (float) (cd).swits[cn][1] / 196.0F);
                    }
                }
                if ((control).up) {
                    if (speed < 0.0F)
                        speed += (float) (cd).handb[cn];
                    else {
                        int i_18_ = 0;
                        for (int i_19_ = 0; i_19_ < 3; i_19_++) {
                            if (speed >= (float) ((cd).swits[cn][i_19_] / 2) + f_15_ * (float) (cd).swits[cn][i_19_] / 196.0F)
                                i_18_++;
                        }
                        if (i_18_ != 3)
                            speed += (cd).acelf[cn][i_18_] / 2.0F + f_15_ * (cd).acelf[cn][i_18_] / 196.0F;
                        else
                            speed = (float) ((cd).swits[cn][2] / 2) + f_15_ * (float) (cd).swits[cn][2] / 196.0F;
                    }
                }
                if ((control).handb && Math.abs(speed) > (float) (cd).handb[cn]) {
                    if (speed < 0.0F)
                        speed += (float) (cd).handb[cn];
                    else
                        speed -= (float) (cd).handb[cn];
                }
                if (loop == -1 && (conto).y < 100) {
                    if ((control).left) {
                        if (!pl) {
                            if (lcomp == 0.0F)
                                lcomp = 5.0F * (cd).airs[cn];
                            if (lcomp < 20.0F)
                                lcomp += 2.0F * (cd).airs[cn];
                        }
                    } else {
                        if (lcomp > 0.0F)
                            lcomp -= 2.0F * (cd).airs[cn];
                        pl = false;
                    }
                    if ((control).right) {
                        if (!pr) {
                            if (rcomp == 0.0F)
                                rcomp = 5.0F * (cd).airs[cn];
                            if (rcomp < 20.0F)
                                rcomp += 2.0F * (cd).airs[cn];
                        }
                    } else {
                        if (rcomp > 0.0F)
                            rcomp -= 2.0F * (cd).airs[cn];
                        pr = false;
                    }
                    if ((control).up) {
                        if (!pu) {
                            if (ucomp == 0.0F)
                                ucomp = 5.0F * (cd).airs[cn];
                            if (ucomp < 20.0F)
                                ucomp += 2.0F * (cd).airs[cn];
                        }
                    } else {
                        if (ucomp > 0.0F)
                            ucomp -= 2.0F * (cd).airs[cn];
                        pu = false;
                    }
                    if ((control).down) {
                        if (!pd) {
                            if (dcomp == 0.0F)
                                dcomp = 5.0F * (cd).airs[cn];
                            if (dcomp < 20.0F)
                                dcomp += 2.0F * (cd).airs[cn];
                        }
                    } else {
                        if (dcomp > 0.0F)
                            dcomp -= 2.0F * (cd).airs[cn];
                        pd = false;
                    }
                    pzy += (dcomp - ucomp) * m.cos(pxy);
                    if (bool)
                        (conto).xz += (dcomp - ucomp) * m.sin(pxy);
                    else
                        (conto).xz -= (dcomp - ucomp) * m.sin(pxy);
                    pxy += rcomp - lcomp;
                }
            }
        }
        float f_20_ = 20.0F * speed / (154.0F * (cd).simag[cn]);
        if (f_20_ > 20.0F)
            f_20_ = 20.0F;
        (conto).wzy -= f_20_;
        if ((conto).wzy < -30)
            (conto).wzy += 30;
        if ((conto).wzy > 30)
            (conto).wzy -= 30;
        if ((control).right) {
            (conto).wxz -= (cd).turn[cn];
            if ((conto).wxz < -36)
                (conto).wxz = -36;
        }
        if ((control).left) {
            (conto).wxz += (cd).turn[cn];
            if ((conto).wxz > 36)
                (conto).wxz = 36;
        }
        if ((conto).wxz != 0 && !(control).left && !(control).right) {
            if (Math.abs(speed) < 10.0F) {
                if (Math.abs((conto).wxz) == 1)
                    (conto).wxz = 0;
                if ((conto).wxz > 0)
                    (conto).wxz--;
                if ((conto).wxz < 0)
                    (conto).wxz++;
            } else {
                if (Math.abs((conto).wxz) < (cd).turn[cn] * 2)
                    (conto).wxz = 0;
                if ((conto).wxz > 0)
                    (conto).wxz -= (cd).turn[cn] * 2;
                if ((conto).wxz < 0)
                    (conto).wxz += (cd).turn[cn] * 2;
            }
        }
        int i_21_ = (int) (3600.0F / (speed * speed));
        if (i_21_ < 5)
            i_21_ = 5;
        if (speed < 0.0F)
            i_21_ = -i_21_;
        if (wtouch) {
            if (!capsized) {
                if (!(control).handb)
                    fxz = (conto).wxz / (i_21_ * 3);
                else
                    fxz = (conto).wxz / i_21_;
                (conto).xz += (conto).wxz / i_21_;
            }
            wtouch = false;
            gtouch = false;
        } else
            (conto).xz += fxz;
        if (speed > 30.0F || speed < -100.0F) {
            while (Math.abs(mxz - cxz) > 180) {
                if (cxz > mxz)
                    cxz -= 360;
                else if (cxz < mxz)
                    cxz += 360;
            }
            if (Math.abs(mxz - cxz) < 30)
                cxz += (float) (mxz - cxz) / 4.0F;
            else {
                if (cxz > mxz)
                    cxz -= 10;
                if (cxz < mxz)
                    cxz += 10;
            }
        }
        float[] fs = new float[4];
        float[] fs_22_ = new float[4];
        float[] fs_23_ = new float[4];
        for (int i_24_ = 0; i_24_ < 4; i_24_++) {
            fs[i_24_] = (float) ((conto).keyx[i_24_] + (conto).x);
            fs_23_[i_24_] = (float) (i_10_ + (conto).y);
            fs_22_[i_24_] = (float) ((conto).z + (conto).keyz[i_24_]);
            scy[i_24_] += 7.0F;
        }
        rot(fs, fs_23_, (conto).x, (conto).y, pxy, 4);
        rot(fs_23_, fs_22_, (conto).y, (conto).z, pzy, 4);
        rot(fs, fs_22_, (conto).x, (conto).z, (conto).xz, 4);
        boolean bool_25_ = false;
        double d = 0.0;
        int i_26_ = (int) ((scx[0] + scx[1] + scx[2] + scx[3]) / 4.0F);
        int i_27_ = (int) ((scz[0] + scz[1] + scz[2] + scz[3]) / 4.0F);
        for (int i_28_ = 0; i_28_ < 4; i_28_++) {
            if (scx[i_28_] - (float) i_26_ > 200.0F)
                scx[i_28_] = (float) (200 + i_26_);
            if (scx[i_28_] - (float) i_26_ < -200.0F)
                scx[i_28_] = (float) (i_26_ - 200);
            if (scz[i_28_] - (float) i_27_ > 200.0F)
                scz[i_28_] = (float) (200 + i_27_);
            if (scz[i_28_] - (float) i_27_ < -200.0F)
                scz[i_28_] = (float) (i_27_ - 200);
        }
        for (int i_29_ = 0; i_29_ < 4; i_29_++) {
            fs_23_[i_29_] += scy[i_29_];
            fs[i_29_] += (scx[0] + scx[1] + scx[2] + scx[3]) / 4.0F;
            fs_22_[i_29_] += (scz[0] + scz[1] + scz[2] + scz[3]) / 4.0F;
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
            if (Math.abs((trackers).zy[i_34_]) != 90 && Math.abs((trackers).xy[i_34_]) != 90 && Math.abs((conto).x - (trackers).x[i_34_]) < (trackers).radx[i_34_] && Math.abs((conto).z - (trackers).z[i_34_]) < (trackers).radz[i_34_] && (!(trackers).decor[i_34_] || (m).resdown != 2 || (xt).multion != 0))
                i_32_ = (trackers).skd[i_34_];
        }
        if (mtouch) {
            float f_35_ = (cd).grip[cn];
            f_35_ -= (float) Math.abs(txz - (conto).xz) * speed / 250.0F;
            if ((control).handb)
                f_35_ -= (float) (Math.abs(txz - (conto).xz) * 4);
            if (f_35_ < (cd).grip[cn]) {
                if (skid != 2)
                    skid = 1;
                speed -= speed / 100.0F;
            } else if (skid == 1)
                skid = 2;
            if (i_32_ == 1)
                f_35_ *= 0.75;
            if (i_32_ == 2)
                f_35_ *= 0.55;
            int i_36_ = -(int) (speed * m.sin((conto).xz) * m.cos(pzy));
            int i_37_ = (int) (speed * m.cos((conto).xz) * m.cos(pzy));
            int i_38_ = -(int) (speed * m.sin(pzy));
            if (capsized || dest || (checkpoints).haltall) {
                i_36_ = 0;
                i_37_ = 0;
                i_38_ = 0;
                f_35_ = (cd).grip[cn] / 5.0F;
                if (speed > 0.0F)
                    speed -= 2.0F;
                else
                    speed += 2.0F;
            }
            if (Math.abs(speed) > drag) {
                if (speed > 0.0F)
                    speed -= drag;
                else
                    speed += drag;
            } else
                speed = 0.0F;
            if (cn == 8 && f_35_ < 5.0F)
                f_35_ = 5.0F;
            if (f_35_ < 1.0F)
                f_35_ = 1.0F;
            float f_39_ = 0.0F;
            float f_40_ = 0.0F;
            for (int i_41_ = 0; i_41_ < 4; i_41_++) {
                if (Math.abs(scx[i_41_] - (float) i_36_) > f_35_) {
                    if (scx[i_41_] < (float) i_36_)
                        scx[i_41_] += f_35_;
                    else
                        scx[i_41_] -= f_35_;
                } else
                    scx[i_41_] = (float) i_36_;
                if (Math.abs(scz[i_41_] - (float) i_37_) > f_35_) {
                    if (scz[i_41_] < (float) i_37_)
                        scz[i_41_] += f_35_;
                    else
                        scz[i_41_] -= f_35_;
                } else
                    scz[i_41_] = (float) i_37_;
                if (Math.abs(scy[i_41_] - (float) i_38_) > f_35_) {
                    if (scy[i_41_] < (float) i_38_)
                        scy[i_41_] += f_35_;
                    else
                        scy[i_41_] -= f_35_;
                } else
                    scy[i_41_] = (float) i_38_;
                if (f_35_ < (cd).grip[cn]) {
                    if (txz != (conto).xz)
                        dcnt++;
                    else if (dcnt != 0)
                        dcnt = 0;
                    if ((float) dcnt > 40.0F * f_35_ / (cd).grip[cn] || capsized) {
                        if (i_32_ != 0) {
						}
                        if ((double) m.random() > 0.65) {
                            //conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) scx[i_41_], (int) scz[i_41_], f_42_ * (cd).simag[cn], (int) tilt, capsized && mtouch);
                            if (im == (xt).im && !capsized)
                                xt.skid(i_32_, (float) Math.sqrt((double) (scx[i_41_] * scx[i_41_] + scz[i_41_] * scz[i_41_])));
                        }
                    } else {
                        if (i_32_ == 1 && (double) m.random() > 0.8)
                            conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) scx[i_41_], (int) scz[i_41_], 1.1F * (cd).simag[cn], (int) tilt, capsized && mtouch);
                        if ((i_32_ == 2 || i_32_ == 3) && (double) m.random() > 0.6)
                            conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) scx[i_41_], (int) scz[i_41_], 1.15F * (cd).simag[cn], (int) tilt, capsized && mtouch);
                    }
                } else if (dcnt != 0) {
                    dcnt -= 2;
                    if (dcnt < 0)
                        dcnt = 0;
                }
                if (i_32_ == 3) {
                    int i_43_ = (int) (m.random() * 4.0F);
                    scy[i_43_] = (float) ((double) (-100.0F * m.random() * (speed / (float) (cd).swits[cn][2])) * ((double) (cd).bounce[cn] - 0.3));
                }
                if (i_32_ == 4) {
                    int i_44_ = (int) (m.random() * 4.0F);
                    scy[i_44_] = (float) ((double) (-150.0F * m.random() * (speed / (float) (cd).swits[cn][2])) * ((double) (cd).bounce[cn] - 0.3));
                }
                f_39_ += scx[i_41_];
                f_40_ += scz[i_41_];
            }
            txz = (conto).xz;
            if (f_39_ > 0.0F)
                i = -1;
            else
                i = 1;
            d = (double) f_40_ / Math.sqrt((double) (f_39_ * f_39_ + f_40_ * f_40_));
            mxz = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
            if (skid == 2) {
                if (!capsized) {
                    f_39_ /= 4.0F;
                    f_40_ /= 4.0F;
                    if (bool_5_)
                        speed = -((float) Math.sqrt((double) (f_39_ * f_39_ + f_40_ * f_40_)) * m.cos(mxz - (conto).xz));
                    else
                        speed = (float) Math.sqrt((double) (f_39_ * f_39_ + f_40_ * f_40_)) * m.cos(mxz - (conto).xz);
                }
                skid = 0;
            }
            if (capsized && f_39_ == 0.0F && f_40_ == 0.0F)
                i_32_ = 0;
            mtouch = false;
            bool_25_ = true;
        } else if (skid != 2)
            skid = 2;
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
                wtouch = true;
                gtouch = true;
                if (!bool_25_ && scy[i_49_] != 7.0F) {
                    float f_50_ = scy[i_49_] / 333.33F;
                    if ((double) f_50_ > 0.3)
                        f_50_ = 0.3F;
                    if (i_32_ == 0)
                        f_50_ += 1.1;
                    else
                        f_50_ += 1.2;
                    //conto.dust(i_49_, fs[i_49_], fs_23_[i_49_], fs_22_[i_49_], (int) scx[i_49_], (int) scz[i_49_], f_50_ * (cd).simag[cn], 0, capsized && mtouch);
                }
                fs_23_[i_49_] = 250.0F;
                bools_47_[i_49_] = true;
                f_48_ += fs_23_[i_49_] - 250.0F;
                float f_51_ = Math.abs(m.sin(pxy)) + Math.abs(m.sin(pzy));
                f_51_ /= 3.0F;
                if ((double) f_51_ > 0.4)
                    f_51_ = 0.4F;
                f_51_ += (cd).bounce[cn];
                if ((double) f_51_ < 1.1)
                    f_51_ = 1.1F;
                regy(i_49_, Math.abs(scy[i_49_] * f_51_), conto);
                if (scy[i_49_] > 0.0F)
                    scy[i_49_] -= Math.abs(scy[i_49_] * f_51_);
                if (capsized)
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
                    conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 1);
                    if (im == (xt).im)
                        xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                }
                if (!bools[i_58_] && fs[i_58_] > (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]) && fs[i_58_] < (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]) && fs_22_[i_58_] > (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]) && fs_22_[i_58_] < (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]) && fs_23_[i_58_] > (float) ((trackers).y[i_55_] - (trackers).rady[i_55_]) && fs_23_[i_58_] < (float) ((trackers).y[i_55_] + (trackers).rady[i_55_]) && (!(trackers).decor[i_55_] || (m).resdown != 2 || (xt).multion != 0)) {
                    if ((trackers).xy[i_55_] == 0 && (trackers).zy[i_55_] == 0 && (trackers).y[i_55_] != 250 && fs_23_[i_58_] > (float) ((trackers).y[i_55_] - 5)) {
                        i_57_++;
                        wtouch = true;
                        gtouch = true;
                        if (!bool_25_ && scy[i_58_] != 7.0F) {
                            float f_59_ = scy[i_58_] / 333.33F;
                            if ((double) f_59_ > 0.3)
                                f_59_ = 0.3F;
                            if (i_32_ == 0)
                                f_59_ += 1.1;
                            else
                                f_59_ += 1.2;
                            conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) scx[i_58_], (int) scz[i_58_], f_59_ * (cd).simag[cn], 0, capsized && mtouch);
                        }
                        fs_23_[i_58_] = (float) (trackers).y[i_55_];
                        if (capsized && ((trackers).skd[i_55_] == 0 || (trackers).skd[i_55_] == 1)) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 1);
                            if (im == (xt).im)
                                xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                        }
                        float f_60_ = Math.abs(m.sin(pxy)) + Math.abs(m.sin(pzy));
                        f_60_ /= 3.0F;
                        if ((double) f_60_ > 0.4)
                            f_60_ = 0.4F;
                        f_60_ += (cd).bounce[cn];
                        if ((double) f_60_ < 1.1)
                            f_60_ = 1.1F;
                        regy(i_58_, Math.abs(scy[i_58_] * f_60_), conto);
                        if (scy[i_58_] > 0.0F)
                            scy[i_58_] -= Math.abs(scy[i_58_] * f_60_);
                        bools[i_58_] = true;
                    }
                    if ((trackers).zy[i_55_] == -90 && fs_22_[i_58_] < (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]) && (scz[i_58_] < 0.0F || (trackers).radz[i_55_] == 287)) {
                        for (int i_61_ = 0; i_61_ < 4; i_61_++) {
                            if (i_58_ != i_61_ && fs_22_[i_61_] >= (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]))
                                fs_22_[i_61_] -= fs_22_[i_58_] - (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]);
                        }
                        fs_22_[i_58_] = (float) ((trackers).z[i_55_] + (trackers).radz[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            crank[0][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && m.random() > m.random())
                            crank[0][i_58_]++;
                        if (crank[0][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
                            if (im == (xt).im)
                                xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                        }
                        float f_62_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f_62_ /= 4.0F;
                        if ((double) f_62_ > 0.3)
                            f_62_ = 0.3F;
                        if (bool_25_)
                            f_62_ = 0.0F;
                        f_62_ += (double) (cd).bounce[cn] - 0.2;
                        if ((double) f_62_ < 1.1)
                            f_62_ = 1.1F;
                        regz(i_58_, Math.abs(scz[i_58_] * f_62_ * (float) (trackers).dam[i_55_]), conto);
                        scz[i_58_] += Math.abs(scz[i_58_] * f_62_);
                        skid = 2;
                        bool_6_ = true;
                        bools[i_58_] = true;
                        if (!(trackers).notwall[i_55_])
                            (control).wall = i_55_;
                    }
                    if ((trackers).zy[i_55_] == 90 && fs_22_[i_58_] > (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]) && (scz[i_58_] > 0.0F || (trackers).radz[i_55_] == 287)) {
                        for (int i_63_ = 0; i_63_ < 4; i_63_++) {
                            if (i_58_ != i_63_ && fs_22_[i_63_] <= (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]))
                                fs_22_[i_63_] -= fs_22_[i_58_] - (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]);
                        }
                        fs_22_[i_58_] = (float) ((trackers).z[i_55_] - (trackers).radz[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            crank[1][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && m.random() > m.random())
                            crank[1][i_58_]++;
                        if (crank[1][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
                            if (im == (xt).im)
                                xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                        }
                        float f_64_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f_64_ /= 4.0F;
                        if ((double) f_64_ > 0.3)
                            f_64_ = 0.3F;
                        if (bool_25_)
                            f_64_ = 0.0F;
                        f_64_ += (double) (cd).bounce[cn] - 0.2;
                        if ((double) f_64_ < 1.1)
                            f_64_ = 1.1F;
                        regz(i_58_, -Math.abs(scz[i_58_] * f_64_ * (float) (trackers).dam[i_55_]), conto);
                        scz[i_58_] -= Math.abs(scz[i_58_] * f_64_);
                        skid = 2;
                        bool_6_ = true;
                        bools[i_58_] = true;
                        if (!(trackers).notwall[i_55_])
                            (control).wall = i_55_;
                    }
                    if ((trackers).xy[i_55_] == -90 && fs[i_58_] < (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]) && (scx[i_58_] < 0.0F || (trackers).radx[i_55_] == 287)) {
                        for (int i_65_ = 0; i_65_ < 4; i_65_++) {
                            if (i_58_ != i_65_ && fs[i_65_] >= (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]))
                                fs[i_65_] -= fs[i_58_] - (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]);
                        }
                        fs[i_58_] = (float) ((trackers).x[i_55_] + (trackers).radx[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            crank[2][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && m.random() > m.random())
                            crank[2][i_58_]++;
                        if (crank[2][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
                            if (im == (xt).im)
                                xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                        }
                        float f_66_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f_66_ /= 4.0F;
                        if ((double) f_66_ > 0.3)
                            f_66_ = 0.3F;
                        if (bool_25_)
                            f_66_ = 0.0F;
                        f_66_ += (double) (cd).bounce[cn] - 0.2;
                        if ((double) f_66_ < 1.1)
                            f_66_ = 1.1F;
                        regx(i_58_, Math.abs(scx[i_58_] * f_66_ * (float) (trackers).dam[i_55_]), conto);
                        scx[i_58_] += Math.abs(scx[i_58_] * f_66_);
                        skid = 2;
                        bool_6_ = true;
                        bools[i_58_] = true;
                        if (!(trackers).notwall[i_55_])
                            (control).wall = i_55_;
                    }
                    if ((trackers).xy[i_55_] == 90 && fs[i_58_] > (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]) && (scx[i_58_] > 0.0F || (trackers).radx[i_55_] == 287)) {
                        for (int i_67_ = 0; i_67_ < 4; i_67_++) {
                            if (i_58_ != i_67_ && fs[i_67_] <= (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]))
                                fs[i_67_] -= fs[i_58_] - (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]);
                        }
                        fs[i_58_] = (float) ((trackers).x[i_55_] - (trackers).radx[i_55_]);
                        if ((trackers).skd[i_55_] != 2)
                            crank[3][i_58_]++;
                        if ((trackers).skd[i_55_] == 5 && m.random() > m.random())
                            crank[3][i_58_]++;
                        if (crank[3][i_58_] > 1) {
                            conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
                            if (im == (xt).im)
                                xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                        }
                        float f_68_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f_68_ /= 4.0F;
                        if ((double) f_68_ > 0.3)
                            f_68_ = 0.3F;
                        if (bool_25_)
                            f_68_ = 0.0F;
                        f_68_ += (double) (cd).bounce[cn] - 0.2;
                        if ((double) f_68_ < 1.1)
                            f_68_ = 1.1F;
                        regx(i_58_, -Math.abs(scx[i_58_] * f_68_ * (float) (trackers).dam[i_55_]), conto);
                        scx[i_58_] -= Math.abs(scx[i_58_] * f_68_);
                        skid = 2;
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
                        float f_71_ = (float) (trackers).y[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * m.cos(i_69_) - (fs_22_[i_58_] - (float) (trackers).z[i_55_]) * m.sin(i_69_));
                        float f_72_ = (float) (trackers).z[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * m.sin(i_69_) + (fs_22_[i_58_] - (float) (trackers).z[i_55_]) * m.cos(i_69_));
                        if (f_72_ > (float) (trackers).z[i_55_] && f_72_ < (float) ((trackers).z[i_55_] + 200)) {
                            scy[i_58_] -= (f_72_ - (float) (trackers).z[i_55_]) / f_70_;
                            f_72_ = (float) (trackers).z[i_55_];
                        }
                        if (f_72_ > (float) ((trackers).z[i_55_] - 30)) {
                            if ((trackers).skd[i_55_] == 2)
                                i_56_++;
                            else
                                i_53_++;
                            wtouch = true;
                            gtouch = false;
                            if (capsized && ((trackers).skd[i_55_] == 0 || (trackers).skd[i_55_] == 1)) {
                                conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 1);
                                if (im == (xt).im)
                                    xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                            }
                            if (!bool_25_ && i_32_ != 0) {
                                float f_73_ = 1.4F;
                                conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) scx[i_58_], (int) scz[i_58_], f_73_ * (cd).simag[cn], 0, capsized && mtouch);
                            }
                        }
                        fs_23_[i_58_] = (float) (trackers).y[i_55_] + ((f_71_ - (float) (trackers).y[i_55_]) * m.cos(-i_69_) - (f_72_ - (float) (trackers).z[i_55_]) * m.sin(-i_69_));
                        fs_22_[i_58_] = (float) (trackers).z[i_55_] + ((f_71_ - (float) (trackers).y[i_55_]) * m.sin(-i_69_) + (f_72_ - (float) (trackers).z[i_55_]) * m.cos(-i_69_));
                        bools[i_58_] = true;
                    }
                    if ((trackers).xy[i_55_] != 0 && (trackers).xy[i_55_] != 90 && (trackers).xy[i_55_] != -90) {
                        int i_74_ = 90 + (trackers).xy[i_55_];
                        float f_75_ = 1.0F + (float) (50 - Math.abs((trackers).xy[i_55_])) / 30.0F;
                        if (f_75_ < 1.0F)
                            f_75_ = 1.0F;
                        float f_76_ = (float) (trackers).y[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * m.cos(i_74_) - (fs[i_58_] - (float) (trackers).x[i_55_]) * m.sin(i_74_));
                        float f_77_ = (float) (trackers).x[i_55_] + ((fs_23_[i_58_] - (float) (trackers).y[i_55_]) * m.sin(i_74_) + (fs[i_58_] - (float) (trackers).x[i_55_]) * m.cos(i_74_));
                        if (f_77_ > (float) (trackers).x[i_55_] && f_77_ < (float) ((trackers).x[i_55_] + 200)) {
                            scy[i_58_] -= (f_77_ - (float) (trackers).x[i_55_]) / f_75_;
                            f_77_ = (float) (trackers).x[i_55_];
                        }
                        if (f_77_ > (float) ((trackers).x[i_55_] - 30)) {
                            if ((trackers).skd[i_55_] == 2)
                                i_56_++;
                            else
                                i_53_++;
                            wtouch = true;
                            gtouch = false;
                            if (capsized && ((trackers).skd[i_55_] == 0 || (trackers).skd[i_55_] == 1)) {
                                conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 1);
                                if (im == (xt).im)
                                    xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
                            }
                            if (!bool_25_ && i_32_ != 0) {
                                float f_78_ = 1.4F;
                                conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) scx[i_58_], (int) scz[i_58_], f_78_ * (cd).simag[cn], 0, capsized && mtouch);
                            }
                        }
                        fs_23_[i_58_] = (float) (trackers).y[i_55_] + ((f_76_ - (float) (trackers).y[i_55_]) * m.cos(-i_74_) - (f_77_ - (float) (trackers).x[i_55_]) * m.sin(-i_74_));
                        fs[i_58_] = (float) (trackers).x[i_55_] + ((f_76_ - (float) (trackers).y[i_55_]) * m.sin(-i_74_) + (f_77_ - (float) (trackers).x[i_55_]) * m.cos(-i_74_));
                        bools[i_58_] = true;
                    }
                }
            }
            if (i_56_ == 4)
                mtouch = true;
            if (i_57_ == 4)
                i_45_ = 4;
        }
        if (i_53_ == 4)
            mtouch = true;
        for (int i_79_ = 0; i_79_ < 4; i_79_++) {
            for (int i_80_ = 0; i_80_ < 4; i_80_++) {
                if (crank[i_79_][i_80_] == lcrank[i_79_][i_80_])
                    crank[i_79_][i_80_] = 0;
                lcrank[i_79_][i_80_] = crank[i_79_][i_80_];
            }
        }
        int i_81_ = 0;
        int i_82_ = 0;
        int i_83_ = 0;
        int i_84_ = 0;
        if (scy[2] != scy[0]) {
            if (scy[2] < scy[0])
                i = -1;
            else
                i = 1;
            d = Math.sqrt((double) ((fs_22_[0] - fs_22_[2]) * (fs_22_[0] - fs_22_[2]) + (fs_23_[0] - fs_23_[2]) * (fs_23_[0] - fs_23_[2]) + (fs[0] - fs[2]) * (fs[0] - fs[2]))) / (double) (Math.abs((conto).keyz[0]) + Math.abs((conto).keyz[2]));
            if (d >= 0.9998)
                i_81_ = i;
            else
                i_81_ = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
        }
        if (scy[3] != scy[1]) {
            if (scy[3] < scy[1])
                i = -1;
            else
                i = 1;
            d = Math.sqrt((double) ((fs_22_[1] - fs_22_[3]) * (fs_22_[1] - fs_22_[3]) + (fs_23_[1] - fs_23_[3]) * (fs_23_[1] - fs_23_[3]) + (fs[1] - fs[3]) * (fs[1] - fs[3]))) / (double) (Math.abs((conto).keyz[1]) + Math.abs((conto).keyz[3]));
            if (d >= 0.9998)
                i_82_ = i;
            else
                i_82_ = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
        }
        if (scy[1] != scy[0]) {
            if (scy[1] < scy[0])
                i = -1;
            else
                i = 1;
            d = Math.sqrt((double) ((fs_22_[0] - fs_22_[1]) * (fs_22_[0] - fs_22_[1]) + (fs_23_[0] - fs_23_[1]) * (fs_23_[0] - fs_23_[1]) + (fs[0] - fs[1]) * (fs[0] - fs[1]))) / (double) (Math.abs((conto).keyx[0]) + Math.abs((conto).keyx[1]));
            if (d >= 0.9998)
                i_83_ = i;
            else
                i_83_ = (int) (Math.acos(d) / 0.017453292519943295 * (double) i);
        }
        if (scy[3] != scy[2]) {
            if (scy[3] < scy[2])
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
                pmlt = 1;
            else
                pmlt = -1;
            for (i_85_ = Math.abs((conto).xz - 45); i_85_ > 180; i_85_ -= 360) {
                /* empty */
            }
            if (Math.abs(i_85_) > 90)
                nmlt = 1;
            else
                nmlt = -1;
        }
        (conto).xz += forca * (scz[0] * (float) nmlt - scz[1] * (float) pmlt + scz[2] * (float) pmlt - scz[3] * (float) nmlt + scx[0] * (float) pmlt + scx[1] * (float) nmlt - scx[2] * (float) nmlt - scx[3] * (float) pmlt);
        if (Math.abs(i_82_) > Math.abs(i_81_))
            i_81_ = i_82_;
        if (Math.abs(i_84_) > Math.abs(i_83_))
            i_83_ = i_84_;
        if (!bool)
            pzy += i_81_;
        else
            pzy -= i_81_;
        if (!bool_8_)
            pxy += i_83_;
        else
            pxy -= i_83_;
        if (i_45_ == 4) {
            int i_86_ = 0;
            while (pzy < 360) {
                pzy += 360;
                (conto).zy += 360;
            }
            while (pzy > 360) {
                pzy -= 360;
                (conto).zy -= 360;
            }
            if (pzy < 190 && pzy > 170) {
                pzy = 180;
                (conto).zy = 180;
                i_86_++;
            }
            if (pzy > 350 || pzy < 10) {
                pzy = 0;
                (conto).zy = 0;
                i_86_++;
            }
            while (pxy < 360) {
                pxy += 360;
                (conto).xy += 360;
            }
            while (pxy > 360) {
                pxy -= 360;
                (conto).xy -= 360;
            }
            if (pxy < 190 && pxy > 170) {
                pxy = 180;
                (conto).xy = 180;
                i_86_++;
            }
            if (pxy > 350 || pxy < 10) {
                pxy = 0;
                (conto).xy = 0;
                i_86_++;
            }
            if (i_86_ == 2)
                mtouch = true;
        }
        if (!mtouch && wtouch) {
            if (cntouch == 10)
                mtouch = true;
            else
                cntouch++;
        } else
            cntouch = 0;
        (conto).y = (int) ((fs_23_[0] + fs_23_[1] + fs_23_[2] + fs_23_[3]) / 4.0F - (float) i_10_ * m.cos(pzy) * m.cos(pxy) + f_12_);
        if (bool)
            i = -1;
        else
            i = 1;
        (conto).x = (int) ((fs[0] - (float) (conto).keyx[0] * m.cos((conto).xz) + (float) (i * (conto).keyz[0]) * m.sin((conto).xz) + fs[1] - (float) (conto).keyx[1] * m.cos((conto).xz) + (float) (i * (conto).keyz[1]) * m.sin((conto).xz) + fs[2] - (float) (conto).keyx[2] * m.cos((conto).xz) + (float) (i * (conto).keyz[2]) * m.sin((conto).xz) + fs[3] - (float) (conto).keyx[3] * m.cos((conto).xz) + (float) (i * (conto).keyz[3]) * m.sin((conto).xz)) / 4.0F + (float) i_10_ * m.sin(pxy) * m.cos((conto).xz) - (float) i_10_ * m.sin(pzy) * m.sin((conto).xz) + f);
        (conto).z = (int) ((fs_22_[0] - (float) (i * (conto).keyz[0]) * m.cos((conto).xz) - (float) (conto).keyx[0] * m.sin((conto).xz) + fs_22_[1] - (float) (i * (conto).keyz[1]) * m.cos((conto).xz) - (float) (conto).keyx[1] * m.sin((conto).xz) + fs_22_[2] - (float) (i * (conto).keyz[2]) * m.cos((conto).xz) - (float) (conto).keyx[2] * m.sin((conto).xz) + fs_22_[3] - (float) (i * (conto).keyz[3]) * m.cos((conto).xz) - (float) (conto).keyx[3] * m.sin((conto).xz)) / 4.0F + (float) i_10_ * m.sin(pxy) * m.sin((conto).xz) - (float) i_10_ * m.sin(pzy) * m.cos((conto).xz) + f_11_);
        if (Math.abs(speed) > 10.0F || !mtouch) {
            if (Math.abs(pxy - (conto).xy) >= 4) {
                if (pxy > (conto).xy)
                    (conto).xy += 2 + (pxy - (conto).xy) / 2;
                else
                    (conto).xy -= 2 + ((conto).xy - pxy) / 2;
            } else
                (conto).xy = pxy;
            if (Math.abs(pzy - (conto).zy) >= 4) {
                if (pzy > (conto).zy)
                    (conto).zy += 2 + (pzy - (conto).zy) / 2;
                else
                    (conto).zy -= 2 + ((conto).zy - pzy) / 2;
            } else
                (conto).zy = pzy;
        }
        if (wtouch && !capsized) {
            float f_87_ = (float) ((double) (speed / (float) (cd).swits[cn][2] * 14.0F) * ((double) (cd).bounce[cn] - 0.4));
            if ((control).left && tilt < f_87_ && tilt >= 0.0F)
                tilt += 0.4;
            else if ((control).right && tilt > -f_87_ && tilt <= 0.0F)
                tilt -= 0.4;
            else if ((double) Math.abs(tilt) > 3.0 * ((double) (cd).bounce[cn] - 0.4)) {
                if (tilt > 0.0F)
                    tilt -= 3.0 * ((double) (cd).bounce[cn] - 0.3);
                else
                    tilt += 3.0 * ((double) (cd).bounce[cn] - 0.3);
            } else
                tilt = 0.0F;
            (conto).xy += tilt;
            if (gtouch)
                (conto).y -= (double) tilt / 1.5;
        } else if (tilt != 0.0F)
            tilt = 0.0F;
        if (wtouch && i_32_ == 2) {
            (conto).zy += (int) ((double) (m.random() * 6.0F * speed / (float) (cd).swits[cn][2] - 3.0F * speed / (float) (cd).swits[cn][2]) * ((double) (cd).bounce[cn] - 0.3));
            (conto).xy += (int) ((double) (m.random() * 6.0F * speed / (float) (cd).swits[cn][2] - 3.0F * speed / (float) (cd).swits[cn][2]) * ((double) (cd).bounce[cn] - 0.3));
        }
        if (wtouch && i_32_ == 1) {
            (conto).zy += (int) ((double) (m.random() * 4.0F * speed / (float) (cd).swits[cn][2] - 2.0F * speed / (float) (cd).swits[cn][2]) * ((double) (cd).bounce[cn] - 0.3));
            (conto).xy += (int) ((double) (m.random() * 4.0F * speed / (float) (cd).swits[cn][2] - 2.0F * speed / (float) (cd).swits[cn][2]) * ((double) (cd).bounce[cn] - 0.3));
        }
        if (hitmag >= (cd).maxmag[cn] && !dest) {
            distruct(conto);
            if (cntdest == 7)
                dest = true;
            else
                cntdest++;
            if (cntdest == 1)
                (rpd).dest[im] = 300;
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
        if (nofocus)
            i_4_ = 1;
        else
            i_4_ = 7;
        for (int i_92_ = 0; i_92_ < (checkpoints).n; i_92_++) {
            if ((checkpoints).typ[i_92_] > 0) {
                i_91_++;
                if ((checkpoints).typ[i_92_] == 1) {
                    if (clear == i_91_ + nlaps * (checkpoints).nsp)
                        i_4_ = 1;
                    if ((float) Math.abs((conto).z - (checkpoints).z[i_92_]) < 60.0F + Math.abs(scz[0] + scz[1] + scz[2] + scz[3]) / 4.0F && Math.abs((conto).x - (checkpoints).x[i_92_]) < 700 && Math.abs((conto).y - (checkpoints).y[i_92_] + 350) < 450 && clear == i_91_ + nlaps * (checkpoints).nsp - 1) {
                        clear = i_91_ + nlaps * (checkpoints).nsp;
                        pcleared = i_92_;
                        focus = -1;
                    }
                }
                if ((checkpoints).typ[i_92_] == 2) {
                    if (clear == i_91_ + nlaps * (checkpoints).nsp)
                        i_4_ = 1;
                    if ((float) Math.abs((conto).x - (checkpoints).x[i_92_]) < 60.0F + Math.abs(scx[0] + scx[1] + scx[2] + scx[3]) / 4.0F && Math.abs((conto).z - (checkpoints).z[i_92_]) < 700 && Math.abs((conto).y - (checkpoints).y[i_92_] + 350) < 450 && clear == i_91_ + nlaps * (checkpoints).nsp - 1) {
                        clear = i_91_ + nlaps * (checkpoints).nsp;
                        pcleared = i_92_;
                        focus = -1;
                    }
                }
            }
            if (py((conto).x / 100, (checkpoints).x[i_92_] / 100, (conto).z / 100, (checkpoints).z[i_92_] / 100) * i_4_ < i_90_ || i_90_ == 0) {
                i_89_ = i_92_;
                i_90_ = py((conto).x / 100, (checkpoints).x[i_92_] / 100, (conto).z / 100, (checkpoints).z[i_92_] / 100) * i_4_;
            }
        }
        if (clear == i_91_ + nlaps * (checkpoints).nsp)
            nlaps++;
        if (im == (xt).im) {
            for ((m).checkpoint = clear; (m).checkpoint >= (checkpoints).nsp; (m).checkpoint -= (checkpoints).nsp) {
                /* empty */
            }
            if (clear == (checkpoints).nlaps * (checkpoints).nsp - 1)
                (m).lastcheck = true;
            if ((checkpoints).haltall)
                (m).lastcheck = false;
        }
        if (focus == -1) {
            if (im == (xt).im)
                i_89_ += 2;
            else
                i_89_++;
            if (!nofocus) {
                i_91_ = pcleared + 1;
                if (i_91_ >= (checkpoints).n)
                    i_91_ = 0;
                while ((checkpoints).typ[i_91_] <= 0) {
                    if (++i_91_ >= (checkpoints).n)
                        i_91_ = 0;
                }
                if (i_89_ > i_91_ && (clear != nlaps * (checkpoints).nsp || i_89_ < pcleared)) {
                    i_89_ = i_91_;
                    focus = i_89_;
                }
            }
            if (i_89_ >= (checkpoints).n)
                i_89_ -= (checkpoints).n;
            if ((checkpoints).typ[i_89_] == -3)
                i_89_ = 0;
            if (im == (xt).im) {
                if (missedcp != -1)
                    missedcp = -1;
            } else if (missedcp != 0)
                missedcp = 0;
        } else {
            i_89_ = focus;
            if (im == (xt).im) {
                if (missedcp == 0 && mtouch && Math.sqrt((double) py((conto).x / 10, (checkpoints).x[focus] / 10, (conto).z / 10, (checkpoints).z[focus] / 10)) > 800.0)
                    missedcp = 1;
                if (missedcp == -2 && Math.sqrt((double) py((conto).x / 10, (checkpoints).x[focus] / 10, (conto).z / 10, (checkpoints).z[focus] / 10)) < 400.0)
                    missedcp = 0;
                if (missedcp != 0 && mtouch && Math.sqrt((double) py((conto).x / 10, (checkpoints).x[focus] / 10, (conto).z / 10, (checkpoints).z[focus] / 10)) < 250.0)
                    missedcp = 68;
            } else
                missedcp = 1;
            if (nofocus) {
                focus = -1;
                missedcp = 0;
            }
        }
        if (nofocus)
            nofocus = false;
        point = i_89_;
        if (fixes != 0) {
            if ((m).noelec == 0) {
                for (int i_93_ = 0; i_93_ < (checkpoints).fn; i_93_++) {
                    if (!(checkpoints).roted[i_93_]) {
                        if (Math.abs((conto).z - (checkpoints).fz[i_93_]) < 200 && py((conto).x / 100, (checkpoints).fx[i_93_] / 100, (conto).y / 100, (checkpoints).fy[i_93_] / 100) < 30) {
                            if ((conto).dist == 0)
                                (conto).fcnt = 8;
                            else {
                                if (im == (xt).im && !(conto).fix && !(xt).mutes)
                                    (xt).carfixed.play();
                                (conto).fix = true;
                            }
                            (rpd).fix[im] = 300;
                        }
                    } else if (Math.abs((conto).x - (checkpoints).fx[i_93_]) < 200 && py((conto).z / 100, (checkpoints).fz[i_93_] / 100, (conto).y / 100, (checkpoints).fy[i_93_] / 100) < 30) {
                        if ((conto).dist == 0)
                            (conto).fcnt = 8;
                        else {
                            if (im == (xt).im && !(conto).fix && !(xt).mutes)
                                (xt).carfixed.play();
                            (conto).fix = true;
                        }
                        (rpd).fix[im] = 300;
                    }
                }
            }
        } else {
            for (int i_94_ = 0; i_94_ < (checkpoints).fn; i_94_++) {
                if (rpy((float) ((conto).x / 100), (float) ((checkpoints).fx[i_94_] / 100), (float) ((conto).y / 100), (float) ((checkpoints).fy[i_94_] / 100), (float) ((conto).z / 100), (float) ((checkpoints).fz[i_94_] / 100)) < 760)
                    (m).noelec = 2;
            }
        }
        if ((conto).fcnt == 7 || (conto).fcnt == 8) {
            squash = 0;
            nbsq = 0;
            hitmag = 0;
            cntdest = 0;
            dest = false;
            newcar = true;
            (conto).fcnt = 9;
            if (fixes > 0)
                fixes--;
        }
        if (newedcar != 0) {
            newedcar--;
            if (newedcar == 10)
                newcar = false;
        }
        if (!mtouch) {
            if (trcnt != 1) {
                trcnt = 1;
                lxz = (conto).xz;
            }
            if (loop == 2 || loop == -1) {
                travxy += rcomp - lcomp;
                if (Math.abs(travxy) > 135)
                    rtab = true;
                travzy += ucomp - dcomp;
                if (travzy > 135)
                    ftab = true;
                if (travzy < -135)
                    btab = true;
            }
            if (lxz != (conto).xz) {
                travxz += lxz - (conto).xz;
                lxz = (conto).xz;
            }
            if (srfcnt < 10) {
                if ((control).wall != -1)
                    surfer = true;
                srfcnt++;
            }
        } else if (!dest) {
            if (!capsized) {
                if (capcnt != 0)
                    capcnt = 0;
                if (gtouch && trcnt != 0) {
                    if (trcnt == 9) {
                        powerup = 0.0F;
                        if (Math.abs(travxy) > 90)
                            powerup += (float) Math.abs(travxy) / 24.0F;
                        else if (rtab)
                            powerup += 30.0F;
                        if (Math.abs(travzy) > 90)
                            powerup += (float) Math.abs(travzy) / 18.0F;
                        else {
                            if (ftab)
                                powerup += 40.0F;
                            if (btab)
                                powerup += 40.0F;
                        }
                        if (Math.abs(travxz) > 90)
                            powerup += (float) Math.abs(travxz) / 18.0F;
                        if (surfer)
                            powerup += 30.0F;
                        power += powerup;
                        if (im == (xt).im && (int) powerup > (rpd).powered && (rpd).wasted == 0 && (powerup > 60.0F || (checkpoints).stage == 1 || (checkpoints).stage == 2)) {
                            rpdcatch = 30;
                            if ((rpd).hcaught)
                                (rpd).powered = (int) powerup;
                        }
                        if (power > 98.0F) {
                            power = 98.0F;
                            if (powerup > 150.0F)
                                xtpower = 200;
                            else
                                xtpower = 100;
                        }
                    }
                    if (trcnt == 10) {
                        travxy = 0;
                        travzy = 0;
                        travxz = 0;
                        ftab = false;
                        rtab = false;
                        btab = false;
                        trcnt = 0;
                        srfcnt = 0;
                        surfer = false;
                    } else
                        trcnt++;
                }
            } else {
                if (trcnt != 0) {
                    travxy = 0;
                    travzy = 0;
                    travxz = 0;
                    ftab = false;
                    rtab = false;
                    btab = false;
                    trcnt = 0;
                    srfcnt = 0;
                    surfer = false;
                }
                if (capcnt == 0) {
                    int i_95_ = 0;
                    for (int i_96_ = 0; i_96_ < 4; i_96_++) {
                        if (Math.abs(scz[i_96_]) < 70.0F && Math.abs(scx[i_96_]) < 70.0F)
                            i_95_++;
                    }
                    if (i_95_ == 4)
                        capcnt = 1;
                } else {
                    capcnt++;
                    if (capcnt == 30) {
                        speed = 0.0F;
                        (conto).y += (cd).flipy[cn];
                        pxy += 180;
                        (conto).xy += 180;
                        capcnt = 0;
                    }
                }
            }
            if (trcnt == 0 && speed != 0.0F) {
                if (xtpower == 0) {
                    if (power > 0.0F)
                        power -= power * power * power / (float) (cd).powerloss[cn];
                    else
                        power = 0.0F;
                } else
                    xtpower--;
            }
        }
        if (im == (xt).im) {
            if ((control).wall != -1)
                (control).wall = -1;
        } else if (lastcolido != 0 && !dest)
            lastcolido--;
        if (dest) {
            if ((checkpoints).dested[im] == 0) {
                if (lastcolido == 0)
                    (checkpoints).dested[im] = 1;
                else
                    (checkpoints).dested[im] = 2;
            }
        } else if ((checkpoints).dested[im] != 0 && (checkpoints).dested[im] != 3)
            (checkpoints).dested[im] = 0;
        if (im == (xt).im && (rpd).wasted == 0 && rpdcatch != 0) {
            rpdcatch--;
            if (rpdcatch == 0) {
                rpd.cotchinow(im);
                if ((rpd).hcaught)
                    (rpd).whenwasted = (int) (185.0F + m.random() * 20.0F);
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
        if ((xt).multion == 1 && (xt).im != im)
            bool = false;
        if ((xt).multion >= 2)
            bool = false;
        if ((xt).lan && (xt).multion >= 1 && (xt).isbot[im])
            bool = true;
        f *= (cd).dammult[cn];
        if (f > 100.0F) {
            rpd.recy(i, f, mtouch, im);
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
            if (im == (xt).im || colidim)
                xt.crash(f, i_98_ * i_97_);
            if (i_98_ * i_97_ == 0 || mtouch) {
                for (int i_101_ = 0; i_101_ < (conto).npl; i_101_++) {
                    float f_102_ = 0.0F;
                    for (int i_103_ = 0; i_103_ < ((conto).p[i_101_]).n; i_103_++) {
                        if (((conto).p[i_101_]).wz == 0 && py((conto).keyx[i], ((conto).p[i_101_]).ox[i_103_], (conto).keyz[i], ((conto).p[i_101_]).oz[i_103_]) < (cd).clrad[cn]) {
                            f_102_ = f / 20.0F * m.random();
                            ((conto).p[i_101_]).oz[i_103_] += f_102_ * m.sin(i_99_);
                            ((conto).p[i_101_]).ox[i_103_] -= f_102_ * m.sin(i_100_);
                            if (bool)
                                hitmag += Math.abs(f_102_);
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
                if (nbsq > 0) {
                    int i_104_ = 0;
                    int i_105_ = 1;
                    for (int i_106_ = 0; i_106_ < (conto).npl; i_106_++) {
                        float f_107_ = 0.0F;
                        for (int i_108_ = 0; i_108_ < ((conto).p[i_106_]).n; i_108_++) {
                            if (((conto).p[i_106_]).wz == 0) {
                                f_107_ = f / 15.0F * m.random();
                                if ((Math.abs(((conto).p[i_106_]).oy[i_108_] - (cd).flipy[cn] - squash) < (cd).msquash[cn] * 3 || ((conto).p[i_106_]).oy[i_108_] < (cd).flipy[cn] + squash) && squash < (cd).msquash[cn]) {
                                    ((conto).p[i_106_]).oy[i_108_] += f_107_;
                                    i_104_ += f_107_;
                                    i_105_++;
                                    if (bool)
                                        hitmag += Math.abs(f_107_);
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
                    squash += i_104_ / i_105_;
                    nbsq = 0;
                } else
                    nbsq++;
            }
        }
    }
    
    public void regx(int i, float f, ContO conto) {
        boolean bool = true;
        if ((xt).multion == 1 && (xt).im != im)
            bool = false;
        if ((xt).multion >= 2)
            bool = false;
        if ((xt).lan && (xt).multion >= 1 && (xt).isbot[im])
            bool = true;
        f *= (cd).dammult[cn];
        if (Math.abs(f) > 100.0F) {
            rpd.recx(i, f, im);
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            if (im == (xt).im || colidim)
                xt.crash(f, 0);
            for (int i_109_ = 0; i_109_ < (conto).npl; i_109_++) {
                float f_110_ = 0.0F;
                for (int i_111_ = 0; i_111_ < ((conto).p[i_109_]).n; i_111_++) {
                    if (((conto).p[i_109_]).wz == 0 && py((conto).keyx[i], ((conto).p[i_109_]).ox[i_111_], (conto).keyz[i], ((conto).p[i_109_]).oz[i_111_]) < (cd).clrad[cn]) {
                        f_110_ = f / 20.0F * m.random();
                        ((conto).p[i_109_]).oz[i_111_] -= f_110_ * m.sin((conto).xz) * m.cos((conto).zy);
                        ((conto).p[i_109_]).ox[i_111_] += f_110_ * m.cos((conto).xz) * m.cos((conto).xy);
                        if (bool)
                            hitmag += Math.abs(f_110_);
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
        if ((xt).multion == 1 && (xt).im != im)
            bool = false;
        if ((xt).multion >= 2)
            bool = false;
        if ((xt).lan && (xt).multion >= 1 && (xt).isbot[im])
            bool = true;
        f *= (cd).dammult[cn];
        if (Math.abs(f) > 100.0F) {
            rpd.recz(i, f, im);
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            if (im == (xt).im || colidim)
                xt.crash(f, 0);
            for (int i_112_ = 0; i_112_ < (conto).npl; i_112_++) {
                float f_113_ = 0.0F;
                for (int i_114_ = 0; i_114_ < ((conto).p[i_112_]).n; i_114_++) {
                    if (((conto).p[i_112_]).wz == 0 && py((conto).keyx[i], ((conto).p[i_112_]).ox[i_114_], (conto).keyz[i], ((conto).p[i_112_]).oz[i_114_]) < (cd).clrad[cn]) {
                        f_113_ = f / 20.0F * m.random();
                        ((conto).p[i_112_]).oz[i_114_] += f_113_ * m.cos((conto).xz) * m.cos((conto).zy);
                        ((conto).p[i_112_]).ox[i_114_] += f_113_ * m.sin((conto).xz) * m.cos((conto).xy);
                        if (bool)
                            hitmag += Math.abs(f_113_);
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
            if (capsized)
                fs_117_[i] = (float) ((conto).y + (cd).flipy[cn] + squash);
            else
                fs_117_[i] = (float) ((conto).y + (conto).grat);
            fs_118_[i] = (float) ((conto).z + (conto).keyz[i]);
            fs_119_[i] = (float) ((conto_116_).x + (conto_116_).keyx[i]);
            if (capsized)
                fs_120_[i] = (float) ((conto_116_).y + (cd).flipy[(mad_115_).cn] + (mad_115_).squash);
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
            if (!caught[(mad_115_).im] && (speed != 0.0F || (mad_115_).speed != 0.0F)) {
                if (Math.abs(power * speed * (cd).moment[cn]) != Math.abs((mad_115_).power * (mad_115_).speed * (cd).moment[(mad_115_).cn])) {
                    if (Math.abs(power * speed * (cd).moment[cn]) > Math.abs((mad_115_).power * (mad_115_).speed * (cd).moment[(mad_115_).cn]))
                        dominate[(mad_115_).im] = true;
                    else
                        dominate[(mad_115_).im] = false;
                } else if ((cd).moment[cn] > (cd).moment[(mad_115_).cn])
                    dominate[(mad_115_).im] = true;
                else
                    dominate[(mad_115_).im] = false;
                caught[(mad_115_).im] = true;
            }
        } else if (caught[(mad_115_).im])
            caught[(mad_115_).im] = false;
        if (dominate[(mad_115_).im]) {
            int i = (int) (((scz[0] - (mad_115_).scz[0] + scz[1] - (mad_115_).scz[1] + scz[2] - (mad_115_).scz[2] + scz[3] - (mad_115_).scz[3]) * (scz[0] - (mad_115_).scz[0] + scz[1] - (mad_115_).scz[1] + scz[2] - (mad_115_).scz[2] + scz[3] - (mad_115_).scz[3]) + (scx[0] - (mad_115_).scx[0] + scx[1] - (mad_115_).scx[1] + scx[2] - (mad_115_).scx[2] + scx[3] - (mad_115_).scx[3]) * (scx[0] - (mad_115_).scx[0] + scx[1] - (mad_115_).scx[1] + scx[2] - (mad_115_).scx[2] + scx[3] - (mad_115_).scx[3])) / 16.0F);
            int i_122_ = 7000;
            float f = 1.0F;
            if ((xt).multion != 0) {
                i_122_ = 28000;
                f = 1.27F;
            }
            for (int i_123_ = 0; i_123_ < 4; i_123_++) {
                for (int i_124_ = 0; i_124_ < 4; i_124_++) {
                    if ((float) rpy(fs[i_123_], fs_119_[i_124_], fs_117_[i_123_], fs_120_[i_124_], fs_118_[i_123_], fs_121_[i_124_]) < (float) (i + i_122_) * ((cd).comprad[(mad_115_).cn] + (cd).comprad[cn])) {
                        if (Math.abs(scx[i_123_] * (cd).moment[cn]) > Math.abs((mad_115_).scx[i_124_] * (cd).moment[(mad_115_).cn])) {
                            float f_125_ = (mad_115_).scx[i_124_] * (float) (cd).revpush[cn];
                            if (f_125_ > 300.0F)
                                f_125_ = 300.0F;
                            if (f_125_ < -300.0F)
                                f_125_ = -300.0F;
                            float f_126_ = scx[i_123_] * (float) (cd).push[cn];
                            if (f_126_ > 300.0F)
                                f_126_ = 300.0F;
                            if (f_126_ < -300.0F)
                                f_126_ = -300.0F;
                            (mad_115_).scx[i_124_] += f_126_;
                            if (im == (xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regx(i_124_, f_126_ * (cd).moment[cn] * f, conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            scx[i_123_] -= f_125_;
                            regx(i_123_, -f_125_ * (cd).moment[cn] * f, conto);
                            scy[i_123_] -= (float) (cd).revlift[cn];
                            if (im == (xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regy(i_124_, (float) ((cd).revlift[cn] * 7), conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            if (m.random() > m.random())
                                conto_116_.sprk((fs[i_123_] + fs_119_[i_124_]) / 2.0F, (fs_117_[i_123_] + fs_120_[i_124_]) / 2.0F, (fs_118_[i_123_] + fs_121_[i_124_]) / 2.0F, ((mad_115_).scx[i_124_] + scx[i_123_]) / 4.0F, ((mad_115_).scy[i_124_] + scy[i_123_]) / 4.0F, ((mad_115_).scz[i_124_] + scz[i_123_]) / 4.0F, 2);
                        }
                        if (Math.abs(scz[i_123_] * (cd).moment[cn]) > Math.abs((mad_115_).scz[i_124_] * (cd).moment[(mad_115_).cn])) {
                            float f_127_ = (mad_115_).scz[i_124_] * (float) (cd).revpush[cn];
                            if (f_127_ > 300.0F)
                                f_127_ = 300.0F;
                            if (f_127_ < -300.0F)
                                f_127_ = -300.0F;
                            float f_128_ = scz[i_123_] * (float) (cd).push[cn];
                            if (f_128_ > 300.0F)
                                f_128_ = 300.0F;
                            if (f_128_ < -300.0F)
                                f_128_ = -300.0F;
                            (mad_115_).scz[i_124_] += f_128_;
                            if (im == (xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regz(i_124_, f_128_ * (cd).moment[cn] * f, conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            scz[i_123_] -= f_127_;
                            regz(i_123_, -f_127_ * (cd).moment[cn] * f, conto);
                            scy[i_123_] -= (float) (cd).revlift[cn];
                            if (im == (xt).im)
                                (mad_115_).colidim = true;
                            mad_115_.regy(i_124_, (float) ((cd).revlift[cn] * 7), conto_116_);
                            if ((mad_115_).colidim)
                                (mad_115_).colidim = false;
                            if (m.random() > m.random())
                                conto_116_.sprk((fs[i_123_] + fs_119_[i_124_]) / 2.0F, (fs_117_[i_123_] + fs_120_[i_124_]) / 2.0F, (fs_118_[i_123_] + fs_121_[i_124_]) / 2.0F, ((mad_115_).scx[i_124_] + scx[i_123_]) / 4.0F, ((mad_115_).scy[i_124_] + scy[i_123_]) / 4.0F, ((mad_115_).scz[i_124_] + scz[i_123_]) / 4.0F, 2);
                        }
                        if (im == (xt).im)
                            (mad_115_).lastcolido = 70;
                        if ((mad_115_).im == (xt).im)
                            lastcolido = 70;
                        (mad_115_).scy[i_124_] -= (float) (cd).lift[cn];
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
                fs[i_133_] = (float) i + ((f - (float) i) * m.cos(i_131_) - (f_134_ - (float) i_130_) * m.sin(i_131_));
                fs_129_[i_133_] = (float) i_130_ + ((f - (float) i) * m.sin(i_131_) + (f_134_ - (float) i_130_) * m.cos(i_131_));
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
