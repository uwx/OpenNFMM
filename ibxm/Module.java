// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Module.java

package ibxm;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package ibxm:
//            Pattern, Instrument, Data, Sample, 
//            Envelope, Channel

public class Module
{

    public Module()
    {
        songName = "Blank";
        numChannels = 4;
        numInstruments = 1;
        numPatterns = 1;
        sequenceLength = 1;
        restartPos = 0;
        defaultGVol = 64;
        defaultSpeed = 6;
        defaultTempo = 125;
        c2Rate = 8287;
        gain = 64;
        linearPeriods = false;
        fastVolSlides = false;
    }

    public Module(InputStream inputStream)
        throws IOException
    {
        this(new Data(inputStream));
    }

    public Module(Data moduleData)
        throws IOException
    {
        songName = "Blank";
        numChannels = 4;
        numInstruments = 1;
        numPatterns = 1;
        sequenceLength = 1;
        restartPos = 0;
        defaultGVol = 64;
        defaultSpeed = 6;
        defaultTempo = 125;
        c2Rate = 8287;
        gain = 64;
        linearPeriods = false;
        fastVolSlides = false;
        if(moduleData.strLatin1(0, 17).equals("Extended Module: "))
            loadXM(moduleData);
        else
        if(moduleData.strLatin1(44, 4).equals("SCRM"))
            loadS3M(moduleData);
        else
            loadMod(moduleData);
    }

    public Module(byte moduleData[])
        throws IOException
    {
        this(new Data(moduleData));
    }

    private void loadMod(Data moduleData)
        throws IOException
    {
        songName = moduleData.strLatin1(0, 20);
        sequenceLength = moduleData.uByte(950) & 0x7f;
        restartPos = moduleData.uByte(951) & 0x7f;
        if(restartPos >= sequenceLength)
            restartPos = 0;
        sequence = new int[128];
        for(int seqIdx = 0; seqIdx < 128; seqIdx++)
        {
            int patIdx = moduleData.uByte(952 + seqIdx) & 0x7f;
            sequence[seqIdx] = patIdx;
            if(patIdx >= numPatterns)
                numPatterns = patIdx + 1;
        }

        switch(moduleData.ubeShort(1082))
        {
        case 19233: 
        case 19246: 
        case 21556: 
            numChannels = 4;
            c2Rate = 8287;
            gain = 64;
            break;

        case 18510: 
            numChannels = moduleData.uByte(1080) - 48;
            c2Rate = 8363;
            gain = 32;
            break;

        case 17224: 
            numChannels = (moduleData.uByte(1080) - 48) * 10;
            numChannels += moduleData.uByte(1081) - 48;
            c2Rate = 8363;
            gain = 32;
            break;

        default:
            throw new IllegalArgumentException("MOD Format not recognised!");
        }
        defaultGVol = 64;
        defaultSpeed = 6;
        defaultTempo = 125;
        defaultPanning = new int[numChannels];
        for(int idx = 0; idx < numChannels; idx++)
        {
            defaultPanning[idx] = 51;
            if((idx & 3) == 1 || (idx & 3) == 2)
                defaultPanning[idx] = 204;
        }

        int moduleDataIdx = 1084;
        patterns = new Pattern[numPatterns];
        for(int patIdx = 0; patIdx < numPatterns; patIdx++)
        {
            Pattern pattern = patterns[patIdx] = new Pattern(numChannels, 64);
            for(int patDataIdx = 0; patDataIdx < pattern.data.length; patDataIdx += 5)
            {
                int period = (moduleData.uByte(moduleDataIdx) & 0xf) << 8;
                period = (period | moduleData.uByte(moduleDataIdx + 1)) * 4;
                if(period > 112)
                    pattern.data[patDataIdx] = (byte)Channel.periodToKey(period);
                int ins = (moduleData.uByte(moduleDataIdx + 2) & 0xf0) >> 4;
                ins |= moduleData.uByte(moduleDataIdx) & 0x10;
                pattern.data[patDataIdx + 1] = (byte)ins;
                int effect = moduleData.uByte(moduleDataIdx + 2) & 0xf;
                int param = moduleData.uByte(moduleDataIdx + 3);
                if(param == 0 && (effect < 3 || effect == 10))
                    effect = 0;
                if(param == 0 && (effect == 5 || effect == 6))
                    effect -= 2;
                if(effect == 8 && numChannels == 4)
                    effect = param = 0;
                pattern.data[patDataIdx + 3] = (byte)effect;
                pattern.data[patDataIdx + 4] = (byte)param;
                moduleDataIdx += 4;
            }

        }

        numInstruments = 31;
        instruments = new Instrument[numInstruments + 1];
        instruments[0] = new Instrument();
        for(int instIdx = 1; instIdx <= numInstruments; instIdx++)
        {
            Instrument instrument = instruments[instIdx] = new Instrument();
            Sample sample = instrument.samples[0];
            instrument.name = moduleData.strLatin1(instIdx * 30 - 10, 22);
            int sampleLength = moduleData.ubeShort(instIdx * 30 + 12) * 2;
            int fineTune = (moduleData.uByte(instIdx * 30 + 14) & 0xf) << 4;
            sample.fineTune = fineTune >= 128 ? fineTune - 256 : fineTune;
            int volume = moduleData.uByte(instIdx * 30 + 15) & 0x7f;
            sample.volume = volume > 64 ? 64 : volume;
            sample.panning = -1;
            sample.c2Rate = c2Rate;
            int loopStart = moduleData.ubeShort(instIdx * 30 + 16) * 2;
            int loopLength = moduleData.ubeShort(instIdx * 30 + 18) * 2;
            if(loopStart + loopLength > sampleLength)
                loopLength = sampleLength - loopStart;
            if(loopLength < 4)
            {
                loopStart = sampleLength;
                loopLength = 0;
            }
            sample.setSampleData(moduleData.samS8(moduleDataIdx, sampleLength), loopStart, loopLength, false);
            moduleDataIdx += sampleLength;
        }

    }

    private void loadS3M(Data moduleData)
        throws IOException
    {
        songName = moduleData.strCp850(0, 28);
        sequenceLength = moduleData.uleShort(32);
        numInstruments = moduleData.uleShort(34);
        numPatterns = moduleData.uleShort(36);
        int flags = moduleData.uleShort(38);
        int version = moduleData.uleShort(40);
        fastVolSlides = (flags & 0x40) == 64 || version == 4864;
        boolean signedSamples = moduleData.uleShort(42) == 1;
        if(moduleData.uleInt(44) != 0x4d524353)
            throw new IllegalArgumentException("Not an S3M file!");
        defaultGVol = moduleData.uByte(48);
        defaultSpeed = moduleData.uByte(49);
        defaultTempo = moduleData.uByte(50);
        c2Rate = 8363;
        gain = moduleData.uByte(51) & 0x7f;
        boolean stereoMode = (moduleData.uByte(51) & 0x80) == 128;
        boolean defaultPan = moduleData.uByte(53) == 252;
        int channelMap[] = new int[32];
        for(int chanIdx = 0; chanIdx < 32; chanIdx++)
        {
            channelMap[chanIdx] = -1;
            if(moduleData.uByte(64 + chanIdx) < 16)
                channelMap[chanIdx] = numChannels++;
        }

        sequence = new int[sequenceLength];
        for(int seqIdx = 0; seqIdx < sequenceLength; seqIdx++)
            sequence[seqIdx] = moduleData.uByte(96 + seqIdx);

        int moduleDataIdx = 96 + sequenceLength;
        instruments = new Instrument[numInstruments + 1];
        instruments[0] = new Instrument();
        for(int instIdx = 1; instIdx <= numInstruments; instIdx++)
        {
            Instrument instrument = instruments[instIdx] = new Instrument();
            Sample sample = instrument.samples[0];
            int instOffset = moduleData.uleShort(moduleDataIdx) << 4;
            moduleDataIdx += 2;
            instrument.name = moduleData.strCp850(instOffset + 48, 28);
            if(moduleData.uByte(instOffset) != 1 || moduleData.uleShort(instOffset + 76) != 17235)
                continue;
            int sampleOffset = moduleData.uByte(instOffset + 13) << 20;
            sampleOffset += moduleData.uleShort(instOffset + 14) << 4;
            int sampleLength = moduleData.uleInt(instOffset + 16);
            int loopStart = moduleData.uleInt(instOffset + 20);
            int loopLength = moduleData.uleInt(instOffset + 24) - loopStart;
            sample.volume = moduleData.uByte(instOffset + 28);
            sample.panning = -1;
            boolean packed = moduleData.uByte(instOffset + 30) != 0;
            boolean loopOn = (moduleData.uByte(instOffset + 31) & 1) == 1;
            if(loopStart + loopLength > sampleLength)
                loopLength = sampleLength - loopStart;
            if(loopLength < 1 || !loopOn)
            {
                loopStart = sampleLength;
                loopLength = 0;
            }
            boolean stereo = (moduleData.uByte(instOffset + 31) & 2) == 2;
            boolean sixteenBit = (moduleData.uByte(instOffset + 31) & 4) == 4;
            if(packed)
                throw new IllegalArgumentException("Packed samples not supported!");
            sample.c2Rate = moduleData.uleInt(instOffset + 32);
            if(sixteenBit)
            {
                if(signedSamples)
                    sample.setSampleData(moduleData.samS16(sampleOffset, sampleLength), loopStart, loopLength, false);
                else
                    sample.setSampleData(moduleData.samU16(sampleOffset, sampleLength), loopStart, loopLength, false);
                continue;
            }
            if(signedSamples)
                sample.setSampleData(moduleData.samS8(sampleOffset, sampleLength), loopStart, loopLength, false);
            else
                sample.setSampleData(moduleData.samU8(sampleOffset, sampleLength), loopStart, loopLength, false);
        }

        patterns = new Pattern[numPatterns];
        for(int patIdx = 0; patIdx < numPatterns; patIdx++)
        {
            Pattern pattern = patterns[patIdx] = new Pattern(numChannels, 64);
            int inOffset = (moduleData.uleShort(moduleDataIdx) << 4) + 2;
            int rowIdx = 0;
            do
            {
                if(rowIdx >= 64)
                    break;
                int token = moduleData.uByte(inOffset++);
                if(token == 0)
                {
                    rowIdx++;
                } else
                {
                    int noteKey = 0;
                    int noteIns = 0;
                    if((token & 0x20) == 32)
                    {
                        noteKey = moduleData.uByte(inOffset++);
                        noteIns = moduleData.uByte(inOffset++);
                        if(noteKey < 254)
                            noteKey = (noteKey >> 4) * 12 + (noteKey & 0xf) + 1;
                        if(noteKey == 255)
                            noteKey = 0;
                    }
                    int noteVol = 0;
                    if((token & 0x40) == 64)
                    {
                        noteVol = (moduleData.uByte(inOffset++) & 0x7f) + 16;
                        if(noteVol > 80)
                            noteVol = 0;
                    }
                    int noteEffect = 0;
                    int noteParam = 0;
                    if((token & 0x80) == 128)
                    {
                        noteEffect = moduleData.uByte(inOffset++);
                        noteParam = moduleData.uByte(inOffset++);
                        if(noteEffect < 1 || noteEffect >= 64)
                            noteEffect = noteParam = 0;
                        if(noteEffect > 0)
                            noteEffect += 128;
                    }
                    int chanIdx = channelMap[token & 0x1f];
                    if(chanIdx >= 0)
                    {
                        int noteOffset = (rowIdx * numChannels + chanIdx) * 5;
                        pattern.data[noteOffset] = (byte)noteKey;
                        pattern.data[noteOffset + 1] = (byte)noteIns;
                        pattern.data[noteOffset + 2] = (byte)noteVol;
                        pattern.data[noteOffset + 3] = (byte)noteEffect;
                        pattern.data[noteOffset + 4] = (byte)noteParam;
                    }
                }
            } while(true);
            moduleDataIdx += 2;
        }

        defaultPanning = new int[numChannels];
        for(int chanIdx = 0; chanIdx < 32; chanIdx++)
        {
            if(channelMap[chanIdx] < 0)
                continue;
            int panning = 7;
            if(stereoMode)
            {
                panning = 12;
                if(moduleData.uByte(64 + chanIdx) < 8)
                    panning = 3;
            }
            if(defaultPan)
            {
                int panFlags = moduleData.uByte(moduleDataIdx + chanIdx);
                if((panFlags & 0x20) == 32)
                    panning = panFlags & 0xf;
            }
            defaultPanning[channelMap[chanIdx]] = panning * 17;
        }

    }

    private void loadXM(Data moduleData)
        throws IOException
    {
        if(moduleData.uleShort(58) != 260)
            throw new IllegalArgumentException("XM format version must be 0x0104!");
        songName = moduleData.strCp850(17, 20);
        boolean deltaEnv = moduleData.strLatin1(38, 20).startsWith("DigiBooster Pro");
        int dataOffset = 60 + moduleData.uleInt(60);
        sequenceLength = moduleData.uleShort(64);
        restartPos = moduleData.uleShort(66);
        numChannels = moduleData.uleShort(68);
        numPatterns = moduleData.uleShort(70);
        numInstruments = moduleData.uleShort(72);
        linearPeriods = (moduleData.uleShort(74) & 1) > 0;
        defaultGVol = 64;
        defaultSpeed = moduleData.uleShort(76);
        defaultTempo = moduleData.uleShort(78);
        c2Rate = 8363;
        gain = 64;
        defaultPanning = new int[numChannels];
        for(int idx = 0; idx < numChannels; idx++)
            defaultPanning[idx] = 128;

        sequence = new int[sequenceLength];
        for(int seqIdx = 0; seqIdx < sequenceLength; seqIdx++)
        {
            int entry = moduleData.uByte(80 + seqIdx);
            sequence[seqIdx] = entry >= numPatterns ? 0 : entry;
        }

        patterns = new Pattern[numPatterns];
        for(int patIdx = 0; patIdx < numPatterns; patIdx++)
        {
            if(moduleData.uByte(dataOffset + 4) != 0)
                throw new IllegalArgumentException("Unknown pattern packing type!");
            int numRows = moduleData.uleShort(dataOffset + 5);
            int numNotes = numRows * numChannels;
            Pattern pattern = patterns[patIdx] = new Pattern(numChannels, numRows);
            int patternDataLength = moduleData.uleShort(dataOffset + 7);
            dataOffset += moduleData.uleInt(dataOffset);
            int nextOffset = dataOffset + patternDataLength;
            if(patternDataLength > 0)
            {
                int patternDataOffset = 0;
                for(int note = 0; note < numNotes; note++)
                {
                    int flags = moduleData.uByte(dataOffset);
                    if((flags & 0x80) == 0)
                        flags = 31;
                    else
                        dataOffset++;
                    byte key = (flags & 1) <= 0 ? 0 : moduleData.sByte(dataOffset++);
                    pattern.data[patternDataOffset++] = key;
                    byte ins = (flags & 2) <= 0 ? 0 : moduleData.sByte(dataOffset++);
                    pattern.data[patternDataOffset++] = ins;
                    byte vol = (flags & 4) <= 0 ? 0 : moduleData.sByte(dataOffset++);
                    pattern.data[patternDataOffset++] = vol;
                    byte fxc = (flags & 8) <= 0 ? 0 : moduleData.sByte(dataOffset++);
                    byte fxp = (flags & 0x10) <= 0 ? 0 : moduleData.sByte(dataOffset++);
                    if(fxc >= 64)
                        fxc = fxp = 0;
                    pattern.data[patternDataOffset++] = fxc;
                    pattern.data[patternDataOffset++] = fxp;
                }

            }
            dataOffset = nextOffset;
        }

        instruments = new Instrument[numInstruments + 1];
        instruments[0] = new Instrument();
        for(int insIdx = 1; insIdx <= numInstruments; insIdx++)
        {
            Instrument instrument = instruments[insIdx] = new Instrument();
            instrument.name = moduleData.strCp850(dataOffset + 4, 22);
            int numSamples = instrument.numSamples = moduleData.uleShort(dataOffset + 27);
            if(numSamples > 0)
            {
                instrument.samples = new Sample[numSamples];
                for(int keyIdx = 0; keyIdx < 96; keyIdx++)
                    instrument.keyToSample[keyIdx + 1] = moduleData.uByte(dataOffset + 33 + keyIdx);

                Envelope volEnv = instrument.volumeEnvelope = new Envelope();
                volEnv.pointsTick = new int[12];
                volEnv.pointsAmpl = new int[12];
                int pointTick = 0;
                for(int point = 0; point < 12; point++)
                {
                    int pointOffset = dataOffset + 129 + point * 4;
                    pointTick = (deltaEnv ? pointTick : 0) + moduleData.uleShort(pointOffset);
                    volEnv.pointsTick[point] = pointTick;
                    volEnv.pointsAmpl[point] = moduleData.uleShort(pointOffset + 2);
                }

                Envelope panEnv = instrument.panningEnvelope = new Envelope();
                panEnv.pointsTick = new int[12];
                panEnv.pointsAmpl = new int[12];
                pointTick = 0;
                for(int point = 0; point < 12; point++)
                {
                    int pointOffset = dataOffset + 177 + point * 4;
                    pointTick = (deltaEnv ? pointTick : 0) + moduleData.uleShort(pointOffset);
                    panEnv.pointsTick[point] = pointTick;
                    panEnv.pointsAmpl[point] = moduleData.uleShort(pointOffset + 2);
                }

                volEnv.numPoints = moduleData.uByte(dataOffset + 225);
                if(volEnv.numPoints > 12)
                    volEnv.numPoints = 0;
                panEnv.numPoints = moduleData.uByte(dataOffset + 226);
                if(panEnv.numPoints > 12)
                    panEnv.numPoints = 0;
                volEnv.sustainTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 227)];
                volEnv.loopStartTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 228)];
                volEnv.loopEndTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 229)];
                panEnv.sustainTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 230)];
                panEnv.loopStartTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 231)];
                panEnv.loopEndTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 232)];
                volEnv.enabled = volEnv.numPoints > 0 && (moduleData.uByte(dataOffset + 233) & 1) > 0;
                volEnv.sustain = (moduleData.uByte(dataOffset + 233) & 2) > 0;
                volEnv.looped = (moduleData.uByte(dataOffset + 233) & 4) > 0;
                panEnv.enabled = panEnv.numPoints > 0 && (moduleData.uByte(dataOffset + 234) & 1) > 0;
                panEnv.sustain = (moduleData.uByte(dataOffset + 234) & 2) > 0;
                panEnv.looped = (moduleData.uByte(dataOffset + 234) & 4) > 0;
                instrument.vibratoType = moduleData.uByte(dataOffset + 235);
                instrument.vibratoSweep = moduleData.uByte(dataOffset + 236);
                instrument.vibratoDepth = moduleData.uByte(dataOffset + 237);
                instrument.vibratoRate = moduleData.uByte(dataOffset + 238);
                instrument.volumeFadeOut = moduleData.uleShort(dataOffset + 239);
            }
            dataOffset += moduleData.uleInt(dataOffset);
            int sampleHeaderOffset = dataOffset;
            dataOffset += numSamples * 40;
            for(int samIdx = 0; samIdx < numSamples; samIdx++)
            {
                Sample sample = instrument.samples[samIdx] = new Sample();
                int sampleDataBytes = moduleData.uleInt(sampleHeaderOffset);
                int sampleLoopStart = moduleData.uleInt(sampleHeaderOffset + 4);
                int sampleLoopLength = moduleData.uleInt(sampleHeaderOffset + 8);
                sample.volume = moduleData.sByte(sampleHeaderOffset + 12);
                sample.fineTune = moduleData.sByte(sampleHeaderOffset + 13);
                sample.c2Rate = 8363;
                boolean looped = (moduleData.uByte(sampleHeaderOffset + 14) & 3) > 0;
                boolean pingPong = (moduleData.uByte(sampleHeaderOffset + 14) & 2) > 0;
                boolean sixteenBit = (moduleData.uByte(sampleHeaderOffset + 14) & 0x10) > 0;
                sample.panning = moduleData.uByte(sampleHeaderOffset + 15);
                sample.relNote = moduleData.sByte(sampleHeaderOffset + 16);
                sample.name = moduleData.strCp850(sampleHeaderOffset + 18, 22);
                sampleHeaderOffset += 40;
                if(!looped || sampleLoopStart + sampleLoopLength > sampleDataBytes)
                {
                    sampleLoopStart = sampleDataBytes;
                    sampleLoopLength = 0;
                }
                if(sixteenBit)
                    sample.setSampleData(moduleData.samS16D(dataOffset, sampleDataBytes >> 1), sampleLoopStart >> 1, sampleLoopLength >> 1, pingPong);
                else
                    sample.setSampleData(moduleData.samS8D(dataOffset, sampleDataBytes), sampleLoopStart, sampleLoopLength, pingPong);
                dataOffset += sampleDataBytes;
            }

        }

    }

    public void toStringBuffer(StringBuffer out)
    {
        out.append((new StringBuilder()).append("Song Name: ").append(songName).append('\n').append("Num Channels: ").append(numChannels).append('\n').append("Num Instruments: ").append(numInstruments).append('\n').append("Num Patterns: ").append(numPatterns).append('\n').append("Sequence Length: ").append(sequenceLength).append('\n').append("Restart Pos: ").append(restartPos).append('\n').append("Default Speed: ").append(defaultSpeed).append('\n').append("Default Tempo: ").append(defaultTempo).append('\n').append("Linear Periods: ").append(linearPeriods).append('\n').toString());
        out.append("Sequence: ");
        for(int seqIdx = 0; seqIdx < sequence.length; seqIdx++)
            out.append((new StringBuilder()).append(sequence[seqIdx]).append(", ").toString());

        out.append('\n');
        for(int patIdx = 0; patIdx < patterns.length; patIdx++)
        {
            out.append((new StringBuilder()).append("Pattern ").append(patIdx).append(":\n").toString());
            patterns[patIdx].toStringBuffer(out);
        }

        for(int insIdx = 1; insIdx < instruments.length; insIdx++)
        {
            out.append((new StringBuilder()).append("Instrument ").append(insIdx).append(":\n").toString());
            instruments[insIdx].toStringBuffer(out);
        }

    }

    public String songName;
    public int numChannels;
    public int numInstruments;
    public int numPatterns;
    public int sequenceLength;
    public int restartPos;
    public int defaultGVol;
    public int defaultSpeed;
    public int defaultTempo;
    public int c2Rate;
    public int gain;
    public boolean linearPeriods;
    public boolean fastVolSlides;
    public int defaultPanning[] = {
        51, 204, 204, 51
    };
    public int sequence[] = {
        0
    };
    public Pattern patterns[] = {
        new Pattern(4, 64)
    };
    public Instrument instruments[] = {
        new Instrument(), new Instrument()
    };
}
