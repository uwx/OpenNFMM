
/* Medium - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Medium {
	int focus_point = 400;
	int ground = 250;
	int skyline = -300;
	int[] fade = { 3000, 4500, 6000, 7500, 9000, 10500, 12000, 13500, 15000, 16500, 18000, 19500, 21000, 22500, 24000,
			25500 };
	int[] cldd = { 210, 210, 210, 1, -1000 };
	int[] clds = { 210, 210, 210 };
	int[] osky = { 170, 220, 255 };
	int[] csky = { 170, 220, 255 };
	int[] ogrnd = { 205, 200, 200 };
	int[] cgrnd = { 205, 200, 200 };
	int[] texture = { 0, 0, 0, 50 };
	int[] cpol = { 215, 210, 210 };
	int[] crgrnd = { 205, 200, 200 };
	int[] cfade = { 255, 220, 220 };
	int[] snap = { 0, 0, 0 };
	int fogd = 7;
	int mgen = (int) (Math.random() * 100000.0);
	boolean loadnew = false;
	boolean lightson = false;
	boolean darksky = false;
	int lightn = -1;
	int lilo = 217;
	boolean lton = false;
	int noelec = 0;
	int trk = 0;
	boolean crs = false;
	int cx = 400;
	int cy = 225;
	int cz = 50;
	int xz = 0;
	int zy = 0;
	int x = 0;
	int y = 0;
	int z = 0;
	int iw = 0;
	int ih = 0;
	int w = 800;
	int h = 450;
	int nsp = 0;
	int[] spx = new int[7];
	int[] spz = new int[7];
	int[] sprad = new int[7];
	boolean td = false;
	int bcxz = 0;
	boolean bt = false;
	int vxz = 180;
	int adv = 500;
	boolean vert = false;
	float[] tcos = new float[360];
	float[] tsin = new float[360];
	int lastmaf = 0;
	int checkpoint = -1;
	boolean lastcheck = false;
	float elecr = 0.0F;
	boolean cpflik = false;
	boolean nochekflk = false;
	int cntrn = 0;
	boolean[] diup = { false, false, false };
	int[] rand = { 0, 0, 0 };
	int trn = 0;
	int hit = 45000;
	int ptr = 0;
	int ptcnt = -10;
	int nrnd = 0;
	long trx = 0L;
	long trz = 0L;
	long atrx = 0L;
	long atrz = 0L;
	int fallen = 0;
	float fo = 1.0F;
	float gofo = (float) (0.33000001311302185 + Math.random() * 1.34);
	int fvect = 200;
	int[][] ogpx = null;
	int[][] ogpz = null;
	float[][] pvr = null;
	int[] cgpx = null;
	int[] cgpz = null;
	int[] pmx = null;
	float[] pcv = null;
	int sgpx = 0;
	int sgpz = 0;
	int nrw = 0;
	int ncl = 0;
	int noc = 0;
	int[] clx = null;
	int[] clz = null;
	int[] cmx = null;
	int[][][] clax = null;
	int[][][] clay = null;
	int[][][] claz = null;
	int[][][][] clc = null;
	int nmt = 0;
	int[] mrd = null;
	int[] nmv = null;
	int[][] mtx = null;
	int[][] mty = null;
	int[][] mtz = null;
	int[][][] mtc = null;
	int nst = 0;
	int[] stx = null;
	int[] stz = null;
	int[][][] stc = null;
	boolean[] bst = null;
	int[] twn = null;
	int resdown = 0;
	int rescnt = 5;

	public Medium() {
		for (int i = 0; i < 360; i++)
			tcos[i] = (float) Math.cos(i * 0.017453292519943295);
		for (int i = 0; i < 360; i++)
			tsin[i] = (float) Math.sin(i * 0.017453292519943295);
	}

	public float random() {
		if (cntrn == 0) {
			for (int i = 0; i < 3; i++) {
				rand[i] = (int) (10.0 * Math.random());
				if (Math.random() > Math.random())
					diup[i] = false;
				else
					diup[i] = true;
			}
			cntrn = 20;
		} else
			cntrn--;
		for (int i = 0; i < 3; i++)
			if (diup[i]) {
				rand[i]++;
				if (rand[i] == 10)
					rand[i] = 0;
			} else {
				rand[i]--;
				if (rand[i] == -1)
					rand[i] = 9;
			}
		trn++;
		if (trn == 3)
			trn = 0;
		return rand[trn] / 10.0F;
	}

	public void watch(final ContO conto, final int i) {
		if (td) {
			y = (int) ((conto).y - 300 - 1100.0F * random());
			x = ((conto).x + (int) (((conto).x + 400 - (conto).x) * cos(i) - ((conto).z + 5000 - (conto).z) * sin(i)));
			z = ((conto).z + (int) (((conto).x + 400 - (conto).x) * sin(i) + ((conto).z + 5000 - (conto).z) * cos(i)));
			td = false;
		}
		int i_0_ = 0;
		if ((conto).x - x - cx > 0)
			i_0_ = 180;
		int i_1_ = -(int) (90 + i_0_
				+ (Math.atan((double) ((conto).z - z) / (double) ((conto).x - x - cx)) / 0.017453292519943295));
		i_0_ = 0;
		if ((conto).y - y - cy < 0)
			i_0_ = -180;
		final int i_2_ = (int) Math
				.sqrt((((conto).z - z) * ((conto).z - z)) + (((conto).x - x - cx) * ((conto).x - x - cx)));
		final int i_3_ = (int) (90 + i_0_
				- (Math.atan((double) i_2_ / (double) ((conto).y - y - cy)) / 0.017453292519943295));
		for (/**/; i_1_ < 0; i_1_ += 360) {
			/* empty */
		}
		for (/**/; i_1_ > 360; i_1_ -= 360) {
			/* empty */
		}
		xz = i_1_;
		zy += (i_3_ - zy) / 5;
		if ((int) Math.sqrt((((conto).z - z) * ((conto).z - z)) + (((conto).x - x - cx) * ((conto).x - x - cx))
				+ (((conto).y - y - cy) * ((conto).y - y - cy))) > 6000)
			td = true;
	}

	public void aroundtrack(final CheckPoints checkpoints) {
		y = -hit;
		x = (cx + (int) trx + (int) (17000.0F * cos(vxz)));
		z = (int) trz + (int) (17000.0F * sin(vxz));
		if (hit > 5000) {
			if (hit == 45000) {
				fo = 1.0F;
				zy = 67;
				atrx = ((checkpoints).x[0] - trx) / 116L;
				atrz = ((checkpoints).z[0] - trz) / 116L;
				focus_point = 400;
			}
			if (hit == 20000) {
				fallen = 500;
				fo = 1.0F;
				zy = 67;
				atrx = ((checkpoints).x[0] - trx) / 116L;
				atrz = ((checkpoints).z[0] - trz) / 116L;
				focus_point = 400;
			}
			hit -= fallen;
			fallen += 7;
			trx += atrx;
			trz += atrz;
			if (hit < 17600)
				zy -= 2;
			if (fallen > 500)
				fallen = 500;
			if (hit <= 5000) {
				hit = 5000;
				fallen = 0;
			}
			vxz += 3;
		} else {
			focus_point = (int) (400.0F * fo);
			if (Math.abs(fo - gofo) > 0.005) {
				if (fo < gofo)
					fo += 0.005F;
				else
					fo -= 0.005F;
			} else
				gofo = (float) (0.3499999940395355 + Math.random() * 1.3);
			vxz++;
			trx -= (trx - ((checkpoints).x[ptr])) / 10L;
			trz -= (trz - ((checkpoints).z[ptr])) / 10L;
			if (ptcnt == 7) {
				ptr++;
				if (ptr == (checkpoints).n) {
					ptr = 0;
					nrnd++;
				}
				ptcnt = 0;
			} else
				ptcnt++;
		}
		if (vxz > 360)
			vxz -= 360;
		xz = -vxz - 90;
		if (-y - cy < 0) {
		}
		Math.sqrt(((trz - z + cz) * (trz - z + cz)) + ((trx - x - cx) * (trx - x - cx)));
		if (cpflik)
			cpflik = false;
		else
			cpflik = true;
	}

	public void around(final ContO conto, final boolean bool) {
		if (!bool) {
			if (!vert)
				adv += 2;
			else
				adv -= 2;
			if (adv > 900)
				vert = true;
			if (adv < -500)
				vert = false;
		} else {
			adv -= 14;
			if (adv < 617)
				adv = 617;
		}
		int i = 500 + adv;
		if (bool && i < 1300)
			i = 1300;
		if (i < 1000)
			i = 1000;
		y = (conto).y - adv;
		if (y > 10)
			vert = false;
		x = (conto).x + (int) (((conto).x - i - (conto).x) * cos(vxz));
		z = (conto).z + (int) (((conto).x - i - (conto).x) * sin(vxz));
		if (!bool)
			vxz += 2;
		else
			vxz += 4;
		int i_4_ = 0;
		int i_5_ = y;
		if (i_5_ > 0)
			i_5_ = 0;
		if ((conto).y - i_5_ - cy < 0)
			i_4_ = -180;
		final int i_6_ = (int) Math
				.sqrt((((conto).z - z + cz) * ((conto).z - z + cz)) + (((conto).x - x - cx) * ((conto).x - x - cx)));
		int i_7_ = (int) (90 + i_4_
				- (Math.atan((double) i_6_ / (double) ((conto).y - i_5_ - cy)) / 0.017453292519943295));
		xz = -vxz + 90;
		if (bool)
			i_7_ -= 15;
		zy += (i_7_ - zy) / 10;
	}

	public void getaround(final ContO conto) {
		if (!vert)
			adv += 2;
		else
			adv -= 2;
		if (adv > 1700)
			vert = true;
		if (adv < -500)
			vert = false;
		if ((conto).y - adv > 10)
			vert = false;
		int i = 500 + adv;
		if (i < 1000)
			i = 1000;
		final int i_8_ = (conto).y - adv;
		final int i_9_ = (conto).x + (int) (((conto).x - i - (conto).x) * cos(vxz));
		final int i_10_ = (conto).z + (int) (((conto).x - i - (conto).x) * sin(vxz));
		int i_11_ = 0;
		if (Math.abs(i_8_ - y) > fvect) {
			if (y < i_8_)
				y += fvect;
			else
				y -= fvect;
		} else {
			y = i_8_;
			i_11_++;
		}
		if (Math.abs(i_9_ - x) > fvect) {
			if (x < i_9_)
				x += fvect;
			else
				x -= fvect;
		} else {
			x = i_9_;
			i_11_++;
		}
		if (Math.abs(i_10_ - z) > fvect) {
			if (z < i_10_)
				z += fvect;
			else
				z -= fvect;
		} else {
			z = i_10_;
			i_11_++;
		}
		if (i_11_ == 3)
			fvect = 200;
		else
			fvect += 2;
		for (vxz += 2; vxz > 360; vxz -= 360) {
			/* empty */
		}
		int i_12_ = -vxz + 90;
		int i_13_ = 0;
		if ((conto).x - x - cx > 0)
			i_13_ = 180;
		int i_14_ = -(int) (90 + i_13_
				+ (Math.atan((double) ((conto).z - z) / (double) ((conto).x - x - cx)) / 0.017453292519943295));
		int i_15_ = y;
		i_13_ = 0;
		if (i_15_ > 0)
			i_15_ = 0;
		if ((conto).y - i_15_ - cy < 0)
			i_13_ = -180;
		final int i_16_ = (int) Math
				.sqrt((((conto).z - z + cz) * ((conto).z - z + cz)) + (((conto).x - x - cx) * ((conto).x - x - cx)));
		int i_17_ = 25;
		if (i_16_ != 0)
			i_17_ = (int) (90 + i_13_
					- (Math.atan((double) i_16_ / (double) ((conto).y - i_15_ - cy)) / 0.017453292519943295));
		for (/**/; i_12_ < 0; i_12_ += 360) {
			/* empty */
		}
		for (/**/; i_12_ > 360; i_12_ -= 360) {
			/* empty */
		}
		for (/**/; i_14_ < 0; i_14_ += 360) {
			/* empty */
		}
		for (/**/; i_14_ > 360; i_14_ -= 360) {
			/* empty */
		}
		if ((Math.abs(i_12_ - i_14_) < 30 || Math.abs(i_12_ - i_14_) > 330) && i_11_ == 3) {
			if (Math.abs(i_12_ - xz) > 7 && Math.abs(i_12_ - xz) < 353) {
				if (Math.abs(i_12_ - xz) > 180) {
					if (xz > i_12_)
						xz += 7;
					else
						xz -= 7;
				} else if (xz < i_12_)
					xz += 7;
				else
					xz -= 7;
			} else
				xz = i_12_;
		} else if (Math.abs(i_14_ - xz) > 6 && Math.abs(i_14_ - xz) < 354) {
			if (Math.abs(i_14_ - xz) > 180) {
				if (xz > i_14_)
					xz += 3;
				else
					xz -= 3;
			} else if (xz < i_14_)
				xz += 3;
			else
				xz -= 3;
		} else
			xz = i_14_;
		zy += (i_17_ - zy) / 10;
	}

	public void transaround(final ContO conto, final ContO conto_18_, final int i) {
		final int i_19_ = ((conto).x * (20 - i) + (conto_18_).x * i) / 20;
		final int i_20_ = ((conto).y * (20 - i) + (conto_18_).y * i) / 20;
		final int i_21_ = ((conto).z * (20 - i) + (conto_18_).z * i) / 20;
		if (!vert)
			adv += 2;
		else
			adv -= 2;
		if (adv > 900)
			vert = true;
		if (adv < -500)
			vert = false;
		int i_22_ = 500 + adv;
		if (i_22_ < 1000)
			i_22_ = 1000;
		y = i_20_ - adv;
		if (y > 10)
			vert = false;
		x = i_19_ + (int) ((i_19_ - i_22_ - i_19_) * cos(vxz));
		z = i_21_ + (int) ((i_19_ - i_22_ - i_19_) * sin(vxz));
		vxz += 2;
		int i_23_ = 0;
		int i_24_ = y;
		if (i_24_ > 0)
			i_24_ = 0;
		if (i_20_ - i_24_ - cy < 0)
			i_23_ = -180;
		final int i_25_ = (int) Math
				.sqrt(((i_21_ - z + cz) * (i_21_ - z + cz)) + ((i_19_ - x - cx) * (i_19_ - x - cx)));
		final int i_26_ = (int) (90 + i_23_
				- (Math.atan((double) i_25_ / (double) (i_20_ - i_24_ - cy)) / 0.017453292519943295));
		xz = -vxz + 90;
		zy += (i_26_ - zy) / 10;
	}

	public void follow(final ContO conto, int i, final int i_27_) {
		zy = 10;
		int i_28_ = 2 + Math.abs(bcxz) / 4;
		if (i_28_ > 20)
			i_28_ = 20;
		if (i_27_ != 0) {
			if (i_27_ == 1) {
				if (bcxz < 180)
					bcxz += i_28_;
				if (bcxz > 180)
					bcxz = 180;
			}
			if (i_27_ == -1) {
				if (bcxz > -180)
					bcxz -= i_28_;
				if (bcxz < -180)
					bcxz = -180;
			}
		} else if (Math.abs(bcxz) > i_28_) {
			if (bcxz > 0)
				bcxz -= i_28_;
			else
				bcxz += i_28_;
		} else if (bcxz != 0)
			bcxz = 0;
		i += bcxz;
		xz = -i;
		x = ((conto).x - cx + (int) (-((conto).z - 800 - (conto).z) * sin(i)));
		z = ((conto).z - cz + (int) (((conto).z - 800 - (conto).z) * cos(i)));
		y = (conto).y - 250 - cy;
	}

	public void getfollow(final ContO conto, int i, final int i_29_) {
		zy = 10;
		int i_30_ = 2 + Math.abs(bcxz) / 4;
		if (i_30_ > 20)
			i_30_ = 20;
		if (i_29_ != 0) {
			if (i_29_ == 1) {
				if (bcxz < 180)
					bcxz += i_30_;
				if (bcxz > 180)
					bcxz = 180;
			}
			if (i_29_ == -1) {
				if (bcxz > -180)
					bcxz -= i_30_;
				if (bcxz < -180)
					bcxz = -180;
			}
		} else if (Math.abs(bcxz) > i_30_) {
			if (bcxz > 0)
				bcxz -= i_30_;
			else
				bcxz += i_30_;
		} else if (bcxz != 0)
			bcxz = 0;
		i += bcxz;
		xz = -i;
		final int i_31_ = ((conto).x - cx + (int) (-((conto).z - 800 - (conto).z) * sin(i)));
		final int i_32_ = ((conto).z - cz + (int) (((conto).z - 800 - (conto).z) * cos(i)));
		final int i_33_ = (conto).y - 250 - cy;
		int i_34_ = 0;
		if (Math.abs(i_33_ - y) > fvect) {
			if (y < i_33_)
				y += fvect;
			else
				y -= fvect;
		} else {
			y = i_33_;
			i_34_++;
		}
		if (Math.abs(i_31_ - x) > fvect) {
			if (x < i_31_)
				x += fvect;
			else
				x -= fvect;
		} else {
			x = i_31_;
			i_34_++;
		}
		if (Math.abs(i_32_ - z) > fvect) {
			if (z < i_32_)
				z += fvect;
			else
				z -= fvect;
		} else {
			z = i_32_;
			i_34_++;
		}
		if (i_34_ == 3)
			fvect = 200;
		else
			fvect += 2;
	}

	public void newpolys(final int i, final int i_35_, final int i_36_, final int i_37_, final Trackers trackers,
			final int i_38_) {
		final Random random = new Random((i_38_ + cgrnd[0] + cgrnd[1] + cgrnd[2]) * 1671);
		nrw = i_35_ / 1200 + 9;
		ncl = i_37_ / 1200 + 9;
		sgpx = i - 4800;
		sgpz = i_36_ - 4800;
		ogpx = null;
		ogpz = null;
		pvr = null;
		cgpx = null;
		cgpz = null;
		pmx = null;
		pcv = null;
		ogpx = new int[nrw * ncl][8];
		ogpz = new int[nrw * ncl][8];
		pvr = new float[nrw * ncl][8];
		cgpx = new int[nrw * ncl];
		cgpz = new int[nrw * ncl];
		pmx = new int[nrw * ncl];
		pcv = new float[nrw * ncl];
		int i_39_ = 0;
		int i_40_ = 0;
		for (int i_41_ = 0; i_41_ < nrw * ncl; i_41_++) {
			cgpx[i_41_] = (sgpx + i_39_ * 1200 + (int) (random.nextDouble() * 1000.0 - 500.0));
			cgpz[i_41_] = (sgpz + i_40_ * 1200 + (int) (random.nextDouble() * 1000.0 - 500.0));
			if (trackers != null)
				for (int i_42_ = 0; i_42_ < (trackers).nt; i_42_++)
					if ((trackers).zy[i_42_] == 0 && (trackers).xy[i_42_] == 0) {
						if (((trackers).radx[i_42_] < (trackers).radz[i_42_])
								&& (Math.abs(cgpz[i_41_] - (trackers).z[i_42_]) < (trackers).radz[i_42_]))
							for (/**/; (Math.abs(cgpx[i_41_]
									- (trackers).x[i_42_]) < (trackers).radx[i_42_]); cgpx[i_41_] += ((random
											.nextDouble() * ((trackers).radx[i_42_]) * 2.0)
											- ((trackers).radx[i_42_]))) {
								/* empty */
							}
						if (((trackers).radz[i_42_] < (trackers).radx[i_42_])
								&& (Math.abs(cgpx[i_41_] - (trackers).x[i_42_]) < (trackers).radx[i_42_]))
							for (/**/; (Math.abs(cgpz[i_41_]
									- (trackers).z[i_42_]) < (trackers).radz[i_42_]); cgpz[i_41_] += ((random
											.nextDouble() * ((trackers).radz[i_42_]) * 2.0)
											- ((trackers).radz[i_42_]))) {
								/* empty */
							}
					}
			if (++i_39_ == nrw) {
				i_39_ = 0;
				i_40_++;
			}
		}
		for (int i_43_ = 0; i_43_ < nrw * ncl; i_43_++) {
			final float f = (float) (0.3 + 1.6 * random.nextDouble());
			ogpx[i_43_][0] = 0;
			ogpz[i_43_][0] = (int) ((100.0 + random.nextDouble() * 760.0) * f);
			ogpx[i_43_][1] = (int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * f);
			ogpz[i_43_][1] = ogpx[i_43_][1];
			ogpx[i_43_][2] = (int) ((100.0 + random.nextDouble() * 760.0) * f);
			ogpz[i_43_][2] = 0;
			ogpx[i_43_][3] = (int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * f);
			ogpz[i_43_][3] = -ogpx[i_43_][3];
			ogpx[i_43_][4] = 0;
			ogpz[i_43_][4] = -(int) ((100.0 + random.nextDouble() * 760.0) * f);
			ogpx[i_43_][5] = -(int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * f);
			ogpz[i_43_][5] = ogpx[i_43_][5];
			ogpx[i_43_][6] = -(int) ((100.0 + random.nextDouble() * 760.0) * f);
			ogpz[i_43_][6] = 0;
			ogpx[i_43_][7] = -(int) ((100.0 + random.nextDouble() * 760.0) * 0.7071 * f);
			ogpz[i_43_][7] = -ogpx[i_43_][7];
			for (int i_44_ = 0; i_44_ < 8; i_44_++) {
				int i_45_ = i_44_ - 1;
				if (i_45_ == -1)
					i_45_ = 7;
				int i_46_ = i_44_ + 1;
				if (i_46_ == 8)
					i_46_ = 0;
				ogpx[i_43_][i_44_] = ((ogpx[i_43_][i_45_] + ogpx[i_43_][i_46_]) / 2 + ogpx[i_43_][i_44_]) / 2;
				ogpz[i_43_][i_44_] = ((ogpz[i_43_][i_45_] + ogpz[i_43_][i_46_]) / 2 + ogpz[i_43_][i_44_]) / 2;
				pvr[i_43_][i_44_] = (float) (1.1 + random.nextDouble() * 0.8);
				final int i_47_ = (int) (Math.sqrt((int) (((ogpx[i_43_][i_44_]) * (ogpx[i_43_][i_44_])
						* (pvr[i_43_][i_44_]) * (pvr[i_43_][i_44_]))
						+ ((ogpz[i_43_][i_44_]) * (ogpz[i_43_][i_44_]) * (pvr[i_43_][i_44_]) * (pvr[i_43_][i_44_])))));
				if (i_47_ > pmx[i_43_])
					pmx[i_43_] = i_47_;
			}
			pcv[i_43_] = (float) (0.97 + random.nextDouble() * 0.03);
			if (pcv[i_43_] > 1.0F)
				pcv[i_43_] = 1.0F;
			if (random.nextDouble() > random.nextDouble())
				pcv[i_43_] = 1.0F;
		}
	}

	public void groundpolys(final Graphics2D graphics2d) {
		int i = (x - sgpx) / 1200 - 12;
		if (i < 0)
			i = 0;
		int i_48_ = i + 25;
		if (i_48_ > nrw)
			i_48_ = nrw;
		if (i_48_ < i)
			i_48_ = i;
		int i_49_ = (z - sgpz) / 1200 - 12;
		if (i_49_ < 0)
			i_49_ = 0;
		int i_50_ = i_49_ + 25;
		if (i_50_ > ncl)
			i_50_ = ncl;
		if (i_50_ < i_49_)
			i_50_ = i_49_;
		final int[][] is = new int[i_48_ - i][i_50_ - i_49_];
		for (int i_51_ = i; i_51_ < i_48_; i_51_++)
			for (int i_52_ = i_49_; i_52_ < i_50_; i_52_++) {
				is[i_51_ - i][i_52_ - i_49_] = 0;
				final int i_53_ = i_51_ + i_52_ * nrw;
				if (resdown < 2 || i_53_ % 2 == 0) {
					final int i_54_ = (cx
							+ (int) (((cgpx[i_53_] - x - cx) * cos(xz)) - ((cgpz[i_53_] - z - cz) * sin(xz))));
					final int i_55_ = (cz
							+ (int) (((cgpx[i_53_] - x - cx) * sin(xz)) + ((cgpz[i_53_] - z - cz) * cos(xz))));
					final int i_56_ = (cz + (int) (((250 - y - cy) * sin(zy)) + ((i_55_ - cz) * cos(zy))));
					if (xs(i_54_ + pmx[i_53_], i_56_) > 0 && (xs(i_54_ - pmx[i_53_], i_56_) < w) && i_56_ > -pmx[i_53_]
							&& i_56_ < fade[2]) {
						is[i_51_ - i][i_52_ - i_49_] = i_56_;
						final int[] is_57_ = new int[8];
						final int[] is_58_ = new int[8];
						final int[] is_59_ = new int[8];
						for (int i_60_ = 0; i_60_ < 8; i_60_++) {
							is_57_[i_60_] = (int) (((ogpx[i_53_][i_60_]) * pvr[i_53_][i_60_]) + cgpx[i_53_] - x);
							is_58_[i_60_] = (int) (((ogpz[i_53_][i_60_]) * pvr[i_53_][i_60_]) + cgpz[i_53_] - z);
							is_59_[i_60_] = ground;
						}
						rot(is_57_, is_58_, cx, cz, xz, 8);
						rot(is_59_, is_58_, cy, cz, zy, 8);
						final int[] is_61_ = new int[8];
						final int[] is_62_ = new int[8];
						int i_63_ = 0;
						int i_64_ = 0;
						int i_65_ = 0;
						int i_66_ = 0;
						boolean bool = true;
						for (int i_67_ = 0; i_67_ < 8; i_67_++) {
							is_61_[i_67_] = xs(is_57_[i_67_], is_58_[i_67_]);
							is_62_[i_67_] = ys(is_59_[i_67_], is_58_[i_67_]);
							if (is_62_[i_67_] < 0 || is_58_[i_67_] < 10)
								i_63_++;
							if (is_62_[i_67_] > h || is_58_[i_67_] < 10)
								i_64_++;
							if (is_61_[i_67_] < 0 || is_58_[i_67_] < 10)
								i_65_++;
							if (is_61_[i_67_] > w || is_58_[i_67_] < 10)
								i_66_++;
						}
						if (i_65_ == 8 || i_63_ == 8 || i_64_ == 8 || i_66_ == 8)
							bool = false;
						if (bool) {
							int i_68_ = (int) (((cpol[0] * pcv[i_53_]) + cgrnd[0]) / 2.0F);
							int i_69_ = (int) (((cpol[1] * pcv[i_53_]) + cgrnd[1]) / 2.0F);
							int i_70_ = (int) (((cpol[2] * pcv[i_53_]) + cgrnd[2]) / 2.0F);
							if (i_56_ - pmx[i_53_] > fade[0]) {
								i_68_ = ((i_68_ * 7 + cfade[0]) / 8);
								i_69_ = ((i_69_ * 7 + cfade[1]) / 8);
								i_70_ = ((i_70_ * 7 + cfade[2]) / 8);
							}
							if (i_56_ - pmx[i_53_] > fade[1]) {
								i_68_ = ((i_68_ * 7 + cfade[0]) / 8);
								i_69_ = ((i_69_ * 7 + cfade[1]) / 8);
								i_70_ = ((i_70_ * 7 + cfade[2]) / 8);
							}
							graphics2d.setColor(new Color(i_68_, i_69_, i_70_));
							graphics2d.fillPolygon(is_61_, is_62_, 8);
						}
					}
				}
			}
		for (int i_71_ = i; i_71_ < i_48_; i_71_++)
			for (int i_72_ = i_49_; i_72_ < i_50_; i_72_++)
				if (is[i_71_ - i][i_72_ - i_49_] != 0) {
					final int i_73_ = i_71_ + i_72_ * nrw;
					final int[] is_74_ = new int[8];
					final int[] is_75_ = new int[8];
					final int[] is_76_ = new int[8];
					for (int i_77_ = 0; i_77_ < 8; i_77_++) {
						is_74_[i_77_] = (ogpx[i_73_][i_77_] + cgpx[i_73_] - x);
						is_75_[i_77_] = (ogpz[i_73_][i_77_] + cgpz[i_73_] - z);
						is_76_[i_77_] = ground;
					}
					rot(is_74_, is_75_, cx, cz, xz, 8);
					rot(is_76_, is_75_, cy, cz, zy, 8);
					final int[] is_78_ = new int[8];
					final int[] is_79_ = new int[8];
					int i_80_ = 0;
					int i_81_ = 0;
					int i_82_ = 0;
					int i_83_ = 0;
					boolean bool = true;
					for (int i_84_ = 0; i_84_ < 8; i_84_++) {
						is_78_[i_84_] = xs(is_74_[i_84_], is_75_[i_84_]);
						is_79_[i_84_] = ys(is_76_[i_84_], is_75_[i_84_]);
						if (is_79_[i_84_] < 0 || is_75_[i_84_] < 10)
							i_80_++;
						if (is_79_[i_84_] > h || is_75_[i_84_] < 10)
							i_81_++;
						if (is_78_[i_84_] < 0 || is_75_[i_84_] < 10)
							i_82_++;
						if (is_78_[i_84_] > w || is_75_[i_84_] < 10)
							i_83_++;
					}
					if (i_82_ == 8 || i_80_ == 8 || i_81_ == 8 || i_83_ == 8)
						bool = false;
					if (bool) {
						int i_85_ = (int) (cpol[0] * pcv[i_73_]);
						int i_86_ = (int) (cpol[1] * pcv[i_73_]);
						int i_87_ = (int) (cpol[2] * pcv[i_73_]);
						if ((is[i_71_ - i][i_72_ - i_49_] - pmx[i_73_]) > fade[0]) {
							i_85_ = (i_85_ * 7 + cfade[0]) / 8;
							i_86_ = (i_86_ * 7 + cfade[1]) / 8;
							i_87_ = (i_87_ * 7 + cfade[2]) / 8;
						}
						if ((is[i_71_ - i][i_72_ - i_49_] - pmx[i_73_]) > fade[1]) {
							i_85_ = (i_85_ * 7 + cfade[0]) / 8;
							i_86_ = (i_86_ * 7 + cfade[1]) / 8;
							i_87_ = (i_87_ * 7 + cfade[2]) / 8;
						}
						graphics2d.setColor(new Color(i_85_, i_86_, i_87_));
						graphics2d.fillPolygon(is_78_, is_79_, 8);
					}
				}
	}

	public void newclouds(int i, int i_88_, int i_89_, int i_90_) {
		clx = null;
		clz = null;
		cmx = null;
		clax = null;
		clay = null;
		claz = null;
		clc = null;
		i = i / 20 - 10000;
		i_88_ = i_88_ / 20 + 10000;
		i_89_ = i_89_ / 20 - 10000;
		i_90_ = i_90_ / 20 + 10000;
		noc = (i_88_ - i) * (i_90_ - i_89_) / 16666667;
		clx = new int[noc];
		clz = new int[noc];
		cmx = new int[noc];
		clax = new int[noc][3][12];
		clay = new int[noc][3][12];
		claz = new int[noc][3][12];
		clc = new int[noc][2][6][3];
		for (int i_91_ = 0; i_91_ < noc; i_91_++) {
			clx[i_91_] = (int) (i + (i_88_ - i) * Math.random());
			clz[i_91_] = (int) (i_89_ + (i_90_ - i_89_) * Math.random());
			final float f = (float) (0.25 + Math.random() * 1.25);
			float f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][0] = (int) (f_92_ * 0.3826);
			claz[i_91_][0][0] = (int) (f_92_ * 0.9238);
			clay[i_91_][0][0] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][1] = (int) (f_92_ * 0.7071);
			claz[i_91_][0][1] = (int) (f_92_ * 0.7071);
			clay[i_91_][0][1] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][2] = (int) (f_92_ * 0.9238);
			claz[i_91_][0][2] = (int) (f_92_ * 0.3826);
			clay[i_91_][0][2] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][3] = (int) (f_92_ * 0.9238);
			claz[i_91_][0][3] = -(int) (f_92_ * 0.3826);
			clay[i_91_][0][3] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][4] = (int) (f_92_ * 0.7071);
			claz[i_91_][0][4] = -(int) (f_92_ * 0.7071);
			clay[i_91_][0][4] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][5] = (int) (f_92_ * 0.3826);
			claz[i_91_][0][5] = -(int) (f_92_ * 0.9238);
			clay[i_91_][0][5] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][6] = -(int) (f_92_ * 0.3826);
			claz[i_91_][0][6] = -(int) (f_92_ * 0.9238);
			clay[i_91_][0][6] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][7] = -(int) (f_92_ * 0.7071);
			claz[i_91_][0][7] = -(int) (f_92_ * 0.7071);
			clay[i_91_][0][7] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][8] = -(int) (f_92_ * 0.9238);
			claz[i_91_][0][8] = -(int) (f_92_ * 0.3826);
			clay[i_91_][0][8] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][9] = -(int) (f_92_ * 0.9238);
			claz[i_91_][0][9] = (int) (f_92_ * 0.3826);
			clay[i_91_][0][9] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][10] = -(int) (f_92_ * 0.7071);
			claz[i_91_][0][10] = (int) (f_92_ * 0.7071);
			clay[i_91_][0][10] = (int) ((25.0 - Math.random() * 50.0) * f);
			f_92_ = (float) ((200.0 + Math.random() * 700.0) * f);
			clax[i_91_][0][11] = -(int) (f_92_ * 0.3826);
			claz[i_91_][0][11] = (int) (f_92_ * 0.9238);
			clay[i_91_][0][11] = (int) ((25.0 - Math.random() * 50.0) * f);
			for (int i_93_ = 0; i_93_ < 12; i_93_++) {
				int i_94_ = i_93_ - 1;
				if (i_94_ == -1)
					i_94_ = 11;
				int i_95_ = i_93_ + 1;
				if (i_95_ == 12)
					i_95_ = 0;
				clax[i_91_][0][i_93_] = ((clax[i_91_][0][i_94_] + clax[i_91_][0][i_95_]) / 2 + clax[i_91_][0][i_93_])
						/ 2;
				clay[i_91_][0][i_93_] = ((clay[i_91_][0][i_94_] + clay[i_91_][0][i_95_]) / 2 + clay[i_91_][0][i_93_])
						/ 2;
				claz[i_91_][0][i_93_] = ((claz[i_91_][0][i_94_] + claz[i_91_][0][i_95_]) / 2 + claz[i_91_][0][i_93_])
						/ 2;
			}
			for (int i_96_ = 0; i_96_ < 12; i_96_++) {
				f_92_ = (float) (1.2 + 0.6 * Math.random());
				clax[i_91_][1][i_96_] = (int) (clax[i_91_][0][i_96_] * f_92_);
				claz[i_91_][1][i_96_] = (int) (claz[i_91_][0][i_96_] * f_92_);
				clay[i_91_][1][i_96_] = (int) (clay[i_91_][0][i_96_] - 100.0 * Math.random());
				f_92_ = (float) (1.1 + 0.3 * Math.random());
				clax[i_91_][2][i_96_] = (int) (clax[i_91_][1][i_96_] * f_92_);
				claz[i_91_][2][i_96_] = (int) (claz[i_91_][1][i_96_] * f_92_);
				clay[i_91_][2][i_96_] = (int) (clay[i_91_][1][i_96_] - 240.0 * Math.random());
			}
			cmx[i_91_] = 0;
			for (int i_97_ = 0; i_97_ < 12; i_97_++) {
				int i_98_ = i_97_ - 1;
				if (i_98_ == -1)
					i_98_ = 11;
				int i_99_ = i_97_ + 1;
				if (i_99_ == 12)
					i_99_ = 0;
				clay[i_91_][1][i_97_] = ((clay[i_91_][1][i_98_] + clay[i_91_][1][i_99_]) / 2 + clay[i_91_][1][i_97_])
						/ 2;
				clay[i_91_][2][i_97_] = ((clay[i_91_][2][i_98_] + clay[i_91_][2][i_99_]) / 2 + clay[i_91_][2][i_97_])
						/ 2;
				final int i_100_ = (int) Math.sqrt(((clax[i_91_][2][i_97_]) * (clax[i_91_][2][i_97_]))
						+ ((claz[i_91_][2][i_97_]) * (claz[i_91_][2][i_97_])));
				if (i_100_ > cmx[i_91_])
					cmx[i_91_] = i_100_;
			}
			for (int i_101_ = 0; i_101_ < 6; i_101_++) {
				final double d = Math.random();
				final double d_102_ = Math.random();
				for (int i_103_ = 0; i_103_ < 3; i_103_++) {
					f_92_ = (clds[i_103_] * 1.05F - clds[i_103_]);
					clc[i_91_][0][i_101_][i_103_] = (int) (clds[i_103_] + f_92_ * d);
					if (clc[i_91_][0][i_101_][i_103_] > 255)
						clc[i_91_][0][i_101_][i_103_] = 255;
					if (clc[i_91_][0][i_101_][i_103_] < 0)
						clc[i_91_][0][i_101_][i_103_] = 0;
					clc[i_91_][1][i_101_][i_103_] = (int) (clds[i_103_] * 1.05F + f_92_ * d_102_);
					if (clc[i_91_][1][i_101_][i_103_] > 255)
						clc[i_91_][1][i_101_][i_103_] = 255;
					if (clc[i_91_][1][i_101_][i_103_] < 0)
						clc[i_91_][1][i_101_][i_103_] = 0;
				}
			}
		}
	}

	public void drawclouds(final Graphics2D graphics2d) {
		for (int i = 0; i < noc; i++) {
			final int i_104_ = (cx + (int) (((clx[i] - x / 20 - cx) * cos(xz)) - ((clz[i] - z / 20 - cz) * sin(xz))));
			final int i_105_ = (cz + (int) (((clx[i] - x / 20 - cx) * sin(xz)) + ((clz[i] - z / 20 - cz) * cos(xz))));
			final int i_106_ = (cz + (int) (((cldd[4] - y / 20 - cy) * sin(zy)) + ((i_105_ - cz) * cos(zy))));
			final int i_107_ = xs(i_104_ + cmx[i], i_106_);
			final int i_108_ = xs(i_104_ - cmx[i], i_106_);
			if (i_107_ > 0 && i_108_ < w && i_106_ > -cmx[i] && i_107_ - i_108_ > 20) {
				final int[][] is = new int[3][12];
				final int[][] is_109_ = new int[3][12];
				final int[][] is_110_ = new int[3][12];
				final int[] is_111_ = new int[12];
				final int[] is_112_ = new int[12];
				boolean bool_116_ = true;
				for (int i_120_ = 0; i_120_ < 3; i_120_++) {
					for (int i_121_ = 0; i_121_ < 12; i_121_++) {
						is[i_120_][i_121_] = (clax[i][i_120_][i_121_] + clx[i] - x / 20);
						is_110_[i_120_][i_121_] = (claz[i][i_120_][i_121_] + clz[i] - z / 20);
						is_109_[i_120_][i_121_] = (clay[i][i_120_][i_121_] + cldd[4] - y / 20);
					}
					rot(is[i_120_], is_110_[i_120_], cx, cz, xz, 12);
					rot(is_109_[i_120_], is_110_[i_120_], cy, cz, zy, 12);
				}
				for (int i_122_ = 0; i_122_ < 12; i_122_ += 2) {
					int i_123_ = 0;
					int i_124_ = 0;
					int i_125_ = 0;
					int i_126_ = 0;
					bool_116_ = true;
					int i_127_ = 0;
					int i_128_ = 0;
					int i_129_ = 0;
					for (int i_130_ = 0; i_130_ < 6; i_130_++) {
						int i_131_ = 0;
						int i_132_ = 1;
						if (i_130_ == 0)
							i_131_ = i_122_;
						if (i_130_ == 1) {
							i_131_ = i_122_ + 1;
							if (i_131_ >= 12)
								i_131_ -= 12;
						}
						if (i_130_ == 2) {
							i_131_ = i_122_ + 2;
							if (i_131_ >= 12)
								i_131_ -= 12;
						}
						if (i_130_ == 3) {
							i_131_ = i_122_ + 2;
							if (i_131_ >= 12)
								i_131_ -= 12;
							i_132_ = 2;
						}
						if (i_130_ == 4) {
							i_131_ = i_122_ + 1;
							if (i_131_ >= 12)
								i_131_ -= 12;
							i_132_ = 2;
						}
						if (i_130_ == 5) {
							i_131_ = i_122_;
							i_132_ = 2;
						}
						is_111_[i_130_] = xs(is[i_132_][i_131_], is_110_[i_132_][i_131_]);
						is_112_[i_130_] = ys(is_109_[i_132_][i_131_], is_110_[i_132_][i_131_]);
						i_128_ += is[i_132_][i_131_];
						i_127_ += is_109_[i_132_][i_131_];
						i_129_ += is_110_[i_132_][i_131_];
						if (is_112_[i_130_] < 0 || is_110_[0][i_130_] < 10)
							i_123_++;
						if (is_112_[i_130_] > h || is_110_[0][i_130_] < 10)
							i_124_++;
						if (is_111_[i_130_] < 0 || is_110_[0][i_130_] < 10)
							i_125_++;
						if (is_111_[i_130_] > w || is_110_[0][i_130_] < 10)
							i_126_++;
					}
					if (i_125_ == 6 || i_123_ == 6 || i_124_ == 6 || i_126_ == 6)
						bool_116_ = false;
					if (bool_116_) {
						i_128_ /= 6;
						i_127_ /= 6;
						i_129_ /= 6;
						final int i_133_ = (int) Math.sqrt(
								((cy - i_127_) * (cy - i_127_)) + ((cx - i_128_) * ((cx) - i_128_)) + i_129_ * i_129_);
						if (i_133_ < fade[7]) {
							int i_134_ = clc[i][1][i_122_ / 2][0];
							int i_135_ = clc[i][1][i_122_ / 2][1];
							int i_136_ = clc[i][1][i_122_ / 2][2];
							for (int i_137_ = 0; i_137_ < 16; i_137_++)
								if (i_133_ > fade[i_137_]) {
									i_134_ = ((i_134_ * fogd + cfade[0]) / (fogd + 1));
									i_135_ = ((i_135_ * fogd + cfade[1]) / (fogd + 1));
									i_136_ = ((i_136_ * fogd + cfade[2]) / (fogd + 1));
								}
							graphics2d.setColor(new Color(i_134_, i_135_, i_136_));
							graphics2d.fillPolygon(is_111_, is_112_, 6);
						}
					}
				}
				for (int i_138_ = 0; i_138_ < 12; i_138_ += 2) {
					int i_139_ = 0;
					int i_140_ = 0;
					int i_141_ = 0;
					int i_142_ = 0;
					bool_116_ = true;
					int i_143_ = 0;
					int i_144_ = 0;
					int i_145_ = 0;
					for (int i_146_ = 0; i_146_ < 6; i_146_++) {
						int i_147_ = 0;
						int i_148_ = 0;
						if (i_146_ == 0)
							i_147_ = i_138_;
						if (i_146_ == 1) {
							i_147_ = i_138_ + 1;
							if (i_147_ >= 12)
								i_147_ -= 12;
						}
						if (i_146_ == 2) {
							i_147_ = i_138_ + 2;
							if (i_147_ >= 12)
								i_147_ -= 12;
						}
						if (i_146_ == 3) {
							i_147_ = i_138_ + 2;
							if (i_147_ >= 12)
								i_147_ -= 12;
							i_148_ = 1;
						}
						if (i_146_ == 4) {
							i_147_ = i_138_ + 1;
							if (i_147_ >= 12)
								i_147_ -= 12;
							i_148_ = 1;
						}
						if (i_146_ == 5) {
							i_147_ = i_138_;
							i_148_ = 1;
						}
						is_111_[i_146_] = xs(is[i_148_][i_147_], is_110_[i_148_][i_147_]);
						is_112_[i_146_] = ys(is_109_[i_148_][i_147_], is_110_[i_148_][i_147_]);
						i_144_ += is[i_148_][i_147_];
						i_143_ += is_109_[i_148_][i_147_];
						i_145_ += is_110_[i_148_][i_147_];
						if (is_112_[i_146_] < 0 || is_110_[0][i_146_] < 10)
							i_139_++;
						if (is_112_[i_146_] > h || is_110_[0][i_146_] < 10)
							i_140_++;
						if (is_111_[i_146_] < 0 || is_110_[0][i_146_] < 10)
							i_141_++;
						if (is_111_[i_146_] > w || is_110_[0][i_146_] < 10)
							i_142_++;
					}
					if (i_141_ == 6 || i_139_ == 6 || i_140_ == 6 || i_142_ == 6)
						bool_116_ = false;
					if (bool_116_) {
						i_144_ /= 6;
						i_143_ /= 6;
						i_145_ /= 6;
						final int i_149_ = (int) Math.sqrt(
								((cy - i_143_) * (cy - i_143_)) + ((cx - i_144_) * ((cx) - i_144_)) + i_145_ * i_145_);
						if (i_149_ < fade[7]) {
							int i_150_ = clc[i][0][i_138_ / 2][0];
							int i_151_ = clc[i][0][i_138_ / 2][1];
							int i_152_ = clc[i][0][i_138_ / 2][2];
							for (int i_153_ = 0; i_153_ < 16; i_153_++)
								if (i_149_ > fade[i_153_]) {
									i_150_ = ((i_150_ * fogd + cfade[0]) / (fogd + 1));
									i_151_ = ((i_151_ * fogd + cfade[1]) / (fogd + 1));
									i_152_ = ((i_152_ * fogd + cfade[2]) / (fogd + 1));
								}
							graphics2d.setColor(new Color(i_150_, i_151_, i_152_));
							graphics2d.fillPolygon(is_111_, is_112_, 6);
						}
					}
				}
				int i_154_ = 0;
				int i_155_ = 0;
				int i_156_ = 0;
				int i_157_ = 0;
				bool_116_ = true;
				int i_158_ = 0;
				int i_159_ = 0;
				int i_160_ = 0;
				for (int i_161_ = 0; i_161_ < 12; i_161_++) {
					is_111_[i_161_] = xs(is[0][i_161_], is_110_[0][i_161_]);
					is_112_[i_161_] = ys(is_109_[0][i_161_], is_110_[0][i_161_]);
					i_159_ += is[0][i_161_];
					i_158_ += is_109_[0][i_161_];
					i_160_ += is_110_[0][i_161_];
					if (is_112_[i_161_] < 0 || is_110_[0][i_161_] < 10)
						i_154_++;
					if (is_112_[i_161_] > h || is_110_[0][i_161_] < 10)
						i_155_++;
					if (is_111_[i_161_] < 0 || is_110_[0][i_161_] < 10)
						i_156_++;
					if (is_111_[i_161_] > w || is_110_[0][i_161_] < 10)
						i_157_++;
				}
				if (i_156_ == 12 || i_154_ == 12 || i_155_ == 12 || i_157_ == 12)
					bool_116_ = false;
				if (bool_116_) {
					i_159_ /= 12;
					i_158_ /= 12;
					i_160_ /= 12;
					final int i_162_ = (int) Math
							.sqrt(((cy - i_158_) * (cy - i_158_)) + ((cx - i_159_) * (cx - i_159_)) + i_160_ * i_160_);
					if (i_162_ < fade[7]) {
						int i_163_ = clds[0];
						int i_164_ = clds[1];
						int i_165_ = clds[2];
						for (int i_166_ = 0; i_166_ < 16; i_166_++)
							if (i_162_ > fade[i_166_]) {
								i_163_ = ((i_163_ * fogd + cfade[0]) / (fogd + 1));
								i_164_ = ((i_164_ * fogd + cfade[1]) / (fogd + 1));
								i_165_ = ((i_165_ * fogd + cfade[2]) / (fogd + 1));
							}
						graphics2d.setColor(new Color(i_163_, i_164_, i_165_));
						graphics2d.fillPolygon(is_111_, is_112_, 12);
					}
				}
			}
		}
	}

	public void newmountains(final int i, final int i_167_, final int i_168_, final int i_169_) {
		final Random random = new Random(mgen);
		nmt = (int) (20.0 + 10.0 * random.nextDouble());
		final int i_170_ = (i + i_167_) / 60;
		final int i_171_ = (i_168_ + i_169_) / 60;
		final int i_172_ = Math.max(i_167_ - i, i_169_ - i_168_) / 60;
		mrd = null;
		nmv = null;
		mtx = null;
		mty = null;
		mtz = null;
		mtc = null;
		mrd = new int[nmt];
		nmv = new int[nmt];
		mtx = new int[nmt][];
		mty = new int[nmt][];
		mtz = new int[nmt][];
		mtc = new int[nmt][][];
		final int[] is = new int[nmt];
		final int[] is_173_ = new int[nmt];
		for (int i_174_ = 0; i_174_ < nmt; i_174_++) {
			int i_175_ = 85;
			float f = 0.5F;
			float f_176_ = 0.5F;
			is[i_174_] = (int) (10000.0 + random.nextDouble() * 10000.0);
			final int i_177_ = (int) (random.nextDouble() * 360.0);
			if (random.nextDouble() > random.nextDouble()) {
				f = (float) (0.2 + random.nextDouble() * 0.35);
				f_176_ = (float) (0.2 + random.nextDouble() * 0.35);
				nmv[i_174_] = (int) (f * (24.0 + 16.0 * random.nextDouble()));
				i_175_ = (int) (85.0 + 10.0 * random.nextDouble());
			} else {
				f = (float) (0.3 + random.nextDouble() * 1.1);
				f_176_ = (float) (0.2 + random.nextDouble() * 0.35);
				nmv[i_174_] = (int) (f * (12.0 + 8.0 * random.nextDouble()));
				i_175_ = (int) (104.0 - 10.0 * random.nextDouble());
			}
			mtx[i_174_] = new int[nmv[i_174_] * 2];
			mty[i_174_] = new int[nmv[i_174_] * 2];
			mtz[i_174_] = new int[nmv[i_174_] * 2];
			mtc[i_174_] = new int[nmv[i_174_]][3];
			for (int i_178_ = 0; i_178_ < nmv[i_174_]; i_178_++) {
				mtx[i_174_][i_178_] = (int) ((i_178_ * 500 + (random.nextDouble() * 800.0 - 400.0)
						- 250 * (nmv[i_174_] - 1)) * f);
				mtx[i_174_][(i_178_ + nmv[i_174_])] = (int) ((i_178_ * 500 + (random.nextDouble() * 800.0 - 400.0)
						- 250 * (nmv[i_174_] - 1)) * f);
				mtx[i_174_][nmv[i_174_]] = (int) (mtx[i_174_][0] - ((100.0 + random.nextDouble() * 600.0) * f));
				mtx[i_174_][(nmv[i_174_] * 2 - 1)] = (int) ((mtx[i_174_][nmv[i_174_] - 1])
						+ ((100.0 + random.nextDouble() * 600.0) * f));
				if (i_178_ == 0 || i_178_ == nmv[i_174_] - 1)
					mty[i_174_][i_178_] = (int) (((-400.0 - 1200.0 * random.nextDouble()) * f_176_) + ground);
				if (i_178_ == 1 || i_178_ == nmv[i_174_] - 2)
					mty[i_174_][i_178_] = (int) (((-1000.0 - 1450.0 * random.nextDouble()) * f_176_) + ground);
				if (i_178_ > 1 && i_178_ < nmv[i_174_] - 2)
					mty[i_174_][i_178_] = (int) (((-1600.0 - 1700.0 * random.nextDouble()) * f_176_) + ground);
				mty[i_174_][(i_178_ + nmv[i_174_])] = ground - 70;
				mtz[i_174_][i_178_] = i_171_ + i_172_ + is[i_174_];
				mtz[i_174_][(i_178_ + nmv[i_174_])] = i_171_ + i_172_ + is[i_174_];
				final float f_179_ = (float) (0.5 + random.nextDouble() * 0.5);
				mtc[i_174_][i_178_][0] = (int) (170.0F * f_179_ + (170.0F * f_179_ * (snap[0] / 100.0F)));
				if (mtc[i_174_][i_178_][0] > 255)
					mtc[i_174_][i_178_][0] = 255;
				if (mtc[i_174_][i_178_][0] < 0)
					mtc[i_174_][i_178_][0] = 0;
				mtc[i_174_][i_178_][1] = (int) (i_175_ * f_179_ + (85.0F * f_179_ * (snap[1] / 100.0F)));
				if (mtc[i_174_][i_178_][1] > 255)
					mtc[i_174_][i_178_][1] = 255;
				if (mtc[i_174_][i_178_][1] < 1)
					mtc[i_174_][i_178_][1] = 0;
				mtc[i_174_][i_178_][2] = 0;
			}
			for (int i_180_ = 1; i_180_ < nmv[i_174_] - 1; i_180_++) {
				final int i_181_ = i_180_ - 1;
				final int i_182_ = i_180_ + 1;
				mty[i_174_][i_180_] = ((mty[i_174_][i_181_] + mty[i_174_][i_182_]) / 2 + mty[i_174_][i_180_]) / 2;
			}
			rot(mtx[i_174_], mtz[i_174_], i_170_, i_171_, i_177_, nmv[i_174_] * 2);
			is_173_[i_174_] = 0;
		}
		for (int i_183_ = 0; i_183_ < nmt; i_183_++) {
			for (int i_184_ = i_183_ + 1; i_184_ < nmt; i_184_++)
				if (is[i_183_] < is[i_184_])
					is_173_[i_183_]++;
				else
					is_173_[i_184_]++;
			mrd[is_173_[i_183_]] = i_183_;
		}
	}

	public void drawmountains(final Graphics2D graphics2d) {
		for (int i = 0; i < nmt; i++) {
			final int i_185_ = mrd[i];
			final int i_186_ = (cx
					+ (int) (((mtx[i_185_][0] - x / 30 - cx) * cos(xz)) - ((mtz[i_185_][0] - z / 30 - cz) * sin(xz))));
			final int i_187_ = (cz
					+ (int) (((mtx[i_185_][0] - x / 30 - cx) * sin(xz)) + ((mtz[i_185_][0] - z / 30 - cz) * cos(xz))));
			final int i_188_ = (cz + (int) (((mty[i_185_][0] - y / 30 - cy) * sin(zy)) + ((i_187_ - cz) * cos(zy))));
			final int i_189_ = (cx + (int) ((((mtx[i_185_][nmv[i_185_] - 1]) - x / 30 - cx) * cos(xz))
					- (((mtz[i_185_][nmv[i_185_] - 1]) - z / 30 - cz) * sin(xz))));
			final int i_190_ = (cz + (int) ((((mtx[i_185_][nmv[i_185_] - 1]) - x / 30 - cx) * sin(xz))
					+ (((mtz[i_185_][nmv[i_185_] - 1]) - z / 30 - cz) * cos(xz))));
			final int i_191_ = (cz
					+ (int) ((((mty[i_185_][nmv[i_185_] - 1]) - y / 30 - cy) * sin(zy)) + ((i_190_ - cz) * cos(zy))));
			if (xs(i_189_, i_191_) > 0 && xs(i_186_, i_188_) < w) {
				final int[] is = new int[nmv[i_185_] * 2];
				final int[] is_192_ = new int[nmv[i_185_] * 2];
				final int[] is_193_ = new int[nmv[i_185_] * 2];
				for (int i_194_ = 0; i_194_ < nmv[i_185_] * 2; i_194_++) {
					is[i_194_] = (mtx[i_185_][i_194_] - x / 30);
					is_192_[i_194_] = (mty[i_185_][i_194_] - y / 30);
					is_193_[i_194_] = (mtz[i_185_][i_194_] - z / 30);
				}
				final int i_195_ = (int) (Math.sqrt((is[nmv[i_185_] / 4] * is[nmv[i_185_] / 4])
						+ ((is_193_[nmv[i_185_] / 4]) * is_193_[(nmv[i_185_]) / 4])));
				rot(is, is_193_, cx, cz, xz, nmv[i_185_] * 2);
				rot(is_192_, is_193_, cy, cz, zy, nmv[i_185_] * 2);
				final int[] is_196_ = new int[4];
				final int[] is_197_ = new int[4];
				boolean bool_201_ = true;
				for (int i_202_ = 0; i_202_ < nmv[i_185_] - 1; i_202_++) {
					int i_203_ = 0;
					int i_204_ = 0;
					int i_205_ = 0;
					int i_206_ = 0;
					bool_201_ = true;
					for (int i_207_ = 0; i_207_ < 4; i_207_++) {
						int i_208_ = i_207_ + i_202_;
						if (i_207_ == 2)
							i_208_ = i_202_ + nmv[i_185_] + 1;
						if (i_207_ == 3)
							i_208_ = i_202_ + nmv[i_185_];
						is_196_[i_207_] = xs(is[i_208_], is_193_[i_208_]);
						is_197_[i_207_] = ys(is_192_[i_208_], is_193_[i_208_]);
						if (is_197_[i_207_] < 0 || is_193_[i_208_] < 10)
							i_203_++;
						if (is_197_[i_207_] > h || is_193_[i_208_] < 10)
							i_204_++;
						if (is_196_[i_207_] < 0 || is_193_[i_208_] < 10)
							i_205_++;
						if (is_196_[i_207_] > w || is_193_[i_208_] < 10)
							i_206_++;
					}
					if (i_205_ == 4 || i_203_ == 4 || i_204_ == 4 || i_206_ == 4)
						bool_201_ = false;
					if (bool_201_) {
						float f = (i_195_ / 2500.0F + ((8000.0F - fade[0]) / 1000.0F) - 2.0F
								- (Math.abs(y) - 250.0F) / 5000.0F);
						if (f > 0.0F && f < 10.0F) {
							if (f < 3.5)
								f = 3.5F;
							final int i_209_ = (int) (((mtc[i_185_][i_202_][0]) + cgrnd[0] + csky[0] * f
									+ (cfade[0] * f)) / (2.0F + f * 2.0F));
							final int i_210_ = (int) (((mtc[i_185_][i_202_][1]) + cgrnd[1] + csky[1] * f
									+ (cfade[1] * f)) / (2.0F + f * 2.0F));
							final int i_211_ = (int) (((mtc[i_185_][i_202_][2]) + cgrnd[2] + csky[2] * f
									+ (cfade[2] * f)) / (2.0F + f * 2.0F));
							graphics2d.setColor(new Color(i_209_, i_210_, i_211_));
							graphics2d.fillPolygon(is_196_, is_197_, 4);
						}
					}
				}
			}
		}
	}

	public void newstars() {
		stx = null;
		stz = null;
		stc = null;
		bst = null;
		twn = null;
		nst = 0;
		if (lightson) {
			final Random random = new Random((long) (Math.random() * 100000.0));
			nst = 40;
			stx = new int[nst];
			stz = new int[nst];
			stc = new int[nst][2][3];
			bst = new boolean[nst];
			twn = new int[nst];
			for (int i = 0; i < nst; i++) {
				stx[i] = (int) (2000.0 * random.nextDouble() - 1000.0);
				stz[i] = (int) (2000.0 * random.nextDouble() - 1000.0);
				int i_212_ = (int) (3.0 * random.nextDouble());
				if (i_212_ >= 3)
					i_212_ = 0;
				if (i_212_ <= -1)
					i_212_ = 2;
				int i_213_ = i_212_ + 1;
				if (random.nextDouble() > random.nextDouble())
					i_213_ = i_212_ - 1;
				if (i_213_ == 3)
					i_213_ = 0;
				if (i_213_ == -1)
					i_213_ = 2;
				for (int i_214_ = 0; i_214_ < 3; i_214_++) {
					stc[i][0][i_214_] = 200;
					if (i_212_ == i_214_)
						stc[i][0][i_214_] += (int) (55.0 * random.nextDouble());
					if (i_213_ == i_214_)
						stc[i][0][i_214_] += 55;
					stc[i][0][i_214_] = (stc[i][0][i_214_] * 2 + csky[i_214_]) / 3;
					stc[i][1][i_214_] = (stc[i][0][i_214_] + csky[i_214_]) / 2;
				}
				twn[i] = (int) (4.0 * random.nextDouble());
				if (random.nextDouble() > 0.8)
					bst[i] = true;
				else
					bst[i] = false;
			}
		}
	}

	public void drawstars(final Graphics2D graphics2d) {
		for (int i = 0; i < nst; i++) {
			int i_215_ = cx + (int) ((stx[i] * cos(xz)) - (stz[i] * sin(xz)));
			final int i_216_ = cz + (int) ((stx[i] * sin(xz)) + (stz[i] * cos(xz)));
			int i_217_ = (cy + (int) (-200.0F * cos(zy) - i_216_ * sin(zy)));
			final int i_218_ = (cz + (int) (-200.0F * sin(zy) + i_216_ * cos(zy)));
			i_215_ = xs(i_215_, i_218_);
			i_217_ = ys(i_217_, i_218_);
			if (i_215_ - 1 > iw && i_215_ + 3 < w && i_217_ - 1 > ih && i_217_ + 3 < h) {
				if (twn[i] == 0) {
					int i_219_ = (int) (3.0 * Math.random());
					if (i_219_ >= 3)
						i_219_ = 0;
					if (i_219_ <= -1)
						i_219_ = 2;
					int i_220_ = i_219_ + 1;
					if (Math.random() > Math.random())
						i_220_ = i_219_ - 1;
					if (i_220_ == 3)
						i_220_ = 0;
					if (i_220_ == -1)
						i_220_ = 2;
					for (int i_221_ = 0; i_221_ < 3; i_221_++) {
						stc[i][0][i_221_] = 200;
						if (i_219_ == i_221_)
							stc[i][0][i_221_] += (int) (55.0 * Math.random());
						if (i_220_ == i_221_)
							stc[i][0][i_221_] += 55;
						stc[i][0][i_221_] = (stc[i][0][i_221_] * 2 + csky[i_221_]) / 3;
						stc[i][1][i_221_] = (stc[i][0][i_221_] + csky[i_221_]) / 2;
					}
					twn[i] = 3;
				} else
					twn[i]--;
				int i_222_ = 0;
				if (bst[i])
					i_222_ = 1;
				graphics2d.setColor(new Color(stc[i][1][0], stc[i][1][1], stc[i][1][2]));
				graphics2d.fillRect(i_215_ - 1, i_217_, 3 + i_222_, 1 + i_222_);
				graphics2d.fillRect(i_215_, i_217_ - 1, 1 + i_222_, 3 + i_222_);
				graphics2d.setColor(new Color(stc[i][0][0], stc[i][0][1], stc[i][0][2]));
				graphics2d.fillRect(i_215_, i_217_, 1 + i_222_, 1 + i_222_);
			}
		}
	}

	public void d(final Graphics2D graphics2d) {
		nsp = 0;
		if (zy > 90)
			zy = 90;
		if (zy < -90)
			zy = -90;
		if (xz > 360)
			xz -= 360;
		if (xz < 0)
			xz += 360;
		if (y > 0)
			y = 0;
		ground = 250 - y;
		final int[] is = new int[4];
		final int[] is_223_ = new int[4];
		int i = cgrnd[0];
		int i_224_ = cgrnd[1];
		int i_225_ = cgrnd[2];
		int i_226_ = crgrnd[0];
		int i_227_ = crgrnd[1];
		int i_228_ = crgrnd[2];
		int i_229_ = h;
		for (int i_230_ = 0; i_230_ < 16; i_230_++) {
			int i_231_ = fade[i_230_];
			int i_232_ = ground;
			if (zy != 0) {
				i_232_ = (cy + (int) (((ground - cy) * cos(zy)) - ((fade[i_230_] - cz) * sin(zy))));
				i_231_ = (cz + (int) (((ground - cy) * sin(zy)) + ((fade[i_230_] - cz) * cos(zy))));
			}
			is[0] = iw;
			is_223_[0] = ys(i_232_, i_231_);
			if (is_223_[0] < ih)
				is_223_[0] = ih;
			if (is_223_[0] > h)
				is_223_[0] = h;
			is[1] = iw;
			is_223_[1] = i_229_;
			is[2] = w;
			is_223_[2] = i_229_;
			is[3] = w;
			is_223_[3] = is_223_[0];
			i_229_ = is_223_[0];
			if (i_230_ > 0) {
				i_226_ = (i_226_ * 7 + cfade[0]) / 8;
				i_227_ = (i_227_ * 7 + cfade[1]) / 8;
				i_228_ = (i_228_ * 7 + cfade[2]) / 8;
				if (i_230_ < 3) {
					i = (i * 7 + cfade[0]) / 8;
					i_224_ = (i_224_ * 7 + cfade[1]) / 8;
					i_225_ = (i_225_ * 7 + cfade[2]) / 8;
				} else {
					i = i_226_;
					i_224_ = i_227_;
					i_225_ = i_228_;
				}
			}
			if (is_223_[0] < h && is_223_[1] > ih) {
				graphics2d.setColor(new Color(i, i_224_, i_225_));
				graphics2d.fillPolygon(is, is_223_, 4);
			}
		}
		if (lightn != -1 && lton) {
			if (lightn < 16) {
				if (lilo > lightn + 217)
					lilo -= 3;
				else
					lightn = (int) (16.0F + 16.0F * random());
			} else if (lilo < lightn + 217)
				lilo += 7;
			else
				lightn = (int) (16.0F * random());
			csky[0] = (int) (lilo + (lilo * (snap[0] / 100.0F)));
			if (csky[0] > 255)
				csky[0] = 255;
			if (csky[0] < 0)
				csky[0] = 0;
			csky[1] = (int) (lilo + (lilo * (snap[1] / 100.0F)));
			if (csky[1] > 255)
				csky[1] = 255;
			if (csky[1] < 0)
				csky[1] = 0;
			csky[2] = (int) (lilo + (lilo * (snap[2] / 100.0F)));
			if (csky[2] > 255)
				csky[2] = 255;
			if (csky[2] < 0)
				csky[2] = 0;
		}
		i = csky[0];
		i_224_ = csky[1];
		i_225_ = csky[2];
		int i_233_ = i;
		int i_234_ = i_224_;
		int i_235_ = i_225_;
		int i_236_ = (cy + (int) (((skyline - 700 - cy) * cos(zy)) - ((7000 - cz) * sin(zy))));
		final int i_237_ = (cz + (int) (((skyline - 700 - cy) * sin(zy)) + ((7000 - cz) * cos(zy))));
		i_236_ = ys(i_236_, i_237_);
		int i_238_ = ih;
		for (int i_239_ = 0; i_239_ < 16; i_239_++) {
			int i_240_ = fade[i_239_];
			int i_241_ = skyline;
			if (zy != 0) {
				i_241_ = (cy + (int) (((skyline - cy) * cos(zy)) - ((fade[i_239_] - cz) * sin(zy))));
				i_240_ = (cz + (int) (((skyline - cy) * sin(zy)) + ((fade[i_239_] - cz) * cos(zy))));
			}
			is[0] = iw;
			is_223_[0] = ys(i_241_, i_240_);
			if (is_223_[0] > h)
				is_223_[0] = h;
			if (is_223_[0] < ih)
				is_223_[0] = ih;
			is[1] = iw;
			is_223_[1] = i_238_;
			is[2] = w;
			is_223_[2] = i_238_;
			is[3] = w;
			is_223_[3] = is_223_[0];
			i_238_ = is_223_[0];
			if (i_239_ > 0) {
				i = (i * 7 + cfade[0]) / 8;
				i_224_ = (i_224_ * 7 + cfade[1]) / 8;
				i_225_ = (i_225_ * 7 + cfade[2]) / 8;
			}
			if (is_223_[1] < i_236_) {
				i_233_ = i;
				i_234_ = i_224_;
				i_235_ = i_225_;
			}
			if (is_223_[0] > ih && is_223_[1] < h) {
				graphics2d.setColor(new Color(i, i_224_, i_225_));
				graphics2d.fillPolygon(is, is_223_, 4);
			}
		}
		is[0] = iw;
		is_223_[0] = i_238_;
		is[1] = iw;
		is_223_[1] = i_229_;
		is[2] = w;
		is_223_[2] = i_229_;
		is[3] = w;
		is_223_[3] = i_238_;
		if (is_223_[0] < h && is_223_[1] > ih) {
			float f = ((Math.abs(y) - 250.0F) / (fade[0] * 2));
			if (f < 0.0F)
				f = 0.0F;
			if (f > 1.0F)
				f = 1.0F;
			i = (int) ((i * (1.0F - f) + i_226_ * (1.0F + f)) / 2.0F);
			i_224_ = (int) ((i_224_ * (1.0F - f) + i_227_ * (1.0F + f)) / 2.0F);
			i_225_ = (int) ((i_225_ * (1.0F - f) + i_228_ * (1.0F + f)) / 2.0F);
			graphics2d.setColor(new Color(i, i_224_, i_225_));
			graphics2d.fillPolygon(is, is_223_, 4);
		}
		if (resdown != 2) {
			for (int i_242_ = 1; i_242_ < 20; i_242_++) {
				int i_243_ = 7000;
				int i_244_ = skyline - 700 - i_242_ * 70;
				if (zy != 0 && i_242_ != 19) {
					i_244_ = (cy + (int) (((skyline - 700 - i_242_ * 70 - cy) * cos(zy)) - ((7000 - cz) * sin(zy))));
					i_243_ = (cz + (int) (((skyline - 700 - i_242_ * 70 - cy) * sin(zy)) + ((7000 - cz) * cos(zy))));
				}
				is[0] = iw;
				if (i_242_ != 19) {
					is_223_[0] = ys(i_244_, i_243_);
					if (is_223_[0] > h)
						is_223_[0] = h;
					if (is_223_[0] < ih)
						is_223_[0] = ih;
				} else
					is_223_[0] = ih;
				is[1] = iw;
				is_223_[1] = i_236_;
				is[2] = w;
				is_223_[2] = i_236_;
				is[3] = w;
				is_223_[3] = is_223_[0];
				i_236_ = is_223_[0];
				i_233_ *= 0.991;
				i_234_ *= 0.991;
				i_235_ *= 0.998;
				if (is_223_[1] > ih && is_223_[0] < h) {
					graphics2d.setColor(new Color(i_233_, i_234_, i_235_));
					graphics2d.fillPolygon(is, is_223_, 4);
				}
			}
			if (lightson)
				drawstars(graphics2d);
			drawmountains(graphics2d);
			drawclouds(graphics2d);
		}
		groundpolys(graphics2d);
		if (noelec != 0)
			noelec--;
		if (cpflik)
			cpflik = false;
		else {
			cpflik = true;
			elecr = random() * 15.0F - 6.0F;
		}
	}

	public void addsp(final int i, final int i_245_, final int i_246_) {
		if (nsp != 7) {
			spx[nsp] = i;
			spz[nsp] = i_245_;
			sprad[nsp] = i_246_;
			nsp++;
		}
	}

	public void setsnap(final int i, final int i_247_, final int i_248_) {
		snap[0] = i;
		snap[1] = i_247_;
		snap[2] = i_248_;
	}

	public void setsky(final int i, final int i_249_, final int i_250_) {
		osky[0] = i;
		osky[1] = i_249_;
		osky[2] = i_250_;
		for (int i_251_ = 0; i_251_ < 3; i_251_++) {
			clds[i_251_] = ((osky[i_251_] * cldd[3] + cldd[i_251_]) / (cldd[3] + 1));
			clds[i_251_] = (int) (clds[i_251_] + (clds[i_251_] * (snap[i_251_] / 100.0F)));
			if (clds[i_251_] > 255)
				clds[i_251_] = 255;
			if (clds[i_251_] < 0)
				clds[i_251_] = 0;
		}
		csky[0] = (int) (i + i * (snap[0] / 100.0F));
		if (csky[0] > 255)
			csky[0] = 255;
		if (csky[0] < 0)
			csky[0] = 0;
		csky[1] = (int) (i_249_ + i_249_ * (snap[1] / 100.0F));
		if (csky[1] > 255)
			csky[1] = 255;
		if (csky[1] < 0)
			csky[1] = 0;
		csky[2] = (int) (i_250_ + i_250_ * (snap[2] / 100.0F));
		if (csky[2] > 255)
			csky[2] = 255;
		if (csky[2] < 0)
			csky[2] = 0;
		final float[] fs = new float[3];
		Color.RGBtoHSB(csky[0], csky[1], csky[2], fs);
		if (fs[2] < 0.6)
			darksky = true;
		else
			darksky = false;
	}

	public void setcloads(final int i, final int i_252_, final int i_253_, int i_254_, int i_255_) {
		if (i_254_ < 0)
			i_254_ = 0;
		if (i_254_ > 10)
			i_254_ = 10;
		if (i_255_ < -1500)
			i_255_ = -1500;
		if (i_255_ > -500)
			i_255_ = -500;
		cldd[0] = i;
		cldd[1] = i_252_;
		cldd[2] = i_253_;
		cldd[3] = i_254_;
		cldd[4] = i_255_;
		for (int i_256_ = 0; i_256_ < 3; i_256_++) {
			clds[i_256_] = ((osky[i_256_] * cldd[3] + cldd[i_256_]) / (cldd[3] + 1));
			clds[i_256_] = (int) (clds[i_256_] + (clds[i_256_] * (snap[i_256_] / 100.0F)));
			if (clds[i_256_] > 255)
				clds[i_256_] = 255;
			if (clds[i_256_] < 0)
				clds[i_256_] = 0;
		}
	}

	public void setgrnd(final int i, final int i_257_, final int i_258_) {
		ogrnd[0] = i;
		ogrnd[1] = i_257_;
		ogrnd[2] = i_258_;
		for (int i_259_ = 0; i_259_ < 3; i_259_++) {
			cpol[i_259_] = ((ogrnd[i_259_] * texture[3] + texture[i_259_]) / (1 + texture[3]));
			cpol[i_259_] = (int) (cpol[i_259_] + (cpol[i_259_] * (snap[i_259_] / 100.0F)));
			if (cpol[i_259_] > 255)
				cpol[i_259_] = 255;
			if (cpol[i_259_] < 0)
				cpol[i_259_] = 0;
		}
		cgrnd[0] = (int) (i + i * (snap[0] / 100.0F));
		if (cgrnd[0] > 255)
			cgrnd[0] = 255;
		if (cgrnd[0] < 0)
			cgrnd[0] = 0;
		cgrnd[1] = (int) (i_257_ + i_257_ * (snap[1] / 100.0F));
		if (cgrnd[1] > 255)
			cgrnd[1] = 255;
		if (cgrnd[1] < 0)
			cgrnd[1] = 0;
		cgrnd[2] = (int) (i_258_ + i_258_ * (snap[2] / 100.0F));
		if (cgrnd[2] > 255)
			cgrnd[2] = 255;
		if (cgrnd[2] < 0)
			cgrnd[2] = 0;
		for (int i_260_ = 0; i_260_ < 3; i_260_++)
			crgrnd[i_260_] = (int) ((cpol[i_260_] * 0.99 + cgrnd[i_260_]) / 2.0);
	}

	public void setexture(int i, int i_261_, int i_262_, int i_263_) {
		if (i_263_ < 20)
			i_263_ = 20;
		if (i_263_ > 60)
			i_263_ = 60;
		texture[0] = i;
		texture[1] = i_261_;
		texture[2] = i_262_;
		texture[3] = i_263_;
		i = (ogrnd[0] * i_263_ + i) / (1 + i_263_);
		i_261_ = (ogrnd[1] * i_263_ + i_261_) / (1 + i_263_);
		i_262_ = (ogrnd[2] * i_263_ + i_262_) / (1 + i_263_);
		cpol[0] = (int) (i + i * (snap[0] / 100.0F));
		if (cpol[0] > 255)
			cpol[0] = 255;
		if (cpol[0] < 0)
			cpol[0] = 0;
		cpol[1] = (int) (i_261_ + i_261_ * (snap[1] / 100.0F));
		if (cpol[1] > 255)
			cpol[1] = 255;
		if (cpol[1] < 0)
			cpol[1] = 0;
		cpol[2] = (int) (i_262_ + i_262_ * (snap[2] / 100.0F));
		if (cpol[2] > 255)
			cpol[2] = 255;
		if (cpol[2] < 0)
			cpol[2] = 0;
		for (int i_264_ = 0; i_264_ < 3; i_264_++)
			crgrnd[i_264_] = (int) ((cpol[i_264_] * 0.99 + cgrnd[i_264_]) / 2.0);
	}

	public void setpolys(final int i, final int i_265_, final int i_266_) {
		cpol[0] = (int) (i + i * (snap[0] / 100.0F));
		if (cpol[0] > 255)
			cpol[0] = 255;
		if (cpol[0] < 0)
			cpol[0] = 0;
		cpol[1] = (int) (i_265_ + i_265_ * (snap[1] / 100.0F));
		if (cpol[1] > 255)
			cpol[1] = 255;
		if (cpol[1] < 0)
			cpol[1] = 0;
		cpol[2] = (int) (i_266_ + i_266_ * (snap[2] / 100.0F));
		if (cpol[2] > 255)
			cpol[2] = 255;
		if (cpol[2] < 0)
			cpol[2] = 0;
		for (int i_267_ = 0; i_267_ < 3; i_267_++)
			crgrnd[i_267_] = (int) ((cpol[i_267_] * 0.99 + cgrnd[i_267_]) / 2.0);
	}

	public void setfade(final int i, final int i_268_, final int i_269_) {
		cfade[0] = (int) (i + i * (snap[0] / 100.0F));
		if (cfade[0] > 255)
			cfade[0] = 255;
		if (cfade[0] < 0)
			cfade[0] = 0;
		cfade[1] = (int) (i_268_ + i_268_ * (snap[1] / 100.0F));
		if (cfade[1] > 255)
			cfade[1] = 255;
		if (cfade[1] < 0)
			cfade[1] = 0;
		cfade[2] = (int) (i_269_ + i_269_ * (snap[2] / 100.0F));
		if (cfade[2] > 255)
			cfade[2] = 255;
		if (cfade[2] < 0)
			cfade[2] = 0;
	}

	public void fadfrom(int i) {
		if (i > 8000)
			i = 8000;
		for (int i_270_ = 1; i_270_ < 17; i_270_++)
			fade[i_270_ - 1] = i / 2 * (i_270_ + 1);
	}

	public void adjstfade(final float f, final float f_271_, final int i, final GameSparker gamesparker) {
		if (resdown != 2)
			if (f == 5.0F) {
				if (resdown == 0 && rescnt == 0) {
					(gamesparker).moto = 0;
					Madness.anti = 0;
					fade[0] = 3000;
					fadfrom(fade[0]);
					resdown = 1;
					rescnt = 10;
				}
				if (resdown == 1 && rescnt == 0)
					resdown = 2;
				if ((i == 0 || resdown == 0) && f_271_ <= -20.0F)
					rescnt--;
			} else if (resdown == 0)
				rescnt = 5;
			else
				rescnt = 10;
	}

	public int xs(final int i, int i_272_) {
		if (i_272_ < cz)
			i_272_ = cz;
		return (((i_272_ - focus_point) * (cx - i) / i_272_) + i);
	}

	public int ys(final int i, int i_273_) {
		if (i_273_ < 10)
			i_273_ = 10;
		return (((i_273_ - focus_point) * (cy - i) / i_273_) + i);
	}

	public float cos(int i) {
		for (/**/; i >= 360; i -= 360) {
			/* empty */
		}
		for (/**/; i < 0; i += 360) {
			/* empty */
		}
		return tcos[i];
	}

	public float sin(int i) {
		for (/**/; i >= 360; i -= 360) {
			/* empty */
		}
		for (/**/; i < 0; i += 360) {
			/* empty */
		}
		return tsin[i];
	}

	public void rot(final int[] is, final int[] is_274_, final int i, final int i_275_, final int i_276_,
			final int i_277_) {
		if (i_276_ != 0)
			for (int i_278_ = 0; i_278_ < i_277_; i_278_++) {
				final int i_279_ = is[i_278_];
				final int i_280_ = is_274_[i_278_];
				is[i_278_] = i + (int) ((i_279_ - i) * cos(i_276_) - (i_280_ - i_275_) * sin(i_276_));
				is_274_[i_278_] = (i_275_ + (int) ((i_279_ - i) * sin(i_276_) + (i_280_ - i_275_) * cos(i_276_)));
			}
	}
}
