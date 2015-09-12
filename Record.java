/* Record - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;

public class Record
{
    Medium m;
    int caught = 0;
    boolean hcaught = false;
    boolean prepit = true;
    ContO[] ocar = new ContO[8];
    int cntf = 50;
    ContO[][] car = new ContO[6][8];
    int[][] squash = new int[6][8];
    int[] fix = new int[8];
    int[] dest = new int[8];
    int[][] x = new int[300][8];
    int[][] y = new int[300][8];
    int[][] z = new int[300][8];
    int[][] xy = new int[300][8];
    int[][] zy = new int[300][8];
    int[][] xz = new int[300][8];
    int[][] wxz = new int[300][8];
    int[][] wzy = new int[300][8];
    int[][] ns = new int[8][20];
    int[][][] sspark = new int[8][20][30];
    int[][][] sx = new int[8][20][30];
    int[][][] sy = new int[8][20][30];
    int[][][] sz = new int[8][20][30];
    float[][][] smag = new float[8][20][30];
    int[][][] scx = new int[8][20][30];
    int[][][] scz = new int[8][20][30];
    int[] nr = new int[8];
    int[][] rspark = new int[8][200];
    int[][] sprk = new int[8][200];
    int[][] srx = new int[8][200];
    int[][] sry = new int[8][200];
    int[][] srz = new int[8][200];
    float[][] rcx = new float[8][200];
    float[][] rcy = new float[8][200];
    float[][] rcz = new float[8][200];
    int[][] nry = new int[8][4];
    int[][][] ry = new int[8][4][7];
    int[][][] magy = new int[8][4][7];
    boolean[][] mtouch = new boolean[8][7];
    int[][] nrx = new int[8][4];
    int[][][] rx = new int[8][4][7];
    int[][][] magx = new int[8][4][7];
    int[][] nrz = new int[8][4];
    int[][][] rz = new int[8][4][7];
    int[][][] magz = new int[8][4][7];
    int[] checkpoint = new int[300];
    boolean[] lastcheck = new boolean[300];
    int wasted = 0;
    int whenwasted = 0;
    int powered = 0;
    int closefinish = 0;
    ContO[] starcar = new ContO[8];
    int[] hsquash = { 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] hfix = { -1, -1, -1, -1, -1, -1, -1, -1 };
    int[] hdest = { -1, -1, -1, -1, -1, -1, -1, -1 };
    int[][] hx = new int[300][8];
    int[][] hy = new int[300][8];
    int[][] hz = new int[300][8];
    int[][] hxy = new int[300][8];
    int[][] hzy = new int[300][8];
    int[][] hxz = new int[300][8];
    int[][] hwxz = new int[300][8];
    int[][] hwzy = new int[300][8];
    int[][][] hsspark = new int[8][20][30];
    int[][][] hsx = new int[8][20][30];
    int[][][] hsy = new int[8][20][30];
    int[][][] hsz = new int[8][20][30];
    float[][][] hsmag = new float[8][20][30];
    int[][][] hscx = new int[8][20][30];
    int[][][] hscz = new int[8][20][30];
    int[][] hrspark = new int[8][200];
    int[][] hsprk = new int[8][200];
    int[][] hsrx = new int[8][200];
    int[][] hsry = new int[8][200];
    int[][] hsrz = new int[8][200];
    float[][] hrcx = new float[8][200];
    float[][] hrcy = new float[8][200];
    float[][] hrcz = new float[8][200];
    int[][][] hry = new int[8][4][7];
    int[][][] hmagy = new int[8][4][7];
    int[][][] hrx = new int[8][4][7];
    int[][][] hmagx = new int[8][4][7];
    int[][][] hrz = new int[8][4][7];
    int[][][] hmagz = new int[8][4][7];
    boolean[][] hmtouch = new boolean[8][7];
    int[] hcheckpoint = new int[300];
    boolean[] hlastcheck = new boolean[300];
    int[] cntdest = new int[8];
    int lastfr = 0;
    
    public Record(Medium medium) {
	this.m = medium;
	this.caught = 0;
	cotchinow(0);
    }
    
    public void reset(ContO[] contos) {
	this.caught = 0;
	this.hcaught = false;
	this.wasted = 0;
	this.whenwasted = 0;
	this.closefinish = 0;
	this.powered = 0;
	for (int i = 0; i < 8; i++) {
	    if (this.prepit)
		this.starcar[i] = new ContO(contos[i], 0, 0, 0, 0);
	    this.fix[i] = -1;
	    this.dest[i] = -1;
	    this.cntdest[i] = 0;
	}
	for (int i = 0; i < 6; i++) {
	    for (int i_0_ = 0; i_0_ < 8; i_0_++) {
		this.car[i][i_0_]
		    = new ContO(contos[i_0_], 0, 0, 0, 0);
		this.squash[i][i_0_] = 0;
	    }
	}
	for (int i = 0; i < 8; i++) {
	    this.nr[i] = 0;
	    for (int i_1_ = 0; i_1_ < 200; i_1_++)
		this.rspark[i][i_1_] = -1;
	    for (int i_2_ = 0; i_2_ < 20; i_2_++) {
		this.ns[i][i_2_] = 0;
		for (int i_3_ = 0; i_3_ < 30; i_3_++)
		    this.sspark[i][i_2_][i_3_] = -1;
	    }
	    for (int i_4_ = 0; i_4_ < 4; i_4_++) {
		this.nry[i][i_4_] = 0;
		this.nrx[i][i_4_] = 0;
		this.nrz[i][i_4_] = 0;
		for (int i_5_ = 0; i_5_ < 7; i_5_++) {
		    this.ry[i][i_4_][i_5_] = -1;
		    this.rx[i][i_4_][i_5_] = -1;
		    this.rz[i][i_4_][i_5_] = -1;
		}
	    }
	}
	this.prepit = false;
    }
    
    public void cotchinow(int i) {
	if (this.caught >= 300) {
	    this.wasted = i;
	    for (int i_6_ = 0; i_6_ < 8; i_6_++) {
		this.starcar[i_6_]
		    = new ContO(this.car[0][i_6_], 0, 0, 0, 0);
		this.hsquash[i_6_]
		    = this.squash[0][i_6_];
		this.hfix[i_6_] = this.fix[i_6_];
		this.hdest[i_6_] = this.dest[i_6_];
	    }
	    for (int i_7_ = 0; i_7_ < 300; i_7_++) {
		for (int i_8_ = 0; i_8_ < 8; i_8_++) {
		    this.hx[i_7_][i_8_]
			= this.x[i_7_][i_8_];
		    this.hy[i_7_][i_8_]
			= this.y[i_7_][i_8_];
		    this.hz[i_7_][i_8_]
			= this.z[i_7_][i_8_];
		    this.hxy[i_7_][i_8_]
			= this.xy[i_7_][i_8_];
		    this.hzy[i_7_][i_8_]
			= this.zy[i_7_][i_8_];
		    this.hxz[i_7_][i_8_]
			= this.xz[i_7_][i_8_];
		    this.hwxz[i_7_][i_8_]
			= this.wxz[i_7_][i_8_];
		    this.hwzy[i_7_][i_8_]
			= this.wzy[i_7_][i_8_];
		}
		this.hcheckpoint[i_7_]
		    = this.checkpoint[i_7_];
		this.hlastcheck[i_7_]
		    = this.lastcheck[i_7_];
	    }
	    for (int i_9_ = 0; i_9_ < 8; i_9_++) {
		for (int i_10_ = 0; i_10_ < 20; i_10_++) {
		    for (int i_11_ = 0; i_11_ < 30; i_11_++) {
			this.hsspark[i_9_][i_10_][i_11_]
			    = this.sspark[i_9_][i_10_][i_11_];
			this.hsx[i_9_][i_10_][i_11_]
			    = this.sx[i_9_][i_10_][i_11_];
			this.hsy[i_9_][i_10_][i_11_]
			    = this.sy[i_9_][i_10_][i_11_];
			this.hsz[i_9_][i_10_][i_11_]
			    = this.sz[i_9_][i_10_][i_11_];
			this.hsmag[i_9_][i_10_][i_11_]
			    = this.smag[i_9_][i_10_][i_11_];
			this.hscx[i_9_][i_10_][i_11_]
			    = this.scx[i_9_][i_10_][i_11_];
			this.hscz[i_9_][i_10_][i_11_]
			    = this.scz[i_9_][i_10_][i_11_];
		    }
		}
		for (int i_12_ = 0; i_12_ < 200; i_12_++) {
		    this.hrspark[i_9_][i_12_]
			= this.rspark[i_9_][i_12_];
		    this.hsprk[i_9_][i_12_]
			= this.sprk[i_9_][i_12_];
		    this.hsrx[i_9_][i_12_]
			= this.srx[i_9_][i_12_];
		    this.hsry[i_9_][i_12_]
			= this.sry[i_9_][i_12_];
		    this.hsrz[i_9_][i_12_]
			= this.srz[i_9_][i_12_];
		    this.hrcx[i_9_][i_12_]
			= this.rcx[i_9_][i_12_];
		    this.hrcy[i_9_][i_12_]
			= this.rcy[i_9_][i_12_];
		    this.hrcz[i_9_][i_12_]
			= this.rcz[i_9_][i_12_];
		}
	    }
	    for (int i_13_ = 0; i_13_ < 8; i_13_++) {
		for (int i_14_ = 0; i_14_ < 4; i_14_++) {
		    for (int i_15_ = 0; i_15_ < 7; i_15_++) {
			this.hry[i_13_][i_14_][i_15_]
			    = this.ry[i_13_][i_14_][i_15_];
			this.hmagy[i_13_][i_14_][i_15_]
			    = this.magy[i_13_][i_14_][i_15_];
			this.hrx[i_13_][i_14_][i_15_]
			    = this.rx[i_13_][i_14_][i_15_];
			this.hmagx[i_13_][i_14_][i_15_]
			    = this.magx[i_13_][i_14_][i_15_];
			this.hrz[i_13_][i_14_][i_15_]
			    = this.rz[i_13_][i_14_][i_15_];
			this.hmagz[i_13_][i_14_][i_15_]
			    = this.magz[i_13_][i_14_][i_15_];
		    }
		}
	    }
	    for (int i_16_ = 0; i_16_ < 8; i_16_++) {
		for (int i_17_ = 0; i_17_ < 7; i_17_++)
		    this.hmtouch[i_16_][i_17_]
			= this.mtouch[i_16_][i_17_];
	    }
	    this.hcaught = true;
	}
    }
    
    public void rec(ContO conto, int i, int i_18_, int i_19_, int i_20_,
		    int i_21_) {
	if (i == i_21_)
	    this.caught++;
	if (this.cntf == 50) {
	    for (int i_22_ = 0; i_22_ < 5; i_22_++) {
		this.car[i_22_][i]
		    = new ContO(this.car[i_22_ + 1][i], 0, 0, 0, 0);
		this.squash[i_22_][i]
		    = this.squash[i_22_ + 1][i];
	    }
	    this.car[5][i] = new ContO(conto, 0, 0, 0, 0);
	    this.squash[5][i] = i_18_;
	    this.cntf = 0;
	} else
	    this.cntf++;
	this.fix[i]--;
	if (i_20_ != 0)
	    this.dest[i]--;
	if (this.dest[i] == 230) {
	    if (i == i_21_) {
		cotchinow(i_21_);
		this.whenwasted = 229;
	    } else if (i_19_ != 0) {
		cotchinow(i);
		this.whenwasted = 165 + i_19_;
	    }
	}
	for (int i_23_ = 0; i_23_ < 299; i_23_++) {
	    this.x[i_23_][i] = this.x[i_23_ + 1][i];
	    this.y[i_23_][i] = this.y[i_23_ + 1][i];
	    this.z[i_23_][i] = this.z[i_23_ + 1][i];
	    this.zy[i_23_][i] = this.zy[i_23_ + 1][i];
	    this.xy[i_23_][i] = this.xy[i_23_ + 1][i];
	    this.xz[i_23_][i] = this.xz[i_23_ + 1][i];
	    this.wxz[i_23_][i] = this.wxz[i_23_ + 1][i];
	    this.wzy[i_23_][i] = this.wzy[i_23_ + 1][i];
	}
	this.x[299][i] = (conto).x;
	this.y[299][i] = (conto).y;
	this.z[299][i] = (conto).z;
	this.xy[299][i] = (conto).xy;
	this.zy[299][i] = (conto).zy;
	this.xz[299][i] = (conto).xz;
	this.wxz[299][i] = (conto).wxz;
	this.wzy[299][i] = (conto).wzy;
	if (i == i_21_) {
	    for (int i_24_ = 0; i_24_ < 299; i_24_++) {
		this.checkpoint[i_24_]
		    = this.checkpoint[i_24_ + 1];
		this.lastcheck[i_24_]
		    = this.lastcheck[i_24_ + 1];
	    }
	    this.checkpoint[299]
		= ((conto).m).checkpoint;
	    this.lastcheck[299]
		= ((conto).m).lastcheck;
	}
	for (int i_25_ = 0; i_25_ < 20; i_25_++) {
	    if ((conto).stg[i_25_] == 1) {
		this.sspark[i][i_25_][this.ns[i][i_25_]]
		    = 300;
		this.sx[i][i_25_][this.ns[i][i_25_]]
		    = (conto).sx[i_25_];
		this.sy[i][i_25_][this.ns[i][i_25_]]
		    = (conto).sy[i_25_];
		this.sz[i][i_25_][this.ns[i][i_25_]]
		    = (conto).sz[i_25_];
		this.smag[i][i_25_][this.ns[i][i_25_]]
		    = (conto).osmag[i_25_];
		this.scx[i][i_25_][this.ns[i][i_25_]]
		    = (conto).scx[i_25_];
		this.scz[i][i_25_][this.ns[i][i_25_]]
		    = (conto).scz[i_25_];
		this.ns[i][i_25_]++;
		if (this.ns[i][i_25_] == 30)
		    this.ns[i][i_25_] = 0;
	    }
	    for (int i_26_ = 0; i_26_ < 30; i_26_++)
		this.sspark[i][i_25_][i_26_]--;
	}
	if ((conto).sprk != 0) {
	    this.rspark[i][this.nr[i]] = 300;
	    this.sprk[i][this.nr[i]]
		= (conto).sprk;
	    this.srx[i][this.nr[i]]
		= (conto).srx;
	    this.sry[i][this.nr[i]]
		= (conto).sry;
	    this.srz[i][this.nr[i]]
		= (conto).srz;
	    this.rcx[i][this.nr[i]]
		= (conto).rcx;
	    this.rcy[i][this.nr[i]]
		= (conto).rcy;
	    this.rcz[i][this.nr[i]]
		= (conto).rcz;
	    this.nr[i]++;
	    if (this.nr[i] == 200)
		this.nr[i] = 0;
	}
	for (int i_27_ = 0; i_27_ < 200; i_27_++)
	    this.rspark[i][i_27_]--;
	for (int i_28_ = 0; i_28_ < 4; i_28_++) {
	    for (int i_29_ = 0; i_29_ < 7; i_29_++) {
		this.ry[i][i_28_][i_29_]--;
		this.rx[i][i_28_][i_29_]--;
		this.rz[i][i_28_][i_29_]--;
	    }
	}
    }
    
    public void play(ContO conto, Mad mad, int i, int i_30_) {
	(conto).x = this.x[i_30_][i];
	(conto).y = this.y[i_30_][i];
	(conto).z = this.z[i_30_][i];
	(conto).zy = this.zy[i_30_][i];
	(conto).xy = this.xy[i_30_][i];
	(conto).xz = this.xz[i_30_][i];
	(conto).wxz = this.wxz[i_30_][i];
	(conto).wzy = this.wzy[i_30_][i];
	if (i == 0) {
	    ((conto).m).checkpoint
		= this.checkpoint[i_30_];
	    ((conto).m).lastcheck
		= this.lastcheck[i_30_];
	}
	if (i_30_ == 0)
	    this.cntdest[i] = 0;
	if (this.dest[i] == i_30_)
	    this.cntdest[i] = 7;
	if (i_30_ == 0 && this.dest[i] < -1) {
	    for (int i_31_ = 0; i_31_ < (conto).npl; i_31_++) {
		if (((conto).p[i_31_]).wz == 0
		    || ((conto).p[i_31_]).gr == -17
		    || ((conto).p[i_31_]).gr == -16)
		    ((conto).p[i_31_]).embos = 13;
	    }
	}
	if (this.cntdest[i] != 0) {
	    for (int i_32_ = 0; i_32_ < (conto).npl; i_32_++) {
		if (((conto).p[i_32_]).wz == 0
		    || ((conto).p[i_32_]).gr == -17
		    || ((conto).p[i_32_]).gr == -16)
		    ((conto).p[i_32_]).embos = 1;
	    }
	    this.cntdest[i]--;
	}
	for (int i_33_ = 0; i_33_ < 20; i_33_++) {
	    for (int i_34_ = 0; i_34_ < 30; i_34_++) {
		if (this.sspark[i][i_33_][i_34_] == i_30_) {
		    (conto).stg[i_33_] = 1;
		    (conto).sx[i_33_]
			= this.sx[i][i_33_][i_34_];
		    (conto).sy[i_33_]
			= this.sy[i][i_33_][i_34_];
		    (conto).sz[i_33_]
			= this.sz[i][i_33_][i_34_];
		    (conto).osmag[i_33_]
			= this.smag[i][i_33_][i_34_];
		    (conto).scx[i_33_]
			= this.scx[i][i_33_][i_34_];
		    (conto).scz[i_33_]
			= this.scz[i][i_33_][i_34_];
		}
	    }
	}
	for (int i_35_ = 0; i_35_ < 200; i_35_++) {
	    if (this.rspark[i][i_35_] == i_30_) {
		(conto).sprk = this.sprk[i][i_35_];
		(conto).srx = this.srx[i][i_35_];
		(conto).sry = this.sry[i][i_35_];
		(conto).srz = this.srz[i][i_35_];
		(conto).rcx = this.rcx[i][i_35_];
		(conto).rcy = this.rcy[i][i_35_];
		(conto).rcz = this.rcz[i][i_35_];
	    }
	}
	for (int i_36_ = 0; i_36_ < 4; i_36_++) {
	    for (int i_37_ = 0; i_37_ < 7; i_37_++) {
		if (this.ry[i][i_36_][i_37_] == i_30_)
		    regy(i_36_, (float) this.magy[i][i_36_][i_37_],
			 this.mtouch[i][i_37_], conto, mad);
		if (this.rx[i][i_36_][i_37_] == i_30_)
		    regx(i_36_, (float) this.magx[i][i_36_][i_37_],
			 conto, mad);
		if (this.rz[i][i_36_][i_37_] == i_30_)
		    regz(i_36_, (float) this.magz[i][i_36_][i_37_],
			 conto, mad);
	    }
	}
    }
    
    public void playh(ContO conto, Mad mad, int i, int i_38_, int i_39_) {
	(conto).x = this.hx[i_38_][i];
	(conto).y = this.hy[i_38_][i];
	(conto).z = this.hz[i_38_][i];
	(conto).zy = this.hzy[i_38_][i];
	(conto).xy = this.hxy[i_38_][i];
	(conto).xz = this.hxz[i_38_][i];
	(conto).wxz = this.hwxz[i_38_][i];
	(conto).wzy = this.hwzy[i_38_][i];
	if (i == i_39_) {
	    ((conto).m).checkpoint
		= this.hcheckpoint[i_38_];
	    ((conto).m).lastcheck
		= this.hlastcheck[i_38_];
	}
	if (i_38_ == 0)
	    this.cntdest[i] = 0;
	if (this.hdest[i] == i_38_)
	    this.cntdest[i] = 7;
	if (i_38_ == 0 && this.hdest[i] < -1) {
	    for (int i_40_ = 0; i_40_ < (conto).npl; i_40_++) {
		if (((conto).p[i_40_]).wz == 0
		    || ((conto).p[i_40_]).gr == -17
		    || ((conto).p[i_40_]).gr == -16)
		    ((conto).p[i_40_]).embos = 13;
	    }
	}
	if (this.cntdest[i] != 0) {
	    for (int i_41_ = 0; i_41_ < (conto).npl; i_41_++) {
		if (((conto).p[i_41_]).wz == 0
		    || ((conto).p[i_41_]).gr == -17
		    || ((conto).p[i_41_]).gr == -16)
		    ((conto).p[i_41_]).embos = 1;
	    }
	    this.cntdest[i]--;
	}
	for (int i_42_ = 0; i_42_ < 20; i_42_++) {
	    for (int i_43_ = 0; i_43_ < 30; i_43_++) {
		if (this.hsspark[i][i_42_][i_43_] == i_38_) {
		    (conto).stg[i_42_] = 1;
		    (conto).sx[i_42_]
			= this.hsx[i][i_42_][i_43_];
		    (conto).sy[i_42_]
			= this.hsy[i][i_42_][i_43_];
		    (conto).sz[i_42_]
			= this.hsz[i][i_42_][i_43_];
		    (conto).osmag[i_42_]
			= this.hsmag[i][i_42_][i_43_];
		    (conto).scx[i_42_]
			= this.hscx[i][i_42_][i_43_];
		    (conto).scz[i_42_]
			= this.hscz[i][i_42_][i_43_];
		}
	    }
	}
	for (int i_44_ = 0; i_44_ < 200; i_44_++) {
	    if (this.hrspark[i][i_44_] == i_38_) {
		(conto).sprk = this.hsprk[i][i_44_];
		(conto).srx = this.hsrx[i][i_44_];
		(conto).sry = this.hsry[i][i_44_];
		(conto).srz = this.hsrz[i][i_44_];
		(conto).rcx = this.hrcx[i][i_44_];
		(conto).rcy = this.hrcy[i][i_44_];
		(conto).rcz = this.hrcz[i][i_44_];
	    }
	}
	for (int i_45_ = 0; i_45_ < 4; i_45_++) {
	    for (int i_46_ = 0; i_46_ < 7; i_46_++) {
		if (this.hry[i][i_45_][i_46_] == i_38_
		    && this.lastfr != i_38_)
		    regy(i_45_, (float) this.hmagy[i][i_45_][i_46_],
			 this.hmtouch[i][i_46_], conto, mad);
		if (this.hrx[i][i_45_][i_46_] == i_38_) {
		    if (this.lastfr != i_38_)
			regx(i_45_,
			     (float) this.hmagx[i][i_45_][i_46_],
			     conto, mad);
		    else
			chipx(i_45_,
			      (float) this.hmagx[i][i_45_][i_46_],
			      conto, mad);
		}
		if (this.hrz[i][i_45_][i_46_] == i_38_) {
		    if (this.lastfr != i_38_)
			regz(i_45_,
			     (float) this.hmagz[i][i_45_][i_46_],
			     conto, mad);
		    else
			chipz(i_45_,
			      (float) this.hmagz[i][i_45_][i_46_],
			      conto, mad);
		}
	    }
	}
	this.lastfr = i_38_;
    }
    
    public void recy(int i, float f, boolean bool, int i_47_) {
	this.ry[i_47_][i][this.nry[i_47_][i]] = 300;
	this.magy[i_47_][i][this.nry[i_47_][i]]
	    = (int) f;
	this.mtouch[i_47_][this.nry[i_47_][i]] = bool;
	this.nry[i_47_][i]++;
	if (this.nry[i_47_][i] == 7)
	    this.nry[i_47_][i] = 0;
    }
    
    public void recx(int i, float f, int i_48_) {
	this.rx[i_48_][i][this.nry[i_48_][i]] = 300;
	this.magx[i_48_][i][this.nry[i_48_][i]]
	    = (int) f;
	this.nrx[i_48_][i]++;
	if (this.nrx[i_48_][i] == 7)
	    this.nrx[i_48_][i] = 0;
    }
    
    public void recz(int i, float f, int i_49_) {
	this.rz[i_49_][i][this.nry[i_49_][i]] = 300;
	this.magz[i_49_][i][this.nry[i_49_][i]]
	    = (int) f;
	this.nrz[i_49_][i]++;
	if (this.nrz[i_49_][i] == 7)
	    this.nrz[i_49_][i] = 0;
    }
    
    public void regy(int i, float f, boolean bool, ContO conto, Mad mad) {
	if (f > 100.0F) {
	    f -= 100.0F;
	    int i_50_ = 0;
	    int i_51_ = 0;
	    int i_52_ = (conto).zy;
	    int i_53_ = (conto).xy;
	    for (/**/; i_52_ < 360; i_52_ += 360) {
		/* empty */
	    }
	    for (/**/; i_52_ > 360; i_52_ -= 360) {
		/* empty */
	    }
	    if (i_52_ < 210 && i_52_ > 150)
		i_50_ = -1;
	    if (i_52_ > 330 || i_52_ < 30)
		i_50_ = 1;
	    for (/**/; i_53_ < 360; i_53_ += 360) {
		/* empty */
	    }
	    for (/**/; i_53_ > 360; i_53_ -= 360) {
		/* empty */
	    }
	    if (i_53_ < 210 && i_53_ > 150)
		i_51_ = -1;
	    if (i_53_ > 330 || i_53_ < 30)
		i_51_ = 1;
	    if (i_51_ * i_50_ == 0 || bool) {
		for (int i_54_ = 0; i_54_ < (conto).npl; i_54_++) {
		    float f_55_ = 0.0F;
		    for (int i_56_ = 0;
			 i_56_ < ((conto).p[i_54_]).n;
			 i_56_++) {
			if (((conto).p[i_54_]).wz == 0
			    && (py((conto).keyx[i],
				   (((conto).p[i_54_]).ox
				    [i_56_]),
				   (conto).keyz[i],
				   (((conto).p[i_54_]).oz
				    [i_56_]))
				< (((mad).cd).clrad
				   [(mad).cn]))) {
			    f_55_ = f / 20.0F * this.m.random();
			    ((conto).p[i_54_]).oz[i_56_]
				+= f_55_ * this.m.sin(i_52_);
			    ((conto).p[i_54_]).ox[i_56_]
				-= f_55_ * this.m.sin(i_53_);
			}
		    }
		    if (f_55_ != 0.0F) {
			if (Math.abs(f_55_) >= 1.0F) {
			    ((conto).p[i_54_]).chip = 1;
			    ((conto).p[i_54_]).ctmag = f_55_;
			}
			if (!((conto).p[i_54_]).nocol
			    && ((conto).p[i_54_]).glass != 1) {
			    if (((conto).p[i_54_]).bfase > 20
				&& (double) (((conto).p[i_54_])
					     .hsb[1]) > 0.2)
				((conto).p[i_54_]).hsb[1]
				    = 0.2F;
			    if (((conto).p[i_54_]).bfase
				> 30) {
				if ((double) (
					      (conto).p[i_54_]).hsb[2]
				    < 0.5)
				    ((conto).p[i_54_]).hsb[2]
					= 0.5F;
				if ((double) (
					      (conto).p[i_54_]).hsb[1]
				    > 0.1)
				    ((conto).p[i_54_]).hsb[1]
					= 0.1F;
			    }
			    if (((conto).p[i_54_]).bfase > 40)
				((conto).p[i_54_]).hsb[1]
				    = 0.05F;
			    if (((conto).p[i_54_]).bfase
				> 50) {
				if ((double) (
					      (conto).p[i_54_]).hsb[2]
				    > 0.8)
				    ((conto).p[i_54_]).hsb[2]
					= 0.8F;
				((conto).p[i_54_]).hsb[0]
				    = 0.075F;
				((conto).p[i_54_]).hsb[1]
				    = 0.05F;
			    }
			    if (((conto).p[i_54_]).bfase > 60)
				((conto).p[i_54_]).hsb[0]
				    = 0.05F;
			    ((conto).p[i_54_]).bfase += f_55_;
			    new Color(((conto).p[i_54_]).c[0],
				      ((conto).p[i_54_]).c[1],
				      ((conto).p[i_54_]).c[2]);
			    Color color
				= (Color.getHSBColor
				   (((conto).p[i_54_]).hsb[0],
				    ((conto).p[i_54_]).hsb[1],
				    (((conto).p[i_54_]).hsb
				     [2])));
			    ((conto).p[i_54_]).c[0]
				= color.getRed();
			    ((conto).p[i_54_]).c[1]
				= color.getGreen();
			    ((conto).p[i_54_]).c[2]
				= color.getBlue();
			}
			if (((conto).p[i_54_]).glass == 1)
			    ((conto).p[i_54_]).gr
				+= Math.abs((double) f_55_ * 1.5);
		    }
		}
	    }
	    if (i_51_ * i_50_ == -1) {
		int i_57_ = 0;
		int i_58_ = 1;
		for (int i_59_ = 0; i_59_ < (conto).npl; i_59_++) {
		    float f_60_ = 0.0F;
		    for (int i_61_ = 0;
			 i_61_ < ((conto).p[i_59_]).n;
			 i_61_++) {
			if (((conto).p[i_59_]).wz == 0) {
			    f_60_ = f / 15.0F * this.m.random();
			    if (((Math.abs((((conto).p[i_59_])
					    .oy[i_61_])
					   - (((mad).cd)
					      .flipy[(mad).cn])
					   - (this.squash[0]
					      [(mad).im]))
				  < (((mad).cd).msquash
				     [(mad).cn]) * 3)
				 || ((((conto).p[i_59_]).oy
				      [i_61_])
				     < ((((mad).cd).flipy
					 [(mad).cn])
					+ (this.squash[0]
					   [(mad).im]))))
				&& (this.squash[0][(mad).im]
				    < (((mad).cd).msquash
				       [(mad).cn]))) {
				((conto).p[i_59_]).oy[i_61_]
				    += f_60_;
				i_57_ += f_60_;
				i_58_++;
			    }
			}
		    }
		    if (((conto).p[i_59_]).glass == 1)
			((conto).p[i_59_]).gr += 5;
		    else if (f_60_ != 0.0F)
			((conto).p[i_59_]).bfase += f_60_;
		    if (Math.abs(f_60_) >= 1.0F) {
			((conto).p[i_59_]).chip = 1;
			((conto).p[i_59_]).ctmag = f_60_;
		    }
		}
		this.squash[0][(mad).im] += i_57_ / i_58_;
	    }
	}
    }
    
    public void regx(int i, float f, ContO conto, Mad mad) {
	if (Math.abs(f) > 100.0F) {
	    if (f > 100.0F)
		f -= 100.0F;
	    if (f < -100.0F)
		f += 100.0F;
	    for (int i_62_ = 0; i_62_ < (conto).npl; i_62_++) {
		float f_63_ = 0.0F;
		for (int i_64_ = 0;
		     i_64_ < ((conto).p[i_62_]).n; i_64_++) {
		    if (((conto).p[i_62_]).wz == 0
			&& (py((conto).keyx[i],
			       ((conto).p[i_62_]).ox[i_64_],
			       (conto).keyz[i],
			       ((conto).p[i_62_]).oz[i_64_])
			    < (((mad).cd).clrad
			       [(mad).cn]))) {
			f_63_ = f / 20.0F * this.m.random();
			((conto).p[i_62_]).oz[i_64_]
			    -= (f_63_
				* this.m.sin((conto).xz)
				* this.m.cos((conto).zy));
			((conto).p[i_62_]).ox[i_64_]
			    += (f_63_
				* this.m.cos((conto).xz)
				* this.m.cos((conto).xy));
		    }
		}
		if (f_63_ != 0.0F) {
		    if (Math.abs(f_63_) >= 1.0F) {
			((conto).p[i_62_]).chip = 1;
			((conto).p[i_62_]).ctmag = f_63_;
		    }
		    if (!((conto).p[i_62_]).nocol
			&& ((conto).p[i_62_]).glass != 1) {
			if (((conto).p[i_62_]).bfase > 20
			    && (double) (((conto).p[i_62_]).hsb
					 [1]) > 0.2)
			    ((conto).p[i_62_]).hsb[1] = 0.2F;
			if (((conto).p[i_62_]).bfase > 30) {
			    if ((double) (((conto).p[i_62_])
					  .hsb[2])
				< 0.5)
				((conto).p[i_62_]).hsb[2]
				    = 0.5F;
			    if ((double) (((conto).p[i_62_])
					  .hsb[1])
				> 0.1)
				((conto).p[i_62_]).hsb[1]
				    = 0.1F;
			}
			if (((conto).p[i_62_]).bfase > 40)
			    ((conto).p[i_62_]).hsb[1] = 0.05F;
			if (((conto).p[i_62_]).bfase > 50) {
			    if ((double) (((conto).p[i_62_])
					  .hsb[2])
				> 0.8)
				((conto).p[i_62_]).hsb[2]
				    = 0.8F;
			    ((conto).p[i_62_]).hsb[0] = 0.075F;
			    ((conto).p[i_62_]).hsb[1] = 0.05F;
			}
			if (((conto).p[i_62_]).bfase > 60)
			    ((conto).p[i_62_]).hsb[0] = 0.05F;
			((conto).p[i_62_]).bfase
			    += Math.abs(f_63_);
			new Color(((conto).p[i_62_]).c[0],
				  ((conto).p[i_62_]).c[1],
				  ((conto).p[i_62_]).c[2]);
			Color color
			    = (Color.getHSBColor
			       (((conto).p[i_62_]).hsb[0],
				((conto).p[i_62_]).hsb[1],
				((conto).p[i_62_]).hsb[2]));
			((conto).p[i_62_]).c[0]
			    = color.getRed();
			((conto).p[i_62_]).c[1]
			    = color.getGreen();
			((conto).p[i_62_]).c[2]
			    = color.getBlue();
		    }
		    if (((conto).p[i_62_]).glass == 1)
			((conto).p[i_62_]).gr
			    += Math.abs((double) f_63_ * 1.5);
		}
	    }
	}
    }
    
    public void regz(int i, float f, ContO conto, Mad mad) {
	if (Math.abs(f) > 100.0F) {
	    if (f > 100.0F)
		f -= 100.0F;
	    if (f < -100.0F)
		f += 100.0F;
	    for (int i_65_ = 0; i_65_ < (conto).npl; i_65_++) {
		float f_66_ = 0.0F;
		for (int i_67_ = 0;
		     i_67_ < ((conto).p[i_65_]).n; i_67_++) {
		    if (((conto).p[i_65_]).wz == 0
			&& (py((conto).keyx[i],
			       ((conto).p[i_65_]).ox[i_67_],
			       (conto).keyz[i],
			       ((conto).p[i_65_]).oz[i_67_])
			    < (((mad).cd).clrad
			       [(mad).cn]))) {
			f_66_ = f / 20.0F * this.m.random();
			((conto).p[i_65_]).oz[i_67_]
			    += (f_66_
				* this.m.cos((conto).xz)
				* this.m.cos((conto).zy));
			((conto).p[i_65_]).ox[i_67_]
			    += (f_66_
				* this.m.sin((conto).xz)
				* this.m.cos((conto).xy));
		    }
		}
		if (f_66_ != 0.0F) {
		    if (Math.abs(f_66_) >= 1.0F) {
			((conto).p[i_65_]).chip = 1;
			((conto).p[i_65_]).ctmag = f_66_;
		    }
		    if (!((conto).p[i_65_]).nocol
			&& ((conto).p[i_65_]).glass != 1) {
			if (((conto).p[i_65_]).bfase > 20
			    && (double) (((conto).p[i_65_]).hsb
					 [1]) > 0.2)
			    ((conto).p[i_65_]).hsb[1] = 0.2F;
			if (((conto).p[i_65_]).bfase > 30) {
			    if ((double) (((conto).p[i_65_])
					  .hsb[2])
				< 0.5)
				((conto).p[i_65_]).hsb[2]
				    = 0.5F;
			    if ((double) (((conto).p[i_65_])
					  .hsb[1])
				> 0.1)
				((conto).p[i_65_]).hsb[1]
				    = 0.1F;
			}
			if (((conto).p[i_65_]).bfase > 40)
			    ((conto).p[i_65_]).hsb[1] = 0.05F;
			if (((conto).p[i_65_]).bfase > 50) {
			    if ((double) (((conto).p[i_65_])
					  .hsb[2])
				> 0.8)
				((conto).p[i_65_]).hsb[2]
				    = 0.8F;
			    ((conto).p[i_65_]).hsb[0] = 0.075F;
			    ((conto).p[i_65_]).hsb[1] = 0.05F;
			}
			if (((conto).p[i_65_]).bfase > 60)
			    ((conto).p[i_65_]).hsb[0] = 0.05F;
			((conto).p[i_65_]).bfase
			    += Math.abs(f_66_);
			new Color(((conto).p[i_65_]).c[0],
				  ((conto).p[i_65_]).c[1],
				  ((conto).p[i_65_]).c[2]);
			Color color
			    = (Color.getHSBColor
			       (((conto).p[i_65_]).hsb[0],
				((conto).p[i_65_]).hsb[1],
				((conto).p[i_65_]).hsb[2]));
			((conto).p[i_65_]).c[0]
			    = color.getRed();
			((conto).p[i_65_]).c[1]
			    = color.getGreen();
			((conto).p[i_65_]).c[2]
			    = color.getBlue();
		    }
		    if (((conto).p[i_65_]).glass == 1)
			((conto).p[i_65_]).gr
			    += Math.abs((double) f_66_ * 1.5);
		}
	    }
	}
    }
    
    public void chipx(int i, float f, ContO conto, Mad mad) {
	if (Math.abs(f) > 100.0F) {
	    if (f > 100.0F)
		f -= 100.0F;
	    if (f < -100.0F)
		f += 100.0F;
	    for (int i_68_ = 0; i_68_ < (conto).npl; i_68_++) {
		float f_69_ = 0.0F;
		for (int i_70_ = 0;
		     i_70_ < ((conto).p[i_68_]).n; i_70_++) {
		    if (((conto).p[i_68_]).wz == 0
			&& (py((conto).keyx[i],
			       ((conto).p[i_68_]).ox[i_70_],
			       (conto).keyz[i],
			       ((conto).p[i_68_]).oz[i_70_])
			    < (((mad).cd).clrad
			       [(mad).cn])))
			f_69_ = f / 20.0F * this.m.random();
		}
		if (f_69_ != 0.0F && Math.abs(f_69_) >= 1.0F) {
		    ((conto).p[i_68_]).chip = 1;
		    ((conto).p[i_68_]).ctmag = f_69_;
		}
	    }
	}
    }
    
    public void chipz(int i, float f, ContO conto, Mad mad) {
	if (Math.abs(f) > 100.0F) {
	    if (f > 100.0F)
		f -= 100.0F;
	    if (f < -100.0F)
		f += 100.0F;
	    for (int i_71_ = 0; i_71_ < (conto).npl; i_71_++) {
		float f_72_ = 0.0F;
		for (int i_73_ = 0;
		     i_73_ < ((conto).p[i_71_]).n; i_73_++) {
		    if (((conto).p[i_71_]).wz == 0
			&& (py((conto).keyx[i],
			       ((conto).p[i_71_]).ox[i_73_],
			       (conto).keyz[i],
			       ((conto).p[i_71_]).oz[i_73_])
			    < (((mad).cd).clrad
			       [(mad).cn])))
			f_72_ = f / 20.0F * this.m.random();
		}
		if (f_72_ != 0.0F && Math.abs(f_72_) >= 1.0F) {
		    ((conto).p[i_71_]).chip = 1;
		    ((conto).p[i_71_]).ctmag = f_72_;
		}
	    }
	}
    }
    
    public int py(int i, int i_74_, int i_75_, int i_76_) {
	return (i - i_74_) * (i - i_74_) + (i_75_ - i_76_) * (i_75_ - i_76_);
    }
}
