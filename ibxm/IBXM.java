// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IBXM.java

package ibxm;

import ds.nfm.xm.IBXModSlayer;

// Referenced classes of package ibxm:
//            Channel, GlobalVol, Note, Pattern, 
//            Module

public class IBXM
{

    public IBXM(Module module, int samplingRate)
    {
        mustNotify = false;
        this.module = module;
        setSampleRate(samplingRate);
        interpolation = 1;
        rampBuf = new int[128];
        channels = new Channel[module.numChannels];
        globalVol = new GlobalVol();
        note = new Note();
        setSequencePos(0);
    }

    public void connect(IBXModSlayer slayer)
    {
        this.slayer = slayer;
        slayer.patternOffsets = new int[module.sequenceLength];
    }

    public int getSampleRate()
    {
        return sampleRate;
    }

    public void setSampleRate(int rate)
    {
        if(rate < 8000 || rate > 0x1f400)
        {
            throw new IllegalArgumentException("Unsupported sampling rate!");
        } else
        {
            sampleRate = rate;
            return;
        }
    }

    public void setInterpolation(int interpolation)
    {
        this.interpolation = interpolation;
    }

    public int getMixBufferLength()
    {
        return (calculateTickLen(32, 0x1f400) + 65) * 4;
    }

    public int getRow()
    {
        return row;
    }

    public int getSequencePos()
    {
        return seqPos;
    }

    public void setSequencePos(int pos)
    {
        if(pos >= module.sequenceLength)
            pos = 0;
        breakSeqPos = pos;
        nextRow = 0;
        tick = 1;
        globalVol.volume = module.defaultGVol;
        speed = module.defaultSpeed <= 0 ? 6 : module.defaultSpeed;
        tempo = module.defaultTempo <= 0 ? 125 : module.defaultTempo;
        plCount = plChannel = -1;
        for(int idx = 0; idx < module.numChannels; idx++)
            channels[idx] = new Channel(module, idx, globalVol);

        for(int idx = 0; idx < 128; idx++)
            rampBuf[idx] = 0;

        tick();
    }

    public int calculateSongDuration()
    {
        int duration = 0;
        setSequencePos(0);
        for(boolean songEnd = false; !songEnd; songEnd = tick())
            duration += calculateTickLen(tempo, sampleRate);

        setSequencePos(0);
        return duration;
    }

    public int seek(int samplePos)
    {
        setSequencePos(0);
        int currentPos = 0;
        for(int tickLen = calculateTickLen(tempo, sampleRate); samplePos - currentPos >= tickLen; tickLen = calculateTickLen(tempo, sampleRate))
        {
            for(int idx = 0; idx < module.numChannels; idx++)
                channels[idx].updateSampleIdx(tickLen * 2, sampleRate * 2);

            currentPos += tickLen;
            tick();
        }

        return currentPos;
    }

    public void seekSequencePos(int sequencePos, int sequenceRow)
    {
        setSequencePos(0);
        if(sequencePos < 0 || sequencePos >= module.sequenceLength)
            sequencePos = 0;
        if(sequenceRow >= module.patterns[module.sequence[sequencePos]].numRows)
            sequenceRow = 0;
        while(seqPos < sequencePos || row < sequenceRow) 
        {
            int tickLen = calculateTickLen(tempo, sampleRate);
            for(int idx = 0; idx < module.numChannels; idx++)
                channels[idx].updateSampleIdx(tickLen * 2, sampleRate * 2);

            if(tick())
            {
                setSequencePos(sequencePos);
                return;
            }
        }
    }

    public int getAudio(int outputBuf[])
    {
        int tickLen = calculateTickLen(tempo, sampleRate);
        int idx = 0;
        for(int end = (tickLen + 65) * 4; idx < end; idx++)
            outputBuf[idx] = 0;

        for(int chanIdx = 0; chanIdx < module.numChannels; chanIdx++)
        {
            Channel chan = channels[chanIdx];
            chan.resample(outputBuf, 0, (tickLen + 65) * 2, sampleRate * 2, interpolation);
            chan.updateSampleIdx(tickLen * 2, sampleRate * 2);
        }

        downsample(outputBuf, tickLen + 64);
        volumeRamp(outputBuf, tickLen);
        tick();
        return tickLen;
    }

    private int calculateTickLen(int tempo, int samplingRate)
    {
        return (samplingRate * 5) / (tempo * 2);
    }

    private void volumeRamp(int mixBuf[], int tickLen)
    {
        int rampRate = 0x80000 / sampleRate;
        int idx = 0;
        for(int a1 = 0; a1 < 256; a1 += rampRate)
        {
            int a2 = 256 - a1;
            mixBuf[idx] = mixBuf[idx] * a1 + rampBuf[idx] * a2 >> 8;
            mixBuf[idx + 1] = mixBuf[idx + 1] * a1 + rampBuf[idx + 1] * a2 >> 8;
            idx += 2;
        }

        System.arraycopy(mixBuf, tickLen * 2, rampBuf, 0, 128);
    }

    private void downsample(int buf[], int count)
    {
        int outLen = count * 2;
        int inIdx = 0;
        for(int outIdx = 0; outIdx < outLen; outIdx += 2)
        {
            buf[outIdx] = (buf[inIdx] >> 2) + (buf[inIdx + 2] >> 1) + (buf[inIdx + 4] >> 2);
            buf[outIdx + 1] = (buf[inIdx + 1] >> 2) + (buf[inIdx + 3] >> 1) + (buf[inIdx + 5] >> 2);
            inIdx += 4;
        }

    }

    private boolean tick()
    {
        boolean songEnd = false;
        if(--tick <= 0)
        {
            tick = speed;
            songEnd = row();
        } else
        {
            for(int idx = 0; idx < module.numChannels; idx++)
                channels[idx].tick();

        }
        return songEnd;
    }

    private boolean row()
    {
        boolean songEnd = false;
        if(breakSeqPos >= 0)
        {
            if(breakSeqPos >= module.sequenceLength)
            {
                breakSeqPos = nextRow = 0;
                songEnd = true;
            }
            do
            {
                if(module.sequence[breakSeqPos] < module.numPatterns)
                    break;
                breakSeqPos++;
                if(breakSeqPos >= module.sequenceLength)
                    breakSeqPos = nextRow = 0;
            } while(true);
            if(breakSeqPos <= seqPos)
            {
                songEnd = true;
                if(slayer != null && slayer.patternOffsets[breakSeqPos] != 0)
                {
                    slayer.loopMark = true;
                    slayer.rollBack = breakSeqPos;
                    slayer.rollBackPos = slayer.patternOffsets[breakSeqPos];
                }
            }
            seqPos = breakSeqPos;
            for(int idx = 0; idx < module.numChannels; idx++)
                channels[idx].plRow = 0;

            breakSeqPos = -1;
        }
        Pattern pattern = module.patterns[module.sequence[seqPos]];
        row = nextRow;
        if(row >= pattern.numRows)
            row = 0;
        if(row == 0)
            mustNotify = true;
        if(mustNotify)
        {
            if(slayer != null && breakSeqPos < module.sequenceLength)
                slayer.offMark(seqPos);
            mustNotify = false;
        }
        nextRow = row + 1;
        if(nextRow >= pattern.numRows)
        {
            breakSeqPos = seqPos + 1;
            nextRow = 0;
        }
        int noteIdx = row * module.numChannels;
        for(int chanIdx = 0; chanIdx < module.numChannels; chanIdx++)
        {
            Channel channel = channels[chanIdx];
            pattern.getNote(noteIdx + chanIdx, note);
            if(note.effect == 14)
            {
                note.effect = 0x70 | note.param >> 4;
                note.param &= 0xf;
            }
            if(note.effect == 147)
            {
                note.effect = 0xf0 | note.param >> 4;
                note.param &= 0xf;
            }
            if(note.effect == 0 && note.param > 0)
                note.effect = 138;
            channel.row(note);
            switch(note.effect)
            {
            default:
                break;

            case 129: 
                if(note.param > 0)
                    tick = speed = note.param;
                break;

            case 11: // '\013'
            case 130: 
                if(plCount < 0)
                {
                    breakSeqPos = note.param;
                    nextRow = 0;
                    mustNotify = true;
                }
                break;

            case 13: // '\r'
            case 131: 
                if(plCount < 0)
                {
                    breakSeqPos = seqPos + 1;
                    nextRow = (note.param >> 4) * 10 + (note.param & 0xf);
                    mustNotify = true;
                }
                break;

            case 15: // '\017'
                if(note.param <= 0)
                    break;
                if(note.param < 32)
                    tick = speed = note.param;
                else
                    tempo = note.param;
                break;

            case 148: 
                if(note.param > 32)
                    tempo = note.param;
                break;

            case 118: // 'v'
            case 251: 
                if(note.param == 0)
                    channel.plRow = row;
                if(channel.plRow >= row)
                    break;
                if(plCount < 0)
                {
                    plCount = note.param;
                    plChannel = chanIdx;
                }
                if(plChannel != chanIdx)
                    break;
                if(plCount == 0)
                {
                    channel.plRow = row + 1;
                } else
                {
                    nextRow = channel.plRow;
                    breakSeqPos = -1;
                }
                plCount--;
                break;

            case 126: // '~'
            case 254: 
                tick = speed + speed * note.param;
                break;
            }
        }

        return songEnd;
    }

    public static final String VERSION = "a69 (c)2014 mumart@gmail.com";
    private Module module;
    private int rampBuf[];
    private Channel channels[];
    private int sampleRate;
    private int interpolation;
    private int seqPos;
    private int breakSeqPos;
    private int row;
    private int nextRow;
    private int tick;
    private int speed;
    private int tempo;
    private int plCount;
    private int plChannel;
    private GlobalVol globalVol;
    private Note note;
    private IBXModSlayer slayer;
    private boolean mustNotify;
}
