package nfm.open;
/* nfm.open.Mad - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;

class Mad {
	boolean btab = false;
	int capcnt = 0;
	boolean capsized = false;
	private final boolean[] caught = new boolean[8];
	final CarDefine cd;
	int clear = 0;
	int cn = 0;
	int cntdest = 0;
	private int cntouch = 0;
	private boolean colidim = false;
	private final int[][] crank = new int[4][4];
	int cxz = 0;
	private int dcnt = 0;
	float dcomp = 0.0F;
	boolean dest = false;
	private final boolean[] dominate = new boolean[8];
	private final float drag = 0.5F;
	private int fixes = -1;
	private int focus = -1;
	private float forca = 0.0F;
	boolean ftab = false;
	private int fxz = 0;
	boolean gtouch = false;
	int hitmag = 0;
	int im = 0;
	int lastcolido = 0;
	float lcomp = 0.0F;
	private final int[][] lcrank = new int[4][4];
	int loop = 0;
	private int lxz = 0;
	private final Medium m;
	int missedcp = 0;
	boolean mtouch = false;
	int mxz = 0;
	private int nbsq = 0;
	boolean newcar = false;
	int newedcar = 0;
	int nlaps = 0;
	private int nmlt = 1;
	boolean nofocus = false;
	int outshakedam = 0;
	private int pan = 0;
	int pcleared = 0;
	boolean pd = false;
	boolean pl = false;
	private int pmlt = 1;
	int point = 0;
	float power = 75.0F;
	float powerup = 0.0F;
	boolean pr = false;
	boolean pu = false;
	boolean pushed = false;
	int pxy = 0;
	int pzy = 0;
	float rcomp = 0.0F;
	private final Record rpd;
	private int rpdcatch = 0;
	boolean rtab = false;
	final float[] scx = new float[4];
	final float[] scy = new float[4];
	final float[] scz = new float[4];
	int shakedam = 0;
	int skid = 0;
	float speed = 0.0F;
	int squash = 0;
	private int srfcnt = 0;
	boolean surfer = false;
	private float tilt = 0.0F;
	int travxy = 0;
	int travxz = 0;
	int travzy = 0;
	int trcnt = 0;
	int txz = 0;
	float ucomp = 0.0F;
	boolean wtouch = false;
	private final xtGraphics xt;
	private int xtpower = 0;

	public Mad(final CarDefine cardefine, final Medium medium, final Record record, final xtGraphics var_xtGraphics,
			final int i) {
		cd = cardefine;
		m = medium;
		rpd = record;
		xt = var_xtGraphics;
		im = i;
	}

	public void colide(final ContO conto, final Mad mad_118_, final ContO conto_119_) {
		final float[] fs = new float[4];
		final float[] fs_120_ = new float[4];
		final float[] fs_121_ = new float[4];
		final float[] fs_122_ = new float[4];
		final float[] fs_123_ = new float[4];
		final float[] fs_124_ = new float[4];
		for (int i = 0; i < 4; i++) {
			fs[i] = conto.x + conto.keyx[i];
			if (capsized)
				fs_120_[i] = conto.y + cd.flipy[cn] + squash;
			else
				fs_120_[i] = conto.y + conto.grat;
			fs_121_[i] = conto.z + conto.keyz[i];
			fs_122_[i] = conto_119_.x + conto_119_.keyx[i];
			if (capsized)
				fs_123_[i] = conto_119_.y + cd.flipy[mad_118_.cn] + mad_118_.squash;
			else
				fs_123_[i] = conto_119_.y + conto_119_.grat;
			fs_124_[i] = conto_119_.z + conto_119_.keyz[i];
		}
		rot(fs, fs_120_, conto.x, conto.y, conto.xy, 4);
		rot(fs_120_, fs_121_, conto.y, conto.z, conto.zy, 4);
		rot(fs, fs_121_, conto.x, conto.z, conto.xz, 4);
		rot(fs_122_, fs_123_, conto_119_.x, conto_119_.y, conto_119_.xy, 4);
		rot(fs_123_, fs_124_, conto_119_.y, conto_119_.z, conto_119_.zy, 4);
		rot(fs_122_, fs_124_, conto_119_.x, conto_119_.z, conto_119_.xz, 4);
		if (rpy(conto.x, conto_119_.x, conto.y, conto_119_.y, conto.z,
				conto_119_.z) < (conto.maxR * conto.maxR + conto_119_.maxR * conto_119_.maxR) * 1.5) {
			if (!caught[mad_118_.im] && (speed != 0.0F || mad_118_.speed != 0.0F)) {
				if (Math.abs(power * speed * cd.moment[cn]) != Math
						.abs(mad_118_.power * mad_118_.speed * cd.moment[mad_118_.cn])) {
					dominate[mad_118_.im] = Math.abs(power * speed * cd.moment[cn]) > Math
							.abs(mad_118_.power * mad_118_.speed * cd.moment[mad_118_.cn]);
				} else dominate[mad_118_.im] = cd.moment[cn] > cd.moment[mad_118_.cn];
				caught[mad_118_.im] = true;
			}
		} else if (caught[mad_118_.im])
			caught[mad_118_.im] = false;
		int i = 0;
		int i_125_ = 0;
		if (dominate[mad_118_.im]) {
			final int i_126_ = (int) (((scz[0] - mad_118_.scz[0] + scz[1] - mad_118_.scz[1] + scz[2] - mad_118_.scz[2]
					+ scz[3] - mad_118_.scz[3])
					* (scz[0] - mad_118_.scz[0] + scz[1] - mad_118_.scz[1] + scz[2] - mad_118_.scz[2] + scz[3]
							- mad_118_.scz[3])
					+ (scx[0] - mad_118_.scx[0] + scx[1] - mad_118_.scx[1] + scx[2] - mad_118_.scx[2] + scx[3]
							- mad_118_.scx[3])
							* (scx[0] - mad_118_.scx[0] + scx[1] - mad_118_.scx[1] + scx[2] - mad_118_.scx[2] + scx[3]
									- mad_118_.scx[3]))
					/ 16.0F);
			int i_127_ = 7000;
			float f = 1.0F;
			if (xt.multion != 0) {
				i_127_ = 28000;
				f = 1.27F;
			}
			for (int i_128_ = 0; i_128_ < 4; i_128_++)
				for (int i_129_ = 0; i_129_ < 4; i_129_++)
					if (rpy(fs[i_128_], fs_122_[i_129_], fs_120_[i_128_], fs_123_[i_129_], fs_121_[i_128_],
							fs_124_[i_129_]) < (i_126_ + i_127_) * (cd.comprad[mad_118_.cn] + cd.comprad[cn])) {
						if (Math.abs(scx[i_128_] * cd.moment[cn]) > Math
								.abs(mad_118_.scx[i_129_] * cd.moment[mad_118_.cn])) {
							float f_130_ = mad_118_.scx[i_129_] * cd.revpush[cn];
							if (f_130_ > 300.0F)
								f_130_ = 300.0F;
							if (f_130_ < -300.0F)
								f_130_ = -300.0F;
							float f_131_ = scx[i_128_] * cd.push[cn];
							if (f_131_ > 300.0F)
								f_131_ = 300.0F;
							if (f_131_ < -300.0F)
								f_131_ = -300.0F;
							mad_118_.scx[i_129_] += f_131_;
							if (im == xt.im)
								mad_118_.colidim = true;
							i += mad_118_.regx(i_129_, f_131_ * cd.moment[cn] * f, conto_119_);
							if (mad_118_.colidim)
								mad_118_.colidim = false;
							scx[i_128_] -= f_130_;
							i_125_ += regx(i_128_, -f_130_ * cd.moment[cn] * f, conto);
							scy[i_128_] -= cd.revlift[cn];
							if (im == xt.im)
								mad_118_.colidim = true;
							i += mad_118_.regy(i_129_, cd.revlift[cn] * 7, conto_119_);
							if (mad_118_.colidim)
								mad_118_.colidim = false;
							if (m.random() > m.random())
								conto_119_.sprk((fs[i_128_] + fs_122_[i_129_]) / 2.0F,
										(fs_120_[i_128_] + fs_123_[i_129_]) / 2.0F,
										(fs_121_[i_128_] + fs_124_[i_129_]) / 2.0F,
										(mad_118_.scx[i_129_] + scx[i_128_]) / 4.0F,
										(mad_118_.scy[i_129_] + scy[i_128_]) / 4.0F,
										(mad_118_.scz[i_129_] + scz[i_128_]) / 4.0F, 2);
						}
						if (Math.abs(scz[i_128_] * cd.moment[cn]) > Math
								.abs(mad_118_.scz[i_129_] * cd.moment[mad_118_.cn])) {
							float f_132_ = mad_118_.scz[i_129_] * cd.revpush[cn];
							if (f_132_ > 300.0F)
								f_132_ = 300.0F;
							if (f_132_ < -300.0F)
								f_132_ = -300.0F;
							float f_133_ = scz[i_128_] * cd.push[cn];
							if (f_133_ > 300.0F)
								f_133_ = 300.0F;
							if (f_133_ < -300.0F)
								f_133_ = -300.0F;
							mad_118_.scz[i_129_] += f_133_;
							if (im == xt.im)
								mad_118_.colidim = true;
							i += mad_118_.regz(i_129_, f_133_ * cd.moment[cn] * f, conto_119_);
							if (mad_118_.colidim)
								mad_118_.colidim = false;
							scz[i_128_] -= f_132_;
							i_125_ += regz(i_128_, -f_132_ * cd.moment[cn] * f, conto);
							scy[i_128_] -= cd.revlift[cn];
							if (im == xt.im)
								mad_118_.colidim = true;
							i += mad_118_.regy(i_129_, cd.revlift[cn] * 7, conto_119_);
							if (mad_118_.colidim)
								mad_118_.colidim = false;
							if (m.random() > m.random())
								conto_119_.sprk((fs[i_128_] + fs_122_[i_129_]) / 2.0F,
										(fs_120_[i_128_] + fs_123_[i_129_]) / 2.0F,
										(fs_121_[i_128_] + fs_124_[i_129_]) / 2.0F,
										(mad_118_.scx[i_129_] + scx[i_128_]) / 4.0F,
										(mad_118_.scy[i_129_] + scy[i_128_]) / 4.0F,
										(mad_118_.scz[i_129_] + scz[i_128_]) / 4.0F, 2);
						}
						if (im == xt.im)
							mad_118_.lastcolido = 70;
						if (mad_118_.im == xt.im)
							lastcolido = 70;
						mad_118_.scy[i_129_] -= cd.lift[cn];
					}
		}
		if (xt.multion == 1) {
			if (mad_118_.im == xt.im && i != 0)
				xt.dcrashes[im] += i;
			if (im == xt.im && i_125_ != 0)
				xt.dcrashes[mad_118_.im] += i_125_;
		}
	}

	private void distruct(final ContO conto) {
		for (int i = 0; i < conto.npl; i++)
			if (conto.p[i].wz == 0 || conto.p[i].gr == -17 || conto.p[i].gr == -16)
				conto.p[i].embos = 1;
	}

	public void drive(final Control control, final ContO conto, final Trackers trackers,
			final CheckPoints checkpoints) {
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
		int i_10_ = conto.grat;
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
			i_10_ = cd.flipy[cn] + squash;
		control.zyinv = bool;
		float f = 0.0F;
		float f_11_ = 0.0F;
		float f_12_ = 0.0F;
		if (mtouch)
			loop = 0;
		if (wtouch) {
			if (loop == 2 || loop == -1) {
				loop = -1;
				if (control.left)
					pl = true;
				if (control.right)
					pr = true;
				if (control.up)
					pu = true;
				if (control.down)
					pd = true;
			}
			ucomp = 0.0F;
			dcomp = 0.0F;
			lcomp = 0.0F;
			rcomp = 0.0F;
		}
		if (control.handb) {
			if (!pushed)
				if (!wtouch) {
					if (loop == 0)
						loop = 1;
				} else if (gtouch)
					pushed = true;
		} else
			pushed = false;
		if (loop == 1) {
			final float f_13_ = (scy[0] + scy[1] + scy[2] + scy[3]) / 4.0F;
			for (int i_14_ = 0; i_14_ < 4; i_14_++)
				scy[i_14_] = f_13_;
			loop = 2;
		}
		if (!dest)
			if (loop == 2) {
				if (control.up) {
					if (ucomp == 0.0F) {
						ucomp = 10.0F + (scy[0] + 50.0F) / 20.0F;
						if (ucomp < 5.0F)
							ucomp = 5.0F;
						if (ucomp > 10.0F)
							ucomp = 10.0F;
						ucomp *= cd.airs[cn];
					}
					if (ucomp < 20.0F)
						ucomp += 0.5 * cd.airs[cn];
					f = -cd.airc[cn] * m.sin(conto.xz) * i_4_;
					f_11_ = cd.airc[cn] * m.cos(conto.xz) * i_4_;
				} else if (ucomp != 0.0F && ucomp > -2.0F)
					ucomp -= 0.5 * cd.airs[cn];
				if (control.down) {
					if (dcomp == 0.0F) {
						dcomp = 10.0F + (scy[0] + 50.0F) / 20.0F;
						if (dcomp < 5.0F)
							dcomp = 5.0F;
						if (dcomp > 10.0F)
							dcomp = 10.0F;
						dcomp *= cd.airs[cn];
					}
					if (dcomp < 20.0F)
						dcomp += 0.5 * cd.airs[cn];
					f_12_ = -cd.airc[cn];
				} else if (dcomp != 0.0F && ucomp > -2.0F)
					dcomp -= 0.5 * cd.airs[cn];
				if (control.left) {
					if (lcomp == 0.0F)
						lcomp = 5.0F;
					if (lcomp < 20.0F)
						lcomp += 2.0F * cd.airs[cn];
					f = -cd.airc[cn] * m.cos(conto.xz) * i;
					f_11_ = -cd.airc[cn] * m.sin(conto.xz) * i;
				} else if (lcomp > 0.0F)
					lcomp -= 2.0F * cd.airs[cn];
				if (control.right) {
					if (rcomp == 0.0F)
						rcomp = 5.0F;
					if (rcomp < 20.0F)
						rcomp += 2.0F * cd.airs[cn];
					f = cd.airc[cn] * m.cos(conto.xz) * i;
					f_11_ = cd.airc[cn] * m.sin(conto.xz) * i;
				} else if (rcomp > 0.0F)
					rcomp -= 2.0F * cd.airs[cn];
				pzy += (dcomp - ucomp) * m.cos(pxy);
				if (bool)
					conto.xz += (dcomp - ucomp) * m.sin(pxy);
				else
					conto.xz -= (dcomp - ucomp) * m.sin(pxy);
				pxy += rcomp - lcomp;
			} else {
				float f_15_ = power;
				if (f_15_ < 40.0F)
					f_15_ = 40.0F;
				if (control.down)
					if (speed > 0.0F)
						speed -= cd.handb[cn] / 2;
					else {
						int i_16_ = 0;
						for (int i_17_ = 0; i_17_ < 2; i_17_++)
							if (speed <= -(cd.swits[cn][i_17_] / 2 + f_15_ * cd.swits[cn][i_17_] / 196.0F))
								i_16_++;
						if (i_16_ != 2)
							speed -= cd.acelf[cn][i_16_] / 2.0F + f_15_ * cd.acelf[cn][i_16_] / 196.0F;
						else
							speed = -(cd.swits[cn][1] / 2 + f_15_ * cd.swits[cn][1] / 196.0F);
					}
				if (control.up)
					if (speed < 0.0F)
						speed += cd.handb[cn];
					else {
						int i_18_ = 0;
						for (int i_19_ = 0; i_19_ < 3; i_19_++)
							if (speed >= cd.swits[cn][i_19_] / 2 + f_15_ * cd.swits[cn][i_19_] / 196.0F)
								i_18_++;
						if (i_18_ != 3)
							speed += cd.acelf[cn][i_18_] / 2.0F + f_15_ * cd.acelf[cn][i_18_] / 196.0F;
						else
							speed = cd.swits[cn][2] / 2 + f_15_ * cd.swits[cn][2] / 196.0F;
					}
				if (control.handb && Math.abs(speed) > cd.handb[cn])
					if (speed < 0.0F)
						speed += cd.handb[cn];
					else
						speed -= cd.handb[cn];
				if (loop == -1 && conto.y < 100) {
					if (control.left) {
						if (!pl) {
							if (lcomp == 0.0F)
								lcomp = 5.0F * cd.airs[cn];
							if (lcomp < 20.0F)
								lcomp += 2.0F * cd.airs[cn];
						}
					} else {
						if (lcomp > 0.0F)
							lcomp -= 2.0F * cd.airs[cn];
						pl = false;
					}
					if (control.right) {
						if (!pr) {
							if (rcomp == 0.0F)
								rcomp = 5.0F * cd.airs[cn];
							if (rcomp < 20.0F)
								rcomp += 2.0F * cd.airs[cn];
						}
					} else {
						if (rcomp > 0.0F)
							rcomp -= 2.0F * cd.airs[cn];
						pr = false;
					}
					if (control.up) {
						if (!pu) {
							if (ucomp == 0.0F)
								ucomp = 5.0F * cd.airs[cn];
							if (ucomp < 20.0F)
								ucomp += 2.0F * cd.airs[cn];
						}
					} else {
						if (ucomp > 0.0F)
							ucomp -= 2.0F * cd.airs[cn];
						pu = false;
					}
					if (control.down) {
						if (!pd) {
							if (dcomp == 0.0F)
								dcomp = 5.0F * cd.airs[cn];
							if (dcomp < 20.0F)
								dcomp += 2.0F * cd.airs[cn];
						}
					} else {
						if (dcomp > 0.0F)
							dcomp -= 2.0F * cd.airs[cn];
						pd = false;
					}
					pzy += (dcomp - ucomp) * m.cos(pxy);
					if (bool)
						conto.xz += (dcomp - ucomp) * m.sin(pxy);
					else
						conto.xz -= (dcomp - ucomp) * m.sin(pxy);
					pxy += rcomp - lcomp;
				}
			}
		float f_20_ = 20.0F * speed / (154.0F * cd.simag[cn]);
		if (f_20_ > 20.0F)
			f_20_ = 20.0F;
		conto.wzy -= f_20_;
		if (conto.wzy < -30)
			conto.wzy += 30;
		if (conto.wzy > 30)
			conto.wzy -= 30;
		if (control.right) {
			conto.wxz -= cd.turn[cn];
			if (conto.wxz < -36)
				conto.wxz = -36;
		}
		if (control.left) {
			conto.wxz += cd.turn[cn];
			if (conto.wxz > 36)
				conto.wxz = 36;
		}
		if (conto.wxz != 0 && !control.left && !control.right)
			if (Math.abs(speed) < 10.0F) {
				if (Math.abs(conto.wxz) == 1)
					conto.wxz = 0;
				if (conto.wxz > 0)
					conto.wxz--;
				if (conto.wxz < 0)
					conto.wxz++;
			} else {
				if (Math.abs(conto.wxz) < cd.turn[cn] * 2)
					conto.wxz = 0;
				if (conto.wxz > 0)
					conto.wxz -= cd.turn[cn] * 2;
				if (conto.wxz < 0)
					conto.wxz += cd.turn[cn] * 2;
			}
		int i_21_ = (int) (3600.0F / (speed * speed));
		if (i_21_ < 5)
			i_21_ = 5;
		if (speed < 0.0F)
			i_21_ = -i_21_;
		if (wtouch) {
			if (!capsized) {
				if (!control.handb)
					fxz = conto.wxz / (i_21_ * 3);
				else
					fxz = conto.wxz / i_21_;
				conto.xz += conto.wxz / i_21_;
			}
			wtouch = false;
			gtouch = false;
		} else
			conto.xz += fxz;
		if (speed > 30.0F || speed < -100.0F) {
			while (Math.abs(mxz - cxz) > 180)
				if (cxz > mxz)
					cxz -= 360;
				else if (cxz < mxz)
					cxz += 360;
			if (Math.abs(mxz - cxz) < 30)
				cxz += (mxz - cxz) / 4.0F;
			else {
				if (cxz > mxz)
					cxz -= 10;
				if (cxz < mxz)
					cxz += 10;
			}
		}
		final float[] fs = new float[4];
		final float[] fs_22_ = new float[4];
		final float[] fs_23_ = new float[4];
		for (int i_24_ = 0; i_24_ < 4; i_24_++) {
			fs[i_24_] = conto.keyx[i_24_] + conto.x;
			fs_23_[i_24_] = i_10_ + conto.y;
			fs_22_[i_24_] = conto.z + conto.keyz[i_24_];
			scy[i_24_] += 7.0F;
		}
		rot(fs, fs_23_, conto.x, conto.y, pxy, 4);
		rot(fs_23_, fs_22_, conto.y, conto.z, pzy, 4);
		rot(fs, fs_22_, conto.x, conto.z, conto.xz, 4);
		boolean bool_25_ = false;
		double d;
		final int i_26_ = (int) ((scx[0] + scx[1] + scx[2] + scx[3]) / 4.0F);
		final int i_27_ = (int) ((scz[0] + scz[1] + scz[2] + scz[3]) / 4.0F);
		for (int i_28_ = 0; i_28_ < 4; i_28_++) {
			if (scx[i_28_] - i_26_ > 200.0F)
				scx[i_28_] = 200 + i_26_;
			if (scx[i_28_] - i_26_ < -200.0F)
				scx[i_28_] = i_26_ - 200;
			if (scz[i_28_] - i_27_ > 200.0F)
				scz[i_28_] = 200 + i_27_;
			if (scz[i_28_] - i_27_ < -200.0F)
				scz[i_28_] = i_27_ - 200;
		}
		for (int i_29_ = 0; i_29_ < 4; i_29_++) {
			fs_23_[i_29_] += scy[i_29_];
			fs[i_29_] += (scx[0] + scx[1] + scx[2] + scx[3]) / 4.0F;
			fs_22_[i_29_] += (scz[0] + scz[1] + scz[2] + scz[3]) / 4.0F;
		}
		int i_30_ = (conto.x - trackers.sx) / 3000;
		if (i_30_ > trackers.ncx)
			i_30_ = trackers.ncx;
		if (i_30_ < 0)
			i_30_ = 0;
		int i_31_ = (conto.z - trackers.sz) / 3000;
		if (i_31_ > trackers.ncz)
			i_31_ = trackers.ncz;
		if (i_31_ < 0)
			i_31_ = 0;
		int i_32_ = 1;
		for (int i_33_ = 0; i_33_ < trackers.sect[i_30_][i_31_].length; i_33_++) {
			final int i_34_ = trackers.sect[i_30_][i_31_][i_33_];
			if (Math.abs(trackers.zy[i_34_]) != 90 && Math.abs(trackers.xy[i_34_]) != 90
					&& Math.abs(conto.x - trackers.x[i_34_]) < trackers.radx[i_34_]
					&& Math.abs(conto.z - trackers.z[i_34_]) < trackers.radz[i_34_]
					&& (!trackers.decor[i_34_] || m.resdown != 2 || xt.multion != 0))
				i_32_ = trackers.skd[i_34_];
		}
		if (mtouch) {
			float f_35_ = cd.grip[cn];
			f_35_ -= Math.abs(txz - conto.xz) * speed / 250.0F;
			if (control.handb)
				f_35_ -= Math.abs(txz - conto.xz) * 4;
			if (f_35_ < cd.grip[cn]) {
				if (skid != 2)
					skid = 1;
				speed -= speed / 100.0F;
			} else if (skid == 1)
				skid = 2;
			if (i_32_ == 1)
				f_35_ *= 0.75;
			if (i_32_ == 2)
				f_35_ *= 0.55;
			int i_36_ = -(int) (speed * m.sin(conto.xz) * m.cos(pzy));
			int i_37_ = (int) (speed * m.cos(conto.xz) * m.cos(pzy));
			int i_38_ = -(int) (speed * m.sin(pzy));
			if (capsized || dest || checkpoints.haltall) {
				i_36_ = 0;
				i_37_ = 0;
				i_38_ = 0;
				f_35_ = cd.grip[cn] / 5.0F;
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
				if (Math.abs(scx[i_41_] - i_36_) > f_35_) {
					if (scx[i_41_] < i_36_)
						scx[i_41_] += f_35_;
					else
						scx[i_41_] -= f_35_;
				} else
					scx[i_41_] = i_36_;
				if (Math.abs(scz[i_41_] - i_37_) > f_35_) {
					if (scz[i_41_] < i_37_)
						scz[i_41_] += f_35_;
					else
						scz[i_41_] -= f_35_;
				} else
					scz[i_41_] = i_37_;
				if (Math.abs(scy[i_41_] - i_38_) > f_35_) {
					if (scy[i_41_] < i_38_)
						scy[i_41_] += f_35_;
					else
						scy[i_41_] -= f_35_;
				} else
					scy[i_41_] = i_38_;
				if (f_35_ < cd.grip[cn]) {
					if (txz != conto.xz)
						dcnt++;
					else if (dcnt != 0)
						dcnt = 0;
					if (dcnt > 40.0F * f_35_ / cd.grip[cn] || capsized) {
						float f_42_ = 1.0F;
						if (i_32_ != 0)
							f_42_ = 1.2F;
						if (m.random() > 0.65) {
							conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) scx[i_41_],
									(int) scz[i_41_], f_42_ * cd.simag[cn], (int) tilt, capsized && mtouch);
							if (im == xt.im && !capsized)
								xt.skid(i_32_, (float) Math.sqrt(scx[i_41_] * scx[i_41_] + scz[i_41_] * scz[i_41_]));
						}
					} else {
						if (i_32_ == 1 && m.random() > 0.8)
							conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) scx[i_41_],
									(int) scz[i_41_], 1.1F * cd.simag[cn], (int) tilt, capsized && mtouch);
						if ((i_32_ == 2 || i_32_ == 3) && m.random() > 0.6)
							conto.dust(i_41_, fs[i_41_], fs_23_[i_41_], fs_22_[i_41_], (int) scx[i_41_],
									(int) scz[i_41_], 1.15F * cd.simag[cn], (int) tilt, capsized && mtouch);
					}
				} else if (dcnt != 0) {
					dcnt -= 2;
					if (dcnt < 0)
						dcnt = 0;
				}
				if (i_32_ == 3) {
					final int i_43_ = (int) (m.random() * 4.0F);
					scy[i_43_] = (float) (-100.0F * m.random() * (speed / cd.swits[cn][2]) * (cd.bounce[cn] - 0.3));
				}
				if (i_32_ == 4) {
					final int i_44_ = (int) (m.random() * 4.0F);
					scy[i_44_] = (float) (-150.0F * m.random() * (speed / cd.swits[cn][2]) * (cd.bounce[cn] - 0.3));
				}
				f_39_ += scx[i_41_];
				f_40_ += scz[i_41_];
			}
			txz = conto.xz;
			if (f_39_ > 0.0F)
				i = -1;
			else
				i = 1;
			d = f_40_ / Math.sqrt(f_39_ * f_39_ + f_40_ * f_40_);
			mxz = (int) (Math.acos(d) / 0.017453292519943295 * i);
			if (skid == 2) {
				if (!capsized) {
					f_39_ /= 4.0F;
					f_40_ /= 4.0F;
					if (bool_5_)
						speed = -((float) Math.sqrt(f_39_ * f_39_ + f_40_ * f_40_) * m.cos(mxz - conto.xz));
					else
						speed = (float) Math.sqrt(f_39_ * f_39_ + f_40_ * f_40_) * m.cos(mxz - conto.xz);
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
		final boolean[] bools = new boolean[4];
		final boolean[] bools_46_ = new boolean[4];
		final boolean[] bools_47_ = new boolean[4];
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
					if (f_50_ > 0.3)
						f_50_ = 0.3F;
					if (i_32_ == 0)
						f_50_ += 1.1;
					else
						f_50_ += 1.2;
					conto.dust(i_49_, fs[i_49_], fs_23_[i_49_], fs_22_[i_49_], (int) scx[i_49_], (int) scz[i_49_],
							f_50_ * cd.simag[cn], 0, capsized && mtouch);
				}
				fs_23_[i_49_] = 250.0F;
				bools_47_[i_49_] = true;
				f_48_ += fs_23_[i_49_] - 250.0F;
				float f_51_ = Math.abs(m.sin(pxy)) + Math.abs(m.sin(pzy));
				f_51_ /= 3.0F;
				if (f_51_ > 0.4)
					f_51_ = 0.4F;
				f_51_ += cd.bounce[cn];
				if (f_51_ < 1.1)
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
			f_48_ /= i_45_;
			for (int i_52_ = 0; i_52_ < 4; i_52_++)
				if (!bools_47_[i_52_])
					fs_23_[i_52_] -= f_48_;
		}
		int i_53_ = 0;
		for (int i_54_ = 0; i_54_ < trackers.sect[i_30_][i_31_].length; i_54_++) {
			final int i_55_ = trackers.sect[i_30_][i_31_][i_54_];
			int i_56_ = 0;
			int i_57_ = 0;
			for (int i_58_ = 0; i_58_ < 4; i_58_++) {
				if (bools_46_[i_58_] && (trackers.skd[i_55_] == 0 || trackers.skd[i_55_] == 1)
						&& fs[i_58_] > trackers.x[i_55_] - trackers.radx[i_55_]
						&& fs[i_58_] < trackers.x[i_55_] + trackers.radx[i_55_]
						&& fs_22_[i_58_] > trackers.z[i_55_] - trackers.radz[i_55_]
						&& fs_22_[i_58_] < trackers.z[i_55_] + trackers.radz[i_55_]) {
					conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 1);
					if (im == xt.im)
						xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
				}
				if (!bools[i_58_] && fs[i_58_] > trackers.x[i_55_] - trackers.radx[i_55_]
						&& fs[i_58_] < trackers.x[i_55_] + trackers.radx[i_55_]
						&& fs_22_[i_58_] > trackers.z[i_55_] - trackers.radz[i_55_]
						&& fs_22_[i_58_] < trackers.z[i_55_] + trackers.radz[i_55_]
						&& fs_23_[i_58_] > trackers.y[i_55_] - trackers.rady[i_55_]
						&& fs_23_[i_58_] < trackers.y[i_55_] + trackers.rady[i_55_]
						&& (!trackers.decor[i_55_] || m.resdown != 2 || xt.multion != 0)) {
					if (trackers.xy[i_55_] == 0 && trackers.zy[i_55_] == 0 && trackers.y[i_55_] != 250
							&& fs_23_[i_58_] > trackers.y[i_55_] - 5) {
						i_57_++;
						wtouch = true;
						gtouch = true;
						if (!bool_25_ && scy[i_58_] != 7.0F) {
							float f_59_ = scy[i_58_] / 333.33F;
							if (f_59_ > 0.3)
								f_59_ = 0.3F;
							if (i_32_ == 0)
								f_59_ += 1.1;
							else
								f_59_ += 1.2;
							conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) scx[i_58_],
									(int) scz[i_58_], f_59_ * cd.simag[cn], 0, capsized && mtouch);
						}
						fs_23_[i_58_] = trackers.y[i_55_];
						if (capsized && (trackers.skd[i_55_] == 0 || trackers.skd[i_55_] == 1)) {
							conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 1);
							if (im == xt.im)
								xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
						}
						float f_60_ = Math.abs(m.sin(pxy)) + Math.abs(m.sin(pzy));
						f_60_ /= 3.0F;
						if (f_60_ > 0.4)
							f_60_ = 0.4F;
						f_60_ += cd.bounce[cn];
						if (f_60_ < 1.1)
							f_60_ = 1.1F;
						regy(i_58_, Math.abs(scy[i_58_] * f_60_), conto);
						if (scy[i_58_] > 0.0F)
							scy[i_58_] -= Math.abs(scy[i_58_] * f_60_);
						bools[i_58_] = true;
					}
					if (trackers.zy[i_55_] == -90 && fs_22_[i_58_] < trackers.z[i_55_] + trackers.radz[i_55_]
							&& (scz[i_58_] < 0.0F || trackers.radz[i_55_] == 287)) {
						for (int i_61_ = 0; i_61_ < 4; i_61_++)
							if (i_58_ != i_61_ && fs_22_[i_61_] >= trackers.z[i_55_] + trackers.radz[i_55_])
								fs_22_[i_61_] -= fs_22_[i_58_] - (trackers.z[i_55_] + trackers.radz[i_55_]);
						fs_22_[i_58_] = trackers.z[i_55_] + trackers.radz[i_55_];
						if (trackers.skd[i_55_] != 2)
							crank[0][i_58_]++;
						if (trackers.skd[i_55_] == 5 && m.random() > m.random())
							crank[0][i_58_]++;
						if (crank[0][i_58_] > 1) {
							conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
							if (im == xt.im)
								xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
						}
						float f_62_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
						f_62_ /= 4.0F;
						if (f_62_ > 0.3)
							f_62_ = 0.3F;
						if (bool_25_)
							f_62_ = 0.0F;
						f_62_ += cd.bounce[cn] - 0.2;
						if (f_62_ < 1.1)
							f_62_ = 1.1F;
						regz(i_58_, Math.abs(scz[i_58_] * f_62_ * trackers.dam[i_55_]), conto);
						scz[i_58_] += Math.abs(scz[i_58_] * f_62_);
						skid = 2;
						bool_6_ = true;
						bools[i_58_] = true;
						if (!trackers.notwall[i_55_])
							control.wall = i_55_;
					}
					if (trackers.zy[i_55_] == 90 && fs_22_[i_58_] > trackers.z[i_55_] - trackers.radz[i_55_]
							&& (scz[i_58_] > 0.0F || trackers.radz[i_55_] == 287)) {
						for (int i_63_ = 0; i_63_ < 4; i_63_++)
							if (i_58_ != i_63_ && fs_22_[i_63_] <= trackers.z[i_55_] - trackers.radz[i_55_])
								fs_22_[i_63_] -= fs_22_[i_58_] - (trackers.z[i_55_] - trackers.radz[i_55_]);
						fs_22_[i_58_] = trackers.z[i_55_] - trackers.radz[i_55_];
						if (trackers.skd[i_55_] != 2)
							crank[1][i_58_]++;
						if (trackers.skd[i_55_] == 5 && m.random() > m.random())
							crank[1][i_58_]++;
						if (crank[1][i_58_] > 1) {
							conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
							if (im == xt.im)
								xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
						}
						float f_64_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
						f_64_ /= 4.0F;
						if (f_64_ > 0.3)
							f_64_ = 0.3F;
						if (bool_25_)
							f_64_ = 0.0F;
						f_64_ += cd.bounce[cn] - 0.2;
						if (f_64_ < 1.1)
							f_64_ = 1.1F;
						regz(i_58_, -Math.abs(scz[i_58_] * f_64_ * trackers.dam[i_55_]), conto);
						scz[i_58_] -= Math.abs(scz[i_58_] * f_64_);
						skid = 2;
						bool_6_ = true;
						bools[i_58_] = true;
						if (!trackers.notwall[i_55_])
							control.wall = i_55_;
					}
					if (trackers.xy[i_55_] == -90 && fs[i_58_] < trackers.x[i_55_] + trackers.radx[i_55_]
							&& (scx[i_58_] < 0.0F || trackers.radx[i_55_] == 287)) {
						for (int i_65_ = 0; i_65_ < 4; i_65_++)
							if (i_58_ != i_65_ && fs[i_65_] >= trackers.x[i_55_] + trackers.radx[i_55_])
								fs[i_65_] -= fs[i_58_] - (trackers.x[i_55_] + trackers.radx[i_55_]);
						fs[i_58_] = trackers.x[i_55_] + trackers.radx[i_55_];
						if (trackers.skd[i_55_] != 2)
							crank[2][i_58_]++;
						if (trackers.skd[i_55_] == 5 && m.random() > m.random())
							crank[2][i_58_]++;
						if (crank[2][i_58_] > 1) {
							conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
							if (im == xt.im)
								xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
						}
						float f_66_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
						f_66_ /= 4.0F;
						if (f_66_ > 0.3)
							f_66_ = 0.3F;
						if (bool_25_)
							f_66_ = 0.0F;
						f_66_ += cd.bounce[cn] - 0.2;
						if (f_66_ < 1.1)
							f_66_ = 1.1F;
						regx(i_58_, Math.abs(scx[i_58_] * f_66_ * trackers.dam[i_55_]), conto);
						scx[i_58_] += Math.abs(scx[i_58_] * f_66_);
						skid = 2;
						bool_6_ = true;
						bools[i_58_] = true;
						if (!trackers.notwall[i_55_])
							control.wall = i_55_;
					}
					if (trackers.xy[i_55_] == 90 && fs[i_58_] > trackers.x[i_55_] - trackers.radx[i_55_]
							&& (scx[i_58_] > 0.0F || trackers.radx[i_55_] == 287)) {
						for (int i_67_ = 0; i_67_ < 4; i_67_++)
							if (i_58_ != i_67_ && fs[i_67_] <= trackers.x[i_55_] - trackers.radx[i_55_])
								fs[i_67_] -= fs[i_58_] - (trackers.x[i_55_] - trackers.radx[i_55_]);
						fs[i_58_] = trackers.x[i_55_] - trackers.radx[i_55_];
						if (trackers.skd[i_55_] != 2)
							crank[3][i_58_]++;
						if (trackers.skd[i_55_] == 5 && m.random() > m.random())
							crank[3][i_58_]++;
						if (crank[3][i_58_] > 1) {
							conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_], 0);
							if (im == xt.im)
								xt.scrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
						}
						float f_68_ = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
						f_68_ /= 4.0F;
						if (f_68_ > 0.3)
							f_68_ = 0.3F;
						if (bool_25_)
							f_68_ = 0.0F;
						f_68_ += cd.bounce[cn] - 0.2;
						if (f_68_ < 1.1)
							f_68_ = 1.1F;
						regx(i_58_, -Math.abs(scx[i_58_] * f_68_ * trackers.dam[i_55_]), conto);
						scx[i_58_] -= Math.abs(scx[i_58_] * f_68_);
						skid = 2;
						bool_6_ = true;
						bools[i_58_] = true;
						if (!trackers.notwall[i_55_])
							control.wall = i_55_;
					}
					if (trackers.zy[i_55_] != 0 && trackers.zy[i_55_] != 90 && trackers.zy[i_55_] != -90) {
						final int i_69_ = 90 + trackers.zy[i_55_];
						float f_70_ = 1.0F + (50 - Math.abs(trackers.zy[i_55_])) / 30.0F;
						if (f_70_ < 1.0F)
							f_70_ = 1.0F;
						final float f_71_ = trackers.y[i_55_] + ((fs_23_[i_58_] - trackers.y[i_55_]) * m.cos(i_69_)
								- (fs_22_[i_58_] - trackers.z[i_55_]) * m.sin(i_69_));
						float f_72_ = trackers.z[i_55_] + ((fs_23_[i_58_] - trackers.y[i_55_]) * m.sin(i_69_)
								+ (fs_22_[i_58_] - trackers.z[i_55_]) * m.cos(i_69_));
						if (f_72_ > trackers.z[i_55_] && f_72_ < trackers.z[i_55_] + 200) {
							scy[i_58_] -= (f_72_ - trackers.z[i_55_]) / f_70_;
							f_72_ = trackers.z[i_55_];
						}
						if (f_72_ > trackers.z[i_55_] - 30) {
							if (trackers.skd[i_55_] == 2)
								i_56_++;
							else
								i_53_++;
							wtouch = true;
							gtouch = false;
							if (capsized && (trackers.skd[i_55_] == 0 || trackers.skd[i_55_] == 1)) {
								conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_],
										1);
								if (im == xt.im)
									xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
							}
							if (!bool_25_ && i_32_ != 0) {
								final float f_73_ = 1.4F;
								conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) scx[i_58_],
										(int) scz[i_58_], f_73_ * cd.simag[cn], 0, capsized && mtouch);
							}
						}
						fs_23_[i_58_] = trackers.y[i_55_] + ((f_71_ - trackers.y[i_55_]) * m.cos(-i_69_)
								- (f_72_ - trackers.z[i_55_]) * m.sin(-i_69_));
						fs_22_[i_58_] = trackers.z[i_55_] + ((f_71_ - trackers.y[i_55_]) * m.sin(-i_69_)
								+ (f_72_ - trackers.z[i_55_]) * m.cos(-i_69_));
						bools[i_58_] = true;
					}
					if (trackers.xy[i_55_] != 0 && trackers.xy[i_55_] != 90 && trackers.xy[i_55_] != -90) {
						final int i_74_ = 90 + trackers.xy[i_55_];
						float f_75_ = 1.0F + (50 - Math.abs(trackers.xy[i_55_])) / 30.0F;
						if (f_75_ < 1.0F)
							f_75_ = 1.0F;
						final float f_76_ = trackers.y[i_55_] + ((fs_23_[i_58_] - trackers.y[i_55_]) * m.cos(i_74_)
								- (fs[i_58_] - trackers.x[i_55_]) * m.sin(i_74_));
						float f_77_ = trackers.x[i_55_] + ((fs_23_[i_58_] - trackers.y[i_55_]) * m.sin(i_74_)
								+ (fs[i_58_] - trackers.x[i_55_]) * m.cos(i_74_));
						if (f_77_ > trackers.x[i_55_] && f_77_ < trackers.x[i_55_] + 200) {
							scy[i_58_] -= (f_77_ - trackers.x[i_55_]) / f_75_;
							f_77_ = trackers.x[i_55_];
						}
						if (f_77_ > trackers.x[i_55_] - 30) {
							if (trackers.skd[i_55_] == 2)
								i_56_++;
							else
								i_53_++;
							wtouch = true;
							gtouch = false;
							if (capsized && (trackers.skd[i_55_] == 0 || trackers.skd[i_55_] == 1)) {
								conto.sprk(fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], scx[i_58_], scy[i_58_], scz[i_58_],
										1);
								if (im == xt.im)
									xt.gscrape((int) scx[i_58_], (int) scy[i_58_], (int) scz[i_58_]);
							}
							if (!bool_25_ && i_32_ != 0) {
								final float f_78_ = 1.4F;
								conto.dust(i_58_, fs[i_58_], fs_23_[i_58_], fs_22_[i_58_], (int) scx[i_58_],
										(int) scz[i_58_], f_78_ * cd.simag[cn], 0, capsized && mtouch);
							}
						}
						fs_23_[i_58_] = trackers.y[i_55_] + ((f_76_ - trackers.y[i_55_]) * m.cos(-i_74_)
								- (f_77_ - trackers.x[i_55_]) * m.sin(-i_74_));
						fs[i_58_] = trackers.x[i_55_] + ((f_76_ - trackers.y[i_55_]) * m.sin(-i_74_)
								+ (f_77_ - trackers.x[i_55_]) * m.cos(-i_74_));
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
		for (int i_79_ = 0; i_79_ < 4; i_79_++)
			for (int i_80_ = 0; i_80_ < 4; i_80_++) {
				if (crank[i_79_][i_80_] == lcrank[i_79_][i_80_])
					crank[i_79_][i_80_] = 0;
				lcrank[i_79_][i_80_] = crank[i_79_][i_80_];
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
			d = Math.sqrt((fs_22_[0] - fs_22_[2]) * (fs_22_[0] - fs_22_[2])
					+ (fs_23_[0] - fs_23_[2]) * (fs_23_[0] - fs_23_[2]) + (fs[0] - fs[2]) * (fs[0] - fs[2]))
					/ (Math.abs(conto.keyz[0]) + Math.abs(conto.keyz[2]));
			if (d >= 0.9998)
				i_81_ = i;
			else
				i_81_ = (int) (Math.acos(d) / 0.017453292519943295 * i);
		}
		if (scy[3] != scy[1]) {
			if (scy[3] < scy[1])
				i = -1;
			else
				i = 1;
			d = Math.sqrt((fs_22_[1] - fs_22_[3]) * (fs_22_[1] - fs_22_[3])
					+ (fs_23_[1] - fs_23_[3]) * (fs_23_[1] - fs_23_[3]) + (fs[1] - fs[3]) * (fs[1] - fs[3]))
					/ (Math.abs(conto.keyz[1]) + Math.abs(conto.keyz[3]));
			if (d >= 0.9998)
				i_82_ = i;
			else
				i_82_ = (int) (Math.acos(d) / 0.017453292519943295 * i);
		}
		if (scy[1] != scy[0]) {
			if (scy[1] < scy[0])
				i = -1;
			else
				i = 1;
			d = Math.sqrt((fs_22_[0] - fs_22_[1]) * (fs_22_[0] - fs_22_[1])
					+ (fs_23_[0] - fs_23_[1]) * (fs_23_[0] - fs_23_[1]) + (fs[0] - fs[1]) * (fs[0] - fs[1]))
					/ (Math.abs(conto.keyx[0]) + Math.abs(conto.keyx[1]));
			if (d >= 0.9998)
				i_83_ = i;
			else
				i_83_ = (int) (Math.acos(d) / 0.017453292519943295 * i);
		}
		if (scy[3] != scy[2]) {
			if (scy[3] < scy[2])
				i = -1;
			else
				i = 1;
			d = Math.sqrt((fs_22_[2] - fs_22_[3]) * (fs_22_[2] - fs_22_[3])
					+ (fs_23_[2] - fs_23_[3]) * (fs_23_[2] - fs_23_[3]) + (fs[2] - fs[3]) * (fs[2] - fs[3]))
					/ (Math.abs(conto.keyx[2]) + Math.abs(conto.keyx[3]));
			if (d >= 0.9998)
				i_84_ = i;
			else
				i_84_ = (int) (Math.acos(d) / 0.017453292519943295 * i);
		}
		if (bool_6_) {
			int i_85_;
			for (i_85_ = Math.abs(conto.xz + 45); i_85_ > 180; i_85_ -= 360) {
				/* empty */
			}
			if (Math.abs(i_85_) > 90)
				pmlt = 1;
			else
				pmlt = -1;
			for (i_85_ = Math.abs(conto.xz - 45); i_85_ > 180; i_85_ -= 360) {
				/* empty */
			}
			if (Math.abs(i_85_) > 90)
				nmlt = 1;
			else
				nmlt = -1;
		}
		conto.xz += forca * (scz[0] * nmlt - scz[1] * pmlt + scz[2] * pmlt - scz[3] * nmlt + scx[0] * pmlt
				+ scx[1] * nmlt - scx[2] * nmlt - scx[3] * pmlt);
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
				conto.zy += 360;
			}
			while (pzy > 360) {
				pzy -= 360;
				conto.zy -= 360;
			}
			if (pzy < 190 && pzy > 170) {
				pzy = 180;
				conto.zy = 180;
				i_86_++;
			}
			if (pzy > 350 || pzy < 10) {
				pzy = 0;
				conto.zy = 0;
				i_86_++;
			}
			while (pxy < 360) {
				pxy += 360;
				conto.xy += 360;
			}
			while (pxy > 360) {
				pxy -= 360;
				conto.xy -= 360;
			}
			if (pxy < 190 && pxy > 170) {
				pxy = 180;
				conto.xy = 180;
				i_86_++;
			}
			if (pxy > 350 || pxy < 10) {
				pxy = 0;
				conto.xy = 0;
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
		conto.y = (int) ((fs_23_[0] + fs_23_[1] + fs_23_[2] + fs_23_[3]) / 4.0F - i_10_ * m.cos(pzy) * m.cos(pxy)
				+ f_12_);
		if (bool)
			i = -1;
		else
			i = 1;
		conto.x = (int) ((fs[0] - conto.keyx[0] * m.cos(conto.xz) + i * conto.keyz[0] * m.sin(conto.xz) + fs[1]
				- conto.keyx[1] * m.cos(conto.xz) + i * conto.keyz[1] * m.sin(conto.xz) + fs[2]
				- conto.keyx[2] * m.cos(conto.xz) + i * conto.keyz[2] * m.sin(conto.xz) + fs[3]
				- conto.keyx[3] * m.cos(conto.xz) + i * conto.keyz[3] * m.sin(conto.xz)) / 4.0F
				+ i_10_ * m.sin(pxy) * m.cos(conto.xz) - i_10_ * m.sin(pzy) * m.sin(conto.xz) + f);
		conto.z = (int) ((fs_22_[0] - i * conto.keyz[0] * m.cos(conto.xz) - conto.keyx[0] * m.sin(conto.xz) + fs_22_[1]
				- i * conto.keyz[1] * m.cos(conto.xz) - conto.keyx[1] * m.sin(conto.xz) + fs_22_[2]
				- i * conto.keyz[2] * m.cos(conto.xz) - conto.keyx[2] * m.sin(conto.xz) + fs_22_[3]
				- i * conto.keyz[3] * m.cos(conto.xz) - conto.keyx[3] * m.sin(conto.xz)) / 4.0F
				+ i_10_ * m.sin(pxy) * m.sin(conto.xz) - i_10_ * m.sin(pzy) * m.cos(conto.xz) + f_11_);
		if (Math.abs(speed) > 10.0F || !mtouch) {
			if (Math.abs(pxy - conto.xy) >= 4) {
				if (pxy > conto.xy)
					conto.xy += 2 + (pxy - conto.xy) / 2;
				else
					conto.xy -= 2 + (conto.xy - pxy) / 2;
			} else
				conto.xy = pxy;
			if (Math.abs(pzy - conto.zy) >= 4) {
				if (pzy > conto.zy)
					conto.zy += 2 + (pzy - conto.zy) / 2;
				else
					conto.zy -= 2 + (conto.zy - pzy) / 2;
			} else
				conto.zy = pzy;
		}
		if (wtouch && !capsized) {
			final float f_87_ = (float) (speed / cd.swits[cn][2] * 14.0F * (cd.bounce[cn] - 0.4));
			if (control.left && tilt < f_87_ && tilt >= 0.0F)
				tilt += 0.4;
			else if (control.right && tilt > -f_87_ && tilt <= 0.0F)
				tilt -= 0.4;
			else if (Math.abs(tilt) > 3.0 * (cd.bounce[cn] - 0.4)) {
				if (tilt > 0.0F)
					tilt -= 3.0 * (cd.bounce[cn] - 0.3);
				else
					tilt += 3.0 * (cd.bounce[cn] - 0.3);
			} else
				tilt = 0.0F;
			conto.xy += tilt;
			if (gtouch)
				conto.y -= tilt / 1.5;
		} else if (tilt != 0.0F)
			tilt = 0.0F;
		if (wtouch && i_32_ == 2) {
			conto.zy += (int) ((m.random() * 6.0F * speed / cd.swits[cn][2] - 3.0F * speed / cd.swits[cn][2])
					* (cd.bounce[cn] - 0.3));
			conto.xy += (int) ((m.random() * 6.0F * speed / cd.swits[cn][2] - 3.0F * speed / cd.swits[cn][2])
					* (cd.bounce[cn] - 0.3));
		}
		if (wtouch && i_32_ == 1) {
			conto.zy += (int) ((m.random() * 4.0F * speed / cd.swits[cn][2] - 2.0F * speed / cd.swits[cn][2])
					* (cd.bounce[cn] - 0.3));
			conto.xy += (int) ((m.random() * 4.0F * speed / cd.swits[cn][2] - 2.0F * speed / cd.swits[cn][2])
					* (cd.bounce[cn] - 0.3));
		}
		if (hitmag >= cd.maxmag[cn] && !dest) {
			distruct(conto);
			if (cntdest == 7)
				dest = true;
			else
				cntdest++;
			if (cntdest == 1)
				rpd.dest[im] = 300;
		}
		if (conto.dist == 0)
			for (int i_88_ = 0; i_88_ < conto.npl; i_88_++) {
				if (conto.p[i_88_].chip != 0)
					conto.p[i_88_].chip = 0;
				if (conto.p[i_88_].embos != 0)
					conto.p[i_88_].embos = 13;
			}
		int i_89_ = 0;
		int i_90_ = 0;
		int i_91_ = 0;
		if (nofocus)
			i_4_ = 1;
		else
			i_4_ = 7;
		for (int i_92_ = 0; i_92_ < checkpoints.n; i_92_++) {
			if (checkpoints.typ[i_92_] > 0) {
				i_91_++;
				if (checkpoints.typ[i_92_] == 1) {
					if (clear == i_91_ + nlaps * checkpoints.nsp)
						i_4_ = 1;
					if (Math.abs(conto.z - checkpoints.z[i_92_]) < 60.0F
							+ Math.abs(scz[0] + scz[1] + scz[2] + scz[3]) / 4.0F
							&& Math.abs(conto.x - checkpoints.x[i_92_]) < 700
							&& Math.abs(conto.y - checkpoints.y[i_92_] + 350) < 450
							&& clear == i_91_ + nlaps * checkpoints.nsp - 1) {
						clear = i_91_ + nlaps * checkpoints.nsp;
						pcleared = i_92_;
						focus = -1;
					}
				}
				if (checkpoints.typ[i_92_] == 2) {
					if (clear == i_91_ + nlaps * checkpoints.nsp)
						i_4_ = 1;
					if (Math.abs(conto.x - checkpoints.x[i_92_]) < 60.0F
							+ Math.abs(scx[0] + scx[1] + scx[2] + scx[3]) / 4.0F
							&& Math.abs(conto.z - checkpoints.z[i_92_]) < 700
							&& Math.abs(conto.y - checkpoints.y[i_92_] + 350) < 450
							&& clear == i_91_ + nlaps * checkpoints.nsp - 1) {
						clear = i_91_ + nlaps * checkpoints.nsp;
						pcleared = i_92_;
						focus = -1;
					}
				}
			}
			if (py(conto.x / 100, checkpoints.x[i_92_] / 100, conto.z / 100, checkpoints.z[i_92_] / 100) * i_4_ < i_90_
					|| i_90_ == 0) {
				i_89_ = i_92_;
				i_90_ = py(conto.x / 100, checkpoints.x[i_92_] / 100, conto.z / 100, checkpoints.z[i_92_] / 100) * i_4_;
			}
		}
		if (clear == i_91_ + nlaps * checkpoints.nsp) {
			nlaps++;
			if (xt.multion == 1 && im == xt.im) {
				if (xt.laptime < xt.fastestlap || xt.fastestlap == 0)
					xt.fastestlap = xt.laptime;
				xt.laptime = 0;
			}
		}
		if (im == xt.im) {
			if (xt.multion == 1 && xt.starcnt == 0)
				xt.laptime++;
			for (m.checkpoint = clear; m.checkpoint >= checkpoints.nsp; m.checkpoint -= checkpoints.nsp) {
				/* empty */
			}
			if (clear == checkpoints.nlaps * checkpoints.nsp - 1)
				m.lastcheck = true;
			if (checkpoints.haltall)
				m.lastcheck = false;
		}
		if (focus == -1) {
			if (im == xt.im)
				i_89_ += 2;
			else
				i_89_++;
			if (!nofocus) {
				i_91_ = pcleared + 1;
				if (i_91_ >= checkpoints.n)
					i_91_ = 0;
				while (checkpoints.typ[i_91_] <= 0)
					if (++i_91_ >= checkpoints.n)
						i_91_ = 0;
				if (i_89_ > i_91_ && (clear != nlaps * checkpoints.nsp || i_89_ < pcleared)) {
					i_89_ = i_91_;
					focus = i_89_;
				}
			}
			if (i_89_ >= checkpoints.n)
				i_89_ -= checkpoints.n;
			if (checkpoints.typ[i_89_] == -3)
				i_89_ = 0;
			if (im == xt.im) {
				if (missedcp != -1)
					missedcp = -1;
			} else if (missedcp != 0)
				missedcp = 0;
		} else {
			i_89_ = focus;
			if (im == xt.im) {
				if (missedcp == 0 && mtouch && Math.sqrt(
						py(conto.x / 10, checkpoints.x[focus] / 10, conto.z / 10, checkpoints.z[focus] / 10)) > 800.0)
					missedcp = 1;
				if (missedcp == -2 && Math.sqrt(
						py(conto.x / 10, checkpoints.x[focus] / 10, conto.z / 10, checkpoints.z[focus] / 10)) < 400.0)
					missedcp = 0;
				if (missedcp != 0 && mtouch && Math.sqrt(
						py(conto.x / 10, checkpoints.x[focus] / 10, conto.z / 10, checkpoints.z[focus] / 10)) < 250.0)
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
			if (m.noelec == 0)
				for (int i_93_ = 0; i_93_ < checkpoints.fn; i_93_++)
					if (!checkpoints.roted[i_93_]) {
						if (Math.abs(conto.z - checkpoints.fz[i_93_]) < 200 && py(conto.x / 100,
								checkpoints.fx[i_93_] / 100, conto.y / 100, checkpoints.fy[i_93_] / 100) < 30) {
							if (conto.dist == 0)
								conto.fcnt = 8;
							else {
								if (im == xt.im && !conto.fix && !xt.mutes)
									xt.carfixed.play();
								conto.fix = true;
							}
							rpd.fix[im] = 300;
						}
					} else if (Math.abs(conto.x - checkpoints.fx[i_93_]) < 200 && py(conto.z / 100,
							checkpoints.fz[i_93_] / 100, conto.y / 100, checkpoints.fy[i_93_] / 100) < 30) {
						if (conto.dist == 0)
							conto.fcnt = 8;
						else {
							if (im == xt.im && !conto.fix && !xt.mutes)
								xt.carfixed.play();
							conto.fix = true;
						}
						rpd.fix[im] = 300;
					}
		} else
			for (int i_94_ = 0; i_94_ < checkpoints.fn; i_94_++)
				if (rpy(conto.x / 100, checkpoints.fx[i_94_] / 100, conto.y / 100, checkpoints.fy[i_94_] / 100,
						conto.z / 100, checkpoints.fz[i_94_] / 100) < 760)
					m.noelec = 2;
		if (conto.fcnt == 7 || conto.fcnt == 8) {
			squash = 0;
			nbsq = 0;
			hitmag = 0;
			cntdest = 0;
			dest = false;
			newcar = true;
			conto.fcnt = 9;
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
				lxz = conto.xz;
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
			if (lxz != conto.xz) {
				travxz += lxz - conto.xz;
				lxz = conto.xz;
			}
			if (srfcnt < 10) {
				if (control.wall != -1)
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
							powerup += Math.abs(travxy) / 24.0F;
						else if (rtab)
							powerup += 30.0F;
						if (Math.abs(travzy) > 90)
							powerup += Math.abs(travzy) / 18.0F;
						else {
							if (ftab)
								powerup += 40.0F;
							if (btab)
								powerup += 40.0F;
						}
						if (Math.abs(travxz) > 90)
							powerup += Math.abs(travxz) / 18.0F;
						if (surfer)
							powerup += 30.0F;
						power += powerup;
						if (im == xt.im && (int) powerup > rpd.powered && rpd.wasted == 0
								&& (powerup > 60.0F || checkpoints.stage == 1 || checkpoints.stage == 2)) {
							rpdcatch = 30;
							if (rpd.hcaught)
								rpd.powered = (int) powerup;
							if (xt.multion == 1 && powerup > xt.beststunt)
								xt.beststunt = (int) powerup;
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
					for (int i_96_ = 0; i_96_ < 4; i_96_++)
						if (Math.abs(scz[i_96_]) < 70.0F && Math.abs(scx[i_96_]) < 70.0F)
							i_95_++;
					if (i_95_ == 4)
						capcnt = 1;
				} else {
					capcnt++;
					if (capcnt == 30) {
						speed = 0.0F;
						conto.y += cd.flipy[cn];
						pxy += 180;
						conto.xy += 180;
						capcnt = 0;
					}
				}
			}
			if (trcnt == 0 && speed != 0.0F)
				if (xtpower == 0) {
					if (power > 0.0F)
						power -= power * power * power / cd.powerloss[cn];
					else
						power = 0.0F;
				} else
					xtpower--;
		}
		if (im == xt.im) {
			if (control.wall != -1)
				control.wall = -1;
		} else if (lastcolido != 0 && !dest)
			lastcolido--;
		if (dest) {
			if (checkpoints.dested[im] == 0)
				if (lastcolido == 0)
					checkpoints.dested[im] = 1;
				else
					checkpoints.dested[im] = 2;
		} else if (checkpoints.dested[im] != 0 && checkpoints.dested[im] != 3)
			checkpoints.dested[im] = 0;
		if (im == xt.im && rpd.wasted == 0 && rpdcatch != 0) {
			rpdcatch--;
			if (rpdcatch == 0) {
				rpd.cotchinow(im);
				if (rpd.hcaught)
					rpd.whenwasted = (int) (185.0F + m.random() * 20.0F);
			}
		}
	}

	private int py(final int i, final int i_145_, final int i_146_, final int i_147_) {
		return (i - i_145_) * (i - i_145_) + (i_146_ - i_147_) * (i_146_ - i_147_);
	}

	private int regx(final int i, float f, final ContO conto) {
		int i_110_ = 0;
		boolean bool = true;
		if (xt.multion == 1 && xt.im != im)
			bool = false;
		if (xt.multion >= 2)
			bool = false;
		if (xt.lan && xt.multion >= 1 && xt.isbot[im])
			bool = true;
		f *= cd.dammult[cn];
		if (Math.abs(f) > 100.0F) {
			rpd.recx(i, f, im);
			if (f > 100.0F)
				f -= 100.0F;
			if (f < -100.0F)
				f += 100.0F;
			shakedam = (int) ((Math.abs(f) + shakedam) / 2.0F);
			if (im == xt.im || colidim)
				xt.crash(f, 0);
			for (int i_111_ = 0; i_111_ < conto.npl; i_111_++) {
				float f_112_ = 0.0F;
				for (int i_113_ = 0; i_113_ < conto.p[i_111_].n; i_113_++)
					if (conto.p[i_111_].wz == 0 && py(conto.keyx[i], conto.p[i_111_].ox[i_113_], conto.keyz[i],
							conto.p[i_111_].oz[i_113_]) < cd.clrad[cn]) {
						f_112_ = f / 20.0F * m.random();
						conto.p[i_111_].oz[i_113_] -= f_112_ * m.sin(conto.xz) * m.cos(conto.zy);
						conto.p[i_111_].ox[i_113_] += f_112_ * m.cos(conto.xz) * m.cos(conto.xy);
						if (bool) {
							hitmag += Math.abs(f_112_);
							i_110_ += Math.abs(f_112_);
						}
					}
				if (f_112_ != 0.0F) {
					if (Math.abs(f_112_) >= 1.0F) {
						conto.p[i_111_].chip = 1;
						conto.p[i_111_].ctmag = f_112_;
					}
					if (!conto.p[i_111_].nocol && conto.p[i_111_].glass != 1) {
						if (conto.p[i_111_].bfase > 20 && conto.p[i_111_].hsb[1] > 0.25)
							conto.p[i_111_].hsb[1] = 0.25F;
						if (conto.p[i_111_].bfase > 25 && conto.p[i_111_].hsb[2] > 0.7)
							conto.p[i_111_].hsb[2] = 0.7F;
						if (conto.p[i_111_].bfase > 30 && conto.p[i_111_].hsb[1] > 0.15)
							conto.p[i_111_].hsb[1] = 0.15F;
						if (conto.p[i_111_].bfase > 35 && conto.p[i_111_].hsb[2] > 0.6)
							conto.p[i_111_].hsb[2] = 0.6F;
						if (conto.p[i_111_].bfase > 40)
							conto.p[i_111_].hsb[0] = 0.075F;
						if (conto.p[i_111_].bfase > 50 && conto.p[i_111_].hsb[2] > 0.5)
							conto.p[i_111_].hsb[2] = 0.5F;
						if (conto.p[i_111_].bfase > 60)
							conto.p[i_111_].hsb[0] = 0.05F;
						conto.p[i_111_].bfase += Math.abs(f_112_);
						new Color(conto.p[i_111_].c[0], conto.p[i_111_].c[1], conto.p[i_111_].c[2]);
						final Color color = Color.getHSBColor(conto.p[i_111_].hsb[0], conto.p[i_111_].hsb[1],
								conto.p[i_111_].hsb[2]);
						conto.p[i_111_].c[0] = color.getRed();
						conto.p[i_111_].c[1] = color.getGreen();
						conto.p[i_111_].c[2] = color.getBlue();
					}
					if (conto.p[i_111_].glass == 1)
						conto.p[i_111_].gr += Math.abs(f_112_ * 1.5);
				}
			}
		}
		return i_110_;
	}

	private int regy(final int i, float f, final ContO conto) {
		int i_97_ = 0;
		boolean bool = true;
		if (xt.multion == 1 && xt.im != im)
			bool = false;
		if (xt.multion >= 2)
			bool = false;
		if (xt.lan && xt.multion >= 1 && xt.isbot[im])
			bool = true;
		f *= cd.dammult[cn];
		if (f > 100.0F) {
			rpd.recy(i, f, mtouch, im);
			f -= 100.0F;
			int i_98_ = 0;
			int i_99_ = 0;
			int i_100_ = conto.zy;
			int i_101_ = conto.xy;
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
			for (/**/; i_101_ < 360; i_101_ += 360) {
				/* empty */
			}
			for (/**/; i_101_ > 360; i_101_ -= 360) {
				/* empty */
			}
			if (i_101_ < 210 && i_101_ > 150)
				i_99_ = -1;
			if (i_101_ > 330 || i_101_ < 30)
				i_99_ = 1;
			if (i_99_ * i_98_ == 0)
				shakedam = (int) ((Math.abs(f) + shakedam) / 2.0F);
			if (im == xt.im || colidim)
				xt.crash(f, i_99_ * i_98_);
			if (i_99_ * i_98_ == 0 || mtouch)
				for (int i_102_ = 0; i_102_ < conto.npl; i_102_++) {
					float f_103_ = 0.0F;
					for (int i_104_ = 0; i_104_ < conto.p[i_102_].n; i_104_++)
						if (conto.p[i_102_].wz == 0 && py(conto.keyx[i], conto.p[i_102_].ox[i_104_], conto.keyz[i],
								conto.p[i_102_].oz[i_104_]) < cd.clrad[cn]) {
							f_103_ = f / 20.0F * m.random();
							conto.p[i_102_].oz[i_104_] += f_103_ * m.sin(i_100_);
							conto.p[i_102_].ox[i_104_] -= f_103_ * m.sin(i_101_);
							if (bool) {
								hitmag += Math.abs(f_103_);
								i_97_ += Math.abs(f_103_);
							}
						}
					if (f_103_ != 0.0F) {
						if (Math.abs(f_103_) >= 1.0F) {
							conto.p[i_102_].chip = 1;
							conto.p[i_102_].ctmag = f_103_;
						}
						if (!conto.p[i_102_].nocol && conto.p[i_102_].glass != 1) {
							if (conto.p[i_102_].bfase > 20 && conto.p[i_102_].hsb[1] > 0.25)
								conto.p[i_102_].hsb[1] = 0.25F;
							if (conto.p[i_102_].bfase > 25 && conto.p[i_102_].hsb[2] > 0.7)
								conto.p[i_102_].hsb[2] = 0.7F;
							if (conto.p[i_102_].bfase > 30 && conto.p[i_102_].hsb[1] > 0.15)
								conto.p[i_102_].hsb[1] = 0.15F;
							if (conto.p[i_102_].bfase > 35 && conto.p[i_102_].hsb[2] > 0.6)
								conto.p[i_102_].hsb[2] = 0.6F;
							if (conto.p[i_102_].bfase > 40)
								conto.p[i_102_].hsb[0] = 0.075F;
							if (conto.p[i_102_].bfase > 50 && conto.p[i_102_].hsb[2] > 0.5)
								conto.p[i_102_].hsb[2] = 0.5F;
							if (conto.p[i_102_].bfase > 60)
								conto.p[i_102_].hsb[0] = 0.05F;
							conto.p[i_102_].bfase += f_103_;
							new Color(conto.p[i_102_].c[0], conto.p[i_102_].c[1], conto.p[i_102_].c[2]);
							final Color color = Color.getHSBColor(conto.p[i_102_].hsb[0], conto.p[i_102_].hsb[1],
									conto.p[i_102_].hsb[2]);
							conto.p[i_102_].c[0] = color.getRed();
							conto.p[i_102_].c[1] = color.getGreen();
							conto.p[i_102_].c[2] = color.getBlue();
						}
						if (conto.p[i_102_].glass == 1)
							conto.p[i_102_].gr += Math.abs(f_103_ * 1.5);
					}
				}
			if (i_99_ * i_98_ == -1)
				if (nbsq > 0) {
					int i_105_ = 0;
					int i_106_ = 1;
					for (int i_107_ = 0; i_107_ < conto.npl; i_107_++) {
						float f_108_ = 0.0F;
						for (int i_109_ = 0; i_109_ < conto.p[i_107_].n; i_109_++)
							if (conto.p[i_107_].wz == 0) {
								f_108_ = f / 15.0F * m.random();
								if ((Math.abs(conto.p[i_107_].oy[i_109_] - cd.flipy[cn] - squash) < cd.msquash[cn] * 3
										|| conto.p[i_107_].oy[i_109_] < cd.flipy[cn] + squash)
										&& squash < cd.msquash[cn]) {
									conto.p[i_107_].oy[i_109_] += f_108_;
									i_105_ += f_108_;
									i_106_++;
									if (bool) {
										hitmag += Math.abs(f_108_);
										i_97_ += Math.abs(f_108_);
									}
								}
							}
						if (conto.p[i_107_].glass == 1)
							conto.p[i_107_].gr += 5;
						else if (f_108_ != 0.0F)
							conto.p[i_107_].bfase += f_108_;
						if (Math.abs(f_108_) >= 1.0F) {
							conto.p[i_107_].chip = 1;
							conto.p[i_107_].ctmag = f_108_;
						}
					}
					squash += i_105_ / i_106_;
					nbsq = 0;
				} else
					nbsq++;
		}
		return i_97_;
	}

	private int regz(final int i, float f, final ContO conto) {
		int i_114_ = 0;
		boolean bool = true;
		if (xt.multion == 1 && xt.im != im)
			bool = false;
		if (xt.multion >= 2)
			bool = false;
		if (xt.lan && xt.multion >= 1 && xt.isbot[im])
			bool = true;
		f *= cd.dammult[cn];
		if (Math.abs(f) > 100.0F) {
			rpd.recz(i, f, im);
			if (f > 100.0F)
				f -= 100.0F;
			if (f < -100.0F)
				f += 100.0F;
			shakedam = (int) ((Math.abs(f) + shakedam) / 2.0F);
			if (im == xt.im || colidim)
				xt.crash(f, 0);
			for (int i_115_ = 0; i_115_ < conto.npl; i_115_++) {
				float f_116_ = 0.0F;
				for (int i_117_ = 0; i_117_ < conto.p[i_115_].n; i_117_++)
					if (conto.p[i_115_].wz == 0 && py(conto.keyx[i], conto.p[i_115_].ox[i_117_], conto.keyz[i],
							conto.p[i_115_].oz[i_117_]) < cd.clrad[cn]) {
						f_116_ = f / 20.0F * m.random();
						conto.p[i_115_].oz[i_117_] += f_116_ * m.cos(conto.xz) * m.cos(conto.zy);
						conto.p[i_115_].ox[i_117_] += f_116_ * m.sin(conto.xz) * m.cos(conto.xy);
						if (bool) {
							hitmag += Math.abs(f_116_);
							i_114_ += Math.abs(f_116_);
						}
					}
				if (f_116_ != 0.0F) {
					if (Math.abs(f_116_) >= 1.0F) {
						conto.p[i_115_].chip = 1;
						conto.p[i_115_].ctmag = f_116_;
					}
					if (!conto.p[i_115_].nocol && conto.p[i_115_].glass != 1) {
						if (conto.p[i_115_].bfase > 20 && conto.p[i_115_].hsb[1] > 0.25)
							conto.p[i_115_].hsb[1] = 0.25F;
						if (conto.p[i_115_].bfase > 25 && conto.p[i_115_].hsb[2] > 0.7)
							conto.p[i_115_].hsb[2] = 0.7F;
						if (conto.p[i_115_].bfase > 30 && conto.p[i_115_].hsb[1] > 0.15)
							conto.p[i_115_].hsb[1] = 0.15F;
						if (conto.p[i_115_].bfase > 35 && conto.p[i_115_].hsb[2] > 0.6)
							conto.p[i_115_].hsb[2] = 0.6F;
						if (conto.p[i_115_].bfase > 40)
							conto.p[i_115_].hsb[0] = 0.075F;
						if (conto.p[i_115_].bfase > 50 && conto.p[i_115_].hsb[2] > 0.5)
							conto.p[i_115_].hsb[2] = 0.5F;
						if (conto.p[i_115_].bfase > 60)
							conto.p[i_115_].hsb[0] = 0.05F;
						conto.p[i_115_].bfase += Math.abs(f_116_);
						new Color(conto.p[i_115_].c[0], conto.p[i_115_].c[1], conto.p[i_115_].c[2]);
						final Color color = Color.getHSBColor(conto.p[i_115_].hsb[0], conto.p[i_115_].hsb[1],
								conto.p[i_115_].hsb[2]);
						conto.p[i_115_].c[0] = color.getRed();
						conto.p[i_115_].c[1] = color.getGreen();
						conto.p[i_115_].c[2] = color.getBlue();
					}
					if (conto.p[i_115_].glass == 1)
						conto.p[i_115_].gr += Math.abs(f_116_ * 1.5);
				}
			}
		}
		return i_114_;
	}

	public void reseto(final int i, final ContO conto, final CheckPoints checkpoints) {
		cn = i;
		for (int i_0_ = 0; i_0_ < 8; i_0_++) {
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
		forca = ((float) Math.sqrt(conto.keyz[0] * conto.keyz[0] + conto.keyx[0] * conto.keyx[0])
				+ (float) Math.sqrt(conto.keyz[1] * conto.keyz[1] + conto.keyx[1] * conto.keyx[1])
				+ (float) Math.sqrt(conto.keyz[2] * conto.keyz[2] + conto.keyx[2] * conto.keyx[2])
				+ (float) Math.sqrt(conto.keyz[3] * conto.keyz[3] + conto.keyx[3] * conto.keyx[3])) / 10000.0F
				* (float) (cd.bounce[cn] - 0.3);
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
		for (int i_2_ = 0; i_2_ < 4; i_2_++)
			for (int i_3_ = 0; i_3_ < 4; i_3_++) {
				crank[i_2_][i_3_] = 0;
				lcrank[i_2_][i_3_] = 0;
			}
		pan = 0;
		pcleared = checkpoints.pcs;
		clear = 0;
		nlaps = 0;
		focus = -1;
		missedcp = 0;
		nofocus = false;
		power = 98.0F;
		lastcolido = 0;
		checkpoints.dested[im] = 0;
		squash = 0;
		nbsq = 0;
		hitmag = 0;
		cntdest = 0;
		dest = false;
		newcar = false;
		if (im == xt.im) {
			m.checkpoint = -1;
			m.lastcheck = false;
		}
		rpdcatch = 0;
		newedcar = 0;
		fixes = -1;
		if (checkpoints.nfix == 1)
			fixes = 4;
		if (checkpoints.nfix == 2)
			fixes = 3;
		if (checkpoints.nfix == 3)
			fixes = 2;
		if (checkpoints.nfix == 4)
			fixes = 1;
	}

	private void rot(final float[] fs, final float[] fs_134_, final int i, final int i_135_, final int i_136_,
					 final int i_137_) {
		if (i_136_ != 0)
			for (int i_138_ = 0; i_138_ < i_137_; i_138_++) {
				final float f = fs[i_138_];
				final float f_139_ = fs_134_[i_138_];
				fs[i_138_] = i + ((f - i) * m.cos(i_136_) - (f_139_ - i_135_) * m.sin(i_136_));
				fs_134_[i_138_] = i_135_ + ((f - i) * m.sin(i_136_) + (f_139_ - i_135_) * m.cos(i_136_));
			}
	}

	private int rpy(final float f, final float f_140_, final float f_141_, final float f_142_, final float f_143_,
					final float f_144_) {
		return (int) ((f - f_140_) * (f - f_140_) + (f_141_ - f_142_) * (f_141_ - f_142_)
				+ (f_143_ - f_144_) * (f_143_ - f_144_));
	}
}
