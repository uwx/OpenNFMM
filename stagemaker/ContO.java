package stagemaker;

/* ContO - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Random;
public class ContO
{
    Medium m;
    Trackers t;
    Plane[] p;
    int npl = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    int xz = 0;
    int xy = 0;
    int zy = 0;
    int wxz = 0;
    int wzy = 0;
    int dist = 0;
    int maxR = 0;
    int disp = 0;
    int disline = 14;
    boolean shadow = false;
    boolean noline = false;
    boolean decor = false;
    float grounded = 1.0F;
    int grat = 0;
    int[] keyx;
    int[] keyz;
    int sprkat;
    int[] txy;
    int[] tzy;
    int[][] tc;
    int[] tradx;
    int[] tradz;
    int[] trady;
    int[] tx;
    int[] ty;
    int[] tz;
    int[] skd;
    int[] dam;
    boolean[] notwall;
    int tnt;
    int[] stg;
    int[] sx;
    int[] sy;
    int[] sz;
    int[] scx;
    int[] scz;
    float[] osmag;
    int[] sav;
    float[][] smag;
    int[][] srgb;
    float[] sbln;
    int ust;
    int srx;
    int sry;
    int srz;
    float rcx;
    float rcy;
    float rcz;
    int sprk;
    int[] rtg;
    boolean[] rbef;
    int[] rx;
    int[] ry;
    int[] rz;
    float[] vrx;
    float[] vry;
    float[] vrz;
    boolean elec;
    boolean roted;
    int[] edl;
    int[] edr;
    int[] elc;
    boolean fix;
    int fcnt;
    int checkpoint;
    int[] fcol;
    int[] scol;
    int colok;
    boolean errd;
    String err;
    int roofat;
    int wh;
    
    public ContO(byte[] is, Medium medium, Trackers trackers) {
        keyx = new int[4];
        keyz = new int[4];
        sprkat = 0;
        tnt = 0;
        ust = 0;
        srx = 0;
        sry = 0;
        srz = 0;
        rcx = 0.0F;
        rcy = 0.0F;
        rcz = 0.0F;
        sprk = 0;
        elec = false;
        roted = false;
        edl = new int[4];
        edr = new int[4];
        elc = new int[] { 0, 0, 0, 0 };
        fix = false;
        fcnt = 0;
        checkpoint = 0;
        fcol = new int[] { 0, 0, 0 };
        scol = new int[] { 0, 0, 0 };
        colok = 0;
        errd = false;
        err = "";
        roofat = 0;
        wh = 0;
        m = medium;
        t = trackers;
        p = new Plane[10000];
        int[] is_0_ = new int[10000];
        for (int i = 0; i < 286; i++)
            is_0_[i] = 0;
        if ((m).loadnew) {
            for (int i = 0; i < 4; i++)
                keyz[i] = 0;
            shadow = true;
        }
        String string = "";
        boolean bool = false;
        boolean bool_1_ = false;
        int i = 0;
        float f = 1.0F;
        float f_2_ = 1.0F;
        float[] fs = { 1.0F, 1.0F, 1.0F };
        int[] is_3_ = new int[100];
        int[] is_4_ = new int[100];
        int[] is_5_ = new int[100];
        int[] is_6_ = { 0, 0, 0 };
        boolean bool_7_ = false;
        Wheels wheels = new Wheels();
        int i_8_ = 0;
        int i_9_ = 1;
        int i_10_ = 0;
        int i_11_ = 0;
        int i_12_ = 0;
        int i_13_ = 0;
        boolean bool_14_ = false;
        boolean bool_15_ = false;
        try {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(is));
            String string_16_;
            while ((string_16_ = datainputstream.readLine()) != null) {
                string = new StringBuilder().append("").append(string_16_.trim()).toString();
                if (npl < 10000) {
                    if (string.startsWith("<p>")) {
                        bool = true;
                        i = 0;
                        i_9_ = 0;
                        i_10_ = 0;
                        i_12_ = 0;
                        is_0_[npl] = 1;
                        if (!bool_15_)
                            bool_14_ = false;
                    }
                    if (bool) {
                        if (string.startsWith("gr("))
                            i_9_ = getvalue("gr", string, 0);
                        if (string.startsWith("fs(")) {
                            i_10_ = getvalue("fs", string, 0);
                            is_0_[npl] = 2;
                        }
                        if (string.startsWith("c(")) {
                            i_13_ = 0;
                            is_6_[0] = getvalue("c", string, 0);
                            is_6_[1] = getvalue("c", string, 1);
                            is_6_[2] = getvalue("c", string, 2);
                        }
                        if (string.startsWith("glass"))
                            i_13_ = 1;
                        if (string.startsWith("gshadow"))
                            i_13_ = 2;
                        if (string.startsWith("lightF"))
                            i_12_ = 1;
                        if (string.startsWith("light"))
                            i_12_ = 1;
                        if (string.startsWith("lightB"))
                            i_12_ = 2;
                        if (string.startsWith("noOutline"))
                            bool_14_ = true;
                        if (string.startsWith("p(")) {
                            is_3_[i] = (int) ((float) getvalue("p", string, 0) * f * f_2_ * fs[0]);
                            is_4_[i] = (int) ((float) getvalue("p", string, 1) * f * fs[1]);
                            is_5_[i] = (int) ((float) getvalue("p", string, 2) * f * fs[2]);
                            int i_17_ = (int) Math.sqrt((double) (is_3_[i] * is_3_[i] + is_4_[i] * is_4_[i] + is_5_[i] * is_5_[i]));
                            if (i_17_ > maxR)
                                maxR = i_17_;
                            i++;
                        }
                    }
                    if (string.startsWith("</p>")) {
                        p[npl] = new Plane(m, t, is_3_, is_5_, is_4_, i, is_6_, i_13_, i_9_, i_10_, 0, 0, 0, disline, 0, bool_7_, i_12_, bool_14_);
                        if (is_6_[0] == fcol[0] && is_6_[1] == fcol[1] && is_6_[2] == fcol[2] && i_13_ == 0)
                            (p[npl]).colnum = 1;
                        if (is_6_[0] == scol[0] && is_6_[1] == scol[1] && is_6_[2] == scol[2] && i_13_ == 0)
                            (p[npl]).colnum = 2;
                        npl++;
                        bool = false;
                    }
                }
                if (string.startsWith("rims("))
                    wheels.setrims(getvalue("rims", string, 0), getvalue("rims", string, 1), getvalue("rims", string, 2), getvalue("rims", string, 3), getvalue("rims", string, 4));
                if (string.startsWith("w(") && i_8_ < 4) {
                    keyx[i_8_] = (int) ((float) getvalue("w", string, 0) * f * fs[0]);
                    keyz[i_8_] = (int) ((float) getvalue("w", string, 2) * f * fs[2]);
                    wheels.make(m, t, p, npl, (int) ((float) getvalue("w", string, 0) * f * f_2_ * fs[0]), (int) ((float) getvalue("w", string, 1) * f * fs[1]), (int) ((float) getvalue("w", string, 2) * f * fs[2]), getvalue("w", string, 3), (int) ((float) getvalue("w", string, 4) * f * f_2_), (int) ((float) getvalue("w", string, 5) * f), i_11_);
                    npl += 19;
                    if ((m).loadnew) {
                        wh += (int) ((float) getvalue("w", string, 5) * f);
                        if ((wheels).ground > 140) {
                            String string_18_ = "FRONT";
                            if (keyz[i_8_] < 0)
                                string_18_ = "BACK";
                            err = new StringBuilder().append("Wheels Error:\n").append(string_18_).append(" Wheels floor is too far below the center of Y Axis of the car!    \n\nPlease decrease the Y value of the ").append(string_18_).append(" Wheels or decrease its height.     \n \n").toString();
                            errd = true;
                            keyz[i_8_] = 0;
                            keyx[i_8_] = 0;
                        }
                        if ((wheels).ground < -100) {
                            String string_19_ = "FRONT";
                            if (keyz[i_8_] < 0)
                                string_19_ = "BACK";
                            err = new StringBuilder().append("Wheels Error:\n").append(string_19_).append(" Wheels floor is too far above the center of Y Axis of the car!    \n\nPlease increase the Y value of the ").append(string_19_).append(" Wheels or increase its height.     \n \n").toString();
                            errd = true;
                            keyz[i_8_] = 0;
                            keyx[i_8_] = 0;
                        }
                        if (Math.abs(keyx[i_8_]) > 400) {
                            String string_20_ = "FRONT";
                            if (keyz[i_8_] < 0)
                                string_20_ = "BACK";
                            err = new StringBuilder().append("Wheels Error:\n").append(string_20_).append(" Wheels are too far apart!    \n\nPlease decrease the \u00b1X value of the ").append(string_20_).append(" Wheels.     \n \n").toString();
                            errd = true;
                            keyz[i_8_] = 0;
                            keyx[i_8_] = 0;
                        }
                        if (Math.abs(keyz[i_8_]) > 700) {
                            if (keyz[i_8_] < 0)
                                err = "Wheels Error:\nBACK Wheels are too far backwards from the center of the Z Axis!    \n\nPlease increase the -Z value of the BACK Wheels.     \n \n";
                            else
                                err = "Wheels Error:\nFRONT Wheels are too far forwards from the center of the Z Axis!    \n\nPlease decrease the +Z value of the FRONT Wheels.     \n \n";
                            errd = true;
                            keyz[i_8_] = 0;
                            keyx[i_8_] = 0;
                        }
                        if ((int) ((float) getvalue("w", string, 4) * f * f_2_) > 300) {
                            String string_21_ = "FRONT";
                            if (keyz[i_8_] < 0)
                                string_21_ = "BACK";
                            err = new StringBuilder().append("Wheels Error:\nWidth of the ").append(string_21_).append(" Wheels is too large!    \n\nPlease decrease the width of the ").append(string_21_).append(" Wheels.     \n \n").toString();
                            errd = true;
                            keyz[i_8_] = 0;
                            keyx[i_8_] = 0;
                        }
                    }
                    i_8_++;
                }
                if (string.startsWith("tracks")) {
                    int i_22_ = getvalue("tracks", string, 0);
                    txy = new int[i_22_];
                    tzy = new int[i_22_];
                    tc = new int[i_22_][3];
                    tradx = new int[i_22_];
                    tradz = new int[i_22_];
                    trady = new int[i_22_];
                    tx = new int[i_22_];
                    ty = new int[i_22_];
                    tz = new int[i_22_];
                    skd = new int[i_22_];
                    dam = new int[i_22_];
                    notwall = new boolean[i_22_];
                }
                if (string.startsWith("<track>")) {
                    bool_1_ = true;
                    notwall[tnt] = false;
                    dam[tnt] = 1;
                    skd[tnt] = 0;
                    ty[tnt] = 0;
                    tx[tnt] = 0;
                    tz[tnt] = 0;
                    txy[tnt] = 0;
                    tzy[tnt] = 0;
                    trady[tnt] = 0;
                    tradx[tnt] = 0;
                    tradz[tnt] = 0;
                    tc[tnt][0] = 0;
                    tc[tnt][1] = 0;
                    tc[tnt][2] = 0;
                }
                if (bool_1_) {
                    if (string.startsWith("c")) {
                        tc[tnt][0] = getvalue("c", string, 0);
                        tc[tnt][1] = getvalue("c", string, 1);
                        tc[tnt][2] = getvalue("c", string, 2);
                    }
                    if (string.startsWith("xy"))
                        txy[tnt] = getvalue("xy", string, 0);
                    if (string.startsWith("zy"))
                        tzy[tnt] = getvalue("zy", string, 0);
                    if (string.startsWith("radx"))
                        tradx[tnt] = (int) ((float) getvalue("radx", string, 0) * f);
                    if (string.startsWith("rady"))
                        trady[tnt] = (int) ((float) getvalue("rady", string, 0) * f);
                    if (string.startsWith("radz"))
                        tradz[tnt] = (int) ((float) getvalue("radz", string, 0) * f);
                    if (string.startsWith("ty"))
                        ty[tnt] = (int) ((float) getvalue("ty", string, 0) * f);
                    if (string.startsWith("tx"))
                        tx[tnt] = (int) ((float) getvalue("tx", string, 0) * f);
                    if (string.startsWith("tz"))
                        tz[tnt] = (int) ((float) getvalue("tz", string, 0) * f);
                    if (string.startsWith("skid"))
                        skd[tnt] = getvalue("skid", string, 0);
                    if (string.startsWith("dam"))
                        dam[tnt] = 3;
                    if (string.startsWith("notwall"))
                        notwall[tnt] = true;
                }
                if (string.startsWith("</track>")) {
                    bool_1_ = false;
                    tnt++;
                }
                if (string.startsWith("disp("))
                    disp = getvalue("disp", string, 0);
                if (string.startsWith("disline("))
                    disline = getvalue("disline", string, 0) * 2;
                if (string.startsWith("shadow"))
                    shadow = true;
                if (string.startsWith("stonecold"))
                    noline = true;
                if (string.startsWith("newstone")) {
                    noline = true;
                    bool_14_ = true;
                    bool_15_ = true;
                }
                if (string.startsWith("decorative"))
                    decor = true;
                if (string.startsWith("road"))
                    bool_7_ = true;
                if (string.startsWith("notroad"))
                    bool_7_ = false;
                if (string.startsWith("grounded("))
                    grounded = (float) getvalue("grounded", string, 0) / 100.0F;
                if (string.startsWith("div("))
                    f = (float) getvalue("div", string, 0) / 10.0F;
                if (string.startsWith("idiv("))
                    f = (float) getvalue("idiv", string, 0) / 100.0F;
                if (string.startsWith("iwid("))
                    f_2_ = (float) getvalue("iwid", string, 0) / 100.0F;
                if (string.startsWith("ScaleX("))
                    fs[0] = (float) getvalue("ScaleX", string, 0) / 100.0F;
                if (string.startsWith("ScaleY("))
                    fs[1] = (float) getvalue("ScaleY", string, 0) / 100.0F;
                if (string.startsWith("ScaleZ("))
                    fs[2] = (float) getvalue("ScaleZ", string, 0) / 100.0F;
                if (string.startsWith("gwgr(")) {
                    i_11_ = getvalue("gwgr", string, 0);
                    if ((m).loadnew) {
                        if (i_11_ > 40)
                            i_11_ = 40;
                        if (i_11_ < 0 && i_11_ >= -15)
                            i_11_ = -16;
                        if (i_11_ < -40)
                            i_11_ = -40;
                    }
                }
                if (string.startsWith("1stColor(")) {
                    fcol[0] = getvalue("1stColor", string, 0);
                    fcol[1] = getvalue("1stColor", string, 1);
                    fcol[2] = getvalue("1stColor", string, 2);
                    colok++;
                }
                if (string.startsWith("2ndColor(")) {
                    scol[0] = getvalue("2ndColor", string, 0);
                    scol[1] = getvalue("2ndColor", string, 1);
                    scol[2] = getvalue("2ndColor", string, 2);
                    colok++;
                }
            }
            datainputstream.close();
        } catch (Exception exception) {
            if (!errd) {
                err = new StringBuilder().append("Error While Loading 3D Model\n\nLine:     ").append(string).append("\n\nError Detail:\n").append(exception).append("           \n \n").toString();
                System.out.println(err);
                errd = true;
            }
        }
        grat = (wheels).ground;
        sprkat = (wheels).sparkat;
        if (shadow) {
            stg = new int[20];
            rtg = new int[100];
            for (int i_23_ = 0; i_23_ < 20; i_23_++)
                stg[i_23_] = 0;
            for (int i_24_ = 0; i_24_ < 100; i_24_++)
                rtg[i_24_] = 0;
        }
        if ((m).loadnew) {
            if (i_8_ != 0)
                wh = wh / i_8_;
            boolean bool_25_ = false;
            for (int i_26_ = 0; i_26_ < npl; i_26_++) {
                int i_27_ = 0;
                int i_28_ = (p[i_26_]).ox[0];
                int i_29_ = (p[i_26_]).ox[0];
                int i_30_ = (p[i_26_]).oy[0];
                int i_31_ = (p[i_26_]).oy[0];
                int i_32_ = (p[i_26_]).oz[0];
                int i_33_ = (p[i_26_]).oz[0];
                for (int i_34_ = 0; i_34_ < (p[i_26_]).n; i_34_++) {
                    if ((p[i_26_]).ox[i_34_] > i_28_)
                        i_28_ = (p[i_26_]).ox[i_34_];
                    if ((p[i_26_]).ox[i_34_] < i_29_)
                        i_29_ = (p[i_26_]).ox[i_34_];
                    if ((p[i_26_]).oy[i_34_] > i_30_)
                        i_30_ = (p[i_26_]).oy[i_34_];
                    if ((p[i_26_]).oy[i_34_] < i_31_)
                        i_31_ = (p[i_26_]).oy[i_34_];
                    if ((p[i_26_]).oz[i_34_] > i_32_)
                        i_32_ = (p[i_26_]).oz[i_34_];
                    if ((p[i_26_]).oz[i_34_] < i_33_)
                        i_33_ = (p[i_26_]).oz[i_34_];
                }
                if (Math.abs(i_28_ - i_29_) <= Math.abs(i_30_ - i_31_) && Math.abs(i_28_ - i_29_) <= Math.abs(i_32_ - i_33_))
                    i_27_ = 1;
                if (Math.abs(i_30_ - i_31_) <= Math.abs(i_28_ - i_29_) && Math.abs(i_30_ - i_31_) <= Math.abs(i_32_ - i_33_))
                    i_27_ = 2;
                if (Math.abs(i_32_ - i_33_) <= Math.abs(i_28_ - i_29_) && Math.abs(i_32_ - i_33_) <= Math.abs(i_30_ - i_31_))
                    i_27_ = 3;
                if (i_27_ == 2 && (!bool_25_ || (i_30_ + i_31_) / 2 < roofat)) {
                    roofat = (i_30_ + i_31_) / 2;
                    bool_25_ = true;
                }
                if (is_0_[i_26_] == 1) {
                    int i_35_ = 1000;
                    int i_36_ = 0;
                    for (int i_37_ = 0; i_37_ < (p[i_26_]).n; i_37_++) {
                        int i_38_ = i_37_ + 1;
                        if (i_38_ >= (p[i_26_]).n)
                            i_38_ -= (p[i_26_]).n;
                        int i_39_ = i_37_ + 2;
                        if (i_39_ >= (p[i_26_]).n)
                            i_39_ -= (p[i_26_]).n;
                        if (i_27_ == 1) {
                            int i_40_ = Math.abs((int) (Math.atan((double) ((p[i_26_]).oz[i_37_] - (p[i_26_]).oz[i_38_]) / (double) ((p[i_26_]).oy[i_37_] - (p[i_26_]).oy[i_38_])) / 0.017453292519943295));
                            int i_41_ = Math.abs((int) (Math.atan((double) ((p[i_26_]).oz[i_39_] - (p[i_26_]).oz[i_38_]) / (double) ((p[i_26_]).oy[i_39_] - (p[i_26_]).oy[i_38_])) / 0.017453292519943295));
                            if (i_40_ > 45)
                                i_40_ = 90 - i_40_;
                            else
                                i_41_ = 90 - i_41_;
                            if (i_40_ + i_41_ < i_35_) {
                                i_35_ = i_40_ + i_41_;
                                i_36_ = i_37_;
                            }
                        }
                        if (i_27_ == 2) {
                            int i_42_ = Math.abs((int) (Math.atan((double) ((p[i_26_]).oz[i_37_] - (p[i_26_]).oz[i_38_]) / (double) ((p[i_26_]).ox[i_37_] - (p[i_26_]).ox[i_38_])) / 0.017453292519943295));
                            int i_43_ = Math.abs((int) (Math.atan((double) ((p[i_26_]).oz[i_39_] - (p[i_26_]).oz[i_38_]) / (double) ((p[i_26_]).ox[i_39_] - (p[i_26_]).ox[i_38_])) / 0.017453292519943295));
                            if (i_42_ > 45)
                                i_42_ = 90 - i_42_;
                            else
                                i_43_ = 90 - i_43_;
                            if (i_42_ + i_43_ < i_35_) {
                                i_35_ = i_42_ + i_43_;
                                i_36_ = i_37_;
                            }
                        }
                        if (i_27_ == 3) {
                            int i_44_ = Math.abs((int) (Math.atan((double) ((p[i_26_]).oy[i_37_] - (p[i_26_]).oy[i_38_]) / (double) ((p[i_26_]).ox[i_37_] - (p[i_26_]).ox[i_38_])) / 0.017453292519943295));
                            int i_45_ = Math.abs((int) (Math.atan((double) ((p[i_26_]).oy[i_39_] - (p[i_26_]).oy[i_38_]) / (double) ((p[i_26_]).ox[i_39_] - (p[i_26_]).ox[i_38_])) / 0.017453292519943295));
                            if (i_44_ > 45)
                                i_44_ = 90 - i_44_;
                            else
                                i_45_ = 90 - i_45_;
                            if (i_44_ + i_45_ < i_35_) {
                                i_35_ = i_44_ + i_45_;
                                i_36_ = i_37_;
                            }
                        }
                    }
                    if (i_36_ != 0) {
                        int[] is_46_ = new int[(p[i_26_]).n];
                        int[] is_47_ = new int[(p[i_26_]).n];
                        int[] is_48_ = new int[(p[i_26_]).n];
                        for (int i_49_ = 0; i_49_ < (p[i_26_]).n; i_49_++) {
                            is_46_[i_49_] = (p[i_26_]).ox[i_49_];
                            is_47_[i_49_] = (p[i_26_]).oy[i_49_];
                            is_48_[i_49_] = (p[i_26_]).oz[i_49_];
                        }
                        for (int i_50_ = 0; i_50_ < (p[i_26_]).n; i_50_++) {
                            int i_51_ = i_50_ + i_36_;
                            if (i_51_ >= (p[i_26_]).n)
                                i_51_ -= (p[i_26_]).n;
                            (p[i_26_]).ox[i_50_] = is_46_[i_51_];
                            (p[i_26_]).oy[i_50_] = is_47_[i_51_];
                            (p[i_26_]).oz[i_50_] = is_48_[i_51_];
                        }
                    }
                    if (i_27_ == 1) {
                        if (Math.abs((p[i_26_]).oz[0] - (p[i_26_]).oz[1]) > Math.abs((p[i_26_]).oy[0] - (p[i_26_]).oy[1])) {
                            if ((p[i_26_]).oz[0] > (p[i_26_]).oz[1]) {
                                if ((p[i_26_]).oy[1] > (p[i_26_]).oy[2])
                                    (p[i_26_]).fs = 1;
                                else
                                    (p[i_26_]).fs = -1;
                            } else if ((p[i_26_]).oy[1] > (p[i_26_]).oy[2])
                                (p[i_26_]).fs = -1;
                            else
                                (p[i_26_]).fs = 1;
                        } else if ((p[i_26_]).oy[0] > (p[i_26_]).oy[1]) {
                            if ((p[i_26_]).oz[1] > (p[i_26_]).oz[2])
                                (p[i_26_]).fs = -1;
                            else
                                (p[i_26_]).fs = 1;
                        } else if ((p[i_26_]).oz[1] > (p[i_26_]).oz[2])
                            (p[i_26_]).fs = 1;
                        else
                            (p[i_26_]).fs = -1;
                    }
                    if (i_27_ == 2) {
                        if (Math.abs((p[i_26_]).oz[0] - (p[i_26_]).oz[1]) > Math.abs((p[i_26_]).ox[0] - (p[i_26_]).ox[1])) {
                            if ((p[i_26_]).oz[0] > (p[i_26_]).oz[1]) {
                                if ((p[i_26_]).ox[1] > (p[i_26_]).ox[2])
                                    (p[i_26_]).fs = -1;
                                else
                                    (p[i_26_]).fs = 1;
                            } else if ((p[i_26_]).ox[1] > (p[i_26_]).ox[2])
                                (p[i_26_]).fs = 1;
                            else
                                (p[i_26_]).fs = -1;
                        } else if ((p[i_26_]).ox[0] > (p[i_26_]).ox[1]) {
                            if ((p[i_26_]).oz[1] > (p[i_26_]).oz[2])
                                (p[i_26_]).fs = 1;
                            else
                                (p[i_26_]).fs = -1;
                        } else if ((p[i_26_]).oz[1] > (p[i_26_]).oz[2])
                            (p[i_26_]).fs = -1;
                        else
                            (p[i_26_]).fs = 1;
                    }
                    if (i_27_ == 3) {
                        if (Math.abs((p[i_26_]).oy[0] - (p[i_26_]).oy[1]) > Math.abs((p[i_26_]).ox[0] - (p[i_26_]).ox[1])) {
                            if ((p[i_26_]).oy[0] > (p[i_26_]).oy[1]) {
                                if ((p[i_26_]).ox[1] > (p[i_26_]).ox[2])
                                    (p[i_26_]).fs = 1;
                                else
                                    (p[i_26_]).fs = -1;
                            } else if ((p[i_26_]).ox[1] > (p[i_26_]).ox[2])
                                (p[i_26_]).fs = -1;
                            else
                                (p[i_26_]).fs = 1;
                        } else if ((p[i_26_]).ox[0] > (p[i_26_]).ox[1]) {
                            if ((p[i_26_]).oy[1] > (p[i_26_]).oy[2])
                                (p[i_26_]).fs = -1;
                            else
                                (p[i_26_]).fs = 1;
                        } else if ((p[i_26_]).oy[1] > (p[i_26_]).oy[2])
                            (p[i_26_]).fs = 1;
                        else
                            (p[i_26_]).fs = -1;
                    }
                    boolean bool_52_ = false;
                    boolean bool_53_ = false;
                    for (int i_54_ = 0; i_54_ < npl; i_54_++) {
                        if (i_54_ != i_26_ && is_0_[i_54_] != 0) {
                            int i_56_ = (p[i_54_]).ox[0];
                            int i_57_ = (p[i_54_]).ox[0];
                            int i_58_ = (p[i_54_]).oy[0];
                            int i_59_ = (p[i_54_]).oy[0];
                            int i_60_ = (p[i_54_]).oz[0];
                            int i_61_ = (p[i_54_]).oz[0];
                            for (int i_62_ = 0; i_62_ < (p[i_54_]).n; i_62_++) {
                                if ((p[i_54_]).ox[i_62_] > i_56_)
                                    i_56_ = (p[i_54_]).ox[i_62_];
                                if ((p[i_54_]).ox[i_62_] < i_57_)
                                    i_57_ = (p[i_54_]).ox[i_62_];
                                if ((p[i_54_]).oy[i_62_] > i_58_)
                                    i_58_ = (p[i_54_]).oy[i_62_];
                                if ((p[i_54_]).oy[i_62_] < i_59_)
                                    i_59_ = (p[i_54_]).oy[i_62_];
                                if ((p[i_54_]).oz[i_62_] > i_60_)
                                    i_60_ = (p[i_54_]).oz[i_62_];
                                if ((p[i_54_]).oz[i_62_] < i_61_)
                                    i_61_ = (p[i_54_]).oz[i_62_];
                            }
                            int i_63_ = (i_56_ + i_57_) / 2;
                            int i_64_ = (i_58_ + i_59_) / 2;
                            int i_65_ = (i_60_ + i_61_) / 2;
                            int i_66_ = (i_28_ + i_29_) / 2;
                            int i_67_ = (i_30_ + i_31_) / 2;
                            int i_68_ = (i_32_ + i_33_) / 2;
                            if (i_27_ == 1 && (i_64_ <= i_30_ && i_64_ >= i_31_ && i_65_ <= i_32_ && i_65_ >= i_33_ || i_67_ <= i_58_ && i_67_ >= i_59_ && i_68_ <= i_60_ && i_68_ >= i_61_)) {
                                if (i_56_ < i_29_)
                                    bool_52_ = true;
                                if (i_57_ > i_28_)
                                    bool_53_ = true;
                            }
                            if (i_27_ == 2 && (i_63_ <= i_28_ && i_63_ >= i_29_ && i_65_ <= i_32_ && i_65_ >= i_33_ || i_66_ <= i_56_ && i_66_ >= i_57_ && i_68_ <= i_60_ && i_68_ >= i_61_)) {
                                if (i_58_ < i_31_)
                                    bool_52_ = true;
                                if (i_59_ > i_30_)
                                    bool_53_ = true;
                            }
                            if (i_27_ == 3 && (i_63_ <= i_28_ && i_63_ >= i_29_ && i_64_ <= i_30_ && i_64_ >= i_31_ || i_66_ <= i_56_ && i_66_ >= i_57_ && i_67_ <= i_58_ && i_67_ >= i_59_)) {
                                if (i_60_ < i_33_)
                                    bool_52_ = true;
                                if (i_61_ > i_32_)
                                    bool_53_ = true;
                            }
                        }
                        if (bool_52_ && bool_53_)
                            break;
                    }
                    boolean bool_69_ = false;
                    if (bool_52_ && !bool_53_)
                        bool_69_ = true;
                    if (bool_53_ && !bool_52_) {
                        (p[i_26_]).fs *= -1;
                        bool_69_ = true;
                    }
                    if (bool_52_ && bool_53_) {
                        (p[i_26_]).fs = 0;
                        (p[i_26_]).gr = 40;
                        bool_69_ = true;
                    }
                    if (!bool_69_) {
                        int i_70_ = 0;
                        int i_71_ = 0;
                        if (i_27_ == 1) {
                            i_70_ = (i_28_ + i_29_) / 2;
                            i_71_ = i_70_;
                        }
                        if (i_27_ == 2) {
                            i_70_ = (i_30_ + i_31_) / 2;
                            i_71_ = i_70_;
                        }
                        if (i_27_ == 3) {
                            i_70_ = (i_32_ + i_33_) / 2;
                            i_71_ = i_70_;
                        }
                        for (int i_72_ = 0; i_72_ < npl; i_72_++) {
                            if (i_72_ != i_26_) {
                                boolean bool_73_ = false;
                                boolean[] bools = new boolean[(p[i_72_]).n];
                                for (int i_74_ = 0; i_74_ < (p[i_72_]).n; i_74_++) {
                                    bools[i_74_] = false;
                                    for (int i_75_ = 0; i_75_ < (p[i_26_]).n; i_75_++) {
                                        if ((p[i_26_]).ox[i_75_] == (p[i_72_]).ox[i_74_] && (p[i_26_]).oy[i_75_] == (p[i_72_]).oy[i_74_] && (p[i_26_]).oz[i_75_] == (p[i_72_]).oz[i_74_]) {
                                            bools[i_74_] = true;
                                            bool_73_ = true;
                                        }
                                    }
                                }
                                if (bool_73_) {
                                    for (int i_76_ = 0; i_76_ < (p[i_72_]).n; i_76_++) {
                                        if (!bools[i_76_]) {
                                            if (i_27_ == 1) {
                                                if ((p[i_72_]).ox[i_76_] > i_70_)
                                                    i_70_ = (p[i_72_]).ox[i_76_];
                                                if ((p[i_72_]).ox[i_76_] < i_71_)
                                                    i_71_ = (p[i_72_]).ox[i_76_];
                                            }
                                            if (i_27_ == 2) {
                                                if ((p[i_72_]).oy[i_76_] > i_70_)
                                                    i_70_ = (p[i_72_]).oy[i_76_];
                                                if ((p[i_72_]).oy[i_76_] < i_71_)
                                                    i_71_ = (p[i_72_]).oy[i_76_];
                                            }
                                            if (i_27_ == 3) {
                                                if ((p[i_72_]).oz[i_76_] > i_70_)
                                                    i_70_ = (p[i_72_]).oz[i_76_];
                                                if ((p[i_72_]).oz[i_76_] < i_71_)
                                                    i_71_ = (p[i_72_]).oz[i_76_];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i_27_ == 1) {
                            if ((i_70_ + i_71_) / 2 > (i_28_ + i_29_) / 2)
                                (p[i_26_]).fs *= -1;
                            else if ((i_70_ + i_71_) / 2 == (i_28_ + i_29_) / 2 && (i_28_ + i_29_) / 2 < 0)
                                (p[i_26_]).fs *= -1;
                        }
                        if (i_27_ == 2) {
                            if ((i_70_ + i_71_) / 2 > (i_30_ + i_31_) / 2)
                                (p[i_26_]).fs *= -1;
                            else if ((i_70_ + i_71_) / 2 == (i_30_ + i_31_) / 2 && (i_30_ + i_31_) / 2 < 0)
                                (p[i_26_]).fs *= -1;
                        }
                        if (i_27_ == 3) {
                            if ((i_70_ + i_71_) / 2 > (i_32_ + i_33_) / 2)
                                (p[i_26_]).fs *= -1;
                            else if ((i_70_ + i_71_) / 2 == (i_32_ + i_33_) / 2 && (i_32_ + i_33_) / 2 < 0)
                                (p[i_26_]).fs *= -1;
                        }
                    }
                    p[i_26_].deltafntyp();
                }
            }
        }
    }
    
    public ContO(ContO conto_77_, int i, int i_78_, int i_79_, int i_80_) {
        keyx = new int[4];
        keyz = new int[4];
        sprkat = 0;
        tnt = 0;
        ust = 0;
        srx = 0;
        sry = 0;
        srz = 0;
        rcx = 0.0F;
        rcy = 0.0F;
        rcz = 0.0F;
        sprk = 0;
        elec = false;
        roted = false;
        edl = new int[4];
        edr = new int[4];
        elc = new int[] { 0, 0, 0, 0 };
        fix = false;
        fcnt = 0;
        checkpoint = 0;
        fcol = new int[] { 0, 0, 0 };
        scol = new int[] { 0, 0, 0 };
        colok = 0;
        errd = false;
        err = "";
        roofat = 0;
        wh = 0;
        m = (conto_77_).m;
        t = (conto_77_).t;
        npl = (conto_77_).npl;
        maxR = (conto_77_).maxR;
        disp = (conto_77_).disp;
        disline = (conto_77_).disline;
        noline = (conto_77_).noline;
        shadow = (conto_77_).shadow;
        grounded = (conto_77_).grounded;
        decor = (conto_77_).decor;
        if ((m).loadnew && (i_80_ == 90 || i_80_ == -90))
            grounded += 10000.0F;
        grat = (conto_77_).grat;
        sprkat = (conto_77_).sprkat;
        p = new Plane[(conto_77_).npl];
        for (int i_81_ = 0; i_81_ < npl; i_81_++) {
            if (((conto_77_).p[i_81_]).master == 1)
                ((conto_77_).p[i_81_]).n = 20;
            p[i_81_] = new Plane(m, t, ((conto_77_).p[i_81_]).ox, ((conto_77_).p[i_81_]).oz, ((conto_77_).p[i_81_]).oy, ((conto_77_).p[i_81_]).n, ((conto_77_).p[i_81_]).oc, ((conto_77_).p[i_81_]).glass, ((conto_77_).p[i_81_]).gr, ((conto_77_).p[i_81_]).fs, ((conto_77_).p[i_81_]).wx, ((conto_77_).p[i_81_]).wy, ((conto_77_).p[i_81_]).wz, (conto_77_).disline, ((conto_77_).p[i_81_]).bfase, ((conto_77_).p[i_81_]).road, ((conto_77_).p[i_81_]).light, ((conto_77_).p[i_81_]).solo);
        }
        x = i;
        y = i_78_;
        z = i_79_;
        xz = 0;
        xy = 0;
        zy = 0;
        for (int i_82_ = 0; i_82_ < npl; i_82_++) {
            (p[i_82_]).colnum = ((conto_77_).p[i_82_]).colnum;
            (p[i_82_]).master = ((conto_77_).p[i_82_]).master;
            p[i_82_].rot((p[i_82_]).ox, (p[i_82_]).oz, 0, 0, i_80_, (p[i_82_]).n);
            p[i_82_].loadprojf();
        }
        if ((conto_77_).tnt != 0) {
            for (int i_83_ = 0; i_83_ < (conto_77_).tnt; i_83_++) {
                (t).xy[(t).nt] = (int) ((float) (conto_77_).txy[i_83_] * m.cos(i_80_) - (float) (conto_77_).tzy[i_83_] * m.sin(i_80_));
                (t).zy[(t).nt] = (int) ((float) (conto_77_).tzy[i_83_] * m.cos(i_80_) + (float) (conto_77_).txy[i_83_] * m.sin(i_80_));
                for (int i_84_ = 0; i_84_ < 3; i_84_++) {
                    (t).c[(t).nt][i_84_] = (int) ((float) (conto_77_).tc[i_83_][i_84_] + (float) (conto_77_).tc[i_83_][i_84_] * ((float) (m).snap[i_84_] / 100.0F));
                    if ((t).c[(t).nt][i_84_] > 255)
                        (t).c[(t).nt][i_84_] = 255;
                    if ((t).c[(t).nt][i_84_] < 0)
                        (t).c[(t).nt][i_84_] = 0;
                }
                (t).x[(t).nt] = (int) ((float) x + (float) (conto_77_).tx[i_83_] * m.cos(i_80_) - (float) (conto_77_).tz[i_83_] * m.sin(i_80_));
                (t).z[(t).nt] = (int) ((float) z + (float) (conto_77_).tz[i_83_] * m.cos(i_80_) + (float) (conto_77_).tx[i_83_] * m.sin(i_80_));
                (t).y[(t).nt] = y + (conto_77_).ty[i_83_];
                (t).skd[(t).nt] = (conto_77_).skd[i_83_];
                (t).dam[(t).nt] = (conto_77_).dam[i_83_];
                (t).notwall[(t).nt] = (conto_77_).notwall[i_83_];
                if (decor)
                    (t).decor[(t).nt] = true;
                else
                    (t).decor[(t).nt] = false;
                int i_85_ = Math.abs(i_80_);
                if (i_85_ == 180)
                    i_85_ = 0;
                (t).radx[(t).nt] = (int) Math.abs((float) (conto_77_).tradx[i_83_] * m.cos(i_85_) + (float) (conto_77_).tradz[i_83_] * m.sin(i_85_));
                (t).radz[(t).nt] = (int) Math.abs((float) (conto_77_).tradx[i_83_] * m.sin(i_85_) + (float) (conto_77_).tradz[i_83_] * m.cos(i_85_));
                (t).rady[(t).nt] = (conto_77_).trady[i_83_];
                (t).nt++;
            }
        }
        for (int i_86_ = 0; i_86_ < 4; i_86_++) {
            keyx[i_86_] = (conto_77_).keyx[i_86_];
            keyz[i_86_] = (conto_77_).keyz[i_86_];
        }
        if (shadow) {
            stg = new int[20];
            sx = new int[20];
            sy = new int[20];
            sz = new int[20];
            scx = new int[20];
            scz = new int[20];
            osmag = new float[20];
            sav = new int[20];
            smag = new float[20][8];
            srgb = new int[20][3];
            sbln = new float[20];
            ust = 0;
            for (int i_87_ = 0; i_87_ < 20; i_87_++)
                stg[i_87_] = 0;
            rtg = new int[100];
            rbef = new boolean[100];
            rx = new int[100];
            ry = new int[100];
            rz = new int[100];
            vrx = new float[100];
            vry = new float[100];
            vrz = new float[100];
            for (int i_88_ = 0; i_88_ < 100; i_88_++)
                rtg[i_88_] = 0;
        }
    }
    
    public ContO(int i, int i_89_, int i_90_, Medium medium, Trackers trackers, int i_91_, int i_92_, int i_93_) {
        keyx = new int[4];
        keyz = new int[4];
        sprkat = 0;
        tnt = 0;
        ust = 0;
        srx = 0;
        sry = 0;
        srz = 0;
        rcx = 0.0F;
        rcy = 0.0F;
        rcz = 0.0F;
        sprk = 0;
        elec = false;
        roted = false;
        edl = new int[4];
        edr = new int[4];
        elc = new int[] { 0, 0, 0, 0 };
        fix = false;
        fcnt = 0;
        checkpoint = 0;
        fcol = new int[] { 0, 0, 0 };
        scol = new int[] { 0, 0, 0 };
        colok = 0;
        errd = false;
        err = "";
        roofat = 0;
        wh = 0;
        m = medium;
        t = trackers;
        x = i_91_;
        z = i_92_;
        y = i_93_;
        xz = 0;
        xy = 0;
        zy = 0;
        grat = 0;
        sprkat = 0;
        disline = 4;
        noline = true;
        shadow = false;
        grounded = 115.0F;
        decor = true;
        npl = 5;
        p = new Plane[5];
        Random random = new Random((long) i);
        int[] is = new int[8];
        int[] is_94_ = new int[8];
        int[] is_95_ = new int[8];
        int[] is_96_ = new int[8];
        int[] is_97_ = new int[8];
        if (i_90_ < 2)
            i_90_ = 2;
        if (i_90_ > 6)
            i_90_ = 6;
        if (i_89_ < 2)
            i_89_ = 2;
        if (i_89_ > 6)
            i_89_ = 6;
        i_90_ *= 1.0F + (float) (i_89_ - 2) * 0.1786F;
        float f = (float) (50.0 + 100.0 * random.nextDouble());
        is[0] = -(int) (f * (float) i_89_ * 0.7071F);
        is_94_[0] = (int) (f * (float) i_89_ * 0.7071F);
        f = (float) (50.0 + 100.0 * random.nextDouble());
        is[1] = 0;
        is_94_[1] = (int) (f * (float) i_89_);
        f = (float) (50.0 + 100.0 * random.nextDouble());
        is[2] = (int) ((double) (f * (float) i_89_) * 0.7071);
        is_94_[2] = (int) ((double) (f * (float) i_89_) * 0.7071);
        f = (float) (50.0 + 100.0 * random.nextDouble());
        is[3] = (int) (f * (float) i_89_);
        is_94_[3] = 0;
        f = (float) (50.0 + 100.0 * random.nextDouble());
        is[4] = (int) ((double) (f * (float) i_89_) * 0.7071);
        is_94_[4] = -(int) ((double) (f * (float) i_89_) * 0.7071);
        f = (float) (50.0 + 100.0 * random.nextDouble());
        is[5] = 0;
        is_94_[5] = -(int) (f * (float) i_89_);
        f = (float) (50.0 + 100.0 * random.nextDouble());
        is[6] = -(int) ((double) (f * (float) i_89_) * 0.7071);
        is_94_[6] = -(int) ((double) (f * (float) i_89_) * 0.7071);
        f = (float) (50.0 + 100.0 * random.nextDouble());
        is[7] = -(int) (f * (float) i_89_);
        is_94_[7] = 0;
        for (int i_98_ = 0; i_98_ < 8; i_98_++) {
            is_95_[i_98_] = (int) ((double) is[i_98_] * (0.2 + 0.4 * random.nextDouble()));
            is_96_[i_98_] = (int) ((double) is_94_[i_98_] * (0.2 + 0.4 * random.nextDouble()));
            is_97_[i_98_] = -(int) ((10.0 + 15.0 * random.nextDouble()) * (double) i_90_);
        }
        maxR = 0;
        for (int i_99_ = 0; i_99_ < 8; i_99_++) {
            int i_100_ = i_99_ - 1;
            if (i_100_ == -1)
                i_100_ = 7;
            int i_101_ = i_99_ + 1;
            if (i_101_ == 8)
                i_101_ = 0;
            is[i_99_] = ((is[i_100_] + is[i_101_]) / 2 + is[i_99_]) / 2;
            is_94_[i_99_] = ((is_94_[i_100_] + is_94_[i_101_]) / 2 + is_94_[i_99_]) / 2;
            is_95_[i_99_] = ((is_95_[i_100_] + is_95_[i_101_]) / 2 + is_95_[i_99_]) / 2;
            is_96_[i_99_] = ((is_96_[i_100_] + is_96_[i_101_]) / 2 + is_96_[i_99_]) / 2;
            is_97_[i_99_] = ((is_97_[i_100_] + is_97_[i_101_]) / 2 + is_97_[i_99_]) / 2;
            int i_102_ = (int) Math.sqrt((double) (is[i_99_] * is[i_99_] + is_94_[i_99_] * is_94_[i_99_]));
            if (i_102_ > maxR)
                maxR = i_102_;
            i_102_ = (int) Math.sqrt((double) (is_95_[i_99_] * is_95_[i_99_] + is_97_[i_99_] * is_97_[i_99_] + is_96_[i_99_] * is_96_[i_99_]));
            if (i_102_ > maxR)
                maxR = i_102_;
        }
        disp = maxR / 17;
        int[] is_103_ = new int[3];
        float f_104_ = -1.0F;
        float f_105_ = ((float) i_89_ / (float) i_90_ - 0.33F) / 33.4F;
        if ((double) f_105_ < 0.005)
            f_105_ = 0.0F;
        if ((double) f_105_ > 0.057)
            f_105_ = 0.057F;
        for (int i_106_ = 0; i_106_ < 4; i_106_++) {
            int i_107_ = i_106_ * 2;
            int i_108_ = i_107_ + 2;
            if (i_108_ == 8)
                i_108_ = 0;
            int[] is_109_ = new int[6];
            int[] is_110_ = new int[6];
            int[] is_111_ = new int[6];
            is_109_[0] = is[i_107_];
            is_109_[1] = is[i_107_ + 1];
            is_109_[2] = is[i_108_];
            is_109_[5] = is_95_[i_107_];
            is_109_[4] = is_95_[i_107_ + 1];
            is_109_[3] = is_95_[i_108_];
            is_111_[0] = is_94_[i_107_];
            is_111_[1] = is_94_[i_107_ + 1];
            is_111_[2] = is_94_[i_108_];
            is_111_[5] = is_96_[i_107_];
            is_111_[4] = is_96_[i_107_ + 1];
            is_111_[3] = is_96_[i_108_];
            is_110_[0] = 0;
            is_110_[1] = 0;
            is_110_[2] = 0;
            is_110_[5] = is_97_[i_107_];
            is_110_[4] = is_97_[i_107_ + 1];
            is_110_[3] = is_97_[i_108_];
            for (f = (float) ((0.17 - (double) f_105_) * random.nextDouble()); (double) Math.abs(f_104_ - f) < 0.03 - (double) (f_105_ * 0.176F); f = (float) ((0.17 - (double) f_105_) * random.nextDouble())) {
                /* empty */
            }
            f_104_ = f;
            for (int i_112_ = 0; i_112_ < 3; i_112_++) {
                if ((m).trk == 2)
                    is_103_[i_112_] = (int) (390.0F / (2.2F + f - f_105_));
                else
                    is_103_[i_112_] = (int) ((float) ((m).cpol[i_112_] + (m).cgrnd[i_112_]) / (2.2F + f - f_105_));
            }
            p[i_106_] = new Plane(m, t, is_109_, is_111_, is_110_, 6, is_103_, 3, -8, 0, 0, 0, 0, disline, 0, true, 0, false);
        }
        f = (float) (0.02 * random.nextDouble());
        for (int i_113_ = 0; i_113_ < 3; i_113_++) {
            if ((m).trk == 2)
                is_103_[i_113_] = (int) (390.0F / (2.15F + f));
            else
                is_103_[i_113_] = (int) ((float) ((m).cpol[i_113_] + (m).cgrnd[i_113_]) / (2.15F + f));
        }
        p[4] = new Plane(m, t, is_95_, is_96_, is_97_, 8, is_103_, 3, -8, 0, 0, 0, 0, disline, 0, true, 0, false);
        int[] is_114_ = new int[2];
        int[] is_115_ = new int[2];
        for (int i_116_ = 0; i_116_ < 4; i_116_++) {
            int i_117_ = i_116_ * 2 + 1;
            (t).y[(t).nt] = is_97_[i_117_] / 2;
            (t).rady[(t).nt] = Math.abs(is_97_[i_117_] / 2);
            if (i_116_ == 0 || i_116_ == 2) {
                (t).z[(t).nt] = (is_94_[i_117_] + is_96_[i_117_]) / 2;
                (t).radz[(t).nt] = Math.abs((t).z[(t).nt] - is_94_[i_117_]);
                i_117_ = i_116_ * 2 + 2;
                if (i_117_ == 8)
                    i_117_ = 0;
                (t).x[(t).nt] = (is[i_116_ * 2] + is[i_117_]) / 2;
                (t).radx[(t).nt] = Math.abs((t).x[(t).nt] - is[i_116_ * 2]);
            } else {
                (t).x[(t).nt] = (is[i_117_] + is_95_[i_117_]) / 2;
                (t).radx[(t).nt] = Math.abs((t).x[(t).nt] - is[i_117_]);
                i_117_ = i_116_ * 2 + 2;
                if (i_117_ == 8)
                    i_117_ = 0;
                (t).z[(t).nt] = (is_94_[i_116_ * 2] + is_94_[i_117_]) / 2;
                (t).radz[(t).nt] = Math.abs((t).z[(t).nt] - is_94_[i_116_ * 2]);
            }
            if (i_116_ == 0) {
                is_115_[0] = (t).z[(t).nt] - (t).radz[(t).nt];
                (t).zy[(t).nt] = (int) (Math.atan((double) (t).rady[(t).nt] / (double) (t).radz[(t).nt]) / 0.017453292519943295);
                if ((t).zy[(t).nt] > 40)
                    (t).zy[(t).nt] = 40;
                (t).xy[(t).nt] = 0;
            }
            if (i_116_ == 1) {
                is_114_[0] = (t).x[(t).nt] - (t).radx[(t).nt];
                (t).xy[(t).nt] = (int) (Math.atan((double) (t).rady[(t).nt] / (double) (t).radx[(t).nt]) / 0.017453292519943295);
                if ((t).xy[(t).nt] > 40)
                    (t).xy[(t).nt] = 40;
                (t).zy[(t).nt] = 0;
            }
            if (i_116_ == 2) {
                is_115_[1] = (t).z[(t).nt] + (t).radz[(t).nt];
                (t).zy[(t).nt] = -(int) (Math.atan((double) (t).rady[(t).nt] / (double) (t).radz[(t).nt]) / 0.017453292519943295);
                if ((t).zy[(t).nt] < -40)
                    (t).zy[(t).nt] = -40;
                (t).xy[(t).nt] = 0;
            }
            if (i_116_ == 3) {
                is_114_[1] = (t).x[(t).nt] + (t).radx[(t).nt];
                (t).xy[(t).nt] = -(int) (Math.atan((double) (t).rady[(t).nt] / (double) (t).radx[(t).nt]) / 0.017453292519943295);
                if ((t).xy[(t).nt] < -40)
                    (t).xy[(t).nt] = -40;
                (t).zy[(t).nt] = 0;
            }
            (t).x[(t).nt] += x;
            (t).z[(t).nt] += z;
            (t).y[(t).nt] += y;
            for (int i_118_ = 0; i_118_ < 3; i_118_++)
                (t).c[(t).nt][i_118_] = (p[i_116_]).oc[i_118_];
            (t).skd[(t).nt] = 2;
            (t).dam[(t).nt] = 1;
            (t).notwall[(t).nt] = false;
            (t).decor[(t).nt] = true;
            (t).rady[(t).nt] += 10;
            (t).nt++;
        }
        (t).y[(t).nt] = 0;
        for (int i_119_ = 0; i_119_ < 8; i_119_++)
            (t).y[(t).nt] += is_97_[i_119_];
        (t).y[(t).nt] = (t).y[(t).nt] / 8;
        (t).y[(t).nt] += y;
        (t).rady[(t).nt] = 200;
        (t).radx[(t).nt] = is_114_[0] - is_114_[1];
        (t).radz[(t).nt] = is_115_[0] - is_115_[1];
        (t).x[(t).nt] = (is_114_[0] + is_114_[1]) / 2 + x;
        (t).z[(t).nt] = (is_115_[0] + is_115_[1]) / 2 + z;
        (t).zy[(t).nt] = 0;
        (t).xy[(t).nt] = 0;
        for (int i_120_ = 0; i_120_ < 3; i_120_++)
            (t).c[(t).nt][i_120_] = (p[4]).oc[i_120_];
        (t).skd[(t).nt] = 4;
        (t).dam[(t).nt] = 1;
        (t).notwall[(t).nt] = false;
        (t).decor[(t).nt] = true;
        (t).nt++;
    }
    
    public void d(Graphics2D graphics2d) {
        if (dist != 0)
            dist = 0;
        int i = (m).cx + (int) ((float) (x - (m).x - (m).cx) * m.cos((m).xz) - (float) (z - (m).z - (m).cz) * m.sin((m).xz));
        int i_121_ = (m).cz + (int) ((float) (x - (m).x - (m).cx) * m.sin((m).xz) + (float) (z - (m).z - (m).cz) * m.cos((m).xz));
        int i_122_ = (m).cz + (int) ((float) (y - (m).y - (m).cy) * m.sin((m).zy) + (float) (i_121_ - (m).cz) * m.cos((m).zy));
        int i_123_ = xs(i + maxR, i_122_) - xs(i - maxR, i_122_);
        if (xs(i + maxR * 2, i_122_) > (m).iw && xs(i - maxR * 2, i_122_) < (m).w && i_122_ > -maxR && (i_122_ < (m).fade[disline] + maxR || (m).trk != 0) && (i_123_ > disp || (m).trk != 0) && (!decor || (m).resdown != 2 && (m).trk != 1)) {
            if (shadow) {
                if (!(m).crs) {
                    if (i_122_ < 2000) {
                        boolean bool = false;
                        if ((t).ncx != 0 || (t).ncz != 0) {
                            int i_124_ = (x - (t).sx) / 3000;
                            if (i_124_ > (t).ncx)
                                i_124_ = (t).ncx;
                            if (i_124_ < 0)
                                i_124_ = 0;
                            int i_125_ = (z - (t).sz) / 3000;
                            if (i_125_ > (t).ncz)
                                i_125_ = (t).ncz;
                            if (i_125_ < 0)
                                i_125_ = 0;
                            for (int i_126_ = (t).sect[i_124_][i_125_].length - 1; i_126_ >= 0; i_126_--) {
                                int i_127_ = (t).sect[i_124_][i_125_][i_126_];
                                if (Math.abs((t).zy[i_127_]) != 90 && Math.abs((t).xy[i_127_]) != 90 && Math.abs(x - (t).x[i_127_]) < (t).radx[i_127_] + maxR && Math.abs(z - (t).z[i_127_]) < (t).radz[i_127_] + maxR && (!(t).decor[i_127_] || (m).resdown != 2)) {
                                    bool = true;
                                    break;
                                }
                            }
                        }
                        if (bool) {
                            for (int i_128_ = 0; i_128_ < npl; i_128_++)
                                p[i_128_].s(graphics2d, x - (m).x, y - (m).y, z - (m).z, xz, xy, zy, 0);
                        } else {
                            int i_129_ = (m).cy + (int) ((float) ((m).ground - (m).cy) * m.cos((m).zy) - (float) (i_121_ - (m).cz) * m.sin((m).zy));
                            int i_130_ = (m).cz + (int) ((float) ((m).ground - (m).cy) * m.sin((m).zy) + (float) (i_121_ - (m).cz) * m.cos((m).zy));
                            if (ys(i_129_ + maxR, i_130_) > 0 && ys(i_129_ - maxR, i_130_) < (m).h) {
                                for (int i_131_ = 0; i_131_ < npl; i_131_++)
                                    p[i_131_].s(graphics2d, x - (m).x, y - (m).y, z - (m).z, xz, xy, zy, 1);
                            }
                        }
                        m.addsp(x - (m).x, z - (m).z, (int) ((double) maxR * 0.8));
                    } else
                        lowshadow(graphics2d, i_122_);
                } else {
                    for (int i_132_ = 0; i_132_ < npl; i_132_++)
                        p[i_132_].s(graphics2d, x - (m).x, y - (m).y, z - (m).z, xz, xy, zy, 2);
                }
            }
            int i_133_ = (m).cy + (int) ((float) (y - (m).y - (m).cy) * m.cos((m).zy) - (float) (i_121_ - (m).cz) * m.sin((m).zy));
            if (ys(i_133_ + maxR, i_122_) > (m).ih && ys(i_133_ - maxR, i_122_) < (m).h) {
                if (elec && (m).noelec == 0)
                    electrify(graphics2d);
                if (fix)
                    fixit(graphics2d);
                if (checkpoint != 0 && checkpoint - 1 == (m).checkpoint)
                    i_123_ = -1;
                if (shadow) {
                    dist = (int) Math.sqrt((double) (((m).x + (m).cx - x) * ((m).x + (m).cx - x) + ((m).z - z) * ((m).z - z) + ((m).y + (m).cy - y) * ((m).y + (m).cy - y)));
                    for (int i_134_ = 0; i_134_ < 20; i_134_++) {
                        if (stg[i_134_] != 0)
                            pdust(i_134_, graphics2d, true);
                    }
                    dsprk(graphics2d, true);
                }
                int[] is = new int[npl];
                int[] is_135_ = new int[npl];
                for (int i_136_ = 0; i_136_ < npl; i_136_++)
                    is[i_136_] = 0;
                for (int i_137_ = 0; i_137_ < npl; i_137_++) {
                    for (int i_138_ = i_137_ + 1; i_138_ < npl; i_138_++) {
                        if ((p[i_137_]).av != (p[i_138_]).av) {
                            if ((p[i_137_]).av < (p[i_138_]).av)
                                is[i_137_]++;
                            else
                                is[i_138_]++;
                        } else if (i_137_ > i_138_)
                            is[i_137_]++;
                        else
                            is[i_138_]++;
                    }
                    is_135_[is[i_137_]] = i_137_;
                }
                for (int i_139_ = 0; i_139_ < npl; i_139_++)
                    p[is_135_[i_139_]].d(graphics2d, x - (m).x, y - (m).y, z - (m).z, xz, xy, zy, wxz, wzy, noline, i_123_);
                if (shadow) {
                    for (int i_140_ = 0; i_140_ < 20; i_140_++) {
                        if (stg[i_140_] != 0)
                            pdust(i_140_, graphics2d, false);
                    }
                    dsprk(graphics2d, false);
                }
                dist = (int) (Math.sqrt((double) (int) Math.sqrt((double) (((m).x + (m).cx - x) * ((m).x + (m).cx - x) + ((m).z - z) * ((m).z - z) + ((m).y + (m).cy - y) * ((m).y + (m).cy - y)))) * (double) grounded);
            }
        }
        if (shadow && dist == 0) {
            for (int i_141_ = 0; i_141_ < 20; i_141_++) {
                if (stg[i_141_] != 0)
                    stg[i_141_] = 0;
            }
            for (int i_142_ = 0; i_142_ < 100; i_142_++) {
                if (rtg[i_142_] != 0)
                    rtg[i_142_] = 0;
            }
            if (sprk != 0)
                sprk = 0;
        }
    }
    
    public void lowshadow(Graphics2D graphics2d, int i) {
        int[] is = new int[4];
        int[] is_143_ = new int[4];
        int[] is_144_ = new int[4];
        int i_145_ = 1;
        int i_146_;
        for (i_146_ = Math.abs(zy); i_146_ > 270; i_146_ -= 360) {
            /* empty */
        }
        i_146_ = Math.abs(i_146_);
        if (i_146_ > 90)
            i_145_ = -1;
        is[0] = (int) ((double) keyx[0] * 1.2 + (double) x - (double) (m).x);
        is_144_[0] = (int) ((double) ((keyz[0] + 30) * i_145_) * 1.2 + (double) z - (double) (m).z);
        is[1] = (int) ((double) keyx[1] * 1.2 + (double) x - (double) (m).x);
        is_144_[1] = (int) ((double) ((keyz[1] + 30) * i_145_) * 1.2 + (double) z - (double) (m).z);
        is[2] = (int) ((double) keyx[3] * 1.2 + (double) x - (double) (m).x);
        is_144_[2] = (int) ((double) ((keyz[3] - 30) * i_145_) * 1.2 + (double) z - (double) (m).z);
        is[3] = (int) ((double) keyx[2] * 1.2 + (double) x - (double) (m).x);
        is_144_[3] = (int) ((double) ((keyz[2] - 30) * i_145_) * 1.2 + (double) z - (double) (m).z);
        rot(is, is_144_, x - (m).x, z - (m).z, xz, 4);
        int i_147_ = (int) ((double) (float) (m).crgrnd[0] / 1.5);
        int i_148_ = (int) ((double) (float) (m).crgrnd[1] / 1.5);
        int i_149_ = (int) ((double) (float) (m).crgrnd[2] / 1.5);
        for (int i_150_ = 0; i_150_ < 4; i_150_++)
            is_143_[i_150_] = (m).ground;
        if ((t).ncx != 0 || (t).ncz != 0) {
            int i_151_ = (x - (t).sx) / 3000;
            if (i_151_ > (t).ncx)
                i_151_ = (t).ncx;
            if (i_151_ < 0)
                i_151_ = 0;
            int i_152_ = (z - (t).sz) / 3000;
            if (i_152_ > (t).ncz)
                i_152_ = (t).ncz;
            if (i_152_ < 0)
                i_152_ = 0;
            for (int i_153_ = (t).sect[i_151_][i_152_].length - 1; i_153_ >= 0; i_153_--) {
                int i_154_ = (t).sect[i_151_][i_152_][i_153_];
                int i_155_ = 0;
                for (int i_156_ = 0; i_156_ < 4; i_156_++) {
                    if (Math.abs((t).zy[i_154_]) != 90 && Math.abs((t).xy[i_154_]) != 90 && (t).rady[i_154_] != 801 && Math.abs(is[i_156_] - ((t).x[i_154_] - (m).x)) < (t).radx[i_154_] && Math.abs(is_144_[i_156_] - ((t).z[i_154_] - (m).z)) < (t).radz[i_154_] && (!(t).decor[i_154_] || (m).resdown != 2))
                        i_155_++;
                }
                if (i_155_ > 2) {
                    for (int i_157_ = 0; i_157_ < 4; i_157_++) {
                        is_143_[i_157_] = (t).y[i_154_] - (m).y;
                        if ((t).zy[i_154_] != 0)
                            is_143_[i_157_] += (float) (is_144_[i_157_] - ((t).z[i_154_] - (m).z - (t).radz[i_154_])) * m.sin((t).zy[i_154_]) / m.sin(90 - (t).zy[i_154_]) - (float) (t).radz[i_154_] * m.sin((t).zy[i_154_]) / m.sin(90 - (t).zy[i_154_]);
                        if ((t).xy[i_154_] != 0)
                            is_143_[i_157_] += (float) (is[i_157_] - ((t).x[i_154_] - (m).x - (t).radx[i_154_])) * m.sin((t).xy[i_154_]) / m.sin(90 - (t).xy[i_154_]) - (float) (t).radx[i_154_] * m.sin((t).xy[i_154_]) / m.sin(90 - (t).xy[i_154_]);
                    }
                    i_147_ = (int) ((double) (float) (t).c[i_154_][0] / 1.5);
                    i_148_ = (int) ((double) (float) (t).c[i_154_][1] / 1.5);
                    i_149_ = (int) ((double) (float) (t).c[i_154_][2] / 1.5);
                    break;
                }
            }
        }
        rot(is, is_144_, (m).cx, (m).cz, (m).xz, 4);
        rot(is_143_, is_144_, (m).cy, (m).cz, (m).zy, 4);
        boolean bool = true;
        int i_158_ = 0;
        int i_159_ = 0;
        int i_160_ = 0;
        int i_161_ = 0;
        for (int i_162_ = 0; i_162_ < 4; i_162_++) {
            is[i_162_] = xs(is[i_162_], is_144_[i_162_]);
            is_143_[i_162_] = ys(is_143_[i_162_], is_144_[i_162_]);
            if (is_143_[i_162_] < (m).ih || is_144_[i_162_] < 10)
                i_158_++;
            if (is_143_[i_162_] > (m).h || is_144_[i_162_] < 10)
                i_159_++;
            if (is[i_162_] < (m).iw || is_144_[i_162_] < 10)
                i_160_++;
            if (is[i_162_] > (m).w || is_144_[i_162_] < 10)
                i_161_++;
        }
        if (i_160_ == 4 || i_158_ == 4 || i_159_ == 4 || i_161_ == 4)
            bool = false;
        if (bool) {
            for (int i_163_ = 0; i_163_ < 16; i_163_++) {
                if (i > (m).fade[i_163_]) {
                    i_147_ = (i_147_ * (m).fogd + (m).cfade[0]) / ((m).fogd + 1);
                    i_148_ = (i_148_ * (m).fogd + (m).cfade[1]) / ((m).fogd + 1);
                    i_149_ = (i_149_ * (m).fogd + (m).cfade[2]) / ((m).fogd + 1);
                }
            }
            graphics2d.setColor(new Color(i_147_, i_148_, i_149_));
            graphics2d.fillPolygon(is, is_143_, 4);
        }
    }
    
    public void fixit(Graphics2D graphics2d) {
        if (fcnt == 1) {
            for (int i = 0; i < npl; i++) {
                (p[i]).hsb[0] = 0.57F;
                (p[i]).hsb[2] = 0.8F;
                (p[i]).hsb[1] = 0.8F;
                Color color = Color.getHSBColor((p[i]).hsb[0], (p[i]).hsb[1], (p[i]).hsb[2]);
                int i_164_ = (int) ((float) color.getRed() + (float) color.getRed() * ((float) (m).snap[0] / 100.0F));
                if (i_164_ > 255)
                    i_164_ = 255;
                if (i_164_ < 0)
                    i_164_ = 0;
                int i_165_ = (int) ((float) color.getGreen() + (float) color.getGreen() * ((float) (m).snap[1] / 100.0F));
                if (i_165_ > 255)
                    i_165_ = 255;
                if (i_165_ < 0)
                    i_165_ = 0;
                int i_166_ = (int) ((float) color.getBlue() + (float) color.getBlue() * ((float) (m).snap[2] / 100.0F));
                if (i_166_ > 255)
                    i_166_ = 255;
                if (i_166_ < 0)
                    i_166_ = 0;
                Color.RGBtoHSB(i_164_, i_165_, i_166_, (p[i]).hsb);
                (p[i]).flx = 1;
            }
        }
        if (fcnt == 2) {
            for (int i = 0; i < npl; i++)
                (p[i]).flx = 1;
        }
        if (fcnt == 4) {
            for (int i = 0; i < npl; i++)
                (p[i]).flx = 3;
        }
        if ((fcnt == 1 || fcnt > 2) && fcnt != 9) {
            int[] is = new int[8];
            int[] is_167_ = new int[8];
            int[] is_168_ = new int[4];
            for (int i = 0; i < 4; i++) {
                is[i] = keyx[i] + x - (m).x;
                is_167_[i] = grat + y - (m).y;
                is_168_[i] = keyz[i] + z - (m).z;
            }
            rot(is, is_167_, x - (m).x, y - (m).y, xy, 4);
            rot(is_167_, is_168_, y - (m).y, z - (m).y, zy, 4);
            rot(is, is_168_, x - (m).x, z - (m).z, xz, 4);
            rot(is, is_168_, (m).cx, (m).cz, (m).xz, 4);
            rot(is_167_, is_168_, (m).cy, (m).cz, (m).zy, 4);
            int i = 0;
            int i_169_ = 0;
            int i_170_ = 0;
            for (int i_171_ = 0; i_171_ < 4; i_171_++) {
                for (int i_172_ = 0; i_172_ < 4; i_172_++) {
                    if (Math.abs(is[i_171_] - is[i_172_]) > i)
                        i = Math.abs(is[i_171_] - is[i_172_]);
                    if (Math.abs(is_167_[i_171_] - is_167_[i_172_]) > i_169_)
                        i_169_ = Math.abs(is_167_[i_171_] - is_167_[i_172_]);
                    if (py(is[i_171_], is[i_172_], is_167_[i_171_], is_167_[i_172_]) > i_170_)
                        i_170_ = py(is[i_171_], is[i_172_], is_167_[i_171_], is_167_[i_172_]);
                }
            }
            i_170_ = (int) (Math.sqrt((double) i_170_) / 1.5);
            if (i < i_170_)
                i = i_170_;
            if (i_169_ < i_170_)
                i_169_ = i_170_;
            int i_173_ = (m).cx + (int) ((float) (x - (m).x - (m).cx) * m.cos((m).xz) - (float) (z - (m).z - (m).cz) * m.sin((m).xz));
            int i_174_ = (m).cz + (int) ((float) (x - (m).x - (m).cx) * m.sin((m).xz) + (float) (z - (m).z - (m).cz) * m.cos((m).xz));
            int i_175_ = (m).cy + (int) ((float) (y - (m).y - (m).cy) * m.cos((m).zy) - (float) (i_174_ - (m).cz) * m.sin((m).zy));
            i_174_ = (m).cz + (int) ((float) (y - (m).y - (m).cy) * m.sin((m).zy) + (float) (i_174_ - (m).cz) * m.cos((m).zy));
            is[0] = xs((int) ((double) i_173_ - (double) i / 0.8 - (double) m.random() * ((double) i / 2.4)), i_174_);
            is_167_[0] = ys((int) ((double) i_175_ - (double) i_169_ / 1.92 - (double) m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[1] = xs((int) ((double) i_173_ - (double) i / 0.8 - (double) m.random() * ((double) i / 2.4)), i_174_);
            is_167_[1] = ys((int) ((double) i_175_ + (double) i_169_ / 1.92 + (double) m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[2] = xs((int) ((double) i_173_ - (double) i / 1.92 - (double) m.random() * ((double) i / 5.67)), i_174_);
            is_167_[2] = ys((int) ((double) i_175_ + (double) i_169_ / 0.8 + (double) m.random() * ((double) i_169_ / 2.4)), i_174_);
            is[3] = xs((int) ((double) i_173_ + (double) i / 1.92 + (double) m.random() * ((double) i / 5.67)), i_174_);
            is_167_[3] = ys((int) ((double) i_175_ + (double) i_169_ / 0.8 + (double) m.random() * ((double) i_169_ / 2.4)), i_174_);
            is[4] = xs((int) ((double) i_173_ + (double) i / 0.8 + (double) m.random() * ((double) i / 2.4)), i_174_);
            is_167_[4] = ys((int) ((double) i_175_ + (double) i_169_ / 1.92 + (double) m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[5] = xs((int) ((double) i_173_ + (double) i / 0.8 + (double) m.random() * ((double) i / 2.4)), i_174_);
            is_167_[5] = ys((int) ((double) i_175_ - (double) i_169_ / 1.92 - (double) m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[6] = xs((int) ((double) i_173_ + (double) i / 1.92 + (double) m.random() * ((double) i / 5.67)), i_174_);
            is_167_[6] = ys((int) ((double) i_175_ - (double) i_169_ / 0.8 - (double) m.random() * ((double) i_169_ / 2.4)), i_174_);
            is[7] = xs((int) ((double) i_173_ - (double) i / 1.92 - (double) m.random() * ((double) i / 5.67)), i_174_);
            is_167_[7] = ys((int) ((double) i_175_ - (double) i_169_ / 0.8 - (double) m.random() * ((double) i_169_ / 2.4)), i_174_);
            if (fcnt == 3)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), 22, 8);
            if (fcnt == 4)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), 22, 8);
            if (fcnt == 5)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), 0, 8);
            if (fcnt == 6)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), -22, 8);
            if (fcnt == 7)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), -22, 8);
            int i_176_ = (int) (191.0F + 191.0F * ((float) (m).snap[0] / 350.0F));
            if (i_176_ > 255)
                i_176_ = 255;
            if (i_176_ < 0)
                i_176_ = 0;
            int i_177_ = (int) (232.0F + 232.0F * ((float) (m).snap[1] / 350.0F));
            if (i_177_ > 255)
                i_177_ = 255;
            if (i_177_ < 0)
                i_177_ = 0;
            int i_178_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 350.0F));
            if (i_178_ > 255)
                i_178_ = 255;
            if (i_178_ < 0)
                i_178_ = 0;
            graphics2d.setColor(new Color(i_176_, i_177_, i_178_));
            graphics2d.fillPolygon(is, is_167_, 8);
            is[0] = xs((int) ((float) (i_173_ - i) - m.random() * (float) (i / 4)), i_174_);
            is_167_[0] = ys((int) ((double) i_175_ - (double) i_169_ / 2.4 - (double) m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[1] = xs((int) ((float) (i_173_ - i) - m.random() * (float) (i / 4)), i_174_);
            is_167_[1] = ys((int) ((double) i_175_ + (double) i_169_ / 2.4 + (double) m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[2] = xs((int) ((double) i_173_ - (double) i / 2.4 - (double) m.random() * ((double) i / 9.6)), i_174_);
            is_167_[2] = ys((int) ((float) (i_175_ + i_169_) + m.random() * (float) (i_169_ / 4)), i_174_);
            is[3] = xs((int) ((double) i_173_ + (double) i / 2.4 + (double) m.random() * ((double) i / 9.6)), i_174_);
            is_167_[3] = ys((int) ((float) (i_175_ + i_169_) + m.random() * (float) (i_169_ / 4)), i_174_);
            is[4] = xs((int) ((float) (i_173_ + i) + m.random() * (float) (i / 4)), i_174_);
            is_167_[4] = ys((int) ((double) i_175_ + (double) i_169_ / 2.4 + (double) m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[5] = xs((int) ((float) (i_173_ + i) + m.random() * (float) (i / 4)), i_174_);
            is_167_[5] = ys((int) ((double) i_175_ - (double) i_169_ / 2.4 - (double) m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[6] = xs((int) ((double) i_173_ + (double) i / 2.4 + (double) m.random() * ((double) i / 9.6)), i_174_);
            is_167_[6] = ys((int) ((float) (i_175_ - i_169_) - m.random() * (float) (i_169_ / 4)), i_174_);
            is[7] = xs((int) ((double) i_173_ - (double) i / 2.4 - (double) m.random() * ((double) i / 9.6)), i_174_);
            is_167_[7] = ys((int) ((float) (i_175_ - i_169_) - m.random() * (float) (i_169_ / 4)), i_174_);
            i_176_ = (int) (213.0F + 213.0F * ((float) (m).snap[0] / 350.0F));
            if (i_176_ > 255)
                i_176_ = 255;
            if (i_176_ < 0)
                i_176_ = 0;
            i_177_ = (int) (239.0F + 239.0F * ((float) (m).snap[1] / 350.0F));
            if (i_177_ > 255)
                i_177_ = 255;
            if (i_177_ < 0)
                i_177_ = 0;
            i_178_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 350.0F));
            if (i_178_ > 255)
                i_178_ = 255;
            if (i_178_ < 0)
                i_178_ = 0;
            graphics2d.setColor(new Color(i_176_, i_177_, i_178_));
            graphics2d.fillPolygon(is, is_167_, 8);
        }
        if (fcnt > 7) {
            fcnt = 0;
            fix = false;
        } else
            fcnt++;
    }
    
    public void electrify(Graphics2D graphics2d) {
        for (int i = 0; i < 4; i++) {
            if (elc[i] == 0) {
                edl[i] = (int) (380.0F - m.random() * 760.0F);
                edr[i] = (int) (380.0F - m.random() * 760.0F);
                elc[i] = 1;
            }
            int i_179_ = (int) ((float) edl[i] + (190.0F - m.random() * 380.0F));
            int i_180_ = (int) ((float) edr[i] + (190.0F - m.random() * 380.0F));
            int i_181_ = (int) (m.random() * 126.0F);
            int i_182_ = (int) (m.random() * 126.0F);
            int[] is = new int[8];
            int[] is_183_ = new int[8];
            int[] is_184_ = new int[8];
            for (int i_185_ = 0; i_185_ < 8; i_185_++)
                is_184_[i_185_] = z - (m).z;
            is[0] = x - (m).x - 504;
            is_183_[0] = y - (m).y - edl[i] - 5 - (int) (m.random() * 5.0F);
            is[1] = x - (m).x - 252 + i_182_;
            is_183_[1] = y - (m).y - i_179_ - 5 - (int) (m.random() * 5.0F);
            is[2] = x - (m).x + 252 - i_181_;
            is_183_[2] = y - (m).y - i_180_ - 5 - (int) (m.random() * 5.0F);
            is[3] = x - (m).x + 504;
            is_183_[3] = y - (m).y - edr[i] - 5 - (int) (m.random() * 5.0F);
            is[4] = x - (m).x + 504;
            is_183_[4] = y - (m).y - edr[i] + 5 + (int) (m.random() * 5.0F);
            is[5] = x - (m).x + 252 - i_181_;
            is_183_[5] = y - (m).y - i_180_ + 5 + (int) (m.random() * 5.0F);
            is[6] = x - (m).x - 252 + i_182_;
            is_183_[6] = y - (m).y - i_179_ + 5 + (int) (m.random() * 5.0F);
            is[7] = x - (m).x - 504;
            is_183_[7] = y - (m).y - edl[i] + 5 + (int) (m.random() * 5.0F);
            if (roted)
                rot(is, is_184_, x - (m).x, z - (m).z, 90, 8);
            rot(is, is_184_, (m).cx, (m).cz, (m).xz, 8);
            rot(is_183_, is_184_, (m).cy, (m).cz, (m).zy, 8);
            boolean bool = true;
            int i_186_ = 0;
            int i_187_ = 0;
            int i_188_ = 0;
            int i_189_ = 0;
            int[] is_190_ = new int[8];
            int[] is_191_ = new int[8];
            for (int i_192_ = 0; i_192_ < 8; i_192_++) {
                is_190_[i_192_] = xs(is[i_192_], is_184_[i_192_]);
                is_191_[i_192_] = ys(is_183_[i_192_], is_184_[i_192_]);
                if (is_191_[i_192_] < (m).ih || is_184_[i_192_] < 10)
                    i_186_++;
                if (is_191_[i_192_] > (m).h || is_184_[i_192_] < 10)
                    i_187_++;
                if (is_190_[i_192_] < (m).iw || is_184_[i_192_] < 10)
                    i_188_++;
                if (is_190_[i_192_] > (m).w || is_184_[i_192_] < 10)
                    i_189_++;
            }
            if (i_188_ == 8 || i_186_ == 8 || i_187_ == 8 || i_189_ == 8)
                bool = false;
            if (bool) {
                int i_193_ = (int) (160.0F + 160.0F * ((float) (m).snap[0] / 500.0F));
                if (i_193_ > 255)
                    i_193_ = 255;
                if (i_193_ < 0)
                    i_193_ = 0;
                int i_194_ = (int) (238.0F + 238.0F * ((float) (m).snap[1] / 500.0F));
                if (i_194_ > 255)
                    i_194_ = 255;
                if (i_194_ < 0)
                    i_194_ = 0;
                int i_195_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 500.0F));
                if (i_195_ > 255)
                    i_195_ = 255;
                if (i_195_ < 0)
                    i_195_ = 0;
                i_193_ = (i_193_ * 2 + 214 * (elc[i] - 1)) / (elc[i] + 1);
                i_194_ = (i_194_ * 2 + 236 * (elc[i] - 1)) / (elc[i] + 1);
                if ((m).trk == 1) {
                    i_193_ = 255;
                    i_194_ = 128;
                    i_195_ = 0;
                }
                graphics2d.setColor(new Color(i_193_, i_194_, i_195_));
                graphics2d.fillPolygon(is_190_, is_191_, 8);
                if (is_184_[0] < 4000) {
                    i_193_ = (int) (150.0F + 150.0F * ((float) (m).snap[0] / 500.0F));
                    if (i_193_ > 255)
                        i_193_ = 255;
                    if (i_193_ < 0)
                        i_193_ = 0;
                    i_194_ = (int) (227.0F + 227.0F * ((float) (m).snap[1] / 500.0F));
                    if (i_194_ > 255)
                        i_194_ = 255;
                    if (i_194_ < 0)
                        i_194_ = 0;
                    i_195_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 500.0F));
                    if (i_195_ > 255)
                        i_195_ = 255;
                    if (i_195_ < 0)
                        i_195_ = 0;
                    graphics2d.setColor(new Color(i_193_, i_194_, i_195_));
                    graphics2d.drawPolygon(is_190_, is_191_, 8);
                }
            }
            if ((float) elc[i] > m.random() * 60.0F)
                elc[i] = 0;
            else
                elc[i]++;
        }
        if (!roted || xz != 0) {
            xy += 11;
            if (xy > 360)
                xy -= 360;
        } else {
            zy += 11;
            if (zy > 360)
                zy -= 360;
        }
    }
    
    public void dust(int i, float f, float f_196_, float f_197_, int i_198_, int i_199_, float f_200_, int i_201_, boolean bool) {}
    
    public void pdust(int i, Graphics2D graphics2d, boolean bool) {
        if (bool)
            sav[i] = (int) Math.sqrt((double) (((m).x + (m).cx - sx[i]) * ((m).x + (m).cx - sx[i]) + ((m).y + (m).cy - sy[i]) * ((m).y + (m).cy - sy[i]) + ((m).z - sz[i]) * ((m).z - sz[i])));
        if (bool && sav[i] > dist || !bool && sav[i] <= dist) {
            if (stg[i] == 1) {
                sbln[i] = 0.6F;
                boolean bool_205_ = false;
                int[] is = new int[3];
                for (int i_206_ = 0; i_206_ < 3; i_206_++) {
                    is[i_206_] = (int) (255.0F + 255.0F * ((float) (m).snap[i_206_] / 100.0F));
                    if (is[i_206_] > 255)
                        is[i_206_] = 255;
                    if (is[i_206_] < 0)
                        is[i_206_] = 0;
                }
                int i_207_ = (x - (t).sx) / 3000;
                if (i_207_ > (t).ncx)
                    i_207_ = (t).ncx;
                if (i_207_ < 0)
                    i_207_ = 0;
                int i_208_ = (z - (t).sz) / 3000;
                if (i_208_ > (t).ncz)
                    i_208_ = (t).ncz;
                if (i_208_ < 0)
                    i_208_ = 0;
                for (int i_209_ = 0; i_209_ < (t).sect[i_207_][i_208_].length; i_209_++) {
                    int i_210_ = (t).sect[i_207_][i_208_][i_209_];
                    if (Math.abs((t).zy[i_210_]) != 90 && Math.abs((t).xy[i_210_]) != 90 && Math.abs(sx[i] - (t).x[i_210_]) < (t).radx[i_210_] && Math.abs(sz[i] - (t).z[i_210_]) < (t).radz[i_210_]) {
                        if ((t).skd[i_210_] == 0)
                            sbln[i] = 0.2F;
                        if ((t).skd[i_210_] == 1)
                            sbln[i] = 0.4F;
                        if ((t).skd[i_210_] == 2)
                            sbln[i] = 0.45F;
                        for (int i_211_ = 0; i_211_ < 3; i_211_++)
                            srgb[i][i_211_] = ((t).c[i_210_][i_211_] + is[i_211_]) / 2;
                        bool_205_ = true;
                    }
                }
                if (!bool_205_) {
                    for (int i_212_ = 0; i_212_ < 3; i_212_++)
                        srgb[i][i_212_] = ((m).crgrnd[i_212_] + is[i_212_]) / 2;
                }
                float f = (float) (0.1 + (double) m.random());
                if (f > 1.0F)
                    f = 1.0F;
                scx[i] = (int) ((float) scx[i] * f);
                scz[i] = (int) ((float) scx[i] * f);
                for (int i_213_ = 0; i_213_ < 8; i_213_++)
                    smag[i][i_213_] = osmag[i] * m.random() * 50.0F;
                for (int i_214_ = 0; i_214_ < 8; i_214_++) {
                    int i_215_ = i_214_ - 1;
                    if (i_215_ == -1)
                        i_215_ = 7;
                    int i_216_ = i_214_ + 1;
                    if (i_216_ == 8)
                        i_216_ = 0;
                    smag[i][i_214_] = ((smag[i][i_215_] + smag[i][i_216_]) / 2.0F + smag[i][i_214_]) / 2.0F;
                }
                smag[i][6] = smag[i][7];
            }
            int i_217_ = (m).cx + (int) ((float) (sx[i] - (m).x - (m).cx) * m.cos((m).xz) - (float) (sz[i] - (m).z - (m).cz) * m.sin((m).xz));
            int i_218_ = (m).cz + (int) ((float) (sx[i] - (m).x - (m).cx) * m.sin((m).xz) + (float) (sz[i] - (m).z - (m).cz) * m.cos((m).xz));
            int i_219_ = (m).cy + (int) (((float) (sy[i] - (m).y - (m).cy) - smag[i][7]) * m.cos((m).zy) - (float) (i_218_ - (m).cz) * m.sin((m).zy));
            i_218_ = (m).cz + (int) (((float) (sy[i] - (m).y - (m).cy) - smag[i][7]) * m.sin((m).zy) + (float) (i_218_ - (m).cz) * m.cos((m).zy));
            sx[i] += scx[i] / (stg[i] + 1);
            sz[i] += scz[i] / (stg[i] + 1);
            int[] is = new int[8];
            int[] is_220_ = new int[8];
            is[0] = xs((int) ((float) i_217_ + smag[i][0] * 0.9238F * 1.5F), i_218_);
            is_220_[0] = ys((int) ((float) i_219_ + smag[i][0] * 0.3826F * 1.5F), i_218_);
            is[1] = xs((int) ((float) i_217_ + smag[i][1] * 0.9238F * 1.5F), i_218_);
            is_220_[1] = ys((int) ((float) i_219_ - smag[i][1] * 0.3826F * 1.5F), i_218_);
            is[2] = xs((int) ((float) i_217_ + smag[i][2] * 0.3826F), i_218_);
            is_220_[2] = ys((int) ((float) i_219_ - smag[i][2] * 0.9238F), i_218_);
            is[3] = xs((int) ((float) i_217_ - smag[i][3] * 0.3826F), i_218_);
            is_220_[3] = ys((int) ((float) i_219_ - smag[i][3] * 0.9238F), i_218_);
            is[4] = xs((int) ((float) i_217_ - smag[i][4] * 0.9238F * 1.5F), i_218_);
            is_220_[4] = ys((int) ((float) i_219_ - smag[i][4] * 0.3826F * 1.5F), i_218_);
            is[5] = xs((int) ((float) i_217_ - smag[i][5] * 0.9238F * 1.5F), i_218_);
            is_220_[5] = ys((int) ((float) i_219_ + smag[i][5] * 0.3826F * 1.5F), i_218_);
            is[6] = xs((int) ((float) i_217_ - smag[i][6] * 0.3826F * 1.7F), i_218_);
            is_220_[6] = ys((int) ((float) i_219_ + smag[i][6] * 0.9238F), i_218_);
            is[7] = xs((int) ((float) i_217_ + smag[i][7] * 0.3826F * 1.7F), i_218_);
            is_220_[7] = ys((int) ((float) i_219_ + smag[i][7] * 0.9238F), i_218_);
            for (int i_221_ = 0; i_221_ < 7; i_221_++)
                smag[i][i_221_] += 5.0F + m.random() * 15.0F;
            smag[i][7] = smag[i][6];
            boolean bool_222_ = true;
            int i_223_ = 0;
            int i_224_ = 0;
            int i_225_ = 0;
            int i_226_ = 0;
            for (int i_227_ = 0; i_227_ < 8; i_227_++) {
                if (is_220_[i_227_] < (m).ih || i_218_ < 10)
                    i_223_++;
                if (is_220_[i_227_] > (m).h || i_218_ < 10)
                    i_224_++;
                if (is[i_227_] < (m).iw || i_218_ < 10)
                    i_225_++;
                if (is[i_227_] > (m).w || i_218_ < 10)
                    i_226_++;
            }
            if (i_225_ == 4 || i_223_ == 4 || i_224_ == 4 || i_226_ == 4)
                bool_222_ = false;
            if (bool_222_) {
                int i_228_ = srgb[i][0];
                int i_229_ = srgb[i][1];
                int i_230_ = srgb[i][2];
                for (int i_231_ = 0; i_231_ < 16; i_231_++) {
                    if (sav[i] > (m).fade[i_231_]) {
                        i_228_ = (i_228_ * (m).fogd + (m).cfade[0]) / ((m).fogd + 1);
                        i_229_ = (i_229_ * (m).fogd + (m).cfade[1]) / ((m).fogd + 1);
                        i_230_ = (i_230_ * (m).fogd + (m).cfade[2]) / ((m).fogd + 1);
                    }
                }
                graphics2d.setColor(new Color(i_228_, i_229_, i_230_));
                float f = sbln[i] - (float) stg[i] * (sbln[i] / 8.0F);
                graphics2d.setComposite(AlphaComposite.getInstance(3, f));
                graphics2d.fillPolygon(is, is_220_, 8);
                graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }
            if (stg[i] == 7)
                stg[i] = 0;
            else
                stg[i]++;
        }
    }
    
    public void sprk(float f, float f_232_, float f_233_, float f_234_, float f_235_, float f_236_, int i) {
        if (i != 1) {
            srx = (int) (f - (float) sprkat * m.sin(xz));
            sry = (int) (f_232_ - (float) sprkat * m.cos(zy) * m.cos(xy));
            srz = (int) (f_233_ + (float) sprkat * m.cos(xz));
            sprk = 1;
        } else {
            sprk++;
            if (sprk == 4) {
                srx = (int) ((float) x + f_234_);
                sry = (int) f_232_;
                srz = (int) ((float) z + f_236_);
                sprk = 5;
            } else {
                srx = (int) f;
                sry = (int) f_232_;
                srz = (int) f_233_;
            }
        }
        if (i == 2)
            sprk = 6;
        rcx = f_234_;
        rcy = f_235_;
        rcz = f_236_;
    }
    
    public void dsprk(Graphics2D graphics2d, boolean bool) {
        if (bool && sprk != 0) {
            int i = (int) (Math.sqrt((double) (rcx * rcx + rcy * rcy + rcz * rcz)) / 10.0);
            if (i > 5) {
                boolean bool_237_ = false;
                if ((double) dist < Math.sqrt((double) (((m).x + (m).cx - srx) * ((m).x + (m).cx - srx) + ((m).y + (m).cy - sry) * ((m).y + (m).cy - sry) + ((m).z - srz) * ((m).z - srz))))
                    bool_237_ = true;
                if (i > 33)
                    i = 33;
                int i_238_ = 0;
                for (int i_239_ = 0; i_239_ < 100; i_239_++) {
                    if (rtg[i_239_] == 0) {
                        rtg[i_239_] = 1;
                        rbef[i_239_] = bool_237_;
                        i_238_++;
                    }
                    if (i_238_ == i)
                        break;
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (rtg[i] != 0 && (rbef[i] && bool || !rbef[i] && !bool)) {
                if (rtg[i] == 1) {
                    if (sprk < 5) {
                        rx[i] = srx + 3 - (int) ((double) m.random() * 6.7);
                        ry[i] = sry + 3 - (int) ((double) m.random() * 6.7);
                        rz[i] = srz + 3 - (int) ((double) m.random() * 6.7);
                    } else {
                        rx[i] = srx + 10 - (int) (m.random() * 20.0F);
                        ry[i] = sry - (int) (m.random() * 4.0F);
                        rz[i] = srz + 10 - (int) (m.random() * 20.0F);
                    }
                    int i_240_ = (int) Math.sqrt((double) (rcx * rcx + rcy * rcy + rcz * rcz));
                    float f = 0.2F + 0.4F * m.random();
                    float f_241_ = m.random() * m.random() * m.random();
                    float f_242_ = 1.0F;
                    if (m.random() > m.random()) {
                        if (m.random() > m.random())
                            f_242_ *= -1.0F;
                        vrx[i] = -((rcx + (float) i_240_ * (1.0F - rcx / (float) i_240_) * f_241_ * f_242_) * f);
                    }
                    if (m.random() > m.random()) {
                        if (m.random() > m.random())
                            f_242_ *= -1.0F;
                        if (sprk == 5)
                            f_242_ = 1.0F;
                        vry[i] = -((rcy + (float) i_240_ * (1.0F - rcy / (float) i_240_) * f_241_ * f_242_) * f);
                    }
                    if (m.random() > m.random()) {
                        if (m.random() > m.random())
                            f_242_ *= -1.0F;
                        vrz[i] = -((rcz + (float) i_240_ * (1.0F - rcz / (float) i_240_) * f_241_ * f_242_) * f);
                    }
                }
                rx[i] += vrx[i];
                ry[i] += vry[i];
                rz[i] += vrz[i];
                int i_243_ = (m).cx + (int) ((float) (rx[i] - (m).x - (m).cx) * m.cos((m).xz) - (float) (rz[i] - (m).z - (m).cz) * m.sin((m).xz));
                int i_244_ = (m).cz + (int) ((float) (rx[i] - (m).x - (m).cx) * m.sin((m).xz) + (float) (rz[i] - (m).z - (m).cz) * m.cos((m).xz));
                int i_245_ = (m).cy + (int) ((float) (ry[i] - (m).y - (m).cy) * m.cos((m).zy) - (float) (i_244_ - (m).cz) * m.sin((m).zy));
                i_244_ = (m).cz + (int) ((float) (ry[i] - (m).y - (m).cy) * m.sin((m).zy) + (float) (i_244_ - (m).cz) * m.cos((m).zy));
                int i_246_ = (m).cx + (int) (((float) (rx[i] - (m).x - (m).cx) + vrx[i]) * m.cos((m).xz) - ((float) (rz[i] - (m).z - (m).cz) + vrz[i]) * m.sin((m).xz));
                int i_247_ = (m).cz + (int) (((float) (rx[i] - (m).x - (m).cx) + vrx[i]) * m.sin((m).xz) + ((float) (rz[i] - (m).z - (m).cz) + vrz[i]) * m.cos((m).xz));
                int i_248_ = (m).cy + (int) (((float) (ry[i] - (m).y - (m).cy) + vry[i]) * m.cos((m).zy) - (float) (i_247_ - (m).cz) * m.sin((m).zy));
                i_247_ = (m).cz + (int) (((float) (ry[i] - (m).y - (m).cy) + vry[i]) * m.sin((m).zy) + (float) (i_247_ - (m).cz) * m.cos((m).zy));
                int i_249_ = xs(i_243_, i_244_);
                int i_250_ = ys(i_245_, i_244_);
                int i_251_ = xs(i_246_, i_247_);
                int i_252_ = ys(i_248_, i_247_);
                if (i_249_ < (m).iw && i_251_ < (m).iw)
                    rtg[i] = 0;
                if (i_249_ > (m).w && i_251_ > (m).w)
                    rtg[i] = 0;
                if (i_250_ < (m).ih && i_252_ < (m).ih)
                    rtg[i] = 0;
                if (i_250_ > (m).h && i_252_ > (m).h)
                    rtg[i] = 0;
                if (ry[i] > 250)
                    rtg[i] = 0;
                if (rtg[i] != 0) {
                    int i_253_ = 255;
                    int i_254_ = 197 - 30 * rtg[i];
                    int i_255_ = 0;
                    for (int i_256_ = 0; i_256_ < 16; i_256_++) {
                        if (i_244_ > (m).fade[i_256_]) {
                            i_253_ = (i_253_ * (m).fogd + (m).cfade[0]) / ((m).fogd + 1);
                            i_254_ = (i_254_ * (m).fogd + (m).cfade[1]) / ((m).fogd + 1);
                            i_255_ = (i_255_ * (m).fogd + (m).cfade[2]) / ((m).fogd + 1);
                        }
                    }
                    graphics2d.setColor(new Color(i_253_, i_254_, i_255_));
                    graphics2d.drawLine(i_249_, i_250_, i_251_, i_252_);
                    vrx[i] = vrx[i] * 0.8F;
                    vry[i] = vry[i] * 0.8F;
                    vrz[i] = vrz[i] * 0.8F;
                    if (rtg[i] == 3)
                        rtg[i] = 0;
                    else
                        rtg[i]++;
                }
            }
        }
        if (sprk != 0)
            sprk = 0;
    }
    
    public int xs(int i, int i_257_) {
        if (i_257_ < 50)
            i_257_ = 50;
        return (i_257_ - (m).focus_point) * ((m).cx - i) / i_257_ + i;
    }
    
    public int ys(int i, int i_258_) {
        if (i_258_ < 50)
            i_258_ = 50;
        return (i_258_ - (m).focus_point) * ((m).cy - i) / i_258_ + i;
    }
    
    public int getvalue(String string, String string_259_, int i) {
        int i_260_ = 0;
        String string_261_ = "";
        for (int i_262_ = string.length() + 1; i_262_ < string_259_.length(); i_262_++) {
            String string_263_ = new StringBuilder().append("").append(string_259_.charAt(i_262_)).toString();
            if (string_263_.equals(",") || string_263_.equals(")")) {
                i_260_++;
                i_262_++;
            }
            if (i_260_ == i)
                string_261_ = new StringBuilder().append(string_261_).append(string_259_.charAt(i_262_)).toString();
        }
        return Float.valueOf(string_261_).intValue();
    }
    
    public int getpy(int i, int i_264_, int i_265_) {
        return (i - x) / 10 * ((i - x) / 10) + (i_264_ - y) / 10 * ((i_264_ - y) / 10) + (i_265_ - z) / 10 * ((i_265_ - z) / 10);
    }
    
    public int py(int i, int i_266_, int i_267_, int i_268_) {
        return (i - i_266_) * (i - i_266_) + (i_267_ - i_268_) * (i_267_ - i_268_);
    }
    
    public void rot(int[] is, int[] is_269_, int i, int i_270_, int i_271_, int i_272_) {
        if (i_271_ != 0) {
            for (int i_273_ = 0; i_273_ < i_272_; i_273_++) {
                int i_274_ = is[i_273_];
                int i_275_ = is_269_[i_273_];
                is[i_273_] = i + (int) ((float) (i_274_ - i) * m.cos(i_271_) - (float) (i_275_ - i_270_) * m.sin(i_271_));
                is_269_[i_273_] = i_270_ + (int) ((float) (i_274_ - i) * m.sin(i_271_) + (float) (i_275_ - i_270_) * m.cos(i_271_));
            }
        }
    }
}
