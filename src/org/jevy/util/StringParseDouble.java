// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringParseDouble.java

package org.jevy.util;


public class StringParseDouble
{

    public StringParseDouble()
    {
    }

    public Double[] parse(String str[])
    {
        Double dou[];
        if(str == null)
        {
            dou = new Double[1];
            dou[0] = Double.valueOf(0.0D);
            return dou;
        }
        dou = new Double[str.length];
        for(int i = 0; i < str.length; i++)
            try
            {
                if(str[i] == null || "".equals(str[i]))
                    dou[i] = Double.valueOf(0.0D);
                else
                    dou[i] = Double.valueOf(Double.parseDouble(str[i]));
            }
            catch(Exception exception) { }

        return dou;
    }

    public Double parse(String str)
    {
        Double dou = Double.valueOf(0.0D);
        if(str == null)
            return dou;
        try
        {
            if(str == null || "".equals(str))
                dou = Double.valueOf(0.0D);
            else
                dou = Double.valueOf(Double.parseDouble(str));
        }
        catch(Exception exception) { }
        return dou;
    }
}
