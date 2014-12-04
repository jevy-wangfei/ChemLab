// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CO2ResModel.java

package org.jevy.resmodel;


public class CO2ResModel
{

    public CO2ResModel()
    {
    }

    public double getTemper()
    {
        return temper;
    }

    public void setTemper(double temper)
    {
        this.temper = temper;
    }

    public double getP()
    {
        return p;
    }

    public void setP(double p)
    {
        this.p = p;
    }

    public double getV()
    {
        return v;
    }

    public void setV(double v)
    {
        this.v = v;
    }

    public double getDh()
    {
        return dh;
    }

    public void setDh(double dh)
    {
        this.dh = dh;
    }

    public int getDid()
    {
        return did;
    }

    public void setDid(int did)
    {
        this.did = did;
    }

    double temper;
    double p;
    double v;
    double dh;
    int did;
}
