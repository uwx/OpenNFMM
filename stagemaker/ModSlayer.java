package stagemaker;

/* ModSlayer - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.IOException;
public class ModSlayer
{
    static final String VERSION = "1.0";
    static final String COPYRIGHT = "";
    static final int EFF_VOL_SLIDE = 1;
    static final int EFF_PORT_DOWN = 2;
    static final int EFF_PORT_UP = 4;
    static final int EFF_VIBRATO = 8;
    static final int EFF_ARPEGGIO = 16;
    static final int EFF_PORT_TO = 32;
    static final int EFF_TREMOLO = 64;
    static final int EFF_RETRIG = 128;
    static final int MIX_BUF_SIZE = 2048;
    static final int DEF_TEMPO_NTSC = 6;
    static final int DEF_TEMPO_PAL = 6;
    static final int DEF_BPM_NTSC = 125;
    static final int DEF_BPM_PAL = 145;
    static final int MIDCRATE = 8448;
    static final int MAX_SAMPLES = 100;
    static final int MAX_TRACKS = 32;
    static final int S3M_MAGIC1 = 4122;
    static final int S3M_MAGIC2 = Mod.FOURCC("SCRM");
    static final int S3M_INSTR2 = Mod.FOURCC("SCRS");
    static final int[] normal_vol_adj = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 63 };
    static final int[] loud_vol_adj = { 0, 0, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 47, 48, 49, 50, 51, 52, 53, 53, 54, 55, 55, 56, 56, 57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 61, 62, 62, 62, 63, 63, 63, 63, 63, 63 };
    static final int[] sintable = { 0, 25, 50, 74, 98, 120, 142, 162, 180, 197, 212, 225, 236, 244, 250, 254, 255, 254, 250, 244, 236, 225, 212, 197, 180, 162, 142, 120, 98, 74, 50, 25 };
    static final int[] period_set = { 1712, 1616, 1525, 1440, 1359, 1283, 1211, 1143, 1078, 1018, 961, 907, 856, 808, 763, 720, 679, 641, 605, 571, 539, 509, 480, 453, 428, 404, 381, 360, 340, 321, 303, 286, 270, 254, 240, 227, 214, 202, 191, 180, 170, 160, 151, 143, 135, 127, 120, 113, 107, 101, 95, 90, 85, 80, 76, 71, 67, 64, 60, 57, 53, 50, 48, 45, 42, 40, 38, 36, 34, 32, 30, 28, 27, 25, 24, 22, 21, 20, 19, 18, 17, 16, 15, 14 };
    static final int[] period_set_step = { 1664, 1570, 1482, 1399, 1321, 1247, 1177, 1110, 1048, 989, 934, 881, 832, 785, 741, 699, 660, 623, 588, 555, 524, 494, 466, 440, 416, 392, 370, 350, 330, 312, 294, 278, 262, 247, 233, 220, 208, 196, 185, 175, 165, 155, 147, 139, 131, 123, 116, 110, 104, 98, 92, 87, 82, 78, 73, 69, 65, 62, 58, 55, 51, 49, 46, 43, 41, 39, 37, 35, 33, 31, 29, 27, 26, 24, 23, 21, 20, 19, 18, 17, 16, 15, 14, 14 };
    int def_tempo;
    int def_bpm;
    byte[] vol_table;
    int[] vol_adj;
    int vol_shift;
    Mod mod;
    int order_pos;
    int tempo;
    int tempo_wait;
    int bpm;
    int row;
    int break_row;
    int bpm_samples;
    int pattofs;
    byte[] patt;
    int numtracks;
    ModTrackInfo[] tracks;
    int mixspeed;
    boolean mod_done = false;
    public boolean bit16;
    public int samplingrate;
    public int oversample;
    public int gain;
    public int nloops = 1;
    public boolean loud = false;
    private static final int ERROR_SHIFT = 12;
    private static final int ERROR_MASK = 4095;
    private static final long ratediv = 22748294283264L;
    int oln = 0;
    int olav = 0;
    
    ModSlayer(Mod mod, int i, int i_0_, int i_1_) {
        samplingrate = i;
        gain = i_0_;
        oversample = 1;
        this.mod = mod;
        this.def_tempo = 6;
        this.def_bpm = i_1_;
    }
    
    final void beattrack(ModTrackInfo modtrackinfo) {
        if ((modtrackinfo).period_low_limit == 0)
            (modtrackinfo).period_low_limit = 1;
        if (((modtrackinfo).effect & 0x1) != 0) {
            (modtrackinfo).volume += (modtrackinfo).vol_slide;
            if ((modtrackinfo).volume < 0)
                (modtrackinfo).volume = 0;
            if ((modtrackinfo).volume > 64)
                (modtrackinfo).volume = 64;
        }
        if (((modtrackinfo).effect & 0x2) != 0) {
            if (((modtrackinfo).period += (modtrackinfo).port_down) > (modtrackinfo).period_high_limit)
                (modtrackinfo).period = (modtrackinfo).period_high_limit;
            (modtrackinfo).pitch = (modtrackinfo).finetune_rate / (modtrackinfo).period;
        }
        if (((modtrackinfo).effect & 0x4) != 0) {
            if (((modtrackinfo).period -= (modtrackinfo).port_up) < (modtrackinfo).period_low_limit) {
                if ((this.mod).s3m)
                    (modtrackinfo).period = (modtrackinfo).period_high_limit;
                else
                    (modtrackinfo).period = (modtrackinfo).period_low_limit;
            }
            (modtrackinfo).pitch = (modtrackinfo).finetune_rate / (modtrackinfo).period;
        }
        if (((modtrackinfo).effect & 0x20) != 0) {
            if ((modtrackinfo).portto < (modtrackinfo).period) {
                if (((modtrackinfo).period += (modtrackinfo).port_inc) > (modtrackinfo).portto)
                    (modtrackinfo).period = (modtrackinfo).portto;
            } else if ((modtrackinfo).portto > (modtrackinfo).period && ((modtrackinfo).period -= (modtrackinfo).port_inc) < (modtrackinfo).portto)
                (modtrackinfo).period = (modtrackinfo).portto;
            (modtrackinfo).pitch = (modtrackinfo).finetune_rate / (modtrackinfo).period;
        }
        if (((modtrackinfo).effect & 0x8) != 0) {
            (modtrackinfo).vibpos += (modtrackinfo).vib_rate << 2;
            int i = sintable[(modtrackinfo).vibpos >> 2 & 0x1f] * (modtrackinfo).vib_depth >> 7;
            if (((modtrackinfo).vibpos & 0x80) != 0)
                i = -i;
            i += (modtrackinfo).period;
            if (i < (modtrackinfo).period_low_limit)
                i = (modtrackinfo).period_low_limit;
            if (i > (modtrackinfo).period_high_limit)
                i = (modtrackinfo).period_high_limit;
            (modtrackinfo).pitch = (modtrackinfo).finetune_rate / i;
        }
        if (((modtrackinfo).effect & 0x10) != 0) {
            (modtrackinfo).pitch = (modtrackinfo).finetune_rate / (modtrackinfo).arp[(modtrackinfo).arpindex];
            (modtrackinfo).arpindex++;
            if ((modtrackinfo).arpindex >= 3)
                (modtrackinfo).arpindex = 0;
        }
    }
    
    final int get_track(ModTrackInfo modtrackinfo, byte[] is, int i) {
        int i_2_ = is[i] & 0xf0;
        int i_3_ = (is[i++] & 0xf) << 8;
        i_3_ |= is[i++] & 0xff;
        int i_4_ = is[i] & 0xf;
        i_2_ |= (is[i++] & 0xf0) >> 4;
        int i_5_ = is[i++];
        (modtrackinfo).effect = 0;
        if (i_2_ != 0) {
            i_2_--;
            ModInstrument modinstrument = (this.mod).insts[i_2_];
            (modtrackinfo).volume = (modinstrument).volume;
            (modtrackinfo).length = (modinstrument).sample_length;
            (modtrackinfo).repeat = (modinstrument).repeat_point;
            (modtrackinfo).replen = (modinstrument).repeat_length;
            (modtrackinfo).finetune_rate = (modinstrument).finetune_rate;
            (modtrackinfo).samples = (modinstrument).samples;
            (modtrackinfo).period_low_limit = (modinstrument).period_low_limit;
            (modtrackinfo).period_high_limit = (modinstrument).period_high_limit;
        }
        if (i_3_ != 0) {
            (modtrackinfo).portto = i_3_;
            if (i_4_ != 3 && i_4_ != 5) {
                (modtrackinfo).start_period = (modtrackinfo).period = i_3_;
                (modtrackinfo).pitch = (modtrackinfo).finetune_rate / i_3_;
                (modtrackinfo).position = 0;
            }
        }
        if (i_4_ != 0 || i_5_ != 0) {
            switch (i_4_) {
                default:
                break;
                case 0: {
                    int i_6_;
                    for (i_6_ = 12; i_6_ < 48 && (modtrackinfo).period < period_set[i_6_]; i_6_++) {
                        /* empty */
                    }
                    (modtrackinfo).arp[0] = period_set[i_6_];
                    (modtrackinfo).arp[1] = period_set[i_6_ + (i_5_ & 0xf)];
                    (modtrackinfo).arp[2] = period_set[i_6_ + ((i_5_ & 0xf0) >> 4)];
                    (modtrackinfo).arpindex = 0;
                    (modtrackinfo).effect |= 0x10;
                    break;
                }
                case 1:
                (modtrackinfo).effect |= 0x4;
                if (i_5_ != 0)
                    (modtrackinfo).port_up = i_5_;
                break;
                case 2:
                (modtrackinfo).effect |= 0x2;
                if (i_5_ != 0)
                    (modtrackinfo).port_down = i_5_;
                break;
                case 3:
                if (i_5_ != 0)
                    (modtrackinfo).port_inc = i_5_ & 0xff;
                (modtrackinfo).effect |= 0x20;
                break;
                case 4:
                if ((i_5_ & 0xf) != 0)
                    (modtrackinfo).vib_depth = i_5_ & 0xf;
                if ((i_5_ & 0xf0) != 0)
                    (modtrackinfo).vib_rate = (i_5_ & 0xf0) >> 4;
                if (i_3_ != 0)
                    (modtrackinfo).vibpos = 0;
                (modtrackinfo).effect |= 0x8;
                break;
                case 9:
                if (i_5_ == 0)
                    i_5_ = (modtrackinfo).oldsampofs;
                (modtrackinfo).oldsampofs = i_5_;
                (modtrackinfo).position = (i_5_ & 0xff) << 8;
                break;
                case 5:
                (modtrackinfo).effect |= 0x20;
                /* fall through */
                case 6:
                if (i_4_ == 6)
                    (modtrackinfo).effect |= 0x8;
                /* fall through */
                case 10:
                (modtrackinfo).vol_slide = ((i_5_ & 0xf0) >> 4) - (i_5_ & 0xf);
                (modtrackinfo).effect |= 0x1;
                break;
                case 11:
                break;
                case 12:
                if (i_5_ > 64 || i_5_ < 0)
                    (modtrackinfo).volume = 64;
                else
                    (modtrackinfo).volume = i_5_;
                break;
                case 13:
                this.break_row = ((i_5_ & 0xf0) >> 4) * 10 + (i_5_ & 0xf);
                this.row = 64;
                break;
                case 14: {
                    int i_7_ = i_5_ & 0xf0;
                    i_5_ &= 0xf;
                    switch (i_7_) {
                        default:
                        break;
                        case 1:
                        (modtrackinfo).period += i_5_;
                        if ((modtrackinfo).period > (modtrackinfo).period_high_limit)
                            (modtrackinfo).period = (modtrackinfo).period_high_limit;
                        (modtrackinfo).pitch = (modtrackinfo).finetune_rate / (modtrackinfo).period;
                        break;
                        case 2:
                        (modtrackinfo).period -= i_5_;
                        if ((modtrackinfo).period < (modtrackinfo).period_low_limit)
                            (modtrackinfo).period = (modtrackinfo).period_low_limit;
                        (modtrackinfo).pitch = (modtrackinfo).finetune_rate / (modtrackinfo).period;
                    }
                    break;
                }
                case 15:
                if (i_5_ != 0) {
                    i_5_ &= 0xff;
                    if (i_5_ <= 32) {
                        this.tempo = i_5_;
                        this.tempo_wait = i_5_;
                    } else {
                        this.bpm = i_5_;
                        this.bpm_samples = samplingrate / (103 * i_5_ >> 8) * oversample;
                    }
                }
            }
        }
        return i;
    }
    
    final void make_vol_table8() {
        this.vol_table = new byte[16640];
        for (int i = 0; i < 16640; i++)
            this.vol_table[i] = (byte) (this.vol_adj[i >> 8] * (byte) i >> 8 + this.vol_shift);
    }
    
    final void mixtrack_16_mono(ModTrackInfo modtrackinfo, int[] is, int i, int i_8_) {
        byte[] is_9_ = (modtrackinfo).samples;
        int i_10_ = (modtrackinfo).position;
        int i_11_ = this.vol_adj[(modtrackinfo).volume] * gain >> this.vol_shift + 8;
        int i_12_ = (modtrackinfo).error;
        int i_13_ = (modtrackinfo).pitch & 0xfff;
        int i_14_ = (modtrackinfo).pitch >> 12;
        if ((modtrackinfo).replen < 3) {
            int i_15_ = (modtrackinfo).length;
            if (i_10_ < i_15_) {
                int i_16_ = i + i_8_;
                if ((modtrackinfo).pitch < 4096) {
                    while (i_10_ < i_15_ && i < i_16_) {
                        is[i++] += (is_9_[i_10_] * (4096 - i_12_) + is_9_[i_10_ + 1] * i_12_) * i_11_ >> 12;
                        i_10_ += i_14_ + ((i_12_ += i_13_) >> 12);
                        i_12_ &= 0xfff;
                    }
                } else {
                    while (i_10_ < i_15_ && i < i_16_) {
                        is[i++] += is_9_[i_10_] * i_11_;
                        i_10_ += i_14_ + ((i_12_ += i_13_) >> 12);
                        i_12_ &= 0xfff;
                    }
                }
                (modtrackinfo).error = i_12_;
                (modtrackinfo).position = i_10_;
            }
        } else {
            int i_17_ = (modtrackinfo).replen + (modtrackinfo).repeat;
            if ((modtrackinfo).pitch < 4096) {
                for (/**/; i_8_ > 0; i_8_--) {
                    if (i_10_ >= i_17_)
                        i_10_ -= (modtrackinfo).replen;
                    is[i++] += (is_9_[i_10_] * (4096 - i_12_) + is_9_[i_10_ + 1] * i_12_) * i_11_ >> 12;
                    i_10_ += i_14_ + ((i_12_ += i_13_) >> 12);
                    i_12_ &= 0xfff;
                }
            } else {
                for (/**/; i_8_ > 0; i_8_--) {
                    if (i_10_ >= i_17_)
                        i_10_ -= (modtrackinfo).replen;
                    is[i++] += is_9_[i_10_] * i_11_;
                    i_10_ += i_14_ + ((i_12_ += i_13_) >> 12);
                    i_12_ &= 0xfff;
                }
            }
            (modtrackinfo).error = i_12_;
            (modtrackinfo).position = i_10_;
        }
    }
    
    public byte[] turnbytesNorm(boolean bool) throws IOException {
        bit16 = true;
        startplaying(loud);
        int[] is = new int[this.mixspeed];
        int[] is_18_ = new int[this.mixspeed];
        byte[] is_19_ = new byte[18000000];
        this.oln = 0;
        this.olav = 1;
        int i = 1;
        while (!this.mod_done) {
            if (--this.tempo_wait > 0) {
                for (int i_20_ = 0; i_20_ < this.numtracks; i_20_++)
                    beattrack(this.tracks[i_20_]);
            } else
                updatetracks();
            System.arraycopy(is_18_, 0, is, 0, this.bpm_samples);
            for (int i_21_ = 0; i_21_ < this.numtracks; i_21_++)
                mixtrack_16_mono(this.tracks[i_21_], is, 0, this.bpm_samples);
            int i_22_ = this.bpm_samples;
            if (oversample > 1) {
                int i_23_ = 0;
                i_22_ = this.bpm_samples / oversample;
                if (oversample == 2) {
                    for (int i_24_ = 0; i_24_ < i_22_; i_24_++) {
                        is[i_24_] = is[i_23_] + is[i_23_ + 1] >> 1;
                        i_23_ += 2;
                    }
                } else {
                    for (int i_25_ = 0; i_25_ < i_22_; i_25_++) {
                        int i_26_ = is[i_23_++];
                        for (int i_27_ = 1; i_27_ < oversample; i_27_++)
                            i_26_ += is[i_23_++];
                        is[i_25_] = i_26_ / oversample;
                    }
                }
            }
            if (this.oln + i_22_ < 18000000) {
                if (bool) {
                    int i_28_ = 0;
                    int i_29_ = 0;
                    for (int i_30_ = 0; i_30_ < i_22_; i_30_++) {
                        if (is[i_30_] > 0) {
                            i_29_ += is[i_30_];
                            i_28_++;
                        }
                    }
                    if (i_28_ != 0) {
                        i_29_ /= i_28_;
                        this.olav += i_29_;
                        i++;
                    }
                }
                intToBytes16(is, is_19_, i_22_, this.oln);
                this.oln += i_22_;
            }
        }
        if (bool)
            this.olav = this.olav / i;
        this.oln++;
        return is_19_;
    }
    
    public static void intToBytes16(int[] is, byte[] is_31_, int i, int i_32_) {
        int i_33_ = i_32_;
        for (int i_34_ = 0; i_34_ < i; i_34_++) {
            is_31_[i_33_++] = (byte) (is[i_34_] >> 8);
            is_31_[i_33_] = (byte) (is[i_34_] & 0xff);
        }
    }
    
    public byte[] turnbytesUlaw() throws IOException {
        bit16 = true;
        startplaying(loud);
        int[] is = new int[this.mixspeed];
        int[] is_35_ = new int[this.mixspeed];
        int[] is_36_ = new int[3200000];
        this.oln = 0;
        while (!this.mod_done) {
            if (--this.tempo_wait > 0) {
                for (int i = 0; i < this.numtracks; i++)
                    beattrack(this.tracks[i]);
            } else
                updatetracks();
            System.arraycopy(is_35_, 0, is, 0, this.bpm_samples);
            for (int i = 0; i < this.numtracks; i++)
                mixtrack_16_mono(this.tracks[i], is, 0, this.bpm_samples);
            int i = this.bpm_samples;
            if (oversample > 1) {
                int i_37_ = 0;
                i = this.bpm_samples / oversample;
                if (oversample == 2) {
                    for (int i_38_ = 0; i_38_ < i; i_38_++) {
                        is[i_38_] = is[i_37_] + is[i_37_ + 1] >> 1;
                        i_37_ += 2;
                    }
                } else {
                    for (int i_39_ = 0; i_39_ < i; i_39_++) {
                        int i_40_ = is[i_37_++];
                        for (int i_41_ = 1; i_41_ < oversample; i_41_++)
                            i_40_ += is[i_37_++];
                        is[i_39_] = i_40_ / oversample;
                    }
                }
            }
            for (int i_42_ = 0; i_42_ < i; i_42_++) {
                if (this.oln < 3200000) {
                    is_36_[this.oln] = is[i_42_];
                    this.oln++;
                }
            }
        }
        for (int i = 2; i < this.oln; i++)
            is_36_[i] = (is_36_[i] + is_36_[i - 2]) / 2;
        for (int i = 57; i < this.oln; i++)
            is_36_[i] = (is_36_[i] + is_36_[i] + is_36_[i - 50]) / 3;
        byte[] is_43_ = new byte[this.oln];
        for (int i = 0; i < this.oln; i++)
            is_43_[i] = UlawUtils.linear2ulawclip(is_36_[i]);
        return is_43_;
    }
    
    final void startplaying(boolean bool) {
        this.vol_adj = bool ? loud_vol_adj : normal_vol_adj;
        this.mixspeed = samplingrate * oversample;
        this.order_pos = 0;
        this.tempo_wait = this.tempo = this.def_tempo;
        this.bpm = this.def_bpm;
        this.row = 64;
        this.break_row = 0;
        this.bpm_samples = samplingrate / (24 * this.bpm / 60) * oversample;
        this.numtracks = (this.mod).numtracks;
        this.tracks = new ModTrackInfo[this.numtracks];
        for (int i = 0; i < this.tracks.length; i++)
            this.tracks[i] = new ModTrackInfo();
        if ((this.mod).s3m) {
            for (int i = 0; i < (this.mod).insts.length; i++) {
                ModInstrument modinstrument = (this.mod).insts[i];
                (modinstrument).finetune_rate = (int) (428L * (long) (modinstrument).finetune_value << 8) / this.mixspeed;
                (modinstrument).period_low_limit = 14;
                (modinstrument).period_high_limit = 1712;
            }
        } else {
            for (int i = 0; i < (this.mod).insts.length; i++) {
                ModInstrument modinstrument = (this.mod).insts[i];
                (modinstrument).finetune_rate = (int) (22748294283264L / (long) (this.mixspeed * (1536 - (modinstrument).finetune_value)));
                (modinstrument).period_low_limit = 113;
                (modinstrument).period_high_limit = 856;
            }
        }
        if (this.numtracks > 8)
            this.vol_shift = 2;
        else if (this.numtracks > 4)
            this.vol_shift = 1;
        else
            this.vol_shift = 0;
        if (!bit16)
            make_vol_table8();
    }
    
    final void updatetracks() {
        this.tempo_wait = this.tempo;
        if (this.row >= 64) {
            if (this.order_pos >= (this.mod).song_length_patterns) {
                this.order_pos = 0;
                nloops--;
                if (nloops == 0)
                    this.mod_done = true;
            }
            this.row = this.break_row;
            this.break_row = 0;
            if ((this.mod).positions[this.order_pos] == 255) {
                this.order_pos = 0;
                this.row = 0;
            }
            this.patt = (this.mod).patterns[(this.mod).positions[this.order_pos]];
            this.pattofs = this.row * 4 * this.numtracks;
            this.order_pos++;
        }
        this.row++;
        for (int i = 0; i < this.numtracks; i++)
            this.pattofs = get_track(this.tracks[i], this.patt, this.pattofs);
    }
}
