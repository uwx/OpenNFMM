
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name:   Madness.java

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Madness$1 extends WindowAdapter {

    Madness$1() {
    }

    @Override
    public void windowClosing(final WindowEvent windowevent) {
        Madness.exitsequance();
    }
}
