// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Basicdata.java

package org.jevy.model;

import java.io.Serializable;

// Referenced classes of package org.jevy.model:
//            Teams

public class Basicdata
    implements Serializable
{

    public Basicdata()
    {
    }

    public Basicdata(Teams teams, String label, Double bdata1, Double bdata2, Double bdata3, Double bdata4, Double bdata5, 
            Double bdata6, Double bdata7, Double bdata8)
    {
        this.teams = teams;
        this.label = label;
        this.bdata1 = bdata1;
        this.bdata2 = bdata2;
        this.bdata3 = bdata3;
        this.bdata4 = bdata4;
        this.bdata5 = bdata5;
        this.bdata6 = bdata6;
        this.bdata7 = bdata7;
        this.bdata8 = bdata8;
    }

    public Integer getBid()
    {
        return bid;
    }

    public void setBid(Integer bid)
    {
        this.bid = bid;
    }

    public Teams getTeams()
    {
        return teams;
    }

    public void setTeams(Teams teams)
    {
        this.teams = teams;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public Double getBdata1()
    {
        return bdata1;
    }

    public void setBdata1(Double bdata1)
    {
        this.bdata1 = bdata1;
    }

    public Double getBdata2()
    {
        return bdata2;
    }

    public void setBdata2(Double bdata2)
    {
        this.bdata2 = bdata2;
    }

    public Double getBdata3()
    {
        return bdata3;
    }

    public void setBdata3(Double bdata3)
    {
        this.bdata3 = bdata3;
    }

    public Double getBdata4()
    {
        return bdata4;
    }

    public void setBdata4(Double bdata4)
    {
        this.bdata4 = bdata4;
    }

    public Double getBdata5()
    {
        return bdata5;
    }

    public void setBdata5(Double bdata5)
    {
        this.bdata5 = bdata5;
    }

    public Double getBdata6()
    {
        return bdata6;
    }

    public void setBdata6(Double bdata6)
    {
        this.bdata6 = bdata6;
    }

    public Double getBdata7()
    {
        return bdata7;
    }

    public void setBdata7(Double bdata7)
    {
        this.bdata7 = bdata7;
    }

    public Double getBdata8()
    {
        return bdata8;
    }

    public void setBdata8(Double bdata8)
    {
        this.bdata8 = bdata8;
    }

    private Integer bid;
    private Teams teams;
    private String label;
    private Double bdata1;
    private Double bdata2;
    private Double bdata3;
    private Double bdata4;
    private Double bdata5;
    private Double bdata6;
    private Double bdata7;
    private Double bdata8;
}
