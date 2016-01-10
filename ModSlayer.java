
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name:   ModSlayer.java

import java.io.IOException;

public class ModSlayer {

    static final String COPYRIGHT = "";

    static final int DEF_BPM_NTSC = 125;

    static final int DEF_BPM_PAL = 145;

    static final int DEF_TEMPO_NTSC = 6;

    static final int DEF_TEMPO_PAL = 6;

    static final int EFF_ARPEGGIO = 16;

    static final int EFF_PORT_DOWN = 2;

    static final int EFF_PORT_TO = 32;

    static final int EFF_PORT_UP = 4;

    static final int EFF_RETRIG = 128;

    static final int EFF_TREMOLO = 64;
    static final int EFF_VIBRATO = 8;
    static final int EFF_VOL_SLIDE = 1;
    static final int loudVolAdj[] = {
            0, 0, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42,
            44, 46, 47, 48, 49, 50, 51, 52, 53, 53, 54, 55, 55, 56, 56, 57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 61, 62,
            62, 62, 63, 63, 63, 63, 63, 63
    };
    static final int MAX_SAMPLES = 100;
    static final int MAX_TRACKS = 32;
    static final int MIDCRATE = 8448;
    static final int MIX_BUF_SIZE = 2048;
    static final int normalVolAdj[] = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
            29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55,
            56, 57, 58, 59, 60, 61, 62, 63, 63
    };
    static final int periodSet[] = {
            1712, 1616, 1525, 1440, 1359, 1283, 1211, 1143, 1078, 1018, 961, 907, 856, 808, 763, 720, 679, 641, 605,
            571, 539, 509, 480, 453, 428, 404, 381, 360, 340, 321, 303, 286, 270, 254, 240, 227, 214, 202, 191, 180,
            170, 160, 151, 143, 135, 127, 120, 113, 107, 101, 95, 90, 85, 80, 76, 71, 67, 64, 60, 57, 53, 50, 48, 45,
            42, 40, 38, 36, 34, 32, 30, 28, 27, 25, 24, 22, 21, 20, 19, 18, 17, 16, 15, 14
    };
    static final int periodSetStep[] = {
            1664, 1570, 1482, 1399, 1321, 1247, 1177, 1110, 1048, 989, 934, 881, 832, 785, 741, 699, 660, 623, 588, 555,
            524, 494, 466, 440, 416, 392, 370, 350, 330, 312, 294, 278, 262, 247, 233, 220, 208, 196, 185, 175, 165,
            155, 147, 139, 131, 123, 116, 110, 104, 98, 92, 87, 82, 78, 73, 69, 65, 62, 58, 55, 51, 49, 46, 43, 41, 39,
            37, 35, 33, 31, 29, 27, 26, 24, 23, 21, 20, 19, 18, 17, 16, 15, 14, 14
    };
    static final int S3M_INSTR2 = Mod.FOURCC("SCRS");
    static final int S3M_MAGIC1 = 4122;
    static final int S3M_MAGIC2 = Mod.FOURCC("SCRM");
    static final int sintable[] = {
            0, 25, 50, 74, 98, 120, 142, 162, 180, 197, 212, 225, 236, 244, 250, 254, 255, 254, 250, 244, 236, 225, 212,
            197, 180, 162, 142, 120, 98, 74, 50, 25
    };
    static final String VERSION = "1.0";

    public static void intToBytes16(final int ai[], final byte abyte0[], final int i, final int j) {
        int k = j;
        for (int l = 0; l < i; l++) {
            abyte0[k++] = (byte) (ai[l] >> 8);
            abyte0[k] = (byte) (ai[l] & 0xff);
        }

    }

    public boolean bit16;
    int bpm;
    int bpmSamples;
    int breakRow;
    int defBpm;
    int defTempo;
    public int gain;
    public boolean loud;
    int mixspeed;
    Mod mod;
    boolean modDone;
    public int nloops;
    int numtracks;
    int olav;
    int oln;
    int orderPos;
    public int oversample;
    byte patt[];
    int pattofs;
    int row;
    public int samplingrate;
    int tempo;
    int tempoWait;
    ModTrackInfo tracks[];
    int volAdj[];
    int volShift;
    byte volTable[];

    ModSlayer(final Mod mod1, final int i, final int j, final int k) {
        modDone = false;
        nloops = 1;
        loud = false;
        oln = 0;
        olav = 0;
        samplingrate = i;
        gain = j;
        oversample = 1;
        mod = mod1;
        defTempo = 6;
        defBpm = k;
    }

    final void beattrack(final ModTrackInfo modtrackinfo) {
        if (modtrackinfo.periodLowLimit == 0)
            modtrackinfo.periodLowLimit = 1;
        if ((modtrackinfo.effect & 1) != 0) {
            modtrackinfo.volume += modtrackinfo.volSlide;
            if (modtrackinfo.volume < 0)
                modtrackinfo.volume = 0;
            if (modtrackinfo.volume > 64)
                modtrackinfo.volume = 64;
        }
        if ((modtrackinfo.effect & 2) != 0) {
            if ((modtrackinfo.period += modtrackinfo.portDown) > modtrackinfo.periodHighLimit)
                modtrackinfo.period = modtrackinfo.periodHighLimit;
            modtrackinfo.pitch = modtrackinfo.finetuneRate / modtrackinfo.period;
        }
        if ((modtrackinfo.effect & 4) != 0) {
            if ((modtrackinfo.period -= modtrackinfo.portUp) < modtrackinfo.periodLowLimit)
                if (mod.s3m)
                    modtrackinfo.period = modtrackinfo.periodHighLimit;
                else
                    modtrackinfo.period = modtrackinfo.periodLowLimit;
            modtrackinfo.pitch = modtrackinfo.finetuneRate / modtrackinfo.period;
        }
        if ((modtrackinfo.effect & 0x20) != 0) {
            if (modtrackinfo.portto < modtrackinfo.period) {
                if ((modtrackinfo.period += modtrackinfo.portInc) > modtrackinfo.portto)
                    modtrackinfo.period = modtrackinfo.portto;
            } else if (modtrackinfo.portto > modtrackinfo.period
                    && (modtrackinfo.period -= modtrackinfo.portInc) < modtrackinfo.portto)
                modtrackinfo.period = modtrackinfo.portto;
            modtrackinfo.pitch = modtrackinfo.finetuneRate / modtrackinfo.period;
        }
        if ((modtrackinfo.effect & 8) != 0) {
            modtrackinfo.vibpos += modtrackinfo.vibRate << 2;
            int i = sintable[modtrackinfo.vibpos >> 2 & 0x1f] * modtrackinfo.vibDepth >> 7;
            if ((modtrackinfo.vibpos & 0x80) != 0)
                i = -i;
            i += modtrackinfo.period;
            if (i < modtrackinfo.periodLowLimit)
                i = modtrackinfo.periodLowLimit;
            if (i > modtrackinfo.periodHighLimit)
                i = modtrackinfo.periodHighLimit;
            modtrackinfo.pitch = modtrackinfo.finetuneRate / i;
        }
        if ((modtrackinfo.effect & 0x10) != 0) {
            modtrackinfo.pitch = modtrackinfo.finetuneRate / modtrackinfo.arp[modtrackinfo.arpindex];
            modtrackinfo.arpindex++;
            if (modtrackinfo.arpindex >= 3)
                modtrackinfo.arpindex = 0;
        }
    }

    final int getTrack(final ModTrackInfo modtrackinfo, final byte abyte0[], int i) {
        int j = abyte0[i] & 0xf0;
        int k = (abyte0[i++] & 0xf) << 8;
        k |= abyte0[i++] & 0xff;
        final int l = abyte0[i] & 0xf;
        j |= (abyte0[i++] & 0xf0) >> 4;
        int i1 = abyte0[i++];
        modtrackinfo.effect = 0;
        if (j != 0) {
            j--;
            final ModInstrument modinstrument = mod.insts[j];
            modtrackinfo.volume = modinstrument.volume;
            modtrackinfo.length = modinstrument.sampleLength;
            modtrackinfo.repeat = modinstrument.repeatPoint;
            modtrackinfo.replen = modinstrument.repeatLength;
            modtrackinfo.finetuneRate = modinstrument.finetuneRate;
            modtrackinfo.samples = modinstrument.samples;
            modtrackinfo.periodLowLimit = modinstrument.periodLowLimit;
            modtrackinfo.periodHighLimit = modinstrument.periodHighLimit;
        }
        if (k != 0) {
            modtrackinfo.portto = k;
            if (l != 3 && l != 5) {
                modtrackinfo.startPeriod = modtrackinfo.period = k;
                modtrackinfo.pitch = modtrackinfo.finetuneRate / k;
                modtrackinfo.position = 0;
            }
        }
        if (l != 0 || i1 != 0)
            label0: switch (l) {
                case 7: // '\007'
                case 8: // '\b'
                case 11: // '\013'
                default:
                    break;

                case 0: // '\0'
                    int j1;
                    for (j1 = 12; j1 < 48 && modtrackinfo.period < periodSet[j1]; j1++)
                        ;
                    modtrackinfo.arp[0] = periodSet[j1];
                    modtrackinfo.arp[1] = periodSet[j1 + (i1 & 0xf)];
                    modtrackinfo.arp[2] = periodSet[j1 + ((i1 & 0xf0) >> 4)];
                    modtrackinfo.arpindex = 0;
                    modtrackinfo.effect |= 0x10;
                    break;

                case 1: // '\001'
                    modtrackinfo.effect |= 4;
                    if (i1 != 0)
                        modtrackinfo.portUp = i1;
                    break;

                case 2: // '\002'
                    modtrackinfo.effect |= 2;
                    if (i1 != 0)
                        modtrackinfo.portDown = i1;
                    break;

                case 3: // '\003'
                    if (i1 != 0)
                        modtrackinfo.portInc = i1 & 0xff;
                    modtrackinfo.effect |= 0x20;
                    break;

                case 4: // '\004'
                    if ((i1 & 0xf) != 0)
                        modtrackinfo.vibDepth = i1 & 0xf;
                    if ((i1 & 0xf0) != 0)
                        modtrackinfo.vibRate = (i1 & 0xf0) >> 4;
                    if (k != 0)
                        modtrackinfo.vibpos = 0;
                    modtrackinfo.effect |= 8;
                    break;

                case 9: // '\t'
                    if (i1 == 0)
                        i1 = modtrackinfo.oldsampofs;
                    modtrackinfo.oldsampofs = i1;
                    modtrackinfo.position = (i1 & 0xff) << 8;
                    break;

                case 5: // '\005'
                    modtrackinfo.effect |= 0x20;
                    // fall through

                case 6: // '\006'
                    if (l == 6)
                        modtrackinfo.effect |= 8;
                    // fall through

                case 10: // '\n'
                    modtrackinfo.volSlide = ((i1 & 0xf0) >> 4) - (i1 & 0xf);
                    modtrackinfo.effect |= 1;
                    break;

                case 12: // '\f'
                    if (i1 > 64 || i1 < 0)
                        modtrackinfo.volume = 64;
                    else
                        modtrackinfo.volume = i1;
                    break;

                case 13: // '\r'
                    breakRow = ((i1 & 0xf0) >> 4) * 10 + (i1 & 0xf);
                    row = 64;
                    break;

                case 14: // '\016'
                    final int k1 = i1 & 0xf0;
                    i1 &= 0xf;
                    switch (k1) {
                        default:
                            break label0;

                        case 1: // '\001'
                            modtrackinfo.period += i1;
                            if (modtrackinfo.period > modtrackinfo.periodHighLimit)
                                modtrackinfo.period = modtrackinfo.periodHighLimit;
                            modtrackinfo.pitch = modtrackinfo.finetuneRate / modtrackinfo.period;
                            break label0;

                        case 2: // '\002'
                            modtrackinfo.period -= i1;
                            break;
                    }
                    if (modtrackinfo.period < modtrackinfo.periodLowLimit)
                        modtrackinfo.period = modtrackinfo.periodLowLimit;
                    modtrackinfo.pitch = modtrackinfo.finetuneRate / modtrackinfo.period;
                    break;

                case 15: // '\017'
                    if (i1 == 0)
                        break;
                    i1 &= 0xff;
                    if (i1 <= 32) {
                        tempo = i1;
                        tempoWait = i1;
                    } else {
                        bpm = i1;
                        bpmSamples = samplingrate / (103 * i1 >> 8) * oversample;
                    }
                    break;
            }
        return i;
    }

    final void makeVolTable8() {
        volTable = new byte[16640];
        for (int i = 0; i < 16640; i++)
            volTable[i] = (byte) (volAdj[i >> 8] * (byte) i >> 8 + volShift);

    }

    final void mixtrack_16Mono(final ModTrackInfo modtrackinfo, final int ai[], int i, int j) {
        final byte abyte0[] = modtrackinfo.samples;
        int k = modtrackinfo.position;
        final int j1 = volAdj[modtrackinfo.volume] * gain >> volShift + 8;
        int i2 = modtrackinfo.error;
        final int k1 = modtrackinfo.pitch & 0xfff;
        final int l1 = modtrackinfo.pitch >> 12;
        if (modtrackinfo.replen < 3) {
            final int l = modtrackinfo.length;
            if (k >= l)
                return;
            final int j2 = i + j;
            if (modtrackinfo.pitch < 4096)
                while (k < l && i < j2) {
                    ai[i++] += (abyte0[k] * (4096 - i2) + abyte0[k + 1] * i2) * j1 >> 12;
                    k += l1 + ((i2 += k1) >> 12);
                    i2 &= 0xfff;
                }
            else
                while (k < l && i < j2) {
                    ai[i++] += abyte0[k] * j1;
                    k += l1 + ((i2 += k1) >> 12);
                    i2 &= 0xfff;
                }
            modtrackinfo.error = i2;
            modtrackinfo.position = k;
        } else {
            final int i1 = modtrackinfo.replen + modtrackinfo.repeat;
            if (modtrackinfo.pitch < 4096)
                for (; j > 0; j--) {
                    if (k >= i1)
                        k -= modtrackinfo.replen;
                    ai[i++] += (abyte0[k] * (4096 - i2) + abyte0[k + 1] * i2) * j1 >> 12;
                    k += l1 + ((i2 += k1) >> 12);
                    i2 &= 0xfff;
                }

            else
                for (; j > 0; j--) {
                    if (k >= i1)
                        k -= modtrackinfo.replen;
                    ai[i++] += abyte0[k] * j1;
                    k += l1 + ((i2 += k1) >> 12);
                    i2 &= 0xfff;
                }

            modtrackinfo.error = i2;
            modtrackinfo.position = k;
        }
    }

    final void startplaying(final boolean flag) {
        volAdj = flag ? loudVolAdj : normalVolAdj;
        mixspeed = samplingrate * oversample;
        orderPos = 0;
        tempoWait = tempo = defTempo;
        bpm = defBpm;
        row = 64;
        breakRow = 0;
        bpmSamples = samplingrate / (24 * bpm / 60) * oversample;
        numtracks = mod.numtracks;
        tracks = new ModTrackInfo[numtracks];
        for (int i = 0; i < tracks.length; i++)
            tracks[i] = new ModTrackInfo();

        if (mod.s3m)
            for (int j = 0; j < mod.insts.length; j++) {
                final ModInstrument modinstrument = mod.insts[j];
                modinstrument.finetuneRate = (int) (428L * modinstrument.finetuneValue << 8) / mixspeed;
                modinstrument.periodLowLimit = 14;
                modinstrument.periodHighLimit = 1712;
            }
        else
            for (int k = 0; k < mod.insts.length; k++) {
                final ModInstrument modinstrument1 = mod.insts[k];
                modinstrument1.finetuneRate = (int) (0x14b080000000L
                        / (mixspeed * (1536 - modinstrument1.finetuneValue)));
                modinstrument1.periodLowLimit = 113;
                modinstrument1.periodHighLimit = 856;
            }
        if (numtracks > 8)
            volShift = 2;
        else if (numtracks > 4)
            volShift = 1;
        else
            volShift = 0;
        if (!bit16)
            makeVolTable8();
    }

    public byte[] turnbytesNorm(final boolean flag) throws IOException {
        bit16 = true;
        startplaying(loud);
        final int ai[] = new int[mixspeed];
        final int ai1[] = new int[mixspeed];
        final byte abyte0[] = new byte[0x112a880];
        oln = 0;
        olav = 1;
        int j1 = 1;
        do {
            if (modDone)
                break;
            if (--tempoWait > 0)
                for (int i1 = 0; i1 < numtracks; i1++)
                    beattrack(tracks[i1]);
            else
                updatetracks();
            System.arraycopy(ai1, 0, ai, 0, bpmSamples);
            for (int i = 0; i < numtracks; i++)
                mixtrack_16Mono(tracks[i], ai, 0, bpmSamples);

            int k1 = bpmSamples;
            if (oversample > 1) {
                int l1 = 0;
                k1 = bpmSamples / oversample;
                if (oversample == 2)
                    for (int j = 0; j < k1; j++) {
                        ai[j] = ai[l1] + ai[l1 + 1] >> 1;
                        l1 += 2;
                    }
                else
                    for (int k = 0; k < k1; k++) {
                        int j2 = ai[l1++];
                        for (int l2 = 1; l2 < oversample; l2++)
                            j2 += ai[l1++];

                        ai[k] = j2 / oversample;
                    }
            }
            if (oln + k1 < 0x112a880) {
                if (flag) {
                    int i2 = 0;
                    int k2 = 0;
                    for (int l = 0; l < k1; l++)
                        if (ai[l] > 0) {
                            k2 += ai[l];
                            i2++;
                        }

                    if (i2 != 0) {
                        k2 /= i2;
                        olav += k2;
                        j1++;
                    }
                }
                intToBytes16(ai, abyte0, k1, oln);
                oln += k1;
            }
        } while (true);
        if (flag)
            olav = olav / j1;
        oln++;
        return abyte0;
    }

    public byte[] turnbytesUlaw() throws IOException {
        bit16 = true;
        startplaying(loud);
        final int ai[] = new int[mixspeed];
        final int ai1[] = new int[mixspeed];
        final int ai2[] = new int[0x30d400];
        oln = 0;
        while (!modDone) {
            if (--tempoWait > 0)
                for (int k1 = 0; k1 < numtracks; k1++)
                    beattrack(tracks[k1]);
            else
                updatetracks();
            System.arraycopy(ai1, 0, ai, 0, bpmSamples);
            for (int i = 0; i < numtracks; i++)
                mixtrack_16Mono(tracks[i], ai, 0, bpmSamples);

            int l1 = bpmSamples;
            if (oversample > 1) {
                int i2 = 0;
                l1 = bpmSamples / oversample;
                if (oversample == 2)
                    for (int j = 0; j < l1; j++) {
                        ai[j] = ai[i2] + ai[i2 + 1] >> 1;
                        i2 += 2;
                    }
                else
                    for (int k = 0; k < l1; k++) {
                        int k2 = ai[i2++];
                        for (int l2 = 1; l2 < oversample; l2++)
                            k2 += ai[i2++];

                        ai[k] = k2 / oversample;
                    }
            }
            int l = 0;
            while (l < l1) {
                if (oln < 0x30d400) {
                    ai2[oln] = ai[l];
                    oln++;
                }
                l++;
            }
        }
        for (int i1 = 2; i1 < oln; i1++)
            ai2[i1] = (ai2[i1] + ai2[i1 - 2]) / 2;

        for (int j1 = 57; j1 < oln; j1++)
            ai2[j1] = (ai2[j1] + ai2[j1] + ai2[j1 - 50]) / 3;

        final byte abyte0[] = new byte[oln];
        for (int j2 = 0; j2 < oln; j2++)
            abyte0[j2] = UlawUtils.linear2ulawclip(ai2[j2]);

        return abyte0;
    }

    final void updatetracks() {
        tempoWait = tempo;
        if (row >= 64) {
            if (orderPos >= mod.songLengthPatterns) {
                orderPos = 0;
                nloops--;
                if (nloops == 0)
                    modDone = true;
            }
            row = breakRow;
            breakRow = 0;
            if (mod.positions[orderPos] == 255) {
                orderPos = 0;
                row = 0;
            }
            patt = mod.patterns[mod.positions[orderPos]];
            pattofs = row * 4 * numtracks;
            orderPos++;
        }
        row++;
        for (int i = 0; i < numtracks; i++)
            pattofs = getTrack(tracks[i], patt, pattofs);

    }

}
