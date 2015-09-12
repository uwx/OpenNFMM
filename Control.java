/* Control - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Control
{
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    boolean handb = false;
    int lookback = 0;
    boolean enter = false;
    boolean exit = false;
    boolean arrace = false;
    boolean mutem = false;
    boolean mutes = false;
    boolean radar = false;
    int chatup = 0;
    int multion = 0;
    Medium m;
    int pan = 0;
    int attack = 0;
    int acr = 0;
    boolean afta = false;
    int[] fpnt = new int[5];
    int trfix = 0;
    boolean forget = false;
    boolean bulistc = false;
    int runbul = 0;
    int acuracy = 0;
    int upwait = 0;
    boolean agressed = false;
    float skiplev = 1.0F;
    int clrnce = 5;
    int rampp = 0;
    int turntyp = 0;
    float aim = 0.0F;
    int saftey = 30;
    boolean perfection = false;
    float mustland = 0.5F;
    boolean usebounce = false;
    float trickprf = 0.5F;
    int stuntf = 0;
    boolean zyinv = false;
    boolean lastl = false;
    boolean wlastl = false;
    int hold = 0;
    int wall = -1;
    int lwall = -1;
    int stcnt = 0;
    int statusque = 0;
    int turncnt = 0;
    int randtcnt = 0;
    int upcnt = 0;
    int trickfase = 0;
    int swat = 0;
    boolean udcomp = false;
    boolean lrcomp = false;
    boolean udbare = false;
    boolean lrbare = false;
    boolean onceu = false;
    boolean onced = false;
    boolean oncel = false;
    boolean oncer = false;
    int lrdirect = 0;
    int uddirect = 0;
    int lrstart = 0;
    int udstart = 0;
    int oxy = 0;
    int ozy = 0;
    int flycnt = 0;
    boolean lrswt = false;
    boolean udswt = false;
    boolean gowait = false;
    int actwait = 0;
    int cntrn = 0;
    int revstart = 0;
    int oupnt = 0;
    int wtz = 0;
    int wtx = 0;
    int frx = 0;
    int frz = 0;
    int frad = 0;
    int apunch = 0;
    boolean exitattack = false;
    int avoidnlev = 0;
    
    public Control(Medium medium) {
	m = medium;
    }
    
    public void falseo(int i) {
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
    
    public void reset(CheckPoints checkpoints, int i) {
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
	if ((checkpoints).stage == 16
	    || (checkpoints).stage == 18)
	    hold = 50;
	if ((checkpoints).stage == 17)
	    hold = 10;
	if ((checkpoints).stage == 20)
	    hold = 30;
	if ((checkpoints).stage == 21) {
	    if (i != 13) {
		hold = 35;
		revstart = 25;
	    } else
		hold = 5;
	    statusque = 0;
	}
	if ((checkpoints).stage == 22) {
	    if (i != 13) {
		hold
		    = (int) (20.0F + 10.0F * m.random());
		revstart
		    = (int) (10.0F + 10.0F * m.random());
	    } else
		hold = 5;
	    statusque = 0;
	}
	if ((checkpoints).stage == 24) {
	    hold = 30;
	    statusque = 0;
	    if (i != 14)
		revstart = 1;
	}
	if ((checkpoints).stage == 25)
	    hold = 40;
	if ((checkpoints).stage == 26)
	    hold = 20;
	if ((checkpoints).stage != 19
	    && (checkpoints).stage != 26) {
	    for (int i_0_ = 0; i_0_ < (checkpoints).fn; i_0_++) {
		int i_1_ = -10;
		for (int i_2_ = 0; i_2_ < (checkpoints).n;
		     i_2_++) {
		    if (py((checkpoints).fx[i_0_] / 100,
			   (checkpoints).x[i_2_] / 100,
			   (checkpoints).fz[i_0_] / 100,
			   (checkpoints).z[i_2_] / 100) < i_1_
			|| i_1_ == -10) {
			i_1_ = py((checkpoints).fx[i_0_] / 100,
				  (checkpoints).x[i_2_] / 100,
				  (checkpoints).fz[i_0_] / 100,
				  (checkpoints).z[i_2_] / 100);
			fpnt[i_0_] = i_2_;
		    }
		}
	    }
	    for (int i_3_ = 0; i_3_ < (checkpoints).fn; i_3_++) {
		fpnt[i_3_] -= 4;
		if (fpnt[i_3_] < 0)
		    fpnt[i_3_]
			+= (checkpoints).nsp;
	    }
	} else {
	    if ((checkpoints).stage == 19) {
		fpnt[0] = 14;
		fpnt[1] = 36;
	    }
	    if ((checkpoints).stage == 26)
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
    
    public void preform(Mad mad, ContO conto, CheckPoints checkpoints,
			Trackers trackers) {
	left = false;
	right = false;
	up = false;
	down = false;
	handb = false;
	if (!(mad).dest) {
	    if ((mad).mtouch) {
		if (stcnt > statusque) {
		    int i = (checkpoints).stage;
		    if (i > 10)
			i -= 10;
		    acuracy
			= ((7
			    - (checkpoints).pos[(mad).im])
			   * (checkpoints).pos[0] * (6 - i * 2));
		    if (acuracy < 0
			|| (checkpoints).stage == -1)
			acuracy = 0;
		    clrnce = 5;
		    if ((checkpoints).stage == 16
			|| (checkpoints).stage == 21)
			clrnce = 2;
		    if ((checkpoints).stage == 22
			&& ((mad).pcleared == 27
			    || (mad).pcleared == 17))
			clrnce = 3;
		    if ((checkpoints).stage == 26
			&& (mad).pcleared == 33)
			clrnce = 3;
		    float f = 0.0F;
		    if ((checkpoints).stage == 1)
			f = 2.0F;
		    if ((checkpoints).stage == 2)
			f = 1.5F;
		    if ((checkpoints).stage == 3
			&& (mad).cn != 6)
			f = 0.5F;
		    if ((checkpoints).stage == 4)
			f = 0.5F;
		    if ((checkpoints).stage == 11)
			f = 2.0F;
		    if ((checkpoints).stage == 12)
			f = 1.5F;
		    if ((checkpoints).stage == 13
			&& (mad).cn != 9)
			f = 0.5F;
		    if ((checkpoints).stage == 14)
			f = 0.5F;
		    upwait
			= (int) ((float) (((checkpoints).pos[0]
					   - ((checkpoints).pos
					      [(mad).im]))
					  * ((checkpoints).pos[0]
					     - ((checkpoints).pos
						[(mad).im]))
					  * ((checkpoints).pos[0]
					     - ((checkpoints).pos
						[(mad).im])))
				 * f);
		    if (upwait > 80)
			upwait = 80;
		    if (((checkpoints).stage == 11
			 || (checkpoints).stage == 1)
			&& upwait < 20)
			upwait = 20;
		    f = 0.0F;
		    if ((checkpoints).stage == 1
			|| (checkpoints).stage == 2)
			f = 1.0F;
		    if ((checkpoints).stage == 4)
			f = 0.5F;
		    if ((checkpoints).stage == 7)
			f = 0.5F;
		    if ((checkpoints).stage == 10)
			f = 0.5F;
		    if ((checkpoints).stage == 11
			|| (checkpoints).stage == 12)
			f = 1.0F;
		    if ((checkpoints).stage == 13)
			f = 0.5F;
		    if ((checkpoints).stage == 14)
			f = 0.5F;
		    if ((checkpoints).stage == 15)
			f = 0.2F;
		    if (((checkpoints).pos[(mad).im]
			 - (checkpoints).pos[0])
			>= -1) {
			skiplev -= 0.1;
			if (skiplev < 0.0F)
			    skiplev = 0.0F;
		    } else {
			skiplev += 0.2;
			if (skiplev > f)
			    skiplev = f;
		    }
		    if ((checkpoints).stage == 18) {
			if ((mad).pcleared >= 10
			    && (mad).pcleared <= 24)
			    skiplev = 1.0F;
			else
			    skiplev = 0.0F;
		    }
		    if ((checkpoints).stage == 21) {
			skiplev = 0.0F;
			if ((mad).pcleared == 5)
			    skiplev = 1.0F;
			if ((mad).pcleared == 28
			    || (mad).pcleared == 35)
			    skiplev = 0.5F;
		    }
		    if ((checkpoints).stage == 23)
			skiplev = 0.5F;
		    if ((checkpoints).stage == 24
			|| (checkpoints).stage == 22)
			skiplev = 1.0F;
		    if ((checkpoints).stage == 26
			|| (checkpoints).stage == 25
			|| (checkpoints).stage == 20)
			skiplev = 0.0F;
		    rampp
			= (int) (m.random() * 4.0F - 2.0F);
		    if ((mad).power == 98.0F)
			rampp = -1;
		    if ((mad).power < 75.0F
			&& rampp == -1)
			rampp = 0;
		    if ((mad).power < 60.0F)
			rampp = 1;
		    if ((checkpoints).stage == 6)
			rampp = 2;
		    if ((checkpoints).stage == 18
			&& (mad).pcleared >= 45)
			rampp = 2;
		    if ((checkpoints).stage == 22
			&& (mad).pcleared == 17)
			rampp = 2;
		    if ((checkpoints).stage == 25
			|| (checkpoints).stage == 26)
			rampp = 0;
		    if (cntrn == 0) {
			agressed = false;
			turntyp
			    = (int) (m.random() * 4.0F);
			if ((checkpoints).stage == 3
			    && (mad).cn == 6) {
			    turntyp = 1;
			    if (attack == 0)
				agressed = true;
			}
			if ((checkpoints).stage == 9
			    && (mad).cn == 15) {
			    turntyp = 1;
			    if (attack == 0)
				agressed = true;
			}
			if ((checkpoints).stage == 13
			    && (mad).cn == 9) {
			    turntyp = 1;
			    if (attack == 0)
				agressed = true;
			}
			if (((checkpoints).pos[0]
			     - (checkpoints).pos[(mad).im])
			    < 0)
			    turntyp
				= (int) (m.random() * 2.0F);
			if ((checkpoints).stage == 10)
			    turntyp = 2;
			if ((checkpoints).stage == 18)
			    turntyp = 2;
			if ((checkpoints).stage == 20)
			    turntyp = 0;
			if ((checkpoints).stage == 23)
			    turntyp = 1;
			if ((checkpoints).stage == 24)
			    turntyp = 0;
			if (attack != 0) {
			    turntyp = 2;
			    if ((checkpoints).stage == 9
				|| (checkpoints).stage == 10
				|| (checkpoints).stage == 19
				|| (checkpoints).stage == 21
				|| (checkpoints).stage == 23
				|| (checkpoints).stage == 27)
				turntyp
				    = (int) (m.random()
					     * 3.0F);
			    if ((checkpoints).stage == 26
				&& ((((checkpoints).clear
				      [(mad).im])
				     - (checkpoints).clear[0])
				    >= 5))
				turntyp = 0;
			}
			if ((checkpoints).stage == 6) {
			    turntyp = 1;
			    agressed = true;
			}
			if ((checkpoints).stage == 7
			    || (checkpoints).stage == 9
			    || (checkpoints).stage == 10
			    || (checkpoints).stage == 16
			    || (checkpoints).stage == 17
			    || (checkpoints).stage == 19
			    || (checkpoints).stage == 20
			    || (checkpoints).stage == 21
			    || (checkpoints).stage == 22
			    || (checkpoints).stage == 24
			    || (checkpoints).stage == 26
			    || (checkpoints).stage == 27)
			    agressed = true;
			if ((checkpoints).stage == -1) {
			    if (m.random()
				> m.random())
				agressed = true;
			    else
				agressed = false;
			}
			cntrn = 5;
		    } else
			cntrn--;
		    saftey
			= (int) ((double) ((98.0F - (mad).power) / 2.0F)
				 * ((double) (m.random()
					      / 2.0F)
				    + 0.5));
		    if (saftey > 20)
			saftey = 20;
		    f = 0.0F;
		    if ((checkpoints).stage == 1
			|| (checkpoints).stage == 11)
			f = 0.9F;
		    if ((checkpoints).stage == 2
			|| (checkpoints).stage == 12)
			f = 0.7F;
		    if ((checkpoints).stage == 4
			|| (checkpoints).stage == 13)
			f = 0.4F;
		    mustland
			= f + (float) ((double) (m.random()
						 / 2.0F)
				       - 0.25);
		    f = 1.0F;
		    if ((checkpoints).stage == 1
			|| (checkpoints).stage == 11)
			f = 5.0F;
		    if ((checkpoints).stage == 2
			|| (checkpoints).stage == 12)
			f = 2.0F;
		    if ((checkpoints).stage == 4
			|| (checkpoints).stage == 13)
			f = 1.5F;
		    if ((mad).power > 50.0F) {
			if (((checkpoints).pos[0]
			     - (checkpoints).pos[(mad).im])
			    > 0)
			    saftey *= f;
			else
			    mustland = 0.0F;
		    } else
			mustland -= 0.5F;
		    if ((checkpoints).stage == 18
			|| (checkpoints).stage == 20
			|| (checkpoints).stage == 22
			|| (checkpoints).stage == 24)
			mustland = 0.0F;
		    stuntf = 0;
		    if ((checkpoints).stage == 8)
			stuntf = 17;
		    if ((checkpoints).stage == 18
			&& (mad).pcleared == 57)
			stuntf = 1;
		    if ((checkpoints).stage == 19
			&& (mad).pcleared == 3)
			stuntf = 2;
		    if ((checkpoints).stage == 20) {
			if (((checkpoints).pos[0]
			     < (checkpoints).pos[(mad).im])
			    || Math.abs((checkpoints).clear[0]
					- (mad).clear) >= 2
			    || (mad).clear < 2) {
			    stuntf = 4;
			    saftey = 10;
			} else
			    stuntf = 3;
		    }
		    if ((checkpoints).stage == 21
			&& (mad).pcleared == 21)
			stuntf = 1;
		    if ((checkpoints).stage == 24) {
			saftey = 10;
			if ((mad).pcleared >= 4
			    && (mad).pcleared < 70)
			    stuntf = 4;
			else if ((mad).cn == 12 || (mad).cn == 8)
			    stuntf = 2;
			if ((mad).cn == 14)
			    stuntf = 6;
		    }
		    if ((checkpoints).stage == 26) {
			mustland = 0.0F;
			saftey = 10;
			if (((mad).pcleared == 15
			     || (mad).pcleared == 51)
			    && ((double) m.random() > 0.4
				|| trfix != 0))
			    stuntf = 7;
			if ((mad).pcleared == 42)
			    stuntf = 1;
			if ((mad).pcleared == 77)
			    stuntf = 7;
			avoidnlev
			    = (int) (2700.0F * m.random());
		    }
		    trickprf
			= (((mad).power - 38.0F) / 50.0F
			   - m.random() / 2.0F);
		    if ((mad).power < 60.0F)
			trickprf = -1.0F;
		    if ((checkpoints).stage == 6
			&& (double) trickprf > 0.5)
			trickprf = 0.5F;
		    if ((checkpoints).stage == 3
			&& (mad).cn == 6
			&& (double) trickprf > 0.7)
			trickprf = 0.7F;
		    if ((checkpoints).stage == 13
			&& (mad).cn == 9
			&& (double) trickprf > 0.7)
			trickprf = 0.7F;
		    if ((checkpoints).stage == 16
			&& (double) trickprf > 0.3)
			trickprf = 0.3F;
		    if ((checkpoints).stage == 18
			&& (double) trickprf > 0.2)
			trickprf = 0.2F;
		    if ((checkpoints).stage == 19) {
			if ((double) trickprf > 0.5)
			    trickprf = 0.5F;
			if (((mad).im == 6 || (mad).im == 5)
			    && (double) trickprf > 0.3)
			    trickprf = 0.3F;
		    }
		    if ((checkpoints).stage == 21
			&& trickprf != -1.0F)
			trickprf *= 0.75F;
		    if ((checkpoints).stage == 22
			&& ((mad).pcleared == 55
			    || (mad).pcleared == 7)) {
			trickprf = -1.0F;
			stuntf = 5;
		    }
		    if ((checkpoints).stage == 23
			&& (double) trickprf > 0.4)
			trickprf = 0.4F;
		    if ((checkpoints).stage == 24
			&& (double) trickprf > 0.5)
			trickprf = 0.5F;
		    if ((checkpoints).stage == 27)
			trickprf = -1.0F;
		    if (m.random()
			> (mad).power / 100.0F)
			usebounce = true;
		    else
			usebounce = false;
		    if ((checkpoints).stage == 9)
			usebounce = false;
		    if ((checkpoints).stage == 14
			|| (checkpoints).stage == 16)
			usebounce = true;
		    if ((checkpoints).stage == 20
			|| (checkpoints).stage == 24)
			usebounce = false;
		    if (m.random()
			> ((float) (mad).hitmag
			   / (float) (((mad).cd).maxmag
				      [(mad).cn])))
			perfection = false;
		    else
			perfection = true;
		    if ((100.0F * (float) (mad).hitmag
			 / (float) (((mad).cd).maxmag
				    [(mad).cn]))
			> 60.0F)
			perfection = true;
		    if ((checkpoints).stage == 3
			&& (mad).cn == 6)
			perfection = true;
		    if ((checkpoints).stage == 6
			|| (checkpoints).stage == 8
			|| (checkpoints).stage == 9
			|| (checkpoints).stage == 10
			|| (checkpoints).stage == 16
			|| (checkpoints).stage == 18
			|| (checkpoints).stage == 19
			|| (checkpoints).stage == 20
			|| (checkpoints).stage == 21
			|| (checkpoints).stage == 22
			|| (checkpoints).stage == 24
			|| (checkpoints).stage == 26
			|| (checkpoints).stage == 27)
			perfection = true;
		    if (attack == 0) {
			boolean bool = true;
			if ((checkpoints).stage == 3
			    || (checkpoints).stage == 1
			    || (checkpoints).stage == 4
			    || (checkpoints).stage == 9
			    || (checkpoints).stage == 13
			    || (checkpoints).stage == 11
			    || (checkpoints).stage == 14
			    || (checkpoints).stage == 19
			    || (checkpoints).stage == 23
			    || (checkpoints).stage == 26)
			    bool = afta;
			if ((checkpoints).stage == 8
			    || (checkpoints).stage == 6
			    || (checkpoints).stage == 18
			    || (checkpoints).stage == 16
			    || (checkpoints).stage == 20
			    || (checkpoints).stage == 24)
			    bool = false;
			if ((checkpoints).stage == 3
			    && (mad).cn == 6)
			    bool = false;
			if ((checkpoints).stage == -1
			    && (m.random()
				> m.random()))
			    bool = false;
			boolean bool_4_ = false;
			if ((checkpoints).stage == 13
			    && (mad).cn == 9)
			    bool_4_ = true;
			if ((checkpoints).stage == 18
			    && (mad).cn == 11)
			    bool_4_ = true;
			if ((checkpoints).stage == 19
			    && (checkpoints).clear[0] >= 20)
			    bool_4_ = true;
			if ((checkpoints).stage == 4
			    || (checkpoints).stage == 10
			    || (checkpoints).stage == 21
			    || (checkpoints).stage == 22
			    || (checkpoints).stage == 23
			    || (checkpoints).stage == 25
			    || (checkpoints).stage == 26)
			    bool_4_ = true;
			if ((checkpoints).stage == 3
			    && (mad).cn == 6)
			    bool_4_ = true;
			int i_5_ = 60;
			if ((checkpoints).stage == 5)
			    i_5_ = 40;
			if ((checkpoints).stage == 6
			    && bulistc)
			    i_5_ = 40;
			if ((checkpoints).stage == 9
			    && bulistc)
			    i_5_ = 30;
			if ((checkpoints).stage == 3
			    || (checkpoints).stage == 13
			    || (checkpoints).stage == 21
			    || (checkpoints).stage == 27
			    || (checkpoints).stage == 20
			    || (checkpoints).stage == 18)
			    i_5_ = 30;
			if (((checkpoints).stage == 12
			     || (checkpoints).stage == 23)
			    && (mad).cn == 13)
			    i_5_ = 50;
			if ((checkpoints).stage == 14)
			    i_5_ = 20;
			if ((checkpoints).stage == 15
			    && (mad).im != 6)
			    i_5_ = 40;
			if ((checkpoints).stage == 17)
			    i_5_ = 40;
			if ((checkpoints).stage == 18
			    && (mad).cn == 11)
			    i_5_ = 40;
			if ((checkpoints).stage == 19 && bool_4_)
			    i_5_ = 30;
			if ((checkpoints).stage == 21
			    && bulistc)
			    i_5_ = 30;
			if ((checkpoints).stage == 22)
			    i_5_ = 50;
			if ((checkpoints).stage == 25
			    && bulistc)
			    i_5_ = 40;
			if ((checkpoints).stage == 26) {
			    if ((mad).cn == 11
				&& (checkpoints).clear[0] == 27)
				i_5_ = 0;
			    if ((mad).cn == 15 || (mad).cn == 9)
				i_5_ = 50;
			    if ((mad).cn == 11)
				i_5_ = 40;
			    if ((checkpoints).pos[0]
				> ((checkpoints).pos
				   [(mad).im]))
				i_5_ = 80;
			}
			for (int i_6_ = 0; i_6_ < 7; i_6_++) {
			    if (i_6_ != (mad).im
				&& ((checkpoints).clear[i_6_]
				    != -1)) {
				int i_7_ = (conto).xz;
				if (zyinv)
				    i_7_ += 180;
				for (/**/; i_7_ < 0; i_7_ += 360) {
				    /* empty */
				}
				for (/**/; i_7_ > 180; i_7_ -= 360) {
				    /* empty */
				}
				int i_8_ = 0;
				if (((checkpoints).opx[i_6_]
				     - (conto).x)
				    >= 0)
				    i_8_ = 180;
				int i_9_;
				for (i_9_
					 = (int) ((double) (90 + i_8_)
						  + ((Math.atan
						      ((double) (((
								   checkpoints)
								  .opz[i_6_])
								 - (
								    conto).z)
						       / (double) (((
								     checkpoints)
								    .opx[i_6_])
								   - ((
								       conto)
								      .x))))
						     / 0.017453292519943295));
				     i_9_ < 0; i_9_ += 360) {
				    /* empty */
				}
				for (/**/; i_9_ > 180; i_9_ -= 360) {
				    /* empty */
				}
				int i_10_ = Math.abs(i_7_ - i_9_);
				if (i_10_ > 180)
				    i_10_ = Math.abs(i_10_ - 360);
				int i_11_
				    = (2000
				       * (Math.abs(((checkpoints)
						    .clear[i_6_])
						   - (mad).clear)
					  + 1));
				if (((checkpoints).stage == 6
				     || (checkpoints).stage == 9)
				    && bulistc)
				    i_11_ = 6000;
				if ((checkpoints).stage == 3
				    && (mad).cn == 6
				    && (checkpoints).wasted < 2
				    && i_11_ > 4000)
				    i_11_ = 4000;
				if ((checkpoints).stage == 13
				    && (mad).cn == 9 && i_11_ < 12000)
				    i_11_ = 12000;
				if ((checkpoints).stage == 14
				    && i_11_ < 4000)
				    i_11_ = 4000;
				if ((checkpoints).stage == 18
				    && (mad).cn == 11) {
				    if (i_11_ < 12000)
					i_11_ = 12000;
				    i_10_ = 10;
				}
				if ((checkpoints).stage == 19
				    && ((mad).pcleared == 13
					|| (mad).pcleared == 33
					|| bool_4_)
				    && i_11_ < 12000)
				    i_11_ = 12000;
				if ((checkpoints).stage == 21) {
				    if (bulistc) {
					i_11_ = 8000;
					i_10_ = 10;
					afta = true;
				    } else if (i_11_ < 6000)
					i_11_ = 6000;
				}
				if ((checkpoints).stage == 22
				    && bulistc) {
				    i_11_ = 6000;
				    i_10_ = 10;
				}
				if ((checkpoints).stage == 23)
				    i_11_ = 21000;
				if ((checkpoints).stage == 25) {
				    i_11_ *= Math.abs((
						       checkpoints).clear[i_6_]
						      - (mad).clear) + 1;
				    if (bulistc) {
					i_11_
					    = (4000
					       * (Math.abs(((
							     checkpoints)
							    .clear[i_6_])
							   - (mad).clear)
						  + 1));
					i_10_ = 10;
				    }
				}
				if ((checkpoints).stage == 20)
				    i_11_ = 16000;
				if ((checkpoints).stage == 26) {
				    if ((mad).cn == 13
					&& bulistc) {
					if (oupnt == 33)
					    i_11_ = 17000;
					if (oupnt == 51)
					    i_11_ = 30000;
					if (oupnt == 15
					    && ((checkpoints)
						.clear[0]) >= 14)
					    i_11_ = 60000;
					i_10_ = 10;
				    }
				    if ((mad).cn == 15
					|| (mad).cn == 9)
					i_11_ *= (Math.abs(((
							     checkpoints)
							    .clear[i_6_])
							   - (mad).clear)
						  + 1);
				    if ((mad).cn == 11)
					i_11_
					    = (4000
					       * (Math.abs(((
							     checkpoints)
							    .clear[i_6_])
							   - (mad).clear)
						  + 1));
				}
				int i_12_
				    = 85 + 15 * (Math.abs(((
							    checkpoints)
							   .clear[i_6_])
							  - (mad).clear)
						 + 1);
				if ((checkpoints).stage == 23)
				    i_12_ = 45;
				if ((checkpoints).stage == 26
				    && ((mad).cn == 15
					|| (mad).cn == 9
					|| (mad).cn == 11
					|| (mad).cn == 14))
				    i_12_ = 50 + 70 * Math.abs(((
								 checkpoints)
								.clear[i_6_])
							       - ((mad)
								  .clear));
				if (i_10_ < i_12_
				    && py((conto).x / 100,
					  ((checkpoints).opx
					   [i_6_]) / 100,
					  (conto).z / 100,
					  ((checkpoints).opz
					   [i_6_]) / 100) < i_11_
				    && afta
				    && (mad).power > (float) i_5_) {
				    float f_13_
					= (float) (35
						   - (Math.abs(((
								 checkpoints)
								.clear[i_6_])
							       - ((mad)
								  .clear))
						      * 10));
				    if (f_13_ < 1.0F)
					f_13_ = 1.0F;
				    float f_14_
					= ((float) ((((
						       checkpoints)
						      .pos[(mad).im])
						     + 1)
						    * (5 - ((
							     checkpoints)
							    .pos[i_6_])))
					   / f_13_);
				    if ((checkpoints).stage != 27
					&& (double) f_14_ > 0.7)
					f_14_ = 0.7F;
				    if (i_6_ != 0
					&& ((checkpoints).pos[0]
					    < ((checkpoints).pos
					       [(mad).im])))
					f_14_ = 0.0F;
				    if (i_6_ != 0 && bool_4_)
					f_14_ = 0.0F;
				    if (bool_4_
					&& ((checkpoints).stage
					    == 3)
					&& i_6_ == 0) {
					if ((checkpoints).wasted
					    >= 2)
					    f_14_ *= 0.5F;
					else
					    f_14_ = 0.0F;
				    }
				    if (((checkpoints).stage == 3
					 || ((checkpoints).stage
					     == 9))
					&& i_6_ == 4)
					f_14_ = 0.0F;
				    if ((checkpoints).stage
					== 6) {
					f_14_ = 0.0F;
					if (bulistc
					    && i_6_ == 0)
					    f_14_ = 1.0F;
				    }
				    if ((checkpoints).stage
					== 8) {
					f_14_ = 0.0F;
					if (bulistc
					    && (mad).cn != 11
					    && (mad).cn != 13)
					    f_14_ = 1.0F;
				    }
				    if ((checkpoints).stage == 9
					&& (mad).cn == 15)
					f_14_ = 0.0F;
				    if ((checkpoints).stage == 9
					&& bulistc) {
					if (i_6_ == 0)
					    f_14_ = 1.0F;
					else
					    f_14_ = 0.0F;
				    }
				    if ((checkpoints).stage == 9
					&& (((checkpoints).pos
					     [i_6_]) == 4
					    || ((checkpoints).pos
						[i_6_]) == 3))
					f_14_ = 0.0F;
				    if ((checkpoints).stage
					== 13) {
					if ((mad).cn == 9
					    || ((mad).cn == 13
						&& bulistc))
					    f_14_ *= 2.0F;
					else
					    f_14_ *= 0.5F;
				    }
				    if ((checkpoints).stage
					== 16)
					f_14_ = 0.0F;
				    if ((checkpoints).stage == 17
					&& (mad).im == 6 && i_6_ == 0)
					f_14_ *= 1.5;
				    if ((checkpoints).stage
					== 18) {
					if ((mad).cn == 11
					    || ((mad).cn == 13
						&& bulistc))
					    f_14_ *= 1.5F;
					else
					    f_14_ = 0.0F;
				    }
				    if ((checkpoints).stage
					== 19) {
					if (i_6_ != 0)
					    f_14_ *= 0.5;
					if ((mad).pcleared != 13
					    && (mad).pcleared != 33
					    && !bool_4_)
					    f_14_ *= 0.5F;
					if (((mad).im == 6
					     || (mad).im == 5)
					    && i_6_ != 0)
					    f_14_ = 0.0F;
				    }
				    if ((checkpoints).stage
					== 20) {
					f_14_ = 0.0F;
					if (bulistc
					    && (mad).cn != 11
					    && (mad).cn != 13)
					    f_14_ = 1.0F;
				    }
				    if ((checkpoints).stage == 21
					&& bulistc
					&& i_6_ == 0)
					f_14_ = 1.0F;
				    if ((checkpoints).stage
					== 22) {
					if ((mad).cn != 11
					    && (mad).cn != 13)
					    f_14_ = 0.0F;
					if ((mad).cn == 13 && i_6_ == 0)
					    f_14_ = 1.0F;
				    }
				    if ((checkpoints).stage
					== 24)
					f_14_ = 0.0F;
				    if ((checkpoints).stage
					== 25) {
					if (((checkpoints).pos
					     [(mad).im])
					    == 0)
					    f_14_ *= 0.5;
					if ((checkpoints).pos[0]
					    < ((checkpoints).pos
					       [(mad).im]))
					    f_14_ *= 2.0F;
					if (bulistc
					    && i_6_ == 0)
					    f_14_ = 1.0F;
				    }
				    if ((checkpoints).stage
					== 26) {
					if ((mad).cn != 14) {
					    if ((((checkpoints)
						  .pos[0])
						 < ((checkpoints)
						    .pos[(mad).im]))
						&& ((
						     checkpoints).clear[0]
						    - ((
							checkpoints)
						       .clear
						       [(mad).im])) != 1)
						f_14_ *= 2.0F;
					} else
					    f_14_ *= 0.5;
					if ((mad).cn == 13 && i_6_ == 0)
					    f_14_ = 1.0F;
					if (((checkpoints).pos
					     [(mad).im]) == 0
					    || (((checkpoints)
						 .pos[(mad).im]) == 1
						&& ((checkpoints)
						    .pos[0]) == 0))
					    f_14_ = 0.0F;
					if ((((checkpoints).clear
					      [(mad).im])
					     - ((checkpoints)
						.clear[0])) >= 5
					    && i_6_ == 0)
					    f_14_ = 1.0F;
					if ((mad).cn == 10
					    || (mad).cn == 12)
					    f_14_ = 0.0F;
				    }
				    if (m.random() < f_14_) {
					attack
					    = (40
					       * (Math.abs(((
							     checkpoints)
							    .clear[i_6_])
							   - (mad).clear)
						  + 1));
					if (attack > 500)
					    attack = 500;
					aim = 0.0F;
					if (((checkpoints).stage
					     == 13)
					    && (mad).cn == 9
					    && (m.random()
						> m.random()))
					    aim = 1.0F;
					if ((checkpoints).stage
					    == 14) {
					    if (i_6_ == 0
						&& ((
						     checkpoints).pos[0]
						    < ((
							checkpoints)
						       .pos[(mad).im])))
						aim = 1.5F;
					    else
						aim
						    = m
							  .random();
					}
					if ((checkpoints).stage
					    == 15)
					    aim
						= (m.random()
						   * 1.5F);
					if (((checkpoints).stage
					     == 17)
					    && (mad).im != 6
					    && ((m.random()
						 > m.random())
						|| ((
						     checkpoints).pos[0]
						    < ((
							checkpoints)
						       .pos[(mad).im]))))
					    aim = 1.0F;
					if (((checkpoints).stage
					     == 18)
					    && (mad).cn == 11
					    && (m.random()
						> m.random()))
					    aim
						= 0.76F + (this
							       .m.random()
							   * 0.76F);
					if (((checkpoints).stage
					     == 19)
					    && ((mad).pcleared == 13
						|| (mad).pcleared == 33))
					    aim = 1.0F;
					if ((checkpoints).stage
					    == 21) {
					    if (bulistc) {
						aim = 0.7F;
						if (attack
						    > 150)
						    attack
							= 150;
					    } else
						aim
						    = m
							  .random();
					}
					if ((checkpoints).stage
					    == 22) {
					    if (m.random()
						> m.random())
						aim = 0.7F;
					    if (bulistc
						&& (attack
						    > 150))
						attack = 150;
					}
					if (((checkpoints).stage
					     == 23)
					    && attack > 60)
					    attack = 60;
					if ((checkpoints).stage
					    == 25) {
					    aim
						= (m.random()
						   * 1.5F);
					    attack
						= attack / 2;
					    if (m.random()
						> m.random())
						exitattack
						    = true;
					    else
						exitattack
						    = false;
					}
					if ((checkpoints).stage
					    == 26) {
					    if ((mad).cn == 13) {
						aim = 0.76F;
						attack = 150;
					    } else {
						aim
						    = m
							  .random() * 1.5F;
						if (Math.abs(((
							       checkpoints)
							      .clear[i_6_])
							     - ((mad)
								.clear)) <= 2
						    || (mad).cn == 14)
						    attack
							= (this
							   .attack) / 3;
					    }
					}
					if (((checkpoints).stage
					     == -1)
					    && (m.random()
						> m.random()))
					    aim
						= (m.random()
						   * 1.5F);
					acr = i_6_;
					turntyp
					    = (int) (1.0F
						     + m
							   .random() * 2.0F);
				    }
				}
				if (bool && i_10_ > 100
				    && py((conto).x / 100,
					  ((checkpoints).opx
					   [i_6_]) / 100,
					  (conto).z / 100,
					  ((checkpoints).opz
					   [i_6_]) / 100) < 300
				    && ((double) m.random()
					> (0.6
					   - (double) ((float) ((
								 checkpoints)
								.pos
								[((mad)
								  .im)])
						       / 10.0F)))) {
				    clrnce = 0;
				    acuracy = 0;
				}
			    }
			}
		    }
		    boolean bool = false;
		    if ((checkpoints).stage == 6
			|| (checkpoints).stage == 8)
			bool = true;
		    if ((checkpoints).stage == 9
			&& (mad).cn == 15)
			bool = true;
		    if ((checkpoints).stage == 16
			|| (checkpoints).stage == 20
			|| (checkpoints).stage == 21
			|| (checkpoints).stage == 27)
			bool = true;
		    if ((checkpoints).stage == 18
			&& (mad).pcleared != 73)
			bool = true;
		    if ((checkpoints).stage == -1
			&& (m.random()
			    > m.random()))
			bool = true;
		    if (trfix != 3) {
			trfix = 0;
			int i_15_ = 50;
			if ((checkpoints).stage == 26)
			    i_15_ = 40;
			if ((100.0F * (float) (mad).hitmag
			     / (float) (((mad).cd).maxmag
					[(mad).cn]))
			    > (float) i_15_)
			    trfix = 1;
			if (!bool) {
			    int i_16_ = 80;
			    if ((checkpoints).stage == 18
				&& (mad).cn != 11)
				i_16_ = 50;
			    if ((checkpoints).stage == 19)
				i_16_ = 70;
			    if ((checkpoints).stage == 25
				&& (mad).pcleared == 91)
				i_16_ = 50;
			    if ((checkpoints).stage == 26
				&& ((((checkpoints).clear
				      [(mad).im])
				     - (checkpoints).clear[0])
				    >= 5)
				&& (mad).cn != 10
				&& (mad).cn != 12)
				i_16_ = 50;
			    if ((100.0F * (float) (mad).hitmag
				 / (float) (((mad).cd).maxmag
					    [(mad).cn]))
				> (float) i_16_)
				trfix = 2;
			}
		    } else {
			upwait = 0;
			acuracy = 0;
			skiplev = 1.0F;
			clrnce = 2;
		    }
		    if (!bulistc) {
			if ((checkpoints).stage == 18
			    && (mad).cn == 11
			    && (mad).pcleared == 35) {
			    (mad).pcleared = 73;
			    (mad).clear = 0;
			    bulistc = true;
			    runbul
				= (int) (100.0F * m.random());
			}
			if ((checkpoints).stage == 21
			    && (mad).cn == 13)
			    bulistc = true;
			if ((checkpoints).stage == 22
			    && (mad).cn == 13)
			    bulistc = true;
			if ((checkpoints).stage == 25
			    && ((checkpoints).clear[0]
				- (mad).clear) >= 3
			    && trfix == 0) {
			    bulistc = true;
			    oupnt = -1;
			}
			if ((checkpoints).stage == 26) {
			    if ((mad).cn == 13
				&& (checkpoints).pcleared == 8) {
				bulistc = true;
				attack = 0;
			    }
			    if ((mad).cn == 11
				&& ((checkpoints).clear[0]
				    - (mad).clear) >= 2
				&& trfix == 0) {
				bulistc = true;
				oupnt = -1;
			    }
			}
			if (((checkpoints).stage == 6
			     || (checkpoints).stage == 8
			     || (checkpoints).stage == 12
			     || (checkpoints).stage == 13
			     || (checkpoints).stage == 14
			     || (checkpoints).stage == 15
			     || (checkpoints).stage == 18
			     || (checkpoints).stage == 20
			     || (checkpoints).stage == 23)
			    && (mad).cn == 13
			    && Math.abs((checkpoints).clear[0]
					- (mad).clear) >= 2)
			    bulistc = true;
			if (((checkpoints).stage == 8
			     || (checkpoints).stage == 20)
			    && (mad).cn == 11
			    && Math.abs((checkpoints).clear[0]
					- (mad).clear) >= 1)
			    bulistc = true;
			if ((checkpoints).stage == 6
			    && (mad).cn == 11)
			    bulistc = true;
			if ((checkpoints).stage == 9
			    && afta
			    && (((checkpoints).pos
				 [(mad).im]) == 4
				|| ((checkpoints).pos
				    [(mad).im]) == 3)
			    && (mad).cn != 15
			    && trfix != 0)
			    bulistc = true;
		    } else if ((checkpoints).stage == 18) {
			runbul--;
			if ((mad).pcleared == 10)
			    runbul = 0;
			if (runbul <= 0)
			    bulistc = false;
		    }
		    stcnt = 0;
		    statusque
			= (int) (20.0F * m.random());
		} else
		    stcnt++;
	    }
	    boolean bool = false;
	    if (usebounce)
		bool = (mad).wtouch;
	    else
		bool = (mad).mtouch;
	    if (bool) {
		if (trickfase != 0)
		    trickfase = 0;
		if (trfix == 2 || trfix == 3)
		    attack = 0;
		if (attack == 0) {
		    if (upcnt < 30) {
			if (revstart <= 0)
			    up = true;
			else {
			    down = true;
			    revstart--;
			}
		    }
		    if (upcnt < 25 + actwait)
			upcnt++;
		    else {
			upcnt = 0;
			actwait = upwait;
		    }
		    int i = (mad).point;
		    int i_17_ = 50;
		    if ((checkpoints).stage == 9)
			i_17_ = 20;
		    if ((checkpoints).stage == 18)
			i_17_ = 20;
		    if ((checkpoints).stage == 25)
			i_17_ = 40;
		    if ((checkpoints).stage == 26)
			i_17_ = 20;
		    if (!bulistc
			|| trfix == 2
			|| trfix == 3
			|| trfix == 4
			|| (mad).power < (float) i_17_) {
			if (rampp == 1
			    && (checkpoints).typ[i] <= 0) {
			    int i_18_ = i + 1;
			    if (i_18_ >= (checkpoints).n)
				i_18_ = 0;
			    if ((checkpoints).typ[i_18_] == -2)
				i = i_18_;
			}
			if (rampp == -1
			    && (checkpoints).typ[i] == -2
			    && ++i >= (checkpoints).n)
			    i = 0;
			if (m.random()
			    > skiplev) {
			    int i_19_ = i;
			    boolean bool_20_ = false;
			    if ((checkpoints).typ[i_19_] > 0) {
				int i_21_ = 0;
				for (int i_22_ = 0;
				     i_22_ < (checkpoints).n;
				     i_22_++) {
				    if (((checkpoints).typ[i_22_]
					 > 0)
					&& i_22_ < i_19_)
					i_21_++;
				}
				bool_20_ = ((mad).clear
					    != i_21_ + ((mad).nlaps
							* (
							   checkpoints).nsp));
			    }
			    while ((checkpoints).typ[i_19_] == 0
				   || ((checkpoints).typ[i_19_]
				       == -1)
				   || ((checkpoints).typ[i_19_]
				       == -3)
				   || bool_20_) {
				i = i_19_;
				if (++i_19_ >= (checkpoints).n)
				    i_19_ = 0;
				bool_20_ = false;
				if ((checkpoints).typ[i_19_]
				    > 0) {
				    int i_23_ = 0;
				    for (int i_24_ = 0;
					 i_24_ < (checkpoints).n;
					 i_24_++) {
					if (((checkpoints).typ
					     [i_24_]) > 0
					    && i_24_ < i_19_)
					    i_23_++;
				    }
				    bool_20_
					= ((mad).clear
					   != i_23_ + ((mad).nlaps
						       * (
							  checkpoints).nsp));
				}
			    }
			} else if (m.random()
				   > skiplev) {
			    while ((checkpoints).typ[i] == -1) {
				if (++i >= (checkpoints).n)
				    i = 0;
			    }
			}
			if ((checkpoints).stage == 18
			    && (mad).pcleared == 73
			    && trfix == 0
			    && (mad).clear != 0)
			    i = 10;
			if ((checkpoints).stage == 19
			    && (mad).pcleared == 18
			    && trfix == 0)
			    i = 27;
			if ((checkpoints).stage == 21) {
			    if ((mad).pcleared == 5
				&& trfix == 0
				&& (mad).power < 70.0F) {
				if (i <= 16)
				    i = 16;
				else
				    i = 21;
			    }
			    if ((mad).pcleared == 50)
				i = 57;
			}
			if ((checkpoints).stage == 22
			    && ((mad).pcleared == 27
				|| (mad).pcleared == 37)) {
			    while ((checkpoints).typ[i] == -1) {
				if (++i >= (checkpoints).n)
				    i = 0;
			    }
			}
			if ((checkpoints).stage == 23) {
			    while ((checkpoints).typ[i] == -1) {
				if (++i >= (checkpoints).n)
				    i = 0;
			    }
			}
			if ((checkpoints).stage == 24) {
			    while ((checkpoints).typ[i] == -1) {
				if (++i >= (checkpoints).n)
				    i = 0;
			    }
			    if (!(mad).gtouch) {
				while ((checkpoints).typ[i]
				       == -2) {
				    if (++i >= (checkpoints).n)
					i = 0;
				}
			    }
			    if (oupnt >= 68)
				i = 70;
			    else
				oupnt = i;
			}
			if ((checkpoints).stage == 25) {
			    if (((mad).pcleared != 91
				 && ((checkpoints).pos[0]
				     < ((checkpoints).pos
					[(mad).im]))
				 && (mad).cn != 13)
				|| (((checkpoints).pos
				     [(mad).im]) == 0
				    && ((mad).clear == 12
					|| (mad).clear == 20))) {
				while ((checkpoints).typ[i]
				       == -4) {
				    if (++i >= (checkpoints).n)
					i = 0;
				}
			    }
			    if ((mad).pcleared == 9) {
				if (py((conto).x / 100, 297,
				       (conto).z / 100, 347)
				    < 400)
				    oupnt = 1;
				if (oupnt == 1 && i < 22)
				    i = 22;
			    }
			    if ((mad).pcleared == 67) {
				if (py((conto).x / 100, 28,
				       (conto).z / 100, 494)
				    < 4000)
				    oupnt = 2;
				if (oupnt == 2)
				    i = 76;
			    }
			    if ((mad).pcleared == 76) {
				if (py((conto).x / 100, -50,
				       (conto).z / 100, 0)
				    < 2000)
				    oupnt = 3;
				if (oupnt == 3)
				    i = 91;
				else
				    i = 89;
			    }
			}
			if ((checkpoints).stage == 26) {
			    if ((mad).pcleared == 128) {
				if (py((conto).x / 100, 0,
				       (conto).z / 100, 229) < 1500
				    || (conto).z > 23000)
				    oupnt = 128;
				if (oupnt != 128)
				    i = 3;
			    }
			    if ((mad).pcleared == 8) {
				if (py((conto).x / 100, -207,
				       (conto).z / 100, 549) < 1500
				    || (conto).x < -20700)
				    oupnt = 8;
				if (oupnt != 8)
				    i = 12;
			    }
			    if ((mad).pcleared == 33) {
				if (py((conto).x / 100, -60,
				       (conto).z / 100, 168) < 250
				    || (conto).z > 17000)
				    oupnt = 331;
				if (py((conto).x / 100, -112,
				       (conto).z / 100, 414) < 10000
				    || (conto).z > 40000)
				    oupnt = 332;
				if (oupnt != 331
				    && oupnt != 332) {
				    if (trfix != 1)
					i = 38;
				    else
					i = 39;
				}
				if (oupnt == 331)
				    i = 71;
			    }
			    if ((mad).pcleared == 42) {
				if (py((conto).x / 100, -269,
				       (conto).z / 100, 493) < 100
				    || (conto).x < -27000)
				    oupnt = 142;
				if (oupnt != 142)
				    i = 47;
			    }
			    if ((mad).pcleared == 51) {
				if (py((conto).x / 100, -352,
				       (conto).z / 100, 260) < 100
				    || (conto).z < 25000)
				    oupnt = 511;
				if (py((conto).x / 100, -325,
				       (conto).z / 100, 10) < 2000
				    || (conto).x > -32000)
				    oupnt = 512;
				if (oupnt != 511
				    && oupnt != 512)
				    i = 80;
				if (oupnt == 511)
				    i = 61;
			    }
			    if ((mad).pcleared == 77) {
				if (py((conto).x / 100, -371,
				       (conto).z / 100, 319) < 100
				    || (conto).z < 31000)
				    oupnt = 77;
				if (oupnt != 77) {
				    i = 78;
				    (mad).nofocus = true;
				}
			    }
			    if ((mad).pcleared == 105) {
				if (py((conto).x / 100, -179,
				       (conto).z / 100, 10) < 2300
				    || (conto).z < 1050)
				    oupnt = 105;
				if (oupnt != 105)
				    i = 65;
				else
				    i = 125;
			    }
			    if (trfix == 3) {
				if (py((conto).x / 100, -52,
				       (conto).z / 100, 448) < 100
				    || (conto).z > 45000)
				    oupnt = 176;
				if (oupnt != 176)
				    i = 41;
				else
				    i = 43;
			    }
			    if ((((checkpoints).clear
				  [(mad).im])
				 - (checkpoints).clear[0]) >= 2
				&& (py((conto).x / 100,
				       ((checkpoints).opx[0]
					/ 100),
				       (conto).z / 100,
				       ((checkpoints).opz[0]
					/ 100))
				    < 1000 + avoidnlev)) {
				int i_25_ = (conto).xz;
				if (zyinv)
				    i_25_ += 180;
				for (/**/; i_25_ < 0; i_25_ += 360) {
				    /* empty */
				}
				for (/**/; i_25_ > 180; i_25_ -= 360) {
				    /* empty */
				}
				int i_26_ = 0;
				if (((checkpoints).opx[0]
				     - (conto).x)
				    >= 0)
				    i_26_ = 180;
				int i_27_;
				for (i_27_
					 = (int) ((double) (90 + i_26_)
						  + ((Math.atan
						      ((double) (((
								   checkpoints)
								  .opz[0])
								 - (
								    conto).z)
						       / (double) (((
								     checkpoints)
								    .opx[0])
								   - ((
								       conto)
								      .x))))
						     / 0.017453292519943295));
				     i_27_ < 0; i_27_ += 360) {
				    /* empty */
				}
				for (/**/; i_27_ > 180; i_27_ -= 360) {
				    /* empty */
				}
				int i_28_ = Math.abs(i_25_ - i_27_);
				if (i_28_ > 180)
				    i_28_ = Math.abs(i_28_ - 360);
				if (i_28_ < 90)
				    wall = 0;
			    }
			}
			if (rampp == 2) {
			    int i_29_ = i + 1;
			    if (i_29_ >= (checkpoints).n)
				i_29_ = 0;
			    if ((checkpoints).typ[i_29_] == -2
				&& i != (mad).point && --i < 0)
				i += (checkpoints).n;
			}
			if (bulistc) {
			    (mad).nofocus = true;
			    if (gowait)
				gowait = false;
			}
		    } else {
			if (((checkpoints).stage != 25
			     && (checkpoints).stage != 26)
			    || runbul == 0) {
			    i -= 2;
			    if (i < 0)
				i += (checkpoints).n;
			    if ((checkpoints).stage == 9
				&& i > 76)
				i = 76;
			    while ((checkpoints).typ[i] == -4) {
				if (--i < 0)
				    i += (checkpoints).n;
			    }
			}
			if ((checkpoints).stage == 21) {
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
			if ((checkpoints).stage == 22) {
			    if (!gowait) {
				if ((checkpoints).clear[0]
				    == 0) {
				    wtx = -3500;
				    wtz = 19000;
				    frx = -3500;
				    frz = 39000;
				    frad = 12000;
				    oupnt = 37;
				    gowait = true;
				    afta = false;
				}
				if ((checkpoints).clear[0]
				    == 7) {
				    wtx = -44800;
				    wtz = 40320;
				    frx = -44800;
				    frz = 34720;
				    frad = 30000;
				    oupnt = 27;
				    gowait = true;
				    afta = false;
				}
				if ((checkpoints).clear[0]
				    == 10) {
				    wtx = 0;
				    wtz = 48739;
				    frx = 0;
				    frz = 38589;
				    frad = 90000;
				    oupnt = 55;
				    gowait = true;
				    afta = false;
				}
				if ((checkpoints).clear[0]
				    == 14) {
				    wtx = -3500;
				    wtz = 19000;
				    frx = -14700;
				    frz = 39000;
				    frad = 45000;
				    oupnt = 37;
				    gowait = true;
				    afta = false;
				}
				if ((checkpoints).clear[0]
				    == 18) {
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
				if (py((conto).x / 100,
				       wtx / 100,
				       (conto).z / 100,
				       wtz / 100) < 10000
				    && (mad).speed > 50.0F)
				    up = false;
				if (py((conto).x / 100,
				       wtx / 100,
				       (conto).z / 100,
				       wtz / 100)
				    < 200) {
				    up = false;
				    handb = true;
				}
				if (((checkpoints).pcleared
				     == oupnt)
				    && (py(((checkpoints).opx[0]
					    / 100),
					   frx / 100,
					   ((checkpoints).opz[0]
					    / 100),
					   frz / 100)
					< frad)) {
				    afta = true;
				    gowait = false;
				}
				if (py((conto).x / 100,
				       ((checkpoints).opx[0]
					/ 100),
				       (conto).z / 100,
				       ((checkpoints).opz[0]
					/ 100))
				    < 25) {
				    afta = true;
				    gowait = false;
				    attack = 200;
				    acr = 0;
				}
			    }
			}
			if ((checkpoints).stage == 25) {
			    if (oupnt == -1) {
				int i_30_ = -10;
				for (int i_31_ = 0;
				     i_31_ < (checkpoints).n;
				     i_31_++) {
				    if ((((checkpoints).typ
					  [i_31_]) == -2
					 || ((checkpoints).typ
					     [i_31_]) == -4)
					&& (i_31_ < 50 || i_31_ > 54)
					&& (py((conto).x / 100,
					       ((checkpoints).x
						[i_31_]) / 100,
					       (conto).z / 100,
					       ((checkpoints).z
						[i_31_]) / 100) < i_30_
					    || i_30_ == -10)) {
					i_30_ = py((conto).x / 100,
						   ((checkpoints)
						    .x[i_31_]) / 100,
						   (conto).z / 100,
						   ((checkpoints)
						    .z[i_31_]) / 100);
					oupnt = i_31_;
				    }
				}
				oupnt--;
				if (i < 0)
				    oupnt
					+= (checkpoints).n;
			    }
			    if (oupnt >= 0
				&& (oupnt
				    < (checkpoints).n)) {
				i = oupnt;
				if (py((conto).x / 100,
				       (checkpoints).x[i] / 100,
				       (conto).z / 100,
				       (checkpoints).z[i] / 100)
				    < 800) {
				    oupnt
					= -(int) (75.0F
						  + m
							.random() * 200.0F);
				    runbul
					= (int) (50.0F
						 + (m.random()
						    * 100.0F));
				}
			    }
			    if (oupnt < -1)
				oupnt++;
			    if (runbul != 0)
				runbul--;
			}
			if ((checkpoints).stage == 26) {
			    boolean bool_32_ = false;
			    if ((mad).cn == 13) {
				if (!gowait) {
				    if ((checkpoints).clear[0]
					== 1) {
					if ((double) m
							 .random()
					    > 0.5) {
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
				    if ((checkpoints).clear[0]
					== 4) {
					wtx = -12700;
					wtz = 14000;
					frx = -31000;
					frz = 1050;
					frad = 11000;
					oupnt = 51;
					gowait = true;
					afta = false;
				    }
				    if ((checkpoints).clear[0]
					== 14) {
					wtx = -35350;
					wtz = 6650;
					frx = -48300;
					frz = 54950;
					frad = 11000;
					oupnt = 15;
					gowait = true;
					afta = false;
				    }
				    if ((checkpoints).clear[0]
					== 17) {
					wtx = -42700;
					wtz = 41000;
					frx = -40950;
					frz = 49350;
					frad = 7000;
					oupnt = 42;
					gowait = true;
					afta = false;
				    }
				    if ((checkpoints).clear[0]
					== 21) {
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
				    if (py((conto).x / 100,
					   wtx / 100,
					   (conto).z / 100,
					   wtz / 100) < 10000
					&& (mad).speed > 50.0F)
					up = false;
				    if (py((conto).x / 100,
					   wtx / 100,
					   (conto).z / 100,
					   wtz / 100)
					< 200) {
					up = false;
					handb = true;
				    }
				    if (((checkpoints).pcleared
					 == oupnt)
					&& (py(((checkpoints).opx
						[0]) / 100,
					       frx / 100,
					       ((checkpoints).opz
						[0]) / 100,
					       frz / 100)
					    < frad)) {
					runbul = 0;
					afta = true;
					gowait = false;
				    }
				    if (py((conto).x / 100,
					   ((checkpoints).opx[0]
					    / 100),
					   (conto).z / 100,
					   ((checkpoints).opz[0]
					    / 100))
					< 25) {
					afta = true;
					gowait = false;
					attack = 200;
					acr = 0;
				    }
				    if (((checkpoints).clear[0]
					 == 21)
					&& oupnt != 125)
					gowait = false;
				}
				if (((checkpoints).clear[0] >= 11
				     && !gowait)
				    || ((mad).power < 60.0F
					&& ((checkpoints).clear
					    [0]) < 21)) {
				    bool_32_ = true;
				    if (!exitattack) {
					oupnt = -1;
					exitattack = true;
				    }
				} else if (exitattack)
				    exitattack = false;
			    }
			    if ((mad).cn == 11)
				bool_32_ = true;
			    if (bool_32_) {
				if (oupnt == -1) {
				    int i_33_ = -10;
				    for (int i_34_ = 0;
					 i_34_ < (checkpoints).n;
					 i_34_++) {
					if (((checkpoints).typ
					     [i_34_]) == -4
					    && ((py((conto).x / 100,
						    ((
						      checkpoints).x[i_34_]
						     / 100),
						    (conto).z / 100,
						    ((
						      checkpoints).z[i_34_]
						     / 100)) < i_33_
						 && ((double) this
								  .m.random()
						     > 0.6))
						|| i_33_ == -10)) {
					    i_33_ = py((conto).x / 100,
						       ((
							 checkpoints).x[i_34_]
							/ 100),
						       (conto).z / 100,
						       ((
							 checkpoints).z[i_34_]
							/ 100));
					    oupnt = i_34_;
					}
				    }
				    oupnt--;
				    if (i < 0)
					oupnt
					    += (checkpoints).n;
				}
				if (oupnt >= 0
				    && (oupnt
					< (checkpoints).n)) {
				    i = oupnt;
				    if (py((conto).x / 100,
					   ((checkpoints).x[i]
					    / 100),
					   (conto).z / 100,
					   ((checkpoints).z[i]
					    / 100))
					< 800) {
					oupnt
					    = -(int) (75.0F + (this
								   .m.random()
							       * 200.0F));
					runbul
					    = (int) (50.0F
						     + m
							   .random() * 100.0F);
				    }
				}
				if (oupnt < -1)
				    oupnt++;
				if (runbul != 0)
				    runbul--;
			    }
			}
			(mad).nofocus = true;
		    }
		    if ((checkpoints).stage != 27) {
			if ((checkpoints).stage == 10
			    || (checkpoints).stage == 19
			    || ((checkpoints).stage == 18
				&& (mad).pcleared == 73)
			    || (checkpoints).stage == 26)
			    forget = true;
			if (((mad).missedcp == 0
			     || forget
			     || trfix == 4)
			    && trfix != 0) {
			    int i_35_ = 0;
			    if ((checkpoints).stage == 25
				|| (checkpoints).stage == 26)
				i_35_ = 3;
			    if (trfix == 2) {
				int i_36_ = -10;
				int i_37_ = 0;
				for (int i_38_ = i_35_;
				     i_38_ < (checkpoints).fn;
				     i_38_++) {
				    if (py((conto).x / 100,
					   (((checkpoints).x
					     [fpnt[i_38_]])
					    / 100),
					   (conto).z / 100,
					   (((checkpoints).z
					     [fpnt[i_38_]])
					    / 100)) < i_36_
					|| i_36_ == -10) {
					i_36_
					    = py((conto).x / 100,
						 ((checkpoints).x
						  [(fpnt
						    [i_38_])]) / 100,
						 (conto).z / 100,
						 ((checkpoints).z
						  [(fpnt
						    [i_38_])]) / 100);
					i_37_ = i_38_;
				    }
				}
				if ((checkpoints).stage == 18
				    || (checkpoints).stage == 22)
				    i_37_ = 1;
				i = fpnt[i_37_];
				if ((checkpoints).special[i_37_])
				    forget = true;
				else
				    forget = false;
			    }
			    for (int i_39_ = i_35_;
				 i_39_ < (checkpoints).fn;
				 i_39_++) {
				if (py((conto).x / 100,
				       ((checkpoints).x
					[fpnt[i_39_]]) / 100,
				       (conto).z / 100,
				       ((checkpoints).z
					[fpnt[i_39_]]) / 100)
				    < 2000) {
				    forget = false;
				    actwait = 0;
				    upwait = 0;
				    turntyp = 2;
				    randtcnt = -1;
				    acuracy = 0;
				    rampp = 0;
				    trfix = 3;
				}
			    }
			    if (trfix == 3)
				(mad).nofocus = true;
			}
		    }
		    if (turncnt > randtcnt) {
			if (!gowait) {
			    int i_40_ = 0;
			    if (((checkpoints).x[i]
				 - (conto).x)
				>= 0)
				i_40_ = 180;
			    pan
				= (int) ((double) (90 + i_40_)
					 + ((Math.atan
					     ((double) ((
							 checkpoints).z[i]
							- (conto).z)
					      / (double) ((
							   checkpoints).x[i]
							  - ((conto)
							     .x))))
					    / 0.017453292519943295));
			} else {
			    int i_41_ = 0;
			    if (wtx - (conto).x >= 0)
				i_41_ = 180;
			    pan
				= (int) ((double) (90 + i_41_)
					 + ((Math.atan
					     ((double) (wtz
							- (conto).z)
					      / (double) (wtx
							  - ((conto)
							     .x))))
					    / 0.017453292519943295));
			}
			turncnt = 0;
			randtcnt
			    = (int) ((float) acuracy
				     * m.random());
		    } else
			turncnt++;
		} else {
		    up = true;
		    int i = 0;
		    int i_42_
			= (int) ((float) pys((conto).x,
					     ((checkpoints).opx
					      [acr]),
					     (conto).z,
					     ((checkpoints).opz
					      [acr]))
				 / 2.0F * aim);
		    int i_43_
			= (int) ((float) ((checkpoints).opx
					  [acr])
				 - ((float) i_42_
				    * m.sin((
							      checkpoints)
							     .omxz
							     [(this
							       .acr)])));
		    int i_44_
			= (int) ((float) ((checkpoints).opz
					  [acr])
				 + ((float) i_42_
				    * m.cos((
							      checkpoints)
							     .omxz
							     [(this
							       .acr)])));
		    if (i_43_ - (conto).x >= 0)
			i = 180;
		    pan
			= (int) ((double) (90 + i)
				 + (Math.atan((double) (i_44_
							- (conto).z)
					      / (double) (i_43_
							  - (conto).x))
				    / 0.017453292519943295));
		    attack--;
		    if (attack <= 0)
			attack = 0;
		    if ((checkpoints).stage == 25
			&& exitattack
			&& !bulistc
			&& (mad).missedcp != 0)
			attack = 0;
		    if ((checkpoints).stage == 26
			&& (mad).cn == 13
			&& ((checkpoints).clear[0] == 4
			    || (checkpoints).clear[0] == 13
			    || (checkpoints).clear[0] == 21))
			attack = 0;
		    if ((checkpoints).stage == 26
			&& (mad).missedcp != 0
			&& (((checkpoints).pos[(mad).im]
			     == 0)
			    || (((checkpoints).pos
				 [(mad).im]) == 1
				&& (checkpoints).pos[0] == 0)))
			attack = 0;
		    if ((checkpoints).stage == 26
			&& ((checkpoints).pos[0]
			    > (checkpoints).pos[(mad).im])
			&& (mad).power < 80.0F)
			attack = 0;
		}
		int i = (conto).xz;
		if (zyinv)
		    i += 180;
		for (/**/; i < 0; i += 360) {
		    /* empty */
		}
		for (/**/; i > 180; i -= 360) {
		    /* empty */
		}
		for (/**/; pan < 0;
		     pan += 360) {
		    /* empty */
		}
		for (/**/; pan > 180;
		     pan -= 360) {
		    /* empty */
		}
		if (wall != -1 && hold == 0)
		    clrnce = 0;
		if (hold == 0) {
		    if (Math.abs(i - pan) < 180) {
			if (Math.abs(i - pan)
			    > clrnce) {
			    if (i < pan) {
				left = true;
				lastl = true;
			    } else {
				right = true;
				lastl = false;
			    }
			    if (Math.abs(i - pan) > 50
				&& ((mad).speed
				    > (float) (((mad).cd)
					       .swits[(mad).cn][0]))
				&& turntyp != 0) {
				if (turntyp == 1)
				    down = true;
				if (turntyp == 2)
				    handb = true;
				if (!agressed)
				    up = false;
			    }
			}
		    } else if (Math.abs(i - pan)
			       < 360 - clrnce) {
			if (i < pan) {
			    right = true;
			    lastl = false;
			} else {
			    left = true;
			    lastl = true;
			}
			if (Math.abs(i - pan) < 310
			    && ((mad).speed
				> (float) (((mad).cd).swits
					   [(mad).cn][0]))
			    && turntyp != 0) {
			    if (turntyp == 1)
				down = true;
			    if (turntyp == 2)
				handb = true;
			    if (!agressed)
				up = false;
			}
		    }
		}
		if ((checkpoints).stage == 24
		    && wall != -1) {
		    if ((trackers).dam[wall] == 0
			|| (mad).pcleared == 45)
			wall = -1;
		    if ((mad).pcleared == 58
			&& ((checkpoints).opz[(mad).im]
			    < 36700)) {
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
		    if ((trackers).dam[wall]
			!= 0) {
			int i_45_ = 1;
			if ((trackers).skd[wall]
			    == 1)
			    i_45_ = 3;
			hold += i_45_;
			if (hold > 10 * i_45_)
			    hold = 10 * i_45_;
		    } else
			hold = 1;
		    wall = -1;
		} else if (hold != 0)
		    hold--;
	    } else {
		if (trickfase == 0) {
		    int i = (int) (((mad).scy[0] + (mad).scy[1]
				    + (mad).scy[2] + (mad).scy[3])
				   * (float) ((conto).y - 300)
				   / 4000.0F);
		    int i_46_ = 3;
		    if ((checkpoints).stage == 25)
			i_46_ = 10;
		    if (i > 7
			&& ((m.random()
			     > trickprf / (float) i_46_)
			    || stuntf == 4
			    || stuntf == 3
			    || stuntf == 5
			    || stuntf == 6
			    || (checkpoints).stage == 26)) {
			oxy = (mad).pxy;
			ozy = (mad).pzy;
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
			} else if (((m.random()
				     > m.random())
				    && stuntf != 1)
				   || stuntf == 4
				   || stuntf == 6
				   || stuntf == 7
				   || stuntf == 17) {
			    if (((m.random()
				  > m.random())
				 || stuntf == 2
				 || stuntf == 7)
				&& stuntf != 4
				&& stuntf != 6)
				uddirect = -1;
			    else
				uddirect = 1;
			    udstart
				= (int) (10.0F * m.random()
					 * trickprf);
			    if (stuntf == 6)
				udstart = 0;
			    if ((checkpoints).stage == 26)
				udstart = 0;
			    if ((checkpoints).stage == 24
				&& (oupnt == 68
				    || oupnt == 69)) {
				apunch = 20;
				oupnt = 70;
			    }
			    if ((double) m.random() > 0.85
				&& stuntf != 4
				&& stuntf != 3
				&& stuntf != 6
				&& stuntf != 17
				&& (checkpoints).stage != 26)
				udswt = true;
			    if ((m.random()
				 > trickprf + 0.3F)
				&& stuntf != 4
				&& stuntf != 6) {
				if (m.random()
				    > m.random())
				    lrdirect = -1;
				else
				    lrdirect = 1;
				lrstart
				    = (int) (30.0F
					     * m.random());
				if ((double) m.random()
				    > 0.75)
				    lrswt = true;
			    }
			} else {
			    if (m.random()
				> m.random())
				lrdirect = -1;
			    else
				lrdirect = 1;
			    lrstart
				= (int) (10.0F * m.random()
					 * trickprf);
			    if ((double) m.random() > 0.75
				&& (checkpoints).stage != 26)
				lrswt = true;
			    if (m.random()
				> trickprf + 0.3F) {
				if (m.random()
				    > m.random())
				    uddirect = -1;
				else
				    uddirect = 1;
				udstart
				    = (int) (30.0F
					     * m.random());
				if ((double) m.random()
				    > 0.85)
				    udswt = true;
			    }
			}
			if (trfix == 3
			    || trfix == 4) {
			    if ((checkpoints).stage != 18
				&& (checkpoints).stage != 8) {
				if ((checkpoints).stage != 25
				    && lrdirect == -1) {
				    if ((checkpoints).stage
					!= 19)
					uddirect = -1;
				    else
					uddirect = 1;
				}
				lrdirect = 0;
				if (((checkpoints).stage == 19
				     || ((checkpoints).stage
					 == 25))
				    && uddirect == -1)
				    uddirect = 1;
				if ((mad).power < 60.0F)
				    uddirect = -1;
			    } else {
				if (uddirect != 0)
				    uddirect = -1;
				lrdirect = 0;
			    }
			    if ((checkpoints).stage == 20) {
				uddirect = 1;
				lrdirect = 0;
			    }
			    if ((checkpoints).stage == 26) {
				uddirect = -1;
				lrdirect = 0;
				if ((mad).cn != 11
				    && (mad).cn != 13) {
				    udstart = 7;
				    if ((mad).cn == 14
					&& (mad).power > 30.0F)
					udstart = 14;
				} else
				    udstart = 0;
				if ((mad).cn == 11) {
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
		    if (lrdirect != 0
			&& (flycnt
			    > lrstart)) {
			if (lrswt
			    && Math.abs((mad).pxy
					- oxy) > 180) {
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
		    if (uddirect != 0
			&& (flycnt
			    > udstart)) {
			if (udswt
			    && Math.abs((mad).pzy
					- ozy) > 180) {
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
		    if ((((mad).scy[0] + (mad).scy[1]
			  + (mad).scy[2] + (mad).scy[3])
			 * 100.0F / (float) ((conto).y - 300))
			< (float) -saftey) {
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
			if ((mad).dcomp != 0.0F
			    || (mad).ucomp != 0.0F)
			    udbare = true;
			if ((mad).lcomp != 0.0F
			    || (mad).rcomp != 0.0F)
			    lrbare = true;
			swat = 1;
		    }
		    if ((mad).wtouch) {
			if (swat == 1)
			    swat = 2;
		    } else if (swat == 2) {
			if ((mad).capsized
			    && (m.random()
				> mustland)) {
			    if (udbare) {
				lrbare = true;
				udbare = false;
			    } else if (lrbare) {
				udbare = true;
				lrbare = false;
			    }
			}
			swat = 3;
		    }
		    if (udbare) {
			int i;
			for (i = (mad).pzy + 90; i < 0; i += 360) {
			    /* empty */
			}
			for (/**/; i > 180; i -= 360) {
			    /* empty */
			}
			i = Math.abs(i);
			if ((mad).lcomp - (mad).rcomp < 5.0F
			    && (onced
				|| onceu))
			    udcomp = true;
			if ((mad).dcomp > (mad).ucomp) {
			    if ((mad).capsized) {
				if (udcomp) {
				    if (i > 90)
					up = true;
				    else
					down = true;
				} else if (!onced)
				    down = true;
			    } else {
				if (udcomp) {
				    if (perfection
					&& Math.abs(i - 90) > 30) {
					if (i > 90)
					    up = true;
					else
					    down = true;
				    }
				} else if (m.random()
					   > mustland)
				    up = true;
				onced = true;
			    }
			} else if ((mad).capsized) {
			    if (udcomp) {
				if (i > 90)
				    up = true;
				else
				    down = true;
			    } else if (!onceu)
				up = true;
			} else {
			    if (udcomp) {
				if (perfection
				    && Math.abs(i - 90) > 30) {
				    if (i > 90)
					up = true;
				    else
					down = true;
				}
			    } else if (m.random()
				       > mustland)
				down = true;
			    onceu = true;
			}
		    }
		    if (lrbare) {
			int i = (mad).pxy + 90;
			if (zyinv)
			    i += 180;
			for (/**/; i < 0; i += 360) {
			    /* empty */
			}
			for (/**/; i > 180; i -= 360) {
			    /* empty */
			}
			i = Math.abs(i);
			if ((mad).lcomp - (mad).rcomp < 10.0F
			    && (oncel
				|| oncer))
			    lrcomp = true;
			if ((mad).lcomp > (mad).rcomp) {
			    if ((mad).capsized) {
				if (lrcomp) {
				    if (i > 90)
					left = true;
				    else
					right = true;
				} else if (!oncel)
				    left = true;
			    } else {
				if (lrcomp) {
				    if (perfection
					&& Math.abs(i - 90) > 30) {
					if (i > 90)
					    left = true;
					else
					    right = true;
				    }
				} else if (m.random()
					   > mustland)
				    right = true;
				oncel = true;
			    }
			} else if ((mad).capsized) {
			    if (lrcomp) {
				if (i > 90)
				    left = true;
				else
				    right = true;
			    } else if (!oncer)
				right = true;
			} else {
			    if (lrcomp) {
				if (perfection
				    && Math.abs(i - 90) > 30) {
				    if (i > 90)
					left = true;
				    else
					right = true;
				}
			    } else if (m.random()
				       > mustland)
				left = true;
			    oncer = true;
			}
		    }
		}
	    }
	}
    }
    
    public int py(int i, int i_47_, int i_48_, int i_49_) {
	return (i - i_47_) * (i - i_47_) + (i_48_ - i_49_) * (i_48_ - i_49_);
    }
    
    public int pys(int i, int i_50_, int i_51_, int i_52_) {
	return (int) Math.sqrt((double) ((i - i_50_) * (i - i_50_)
					 + (i_51_ - i_52_) * (i_51_ - i_52_)));
    }
}
