/* CheckPoints - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class CheckPoints {
	int[] x = new int[10000];
	int[] z = new int[10000];
	int[] y = new int[10000];
	int[] typ = new int[10000];
	int pcs = 0;
	int nsp = 0;
	int n = 0;
	int[] fx = new int[5];
	int[] fz = new int[5];
	int[] fy = new int[5];
	boolean[] roted = new boolean[5];
	boolean[] special = new boolean[5];
	int fn = 0;
	int stage = (int) (Math.random() * 27.0) + 1;
	int nlaps = 0;
	int nfix = 0;
	boolean notb = false;
	String name = "hogan rewish";
	String maker = "";
	int pubt = 0;
	String trackname = "";
	int trackvol = 200;
	int top20 = 0;
	int nto = 0;
	int[] pos = { 7, 7, 7, 7, 7, 7, 7, 7 };
	int[] clear = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] dested = { 0, 0, 0, 0, 0, 0, 0, 0 };
	float[] magperc = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	int wasted = 0;
	boolean haltall = false;
	int pcleared = 0;
	int[] opx = new int[8];
	int[] opz = new int[8];
	int[] onscreen = new int[8];
	int[] omxz = new int[8];
	int catchfin = 0;
	int postwo = 0;
	float prox = 0.0F;

	public void checkstat(final Mad[] mads, final ContO[] contos, final Record record, final int i, final int i_0_,
			final int i_1_) {
		if (!haltall) {
			pcleared = (mads[i_0_]).pcleared;
			for (int i_2_ = 0; i_2_ < i; i_2_++) {
				magperc[i_2_] = ((float) (mads[i_2_]).hitmag / (float) (((mads[i_2_]).cd).maxmag[(mads[i_2_]).cn]));
				if (magperc[i_2_] > 1.0F)
					magperc[i_2_] = 1.0F;
				pos[i_2_] = 0;
				onscreen[i_2_] = (contos[i_2_]).dist;
				opx[i_2_] = (contos[i_2_]).x;
				opz[i_2_] = (contos[i_2_]).z;
				omxz[i_2_] = (mads[i_2_]).mxz;
				if (dested[i_2_] == 0)
					clear[i_2_] = (mads[i_2_]).clear;
				else
					clear[i_2_] = -1;
				(mads[i_2_]).outshakedam = (mads[i_2_]).shakedam;
				(mads[i_2_]).shakedam = 0;
			}
			for (int i_3_ = 0; i_3_ < i; i_3_++)
				for (int i_4_ = i_3_ + 1; i_4_ < i; i_4_++)
					if (clear[i_3_] != clear[i_4_]) {
						if (clear[i_3_] < clear[i_4_])
							pos[i_3_]++;
						else
							pos[i_4_]++;
					} else {
						int i_5_ = (mads[i_3_]).pcleared + 1;
						if (i_5_ >= n)
							i_5_ = 0;
						while (typ[i_5_] <= 0)
							if (++i_5_ >= n)
								i_5_ = 0;
						if (py((contos[i_3_]).x / 100, x[i_5_] / 100, (contos[i_3_]).z / 100, z[i_5_] / 100) > py(
								(contos[i_4_]).x / 100, x[i_5_] / 100, (contos[i_4_]).z / 100, z[i_5_] / 100))
							pos[i_3_]++;
						else
							pos[i_4_]++;
					}
			if (stage > 2)
				for (int i_6_ = 0; i_6_ < i; i_6_++)
					if ((clear[i_6_] == (nlaps * nsp)) && pos[i_6_] == 0)
						if (i_6_ == i_0_) {
							for (int i_7_ = 0; i_7_ < i; i_7_++)
								if (pos[i_7_] == 1)
									postwo = i_7_;
							if ((py(opx[i_0_] / 100, (opx[postwo]) / 100, opz[i_0_] / 100, (opz[postwo]) / 100) < 14000)
									&& (clear[i_0_] - (clear[postwo])) == 1)
								catchfin = 30;
						} else if (pos[i_0_] == 1
								&& (py(opx[i_0_] / 100, opx[i_6_] / 100, opz[i_0_] / 100, opz[i_6_] / 100) < 14000)
								&& ((clear[i_6_] - clear[i_0_]) == 1)) {
							catchfin = 30;
							postwo = i_6_;
						}
		}
		wasted = 0;
		for (int i_8_ = 0; i_8_ < i; i_8_++)
			if ((i_0_ != i_8_ || i_1_ >= 2) && (mads[i_8_]).dest)
				wasted++;
		if (catchfin != 0 && i_1_ < 2) {
			catchfin--;
			if (catchfin == 0) {
				record.cotchinow(postwo);
				(record).closefinish = pos[i_0_] + 1;
			}
		}
	}

	public void calprox() {
		int i = 0;
		for (int i_9_ = 0; i_9_ < n - 1; i_9_++)
			for (int i_10_ = i_9_ + 1; i_10_ < n; i_10_++) {
				if (Math.abs(x[i_9_] - x[i_10_]) > i)
					i = Math.abs(x[i_9_] - x[i_10_]);
				if (Math.abs(z[i_9_] - z[i_10_]) > i)
					i = Math.abs(z[i_9_] - z[i_10_]);
			}
		prox = i / 90.0F;
	}

	public int py(final int i, final int i_11_, final int i_12_, final int i_13_) {
		return (i - i_11_) * (i - i_11_) + (i_12_ - i_13_) * (i_12_ - i_13_);
	}
}
