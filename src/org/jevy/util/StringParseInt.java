// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringParseInt.java

package org.jevy.util;

import java.io.PrintStream;

public class StringParseInt
{

    public StringParseInt()
    {
    }

    public int parse(String str)
    {
        int i = 0;
        try
        {
            i = Integer.parseInt(str);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("org.jevy.util.StringParseInt.parse:")).append(e).toString());
        }
        return i;
    }
}
