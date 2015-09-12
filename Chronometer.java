// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Chronometer.java

import java.awt.*;
import java.io.PrintStream;
import java.text.DecimalFormat;

public class Chronometer
{

    public Chronometer(xtGraphics pxt)
    {
        System.out.println("Chronometer ready");
        xt = pxt;
        rd = xt.rd;
        start = 0L;
        end = 0L;
        laps = 0;
        current = 0;
        bestlap = 1;
        delay = 0L;
        pausetime = 0L;
        laptimes = null;
        laptimes = null;
        running = false;
        ready = false;
        paused = false;
        dc = new DecimalFormat("00");
    }

    public void start()
    {
        if(ready)
        {
            start = System.currentTimeMillis();
            delay = 0L;
            pausetime = 0L;
            current = 1;
            running = true;
            paused = false;
        }
    }

    public void pause()
    {
        if(running && !paused)
        {
            pausetime = System.currentTimeMillis();
            lapsplits[current - 1] = pausetime - start - delay;
            laptimes[current - 1] = pausetime - start - delay - (current <= 1 ? 0L : lapsplits[current - 2]);
            paused = true;
        }
    }

    public void resume()
    {
        if(running && paused)
        {
            delay += System.currentTimeMillis() - pausetime;
            paused = false;
        }
    }

    public void stop()
    {
        if(current <= laps)
            performLap();
        current--;
        end = System.currentTimeMillis();
        delay = 0L;
        pausetime = 0L;
        running = false;
        paused = false;
    }

    public void setLaps(int i)
    {
        if(!running)
        {
            laps = i;
            laptimes = new long[i];
            lapsplits = new long[i];
            current = 0;
            ready = true;
        }
    }

    public void performLap()
    {
        if(running && current <= laps)
        {
            long l = System.currentTimeMillis();
            lapsplits[current - 1] = l - start - delay;
            laptimes[current - 1] = l - start - delay - (current <= 1 ? 0L : lapsplits[current - 2]);
            if(laptimes[current - 1] < laptimes[bestlap - 1])
                bestlap = current;
            current++;
        }
    }

    public void reset()
    {
        if(!running)
        {
            start = 0L;
            end = 0L;
            laps = 0;
            current = 0;
            bestlap = 1;
            laptimes = null;
            delay = 0L;
            pausetime = 0L;
            running = false;
            paused = false;
            ready = false;
        }
    }

    public long totalTimeMillis()
    {
        return lapsplits[laps - 1];
    }

    public long bestLapTimeMillis()
    {
        return laptimes[bestlap - 1];
    }

    public String getTotalTime()
    {
        return getTime(lapsplits[laps - 1]);
    }

    public String getBestLapTime()
    {
        return getTime(laptimes[bestlap - 1]);
    }

    public void paint(int x, int y, int style)
    {
        int r = 50;
        int g = 204;
        int b = 255;
        Font tmp = rd.getFont();
        FontMetrics tmpm = ftm;
        if(style == 1)
            colorSnap(r, g, b, 100);
        else
        if(style == 2 || style == 4)
            colorSnap(50, 50, 50, 220);
        else
            colorSnap(0, 0, 0, 100);
        int cur = current > laps ? laps : current;
        if(cur > 10)
            cur = 10;
        int h = 20 * (cur + 1);
        int sti = current > 10 ? current - 10 : 0;
        rd.fillRoundRect(x, y, 177, h, 7, 7);
        if(style == 1)
            colorSnap(0, 0, 0);
        else
        if(xt.m.lightson || xt.m.darksky)
            colorSet(r, g, b, 220);
        else
            colorSnap(r, g, b);
        if(style != 3)
            rd.drawRoundRect(x, y, 177, h, 7, 7);
        useFont(new Font("Arial", 1, 11));
        rd.drawString("# Lap", (x + 22) - ftm.stringWidth("# Lap") / 2, y + 15);
        rd.drawString("Lap Time", (x + 44 + 33) - ftm.stringWidth("Lap Time") / 2, y + 15);
        rd.drawString("Split Time", (x + 44 + 67 + 34) - ftm.stringWidth("Split Time") / 2, y + 15);
        rd.drawLine(x + 43, y, x + 43, (y + h) - 1);
        rd.drawLine(x + 44 + 67, y, x + 44 + 67, (y + h) - 1);
        if(style >= 3)
        {
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
        }
        for(int i = sti; i < current && i < laps; i++)
        {
            int pos = (i - sti) + 1;
            if(style > 1)
                if(xt.m.lightson || xt.m.darksky)
                    colorSet(r, g, b, 220);
                else
                    colorSnap(r, g, b);
            rd.drawLine(x, y + 20 * pos, x + 177, y + 20 * pos);
            if(style > 1)
                if(xt.m.lightson || xt.m.darksky)
                    colorSet(250, 250, 250, 220);
                else
                    colorSnap(250, 250, 250);
            rd.drawString((new StringBuilder()).append("").append(i + 1).toString(), (x + 22) - ftm.stringWidth((new StringBuilder()).append("").append(i + 1).toString()) / 2, y + 20 * pos + 15);
            String currentTime;
            String lapTime;
            if(i == current - 1 && running && !paused)
            {
                currentTime = getTime(System.currentTimeMillis() - start - delay);
                lapTime = getTime(System.currentTimeMillis() - start - delay - (i <= 0 ? 0L : lapsplits[i - 1]));
            } else
            {
                currentTime = getTime(lapsplits[i]);
                lapTime = getTime(laptimes[i]);
            }
            rd.drawString(lapTime, (x + 44 + 33) - ftm.stringWidth(currentTime) / 2, y + 20 * pos + 15);
            rd.drawString(currentTime, (x + 44 + 67 + 34) - ftm.stringWidth(currentTime) / 2, y + 20 * pos + 15);
        }

        rd.setFont(tmp);
        ftm = tmpm;
    }

    private Color colorSet(int r, int g, int b)
    {
        return colorSet(r, g, b, 255);
    }

    private Color colorSet(int r, int g, int b, int a)
    {
        Color c = new Color(r, g, b, a);
        rd.setColor(c);
        return c;
    }

    private Color colorSnap(int r, int g, int b)
    {
        return colorSnap(r, g, b, 255);
    }

    private Color colorSnap(int r, int g, int b, int a)
    {
        int nr = r;
        int ng = g;
        int nb = b;
        nr = (int)((float)nr + (float)nr * ((float)xt.m.snap[0] / 100F));
        if(nr > 255)
            nr = 255;
        if(nr < 0)
            nr = 0;
        ng = (int)((float)ng + (float)ng * ((float)xt.m.snap[1] / 100F));
        if(ng > 255)
            ng = 255;
        if(ng < 0)
            ng = 0;
        nb = (int)((float)nb + (float)nb * ((float)xt.m.snap[2] / 100F));
        if(nb > 255)
            nb = 255;
        if(nb < 0)
            nb = 0;
        if(a > 255)
            a = 255;
        if(a < 0)
            a = 0;
        Color c = new Color(nr, ng, nb, a);
        rd.setColor(c);
        return c;
    }

    private void useFont(Font f)
    {
        rd.setFont(f);
        ftm = rd.getFontMetrics();
    }

    public String getTime(long time)
    {
        long cent = (time % 1000L) / 10L;
        int secs = (int)((time / 1000L) % 60L);
        int mins = (int)(time / 1000L / 60L);
        return (new StringBuilder()).append(dc.format(mins)).append(":").append(dc.format(secs)).append(".").append(dc.format(cent)).toString();
    }

    long start;
    long end;
    long delay;
    long pausetime;
    int bestlap;
    long laptimes[];
    long lapsplits[];
    int laps;
    int current;
    boolean ready;
    boolean paused;
    boolean running;
    Graphics2D rd;
    xtGraphics xt;
    FontMetrics ftm;
    DecimalFormat dc;
}
