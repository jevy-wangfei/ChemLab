// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ListMaxMin.java

package org.jevy.util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ListMaxMin
{

    public ListMaxMin()
    {
    }

    public double getMax(List data)
    {
        double res = ((Double)data.get(0)).doubleValue();
        for(int i = 0; i < data.size() - 1; i++)
            if(res < ((Double)data.get(i + 1)).doubleValue())
                res = ((Double)data.get(i + 1)).doubleValue();

        return res;
    }

    public double getMin(List data)
    {
        double res = ((Double)data.get(0)).doubleValue();
        for(int i = 0; i < data.size() - 1; i++)
            if(res > ((Double)data.get(i + 1)).doubleValue())
                res = ((Double)data.get(i + 1)).doubleValue();

        return res;
    }

    public static void main(String args[])
    {
        ListMaxMin li = new ListMaxMin();
        List list = new ArrayList();
        list.add(Double.valueOf(1.1000000000000001D));
        list.add(Double.valueOf(2.2000000000000002D));
        list.add(Double.valueOf(3.2999999999999998D));
        list.add(Double.valueOf(2.7000000000000002D));
        System.out.println(li.getMax(list));
        System.out.println(li.getMin(list));
    }
}
