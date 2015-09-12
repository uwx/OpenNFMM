// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Sample.java

package ibxm;


public class Sample
{

    public Sample()
    {
        name = "";
        volume = 0;
        panning = -1;
        relNote = 0;
        fineTune = 0;
        c2Rate = 8363;
        loopStart = 0;
        loopLength = 0;
    }

    private static short[][] calculateSincTables()
    {
        short sincTables[][] = new short[8][];
        for(int tableIdx = 0; tableIdx < 8; tableIdx++)
            sincTables[tableIdx] = calculateSincTable(1.0D / (double)(tableIdx + 1));

        return sincTables;
    }

    private static short[] calculateSincTable(double lowpass)
    {
        short sincTable[] = new short[272];
        double windDT = -0.39269908169872414D;
        double sincDT = -3.1415926535897931D;
        int tableIdx = 0;
        for(int tableY = 0; tableY <= 16; tableY++)
        {
            double fracT = (double)tableY / 16D;
            double sincT = 3.1415926535897931D * (7D + fracT);
            double windT = 3.1415926535897931D + (sincT * 2D) / 16D;
            for(int tableX = 0; tableX < 16; tableX++)
            {
                double sincY = lowpass;
                if(sincT != 0.0D)
                    sincY = Math.sin(lowpass * sincT) / sincT;
                double windY = 0.35875000000000001D;
                windY -= 0.48829D * Math.cos(windT);
                windY += 0.14127999999999999D * Math.cos(windT * 2D);
                windY -= 0.011679999999999999D * Math.cos(windT * 3D);
                sincTable[tableIdx++] = (short)(int)Math.round(sincY * windY * 32767D);
                sincT += sincDT;
                windT += windDT;
            }

        }

        return sincTable;
    }

    public void setSampleData(short sampleData[], int loopStart, int loopLength, boolean pingPong)
    {
        int sampleLength = sampleData.length;
        if(loopStart < 0 || loopStart > sampleLength)
            loopStart = sampleLength;
        if(loopLength < 0 || loopStart + loopLength > sampleLength)
            loopLength = sampleLength - loopStart;
        sampleLength = loopStart + loopLength;
        loopStart += 8;
        int newSampleLength = 8 + sampleLength + (pingPong ? loopLength : 0) + 16;
        short newSampleData[] = new short[newSampleLength];
        System.arraycopy(sampleData, 0, newSampleData, 8, sampleLength);
        sampleData = newSampleData;
        if(pingPong)
        {
            int loopEnd = loopStart + loopLength;
            for(int idx = 0; idx < loopLength; idx++)
                sampleData[loopEnd + idx] = sampleData[loopEnd - idx - 1];

            loopLength *= 2;
        }
        int idx = loopStart + loopLength;
        for(int end = idx + 16; idx < end; idx++)
            sampleData[idx] = sampleData[idx - loopLength];

        sampleData = sampleData;
        loopStart = loopStart;
        loopLength = loopLength;
    }

    public void resampleNearest(int sampleIdx, int sampleFrac, int step, int leftGain, int rightGain, int mixBuffer[], int offset, 
            int length)
    {
        int loopLen = loopLength;
        int loopEnd = loopStart + loopLen;
        if((sampleIdx += 8) >= loopEnd)
            sampleIdx = normaliseSampleIdx(sampleIdx);
        short data[] = sampleData;
        int outIdx = offset << 1;
        for(int outEnd = offset + length << 1; outIdx < outEnd;)
        {
            if(sampleIdx >= loopEnd)
            {
                if(loopLen < 2)
                    break;
                for(; sampleIdx >= loopEnd; sampleIdx -= loopLen);
            }
            int y = data[sampleIdx];
            mixBuffer[outIdx++] += y * leftGain >> 15;
            mixBuffer[outIdx++] += y * rightGain >> 15;
            sampleFrac += step;
            sampleIdx += sampleFrac >> 15;
            sampleFrac &= 0x7fff;
        }

    }

    public void resampleLinear(int sampleIdx, int sampleFrac, int step, int leftGain, int rightGain, int mixBuffer[], int offset, 
            int length)
    {
        int loopLen = loopLength;
        int loopEnd = loopStart + loopLen;
        if((sampleIdx += 8) >= loopEnd)
            sampleIdx = normaliseSampleIdx(sampleIdx);
        short data[] = sampleData;
        int outIdx = offset << 1;
        for(int outEnd = offset + length << 1; outIdx < outEnd;)
        {
            if(sampleIdx >= loopEnd)
            {
                if(loopLen < 2)
                    break;
                for(; sampleIdx >= loopEnd; sampleIdx -= loopLen);
            }
            int c = data[sampleIdx];
            int m = data[sampleIdx + 1] - c;
            int y = (m * sampleFrac >> 15) + c;
            mixBuffer[outIdx++] += y * leftGain >> 15;
            mixBuffer[outIdx++] += y * rightGain >> 15;
            sampleFrac += step;
            sampleIdx += sampleFrac >> 15;
            sampleFrac &= 0x7fff;
        }

    }

    public void resampleSinc(int sampleIdx, int sampleFrac, int step, int leftGain, int rightGain, int mixBuffer[], int offset, 
            int length)
    {
        int tableIdx = 0;
        if(step > 32768)
        {
            tableIdx = (step >> 15) - 1;
            if(tableIdx >= 8)
                tableIdx = 7;
        }
        short sincTable[] = SINC_TABLES[tableIdx];
        int loopLen = loopLength;
        int loopEnd = loopStart + loopLen;
        if(sampleIdx >= loopEnd)
            sampleIdx = normaliseSampleIdx(sampleIdx);
        short data[] = sampleData;
        int outIdx = offset << 1;
        for(int outEnd = offset + length << 1; outIdx < outEnd;)
        {
            if(sampleIdx >= loopEnd)
            {
                if(loopLen < 2)
                    break;
                for(; sampleIdx >= loopEnd; sampleIdx -= loopLen);
            }
            int tableIdx1 = (sampleFrac >> 11) << 4;
            int tableIdx2 = tableIdx1 + 16;
            int a1 = 0;
            int a2 = 0;
            for(int tap = 0; tap < 16; tap++)
            {
                a1 += sincTable[tableIdx1 + tap] * data[sampleIdx + tap];
                a2 += sincTable[tableIdx2 + tap] * data[sampleIdx + tap];
            }

            a1 >>= 15;
            a2 >>= 15;
            int y = a1 + ((a2 - a1) * (sampleFrac & 0x7ff) >> 11);
            mixBuffer[outIdx++] += y * leftGain >> 15;
            mixBuffer[outIdx++] += y * rightGain >> 15;
            sampleFrac += step;
            sampleIdx += sampleFrac >> 15;
            sampleFrac &= 0x7fff;
        }

    }

    public int normaliseSampleIdx(int sampleIdx)
    {
        int loopOffset = sampleIdx - loopStart;
        if(loopOffset > 0)
        {
            sampleIdx = loopStart;
            if(loopLength > 1)
                sampleIdx += loopOffset % loopLength;
        }
        return sampleIdx;
    }

    public boolean looped()
    {
        return loopLength > 1;
    }

    public void toStringBuffer(StringBuffer out)
    {
        out.append((new StringBuilder()).append("Name: ").append(name).append('\n').toString());
        out.append((new StringBuilder()).append("Volume: ").append(volume).append('\n').toString());
        out.append((new StringBuilder()).append("Panning: ").append(panning).append('\n').toString());
        out.append((new StringBuilder()).append("Relative Note: ").append(relNote).append('\n').toString());
        out.append((new StringBuilder()).append("Fine Tune: ").append(fineTune).append('\n').toString());
        out.append((new StringBuilder()).append("Loop Start: ").append(loopStart).append('\n').toString());
        out.append((new StringBuilder()).append("Loop Length: ").append(loopLength).append('\n').toString());
    }

    public static final int FP_SHIFT = 15;
    public static final int FP_ONE = 32768;
    public static final int FP_MASK = 32767;
    public static final int C2_PAL = 8287;
    public static final int C2_NTSC = 8363;
    public String name;
    public int volume;
    public int panning;
    public int relNote;
    public int fineTune;
    public int c2Rate;
    private int loopStart;
    private int loopLength;
    private short sampleData[];
    private static final short SINC_TABLES[][] = calculateSincTables();

}
