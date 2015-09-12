package stagemaker;

/* Control - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
public class Control
{
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    boolean handb = false;
    int lookback = 0;
    boolean enter = false;
    boolean exit = false;
    boolean arrace = false;
    boolean mutem = false;
    boolean mutes = false;
    boolean chatup = false;
    int multion = 0;
    Medium m;
    int pan = 0;
    int attack = 0;
    int acr = 0;
    boolean afta = false;
    int[] fpnt = new int[5];
    int trfix = 0;
    boolean forget = false;
    boolean bulistc = false;
    int runbul = 0;
    int acuracy = 0;
    int upwait = 0;
    boolean agressed = false;
    float skiplev = 1.0F;
    int clrnce = 5;
    int rampp = 0;
    int turntyp = 0;
    float aim = 0.0F;
    int saftey = 30;
    boolean perfection = false;
    float mustland = 0.5F;
    boolean usebounce = false;
    float trickprf = 0.5F;
    int stuntf = 0;
    boolean zyinv = false;
    boolean lastl = false;
    boolean wlastl = false;
    int hold = 0;
    int wall = -1;
    int lwall = -1;
    int stcnt = 0;
    int statusque = 0;
    int turncnt = 0;
    int randtcnt = 0;
    int upcnt = 0;
    int trickfase = 0;
    int swat = 0;
    boolean udcomp = false;
    boolean lrcomp = false;
    boolean udbare = false;
    boolean lrbare = false;
    boolean onceu = false;
    boolean onced = false;
    boolean oncel = false;
    boolean oncer = false;
    int lrdirect = 0;
    int uddirect = 0;
    int lrstart = 0;
    int udstart = 0;
    int oxy = 0;
    int ozy = 0;
    int flycnt = 0;
    boolean lrswt = false;
    boolean udswt = false;
    boolean gowait = false;
    int actwait = 0;
    int cntrn = 0;
    int revstart = 0;
    int oupnt = 0;
    int wtz = 0;
    int wtx = 0;
    int frx = 0;
    int frz = 0;
    int frad = 0;
    int apunch = 0;
    boolean exitattack = false;
    int avoidnlev = 0;
    
    public Control(Medium medium) {
        this.m = medium;
    }
    
    public void falseo(int i) {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        this.lookback = 0;
        this.enter = false;
        this.exit = false;
        if (i != 1) {
            this.arrace = false;
            this.chatup = false;
            if (i != 2)
                this.multion = 0;
            if (i != 3) {
                this.mutem = false;
                this.mutes = false;
            }
        }
    }
    
    public void reset(CheckPoints checkpoints, int i) {
        this.pan = 0;
        this.attack = 0;
        this.acr = 0;
        this.afta = false;
        this.trfix = 0;
        this.acuracy = 0;
        this.upwait = 0;
        this.forget = false;
        this.bulistc = false;
        this.runbul = 0;
        this.revstart = 0;
        this.oupnt = 0;
        this.gowait = false;
        this.apunch = 0;
        this.exitattack = false;
        if ((checkpoints).stage == 16 || (checkpoints).stage == 18)
            this.hold = 50;
        if ((checkpoints).stage == 17)
            this.hold = 10;
        if ((checkpoints).stage == 20)
            this.hold = 30;
        if ((checkpoints).stage == 21) {
            if (i != 13) {
                this.hold = 35;
                this.revstart = 25;
            } else
                this.hold = 5;
            this.statusque = 0;
        }
        if ((checkpoints).stage == 22) {
            if (i != 13) {
                this.hold = (int) (20.0F + 10.0F * this.m.random());
                this.revstart = (int) (10.0F + 10.0F * this.m.random());
            } else
                this.hold = 5;
            this.statusque = 0;
        }
        if ((checkpoints).stage == 24) {
            this.hold = 30;
            this.statusque = 0;
            if (i != 14)
                this.revstart = 1;
        }
        if ((checkpoints).stage == 25)
            this.hold = 40;
        if ((checkpoints).stage == 26)
            this.hold = 20;
        if ((checkpoints).stage != 19 && (checkpoints).stage != 26) {
            for (int i_0_ = 0; i_0_ < (checkpoints).fn; i_0_++) {
                int i_1_ = -10;
                for (int i_2_ = 0; i_2_ < (checkpoints).n; i_2_++) {
                    if (py((checkpoints).fx[i_0_] / 100, (checkpoints).x[i_2_] / 100, (checkpoints).fz[i_0_] / 100, (checkpoints).z[i_2_] / 100) < i_1_ || i_1_ == -10) {
                        i_1_ = py((checkpoints).fx[i_0_] / 100, (checkpoints).x[i_2_] / 100, (checkpoints).fz[i_0_] / 100, (checkpoints).z[i_2_] / 100);
                        this.fpnt[i_0_] = i_2_;
                    }
                }
            }
            for (int i_3_ = 0; i_3_ < (checkpoints).fn; i_3_++) {
                this.fpnt[i_3_] -= 4;
                if (this.fpnt[i_3_] < 0)
                    this.fpnt[i_3_] += (checkpoints).nsp;
            }
        } else {
            if ((checkpoints).stage == 19) {
                this.fpnt[0] = 14;
                this.fpnt[1] = 36;
            }
            if ((checkpoints).stage == 26)
                this.fpnt[3] = 39;
        }
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        this.lookback = 0;
        this.arrace = false;
        this.mutem = false;
        this.mutes = false;
    }
    
    public void preform(Mad mad, ContO conto, CheckPoints checkpoints, Trackers trackers) {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        if (!(mad).dest) {
            if ((mad).mtouch) {
                if (this.stcnt > this.statusque) {
                    int i = (checkpoints).stage;
                    if (i > 10)
                        i -= 10;
                    this.acuracy = (7 - (checkpoints).pos[(mad).im]) * (checkpoints).pos[0] * (6 - i * 2);
                    if (this.acuracy < 0 || (checkpoints).stage == -1)
                        this.acuracy = 0;
                    this.clrnce = 5;
                    if ((checkpoints).stage == 16 || (checkpoints).stage == 21)
                        this.clrnce = 2;
                    if ((checkpoints).stage == 22 && ((mad).pcleared == 27 || (mad).pcleared == 17))
                        this.clrnce = 3;
                    if ((checkpoints).stage == 26 && (mad).pcleared == 33)
                        this.clrnce = 3;
                    float f = 0.0F;
                    if ((checkpoints).stage == 1)
                        f = 2.0F;
                    if ((checkpoints).stage == 2)
                        f = 1.5F;
                    if ((checkpoints).stage == 3 && (mad).cn != 6)
                        f = 0.5F;
                    if ((checkpoints).stage == 4)
                        f = 0.5F;
                    if ((checkpoints).stage == 11)
                        f = 2.0F;
                    if ((checkpoints).stage == 12)
                        f = 1.5F;
                    if ((checkpoints).stage == 13 && (mad).cn != 9)
                        f = 0.5F;
                    if ((checkpoints).stage == 14)
                        f = 0.5F;
                    this.upwait = (int) ((float) (((checkpoints).pos[0] - (checkpoints).pos[(mad).im]) * ((checkpoints).pos[0] - (checkpoints).pos[(mad).im]) * ((checkpoints).pos[0] - (checkpoints).pos[(mad).im])) * f);
                    if (this.upwait > 80)
                        this.upwait = 80;
                    if (((checkpoints).stage == 11 || (checkpoints).stage == 1) && this.upwait < 20)
                        this.upwait = 20;
                    f = 0.0F;
                    if ((checkpoints).stage == 1 || (checkpoints).stage == 2)
                        f = 1.0F;
                    if ((checkpoints).stage == 4)
                        f = 0.5F;
                    if ((checkpoints).stage == 7)
                        f = 0.5F;
                    if ((checkpoints).stage == 10)
                        f = 0.5F;
                    if ((checkpoints).stage == 11 || (checkpoints).stage == 12)
                        f = 1.0F;
                    if ((checkpoints).stage == 13)
                        f = 0.5F;
                    if ((checkpoints).stage == 14)
                        f = 0.5F;
                    if ((checkpoints).stage == 15)
                        f = 0.2F;
                    if ((checkpoints).pos[(mad).im] - (checkpoints).pos[0] >= -1) {
                        this.skiplev -= 0.1;
                        if (this.skiplev < 0.0F)
                            this.skiplev = 0.0F;
                    } else {
                        this.skiplev += 0.2;
                        if (this.skiplev > f)
                            this.skiplev = f;
                    }
                    if ((checkpoints).stage == 18) {
                        if ((mad).pcleared >= 10 && (mad).pcleared <= 24)
                            this.skiplev = 1.0F;
                        else
                            this.skiplev = 0.0F;
                    }
                    if ((checkpoints).stage == 21) {
                        this.skiplev = 0.0F;
                        if ((mad).pcleared == 5)
                            this.skiplev = 1.0F;
                        if ((mad).pcleared == 28 || (mad).pcleared == 35)
                            this.skiplev = 0.5F;
                    }
                    if ((checkpoints).stage == 23)
                        this.skiplev = 0.5F;
                    if ((checkpoints).stage == 24 || (checkpoints).stage == 22)
                        this.skiplev = 1.0F;
                    if ((checkpoints).stage == 26 || (checkpoints).stage == 25 || (checkpoints).stage == 20)
                        this.skiplev = 0.0F;
                    this.rampp = (int) (this.m.random() * 4.0F - 2.0F);
                    if ((mad).power == 98.0F)
                        this.rampp = -1;
                    if ((mad).power < 75.0F && this.rampp == -1)
                        this.rampp = 0;
                    if ((mad).power < 60.0F)
                        this.rampp = 1;
                    if ((checkpoints).stage == 6)
                        this.rampp = 2;
                    if ((checkpoints).stage == 18 && (mad).pcleared >= 45)
                        this.rampp = 2;
                    if ((checkpoints).stage == 22 && (mad).pcleared == 17)
                        this.rampp = 2;
                    if ((checkpoints).stage == 25 || (checkpoints).stage == 26)
                        this.rampp = 0;
                    if (this.cntrn == 0) {
                        this.agressed = false;
                        this.turntyp = (int) (this.m.random() * 4.0F);
                        if ((checkpoints).stage == 3 && (mad).cn == 6) {
                            this.turntyp = 1;
                            if (this.attack == 0)
                                this.agressed = true;
                        }
                        if ((checkpoints).stage == 9 && (mad).cn == 15) {
                            this.turntyp = 1;
                            if (this.attack == 0)
                                this.agressed = true;
                        }
                        if ((checkpoints).stage == 13 && (mad).cn == 9) {
                            this.turntyp = 1;
                            if (this.attack == 0)
                                this.agressed = true;
                        }
                        if ((checkpoints).pos[0] - (checkpoints).pos[(mad).im] < 0)
                            this.turntyp = (int) (this.m.random() * 2.0F);
                        if ((checkpoints).stage == 10)
                            this.turntyp = 2;
                        if ((checkpoints).stage == 18)
                            this.turntyp = 2;
                        if ((checkpoints).stage == 20)
                            this.turntyp = 0;
                        if ((checkpoints).stage == 23)
                            this.turntyp = 1;
                        if ((checkpoints).stage == 24)
                            this.turntyp = 0;
                        if (this.attack != 0) {
                            this.turntyp = 2;
                            if ((checkpoints).stage == 9 || (checkpoints).stage == 10 || (checkpoints).stage == 19 || (checkpoints).stage == 21 || (checkpoints).stage == 23 || (checkpoints).stage == 27)
                                this.turntyp = (int) (this.m.random() * 3.0F);
                            if ((checkpoints).stage == 26 && (checkpoints).clear[(mad).im] - (checkpoints).clear[0] >= 5)
                                this.turntyp = 0;
                        }
                        if ((checkpoints).stage == 6) {
                            this.turntyp = 1;
                            this.agressed = true;
                        }
                        if ((checkpoints).stage == 7 || (checkpoints).stage == 9 || (checkpoints).stage == 10 || (checkpoints).stage == 16 || (checkpoints).stage == 17 || (checkpoints).stage == 19 || (checkpoints).stage == 20 || (checkpoints).stage == 21 || (checkpoints).stage == 22 || (checkpoints).stage == 24 || (checkpoints).stage == 26 || (checkpoints).stage == 27)
                            this.agressed = true;
                        if ((checkpoints).stage == -1) {
                            if (this.m.random() > this.m.random())
                                this.agressed = true;
                            else
                                this.agressed = false;
                        }
                        this.cntrn = 5;
                    } else
                        this.cntrn--;
                    this.saftey = (int) ((double) ((98.0F - (mad).power) / 2.0F) * ((double) (this.m.random() / 2.0F) + 0.5));
                    if (this.saftey > 20)
                        this.saftey = 20;
                    f = 0.0F;
                    if ((checkpoints).stage == 1 || (checkpoints).stage == 11)
                        f = 0.9F;
                    if ((checkpoints).stage == 2 || (checkpoints).stage == 12)
                        f = 0.7F;
                    if ((checkpoints).stage == 4 || (checkpoints).stage == 13)
                        f = 0.4F;
                    this.mustland = f + (float) ((double) (this.m.random() / 2.0F) - 0.25);
                    f = 1.0F;
                    if ((checkpoints).stage == 1 || (checkpoints).stage == 11)
                        f = 5.0F;
                    if ((checkpoints).stage == 2 || (checkpoints).stage == 12)
                        f = 2.0F;
                    if ((checkpoints).stage == 4 || (checkpoints).stage == 13)
                        f = 1.5F;
                    if ((mad).power > 50.0F) {
                        if ((checkpoints).pos[0] - (checkpoints).pos[(mad).im] > 0)
                            this.saftey *= f;
                        else
                            this.mustland = 0.0F;
                    } else
                        this.mustland -= 0.5F;
                    if ((checkpoints).stage == 18 || (checkpoints).stage == 20 || (checkpoints).stage == 22 || (checkpoints).stage == 24)
                        this.mustland = 0.0F;
                    this.stuntf = 0;
                    if ((checkpoints).stage == 8)
                        this.stuntf = 17;
                    if ((checkpoints).stage == 18 && (mad).pcleared == 57)
                        this.stuntf = 1;
                    if ((checkpoints).stage == 19 && (mad).pcleared == 3)
                        this.stuntf = 2;
                    if ((checkpoints).stage == 20) {
                        if ((checkpoints).pos[0] < (checkpoints).pos[(mad).im] || Math.abs((checkpoints).clear[0] - (mad).clear) >= 2 || (mad).clear < 2) {
                            this.stuntf = 4;
                            this.saftey = 10;
                        } else
                            this.stuntf = 3;
                    }
                    if ((checkpoints).stage == 21 && (mad).pcleared == 21)
                        this.stuntf = 1;
                    if ((checkpoints).stage == 24) {
                        this.saftey = 10;
                        if ((mad).pcleared >= 4 && (mad).pcleared < 70)
                            this.stuntf = 4;
                        else if ((mad).cn == 12 || (mad).cn == 8)
                            this.stuntf = 2;
                        if ((mad).cn == 14)
                            this.stuntf = 6;
                    }
                    if ((checkpoints).stage == 26) {
                        this.mustland = 0.0F;
                        this.saftey = 10;
                        if (((mad).pcleared == 15 || (mad).pcleared == 51) && ((double) this.m.random() > 0.4 || this.trfix != 0))
                            this.stuntf = 7;
                        if ((mad).pcleared == 42)
                            this.stuntf = 1;
                        if ((mad).pcleared == 77)
                            this.stuntf = 7;
                        this.avoidnlev = (int) (2700.0F * this.m.random());
                    }
                    this.trickprf = ((mad).power - 38.0F) / 50.0F - this.m.random() / 2.0F;
                    if ((mad).power < 60.0F)
                        this.trickprf = -1.0F;
                    if ((checkpoints).stage == 6 && (double) this.trickprf > 0.5)
                        this.trickprf = 0.5F;
                    if ((checkpoints).stage == 3 && (mad).cn == 6 && (double) this.trickprf > 0.7)
                        this.trickprf = 0.7F;
                    if ((checkpoints).stage == 13 && (mad).cn == 9 && (double) this.trickprf > 0.7)
                        this.trickprf = 0.7F;
                    if ((checkpoints).stage == 16 && (double) this.trickprf > 0.3)
                        this.trickprf = 0.3F;
                    if ((checkpoints).stage == 18 && (double) this.trickprf > 0.2)
                        this.trickprf = 0.2F;
                    if ((checkpoints).stage == 19) {
                        if ((double) this.trickprf > 0.5)
                            this.trickprf = 0.5F;
                        if (((mad).im == 6 || (mad).im == 5) && (double) this.trickprf > 0.3)
                            this.trickprf = 0.3F;
                    }
                    if ((checkpoints).stage == 21 && this.trickprf != -1.0F)
                        this.trickprf *= 0.75F;
                    if ((checkpoints).stage == 22 && ((mad).pcleared == 55 || (mad).pcleared == 7)) {
                        this.trickprf = -1.0F;
                        this.stuntf = 5;
                    }
                    if ((checkpoints).stage == 23 && (double) this.trickprf > 0.4)
                        this.trickprf = 0.4F;
                    if ((checkpoints).stage == 24 && (double) this.trickprf > 0.5)
                        this.trickprf = 0.5F;
                    if ((checkpoints).stage == 27)
                        this.trickprf = -1.0F;
                    if (this.m.random() > (mad).power / 100.0F)
                        this.usebounce = true;
                    else
                        this.usebounce = false;
                    if ((checkpoints).stage == 9)
                        this.usebounce = false;
                    if ((checkpoints).stage == 14 || (checkpoints).stage == 16)
                        this.usebounce = true;
                    if ((checkpoints).stage == 20 || (checkpoints).stage == 24)
                        this.usebounce = false;
                    if (this.m.random() > (float) (mad).hitmag / (float) ((mad).cd).maxmag[(mad).cn])
                        this.perfection = false;
                    else
                        this.perfection = true;
                    if (100.0F * (float) (mad).hitmag / (float) ((mad).cd).maxmag[(mad).cn] > 60.0F)
                        this.perfection = true;
                    if ((checkpoints).stage == 3 && (mad).cn == 6)
                        this.perfection = true;
                    if ((checkpoints).stage == 6 || (checkpoints).stage == 8 || (checkpoints).stage == 9 || (checkpoints).stage == 10 || (checkpoints).stage == 16 || (checkpoints).stage == 18 || (checkpoints).stage == 19 || (checkpoints).stage == 20 || (checkpoints).stage == 21 || (checkpoints).stage == 22 || (checkpoints).stage == 24 || (checkpoints).stage == 26 || (checkpoints).stage == 27)
                        this.perfection = true;
                    if (this.attack == 0) {
                        boolean bool = true;
                        if ((checkpoints).stage == 3 || (checkpoints).stage == 1 || (checkpoints).stage == 4 || (checkpoints).stage == 9 || (checkpoints).stage == 13 || (checkpoints).stage == 11 || (checkpoints).stage == 14 || (checkpoints).stage == 19 || (checkpoints).stage == 23 || (checkpoints).stage == 26)
                            bool = this.afta;
                        if ((checkpoints).stage == 8 || (checkpoints).stage == 6 || (checkpoints).stage == 18 || (checkpoints).stage == 16 || (checkpoints).stage == 20 || (checkpoints).stage == 24)
                            bool = false;
                        if ((checkpoints).stage == 3 && (mad).cn == 6)
                            bool = false;
                        if ((checkpoints).stage == -1 && this.m.random() > this.m.random())
                            bool = false;
                        boolean bool_4_ = false;
                        if ((checkpoints).stage == 13 && (mad).cn == 9)
                            bool_4_ = true;
                        if ((checkpoints).stage == 18 && (mad).cn == 11)
                            bool_4_ = true;
                        if ((checkpoints).stage == 19 && (checkpoints).clear[0] >= 20)
                            bool_4_ = true;
                        if ((checkpoints).stage == 4 || (checkpoints).stage == 10 || (checkpoints).stage == 21 || (checkpoints).stage == 22 || (checkpoints).stage == 23 || (checkpoints).stage == 25 || (checkpoints).stage == 26)
                            bool_4_ = true;
                        if ((checkpoints).stage == 3 && (mad).cn == 6)
                            bool_4_ = true;
                        int i_5_ = 60;
                        if ((checkpoints).stage == 5)
                            i_5_ = 40;
                        if ((checkpoints).stage == 6 && this.bulistc)
                            i_5_ = 40;
                        if ((checkpoints).stage == 9 && this.bulistc)
                            i_5_ = 30;
                        if ((checkpoints).stage == 3 || (checkpoints).stage == 13 || (checkpoints).stage == 21 || (checkpoints).stage == 27 || (checkpoints).stage == 20 || (checkpoints).stage == 18)
                            i_5_ = 30;
                        if (((checkpoints).stage == 12 || (checkpoints).stage == 23) && (mad).cn == 13)
                            i_5_ = 50;
                        if ((checkpoints).stage == 14)
                            i_5_ = 20;
                        if ((checkpoints).stage == 15 && (mad).im != 6)
                            i_5_ = 40;
                        if ((checkpoints).stage == 17)
                            i_5_ = 40;
                        if ((checkpoints).stage == 18 && (mad).cn == 11)
                            i_5_ = 40;
                        if ((checkpoints).stage == 19 && bool_4_)
                            i_5_ = 30;
                        if ((checkpoints).stage == 21 && this.bulistc)
                            i_5_ = 30;
                        if ((checkpoints).stage == 22)
                            i_5_ = 50;
                        if ((checkpoints).stage == 25 && this.bulistc)
                            i_5_ = 40;
                        if ((checkpoints).stage == 26) {
                            if ((mad).cn == 11 && (checkpoints).clear[0] == 27)
                                i_5_ = 0;
                            if ((mad).cn == 15 || (mad).cn == 9)
                                i_5_ = 50;
                            if ((mad).cn == 11)
                                i_5_ = 40;
                            if ((checkpoints).pos[0] > (checkpoints).pos[(mad).im])
                                i_5_ = 80;
                        }
                        for (int i_6_ = 0; i_6_ < 7; i_6_++) {
                            if (i_6_ != (mad).im && (checkpoints).clear[i_6_] != -1) {
                                int i_7_ = (conto).xz;
                                if (this.zyinv)
                                    i_7_ += 180;
                                for (/**/; i_7_ < 0; i_7_ += 360) {
                                    /* empty */
                                }
                                for (/**/; i_7_ > 180; i_7_ -= 360) {
                                    /* empty */
                                }
                                int i_8_ = 0;
                                if ((checkpoints).opx[i_6_] - (conto).x >= 0)
                                    i_8_ = 180;
                                int i_9_;
                                for (i_9_ = (int) ((double) (90 + i_8_) + Math.atan((double) ((checkpoints).opz[i_6_] - (conto).z) / (double) ((checkpoints).opx[i_6_] - (conto).x)) / 0.017453292519943295); i_9_ < 0; i_9_ += 360) {
                                    /* empty */
                                }
                                for (/**/; i_9_ > 180; i_9_ -= 360) {
                                    /* empty */
                                }
                                int i_10_ = Math.abs(i_7_ - i_9_);
                                if (i_10_ > 180)
                                    i_10_ = Math.abs(i_10_ - 360);
                                int i_11_ = 2000 * (Math.abs((checkpoints).clear[i_6_] - (mad).clear) + 1);
                                if (((checkpoints).stage == 6 || (checkpoints).stage == 9) && this.bulistc)
                                    i_11_ = 6000;
                                if ((checkpoints).stage == 3 && (mad).cn == 6 && (checkpoints).wasted < 2 && i_11_ > 4000)
                                    i_11_ = 4000;
                                if ((checkpoints).stage == 13 && (mad).cn == 9 && i_11_ < 12000)
                                    i_11_ = 12000;
                                if ((checkpoints).stage == 14 && i_11_ < 4000)
                                    i_11_ = 4000;
                                if ((checkpoints).stage == 18 && (mad).cn == 11) {
                                    if (i_11_ < 12000)
                                        i_11_ = 12000;
                                    i_10_ = 10;
                                }
                                if ((checkpoints).stage == 19 && ((mad).pcleared == 13 || (mad).pcleared == 33 || bool_4_) && i_11_ < 12000)
                                    i_11_ = 12000;
                                if ((checkpoints).stage == 21) {
                                    if (this.bulistc) {
                                        i_11_ = 8000;
                                        i_10_ = 10;
                                        this.afta = true;
                                    } else if (i_11_ < 6000)
                                        i_11_ = 6000;
                                }
                                if ((checkpoints).stage == 22 && this.bulistc) {
                                    i_11_ = 6000;
                                    i_10_ = 10;
                                }
                                if ((checkpoints).stage == 23)
                                    i_11_ = 21000;
                                if ((checkpoints).stage == 25) {
                                    i_11_ *= Math.abs((checkpoints).clear[i_6_] - (mad).clear) + 1;
                                    if (this.bulistc) {
                                        i_11_ = 4000 * (Math.abs((checkpoints).clear[i_6_] - (mad).clear) + 1);
                                        i_10_ = 10;
                                    }
                                }
                                if ((checkpoints).stage == 20)
                                    i_11_ = 16000;
                                if ((checkpoints).stage == 26) {
                                    if ((mad).cn == 13 && this.bulistc) {
                                        if (this.oupnt == 33)
                                            i_11_ = 17000;
                                        if (this.oupnt == 51)
                                            i_11_ = 30000;
                                        if (this.oupnt == 15 && (checkpoints).clear[0] >= 14)
                                            i_11_ = 60000;
                                        i_10_ = 10;
                                    }
                                    if ((mad).cn == 15 || (mad).cn == 9)
                                        i_11_ *= Math.abs((checkpoints).clear[i_6_] - (mad).clear) + 1;
                                    if ((mad).cn == 11)
                                        i_11_ = 4000 * (Math.abs((checkpoints).clear[i_6_] - (mad).clear) + 1);
                                }
                                int i_12_ = 85 + 15 * (Math.abs((checkpoints).clear[i_6_] - (mad).clear) + 1);
                                if ((checkpoints).stage == 23)
                                    i_12_ = 45;
                                if ((checkpoints).stage == 26 && ((mad).cn == 15 || (mad).cn == 9 || (mad).cn == 11 || (mad).cn == 14))
                                    i_12_ = 50 + 70 * Math.abs((checkpoints).clear[i_6_] - (mad).clear);
                                if (i_10_ < i_12_ && py((conto).x / 100, (checkpoints).opx[i_6_] / 100, (conto).z / 100, (checkpoints).opz[i_6_] / 100) < i_11_ && this.afta && (mad).power > (float) i_5_) {
                                    float f_13_ = (float) (35 - Math.abs((checkpoints).clear[i_6_] - (mad).clear) * 10);
                                    if (f_13_ < 1.0F)
                                        f_13_ = 1.0F;
                                    float f_14_ = (float) (((checkpoints).pos[(mad).im] + 1) * (5 - (checkpoints).pos[i_6_])) / f_13_;
                                    if ((checkpoints).stage != 27 && (double) f_14_ > 0.7)
                                        f_14_ = 0.7F;
                                    if (i_6_ != 0 && (checkpoints).pos[0] < (checkpoints).pos[(mad).im])
                                        f_14_ = 0.0F;
                                    if (i_6_ != 0 && bool_4_)
                                        f_14_ = 0.0F;
                                    if (bool_4_ && (checkpoints).stage == 3 && i_6_ == 0) {
                                        if ((checkpoints).wasted >= 2)
                                            f_14_ *= 0.5F;
                                        else
                                            f_14_ = 0.0F;
                                    }
                                    if (((checkpoints).stage == 3 || (checkpoints).stage == 9) && i_6_ == 4)
                                        f_14_ = 0.0F;
                                    if ((checkpoints).stage == 6) {
                                        f_14_ = 0.0F;
                                        if (this.bulistc && i_6_ == 0)
                                            f_14_ = 1.0F;
                                    }
                                    if ((checkpoints).stage == 8) {
                                        f_14_ = 0.0F;
                                        if (this.bulistc && (mad).cn != 11 && (mad).cn != 13)
                                            f_14_ = 1.0F;
                                    }
                                    if ((checkpoints).stage == 9 && (mad).cn == 15)
                                        f_14_ = 0.0F;
                                    if ((checkpoints).stage == 9 && this.bulistc) {
                                        if (i_6_ == 0)
                                            f_14_ = 1.0F;
                                        else
                                            f_14_ = 0.0F;
                                    }
                                    if ((checkpoints).stage == 9 && ((checkpoints).pos[i_6_] == 4 || (checkpoints).pos[i_6_] == 3))
                                        f_14_ = 0.0F;
                                    if ((checkpoints).stage == 13) {
                                        if ((mad).cn == 9 || (mad).cn == 13 && this.bulistc)
                                            f_14_ *= 2.0F;
                                        else
                                            f_14_ *= 0.5F;
                                    }
                                    if ((checkpoints).stage == 16)
                                        f_14_ = 0.0F;
                                    if ((checkpoints).stage == 17 && (mad).im == 6 && i_6_ == 0)
                                        f_14_ *= 1.5;
                                    if ((checkpoints).stage == 18) {
                                        if ((mad).cn == 11 || (mad).cn == 13 && this.bulistc)
                                            f_14_ *= 1.5F;
                                        else
                                            f_14_ = 0.0F;
                                    }
                                    if ((checkpoints).stage == 19) {
                                        if (i_6_ != 0)
                                            f_14_ *= 0.5;
                                        if ((mad).pcleared != 13 && (mad).pcleared != 33 && !bool_4_)
                                            f_14_ *= 0.5F;
                                        if (((mad).im == 6 || (mad).im == 5) && i_6_ != 0)
                                            f_14_ = 0.0F;
                                    }
                                    if ((checkpoints).stage == 20) {
                                        f_14_ = 0.0F;
                                        if (this.bulistc && (mad).cn != 11 && (mad).cn != 13)
                                            f_14_ = 1.0F;
                                    }
                                    if ((checkpoints).stage == 21 && this.bulistc && i_6_ == 0)
                                        f_14_ = 1.0F;
                                    if ((checkpoints).stage == 22) {
                                        if ((mad).cn != 11 && (mad).cn != 13)
                                            f_14_ = 0.0F;
                                        if ((mad).cn == 13 && i_6_ == 0)
                                            f_14_ = 1.0F;
                                    }
                                    if ((checkpoints).stage == 24)
                                        f_14_ = 0.0F;
                                    if ((checkpoints).stage == 25) {
                                        if ((checkpoints).pos[(mad).im] == 0)
                                            f_14_ *= 0.5;
                                        if ((checkpoints).pos[0] < (checkpoints).pos[(mad).im])
                                            f_14_ *= 2.0F;
                                        if (this.bulistc && i_6_ == 0)
                                            f_14_ = 1.0F;
                                    }
                                    if ((checkpoints).stage == 26) {
                                        if ((mad).cn != 14) {
                                            if ((checkpoints).pos[0] < (checkpoints).pos[(mad).im] && (checkpoints).clear[0] - (checkpoints).clear[(mad).im] != 1)
                                                f_14_ *= 2.0F;
                                        } else
                                            f_14_ *= 0.5;
                                        if ((mad).cn == 13 && i_6_ == 0)
                                            f_14_ = 1.0F;
                                        if ((checkpoints).pos[(mad).im] == 0 || (checkpoints).pos[(mad).im] == 1 && (checkpoints).pos[0] == 0)
                                            f_14_ = 0.0F;
                                        if ((checkpoints).clear[(mad).im] - (checkpoints).clear[0] >= 5 && i_6_ == 0)
                                            f_14_ = 1.0F;
                                        if ((mad).cn == 10 || (mad).cn == 12)
                                            f_14_ = 0.0F;
                                    }
                                    if (this.m.random() < f_14_) {
                                        this.attack = 40 * (Math.abs((checkpoints).clear[i_6_] - (mad).clear) + 1);
                                        if (this.attack > 500)
                                            this.attack = 500;
                                        this.aim = 0.0F;
                                        if ((checkpoints).stage == 13 && (mad).cn == 9 && this.m.random() > this.m.random())
                                            this.aim = 1.0F;
                                        if ((checkpoints).stage == 14) {
                                            if (i_6_ == 0 && (checkpoints).pos[0] < (checkpoints).pos[(mad).im])
                                                this.aim = 1.5F;
                                            else
                                                this.aim = this.m.random();
                                        }
                                        if ((checkpoints).stage == 15)
                                            this.aim = this.m.random() * 1.5F;
                                        if ((checkpoints).stage == 17 && (mad).im != 6 && (this.m.random() > this.m.random() || (checkpoints).pos[0] < (checkpoints).pos[(mad).im]))
                                            this.aim = 1.0F;
                                        if ((checkpoints).stage == 18 && (mad).cn == 11 && this.m.random() > this.m.random())
                                            this.aim = 0.76F + this.m.random() * 0.76F;
                                        if ((checkpoints).stage == 19 && ((mad).pcleared == 13 || (mad).pcleared == 33))
                                            this.aim = 1.0F;
                                        if ((checkpoints).stage == 21) {
                                            if (this.bulistc) {
                                                this.aim = 0.7F;
                                                if (this.attack > 150)
                                                    this.attack = 150;
                                            } else
                                                this.aim = this.m.random();
                                        }
                                        if ((checkpoints).stage == 22) {
                                            if (this.m.random() > this.m.random())
                                                this.aim = 0.7F;
                                            if (this.bulistc && this.attack > 150)
                                                this.attack = 150;
                                        }
                                        if ((checkpoints).stage == 23 && this.attack > 60)
                                            this.attack = 60;
                                        if ((checkpoints).stage == 25) {
                                            this.aim = this.m.random() * 1.5F;
                                            this.attack = this.attack / 2;
                                            if (this.m.random() > this.m.random())
                                                this.exitattack = true;
                                            else
                                                this.exitattack = false;
                                        }
                                        if ((checkpoints).stage == 26) {
                                            if ((mad).cn == 13) {
                                                this.aim = 0.76F;
                                                this.attack = 150;
                                            } else {
                                                this.aim = this.m.random() * 1.5F;
                                                if (Math.abs((checkpoints).clear[i_6_] - (mad).clear) <= 2 || (mad).cn == 14)
                                                    this.attack = this.attack / 3;
                                            }
                                        }
                                        if ((checkpoints).stage == -1 && this.m.random() > this.m.random())
                                            this.aim = this.m.random() * 1.5F;
                                        this.acr = i_6_;
                                        this.turntyp = (int) (1.0F + this.m.random() * 2.0F);
                                    }
                                }
                                if (bool && i_10_ > 100 && py((conto).x / 100, (checkpoints).opx[i_6_] / 100, (conto).z / 100, (checkpoints).opz[i_6_] / 100) < 300 && (double) this.m.random() > 0.6 - (double) ((float) (checkpoints).pos[(mad).im] / 10.0F)) {
                                    this.clrnce = 0;
                                    this.acuracy = 0;
                                }
                            }
                        }
                    }
                    boolean bool = false;
                    if ((checkpoints).stage == 6 || (checkpoints).stage == 8)
                        bool = true;
                    if ((checkpoints).stage == 9 && (mad).cn == 15)
                        bool = true;
                    if ((checkpoints).stage == 16 || (checkpoints).stage == 20 || (checkpoints).stage == 21 || (checkpoints).stage == 27)
                        bool = true;
                    if ((checkpoints).stage == 18 && (mad).pcleared != 73)
                        bool = true;
                    if ((checkpoints).stage == -1 && this.m.random() > this.m.random())
                        bool = true;
                    if (this.trfix != 3) {
                        this.trfix = 0;
                        int i_15_ = 50;
                        if ((checkpoints).stage == 26)
                            i_15_ = 40;
                        if (100.0F * (float) (mad).hitmag / (float) ((mad).cd).maxmag[(mad).cn] > (float) i_15_)
                            this.trfix = 1;
                        if (!bool) {
                            int i_16_ = 80;
                            if ((checkpoints).stage == 18 && (mad).cn != 11)
                                i_16_ = 50;
                            if ((checkpoints).stage == 19)
                                i_16_ = 70;
                            if ((checkpoints).stage == 25 && (mad).pcleared == 91)
                                i_16_ = 50;
                            if ((checkpoints).stage == 26 && (checkpoints).clear[(mad).im] - (checkpoints).clear[0] >= 5 && (mad).cn != 10 && (mad).cn != 12)
                                i_16_ = 50;
                            if (100.0F * (float) (mad).hitmag / (float) ((mad).cd).maxmag[(mad).cn] > (float) i_16_)
                                this.trfix = 2;
                        }
                    } else {
                        this.upwait = 0;
                        this.acuracy = 0;
                        this.skiplev = 1.0F;
                        this.clrnce = 2;
                    }
                    if (!this.bulistc) {
                        if ((checkpoints).stage == 18 && (mad).cn == 11 && (mad).pcleared == 35) {
                            (mad).pcleared = 73;
                            (mad).clear = 0;
                            this.bulistc = true;
                            this.runbul = (int) (100.0F * this.m.random());
                        }
                        if ((checkpoints).stage == 21 && (mad).cn == 13)
                            this.bulistc = true;
                        if ((checkpoints).stage == 22 && (mad).cn == 13)
                            this.bulistc = true;
                        if ((checkpoints).stage == 25 && (checkpoints).clear[0] - (mad).clear >= 3 && this.trfix == 0) {
                            this.bulistc = true;
                            this.oupnt = -1;
                        }
                        if ((checkpoints).stage == 26) {
                            if ((mad).cn == 13 && (checkpoints).pcleared == 8) {
                                this.bulistc = true;
                                this.attack = 0;
                            }
                            if ((mad).cn == 11 && (checkpoints).clear[0] - (mad).clear >= 2 && this.trfix == 0) {
                                this.bulistc = true;
                                this.oupnt = -1;
                            }
                        }
                        if (((checkpoints).stage == 6 || (checkpoints).stage == 8 || (checkpoints).stage == 12 || (checkpoints).stage == 13 || (checkpoints).stage == 14 || (checkpoints).stage == 15 || (checkpoints).stage == 18 || (checkpoints).stage == 20 || (checkpoints).stage == 23) && (mad).cn == 13 && Math.abs((checkpoints).clear[0] - (mad).clear) >= 2)
                            this.bulistc = true;
                        if (((checkpoints).stage == 8 || (checkpoints).stage == 20) && (mad).cn == 11 && Math.abs((checkpoints).clear[0] - (mad).clear) >= 1)
                            this.bulistc = true;
                        if ((checkpoints).stage == 6 && (mad).cn == 11)
                            this.bulistc = true;
                        if ((checkpoints).stage == 9 && this.afta && ((checkpoints).pos[(mad).im] == 4 || (checkpoints).pos[(mad).im] == 3) && (mad).cn != 15 && this.trfix != 0)
                            this.bulistc = true;
                    } else if ((checkpoints).stage == 18) {
                        this.runbul--;
                        if ((mad).pcleared == 10)
                            this.runbul = 0;
                        if (this.runbul <= 0)
                            this.bulistc = false;
                    }
                    this.stcnt = 0;
                    this.statusque = (int) (20.0F * this.m.random());
                } else
                    this.stcnt++;
            }
            boolean bool = false;
            if (this.usebounce)
                bool = (mad).wtouch;
            else
                bool = (mad).mtouch;
            if (bool) {
                if (this.trickfase != 0)
                    this.trickfase = 0;
                if (this.trfix == 2 || this.trfix == 3)
                    this.attack = 0;
                if (this.attack == 0) {
                    if (this.upcnt < 30) {
                        if (this.revstart <= 0)
                            this.up = true;
                        else {
                            this.down = true;
                            this.revstart--;
                        }
                    }
                    if (this.upcnt < 25 + this.actwait)
                        this.upcnt++;
                    else {
                        this.upcnt = 0;
                        this.actwait = this.upwait;
                    }
                    int i = (mad).point;
                    int i_17_ = 50;
                    if ((checkpoints).stage == 9)
                        i_17_ = 20;
                    if ((checkpoints).stage == 18)
                        i_17_ = 20;
                    if ((checkpoints).stage == 25)
                        i_17_ = 40;
                    if ((checkpoints).stage == 26)
                        i_17_ = 20;
                    if (!this.bulistc || this.trfix == 2 || this.trfix == 3 || this.trfix == 4 || (mad).power < (float) i_17_) {
                        if (this.rampp == 1 && (checkpoints).typ[i] <= 0) {
                            int i_18_ = i + 1;
                            if (i_18_ >= (checkpoints).n)
                                i_18_ = 0;
                            if ((checkpoints).typ[i_18_] == -2)
                                i = i_18_;
                        }
                        if (this.rampp == -1 && (checkpoints).typ[i] == -2 && ++i >= (checkpoints).n)
                            i = 0;
                        if (this.m.random() > this.skiplev) {
                            int i_19_ = i;
                            boolean bool_20_ = false;
                            if ((checkpoints).typ[i_19_] > 0) {
                                int i_21_ = 0;
                                for (int i_22_ = 0; i_22_ < (checkpoints).n; i_22_++) {
                                    if ((checkpoints).typ[i_22_] > 0 && i_22_ < i_19_)
                                        i_21_++;
                                }
                                bool_20_ = (mad).clear != i_21_ + (mad).nlaps * (checkpoints).nsp;
                            }
                            while ((checkpoints).typ[i_19_] == 0 || (checkpoints).typ[i_19_] == -1 || (checkpoints).typ[i_19_] == -3 || bool_20_) {
                                i = i_19_;
                                if (++i_19_ >= (checkpoints).n)
                                    i_19_ = 0;
                                bool_20_ = false;
                                if ((checkpoints).typ[i_19_] > 0) {
                                    int i_23_ = 0;
                                    for (int i_24_ = 0; i_24_ < (checkpoints).n; i_24_++) {
                                        if ((checkpoints).typ[i_24_] > 0 && i_24_ < i_19_)
                                            i_23_++;
                                    }
                                    bool_20_ = (mad).clear != i_23_ + (mad).nlaps * (checkpoints).nsp;
                                }
                            }
                        } else if (this.m.random() > this.skiplev) {
                            while ((checkpoints).typ[i] == -1) {
                                if (++i >= (checkpoints).n)
                                    i = 0;
                            }
                        }
                        if ((checkpoints).stage == 18 && (mad).pcleared == 73 && this.trfix == 0 && (mad).clear != 0)
                            i = 10;
                        if ((checkpoints).stage == 19 && (mad).pcleared == 18 && this.trfix == 0)
                            i = 27;
                        if ((checkpoints).stage == 21) {
                            if ((mad).pcleared == 5 && this.trfix == 0 && (mad).power < 70.0F) {
                                if (i <= 16)
                                    i = 16;
                                else
                                    i = 21;
                            }
                            if ((mad).pcleared == 50)
                                i = 57;
                        }
                        if ((checkpoints).stage == 22 && ((mad).pcleared == 27 || (mad).pcleared == 37)) {
                            while ((checkpoints).typ[i] == -1) {
                                if (++i >= (checkpoints).n)
                                    i = 0;
                            }
                        }
                        if ((checkpoints).stage == 23) {
                            while ((checkpoints).typ[i] == -1) {
                                if (++i >= (checkpoints).n)
                                    i = 0;
                            }
                        }
                        if ((checkpoints).stage == 24) {
                            while ((checkpoints).typ[i] == -1) {
                                if (++i >= (checkpoints).n)
                                    i = 0;
                            }
                            if (!(mad).gtouch) {
                                while ((checkpoints).typ[i] == -2) {
                                    if (++i >= (checkpoints).n)
                                        i = 0;
                                }
                            }
                            if (this.oupnt >= 68)
                                i = 70;
                            else
                                this.oupnt = i;
                        }
                        if ((checkpoints).stage == 25) {
                            if ((mad).pcleared != 91 && (checkpoints).pos[0] < (checkpoints).pos[(mad).im] && (mad).cn != 13 || (checkpoints).pos[(mad).im] == 0 && ((mad).clear == 12 || (mad).clear == 20)) {
                                while ((checkpoints).typ[i] == -4) {
                                    if (++i >= (checkpoints).n)
                                        i = 0;
                                }
                            }
                            if ((mad).pcleared == 9) {
                                if (py((conto).x / 100, 297, (conto).z / 100, 347) < 400)
                                    this.oupnt = 1;
                                if (this.oupnt == 1 && i < 22)
                                    i = 22;
                            }
                            if ((mad).pcleared == 67) {
                                if (py((conto).x / 100, 28, (conto).z / 100, 494) < 4000)
                                    this.oupnt = 2;
                                if (this.oupnt == 2)
                                    i = 76;
                            }
                            if ((mad).pcleared == 76) {
                                if (py((conto).x / 100, -50, (conto).z / 100, 0) < 2000)
                                    this.oupnt = 3;
                                if (this.oupnt == 3)
                                    i = 91;
                                else
                                    i = 89;
                            }
                        }
                        if ((checkpoints).stage == 26) {
                            if ((mad).pcleared == 128) {
                                if (py((conto).x / 100, 0, (conto).z / 100, 229) < 1500 || (conto).z > 23000)
                                    this.oupnt = 128;
                                if (this.oupnt != 128)
                                    i = 3;
                            }
                            if ((mad).pcleared == 8) {
                                if (py((conto).x / 100, -207, (conto).z / 100, 549) < 1500 || (conto).x < -20700)
                                    this.oupnt = 8;
                                if (this.oupnt != 8)
                                    i = 12;
                            }
                            if ((mad).pcleared == 33) {
                                if (py((conto).x / 100, -60, (conto).z / 100, 168) < 250 || (conto).z > 17000)
                                    this.oupnt = 331;
                                if (py((conto).x / 100, -112, (conto).z / 100, 414) < 10000 || (conto).z > 40000)
                                    this.oupnt = 332;
                                if (this.oupnt != 331 && this.oupnt != 332) {
                                    if (this.trfix != 1)
                                        i = 38;
                                    else
                                        i = 39;
                                }
                                if (this.oupnt == 331)
                                    i = 71;
                            }
                            if ((mad).pcleared == 42) {
                                if (py((conto).x / 100, -269, (conto).z / 100, 493) < 100 || (conto).x < -27000)
                                    this.oupnt = 142;
                                if (this.oupnt != 142)
                                    i = 47;
                            }
                            if ((mad).pcleared == 51) {
                                if (py((conto).x / 100, -352, (conto).z / 100, 260) < 100 || (conto).z < 25000)
                                    this.oupnt = 511;
                                if (py((conto).x / 100, -325, (conto).z / 100, 10) < 2000 || (conto).x > -32000)
                                    this.oupnt = 512;
                                if (this.oupnt != 511 && this.oupnt != 512)
                                    i = 80;
                                if (this.oupnt == 511)
                                    i = 61;
                            }
                            if ((mad).pcleared == 77) {
                                if (py((conto).x / 100, -371, (conto).z / 100, 319) < 100 || (conto).z < 31000)
                                    this.oupnt = 77;
                                if (this.oupnt != 77) {
                                    i = 78;
                                    (mad).nofocus = true;
                                }
                            }
                            if ((mad).pcleared == 105) {
                                if (py((conto).x / 100, -179, (conto).z / 100, 10) < 2300 || (conto).z < 1050)
                                    this.oupnt = 105;
                                if (this.oupnt != 105)
                                    i = 65;
                                else
                                    i = 125;
                            }
                            if (this.trfix == 3) {
                                if (py((conto).x / 100, -52, (conto).z / 100, 448) < 100 || (conto).z > 45000)
                                    this.oupnt = 176;
                                if (this.oupnt != 176)
                                    i = 41;
                                else
                                    i = 43;
                            }
                            if ((checkpoints).clear[(mad).im] - (checkpoints).clear[0] >= 2 && py((conto).x / 100, (checkpoints).opx[0] / 100, (conto).z / 100, (checkpoints).opz[0] / 100) < 1000 + this.avoidnlev) {
                                int i_25_ = (conto).xz;
                                if (this.zyinv)
                                    i_25_ += 180;
                                for (/**/; i_25_ < 0; i_25_ += 360) {
                                    /* empty */
                                }
                                for (/**/; i_25_ > 180; i_25_ -= 360) {
                                    /* empty */
                                }
                                int i_26_ = 0;
                                if ((checkpoints).opx[0] - (conto).x >= 0)
                                    i_26_ = 180;
                                int i_27_;
                                for (i_27_ = (int) ((double) (90 + i_26_) + Math.atan((double) ((checkpoints).opz[0] - (conto).z) / (double) ((checkpoints).opx[0] - (conto).x)) / 0.017453292519943295); i_27_ < 0; i_27_ += 360) {
                                    /* empty */
                                }
                                for (/**/; i_27_ > 180; i_27_ -= 360) {
                                    /* empty */
                                }
                                int i_28_ = Math.abs(i_25_ - i_27_);
                                if (i_28_ > 180)
                                    i_28_ = Math.abs(i_28_ - 360);
                                if (i_28_ < 90)
                                    this.wall = 0;
                            }
                        }
                        if (this.rampp == 2) {
                            int i_29_ = i + 1;
                            if (i_29_ >= (checkpoints).n)
                                i_29_ = 0;
                            if ((checkpoints).typ[i_29_] == -2 && i != (mad).point && --i < 0)
                                i += (checkpoints).n;
                        }
                        if (this.bulistc) {
                            (mad).nofocus = true;
                            if (this.gowait)
                                this.gowait = false;
                        }
                    } else {
                        if ((checkpoints).stage != 25 && (checkpoints).stage != 26 || this.runbul == 0) {
                            i -= 2;
                            if (i < 0)
                                i += (checkpoints).n;
                            if ((checkpoints).stage == 9 && i > 76)
                                i = 76;
                            while ((checkpoints).typ[i] == -4) {
                                if (--i < 0)
                                    i += (checkpoints).n;
                            }
                        }
                        if ((checkpoints).stage == 21) {
                            if (i >= 14 && i <= 19)
                                i = 13;
                            if (this.oupnt == 72 && i != 56)
                                i = 57;
                            else if (this.oupnt == 54 && i != 52)
                                i = 53;
                            else if (this.oupnt == 39 && i != 37)
                                i = 38;
                            else
                                this.oupnt = i;
                        }
                        if ((checkpoints).stage == 22) {
                            if (!this.gowait) {
                                if ((checkpoints).clear[0] == 0) {
                                    this.wtx = -3500;
                                    this.wtz = 19000;
                                    this.frx = -3500;
                                    this.frz = 39000;
                                    this.frad = 12000;
                                    this.oupnt = 37;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if ((checkpoints).clear[0] == 7) {
                                    this.wtx = -44800;
                                    this.wtz = 40320;
                                    this.frx = -44800;
                                    this.frz = 34720;
                                    this.frad = 30000;
                                    this.oupnt = 27;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if ((checkpoints).clear[0] == 10) {
                                    this.wtx = 0;
                                    this.wtz = 48739;
                                    this.frx = 0;
                                    this.frz = 38589;
                                    this.frad = 90000;
                                    this.oupnt = 55;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if ((checkpoints).clear[0] == 14) {
                                    this.wtx = -3500;
                                    this.wtz = 19000;
                                    this.frx = -14700;
                                    this.frz = 39000;
                                    this.frad = 45000;
                                    this.oupnt = 37;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                                if ((checkpoints).clear[0] == 18) {
                                    this.wtx = -48300;
                                    this.wtz = -4550;
                                    this.frx = -48300;
                                    this.frz = 5600;
                                    this.frad = 90000;
                                    this.oupnt = 17;
                                    this.gowait = true;
                                    this.afta = false;
                                }
                            }
                            if (this.gowait) {
                                if (py((conto).x / 100, this.wtx / 100, (conto).z / 100, this.wtz / 100) < 10000 && (mad).speed > 50.0F)
                                    this.up = false;
                                if (py((conto).x / 100, this.wtx / 100, (conto).z / 100, this.wtz / 100) < 200) {
                                    this.up = false;
                                    this.handb = true;
                                }
                                if ((checkpoints).pcleared == this.oupnt && py((checkpoints).opx[0] / 100, this.frx / 100, (checkpoints).opz[0] / 100, this.frz / 100) < this.frad) {
                                    this.afta = true;
                                    this.gowait = false;
                                }
                                if (py((conto).x / 100, (checkpoints).opx[0] / 100, (conto).z / 100, (checkpoints).opz[0] / 100) < 25) {
                                    this.afta = true;
                                    this.gowait = false;
                                    this.attack = 200;
                                    this.acr = 0;
                                }
                            }
                        }
                        if ((checkpoints).stage == 25) {
                            if (this.oupnt == -1) {
                                int i_30_ = -10;
                                for (int i_31_ = 0; i_31_ < (checkpoints).n; i_31_++) {
                                    if (((checkpoints).typ[i_31_] == -2 || (checkpoints).typ[i_31_] == -4) && (i_31_ < 50 || i_31_ > 54) && (py((conto).x / 100, (checkpoints).x[i_31_] / 100, (conto).z / 100, (checkpoints).z[i_31_] / 100) < i_30_ || i_30_ == -10)) {
                                        i_30_ = py((conto).x / 100, (checkpoints).x[i_31_] / 100, (conto).z / 100, (checkpoints).z[i_31_] / 100);
                                        this.oupnt = i_31_;
                                    }
                                }
                                this.oupnt--;
                                if (i < 0)
                                    this.oupnt += (checkpoints).n;
                            }
                            if (this.oupnt >= 0 && this.oupnt < (checkpoints).n) {
                                i = this.oupnt;
                                if (py((conto).x / 100, (checkpoints).x[i] / 100, (conto).z / 100, (checkpoints).z[i] / 100) < 800) {
                                    this.oupnt = -(int) (75.0F + this.m.random() * 200.0F);
                                    this.runbul = (int) (50.0F + this.m.random() * 100.0F);
                                }
                            }
                            if (this.oupnt < -1)
                                this.oupnt++;
                            if (this.runbul != 0)
                                this.runbul--;
                        }
                        if ((checkpoints).stage == 26) {
                            boolean bool_32_ = false;
                            if ((mad).cn == 13) {
                                if (!this.gowait) {
                                    if ((checkpoints).clear[0] == 1) {
                                        if ((double) this.m.random() > 0.5) {
                                            this.wtx = -14000;
                                            this.wtz = 48000;
                                            this.frx = -5600;
                                            this.frz = 47600;
                                            this.frad = 88000;
                                            this.oupnt = 33;
                                        } else {
                                            this.wtx = -5600;
                                            this.wtz = 8000;
                                            this.frx = -7350;
                                            this.frz = -4550;
                                            this.frad = 22000;
                                            this.oupnt = 15;
                                        }
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if ((checkpoints).clear[0] == 4) {
                                        this.wtx = -12700;
                                        this.wtz = 14000;
                                        this.frx = -31000;
                                        this.frz = 1050;
                                        this.frad = 11000;
                                        this.oupnt = 51;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if ((checkpoints).clear[0] == 14) {
                                        this.wtx = -35350;
                                        this.wtz = 6650;
                                        this.frx = -48300;
                                        this.frz = 54950;
                                        this.frad = 11000;
                                        this.oupnt = 15;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if ((checkpoints).clear[0] == 17) {
                                        this.wtx = -42700;
                                        this.wtz = 41000;
                                        this.frx = -40950;
                                        this.frz = 49350;
                                        this.frad = 7000;
                                        this.oupnt = 42;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                    if ((checkpoints).clear[0] == 21) {
                                        this.wtx = -1750;
                                        this.wtz = -15750;
                                        this.frx = -25900;
                                        this.frz = -14000;
                                        this.frad = 11000;
                                        this.oupnt = 125;
                                        this.gowait = true;
                                        this.afta = false;
                                    }
                                }
                                if (this.gowait) {
                                    if (py((conto).x / 100, this.wtx / 100, (conto).z / 100, this.wtz / 100) < 10000 && (mad).speed > 50.0F)
                                        this.up = false;
                                    if (py((conto).x / 100, this.wtx / 100, (conto).z / 100, this.wtz / 100) < 200) {
                                        this.up = false;
                                        this.handb = true;
                                    }
                                    if ((checkpoints).pcleared == this.oupnt && py((checkpoints).opx[0] / 100, this.frx / 100, (checkpoints).opz[0] / 100, this.frz / 100) < this.frad) {
                                        this.runbul = 0;
                                        this.afta = true;
                                        this.gowait = false;
                                    }
                                    if (py((conto).x / 100, (checkpoints).opx[0] / 100, (conto).z / 100, (checkpoints).opz[0] / 100) < 25) {
                                        this.afta = true;
                                        this.gowait = false;
                                        this.attack = 200;
                                        this.acr = 0;
                                    }
                                    if ((checkpoints).clear[0] == 21 && this.oupnt != 125)
                                        this.gowait = false;
                                }
                                if ((checkpoints).clear[0] >= 11 && !this.gowait || (mad).power < 60.0F && (checkpoints).clear[0] < 21) {
                                    bool_32_ = true;
                                    if (!this.exitattack) {
                                        this.oupnt = -1;
                                        this.exitattack = true;
                                    }
                                } else if (this.exitattack)
                                    this.exitattack = false;
                            }
                            if ((mad).cn == 11)
                                bool_32_ = true;
                            if (bool_32_) {
                                if (this.oupnt == -1) {
                                    int i_33_ = -10;
                                    for (int i_34_ = 0; i_34_ < (checkpoints).n; i_34_++) {
                                        if ((checkpoints).typ[i_34_] == -4 && (py((conto).x / 100, (checkpoints).x[i_34_] / 100, (conto).z / 100, (checkpoints).z[i_34_] / 100) < i_33_ && (double) this.m.random() > 0.6 || i_33_ == -10)) {
                                            i_33_ = py((conto).x / 100, (checkpoints).x[i_34_] / 100, (conto).z / 100, (checkpoints).z[i_34_] / 100);
                                            this.oupnt = i_34_;
                                        }
                                    }
                                    this.oupnt--;
                                    if (i < 0)
                                        this.oupnt += (checkpoints).n;
                                }
                                if (this.oupnt >= 0 && this.oupnt < (checkpoints).n) {
                                    i = this.oupnt;
                                    if (py((conto).x / 100, (checkpoints).x[i] / 100, (conto).z / 100, (checkpoints).z[i] / 100) < 800) {
                                        this.oupnt = -(int) (75.0F + this.m.random() * 200.0F);
                                        this.runbul = (int) (50.0F + this.m.random() * 100.0F);
                                    }
                                }
                                if (this.oupnt < -1)
                                    this.oupnt++;
                                if (this.runbul != 0)
                                    this.runbul--;
                            }
                        }
                        (mad).nofocus = true;
                    }
                    if ((checkpoints).stage != 27) {
                        if ((checkpoints).stage == 10 || (checkpoints).stage == 19 || (checkpoints).stage == 18 && (mad).pcleared == 73 || (checkpoints).stage == 26)
                            this.forget = true;
                        if (((mad).missedcp == 0 || this.forget || this.trfix == 4) && this.trfix != 0) {
                            int i_35_ = 0;
                            if ((checkpoints).stage == 25 || (checkpoints).stage == 26)
                                i_35_ = 3;
                            if (this.trfix == 2) {
                                int i_36_ = -10;
                                int i_37_ = 0;
                                for (int i_38_ = i_35_; i_38_ < (checkpoints).fn; i_38_++) {
                                    if (py((conto).x / 100, (checkpoints).x[this.fpnt[i_38_]] / 100, (conto).z / 100, (checkpoints).z[this.fpnt[i_38_]] / 100) < i_36_ || i_36_ == -10) {
                                        i_36_ = py((conto).x / 100, (checkpoints).x[this.fpnt[i_38_]] / 100, (conto).z / 100, (checkpoints).z[this.fpnt[i_38_]] / 100);
                                        i_37_ = i_38_;
                                    }
                                }
                                if ((checkpoints).stage == 18 || (checkpoints).stage == 22)
                                    i_37_ = 1;
                                i = this.fpnt[i_37_];
                                if ((checkpoints).special[i_37_])
                                    this.forget = true;
                                else
                                    this.forget = false;
                            }
                            for (int i_39_ = i_35_; i_39_ < (checkpoints).fn; i_39_++) {
                                if (py((conto).x / 100, (checkpoints).x[this.fpnt[i_39_]] / 100, (conto).z / 100, (checkpoints).z[this.fpnt[i_39_]] / 100) < 2000) {
                                    this.forget = false;
                                    this.actwait = 0;
                                    this.upwait = 0;
                                    this.turntyp = 2;
                                    this.randtcnt = -1;
                                    this.acuracy = 0;
                                    this.rampp = 0;
                                    this.trfix = 3;
                                }
                            }
                            if (this.trfix == 3)
                                (mad).nofocus = true;
                        }
                    }
                    if (this.turncnt > this.randtcnt) {
                        if (!this.gowait) {
                            int i_40_ = 0;
                            if ((checkpoints).x[i] - (conto).x >= 0)
                                i_40_ = 180;
                            this.pan = (int) ((double) (90 + i_40_) + Math.atan((double) ((checkpoints).z[i] - (conto).z) / (double) ((checkpoints).x[i] - (conto).x)) / 0.017453292519943295);
                        } else {
                            int i_41_ = 0;
                            if (this.wtx - (conto).x >= 0)
                                i_41_ = 180;
                            this.pan = (int) ((double) (90 + i_41_) + Math.atan((double) (this.wtz - (conto).z) / (double) (this.wtx - (conto).x)) / 0.017453292519943295);
                        }
                        this.turncnt = 0;
                        this.randtcnt = (int) ((float) this.acuracy * this.m.random());
                    } else
                        this.turncnt++;
                } else {
                    this.up = true;
                    int i = 0;
                    int i_42_ = (int) ((float) pys((conto).x, (checkpoints).opx[this.acr], (conto).z, (checkpoints).opz[this.acr]) / 2.0F * this.aim);
                    int i_43_ = (int) ((float) (checkpoints).opx[this.acr] - (float) i_42_ * this.m.sin((checkpoints).omxz[this.acr]));
                    int i_44_ = (int) ((float) (checkpoints).opz[this.acr] + (float) i_42_ * this.m.cos((checkpoints).omxz[this.acr]));
                    if (i_43_ - (conto).x >= 0)
                        i = 180;
                    this.pan = (int) ((double) (90 + i) + Math.atan((double) (i_44_ - (conto).z) / (double) (i_43_ - (conto).x)) / 0.017453292519943295);
                    this.attack--;
                    if (this.attack <= 0)
                        this.attack = 0;
                    if ((checkpoints).stage == 25 && this.exitattack && !this.bulistc && (mad).missedcp != 0)
                        this.attack = 0;
                    if ((checkpoints).stage == 26 && (mad).cn == 13 && ((checkpoints).clear[0] == 4 || (checkpoints).clear[0] == 13 || (checkpoints).clear[0] == 21))
                        this.attack = 0;
                    if ((checkpoints).stage == 26 && (mad).missedcp != 0 && ((checkpoints).pos[(mad).im] == 0 || (checkpoints).pos[(mad).im] == 1 && (checkpoints).pos[0] == 0))
                        this.attack = 0;
                    if ((checkpoints).stage == 26 && (checkpoints).pos[0] > (checkpoints).pos[(mad).im] && (mad).power < 80.0F)
                        this.attack = 0;
                }
                int i = (conto).xz;
                if (this.zyinv)
                    i += 180;
                for (/**/; i < 0; i += 360) {
                    /* empty */
                }
                for (/**/; i > 180; i -= 360) {
                    /* empty */
                }
                for (/**/; this.pan < 0; this.pan += 360) {
                    /* empty */
                }
                for (/**/; this.pan > 180; this.pan -= 360) {
                    /* empty */
                }
                if (this.wall != -1 && this.hold == 0)
                    this.clrnce = 0;
                if (this.hold == 0) {
                    if (Math.abs(i - this.pan) < 180) {
                        if (Math.abs(i - this.pan) > this.clrnce) {
                            if (i < this.pan) {
                                this.left = true;
                                this.lastl = true;
                            } else {
                                this.right = true;
                                this.lastl = false;
                            }
                            if (Math.abs(i - this.pan) > 50 && (mad).speed > (float) ((mad).cd).swits[(mad).cn][0] && this.turntyp != 0) {
                                if (this.turntyp == 1)
                                    this.down = true;
                                if (this.turntyp == 2)
                                    this.handb = true;
                                if (!this.agressed)
                                    this.up = false;
                            }
                        }
                    } else if (Math.abs(i - this.pan) < 360 - this.clrnce) {
                        if (i < this.pan) {
                            this.right = true;
                            this.lastl = false;
                        } else {
                            this.left = true;
                            this.lastl = true;
                        }
                        if (Math.abs(i - this.pan) < 310 && (mad).speed > (float) ((mad).cd).swits[(mad).cn][0] && this.turntyp != 0) {
                            if (this.turntyp == 1)
                                this.down = true;
                            if (this.turntyp == 2)
                                this.handb = true;
                            if (!this.agressed)
                                this.up = false;
                        }
                    }
                }
                if ((checkpoints).stage == 24 && this.wall != -1) {
                    if ((trackers).dam[this.wall] == 0 || (mad).pcleared == 45)
                        this.wall = -1;
                    if ((mad).pcleared == 58 && (checkpoints).opz[(mad).im] < 36700) {
                        this.wall = -1;
                        this.hold = 0;
                    }
                }
                if (this.wall != -1) {
                    if (this.lwall != this.wall) {
                        if (this.lastl)
                            this.left = true;
                        else
                            this.right = true;
                        this.wlastl = this.lastl;
                        this.lwall = this.wall;
                    } else if (this.wlastl)
                        this.left = true;
                    else
                        this.right = true;
                    if ((trackers).dam[this.wall] != 0) {
                        int i_45_ = 1;
                        if ((trackers).skd[this.wall] == 1)
                            i_45_ = 3;
                        this.hold += i_45_;
                        if (this.hold > 10 * i_45_)
                            this.hold = 10 * i_45_;
                    } else
                        this.hold = 1;
                    this.wall = -1;
                } else if (this.hold != 0)
                    this.hold--;
            } else {
                if (this.trickfase == 0) {
                    int i = (int) (((mad).scy[0] + (mad).scy[1] + (mad).scy[2] + (mad).scy[3]) * (float) ((conto).y - 300) / 4000.0F);
                    int i_46_ = 3;
                    if ((checkpoints).stage == 25)
                        i_46_ = 10;
                    if (i > 7 && (this.m.random() > this.trickprf / (float) i_46_ || this.stuntf == 4 || this.stuntf == 3 || this.stuntf == 5 || this.stuntf == 6 || (checkpoints).stage == 26)) {
                        this.oxy = (mad).pxy;
                        this.ozy = (mad).pzy;
                        this.flycnt = 0;
                        this.uddirect = 0;
                        this.lrdirect = 0;
                        this.udswt = false;
                        this.lrswt = false;
                        this.trickfase = 1;
                        if (i < 16) {
                            if (this.stuntf != 6) {
                                this.uddirect = -1;
                                this.udstart = 0;
                                this.udswt = false;
                            } else if (this.oupnt != 70) {
                                this.uddirect = 1;
                                this.udstart = 0;
                                this.udswt = false;
                            }
                        } else if (this.m.random() > this.m.random() && this.stuntf != 1 || this.stuntf == 4 || this.stuntf == 6 || this.stuntf == 7 || this.stuntf == 17) {
                            if ((this.m.random() > this.m.random() || this.stuntf == 2 || this.stuntf == 7) && this.stuntf != 4 && this.stuntf != 6)
                                this.uddirect = -1;
                            else
                                this.uddirect = 1;
                            this.udstart = (int) (10.0F * this.m.random() * this.trickprf);
                            if (this.stuntf == 6)
                                this.udstart = 0;
                            if ((checkpoints).stage == 26)
                                this.udstart = 0;
                            if ((checkpoints).stage == 24 && (this.oupnt == 68 || this.oupnt == 69)) {
                                this.apunch = 20;
                                this.oupnt = 70;
                            }
                            if ((double) this.m.random() > 0.85 && this.stuntf != 4 && this.stuntf != 3 && this.stuntf != 6 && this.stuntf != 17 && (checkpoints).stage != 26)
                                this.udswt = true;
                            if (this.m.random() > this.trickprf + 0.3F && this.stuntf != 4 && this.stuntf != 6) {
                                if (this.m.random() > this.m.random())
                                    this.lrdirect = -1;
                                else
                                    this.lrdirect = 1;
                                this.lrstart = (int) (30.0F * this.m.random());
                                if ((double) this.m.random() > 0.75)
                                    this.lrswt = true;
                            }
                        } else {
                            if (this.m.random() > this.m.random())
                                this.lrdirect = -1;
                            else
                                this.lrdirect = 1;
                            this.lrstart = (int) (10.0F * this.m.random() * this.trickprf);
                            if ((double) this.m.random() > 0.75 && (checkpoints).stage != 26)
                                this.lrswt = true;
                            if (this.m.random() > this.trickprf + 0.3F) {
                                if (this.m.random() > this.m.random())
                                    this.uddirect = -1;
                                else
                                    this.uddirect = 1;
                                this.udstart = (int) (30.0F * this.m.random());
                                if ((double) this.m.random() > 0.85)
                                    this.udswt = true;
                            }
                        }
                        if (this.trfix == 3 || this.trfix == 4) {
                            if ((checkpoints).stage != 18 && (checkpoints).stage != 8) {
                                if ((checkpoints).stage != 25 && this.lrdirect == -1) {
                                    if ((checkpoints).stage != 19)
                                        this.uddirect = -1;
                                    else
                                        this.uddirect = 1;
                                }
                                this.lrdirect = 0;
                                if (((checkpoints).stage == 19 || (checkpoints).stage == 25) && this.uddirect == -1)
                                    this.uddirect = 1;
                                if ((mad).power < 60.0F)
                                    this.uddirect = -1;
                            } else {
                                if (this.uddirect != 0)
                                    this.uddirect = -1;
                                this.lrdirect = 0;
                            }
                            if ((checkpoints).stage == 20) {
                                this.uddirect = 1;
                                this.lrdirect = 0;
                            }
                            if ((checkpoints).stage == 26) {
                                this.uddirect = -1;
                                this.lrdirect = 0;
                                if ((mad).cn != 11 && (mad).cn != 13) {
                                    this.udstart = 7;
                                    if ((mad).cn == 14 && (mad).power > 30.0F)
                                        this.udstart = 14;
                                } else
                                    this.udstart = 0;
                                if ((mad).cn == 11) {
                                    this.lrdirect = -1;
                                    this.lrstart = 0;
                                }
                            }
                        }
                    } else
                        this.trickfase = -1;
                    if (!this.afta)
                        this.afta = true;
                    if (this.trfix == 3) {
                        this.trfix = 4;
                        this.statusque += 30;
                    }
                }
                if (this.trickfase == 1) {
                    this.flycnt++;
                    if (this.lrdirect != 0 && this.flycnt > this.lrstart) {
                        if (this.lrswt && Math.abs((mad).pxy - this.oxy) > 180) {
                            if (this.lrdirect == -1)
                                this.lrdirect = 1;
                            else
                                this.lrdirect = -1;
                            this.lrswt = false;
                        }
                        if (this.lrdirect == -1) {
                            this.handb = true;
                            this.left = true;
                        } else {
                            this.handb = true;
                            this.right = true;
                        }
                    }
                    if (this.uddirect != 0 && this.flycnt > this.udstart) {
                        if (this.udswt && Math.abs((mad).pzy - this.ozy) > 180) {
                            if (this.uddirect == -1)
                                this.uddirect = 1;
                            else
                                this.uddirect = -1;
                            this.udswt = false;
                        }
                        if (this.uddirect == -1) {
                            this.handb = true;
                            this.down = true;
                        } else {
                            this.handb = true;
                            this.up = true;
                            if (this.apunch > 0) {
                                this.down = true;
                                this.apunch--;
                            }
                        }
                    }
                    if (((mad).scy[0] + (mad).scy[1] + (mad).scy[2] + (mad).scy[3]) * 100.0F / (float) ((conto).y - 300) < (float) -this.saftey) {
                        this.onceu = false;
                        this.onced = false;
                        this.oncel = false;
                        this.oncer = false;
                        this.lrcomp = false;
                        this.udcomp = false;
                        this.udbare = false;
                        this.lrbare = false;
                        this.trickfase = 2;
                        this.swat = 0;
                    }
                }
                if (this.trickfase == 2) {
                    if (this.swat == 0) {
                        if ((mad).dcomp != 0.0F || (mad).ucomp != 0.0F)
                            this.udbare = true;
                        if ((mad).lcomp != 0.0F || (mad).rcomp != 0.0F)
                            this.lrbare = true;
                        this.swat = 1;
                    }
                    if ((mad).wtouch) {
                        if (this.swat == 1)
                            this.swat = 2;
                    } else if (this.swat == 2) {
                        if ((mad).capsized && this.m.random() > this.mustland) {
                            if (this.udbare) {
                                this.lrbare = true;
                                this.udbare = false;
                            } else if (this.lrbare) {
                                this.udbare = true;
                                this.lrbare = false;
                            }
                        }
                        this.swat = 3;
                    }
                    if (this.udbare) {
                        int i;
                        for (i = (mad).pzy + 90; i < 0; i += 360) {
                            /* empty */
                        }
                        for (/**/; i > 180; i -= 360) {
                            /* empty */
                        }
                        i = Math.abs(i);
                        if ((mad).lcomp - (mad).rcomp < 5.0F && (this.onced || this.onceu))
                            this.udcomp = true;
                        if ((mad).dcomp > (mad).ucomp) {
                            if ((mad).capsized) {
                                if (this.udcomp) {
                                    if (i > 90)
                                        this.up = true;
                                    else
                                        this.down = true;
                                } else if (!this.onced)
                                    this.down = true;
                            } else {
                                if (this.udcomp) {
                                    if (this.perfection && Math.abs(i - 90) > 30) {
                                        if (i > 90)
                                            this.up = true;
                                        else
                                            this.down = true;
                                    }
                                } else if (this.m.random() > this.mustland)
                                    this.up = true;
                                this.onced = true;
                            }
                        } else if ((mad).capsized) {
                            if (this.udcomp) {
                                if (i > 90)
                                    this.up = true;
                                else
                                    this.down = true;
                            } else if (!this.onceu)
                                this.up = true;
                        } else {
                            if (this.udcomp) {
                                if (this.perfection && Math.abs(i - 90) > 30) {
                                    if (i > 90)
                                        this.up = true;
                                    else
                                        this.down = true;
                                }
                            } else if (this.m.random() > this.mustland)
                                this.down = true;
                            this.onceu = true;
                        }
                    }
                    if (this.lrbare) {
                        int i = (mad).pxy + 90;
                        if (this.zyinv)
                            i += 180;
                        for (/**/; i < 0; i += 360) {
                            /* empty */
                        }
                        for (/**/; i > 180; i -= 360) {
                            /* empty */
                        }
                        i = Math.abs(i);
                        if ((mad).lcomp - (mad).rcomp < 10.0F && (this.oncel || this.oncer))
                            this.lrcomp = true;
                        if ((mad).lcomp > (mad).rcomp) {
                            if ((mad).capsized) {
                                if (this.lrcomp) {
                                    if (i > 90)
                                        this.left = true;
                                    else
                                        this.right = true;
                                } else if (!this.oncel)
                                    this.left = true;
                            } else {
                                if (this.lrcomp) {
                                    if (this.perfection && Math.abs(i - 90) > 30) {
                                        if (i > 90)
                                            this.left = true;
                                        else
                                            this.right = true;
                                    }
                                } else if (this.m.random() > this.mustland)
                                    this.right = true;
                                this.oncel = true;
                            }
                        } else if ((mad).capsized) {
                            if (this.lrcomp) {
                                if (i > 90)
                                    this.left = true;
                                else
                                    this.right = true;
                            } else if (!this.oncer)
                                this.right = true;
                        } else {
                            if (this.lrcomp) {
                                if (this.perfection && Math.abs(i - 90) > 30) {
                                    if (i > 90)
                                        this.left = true;
                                    else
                                        this.right = true;
                                }
                            } else if (this.m.random() > this.mustland)
                                this.left = true;
                            this.oncer = true;
                        }
                    }
                }
            }
        }
    }
    
    public int py(int i, int i_47_, int i_48_, int i_49_) {
        return (i - i_47_) * (i - i_47_) + (i_48_ - i_49_) * (i_48_ - i_49_);
    }
    
    public int pys(int i, int i_50_, int i_51_, int i_52_) {
        return (int) Math.sqrt((double) ((i - i_50_) * (i - i_50_) + (i_51_ - i_52_) * (i_51_ - i_52_)));
    }
}
