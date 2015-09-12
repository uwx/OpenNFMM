// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModSlayer.java

package ds.nfm.mod;

import ds.nfm.ModuleSlayer;
import java.io.IOException;

// Referenced classes of package ds.nfm.mod:
//            ModTrackInfo, Mod, ModInstrument

public class ModSlayer extends ModuleSlayer
{

    public ModSlayer(Mod pmod, int smpl, int gn, int bpmflex)
    {
        mod_done = false;
        nloops = 1;
        loud = false;
        loopA = 0;
        loopB = 0;
        loops = 0;
        onLoop = false;
        jumpTo = -1;
        jumpLocation = 0;
        reverseJump = false;
        samplingrate = smpl;
        gain = gn;
        oversample = 1;
        mod = pmod;
        def_tempo = 6;
        def_bpm = bpmflex;
    }

    final void beattrack(ModTrackInfo modtrackinfo)
    {
        if(modtrackinfo.period_low_limit == 0)
            modtrackinfo.period_low_limit = 1;
        if((modtrackinfo.effect & 1) != 0)
        {
            modtrackinfo.volume += modtrackinfo.vol_slide;
            if(modtrackinfo.volume < 0)
                modtrackinfo.volume = 0;
            if(modtrackinfo.volume > 64)
                modtrackinfo.volume = 64;
        }
        if((modtrackinfo.effect & 2) != 0)
        {
            if((modtrackinfo.period += modtrackinfo.port_down) > modtrackinfo.period_high_limit)
                modtrackinfo.period = modtrackinfo.period_high_limit;
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
        }
        if((modtrackinfo.effect & 4) != 0)
        {
            if((modtrackinfo.period -= modtrackinfo.port_up) < modtrackinfo.period_low_limit)
                if(mod.s3m)
                    modtrackinfo.period = modtrackinfo.period_high_limit;
                else
                    modtrackinfo.period = modtrackinfo.period_low_limit;
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
        }
        if((modtrackinfo.effect & 0x20) != 0)
        {
            if(modtrackinfo.portto < modtrackinfo.period)
            {
                if((modtrackinfo.period += modtrackinfo.port_inc) > modtrackinfo.portto)
                    modtrackinfo.period = modtrackinfo.portto;
            } else
            if(modtrackinfo.portto > modtrackinfo.period && (modtrackinfo.period -= modtrackinfo.port_inc) < modtrackinfo.portto)
                modtrackinfo.period = modtrackinfo.portto;
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
        }
        if((modtrackinfo.effect & 8) != 0)
        {
            modtrackinfo.vibpos += modtrackinfo.vib_rate << 2;
            int i = sintable[modtrackinfo.vibpos >> 2 & 0x1f] * modtrackinfo.vib_depth >> 7;
            if((modtrackinfo.vibpos & 0x80) != 0)
                i = -i;
            i += modtrackinfo.period;
            if(mod.s3m)
            {
                if(i < modtrackinfo.period_low_limit)
                    i = modtrackinfo.period_low_limit;
                if(i > modtrackinfo.period_high_limit)
                    i = modtrackinfo.period_high_limit;
            }
            i = i <= 0 ? 1 : i;
            modtrackinfo.pitch = modtrackinfo.finetune_rate / i;
        }
        if((modtrackinfo.effect & 0x10) != 0)
        {
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.arp[modtrackinfo.arpindex];
            modtrackinfo.arpindex++;
            if(modtrackinfo.arpindex >= 3)
                modtrackinfo.arpindex = 0;
        }
    }

    final int get_track(ModTrackInfo modtrackinfo, byte is[], int i)
    {
        int i_2_ = is[i] & 0xf0;
        int i_3_ = (is[i++] & 0xf) << 8;
        i_3_ |= is[i++] & 0xff;
        int i_4_ = is[i] & 0xf;
        i_2_ |= (is[i++] & 0xf0) >> 4;
        int i_5_ = is[i++];
        modtrackinfo.effect = 0;
        if(i_2_ != 0)
        {
            i_2_--;
            ModInstrument modinstrument = mod.insts[i_2_];
            modtrackinfo.volume = modinstrument.volume;
            modtrackinfo.length = modinstrument.sample_length;
            modtrackinfo.repeat = modinstrument.repeat_point;
            modtrackinfo.replen = modinstrument.repeat_length;
            modtrackinfo.finetune_rate = modinstrument.finetune_rate;
            modtrackinfo.samples = modinstrument.samples;
            modtrackinfo.period_low_limit = modinstrument.period_low_limit;
            modtrackinfo.period_high_limit = modinstrument.period_high_limit;
        }
        modtrackinfo.notelimit = -1;
        modtrackinfo.noterestart -= tempo;
        if(modtrackinfo.noterestart < -1)
            modtrackinfo.noterestart = -1;
        if(i_3_ != 0)
        {
            modtrackinfo.portto = i_3_;
            if(i_4_ != 3 && i_4_ != 5)
            {
                modtrackinfo.start_period = modtrackinfo.period = i_3_;
                modtrackinfo.pitch = modtrackinfo.finetune_rate / i_3_;
                modtrackinfo.position = 0;
            }
        }
        if(i_4_ != 0 || i_5_ != 0)
label0:
            switch(i_4_)
            {
            case 7: // '\007'
            case 8: // '\b'
            default:
                break;

            case 0: // '\0'
                int i_6_;
                for(i_6_ = 12; i_6_ < 48 && modtrackinfo.period < period_set[i_6_]; i_6_++);
                modtrackinfo.arp[0] = period_set[i_6_];
                modtrackinfo.arp[1] = period_set[i_6_ + (i_5_ & 0xf)];
                modtrackinfo.arp[2] = period_set[i_6_ + ((i_5_ & 0xf0) >> 4)];
                modtrackinfo.arpindex = 0;
                modtrackinfo.effect |= 0x10;
                break;

            case 1: // '\001'
                modtrackinfo.effect |= 4;
                if(i_5_ != 0)
                    modtrackinfo.port_up = i_5_;
                break;

            case 2: // '\002'
                modtrackinfo.effect |= 2;
                if(i_5_ != 0)
                    modtrackinfo.port_down = i_5_;
                break;

            case 3: // '\003'
                if(i_5_ != 0)
                    modtrackinfo.port_inc = i_5_ & 0xff;
                modtrackinfo.effect |= 0x20;
                break;

            case 4: // '\004'
                if((i_5_ & 0xf) != 0)
                    modtrackinfo.vib_depth = i_5_ & 0xf;
                if((i_5_ & 0xf0) != 0)
                    modtrackinfo.vib_rate = (i_5_ & 0xf0) >> 4;
                if(i_3_ != 0)
                    modtrackinfo.vibpos = 0;
                modtrackinfo.effect |= 8;
                break;

            case 9: // '\t'
                if(i_5_ == 0)
                    i_5_ = modtrackinfo.oldsampofs;
                modtrackinfo.oldsampofs = i_5_;
                modtrackinfo.position = (i_5_ & 0xff) << 8;
                break;

            case 5: // '\005'
                modtrackinfo.effect |= 0x20;
                // fall through

            case 6: // '\006'
                if(i_4_ == 6)
                    modtrackinfo.effect |= 8;
                // fall through

            case 10: // '\n'
                modtrackinfo.vol_slide = ((i_5_ & 0xf0) >> 4) - (i_5_ & 0xf);
                modtrackinfo.effect |= 1;
                break;

            case 11: // '\013'
                if(jumpLocation == order_pos && reverseJump)
                {
                    reverseJump = false;
                    break;
                }
                if(reverseJump || i_5_ >= 128 || i_5_ < 0)
                    break;
                jumpTo = i_5_;
                jumpLocation = order_pos;
                if(jumpTo >= order_pos)
                    break;
                reverseJump = true;
                if(order_pos != mod.song_length_patterns)
                    break;
                if(i_5_ < order_pos - 2)
                {
                    rollBack = i_5_;
                    rollBackPos = patternOffsets[i_5_];
                    loopMark = true;
                }
                jumpTo = -1;
                jumpLocation = 0;
                break;

            case 12: // '\f'
                if(i_5_ > 64 || i_5_ < 0)
                    modtrackinfo.volume = 64;
                else
                    modtrackinfo.volume = i_5_;
                break;

            case 13: // '\r'
                break_row = ((i_5_ & 0xf0) >> 4) * 10 + (i_5_ & 0xf);
                row = 64;
                break;

            case 14: // '\016'
                int i_7_ = (i_5_ & 0xf0) >> 4;
                i_5_ &= 0xf;
                switch(i_7_)
                {
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 7: // '\007'
                case 8: // '\b'
                default:
                    break;

                case 1: // '\001'
                    modtrackinfo.period += i_5_;
                    if(modtrackinfo.period > modtrackinfo.period_high_limit)
                        modtrackinfo.period = modtrackinfo.period_high_limit;
                    modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
                    break label0;

                case 2: // '\002'
                    modtrackinfo.period -= i_5_;
                    if(modtrackinfo.period < modtrackinfo.period_low_limit)
                        modtrackinfo.period = modtrackinfo.period_low_limit;
                    modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
                    break label0;

                case 6: // '\006'
                    if(loops != 0 || onLoop)
                        break label0;
                    if(i_5_ <= 0)
                    {
                        loopA = row;
                    } else
                    {
                        loopB = row;
                        loops = i_5_;
                        onLoop = true;
                    }
                    break label0;

                case 9: // '\t'
                    modtrackinfo.noterestart = i_5_;
                    break label0;

                case 10: // '\n'
                    modtrackinfo.volume += i_5_;
                    if(modtrackinfo.volume > 64)
                        modtrackinfo.volume = 64;
                    if(modtrackinfo.volume < 0)
                        modtrackinfo.volume = 0;
                    break label0;

                case 11: // '\013'
                    modtrackinfo.volume -= i_5_;
                    if(modtrackinfo.volume > 64)
                        modtrackinfo.volume = 64;
                    if(modtrackinfo.volume < 0)
                        modtrackinfo.volume = 0;
                    break;

                case 12: // '\f'
                    modtrackinfo.notelimit = i_5_;
                    break;
                }
                break;

            case 15: // '\017'
                if(i_5_ == 0)
                    break;
                i_5_ &= 0xff;
                if(i_5_ <= 32)
                {
                    tempo = i_5_;
                    tempo_wait = i_5_;
                } else
                {
                    bpm = i_5_;
                    bpm_samples = (samplingrate / (103 * i_5_ >> 8)) * oversample;
                }
                break;
            }
        return i;
    }

    final void make_vol_table8()
    {
        vol_table = new byte[16640];
        for(int i = 0; i < 16640; i++)
            vol_table[i] = (byte)(vol_adj[i >> 8] * (byte)i >> 8 + vol_shift);

    }

    final void mixtrack_16_mono(ModTrackInfo modtrackinfo, int buffer[], int buffpos, int bufflen)
    {
        byte samples[] = modtrackinfo.samples;
        int samplepos = modtrackinfo.position;
        int volume = vol_adj[modtrackinfo.volume] * gain >> vol_shift + 8;
        int error = modtrackinfo.error;
        int lopitch = modtrackinfo.pitch & 0xfff;
        int hipitch = modtrackinfo.pitch >> 12;
        if(modtrackinfo.replen < 3)
        {
            int endtr = modtrackinfo.length;
            if(samplepos < endtr)
            {
                int buffend = buffpos + bufflen;
                if(modtrackinfo.pitch < 4096)
                    while(samplepos < endtr && buffpos < buffend) 
                    {
                        if(modtrackinfo.notelimit == -1 || tempo - tempo_wait < modtrackinfo.notelimit)
                            buffer[buffpos++] += (samples[samplepos] * (4096 - error) + samples[samplepos + 1] * error) * volume >> 12;
                        else
                            modtrackinfo.volume = 0;
                        samplepos += hipitch + ((error += lopitch) >> 12);
                        error &= 0xfff;
                    }
                else
                    while(samplepos < endtr && buffpos < buffend) 
                    {
                        if(modtrackinfo.notelimit == -1 || tempo - tempo_wait < modtrackinfo.notelimit)
                            buffer[buffpos++] += samples[samplepos] * volume;
                        else
                            modtrackinfo.volume = 0;
                        samplepos += hipitch + ((error += lopitch) >> 12);
                        error &= 0xfff;
                    }
                modtrackinfo.error = error;
                if(modtrackinfo.noterestart == -1 || tempo - tempo_wait < modtrackinfo.noterestart)
                {
                    modtrackinfo.position = samplepos;
                } else
                {
                    modtrackinfo.position = 0;
                    modtrackinfo.noterestart = -1;
                }
            }
        } else
        {
            int endtr = modtrackinfo.replen + modtrackinfo.repeat;
            if(modtrackinfo.pitch < 4096)
                for(; bufflen > 0; bufflen--)
                {
                    if(samplepos >= endtr)
                        samplepos -= modtrackinfo.replen;
                    if(samplepos < 0)
                        samplepos = 0;
                    for(; samplepos >= samples.length; samplepos -= samples.length);
                    if(modtrackinfo.notelimit == -1 || tempo - tempo_wait < modtrackinfo.notelimit)
                        buffer[buffpos++] += (samples[samplepos] * (4096 - error) + samples[samplepos + 1] * error) * volume >> 12;
                    else
                        modtrackinfo.volume = 0;
                    samplepos += hipitch + ((error += lopitch) >> 12);
                    error &= 0xfff;
                }

            else
                for(; bufflen > 0; bufflen--)
                {
                    if(samplepos >= endtr)
                        samplepos -= modtrackinfo.replen;
                    if(samplepos < 0)
                        samplepos = 0;
                    for(; samplepos >= samples.length; samplepos -= samples.length);
                    if(modtrackinfo.notelimit == -1 || tempo - tempo_wait < modtrackinfo.notelimit)
                        buffer[buffpos++] += samples[samplepos] * volume;
                    else
                        modtrackinfo.volume = 0;
                    samplepos += hipitch + ((error += lopitch) >> 12);
                    error &= 0xfff;
                }

            modtrackinfo.error = error;
            if(modtrackinfo.noterestart == -1 || tempo - tempo_wait < modtrackinfo.noterestart)
            {
                modtrackinfo.position = samplepos;
            } else
            {
                modtrackinfo.position = 0;
                modtrackinfo.noterestart = -1;
            }
        }
    }

    public byte[] turnbytesNorm(boolean calvol)
        throws IOException
    {
        bit16 = true;
        startplaying(loud);
        int buf[] = new int[mixspeed];
        int emptybuf[] = new int[mixspeed];
        byte realbytes[] = new byte[0x112a880];
        patternOffsets = new int[mod.song_length_patterns];
        oln = 0;
        olav = 1;
        int olniu = 1;
        do
        {
            if(mod_done)
                break;
            if(--tempo_wait > 0)
            {
                for(int count = 0; count < numtracks; count++)
                    beattrack(tracks[count]);

            } else
            {
                updatetracks();
            }
            if(!mod_done)
            {
                if(row == 1 && tempo_wait == tempo)
                    patternOffsets[order_pos - 1] = oln;
                System.arraycopy(emptybuf, 0, buf, 0, bpm_samples);
                for(int i = 0; i < numtracks; i++)
                    mixtrack_16_mono(tracks[i], buf, 0, bpm_samples);

                int real_samples = bpm_samples;
                if(oversample > 1)
                {
                    int k = 0;
                    real_samples = bpm_samples / oversample;
                    if(oversample == 2)
                    {
                        for(int i = 0; i < real_samples; i++)
                        {
                            buf[i] = buf[k] + buf[k + 1] >> 1;
                            k += 2;
                        }

                    } else
                    {
                        for(int i = 0; i < real_samples; i++)
                        {
                            int sum = buf[k++];
                            for(int j = 1; j < oversample; j++)
                                sum += buf[k++];

                            buf[i] = sum / oversample;
                        }

                    }
                }
                if(oln + real_samples < 0x112a880)
                {
                    if(calvol)
                    {
                        int niu = 0;
                        int cav = 0;
                        for(int i = 0; i < real_samples; i++)
                            if(buf[i] > 0)
                            {
                                cav += buf[i];
                                niu++;
                            }

                        if(niu != 0)
                        {
                            cav /= niu;
                            olav += cav;
                            olniu++;
                        }
                    }
                    intToBytes16(buf, realbytes, real_samples, oln);
                    oln += real_samples;
                }
            }
            if(loopMark)
            {
                rollBackTrig = oln;
                loopMark = false;
            }
        } while(true);
        if(calvol)
            olav = olav / olniu;
        oln++;
        return realbytes;
    }

    public static void intToBytes16(int sample[], byte buffer[], int realsamples, int oln)
    {
        int byteOffset = oln;
        for(int i = 0; i < realsamples; i++)
        {
            buffer[byteOffset++] = (byte)(sample[i] >> 8);
            buffer[byteOffset] = (byte)(sample[i] & 0xff);
        }

    }

    final void startplaying(boolean flag)
    {
        vol_adj = flag ? loud_vol_adj : normal_vol_adj;
        mixspeed = samplingrate * oversample;
        order_pos = 0;
        tempo_wait = tempo = def_tempo;
        bpm = def_bpm;
        row = 64;
        break_row = 0;
        bpm_samples = (samplingrate / ((24 * bpm) / 60)) * oversample;
        numtracks = mod.numtracks;
        tracks = new ModTrackInfo[numtracks];
        for(int i = 0; i < tracks.length; i++)
            tracks[i] = new ModTrackInfo();

        if(mod.s3m)
        {
            for(int j = 0; j < mod.insts.length; j++)
            {
                ModInstrument modinstrument = mod.insts[j];
                modinstrument.finetune_rate = (int)(428L * (long)modinstrument.finetune_value << 8) / mixspeed;
                modinstrument.period_low_limit = 14;
                modinstrument.period_high_limit = 1712;
            }

        } else
        {
            for(int k = 0; k < mod.insts.length; k++)
            {
                ModInstrument modinstrument1 = mod.insts[k];
                modinstrument1.finetune_rate = (int)(0x14b080000000L / (long)(mixspeed * (1536 - modinstrument1.finetune_value)));
                modinstrument1.period_low_limit = 113;
                modinstrument1.period_high_limit = 856;
            }

        }
        if(numtracks > 8)
            vol_shift = 2;
        else
        if(numtracks > 4)
            vol_shift = 1;
        else
            vol_shift = 0;
        if(!bit16)
            make_vol_table8();
    }

    final void updatetracks()
    {
        tempo_wait = tempo;
        if(jumpTo != -1)
        {
            onLoop = false;
            loopA = row;
            row = break_row;
            break_row = 0;
            order_pos = jumpTo;
            patt = mod.patterns[mod.positions[order_pos]];
            pattofs = row * 4 * numtracks;
            order_pos++;
            jumpTo = -1;
        }
        if(row >= 64)
        {
            onLoop = false;
            loopA = row;
            if(order_pos >= mod.song_length_patterns)
            {
                order_pos = 0;
                nloops--;
                if(nloops == 0)
                    mod_done = true;
            }
            row = break_row;
            break_row = 0;
            if(mod.positions[order_pos] == 255)
            {
                order_pos = 0;
                row = 0;
            }
            patt = mod.patterns[mod.positions[order_pos]];
            pattofs = row * 4 * numtracks;
            order_pos++;
        } else
        {
            if(loops > 0 && loops > 0 && row == loopB)
            {
                row = loopA - 1;
                pattofs = row * 4 * numtracks;
                loops--;
            }
            if(loops == 0 && row == loopB + 1)
            {
                onLoop = false;
                loopA = row;
            }
        }
        row++;
        for(int i = 0; i < numtracks; i++)
            pattofs = get_track(tracks[i], patt, pattofs);

    }

    static final String VERSION = "1.1";
    static final String COPYRIGHT = "DragShot Software (c) 2014";
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
    static final int normal_vol_adj[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 
        20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 
        30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 
        40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 
        50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 
        60, 61, 62, 63, 63
    };
    static final int loud_vol_adj[] = {
        0, 0, 1, 2, 2, 3, 3, 4, 5, 6, 
        7, 8, 9, 10, 12, 14, 16, 18, 20, 22, 
        24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 
        44, 46, 47, 48, 49, 50, 51, 52, 53, 53, 
        54, 55, 55, 56, 56, 57, 57, 58, 58, 59, 
        59, 60, 60, 61, 61, 61, 62, 62, 62, 63, 
        63, 63, 63, 63, 63
    };
    static final int sintable[] = {
        0, 25, 50, 74, 98, 120, 142, 162, 180, 197, 
        212, 225, 236, 244, 250, 254, 255, 254, 250, 244, 
        236, 225, 212, 197, 180, 162, 142, 120, 98, 74, 
        50, 25
    };
    static final int period_set[] = {
        1712, 1616, 1525, 1440, 1359, 1283, 1211, 1143, 1078, 1018, 
        961, 907, 856, 808, 763, 720, 679, 641, 605, 571, 
        539, 509, 480, 453, 428, 404, 381, 360, 340, 321, 
        303, 286, 270, 254, 240, 227, 214, 202, 191, 180, 
        170, 160, 151, 143, 135, 127, 120, 113, 107, 101, 
        95, 90, 85, 80, 76, 71, 67, 64, 60, 57, 
        53, 50, 48, 45, 42, 40, 38, 36, 34, 32, 
        30, 28, 27, 25, 24, 22, 21, 20, 19, 18, 
        17, 16, 15, 14
    };
    static final int period_set_step[] = {
        1664, 1570, 1482, 1399, 1321, 1247, 1177, 1110, 1048, 989, 
        934, 881, 832, 785, 741, 699, 660, 623, 588, 555, 
        524, 494, 466, 440, 416, 392, 370, 350, 330, 312, 
        294, 278, 262, 247, 233, 220, 208, 196, 185, 175, 
        165, 155, 147, 139, 131, 123, 116, 110, 104, 98, 
        92, 87, 82, 78, 73, 69, 65, 62, 58, 55, 
        51, 49, 46, 43, 41, 39, 37, 35, 33, 31, 
        29, 27, 26, 24, 23, 21, 20, 19, 18, 17, 
        16, 15, 14, 14
    };
    int def_tempo;
    int def_bpm;
    byte vol_table[];
    int vol_adj[];
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
    byte patt[];
    int numtracks;
    ModTrackInfo tracks[];
    int mixspeed;
    boolean mod_done;
    public boolean bit16;
    public int samplingrate;
    public int oversample;
    public int gain;
    public int nloops;
    public boolean loud;
    private static final int ERROR_SHIFT = 12;
    private static final int ERROR_MASK = 4095;
    private static final long ratediv = 0x14b080000000L;
    int loopA;
    int loopB;
    int loops;
    boolean onLoop;
    int jumpTo;
    int jumpLocation;
    boolean reverseJump;
    int patternOffsets[];

}
