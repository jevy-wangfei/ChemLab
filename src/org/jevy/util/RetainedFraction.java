// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RetainedFraction.java

package org.jevy.util;

import java.io.PrintStream;

public class RetainedFraction
{

    public RetainedFraction()
    {
    }

    public double retained4(double dou)
    {
        int temp = (int)(dou * 10000D);
        int tempp = (int)(dou * 100000D);
        int yu = tempp % 10000;
        if(yu >= 5)
            temp++;
        return (double)temp / 10000D;
    }

    public static void main(String args[])
    {
        double dou = 54.546564644999997D;
        System.out.println((new RetainedFraction()).retained4(dou));
    }
}
