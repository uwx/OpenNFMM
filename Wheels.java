/* Wheels - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Wheels
{
    int ground = 0;
    int mast = 0;
    int sparkat = 0;
    int[] rc = { 120, 120, 120 };
    float size = 2.0F;
    float depth = 3.0F;
    
    public Wheels() {
	this.sparkat = 0;
	this.ground = 0;
    }
    
    public void setrims(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
	this.rc[0] = i;
	this.rc[1] = i_0_;
	this.rc[2] = i_1_;
	this.size = (float) i_2_ / 10.0F;
	if (this.size < 0.0F)
	    this.size = 0.0F;
	this.depth = (float) i_3_ / 10.0F;
	if (this.depth / this.size > 41.0F)
	    this.depth = this.size * 41.0F;
	if (this.depth / this.size < -25.0F)
	    this.depth = -(this.size * 25.0F);
    }
    
    public void make(Medium medium, Trackers trackers, Plane[] planes, int i,
		     int i_4_, int i_5_, int i_6_, int i_7_, int i_8_,
		     int i_9_, int i_10_) {
	int[] is = new int[20];
	int[] is_11_ = new int[20];
	int[] is_12_ = new int[20];
	int[] is_13_ = { 45, 45, 45 };
	int i_14_ = 0;
	float f = (float) i_8_ / 10.0F;
	float f_15_ = (float) i_9_ / 10.0F;
	if (i_7_ == 11)
	    i_14_ = (int) ((float) i_4_ + 4.0F * f);
	this.sparkat = (int) (f_15_ * 24.0F);
	this.ground = (int) ((float) i_5_ + 13.0F * f_15_);
	int i_16_ = -1;
	if (i_4_ < 0)
	    i_16_ = 1;
	for (int i_17_ = 0; i_17_ < 20; i_17_++)
	    is[i_17_] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ + 9.1923F * f_15_);
	is_11_[1] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[1] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is_11_[2] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[2] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is_11_[3] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ - 9.1923F * f_15_);
	is_11_[4] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[4] = (int) ((float) i_6_ - 12.557F * f_15_);
	is_11_[5] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[5] = (int) ((float) i_6_ - 12.557F * f_15_);
	is_11_[6] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[6] = (int) ((float) i_6_ - 9.1923F * f_15_);
	is_11_[7] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[7] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is_11_[8] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[8] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is_11_[9] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[9] = (int) ((float) i_6_ + 9.1923F * f_15_);
	is_11_[10] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[10] = (int) ((float) i_6_ + 12.557F * f_15_);
	is_11_[11] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[11] = (int) ((float) i_6_ + 12.557F * f_15_);
	is_11_[12] = i_5_;
	is_12_[12] = (int) ((float) i_6_ + 10.0F * this.size);
	is_11_[13]
	    = (int) ((double) i_5_ + 8.66 * (double) this.size);
	is_12_[13] = (int) ((float) i_6_ + 5.0F * this.size);
	is_11_[14]
	    = (int) ((double) i_5_ + 8.66 * (double) this.size);
	is_12_[14] = (int) ((float) i_6_ - 5.0F * this.size);
	is_11_[15] = i_5_;
	is_12_[15] = (int) ((float) i_6_ - 10.0F * this.size);
	is_11_[16]
	    = (int) ((double) i_5_ - 8.66 * (double) this.size);
	is_12_[16] = (int) ((float) i_6_ - 5.0F * this.size);
	is_11_[17]
	    = (int) ((double) i_5_ - 8.66 * (double) this.size);
	is_12_[17] = (int) ((float) i_6_ + 5.0F * this.size);
	is_11_[18] = i_5_;
	is_12_[18] = (int) ((float) i_6_ + 10.0F * this.size);
	is_11_[19] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[19] = (int) ((float) i_6_ + 12.557F * f_15_);
	planes[i]
	    = new Plane(medium, trackers, is, is_12_, is_11_, 20, is_13_, 0,
			i_10_, 0, i_14_, i_5_, i_6_, 7, 0, false, 0, false);
	(planes[i]).master = 1;
	i++;
	is[2] = (int) ((float) i_4_ - this.depth * f);
	is_11_[2] = i_5_;
	is_12_[2] = i_6_;
	int i_18_
	    = (int) ((float) i_10_
		     - this.depth / this.size * 4.0F);
	if (i_18_ < -16)
	    i_18_ = -16;
	is_11_[0] = i_5_;
	is_12_[0] = (int) ((float) i_6_ + 10.0F * this.size);
	is_11_[1]
	    = (int) ((double) i_5_ + 8.66 * (double) this.size);
	is_12_[1] = (int) ((float) i_6_ + 5.0F * this.size);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3,
			      this.rc, 0, i_18_, 0, i_14_, i_5_,
			      i_6_, 7, 0, false, 0, false);
	if (this.depth / this.size < 7.0F)
	    (planes[i]).master = 2;
	i++;
	is_11_[0]
	    = (int) ((double) i_5_ + 8.66 * (double) this.size);
	is_12_[0] = (int) ((float) i_6_ + 5.0F * this.size);
	is_11_[1]
	    = (int) ((double) i_5_ + 8.66 * (double) this.size);
	is_12_[1] = (int) ((float) i_6_ - 5.0F * this.size);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3,
			      this.rc, 0, i_18_, 0, i_14_, i_5_,
			      i_6_, 7, 0, false, 0, false);
	if (this.depth / this.size < 7.0F)
	    (planes[i]).master = 2;
	i++;
	is_11_[0]
	    = (int) ((double) i_5_ + 8.66 * (double) this.size);
	is_12_[0] = (int) ((float) i_6_ - 5.0F * this.size);
	is_11_[1] = i_5_;
	is_12_[1] = (int) ((float) i_6_ - 10.0F * this.size);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3,
			      this.rc, 0, i_18_, 0, i_14_, i_5_,
			      i_6_, 7, 0, false, 0, false);
	if (this.depth / this.size < 7.0F)
	    (planes[i]).master = 2;
	i++;
	is_11_[0] = i_5_;
	is_12_[0] = (int) ((float) i_6_ - 10.0F * this.size);
	is_11_[1]
	    = (int) ((double) i_5_ - 8.66 * (double) this.size);
	is_12_[1] = (int) ((float) i_6_ - 5.0F * this.size);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3,
			      this.rc, 0, i_18_, 0, i_14_, i_5_,
			      i_6_, 7, 0, false, 0, false);
	if (this.depth / this.size < 7.0F)
	    (planes[i]).master = 2;
	i++;
	is_11_[0]
	    = (int) ((double) i_5_ - 8.66 * (double) this.size);
	is_12_[0] = (int) ((float) i_6_ - 5.0F * this.size);
	is_11_[1]
	    = (int) ((double) i_5_ - 8.66 * (double) this.size);
	is_12_[1] = (int) ((float) i_6_ + 5.0F * this.size);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3,
			      this.rc, 0, i_18_, 0, i_14_, i_5_,
			      i_6_, 7, 0, false, 0, false);
	if (this.depth / this.size < 7.0F)
	    (planes[i]).master = 2;
	i++;
	is_11_[0]
	    = (int) ((double) i_5_ - 8.66 * (double) this.size);
	is_12_[0] = (int) ((float) i_6_ + 5.0F * this.size);
	is_11_[1] = i_5_;
	is_12_[1] = (int) ((float) i_6_ + 10.0F * this.size);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3,
			      this.rc, 0, i_18_, 0, i_14_, i_5_,
			      i_6_, 7, 0, false, 0, false);
	if (this.depth / this.size < 7.0F)
	    (planes[i]).master = 2;
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[0] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[1] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[2] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[3] = (int) ((float) i_6_ + 3.3646F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ - 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[1] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[2] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ - 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ - 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[1] = (int) ((float) i_6_ - 12.557F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[2] = (int) ((float) i_6_ - 12.557F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ - 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[0] = (int) ((float) i_6_ - 12.557F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[1] = (int) ((float) i_6_ - 12.557F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[2] = (int) ((float) i_6_ - 12.557F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[3] = (int) ((float) i_6_ - 12.557F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ - 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[1] = (int) ((float) i_6_ - 12.557F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[2] = (int) ((float) i_6_ - 12.557F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ - 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ - 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[1] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[2] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ - 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[0] = (int) ((float) i_6_ - 3.3646F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[1] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[2] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[3] = (int) ((float) i_6_ - 3.3646F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ + 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[1] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ + 12.557F * f_15_);
	is_12_[2] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ + 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ + 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[1] = (int) ((float) i_6_ + 12.557F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[2] = (int) ((float) i_6_ + 12.557F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ + 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ + 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[0] = (int) ((float) i_6_ + 12.557F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[1] = (int) ((float) i_6_ + 12.557F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[2] = (int) ((float) i_6_ + 12.557F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ + 3.3646F * f_15_);
	is_12_[3] = (int) ((float) i_6_ + 12.557F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ + 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[1] = (int) ((float) i_6_ + 12.557F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ - 3.3646F * f_15_);
	is_12_[2] = (int) ((float) i_6_ + 12.557F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ + 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
	is[0] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[0] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[0] = (int) ((float) i_6_ + 9.1923F * f_15_);
	is[1] = (int) ((float) i_4_ - 4.0F * f);
	is_11_[1] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[1] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is[2] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[2] = (int) ((float) i_5_ - 12.557F * f_15_);
	is_12_[2] = (int) ((float) i_6_ + 3.3646F * f_15_);
	is[3] = (int) ((float) i_4_ + 4.0F * f);
	is_11_[3] = (int) ((float) i_5_ - 9.1923F * f_15_);
	is_12_[3] = (int) ((float) i_6_ + 9.1923F * f_15_);
	planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_,
			      0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_, 7, 0,
			      false, 0, true);
	i++;
    }
}
