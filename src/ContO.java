
/* ContO - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Random;

public class ContO {
	int checkpoint;
	int colok;
	int[] dam;
	boolean decor = false;
	int disline = 14;
	int disp = 0;
	int dist = 0;
	int[] edl;
	int[] edr;
	int[] elc;
	boolean elec;
	String err;
	boolean errd;
	int fcnt;
	int[] fcol;
	boolean fix;
	int grat = 0;
	float grounded = 1.0F;
	int[] keyx;
	int[] keyz;
	Medium m;
	int maxR = 0;
	boolean noline = false;
	boolean[] notwall;
	int npl = 0;
	float[] osmag;
	Plane[] p;
	boolean[] rbef;
	float rcx;
	float rcy;
	float rcz;
	int roofat;
	boolean roted;
	int[] rtg;
	int[] rx;
	int[] ry;
	int[] rz;
	int[] sav;
	float[] sbln;
	int[] scol;
	int[] scx;
	int[] scz;
	boolean shadow = false;
	int[] skd;
	float[][] smag;
	int sprk;
	int sprkat;
	int[][] srgb;
	int srx;
	int sry;
	int srz;
	int[] stg;
	int[] sx;
	int[] sy;
	int[] sz;
	Trackers t;
	int[][] tc;
	int tnt;
	int[] tradx;
	int[] trady;
	int[] tradz;
	int[] tx;
	int[] txy;
	int[] ty;
	int[] tz;
	int[] tzy;
	int ust;
	float[] vrx;
	float[] vry;
	float[] vrz;
	int wh;
	int wxz = 0;
	int wzy = 0;
	int x = 0;
	int xy = 0;
	int xz = 0;
	int y = 0;
	int z = 0;
	int zy = 0;

	public ContO(final byte[] is, final Medium medium, final Trackers trackers) {
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
		// p = new Plane[286];
		p = new Plane[10000];
		// int[] is_0_ = new int[286];
		final int[] is_0_ = new int[10000];
		// for (int i = 0; i < 286; i++)
		// is_0_[i] = 0;
		for (int i = 0; i < 10000; i++)
			is_0_[i] = 0;
		if (m.loadnew) {
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
		final float[] fs = { 1.0F, 1.0F, 1.0F };
		final int[] is_3_ = new int[100];
		final int[] is_4_ = new int[100];
		final int[] is_5_ = new int[100];
		final int[] is_6_ = { 0, 0, 0 };
		boolean bool_7_ = false;
		final Wheels wheels = new Wheels();
		boolean bool_8_ = false;
		int i_9_ = 0;
		int i_10_ = 1;
		int i_11_ = 0;
		int i_12_ = 0;
		int i_13_ = 0;
		int i_14_ = 0;
		boolean bool_15_ = false;
		boolean bool_16_ = false;


		boolean randomcolor = false;
        boolean randoutline = false;

        boolean customstroke = false;
        int strokewidth = 1;
        int strokecap = BasicStroke.CAP_BUTT;
        int strokejoin = BasicStroke.JOIN_MITER;
        int strokemtlimit = 10;

		try {
			final DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(is));
			String string_17_;
			while ((string_17_ = datainputstream.readLine()) != null) {
				string = new StringBuilder().append("").append(string_17_.trim()).toString();
				if (npl < 10000 /* 210 */) {
					if (string.startsWith("<p>")) {
						bool = true;
						i = 0;
						i_10_ = 0;
						i_11_ = 0;
						i_13_ = 0;
						is_0_[npl] = 1;
						if (!bool_16_)
							bool_15_ = false;

						randomcolor = false;
						randoutline = false;
				        customstroke = false;
				        strokewidth = 1;
				        strokecap = BasicStroke.CAP_BUTT;
				        strokejoin = BasicStroke.JOIN_MITER;
				        strokemtlimit = 10;
					}
					if (bool) {
						if (string.startsWith("gr("))
							i_10_ = getvalue("gr", string, 0);
						if (string.startsWith("fs(")) {
							i_11_ = getvalue("fs", string, 0);
							is_0_[npl] = 2;
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
						if(string.startsWith("random()") || string.startsWith("rainbow()"))
							randomcolor = true;
	                    if(string.startsWith("randoutline()"))
							randoutline = true;
		                if(string.startsWith("customOutline"))
		                	customstroke = true;
		                if(string.startsWith("$outlineW("))
		                	strokewidth = getvalue("$outlineW", string, 0);
		                if(string.startsWith("$outlineCap(")) {
			                if(string.startsWith("$outlineCap(butt)"))
			                	strokecap = BasicStroke.CAP_BUTT;
			                if(string.startsWith("$outlineCap(round)"))
			                	strokecap = BasicStroke.CAP_ROUND;
			                if(string.startsWith("$outlineCap(square)"))
			                	strokecap = BasicStroke.CAP_SQUARE;
		                }
		                if(string.startsWith("$outlineJoin(")) {
			                if(string.startsWith("$outlineJoin(bevel)"))
			                	strokejoin = BasicStroke.JOIN_BEVEL;
			                if(string.startsWith("$outlineJoin(miter)"))
			                	strokejoin = BasicStroke.JOIN_MITER;
			                if(string.startsWith("$outlineJoin(round)"))
			                	strokejoin = BasicStroke.JOIN_ROUND;
		                }
		                if(string.startsWith("$outlineMtlimit("))
		                	strokemtlimit = getvalue("$outlineMtlimit", string, 0);
						if (string.startsWith("p(")) {
							is_3_[i] = (int) (getvalue("p", string, 0) * f * f_2_ * fs[0]);
							is_4_[i] = (int) (getvalue("p", string, 1) * f * fs[1]);
							is_5_[i] = (int) (getvalue("p", string, 2) * f * fs[2]);
							final int i_18_ = (int) Math
									.sqrt(is_3_[i] * is_3_[i] + is_4_[i] * is_4_[i] + is_5_[i] * is_5_[i]);
							if (i_18_ > maxR)
								maxR = i_18_;
							i++;
						}
					}
					if (string.startsWith("</p>")) {
						p[npl] = new Plane(m, t, is_3_, is_5_, is_4_, i, is_6_, i_14_, i_10_, i_11_, 0, 0, 0, disline,
								0, bool_7_, i_13_, bool_15_, randomcolor, randoutline, customstroke, strokewidth, strokecap, strokejoin, strokemtlimit);
						if (is_6_[0] == fcol[0] && is_6_[1] == fcol[1] && is_6_[2] == fcol[2] && i_14_ == 0)
							p[npl].colnum = 1;
						if (is_6_[0] == scol[0] && is_6_[1] == scol[1] && is_6_[2] == scol[2] && i_14_ == 0)
							p[npl].colnum = 2;
						npl++;
						bool = false;
					}
				}
				if (string.startsWith("rims("))
					wheels.setrims(getvalue("rims", string, 0), getvalue("rims", string, 1),
							getvalue("rims", string, 2), getvalue("rims", string, 3), getvalue("rims", string, 4));
				if (string.startsWith("w(") && i_9_ < 4) {
					keyx[i_9_] = (int) (getvalue("w", string, 0) * f * fs[0]);
					keyz[i_9_] = (int) (getvalue("w", string, 2) * f * fs[2]);
					wheels.make(m, t, p, npl, (int) (getvalue("w", string, 0) * f * f_2_ * fs[0]),
							(int) (getvalue("w", string, 1) * f * fs[1]), (int) (getvalue("w", string, 2) * f * fs[2]),
							getvalue("w", string, 3), (int) (getvalue("w", string, 4) * f * f_2_),
							(int) (getvalue("w", string, 5) * f), i_12_);
					npl += 19;
					if (m.loadnew) {
						wh += (int) (getvalue("w", string, 5) * f);
						if (wheels.ground > 140) {
							String string_19_ = "FRONT";
							if (keyz[i_9_] < 0)
								string_19_ = "BACK";
							err = new StringBuilder().append("Wheels Error:\n").append(string_19_)
									.append(" Wheels floor is too far below the center of Y Axis of the car!    \n\nPlease decrease the Y value of the ")
									.append(string_19_).append(" Wheels or decrease its height.     \n \n").toString();
							errd = true;
							keyz[i_9_] = 0;
							keyx[i_9_] = 0;
						}
						if (wheels.ground < -100) {
							String string_20_ = "FRONT";
							if (keyz[i_9_] < 0)
								string_20_ = "BACK";
							err = new StringBuilder().append("Wheels Error:\n").append(string_20_)
									.append(" Wheels floor is too far above the center of Y Axis of the car!    \n\nPlease increase the Y value of the ")
									.append(string_20_).append(" Wheels or increase its height.     \n \n").toString();
							errd = true;
							keyz[i_9_] = 0;
							keyx[i_9_] = 0;
						}
						if (Math.abs(keyx[i_9_]) > 400) {
							String string_21_ = "FRONT";
							if (keyz[i_9_] < 0)
								string_21_ = "BACK";
							err = new StringBuilder().append("Wheels Error:\n").append(string_21_)
									.append(" Wheels are too far apart!    \n\nPlease decrease the \u00b1X value of the ")
									.append(string_21_).append(" Wheels.     \n \n").toString();
							errd = true;
							keyz[i_9_] = 0;
							keyx[i_9_] = 0;
						}
						if (Math.abs(keyz[i_9_]) > 700) {
							if (keyz[i_9_] < 0)
								err = "Wheels Error:\nBACK Wheels are too far backwards from the center of the Z Axis!    \n\nPlease increase the -Z value of the BACK Wheels.     \n \n";
							else
								err = "Wheels Error:\nFRONT Wheels are too far forwards from the center of the Z Axis!    \n\nPlease decrease the +Z value of the FRONT Wheels.     \n \n";
							errd = true;
							keyz[i_9_] = 0;
							keyx[i_9_] = 0;
						}
						if ((int) (getvalue("w", string, 4) * f * f_2_) > 300) {
							String string_22_ = "FRONT";
							if (keyz[i_9_] < 0)
								string_22_ = "BACK";
							err = new StringBuilder().append("Wheels Error:\nWidth of the ").append(string_22_)
									.append(" Wheels is too large!    \n\nPlease decrease the width of the ")
									.append(string_22_).append(" Wheels.     \n \n").toString();
							errd = true;
							keyz[i_9_] = 0;
							keyx[i_9_] = 0;
						}
					}
					i_9_++;
				}
				if (string.startsWith("tracks")) {
					final int i_23_ = getvalue("tracks", string, 0);
					txy = new int[i_23_];
					tzy = new int[i_23_];
					tc = new int[i_23_][3];
					tradx = new int[i_23_];
					tradz = new int[i_23_];
					trady = new int[i_23_];
					tx = new int[i_23_];
					ty = new int[i_23_];
					tz = new int[i_23_];
					skd = new int[i_23_];
					dam = new int[i_23_];
					notwall = new boolean[i_23_];
					bool_8_ = true;
				}
				if (bool_8_) {
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
							tradx[tnt] = (int) (getvalue("radx", string, 0) * f);
						if (string.startsWith("rady"))
							trady[tnt] = (int) (getvalue("rady", string, 0) * f);
						if (string.startsWith("radz"))
							tradz[tnt] = (int) (getvalue("radz", string, 0) * f);
						if (string.startsWith("ty"))
							ty[tnt] = (int) (getvalue("ty", string, 0) * f);
						if (string.startsWith("tx"))
							tx[tnt] = (int) (getvalue("tx", string, 0) * f);
						if (string.startsWith("tz"))
							tz[tnt] = (int) (getvalue("tz", string, 0) * f);
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
					bool_15_ = true;
					bool_16_ = true;
				}
				if (string.startsWith("decorative"))
					decor = true;
				if (string.startsWith("road"))
					bool_7_ = true;
				if (string.startsWith("notroad"))
					bool_7_ = false;
				if (string.startsWith("grounded("))
					grounded = getvalue("grounded", string, 0) / 100.0F;
				if (string.startsWith("div("))
					f = getvalue("div", string, 0) / 10.0F;
				if (string.startsWith("idiv("))
					f = getvalue("idiv", string, 0) / 100.0F;
				if (string.startsWith("iwid("))
					f_2_ = getvalue("iwid", string, 0) / 100.0F;
				if (string.startsWith("ScaleX("))
					fs[0] = getvalue("ScaleX", string, 0) / 100.0F;
				if (string.startsWith("ScaleY("))
					fs[1] = getvalue("ScaleY", string, 0) / 100.0F;
				if (string.startsWith("ScaleZ("))
					fs[2] = getvalue("ScaleZ", string, 0) / 100.0F;
				if (string.startsWith("gwgr(")) {
					i_12_ = getvalue("gwgr", string, 0);
					if (m.loadnew) {
						if (i_12_ > 40)
							i_12_ = 40;
						if (i_12_ < 0 && i_12_ >= -15)
							i_12_ = -16;
						if (i_12_ < -40)
							i_12_ = -40;
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
		} catch (final Exception exception) {
			if (!errd) {
				err = new StringBuilder().append("Error While Loading 3D Model\n\nLine:     ").append(string)
						.append("\n\nError Detail:\n").append(exception).append("           \n \n").toString();
				System.out.println(err);
				errd = true;
			}
		}
		grat = wheels.ground;
		sprkat = wheels.sparkat;
		if (shadow) {
			stg = new int[20];
			rtg = new int[100];
			for (int i_24_ = 0; i_24_ < 20; i_24_++)
				stg[i_24_] = 0;
			for (int i_25_ = 0; i_25_ < 100; i_25_++)
				rtg[i_25_] = 0;
		}
		if (m.loadnew) {
			if (i_9_ != 0)
				wh = wh / i_9_;
			boolean bool_26_ = false;
			for (int i_27_ = 0; i_27_ < npl; i_27_++) {
				int i_28_ = 0;
				int i_29_ = p[i_27_].ox[0];
				int i_30_ = p[i_27_].ox[0];
				int i_31_ = p[i_27_].oy[0];
				int i_32_ = p[i_27_].oy[0];
				int i_33_ = p[i_27_].oz[0];
				int i_34_ = p[i_27_].oz[0];
				for (int i_35_ = 0; i_35_ < p[i_27_].n; i_35_++) {
					if (p[i_27_].ox[i_35_] > i_29_)
						i_29_ = p[i_27_].ox[i_35_];
					if (p[i_27_].ox[i_35_] < i_30_)
						i_30_ = p[i_27_].ox[i_35_];
					if (p[i_27_].oy[i_35_] > i_31_)
						i_31_ = p[i_27_].oy[i_35_];
					if (p[i_27_].oy[i_35_] < i_32_)
						i_32_ = p[i_27_].oy[i_35_];
					if (p[i_27_].oz[i_35_] > i_33_)
						i_33_ = p[i_27_].oz[i_35_];
					if (p[i_27_].oz[i_35_] < i_34_)
						i_34_ = p[i_27_].oz[i_35_];
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
				if (i_28_ == 2 && (!bool_26_ || (i_31_ + i_32_) / 2 < roofat)) {
					roofat = (i_31_ + i_32_) / 2;
					bool_26_ = true;
				}
				if (is_0_[i_27_] == 1) {
					int i_36_ = 1000;
					int i_37_ = 0;
					for (int i_38_ = 0; i_38_ < p[i_27_].n; i_38_++) {
						int i_39_ = i_38_ + 1;
						if (i_39_ >= p[i_27_].n)
							i_39_ -= p[i_27_].n;
						int i_40_ = i_38_ + 2;
						if (i_40_ >= p[i_27_].n)
							i_40_ -= p[i_27_].n;
						if (i_28_ == 1) {
							int i_41_ = Math.abs((int) (Math
									.atan((double) (p[i_27_].oz[i_38_] - p[i_27_].oz[i_39_])
											/ (double) (p[i_27_].oy[i_38_] - p[i_27_].oy[i_39_]))
									/ 0.017453292519943295));
							int i_42_ = Math.abs((int) (Math
									.atan((double) (p[i_27_].oz[i_40_] - p[i_27_].oz[i_39_])
											/ (double) (p[i_27_].oy[i_40_] - p[i_27_].oy[i_39_]))
									/ 0.017453292519943295));
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
							int i_43_ = Math.abs((int) (Math
									.atan((double) (p[i_27_].oz[i_38_] - p[i_27_].oz[i_39_])
											/ (double) (p[i_27_].ox[i_38_] - p[i_27_].ox[i_39_]))
									/ 0.017453292519943295));
							int i_44_ = Math.abs((int) (Math
									.atan((double) (p[i_27_].oz[i_40_] - p[i_27_].oz[i_39_])
											/ (double) (p[i_27_].ox[i_40_] - p[i_27_].ox[i_39_]))
									/ 0.017453292519943295));
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
							int i_45_ = Math.abs((int) (Math
									.atan((double) (p[i_27_].oy[i_38_] - p[i_27_].oy[i_39_])
											/ (double) (p[i_27_].ox[i_38_] - p[i_27_].ox[i_39_]))
									/ 0.017453292519943295));
							int i_46_ = Math.abs((int) (Math
									.atan((double) (p[i_27_].oy[i_40_] - p[i_27_].oy[i_39_])
											/ (double) (p[i_27_].ox[i_40_] - p[i_27_].ox[i_39_]))
									/ 0.017453292519943295));
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
						final int[] is_47_ = new int[p[i_27_].n];
						final int[] is_48_ = new int[p[i_27_].n];
						final int[] is_49_ = new int[p[i_27_].n];
						for (int i_50_ = 0; i_50_ < p[i_27_].n; i_50_++) {
							is_47_[i_50_] = p[i_27_].ox[i_50_];
							is_48_[i_50_] = p[i_27_].oy[i_50_];
							is_49_[i_50_] = p[i_27_].oz[i_50_];
						}
						for (int i_51_ = 0; i_51_ < p[i_27_].n; i_51_++) {
							int i_52_ = i_51_ + i_37_;
							if (i_52_ >= p[i_27_].n)
								i_52_ -= p[i_27_].n;
							p[i_27_].ox[i_51_] = is_47_[i_52_];
							p[i_27_].oy[i_51_] = is_48_[i_52_];
							p[i_27_].oz[i_51_] = is_49_[i_52_];
						}
					}
					if (i_28_ == 1)
						if (Math.abs(p[i_27_].oz[0] - p[i_27_].oz[1]) > Math.abs(p[i_27_].oy[0] - p[i_27_].oy[1])) {
							if (p[i_27_].oz[0] > p[i_27_].oz[1]) {
								if (p[i_27_].oy[1] > p[i_27_].oy[2])
									p[i_27_].fs = 1;
								else
									p[i_27_].fs = -1;
							} else if (p[i_27_].oy[1] > p[i_27_].oy[2])
								p[i_27_].fs = -1;
							else
								p[i_27_].fs = 1;
						} else if (p[i_27_].oy[0] > p[i_27_].oy[1]) {
							if (p[i_27_].oz[1] > p[i_27_].oz[2])
								p[i_27_].fs = -1;
							else
								p[i_27_].fs = 1;
						} else if (p[i_27_].oz[1] > p[i_27_].oz[2])
							p[i_27_].fs = 1;
						else
							p[i_27_].fs = -1;
					if (i_28_ == 2)
						if (Math.abs(p[i_27_].oz[0] - p[i_27_].oz[1]) > Math.abs(p[i_27_].ox[0] - p[i_27_].ox[1])) {
							if (p[i_27_].oz[0] > p[i_27_].oz[1]) {
								if (p[i_27_].ox[1] > p[i_27_].ox[2])
									p[i_27_].fs = -1;
								else
									p[i_27_].fs = 1;
							} else if (p[i_27_].ox[1] > p[i_27_].ox[2])
								p[i_27_].fs = 1;
							else
								p[i_27_].fs = -1;
						} else if (p[i_27_].ox[0] > p[i_27_].ox[1]) {
							if (p[i_27_].oz[1] > p[i_27_].oz[2])
								p[i_27_].fs = 1;
							else
								p[i_27_].fs = -1;
						} else if (p[i_27_].oz[1] > p[i_27_].oz[2])
							p[i_27_].fs = -1;
						else
							p[i_27_].fs = 1;
					if (i_28_ == 3)
						if (Math.abs(p[i_27_].oy[0] - p[i_27_].oy[1]) > Math.abs(p[i_27_].ox[0] - p[i_27_].ox[1])) {
							if (p[i_27_].oy[0] > p[i_27_].oy[1]) {
								if (p[i_27_].ox[1] > p[i_27_].ox[2])
									p[i_27_].fs = 1;
								else
									p[i_27_].fs = -1;
							} else if (p[i_27_].ox[1] > p[i_27_].ox[2])
								p[i_27_].fs = -1;
							else
								p[i_27_].fs = 1;
						} else if (p[i_27_].ox[0] > p[i_27_].ox[1]) {
							if (p[i_27_].oy[1] > p[i_27_].oy[2])
								p[i_27_].fs = -1;
							else
								p[i_27_].fs = 1;
						} else if (p[i_27_].oy[1] > p[i_27_].oy[2])
							p[i_27_].fs = 1;
						else
							p[i_27_].fs = -1;
					boolean bool_53_ = false;
					boolean bool_54_ = false;
					for (int i_55_ = 0; i_55_ < npl; i_55_++) {
						if (i_55_ != i_27_ && is_0_[i_55_] != 0) {
							int i_57_ = p[i_55_].ox[0];
							int i_58_ = p[i_55_].ox[0];
							int i_59_ = p[i_55_].oy[0];
							int i_60_ = p[i_55_].oy[0];
							int i_61_ = p[i_55_].oz[0];
							int i_62_ = p[i_55_].oz[0];
							for (int i_63_ = 0; i_63_ < p[i_55_].n; i_63_++) {
								if (p[i_55_].ox[i_63_] > i_57_)
									i_57_ = p[i_55_].ox[i_63_];
								if (p[i_55_].ox[i_63_] < i_58_)
									i_58_ = p[i_55_].ox[i_63_];
								if (p[i_55_].oy[i_63_] > i_59_)
									i_59_ = p[i_55_].oy[i_63_];
								if (p[i_55_].oy[i_63_] < i_60_)
									i_60_ = p[i_55_].oy[i_63_];
								if (p[i_55_].oz[i_63_] > i_61_)
									i_61_ = p[i_55_].oz[i_63_];
								if (p[i_55_].oz[i_63_] < i_62_)
									i_62_ = p[i_55_].oz[i_63_];
							}
							final int i_64_ = (i_57_ + i_58_) / 2;
							final int i_65_ = (i_59_ + i_60_) / 2;
							final int i_66_ = (i_61_ + i_62_) / 2;
							final int i_67_ = (i_29_ + i_30_) / 2;
							final int i_68_ = (i_31_ + i_32_) / 2;
							final int i_69_ = (i_33_ + i_34_) / 2;
							if (i_28_ == 1 && (i_65_ <= i_31_ && i_65_ >= i_32_ && i_66_ <= i_33_ && i_66_ >= i_34_
									|| i_68_ <= i_59_ && i_68_ >= i_60_ && i_69_ <= i_61_ && i_69_ >= i_62_)) {
								if (i_57_ < i_30_)
									bool_53_ = true;
								if (i_58_ > i_29_)
									bool_54_ = true;
							}
							if (i_28_ == 2 && (i_64_ <= i_29_ && i_64_ >= i_30_ && i_66_ <= i_33_ && i_66_ >= i_34_
									|| i_67_ <= i_57_ && i_67_ >= i_58_ && i_69_ <= i_61_ && i_69_ >= i_62_)) {
								if (i_59_ < i_32_)
									bool_53_ = true;
								if (i_60_ > i_31_)
									bool_54_ = true;
							}
							if (i_28_ == 3 && (i_64_ <= i_29_ && i_64_ >= i_30_ && i_65_ <= i_31_ && i_65_ >= i_32_
									|| i_67_ <= i_57_ && i_67_ >= i_58_ && i_68_ <= i_59_ && i_68_ >= i_60_)) {
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
						p[i_27_].fs *= -1;
						bool_70_ = true;
					}
					if (bool_53_ && bool_54_) {
						p[i_27_].fs = 0;
						p[i_27_].gr = 40;
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
						for (int i_73_ = 0; i_73_ < npl; i_73_++)
							if (i_73_ != i_27_) {
								boolean bool_74_ = false;
								final boolean[] bools = new boolean[p[i_73_].n];
								for (int i_75_ = 0; i_75_ < p[i_73_].n; i_75_++) {
									bools[i_75_] = false;
									for (int i_76_ = 0; i_76_ < p[i_27_].n; i_76_++)
										if (p[i_27_].ox[i_76_] == p[i_73_].ox[i_75_]
												&& p[i_27_].oy[i_76_] == p[i_73_].oy[i_75_]
												&& p[i_27_].oz[i_76_] == p[i_73_].oz[i_75_]) {
											bools[i_75_] = true;
											bool_74_ = true;
										}
								}
								if (bool_74_)
									for (int i_77_ = 0; i_77_ < p[i_73_].n; i_77_++)
										if (!bools[i_77_]) {
											if (i_28_ == 1) {
												if (p[i_73_].ox[i_77_] > i_71_)
													i_71_ = p[i_73_].ox[i_77_];
												if (p[i_73_].ox[i_77_] < i_72_)
													i_72_ = p[i_73_].ox[i_77_];
											}
											if (i_28_ == 2) {
												if (p[i_73_].oy[i_77_] > i_71_)
													i_71_ = p[i_73_].oy[i_77_];
												if (p[i_73_].oy[i_77_] < i_72_)
													i_72_ = p[i_73_].oy[i_77_];
											}
											if (i_28_ == 3) {
												if (p[i_73_].oz[i_77_] > i_71_)
													i_71_ = p[i_73_].oz[i_77_];
												if (p[i_73_].oz[i_77_] < i_72_)
													i_72_ = p[i_73_].oz[i_77_];
											}
										}
							}
						if (i_28_ == 1)
							if ((i_71_ + i_72_) / 2 > (i_29_ + i_30_) / 2)
								p[i_27_].fs *= -1;
							else if ((i_71_ + i_72_) / 2 == (i_29_ + i_30_) / 2 && (i_29_ + i_30_) / 2 < 0)
								p[i_27_].fs *= -1;
						if (i_28_ == 2)
							if ((i_71_ + i_72_) / 2 > (i_31_ + i_32_) / 2)
								p[i_27_].fs *= -1;
							else if ((i_71_ + i_72_) / 2 == (i_31_ + i_32_) / 2 && (i_31_ + i_32_) / 2 < 0)
								p[i_27_].fs *= -1;
						if (i_28_ == 3)
							if ((i_71_ + i_72_) / 2 > (i_33_ + i_34_) / 2)
								p[i_27_].fs *= -1;
							else if ((i_71_ + i_72_) / 2 == (i_33_ + i_34_) / 2 && (i_33_ + i_34_) / 2 < 0)
								p[i_27_].fs *= -1;
					}
					p[i_27_].deltafntyp();
				}
			}
		}
	}

	public ContO(final ContO conto_78_, final int i, final int i_79_, final int i_80_, final int i_81_) {
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
		m = conto_78_.m;
		t = conto_78_.t;
		npl = conto_78_.npl;
		maxR = conto_78_.maxR;
		disp = conto_78_.disp;
		disline = conto_78_.disline;
		noline = conto_78_.noline;
		shadow = conto_78_.shadow;
		grounded = conto_78_.grounded;
		decor = conto_78_.decor;
		if (m.loadnew && (i_81_ == 90 || i_81_ == -90))
			grounded += 10000.0F;
		grat = conto_78_.grat;
		sprkat = conto_78_.sprkat;
		p = new Plane[conto_78_.npl];
		for (int i_82_ = 0; i_82_ < npl; i_82_++) {
			if (conto_78_.p[i_82_].master == 1)
				conto_78_.p[i_82_].n = 20;
			p[i_82_] = new Plane(m, t, conto_78_.p[i_82_].ox, conto_78_.p[i_82_].oz, conto_78_.p[i_82_].oy,
					conto_78_.p[i_82_].n, conto_78_.p[i_82_].oc, conto_78_.p[i_82_].glass, conto_78_.p[i_82_].gr,
					conto_78_.p[i_82_].fs, conto_78_.p[i_82_].wx, conto_78_.p[i_82_].wy, conto_78_.p[i_82_].wz,
					conto_78_.disline, conto_78_.p[i_82_].bfase, conto_78_.p[i_82_].road, conto_78_.p[i_82_].light,
					conto_78_.p[i_82_].solo, conto_78_.p[i_82_].randomcolor, conto_78_.p[i_82_].randoutline, conto_78_.p[i_82_].customstroke, conto_78_.p[i_82_].strokewidth, conto_78_.p[i_82_].strokecap, conto_78_.p[i_82_].strokejoin, conto_78_.p[i_82_].strokemtlimit);
		}
		x = i;
		y = i_79_;
		z = i_80_;
		xz = 0;
		xy = 0;
		zy = 0;
		for (int i_83_ = 0; i_83_ < npl; i_83_++) {
			p[i_83_].colnum = conto_78_.p[i_83_].colnum;
			p[i_83_].master = conto_78_.p[i_83_].master;
			p[i_83_].rot(p[i_83_].ox, p[i_83_].oz, 0, 0, i_81_, p[i_83_].n);
			p[i_83_].loadprojf();
		}
		if (conto_78_.tnt != 0)
			for (int i_84_ = 0; i_84_ < conto_78_.tnt; i_84_++) {
				t.xy[t.nt] = (int) (conto_78_.txy[i_84_] * m.cos(i_81_) - conto_78_.tzy[i_84_] * m.sin(i_81_));
				t.zy[t.nt] = (int) (conto_78_.tzy[i_84_] * m.cos(i_81_) + conto_78_.txy[i_84_] * m.sin(i_81_));
				for (int i_85_ = 0; i_85_ < 3; i_85_++) {
					t.c[t.nt][i_85_] = (int) (conto_78_.tc[i_84_][i_85_]
							+ conto_78_.tc[i_84_][i_85_] * (m.snap[i_85_] / 100.0F));
					if (t.c[t.nt][i_85_] > 255)
						t.c[t.nt][i_85_] = 255;
					if (t.c[t.nt][i_85_] < 0)
						t.c[t.nt][i_85_] = 0;
				}
				t.x[t.nt] = (int) (x + conto_78_.tx[i_84_] * m.cos(i_81_) - conto_78_.tz[i_84_] * m.sin(i_81_));
				t.z[t.nt] = (int) (z + conto_78_.tz[i_84_] * m.cos(i_81_) + conto_78_.tx[i_84_] * m.sin(i_81_));
				t.y[t.nt] = y + conto_78_.ty[i_84_];
				t.skd[t.nt] = conto_78_.skd[i_84_];
				t.dam[t.nt] = conto_78_.dam[i_84_];
				t.notwall[t.nt] = conto_78_.notwall[i_84_];
				if (decor)
					t.decor[t.nt] = true;
				else
					t.decor[t.nt] = false;
				int i_86_ = Math.abs(i_81_);
				if (i_86_ == 180)
					i_86_ = 0;
				t.radx[t.nt] = (int) Math
						.abs(conto_78_.tradx[i_84_] * m.cos(i_86_) + conto_78_.tradz[i_84_] * m.sin(i_86_));
				t.radz[t.nt] = (int) Math
						.abs(conto_78_.tradx[i_84_] * m.sin(i_86_) + conto_78_.tradz[i_84_] * m.cos(i_86_));
				t.rady[t.nt] = conto_78_.trady[i_84_];
				t.nt++;
			}
		for (int i_87_ = 0; i_87_ < 4; i_87_++) {
			keyx[i_87_] = conto_78_.keyx[i_87_];
			keyz[i_87_] = conto_78_.keyz[i_87_];
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
			for (int i_88_ = 0; i_88_ < 20; i_88_++)
				stg[i_88_] = 0;
			rtg = new int[100];
			rbef = new boolean[100];
			rx = new int[100];
			ry = new int[100];
			rz = new int[100];
			vrx = new float[100];
			vry = new float[100];
			vrz = new float[100];
			for (int i_89_ = 0; i_89_ < 100; i_89_++)
				rtg[i_89_] = 0;
		}
	}

	public ContO(final int i, final int i_90_, final int i_91_, final Medium medium, final Trackers trackers,
			final int i_92_, final int i_93_, final int i_94_) {
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
		x = i_92_;
		z = i_93_;
		y = i_94_;
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
		final Random random = new Random(i);
		final int[] is = new int[8];
		final int[] is_95_ = new int[8];
		final int[] is_96_ = new int[8];
		final int[] is_97_ = new int[8];
		final int[] is_98_ = new int[8];
		float f = i_90_;
		float f_99_ = i_91_;
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
		is[2] = (int) (f_100_ * f * 0.7071);
		is_95_[2] = (int) (f_100_ * f * 0.7071);
		f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
		is[3] = (int) (f_100_ * f);
		is_95_[3] = 0;
		f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
		is[4] = (int) (f_100_ * f * 0.7071);
		is_95_[4] = -(int) (f_100_ * f * 0.7071);
		f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
		is[5] = 0;
		is_95_[5] = -(int) (f_100_ * f);
		f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
		is[6] = -(int) (f_100_ * f * 0.7071);
		is_95_[6] = -(int) (f_100_ * f * 0.7071);
		f_100_ = (float) (50.0 + 100.0 * random.nextDouble());
		is[7] = -(int) (f_100_ * f);
		is_95_[7] = 0;
		for (int i_101_ = 0; i_101_ < 8; i_101_++) {
			is_96_[i_101_] = (int) (is[i_101_] * (0.2 + 0.4 * random.nextDouble()));
			is_97_[i_101_] = (int) (is_95_[i_101_] * (0.2 + 0.4 * random.nextDouble()));
			is_98_[i_101_] = -(int) ((10.0 + 15.0 * random.nextDouble()) * f_99_);
		}
		maxR = 0;
		for (int i_102_ = 0; i_102_ < 8; i_102_++) {
			int i_103_ = i_102_ - 1;
			if (i_103_ == -1)
				i_103_ = 7;
			int i_104_ = i_102_ + 1;
			if (i_104_ == 8)
				i_104_ = 0;
			is[i_102_] = ((is[i_103_] + is[i_104_]) / 2 + is[i_102_]) / 2;
			is_95_[i_102_] = ((is_95_[i_103_] + is_95_[i_104_]) / 2 + is_95_[i_102_]) / 2;
			is_96_[i_102_] = ((is_96_[i_103_] + is_96_[i_104_]) / 2 + is_96_[i_102_]) / 2;
			is_97_[i_102_] = ((is_97_[i_103_] + is_97_[i_104_]) / 2 + is_97_[i_102_]) / 2;
			is_98_[i_102_] = ((is_98_[i_103_] + is_98_[i_104_]) / 2 + is_98_[i_102_]) / 2;
			int i_105_ = (int) Math.sqrt(is[i_102_] * is[i_102_] + is_95_[i_102_] * is_95_[i_102_]);
			if (i_105_ > maxR)
				maxR = i_105_;
			i_105_ = (int) Math.sqrt(is_96_[i_102_] * is_96_[i_102_] + is_98_[i_102_] * is_98_[i_102_]
					+ is_97_[i_102_] * is_97_[i_102_]);
			if (i_105_ > maxR)
				maxR = i_105_;
		}
		disp = maxR / 17;
		final int[] is_106_ = new int[3];
		float f_107_ = -1.0F;
		float f_108_ = (f / f_99_ - 0.33F) / 33.4F;
		if (f_108_ < 0.005)
			f_108_ = 0.0F;
		if (f_108_ > 0.057)
			f_108_ = 0.057F;
		for (int i_109_ = 0; i_109_ < 4; i_109_++) {
			final int i_110_ = i_109_ * 2;
			int i_111_ = i_110_ + 2;
			if (i_111_ == 8)
				i_111_ = 0;
			final int[] is_112_ = new int[6];
			final int[] is_113_ = new int[6];
			final int[] is_114_ = new int[6];
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
			for (f_100_ = (float) ((0.17 - f_108_) * random.nextDouble()); Math.abs(f_107_ - f_100_) < 0.03
					- f_108_ * 0.176F; f_100_ = (float) ((0.17 - f_108_) * random.nextDouble())) {
				/* empty */
			}
			f_107_ = f_100_;
			for (int i_115_ = 0; i_115_ < 3; i_115_++)
				if (m.trk == 2)
					is_106_[i_115_] = (int) (390.0F / (2.2F + f_100_ - f_108_));
				else
					is_106_[i_115_] = (int) ((m.cpol[i_115_] + m.cgrnd[i_115_]) / (2.2F + f_100_ - f_108_));
			p[i_109_] = new Plane(m, t, is_112_, is_114_, is_113_, 6, is_106_, 3, -8, 0, 0, 0, 0, disline, 0, true, 0,
					false, false, false, false, 1, 0, 0, 10);
		}
		f_100_ = (float) (0.02 * random.nextDouble());
		for (int i_116_ = 0; i_116_ < 3; i_116_++)
			if (m.trk == 2)
				is_106_[i_116_] = (int) (390.0F / (2.15F + f_100_));
			else
				is_106_[i_116_] = (int) ((m.cpol[i_116_] + m.cgrnd[i_116_]) / (2.15F + f_100_));
		p[4] = new Plane(m, t, is_96_, is_97_, is_98_, 8, is_106_, 3, -8, 0, 0, 0, 0, disline, 0, true, 0, false, false, false, false, 1, 0, 0, 10);
		final int[] is_117_ = new int[2];
		final int[] is_118_ = new int[2];
		for (int i_119_ = 0; i_119_ < 4; i_119_++) {
			int i_120_ = i_119_ * 2 + 1;
			t.y[t.nt] = is_98_[i_120_] / 2;
			t.rady[t.nt] = Math.abs(is_98_[i_120_] / 2);
			if (i_119_ == 0 || i_119_ == 2) {
				t.z[t.nt] = (is_95_[i_120_] + is_97_[i_120_]) / 2;
				t.radz[t.nt] = Math.abs(t.z[t.nt] - is_95_[i_120_]);
				i_120_ = i_119_ * 2 + 2;
				if (i_120_ == 8)
					i_120_ = 0;
				t.x[t.nt] = (is[i_119_ * 2] + is[i_120_]) / 2;
				t.radx[t.nt] = Math.abs(t.x[t.nt] - is[i_119_ * 2]);
			} else {
				t.x[t.nt] = (is[i_120_] + is_96_[i_120_]) / 2;
				t.radx[t.nt] = Math.abs(t.x[t.nt] - is[i_120_]);
				i_120_ = i_119_ * 2 + 2;
				if (i_120_ == 8)
					i_120_ = 0;
				t.z[t.nt] = (is_95_[i_119_ * 2] + is_95_[i_120_]) / 2;
				t.radz[t.nt] = Math.abs(t.z[t.nt] - is_95_[i_119_ * 2]);
			}
			if (i_119_ == 0) {
				is_118_[0] = t.z[t.nt] - t.radz[t.nt];
				t.zy[t.nt] = (int) (Math.atan((double) t.rady[t.nt] / (double) t.radz[t.nt]) / 0.017453292519943295);
				if (t.zy[t.nt] > 40)
					t.zy[t.nt] = 40;
				t.xy[t.nt] = 0;
			}
			if (i_119_ == 1) {
				is_117_[0] = t.x[t.nt] - t.radx[t.nt];
				t.xy[t.nt] = (int) (Math.atan((double) t.rady[t.nt] / (double) t.radx[t.nt]) / 0.017453292519943295);
				if (t.xy[t.nt] > 40)
					t.xy[t.nt] = 40;
				t.zy[t.nt] = 0;
			}
			if (i_119_ == 2) {
				is_118_[1] = t.z[t.nt] + t.radz[t.nt];
				t.zy[t.nt] = -(int) (Math.atan((double) t.rady[t.nt] / (double) t.radz[t.nt]) / 0.017453292519943295);
				if (t.zy[t.nt] < -40)
					t.zy[t.nt] = -40;
				t.xy[t.nt] = 0;
			}
			if (i_119_ == 3) {
				is_117_[1] = t.x[t.nt] + t.radx[t.nt];
				t.xy[t.nt] = -(int) (Math.atan((double) t.rady[t.nt] / (double) t.radx[t.nt]) / 0.017453292519943295);
				if (t.xy[t.nt] < -40)
					t.xy[t.nt] = -40;
				t.zy[t.nt] = 0;
			}
			t.x[t.nt] += x;
			t.z[t.nt] += z;
			t.y[t.nt] += y;
			for (int i_121_ = 0; i_121_ < 3; i_121_++)
				t.c[t.nt][i_121_] = p[i_119_].oc[i_121_];
			t.skd[t.nt] = 2;
			t.dam[t.nt] = 1;
			t.notwall[t.nt] = false;
			t.decor[t.nt] = true;
			t.rady[t.nt] += 10;
			t.nt++;
		}
		t.y[t.nt] = 0;
		for (int i_122_ = 0; i_122_ < 8; i_122_++)
			t.y[t.nt] += is_98_[i_122_];
		t.y[t.nt] = t.y[t.nt] / 8;
		t.y[t.nt] += y;
		t.rady[t.nt] = 200;
		t.radx[t.nt] = is_117_[0] - is_117_[1];
		t.radz[t.nt] = is_118_[0] - is_118_[1];
		t.x[t.nt] = (is_117_[0] + is_117_[1]) / 2 + x;
		t.z[t.nt] = (is_118_[0] + is_118_[1]) / 2 + z;
		t.zy[t.nt] = 0;
		t.xy[t.nt] = 0;
		for (int i_123_ = 0; i_123_ < 3; i_123_++)
			t.c[t.nt][i_123_] = p[4].oc[i_123_];
		t.skd[t.nt] = 4;
		t.dam[t.nt] = 1;
		t.notwall[t.nt] = false;
		t.decor[t.nt] = true;
		t.nt++;
	}

	public void d(final Graphics2D graphics2d) {
		if (dist != 0)
			dist = 0;
		final int i = m.cx + (int) ((x - m.x - m.cx) * m.cos(m.xz) - (z - m.z - m.cz) * m.sin(m.xz));
		final int i_124_ = m.cz + (int) ((x - m.x - m.cx) * m.sin(m.xz) + (z - m.z - m.cz) * m.cos(m.xz));
		final int i_125_ = m.cz + (int) ((y - m.y - m.cy) * m.sin(m.zy) + (i_124_ - m.cz) * m.cos(m.zy));
		int i_126_ = xs(i + maxR, i_125_) - xs(i - maxR, i_125_);
		if (xs(i + maxR * 2, i_125_) > m.iw && xs(i - maxR * 2, i_125_) < m.w && i_125_ > -maxR
				&& (i_125_ < m.fade[disline] + maxR || m.trk != 0) && (i_126_ > disp || m.trk != 0)
				&& (!decor || m.resdown != 2 && m.trk != 1)) {
			if (shadow)
				if (!m.crs) {
					if (i_125_ < 2000) {
						boolean bool = false;
						if (t.ncx != 0 || t.ncz != 0) {
							int i_127_ = (x - t.sx) / 3000;
							if (i_127_ > t.ncx)
								i_127_ = t.ncx;
							if (i_127_ < 0)
								i_127_ = 0;
							int i_128_ = (z - t.sz) / 3000;
							if (i_128_ > t.ncz)
								i_128_ = t.ncz;
							if (i_128_ < 0)
								i_128_ = 0;
							for (int i_129_ = t.sect[i_127_][i_128_].length - 1; i_129_ >= 0; i_129_--) {
								final int i_130_ = t.sect[i_127_][i_128_][i_129_];
								if (Math.abs(t.zy[i_130_]) != 90 && Math.abs(t.xy[i_130_]) != 90
										&& Math.abs(x - t.x[i_130_]) < t.radx[i_130_] + maxR
										&& Math.abs(z - t.z[i_130_]) < t.radz[i_130_] + maxR
										&& (!t.decor[i_130_] || m.resdown != 2)) {
									bool = true;
									break;
								}
							}
						}
						if (bool)
							for (int i_131_ = 0; i_131_ < npl; i_131_++)
								p[i_131_].s(graphics2d, x - m.x, y - m.y, z - m.z, xz, xy, zy, 0);
						else {
							final int i_132_ = m.cy
									+ (int) ((m.ground - m.cy) * m.cos(this.m.zy) - (i_124_ - m.cz) * m.sin(m.zy));
							final int i_133_ = m.cz
									+ (int) ((m.ground - m.cy) * m.sin(this.m.zy) + (i_124_ - m.cz) * m.cos(m.zy));
							if (ys(i_132_ + maxR, i_133_) > 0 && ys(i_132_ - maxR, i_133_) < m.h)
								for (int i_134_ = 0; i_134_ < npl; i_134_++)
									p[i_134_].s(graphics2d, x - m.x, y - m.y, z - m.z, xz, xy, zy, 1);
						}
						m.addsp(x - m.x, z - m.z, (int) (maxR * 0.8));
					} else
						lowshadow(graphics2d, i_125_);
				} else
					for (int i_135_ = 0; i_135_ < npl; i_135_++)
						p[i_135_].s(graphics2d, x - m.x, y - m.y, z - m.z, xz, xy, zy, 2);
			final int i_136_ = m.cy + (int) ((y - m.y - m.cy) * m.cos(m.zy) - (i_124_ - m.cz) * m.sin(m.zy));
			if (ys(i_136_ + maxR, i_125_) > m.ih && ys(i_136_ - maxR, i_125_) < m.h) {
				if (elec && m.noelec == 0)
					electrify(graphics2d);
				if (fix)
					fixit(graphics2d);
				if (checkpoint != 0 && checkpoint - 1 == m.checkpoint)
					i_126_ = -1;
				if (shadow) {
					dist = (int) Math.sqrt((m.x + m.cx - x) * (m.x + m.cx - x) + (m.z - z) * (m.z - z)
							+ (m.y + m.cy - y) * (m.y + m.cy - y));
					for (int i_137_ = 0; i_137_ < 20; i_137_++)
						if (stg[i_137_] != 0)
							pdust(i_137_, graphics2d, true);
					dsprk(graphics2d, true);
				}
				final int[] is = new int[npl];
				final int[] is_138_ = new int[npl];
				for (int i_139_ = 0; i_139_ < npl; i_139_++)
					is[i_139_] = 0;
				for (int i_140_ = 0; i_140_ < npl; i_140_++) {
					for (int i_141_ = i_140_ + 1; i_141_ < npl; i_141_++)
						if (p[i_140_].av != p[i_141_].av) {
							if (p[i_140_].av < p[i_141_].av)
								is[i_140_]++;
							else
								is[i_141_]++;
						} else if (i_140_ > i_141_)
							is[i_140_]++;
						else
							is[i_141_]++;
					is_138_[is[i_140_]] = i_140_;
				}
				for (int i_142_ = 0; i_142_ < npl; i_142_++)
					p[is_138_[i_142_]].d(graphics2d, x - m.x, y - m.y, z - m.z, xz, xy, zy, wxz, wzy, noline, i_126_);
				if (shadow) {
					for (int i_143_ = 0; i_143_ < 20; i_143_++)
						if (stg[i_143_] != 0)
							pdust(i_143_, graphics2d, false);
					dsprk(graphics2d, false);
				}
				dist = (int) (Math.sqrt((int) Math.sqrt((m.x + m.cx - x) * (m.x + m.cx - x) + (m.z - z) * (m.z - this.z)
						+ (m.y + m.cy - y) * (m.y + this.m.cy - this.y))) * grounded);
			}
		}
		if (shadow && dist == 0) {
			for (int i_144_ = 0; i_144_ < 20; i_144_++)
				if (stg[i_144_] != 0)
					stg[i_144_] = 0;
			for (int i_145_ = 0; i_145_ < 100; i_145_++)
				if (rtg[i_145_] != 0)
					rtg[i_145_] = 0;
			if (sprk != 0)
				sprk = 0;
		}
	}

	public void dsprk(final Graphics2D graphics2d, final boolean bool) {
		if (bool && sprk != 0) {
			int i = (int) (Math.sqrt(rcx * rcx + rcy * rcy + rcz * rcz) / 10.0);
			if (i > 5) {
				boolean bool_240_ = false;
				if (dist < Math.sqrt((m.x + m.cx - srx) * (m.x + m.cx - srx) + (m.y + m.cy - sry) * (m.y + m.cy - sry)
						+ (m.z - srz) * (m.z - srz)))
					bool_240_ = true;
				if (i > 33)
					i = 33;
				int i_241_ = 0;
				for (int i_242_ = 0; i_242_ < 100; i_242_++) {
					if (rtg[i_242_] == 0) {
						rtg[i_242_] = 1;
						rbef[i_242_] = bool_240_;
						i_241_++;
					}
					if (i_241_ == i)
						break;
				}
			}
		}
		for (int i = 0; i < 100; i++)
			if (rtg[i] != 0 && (rbef[i] && bool || !rbef[i] && !bool)) {
				if (rtg[i] == 1) {
					if (sprk < 5) {
						rx[i] = srx + 3 - (int) (m.random() * 6.7);
						ry[i] = sry + 3 - (int) (m.random() * 6.7);
						rz[i] = srz + 3 - (int) (m.random() * 6.7);
					} else {
						rx[i] = srx + 10 - (int) (m.random() * 20.0F);
						ry[i] = sry - (int) (m.random() * 4.0F);
						rz[i] = srz + 10 - (int) (m.random() * 20.0F);
					}
					final int i_243_ = (int) Math.sqrt(rcx * rcx + rcy * rcy + rcz * rcz);
					final float f = 0.2F + 0.4F * m.random();
					final float f_244_ = m.random() * m.random() * m.random();
					float f_245_ = 1.0F;
					if (m.random() > m.random()) {
						if (m.random() > m.random())
							f_245_ *= -1.0F;
						vrx[i] = -((rcx + i_243_ * (1.0F - rcx / i_243_) * f_244_ * f_245_) * f);
					}
					if (m.random() > m.random()) {
						if (m.random() > m.random())
							f_245_ *= -1.0F;
						if (sprk == 5)
							f_245_ = 1.0F;
						vry[i] = -((rcy + i_243_ * (1.0F - rcy / i_243_) * f_244_ * f_245_) * f);
					}
					if (m.random() > m.random()) {
						if (m.random() > m.random())
							f_245_ *= -1.0F;
						vrz[i] = -((rcz + i_243_ * (1.0F - rcz / i_243_) * f_244_ * f_245_) * f);
					}
				}
				rx[i] += vrx[i];
				ry[i] += vry[i];
				rz[i] += vrz[i];
				final int i_246_ = m.cx
						+ (int) ((rx[i] - m.x - m.cx) * m.cos(m.xz) - (rz[i] - m.z - m.cz) * m.sin(m.xz));
				int i_247_ = m.cz + (int) ((rx[i] - m.x - m.cx) * m.sin(m.xz) + (rz[i] - m.z - m.cz) * m.cos(m.xz));
				final int i_248_ = m.cy + (int) ((ry[i] - m.y - m.cy) * m.cos(m.zy) - (i_247_ - m.cz) * m.sin(m.zy));
				i_247_ = m.cz + (int) ((ry[i] - m.y - m.cy) * m.sin(m.zy) + (i_247_ - m.cz) * m.cos(m.zy));
				final int i_249_ = m.cx + (int) ((rx[i] - m.x - m.cx + vrx[i]) * m.cos(m.xz)
						- (rz[i] - m.z - m.cz + vrz[i]) * m.sin(m.xz));
				int i_250_ = m.cz + (int) ((rx[i] - m.x - m.cx + vrx[i]) * m.sin(m.xz)
						+ (rz[i] - m.z - m.cz + vrz[i]) * m.cos(m.xz));
				final int i_251_ = m.cy
						+ (int) ((ry[i] - m.y - m.cy + vry[i]) * m.cos(m.zy) - (i_250_ - m.cz) * m.sin(m.zy));
				i_250_ = m.cz + (int) ((ry[i] - m.y - m.cy + vry[i]) * m.sin(m.zy) + (i_250_ - m.cz) * m.cos(m.zy));
				final int i_252_ = xs(i_246_, i_247_);
				final int i_253_ = ys(i_248_, i_247_);
				final int i_254_ = xs(i_249_, i_250_);
				final int i_255_ = ys(i_251_, i_250_);
				if (i_252_ < m.iw && i_254_ < m.iw)
					rtg[i] = 0;
				if (i_252_ > m.w && i_254_ > m.w)
					rtg[i] = 0;
				if (i_253_ < m.ih && i_255_ < m.ih)
					rtg[i] = 0;
				if (i_253_ > m.h && i_255_ > m.h)
					rtg[i] = 0;
				if (ry[i] > 250)
					rtg[i] = 0;
				if (rtg[i] != 0) {
					int i_256_ = 255;
					int i_257_ = 197 - 30 * rtg[i];
					int i_258_ = 0;
					for (int i_259_ = 0; i_259_ < 16; i_259_++)
						if (i_247_ > m.fade[i_259_]) {
							i_256_ = (i_256_ * m.fogd + m.cfade[0]) / (m.fogd + 1);
							i_257_ = (i_257_ * m.fogd + m.cfade[1]) / (m.fogd + 1);
							i_258_ = (i_258_ * m.fogd + m.cfade[2]) / (m.fogd + 1);
						}
					graphics2d.setColor(new Color(i_256_, i_257_, i_258_));
					graphics2d.drawLine(i_252_, i_253_, i_254_, i_255_);
					vrx[i] = vrx[i] * 0.8F;
					vry[i] = vry[i] * 0.8F;
					vrz[i] = vrz[i] * 0.8F;
					if (rtg[i] == 3)
						rtg[i] = 0;
					else
						rtg[i]++;
				}
			}
		if (sprk != 0)
			sprk = 0;
	}

	public void dust(final int i, final float f, final float f_199_, final float f_200_, final int i_201_,
			final int i_202_, final float f_203_, final int i_204_, final boolean bool) {
		boolean bool_205_ = false;
		if (i_204_ > 5 && (i == 0 || i == 2))
			bool_205_ = true;
		if (i_204_ < -5 && (i == 1 || i == 3))
			bool_205_ = true;
		float f_206_ = (float) ((Math.sqrt(i_201_ * i_201_ + i_202_ * i_202_) - 40.0) / 160.0);
		if (f_206_ > 1.0F)
			f_206_ = 1.0F;
		if (f_206_ > 0.2 && !bool_205_) {
			ust++;
			if (ust == 20)
				ust = 0;
			if (!bool) {
				final float f_207_ = m.random();
				sx[ust] = (int) ((f + x * f_207_) / (1.0F + f_207_));
				sz[ust] = (int) ((f_200_ + z * f_207_) / (1.0F + f_207_));
				sy[ust] = (int) ((f_199_ + y * f_207_) / (1.0F + f_207_));
			} else {
				sx[ust] = (int) ((f + (x + i_201_)) / 2.0F);
				sz[ust] = (int) ((f_200_ + (z + i_202_)) / 2.0F);
				sy[ust] = (int) f_199_;
			}
			if (sy[i] > 250)
				sy[i] = 250;
			osmag[ust] = f_203_ * f_206_;
			scx[ust] = i_201_;
			scz[ust] = i_202_;
			stg[ust] = 1;
		}
	}

	public void electrify(final Graphics2D graphics2d) {
		for (int i = 0; i < 4; i++) {
			if (elc[i] == 0) {
				edl[i] = (int) (380.0F - m.random() * 760.0F);
				edr[i] = (int) (380.0F - m.random() * 760.0F);
				elc[i] = 1;
			}
			final int i_182_ = (int) (edl[i] + (190.0F - m.random() * 380.0F));
			final int i_183_ = (int) (edr[i] + (190.0F - m.random() * 380.0F));
			final int i_184_ = (int) (m.random() * 126.0F);
			final int i_185_ = (int) (m.random() * 126.0F);
			final int[] is = new int[8];
			final int[] is_186_ = new int[8];
			final int[] is_187_ = new int[8];
			for (int i_188_ = 0; i_188_ < 8; i_188_++)
				is_187_[i_188_] = z - m.z;
			is[0] = x - m.x - 504;
			is_186_[0] = y - m.y - edl[i] - 5 - (int) (m.random() * 5.0F);
			is[1] = x - m.x - 252 + i_185_;
			is_186_[1] = y - m.y - i_182_ - 5 - (int) (m.random() * 5.0F);
			is[2] = x - m.x + 252 - i_184_;
			is_186_[2] = y - m.y - i_183_ - 5 - (int) (m.random() * 5.0F);
			is[3] = x - m.x + 504;
			is_186_[3] = y - m.y - edr[i] - 5 - (int) (m.random() * 5.0F);
			is[4] = x - m.x + 504;
			is_186_[4] = y - m.y - edr[i] + 5 + (int) (m.random() * 5.0F);
			is[5] = x - m.x + 252 - i_184_;
			is_186_[5] = y - m.y - i_183_ + 5 + (int) (m.random() * 5.0F);
			is[6] = x - m.x - 252 + i_185_;
			is_186_[6] = y - m.y - i_182_ + 5 + (int) (m.random() * 5.0F);
			is[7] = x - m.x - 504;
			is_186_[7] = y - m.y - edl[i] + 5 + (int) (m.random() * 5.0F);
			if (roted)
				rot(is, is_187_, x - m.x, z - m.z, 90, 8);
			rot(is, is_187_, m.cx, m.cz, m.xz, 8);
			rot(is_186_, is_187_, m.cy, m.cz, m.zy, 8);
			boolean bool = true;
			int i_189_ = 0;
			int i_190_ = 0;
			int i_191_ = 0;
			int i_192_ = 0;
			final int[] is_193_ = new int[8];
			final int[] is_194_ = new int[8];
			for (int i_195_ = 0; i_195_ < 8; i_195_++) {
				is_193_[i_195_] = xs(is[i_195_], is_187_[i_195_]);
				is_194_[i_195_] = ys(is_186_[i_195_], is_187_[i_195_]);
				if (is_194_[i_195_] < m.ih || is_187_[i_195_] < 10)
					i_189_++;
				if (is_194_[i_195_] > m.h || is_187_[i_195_] < 10)
					i_190_++;
				if (is_193_[i_195_] < m.iw || is_187_[i_195_] < 10)
					i_191_++;
				if (is_193_[i_195_] > m.w || is_187_[i_195_] < 10)
					i_192_++;
			}
			if (i_191_ == 8 || i_189_ == 8 || i_190_ == 8 || i_192_ == 8)
				bool = false;
			if (bool) {
				int i_196_ = (int) (160.0F + 160.0F * (m.snap[0] / 500.0F));
				if (i_196_ > 255)
					i_196_ = 255;
				if (i_196_ < 0)
					i_196_ = 0;
				int i_197_ = (int) (238.0F + 238.0F * (m.snap[1] / 500.0F));
				if (i_197_ > 255)
					i_197_ = 255;
				if (i_197_ < 0)
					i_197_ = 0;
				int i_198_ = (int) (255.0F + 255.0F * (m.snap[2] / 500.0F));
				if (i_198_ > 255)
					i_198_ = 255;
				if (i_198_ < 0)
					i_198_ = 0;
				i_196_ = (i_196_ * 2 + 214 * (elc[i] - 1)) / (elc[i] + 1);
				i_197_ = (i_197_ * 2 + 236 * (elc[i] - 1)) / (elc[i] + 1);
				if (m.trk == 1) {
					i_196_ = 255;
					i_197_ = 128;
					i_198_ = 0;
				}
				graphics2d.setColor(new Color(i_196_, i_197_, i_198_));
				graphics2d.fillPolygon(is_193_, is_194_, 8);
				if (is_187_[0] < 4000) {
					i_196_ = (int) (150.0F + 150.0F * (m.snap[0] / 500.0F));
					if (i_196_ > 255)
						i_196_ = 255;
					if (i_196_ < 0)
						i_196_ = 0;
					i_197_ = (int) (227.0F + 227.0F * (m.snap[1] / 500.0F));
					if (i_197_ > 255)
						i_197_ = 255;
					if (i_197_ < 0)
						i_197_ = 0;
					i_198_ = (int) (255.0F + 255.0F * (m.snap[2] / 500.0F));
					if (i_198_ > 255)
						i_198_ = 255;
					if (i_198_ < 0)
						i_198_ = 0;
					graphics2d.setColor(new Color(i_196_, i_197_, i_198_));
					graphics2d.drawPolygon(is_193_, is_194_, 8);
				}
			}
			if (elc[i] > m.random() * 60.0F)
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

	public void fixit(final Graphics2D graphics2d) {
		if (fcnt == 1)
			for (int i = 0; i < npl; i++) {
				p[i].hsb[0] = 0.57F;
				p[i].hsb[2] = 0.8F;
				p[i].hsb[1] = 0.8F;
				final Color color = Color.getHSBColor(p[i].hsb[0], p[i].hsb[1], p[i].hsb[2]);
				int i_167_ = (int) (color.getRed() + color.getRed() * (m.snap[0] / 100.0F));
				if (i_167_ > 255)
					i_167_ = 255;
				if (i_167_ < 0)
					i_167_ = 0;
				int i_168_ = (int) (color.getGreen() + color.getGreen() * (m.snap[1] / 100.0F));
				if (i_168_ > 255)
					i_168_ = 255;
				if (i_168_ < 0)
					i_168_ = 0;
				int i_169_ = (int) (color.getBlue() + color.getBlue() * (m.snap[2] / 100.0F));
				if (i_169_ > 255)
					i_169_ = 255;
				if (i_169_ < 0)
					i_169_ = 0;
				Color.RGBtoHSB(i_167_, i_168_, i_169_, p[i].hsb);
				p[i].flx = 1;
			}
		if (fcnt == 2)
			for (int i = 0; i < npl; i++)
				p[i].flx = 1;
		if (fcnt == 4)
			for (int i = 0; i < npl; i++)
				p[i].flx = 3;
		if ((fcnt == 1 || fcnt > 2) && fcnt != 9) {
			final int[] is = new int[8];
			final int[] is_170_ = new int[8];
			final int[] is_171_ = new int[4];
			for (int i = 0; i < 4; i++) {
				is[i] = keyx[i] + x - m.x;
				is_170_[i] = grat + y - m.y;
				is_171_[i] = keyz[i] + z - m.z;
			}
			rot(is, is_170_, x - m.x, y - m.y, xy, 4);
			rot(is_170_, is_171_, y - m.y, z - m.y, zy, 4);
			rot(is, is_171_, x - m.x, z - m.z, xz, 4);
			rot(is, is_171_, m.cx, m.cz, m.xz, 4);
			rot(is_170_, is_171_, m.cy, m.cz, m.zy, 4);
			int i = 0;
			int i_172_ = 0;
			int i_173_ = 0;
			for (int i_174_ = 0; i_174_ < 4; i_174_++)
				for (int i_175_ = 0; i_175_ < 4; i_175_++) {
					if (Math.abs(is[i_174_] - is[i_175_]) > i)
						i = Math.abs(is[i_174_] - is[i_175_]);
					if (Math.abs(is_170_[i_174_] - is_170_[i_175_]) > i_172_)
						i_172_ = Math.abs(is_170_[i_174_] - is_170_[i_175_]);
					if (py(is[i_174_], is[i_175_], is_170_[i_174_], is_170_[i_175_]) > i_173_)
						i_173_ = py(is[i_174_], is[i_175_], is_170_[i_174_], is_170_[i_175_]);
				}
			i_173_ = (int) (Math.sqrt(i_173_) / 1.5);
			if (i < i_173_)
				i = i_173_;
			if (i_172_ < i_173_)
				i_172_ = i_173_;
			final int i_176_ = m.cx + (int) ((x - m.x - m.cx) * m.cos(m.xz) - (z - m.z - m.cz) * m.sin(m.xz));
			int i_177_ = m.cz + (int) ((x - m.x - m.cx) * m.sin(m.xz) + (z - m.z - m.cz) * m.cos(m.xz));
			final int i_178_ = m.cy + (int) ((y - m.y - m.cy) * m.cos(m.zy) - (i_177_ - m.cz) * m.sin(m.zy));
			i_177_ = m.cz + (int) ((y - m.y - m.cy) * m.sin(m.zy) + (i_177_ - m.cz) * m.cos(m.zy));
			is[0] = xs((int) (i_176_ - i / 0.8 - m.random() * (i / 2.4)), i_177_);
			is_170_[0] = ys((int) (i_178_ - i_172_ / 1.92 - m.random() * (i_172_ / 5.67)), i_177_);
			is[1] = xs((int) (i_176_ - i / 0.8 - m.random() * (i / 2.4)), i_177_);
			is_170_[1] = ys((int) (i_178_ + i_172_ / 1.92 + m.random() * (i_172_ / 5.67)), i_177_);
			is[2] = xs((int) (i_176_ - i / 1.92 - m.random() * (i / 5.67)), i_177_);
			is_170_[2] = ys((int) (i_178_ + i_172_ / 0.8 + m.random() * (i_172_ / 2.4)), i_177_);
			is[3] = xs((int) (i_176_ + i / 1.92 + m.random() * (i / 5.67)), i_177_);
			is_170_[3] = ys((int) (i_178_ + i_172_ / 0.8 + m.random() * (i_172_ / 2.4)), i_177_);
			is[4] = xs((int) (i_176_ + i / 0.8 + m.random() * (i / 2.4)), i_177_);
			is_170_[4] = ys((int) (i_178_ + i_172_ / 1.92 + m.random() * (i_172_ / 5.67)), i_177_);
			is[5] = xs((int) (i_176_ + i / 0.8 + m.random() * (i / 2.4)), i_177_);
			is_170_[5] = ys((int) (i_178_ - i_172_ / 1.92 - m.random() * (i_172_ / 5.67)), i_177_);
			is[6] = xs((int) (i_176_ + i / 1.92 + m.random() * (i / 5.67)), i_177_);
			is_170_[6] = ys((int) (i_178_ - i_172_ / 0.8 - m.random() * (i_172_ / 2.4)), i_177_);
			is[7] = xs((int) (i_176_ - i / 1.92 - m.random() * (i / 5.67)), i_177_);
			is_170_[7] = ys((int) (i_178_ - i_172_ / 0.8 - m.random() * (i_172_ / 2.4)), i_177_);
			if (fcnt == 3)
				rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), 22, 8);
			if (fcnt == 4)
				rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), 22, 8);
			if (fcnt == 5)
				rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), 0, 8);
			if (fcnt == 6)
				rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), -22, 8);
			if (fcnt == 7)
				rot(is, is_170_, xs(i_176_, i_177_), ys(i_178_, i_177_), -22, 8);
			int i_179_ = (int) (191.0F + 191.0F * (m.snap[0] / 350.0F));
			if (i_179_ > 255)
				i_179_ = 255;
			if (i_179_ < 0)
				i_179_ = 0;
			int i_180_ = (int) (232.0F + 232.0F * (m.snap[1] / 350.0F));
			if (i_180_ > 255)
				i_180_ = 255;
			if (i_180_ < 0)
				i_180_ = 0;
			int i_181_ = (int) (255.0F + 255.0F * (m.snap[2] / 350.0F));
			if (i_181_ > 255)
				i_181_ = 255;
			if (i_181_ < 0)
				i_181_ = 0;
			graphics2d.setColor(new Color(i_179_, i_180_, i_181_));
			graphics2d.fillPolygon(is, is_170_, 8);
			is[0] = xs((int) (i_176_ - i - m.random() * (i / 4)), i_177_);
			is_170_[0] = ys((int) (i_178_ - i_172_ / 2.4 - m.random() * (i_172_ / 9.6)), i_177_);
			is[1] = xs((int) (i_176_ - i - m.random() * (i / 4)), i_177_);
			is_170_[1] = ys((int) (i_178_ + i_172_ / 2.4 + m.random() * (i_172_ / 9.6)), i_177_);
			is[2] = xs((int) (i_176_ - i / 2.4 - m.random() * (i / 9.6)), i_177_);
			is_170_[2] = ys((int) (i_178_ + i_172_ + m.random() * (i_172_ / 4)), i_177_);
			is[3] = xs((int) (i_176_ + i / 2.4 + m.random() * (i / 9.6)), i_177_);
			is_170_[3] = ys((int) (i_178_ + i_172_ + m.random() * (i_172_ / 4)), i_177_);
			is[4] = xs((int) (i_176_ + i + m.random() * (i / 4)), i_177_);
			is_170_[4] = ys((int) (i_178_ + i_172_ / 2.4 + m.random() * (i_172_ / 9.6)), i_177_);
			is[5] = xs((int) (i_176_ + i + m.random() * (i / 4)), i_177_);
			is_170_[5] = ys((int) (i_178_ - i_172_ / 2.4 - m.random() * (i_172_ / 9.6)), i_177_);
			is[6] = xs((int) (i_176_ + i / 2.4 + m.random() * (i / 9.6)), i_177_);
			is_170_[6] = ys((int) (i_178_ - i_172_ - m.random() * (i_172_ / 4)), i_177_);
			is[7] = xs((int) (i_176_ - i / 2.4 - m.random() * (i / 9.6)), i_177_);
			is_170_[7] = ys((int) (i_178_ - i_172_ - m.random() * (i_172_ / 4)), i_177_);
			i_179_ = (int) (213.0F + 213.0F * (m.snap[0] / 350.0F));
			if (i_179_ > 255)
				i_179_ = 255;
			if (i_179_ < 0)
				i_179_ = 0;
			i_180_ = (int) (239.0F + 239.0F * (m.snap[1] / 350.0F));
			if (i_180_ > 255)
				i_180_ = 255;
			if (i_180_ < 0)
				i_180_ = 0;
			i_181_ = (int) (255.0F + 255.0F * (m.snap[2] / 350.0F));
			if (i_181_ > 255)
				i_181_ = 255;
			if (i_181_ < 0)
				i_181_ = 0;
			graphics2d.setColor(new Color(i_179_, i_180_, i_181_));
			graphics2d.fillPolygon(is, is_170_, 8);
		}
		if (fcnt > 7) {
			fcnt = 0;
			fix = false;
		} else
			fcnt++;
	}

	public int getpy(final int i, final int i_267_, final int i_268_) {
		return (i - x) / 10 * ((i - x) / 10) + (i_267_ - y) / 10 * ((i_267_ - y) / 10)
				+ (i_268_ - z) / 10 * ((i_268_ - z) / 10);
	}

	public int getvalue(final String string, final String string_262_, final int i) {
		int i_263_ = 0;
		String string_264_ = "";
		for (int i_265_ = string.length() + 1; i_265_ < string_262_.length(); i_265_++) {
			final String string_266_ = new StringBuilder().append("").append(string_262_.charAt(i_265_)).toString();
			if (string_266_.equals(",") || string_266_.equals(")")) {
				i_263_++;
				i_265_++;
			}
			if (i_263_ == i)
				string_264_ = new StringBuilder().append(string_264_).append(string_262_.charAt(i_265_)).toString();
		}
		return Float.valueOf(string_264_).intValue();
	}

	public void lowshadow(final Graphics2D graphics2d, final int i) {
		final int[] is = new int[4];
		final int[] is_146_ = new int[4];
		final int[] is_147_ = new int[4];
		int i_148_ = 1;
		int i_149_;
		for (i_149_ = Math.abs(zy); i_149_ > 270; i_149_ -= 360) {
			/* empty */
		}
		i_149_ = Math.abs(i_149_);
		if (i_149_ > 90)
			i_148_ = -1;
		is[0] = (int) (keyx[0] * 1.2 + x - m.x);
		is_147_[0] = (int) ((keyz[0] + 30) * i_148_ * 1.2 + z - m.z);
		is[1] = (int) (keyx[1] * 1.2 + x - m.x);
		is_147_[1] = (int) ((keyz[1] + 30) * i_148_ * 1.2 + z - m.z);
		is[2] = (int) (keyx[3] * 1.2 + x - m.x);
		is_147_[2] = (int) ((keyz[3] - 30) * i_148_ * 1.2 + z - m.z);
		is[3] = (int) (keyx[2] * 1.2 + x - m.x);
		is_147_[3] = (int) ((keyz[2] - 30) * i_148_ * 1.2 + z - m.z);
		rot(is, is_147_, x - m.x, z - m.z, xz, 4);
		int i_150_ = (int) (m.crgrnd[0] / 1.5);
		int i_151_ = (int) (m.crgrnd[1] / 1.5);
		int i_152_ = (int) (m.crgrnd[2] / 1.5);
		for (int i_153_ = 0; i_153_ < 4; i_153_++)
			is_146_[i_153_] = m.ground;
		if (t.ncx != 0 || t.ncz != 0) {
			int i_154_ = (x - t.sx) / 3000;
			if (i_154_ > t.ncx)
				i_154_ = t.ncx;
			if (i_154_ < 0)
				i_154_ = 0;
			int i_155_ = (z - t.sz) / 3000;
			if (i_155_ > t.ncz)
				i_155_ = t.ncz;
			if (i_155_ < 0)
				i_155_ = 0;
			for (int i_156_ = t.sect[i_154_][i_155_].length - 1; i_156_ >= 0; i_156_--) {
				final int i_157_ = t.sect[i_154_][i_155_][i_156_];
				int i_158_ = 0;
				for (int i_159_ = 0; i_159_ < 4; i_159_++)
					if (Math.abs(t.zy[i_157_]) != 90 && Math.abs(t.xy[i_157_]) != 90 && t.rady[i_157_] != 801
							&& Math.abs(is[i_159_] - (t.x[i_157_] - m.x)) < t.radx[i_157_]
							&& Math.abs(is_147_[i_159_] - (t.z[i_157_] - m.z)) < t.radz[i_157_]
							&& (!t.decor[i_157_] || m.resdown != 2))
						i_158_++;
				if (i_158_ > 2) {
					for (int i_160_ = 0; i_160_ < 4; i_160_++) {
						is_146_[i_160_] = t.y[i_157_] - m.y;
						if (t.zy[i_157_] != 0)
							is_146_[i_160_] += (is_147_[i_160_] - (t.z[i_157_] - m.z - t.radz[i_157_]))
									* m.sin(t.zy[i_157_]) / m.sin(90 - t.zy[i_157_])
									- t.radz[i_157_] * m.sin(t.zy[i_157_]) / m.sin(90 - t.zy[i_157_]);
						if (t.xy[i_157_] != 0)
							is_146_[i_160_] += (is[i_160_] - (t.x[i_157_] - m.x - t.radx[i_157_])) * m.sin(t.xy[i_157_])
									/ m.sin(90 - t.xy[i_157_])
									- t.radx[i_157_] * m.sin(t.xy[i_157_]) / m.sin(90 - t.xy[i_157_]);
					}
					i_150_ = (int) (t.c[i_157_][0] / 1.5);
					i_151_ = (int) (t.c[i_157_][1] / 1.5);
					i_152_ = (int) (t.c[i_157_][2] / 1.5);
					break;
				}
			}
		}
		rot(is, is_147_, m.cx, m.cz, m.xz, 4);
		rot(is_146_, is_147_, m.cy, m.cz, m.zy, 4);
		boolean bool = true;
		int i_161_ = 0;
		int i_162_ = 0;
		int i_163_ = 0;
		int i_164_ = 0;
		for (int i_165_ = 0; i_165_ < 4; i_165_++) {
			is[i_165_] = xs(is[i_165_], is_147_[i_165_]);
			is_146_[i_165_] = ys(is_146_[i_165_], is_147_[i_165_]);
			if (is_146_[i_165_] < m.ih || is_147_[i_165_] < 10)
				i_161_++;
			if (is_146_[i_165_] > m.h || is_147_[i_165_] < 10)
				i_162_++;
			if (is[i_165_] < m.iw || is_147_[i_165_] < 10)
				i_163_++;
			if (is[i_165_] > m.w || is_147_[i_165_] < 10)
				i_164_++;
		}
		if (i_163_ == 4 || i_161_ == 4 || i_162_ == 4 || i_164_ == 4)
			bool = false;
		if (bool) {
			for (int i_166_ = 0; i_166_ < 16; i_166_++)
				if (i > m.fade[i_166_]) {
					i_150_ = (i_150_ * m.fogd + m.cfade[0]) / (m.fogd + 1);
					i_151_ = (i_151_ * m.fogd + m.cfade[1]) / (m.fogd + 1);
					i_152_ = (i_152_ * m.fogd + m.cfade[2]) / (m.fogd + 1);
				}
			graphics2d.setColor(new Color(i_150_, i_151_, i_152_));
			graphics2d.fillPolygon(is, is_146_, 4);
		}
	}

	public void pdust(final int i, final Graphics2D graphics2d, final boolean bool) {
		if (bool)
			sav[i] = (int) Math.sqrt((m.x + m.cx - sx[i]) * (m.x + m.cx - sx[i])
					+ (m.y + m.cy - sy[i]) * (m.y + m.cy - sy[i]) + (m.z - sz[i]) * (m.z - sz[i]));
		if (bool && sav[i] > dist || !bool && sav[i] <= dist) {
			if (stg[i] == 1) {
				sbln[i] = 0.6F;
				boolean bool_208_ = false;
				final int[] is = new int[3];
				for (int i_209_ = 0; i_209_ < 3; i_209_++) {
					is[i_209_] = (int) (255.0F + 255.0F * (m.snap[i_209_] / 100.0F));
					if (is[i_209_] > 255)
						is[i_209_] = 255;
					if (is[i_209_] < 0)
						is[i_209_] = 0;
				}
				int i_210_ = (x - t.sx) / 3000;
				if (i_210_ > t.ncx)
					i_210_ = t.ncx;
				if (i_210_ < 0)
					i_210_ = 0;
				int i_211_ = (z - t.sz) / 3000;
				if (i_211_ > t.ncz)
					i_211_ = t.ncz;
				if (i_211_ < 0)
					i_211_ = 0;
				for (int i_212_ = 0; i_212_ < t.sect[i_210_][i_211_].length; i_212_++) {
					final int i_213_ = t.sect[i_210_][i_211_][i_212_];
					if (Math.abs(t.zy[i_213_]) != 90 && Math.abs(t.xy[i_213_]) != 90
							&& Math.abs(sx[i] - t.x[i_213_]) < t.radx[i_213_]
							&& Math.abs(sz[i] - t.z[i_213_]) < t.radz[i_213_]) {
						if (t.skd[i_213_] == 0)
							sbln[i] = 0.2F;
						if (t.skd[i_213_] == 1)
							sbln[i] = 0.4F;
						if (t.skd[i_213_] == 2)
							sbln[i] = 0.45F;
						for (int i_214_ = 0; i_214_ < 3; i_214_++)
							srgb[i][i_214_] = (t.c[i_213_][i_214_] + is[i_214_]) / 2;
						bool_208_ = true;
					}
				}
				if (!bool_208_)
					for (int i_215_ = 0; i_215_ < 3; i_215_++)
						srgb[i][i_215_] = (m.crgrnd[i_215_] + is[i_215_]) / 2;
				float f = (float) (0.1 + m.random());
				if (f > 1.0F)
					f = 1.0F;
				scx[i] = (int) (scx[i] * f);
				scz[i] = (int) (scx[i] * f);
				for (int i_216_ = 0; i_216_ < 8; i_216_++)
					smag[i][i_216_] = osmag[i] * m.random() * 50.0F;
				for (int i_217_ = 0; i_217_ < 8; i_217_++) {
					int i_218_ = i_217_ - 1;
					if (i_218_ == -1)
						i_218_ = 7;
					int i_219_ = i_217_ + 1;
					if (i_219_ == 8)
						i_219_ = 0;
					smag[i][i_217_] = ((smag[i][i_218_] + smag[i][i_219_]) / 2.0F + smag[i][i_217_]) / 2.0F;
				}
				smag[i][6] = smag[i][7];
			}
			final int i_220_ = m.cx + (int) ((sx[i] - m.x - m.cx) * m.cos(m.xz) - (sz[i] - m.z - m.cz) * m.sin(m.xz));
			int i_221_ = m.cz + (int) ((sx[i] - m.x - m.cx) * m.sin(m.xz) + (sz[i] - m.z - m.cz) * m.cos(m.xz));
			final int i_222_ = m.cy
					+ (int) ((sy[i] - m.y - m.cy - smag[i][7]) * m.cos(m.zy) - (i_221_ - m.cz) * m.sin(m.zy));
			i_221_ = m.cz + (int) ((sy[i] - m.y - m.cy - smag[i][7]) * m.sin(m.zy) + (i_221_ - m.cz) * m.cos(m.zy));
			sx[i] += scx[i] / (stg[i] + 1);
			sz[i] += scz[i] / (stg[i] + 1);
			final int[] is = new int[8];
			final int[] is_223_ = new int[8];
			is[0] = xs((int) (i_220_ + smag[i][0] * 0.9238F * 1.5F), i_221_);
			is_223_[0] = ys((int) (i_222_ + smag[i][0] * 0.3826F * 1.5F), i_221_);
			is[1] = xs((int) (i_220_ + smag[i][1] * 0.9238F * 1.5F), i_221_);
			is_223_[1] = ys((int) (i_222_ - smag[i][1] * 0.3826F * 1.5F), i_221_);
			is[2] = xs((int) (i_220_ + smag[i][2] * 0.3826F), i_221_);
			is_223_[2] = ys((int) (i_222_ - smag[i][2] * 0.9238F), i_221_);
			is[3] = xs((int) (i_220_ - smag[i][3] * 0.3826F), i_221_);
			is_223_[3] = ys((int) (i_222_ - smag[i][3] * 0.9238F), i_221_);
			is[4] = xs((int) (i_220_ - smag[i][4] * 0.9238F * 1.5F), i_221_);
			is_223_[4] = ys((int) (i_222_ - smag[i][4] * 0.3826F * 1.5F), i_221_);
			is[5] = xs((int) (i_220_ - smag[i][5] * 0.9238F * 1.5F), i_221_);
			is_223_[5] = ys((int) (i_222_ + smag[i][5] * 0.3826F * 1.5F), i_221_);
			is[6] = xs((int) (i_220_ - smag[i][6] * 0.3826F * 1.7F), i_221_);
			is_223_[6] = ys((int) (i_222_ + smag[i][6] * 0.9238F), i_221_);
			is[7] = xs((int) (i_220_ + smag[i][7] * 0.3826F * 1.7F), i_221_);
			is_223_[7] = ys((int) (i_222_ + smag[i][7] * 0.9238F), i_221_);
			for (int i_224_ = 0; i_224_ < 7; i_224_++)
				smag[i][i_224_] += 5.0F + m.random() * 15.0F;
			smag[i][7] = smag[i][6];
			boolean bool_225_ = true;
			int i_226_ = 0;
			int i_227_ = 0;
			int i_228_ = 0;
			int i_229_ = 0;
			for (int i_230_ = 0; i_230_ < 8; i_230_++) {
				if (is_223_[i_230_] < m.ih || i_221_ < 10)
					i_226_++;
				if (is_223_[i_230_] > m.h || i_221_ < 10)
					i_227_++;
				if (is[i_230_] < m.iw || i_221_ < 10)
					i_228_++;
				if (is[i_230_] > m.w || i_221_ < 10)
					i_229_++;
			}
			if (i_228_ == 4 || i_226_ == 4 || i_227_ == 4 || i_229_ == 4)
				bool_225_ = false;
			if (bool_225_) {
				int i_231_ = srgb[i][0];
				int i_232_ = srgb[i][1];
				int i_233_ = srgb[i][2];
				for (int i_234_ = 0; i_234_ < 16; i_234_++)
					if (sav[i] > m.fade[i_234_]) {
						i_231_ = (i_231_ * m.fogd + m.cfade[0]) / (m.fogd + 1);
						i_232_ = (i_232_ * m.fogd + m.cfade[1]) / (m.fogd + 1);
						i_233_ = (i_233_ * m.fogd + m.cfade[2]) / (m.fogd + 1);
					}
				graphics2d.setColor(new Color(i_231_, i_232_, i_233_));
				final float f = sbln[i] - stg[i] * (sbln[i] / 8.0F);
				graphics2d.setComposite(AlphaComposite.getInstance(3, f));
				graphics2d.fillPolygon(is, is_223_, 8);
				graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
			}
			if (stg[i] == 7)
				stg[i] = 0;
			else
				stg[i]++;
		}
	}

	public int py(final int i, final int i_269_, final int i_270_, final int i_271_) {
		return (i - i_269_) * (i - i_269_) + (i_270_ - i_271_) * (i_270_ - i_271_);
	}

	public void rot(final int[] is, final int[] is_272_, final int i, final int i_273_, final int i_274_,
			final int i_275_) {
		if (i_274_ != 0)
			for (int i_276_ = 0; i_276_ < i_275_; i_276_++) {
				final int i_277_ = is[i_276_];
				final int i_278_ = is_272_[i_276_];
				is[i_276_] = i + (int) ((i_277_ - i) * m.cos(i_274_) - (i_278_ - i_273_) * m.sin(i_274_));
				is_272_[i_276_] = i_273_ + (int) ((i_277_ - i) * m.sin(i_274_) + (i_278_ - i_273_) * m.cos(i_274_));
			}
	}

	public void sprk(final float f, final float f_235_, final float f_236_, final float f_237_, final float f_238_,
			final float f_239_, final int i) {
		if (i != 1) {
			srx = (int) (f - sprkat * m.sin(xz));
			sry = (int) (f_235_ - sprkat * m.cos(zy) * m.cos(xy));
			srz = (int) (f_236_ + sprkat * m.cos(xz));
			sprk = 1;
		} else {
			sprk++;
			if (sprk == 4) {
				srx = (int) (x + f_237_);
				sry = (int) f_235_;
				srz = (int) (z + f_239_);
				sprk = 5;
			} else {
				srx = (int) f;
				sry = (int) f_235_;
				srz = (int) f_236_;
			}
		}
		if (i == 2)
			sprk = 6;
		rcx = f_237_;
		rcy = f_238_;
		rcz = f_239_;
	}

	public int xs(final int i, int i_260_) {
		if (i_260_ < 50)
			i_260_ = 50;
		return (i_260_ - m.focus_point) * (m.cx - i) / i_260_ + i;
	}

	public int ys(final int i, int i_261_) {
		if (i_261_ < 50)
			i_261_ = 50;
		return (i_261_ - m.focus_point) * (m.cy - i) / i_261_ + i;
	}
}
