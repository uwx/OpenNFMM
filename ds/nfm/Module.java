// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Module.java

package ds.nfm;

import java.io.IOException;
import java.io.InputStream;

public abstract class Module
{

    public Module()
    {
        loaded = false;
    }

    public String getName()
    {
        return name;
    }

    public boolean isLoaded()
    {
        return loaded;
    }

    public abstract void loadMod(InputStream inputstream)
        throws IOException;

    protected String name;
    protected boolean loaded;
}
