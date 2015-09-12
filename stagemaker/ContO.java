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
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.sprkat = 0;
        this.tnt = 0;
        this.ust = 0;
        this.srx = 0;
        this.sry = 0;
        this.srz = 0;
        this.rcx = 0.0F;
        this.rcy = 0.0F;
        this.rcz = 0.0F;
        this.sprk = 0;
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[] { 0, 0, 0, 0 };
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.fcol = new int[] { 0, 0, 0 };
        this.scol = new int[] { 0, 0, 0 };
        this.colok = 0;
        this.errd = false;
        this.err = "";
        this.roofat = 0;
        this.wh = 0;
        this.m = medium;
        this.t = trackers;
        this.p = new Plane[10000];
        int[] is_0_ = new int[10000];
        for (int i = 0; i < 286; i++)
            is_0_[i] = 0;
        if ((this.m).loadnew) {
            for (int i = 0; i < 4; i++)
                this.keyz[i] = 0;
            this.shadow = true;
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
                if (this.npl < 10000) {
                    if (string.startsWith("<p>")) {
                        bool = true;
                        i = 0;
                        i_9_ = 0;
                        i_10_ = 0;
                        i_12_ = 0;
                        is_0_[this.npl] = 1;
                        if (!bool_15_)
                            bool_14_ = false;
                    }
                    if (bool) {
                        if (string.startsWith("gr("))
                            i_9_ = getvalue("gr", string, 0);
                        if (string.startsWith("fs(")) {
                            i_10_ = getvalue("fs", string, 0);
                            is_0_[this.npl] = 2;
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
                            if (i_17_ > this.maxR)
                                this.maxR = i_17_;
                            i++;
                        }
                    }
                    if (string.startsWith("</p>")) {
                        this.p[this.npl] = new Plane(this.m, this.t, is_3_, is_5_, is_4_, i, is_6_, i_13_, i_9_, i_10_, 0, 0, 0, this.disline, 0, bool_7_, i_12_, bool_14_);
                        if (is_6_[0] == this.fcol[0] && is_6_[1] == this.fcol[1] && is_6_[2] == this.fcol[2] && i_13_ == 0)
                            (this.p[this.npl]).colnum = 1;
                        if (is_6_[0] == this.scol[0] && is_6_[1] == this.scol[1] && is_6_[2] == this.scol[2] && i_13_ == 0)
                            (this.p[this.npl]).colnum = 2;
                        this.npl++;
                        bool = false;
                    }
                }
                if (string.startsWith("rims("))
                    wheels.setrims(getvalue("rims", string, 0), getvalue("rims", string, 1), getvalue("rims", string, 2), getvalue("rims", string, 3), getvalue("rims", string, 4));
                if (string.startsWith("w(") && i_8_ < 4) {
                    this.keyx[i_8_] = (int) ((float) getvalue("w", string, 0) * f * fs[0]);
                    this.keyz[i_8_] = (int) ((float) getvalue("w", string, 2) * f * fs[2]);
                    wheels.make(this.m, this.t, this.p, this.npl, (int) ((float) getvalue("w", string, 0) * f * f_2_ * fs[0]), (int) ((float) getvalue("w", string, 1) * f * fs[1]), (int) ((float) getvalue("w", string, 2) * f * fs[2]), getvalue("w", string, 3), (int) ((float) getvalue("w", string, 4) * f * f_2_), (int) ((float) getvalue("w", string, 5) * f), i_11_);
                    this.npl += 19;
                    if ((this.m).loadnew) {
                        this.wh += (int) ((float) getvalue("w", string, 5) * f);
                        if ((wheels).ground > 140) {
                            String string_18_ = "FRONT";
                            if (this.keyz[i_8_] < 0)
                                string_18_ = "BACK";
                            this.err = new StringBuilder().append("Wheels Error:\n").append(string_18_).append(" Wheels floor is too far below the center of Y Axis of the car!    \n\nPlease decrease the Y value of the ").append(string_18_).append(" Wheels or decrease its height.     \n \n").toString();
                            this.errd = true;
                            this.keyz[i_8_] = 0;
                            this.keyx[i_8_] = 0;
                        }
                        if ((wheels).ground < -100) {
                            String string_19_ = "FRONT";
                            if (this.keyz[i_8_] < 0)
                                string_19_ = "BACK";
                            this.err = new StringBuilder().append("Wheels Error:\n").append(string_19_).append(" Wheels floor is too far above the center of Y Axis of the car!    \n\nPlease increase the Y value of the ").append(string_19_).append(" Wheels or increase its height.     \n \n").toString();
                            this.errd = true;
                            this.keyz[i_8_] = 0;
                            this.keyx[i_8_] = 0;
                        }
                        if (Math.abs(this.keyx[i_8_]) > 400) {
                            String string_20_ = "FRONT";
                            if (this.keyz[i_8_] < 0)
                                string_20_ = "BACK";
                            this.err = new StringBuilder().append("Wheels Error:\n").append(string_20_).append(" Wheels are too far apart!    \n\nPlease decrease the \u00b1X value of the ").append(string_20_).append(" Wheels.     \n \n").toString();
                            this.errd = true;
                            this.keyz[i_8_] = 0;
                            this.keyx[i_8_] = 0;
                        }
                        if (Math.abs(this.keyz[i_8_]) > 700) {
                            if (this.keyz[i_8_] < 0)
                                this.err = "Wheels Error:\nBACK Wheels are too far backwards from the center of the Z Axis!    \n\nPlease increase the -Z value of the BACK Wheels.     \n \n";
                            else
                                this.err = "Wheels Error:\nFRONT Wheels are too far forwards from the center of the Z Axis!    \n\nPlease decrease the +Z value of the FRONT Wheels.     \n \n";
                            this.errd = true;
                            this.keyz[i_8_] = 0;
                            this.keyx[i_8_] = 0;
                        }
                        if ((int) ((float) getvalue("w", string, 4) * f * f_2_) > 300) {
                            String string_21_ = "FRONT";
                            if (this.keyz[i_8_] < 0)
                                string_21_ = "BACK";
                            this.err = new StringBuilder().append("Wheels Error:\nWidth of the ").append(string_21_).append(" Wheels is too large!    \n\nPlease decrease the width of the ").append(string_21_).append(" Wheels.     \n \n").toString();
                            this.errd = true;
                            this.keyz[i_8_] = 0;
                            this.keyx[i_8_] = 0;
                        }
                    }
                    i_8_++;
                }
                if (string.startsWith("tracks")) {
                    int i_22_ = getvalue("tracks", string, 0);
                    this.txy = new int[i_22_];
                    this.tzy = new int[i_22_];
                    this.tc = new int[i_22_][3];
                    this.tradx = new int[i_22_];
                    this.tradz = new int[i_22_];
                    this.trady = new int[i_22_];
                    this.tx = new int[i_22_];
                    this.ty = new int[i_22_];
                    this.tz = new int[i_22_];
                    this.skd = new int[i_22_];
                    this.dam = new int[i_22_];
                    this.notwall = new boolean[i_22_];
                }
                if (string.startsWith("<track>")) {
                    bool_1_ = true;
                    this.notwall[this.tnt] = false;
                    this.dam[this.tnt] = 1;
                    this.skd[this.tnt] = 0;
                    this.ty[this.tnt] = 0;
                    this.tx[this.tnt] = 0;
                    this.tz[this.tnt] = 0;
                    this.txy[this.tnt] = 0;
                    this.tzy[this.tnt] = 0;
                    this.trady[this.tnt] = 0;
                    this.tradx[this.tnt] = 0;
                    this.tradz[this.tnt] = 0;
                    this.tc[this.tnt][0] = 0;
                    this.tc[this.tnt][1] = 0;
                    this.tc[this.tnt][2] = 0;
                }
                if (bool_1_) {
                    if (string.startsWith("c")) {
                        this.tc[this.tnt][0] = getvalue("c", string, 0);
                        this.tc[this.tnt][1] = getvalue("c", string, 1);
                        this.tc[this.tnt][2] = getvalue("c", string, 2);
                    }
                    if (string.startsWith("xy"))
                        this.txy[this.tnt] = getvalue("xy", string, 0);
                    if (string.startsWith("zy"))
                        this.tzy[this.tnt] = getvalue("zy", string, 0);
                    if (string.startsWith("radx"))
                        this.tradx[this.tnt] = (int) ((float) getvalue("radx", string, 0) * f);
                    if (string.startsWith("rady"))
                        this.trady[this.tnt] = (int) ((float) getvalue("rady", string, 0) * f);
                    if (string.startsWith("radz"))
                        this.tradz[this.tnt] = (int) ((float) getvalue("radz", string, 0) * f);
                    if (string.startsWith("ty"))
                        this.ty[this.tnt] = (int) ((float) getvalue("ty", string, 0) * f);
                    if (string.startsWith("tx"))
                        this.tx[this.tnt] = (int) ((float) getvalue("tx", string, 0) * f);
                    if (string.startsWith("tz"))
                        this.tz[this.tnt] = (int) ((float) getvalue("tz", string, 0) * f);
                    if (string.startsWith("skid"))
                        this.skd[this.tnt] = getvalue("skid", string, 0);
                    if (string.startsWith("dam"))
                        this.dam[this.tnt] = 3;
                    if (string.startsWith("notwall"))
                        this.notwall[this.tnt] = true;
                }
                if (string.startsWith("</track>")) {
                    bool_1_ = false;
                    this.tnt++;
                }
                if (string.startsWith("disp("))
                    this.disp = getvalue("disp", string, 0);
                if (string.startsWith("disline("))
                    this.disline = getvalue("disline", string, 0) * 2;
                if (string.startsWith("shadow"))
                    this.shadow = true;
                if (string.startsWith("stonecold"))
                    this.noline = true;
                if (string.startsWith("newstone")) {
                    this.noline = true;
                    bool_14_ = true;
                    bool_15_ = true;
                }
                if (string.startsWith("decorative"))
                    this.decor = true;
                if (string.startsWith("road"))
                    bool_7_ = true;
                if (string.startsWith("notroad"))
                    bool_7_ = false;
                if (string.startsWith("grounded("))
                    this.grounded = (float) getvalue("grounded", string, 0) / 100.0F;
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
                    if ((this.m).loadnew) {
                        if (i_11_ > 40)
                            i_11_ = 40;
                        if (i_11_ < 0 && i_11_ >= -15)
                            i_11_ = -16;
                        if (i_11_ < -40)
                            i_11_ = -40;
                    }
                }
                if (string.startsWith("1stColor(")) {
                    this.fcol[0] = getvalue("1stColor", string, 0);
                    this.fcol[1] = getvalue("1stColor", string, 1);
                    this.fcol[2] = getvalue("1stColor", string, 2);
                    this.colok++;
                }
                if (string.startsWith("2ndColor(")) {
                    this.scol[0] = getvalue("2ndColor", string, 0);
                    this.scol[1] = getvalue("2ndColor", string, 1);
                    this.scol[2] = getvalue("2ndColor", string, 2);
                    this.colok++;
                }
            }
            datainputstream.close();
        } catch (Exception exception) {
            if (!this.errd) {
                this.err = new StringBuilder().append("Error While Loading 3D Model\n\nLine:     ").append(string).append("\n\nError Detail:\n").append(exception).append("           \n \n").toString();
                System.out.println(this.err);
                this.errd = true;
            }
        }
        this.grat = (wheels).ground;
        this.sprkat = (wheels).sparkat;
        if (this.shadow) {
            this.stg = new int[20];
            this.rtg = new int[100];
            for (int i_23_ = 0; i_23_ < 20; i_23_++)
                this.stg[i_23_] = 0;
            for (int i_24_ = 0; i_24_ < 100; i_24_++)
                this.rtg[i_24_] = 0;
        }
        if ((this.m).loadnew) {
            if (i_8_ != 0)
                this.wh = this.wh / i_8_;
            boolean bool_25_ = false;
            for (int i_26_ = 0; i_26_ < this.npl; i_26_++) {
                int i_27_ = 0;
                int i_28_ = (this.p[i_26_]).ox[0];
                int i_29_ = (this.p[i_26_]).ox[0];
                int i_30_ = (this.p[i_26_]).oy[0];
                int i_31_ = (this.p[i_26_]).oy[0];
                int i_32_ = (this.p[i_26_]).oz[0];
                int i_33_ = (this.p[i_26_]).oz[0];
                for (int i_34_ = 0; i_34_ < (this.p[i_26_]).n; i_34_++) {
                    if ((this.p[i_26_]).ox[i_34_] > i_28_)
                        i_28_ = (this.p[i_26_]).ox[i_34_];
                    if ((this.p[i_26_]).ox[i_34_] < i_29_)
                        i_29_ = (this.p[i_26_]).ox[i_34_];
                    if ((this.p[i_26_]).oy[i_34_] > i_30_)
                        i_30_ = (this.p[i_26_]).oy[i_34_];
                    if ((this.p[i_26_]).oy[i_34_] < i_31_)
                        i_31_ = (this.p[i_26_]).oy[i_34_];
                    if ((this.p[i_26_]).oz[i_34_] > i_32_)
                        i_32_ = (this.p[i_26_]).oz[i_34_];
                    if ((this.p[i_26_]).oz[i_34_] < i_33_)
                        i_33_ = (this.p[i_26_]).oz[i_34_];
                }
                if (Math.abs(i_28_ - i_29_) <= Math.abs(i_30_ - i_31_) && Math.abs(i_28_ - i_29_) <= Math.abs(i_32_ - i_33_))
                    i_27_ = 1;
                if (Math.abs(i_30_ - i_31_) <= Math.abs(i_28_ - i_29_) && Math.abs(i_30_ - i_31_) <= Math.abs(i_32_ - i_33_))
                    i_27_ = 2;
                if (Math.abs(i_32_ - i_33_) <= Math.abs(i_28_ - i_29_) && Math.abs(i_32_ - i_33_) <= Math.abs(i_30_ - i_31_))
                    i_27_ = 3;
                if (i_27_ == 2 && (!bool_25_ || (i_30_ + i_31_) / 2 < this.roofat)) {
                    this.roofat = (i_30_ + i_31_) / 2;
                    bool_25_ = true;
                }
                if (is_0_[i_26_] == 1) {
                    int i_35_ = 1000;
                    int i_36_ = 0;
                    for (int i_37_ = 0; i_37_ < (this.p[i_26_]).n; i_37_++) {
                        int i_38_ = i_37_ + 1;
                        if (i_38_ >= (this.p[i_26_]).n)
                            i_38_ -= (this.p[i_26_]).n;
                        int i_39_ = i_37_ + 2;
                        if (i_39_ >= (this.p[i_26_]).n)
                            i_39_ -= (this.p[i_26_]).n;
                        if (i_27_ == 1) {
                            int i_40_ = Math.abs((int) (Math.atan((double) ((this.p[i_26_]).oz[i_37_] - (this.p[i_26_]).oz[i_38_]) / (double) ((this.p[i_26_]).oy[i_37_] - (this.p[i_26_]).oy[i_38_])) / 0.017453292519943295));
                            int i_41_ = Math.abs((int) (Math.atan((double) ((this.p[i_26_]).oz[i_39_] - (this.p[i_26_]).oz[i_38_]) / (double) ((this.p[i_26_]).oy[i_39_] - (this.p[i_26_]).oy[i_38_])) / 0.017453292519943295));
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
                            int i_42_ = Math.abs((int) (Math.atan((double) ((this.p[i_26_]).oz[i_37_] - (this.p[i_26_]).oz[i_38_]) / (double) ((this.p[i_26_]).ox[i_37_] - (this.p[i_26_]).ox[i_38_])) / 0.017453292519943295));
                            int i_43_ = Math.abs((int) (Math.atan((double) ((this.p[i_26_]).oz[i_39_] - (this.p[i_26_]).oz[i_38_]) / (double) ((this.p[i_26_]).ox[i_39_] - (this.p[i_26_]).ox[i_38_])) / 0.017453292519943295));
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
                            int i_44_ = Math.abs((int) (Math.atan((double) ((this.p[i_26_]).oy[i_37_] - (this.p[i_26_]).oy[i_38_]) / (double) ((this.p[i_26_]).ox[i_37_] - (this.p[i_26_]).ox[i_38_])) / 0.017453292519943295));
                            int i_45_ = Math.abs((int) (Math.atan((double) ((this.p[i_26_]).oy[i_39_] - (this.p[i_26_]).oy[i_38_]) / (double) ((this.p[i_26_]).ox[i_39_] - (this.p[i_26_]).ox[i_38_])) / 0.017453292519943295));
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
                        int[] is_46_ = new int[(this.p[i_26_]).n];
                        int[] is_47_ = new int[(this.p[i_26_]).n];
                        int[] is_48_ = new int[(this.p[i_26_]).n];
                        for (int i_49_ = 0; i_49_ < (this.p[i_26_]).n; i_49_++) {
                            is_46_[i_49_] = (this.p[i_26_]).ox[i_49_];
                            is_47_[i_49_] = (this.p[i_26_]).oy[i_49_];
                            is_48_[i_49_] = (this.p[i_26_]).oz[i_49_];
                        }
                        for (int i_50_ = 0; i_50_ < (this.p[i_26_]).n; i_50_++) {
                            int i_51_ = i_50_ + i_36_;
                            if (i_51_ >= (this.p[i_26_]).n)
                                i_51_ -= (this.p[i_26_]).n;
                            (this.p[i_26_]).ox[i_50_] = is_46_[i_51_];
                            (this.p[i_26_]).oy[i_50_] = is_47_[i_51_];
                            (this.p[i_26_]).oz[i_50_] = is_48_[i_51_];
                        }
                    }
                    if (i_27_ == 1) {
                        if (Math.abs((this.p[i_26_]).oz[0] - (this.p[i_26_]).oz[1]) > Math.abs((this.p[i_26_]).oy[0] - (this.p[i_26_]).oy[1])) {
                            if ((this.p[i_26_]).oz[0] > (this.p[i_26_]).oz[1]) {
                                if ((this.p[i_26_]).oy[1] > (this.p[i_26_]).oy[2])
                                    (this.p[i_26_]).fs = 1;
                                else
                                    (this.p[i_26_]).fs = -1;
                            } else if ((this.p[i_26_]).oy[1] > (this.p[i_26_]).oy[2])
                                (this.p[i_26_]).fs = -1;
                            else
                                (this.p[i_26_]).fs = 1;
                        } else if ((this.p[i_26_]).oy[0] > (this.p[i_26_]).oy[1]) {
                            if ((this.p[i_26_]).oz[1] > (this.p[i_26_]).oz[2])
                                (this.p[i_26_]).fs = -1;
                            else
                                (this.p[i_26_]).fs = 1;
                        } else if ((this.p[i_26_]).oz[1] > (this.p[i_26_]).oz[2])
                            (this.p[i_26_]).fs = 1;
                        else
                            (this.p[i_26_]).fs = -1;
                    }
                    if (i_27_ == 2) {
                        if (Math.abs((this.p[i_26_]).oz[0] - (this.p[i_26_]).oz[1]) > Math.abs((this.p[i_26_]).ox[0] - (this.p[i_26_]).ox[1])) {
                            if ((this.p[i_26_]).oz[0] > (this.p[i_26_]).oz[1]) {
                                if ((this.p[i_26_]).ox[1] > (this.p[i_26_]).ox[2])
                                    (this.p[i_26_]).fs = -1;
                                else
                                    (this.p[i_26_]).fs = 1;
                            } else if ((this.p[i_26_]).ox[1] > (this.p[i_26_]).ox[2])
                                (this.p[i_26_]).fs = 1;
                            else
                                (this.p[i_26_]).fs = -1;
                        } else if ((this.p[i_26_]).ox[0] > (this.p[i_26_]).ox[1]) {
                            if ((this.p[i_26_]).oz[1] > (this.p[i_26_]).oz[2])
                                (this.p[i_26_]).fs = 1;
                            else
                                (this.p[i_26_]).fs = -1;
                        } else if ((this.p[i_26_]).oz[1] > (this.p[i_26_]).oz[2])
                            (this.p[i_26_]).fs = -1;
                        else
                            (this.p[i_26_]).fs = 1;
                    }
                    if (i_27_ == 3) {
                        if (Math.abs((this.p[i_26_]).oy[0] - (this.p[i_26_]).oy[1]) > Math.abs((this.p[i_26_]).ox[0] - (this.p[i_26_]).ox[1])) {
                            if ((this.p[i_26_]).oy[0] > (this.p[i_26_]).oy[1]) {
                                if ((this.p[i_26_]).ox[1] > (this.p[i_26_]).ox[2])
                                    (this.p[i_26_]).fs = 1;
                                else
                                    (this.p[i_26_]).fs = -1;
                            } else if ((this.p[i_26_]).ox[1] > (this.p[i_26_]).ox[2])
                                (this.p[i_26_]).fs = -1;
                            else
                                (this.p[i_26_]).fs = 1;
                        } else if ((this.p[i_26_]).ox[0] > (this.p[i_26_]).ox[1]) {
                            if ((this.p[i_26_]).oy[1] > (this.p[i_26_]).oy[2])
                                (this.p[i_26_]).fs = -1;
                            else
                                (this.p[i_26_]).fs = 1;
                        } else if ((this.p[i_26_]).oy[1] > (this.p[i_26_]).oy[2])
                            (this.p[i_26_]).fs = 1;
                        else
                            (this.p[i_26_]).fs = -1;
                    }
                    boolean bool_52_ = false;
                    boolean bool_53_ = false;
                    for (int i_54_ = 0; i_54_ < this.npl; i_54_++) {
                        if (i_54_ != i_26_ && is_0_[i_54_] != 0) {
                            boolean bool_55_ = false;
                            int i_56_ = (this.p[i_54_]).ox[0];
                            int i_57_ = (this.p[i_54_]).ox[0];
                            int i_58_ = (this.p[i_54_]).oy[0];
                            int i_59_ = (this.p[i_54_]).oy[0];
                            int i_60_ = (this.p[i_54_]).oz[0];
                            int i_61_ = (this.p[i_54_]).oz[0];
                            for (int i_62_ = 0; i_62_ < (this.p[i_54_]).n; i_62_++) {
                                if ((this.p[i_54_]).ox[i_62_] > i_56_)
                                    i_56_ = (this.p[i_54_]).ox[i_62_];
                                if ((this.p[i_54_]).ox[i_62_] < i_57_)
                                    i_57_ = (this.p[i_54_]).ox[i_62_];
                                if ((this.p[i_54_]).oy[i_62_] > i_58_)
                                    i_58_ = (this.p[i_54_]).oy[i_62_];
                                if ((this.p[i_54_]).oy[i_62_] < i_59_)
                                    i_59_ = (this.p[i_54_]).oy[i_62_];
                                if ((this.p[i_54_]).oz[i_62_] > i_60_)
                                    i_60_ = (this.p[i_54_]).oz[i_62_];
                                if ((this.p[i_54_]).oz[i_62_] < i_61_)
                                    i_61_ = (this.p[i_54_]).oz[i_62_];
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
                        (this.p[i_26_]).fs *= -1;
                        bool_69_ = true;
                    }
                    if (bool_52_ && bool_53_) {
                        (this.p[i_26_]).fs = 0;
                        (this.p[i_26_]).gr = 40;
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
                        for (int i_72_ = 0; i_72_ < this.npl; i_72_++) {
                            if (i_72_ != i_26_) {
                                boolean bool_73_ = false;
                                boolean[] bools = new boolean[(this.p[i_72_]).n];
                                for (int i_74_ = 0; i_74_ < (this.p[i_72_]).n; i_74_++) {
                                    bools[i_74_] = false;
                                    for (int i_75_ = 0; i_75_ < (this.p[i_26_]).n; i_75_++) {
                                        if ((this.p[i_26_]).ox[i_75_] == (this.p[i_72_]).ox[i_74_] && (this.p[i_26_]).oy[i_75_] == (this.p[i_72_]).oy[i_74_] && (this.p[i_26_]).oz[i_75_] == (this.p[i_72_]).oz[i_74_]) {
                                            bools[i_74_] = true;
                                            bool_73_ = true;
                                        }
                                    }
                                }
                                if (bool_73_) {
                                    for (int i_76_ = 0; i_76_ < (this.p[i_72_]).n; i_76_++) {
                                        if (!bools[i_76_]) {
                                            if (i_27_ == 1) {
                                                if ((this.p[i_72_]).ox[i_76_] > i_70_)
                                                    i_70_ = (this.p[i_72_]).ox[i_76_];
                                                if ((this.p[i_72_]).ox[i_76_] < i_71_)
                                                    i_71_ = (this.p[i_72_]).ox[i_76_];
                                            }
                                            if (i_27_ == 2) {
                                                if ((this.p[i_72_]).oy[i_76_] > i_70_)
                                                    i_70_ = (this.p[i_72_]).oy[i_76_];
                                                if ((this.p[i_72_]).oy[i_76_] < i_71_)
                                                    i_71_ = (this.p[i_72_]).oy[i_76_];
                                            }
                                            if (i_27_ == 3) {
                                                if ((this.p[i_72_]).oz[i_76_] > i_70_)
                                                    i_70_ = (this.p[i_72_]).oz[i_76_];
                                                if ((this.p[i_72_]).oz[i_76_] < i_71_)
                                                    i_71_ = (this.p[i_72_]).oz[i_76_];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i_27_ == 1) {
                            if ((i_70_ + i_71_) / 2 > (i_28_ + i_29_) / 2)
                                (this.p[i_26_]).fs *= -1;
                            else if ((i_70_ + i_71_) / 2 == (i_28_ + i_29_) / 2 && (i_28_ + i_29_) / 2 < 0)
                                (this.p[i_26_]).fs *= -1;
                        }
                        if (i_27_ == 2) {
                            if ((i_70_ + i_71_) / 2 > (i_30_ + i_31_) / 2)
                                (this.p[i_26_]).fs *= -1;
                            else if ((i_70_ + i_71_) / 2 == (i_30_ + i_31_) / 2 && (i_30_ + i_31_) / 2 < 0)
                                (this.p[i_26_]).fs *= -1;
                        }
                        if (i_27_ == 3) {
                            if ((i_70_ + i_71_) / 2 > (i_32_ + i_33_) / 2)
                                (this.p[i_26_]).fs *= -1;
                            else if ((i_70_ + i_71_) / 2 == (i_32_ + i_33_) / 2 && (i_32_ + i_33_) / 2 < 0)
                                (this.p[i_26_]).fs *= -1;
                        }
                    }
                    this.p[i_26_].deltafntyp();
                }
            }
        }
    }
    
    public ContO(ContO conto_77_, int i, int i_78_, int i_79_, int i_80_) {
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.sprkat = 0;
        this.tnt = 0;
        this.ust = 0;
        this.srx = 0;
        this.sry = 0;
        this.srz = 0;
        this.rcx = 0.0F;
        this.rcy = 0.0F;
        this.rcz = 0.0F;
        this.sprk = 0;
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[] { 0, 0, 0, 0 };
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.fcol = new int[] { 0, 0, 0 };
        this.scol = new int[] { 0, 0, 0 };
        this.colok = 0;
        this.errd = false;
        this.err = "";
        this.roofat = 0;
        this.wh = 0;
        this.m = (conto_77_).m;
        this.t = (conto_77_).t;
        this.npl = (conto_77_).npl;
        this.maxR = (conto_77_).maxR;
        this.disp = (conto_77_).disp;
        this.disline = (conto_77_).disline;
        this.noline = (conto_77_).noline;
        this.shadow = (conto_77_).shadow;
        this.grounded = (conto_77_).grounded;
        this.decor = (conto_77_).decor;
        if ((this.m).loadnew && (i_80_ == 90 || i_80_ == -90))
            this.grounded += 10000.0F;
        this.grat = (conto_77_).grat;
        this.sprkat = (conto_77_).sprkat;
        this.p = new Plane[(conto_77_).npl];
        for (int i_81_ = 0; i_81_ < this.npl; i_81_++) {
            if (((conto_77_).p[i_81_]).master == 1)
                ((conto_77_).p[i_81_]).n = 20;
            this.p[i_81_] = new Plane(this.m, this.t, ((conto_77_).p[i_81_]).ox, ((conto_77_).p[i_81_]).oz, ((conto_77_).p[i_81_]).oy, ((conto_77_).p[i_81_]).n, ((conto_77_).p[i_81_]).oc, ((conto_77_).p[i_81_]).glass, ((conto_77_).p[i_81_]).gr, ((conto_77_).p[i_81_]).fs, ((conto_77_).p[i_81_]).wx, ((conto_77_).p[i_81_]).wy, ((conto_77_).p[i_81_]).wz, (conto_77_).disline, ((conto_77_).p[i_81_]).bfase, ((conto_77_).p[i_81_]).road, ((conto_77_).p[i_81_]).light, ((conto_77_).p[i_81_]).solo);
        }
        this.x = i;
        this.y = i_78_;
        this.z = i_79_;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        for (int i_82_ = 0; i_82_ < this.npl; i_82_++) {
            (this.p[i_82_]).colnum = ((conto_77_).p[i_82_]).colnum;
            (this.p[i_82_]).master = ((conto_77_).p[i_82_]).master;
            this.p[i_82_].rot((this.p[i_82_]).ox, (this.p[i_82_]).oz, 0, 0, i_80_, (this.p[i_82_]).n);
            this.p[i_82_].loadprojf();
        }
        if ((conto_77_).tnt != 0) {
            for (int i_83_ = 0; i_83_ < (conto_77_).tnt; i_83_++) {
                (this.t).xy[(this.t).nt] = (int) ((float) (conto_77_).txy[i_83_] * this.m.cos(i_80_) - (float) (conto_77_).tzy[i_83_] * this.m.sin(i_80_));
                (this.t).zy[(this.t).nt] = (int) ((float) (conto_77_).tzy[i_83_] * this.m.cos(i_80_) + (float) (conto_77_).txy[i_83_] * this.m.sin(i_80_));
                for (int i_84_ = 0; i_84_ < 3; i_84_++) {
                    (this.t).c[(this.t).nt][i_84_] = (int) ((float) (conto_77_).tc[i_83_][i_84_] + (float) (conto_77_).tc[i_83_][i_84_] * ((float) (this.m).snap[i_84_] / 100.0F));
                    if ((this.t).c[(this.t).nt][i_84_] > 255)
                        (this.t).c[(this.t).nt][i_84_] = 255;
                    if ((this.t).c[(this.t).nt][i_84_] < 0)
                        (this.t).c[(this.t).nt][i_84_] = 0;
                }
                (this.t).x[(this.t).nt] = (int) ((float) this.x + (float) (conto_77_).tx[i_83_] * this.m.cos(i_80_) - (float) (conto_77_).tz[i_83_] * this.m.sin(i_80_));
                (this.t).z[(this.t).nt] = (int) ((float) this.z + (float) (conto_77_).tz[i_83_] * this.m.cos(i_80_) + (float) (conto_77_).tx[i_83_] * this.m.sin(i_80_));
                (this.t).y[(this.t).nt] = this.y + (conto_77_).ty[i_83_];
                (this.t).skd[(this.t).nt] = (conto_77_).skd[i_83_];
                (this.t).dam[(this.t).nt] = (conto_77_).dam[i_83_];
                (this.t).notwall[(this.t).nt] = (conto_77_).notwall[i_83_];
                if (this.decor)
                    (this.t).decor[(this.t).nt] = true;
                else
                    (this.t).decor[(this.t).nt] = false;
                int i_85_ = Math.abs(i_80_);
                if (i_85_ == 180)
                    i_85_ = 0;
                (this.t).radx[(this.t).nt] = (int) Math.abs((float) (conto_77_).tradx[i_83_] * this.m.cos(i_85_) + (float) (conto_77_).tradz[i_83_] * this.m.sin(i_85_));
                (this.t).radz[(this.t).nt] = (int) Math.abs((float) (conto_77_).tradx[i_83_] * this.m.sin(i_85_) + (float) (conto_77_).tradz[i_83_] * this.m.cos(i_85_));
                (this.t).rady[(this.t).nt] = (conto_77_).trady[i_83_];
                (this.t).nt++;
            }
        }
        for (int i_86_ = 0; i_86_ < 4; i_86_++) {
            this.keyx[i_86_] = (conto_77_).keyx[i_86_];
            this.keyz[i_86_] = (conto_77_).keyz[i_86_];
        }
        if (this.shadow) {
            this.stg = new int[20];
            this.sx = new int[20];
            this.sy = new int[20];
            this.sz = new int[20];
            this.scx = new int[20];
            this.scz = new int[20];
            this.osmag = new float[20];
            this.sav = new int[20];
            this.smag = new float[20][8];
            this.srgb = new int[20][3];
            this.sbln = new float[20];
            this.ust = 0;
            for (int i_87_ = 0; i_87_ < 20; i_87_++)
                this.stg[i_87_] = 0;
            this.rtg = new int[100];
            this.rbef = new boolean[100];
            this.rx = new int[100];
            this.ry = new int[100];
            this.rz = new int[100];
            this.vrx = new float[100];
            this.vry = new float[100];
            this.vrz = new float[100];
            for (int i_88_ = 0; i_88_ < 100; i_88_++)
                this.rtg[i_88_] = 0;
        }
    }
    
    public ContO(int i, int i_89_, int i_90_, Medium medium, Trackers trackers, int i_91_, int i_92_, int i_93_) {
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.sprkat = 0;
        this.tnt = 0;
        this.ust = 0;
        this.srx = 0;
        this.sry = 0;
        this.srz = 0;
        this.rcx = 0.0F;
        this.rcy = 0.0F;
        this.rcz = 0.0F;
        this.sprk = 0;
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[] { 0, 0, 0, 0 };
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.fcol = new int[] { 0, 0, 0 };
        this.scol = new int[] { 0, 0, 0 };
        this.colok = 0;
        this.errd = false;
        this.err = "";
        this.roofat = 0;
        this.wh = 0;
        this.m = medium;
        this.t = trackers;
        this.x = i_91_;
        this.z = i_92_;
        this.y = i_93_;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        this.grat = 0;
        this.sprkat = 0;
        this.disline = 4;
        this.noline = true;
        this.shadow = false;
        this.grounded = 115.0F;
        this.decor = true;
        this.npl = 5;
        this.p = new Plane[5];
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
        this.maxR = 0;
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
            if (i_102_ > this.maxR)
                this.maxR = i_102_;
            i_102_ = (int) Math.sqrt((double) (is_95_[i_99_] * is_95_[i_99_] + is_97_[i_99_] * is_97_[i_99_] + is_96_[i_99_] * is_96_[i_99_]));
            if (i_102_ > this.maxR)
                this.maxR = i_102_;
        }
        this.disp = this.maxR / 17;
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
                if ((this.m).trk == 2)
                    is_103_[i_112_] = (int) (390.0F / (2.2F + f - f_105_));
                else
                    is_103_[i_112_] = (int) ((float) ((this.m).cpol[i_112_] + (this.m).cgrnd[i_112_]) / (2.2F + f - f_105_));
            }
            this.p[i_106_] = new Plane(this.m, this.t, is_109_, is_111_, is_110_, 6, is_103_, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
        }
        f = (float) (0.02 * random.nextDouble());
        for (int i_113_ = 0; i_113_ < 3; i_113_++) {
            if ((this.m).trk == 2)
                is_103_[i_113_] = (int) (390.0F / (2.15F + f));
            else
                is_103_[i_113_] = (int) ((float) ((this.m).cpol[i_113_] + (this.m).cgrnd[i_113_]) / (2.15F + f));
        }
        this.p[4] = new Plane(this.m, this.t, is_95_, is_96_, is_97_, 8, is_103_, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
        int[] is_114_ = new int[2];
        int[] is_115_ = new int[2];
        for (int i_116_ = 0; i_116_ < 4; i_116_++) {
            int i_117_ = i_116_ * 2 + 1;
            (this.t).y[(this.t).nt] = is_97_[i_117_] / 2;
            (this.t).rady[(this.t).nt] = Math.abs(is_97_[i_117_] / 2);
            if (i_116_ == 0 || i_116_ == 2) {
                (this.t).z[(this.t).nt] = (is_94_[i_117_] + is_96_[i_117_]) / 2;
                (this.t).radz[(this.t).nt] = Math.abs((this.t).z[(this.t).nt] - is_94_[i_117_]);
                i_117_ = i_116_ * 2 + 2;
                if (i_117_ == 8)
                    i_117_ = 0;
                (this.t).x[(this.t).nt] = (is[i_116_ * 2] + is[i_117_]) / 2;
                (this.t).radx[(this.t).nt] = Math.abs((this.t).x[(this.t).nt] - is[i_116_ * 2]);
            } else {
                (this.t).x[(this.t).nt] = (is[i_117_] + is_95_[i_117_]) / 2;
                (this.t).radx[(this.t).nt] = Math.abs((this.t).x[(this.t).nt] - is[i_117_]);
                i_117_ = i_116_ * 2 + 2;
                if (i_117_ == 8)
                    i_117_ = 0;
                (this.t).z[(this.t).nt] = (is_94_[i_116_ * 2] + is_94_[i_117_]) / 2;
                (this.t).radz[(this.t).nt] = Math.abs((this.t).z[(this.t).nt] - is_94_[i_116_ * 2]);
            }
            if (i_116_ == 0) {
                is_115_[0] = (this.t).z[(this.t).nt] - (this.t).radz[(this.t).nt];
                (this.t).zy[(this.t).nt] = (int) (Math.atan((double) (this.t).rady[(this.t).nt] / (double) (this.t).radz[(this.t).nt]) / 0.017453292519943295);
                if ((this.t).zy[(this.t).nt] > 40)
                    (this.t).zy[(this.t).nt] = 40;
                (this.t).xy[(this.t).nt] = 0;
            }
            if (i_116_ == 1) {
                is_114_[0] = (this.t).x[(this.t).nt] - (this.t).radx[(this.t).nt];
                (this.t).xy[(this.t).nt] = (int) (Math.atan((double) (this.t).rady[(this.t).nt] / (double) (this.t).radx[(this.t).nt]) / 0.017453292519943295);
                if ((this.t).xy[(this.t).nt] > 40)
                    (this.t).xy[(this.t).nt] = 40;
                (this.t).zy[(this.t).nt] = 0;
            }
            if (i_116_ == 2) {
                is_115_[1] = (this.t).z[(this.t).nt] + (this.t).radz[(this.t).nt];
                (this.t).zy[(this.t).nt] = -(int) (Math.atan((double) (this.t).rady[(this.t).nt] / (double) (this.t).radz[(this.t).nt]) / 0.017453292519943295);
                if ((this.t).zy[(this.t).nt] < -40)
                    (this.t).zy[(this.t).nt] = -40;
                (this.t).xy[(this.t).nt] = 0;
            }
            if (i_116_ == 3) {
                is_114_[1] = (this.t).x[(this.t).nt] + (this.t).radx[(this.t).nt];
                (this.t).xy[(this.t).nt] = -(int) (Math.atan((double) (this.t).rady[(this.t).nt] / (double) (this.t).radx[(this.t).nt]) / 0.017453292519943295);
                if ((this.t).xy[(this.t).nt] < -40)
                    (this.t).xy[(this.t).nt] = -40;
                (this.t).zy[(this.t).nt] = 0;
            }
            (this.t).x[(this.t).nt] += this.x;
            (this.t).z[(this.t).nt] += this.z;
            (this.t).y[(this.t).nt] += this.y;
            for (int i_118_ = 0; i_118_ < 3; i_118_++)
                (this.t).c[(this.t).nt][i_118_] = (this.p[i_116_]).oc[i_118_];
            (this.t).skd[(this.t).nt] = 2;
            (this.t).dam[(this.t).nt] = 1;
            (this.t).notwall[(this.t).nt] = false;
            (this.t).decor[(this.t).nt] = true;
            (this.t).rady[(this.t).nt] += 10;
            (this.t).nt++;
        }
        (this.t).y[(this.t).nt] = 0;
        for (int i_119_ = 0; i_119_ < 8; i_119_++)
            (this.t).y[(this.t).nt] += is_97_[i_119_];
        (this.t).y[(this.t).nt] = (this.t).y[(this.t).nt] / 8;
        (this.t).y[(this.t).nt] += this.y;
        (this.t).rady[(this.t).nt] = 200;
        (this.t).radx[(this.t).nt] = is_114_[0] - is_114_[1];
        (this.t).radz[(this.t).nt] = is_115_[0] - is_115_[1];
        (this.t).x[(this.t).nt] = (is_114_[0] + is_114_[1]) / 2 + this.x;
        (this.t).z[(this.t).nt] = (is_115_[0] + is_115_[1]) / 2 + this.z;
        (this.t).zy[(this.t).nt] = 0;
        (this.t).xy[(this.t).nt] = 0;
        for (int i_120_ = 0; i_120_ < 3; i_120_++)
            (this.t).c[(this.t).nt][i_120_] = (this.p[4]).oc[i_120_];
        (this.t).skd[(this.t).nt] = 4;
        (this.t).dam[(this.t).nt] = 1;
        (this.t).notwall[(this.t).nt] = false;
        (this.t).decor[(this.t).nt] = true;
        (this.t).nt++;
    }
    
    public void d(Graphics2D graphics2d) {
        if (this.dist != 0)
            this.dist = 0;
        int i = (this.m).cx + (int) ((float) (this.x - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) (this.z - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
        int i_121_ = (this.m).cz + (int) ((float) (this.x - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) (this.z - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
        int i_122_ = (this.m).cz + (int) ((float) (this.y - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_121_ - (this.m).cz) * this.m.cos((this.m).zy));
        int i_123_ = xs(i + this.maxR, i_122_) - xs(i - this.maxR, i_122_);
        if (xs(i + this.maxR * 2, i_122_) > (this.m).iw && xs(i - this.maxR * 2, i_122_) < (this.m).w && i_122_ > -this.maxR && (i_122_ < (this.m).fade[this.disline] + this.maxR || (this.m).trk != 0) && (i_123_ > this.disp || (this.m).trk != 0) && (!this.decor || (this.m).resdown != 2 && (this.m).trk != 1)) {
            if (this.shadow) {
                if (!(this.m).crs) {
                    if (i_122_ < 2000) {
                        boolean bool = false;
                        if ((this.t).ncx != 0 || (this.t).ncz != 0) {
                            int i_124_ = (this.x - (this.t).sx) / 3000;
                            if (i_124_ > (this.t).ncx)
                                i_124_ = (this.t).ncx;
                            if (i_124_ < 0)
                                i_124_ = 0;
                            int i_125_ = (this.z - (this.t).sz) / 3000;
                            if (i_125_ > (this.t).ncz)
                                i_125_ = (this.t).ncz;
                            if (i_125_ < 0)
                                i_125_ = 0;
                            for (int i_126_ = (this.t).sect[i_124_][i_125_].length - 1; i_126_ >= 0; i_126_--) {
                                int i_127_ = (this.t).sect[i_124_][i_125_][i_126_];
                                if (Math.abs((this.t).zy[i_127_]) != 90 && Math.abs((this.t).xy[i_127_]) != 90 && Math.abs(this.x - (this.t).x[i_127_]) < (this.t).radx[i_127_] + this.maxR && Math.abs(this.z - (this.t).z[i_127_]) < (this.t).radz[i_127_] + this.maxR && (!(this.t).decor[i_127_] || (this.m).resdown != 2)) {
                                    bool = true;
                                    break;
                                }
                            }
                        }
                        if (bool) {
                            for (int i_128_ = 0; i_128_ < this.npl; i_128_++)
                                this.p[i_128_].s(graphics2d, this.x - (this.m).x, this.y - (this.m).y, this.z - (this.m).z, this.xz, this.xy, this.zy, 0);
                        } else {
                            int i_129_ = (this.m).cy + (int) ((float) ((this.m).ground - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_121_ - (this.m).cz) * this.m.sin((this.m).zy));
                            int i_130_ = (this.m).cz + (int) ((float) ((this.m).ground - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_121_ - (this.m).cz) * this.m.cos((this.m).zy));
                            if (ys(i_129_ + this.maxR, i_130_) > 0 && ys(i_129_ - this.maxR, i_130_) < (this.m).h) {
                                for (int i_131_ = 0; i_131_ < this.npl; i_131_++)
                                    this.p[i_131_].s(graphics2d, this.x - (this.m).x, this.y - (this.m).y, this.z - (this.m).z, this.xz, this.xy, this.zy, 1);
                            }
                        }
                        this.m.addsp(this.x - (this.m).x, this.z - (this.m).z, (int) ((double) this.maxR * 0.8));
                    } else
                        lowshadow(graphics2d, i_122_);
                } else {
                    for (int i_132_ = 0; i_132_ < this.npl; i_132_++)
                        this.p[i_132_].s(graphics2d, this.x - (this.m).x, this.y - (this.m).y, this.z - (this.m).z, this.xz, this.xy, this.zy, 2);
                }
            }
            int i_133_ = (this.m).cy + (int) ((float) (this.y - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_121_ - (this.m).cz) * this.m.sin((this.m).zy));
            if (ys(i_133_ + this.maxR, i_122_) > (this.m).ih && ys(i_133_ - this.maxR, i_122_) < (this.m).h) {
                if (this.elec && (this.m).noelec == 0)
                    electrify(graphics2d);
                if (this.fix)
                    fixit(graphics2d);
                if (this.checkpoint != 0 && this.checkpoint - 1 == (this.m).checkpoint)
                    i_123_ = -1;
                if (this.shadow) {
                    this.dist = (int) Math.sqrt((double) (((this.m).x + (this.m).cx - this.x) * ((this.m).x + (this.m).cx - this.x) + ((this.m).z - this.z) * ((this.m).z - this.z) + ((this.m).y + (this.m).cy - this.y) * ((this.m).y + (this.m).cy - this.y)));
                    for (int i_134_ = 0; i_134_ < 20; i_134_++) {
                        if (this.stg[i_134_] != 0)
                            pdust(i_134_, graphics2d, true);
                    }
                    dsprk(graphics2d, true);
                }
                int[] is = new int[this.npl];
                int[] is_135_ = new int[this.npl];
                for (int i_136_ = 0; i_136_ < this.npl; i_136_++)
                    is[i_136_] = 0;
                for (int i_137_ = 0; i_137_ < this.npl; i_137_++) {
                    for (int i_138_ = i_137_ + 1; i_138_ < this.npl; i_138_++) {
                        if ((this.p[i_137_]).av != (this.p[i_138_]).av) {
                            if ((this.p[i_137_]).av < (this.p[i_138_]).av)
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
                for (int i_139_ = 0; i_139_ < this.npl; i_139_++)
                    this.p[is_135_[i_139_]].d(graphics2d, this.x - (this.m).x, this.y - (this.m).y, this.z - (this.m).z, this.xz, this.xy, this.zy, this.wxz, this.wzy, this.noline, i_123_);
                if (this.shadow) {
                    for (int i_140_ = 0; i_140_ < 20; i_140_++) {
                        if (this.stg[i_140_] != 0)
                            pdust(i_140_, graphics2d, false);
                    }
                    dsprk(graphics2d, false);
                }
                this.dist = (int) (Math.sqrt((double) (int) Math.sqrt((double) (((this.m).x + (this.m).cx - this.x) * ((this.m).x + (this.m).cx - this.x) + ((this.m).z - this.z) * ((this.m).z - this.z) + ((this.m).y + (this.m).cy - this.y) * ((this.m).y + (this.m).cy - this.y)))) * (double) this.grounded);
            }
        }
        if (this.shadow && this.dist == 0) {
            for (int i_141_ = 0; i_141_ < 20; i_141_++) {
                if (this.stg[i_141_] != 0)
                    this.stg[i_141_] = 0;
            }
            for (int i_142_ = 0; i_142_ < 100; i_142_++) {
                if (this.rtg[i_142_] != 0)
                    this.rtg[i_142_] = 0;
            }
            if (this.sprk != 0)
                this.sprk = 0;
        }
    }
    
    public void lowshadow(Graphics2D graphics2d, int i) {
        int[] is = new int[4];
        int[] is_143_ = new int[4];
        int[] is_144_ = new int[4];
        int i_145_ = 1;
        int i_146_;
        for (i_146_ = Math.abs(this.zy); i_146_ > 270; i_146_ -= 360) {
            /* empty */
        }
        i_146_ = Math.abs(i_146_);
        if (i_146_ > 90)
            i_145_ = -1;
        is[0] = (int) ((double) this.keyx[0] * 1.2 + (double) this.x - (double) (this.m).x);
        is_144_[0] = (int) ((double) ((this.keyz[0] + 30) * i_145_) * 1.2 + (double) this.z - (double) (this.m).z);
        is[1] = (int) ((double) this.keyx[1] * 1.2 + (double) this.x - (double) (this.m).x);
        is_144_[1] = (int) ((double) ((this.keyz[1] + 30) * i_145_) * 1.2 + (double) this.z - (double) (this.m).z);
        is[2] = (int) ((double) this.keyx[3] * 1.2 + (double) this.x - (double) (this.m).x);
        is_144_[2] = (int) ((double) ((this.keyz[3] - 30) * i_145_) * 1.2 + (double) this.z - (double) (this.m).z);
        is[3] = (int) ((double) this.keyx[2] * 1.2 + (double) this.x - (double) (this.m).x);
        is_144_[3] = (int) ((double) ((this.keyz[2] - 30) * i_145_) * 1.2 + (double) this.z - (double) (this.m).z);
        rot(is, is_144_, this.x - (this.m).x, this.z - (this.m).z, this.xz, 4);
        int i_147_ = (int) ((double) (float) (this.m).crgrnd[0] / 1.5);
        int i_148_ = (int) ((double) (float) (this.m).crgrnd[1] / 1.5);
        int i_149_ = (int) ((double) (float) (this.m).crgrnd[2] / 1.5);
        for (int i_150_ = 0; i_150_ < 4; i_150_++)
            is_143_[i_150_] = (this.m).ground;
        if ((this.t).ncx != 0 || (this.t).ncz != 0) {
            int i_151_ = (this.x - (this.t).sx) / 3000;
            if (i_151_ > (this.t).ncx)
                i_151_ = (this.t).ncx;
            if (i_151_ < 0)
                i_151_ = 0;
            int i_152_ = (this.z - (this.t).sz) / 3000;
            if (i_152_ > (this.t).ncz)
                i_152_ = (this.t).ncz;
            if (i_152_ < 0)
                i_152_ = 0;
            for (int i_153_ = (this.t).sect[i_151_][i_152_].length - 1; i_153_ >= 0; i_153_--) {
                int i_154_ = (this.t).sect[i_151_][i_152_][i_153_];
                int i_155_ = 0;
                for (int i_156_ = 0; i_156_ < 4; i_156_++) {
                    if (Math.abs((this.t).zy[i_154_]) != 90 && Math.abs((this.t).xy[i_154_]) != 90 && (this.t).rady[i_154_] != 801 && Math.abs(is[i_156_] - ((this.t).x[i_154_] - (this.m).x)) < (this.t).radx[i_154_] && Math.abs(is_144_[i_156_] - ((this.t).z[i_154_] - (this.m).z)) < (this.t).radz[i_154_] && (!(this.t).decor[i_154_] || (this.m).resdown != 2))
                        i_155_++;
                }
                if (i_155_ > 2) {
                    for (int i_157_ = 0; i_157_ < 4; i_157_++) {
                        is_143_[i_157_] = (this.t).y[i_154_] - (this.m).y;
                        if ((this.t).zy[i_154_] != 0)
                            is_143_[i_157_] += (float) (is_144_[i_157_] - ((this.t).z[i_154_] - (this.m).z - (this.t).radz[i_154_])) * this.m.sin((this.t).zy[i_154_]) / this.m.sin(90 - (this.t).zy[i_154_]) - (float) (this.t).radz[i_154_] * this.m.sin((this.t).zy[i_154_]) / this.m.sin(90 - (this.t).zy[i_154_]);
                        if ((this.t).xy[i_154_] != 0)
                            is_143_[i_157_] += (float) (is[i_157_] - ((this.t).x[i_154_] - (this.m).x - (this.t).radx[i_154_])) * this.m.sin((this.t).xy[i_154_]) / this.m.sin(90 - (this.t).xy[i_154_]) - (float) (this.t).radx[i_154_] * this.m.sin((this.t).xy[i_154_]) / this.m.sin(90 - (this.t).xy[i_154_]);
                    }
                    i_147_ = (int) ((double) (float) (this.t).c[i_154_][0] / 1.5);
                    i_148_ = (int) ((double) (float) (this.t).c[i_154_][1] / 1.5);
                    i_149_ = (int) ((double) (float) (this.t).c[i_154_][2] / 1.5);
                    break;
                }
            }
        }
        rot(is, is_144_, (this.m).cx, (this.m).cz, (this.m).xz, 4);
        rot(is_143_, is_144_, (this.m).cy, (this.m).cz, (this.m).zy, 4);
        boolean bool = true;
        int i_158_ = 0;
        int i_159_ = 0;
        int i_160_ = 0;
        int i_161_ = 0;
        for (int i_162_ = 0; i_162_ < 4; i_162_++) {
            is[i_162_] = xs(is[i_162_], is_144_[i_162_]);
            is_143_[i_162_] = ys(is_143_[i_162_], is_144_[i_162_]);
            if (is_143_[i_162_] < (this.m).ih || is_144_[i_162_] < 10)
                i_158_++;
            if (is_143_[i_162_] > (this.m).h || is_144_[i_162_] < 10)
                i_159_++;
            if (is[i_162_] < (this.m).iw || is_144_[i_162_] < 10)
                i_160_++;
            if (is[i_162_] > (this.m).w || is_144_[i_162_] < 10)
                i_161_++;
        }
        if (i_160_ == 4 || i_158_ == 4 || i_159_ == 4 || i_161_ == 4)
            bool = false;
        if (bool) {
            for (int i_163_ = 0; i_163_ < 16; i_163_++) {
                if (i > (this.m).fade[i_163_]) {
                    i_147_ = (i_147_ * (this.m).fogd + (this.m).cfade[0]) / ((this.m).fogd + 1);
                    i_148_ = (i_148_ * (this.m).fogd + (this.m).cfade[1]) / ((this.m).fogd + 1);
                    i_149_ = (i_149_ * (this.m).fogd + (this.m).cfade[2]) / ((this.m).fogd + 1);
                }
            }
            graphics2d.setColor(new Color(i_147_, i_148_, i_149_));
            graphics2d.fillPolygon(is, is_143_, 4);
        }
    }
    
    public void fixit(Graphics2D graphics2d) {
        if (this.fcnt == 1) {
            for (int i = 0; i < this.npl; i++) {
                (this.p[i]).hsb[0] = 0.57F;
                (this.p[i]).hsb[2] = 0.8F;
                (this.p[i]).hsb[1] = 0.8F;
                Color color = Color.getHSBColor((this.p[i]).hsb[0], (this.p[i]).hsb[1], (this.p[i]).hsb[2]);
                int i_164_ = (int) ((float) color.getRed() + (float) color.getRed() * ((float) (this.m).snap[0] / 100.0F));
                if (i_164_ > 255)
                    i_164_ = 255;
                if (i_164_ < 0)
                    i_164_ = 0;
                int i_165_ = (int) ((float) color.getGreen() + (float) color.getGreen() * ((float) (this.m).snap[1] / 100.0F));
                if (i_165_ > 255)
                    i_165_ = 255;
                if (i_165_ < 0)
                    i_165_ = 0;
                int i_166_ = (int) ((float) color.getBlue() + (float) color.getBlue() * ((float) (this.m).snap[2] / 100.0F));
                if (i_166_ > 255)
                    i_166_ = 255;
                if (i_166_ < 0)
                    i_166_ = 0;
                Color.RGBtoHSB(i_164_, i_165_, i_166_, (this.p[i]).hsb);
                (this.p[i]).flx = 1;
            }
        }
        if (this.fcnt == 2) {
            for (int i = 0; i < this.npl; i++)
                (this.p[i]).flx = 1;
        }
        if (this.fcnt == 4) {
            for (int i = 0; i < this.npl; i++)
                (this.p[i]).flx = 3;
        }
        if ((this.fcnt == 1 || this.fcnt > 2) && this.fcnt != 9) {
            int[] is = new int[8];
            int[] is_167_ = new int[8];
            int[] is_168_ = new int[4];
            for (int i = 0; i < 4; i++) {
                is[i] = this.keyx[i] + this.x - (this.m).x;
                is_167_[i] = this.grat + this.y - (this.m).y;
                is_168_[i] = this.keyz[i] + this.z - (this.m).z;
            }
            rot(is, is_167_, this.x - (this.m).x, this.y - (this.m).y, this.xy, 4);
            rot(is_167_, is_168_, this.y - (this.m).y, this.z - (this.m).y, this.zy, 4);
            rot(is, is_168_, this.x - (this.m).x, this.z - (this.m).z, this.xz, 4);
            rot(is, is_168_, (this.m).cx, (this.m).cz, (this.m).xz, 4);
            rot(is_167_, is_168_, (this.m).cy, (this.m).cz, (this.m).zy, 4);
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
            int i_173_ = (this.m).cx + (int) ((float) (this.x - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) (this.z - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
            int i_174_ = (this.m).cz + (int) ((float) (this.x - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) (this.z - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
            int i_175_ = (this.m).cy + (int) ((float) (this.y - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_174_ - (this.m).cz) * this.m.sin((this.m).zy));
            i_174_ = (this.m).cz + (int) ((float) (this.y - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_174_ - (this.m).cz) * this.m.cos((this.m).zy));
            is[0] = xs((int) ((double) i_173_ - (double) i / 0.8 - (double) this.m.random() * ((double) i / 2.4)), i_174_);
            is_167_[0] = ys((int) ((double) i_175_ - (double) i_169_ / 1.92 - (double) this.m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[1] = xs((int) ((double) i_173_ - (double) i / 0.8 - (double) this.m.random() * ((double) i / 2.4)), i_174_);
            is_167_[1] = ys((int) ((double) i_175_ + (double) i_169_ / 1.92 + (double) this.m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[2] = xs((int) ((double) i_173_ - (double) i / 1.92 - (double) this.m.random() * ((double) i / 5.67)), i_174_);
            is_167_[2] = ys((int) ((double) i_175_ + (double) i_169_ / 0.8 + (double) this.m.random() * ((double) i_169_ / 2.4)), i_174_);
            is[3] = xs((int) ((double) i_173_ + (double) i / 1.92 + (double) this.m.random() * ((double) i / 5.67)), i_174_);
            is_167_[3] = ys((int) ((double) i_175_ + (double) i_169_ / 0.8 + (double) this.m.random() * ((double) i_169_ / 2.4)), i_174_);
            is[4] = xs((int) ((double) i_173_ + (double) i / 0.8 + (double) this.m.random() * ((double) i / 2.4)), i_174_);
            is_167_[4] = ys((int) ((double) i_175_ + (double) i_169_ / 1.92 + (double) this.m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[5] = xs((int) ((double) i_173_ + (double) i / 0.8 + (double) this.m.random() * ((double) i / 2.4)), i_174_);
            is_167_[5] = ys((int) ((double) i_175_ - (double) i_169_ / 1.92 - (double) this.m.random() * ((double) i_169_ / 5.67)), i_174_);
            is[6] = xs((int) ((double) i_173_ + (double) i / 1.92 + (double) this.m.random() * ((double) i / 5.67)), i_174_);
            is_167_[6] = ys((int) ((double) i_175_ - (double) i_169_ / 0.8 - (double) this.m.random() * ((double) i_169_ / 2.4)), i_174_);
            is[7] = xs((int) ((double) i_173_ - (double) i / 1.92 - (double) this.m.random() * ((double) i / 5.67)), i_174_);
            is_167_[7] = ys((int) ((double) i_175_ - (double) i_169_ / 0.8 - (double) this.m.random() * ((double) i_169_ / 2.4)), i_174_);
            if (this.fcnt == 3)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), 22, 8);
            if (this.fcnt == 4)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), 22, 8);
            if (this.fcnt == 5)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), 0, 8);
            if (this.fcnt == 6)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), -22, 8);
            if (this.fcnt == 7)
                rot(is, is_167_, xs(i_173_, i_174_), ys(i_175_, i_174_), -22, 8);
            int i_176_ = (int) (191.0F + 191.0F * ((float) (this.m).snap[0] / 350.0F));
            if (i_176_ > 255)
                i_176_ = 255;
            if (i_176_ < 0)
                i_176_ = 0;
            int i_177_ = (int) (232.0F + 232.0F * ((float) (this.m).snap[1] / 350.0F));
            if (i_177_ > 255)
                i_177_ = 255;
            if (i_177_ < 0)
                i_177_ = 0;
            int i_178_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 350.0F));
            if (i_178_ > 255)
                i_178_ = 255;
            if (i_178_ < 0)
                i_178_ = 0;
            graphics2d.setColor(new Color(i_176_, i_177_, i_178_));
            graphics2d.fillPolygon(is, is_167_, 8);
            is[0] = xs((int) ((float) (i_173_ - i) - this.m.random() * (float) (i / 4)), i_174_);
            is_167_[0] = ys((int) ((double) i_175_ - (double) i_169_ / 2.4 - (double) this.m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[1] = xs((int) ((float) (i_173_ - i) - this.m.random() * (float) (i / 4)), i_174_);
            is_167_[1] = ys((int) ((double) i_175_ + (double) i_169_ / 2.4 + (double) this.m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[2] = xs((int) ((double) i_173_ - (double) i / 2.4 - (double) this.m.random() * ((double) i / 9.6)), i_174_);
            is_167_[2] = ys((int) ((float) (i_175_ + i_169_) + this.m.random() * (float) (i_169_ / 4)), i_174_);
            is[3] = xs((int) ((double) i_173_ + (double) i / 2.4 + (double) this.m.random() * ((double) i / 9.6)), i_174_);
            is_167_[3] = ys((int) ((float) (i_175_ + i_169_) + this.m.random() * (float) (i_169_ / 4)), i_174_);
            is[4] = xs((int) ((float) (i_173_ + i) + this.m.random() * (float) (i / 4)), i_174_);
            is_167_[4] = ys((int) ((double) i_175_ + (double) i_169_ / 2.4 + (double) this.m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[5] = xs((int) ((float) (i_173_ + i) + this.m.random() * (float) (i / 4)), i_174_);
            is_167_[5] = ys((int) ((double) i_175_ - (double) i_169_ / 2.4 - (double) this.m.random() * ((double) i_169_ / 9.6)), i_174_);
            is[6] = xs((int) ((double) i_173_ + (double) i / 2.4 + (double) this.m.random() * ((double) i / 9.6)), i_174_);
            is_167_[6] = ys((int) ((float) (i_175_ - i_169_) - this.m.random() * (float) (i_169_ / 4)), i_174_);
            is[7] = xs((int) ((double) i_173_ - (double) i / 2.4 - (double) this.m.random() * ((double) i / 9.6)), i_174_);
            is_167_[7] = ys((int) ((float) (i_175_ - i_169_) - this.m.random() * (float) (i_169_ / 4)), i_174_);
            i_176_ = (int) (213.0F + 213.0F * ((float) (this.m).snap[0] / 350.0F));
            if (i_176_ > 255)
                i_176_ = 255;
            if (i_176_ < 0)
                i_176_ = 0;
            i_177_ = (int) (239.0F + 239.0F * ((float) (this.m).snap[1] / 350.0F));
            if (i_177_ > 255)
                i_177_ = 255;
            if (i_177_ < 0)
                i_177_ = 0;
            i_178_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 350.0F));
            if (i_178_ > 255)
                i_178_ = 255;
            if (i_178_ < 0)
                i_178_ = 0;
            graphics2d.setColor(new Color(i_176_, i_177_, i_178_));
            graphics2d.fillPolygon(is, is_167_, 8);
        }
        if (this.fcnt > 7) {
            this.fcnt = 0;
            this.fix = false;
        } else
            this.fcnt++;
    }
    
    public void electrify(Graphics2D graphics2d) {
        for (int i = 0; i < 4; i++) {
            if (this.elc[i] == 0) {
                this.edl[i] = (int) (380.0F - this.m.random() * 760.0F);
                this.edr[i] = (int) (380.0F - this.m.random() * 760.0F);
                this.elc[i] = 1;
            }
            int i_179_ = (int) ((float) this.edl[i] + (190.0F - this.m.random() * 380.0F));
            int i_180_ = (int) ((float) this.edr[i] + (190.0F - this.m.random() * 380.0F));
            int i_181_ = (int) (this.m.random() * 126.0F);
            int i_182_ = (int) (this.m.random() * 126.0F);
            int[] is = new int[8];
            int[] is_183_ = new int[8];
            int[] is_184_ = new int[8];
            for (int i_185_ = 0; i_185_ < 8; i_185_++)
                is_184_[i_185_] = this.z - (this.m).z;
            is[0] = this.x - (this.m).x - 504;
            is_183_[0] = this.y - (this.m).y - this.edl[i] - 5 - (int) (this.m.random() * 5.0F);
            is[1] = this.x - (this.m).x - 252 + i_182_;
            is_183_[1] = this.y - (this.m).y - i_179_ - 5 - (int) (this.m.random() * 5.0F);
            is[2] = this.x - (this.m).x + 252 - i_181_;
            is_183_[2] = this.y - (this.m).y - i_180_ - 5 - (int) (this.m.random() * 5.0F);
            is[3] = this.x - (this.m).x + 504;
            is_183_[3] = this.y - (this.m).y - this.edr[i] - 5 - (int) (this.m.random() * 5.0F);
            is[4] = this.x - (this.m).x + 504;
            is_183_[4] = this.y - (this.m).y - this.edr[i] + 5 + (int) (this.m.random() * 5.0F);
            is[5] = this.x - (this.m).x + 252 - i_181_;
            is_183_[5] = this.y - (this.m).y - i_180_ + 5 + (int) (this.m.random() * 5.0F);
            is[6] = this.x - (this.m).x - 252 + i_182_;
            is_183_[6] = this.y - (this.m).y - i_179_ + 5 + (int) (this.m.random() * 5.0F);
            is[7] = this.x - (this.m).x - 504;
            is_183_[7] = this.y - (this.m).y - this.edl[i] + 5 + (int) (this.m.random() * 5.0F);
            if (this.roted)
                rot(is, is_184_, this.x - (this.m).x, this.z - (this.m).z, 90, 8);
            rot(is, is_184_, (this.m).cx, (this.m).cz, (this.m).xz, 8);
            rot(is_183_, is_184_, (this.m).cy, (this.m).cz, (this.m).zy, 8);
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
                if (is_191_[i_192_] < (this.m).ih || is_184_[i_192_] < 10)
                    i_186_++;
                if (is_191_[i_192_] > (this.m).h || is_184_[i_192_] < 10)
                    i_187_++;
                if (is_190_[i_192_] < (this.m).iw || is_184_[i_192_] < 10)
                    i_188_++;
                if (is_190_[i_192_] > (this.m).w || is_184_[i_192_] < 10)
                    i_189_++;
            }
            if (i_188_ == 8 || i_186_ == 8 || i_187_ == 8 || i_189_ == 8)
                bool = false;
            if (bool) {
                int i_193_ = (int) (160.0F + 160.0F * ((float) (this.m).snap[0] / 500.0F));
                if (i_193_ > 255)
                    i_193_ = 255;
                if (i_193_ < 0)
                    i_193_ = 0;
                int i_194_ = (int) (238.0F + 238.0F * ((float) (this.m).snap[1] / 500.0F));
                if (i_194_ > 255)
                    i_194_ = 255;
                if (i_194_ < 0)
                    i_194_ = 0;
                int i_195_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 500.0F));
                if (i_195_ > 255)
                    i_195_ = 255;
                if (i_195_ < 0)
                    i_195_ = 0;
                i_193_ = (i_193_ * 2 + 214 * (this.elc[i] - 1)) / (this.elc[i] + 1);
                i_194_ = (i_194_ * 2 + 236 * (this.elc[i] - 1)) / (this.elc[i] + 1);
                if ((this.m).trk == 1) {
                    i_193_ = 255;
                    i_194_ = 128;
                    i_195_ = 0;
                }
                graphics2d.setColor(new Color(i_193_, i_194_, i_195_));
                graphics2d.fillPolygon(is_190_, is_191_, 8);
                if (is_184_[0] < 4000) {
                    i_193_ = (int) (150.0F + 150.0F * ((float) (this.m).snap[0] / 500.0F));
                    if (i_193_ > 255)
                        i_193_ = 255;
                    if (i_193_ < 0)
                        i_193_ = 0;
                    i_194_ = (int) (227.0F + 227.0F * ((float) (this.m).snap[1] / 500.0F));
                    if (i_194_ > 255)
                        i_194_ = 255;
                    if (i_194_ < 0)
                        i_194_ = 0;
                    i_195_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 500.0F));
                    if (i_195_ > 255)
                        i_195_ = 255;
                    if (i_195_ < 0)
                        i_195_ = 0;
                    graphics2d.setColor(new Color(i_193_, i_194_, i_195_));
                    graphics2d.drawPolygon(is_190_, is_191_, 8);
                }
            }
            if ((float) this.elc[i] > this.m.random() * 60.0F)
                this.elc[i] = 0;
            else
                this.elc[i]++;
        }
        if (!this.roted || this.xz != 0) {
            this.xy += 11;
            if (this.xy > 360)
                this.xy -= 360;
        } else {
            this.zy += 11;
            if (this.zy > 360)
                this.zy -= 360;
        }
    }
    
    public void dust(int i, float f, float f_196_, float f_197_, int i_198_, int i_199_, float f_200_, int i_201_, boolean bool) {}
    
    public void pdust(int i, Graphics2D graphics2d, boolean bool) {
        if (bool)
            this.sav[i] = (int) Math.sqrt((double) (((this.m).x + (this.m).cx - this.sx[i]) * ((this.m).x + (this.m).cx - this.sx[i]) + ((this.m).y + (this.m).cy - this.sy[i]) * ((this.m).y + (this.m).cy - this.sy[i]) + ((this.m).z - this.sz[i]) * ((this.m).z - this.sz[i])));
        if (bool && this.sav[i] > this.dist || !bool && this.sav[i] <= this.dist) {
            if (this.stg[i] == 1) {
                this.sbln[i] = 0.6F;
                boolean bool_205_ = false;
                int[] is = new int[3];
                for (int i_206_ = 0; i_206_ < 3; i_206_++) {
                    is[i_206_] = (int) (255.0F + 255.0F * ((float) (this.m).snap[i_206_] / 100.0F));
                    if (is[i_206_] > 255)
                        is[i_206_] = 255;
                    if (is[i_206_] < 0)
                        is[i_206_] = 0;
                }
                int i_207_ = (this.x - (this.t).sx) / 3000;
                if (i_207_ > (this.t).ncx)
                    i_207_ = (this.t).ncx;
                if (i_207_ < 0)
                    i_207_ = 0;
                int i_208_ = (this.z - (this.t).sz) / 3000;
                if (i_208_ > (this.t).ncz)
                    i_208_ = (this.t).ncz;
                if (i_208_ < 0)
                    i_208_ = 0;
                for (int i_209_ = 0; i_209_ < (this.t).sect[i_207_][i_208_].length; i_209_++) {
                    int i_210_ = (this.t).sect[i_207_][i_208_][i_209_];
                    if (Math.abs((this.t).zy[i_210_]) != 90 && Math.abs((this.t).xy[i_210_]) != 90 && Math.abs(this.sx[i] - (this.t).x[i_210_]) < (this.t).radx[i_210_] && Math.abs(this.sz[i] - (this.t).z[i_210_]) < (this.t).radz[i_210_]) {
                        if ((this.t).skd[i_210_] == 0)
                            this.sbln[i] = 0.2F;
                        if ((this.t).skd[i_210_] == 1)
                            this.sbln[i] = 0.4F;
                        if ((this.t).skd[i_210_] == 2)
                            this.sbln[i] = 0.45F;
                        for (int i_211_ = 0; i_211_ < 3; i_211_++)
                            this.srgb[i][i_211_] = ((this.t).c[i_210_][i_211_] + is[i_211_]) / 2;
                        bool_205_ = true;
                    }
                }
                if (!bool_205_) {
                    for (int i_212_ = 0; i_212_ < 3; i_212_++)
                        this.srgb[i][i_212_] = ((this.m).crgrnd[i_212_] + is[i_212_]) / 2;
                }
                float f = (float) (0.1 + (double) this.m.random());
                if (f > 1.0F)
                    f = 1.0F;
                this.scx[i] = (int) ((float) this.scx[i] * f);
                this.scz[i] = (int) ((float) this.scx[i] * f);
                for (int i_213_ = 0; i_213_ < 8; i_213_++)
                    this.smag[i][i_213_] = this.osmag[i] * this.m.random() * 50.0F;
                for (int i_214_ = 0; i_214_ < 8; i_214_++) {
                    int i_215_ = i_214_ - 1;
                    if (i_215_ == -1)
                        i_215_ = 7;
                    int i_216_ = i_214_ + 1;
                    if (i_216_ == 8)
                        i_216_ = 0;
                    this.smag[i][i_214_] = ((this.smag[i][i_215_] + this.smag[i][i_216_]) / 2.0F + this.smag[i][i_214_]) / 2.0F;
                }
                this.smag[i][6] = this.smag[i][7];
            }
            int i_217_ = (this.m).cx + (int) ((float) (this.sx[i] - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) (this.sz[i] - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
            int i_218_ = (this.m).cz + (int) ((float) (this.sx[i] - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) (this.sz[i] - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
            int i_219_ = (this.m).cy + (int) (((float) (this.sy[i] - (this.m).y - (this.m).cy) - this.smag[i][7]) * this.m.cos((this.m).zy) - (float) (i_218_ - (this.m).cz) * this.m.sin((this.m).zy));
            i_218_ = (this.m).cz + (int) (((float) (this.sy[i] - (this.m).y - (this.m).cy) - this.smag[i][7]) * this.m.sin((this.m).zy) + (float) (i_218_ - (this.m).cz) * this.m.cos((this.m).zy));
            this.sx[i] += this.scx[i] / (this.stg[i] + 1);
            this.sz[i] += this.scz[i] / (this.stg[i] + 1);
            int[] is = new int[8];
            int[] is_220_ = new int[8];
            is[0] = xs((int) ((float) i_217_ + this.smag[i][0] * 0.9238F * 1.5F), i_218_);
            is_220_[0] = ys((int) ((float) i_219_ + this.smag[i][0] * 0.3826F * 1.5F), i_218_);
            is[1] = xs((int) ((float) i_217_ + this.smag[i][1] * 0.9238F * 1.5F), i_218_);
            is_220_[1] = ys((int) ((float) i_219_ - this.smag[i][1] * 0.3826F * 1.5F), i_218_);
            is[2] = xs((int) ((float) i_217_ + this.smag[i][2] * 0.3826F), i_218_);
            is_220_[2] = ys((int) ((float) i_219_ - this.smag[i][2] * 0.9238F), i_218_);
            is[3] = xs((int) ((float) i_217_ - this.smag[i][3] * 0.3826F), i_218_);
            is_220_[3] = ys((int) ((float) i_219_ - this.smag[i][3] * 0.9238F), i_218_);
            is[4] = xs((int) ((float) i_217_ - this.smag[i][4] * 0.9238F * 1.5F), i_218_);
            is_220_[4] = ys((int) ((float) i_219_ - this.smag[i][4] * 0.3826F * 1.5F), i_218_);
            is[5] = xs((int) ((float) i_217_ - this.smag[i][5] * 0.9238F * 1.5F), i_218_);
            is_220_[5] = ys((int) ((float) i_219_ + this.smag[i][5] * 0.3826F * 1.5F), i_218_);
            is[6] = xs((int) ((float) i_217_ - this.smag[i][6] * 0.3826F * 1.7F), i_218_);
            is_220_[6] = ys((int) ((float) i_219_ + this.smag[i][6] * 0.9238F), i_218_);
            is[7] = xs((int) ((float) i_217_ + this.smag[i][7] * 0.3826F * 1.7F), i_218_);
            is_220_[7] = ys((int) ((float) i_219_ + this.smag[i][7] * 0.9238F), i_218_);
            for (int i_221_ = 0; i_221_ < 7; i_221_++)
                this.smag[i][i_221_] += 5.0F + this.m.random() * 15.0F;
            this.smag[i][7] = this.smag[i][6];
            boolean bool_222_ = true;
            int i_223_ = 0;
            int i_224_ = 0;
            int i_225_ = 0;
            int i_226_ = 0;
            for (int i_227_ = 0; i_227_ < 8; i_227_++) {
                if (is_220_[i_227_] < (this.m).ih || i_218_ < 10)
                    i_223_++;
                if (is_220_[i_227_] > (this.m).h || i_218_ < 10)
                    i_224_++;
                if (is[i_227_] < (this.m).iw || i_218_ < 10)
                    i_225_++;
                if (is[i_227_] > (this.m).w || i_218_ < 10)
                    i_226_++;
            }
            if (i_225_ == 4 || i_223_ == 4 || i_224_ == 4 || i_226_ == 4)
                bool_222_ = false;
            if (bool_222_) {
                int i_228_ = this.srgb[i][0];
                int i_229_ = this.srgb[i][1];
                int i_230_ = this.srgb[i][2];
                for (int i_231_ = 0; i_231_ < 16; i_231_++) {
                    if (this.sav[i] > (this.m).fade[i_231_]) {
                        i_228_ = (i_228_ * (this.m).fogd + (this.m).cfade[0]) / ((this.m).fogd + 1);
                        i_229_ = (i_229_ * (this.m).fogd + (this.m).cfade[1]) / ((this.m).fogd + 1);
                        i_230_ = (i_230_ * (this.m).fogd + (this.m).cfade[2]) / ((this.m).fogd + 1);
                    }
                }
                graphics2d.setColor(new Color(i_228_, i_229_, i_230_));
                float f = this.sbln[i] - (float) this.stg[i] * (this.sbln[i] / 8.0F);
                graphics2d.setComposite(AlphaComposite.getInstance(3, f));
                graphics2d.fillPolygon(is, is_220_, 8);
                graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }
            if (this.stg[i] == 7)
                this.stg[i] = 0;
            else
                this.stg[i]++;
        }
    }
    
    public void sprk(float f, float f_232_, float f_233_, float f_234_, float f_235_, float f_236_, int i) {
        if (i != 1) {
            this.srx = (int) (f - (float) this.sprkat * this.m.sin(this.xz));
            this.sry = (int) (f_232_ - (float) this.sprkat * this.m.cos(this.zy) * this.m.cos(this.xy));
            this.srz = (int) (f_233_ + (float) this.sprkat * this.m.cos(this.xz));
            this.sprk = 1;
        } else {
            this.sprk++;
            if (this.sprk == 4) {
                this.srx = (int) ((float) this.x + f_234_);
                this.sry = (int) f_232_;
                this.srz = (int) ((float) this.z + f_236_);
                this.sprk = 5;
            } else {
                this.srx = (int) f;
                this.sry = (int) f_232_;
                this.srz = (int) f_233_;
            }
        }
        if (i == 2)
            this.sprk = 6;
        this.rcx = f_234_;
        this.rcy = f_235_;
        this.rcz = f_236_;
    }
    
    public void dsprk(Graphics2D graphics2d, boolean bool) {
        if (bool && this.sprk != 0) {
            int i = (int) (Math.sqrt((double) (this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz)) / 10.0);
            if (i > 5) {
                boolean bool_237_ = false;
                if ((double) this.dist < Math.sqrt((double) (((this.m).x + (this.m).cx - this.srx) * ((this.m).x + (this.m).cx - this.srx) + ((this.m).y + (this.m).cy - this.sry) * ((this.m).y + (this.m).cy - this.sry) + ((this.m).z - this.srz) * ((this.m).z - this.srz))))
                    bool_237_ = true;
                if (i > 33)
                    i = 33;
                int i_238_ = 0;
                for (int i_239_ = 0; i_239_ < 100; i_239_++) {
                    if (this.rtg[i_239_] == 0) {
                        this.rtg[i_239_] = 1;
                        this.rbef[i_239_] = bool_237_;
                        i_238_++;
                    }
                    if (i_238_ == i)
                        break;
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (this.rtg[i] != 0 && (this.rbef[i] && bool || !this.rbef[i] && !bool)) {
                if (this.rtg[i] == 1) {
                    if (this.sprk < 5) {
                        this.rx[i] = this.srx + 3 - (int) ((double) this.m.random() * 6.7);
                        this.ry[i] = this.sry + 3 - (int) ((double) this.m.random() * 6.7);
                        this.rz[i] = this.srz + 3 - (int) ((double) this.m.random() * 6.7);
                    } else {
                        this.rx[i] = this.srx + 10 - (int) (this.m.random() * 20.0F);
                        this.ry[i] = this.sry - (int) (this.m.random() * 4.0F);
                        this.rz[i] = this.srz + 10 - (int) (this.m.random() * 20.0F);
                    }
                    int i_240_ = (int) Math.sqrt((double) (this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz));
                    float f = 0.2F + 0.4F * this.m.random();
                    float f_241_ = this.m.random() * this.m.random() * this.m.random();
                    float f_242_ = 1.0F;
                    if (this.m.random() > this.m.random()) {
                        if (this.m.random() > this.m.random())
                            f_242_ *= -1.0F;
                        this.vrx[i] = -((this.rcx + (float) i_240_ * (1.0F - this.rcx / (float) i_240_) * f_241_ * f_242_) * f);
                    }
                    if (this.m.random() > this.m.random()) {
                        if (this.m.random() > this.m.random())
                            f_242_ *= -1.0F;
                        if (this.sprk == 5)
                            f_242_ = 1.0F;
                        this.vry[i] = -((this.rcy + (float) i_240_ * (1.0F - this.rcy / (float) i_240_) * f_241_ * f_242_) * f);
                    }
                    if (this.m.random() > this.m.random()) {
                        if (this.m.random() > this.m.random())
                            f_242_ *= -1.0F;
                        this.vrz[i] = -((this.rcz + (float) i_240_ * (1.0F - this.rcz / (float) i_240_) * f_241_ * f_242_) * f);
                    }
                }
                this.rx[i] += this.vrx[i];
                this.ry[i] += this.vry[i];
                this.rz[i] += this.vrz[i];
                int i_243_ = (this.m).cx + (int) ((float) (this.rx[i] - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) (this.rz[i] - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
                int i_244_ = (this.m).cz + (int) ((float) (this.rx[i] - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) (this.rz[i] - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
                int i_245_ = (this.m).cy + (int) ((float) (this.ry[i] - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_244_ - (this.m).cz) * this.m.sin((this.m).zy));
                i_244_ = (this.m).cz + (int) ((float) (this.ry[i] - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_244_ - (this.m).cz) * this.m.cos((this.m).zy));
                int i_246_ = (this.m).cx + (int) (((float) (this.rx[i] - (this.m).x - (this.m).cx) + this.vrx[i]) * this.m.cos((this.m).xz) - ((float) (this.rz[i] - (this.m).z - (this.m).cz) + this.vrz[i]) * this.m.sin((this.m).xz));
                int i_247_ = (this.m).cz + (int) (((float) (this.rx[i] - (this.m).x - (this.m).cx) + this.vrx[i]) * this.m.sin((this.m).xz) + ((float) (this.rz[i] - (this.m).z - (this.m).cz) + this.vrz[i]) * this.m.cos((this.m).xz));
                int i_248_ = (this.m).cy + (int) (((float) (this.ry[i] - (this.m).y - (this.m).cy) + this.vry[i]) * this.m.cos((this.m).zy) - (float) (i_247_ - (this.m).cz) * this.m.sin((this.m).zy));
                i_247_ = (this.m).cz + (int) (((float) (this.ry[i] - (this.m).y - (this.m).cy) + this.vry[i]) * this.m.sin((this.m).zy) + (float) (i_247_ - (this.m).cz) * this.m.cos((this.m).zy));
                int i_249_ = xs(i_243_, i_244_);
                int i_250_ = ys(i_245_, i_244_);
                int i_251_ = xs(i_246_, i_247_);
                int i_252_ = ys(i_248_, i_247_);
                if (i_249_ < (this.m).iw && i_251_ < (this.m).iw)
                    this.rtg[i] = 0;
                if (i_249_ > (this.m).w && i_251_ > (this.m).w)
                    this.rtg[i] = 0;
                if (i_250_ < (this.m).ih && i_252_ < (this.m).ih)
                    this.rtg[i] = 0;
                if (i_250_ > (this.m).h && i_252_ > (this.m).h)
                    this.rtg[i] = 0;
                if (this.ry[i] > 250)
                    this.rtg[i] = 0;
                if (this.rtg[i] != 0) {
                    int i_253_ = 255;
                    int i_254_ = 197 - 30 * this.rtg[i];
                    int i_255_ = 0;
                    for (int i_256_ = 0; i_256_ < 16; i_256_++) {
                        if (i_244_ > (this.m).fade[i_256_]) {
                            i_253_ = (i_253_ * (this.m).fogd + (this.m).cfade[0]) / ((this.m).fogd + 1);
                            i_254_ = (i_254_ * (this.m).fogd + (this.m).cfade[1]) / ((this.m).fogd + 1);
                            i_255_ = (i_255_ * (this.m).fogd + (this.m).cfade[2]) / ((this.m).fogd + 1);
                        }
                    }
                    graphics2d.setColor(new Color(i_253_, i_254_, i_255_));
                    graphics2d.drawLine(i_249_, i_250_, i_251_, i_252_);
                    this.vrx[i] = this.vrx[i] * 0.8F;
                    this.vry[i] = this.vry[i] * 0.8F;
                    this.vrz[i] = this.vrz[i] * 0.8F;
                    if (this.rtg[i] == 3)
                        this.rtg[i] = 0;
                    else
                        this.rtg[i]++;
                }
            }
        }
        if (this.sprk != 0)
            this.sprk = 0;
    }
    
    public int xs(int i, int i_257_) {
        if (i_257_ < 50)
            i_257_ = 50;
        return (i_257_ - (this.m).focus_point) * ((this.m).cx - i) / i_257_ + i;
    }
    
    public int ys(int i, int i_258_) {
        if (i_258_ < 50)
            i_258_ = 50;
        return (i_258_ - (this.m).focus_point) * ((this.m).cy - i) / i_258_ + i;
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
        return (i - this.x) / 10 * ((i - this.x) / 10) + (i_264_ - this.y) / 10 * ((i_264_ - this.y) / 10) + (i_265_ - this.z) / 10 * ((i_265_ - this.z) / 10);
    }
    
    public int py(int i, int i_266_, int i_267_, int i_268_) {
        return (i - i_266_) * (i - i_266_) + (i_267_ - i_268_) * (i_267_ - i_268_);
    }
    
    public void rot(int[] is, int[] is_269_, int i, int i_270_, int i_271_, int i_272_) {
        if (i_271_ != 0) {
            for (int i_273_ = 0; i_273_ < i_272_; i_273_++) {
                int i_274_ = is[i_273_];
                int i_275_ = is_269_[i_273_];
                is[i_273_] = i + (int) ((float) (i_274_ - i) * this.m.cos(i_271_) - (float) (i_275_ - i_270_) * this.m.sin(i_271_));
                is_269_[i_273_] = i_270_ + (int) ((float) (i_274_ - i) * this.m.sin(i_271_) + (float) (i_275_ - i_270_) * this.m.cos(i_271_));
            }
        }
    }
}
