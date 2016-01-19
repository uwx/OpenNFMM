/* Control - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Control {
    private int acr = 0;
    int actwait = 0;
    int acuracy = 0;
    private boolean afta = false;
    private boolean agressed = false;
    float aim = 0.0F;
    int apunch = 0;
    boolean arrace = false;
    int attack = 0;
    int avoidnlev = 0;
    private boolean bulistc = false;
    int chatup = 0;
    int clrnce = 5;
    int cntrn = 0;
    boolean down = false;
    boolean enter = false;
    boolean exit = false;
    private boolean exitattack = false;
    int flycnt = 0;
    private boolean forget = false;
    int[] fpnt = new int[5];
    int frad = 0;
    int frx = 0;
    int frz = 0;
    private boolean gowait = false;
    boolean handb = false;
    int hold = 0;
    private boolean lastl = false;
    boolean left = false;
    int lookback = 0;
    private boolean lrbare = false;
    private boolean lrcomp = false;
    int lrdirect = 0;
    int lrstart = 0;
    private boolean lrswt = false;
    int lwall = -1;
    Medium m;
    int multion = 0;
    float mustland = 0.5F;
    boolean mutem = false;
    boolean mutes = false;
    private boolean onced = false;
    private boolean oncel = false;
    private boolean oncer = false;
    private boolean onceu = false;
    int oupnt = 0;
    int oxy = 0;
    int ozy = 0;
    int pan = 0;
    private boolean perfection = false;
    boolean radar = false;
    int rampp = 0;
    int randtcnt = 0;
    int revstart = 0;
    boolean right = false;
    int runbul = 0;
    int saftey = 30;
    float skiplev = 1.0F;
    int statusque = 0;
    int stcnt = 0;
    int stuntf = 0;
    int swat = 0;
    int trfix = 0;
    int trickfase = 0;
    float trickprf = 0.5F;
    int turncnt = 0;
    int turntyp = 0;
    private boolean udbare = false;
    private boolean udcomp = false;
    int uddirect = 0;
    int udstart = 0;
    private boolean udswt = false;
    boolean up = false;
    int upcnt = 0;
    int upwait = 0;
    private boolean usebounce = false;
    int wall = -1;
    private boolean wlastl = false;
    int wtx = 0;
    int wtz = 0;
    boolean zyinv = false;

    public Control(final Medium medium) {
        m = medium;
    }

    public void falseo(final int i) {
        left = false;
        right = false;
        up = false;
        down = false;
        handb = false;
        lookback = 0;
        enter = false;
        exit = false;
        if (i != 1) {
            radar = false;
            arrace = false;
            chatup = 0;
            if (i != 2)
                multion = 0;
            if (i != 3) {
                mutem = false;
                mutes = false;
            }
        }
    }

    public void preform(final Mad mad, final ContO conto, final CheckPoints checkpoints, final Trackers trackers) {
        left = false;
        right = false;
        up = false;
        down = false;
        handb = false;
        if (!mad.dest) {
            if (mad.mtouch)
                if (stcnt > statusque) {
                    acuracy = (7 - checkpoints.pos[mad.im]) * checkpoints.pos[0] * (6 - checkpoints.stage * 2);
                    if (acuracy < 0 || checkpoints.stage == -1)
                        acuracy = 0;
                    clrnce = 5;
                    if (checkpoints.stage == 16 || checkpoints.stage == 21)
                        clrnce = 2;
                    if (checkpoints.stage == 22 && (mad.pcleared == 27 || mad.pcleared == 17))
                        clrnce = 3;
                    if (checkpoints.stage == 26 && mad.pcleared == 33)
                        clrnce = 3;
                    float f = 0.0F;
                    if (checkpoints.stage == 1)
                        f = 2.0F;
                    if (checkpoints.stage == 2)
                        f = 1.5F;
                    if (checkpoints.stage == 3 && mad.cn != 6)
                        f = 0.5F;
                    if (checkpoints.stage == 4)
                        f = 0.5F;
                    if (checkpoints.stage == 11)
                        f = 2.0F;
                    if (checkpoints.stage == 12)
                        f = 1.5F;
                    if (checkpoints.stage == 13 && mad.cn != 9)
                        f = 0.5F;
                    if (checkpoints.stage == 14)
                        f = 0.5F;
                    upwait = (int) ((checkpoints.pos[0] - checkpoints.pos[mad.im])
                            * (checkpoints.pos[0] - checkpoints.pos[mad.im])
                            * (checkpoints.pos[0] - checkpoints.pos[mad.im]) * f);
                    if (upwait > 80)
                        upwait = 80;
                    if ((checkpoints.stage == 11 || checkpoints.stage == 1) && upwait < 20)
                        upwait = 20;
                    f = 0.0F;
                    if (checkpoints.stage == 1 || checkpoints.stage == 2)
                        f = 1.0F;
                    if (checkpoints.stage == 4)
                        f = 0.5F;
                    if (checkpoints.stage == 7)
                        f = 0.5F;
                    if (checkpoints.stage == 10)
                        f = 0.5F;
                    if (checkpoints.stage == 11 || checkpoints.stage == 12)
                        f = 1.0F;
                    if (checkpoints.stage == 13)
                        f = 0.5F;
                    if (checkpoints.stage == 14)
                        f = 0.5F;
                    if (checkpoints.stage == 15)
                        f = 0.2F;
                    if (checkpoints.pos[mad.im] - checkpoints.pos[0] >= -1) {
                        skiplev -= 0.1;
                        if (skiplev < 0.0F)
                            skiplev = 0.0F;
                    } else {
                        skiplev += 0.2;
                        if (skiplev > f)
                            skiplev = f;
                    }
                    if (checkpoints.stage == 18)
                        if (mad.pcleared >= 10 && mad.pcleared <= 24)
                            skiplev = 1.0F;
                        else
                            skiplev = 0.0F;
                    if (checkpoints.stage == 21) {
                        skiplev = 0.0F;
                        if (mad.pcleared == 5)
                            skiplev = 1.0F;
                        if (mad.pcleared == 28 || mad.pcleared == 35)
                            skiplev = 0.5F;
                    }
                    if (checkpoints.stage == 23)
                        skiplev = 0.5F;
                    if (checkpoints.stage == 24 || checkpoints.stage == 22)
                        skiplev = 1.0F;
                    if (checkpoints.stage == 26 || checkpoints.stage == 25 || checkpoints.stage == 20)
                        skiplev = 0.0F;
                    rampp = (int) (m.random() * 4.0F - 2.0F);
                    if (mad.power == 98.0F)
                        rampp = -1;
                    if (mad.power < 75.0F && rampp == -1)
                        rampp = 0;
                    if (mad.power < 60.0F)
                        rampp = 1;
                    if (checkpoints.stage == 6)
                        rampp = 2;
                    if (checkpoints.stage == 18 && mad.pcleared >= 45)
                        rampp = 2;
                    if (checkpoints.stage == 22 && mad.pcleared == 17)
                        rampp = 2;
                    if (checkpoints.stage == 25 || checkpoints.stage == 26)
                        rampp = 0;
                    if (cntrn == 0) {
                        agressed = false;
                        turntyp = (int) (m.random() * 4.0F);
                        if (checkpoints.stage == 3 && mad.cn == 6) {
                            turntyp = 1;
                            if (attack == 0)
                                agressed = true;
                        }
                        if (checkpoints.stage == 9 && mad.cn == 15) {
                            turntyp = 1;
                            if (attack == 0)
                                agressed = true;
                        }
                        if (checkpoints.stage == 13 && mad.cn == 9) {
                            turntyp = 1;
                            if (attack == 0)
                                agressed = true;
                        }
                        if (checkpoints.pos[0] - checkpoints.pos[mad.im] < 0)
                            turntyp = (int) (m.random() * 2.0F);
                        if (checkpoints.stage == 10)
                            turntyp = 2;
                        if (checkpoints.stage == 18)
                            turntyp = 2;
                        if (checkpoints.stage == 20)
                            turntyp = 0;
                        if (checkpoints.stage == 23)
                            turntyp = 1;
                        if (checkpoints.stage == 24)
                            turntyp = 0;
                        if (attack != 0) {
                            turntyp = 2;
                            if (checkpoints.stage == 9 || checkpoints.stage == 10 || checkpoints.stage == 19
                                    || checkpoints.stage == 21 || checkpoints.stage == 23 || checkpoints.stage == 27)
                                turntyp = (int) (m.random() * 3.0F);
                            if (checkpoints.stage == 26 && checkpoints.clear[mad.im] - checkpoints.clear[0] >= 5)
                                turntyp = 0;
                        }
                        if (checkpoints.stage == 6) {
                            turntyp = 1;
                            agressed = true;
                        }
                        if (checkpoints.stage == 7 || checkpoints.stage == 9 || checkpoints.stage == 10
                                || checkpoints.stage == 16 || checkpoints.stage == 17 || checkpoints.stage == 19
                                || checkpoints.stage == 20 || checkpoints.stage == 21 || checkpoints.stage == 22
                                || checkpoints.stage == 24 || checkpoints.stage == 26 || checkpoints.stage == 27)
                            agressed = true;
                        if (checkpoints.stage == -1)
                            if (m.random() > m.random())
                                agressed = true;
                            else
                                agressed = false;
                        cntrn = 5;
                    } else
                        cntrn--;
                    saftey = (int) ((98.0F - mad.power) / 2.0F * (m.random() / 2.0F + 0.5));
                    if (saftey > 20)
                        saftey = 20;
                    f = 0.0F;
                    if (checkpoints.stage == 1 || checkpoints.stage == 11)
                        f = 0.9F;
                    if (checkpoints.stage == 2 || checkpoints.stage == 12)
                        f = 0.7F;
                    if (checkpoints.stage == 4 || checkpoints.stage == 13)
                        f = 0.4F;
                    mustland = f + (float) (m.random() / 2.0F - 0.25);
                    f = 1.0F;
                    if (checkpoints.stage == 1 || checkpoints.stage == 11)
                        f = 5.0F;
                    if (checkpoints.stage == 2 || checkpoints.stage == 12)
                        f = 2.0F;
                    if (checkpoints.stage == 4 || checkpoints.stage == 13)
                        f = 1.5F;
                    if (mad.power > 50.0F) {
                        if (checkpoints.pos[0] - checkpoints.pos[mad.im] > 0)
                            saftey *= f;
                        else
                            mustland = 0.0F;
                    } else
                        mustland -= 0.5F;
                    if (checkpoints.stage == 18 || checkpoints.stage == 20 || checkpoints.stage == 22
                            || checkpoints.stage == 24)
                        mustland = 0.0F;
                    stuntf = 0;
                    if (checkpoints.stage == 8)
                        stuntf = 17;
                    if (checkpoints.stage == 18 && mad.pcleared == 57)
                        stuntf = 1;
                    if (checkpoints.stage == 19 && mad.pcleared == 3)
                        stuntf = 2;
                    if (checkpoints.stage == 20)
                        if (checkpoints.pos[0] < checkpoints.pos[mad.im]
                                || Math.abs(checkpoints.clear[0] - mad.clear) >= 2 || mad.clear < 2) {
                            stuntf = 4;
                            saftey = 10;
                        } else
                            stuntf = 3;
                    if (checkpoints.stage == 21 && mad.pcleared == 21)
                        stuntf = 1;
                    if (checkpoints.stage == 24) {
                        saftey = 10;
                        if (mad.pcleared >= 4 && mad.pcleared < 70)
                            stuntf = 4;
                        else if (mad.cn == 12 || mad.cn == 8)
                            stuntf = 2;
                        if (mad.cn == 14)
                            stuntf = 6;
                    }
                    if (checkpoints.stage == 26) {
                        mustland = 0.0F;
                        saftey = 10;
                        if ((mad.pcleared == 15 || mad.pcleared == 51) && (m.random() > 0.4 || trfix != 0))
                            stuntf = 7;
                        if (mad.pcleared == 42)
                            stuntf = 1;
                        if (mad.pcleared == 77)
                            stuntf = 7;
                        avoidnlev = (int) (2700.0F * m.random());
                    }
                    trickprf = (mad.power - 38.0F) / 50.0F - m.random() / 2.0F;
                    if (mad.power < 60.0F)
                        trickprf = -1.0F;
                    if (checkpoints.stage == 6 && trickprf > 0.5)
                        trickprf = 0.5F;
                    if (checkpoints.stage == 3 && mad.cn == 6 && trickprf > 0.7)
                        trickprf = 0.7F;
                    if (checkpoints.stage == 13 && mad.cn == 9 && trickprf > 0.7)
                        trickprf = 0.7F;
                    if (checkpoints.stage == 16 && trickprf > 0.3)
                        trickprf = 0.3F;
                    if (checkpoints.stage == 18 && trickprf > 0.2)
                        trickprf = 0.2F;
                    if (checkpoints.stage == 19) {
                        if (trickprf > 0.5)
                            trickprf = 0.5F;
                        if ((mad.im == 6 || mad.im == 5) && trickprf > 0.3)
                            trickprf = 0.3F;
                    }
                    if (checkpoints.stage == 21 && trickprf != -1.0F)
                        trickprf *= 0.75F;
                    if (checkpoints.stage == 22 && (mad.pcleared == 55 || mad.pcleared == 7)) {
                        trickprf = -1.0F;
                        stuntf = 5;
                    }
                    if (checkpoints.stage == 23 && trickprf > 0.4)
                        trickprf = 0.4F;
                    if (checkpoints.stage == 24 && trickprf > 0.5)
                        trickprf = 0.5F;
                    if (checkpoints.stage == 27)
                        trickprf = -1.0F;
                    if (m.random() > mad.power / 100.0F)
                        usebounce = true;
                    else
                        usebounce = false;
                    if (checkpoints.stage == 9)
                        usebounce = false;
                    if (checkpoints.stage == 14 || checkpoints.stage == 16)
                        usebounce = true;
                    if (checkpoints.stage == 20 || checkpoints.stage == 24)
                        usebounce = false;
                    if (m.random() > (float) mad.hitmag / (float) mad.cd.maxmag[mad.cn])
                        perfection = false;
                    else
                        perfection = true;
                    if (100.0F * mad.hitmag / mad.cd.maxmag[mad.cn] > 60.0F)
                        perfection = true;
                    if (checkpoints.stage == 3 && mad.cn == 6)
                        perfection = true;
                    if (checkpoints.stage == 6 || checkpoints.stage == 8 || checkpoints.stage == 9
                            || checkpoints.stage == 10 || checkpoints.stage == 16 || checkpoints.stage == 18
                            || checkpoints.stage == 19 || checkpoints.stage == 20 || checkpoints.stage == 21
                            || checkpoints.stage == 22 || checkpoints.stage == 24 || checkpoints.stage == 26
                            || checkpoints.stage == 27)
                        perfection = true;
                    if (attack == 0) {
                        boolean bool = true;
                        if (checkpoints.stage == 3 || checkpoints.stage == 1 || checkpoints.stage == 4
                                || checkpoints.stage == 9 || checkpoints.stage == 13 || checkpoints.stage == 11
                                || checkpoints.stage == 14 || checkpoints.stage == 19 || checkpoints.stage == 23
                                || checkpoints.stage == 26)
                            bool = afta;
                        if (checkpoints.stage == 8 || checkpoints.stage == 6 || checkpoints.stage == 18
                                || checkpoints.stage == 16 || checkpoints.stage == 20 || checkpoints.stage == 24)
                            bool = false;
                        if (checkpoints.stage == 3 && mad.cn == 6)
                            bool = false;
                        if (checkpoints.stage == -1 && m.random() > m.random())
                            bool = false;
                        boolean bool4 = false;
                        if (checkpoints.stage == 13 && mad.cn == 9)
                            bool4 = true;
                        if (checkpoints.stage == 18 && mad.cn == 11)
                            bool4 = true;
                        if (checkpoints.stage == 19 && checkpoints.clear[0] >= 20)
                            bool4 = true;
                        if (checkpoints.stage == 4 || checkpoints.stage == 10 || checkpoints.stage == 21
                                || checkpoints.stage == 22 || checkpoints.stage == 23 || checkpoints.stage == 25
                                || checkpoints.stage == 26)
                            bool4 = true;
                        if (checkpoints.stage == 3 && mad.cn == 6)
                            bool4 = true;
                        int i5 = 60;
                        if (checkpoints.stage == 5)
                            i5 = 40;
                        if (checkpoints.stage == 6 && bulistc)
                            i5 = 40;
                        if (checkpoints.stage == 9 && bulistc)
                            i5 = 30;
                        if (checkpoints.stage == 3 || checkpoints.stage == 13 || checkpoints.stage == 21
                                || checkpoints.stage == 27 || checkpoints.stage == 20 || checkpoints.stage == 18)
                            i5 = 30;
                        if ((checkpoints.stage == 12 || checkpoints.stage == 23) && mad.cn == 13)
                            i5 = 50;
                        if (checkpoints.stage == 14)
                            i5 = 20;
                        if (checkpoints.stage == 15 && mad.im != 6)
                            i5 = 40;
                        if (checkpoints.stage == 17)
                            i5 = 40;
                        if (checkpoints.stage == 18 && mad.cn == 11)
                            i5 = 40;
                        if (checkpoints.stage == 19 && bool4)
                            i5 = 30;
                        if (checkpoints.stage == 21 && bulistc)
                            i5 = 30;
                        if (checkpoints.stage == 22)
                            i5 = 50;
                        if (checkpoints.stage == 25 && bulistc)
                            i5 = 40;
                        if (checkpoints.stage == 26) {
                            if (mad.cn == 11 && checkpoints.clear[0] == 27)
                                i5 = 0;
                            if (mad.cn == 15 || mad.cn == 9)
                                i5 = 50;
                            if (mad.cn == 11)
                                i5 = 40;
                            if (checkpoints.pos[0] > checkpoints.pos[mad.im])
                                i5 = 80;
                        }
                        for (int i6 = 0; i6 < 7; i6++)
                            if (i6 != mad.im && checkpoints.clear[i6] != -1) {
                                int i7 = conto.xz;
                                if (zyinv)
                                    i7 += 180;
                                for (/**/; i7 < 0; i7 += 360) {
                                    
                                }
                                for (/**/; i7 > 180; i7 -= 360) {
                                    
                                }
                                int i8 = 0;
                                if (checkpoints.opx[i6] - conto.x >= 0)
                                    i8 = 180;
                                int i9;
                                for (i9 = (int) (90 + i8
                                        + Math.atan((double) (checkpoints.opz[i6] - conto.z)
                                                / (double) (checkpoints.opx[i6] - conto.x))
                                        / 0.017453292519943295); i9 < 0; i9 += 360) {
                                    
                                }
                                for (/**/; i9 > 180; i9 -= 360) {
                                    
                                }
                                int i10 = Math.abs(i7 - i9);
                                if (i10 > 180)
                                    i10 = Math.abs(i10 - 360);
                                int i11 = 2000 * (Math.abs(checkpoints.clear[i6] - mad.clear) + 1);
                                if ((checkpoints.stage == 6 || checkpoints.stage == 9) && bulistc)
                                    i11 = 6000;
                                if (checkpoints.stage == 3 && mad.cn == 6 && checkpoints.wasted < 2 && i11 > 4000)
                                    i11 = 4000;
                                if (checkpoints.stage == 13 && mad.cn == 9 && i11 < 12000)
                                    i11 = 12000;
                                if (checkpoints.stage == 14 && i11 < 4000)
                                    i11 = 4000;
                                if (checkpoints.stage == 18 && mad.cn == 11) {
                                    if (i11 < 12000)
                                        i11 = 12000;
                                    i10 = 10;
                                }
                                if (checkpoints.stage == 19 && (mad.pcleared == 13 || mad.pcleared == 33 || bool4)
                                        && i11 < 12000)
                                    i11 = 12000;
                                if (checkpoints.stage == 21)
                                    if (bulistc) {
                                        i11 = 8000;
                                        i10 = 10;
                                        afta = true;
                                    } else if (i11 < 6000)
                                        i11 = 6000;
                                if (checkpoints.stage == 22 && bulistc) {
                                    i11 = 6000;
                                    i10 = 10;
                                }
                                if (checkpoints.stage == 23)
                                    i11 = 21000;
                                if (checkpoints.stage == 25) {
                                    i11 *= Math.abs(checkpoints.clear[i6] - mad.clear) + 1;
                                    if (bulistc) {
                                        i11 = 4000 * (Math.abs(checkpoints.clear[i6] - mad.clear) + 1);
                                        i10 = 10;
                                    }
                                }
                                if (checkpoints.stage == 20)
                                    i11 = 16000;
                                if (checkpoints.stage == 26) {
                                    if (mad.cn == 13 && bulistc) {
                                        if (oupnt == 33)
                                            i11 = 17000;
                                        if (oupnt == 51)
                                            i11 = 30000;
                                        if (oupnt == 15 && checkpoints.clear[0] >= 14)
                                            i11 = 60000;
                                        i10 = 10;
                                    }
                                    if (mad.cn == 15 || mad.cn == 9)
                                        i11 *= Math.abs(checkpoints.clear[i6] - mad.clear) + 1;
                                    if (mad.cn == 11)
                                        i11 = 4000 * (Math.abs(checkpoints.clear[i6] - mad.clear) + 1);
                                }
                                int i12 = 85 + 15 * (Math.abs(checkpoints.clear[i6] - mad.clear) + 1);
                                if (checkpoints.stage == 23)
                                    i12 = 45;
                                if (checkpoints.stage == 26
                                        && (mad.cn == 15 || mad.cn == 9 || mad.cn == 11 || mad.cn == 14))
                                    i12 = 50 + 70 * Math.abs(checkpoints.clear[i6] - mad.clear);
                                if (i10 < i12 && py(conto.x / 100, checkpoints.opx[i6] / 100, conto.z / 100,
                                        checkpoints.opz[i6] / 100) < i11 && afta && mad.power > i5) {
                                    float f13 = 35 - Math.abs(checkpoints.clear[i6] - mad.clear) * 10;
                                    if (f13 < 1.0F)
                                        f13 = 1.0F;
                                    float f14 = (checkpoints.pos[mad.im] + 1) * (5 - checkpoints.pos[i6]) / f13;
                                    if (checkpoints.stage != 27 && f14 > 0.7)
                                        f14 = 0.7F;
                                    if (i6 != 0 && checkpoints.pos[0] < checkpoints.pos[mad.im])
                                        f14 = 0.0F;
                                    if (i6 != 0 && bool4)
                                        f14 = 0.0F;
                                    if (bool4 && checkpoints.stage == 3 && i6 == 0)
                                        if (checkpoints.wasted >= 2)
                                            f14 *= 0.5F;
                                        else
                                            f14 = 0.0F;
                                    if ((checkpoints.stage == 3 || checkpoints.stage == 9) && i6 == 4)
                                        f14 = 0.0F;
                                    if (checkpoints.stage == 6) {
                                        f14 = 0.0F;
                                        if (bulistc && i6 == 0)
                                            f14 = 1.0F;
                                    }
                                    if (checkpoints.stage == 8) {
                                        f14 = 0.0F;
                                        if (bulistc && mad.cn != 11 && mad.cn != 13)
                                            f14 = 1.0F;
                                    }
                                    if (checkpoints.stage == 9 && mad.cn == 15)
                                        f14 = 0.0F;
                                    if (checkpoints.stage == 9 && bulistc)
                                        if (i6 == 0)
                                            f14 = 1.0F;
                                        else
                                            f14 = 0.0F;
                                    if (checkpoints.stage == 9
                                            && (checkpoints.pos[i6] == 4 || checkpoints.pos[i6] == 3))
                                        f14 = 0.0F;
                                    if (checkpoints.stage == 13)
                                        if (mad.cn == 9 || mad.cn == 13 && bulistc)
                                            f14 *= 2.0F;
                                        else
                                            f14 *= 0.5F;
                                    if (checkpoints.stage == 16)
                                        f14 = 0.0F;
                                    if (checkpoints.stage == 17 && mad.im == 6 && i6 == 0)
                                        f14 *= 1.5;
                                    if (checkpoints.stage == 18)
                                        if (mad.cn == 11 || mad.cn == 13 && bulistc)
                                            f14 *= 1.5F;
                                        else
                                            f14 = 0.0F;
                                    if (checkpoints.stage == 19) {
                                        if (i6 != 0)
                                            f14 *= 0.5;
                                        if (mad.pcleared != 13 && mad.pcleared != 33 && !bool4)
                                            f14 *= 0.5F;
                                        if ((mad.im == 6 || mad.im == 5) && i6 != 0)
                                            f14 = 0.0F;
                                    }
                                    if (checkpoints.stage == 20) {
                                        f14 = 0.0F;
                                        if (bulistc && mad.cn != 11 && mad.cn != 13)
                                            f14 = 1.0F;
                                    }
                                    if (checkpoints.stage == 21 && bulistc && i6 == 0)
                                        f14 = 1.0F;
                                    if (checkpoints.stage == 22) {
                                        if (mad.cn != 11 && mad.cn != 13)
                                            f14 = 0.0F;
                                        if (mad.cn == 13 && i6 == 0)
                                            f14 = 1.0F;
                                    }
                                    if (checkpoints.stage == 24)
                                        f14 = 0.0F;
                                    if (checkpoints.stage == 25) {
                                        if (checkpoints.pos[mad.im] == 0)
                                            f14 *= 0.5;
                                        if (checkpoints.pos[0] < checkpoints.pos[mad.im])
                                            f14 *= 2.0F;
                                        if (bulistc && i6 == 0)
                                            f14 = 1.0F;
                                    }
                                    if (checkpoints.stage == 26) {
                                        if (mad.cn != 14) {
                                            if (checkpoints.pos[0] < checkpoints.pos[mad.im]
                                                    && checkpoints.clear[0] - checkpoints.clear[mad.im] != 1)
                                                f14 *= 2.0F;
                                        } else
                                            f14 *= 0.5;
                                        if (mad.cn == 13 && i6 == 0)
                                            f14 = 1.0F;
                                        if (checkpoints.pos[mad.im] == 0
                                                || checkpoints.pos[mad.im] == 1 && checkpoints.pos[0] == 0)
                                            f14 = 0.0F;
                                        if (checkpoints.clear[mad.im] - checkpoints.clear[0] >= 5 && i6 == 0)
                                            f14 = 1.0F;
                                        if (mad.cn == 10 || mad.cn == 12)
                                            f14 = 0.0F;
                                    }
                                    if (m.random() < f14) {
                                        attack = 40 * (Math.abs(checkpoints.clear[i6] - mad.clear) + 1);
                                        if (attack > 500)
                                            attack = 500;
                                        aim = 0.0F;
                                        if (checkpoints.stage == 13 && mad.cn == 9 && m.random() > m.random())
                                            aim = 1.0F;
                                        if (checkpoints.stage == 14)
                                            if (i6 == 0 && checkpoints.pos[0] < checkpoints.pos[mad.im])
                                                aim = 1.5F;
                                            else
                                                aim = m.random();
                                        if (checkpoints.stage == 15)
                                            aim = m.random() * 1.5F;
                                        if (checkpoints.stage == 17 && mad.im != 6 && (m.random() > m.random()
                                                || checkpoints.pos[0] < checkpoints.pos[mad.im]))
                                            aim = 1.0F;
                                        if (checkpoints.stage == 18 && mad.cn == 11 && m.random() > m.random())
                                            aim = 0.76F + m.random() * 0.76F;
                                        if (checkpoints.stage == 19 && (mad.pcleared == 13 || mad.pcleared == 33))
                                            aim = 1.0F;
                                        if (checkpoints.stage == 21)
                                            if (bulistc) {
                                                aim = 0.7F;
                                                if (attack > 150)
                                                    attack = 150;
                                            } else
                                                aim = m.random();
                                        if (checkpoints.stage == 22) {
                                            if (m.random() > m.random())
                                                aim = 0.7F;
                                            if (bulistc && attack > 150)
                                                attack = 150;
                                        }
                                        if (checkpoints.stage == 23 && attack > 60)
                                            attack = 60;
                                        if (checkpoints.stage == 25) {
                                            aim = m.random() * 1.5F;
                                            attack = attack / 2;
                                            if (m.random() > m.random())
                                                exitattack = true;
                                            else
                                                exitattack = false;
                                        }
                                        if (checkpoints.stage == 26)
                                            if (mad.cn == 13) {
                                                aim = 0.76F;
                                                attack = 150;
                                            } else {
                                                aim = m.random() * 1.5F;
                                                if (Math.abs(checkpoints.clear[i6] - mad.clear) <= 2 || mad.cn == 14)
                                                    attack = attack / 3;
                                            }
                                        if (checkpoints.stage == -1 && m.random() > m.random())
                                            aim = m.random() * 1.5F;
                                        acr = i6;
                                        turntyp = (int) (1.0F + m.random() * 2.0F);
                                    }
                                }
                                if (bool && i10 > 100
                                        && py(conto.x / 100, checkpoints.opx[i6] / 100, conto.z / 100,
                                                checkpoints.opz[i6] / 100) < 300
                                        && m.random() > 0.6 - checkpoints.pos[mad.im] / 10.0F) {
                                    clrnce = 0;
                                    acuracy = 0;
                                }
                            }
                    }
                    boolean bool = false;
                    if (checkpoints.stage == 6 || checkpoints.stage == 8)
                        bool = true;
                    if (checkpoints.stage == 9 && mad.cn == 15)
                        bool = true;
                    if (checkpoints.stage == 16 || checkpoints.stage == 20 || checkpoints.stage == 21
                            || checkpoints.stage == 27)
                        bool = true;
                    if (checkpoints.stage == 18 && mad.pcleared != 73)
                        bool = true;
                    if (checkpoints.stage == -1 && m.random() > m.random())
                        bool = true;
                    if (trfix != 3) {
                        trfix = 0;
                        int i15 = 50;
                        if (checkpoints.stage == 26)
                            i15 = 40;
                        if (100.0F * mad.hitmag / mad.cd.maxmag[mad.cn] > i15)
                            trfix = 1;
                        if (!bool) {
                            int i16 = 80;
                            if (checkpoints.stage == 18 && mad.cn != 11)
                                i16 = 50;
                            if (checkpoints.stage == 19)
                                i16 = 70;
                            if (checkpoints.stage == 25 && mad.pcleared == 91)
                                i16 = 50;
                            if (checkpoints.stage == 26 && checkpoints.clear[mad.im] - checkpoints.clear[0] >= 5
                                    && mad.cn != 10 && mad.cn != 12)
                                i16 = 50;
                            if (100.0F * mad.hitmag / mad.cd.maxmag[mad.cn] > i16)
                                trfix = 2;
                        }
                    } else {
                        upwait = 0;
                        acuracy = 0;
                        skiplev = 1.0F;
                        clrnce = 2;
                    }
                    if (!bulistc) {
                        if (checkpoints.stage == 18 && mad.cn == 11 && mad.pcleared == 35) {
                            mad.pcleared = 73;
                            mad.clear = 0;
                            bulistc = true;
                            runbul = (int) (100.0F * m.random());
                        }
                        if (checkpoints.stage == 21 && mad.cn == 13)
                            bulistc = true;
                        if (checkpoints.stage == 22 && mad.cn == 13)
                            bulistc = true;
                        if (checkpoints.stage == 25 && checkpoints.clear[0] - mad.clear >= 3 && trfix == 0) {
                            bulistc = true;
                            oupnt = -1;
                        }
                        if (checkpoints.stage == 26) {
                            if (mad.cn == 13 && checkpoints.pcleared == 8) {
                                bulistc = true;
                                attack = 0;
                            }
                            if (mad.cn == 11 && checkpoints.clear[0] - mad.clear >= 2 && trfix == 0) {
                                bulistc = true;
                                oupnt = -1;
                            }
                        }
                        if ((checkpoints.stage == 6 || checkpoints.stage == 8 || checkpoints.stage == 12
                                || checkpoints.stage == 13 || checkpoints.stage == 14 || checkpoints.stage == 15
                                || checkpoints.stage == 18 || checkpoints.stage == 20 || checkpoints.stage == 23)
                                && mad.cn == 13 && Math.abs(checkpoints.clear[0] - mad.clear) >= 2)
                            bulistc = true;
                        if ((checkpoints.stage == 8 || checkpoints.stage == 20) && mad.cn == 11
                                && Math.abs(checkpoints.clear[0] - mad.clear) >= 1)
                            bulistc = true;
                        if (checkpoints.stage == 6 && mad.cn == 11)
                            bulistc = true;
                        if (checkpoints.stage == 9 && afta
                                && (checkpoints.pos[mad.im] == 4 || checkpoints.pos[mad.im] == 3) && mad.cn != 15
                                && trfix != 0)
                            bulistc = true;
                    } else if (checkpoints.stage == 18) {
                        runbul--;
                        if (mad.pcleared == 10)
                            runbul = 0;
                        if (runbul <= 0)
                            bulistc = false;
                    }
                    stcnt = 0;
                    statusque = (int) (20.0F * m.random());
                } else
                    stcnt++;
            boolean bool = false;
            if (usebounce)
                bool = mad.wtouch;
            else
                bool = mad.mtouch;
            if (bool) {
                if (trickfase != 0)
                    trickfase = 0;
                if (trfix == 2 || trfix == 3)
                    attack = 0;
                if (attack == 0) {
                    if (upcnt < 30)
                        if (revstart <= 0)
                            up = true;
                        else {
                            down = true;
                            revstart--;
                        }
                    if (upcnt < 25 + actwait)
                        upcnt++;
                    else {
                        upcnt = 0;
                        actwait = upwait;
                    }
                    int i = mad.point;
                    int i17 = 50;
                    if (checkpoints.stage == 9)
                        i17 = 20;
                    if (checkpoints.stage == 18)
                        i17 = 20;
                    if (checkpoints.stage == 25)
                        i17 = 40;
                    if (checkpoints.stage == 26)
                        i17 = 20;
                    if (!bulistc || trfix == 2 || trfix == 3 || trfix == 4 || mad.power < i17) {
                        if (rampp == 1 && checkpoints.typ[i] <= 0) {
                            int i18 = i + 1;
                            if (i18 >= checkpoints.n)
                                i18 = 0;
                            if (checkpoints.typ[i18] == -2)
                                i = i18;
                        }
                        if (rampp == -1 && checkpoints.typ[i] == -2 && ++i >= checkpoints.n)
                            i = 0;
                        if (m.random() > skiplev) {
                            int i19 = i;
                            boolean bool20 = false;
                            if (checkpoints.typ[i19] > 0) {
                                int i21 = 0;
                                for (int i22 = 0; i22 < checkpoints.n; i22++)
                                    if (checkpoints.typ[i22] > 0 && i22 < i19)
                                        i21++;
                                bool20 = mad.clear != i21 + mad.nlaps * checkpoints.nsp;
                            }
                            while (checkpoints.typ[i19] == 0 || checkpoints.typ[i19] == -1 || checkpoints.typ[i19] == -3
                                    || bool20) {
                                i = i19;
                                if (++i19 >= checkpoints.n)
                                    i19 = 0;
                                bool20 = false;
                                if (checkpoints.typ[i19] > 0) {
                                    int i23 = 0;
                                    for (int i24 = 0; i24 < checkpoints.n; i24++)
                                        if (checkpoints.typ[i24] > 0 && i24 < i19)
                                            i23++;
                                    bool20 = mad.clear != i23 + mad.nlaps * checkpoints.nsp;
                                }
                            }
                        } else if (m.random() > skiplev)
                            while (checkpoints.typ[i] == -1)
                                if (++i >= checkpoints.n)
                                    i = 0;
                        if (checkpoints.stage == 18 && mad.pcleared == 73 && trfix == 0 && mad.clear != 0)
                            i = 10;
                        if (checkpoints.stage == 19 && mad.pcleared == 18 && trfix == 0)
                            i = 27;
                        if (checkpoints.stage == 21) {
                            if (mad.pcleared == 5 && trfix == 0 && mad.power < 70.0F)
                                if (i <= 16)
                                    i = 16;
                                else
                                    i = 21;
                            if (mad.pcleared == 50)
                                i = 57;
                        }
                        if (checkpoints.stage == 22 && (mad.pcleared == 27 || mad.pcleared == 37))
                            while (checkpoints.typ[i] == -1)
                                if (++i >= checkpoints.n)
                                    i = 0;
                        if (checkpoints.stage == 23)
                            while (checkpoints.typ[i] == -1)
                                if (++i >= checkpoints.n)
                                    i = 0;
                        if (checkpoints.stage == 24) {
                            while (checkpoints.typ[i] == -1)
                                if (++i >= checkpoints.n)
                                    i = 0;
                            if (!mad.gtouch)
                                while (checkpoints.typ[i] == -2)
                                    if (++i >= checkpoints.n)
                                        i = 0;
                            if (oupnt >= 68)
                                i = 70;
                            else
                                oupnt = i;
                        }
                        if (checkpoints.stage == 25) {
                            if (mad.pcleared != 91 && checkpoints.pos[0] < checkpoints.pos[mad.im] && mad.cn != 13
                                    || checkpoints.pos[mad.im] == 0 && (mad.clear == 12 || mad.clear == 20))
                                while (checkpoints.typ[i] == -4)
                                    if (++i >= checkpoints.n)
                                        i = 0;
                            if (mad.pcleared == 9) {
                                if (py(conto.x / 100, 297, conto.z / 100, 347) < 400)
                                    oupnt = 1;
                                if (oupnt == 1 && i < 22)
                                    i = 22;
                            }
                            if (mad.pcleared == 67) {
                                if (py(conto.x / 100, 28, conto.z / 100, 494) < 4000)
                                    oupnt = 2;
                                if (oupnt == 2)
                                    i = 76;
                            }
                            if (mad.pcleared == 76) {
                                if (py(conto.x / 100, -50, conto.z / 100, 0) < 2000)
                                    oupnt = 3;
                                if (oupnt == 3)
                                    i = 91;
                                else
                                    i = 89;
                            }
                        }
                        if (checkpoints.stage == 26) {
                            if (mad.pcleared == 128) {
                                if (py(conto.x / 100, 0, conto.z / 100, 229) < 1500 || conto.z > 23000)
                                    oupnt = 128;
                                if (oupnt != 128)
                                    i = 3;
                            }
                            if (mad.pcleared == 8) {
                                if (py(conto.x / 100, -207, conto.z / 100, 549) < 1500 || conto.x < -20700)
                                    oupnt = 8;
                                if (oupnt != 8)
                                    i = 12;
                            }
                            if (mad.pcleared == 33) {
                                if (py(conto.x / 100, -60, conto.z / 100, 168) < 250 || conto.z > 17000)
                                    oupnt = 331;
                                if (py(conto.x / 100, -112, conto.z / 100, 414) < 10000 || conto.z > 40000)
                                    oupnt = 332;
                                if (oupnt != 331 && oupnt != 332)
                                    if (trfix != 1)
                                        i = 38;
                                    else
                                        i = 39;
                                if (oupnt == 331)
                                    i = 71;
                            }
                            if (mad.pcleared == 42) {
                                if (py(conto.x / 100, -269, conto.z / 100, 493) < 100 || conto.x < -27000)
                                    oupnt = 142;
                                if (oupnt != 142)
                                    i = 47;
                            }
                            if (mad.pcleared == 51) {
                                if (py(conto.x / 100, -352, conto.z / 100, 260) < 100 || conto.z < 25000)
                                    oupnt = 511;
                                if (py(conto.x / 100, -325, conto.z / 100, 10) < 2000 || conto.x > -32000)
                                    oupnt = 512;
                                if (oupnt != 511 && oupnt != 512)
                                    i = 80;
                                if (oupnt == 511)
                                    i = 61;
                            }
                            if (mad.pcleared == 77) {
                                if (py(conto.x / 100, -371, conto.z / 100, 319) < 100 || conto.z < 31000)
                                    oupnt = 77;
                                if (oupnt != 77) {
                                    i = 78;
                                    mad.nofocus = true;
                                }
                            }
                            if (mad.pcleared == 105) {
                                if (py(conto.x / 100, -179, conto.z / 100, 10) < 2300 || conto.z < 1050)
                                    oupnt = 105;
                                if (oupnt != 105)
                                    i = 65;
                                else
                                    i = 125;
                            }
                            if (trfix == 3) {
                                if (py(conto.x / 100, -52, conto.z / 100, 448) < 100 || conto.z > 45000)
                                    oupnt = 176;
                                if (oupnt != 176)
                                    i = 41;
                                else
                                    i = 43;
                            }
                            if (checkpoints.clear[mad.im] - checkpoints.clear[0] >= 2
                                    && py(conto.x / 100, checkpoints.opx[0] / 100, conto.z / 100,
                                            checkpoints.opz[0] / 100) < 1000 + avoidnlev) {
                                int i25 = conto.xz;
                                if (zyinv)
                                    i25 += 180;
                                for (/**/; i25 < 0; i25 += 360) {
                                    
                                }
                                for (/**/; i25 > 180; i25 -= 360) {
                                    
                                }
                                int i26 = 0;
                                if (checkpoints.opx[0] - conto.x >= 0)
                                    i26 = 180;
                                int i27;
                                for (i27 = (int) (90 + i26
                                        + Math.atan((double) (checkpoints.opz[0] - conto.z)
                                                / (double) (checkpoints.opx[0] - conto.x))
                                        / 0.017453292519943295); i27 < 0; i27 += 360) {
                                    
                                }
                                for (/**/; i27 > 180; i27 -= 360) {
                                    
                                }
                                int i28 = Math.abs(i25 - i27);
                                if (i28 > 180)
                                    i28 = Math.abs(i28 - 360);
                                if (i28 < 90)
                                    wall = 0;
                            }
                        }
                        if (rampp == 2) {
                            int i29 = i + 1;
                            if (i29 >= checkpoints.n)
                                i29 = 0;
                            if (checkpoints.typ[i29] == -2 && i != mad.point && --i < 0)
                                i += checkpoints.n;
                        }
                        if (bulistc) {
                            mad.nofocus = true;
                            if (gowait)
                                gowait = false;
                        }
                    } else {
                        if (checkpoints.stage != 25 && checkpoints.stage != 26 || runbul == 0) {
                            i -= 2;
                            if (i < 0)
                                i += checkpoints.n;
                            if (checkpoints.stage == 9 && i > 76)
                                i = 76;
                            while (checkpoints.typ[i] == -4)
                                if (--i < 0)
                                    i += checkpoints.n;
                        }
                        if (checkpoints.stage == 21) {
                            if (i >= 14 && i <= 19)
                                i = 13;
                            if (oupnt == 72 && i != 56)
                                i = 57;
                            else if (oupnt == 54 && i != 52)
                                i = 53;
                            else if (oupnt == 39 && i != 37)
                                i = 38;
                            else
                                oupnt = i;
                        }
                        if (checkpoints.stage == 22) {
                            if (!gowait) {
                                if (checkpoints.clear[0] == 0) {
                                    wtx = -3500;
                                    wtz = 19000;
                                    frx = -3500;
                                    frz = 39000;
                                    frad = 12000;
                                    oupnt = 37;
                                    gowait = true;
                                    afta = false;
                                }
                                if (checkpoints.clear[0] == 7) {
                                    wtx = -44800;
                                    wtz = 40320;
                                    frx = -44800;
                                    frz = 34720;
                                    frad = 30000;
                                    oupnt = 27;
                                    gowait = true;
                                    afta = false;
                                }
                                if (checkpoints.clear[0] == 10) {
                                    wtx = 0;
                                    wtz = 48739;
                                    frx = 0;
                                    frz = 38589;
                                    frad = 90000;
                                    oupnt = 55;
                                    gowait = true;
                                    afta = false;
                                }
                                if (checkpoints.clear[0] == 14) {
                                    wtx = -3500;
                                    wtz = 19000;
                                    frx = -14700;
                                    frz = 39000;
                                    frad = 45000;
                                    oupnt = 37;
                                    gowait = true;
                                    afta = false;
                                }
                                if (checkpoints.clear[0] == 18) {
                                    wtx = -48300;
                                    wtz = -4550;
                                    frx = -48300;
                                    frz = 5600;
                                    frad = 90000;
                                    oupnt = 17;
                                    gowait = true;
                                    afta = false;
                                }
                            }
                            if (gowait) {
                                if (py(conto.x / 100, wtx / 100, conto.z / 100, wtz / 100) < 10000 && mad.speed > 50.0F)
                                    up = false;
                                if (py(conto.x / 100, wtx / 100, conto.z / 100, wtz / 100) < 200) {
                                    up = false;
                                    handb = true;
                                }
                                if (checkpoints.pcleared == oupnt && py(checkpoints.opx[0] / 100, frx / 100,
                                        checkpoints.opz[0] / 100, frz / 100) < frad) {
                                    afta = true;
                                    gowait = false;
                                }
                                if (py(conto.x / 100, checkpoints.opx[0] / 100, conto.z / 100,
                                        checkpoints.opz[0] / 100) < 25) {
                                    afta = true;
                                    gowait = false;
                                    attack = 200;
                                    acr = 0;
                                }
                            }
                        }
                        if (checkpoints.stage == 25) {
                            if (oupnt == -1) {
                                int i30 = -10;
                                for (int i31 = 0; i31 < checkpoints.n; i31++)
                                    if ((checkpoints.typ[i31] == -2 || checkpoints.typ[i31] == -4)
                                            && (i31 < 50 || i31 > 54) && (py(conto.x / 100, checkpoints.x[i31] / 100,
                                                    conto.z / 100, checkpoints.z[i31] / 100) < i30 || i30 == -10)) {
                                        i30 = py(conto.x / 100, checkpoints.x[i31] / 100, conto.z / 100,
                                                checkpoints.z[i31] / 100);
                                        oupnt = i31;
                                    }
                                oupnt--;
                                if (i < 0)
                                    oupnt += checkpoints.n;
                            }
                            if (oupnt >= 0 && oupnt < checkpoints.n) {
                                i = oupnt;
                                if (py(conto.x / 100, checkpoints.x[i] / 100, conto.z / 100,
                                        checkpoints.z[i] / 100) < 800) {
                                    oupnt = -(int) (75.0F + m.random() * 200.0F);
                                    runbul = (int) (50.0F + m.random() * 100.0F);
                                }
                            }
                            if (oupnt < -1)
                                oupnt++;
                            if (runbul != 0)
                                runbul--;
                        }
                        if (checkpoints.stage == 26) {
                            boolean bool32 = false;
                            if (mad.cn == 13) {
                                if (!gowait) {
                                    if (checkpoints.clear[0] == 1) {
                                        if (m.random() > 0.5) {
                                            wtx = -14000;
                                            wtz = 48000;
                                            frx = -5600;
                                            frz = 47600;
                                            frad = 88000;
                                            oupnt = 33;
                                        } else {
                                            wtx = -5600;
                                            wtz = 8000;
                                            frx = -7350;
                                            frz = -4550;
                                            frad = 22000;
                                            oupnt = 15;
                                        }
                                        gowait = true;
                                        afta = false;
                                    }
                                    if (checkpoints.clear[0] == 4) {
                                        wtx = -12700;
                                        wtz = 14000;
                                        frx = -31000;
                                        frz = 1050;
                                        frad = 11000;
                                        oupnt = 51;
                                        gowait = true;
                                        afta = false;
                                    }
                                    if (checkpoints.clear[0] == 14) {
                                        wtx = -35350;
                                        wtz = 6650;
                                        frx = -48300;
                                        frz = 54950;
                                        frad = 11000;
                                        oupnt = 15;
                                        gowait = true;
                                        afta = false;
                                    }
                                    if (checkpoints.clear[0] == 17) {
                                        wtx = -42700;
                                        wtz = 41000;
                                        frx = -40950;
                                        frz = 49350;
                                        frad = 7000;
                                        oupnt = 42;
                                        gowait = true;
                                        afta = false;
                                    }
                                    if (checkpoints.clear[0] == 21) {
                                        wtx = -1750;
                                        wtz = -15750;
                                        frx = -25900;
                                        frz = -14000;
                                        frad = 11000;
                                        oupnt = 125;
                                        gowait = true;
                                        afta = false;
                                    }
                                }
                                if (gowait) {
                                    if (py(conto.x / 100, wtx / 100, conto.z / 100, wtz / 100) < 10000
                                            && mad.speed > 50.0F)
                                        up = false;
                                    if (py(conto.x / 100, wtx / 100, conto.z / 100, wtz / 100) < 200) {
                                        up = false;
                                        handb = true;
                                    }
                                    if (checkpoints.pcleared == oupnt && py(checkpoints.opx[0] / 100, frx / 100,
                                            checkpoints.opz[0] / 100, frz / 100) < frad) {
                                        runbul = 0;
                                        afta = true;
                                        gowait = false;
                                    }
                                    if (py(conto.x / 100, checkpoints.opx[0] / 100, conto.z / 100,
                                            checkpoints.opz[0] / 100) < 25) {
                                        afta = true;
                                        gowait = false;
                                        attack = 200;
                                        acr = 0;
                                    }
                                    if (checkpoints.clear[0] == 21 && oupnt != 125)
                                        gowait = false;
                                }
                                if (checkpoints.clear[0] >= 11 && !gowait
                                        || mad.power < 60.0F && checkpoints.clear[0] < 21) {
                                    bool32 = true;
                                    if (!exitattack) {
                                        oupnt = -1;
                                        exitattack = true;
                                    }
                                } else if (exitattack)
                                    exitattack = false;
                            }
                            if (mad.cn == 11)
                                bool32 = true;
                            if (bool32) {
                                if (oupnt == -1) {
                                    int i33 = -10;
                                    for (int i34 = 0; i34 < checkpoints.n; i34++)
                                        if (checkpoints.typ[i34] == -4 && (py(conto.x / 100, checkpoints.x[i34] / 100,
                                                conto.z / 100, checkpoints.z[i34] / 100) < i33 && m.random() > 0.6
                                                || i33 == -10)) {
                                            i33 = py(conto.x / 100, checkpoints.x[i34] / 100, conto.z / 100,
                                                    checkpoints.z[i34] / 100);
                                            oupnt = i34;
                                        }
                                    oupnt--;
                                    if (i < 0)
                                        oupnt += checkpoints.n;
                                }
                                if (oupnt >= 0 && oupnt < checkpoints.n) {
                                    i = oupnt;
                                    if (py(conto.x / 100, checkpoints.x[i] / 100, conto.z / 100,
                                            checkpoints.z[i] / 100) < 800) {
                                        oupnt = -(int) (75.0F + m.random() * 200.0F);
                                        runbul = (int) (50.0F + m.random() * 100.0F);
                                    }
                                }
                                if (oupnt < -1)
                                    oupnt++;
                                if (runbul != 0)
                                    runbul--;
                            }
                        }
                        mad.nofocus = true;
                    }
                    if (checkpoints.stage != 27) {
                        if (checkpoints.stage == 10 || checkpoints.stage == 19
                                || checkpoints.stage == 18 && mad.pcleared == 73 || checkpoints.stage == 26)
                            forget = true;
                        if ((mad.missedcp == 0 || forget || trfix == 4) && trfix != 0) {
                            int i35 = 0;
                            if (checkpoints.stage == 25 || checkpoints.stage == 26)
                                i35 = 3;
                            if (trfix == 2) {
                                int i36 = -10;
                                int i37 = 0;
                                for (int i38 = i35; i38 < checkpoints.fn; i38++)
                                    if (py(conto.x / 100, checkpoints.x[fpnt[i38]] / 100, conto.z / 100,
                                            checkpoints.z[fpnt[i38]] / 100) < i36 || i36 == -10) {
                                        i36 = py(conto.x / 100, checkpoints.x[fpnt[i38]] / 100, conto.z / 100,
                                                checkpoints.z[fpnt[i38]] / 100);
                                        i37 = i38;
                                    }
                                if (checkpoints.stage == 18 || checkpoints.stage == 22)
                                    i37 = 1;
                                i = fpnt[i37];
                                if (checkpoints.special[i37])
                                    forget = true;
                                else
                                    forget = false;
                            }
                            for (int i39 = i35; i39 < checkpoints.fn; i39++)
                                if (py(conto.x / 100, checkpoints.x[fpnt[i39]] / 100, conto.z / 100,
                                        checkpoints.z[fpnt[i39]] / 100) < 2000) {
                                    forget = false;
                                    actwait = 0;
                                    upwait = 0;
                                    turntyp = 2;
                                    randtcnt = -1;
                                    acuracy = 0;
                                    rampp = 0;
                                    trfix = 3;
                                }
                            if (trfix == 3)
                                mad.nofocus = true;
                        }
                    }
                    if (turncnt > randtcnt) {
                        if (!gowait) {
                            int i40 = 0;
                            if (checkpoints.x[i] - conto.x >= 0)
                                i40 = 180;
                            pan = (int) (90 + i40 + Math
                                    .atan((double) (checkpoints.z[i] - conto.z) / (double) (checkpoints.x[i] - conto.x))
                                    / 0.017453292519943295);
                        } else {
                            int i41 = 0;
                            if (wtx - conto.x >= 0)
                                i41 = 180;
                            pan = (int) (90 + i41 + Math.atan((double) (wtz - conto.z) / (double) (wtx - conto.x))
                                    / 0.017453292519943295);
                        }
                        turncnt = 0;
                        randtcnt = (int) (acuracy * m.random());
                    } else
                        turncnt++;
                } else {
                    up = true;
                    int i = 0;
                    final int i42 = (int) (pys(conto.x, checkpoints.opx[acr], conto.z, checkpoints.opz[acr]) / 2.0F
                            * aim);
                    final int i43 = (int) (checkpoints.opx[acr] - i42 * m.sin(checkpoints.omxz[acr]));
                    final int i44 = (int) (checkpoints.opz[acr] + i42 * m.cos(checkpoints.omxz[acr]));
                    if (i43 - conto.x >= 0)
                        i = 180;
                    pan = (int) (90 + i
                            + Math.atan((double) (i44 - conto.z) / (double) (i43 - conto.x)) / 0.017453292519943295);
                    attack--;
                    if (attack <= 0)
                        attack = 0;
                    if (checkpoints.stage == 25 && exitattack && !bulistc && mad.missedcp != 0)
                        attack = 0;
                    if (checkpoints.stage == 26 && mad.cn == 13
                            && (checkpoints.clear[0] == 4 || checkpoints.clear[0] == 13 || checkpoints.clear[0] == 21))
                        attack = 0;
                    if (checkpoints.stage == 26 && mad.missedcp != 0 && (checkpoints.pos[mad.im] == 0
                            || checkpoints.pos[mad.im] == 1 && checkpoints.pos[0] == 0))
                        attack = 0;
                    if (checkpoints.stage == 26 && checkpoints.pos[0] > checkpoints.pos[mad.im] && mad.power < 80.0F)
                        attack = 0;
                }
                int i = conto.xz;
                if (zyinv)
                    i += 180;
                for (/**/; i < 0; i += 360) {
                    
                }
                for (/**/; i > 180; i -= 360) {
                    
                }
                for (/**/; pan < 0; pan += 360) {
                    
                }
                for (/**/; pan > 180; pan -= 360) {
                    
                }
                if (wall != -1 && hold == 0)
                    clrnce = 0;
                if (hold == 0)
                    if (Math.abs(i - pan) < 180) {
                        if (Math.abs(i - pan) > clrnce) {
                            if (i < pan) {
                                left = true;
                                lastl = true;
                            } else {
                                right = true;
                                lastl = false;
                            }
                            if (Math.abs(i - pan) > 50 && mad.speed > mad.cd.swits[mad.cn][0] && turntyp != 0) {
                                if (turntyp == 1)
                                    down = true;
                                if (turntyp == 2)
                                    handb = true;
                                if (!agressed)
                                    up = false;
                            }
                        }
                    } else if (Math.abs(i - pan) < 360 - clrnce) {
                        if (i < pan) {
                            right = true;
                            lastl = false;
                        } else {
                            left = true;
                            lastl = true;
                        }
                        if (Math.abs(i - pan) < 310 && mad.speed > mad.cd.swits[mad.cn][0] && turntyp != 0) {
                            if (turntyp == 1)
                                down = true;
                            if (turntyp == 2)
                                handb = true;
                            if (!agressed)
                                up = false;
                        }
                    }
                if (checkpoints.stage == 24 && wall != -1) {
                    if (trackers.dam[wall] == 0 || mad.pcleared == 45)
                        wall = -1;
                    if (mad.pcleared == 58 && checkpoints.opz[mad.im] < 36700) {
                        wall = -1;
                        hold = 0;
                    }
                }
                if (wall != -1) {
                    if (lwall != wall) {
                        if (lastl)
                            left = true;
                        else
                            right = true;
                        wlastl = lastl;
                        lwall = wall;
                    } else if (wlastl)
                        left = true;
                    else
                        right = true;
                    if (trackers.dam[wall] != 0) {
                        int i45 = 1;
                        if (trackers.skd[wall] == 1)
                            i45 = 3;
                        hold += i45;
                        if (hold > 10 * i45)
                            hold = 10 * i45;
                    } else
                        hold = 1;
                    wall = -1;
                } else if (hold != 0)
                    hold--;
            } else {
                if (trickfase == 0) {
                    final int i = (int) ((mad.scy[0] + mad.scy[1] + mad.scy[2] + mad.scy[3]) * (conto.y - 300)
                            / 4000.0F);
                    int i46 = 3;
                    if (checkpoints.stage == 25)
                        i46 = 10;
                    if (i > 7 && (m.random() > trickprf / i46 || stuntf == 4 || stuntf == 3 || stuntf == 5
                            || stuntf == 6 || checkpoints.stage == 26)) {
                        oxy = mad.pxy;
                        ozy = mad.pzy;
                        flycnt = 0;
                        uddirect = 0;
                        lrdirect = 0;
                        udswt = false;
                        lrswt = false;
                        trickfase = 1;
                        if (i < 16) {
                            if (stuntf != 6) {
                                uddirect = -1;
                                udstart = 0;
                                udswt = false;
                            } else if (oupnt != 70) {
                                uddirect = 1;
                                udstart = 0;
                                udswt = false;
                            }
                        } else if (m.random() > m.random() && stuntf != 1 || stuntf == 4 || stuntf == 6 || stuntf == 7
                                || stuntf == 17) {
                            if ((m.random() > m.random() || stuntf == 2 || stuntf == 7) && stuntf != 4 && stuntf != 6)
                                uddirect = -1;
                            else
                                uddirect = 1;
                            udstart = (int) (10.0F * m.random() * trickprf);
                            if (stuntf == 6)
                                udstart = 0;
                            if (checkpoints.stage == 26)
                                udstart = 0;
                            if (checkpoints.stage == 24 && (oupnt == 68 || oupnt == 69)) {
                                apunch = 20;
                                oupnt = 70;
                            }
                            if (m.random() > 0.85 && stuntf != 4 && stuntf != 3 && stuntf != 6 && stuntf != 17
                                    && checkpoints.stage != 26)
                                udswt = true;
                            if (m.random() > trickprf + 0.3F && stuntf != 4 && stuntf != 6) {
                                if (m.random() > m.random())
                                    lrdirect = -1;
                                else
                                    lrdirect = 1;
                                lrstart = (int) (30.0F * m.random());
                                if (m.random() > 0.75)
                                    lrswt = true;
                            }
                        } else {
                            if (m.random() > m.random())
                                lrdirect = -1;
                            else
                                lrdirect = 1;
                            lrstart = (int) (10.0F * m.random() * trickprf);
                            if (m.random() > 0.75 && checkpoints.stage != 26)
                                lrswt = true;
                            if (m.random() > trickprf + 0.3F) {
                                if (m.random() > m.random())
                                    uddirect = -1;
                                else
                                    uddirect = 1;
                                udstart = (int) (30.0F * m.random());
                                if (m.random() > 0.85)
                                    udswt = true;
                            }
                        }
                        if (trfix == 3 || trfix == 4) {
                            if (checkpoints.stage != 18 && checkpoints.stage != 8) {
                                if (checkpoints.stage != 25 && lrdirect == -1)
                                    if (checkpoints.stage != 19)
                                        uddirect = -1;
                                    else
                                        uddirect = 1;
                                lrdirect = 0;
                                if ((checkpoints.stage == 19 || checkpoints.stage == 25) && uddirect == -1)
                                    uddirect = 1;
                                if (mad.power < 60.0F)
                                    uddirect = -1;
                            } else {
                                if (uddirect != 0)
                                    uddirect = -1;
                                lrdirect = 0;
                            }
                            if (checkpoints.stage == 20) {
                                uddirect = 1;
                                lrdirect = 0;
                            }
                            if (checkpoints.stage == 26) {
                                uddirect = -1;
                                lrdirect = 0;
                                if (mad.cn != 11 && mad.cn != 13) {
                                    udstart = 7;
                                    if (mad.cn == 14 && mad.power > 30.0F)
                                        udstart = 14;
                                } else
                                    udstart = 0;
                                if (mad.cn == 11) {
                                    lrdirect = -1;
                                    lrstart = 0;
                                }
                            }
                        }
                    } else
                        trickfase = -1;
                    if (!afta)
                        afta = true;
                    if (trfix == 3) {
                        trfix = 4;
                        statusque += 30;
                    }
                }
                if (trickfase == 1) {
                    flycnt++;
                    if (lrdirect != 0 && flycnt > lrstart) {
                        if (lrswt && Math.abs(mad.pxy - oxy) > 180) {
                            if (lrdirect == -1)
                                lrdirect = 1;
                            else
                                lrdirect = -1;
                            lrswt = false;
                        }
                        if (lrdirect == -1) {
                            handb = true;
                            left = true;
                        } else {
                            handb = true;
                            right = true;
                        }
                    }
                    if (uddirect != 0 && flycnt > udstart) {
                        if (udswt && Math.abs(mad.pzy - ozy) > 180) {
                            if (uddirect == -1)
                                uddirect = 1;
                            else
                                uddirect = -1;
                            udswt = false;
                        }
                        if (uddirect == -1) {
                            handb = true;
                            down = true;
                        } else {
                            handb = true;
                            up = true;
                            if (apunch > 0) {
                                down = true;
                                apunch--;
                            }
                        }
                    }
                    if ((mad.scy[0] + mad.scy[1] + mad.scy[2] + mad.scy[3]) * 100.0F / (conto.y - 300) < -saftey) {
                        onceu = false;
                        onced = false;
                        oncel = false;
                        oncer = false;
                        lrcomp = false;
                        udcomp = false;
                        udbare = false;
                        lrbare = false;
                        trickfase = 2;
                        swat = 0;
                    }
                }
                if (trickfase == 2) {
                    if (swat == 0) {
                        if (mad.dcomp != 0.0F || mad.ucomp != 0.0F)
                            udbare = true;
                        if (mad.lcomp != 0.0F || mad.rcomp != 0.0F)
                            lrbare = true;
                        swat = 1;
                    }
                    if (mad.wtouch) {
                        if (swat == 1)
                            swat = 2;
                    } else if (swat == 2) {
                        if (mad.capsized && m.random() > mustland)
                            if (udbare) {
                                lrbare = true;
                                udbare = false;
                            } else if (lrbare) {
                                udbare = true;
                                lrbare = false;
                            }
                        swat = 3;
                    }
                    if (udbare) {
                        int i;
                        for (i = mad.pzy + 90; i < 0; i += 360) {
                            
                        }
                        for (/**/; i > 180; i -= 360) {
                            
                        }
                        i = Math.abs(i);
                        if (mad.lcomp - mad.rcomp < 5.0F && (onced || onceu))
                            udcomp = true;
                        if (mad.dcomp > mad.ucomp) {
                            if (mad.capsized) {
                                if (udcomp) {
                                    if (i > 90)
                                        up = true;
                                    else
                                        down = true;
                                } else if (!onced)
                                    down = true;
                            } else {
                                if (udcomp) {
                                    if (perfection && Math.abs(i - 90) > 30)
                                        if (i > 90)
                                            up = true;
                                        else
                                            down = true;
                                } else if (m.random() > mustland)
                                    up = true;
                                onced = true;
                            }
                        } else if (mad.capsized) {
                            if (udcomp) {
                                if (i > 90)
                                    up = true;
                                else
                                    down = true;
                            } else if (!onceu)
                                up = true;
                        } else {
                            if (udcomp) {
                                if (perfection && Math.abs(i - 90) > 30)
                                    if (i > 90)
                                        up = true;
                                    else
                                        down = true;
                            } else if (m.random() > mustland)
                                down = true;
                            onceu = true;
                        }
                    }
                    if (lrbare) {
                        int i = mad.pxy + 90;
                        if (zyinv)
                            i += 180;
                        for (/**/; i < 0; i += 360) {
                            
                        }
                        for (/**/; i > 180; i -= 360) {
                            
                        }
                        i = Math.abs(i);
                        if (mad.lcomp - mad.rcomp < 10.0F && (oncel || oncer))
                            lrcomp = true;
                        if (mad.lcomp > mad.rcomp) {
                            if (mad.capsized) {
                                if (lrcomp) {
                                    if (i > 90)
                                        left = true;
                                    else
                                        right = true;
                                } else if (!oncel)
                                    left = true;
                            } else {
                                if (lrcomp) {
                                    if (perfection && Math.abs(i - 90) > 30)
                                        if (i > 90)
                                            left = true;
                                        else
                                            right = true;
                                } else if (m.random() > mustland)
                                    right = true;
                                oncel = true;
                            }
                        } else if (mad.capsized) {
                            if (lrcomp) {
                                if (i > 90)
                                    left = true;
                                else
                                    right = true;
                            } else if (!oncer)
                                right = true;
                        } else {
                            if (lrcomp) {
                                if (perfection && Math.abs(i - 90) > 30)
                                    if (i > 90)
                                        left = true;
                                    else
                                        right = true;
                            } else if (m.random() > mustland)
                                left = true;
                            oncer = true;
                        }
                    }
                }
            }
        }
    }

    private int py(final int i, final int i47, final int i48, final int i49) {
        return (i - i47) * (i - i47) + (i48 - i49) * (i48 - i49);
    }

    private int pys(final int i, final int i50, final int i51, final int i52) {
        return (int) Math.sqrt((i - i50) * (i - i50) + (i51 - i52) * (i51 - i52));
    }

    public void reset(final CheckPoints checkpoints, final int i) {
        pan = 0;
        attack = 0;
        acr = 0;
        afta = false;
        trfix = 0;
        acuracy = 0;
        upwait = 0;
        forget = false;
        bulistc = false;
        runbul = 0;
        revstart = 0;
        oupnt = 0;
        gowait = false;
        apunch = 0;
        exitattack = false;
        if (checkpoints.stage == 16 || checkpoints.stage == 18)
            hold = 50;
        if (checkpoints.stage == 17)
            hold = 10;
        if (checkpoints.stage == 20)
            hold = 30;
        if (checkpoints.stage == 21) {
            if (i != 13) {
                hold = 35;
                revstart = 25;
            } else
                hold = 5;
            statusque = 0;
        }
        if (checkpoints.stage == 22) {
            if (i != 13) {
                hold = (int) (20.0F + 10.0F * m.random());
                revstart = (int) (10.0F + 10.0F * m.random());
            } else
                hold = 5;
            statusque = 0;
        }
        if (checkpoints.stage == 24) {
            hold = 30;
            statusque = 0;
            if (i != 14)
                revstart = 1;
        }
        if (checkpoints.stage == 25)
            hold = 40;
        if (checkpoints.stage == 26)
            hold = 20;
        if (checkpoints.stage != 19 && checkpoints.stage != 26) {
            for (int i0 = 0; i0 < checkpoints.fn; i0++) {
                int i1 = -10;
                for (int i2 = 0; i2 < checkpoints.n; i2++)
                    if (py(checkpoints.fx[i0] / 100, checkpoints.x[i2] / 100, checkpoints.fz[i0] / 100,
                            checkpoints.z[i2] / 100) < i1 || i1 == -10) {
                        i1 = py(checkpoints.fx[i0] / 100, checkpoints.x[i2] / 100, checkpoints.fz[i0] / 100,
                                checkpoints.z[i2] / 100);
                        fpnt[i0] = i2;
                    }
            }
            for (int i3 = 0; i3 < checkpoints.fn; i3++) {
                fpnt[i3] -= 4;
                if (fpnt[i3] < 0)
                    fpnt[i3] += checkpoints.nsp;
            }
        } else {
            if (checkpoints.stage == 19) {
                fpnt[0] = 14;
                fpnt[1] = 36;
            }
            if (checkpoints.stage == 26)
                fpnt[3] = 39;
        }
        left = false;
        right = false;
        up = false;
        down = false;
        handb = false;
        lookback = 0;
        arrace = false;
        mutem = false;
        mutes = false;
    }
}
