// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Exname.java

package org.jevy.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Exname
    implements Serializable
{

    public Exname()
    {
        descriptions = new HashSet(0);
        teamses = new HashSet(0);
    }

    public Exname(String exname, Set descriptions, Set teamses)
    {
        this.descriptions = new HashSet(0);
        this.teamses = new HashSet(0);
        this.exname = exname;
        this.descriptions = descriptions;
        this.teamses = teamses;
    }

    public Integer getEnid()
    {
        return enid;
    }

    public void setEnid(Integer enid)
    {
        this.enid = enid;
    }

    public String getExname()
    {
        return exname;
    }

    public void setExname(String exname)
    {
        this.exname = exname;
    }

    public Set getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(Set descriptions)
    {
        this.descriptions = descriptions;
    }

    public Set getTeamses()
    {
        return teamses;
    }

    public void setTeamses(Set teamses)
    {
        this.teamses = teamses;
    }

    private Integer enid;
    private String exname;
    private Set descriptions;
    private Set teamses;
}
