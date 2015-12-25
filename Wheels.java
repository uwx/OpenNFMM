/* Wheels - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Wheels {
	float depth = 3.0F;
	int ground = 0;
	int mast = 0;
	int[] rc = { 120, 120, 120 };
	float size = 2.0F;
	int sparkat = 0;

	public Wheels() {
		sparkat = 0;
		ground = 0;
	}

	public void make(final Medium medium, final Trackers trackers, final Plane[] planes, int i, final int i_4_,
			final int i_5_, final int i_6_, final int i_7_, final int i_8_, final int i_9_, final int i_10_) {
		final int[] is = new int[20];
		final int[] is_11_ = new int[20];
		final int[] is_12_ = new int[20];
		final int[] is_13_ = { 45, 45, 45 };
		int i_14_ = 0;
		final float f = i_8_ / 10.0F;
		final float f_15_ = i_9_ / 10.0F;
		if (i_7_ == 11)
			i_14_ = (int) (i_4_ + 4.0F * f);
		sparkat = (int) (f_15_ * 24.0F);
		ground = (int) (i_5_ + 13.0F * f_15_);
		int i_16_ = -1;
		if (i_4_ < 0)
			i_16_ = 1;
		for (int i_17_ = 0; i_17_ < 20; i_17_++)
			is[i_17_] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ + 9.1923F * f_15_);
		is_11_[1] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[1] = (int) (i_6_ + 3.3646F * f_15_);
		is_11_[2] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[2] = (int) (i_6_ - 3.3646F * f_15_);
		is_11_[3] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ - 9.1923F * f_15_);
		is_11_[4] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[4] = (int) (i_6_ - 12.557F * f_15_);
		is_11_[5] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[5] = (int) (i_6_ - 12.557F * f_15_);
		is_11_[6] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[6] = (int) (i_6_ - 9.1923F * f_15_);
		is_11_[7] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[7] = (int) (i_6_ - 3.3646F * f_15_);
		is_11_[8] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[8] = (int) (i_6_ + 3.3646F * f_15_);
		is_11_[9] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[9] = (int) (i_6_ + 9.1923F * f_15_);
		is_11_[10] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[10] = (int) (i_6_ + 12.557F * f_15_);
		is_11_[11] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[11] = (int) (i_6_ + 12.557F * f_15_);
		is_11_[12] = i_5_;
		is_12_[12] = (int) (i_6_ + 10.0F * size);
		is_11_[13] = (int) (i_5_ + 8.66 * size);
		is_12_[13] = (int) (i_6_ + 5.0F * size);
		is_11_[14] = (int) (i_5_ + 8.66 * size);
		is_12_[14] = (int) (i_6_ - 5.0F * size);
		is_11_[15] = i_5_;
		is_12_[15] = (int) (i_6_ - 10.0F * size);
		is_11_[16] = (int) (i_5_ - 8.66 * size);
		is_12_[16] = (int) (i_6_ - 5.0F * size);
		is_11_[17] = (int) (i_5_ - 8.66 * size);
		is_12_[17] = (int) (i_6_ + 5.0F * size);
		is_11_[18] = i_5_;
		is_12_[18] = (int) (i_6_ + 10.0F * size);
		is_11_[19] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[19] = (int) (i_6_ + 12.557F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 20, is_13_, 0, i_10_, 0, i_14_, i_5_, i_6_, 7, 0,
				false, 0, false, false, false, false, 1, 0, 0, 10);
		planes[i].master = 1;
		i++;
		is[2] = (int) (i_4_ - depth * f);
		is_11_[2] = i_5_;
		is_12_[2] = i_6_;
		int i_18_ = (int) (i_10_ - depth / size * 4.0F);
		if (i_18_ < -16)
			i_18_ = -16;
		is_11_[0] = i_5_;
		is_12_[0] = (int) (i_6_ + 10.0F * size);
		is_11_[1] = (int) (i_5_ + 8.66 * size);
		is_12_[1] = (int) (i_6_ + 5.0F * size);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3, rc, 0, i_18_, 0, i_14_, i_5_, i_6_, 7, 0, false,
				0, false, false, false, false, 1, 0, 0, 10);
		if (depth / size < 7.0F)
			planes[i].master = 2;
		i++;
		is_11_[0] = (int) (i_5_ + 8.66 * size);
		is_12_[0] = (int) (i_6_ + 5.0F * size);
		is_11_[1] = (int) (i_5_ + 8.66 * size);
		is_12_[1] = (int) (i_6_ - 5.0F * size);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3, rc, 0, i_18_, 0, i_14_, i_5_, i_6_, 7, 0, false,
				0, false, false, false, false, 1, 0, 0, 10);
		if (depth / size < 7.0F)
			planes[i].master = 2;
		i++;
		is_11_[0] = (int) (i_5_ + 8.66 * size);
		is_12_[0] = (int) (i_6_ - 5.0F * size);
		is_11_[1] = i_5_;
		is_12_[1] = (int) (i_6_ - 10.0F * size);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3, rc, 0, i_18_, 0, i_14_, i_5_, i_6_, 7, 0, false,
				0, false, false, false, false, 1, 0, 0, 10);
		if (depth / size < 7.0F)
			planes[i].master = 2;
		i++;
		is_11_[0] = i_5_;
		is_12_[0] = (int) (i_6_ - 10.0F * size);
		is_11_[1] = (int) (i_5_ - 8.66 * size);
		is_12_[1] = (int) (i_6_ - 5.0F * size);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3, rc, 0, i_18_, 0, i_14_, i_5_, i_6_, 7, 0, false,
				0, false, false, false, false, 1, 0, 0, 10);
		if (depth / size < 7.0F)
			planes[i].master = 2;
		i++;
		is_11_[0] = (int) (i_5_ - 8.66 * size);
		is_12_[0] = (int) (i_6_ - 5.0F * size);
		is_11_[1] = (int) (i_5_ - 8.66 * size);
		is_12_[1] = (int) (i_6_ + 5.0F * size);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3, rc, 0, i_18_, 0, i_14_, i_5_, i_6_, 7, 0, false,
				0, false, false, false, false, 1, 0, 0, 10);
		if (depth / size < 7.0F)
			planes[i].master = 2;
		i++;
		is_11_[0] = (int) (i_5_ - 8.66 * size);
		is_12_[0] = (int) (i_6_ + 5.0F * size);
		is_11_[1] = i_5_;
		is_12_[1] = (int) (i_6_ + 10.0F * size);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 3, rc, 0, i_18_, 0, i_14_, i_5_, i_6_, 7, 0, false,
				0, false, false, false, false, 1, 0, 0, 10);
		if (depth / size < 7.0F)
			planes[i].master = 2;
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[0] = (int) (i_6_ + 3.3646F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[1] = (int) (i_6_ - 3.3646F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[2] = (int) (i_6_ - 3.3646F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[3] = (int) (i_6_ + 3.3646F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ - 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[1] = (int) (i_6_ - 3.3646F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[2] = (int) (i_6_ - 3.3646F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ - 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ - 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[1] = (int) (i_6_ - 12.557F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[2] = (int) (i_6_ - 12.557F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ - 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[0] = (int) (i_6_ - 12.557F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[1] = (int) (i_6_ - 12.557F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[2] = (int) (i_6_ - 12.557F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[3] = (int) (i_6_ - 12.557F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ - 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[1] = (int) (i_6_ - 12.557F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[2] = (int) (i_6_ - 12.557F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ - 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ - 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[1] = (int) (i_6_ - 3.3646F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[2] = (int) (i_6_ - 3.3646F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ - 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[0] = (int) (i_6_ - 3.3646F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[1] = (int) (i_6_ + 3.3646F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[2] = (int) (i_6_ + 3.3646F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[3] = (int) (i_6_ - 3.3646F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ + 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[1] = (int) (i_6_ + 3.3646F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ + 12.557F * f_15_);
		is_12_[2] = (int) (i_6_ + 3.3646F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ + 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ + 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[1] = (int) (i_6_ + 12.557F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[2] = (int) (i_6_ + 12.557F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ + 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ + 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[0] = (int) (i_6_ + 12.557F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[1] = (int) (i_6_ + 12.557F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[2] = (int) (i_6_ + 12.557F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ + 3.3646F * f_15_);
		is_12_[3] = (int) (i_6_ + 12.557F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, -1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ + 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[1] = (int) (i_6_ + 12.557F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ - 3.3646F * f_15_);
		is_12_[2] = (int) (i_6_ + 12.557F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ + 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
		is[0] = (int) (i_4_ - 4.0F * f);
		is_11_[0] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[0] = (int) (i_6_ + 9.1923F * f_15_);
		is[1] = (int) (i_4_ - 4.0F * f);
		is_11_[1] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[1] = (int) (i_6_ + 3.3646F * f_15_);
		is[2] = (int) (i_4_ + 4.0F * f);
		is_11_[2] = (int) (i_5_ - 12.557F * f_15_);
		is_12_[2] = (int) (i_6_ + 3.3646F * f_15_);
		is[3] = (int) (i_4_ + 4.0F * f);
		is_11_[3] = (int) (i_5_ - 9.1923F * f_15_);
		is_12_[3] = (int) (i_6_ + 9.1923F * f_15_);
		planes[i] = new Plane(medium, trackers, is, is_12_, is_11_, 4, is_13_, 0, i_10_, 1 * i_16_, i_14_, i_5_, i_6_,
				7, 0, false, 0, true, false, false, false, 1, 0, 0, 10);
		i++;
	}

	public void setrims(final int i, final int i_0_, final int i_1_, final int i_2_, final int i_3_) {
		rc[0] = i;
		rc[1] = i_0_;
		rc[2] = i_1_;
		size = i_2_ / 10.0F;
		if (size < 0.0F)
			size = 0.0F;
		depth = i_3_ / 10.0F;
		if (depth / size > 41.0F)
			depth = size * 41.0F;
		if (depth / size < -25.0F)
			depth = -(size * 25.0F);
	}
}
