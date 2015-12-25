// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SuperClip.java

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import javax.sound.sampled.*;

public class SuperClip
    implements Runnable
{

    public SuperClip(byte abyte0[], int i, int j)
    {
        skiprate = 0;
        stoped = 1;
        source = null;
        rollBackPos = 0;
        rollBackTrig = 0;
        changeGain = false;
        stoped = 2;
        skiprate = j;
        stream = new ByteArrayInputStream(abyte0, 0, i);
    }

    public void run()
    {
        try
        {
            AudioFormat audioformat = new AudioFormat(javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED, skiprate, 16, 1, 2, skiprate, false);
            javax.sound.sampled.DataLine.Info info = new javax.sound.sampled.DataLine.Info(SourceDataLine.class, audioformat);
            source = (SourceDataLine)AudioSystem.getLine(info);
            source.open(audioformat);
            source.start();
        }
        catch(Exception exception)
        {
            stoped = 1;
        }
        boolean flag = false;
        while(stoped == 0) 
        {
            try
            {
                int i = skiprate;
                int j = stream.available();
                if(j % 2 != 0)
                    j++;
                byte abyte0[] = new byte[j <= i ? j : i];
                int l = stream.read(abyte0, 0, abyte0.length);
                if(l == -1 || rollBackPos != 0 && j < rollBackTrig)
                    flag = true;
                if(flag)
                {
                    if(l != -1)
                        source.write(abyte0, 0, abyte0.length);
                    stream.reset();
                    if(rollBackPos != 0)
                        stream.skip(rollBackPos);
                    int k = stream.available();
                    if(k % 2 != 0)
                        k++;
                    abyte0 = new byte[k <= i ? k : i];
                    stream.read(abyte0, 0, abyte0.length);
                    flag = false;
                }
                source.write(abyte0, 0, abyte0.length);
            }
            catch(Exception exception1)
            {
                System.out.println((new StringBuilder()).append("Play error: ").append(exception1).toString());
                stoped = 1;
            }
            try
            {
                Thread _tmp = cliper;
                Thread.sleep(200L);
            }
            catch(InterruptedException interruptedexception) { }
        }
        source.stop();
        source.close();
        source = null;
        stoped = 2;
    }

    public void play()
    {
        if(stoped == 2)
        {
            stoped = 0;
            try
            {
                stream.reset();
            }
            catch(Exception exception) { }
            cliper = new Thread(this);
            cliper.start();
        }
    }

    public void resume()
    {
        if(stoped == 2)
        {
            stoped = 0;
            cliper = new Thread(this);
            cliper.start();
        }
    }

    public void stop()
    {
        if(stoped == 0)
        {
            stoped = 1;
            if(source != null)
                source.stop();
        }
    }

    public void close()
    {
        try
        {
            stream.close();
            stream = null;
        }
        catch(Exception exception) { }
    }

    int skiprate;
    Thread cliper;
    int stoped;
    SourceDataLine source;
    ByteArrayInputStream stream;
    int rollBackPos;
    int rollBackTrig;
    boolean changeGain;
}
