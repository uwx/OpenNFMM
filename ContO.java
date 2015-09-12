/* ContO - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
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
	//this.p = new Plane[286];
	this.p = new Plane[10000];
	//int[] is_0_ = new int[286];
	int[] is_0_ = new int[10000];
	//for (int i = 0; i < 286; i++)
	//    is_0_[i] = 0;
	for (int i = 0; i < 10000; i++)
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
	boolean bool_8_ = false;
	int i_9_ = 0;
	int i_10_ = 1;
	int i_11_ = 0;
	int i_12_ = 0;
	int i_13_ = 0;
	int i_14_ = 0;
	boolean bool_15_ = false;
	boolean bool_16_ = false;
	try {
	    DataInputStream datainputstream
		= new DataInputStream(new ByteArrayInputStream(is));
	    String string_17_;
	    while ((string_17_ = datainputstream.readLine()) != null) {
		string = new StringBuilder().append("").append
			     (string_17_.trim()).toString();
		if (this.npl < 10000 /*210*/) {
		    if (string.startsWith("<p>")) {
			bool = true;
			i = 0;
			i_10_ = 0;
			i_11_ = 0;
			i_13_ = 0;
			is_0_[this.npl] = 1;
			if (!bool_16_)
			    bool_15_ = false;
		    }
		    if (bool) {
			if (string.startsWith("gr("))
			    i_10_ = getvalue("gr", string, 0);
			if (string.startsWith("fs(")) {
			    i_11_ = getvalue("fs", string, 0);
			    is_0_[this.npl] = 2;
			}
			if (string.startsWith("c(")) {
			    i_14_ = 0;
			    is_6_[0] = getvalue("c", string, 0);
			    is_6_[1] = getvalue("c", string, 1);
			    is_6_[2] = getvalue("c", string, 2);
			}
			if (string.startsWith("glass"))
			    i_14_ = 1;
			if (string.startsWith("gshadow"))
			    i_14_ = 2;
			if (string.startsWith("lightF"))
			    i_13_ = 1;
			if (string.startsWith("light"))
			    i_13_ = 1;
			if (string.startsWith("lightB"))
			    i_13_ = 2;
			if (string.startsWith("noOutline"))
			    bool_15_ = true;
			if (string.startsWith("p(")) {
			    is_3_[i] = (int) ((float) getvalue("p", string, 0)
					      * f * f_2_ * fs[0]);
			    is_4_[i] = (int) ((float) getvalue("p", string, 1)
					      * f * fs[1]);
			    is_5_[i] = (int) ((float) getvalue("p", string, 2)
					      * f * fs[2]);
			    int i_18_
				= (int) Math.sqrt((double) (is_3_[i] * is_3_[i]
							    + (is_4_[i]
							       * is_4_[i])
							    + (is_5_[i]
							       * is_5_[i])));
			    if (i_18_ > this.maxR)
				this.maxR = i_18_;
			    i++;
			}
		    }
		    if (string.startsWith("</p>")) {
			this.p[this.npl]
			    = new Plane(this.m, this.t,
					is_3_, is_5_, is_4_, i, is_6_, i_14_,
					i_10_, i_11_, 0, 0, 0,
					this.disline, 0, bool_7_,
					i_13_, bool_15_);
			if (is_6_[0] == this.fcol[0]
			    && is_6_[1] == this.fcol[1]
			    && is_6_[2] == this.fcol[2]
			    && i_14_ == 0)
			    (this.p[this.npl])
				.colnum
				= 1;
			if (is_6_[0] == this.scol[0]
			    && is_6_[1] == this.scol[1]
			    && is_6_[2] == this.scol[2]
			    && i_14_ == 0)
			    (this.p[this.npl])
				.colnum
				= 2;
			this.npl++;
			bool = false;
		    }
		}
		if (string.startsWith("rims("))
		    wheels.setrims(getvalue("rims", string, 0),
				   getvalue("rims", string, 1),
				   getvalue("rims", string, 2),
				   getvalue("rims", string, 3),
				   getvalue("rims", string, 4));
		if (string.startsWith("w(") && i_9_ < 4) {
		    this.keyx[i_9_]
			= (int) ((float) getvalue("w", string, 0) * f * fs[0]);
		    this.keyz[i_9_]
			= (int) ((float) getvalue("w", string, 2) * f * fs[2]);
		    wheels.make(this.m, this.t,
				this.p, this.npl,
				(int) ((float) getvalue("w", string, 0) * f
				       * f_2_ * fs[0]),
				(int) ((float) getvalue("w", string, 1) * f
				       * fs[1]),
				(int) ((float) getvalue("w", string, 2) * f
				       * fs[2]),
				getvalue("w", string, 3),
				(int) ((float) getvalue("w", string, 4) * f
				       * f_2_),
				(int) ((float) getvalue("w", string, 5) * f),
				i_12_);
		    this.npl += 19;
		    if ((this.m).loadnew) {
			this.wh
			    += (int) ((float) getvalue("w", string, 5) * f);
			if ((wheels).ground > 140) {
			    String string_19_ = "FRONT";
			    if (this.keyz[i_9_] < 0)
				string_19_ = "BACK";
			    this.err
				= new StringBuilder().append
				      ("Wheels Error:\n").append
				      (string_19_).append
				      (" Wheels floor is too far below the center of Y Axis of the car!    \n\nPlease decrease the Y value of the ")
				      .append
				      (string_19_).append
				      (" Wheels or decrease its height.     \n \n")
				      .toString();
			    this.errd = true;
			    this.keyz[i_9_] = 0;
			    this.keyx[i_9_] = 0;
			}
			if ((wheels).ground < -100) {
			    String string_20_ = "FRONT";
			    if (this.keyz[i_9_] < 0)
				string_20_ = "BACK";
			    this.err
				= new StringBuilder().append
				      ("Wheels Error:\n").append
				      (string_20_).append
				      (" Wheels floor is too far above the center of Y Axis of the car!    \n\nPlease increase the Y value of the ")
				      .append
				      (string_20_).append
				      (" Wheels or increase its height.     \n \n")
				      .toString();
			    this.errd = true;
			    this.keyz[i_9_] = 0;
			    this.keyx[i_9_] = 0;
			}
			if (Math.abs(this.keyx[i_9_]) > 400) {
			    String string_21_ = "FRONT";
			    if (this.keyz[i_9_] < 0)
				string_21_ = "BACK";
			    this.err
				= new StringBuilder().append
				      ("Wheels Error:\n").append
				      (string_21_).append
				      (" Wheels are too far apart!    \n\nPlease decrease the \u00b1X value of the ")
				      .append
				      (string_21_).append
				      (" Wheels.     \n \n").toString();
			    this.errd = true;
			    this.keyz[i_9_] = 0;
			    this.keyx[i_9_] = 0;
			}
			if (Math.abs(this.keyz[i_9_]) > 700) {
			    if (this.keyz[i_9_] < 0)
				this.err
				    = "Wheels Error:\nBACK Wheels are too far backwards from the center of the Z Axis!    \n\nPlease increase the -Z value of the BACK Wheels.     \n \n";
			    else
				this.err
				    = "Wheels Error:\nFRONT Wheels are too far forwards from the center of the Z Axis!    \n\nPlease decrease the +Z value of the FRONT Wheels.     \n \n";
			    this.errd = true;
			    this.keyz[i_9_] = 0;
			    this.keyx[i_9_] = 0;
			}
			if ((int) ((float) getvalue("w", string, 4) * f * f_2_)
			    > 300) {
			    String string_22_ = "FRONT";
			    if (this.keyz[i_9_] < 0)
				string_22_ = "BACK";
			    this.err
				= new StringBuilder().append
				      ("Wheels Error:\nWidth of the ").append
				      (string_22_).append
				      (" Wheels is too large!    \n\nPlease decrease the width of the ")
				      .append
				      (string_22_).append
				      (" Wheels.     \n \n").toString();
			    this.errd = true;
			    this.keyz[i_9_] = 0;
			    this.keyx[i_9_] = 0;
			}
		    }
		    i_9_++;
		}
		if (string.startsWith("tracks")) {
		    int i_23_ = getvalue("tracks", string, 0);
		    this.txy = new int[i_23_];
		    this.tzy = new int[i_23_];
		    this.tc = new int[i_23_][3];
		    this.tradx = new int[i_23_];
		    this.tradz = new int[i_23_];
		    this.trady = new int[i_23_];
		    this.tx = new int[i_23_];
		    this.ty = new int[i_23_];
		    this.tz = new int[i_23_];
		    this.skd = new int[i_23_];
		    this.dam = new int[i_23_];
		    this.notwall = new boolean[i_23_];
		    bool_8_ = true;
		}
		if (bool_8_) {
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
			    this.tc[this.tnt][0]
				= getvalue("c", string, 0);
			    this.tc[this.tnt][1]
				= getvalue("c", string, 1);
			    this.tc[this.tnt][2]
				= getvalue("c", string, 2);
			}
			if (string.startsWith("xy"))
			    this.txy[this.tnt]
				= getvalue("xy", string, 0);
			if (string.startsWith("zy"))
			    this.tzy[this.tnt]
				= getvalue("zy", string, 0);
			if (string.startsWith("radx"))
			    this.tradx[this.tnt]
				= (int) ((float) getvalue("radx", string, 0)
					 * f);
			if (string.startsWith("rady"))
			    this.trady[this.tnt]
				= (int) ((float) getvalue("rady", string, 0)
					 * f);
			if (string.startsWith("radz"))
			    this.tradz[this.tnt]
				= (int) ((float) getvalue("radz", string, 0)
					 * f);
			if (string.startsWith("ty"))
			    this.ty[this.tnt]
				= (int) ((float) getvalue("ty", string, 0)
					 * f);
			if (string.startsWith("tx"))
			    this.tx[this.tnt]
				= (int) ((float) getvalue("tx", string, 0)
					 * f);
			if (string.startsWith("tz"))
			    this.tz[this.tnt]
				= (int) ((float) getvalue("tz", string, 0)
					 * f);
			if (string.startsWith("skid"))
			    this.skd[this.tnt]
				= getvalue("skid", string, 0);
			if (string.startsWith("dam"))
			    this.dam[this.tnt] = 3;
			if (string.startsWith("notwall"))
			    this.notwall[this.tnt] = true;
		    }
		    if (string.startsWith("</track>")) {
			bool_1_ = false;
			this.tnt++;
		    }
		}
		if (string.startsWith("disp("))
		    this.disp = getvalue("disp", string, 0);
		if (string.startsWith("disline("))
		    this.disline
			= getvalue("disline", string, 0) * 2;
		if (string.startsWith("shadow"))
		    this.shadow = true;
		if (string.startsWith("stonecold"))
		    this.noline = true;
		if (string.startsWith("newstone")) {
		    this.noline = true;
		    bool_15_ = true;
		    bool_16_ = true;
		}
		if (string.startsWith("decorative"))
		    this.decor = true;
		if (string.startsWith("road"))
		    bool_7_ = true;
		if (string.startsWith("notroad"))
		    bool_7_ = false;
		if (string.startsWith("grounded("))
		    this.grounded
			= (float) getvalue("grounded", string, 0) / 100.0F;
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
		    i_12_ = getvalue("gwgr", string, 0);
		    if ((this.m).loadnew) {
			if (i_12_ > 40)
			    i_12_ = 40;
			if (i_12_ < 0 && i_12_ >= -15)
			    i_12_ = -16;
			if (i_12_ < -40)
			    i_12_ = -40;
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
		this.err
		    = new StringBuilder().append
			  ("Error While Loading 3D Model\n\nLine:     ").append
			  (string).append
			  ("\n\nError Detail:\n").append
			  (exception).append
			  ("           \n \n").toString();
		System.out.println(this.err);
		this.errd = true;
	    }
	}
	this.grat = (wheels).ground;
	this.sprkat = (wheels).sparkat;
	if (this.shadow) {
	    this.stg = new int[20];
	    this.rtg = new int[100];
	    for (int i_24_ = 0; i_24_ < 20; i_24_++)
		this.stg[i_24_] = 0;
	    for (int i_25_ = 0; i_25_ < 100; i_25_++)
		this.rtg[i_25_] = 0;
	}
	if ((this.m).loadnew) {
	    if (i_9_ != 0)
		this.wh = this.wh / i_9_;
	    boolean bool_26_ = false;
	    for (int i_27_ = 0; i_27_ < this.npl; i_27_++) {
		int i_28_ = 0;
		int i_29_ = (this.p[i_27_]).ox[0];
		int i_30_ = (this.p[i_27_]).ox[0];
		int i_31_ = (this.p[i_27_]).oy[0];
		int i_32_ = (this.p[i_27_]).oy[0];
		int i_33_ = (this.p[i_27_]).oz[0];
		int i_34_ = (this.p[i_27_]).oz[0];
		for (int i_35_ = 0;
		     i_35_ < (this.p[i_27_]).n; i_35_++) {
		    if ((this.p[i_27_]).ox[i_35_] > i_29_)
			i_29_ = (this.p[i_27_]).ox[i_35_];
		    if ((this.p[i_27_]).ox[i_35_] < i_30_)
			i_30_ = (this.p[i_27_]).ox[i_35_];
		    if ((this.p[i_27_]).oy[i_35_] > i_31_)
			i_31_ = (this.p[i_27_]).oy[i_35_];
		    if ((this.p[i_27_]).oy[i_35_] < i_32_)
			i_32_ = (this.p[i_27_]).oy[i_35_];
		    if ((this.p[i_27_]).oz[i_35_] > i_33_)
			i_33_ = (this.p[i_27_]).oz[i_35_];
		    if ((this.p[i_27_]).oz[i_35_] < i_34_)
			i_34_ = (this.p[i_27_]).oz[i_35_];
		}
		if (Math.abs(i_29_ - i_30_) <= Math.abs(i_31_ - i_32_)
		    && Math.abs(i_29_ - i_30_) <= Math.abs(i_33_ - i_34_))
		    i_28_ = 1;
		if (Math.abs(i_31_ - i_32_) <= Math.abs(i_29_ - i_30_)
		    && Math.abs(i_31_ - i_32_) <= Math.abs(i_33_ - i_34_))
		    i_28_ = 2;
		if (Math.abs(i_33_ - i_34_) <= Math.abs(i_29_ - i_30_)
		    && Math.abs(i_33_ - i_34_) <= Math.abs(i_31_ - i_32_))
		    i_28_ = 3;
		if (i_28_ == 2
		    && (!bool_26_
			|| (i_31_ + i_32_) / 2 < this.roofat)) {
		    this.roofat = (i_31_ + i_32_) / 2;
		    bool_26_ = true;
		}
		if (is_0_[i_27_] == 1) {
		    int i_36_ = 1000;
		    int i_37_ = 0;
		    for (int i_38_ = 0;
			 i_38_ < (this.p[i_27_]).n;
			 i_38_++) {
			int i_39_ = i_38_ + 1;
			if (i_39_ >= (this.p[i_27_]).n)
			    i_39_ -= (this.p[i_27_]).n;
			int i_40_ = i_38_ + 2;
			if (i_40_ >= (this.p[i_27_]).n)
			    i_40_ -= (this.p[i_27_]).n;
			if (i_28_ == 1) {
			    int i_41_
				= (Math.abs
				   ((int) ((Math.atan
					    ((double) ((
							(this.p
							 [i_27_])).oz[i_38_]
						       - (
							  (this.p
							   [i_27_])).oz[i_39_])
					     / (double) ((
							  (this.p
							   [i_27_])).oy[i_38_]
							 - ((
							     (this.p
							      [i_27_]))
							    .oy[i_39_]))))
					   / 0.017453292519943295)));
			    int i_42_
				= (Math.abs
				   ((int) ((Math.atan
					    ((double) ((
							(this.p
							 [i_27_])).oz[i_40_]
						       - (
							  (this.p
							   [i_27_])).oz[i_39_])
					     / (double) ((
							  (this.p
							   [i_27_])).oy[i_40_]
							 - ((
							     (this.p
							      [i_27_]))
							    .oy[i_39_]))))
					   / 0.017453292519943295)));
			    if (i_41_ > 45)
				i_41_ = 90 - i_41_;
			    else
				i_42_ = 90 - i_42_;
			    if (i_41_ + i_42_ < i_36_) {
				i_36_ = i_41_ + i_42_;
				i_37_ = i_38_;
			    }
			}
			if (i_28_ == 2) {
			    int i_43_
				= (Math.abs
				   ((int) ((Math.atan
					    ((double) ((
							(this.p
							 [i_27_])).oz[i_38_]
						       - (
							  (this.p
							   [i_27_])).oz[i_39_])
					     / (double) ((
							  (this.p
							   [i_27_])).ox[i_38_]
							 - ((
							     (this.p
							      [i_27_]))
							    .ox[i_39_]))))
					   / 0.017453292519943295)));
			    int i_44_
				= (Math.abs
				   ((int) ((Math.atan
					    ((double) ((
							(this.p
							 [i_27_])).oz[i_40_]
						       - (
							  (this.p
							   [i_27_])).oz[i_39_])
					     / (double) ((
							  (this.p
							   [i_27_])).ox[i_40_]
							 - ((
							     (this.p
							      [i_27_]))
							    .ox[i_39_]))))
					   / 0.017453292519943295)));
			    if (i_43_ > 45)
				i_43_ = 90 - i_43_;
			    else
				i_44_ = 90 - i_44_;
			    if (i_43_ + i_44_ < i_36_) {
				i_36_ = i_43_ + i_44_;
				i_37_ = i_38_;
			    }
			}
			if (i_28_ == 3) {
			    int i_45_
				= (Math.abs
				   ((int) ((Math.atan
					    ((double) ((
							(this.p
							 [i_27_])).oy[i_38_]
						       - (
							  (this.p
							   [i_27_])).oy[i_39_])
					     / (double) ((
							  (this.p
							   [i_27_])).ox[i_38_]
							 - ((
							     (this.p
							      [i_27_]))
							    .ox[i_39_]))))
					   / 0.017453292519943295)));
			    int i_46_
				= (Math.abs
				   ((int) ((Math.atan
					    ((double) ((
							(this.p
							 [i_27_])).oy[i_40_]
						       - (
							  (this.p
							   [i_27_])).oy[i_39_])
					     / (double) ((
							  (this.p
							   [i_27_])).ox[i_40_]
							 - ((
							     (this.p
							      [i_27_]))
							    .ox[i_39_]))))
					   / 0.017453292519943295)));
			    if (i_45_ > 45)
				i_45_ = 90 - i_45_;
			    else
				i_46_ = 90 - i_46_;
			    if (i_45_ + i_46_ < i_36_) {
				i_36_ = i_45_ + i_46_;
				i_37_ = i_38_;
			    }
			}
		    }
		    if (i_37_ != 0) {
			int[] is_47_
			    = new int[(this.p[i_27_]).n];
			int[] is_48_
			    = new int[(this.p[i_27_]).n];
			int[] is_49_
			    = new int[(this.p[i_27_]).n];
			for (int i_50_ = 0;
			     i_50_ < (this.p[i_27_]).n;
			     i_50_++) {
			    is_47_[i_50_]
				= (this.p[i_27_]).ox[i_50_];
			    is_48_[i_50_]
				= (this.p[i_27_]).oy[i_50_];
			    is_49_[i_50_]
				= (this.p[i_27_]).oz[i_50_];
			}
			for (int i_51_ = 0;
			     i_51_ < (this.p[i_27_]).n;
			     i_51_++) {
			    int i_52_ = i_51_ + i_37_;
			    if (i_52_ >= (this.p[i_27_]).n)
				i_52_ -= (this.p[i_27_]).n;
			    (this.p[i_27_]).ox[i_51_]
				= is_47_[i_52_];
			    (this.p[i_27_]).oy[i_51_]
				= is_48_[i_52_];
			    (this.p[i_27_]).oz[i_51_]
				= is_49_[i_52_];
			}
		    }
		    if (i_28_ == 1) {
			if (Math.abs((this.p[i_27_]).oz[0]
				     - (this.p[i_27_]).oz[1])
			    > Math.abs((this.p[i_27_]).oy[0]
				       - ((this.p[i_27_]).oy
					  [1]))) {
			    if ((this.p[i_27_]).oz[0]
				> (this.p[i_27_]).oz[1]) {
				if ((this.p[i_27_]).oy[1]
				    > (this.p[i_27_]).oy[2])
				    (this.p[i_27_]).fs = 1;
				else
				    (this.p[i_27_]).fs = -1;
			    } else if ((this.p[i_27_]).oy[1]
				       > ((this.p[i_27_]).oy
					  [2]))
				(this.p[i_27_]).fs = -1;
			    else
				(this.p[i_27_]).fs = 1;
			} else if ((this.p[i_27_]).oy[0]
				   > (this.p[i_27_]).oy[1]) {
			    if ((this.p[i_27_]).oz[1]
				> (this.p[i_27_]).oz[2])
				(this.p[i_27_]).fs = -1;
			    else
				(this.p[i_27_]).fs = 1;
			} else if ((this.p[i_27_]).oz[1]
				   > (this.p[i_27_]).oz[2])
			    (this.p[i_27_]).fs = 1;
			else
			    (this.p[i_27_]).fs = -1;
		    }
		    if (i_28_ == 2) {
			if (Math.abs((this.p[i_27_]).oz[0]
				     - (this.p[i_27_]).oz[1])
			    > Math.abs((this.p[i_27_]).ox[0]
				       - ((this.p[i_27_]).ox
					  [1]))) {
			    if ((this.p[i_27_]).oz[0]
				> (this.p[i_27_]).oz[1]) {
				if ((this.p[i_27_]).ox[1]
				    > (this.p[i_27_]).ox[2])
				    (this.p[i_27_]).fs = -1;
				else
				    (this.p[i_27_]).fs = 1;
			    } else if ((this.p[i_27_]).ox[1]
				       > ((this.p[i_27_]).ox
					  [2]))
				(this.p[i_27_]).fs = 1;
			    else
				(this.p[i_27_]).fs = -1;
			} else if ((this.p[i_27_]).ox[0]
				   > (this.p[i_27_]).ox[1]) {
			    if ((this.p[i_27_]).oz[1]
				> (this.p[i_27_]).oz[2])
				(this.p[i_27_]).fs = 1;
			    else
				(this.p[i_27_]).fs = -1;
			} else if ((this.p[i_27_]).oz[1]
				   > (this.p[i_27_]).oz[2])
			    (this.p[i_27_]).fs = -1;
			else
			    (this.p[i_27_]).fs = 1;
		    }
		    if (i_28_ == 3) {
			if (Math.abs((this.p[i_27_]).oy[0]
				     - (this.p[i_27_]).oy[1])
			    > Math.abs((this.p[i_27_]).ox[0]
				       - ((this.p[i_27_]).ox
					  [1]))) {
			    if ((this.p[i_27_]).oy[0]
				> (this.p[i_27_]).oy[1]) {
				if ((this.p[i_27_]).ox[1]
				    > (this.p[i_27_]).ox[2])
				    (this.p[i_27_]).fs = 1;
				else
				    (this.p[i_27_]).fs = -1;
			    } else if ((this.p[i_27_]).ox[1]
				       > ((this.p[i_27_]).ox
					  [2]))
				(this.p[i_27_]).fs = -1;
			    else
				(this.p[i_27_]).fs = 1;
			} else if ((this.p[i_27_]).ox[0]
				   > (this.p[i_27_]).ox[1]) {
			    if ((this.p[i_27_]).oy[1]
				> (this.p[i_27_]).oy[2])
				(this.p[i_27_]).fs = -1;
			    else
				(this.p[i_27_]).fs = 1;
			} else if ((this.p[i_27_]).oy[1]
				   > (this.p[i_27_]).oy[2])
			    (this.p[i_27_]).fs = 1;
			else
			    (this.p[i_27_]).fs = -1;
		    }
		    boolean bool_53_ = false;
		    boolean bool_54_ = false;
		    for (int i_55_ = 0; i_55_ < this.npl; i_55_++) {
			if (i_55_ != i_27_ && is_0_[i_55_] != 0) {
			    boolean bool_56_ = false;
			    int i_57_
				= (this.p[i_55_]).ox[0];
			    int i_58_
				= (this.p[i_55_]).ox[0];
			    int i_59_
				= (this.p[i_55_]).oy[0];
			    int i_60_
				= (this.p[i_55_]).oy[0];
			    int i_61_
				= (this.p[i_55_]).oz[0];
			    int i_62_
				= (this.p[i_55_]).oz[0];
			    for (int i_63_ = 0;
				 i_63_ < (this.p[i_55_]).n;
				 i_63_++) {
				if ((this.p[i_55_]).ox[i_63_]
				    > i_57_)
				    i_57_ = ((this.p[i_55_])
					     .ox[i_63_]);
				if ((this.p[i_55_]).ox[i_63_]
				    < i_58_)
				    i_58_ = ((this.p[i_55_])
					     .ox[i_63_]);
				if ((this.p[i_55_]).oy[i_63_]
				    > i_59_)
				    i_59_ = ((this.p[i_55_])
					     .oy[i_63_]);
				if ((this.p[i_55_]).oy[i_63_]
				    < i_60_)
				    i_60_ = ((this.p[i_55_])
					     .oy[i_63_]);
				if ((this.p[i_55_]).oz[i_63_]
				    > i_61_)
				    i_61_ = ((this.p[i_55_])
					     .oz[i_63_]);
				if ((this.p[i_55_]).oz[i_63_]
				    < i_62_)
				    i_62_ = ((this.p[i_55_])
					     .oz[i_63_]);
			    }
			    int i_64_ = (i_57_ + i_58_) / 2;
			    int i_65_ = (i_59_ + i_60_) / 2;
			    int i_66_ = (i_61_ + i_62_) / 2;
			    int i_67_ = (i_29_ + i_30_) / 2;
			    int i_68_ = (i_31_ + i_32_) / 2;
			    int i_69_ = (i_33_ + i_34_) / 2;
			    if (i_28_ == 1
				&& ((i_65_ <= i_31_ && i_65_ >= i_32_
				     && i_66_ <= i_33_ && i_66_ >= i_34_)
				    || (i_68_ <= i_59_ && i_68_ >= i_60_
					&& i_69_ <= i_61_
					&& i_69_ >= i_62_))) {
				if (i_57_ < i_30_)
				    bool_53_ = true;
				if (i_58_ > i_29_)
				    bool_54_ = true;
			    }
			    if (i_28_ == 2
				&& ((i_64_ <= i_29_ && i_64_ >= i_30_
				     && i_66_ <= i_33_ && i_66_ >= i_34_)
				    || (i_67_ <= i_57_ && i_67_ >= i_58_
					&& i_69_ <= i_61_
					&& i_69_ >= i_62_))) {
				if (i_59_ < i_32_)
				    bool_53_ = true;
				if (i_60_ > i_31_)
				    bool_54_ = true;
			    }
			    if (i_28_ == 3
				&& ((i_64_ <= i_29_ && i_64_ >= i_30_
				     && i_65_ <= i_31_ && i_65_ >= i_32_)
				    || (i_67_ <= i_57_ && i_67_ >= i_58_
					&& i_68_ <= i_59_
					&& i_68_ >= i_60_))) {
				if (i_61_ < i_34_)
				    bool_53_ = true;
				if (i_62_ > i_33_)
				    bool_54_ = true;
			    }
			}
			if (bool_53_ && bool_54_)
			    break;
		    }
		    boolean bool_70_ = false;
		    if (bool_53_ && !bool_54_)
			bool_70_ = true;
		    if (bool_54_ && !bool_53_) {
			(this.p[i_27_]).fs *= -1;
			bool_70_ = true;
		    }
		    if (bool_53_ && bool_54_) {
			(this.p[i_27_]).fs = 0;
			(this.p[i_27_]).gr = 40;
			bool_70_ = true;
		    }
		    if (!bool_70_) {
			int i_71_ = 0;
			int i_72_ = 0;
			if (i_28_ == 1) {
			    i_71_ = (i_29_ + i_30_) / 2;
			    i_72_ = i_71_;
			}
			if (i_28_ == 2) {
			    i_71_ = (i_31_ + i_32_) / 2;
			    i_72_ = i_71_;
			}
			if (i_28_ == 3) {
			    i_71_ = (i_33_ + i_34_) / 2;
			    i_72_ = i_71_;
			}
			for (int i_73_ = 0; i_73_ < this.npl;
			     i_73_++) {
			    if (i_73_ != i_27_) {
				boolean bool_74_ = false;
				boolean[] bools
				    = (new boolean
				       [(this.p[i_73_]).n]);
				for (int i_75_ = 0;
				     (i_75_
				      < (this.p[i_73_]).n);
				     i_75_++) {
				    bools[i_75_] = false;
				    for (int i_76_ = 0;
					 (i_76_
					  < ((this.p[i_27_])
					     .n));
					 i_76_++) {
					if ((((this.p[i_27_])
					      .ox[i_76_])
					     == ((this.p
							  [i_73_])).ox[i_75_])
					    && (((this.p
							  [i_27_])).oy[i_76_]
						== ((
						     this.p[i_73_])
						    .oy[i_75_]))
					    && (((this.p
							  [i_27_])).oz[i_76_]
						== ((
						     this.p[i_73_])
						    .oz[i_75_]))) {
					    bools[i_75_] = true;
					    bool_74_ = true;
					}
				    }
				}
				if (bool_74_) {
				    for (int i_77_ = 0;
					 (i_77_
					  < ((this.p[i_73_])
					     .n));
					 i_77_++) {
					if (!bools[i_77_]) {
					    if (i_28_ == 1) {
						if (((
						      this.p[i_73_])
						     .ox[i_77_])
						    > i_71_)
						    i_71_ = ((
							      (this.p
							       [i_73_]))
							     .ox[i_77_]);
						if (((
						      this.p[i_73_])
						     .ox[i_77_])
						    < i_72_)
						    i_72_ = ((
							      (this.p
							       [i_73_]))
							     .ox[i_77_]);
					    }
					    if (i_28_ == 2) {
						if (((
						      this.p[i_73_])
						     .oy[i_77_])
						    > i_71_)
						    i_71_ = ((
							      (this.p
							       [i_73_]))
							     .oy[i_77_]);
						if (((
						      this.p[i_73_])
						     .oy[i_77_])
						    < i_72_)
						    i_72_ = ((
							      (this.p
							       [i_73_]))
							     .oy[i_77_]);
					    }
					    if (i_28_ == 3) {
						if (((
						      this.p[i_73_])
						     .oz[i_77_])
						    > i_71_)
						    i_71_ = ((
							      (this.p
							       [i_73_]))
							     .oz[i_77_]);
						if (((
						      this.p[i_73_])
						     .oz[i_77_])
						    < i_72_)
						    i_72_ = ((
							      (this.p
							       [i_73_]))
							     .oz[i_77_]);
					    }
					}
				    }
				}
			    }
			}
			if (i_28_ == 1) {
			    if ((i_71_ + i_72_) / 2 > (i_29_ + i_30_) / 2)
				(this.p[i_27_]).fs *= -1;
			    else if ((i_71_ + i_72_) / 2 == (i_29_ + i_30_) / 2
				     && (i_29_ + i_30_) / 2 < 0)
				(this.p[i_27_]).fs *= -1;
			}
			if (i_28_ == 2) {
			    if ((i_71_ + i_72_) / 2 > (i_31_ + i_32_) / 2)
				(this.p[i_27_]).fs *= -1;
			    else if ((i_71_ + i_72_) / 2 == (i_31_ + i_32_) / 2
				     && (i_31_ + i_32_) / 2 < 0)
				(this.p[i_27_]).fs *= -1;
			}
			if (i_28_ == 3) {
			    if ((i_71_ + i_72_) / 2 > (i_33_ + i_34_) / 2)
				(this.p[i_27_]).fs *= -1;
			    else if ((i_71_ + i_72_) / 2 == (i_33_ + i_34_) / 2
				     && (i_33_ + i_34_) / 2 < 0)
				(this.p[i_27_]).fs *= -1;
			}
		    }
		    this.p[i_27_].deltafntyp();
		}
	    }
	}
    }
    
    public ContO(ContO conto_78_, int i, int i_79_, int i_80_, int i_81_) {
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
	this.m = (conto_78_).m;
	this.t = (conto_78_).t;
	this.npl = (conto_78_).npl;
	this.maxR = (conto_78_).maxR;
	this.disp = (conto_78_).disp;
	this.disline = (conto_78_).disline;
	this.noline = (conto_78_).noline;
	this.shadow = (conto_78_).shadow;
	this.grounded = (conto_78_).grounded;
	this.decor = (conto_78_).decor;
	if ((this.m).loadnew
	    && (i_81_ == 90 || i_81_ == -90))
	    this.grounded += 10000.0F;
	this.grat = (conto_78_).grat;
	this.sprkat = (conto_78_).sprkat;
	this.p = new Plane[(conto_78_).npl];
	for (int i_82_ = 0; i_82_ < this.npl; i_82_++) {
	    if (((conto_78_).p[i_82_]).master == 1)
		((conto_78_).p[i_82_]).n = 20;
	    this.p[i_82_]
		= new Plane(this.m, this.t,
			    ((conto_78_).p[i_82_]).ox,
			    ((conto_78_).p[i_82_]).oz,
			    ((conto_78_).p[i_82_]).oy,
			    ((conto_78_).p[i_82_]).n,
			    ((conto_78_).p[i_82_]).oc,
			    ((conto_78_).p[i_82_]).glass,
			    ((conto_78_).p[i_82_]).gr,
			    ((conto_78_).p[i_82_]).fs,
			    ((conto_78_).p[i_82_]).wx,
			    ((conto_78_).p[i_82_]).wy,
			    ((conto_78_).p[i_82_]).wz,
			    (conto_78_).disline,
			    ((conto_78_).p[i_82_]).bfase,
			    ((conto_78_).p[i_82_]).road,
			    ((conto_78_).p[i_82_]).light,
			    ((conto_78_).p[i_82_]).solo);
	}
	this.x = i;
	this.y = i_79_;
	this.z = i_80_;
	this.xz = 0;
	this.xy = 0;
	this.zy = 0;
	for (int i_83_ = 0; i_83_ < this.npl; i_83_++) {
	    (this.p[i_83_]).colnum
		= ((conto_78_).p[i_83_]).colnum;
	    (this.p[i_83_]).master
		= ((conto_78_).p[i_83_]).master;
	    this.p[i_83_].rot((this.p[i_83_]).ox,
					(this.p[i_83_]).oz,
					0, 0, i_81_,
					(this.p[i_83_]).n);
	    this.p[i_83_].loadprojf();
	}
	if ((conto_78_).tnt != 0) {
	    for (int i_84_ = 0; i_84_ < (conto_78_).tnt; i_84_++) {
		(this.t).xy[((this.t)
						  .nt)]
		    = (int) (((float) (conto_78_).txy[i_84_]
			      * this.m.cos(i_81_))
			     - ((float) (conto_78_).tzy[i_84_]
				* this.m.sin(i_81_)));
		(this.t).zy[((this.t)
						  .nt)]
		    = (int) (((float) (conto_78_).tzy[i_84_]
			      * this.m.cos(i_81_))
			     + ((float) (conto_78_).txy[i_84_]
				* this.m.sin(i_81_)));
		for (int i_85_ = 0; i_85_ < 3; i_85_++) {
		    (this.t).c
			[(this.t).nt][i_85_]
			= (int) ((float) (conto_78_).tc[i_84_][i_85_]
				 + ((float) ((conto_78_).tc[i_84_]
					     [i_85_])
				    * ((float) ((this.m)
						.snap[i_85_])
				       / 100.0F)));
		    if (((this.t).c
			 [(this.t).nt][i_85_])
			> 255)
			(this.t).c
			    [(this.t).nt][i_85_]
			    = 255;
		    if (((this.t).c
			 [(this.t).nt][i_85_])
			< 0)
			(this.t).c
			    [(this.t).nt][i_85_]
			    = 0;
		}
		(this.t).x[((this.t)
						 .nt)]
		    = (int) ((float) this.x
			     + ((float) (conto_78_).tx[i_84_]
				* this.m.cos(i_81_))
			     - ((float) (conto_78_).tz[i_84_]
				* this.m.sin(i_81_)));
		(this.t).z[((this.t)
						 .nt)]
		    = (int) ((float) this.z
			     + ((float) (conto_78_).tz[i_84_]
				* this.m.cos(i_81_))
			     + ((float) (conto_78_).tx[i_84_]
				* this.m.sin(i_81_)));
		(this.t).y[((this.t)
						 .nt)]
		    = this.y + (conto_78_).ty[i_84_];
		(this.t).skd
		    [(this.t).nt]
		    = (conto_78_).skd[i_84_];
		(this.t).dam
		    [(this.t).nt]
		    = (conto_78_).dam[i_84_];
		(this.t).notwall
		    [(this.t).nt]
		    = (conto_78_).notwall[i_84_];
		if (this.decor)
		    (this.t).decor
			[(this.t).nt]
			= true;
		else
		    (this.t).decor
			[(this.t).nt]
			= false;
		int i_86_ = Math.abs(i_81_);
		if (i_86_ == 180)
		    i_86_ = 0;
		(this.t).radx
		    [(this.t).nt]
		    = (int) Math.abs(((float) (conto_78_).tradx[i_84_]
				      * this.m.cos(i_86_))
				     + ((float) ((conto_78_).tradz
						 [i_84_])
					* this.m.sin(i_86_)));
		(this.t).radz
		    [(this.t).nt]
		    = (int) Math.abs(((float) (conto_78_).tradx[i_84_]
				      * this.m.sin(i_86_))
				     + ((float) ((conto_78_).tradz
						 [i_84_])
					* this.m.cos(i_86_)));
		(this.t).rady
		    [(this.t).nt]
		    = (conto_78_).trady[i_84_];
		(this.t).nt++;
	    }
	}
	for (int i_87_ = 0; i_87_ < 4; i_87_++) {
	    this.keyx[i_87_] = (conto_78_).keyx[i_87_];
	    this.keyz[i_87_] = (conto_78_).keyz[i_87_];
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
	    for (int i_88_ = 0; i_88_ < 20; i_88_++)
		this.stg[i_88_] = 0;
	    this.rtg = new int[100];
	    this.rbef = new boolean[100];
	    this.rx = new int[100];
	    this.ry = new int[100];
	    this.rz = new int[100];
	    this.vrx = new float[100];
	    this.vry = new float[100];
	    this.vrz = new float[100];
	    for (int i_89_ = 0; i_89_ < 100; i_89_++)
		this.rtg[i_89_] = 0;
	}
    }
    
    public ContO(int i, int i_90_, int i_91_, Medium medium, Trackers trackers,
		 int i_92_, int i_93_, int i_94_) {
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
	this.x = i_92_;
	this.z = i_93_;
	this.y = i_94_;
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
	int[] is_95_ = new int[8];
	int[] is_96_ = new int[8];
	int[] is_97_ = new int[8];
	int[] is_98_ = new int[8];
	float f = (float) i_90_;
	float f_99_ = (float) i_91_;
	if (f_99_ < 2.0F)
	    f_99_ = 2.0F;
	if (f_99_ > 6.0F)
	    f_99_ = 6.0F;
	if (f < 2.0F)
	    f = 2.0F;
	if (f > 6.0F)
	    f = 6.0F;
	f /= 1.5F;
	f_99_ /= 1.5F;
	f_99_ *= 1.0F + (f - 2.0F) * 0.1786F;
	float f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[0] = -(int) (f_100_ * f * 0.7071F);
	is_95_[0] = (int) (f_100_ * f * 0.7071F);
	f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[1] = 0;
	is_95_[1] = (int) (f_100_ * f);
	f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[2] = (int) ((double) (f_100_ * f) * 0.7071);
	is_95_[2] = (int) ((double) (f_100_ * f) * 0.7071);
	f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[3] = (int) (f_100_ * f);
	is_95_[3] = 0;
	f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[4] = (int) ((double) (f_100_ * f) * 0.7071);
	is_95_[4] = -(int) ((double) (f_100_ * f) * 0.7071);
	f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[5] = 0;
	is_95_[5] = -(int) (f_100_ * f);
	f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[6] = -(int) ((double) (f_100_ * f) * 0.7071);
	is_95_[6] = -(int) ((double) (f_100_ * f) * 0.7071);
	f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
	is[7] = -(int) (f_100_ * f);
	is_95_[7] = 0;
	for (int i_101_ = 0; i_101_ < 8; i_101_++) {
	    is_96_[i_101_] = (int) ((double) is[i_101_]
				    * (0.2 + 0.4 * random.nextDouble()));
	    is_97_[i_101_] = (int) ((double) is_95_[i_101_]
				    * (0.2 + 0.4 * random.nextDouble()));
	    is_98_[i_101_] = -(int) ((10.0 + 15.0 * random.nextDouble())
				     * (double) f_99_);
	}
	this.maxR = 0;
	for (int i_102_ = 0; i_102_ < 8; i_102_++) {
	    int i_103_ = i_102_ - 1;
	    if (i_103_ == -1)
		i_103_ = 7;
	    int i_104_ = i_102_ + 1;
	    if (i_104_ == 8)
		i_104_ = 0;
	    is[i_102_] = ((is[i_103_] + is[i_104_]) / 2 + is[i_102_]) / 2;
	    is_95_[i_102_]
		= ((is_95_[i_103_] + is_95_[i_104_]) / 2 + is_95_[i_102_]) / 2;
	    is_96_[i_102_]
		= ((is_96_[i_103_] + is_96_[i_104_]) / 2 + is_96_[i_102_]) / 2;
	    is_97_[i_102_]
		= ((is_97_[i_103_] + is_97_[i_104_]) / 2 + is_97_[i_102_]) / 2;
	    is_98_[i_102_]
		= ((is_98_[i_103_] + is_98_[i_104_]) / 2 + is_98_[i_102_]) / 2;
	    int i_105_ = (int) Math.sqrt((double) (is[i_102_] * is[i_102_]
						   + (is_95_[i_102_]
						      * is_95_[i_102_])));
	    if (i_105_ > this.maxR)
		this.maxR = i_105_;
	    i_105_
		= (int) Math.sqrt((double) (is_96_[i_102_] * is_96_[i_102_]
					    + is_98_[i_102_] * is_98_[i_102_]
					    + (is_97_[i_102_]
					       * is_97_[i_102_])));
	    if (i_105_ > this.maxR)
		this.maxR = i_105_;
	}
	this.disp = this.maxR / 17;
	int[] is_106_ = new int[3];
	float f_107_ = -1.0F;
	float f_108_ = (f / f_99_ - 0.33F) / 33.4F;
	if ((double) f_108_ < 0.005)
	    f_108_ = 0.0F;
	if ((double) f_108_ > 0.057)
	    f_108_ = 0.057F;
	for (int i_109_ = 0; i_109_ < 4; i_109_++) {
	    int i_110_ = i_109_ * 2;
	    int i_111_ = i_110_ + 2;
	    if (i_111_ == 8)
		i_111_ = 0;
	    int[] is_112_ = new int[6];
	    int[] is_113_ = new int[6];
	    int[] is_114_ = new int[6];
	    is_112_[0] = is[i_110_];
	    is_112_[1] = is[i_110_ + 1];
	    is_112_[2] = is[i_111_];
	    is_112_[5] = is_96_[i_110_];
	    is_112_[4] = is_96_[i_110_ + 1];
	    is_112_[3] = is_96_[i_111_];
	    is_114_[0] = is_95_[i_110_];
	    is_114_[1] = is_95_[i_110_ + 1];
	    is_114_[2] = is_95_[i_111_];
	    is_114_[5] = is_97_[i_110_];
	    is_114_[4] = is_97_[i_110_ + 1];
	    is_114_[3] = is_97_[i_111_];
	    is_113_[0] = 0;
	    is_113_[1] = 0;
	    is_113_[2] = 0;
	    is_113_[5] = is_98_[i_110_];
	    is_113_[4] = is_98_[i_110_ + 1];
	    is_113_[3] = is_98_[i_111_];
	    for (f_100_ = (float) ((0.17 - (double) f_108_)
				   * random.nextDouble());
		 ((double) Math.abs(f_107_ - f_100_)
		  < 0.03 - (double) (f_108_ * 0.176F));
		 f_100_ = (float) ((0.17 - (double) f_108_)
				   * random.nextDouble())) {
		/* empty */
	    }
	    f_107_ = f_100_;
	    for (int i_115_ = 0; i_115_ < 3; i_115_++) {
		if ((this.m).trk == 2)
		    is_106_[i_115_]
			= (int) (390.0F / (2.2F + f_100_ - f_108_));
		else
		    is_106_[i_115_]
			= (int) ((float) (((this.m).cpol
					   [i_115_])
					  + ((this.m).cgrnd
					     [i_115_]))
				 / (2.2F + f_100_ - f_108_));
	    }
	    this.p[i_109_]
		= new Plane(this.m, this.t, is_112_,
			    is_114_, is_113_, 6, is_106_, 3, -8, 0, 0, 0, 0,
			    this.disline, 0, true, 0, false);
	}
	f_100_ = (float) (0.02 * random.nextDouble());
	for (int i_116_ = 0; i_116_ < 3; i_116_++) {
	    if ((this.m).trk == 2)
		is_106_[i_116_] = (int) (390.0F / (2.15F + f_100_));
	    else
		is_106_[i_116_]
		    = (int) ((float) ((this.m).cpol[i_116_]
				      + ((this.m).cgrnd
					 [i_116_]))
			     / (2.15F + f_100_));
	}
	this.p[4]
	    = new Plane(this.m, this.t, is_96_, is_97_,
			is_98_, 8, is_106_, 3, -8, 0, 0, 0, 0,
			this.disline, 0, true, 0, false);
	int[] is_117_ = new int[2];
	int[] is_118_ = new int[2];
	for (int i_119_ = 0; i_119_ < 4; i_119_++) {
	    int i_120_ = i_119_ * 2 + 1;
	    (this.t).y[(this.t).nt]
		= is_98_[i_120_] / 2;
	    (this.t).rady[((this.t)
						.nt)]
		= Math.abs(is_98_[i_120_] / 2);
	    if (i_119_ == 0 || i_119_ == 2) {
		(this.t).z[((this.t)
						 .nt)]
		    = (is_95_[i_120_] + is_97_[i_120_]) / 2;
		(this.t).radz
		    [(this.t).nt]
		    = Math.abs(((this.t).z
				[(this.t).nt])
			       - is_95_[i_120_]);
		i_120_ = i_119_ * 2 + 2;
		if (i_120_ == 8)
		    i_120_ = 0;
		(this.t).x[((this.t)
						 .nt)]
		    = (is[i_119_ * 2] + is[i_120_]) / 2;
		(this.t).radx
		    [(this.t).nt]
		    = Math.abs(((this.t).x
				[(this.t).nt])
			       - is[i_119_ * 2]);
	    } else {
		(this.t).x[((this.t)
						 .nt)]
		    = (is[i_120_] + is_96_[i_120_]) / 2;
		(this.t).radx
		    [(this.t).nt]
		    = Math.abs(((this.t).x
				[(this.t).nt])
			       - is[i_120_]);
		i_120_ = i_119_ * 2 + 2;
		if (i_120_ == 8)
		    i_120_ = 0;
		(this.t).z[((this.t)
						 .nt)]
		    = (is_95_[i_119_ * 2] + is_95_[i_120_]) / 2;
		(this.t).radz
		    [(this.t).nt]
		    = Math.abs(((this.t).z
				[(this.t).nt])
			       - is_95_[i_119_ * 2]);
	    }
	    if (i_119_ == 0) {
		is_118_[0] = (((this.t).z
			       [(this.t).nt])
			      - ((this.t).radz
				 [(this.t).nt]));
		(this.t).zy[((this.t)
						  .nt)]
		    = (int) ((Math.atan
			      ((double) ((this.t).rady
					 [(this.t).nt])
			       / (double) ((this.t).radz
					   [((this.t)
					     .nt)])))
			     / 0.017453292519943295);
		if (((this.t).zy
		     [(this.t).nt])
		    > 40)
		    (this.t).zy
			[(this.t).nt]
			= 40;
		(this.t).xy[((this.t)
						  .nt)]
		    = 0;
	    }
	    if (i_119_ == 1) {
		is_117_[0] = (((this.t).x
			       [(this.t).nt])
			      - ((this.t).radx
				 [(this.t).nt]));
		(this.t).xy[((this.t)
						  .nt)]
		    = (int) ((Math.atan
			      ((double) ((this.t).rady
					 [(this.t).nt])
			       / (double) ((this.t).radx
					   [((this.t)
					     .nt)])))
			     / 0.017453292519943295);
		if (((this.t).xy
		     [(this.t).nt])
		    > 40)
		    (this.t).xy
			[(this.t).nt]
			= 40;
		(this.t).zy[((this.t)
						  .nt)]
		    = 0;
	    }
	    if (i_119_ == 2) {
		is_118_[1] = (((this.t).z
			       [(this.t).nt])
			      + ((this.t).radz
				 [(this.t).nt]));
		(this.t).zy[((this.t)
						  .nt)]
		    = -(int) ((Math.atan
			       ((double) ((this.t).rady
					  [(this.t).nt])
				/ (double) ((this.t).radz
					    [((this.t)
					      .nt)])))
			      / 0.017453292519943295);
		if (((this.t).zy
		     [(this.t).nt])
		    < -40)
		    (this.t).zy
			[(this.t).nt]
			= -40;
		(this.t).xy[((this.t)
						  .nt)]
		    = 0;
	    }
	    if (i_119_ == 3) {
		is_117_[1] = (((this.t).x
			       [(this.t).nt])
			      + ((this.t).radx
				 [(this.t).nt]));
		(this.t).xy[((this.t)
						  .nt)]
		    = -(int) ((Math.atan
			       ((double) ((this.t).rady
					  [(this.t).nt])
				/ (double) ((this.t).radx
					    [((this.t)
					      .nt)])))
			      / 0.017453292519943295);
		if (((this.t).xy
		     [(this.t).nt])
		    < -40)
		    (this.t).xy
			[(this.t).nt]
			= -40;
		(this.t).zy[((this.t)
						  .nt)]
		    = 0;
	    }
	    (this.t).x[(this.t).nt]
		+= this.x;
	    (this.t).z[(this.t).nt]
		+= this.z;
	    (this.t).y[(this.t).nt]
		+= this.y;
	    for (int i_121_ = 0; i_121_ < 3; i_121_++)
		(this.t).c
		    [(this.t).nt][i_121_]
		    = (this.p[i_119_]).oc[i_121_];
	    (this.t).skd[(this.t).nt]
		= 2;
	    (this.t).dam[(this.t).nt]
		= 1;
	    (this.t).notwall
		[(this.t).nt]
		= false;
	    (this.t).decor[((this.t)
						 .nt)]
		= true;
	    (this.t).rady[((this.t)
						.nt)]
		+= 10;
	    (this.t).nt++;
	}
	(this.t).y[(this.t).nt] = 0;
	for (int i_122_ = 0; i_122_ < 8; i_122_++)
	    (this.t).y[(this.t).nt]
		+= is_98_[i_122_];
	(this.t).y[(this.t).nt]
	    = ((this.t).y
	       [(this.t).nt]) / 8;
	(this.t).y[(this.t).nt]
	    += this.y;
	(this.t).rady[(this.t).nt]
	    = 200;
	(this.t).radx[(this.t).nt]
	    = is_117_[0] - is_117_[1];
	(this.t).radz[(this.t).nt]
	    = is_118_[0] - is_118_[1];
	(this.t).x[(this.t).nt]
	    = (is_117_[0] + is_117_[1]) / 2 + this.x;
	(this.t).z[(this.t).nt]
	    = (is_118_[0] + is_118_[1]) / 2 + this.z;
	(this.t).zy[(this.t).nt] = 0;
	(this.t).xy[(this.t).nt] = 0;
	for (int i_123_ = 0; i_123_ < 3; i_123_++)
	    (this.t).c
		[(this.t).nt][i_123_]
		= (this.p[4]).oc[i_123_];
	(this.t).skd[(this.t).nt]
	    = 4;
	(this.t).dam[(this.t).nt]
	    = 1;
	(this.t).notwall[(this.t).nt]
	    = false;
	(this.t).decor[(this.t).nt]
	    = true;
	(this.t).nt++;
    }
    
    public void d(Graphics2D graphics2d) {
	if (this.dist != 0)
	    this.dist = 0;
	int i = ((this.m).cx
		 + (int) (((float) (this.x
				    - (this.m).x
				    - (this.m).cx)
			   * this.m
				 .cos((this.m).xz))
			  - ((float) (this.z
				      - (this.m).z
				      - (this.m).cz)
			     * this.m
				   .sin((this.m).xz))));
	int i_124_
	    = ((this.m).cz
	       + (int) (((float) (this.x
				  - (this.m).x
				  - (this.m).cx)
			 * this.m
			       .sin((this.m).xz))
			+ ((float) (this.z
				    - (this.m).z
				    - (this.m).cz)
			   * this.m
				 .cos((this.m).xz))));
	int i_125_
	    = ((this.m).cz
	       + (int) (((float) (this.y
				  - (this.m).y
				  - (this.m).cy)
			 * this.m
			       .sin((this.m).zy))
			+ ((float) (i_124_ - (this.m).cz)
			   * this.m
				 .cos((this.m).zy))));
	int i_126_ = (xs(i + this.maxR, i_125_)
		      - xs(i - this.maxR, i_125_));
	if ((xs(i + this.maxR * 2, i_125_)
	     > (this.m).iw)
	    && (xs(i - this.maxR * 2, i_125_)
		< (this.m).w)
	    && i_125_ > -this.maxR
	    && (i_125_ < ((this.m).fade
			  [this.disline]) + this.maxR
		|| (this.m).trk != 0)
	    && (i_126_ > this.disp
		|| (this.m).trk != 0)
	    && (!this.decor
		|| ((this.m).resdown != 2
		    && (this.m).trk != 1))) {
	    if (this.shadow) {
		if (!(this.m).crs) {
		    if (i_125_ < 2000) {
			boolean bool = false;
			if ((this.t).ncx != 0
			    || (this.t).ncz != 0) {
			    int i_127_ = ((this.x
					   - (this.t).sx)
					  / 3000);
			    if (i_127_ > (this.t).ncx)
				i_127_ = (this.t).ncx;
			    if (i_127_ < 0)
				i_127_ = 0;
			    int i_128_ = ((this.z
					   - (this.t).sz)
					  / 3000);
			    if (i_128_ > (this.t).ncz)
				i_128_ = (this.t).ncz;
			    if (i_128_ < 0)
				i_128_ = 0;
			    for (int i_129_ = (((this.t)
						.sect[i_127_][i_128_]).length
					       - 1);
				 i_129_ >= 0; i_129_--) {
				int i_130_ = ((this.t)
					      .sect[i_127_][i_128_][i_129_]);
				if (Math.abs((this.t).zy
					     [i_130_]) != 90
				    && Math.abs((this.t)
						.xy[i_130_]) != 90
				    && (Math.abs(this.x
						 - ((this
								.t)).x[i_130_])
					< ((this.t).radx
					   [i_130_]) + this.maxR)
				    && (Math.abs(this.z
						 - ((this
								.t)).z[i_130_])
					< ((this.t).radz
					   [i_130_]) + this.maxR)
				    && (!((this.t).decor
					  [i_130_])
					|| ((this.m).resdown
					    != 2))) {
				    bool = true;
				    break;
				}
			    }
			}
			if (bool) {
			    for (int i_131_ = 0; i_131_ < this.npl;
				 i_131_++)
				this.p[i_131_].s
				    (graphics2d,
				     (this.x
				      - (this.m).x),
				     (this.y
				      - (this.m).y),
				     (this.z
				      - (this.m).z),
				     this.xz, this.xy,
				     this.zy, 0);
			} else {
			    int i_132_
				= ((this.m).cy
				   + (int) (((float) ((
						       this.m).ground
						      - (
							 this.m).cy)
					     * this.m.cos((
								     (
								      this).m)
								    .zy))
					    - ((float) (i_124_
							- ((
							    this.m)
							   .cz))
					       * (this.m.sin
						  ((this.m)
						   .zy)))));
			    int i_133_
				= ((this.m).cz
				   + (int) (((float) ((
						       this.m).ground
						      - (
							 this.m).cy)
					     * this.m.sin((
								     (
								      this).m)
								    .zy))
					    + ((float) (i_124_
							- ((
							    this.m)
							   .cz))
					       * (this.m.cos
						  ((this.m)
						   .zy)))));
			    if (ys(i_132_ + this.maxR, i_133_) > 0
				&& (ys(i_132_ - this.maxR, i_133_)
				    < (this.m).h)) {
				for (int i_134_ = 0;
				     i_134_ < this.npl; i_134_++)
				    this.p[i_134_].s
					(graphics2d,
					 (this.x
					  - (this.m).x),
					 (this.y
					  - (this.m).y),
					 (this.z
					  - (this.m).z),
					 this.xz, this.xy,
					 this.zy, 1);
			    }
			}
			this.m.addsp
			    (this.x - (this.m).x,
			     this.z - (this.m).z,
			     (int) ((double) this.maxR * 0.8));
		    } else
			lowshadow(graphics2d, i_125_);
		} else {
		    for (int i_135_ = 0; i_135_ < this.npl; i_135_++)
			this.p[i_135_].s
			    (graphics2d,
			     this.x - (this.m).x,
			     this.y - (this.m).y,
			     this.z - (this.m).z,
			     this.xz, this.xy,
			     this.zy, 2);
		}
	    }
	    int i_136_
		= ((this.m).cy
		   + (int) (((float) (this.y
				      - (this.m).y
				      - (this.m).cy)
			     * this.m
				   .cos((this.m).zy))
			    - ((float) (i_124_
					- (this.m).cz)
			       * this.m
				     .sin((this.m).zy))));
	    if ((ys(i_136_ + this.maxR, i_125_)
		 > (this.m).ih)
		&& (ys(i_136_ - this.maxR, i_125_)
		    < (this.m).h)) {
		if (this.elec
		    && (this.m).noelec == 0)
		    electrify(graphics2d);
		if (this.fix)
		    fixit(graphics2d);
		if (this.checkpoint != 0
		    && (this.checkpoint - 1
			== (this.m).checkpoint))
		    i_126_ = -1;
		if (this.shadow) {
		    this.dist
			= (int) (Math.sqrt
				 ((double) ((((this.m).x
					      + (this.m).cx
					      - this.x)
					     * ((this.m).x
						+ ((this.m)
						   .cx)
						- this.x))
					    + (((this.m).z
						- this.z)
					       * ((this.m).z
						  - this.z))
					    + (((this.m).y
						+ ((this.m)
						   .cy)
						- this.y)
					       * ((this.m).y
						  + (
						     this.m).cy
						  - this.y)))));
		    for (int i_137_ = 0; i_137_ < 20; i_137_++) {
			if (this.stg[i_137_] != 0)
			    pdust(i_137_, graphics2d, true);
		    }
		    dsprk(graphics2d, true);
		}
		int[] is = new int[this.npl];
		int[] is_138_ = new int[this.npl];
		for (int i_139_ = 0; i_139_ < this.npl; i_139_++)
		    is[i_139_] = 0;
		for (int i_140_ = 0; i_140_ < this.npl; i_140_++) {
		    for (int i_141_ = i_140_ + 1; i_141_ < this.npl;
			 i_141_++) {
			if ((this.p[i_140_]).av
			    != (this.p[i_141_]).av) {
			    if ((this.p[i_140_]).av
				< (this.p[i_141_]).av)
				is[i_140_]++;
			    else
				is[i_141_]++;
			} else if (i_140_ > i_141_)
			    is[i_140_]++;
			else
			    is[i_141_]++;
		    }
		    is_138_[is[i_140_]] = i_140_;
		}
		for (int i_142_ = 0; i_142_ < this.npl; i_142_++)
		    this.p[is_138_[i_142_]].d
			(graphics2d,
			 this.x - (this.m).x,
			 this.y - (this.m).y,
			 this.z - (this.m).z,
			 this.xz, this.xy,
			 this.zy, this.wxz,
			 this.wzy, this.noline, i_126_);
		if (this.shadow) {
		    for (int i_143_ = 0; i_143_ < 20; i_143_++) {
			if (this.stg[i_143_] != 0)
			    pdust(i_143_, graphics2d, false);
		    }
		    dsprk(graphics2d, false);
		}
		this.dist
		    = (int) ((Math.sqrt
			      ((double) (int) Math.sqrt
					      ((double) ((((
							    this.m).x
							   + (
							      (this
							       .m)).cx
							   - this.x)
							  * ((
							      (this
							       .m)).x
							     + (
								(this
								 .m)).cx
							     - (this
								.x)))
							 + (((
							      (this
							       .m)).z
							     - (this
								.z))
							    * ((
								(this
								 .m)).z
							       - (
								  this).z))
							 + (((
							      (this
							       .m)).y
							     + (
								(this
								 .m)).cy
							     - (this
								.y))
							    * ((
								(this
								 .m)).y
							       + (
								  (
								   this).m).cy
							       - (
								  this).y))))))
			     * (double) this.grounded);
	    }
	}
	if (this.shadow && this.dist == 0) {
	    for (int i_144_ = 0; i_144_ < 20; i_144_++) {
		if (this.stg[i_144_] != 0)
		    this.stg[i_144_] = 0;
	    }
	    for (int i_145_ = 0; i_145_ < 100; i_145_++) {
		if (this.rtg[i_145_] != 0)
		    this.rtg[i_145_] = 0;
	    }
	    if (this.sprk != 0)
		this.sprk = 0;
	}
    }
    
    public void lowshadow(Graphics2D graphics2d, int i) {
	int[] is = new int[4];
	int[] is_146_ = new int[4];
	int[] is_147_ = new int[4];
	int i_148_ = 1;
	int i_149_;
	for (i_149_ = Math.abs(this.zy); i_149_ > 270;
	     i_149_ -= 360) {
	    /* empty */
	}
	i_149_ = Math.abs(i_149_);
	if (i_149_ > 90)
	    i_148_ = -1;
	is[0] = (int) ((double) this.keyx[0] * 1.2
		       + (double) this.x
		       - (double) (this.m).x);
	is_147_[0]
	    = (int) ((double) ((this.keyz[0] + 30) * i_148_) * 1.2
		     + (double) this.z
		     - (double) (this.m).z);
	is[1] = (int) ((double) this.keyx[1] * 1.2
		       + (double) this.x
		       - (double) (this.m).x);
	is_147_[1]
	    = (int) ((double) ((this.keyz[1] + 30) * i_148_) * 1.2
		     + (double) this.z
		     - (double) (this.m).z);
	is[2] = (int) ((double) this.keyx[3] * 1.2
		       + (double) this.x
		       - (double) (this.m).x);
	is_147_[2]
	    = (int) ((double) ((this.keyz[3] - 30) * i_148_) * 1.2
		     + (double) this.z
		     - (double) (this.m).z);
	is[3] = (int) ((double) this.keyx[2] * 1.2
		       + (double) this.x
		       - (double) (this.m).x);
	is_147_[3]
	    = (int) ((double) ((this.keyz[2] - 30) * i_148_) * 1.2
		     + (double) this.z
		     - (double) (this.m).z);
	rot(is, is_147_, this.x - (this.m).x,
	    this.z - (this.m).z,
	    this.xz, 4);
	int i_150_
	    = (int) ((double) (float) (this.m).crgrnd[0]
		     / 1.5);
	int i_151_
	    = (int) ((double) (float) (this.m).crgrnd[1]
		     / 1.5);
	int i_152_
	    = (int) ((double) (float) (this.m).crgrnd[2]
		     / 1.5);
	for (int i_153_ = 0; i_153_ < 4; i_153_++)
	    is_146_[i_153_] = (this.m).ground;
	if ((this.t).ncx != 0
	    || (this.t).ncz != 0) {
	    int i_154_
		= (this.x - (this.t).sx) / 3000;
	    if (i_154_ > (this.t).ncx)
		i_154_ = (this.t).ncx;
	    if (i_154_ < 0)
		i_154_ = 0;
	    int i_155_
		= (this.z - (this.t).sz) / 3000;
	    if (i_155_ > (this.t).ncz)
		i_155_ = (this.t).ncz;
	    if (i_155_ < 0)
		i_155_ = 0;
	    for (int i_156_ = ((this.t).sect[i_154_]
			       [i_155_]).length - 1;
		 i_156_ >= 0; i_156_--) {
		int i_157_ = ((this.t).sect[i_154_]
			      [i_155_][i_156_]);
		int i_158_ = 0;
		for (int i_159_ = 0; i_159_ < 4; i_159_++) {
		    if ((Math.abs((this.t).zy[i_157_])
			 != 90)
			&& (Math.abs((this.t).xy[i_157_])
			    != 90)
			&& (this.t).rady[i_157_] != 801
			&& (Math.abs(is[i_159_]
				     - ((this.t).x[i_157_]
					- (this.m).x))
			    < (this.t).radx[i_157_])
			&& (Math.abs(is_147_[i_159_]
				     - ((this.t).z[i_157_]
					- (this.m).z))
			    < (this.t).radz[i_157_])
			&& (!(this.t).decor[i_157_]
			    || (this.m).resdown != 2))
			i_158_++;
		}
		if (i_158_ > 2) {
		    for (int i_160_ = 0; i_160_ < 4; i_160_++) {
			is_146_[i_160_]
			    = ((this.t).y[i_157_]
			       - (this.m).y);
			if ((this.t).zy[i_157_] != 0)
			    is_146_[i_160_]
				+= (((float) (is_147_[i_160_]
					      - (((this.t)
						  .z[i_157_])
						 - ((this.m)
						    .z)
						 - ((
						     this.t)
						    .radz[i_157_])))
				     * this.m.sin((
							     this.t)
							    .zy[i_157_])
				     / this.m.sin(90
							    - ((
								(this
								 .t))
							       .zy[i_157_])))
				    - ((float) ((this.t)
						.radz[i_157_])
				       * this.m.sin((
							       (this
								.t))
							      .zy[i_157_])
				       / (this.m.sin
					  (90 - ((this.t)
						 .zy[i_157_])))));
			if ((this.t).xy[i_157_] != 0)
			    is_146_[i_160_]
				+= (((float) (is[i_160_]
					      - (((this.t)
						  .x[i_157_])
						 - ((this.m)
						    .x)
						 - ((
						     this.t)
						    .radx[i_157_])))
				     * this.m.sin((
							     this.t)
							    .xy[i_157_])
				     / this.m.sin(90
							    - ((
								(this
								 .t))
							       .xy[i_157_])))
				    - ((float) ((this.t)
						.radx[i_157_])
				       * this.m.sin((
							       (this
								.t))
							      .xy[i_157_])
				       / (this.m.sin
					  (90 - ((this.t)
						 .xy[i_157_])))));
		    }
		    i_150_ = (int) ((double) (float) ((
						       this.t)
						      .c[i_157_][0])
				    / 1.5);
		    i_151_ = (int) ((double) (float) ((
						       this.t)
						      .c[i_157_][1])
				    / 1.5);
		    i_152_ = (int) ((double) (float) ((
						       this.t)
						      .c[i_157_][2])
				    / 1.5);
		    break;
		}
	    }
	}
	rot(is, is_147_, (this.m).cx,
	    (this.m).cz, (this.m).xz, 4);
	rot(is_146_, is_147_, (this.m).cy,
	    (this.m).cz, (this.m).zy, 4);
	boolean bool = true;
	int i_161_ = 0;
	int i_162_ = 0;
	int i_163_ = 0;
	int i_164_ = 0;
	for (int i_165_ = 0; i_165_ < 4; i_165_++) {
	    is[i_165_] = xs(is[i_165_], is_147_[i_165_]);
	    is_146_[i_165_] = ys(is_146_[i_165_], is_147_[i_165_]);
	    if (is_146_[i_165_] < (this.m).ih
		|| is_147_[i_165_] < 10)
		i_161_++;
	    if (is_146_[i_165_] > (this.m).h
		|| is_147_[i_165_] < 10)
		i_162_++;
	    if (is[i_165_] < (this.m).iw
		|| is_147_[i_165_] < 10)
		i_163_++;
	    if (is[i_165_] > (this.m).w
		|| is_147_[i_165_] < 10)
		i_164_++;
	}
	if (i_163_ == 4 || i_161_ == 4 || i_162_ == 4 || i_164_ == 4)
	    bool = false;
	if (bool) {
	    for (int i_166_ = 0; i_166_ < 16; i_166_++) {
		if (i > (this.m).fade[i_166_]) {
		    i_150_ = ((i_150_ * (this.m).fogd
			       + (this.m).cfade[0])
			      / ((this.m).fogd + 1));
		    i_151_ = ((i_151_ * (this.m).fogd
			       + (this.m).cfade[1])
			      / ((this.m).fogd + 1));
		    i_152_ = ((i_152_ * (this.m).fogd
			       + (this.m).cfade[2])
			      / ((this.m).fogd + 1));
		}
	    }
	    graphics2d.setColor(new Color(i_150_, i_151_, i_152_));
	    graphics2d.fillPolygon(is, is_146_, 4);
	}
    }
    
    public void fixit(Graphics2D graphics2d) {
	if (this.fcnt == 1) {
	    for (int i = 0; i < this.npl; i++) {
		(this.p[i]).hsb[0] = 0.57F;
		(this.p[i]).hsb[2] = 0.8F;
		(this.p[i]).hsb[1] = 0.8F;
		Color color
		    = Color.getHSBColor((this.p[i]).hsb[0],
					(this.p[i]).hsb[1],
					(this.p[i]).hsb[2]);
		int i_167_
		    = (int) ((float) color.getRed()
			     + ((float) color.getRed()
				* ((float) (this.m).snap[0]
				   / 100.0F)));
		if (i_167_ > 255)
		    i_167_ = 255;
		if (i_167_ < 0)
		    i_167_ = 0;
		int i_168_
		    = (int) ((float) color.getGreen()
			     + ((float) color.getGreen()
				* ((float) (this.m).snap[1]
				   / 100.0F)));
		if (i_168_ > 255)
		    i_168_ = 255;
		if (i_168_ < 0)
		    i_168_ = 0;
		int i_169_
		    = (int) ((float) color.getBlue()
			     + ((float) color.getBlue()
				* ((float) (this.m).snap[2]
				   / 100.0F)));
		if (i_169_ > 255)
		    i_169_ = 255;
		if (i_169_ < 0)
		    i_169_ = 0;
		Color.RGBtoHSB(i_167_, i_168_, i_169_,
			       (this.p[i]).hsb);
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
	if ((this.fcnt == 1 || this.fcnt > 2)
	    && this.fcnt != 9) {
	    int[] is = new int[8];
	    int[] is_170_ = new int[8];
	    int[] is_171_ = new int[4];
	    for (int i = 0; i < 4; i++) {
		is[i] = (this.keyx[i] + this.x
			 - (this.m).x);
		is_170_[i] = (this.grat + this.y
			      - (this.m).y);
		is_171_[i] = (this.keyz[i] + this.z
			      - (this.m).z);
	    }
	    rot(is, is_170_, this.x - (this.m).x,
		this.y - (this.m).y,
		this.xy, 4);
	    rot(is_170_, is_171_,
		this.y - (this.m).y,
		this.z - (this.m).y,
		this.zy, 4);
	    rot(is, is_171_, this.x - (this.m).x,
		this.z - (this.m).z,
		this.xz, 4);
	    rot(is, is_171_, (this.m).cx,
		(this.m).cz, (this.m).xz,
		4);
	    rot(is_170_, is_171_, (this.m).cy,
		(this.m).cz, (this.m).zy,
		4);
	    int i = 0;
	    int i_172_ = 0;
	    int i_173_ = 0;
	    for (int i_174_ = 0; i_174_ < 4; i_174_++) {
		for (int i_175_ = 0; i_175_ < 4; i_175_++) {
		    if (Math.abs(is[i_174_] - is[i_175_]) > i)
			i = Math.abs(is[i_174_] - is[i_175_]);
		    if (Math.abs(is_170_[i_174_] - is_170_[i_175_]) > i_172_)
			i_172_ = Math.abs(is_170_[i_174_] - is_170_[i_175_]);
		    if (py(is[i_174_], is[i_175_], is_170_[i_174_],
			   is_170_[i_175_])
			> i_173_)
			i_173_ = py(is[i_174_], is[i_175_], is_170_[i_174_],
				    is_170_[i_175_]);
		}
	    }
	    i_173_ = (int) (Math.sqrt((double) i_173_) / 1.5);
	    if (i < i_173_)
		i = i_173_;
	    if (i_172_ < i_173_)
		i_172_ = i_173_;
	    int i_176_
		= ((this.m).cx
		   + (int) (((float) (this.x
				      - (this.m).x
				      - (this.m).cx)
			     * this.m
				   .cos((this.m).xz))
			    - ((float) (this.z
					- (this.m).z
					- (this.m).cz)
			       * this.m
				     .sin((this.m).xz))));
	    int i_177_
		= ((this.m).cz
		   + (int) (((float) (this.x
				      - (this.m).x
				      - (this.m).cx)
			     * this.m
				   .sin((this.m).xz))
			    + ((float) (this.z
					- (this.m).z
					- (this.m).cz)
			       * this.m
				     .cos((this.m).xz))));
	    int i_178_
		= ((this.m).cy
		   + (int) (((float) (this.y
				      - (this.m).y
				      - (this.m).cy)
			     * this.m
				   .cos((this.m).zy))
			    - ((float) (i_177_
					- (this.m).cz)
			       * this.m
				     .sin((this.m).zy))));
	    i_177_
		= ((this.m).cz
		   + (int) (((float) (this.y
				      - (this.m).y
				      - (this.m).cy)
			     * this.m
				   .sin((this.m).zy))
			    + ((float) (i_177_
					- (this.m).cz)
			       * this.m
				     .cos((this.m).zy))));
	    is[0]
		= xs((int) ((double) i_176_ - (double) i / 0.8
			    - (double) this.m.random() * ((double) i
								    / 2.4)),
		     i_177_);
	    is_170_[0] = ys((int) ((double) i_178_ - (double) i_172_ / 1.92
				   - ((double) this.m.random()
				      * ((double) i_172_ / 5.67))),
			    i_177_);
	    is[1]
		= xs((int) ((double) i_176_ - (double) i / 0.8
			    - (double) this.m.random() * ((double) i
								    / 2.4)),
		     i_177_);
	    is_170_[1] = ys((int) ((double) i_178_ + (double) i_172_ / 1.92
				   + ((double) this.m.random()
				      * ((double) i_172_ / 5.67))),
			    i_177_);
	    is[2]
		= xs((int) ((double) i_176_ - (double) i / 1.92
			    - (double) this.m.random() * ((double) i
								    / 5.67)),
		     i_177_);
	    is_170_[2] = ys((int) ((double) i_178_ + (double) i_172_ / 0.8
				   + ((double) this.m.random()
				      * ((double) i_172_ / 2.4))),
			    i_177_);
	    is[3]
		= xs((int) ((double) i_176_ + (double) i / 1.92
			    + (double) this.m.random() * ((double) i
								    / 5.67)),
		     i_177_);
	    is_170_[3] = ys((int) ((double) i_178_ + (double) i_172_ / 0.8
				   + ((double) this.m.random()
				      * ((double) i_172_ / 2.4))),
			    i_177_);
	    is[4]
		= xs((int) ((double) i_176_ + (double) i / 0.8
			    + (double) this.m.random() * ((double) i
								    / 2.4)),
		     i_177_);
	    is_170_[4] = ys((int) ((double) i_178_ + (double) i_172_ / 1.92
				   + ((double) this.m.random()
				      * ((double) i_172_ / 5.67))),
			    i_177_);
	    is[5]
		= xs((int) ((double) i_176_ + (double) i / 0.8
			    + (double) this.m.random() * ((double) i
								    / 2.4)),
		     i_177_);
	    is_170_[5] = ys((int) ((double) i_178_ - (double) i_172_ / 1.92
				   - ((double) this.m.random()
				      * ((double) i_172_ / 5.67))),
			    i_177_);
	    is[6]
		= xs((int) ((double) i_176_ + (double) i / 1.92
			    + (double) this.m.random() * ((double) i
								    / 5.67)),
		     i_177_);
	    is_170_[6] = ys((int) ((double) i_178_ - (double) i_172_ / 0.8
				   - ((double) this.m.random()
				      * ((double) i_172_ / 2.4))),
			    i_177_);
	    is[7]
		= xs((int) ((double) i_176_ - (double) i / 1.92
			    - (double) this.m.random() * ((double) i
								    / 5.67)),
		     i_177_);
	    is_170_[7] = ys((int) ((double) i_178_ - (double) i_172_ / 0.8
				   - ((double) this.m.random()
				      * ((double) i_172_ / 2.4))),
			    i_177_);
	    if (this.fcnt == 3)
		rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), 22,
		    8);
	    if (this.fcnt == 4)
		rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), 22,
		    8);
	    if (this.fcnt == 5)
		rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), 0, 8);
	    if (this.fcnt == 6)
		rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), -22,
		    8);
	    if (this.fcnt == 7)
		rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), -22,
		    8);
	    int i_179_
		= (int) (191.0F
			 + (191.0F
			    * ((float) (this.m).snap[0]
			       / 350.0F)));
	    if (i_179_ > 255)
		i_179_ = 255;
	    if (i_179_ < 0)
		i_179_ = 0;
	    int i_180_
		= (int) (232.0F
			 + (232.0F
			    * ((float) (this.m).snap[1]
			       / 350.0F)));
	    if (i_180_ > 255)
		i_180_ = 255;
	    if (i_180_ < 0)
		i_180_ = 0;
	    int i_181_
		= (int) (255.0F
			 + (255.0F
			    * ((float) (this.m).snap[2]
			       / 350.0F)));
	    if (i_181_ > 255)
		i_181_ = 255;
	    if (i_181_ < 0)
		i_181_ = 0;
	    graphics2d.setColor(new Color(i_179_, i_180_, i_181_));
	    graphics2d.fillPolygon(is, is_170_, 8);
	    is[0] = xs((int) ((float) (i_176_ - i)
			      - this.m.random() * (float) (i / 4)),
		       i_177_);
	    is_170_[0] = ys((int) ((double) i_178_ - (double) i_172_ / 2.4
				   - ((double) this.m.random()
				      * ((double) i_172_ / 9.6))),
			    i_177_);
	    is[1] = xs((int) ((float) (i_176_ - i)
			      - this.m.random() * (float) (i / 4)),
		       i_177_);
	    is_170_[1] = ys((int) ((double) i_178_ + (double) i_172_ / 2.4
				   + ((double) this.m.random()
				      * ((double) i_172_ / 9.6))),
			    i_177_);
	    is[2]
		= xs((int) ((double) i_176_ - (double) i / 2.4
			    - (double) this.m.random() * ((double) i
								    / 9.6)),
		     i_177_);
	    is_170_[2]
		= ys((int) ((float) (i_178_ + i_172_)
			    + this.m.random() * (float) (i_172_
								   / 4)),
		     i_177_);
	    is[3]
		= xs((int) ((double) i_176_ + (double) i / 2.4
			    + (double) this.m.random() * ((double) i
								    / 9.6)),
		     i_177_);
	    is_170_[3]
		= ys((int) ((float) (i_178_ + i_172_)
			    + this.m.random() * (float) (i_172_
								   / 4)),
		     i_177_);
	    is[4] = xs((int) ((float) (i_176_ + i)
			      + this.m.random() * (float) (i / 4)),
		       i_177_);
	    is_170_[4] = ys((int) ((double) i_178_ + (double) i_172_ / 2.4
				   + ((double) this.m.random()
				      * ((double) i_172_ / 9.6))),
			    i_177_);
	    is[5] = xs((int) ((float) (i_176_ + i)
			      + this.m.random() * (float) (i / 4)),
		       i_177_);
	    is_170_[5] = ys((int) ((double) i_178_ - (double) i_172_ / 2.4
				   - ((double) this.m.random()
				      * ((double) i_172_ / 9.6))),
			    i_177_);
	    is[6]
		= xs((int) ((double) i_176_ + (double) i / 2.4
			    + (double) this.m.random() * ((double) i
								    / 9.6)),
		     i_177_);
	    is_170_[6]
		= ys((int) ((float) (i_178_ - i_172_)
			    - this.m.random() * (float) (i_172_
								   / 4)),
		     i_177_);
	    is[7]
		= xs((int) ((double) i_176_ - (double) i / 2.4
			    - (double) this.m.random() * ((double) i
								    / 9.6)),
		     i_177_);
	    is_170_[7]
		= ys((int) ((float) (i_178_ - i_172_)
			    - this.m.random() * (float) (i_172_
								   / 4)),
		     i_177_);
	    i_179_ = (int) (213.0F
			    + (213.0F
			       * ((float) (this.m).snap[0]
				  / 350.0F)));
	    if (i_179_ > 255)
		i_179_ = 255;
	    if (i_179_ < 0)
		i_179_ = 0;
	    i_180_ = (int) (239.0F
			    + (239.0F
			       * ((float) (this.m).snap[1]
				  / 350.0F)));
	    if (i_180_ > 255)
		i_180_ = 255;
	    if (i_180_ < 0)
		i_180_ = 0;
	    i_181_ = (int) (255.0F
			    + (255.0F
			       * ((float) (this.m).snap[2]
				  / 350.0F)));
	    if (i_181_ > 255)
		i_181_ = 255;
	    if (i_181_ < 0)
		i_181_ = 0;
	    graphics2d.setColor(new Color(i_179_, i_180_, i_181_));
	    graphics2d.fillPolygon(is, is_170_, 8);
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
		this.edl[i]
		    = (int) (380.0F - this.m.random() * 760.0F);
		this.edr[i]
		    = (int) (380.0F - this.m.random() * 760.0F);
		this.elc[i] = 1;
	    }
	    int i_182_
		= (int) ((float) this.edl[i]
			 + (190.0F - this.m.random() * 380.0F));
	    int i_183_
		= (int) ((float) this.edr[i]
			 + (190.0F - this.m.random() * 380.0F));
	    int i_184_ = (int) (this.m.random() * 126.0F);
	    int i_185_ = (int) (this.m.random() * 126.0F);
	    int[] is = new int[8];
	    int[] is_186_ = new int[8];
	    int[] is_187_ = new int[8];
	    for (int i_188_ = 0; i_188_ < 8; i_188_++)
		is_187_[i_188_]
		    = this.z - (this.m).z;
	    is[0] = this.x - (this.m).x - 504;
	    is_186_[0] = (this.y - (this.m).y
			  - this.edl[i] - 5
			  - (int) (this.m.random() * 5.0F));
	    is[1] = (this.x - (this.m).x - 252
		     + i_185_);
	    is_186_[1]
		= (this.y - (this.m).y - i_182_
		   - 5 - (int) (this.m.random() * 5.0F));
	    is[2] = (this.x - (this.m).x + 252
		     - i_184_);
	    is_186_[2]
		= (this.y - (this.m).y - i_183_
		   - 5 - (int) (this.m.random() * 5.0F));
	    is[3] = this.x - (this.m).x + 504;
	    is_186_[3] = (this.y - (this.m).y
			  - this.edr[i] - 5
			  - (int) (this.m.random() * 5.0F));
	    is[4] = this.x - (this.m).x + 504;
	    is_186_[4] = (this.y - (this.m).y
			  - this.edr[i] + 5
			  + (int) (this.m.random() * 5.0F));
	    is[5] = (this.x - (this.m).x + 252
		     - i_184_);
	    is_186_[5]
		= (this.y - (this.m).y - i_183_
		   + 5 + (int) (this.m.random() * 5.0F));
	    is[6] = (this.x - (this.m).x - 252
		     + i_185_);
	    is_186_[6]
		= (this.y - (this.m).y - i_182_
		   + 5 + (int) (this.m.random() * 5.0F));
	    is[7] = this.x - (this.m).x - 504;
	    is_186_[7] = (this.y - (this.m).y
			  - this.edl[i] + 5
			  + (int) (this.m.random() * 5.0F));
	    if (this.roted)
		rot(is, is_187_,
		    this.x - (this.m).x,
		    this.z - (this.m).z, 90, 8);
	    rot(is, is_187_, (this.m).cx,
		(this.m).cz, (this.m).xz,
		8);
	    rot(is_186_, is_187_, (this.m).cy,
		(this.m).cz, (this.m).zy,
		8);
	    boolean bool = true;
	    int i_189_ = 0;
	    int i_190_ = 0;
	    int i_191_ = 0;
	    int i_192_ = 0;
	    int[] is_193_ = new int[8];
	    int[] is_194_ = new int[8];
	    for (int i_195_ = 0; i_195_ < 8; i_195_++) {
		is_193_[i_195_] = xs(is[i_195_], is_187_[i_195_]);
		is_194_[i_195_] = ys(is_186_[i_195_], is_187_[i_195_]);
		if (is_194_[i_195_] < (this.m).ih
		    || is_187_[i_195_] < 10)
		    i_189_++;
		if (is_194_[i_195_] > (this.m).h
		    || is_187_[i_195_] < 10)
		    i_190_++;
		if (is_193_[i_195_] < (this.m).iw
		    || is_187_[i_195_] < 10)
		    i_191_++;
		if (is_193_[i_195_] > (this.m).w
		    || is_187_[i_195_] < 10)
		    i_192_++;
	    }
	    if (i_191_ == 8 || i_189_ == 8 || i_190_ == 8 || i_192_ == 8)
		bool = false;
	    if (bool) {
		int i_196_
		    = (int) (160.0F
			     + (160.0F
				* ((float) (this.m).snap[0]
				   / 500.0F)));
		if (i_196_ > 255)
		    i_196_ = 255;
		if (i_196_ < 0)
		    i_196_ = 0;
		int i_197_
		    = (int) (238.0F
			     + (238.0F
				* ((float) (this.m).snap[1]
				   / 500.0F)));
		if (i_197_ > 255)
		    i_197_ = 255;
		if (i_197_ < 0)
		    i_197_ = 0;
		int i_198_
		    = (int) (255.0F
			     + (255.0F
				* ((float) (this.m).snap[2]
				   / 500.0F)));
		if (i_198_ > 255)
		    i_198_ = 255;
		if (i_198_ < 0)
		    i_198_ = 0;
		i_196_ = ((i_196_ * 2 + 214 * (this.elc[i] - 1))
			  / (this.elc[i] + 1));
		i_197_ = ((i_197_ * 2 + 236 * (this.elc[i] - 1))
			  / (this.elc[i] + 1));
		if ((this.m).trk == 1) {
		    i_196_ = 255;
		    i_197_ = 128;
		    i_198_ = 0;
		}
		graphics2d.setColor(new Color(i_196_, i_197_, i_198_));
		graphics2d.fillPolygon(is_193_, is_194_, 8);
		if (is_187_[0] < 4000) {
		    i_196_
			= (int) (150.0F
				 + 150.0F * ((float) (
						      this.m).snap[0]
					     / 500.0F));
		    if (i_196_ > 255)
			i_196_ = 255;
		    if (i_196_ < 0)
			i_196_ = 0;
		    i_197_
			= (int) (227.0F
				 + 227.0F * ((float) (
						      this.m).snap[1]
					     / 500.0F));
		    if (i_197_ > 255)
			i_197_ = 255;
		    if (i_197_ < 0)
			i_197_ = 0;
		    i_198_
			= (int) (255.0F
				 + 255.0F * ((float) (
						      this.m).snap[2]
					     / 500.0F));
		    if (i_198_ > 255)
			i_198_ = 255;
		    if (i_198_ < 0)
			i_198_ = 0;
		    graphics2d.setColor(new Color(i_196_, i_197_, i_198_));
		    graphics2d.drawPolygon(is_193_, is_194_, 8);
		}
	    }
	    if ((float) this.elc[i]
		> this.m.random() * 60.0F)
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
    
    public void dust(int i, float f, float f_199_, float f_200_, int i_201_,
		     int i_202_, float f_203_, int i_204_, boolean bool) {
	boolean bool_205_ = false;
	if (i_204_ > 5 && (i == 0 || i == 2))
	    bool_205_ = true;
	if (i_204_ < -5 && (i == 1 || i == 3))
	    bool_205_ = true;
	float f_206_
	    = (float) ((Math.sqrt((double) (i_201_ * i_201_ + i_202_ * i_202_))
			- 40.0)
		       / 160.0);
	if (f_206_ > 1.0F)
	    f_206_ = 1.0F;
	if ((double) f_206_ > 0.2 && !bool_205_) {
	    this.ust++;
	    if (this.ust == 20)
		this.ust = 0;
	    if (!bool) {
		float f_207_ = this.m.random();
		this.sx[this.ust]
		    = (int) ((f + (float) this.x * f_207_)
			     / (1.0F + f_207_));
		this.sz[this.ust]
		    = (int) ((f_200_ + (float) this.z * f_207_)
			     / (1.0F + f_207_));
		this.sy[this.ust]
		    = (int) ((f_199_ + (float) this.y * f_207_)
			     / (1.0F + f_207_));
	    } else {
		this.sx[this.ust]
		    = (int) ((f + (float) (this.x + i_201_)) / 2.0F);
		this.sz[this.ust]
		    = (int) ((f_200_ + (float) (this.z + i_202_))
			     / 2.0F);
		this.sy[this.ust] = (int) f_199_;
	    }
	    if (this.sy[i] > 250)
		this.sy[i] = 250;
	    this.osmag[this.ust] = f_203_ * f_206_;
	    this.scx[this.ust] = i_201_;
	    this.scz[this.ust] = i_202_;
	    this.stg[this.ust] = 1;
	}
    }
    
    public void pdust(int i, Graphics2D graphics2d, boolean bool) {
	if (bool)
	    this.sav[i]
		= (int) (Math.sqrt
			 ((double) ((((this.m).x
				      + (this.m).cx
				      - this.sx[i])
				     * ((this.m).x
					+ (this.m).cx
					- this.sx[i]))
				    + (((this.m).y
					+ (this.m).cy
					- this.sy[i])
				       * ((this.m).y
					  + (this.m).cy
					  - this.sy[i]))
				    + (((this.m).z
					- this.sz[i])
				       * ((this.m).z
					  - this.sz[i])))));
	if (bool && this.sav[i] > this.dist
	    || !bool && this.sav[i] <= this.dist) {
	    if (this.stg[i] == 1) {
		this.sbln[i] = 0.6F;
		boolean bool_208_ = false;
		int[] is = new int[3];
		for (int i_209_ = 0; i_209_ < 3; i_209_++) {
		    is[i_209_]
			= (int) (255.0F + 255.0F * ((float) ((
							      this.m)
							     .snap[i_209_])
						    / 100.0F));
		    if (is[i_209_] > 255)
			is[i_209_] = 255;
		    if (is[i_209_] < 0)
			is[i_209_] = 0;
		}
		int i_210_
		    = ((this.x - (this.t).sx)
		       / 3000);
		if (i_210_ > (this.t).ncx)
		    i_210_ = (this.t).ncx;
		if (i_210_ < 0)
		    i_210_ = 0;
		int i_211_
		    = ((this.z - (this.t).sz)
		       / 3000);
		if (i_211_ > (this.t).ncz)
		    i_211_ = (this.t).ncz;
		if (i_211_ < 0)
		    i_211_ = 0;
		for (int i_212_ = 0;
		     i_212_ < ((this.t).sect[i_210_]
			       [i_211_]).length;
		     i_212_++) {
		    int i_213_ = ((this.t).sect[i_210_]
				  [i_211_][i_212_]);
		    if ((Math.abs((this.t).zy[i_213_])
			 != 90)
			&& (Math.abs((this.t).xy[i_213_])
			    != 90)
			&& (Math.abs(this.sx[i]
				     - (this.t).x[i_213_])
			    < (this.t).radx[i_213_])
			&& (Math.abs(this.sz[i]
				     - (this.t).z[i_213_])
			    < (this.t).radz[i_213_])) {
			if ((this.t).skd[i_213_] == 0)
			    this.sbln[i] = 0.2F;
			if ((this.t).skd[i_213_] == 1)
			    this.sbln[i] = 0.4F;
			if ((this.t).skd[i_213_] == 2)
			    this.sbln[i] = 0.45F;
			for (int i_214_ = 0; i_214_ < 3; i_214_++)
			    this.srgb[i][i_214_]
				= (((this.t).c[i_213_]
				    [i_214_])
				   + is[i_214_]) / 2;
			bool_208_ = true;
		    }
		}
		if (!bool_208_) {
		    for (int i_215_ = 0; i_215_ < 3; i_215_++)
			this.srgb[i][i_215_]
			    = ((this.m).crgrnd[i_215_]
			       + is[i_215_]) / 2;
		}
		float f = (float) (0.1 + (double) this.m.random());
		if (f > 1.0F)
		    f = 1.0F;
		this.scx[i]
		    = (int) ((float) this.scx[i] * f);
		this.scz[i]
		    = (int) ((float) this.scx[i] * f);
		for (int i_216_ = 0; i_216_ < 8; i_216_++)
		    this.smag[i][i_216_]
			= (this.osmag[i] * this.m.random()
			   * 50.0F);
		for (int i_217_ = 0; i_217_ < 8; i_217_++) {
		    int i_218_ = i_217_ - 1;
		    if (i_218_ == -1)
			i_218_ = 7;
		    int i_219_ = i_217_ + 1;
		    if (i_219_ == 8)
			i_219_ = 0;
		    this.smag[i][i_217_]
			= ((this.smag[i][i_218_]
			    + this.smag[i][i_219_]) / 2.0F
			   + this.smag[i][i_217_]) / 2.0F;
		}
		this.smag[i][6] = this.smag[i][7];
	    }
	    int i_220_
		= ((this.m).cx
		   + (int) (((float) (this.sx[i]
				      - (this.m).x
				      - (this.m).cx)
			     * this.m
				   .cos((this.m).xz))
			    - ((float) (this.sz[i]
					- (this.m).z
					- (this.m).cz)
			       * this.m
				     .sin((this.m).xz))));
	    int i_221_
		= ((this.m).cz
		   + (int) (((float) (this.sx[i]
				      - (this.m).x
				      - (this.m).cx)
			     * this.m
				   .sin((this.m).xz))
			    + ((float) (this.sz[i]
					- (this.m).z
					- (this.m).cz)
			       * this.m
				     .cos((this.m).xz))));
	    int i_222_
		= ((this.m).cy
		   + (int) ((((float) (this.sy[i]
				       - (this.m).y
				       - (this.m).cy)
			      - this.smag[i][7])
			     * this.m
				   .cos((this.m).zy))
			    - ((float) (i_221_
					- (this.m).cz)
			       * this.m
				     .sin((this.m).zy))));
	    i_221_
		= ((this.m).cz
		   + (int) ((((float) (this.sy[i]
				       - (this.m).y
				       - (this.m).cy)
			      - this.smag[i][7])
			     * this.m
				   .sin((this.m).zy))
			    + ((float) (i_221_
					- (this.m).cz)
			       * this.m
				     .cos((this.m).zy))));
	    this.sx[i]
		+= this.scx[i] / (this.stg[i] + 1);
	    this.sz[i]
		+= this.scz[i] / (this.stg[i] + 1);
	    int[] is = new int[8];
	    int[] is_223_ = new int[8];
	    is[0] = xs((int) ((float) i_220_
			      + this.smag[i][0] * 0.9238F * 1.5F),
		       i_221_);
	    is_223_[0]
		= ys((int) ((float) i_222_
			    + this.smag[i][0] * 0.3826F * 1.5F),
		     i_221_);
	    is[1] = xs((int) ((float) i_220_
			      + this.smag[i][1] * 0.9238F * 1.5F),
		       i_221_);
	    is_223_[1]
		= ys((int) ((float) i_222_
			    - this.smag[i][1] * 0.3826F * 1.5F),
		     i_221_);
	    is[2] = xs((int) ((float) i_220_
			      + this.smag[i][2] * 0.3826F),
		       i_221_);
	    is_223_[2] = ys((int) ((float) i_222_
				   - this.smag[i][2] * 0.9238F),
			    i_221_);
	    is[3] = xs((int) ((float) i_220_
			      - this.smag[i][3] * 0.3826F),
		       i_221_);
	    is_223_[3] = ys((int) ((float) i_222_
				   - this.smag[i][3] * 0.9238F),
			    i_221_);
	    is[4] = xs((int) ((float) i_220_
			      - this.smag[i][4] * 0.9238F * 1.5F),
		       i_221_);
	    is_223_[4]
		= ys((int) ((float) i_222_
			    - this.smag[i][4] * 0.3826F * 1.5F),
		     i_221_);
	    is[5] = xs((int) ((float) i_220_
			      - this.smag[i][5] * 0.9238F * 1.5F),
		       i_221_);
	    is_223_[5]
		= ys((int) ((float) i_222_
			    + this.smag[i][5] * 0.3826F * 1.5F),
		     i_221_);
	    is[6] = xs((int) ((float) i_220_
			      - this.smag[i][6] * 0.3826F * 1.7F),
		       i_221_);
	    is_223_[6] = ys((int) ((float) i_222_
				   + this.smag[i][6] * 0.9238F),
			    i_221_);
	    is[7] = xs((int) ((float) i_220_
			      + this.smag[i][7] * 0.3826F * 1.7F),
		       i_221_);
	    is_223_[7] = ys((int) ((float) i_222_
				   + this.smag[i][7] * 0.9238F),
			    i_221_);
	    for (int i_224_ = 0; i_224_ < 7; i_224_++)
		this.smag[i][i_224_]
		    += 5.0F + this.m.random() * 15.0F;
	    this.smag[i][7] = this.smag[i][6];
	    boolean bool_225_ = true;
	    int i_226_ = 0;
	    int i_227_ = 0;
	    int i_228_ = 0;
	    int i_229_ = 0;
	    for (int i_230_ = 0; i_230_ < 8; i_230_++) {
		if (is_223_[i_230_] < (this.m).ih
		    || i_221_ < 10)
		    i_226_++;
		if (is_223_[i_230_] > (this.m).h
		    || i_221_ < 10)
		    i_227_++;
		if (is[i_230_] < (this.m).iw || i_221_ < 10)
		    i_228_++;
		if (is[i_230_] > (this.m).w || i_221_ < 10)
		    i_229_++;
	    }
	    if (i_228_ == 4 || i_226_ == 4 || i_227_ == 4 || i_229_ == 4)
		bool_225_ = false;
	    if (bool_225_) {
		int i_231_ = this.srgb[i][0];
		int i_232_ = this.srgb[i][1];
		int i_233_ = this.srgb[i][2];
		for (int i_234_ = 0; i_234_ < 16; i_234_++) {
		    if (this.sav[i]
			> (this.m).fade[i_234_]) {
			i_231_ = ((i_231_ * (this.m).fogd
				   + (this.m).cfade[0])
				  / ((this.m).fogd + 1));
			i_232_ = ((i_232_ * (this.m).fogd
				   + (this.m).cfade[1])
				  / ((this.m).fogd + 1));
			i_233_ = ((i_233_ * (this.m).fogd
				   + (this.m).cfade[2])
				  / ((this.m).fogd + 1));
		    }
		}
		graphics2d.setColor(new Color(i_231_, i_232_, i_233_));
		float f = (this.sbln[i]
			   - ((float) this.stg[i]
			      * (this.sbln[i] / 8.0F)));
		graphics2d.setComposite(AlphaComposite.getInstance(3, f));
		graphics2d.fillPolygon(is, is_223_, 8);
		graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
	    }
	    if (this.stg[i] == 7)
		this.stg[i] = 0;
	    else
		this.stg[i]++;
	}
    }
    
    public void sprk(float f, float f_235_, float f_236_, float f_237_,
		     float f_238_, float f_239_, int i) {
	if (i != 1) {
	    this.srx
		= (int) (f - ((float) this.sprkat
			      * this.m.sin(this.xz)));
	    this.sry
		= (int) (f_235_ - ((float) this.sprkat
				   * this.m.cos(this.zy)
				   * this.m.cos(this.xy)));
	    this.srz
		= (int) (f_236_ + ((float) this.sprkat
				   * this.m.cos(this.xz)));
	    this.sprk = 1;
	} else {
	    this.sprk++;
	    if (this.sprk == 4) {
		this.srx = (int) ((float) this.x + f_237_);
		this.sry = (int) f_235_;
		this.srz = (int) ((float) this.z + f_239_);
		this.sprk = 5;
	    } else {
		this.srx = (int) f;
		this.sry = (int) f_235_;
		this.srz = (int) f_236_;
	    }
	}
	if (i == 2)
	    this.sprk = 6;
	this.rcx = f_237_;
	this.rcy = f_238_;
	this.rcz = f_239_;
    }
    
    public void dsprk(Graphics2D graphics2d, boolean bool) {
	if (bool && this.sprk != 0) {
	    int i = (int) (Math.sqrt((double) ((this.rcx
						* this.rcx)
					       + (this.rcy
						  * this.rcy)
					       + (this.rcz
						  * this.rcz)))
			   / 10.0);
	    if (i > 5) {
		boolean bool_240_ = false;
		if ((double) this.dist
		    < Math.sqrt((double) ((((this.m).x
					    + (this.m).cx
					    - this.srx)
					   * ((this.m).x
					      + (this.m).cx
					      - this.srx))
					  + (((this.m).y
					      + (this.m).cy
					      - this.sry)
					     * ((this.m).y
						+ ((this.m)
						   .cy)
						- this.sry))
					  + (((this.m).z
					      - this.srz)
					     * ((this.m).z
						- this.srz)))))
		    bool_240_ = true;
		if (i > 33)
		    i = 33;
		int i_241_ = 0;
		for (int i_242_ = 0; i_242_ < 100; i_242_++) {
		    if (this.rtg[i_242_] == 0) {
			this.rtg[i_242_] = 1;
			this.rbef[i_242_] = bool_240_;
			i_241_++;
		    }
		    if (i_241_ == i)
			break;
		}
	    }
	}
	for (int i = 0; i < 100; i++) {
	    if (this.rtg[i] != 0
		&& (this.rbef[i] && bool
		    || !this.rbef[i] && !bool)) {
		if (this.rtg[i] == 1) {
		    if (this.sprk < 5) {
			this.rx[i]
			    = (this.srx + 3
			       - (int) ((double) this.m.random()
					* 6.7));
			this.ry[i]
			    = (this.sry + 3
			       - (int) ((double) this.m.random()
					* 6.7));
			this.rz[i]
			    = (this.srz + 3
			       - (int) ((double) this.m.random()
					* 6.7));
		    } else {
			this.rx[i]
			    = (this.srx + 10
			       - (int) (this.m.random() * 20.0F));
			this.ry[i]
			    = (this.sry
			       - (int) (this.m.random() * 4.0F));
			this.rz[i]
			    = (this.srz + 10
			       - (int) (this.m.random() * 20.0F));
		    }
		    int i_243_
			= (int) Math.sqrt((double) ((this.rcx
						     * this.rcx)
						    + (this.rcy
						       * this.rcy)
						    + (this.rcz
						       * this.rcz)));
		    float f = 0.2F + 0.4F * this.m.random();
		    float f_244_ = (this.m.random()
				    * this.m.random()
				    * this.m.random());
		    float f_245_ = 1.0F;
		    if (this.m.random()
			> this.m.random()) {
			if (this.m.random()
			    > this.m.random())
			    f_245_ *= -1.0F;
			this.vrx[i]
			    = -((this.rcx
				 + ((float) i_243_
				    * (1.0F
				       - this.rcx / (float) i_243_)
				    * f_244_ * f_245_))
				* f);
		    }
		    if (this.m.random()
			> this.m.random()) {
			if (this.m.random()
			    > this.m.random())
			    f_245_ *= -1.0F;
			if (this.sprk == 5)
			    f_245_ = 1.0F;
			this.vry[i]
			    = -((this.rcy
				 + ((float) i_243_
				    * (1.0F
				       - this.rcy / (float) i_243_)
				    * f_244_ * f_245_))
				* f);
		    }
		    if (this.m.random()
			> this.m.random()) {
			if (this.m.random()
			    > this.m.random())
			    f_245_ *= -1.0F;
			this.vrz[i]
			    = -((this.rcz
				 + ((float) i_243_
				    * (1.0F
				       - this.rcz / (float) i_243_)
				    * f_244_ * f_245_))
				* f);
		    }
		}
		this.rx[i] += this.vrx[i];
		this.ry[i] += this.vry[i];
		this.rz[i] += this.vrz[i];
		int i_246_
		    = ((this.m).cx
		       + (int) (((float) (this.rx[i]
					  - (this.m).x
					  - (this.m).cx)
				 * this.m
				       .cos((this.m).xz))
				- ((float) (this.rz[i]
					    - (this.m).z
					    - (this.m).cz)
				   * this.m.sin((
							   this.m)
							  .xz))));
		int i_247_
		    = ((this.m).cz
		       + (int) (((float) (this.rx[i]
					  - (this.m).x
					  - (this.m).cx)
				 * this.m
				       .sin((this.m).xz))
				+ ((float) (this.rz[i]
					    - (this.m).z
					    - (this.m).cz)
				   * this.m.cos((
							   this.m)
							  .xz))));
		int i_248_
		    = ((this.m).cy
		       + (int) (((float) (this.ry[i]
					  - (this.m).y
					  - (this.m).cy)
				 * this.m
				       .cos((this.m).zy))
				- ((float) (i_247_
					    - (this.m).cz)
				   * this.m.sin((
							   this.m)
							  .zy))));
		i_247_
		    = ((this.m).cz
		       + (int) (((float) (this.ry[i]
					  - (this.m).y
					  - (this.m).cy)
				 * this.m
				       .sin((this.m).zy))
				+ ((float) (i_247_
					    - (this.m).cz)
				   * this.m.cos((
							   this.m)
							  .zy))));
		int i_249_
		    = ((this.m).cx
		       + (int) ((((float) (this.rx[i]
					   - (this.m).x
					   - (this.m).cx)
				  + this.vrx[i])
				 * this.m
				       .cos((this.m).xz))
				- (((float) (this.rz[i]
					     - (this.m).z
					     - (this.m).cz)
				    + this.vrz[i])
				   * this.m.sin((
							   this.m)
							  .xz))));
		int i_250_
		    = ((this.m).cz
		       + (int) ((((float) (this.rx[i]
					   - (this.m).x
					   - (this.m).cx)
				  + this.vrx[i])
				 * this.m
				       .sin((this.m).xz))
				+ (((float) (this.rz[i]
					     - (this.m).z
					     - (this.m).cz)
				    + this.vrz[i])
				   * this.m.cos((
							   this.m)
							  .xz))));
		int i_251_
		    = ((this.m).cy
		       + (int) ((((float) (this.ry[i]
					   - (this.m).y
					   - (this.m).cy)
				  + this.vry[i])
				 * this.m
				       .cos((this.m).zy))
				- ((float) (i_250_
					    - (this.m).cz)
				   * this.m.sin((
							   this.m)
							  .zy))));
		i_250_
		    = ((this.m).cz
		       + (int) ((((float) (this.ry[i]
					   - (this.m).y
					   - (this.m).cy)
				  + this.vry[i])
				 * this.m
				       .sin((this.m).zy))
				+ ((float) (i_250_
					    - (this.m).cz)
				   * this.m.cos((
							   this.m)
							  .zy))));
		int i_252_ = xs(i_246_, i_247_);
		int i_253_ = ys(i_248_, i_247_);
		int i_254_ = xs(i_249_, i_250_);
		int i_255_ = ys(i_251_, i_250_);
		if (i_252_ < (this.m).iw
		    && i_254_ < (this.m).iw)
		    this.rtg[i] = 0;
		if (i_252_ > (this.m).w
		    && i_254_ > (this.m).w)
		    this.rtg[i] = 0;
		if (i_253_ < (this.m).ih
		    && i_255_ < (this.m).ih)
		    this.rtg[i] = 0;
		if (i_253_ > (this.m).h
		    && i_255_ > (this.m).h)
		    this.rtg[i] = 0;
		if (this.ry[i] > 250)
		    this.rtg[i] = 0;
		if (this.rtg[i] != 0) {
		    int i_256_ = 255;
		    int i_257_ = 197 - 30 * this.rtg[i];
		    int i_258_ = 0;
		    for (int i_259_ = 0; i_259_ < 16; i_259_++) {
			if (i_247_
			    > (this.m).fade[i_259_]) {
			    i_256_
				= ((i_256_ * (this.m).fogd
				    + (this.m).cfade[0])
				   / ((this.m).fogd + 1));
			    i_257_
				= ((i_257_ * (this.m).fogd
				    + (this.m).cfade[1])
				   / ((this.m).fogd + 1));
			    i_258_
				= ((i_258_ * (this.m).fogd
				    + (this.m).cfade[2])
				   / ((this.m).fogd + 1));
			}
		    }
		    graphics2d.setColor(new Color(i_256_, i_257_, i_258_));
		    graphics2d.drawLine(i_252_, i_253_, i_254_, i_255_);
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
    
    public int xs(int i, int i_260_) {
	if (i_260_ < 50)
	    i_260_ = 50;
	return (((i_260_ - (this.m).focus_point)
		 * ((this.m).cx - i) / i_260_)
		+ i);
    }
    
    public int ys(int i, int i_261_) {
	if (i_261_ < 50)
	    i_261_ = 50;
	return (((i_261_ - (this.m).focus_point)
		 * ((this.m).cy - i) / i_261_)
		+ i);
    }
    
    public int getvalue(String string, String string_262_, int i) {
	int i_263_ = 0;
	String string_264_ = "";
	for (int i_265_ = string.length() + 1; i_265_ < string_262_.length();
	     i_265_++) {
	    String string_266_ = new StringBuilder().append("").append
				     (string_262_.charAt(i_265_)).toString();
	    if (string_266_.equals(",") || string_266_.equals(")")) {
		i_263_++;
		i_265_++;
	    }
	    if (i_263_ == i)
		string_264_ = new StringBuilder().append(string_264_).append
				  (string_262_.charAt(i_265_)).toString();
	}
	return Float.valueOf(string_264_).intValue();
    }
    
    public int getpy(int i, int i_267_, int i_268_) {
	return ((i - this.x) / 10 * ((i - this.x) / 10)
		+ ((i_267_ - this.y) / 10
		   * ((i_267_ - this.y) / 10))
		+ ((i_268_ - this.z) / 10
		   * ((i_268_ - this.z) / 10)));
    }
    
    public int py(int i, int i_269_, int i_270_, int i_271_) {
	return ((i - i_269_) * (i - i_269_)
		+ (i_270_ - i_271_) * (i_270_ - i_271_));
    }
    
    public void rot(int[] is, int[] is_272_, int i, int i_273_, int i_274_,
		    int i_275_) {
	if (i_274_ != 0) {
	    for (int i_276_ = 0; i_276_ < i_275_; i_276_++) {
		int i_277_ = is[i_276_];
		int i_278_ = is_272_[i_276_];
		is[i_276_] = i + (int) (((float) (i_277_ - i)
					 * this.m.cos(i_274_))
					- ((float) (i_278_ - i_273_)
					   * this.m.sin(i_274_)));
		is_272_[i_276_]
		    = i_273_ + (int) (((float) (i_277_ - i)
				       * this.m.sin(i_274_))
				      + ((float) (i_278_ - i_273_)
					 * this.m.cos(i_274_)));
	    }
	}
    }
}
