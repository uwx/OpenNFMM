// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Madness.java

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Madness$1 extends WindowAdapter
{

    public void windowClosing(WindowEvent windowevent)
    {
        Madness.exitsequance();
    }

    Madness$1()
    {
    }
}
