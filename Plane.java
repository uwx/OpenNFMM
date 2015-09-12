/* Plane - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Plane
{
    Medium m;
    Trackers t;
    int[] ox;
    int[] oy;
    int[] oz;
    int n;
    int[] c = new int[3];
    int[] oc = new int[3];
    float[] hsb = new float[3];
    int glass = 0;
    int gr = 0;
    int fs = 0;
    int disline = 7;
    boolean road = false;
    boolean solo = false;
    int light = 0;
    int master = 0;
    int wx = 0;
    int wz = 0;
    int wy = 0;
    float deltaf = 1.0F;
    float projf = 1.0F;
    int av = 0;
    int bfase = 0;
    boolean nocol = false;
    int chip = 0;
    float ctmag = 0.0F;
    int cxz = 0;
    int cxy = 0;
    int czy = 0;
    int[] cox = new int[3];
    int[] coz = new int[3];
    int[] coy = new int[3];
    int dx = 0;
    int dy = 0;
    int dz = 0;
    int vx = 0;
    int vy = 0;
    int vz = 0;
    int embos = 0;
    int typ = 0;
    int pa = 0;
    int pb = 0;
    int flx = 0;
    int colnum = 0;
    
    public Plane(Medium medium, Trackers trackers, int[] is, int[] is_0_,
		 int[] is_1_, int i, int[] is_2_, int i_3_, int i_4_, int i_5_,
		 int i_6_, int i_7_, int i_8_, int i_9_, int i_10_,
		 boolean bool, int i_11_, boolean bool_12_) {
	m = medium;
	t = trackers;
	n = i;
	ox = new int[n];
	oz = new int[n];
	oy = new int[n];
	for (int i_13_ = 0; i_13_ < n; i_13_++) {
	    ox[i_13_] = is[i_13_];
	    oy[i_13_] = is_1_[i_13_];
	    oz[i_13_] = is_0_[i_13_];
	}
	for (int i_14_ = 0; i_14_ < 3; i_14_++)
	    oc[i_14_] = is_2_[i_14_];
	if (i_4_ == -15) {
	    if (is_2_[0] == 211) {
		int i_15_ = (int) (Math.random() * 40.0 - 20.0);
		int i_16_ = (int) (Math.random() * 40.0 - 20.0);
		for (int i_17_ = 0; i_17_ < n; i_17_++) {
		    ox[i_17_] += i_15_;
		    oz[i_17_] += i_16_;
		}
	    }
	    int i_18_ = (int) (185.0 + Math.random() * 20.0);
	    is_2_[0] = (217 + i_18_) / 2;
	    if (is_2_[0] == 211)
		is_2_[0] = 210;
	    is_2_[1] = (189 + i_18_) / 2;
	    is_2_[2] = (132 + i_18_) / 2;
	    for (int i_19_ = 0; i_19_ < n; i_19_++) {
		if (Math.random() > Math.random())
		    ox[i_19_]
			+= (int) (8.0 * Math.random() - 4.0);
		if (Math.random() > Math.random())
		    oy[i_19_]
			+= (int) (8.0 * Math.random() - 4.0);
		if (Math.random() > Math.random())
		    oz[i_19_]
			+= (int) (8.0 * Math.random() - 4.0);
	    }
	}
	if (is_2_[0] == is_2_[1] && is_2_[1] == is_2_[2])
	    nocol = true;
	if (i_3_ == 0) {
	    for (int i_20_ = 0; i_20_ < 3; i_20_++) {
		c[i_20_]
		    = (int) ((float) is_2_[i_20_]
			     + ((float) is_2_[i_20_]
				* ((float) ((m).snap
					    [i_20_])
				   / 100.0F)));
		if (c[i_20_] > 255)
		    c[i_20_] = 255;
		if (c[i_20_] < 0)
		    c[i_20_] = 0;
	    }
	}
	if (i_3_ == 1) {
	    for (int i_21_ = 0; i_21_ < 3; i_21_++)
		c[i_21_]
		    = ((((m).csky[i_21_]
			 * (m).fade[0] * 2)
			+ (m).cfade[i_21_] * 3000)
		       / ((m).fade[0] * 2 + 3000));
	}
	if (i_3_ == 2) {
	    for (int i_22_ = 0; i_22_ < 3; i_22_++)
		c[i_22_]
		    = (int) ((float) (m).crgrnd[i_22_]
			     * 0.925F);
	}
	if (i_3_ == 3) {
	    for (int i_23_ = 0; i_23_ < 3; i_23_++)
		c[i_23_] = is_2_[i_23_];
	}
	disline = i_9_;
	bfase = i_10_;
	glass = i_3_;
	Color.RGBtoHSB(c[0], c[1],
		       c[2], hsb);
	if (i_3_ == 3 && (m).trk != 2) {
	    hsb[1] += 0.05F;
	    if (hsb[1] > 1.0F)
		hsb[1] = 1.0F;
	}
	if (!nocol && glass != 1) {
	    if (bfase > 20
		&& (double) hsb[1] > 0.25)
		hsb[1] = 0.25F;
	    if (bfase > 25
		&& (double) hsb[2] > 0.7)
		hsb[2] = 0.7F;
	    if (bfase > 30
		&& (double) hsb[1] > 0.15)
		hsb[1] = 0.15F;
	    if (bfase > 35
		&& (double) hsb[2] > 0.6)
		hsb[2] = 0.6F;
	    if (bfase > 40)
		hsb[0] = 0.075F;
	    if (bfase > 50
		&& (double) hsb[2] > 0.5)
		hsb[2] = 0.5F;
	    if (bfase > 60)
		hsb[0] = 0.05F;
	}
	road = bool;
	light = i_11_;
	solo = bool_12_;
	gr = i_4_;
	fs = i_5_;
	wx = i_6_;
	wy = i_7_;
	wz = i_8_;
	deltafntyp();
    }
    
    public void deltafntyp() {
	int i = Math.abs(ox[2] - ox[1]);
	int i_24_ = Math.abs(oy[2] - oy[1]);
	int i_25_ = Math.abs(oz[2] - oz[1]);
	if (i_24_ <= i && i_24_ <= i_25_)
	    typ = 2;
	if (i <= i_24_ && i <= i_25_)
	    typ = 1;
	if (i_25_ <= i && i_25_ <= i_24_)
	    typ = 3;
	deltaf = 1.0F;
	for (int i_26_ = 0; i_26_ < 3; i_26_++) {
	    for (int i_27_ = 0; i_27_ < 3; i_27_++) {
		if (i_27_ != i_26_)
		    deltaf
			*= (float) ((Math.sqrt
				     ((double) (((ox[i_27_]
						  - ox[i_26_])
						 * (ox[i_27_]
						    - (ox
						       [i_26_])))
						+ ((oy[i_27_]
						    - oy[i_26_])
						   * (oy[i_27_]
						      - (oy
							 [i_26_])))
						+ ((oz[i_27_]
						    - oz[i_26_])
						   * (oz[i_27_]
						      - (oz
							 [i_26_]))))))
				    / 100.0);
	    }
	}
	deltaf = deltaf / 3.0F;
    }
    
    public void loadprojf() {
	projf = 1.0F;
	for (int i = 0; i < 3; i++) {
	    for (int i_28_ = 0; i_28_ < 3; i_28_++) {
		if (i_28_ != i)
		    projf
			*= (float) ((Math.sqrt
				     ((double) (((ox[i]
						  - ox[i_28_])
						 * (ox[i]
						    - (ox
						       [i_28_])))
						+ ((oz[i]
						    - oz[i_28_])
						   * (oz[i]
						      - (oz
							 [i_28_]))))))
				    / 100.0);
	    }
	}
	projf = projf / 3.0F;
    }
    
    public void d(Graphics2D graphics2d, int i, int i_29_, int i_30_,
		  int i_31_, int i_32_, int i_33_, int i_34_, int i_35_,
		  boolean bool, int i_36_) {
	if (master == 1) {
	    if (av > 1500 && !(m).crs)
		n = 12;
	    else
		n = 20;
	}
	int[] is = new int[n];
	int[] is_37_ = new int[n];
	int[] is_38_ = new int[n];
	if (embos == 0) {
	    for (int i_39_ = 0; i_39_ < n; i_39_++) {
		is[i_39_] = ox[i_39_] + i;
		is_38_[i_39_] = oy[i_39_] + i_29_;
		is_37_[i_39_] = oz[i_39_] + i_30_;
	    }
	    if ((gr == -11 || gr == -12
		 || gr == -13)
		&& (m).lastmaf == 1) {
		for (int i_40_ = 0; i_40_ < n; i_40_++) {
		    is[i_40_] = -ox[i_40_] + i;
		    is_38_[i_40_] = oy[i_40_] + i_29_;
		    is_37_[i_40_] = -oz[i_40_] + i_30_;
		}
	    }
	} else {
	    if (embos <= 11
		&& (double) m.random() > 0.5
		&& glass != 1) {
		for (int i_41_ = 0; i_41_ < n; i_41_++) {
		    is[i_41_]
			= (int) ((float) (ox[i_41_] + i)
				 + (15.0F
				    - m.random() * 30.0F));
		    is_38_[i_41_]
			= (int) ((float) (oy[i_41_] + i_29_)
				 + (15.0F
				    - m.random() * 30.0F));
		    is_37_[i_41_]
			= (int) ((float) (oz[i_41_] + i_30_)
				 + (15.0F
				    - m.random() * 30.0F));
		}
		rot(is, is_38_, i, i_29_, i_32_, n);
		rot(is_38_, is_37_, i_29_, i_30_, i_33_, n);
		rot(is, is_37_, i, i_30_, i_31_, n);
		rot(is, is_37_, (m).cx,
		    (m).cz,
		    (m).xz, n);
		rot(is_38_, is_37_, (m).cy,
		    (m).cz,
		    (m).zy, n);
		int[] is_42_ = new int[n];
		int[] is_43_ = new int[n];
		for (int i_44_ = 0; i_44_ < n; i_44_++) {
		    is_42_[i_44_] = xs(is[i_44_], is_37_[i_44_]);
		    is_43_[i_44_] = ys(is_38_[i_44_], is_37_[i_44_]);
		}
		graphics2d.setColor(new Color(230, 230, 230));
		graphics2d.fillPolygon(is_42_, is_43_, n);
	    }
	    float f = 1.0F;
	    if (embos <= 4)
		f = 1.0F + m.random() / 5.0F;
	    if (embos > 4 && embos <= 7)
		f = 1.0F + m.random() / 4.0F;
	    if (embos > 7 && embos <= 9) {
		f = 1.0F + m.random() / 3.0F;
		if ((double) hsb[2] > 0.7)
		    hsb[2] = 0.7F;
	    }
	    if (embos > 9 && embos <= 10) {
		f = 1.0F + m.random() / 2.0F;
		if ((double) hsb[2] > 0.6)
		    hsb[2] = 0.6F;
	    }
	    if (embos > 10 && embos <= 12) {
		f = 1.0F + m.random() / 1.0F;
		if ((double) hsb[2] > 0.5)
		    hsb[2] = 0.5F;
	    }
	    if (embos == 12) {
		chip = 1;
		ctmag = 2.0F;
		bfase = -7;
	    }
	    if (embos == 13) {
		hsb[1] = 0.2F;
		hsb[2] = 0.4F;
	    }
	    if (embos == 16) {
		pa = (int) (m.random()
					   * (float) n);
		for (pb = (int) (m.random()
						* (float) n);
		     pa == pb;
		     pb = (int) (m.random()
						* (float) n)) {
		    /* empty */
		}
	    }
	    if (embos >= 16) {
		int i_45_ = 1;
		int i_46_ = 1;
		int i_47_;
		for (i_47_ = Math.abs(i_33_); i_47_ > 270; i_47_ -= 360) {
		    /* empty */
		}
		i_47_ = Math.abs(i_47_);
		if (i_47_ > 90)
		    i_45_ = -1;
		int i_48_;
		for (i_48_ = Math.abs(i_32_); i_48_ > 270; i_48_ -= 360) {
		    /* empty */
		}
		i_48_ = Math.abs(i_48_);
		if (i_48_ > 90)
		    i_46_ = -1;
		int[] is_49_ = new int[3];
		int[] is_50_ = new int[3];
		is[0] = ox[pa] + i;
		is_38_[0] = oy[pa] + i_29_;
		is_37_[0] = oz[pa] + i_30_;
		is[1] = ox[pb] + i;
		is_38_[1] = oy[pb] + i_29_;
		is_37_[1] = oz[pb] + i_30_;
		while (Math.abs(is[0] - is[1]) > 100) {
		    if (is[1] > is[0])
			is[1] -= 30;
		    else
			is[1] += 30;
		}
		while (Math.abs(is_37_[0] - is_37_[1]) > 100) {
		    if (is_37_[1] > is_37_[0])
			is_37_[1] -= 30;
		    else
			is_37_[1] += 30;
		}
		int i_51_
		    = (int) ((double) (Math.abs(is[0] - is[1]) / 3)
			     * (0.5 - (double) m.random()));
		int i_52_
		    = (int) ((double) (Math.abs(is_37_[0] - is_37_[1]) / 3)
			     * (0.5 - (double) m.random()));
		is[2] = (is[0] + is[1]) / 2 + i_51_;
		is_37_[2] = (is_37_[0] + is_37_[1]) / 2 + i_52_;
		int i_53_
		    = (int) ((double) (Math.abs(is[0] - is[1])
				       + Math.abs(is_37_[0] - is_37_[1]))
			     / 1.5
			     * ((double) (m.random() / 2.0F)
				+ 0.5));
		is_38_[2]
		    = (is_38_[0] + is_38_[1]) / 2 - i_45_ * i_46_ * i_53_;
		rot(is, is_38_, i, i_29_, i_32_, 3);
		rot(is_38_, is_37_, i_29_, i_30_, i_33_, 3);
		rot(is, is_37_, i, i_30_, i_31_, 3);
		rot(is, is_37_, (m).cx,
		    (m).cz,
		    (m).xz, 3);
		rot(is_38_, is_37_, (m).cy,
		    (m).cz,
		    (m).zy, 3);
		for (int i_54_ = 0; i_54_ < 3; i_54_++) {
		    is_49_[i_54_] = xs(is[i_54_], is_37_[i_54_]);
		    is_50_[i_54_] = ys(is_38_[i_54_], is_37_[i_54_]);
		}
		int i_55_
		    = (int) (255.0F
			     + (255.0F
				* ((float) (m).snap[0]
				   / 400.0F)));
		if (i_55_ > 255)
		    i_55_ = 255;
		if (i_55_ < 0)
		    i_55_ = 0;
		int i_56_
		    = (int) (169.0F
			     + (169.0F
				* ((float) (m).snap[1]
				   / 300.0F)));
		if (i_56_ > 255)
		    i_56_ = 255;
		if (i_56_ < 0)
		    i_56_ = 0;
		int i_57_
		    = (int) (89.0F
			     + (89.0F
				* ((float) (m).snap[2]
				   / 200.0F)));
		if (i_57_ > 255)
		    i_57_ = 255;
		if (i_57_ < 0)
		    i_57_ = 0;
		graphics2d.setColor(new Color(i_55_, i_56_, i_57_));
		graphics2d.fillPolygon(is_49_, is_50_, 3);
		is[0] = ox[pa] + i;
		is_38_[0] = oy[pa] + i_29_;
		is_37_[0] = oz[pa] + i_30_;
		is[1] = ox[pb] + i;
		is_38_[1] = oy[pb] + i_29_;
		is_37_[1] = oz[pb] + i_30_;
		while (Math.abs(is[0] - is[1]) > 100) {
		    if (is[1] > is[0])
			is[1] -= 30;
		    else
			is[1] += 30;
		}
		while (Math.abs(is_37_[0] - is_37_[1]) > 100) {
		    if (is_37_[1] > is_37_[0])
			is_37_[1] -= 30;
		    else
			is_37_[1] += 30;
		}
		is[2] = (is[0] + is[1]) / 2 + i_51_;
		is_37_[2] = (is_37_[0] + is_37_[1]) / 2 + i_52_;
		i_53_ *= 0.8;
		is_38_[2]
		    = (is_38_[0] + is_38_[1]) / 2 - i_45_ * i_46_ * i_53_;
		rot(is, is_38_, i, i_29_, i_32_, 3);
		rot(is_38_, is_37_, i_29_, i_30_, i_33_, 3);
		rot(is, is_37_, i, i_30_, i_31_, 3);
		rot(is, is_37_, (m).cx,
		    (m).cz,
		    (m).xz, 3);
		rot(is_38_, is_37_, (m).cy,
		    (m).cz,
		    (m).zy, 3);
		for (int i_58_ = 0; i_58_ < 3; i_58_++) {
		    is_49_[i_58_] = xs(is[i_58_], is_37_[i_58_]);
		    is_50_[i_58_] = ys(is_38_[i_58_], is_37_[i_58_]);
		}
		i_55_ = (int) (255.0F
			       + 255.0F * ((float) ((m)
						    .snap[0])
					   / 400.0F));
		if (i_55_ > 255)
		    i_55_ = 255;
		if (i_55_ < 0)
		    i_55_ = 0;
		i_56_ = (int) (207.0F
			       + 207.0F * ((float) ((m)
						    .snap[1])
					   / 300.0F));
		if (i_56_ > 255)
		    i_56_ = 255;
		if (i_56_ < 0)
		    i_56_ = 0;
		i_57_ = (int) (136.0F
			       + 136.0F * ((float) ((m)
						    .snap[2])
					   / 200.0F));
		if (i_57_ > 255)
		    i_57_ = 255;
		if (i_57_ < 0)
		    i_57_ = 0;
		graphics2d.setColor(new Color(i_55_, i_56_, i_57_));
		graphics2d.fillPolygon(is_49_, is_50_, 3);
	    }
	    for (int i_59_ = 0; i_59_ < n; i_59_++) {
		if (typ == 1)
		    is[i_59_] = (int) ((float) ox[i_59_] * f
				       + (float) i);
		else
		    is[i_59_] = ox[i_59_] + i;
		if (typ == 2)
		    is_38_[i_59_] = (int) ((float) oy[i_59_] * f
					   + (float) i_29_);
		else
		    is_38_[i_59_] = oy[i_59_] + i_29_;
		if (typ == 3)
		    is_37_[i_59_] = (int) ((float) oz[i_59_] * f
					   + (float) i_30_);
		else
		    is_37_[i_59_] = oz[i_59_] + i_30_;
	    }
	    if (embos != 70)
		embos++;
	    else
		embos = 16;
	}
	if (wz != 0)
	    rot(is_38_, is_37_, wy + i_29_,
		wz + i_30_, i_35_, n);
	if (wx != 0)
	    rot(is, is_37_, wx + i, wz + i_30_,
		i_34_, n);
	if (chip == 1
	    && ((double) m.random() > 0.6
		|| bfase == 0)) {
	    chip = 0;
	    if (bfase == 0 && nocol)
		bfase = 1;
	}
	if (chip != 0) {
	    if (chip == 1) {
		cxz = i_31_;
		cxy = i_32_;
		czy = i_33_;
		int i_60_ = (int) (m.random()
				   * (float) n);
		cox[0] = ox[i_60_];
		coz[0] = oz[i_60_];
		coy[0] = oy[i_60_];
		if (ctmag > 3.0F)
		    ctmag = 3.0F;
		if (ctmag < -3.0F)
		    ctmag = -3.0F;
		cox[1]
		    = (int) ((float) cox[0]
			     + (ctmag
				* (10.0F
				   - m.random() * 20.0F)));
		cox[2]
		    = (int) ((float) cox[0]
			     + (ctmag
				* (10.0F
				   - m.random() * 20.0F)));
		coy[1]
		    = (int) ((float) coy[0]
			     + (ctmag
				* (10.0F
				   - m.random() * 20.0F)));
		coy[2]
		    = (int) ((float) coy[0]
			     + (ctmag
				* (10.0F
				   - m.random() * 20.0F)));
		coz[1]
		    = (int) ((float) coz[0]
			     + (ctmag
				* (10.0F
				   - m.random() * 20.0F)));
		coz[2]
		    = (int) ((float) coz[0]
			     + (ctmag
				* (10.0F
				   - m.random() * 20.0F)));
		dx = 0;
		dy = 0;
		dz = 0;
		if (bfase != -7) {
		    vx
			= (int) (ctmag
				 * (30.0F
				    - m.random() * 60.0F));
		    vz
			= (int) (ctmag
				 * (30.0F
				    - m.random() * 60.0F));
		    vy
			= (int) (ctmag
				 * (30.0F
				    - m.random() * 60.0F));
		} else {
		    vx
			= (int) (ctmag
				 * (10.0F
				    - m.random() * 20.0F));
		    vz
			= (int) (ctmag
				 * (10.0F
				    - m.random() * 20.0F));
		    vy
			= (int) (ctmag
				 * (10.0F
				    - m.random() * 20.0F));
		}
		chip = 2;
	    }
	    int[] is_61_ = new int[3];
	    int[] is_62_ = new int[3];
	    int[] is_63_ = new int[3];
	    for (int i_64_ = 0; i_64_ < 3; i_64_++) {
		is_61_[i_64_] = cox[i_64_] + i;
		is_63_[i_64_] = coy[i_64_] + i_29_;
		is_62_[i_64_] = coz[i_64_] + i_30_;
	    }
	    rot(is_61_, is_63_, i, i_29_, cxy, 3);
	    rot(is_63_, is_62_, i_29_, i_30_, czy, 3);
	    rot(is_61_, is_62_, i, i_30_, cxz, 3);
	    for (int i_65_ = 0; i_65_ < 3; i_65_++) {
		is_61_[i_65_] += dx;
		is_63_[i_65_] += dy;
		is_62_[i_65_] += dz;
	    }
	    dx += vx;
	    dz += vz;
	    dy += vy;
	    vy += 7;
	    if (is_63_[0] > (m).ground)
		chip = 19;
	    rot(is_61_, is_62_, (m).cx,
		(m).cz, (m).xz,
		3);
	    rot(is_63_, is_62_, (m).cy,
		(m).cz, (m).zy,
		3);
	    int[] is_66_ = new int[3];
	    int[] is_67_ = new int[3];
	    for (int i_68_ = 0; i_68_ < 3; i_68_++) {
		is_66_[i_68_] = xs(is_61_[i_68_], is_62_[i_68_]);
		is_67_[i_68_] = ys(is_63_[i_68_], is_62_[i_68_]);
	    }
	    int i_69_ = (int) (m.random() * 3.0F);
	    if (bfase != -7) {
		if (i_69_ == 0)
		    graphics2d.setColor(new Color
					    (c[0],
					     c[1],
					     c[2])
					    .darker());
		if (i_69_ == 1)
		    graphics2d.setColor(new Color(c[0],
						  c[1],
						  c[2]));
		if (i_69_ == 2)
		    graphics2d.setColor(new Color
					    (c[0],
					     c[1],
					     c[2])
					    .brighter());
	    } else
		graphics2d.setColor(Color.getHSBColor(hsb[0],
						      hsb[1],
						      hsb[2]));
	    graphics2d.fillPolygon(is_66_, is_67_, 3);
	    chip++;
	    if (chip == 20)
		chip = 0;
	}
	rot(is, is_38_, i, i_29_, i_32_, n);
	rot(is_38_, is_37_, i_29_, i_30_, i_33_, n);
	rot(is, is_37_, i, i_30_, i_31_, n);
	if ((i_32_ != 0 || i_33_ != 0 || i_31_ != 0)
	    && (m).trk != 2) {
	    projf = 1.0F;
	    for (int i_70_ = 0; i_70_ < 3; i_70_++) {
		for (int i_71_ = 0; i_71_ < 3; i_71_++) {
		    if (i_71_ != i_70_)
			projf
			    *= (float) ((Math.sqrt
					 ((double) (((is[i_70_] - is[i_71_])
						     * (is[i_70_] - is[i_71_]))
						    + ((is_37_[i_70_]
							- is_37_[i_71_])
						       * (is_37_[i_70_]
							  - is_37_[i_71_])))))
					/ 100.0);
		}
	    }
	    projf = projf / 3.0F;
	}
	rot(is, is_37_, (m).cx,
	    (m).cz, (m).xz,
	    n);
	boolean bool_72_ = false;
	int[] is_73_ = new int[n];
	int[] is_74_ = new int[n];
	int i_75_ = 500;
	for (int i_76_ = 0; i_76_ < n; i_76_++) {
	    is_73_[i_76_] = xs(is[i_76_], is_37_[i_76_]);
	    is_74_[i_76_] = ys(is_38_[i_76_], is_37_[i_76_]);
	}
	int i_77_ = 0;
	int i_78_ = 1;
	for (int i_79_ = 0; i_79_ < n; i_79_++) {
	    for (int i_80_ = i_79_; i_80_ < n; i_80_++) {
		if (i_79_ != i_80_
		    && (Math.abs(is_73_[i_79_] - is_73_[i_80_])
			- Math.abs(is_74_[i_79_] - is_74_[i_80_])) < i_75_) {
		    i_78_ = i_79_;
		    i_77_ = i_80_;
		    i_75_ = (Math.abs(is_73_[i_79_] - is_73_[i_80_])
			     - Math.abs(is_74_[i_79_] - is_74_[i_80_]));
		}
	    }
	}
	if (is_74_[i_77_] < is_74_[i_78_]) {
	    int i_81_ = i_77_;
	    i_77_ = i_78_;
	    i_78_ = i_81_;
	}
	if (spy(is[i_77_], is_37_[i_77_]) > spy(is[i_78_], is_37_[i_78_])) {
	    bool_72_ = true;
	    int i_82_ = 0;
	    for (int i_83_ = 0; i_83_ < n; i_83_++) {
		if (is_37_[i_83_] < 50
		    && is_38_[i_83_] > (m).cy)
		    bool_72_ = false;
		else if (is_38_[i_83_] == is_38_[0])
		    i_82_++;
	    }
	    if (i_82_ == n
		&& is_38_[0] > (m).cy)
		bool_72_ = false;
	}
	rot(is_38_, is_37_, (m).cy,
	    (m).cz, (m).zy,
	    n);
	boolean bool_84_ = true;
	int[] is_85_ = new int[n];
	int[] is_86_ = new int[n];
	int i_87_ = 0;
	int i_88_ = 0;
	int i_89_ = 0;
	int i_90_ = 0;
	int i_91_ = 0;
	for (int i_92_ = 0; i_92_ < n; i_92_++) {
	    is_85_[i_92_] = xs(is[i_92_], is_37_[i_92_]);
	    is_86_[i_92_] = ys(is_38_[i_92_], is_37_[i_92_]);
	    if (is_86_[i_92_] < (m).ih
		|| is_37_[i_92_] < 10)
		i_87_++;
	    if (is_86_[i_92_] > (m).h
		|| is_37_[i_92_] < 10)
		i_88_++;
	    if (is_85_[i_92_] < (m).iw
		|| is_37_[i_92_] < 10)
		i_89_++;
	    if (is_85_[i_92_] > (m).w
		|| is_37_[i_92_] < 10)
		i_90_++;
	    if (is_37_[i_92_] < 10)
		i_91_++;
	}
	if (i_89_ == n || i_87_ == n
	    || i_88_ == n || i_90_ == n)
	    bool_84_ = false;
	if (((m).trk == 1
	     || (m).trk == 4)
	    && (i_89_ != 0 || i_87_ != 0 || i_88_ != 0 || i_90_ != 0))
	    bool_84_ = false;
	if ((m).trk == 3 && i_91_ != 0)
	    bool_84_ = false;
	if (i_91_ != 0)
	    bool = true;
	if (bool_84_ && i_36_ != -1) {
	    int i_93_ = 0;
	    int i_94_ = 0;
	    for (int i_95_ = 0; i_95_ < n; i_95_++) {
		for (int i_96_ = i_95_; i_96_ < n; i_96_++) {
		    if (i_95_ != i_96_) {
			if (Math.abs(is_85_[i_95_] - is_85_[i_96_]) > i_93_)
			    i_93_ = Math.abs(is_85_[i_95_] - is_85_[i_96_]);
			if (Math.abs(is_86_[i_95_] - is_86_[i_96_]) > i_94_)
			    i_94_ = Math.abs(is_86_[i_95_] - is_86_[i_96_]);
		    }
		}
	    }
	    if (i_93_ == 0 || i_94_ == 0)
		bool_84_ = false;
	    else if (i_93_ < 3 && i_94_ < 3
		     && (i_36_ / i_93_ > 15 && i_36_ / i_94_ > 15 || bool)
		     && (!(m).lightson
			 || light == 0))
		bool_84_ = false;
	}
	if (bool_84_) {
	    int i_97_ = 1;
	    int i_98_ = gr;
	    if (i_98_ < 0 && i_98_ >= -15)
		i_98_ = 0;
	    if (gr == -11)
		i_98_ = -90;
	    if (gr == -12)
		i_98_ = -75;
	    if (gr == -14 || gr == -15)
		i_98_ = -50;
	    if (glass == 2)
		i_98_ = 200;
	    if (fs != 0) {
		int i_101_;
		int i_102_;
		if (Math.abs(is_86_[0] - is_86_[1])
		    > Math.abs(is_86_[2] - is_86_[1])) {
		    i_101_ = 0;
		    i_102_ = 2;
		} else {
		    i_101_ = 2;
		    i_102_ = 0;
		    i_97_ *= -1;
		}
		if (is_86_[1] > is_86_[i_101_])
		    i_97_ *= -1;
		if (is_85_[1] > is_85_[i_102_])
		    i_97_ *= -1;
		if (fs != 22) {
		    i_97_ *= fs;
		    if (i_97_ == -1) {
			i_98_ += 40;
			i_97_ = -111;
		    }
		}
	    }
	    if ((m).lightson
		&& light == 2)
		i_98_ -= 40;
	    int i_103_ = is_38_[0];
	    int i_104_ = is_38_[0];
	    int i_105_ = is[0];
	    int i_106_ = is[0];
	    int i_107_ = is_37_[0];
	    int i_108_ = is_37_[0];
	    for (int i_109_ = 0; i_109_ < n; i_109_++) {
		if (is_38_[i_109_] > i_103_)
		    i_103_ = is_38_[i_109_];
		if (is_38_[i_109_] < i_104_)
		    i_104_ = is_38_[i_109_];
		if (is[i_109_] > i_105_)
		    i_105_ = is[i_109_];
		if (is[i_109_] < i_106_)
		    i_106_ = is[i_109_];
		if (is_37_[i_109_] > i_107_)
		    i_107_ = is_37_[i_109_];
		if (is_37_[i_109_] < i_108_)
		    i_108_ = is_37_[i_109_];
	    }
	    int i_110_ = (i_103_ + i_104_) / 2;
	    int i_111_ = (i_105_ + i_106_) / 2;
	    int i_112_ = (i_107_ + i_108_) / 2;
	    av
		= (int) Math.sqrt((double) ((((m).cy
					      - i_110_)
					     * ((m).cy
						- i_110_))
					    + (((m).cx
						- i_111_)
					       * (((m)
						   .cx)
						  - i_111_))
					    + i_112_ * i_112_
					    + i_98_ * i_98_ * i_98_));
	    if ((m).trk == 0
		&& (av > ((m).fade
					 [disline])
		    || av == 0))
		bool_84_ = false;
	    if (i_97_ == -111 && av > 4500
		&& !road)
		bool_84_ = false;
	    if (i_97_ == -111 && av > 1500)
		bool = true;
	    if (av > 3000
		&& (m).adv <= 900)
		bool = true;
	    if (fs == 22 && av < 11200)
		(m).lastmaf = i_97_;
	    if (gr == -13
		&& (!(m).lastcheck || i_36_ != -1))
		bool_84_ = false;
	    if (master == 2 && av > 1500
		&& !(m).crs)
		bool_84_ = false;
	    if ((gr == -14 || gr == -15
		 || gr == -12)
		&& (av > 11000 || bool_72_ || i_97_ == -111
		    || (m).resdown == 2)
		&& (m).trk != 2
		&& (m).trk != 3)
		bool_84_ = false;
	    if (gr == -11 && av > 11000
		&& (m).trk != 2
		&& (m).trk != 3)
		bool_84_ = false;
	    if (glass == 2
		&& ((m).trk != 0
		    || av > 6700))
		bool_84_ = false;
	    if (flx != 0
		&& (double) m.random() > 0.3
		&& flx != 77)
		bool_84_ = false;
	}
	if (bool_84_) {
	    float f = (float) ((double) (projf
					 / deltaf)
			       + 0.3);
	    if (bool && !solo) {
		boolean bool_113_ = false;
		if (f > 1.0F) {
		    if ((double) f >= 1.27)
			bool_113_ = true;
		    f = 1.0F;
		}
		if (bool_113_)
		    f *= 0.89;
		else
		    f *= 0.86;
		if ((double) f < 0.37)
		    f = 0.37F;
		if (gr == -9)
		    f = 0.7F;
		if (gr == -4)
		    f = 0.74F;
		if (gr != -7
		    && (m).trk == 0 && bool_72_)
		    f = 0.32F;
		if (gr == -8 || gr == -14
		    || gr == -15)
		    f = 1.0F;
		if (gr == -11 || gr == -12) {
		    f = 0.6F;
		    if (i_36_ == -1) {
			if ((m).cpflik
			    || ((m).nochekflk
				&& !(m).lastcheck))
			    f = 1.0F;
			else
			    f = 0.76F;
		    }
		}
		if (gr == -13 && i_36_ == -1) {
		    if ((m).cpflik)
			f = 0.0F;
		    else
			f = 0.76F;
		}
		if (gr == -6)
		    f = 0.62F;
		if (gr == -5)
		    f = 0.55F;
	    } else {
		if (f > 1.0F)
		    f = 1.0F;
		if ((double) f < 0.6 || bool_72_)
		    f = 0.6F;
	    }
	    Color color = Color.getHSBColor(hsb[0],
					    hsb[1],
					    hsb[2] * f);
	    if ((m).trk == 1) {
		float[] fs = new float[3];
		Color.RGBtoHSB(oc[0], oc[1],
			       oc[2], fs);
		fs[0] = 0.15F;
		fs[1] = 0.3F;
		color = Color.getHSBColor(fs[0], fs[1], fs[2] * f + 0.0F);
	    }
	    if ((m).trk == 3) {
		float[] fs = new float[3];
		Color.RGBtoHSB(oc[0], oc[1],
			       oc[2], fs);
		fs[0] = 0.6F;
		fs[1] = 0.14F;
		color = Color.getHSBColor(fs[0], fs[1], fs[2] * f + 0.0F);
	    }
	    int i_114_ = color.getRed();
	    int i_115_ = color.getGreen();
	    int i_116_ = color.getBlue();
	    if ((m).lightson
		&& (light != 0
		    || ((gr == -11 || gr == -12)
			&& i_36_ == -1))) {
		i_114_ = oc[0];
		if (i_114_ > 255)
		    i_114_ = 255;
		if (i_114_ < 0)
		    i_114_ = 0;
		i_115_ = oc[1];
		if (i_115_ > 255)
		    i_115_ = 255;
		if (i_115_ < 0)
		    i_115_ = 0;
		i_116_ = oc[2];
		if (i_116_ > 255)
		    i_116_ = 255;
		if (i_116_ < 0)
		    i_116_ = 0;
	    }
	    if ((m).trk == 0) {
		for (int i_117_ = 0; i_117_ < 16; i_117_++) {
		    if (av
			> (m).fade[i_117_]) {
			i_114_ = ((i_114_ * (m).fogd
				   + (m).cfade[0])
				  / ((m).fogd + 1));
			i_115_ = ((i_115_ * (m).fogd
				   + (m).cfade[1])
				  / ((m).fogd + 1));
			i_116_ = ((i_116_ * (m).fogd
				   + (m).cfade[2])
				  / ((m).fogd + 1));
		    }
		}
	    }
	    graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
	    graphics2d.fillPolygon(is_85_, is_86_, n);
	    if ((m).trk != 0
		&& gr == -10)
		bool = false;
	    if (!bool) {
		if (flx == 0) {
		    if (!solo) {
			i_114_ = 0;
			i_115_ = 0;
			i_116_ = 0;
			if ((m).lightson
			    && light != 0) {
			    i_114_ = oc[0] / 2;
			    if (i_114_ > 255)
				i_114_ = 255;
			    if (i_114_ < 0)
				i_114_ = 0;
			    i_115_ = oc[1] / 2;
			    if (i_115_ > 255)
				i_115_ = 255;
			    if (i_115_ < 0)
				i_115_ = 0;
			    i_116_ = oc[2] / 2;
			    if (i_116_ > 255)
				i_116_ = 255;
			    if (i_116_ < 0)
				i_116_ = 0;
			}
			if (Madness.anti == 1)
			    graphics2d.setRenderingHint((RenderingHints
							 .KEY_ANTIALIASING),
							(RenderingHints
							 .VALUE_ANTIALIAS_ON));
			graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
			graphics2d.drawPolygon(is_85_, is_86_,
					       n);
			if (Madness.anti == 1)
			    graphics2d.setRenderingHint
				(RenderingHints.KEY_ANTIALIASING,
				 RenderingHints.VALUE_ANTIALIAS_OFF);
		    }
		} else {
		    if (flx == 2) {
			graphics2d.setColor(new Color(0, 0, 0));
			graphics2d.drawPolygon(is_85_, is_86_,
					       n);
		    }
		    if (flx == 1) {
			i_114_ = 0;
			i_115_ = (int) (223.0F
					+ 223.0F * ((float) ((
							      m)
							     .snap[1])
						    / 100.0F));
			if (i_115_ > 255)
			    i_115_ = 255;
			if (i_115_ < 0)
			    i_115_ = 0;
			i_116_ = (int) (255.0F
					+ 255.0F * ((float) ((
							      m)
							     .snap[2])
						    / 100.0F));
			if (i_116_ > 255)
			    i_116_ = 255;
			if (i_116_ < 0)
			    i_116_ = 0;
			graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
			graphics2d.drawPolygon(is_85_, is_86_,
					       n);
			flx = 2;
		    }
		    if (flx == 3) {
			i_114_ = 0;
			i_115_ = (int) (255.0F
					+ 255.0F * ((float) ((
							      m)
							     .snap[1])
						    / 100.0F));
			if (i_115_ > 255)
			    i_115_ = 255;
			if (i_115_ < 0)
			    i_115_ = 0;
			i_116_ = (int) (223.0F
					+ 223.0F * ((float) ((
							      m)
							     .snap[2])
						    / 100.0F));
			if (i_116_ > 255)
			    i_116_ = 255;
			if (i_116_ < 0)
			    i_116_ = 0;
			graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
			graphics2d.drawPolygon(is_85_, is_86_,
					       n);
			flx = 2;
		    }
		    if (flx == 77) {
			graphics2d.setColor(new Color(16, 198, 255));
			graphics2d.drawPolygon(is_85_, is_86_,
					       n);
			flx = 0;
		    }
		}
	    } else if (road && av <= 3000
		       && (m).trk == 0
		       && (m).fade[0] > 4000) {
		i_114_ -= 10;
		if (i_114_ < 0)
		    i_114_ = 0;
		i_115_ -= 10;
		if (i_115_ < 0)
		    i_115_ = 0;
		i_116_ -= 10;
		if (i_116_ < 0)
		    i_116_ = 0;
		graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
		graphics2d.drawPolygon(is_85_, is_86_, n);
	    }
	    if (gr == -10) {
		if ((m).trk == 0) {
		    i_114_ = c[0];
		    i_115_ = c[1];
		    i_116_ = c[2];
		    if (i_36_ == -1 && (m).cpflik) {
			i_114_ *= 1.6;
			if (i_114_ > 255)
			    i_114_ = 255;
			i_115_ *= 1.6;
			if (i_115_ > 255)
			    i_115_ = 255;
			i_116_ *= 1.6;
			if (i_116_ > 255)
			    i_116_ = 255;
		    }
		    for (int i_118_ = 0; i_118_ < 16; i_118_++) {
			if (av
			    > (m).fade[i_118_]) {
			    i_114_
				= ((i_114_ * (m).fogd
				    + (m).cfade[0])
				   / ((m).fogd + 1));
			    i_115_
				= ((i_115_ * (m).fogd
				    + (m).cfade[1])
				   / ((m).fogd + 1));
			    i_116_
				= ((i_116_ * (m).fogd
				    + (m).cfade[2])
				   / ((m).fogd + 1));
			}
		    }
		    graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
		    graphics2d.drawPolygon(is_85_, is_86_, n);
		} else if ((m).cpflik
			   && (m).hit == 5000) {
		    i_115_ = (int) (Math.random() * 115.0);
		    i_114_ = i_115_ * 2 - 54;
		    if (i_114_ < 0)
			i_114_ = 0;
		    if (i_114_ > 255)
			i_114_ = 255;
		    i_116_ = 202 + i_115_ * 2;
		    if (i_116_ < 0)
			i_116_ = 0;
		    if (i_116_ > 255)
			i_116_ = 255;
		    i_115_ += 101;
		    if (i_115_ < 0)
			i_115_ = 0;
		    if (i_115_ > 255)
			i_115_ = 255;
		    graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
		    graphics2d.drawPolygon(is_85_, is_86_, n);
		}
	    }
	    if (gr == -18
		&& (m).trk == 0) {
		i_114_ = c[0];
		i_115_ = c[1];
		i_116_ = c[2];
		if ((m).cpflik
		    && (m).elecr >= 0.0F) {
		    i_114_ = (int) (25.5F * (m).elecr);
		    if (i_114_ > 255)
			i_114_ = 255;
		    i_115_
			= (int) (128.0F
				 + 12.8F * (m).elecr);
		    if (i_115_ > 255)
			i_115_ = 255;
		    i_116_ = 255;
		}
		for (int i_119_ = 0; i_119_ < 16; i_119_++) {
		    if (av
			> (m).fade[i_119_]) {
			i_114_ = ((i_114_ * (m).fogd
				   + (m).cfade[0])
				  / ((m).fogd + 1));
			i_115_ = ((i_115_ * (m).fogd
				   + (m).cfade[1])
				  / ((m).fogd + 1));
			i_116_ = ((i_116_ * (m).fogd
				   + (m).cfade[2])
				  / ((m).fogd + 1));
		    }
		}
		graphics2d.setColor(new Color(i_114_, i_115_, i_116_));
		graphics2d.drawPolygon(is_85_, is_86_, n);
	    }
	}
    }
    
    public void s(Graphics2D graphics2d, int i, int i_120_, int i_121_,
		  int i_122_, int i_123_, int i_124_, int i_125_) {
	int[] is = new int[n];
	int[] is_126_ = new int[n];
	int[] is_127_ = new int[n];
	for (int i_128_ = 0; i_128_ < n; i_128_++) {
	    is[i_128_] = ox[i_128_] + i;
	    is_127_[i_128_] = oy[i_128_] + i_120_;
	    is_126_[i_128_] = oz[i_128_] + i_121_;
	}
	rot(is, is_127_, i, i_120_, i_123_, n);
	rot(is_127_, is_126_, i_120_, i_121_, i_124_, n);
	rot(is, is_126_, i, i_121_, i_122_, n);
	int i_129_
	    = (int) ((double) (float) (m).crgrnd[0]
		     / 1.5);
	int i_130_
	    = (int) ((double) (float) (m).crgrnd[1]
		     / 1.5);
	int i_131_
	    = (int) ((double) (float) (m).crgrnd[2]
		     / 1.5);
	for (int i_132_ = 0; i_132_ < n; i_132_++)
	    is_127_[i_132_] = (m).ground;
	if (i_125_ == 0) {
	    int i_133_ = 0;
	    int i_134_ = 0;
	    int i_135_ = 0;
	    int i_136_ = 0;
	    for (int i_137_ = 0; i_137_ < n; i_137_++) {
		int i_138_ = 0;
		int i_139_ = 0;
		int i_140_ = 0;
		int i_141_ = 0;
		for (int i_142_ = 0; i_142_ < n; i_142_++) {
		    if (is[i_137_] >= is[i_142_])
			i_138_++;
		    if (is[i_137_] <= is[i_142_])
			i_139_++;
		    if (is_126_[i_137_] >= is_126_[i_142_])
			i_140_++;
		    if (is_126_[i_137_] <= is_126_[i_142_])
			i_141_++;
		}
		if (i_138_ == n)
		    i_133_ = is[i_137_];
		if (i_139_ == n)
		    i_134_ = is[i_137_];
		if (i_140_ == n)
		    i_135_ = is_126_[i_137_];
		if (i_141_ == n)
		    i_136_ = is_126_[i_137_];
	    }
	    int i_143_ = (i_133_ + i_134_) / 2;
	    int i_144_ = (i_135_ + i_136_) / 2;
	    int i_145_ = ((i_143_ - (t).sx
			   + (m).x)
			  / 3000);
	    if (i_145_ > (t).ncx)
		i_145_ = (t).ncx;
	    if (i_145_ < 0)
		i_145_ = 0;
	    int i_146_ = ((i_144_ - (t).sz
			   + (m).z)
			  / 3000);
	    if (i_146_ > (t).ncz)
		i_146_ = (t).ncz;
	    if (i_146_ < 0)
		i_146_ = 0;
	    for (int i_147_ = ((t).sect[i_145_]
			       [i_146_]).length - 1;
		 i_147_ >= 0; i_147_--) {
		int i_148_ = ((t).sect[i_145_]
			      [i_146_][i_147_]);
		int i_149_ = 0;
		if (Math.abs((t).zy[i_148_]) != 90
		    && Math.abs((t).xy[i_148_]) != 90
		    && (t).rady[i_148_] != 801
		    && (Math.abs(i_143_
				 - ((t).x[i_148_]
				    - (m).x))
			< (t).radx[i_148_])
		    && (Math.abs(i_144_
				 - ((t).z[i_148_]
				    - (m).z))
			< (t).radz[i_148_])
		    && (!(t).decor[i_148_]
			|| (m).resdown != 2))
		    i_149_++;
		if (i_149_ != 0) {
		    for (int i_150_ = 0; i_150_ < n; i_150_++) {
			is_127_[i_150_]
			    = ((t).y[i_148_]
			       - (m).y);
			if ((t).zy[i_148_] != 0)
			    is_127_[i_150_]
				+= (((float) (is_126_[i_150_]
					      - (((t)
						  .z[i_148_])
						 - ((m)
						    .z)
						 - ((
						     t)
						    .radz[i_148_])))
				     * m.sin((
							     t)
							    .zy[i_148_])
				     / m.sin(90
							    - ((
								(this
								 .t))
							       .zy[i_148_])))
				    - ((float) ((t)
						.radz[i_148_])
				       * m.sin((
							       (this
								.t))
							      .zy[i_148_])
				       / (m.sin
					  (90 - ((t)
						 .zy[i_148_])))));
			if ((t).xy[i_148_] != 0)
			    is_127_[i_150_]
				+= (((float) (is[i_150_]
					      - (((t)
						  .x[i_148_])
						 - ((m)
						    .x)
						 - ((
						     t)
						    .radx[i_148_])))
				     * m.sin((
							     t)
							    .xy[i_148_])
				     / m.sin(90
							    - ((
								(this
								 .t))
							       .xy[i_148_])))
				    - ((float) ((t)
						.radx[i_148_])
				       * m.sin((
							       (this
								.t))
							      .xy[i_148_])
				       / (m.sin
					  (90 - ((t)
						 .xy[i_148_])))));
		    }
		    i_129_ = (int) ((double) (float) ((
						       t)
						      .c[i_148_][0])
				    / 1.5);
		    i_130_ = (int) ((double) (float) ((
						       t)
						      .c[i_148_][1])
				    / 1.5);
		    i_131_ = (int) ((double) (float) ((
						       t)
						      .c[i_148_][2])
				    / 1.5);
		    break;
		}
	    }
	}
	boolean bool = true;
	int[] is_151_ = new int[n];
	int[] is_152_ = new int[n];
	if (i_125_ == 2) {
	    i_129_ = 87;
	    i_130_ = 85;
	    i_131_ = 57;
	} else {
	    for (int i_153_ = 0; i_153_ < (m).nsp;
		 i_153_++) {
		for (int i_154_ = 0; i_154_ < n; i_154_++) {
		    if ((Math.abs(is[i_154_]
				  - (m).spx[i_153_])
			 < (m).sprad[i_153_])
			&& (Math.abs(is_126_[i_154_]
				     - (m).spz[i_153_])
			    < (m).sprad[i_153_]))
			bool = false;
		}
	    }
	}
	if (bool) {
	    rot(is, is_126_, (m).cx,
		(m).cz, (m).xz,
		n);
	    rot(is_127_, is_126_, (m).cy,
		(m).cz, (m).zy,
		n);
	    int i_155_ = 0;
	    int i_156_ = 0;
	    int i_157_ = 0;
	    int i_158_ = 0;
	    for (int i_159_ = 0; i_159_ < n; i_159_++) {
		is_151_[i_159_] = xs(is[i_159_], is_126_[i_159_]);
		is_152_[i_159_] = ys(is_127_[i_159_], is_126_[i_159_]);
		if (is_152_[i_159_] < (m).ih
		    || is_126_[i_159_] < 10)
		    i_155_++;
		if (is_152_[i_159_] > (m).h
		    || is_126_[i_159_] < 10)
		    i_156_++;
		if (is_151_[i_159_] < (m).iw
		    || is_126_[i_159_] < 10)
		    i_157_++;
		if (is_151_[i_159_] > (m).w
		    || is_126_[i_159_] < 10)
		    i_158_++;
	    }
	    if (i_157_ == n || i_155_ == n
		|| i_156_ == n || i_158_ == n)
		bool = false;
	}
	if (bool) {
	    for (int i_160_ = 0; i_160_ < 16; i_160_++) {
		if (av
		    > (m).fade[i_160_]) {
		    i_129_ = ((i_129_ * (m).fogd
			       + (m).cfade[0])
			      / ((m).fogd + 1));
		    i_130_ = ((i_130_ * (m).fogd
			       + (m).cfade[1])
			      / ((m).fogd + 1));
		    i_131_ = ((i_131_ * (m).fogd
			       + (m).cfade[2])
			      / ((m).fogd + 1));
		}
	    }
	    graphics2d.setColor(new Color(i_129_, i_130_, i_131_));
	    graphics2d.fillPolygon(is_151_, is_152_, n);
	}
    }
    
    public int xs(int i, int i_161_) {
	if (i_161_ < (m).cz)
	    i_161_ = (m).cz;
	return (((i_161_ - (m).focus_point)
		 * ((m).cx - i) / i_161_)
		+ i);
    }
    
    public int ys(int i, int i_162_) {
	if (i_162_ < (m).cz)
	    i_162_ = (m).cz;
	return (((i_162_ - (m).focus_point)
		 * ((m).cy - i) / i_162_)
		+ i);
    }
    
    public void rot(int[] is, int[] is_163_, int i, int i_164_, int i_165_,
		    int i_166_) {
	if (i_165_ != 0) {
	    for (int i_167_ = 0; i_167_ < i_166_; i_167_++) {
		int i_168_ = is[i_167_];
		int i_169_ = is_163_[i_167_];
		is[i_167_] = i + (int) (((float) (i_168_ - i)
					 * m.cos(i_165_))
					- ((float) (i_169_ - i_164_)
					   * m.sin(i_165_)));
		is_163_[i_167_]
		    = i_164_ + (int) (((float) (i_168_ - i)
				       * m.sin(i_165_))
				      + ((float) (i_169_ - i_164_)
					 * m.cos(i_165_)));
	    }
	}
    }
    
    public int spy(int i, int i_170_) {
	return (int) Math.sqrt((double) (((i - (m).cx)
					  * (i
					     - (m).cx))
					 + i_170_ * i_170_));
    }
}
