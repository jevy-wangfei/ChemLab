// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Excellent.java

package org.jevy.model;

import java.io.Serializable;

// Referenced classes of package org.jevy.model:
//            Teams

public class Excellent
    implements Serializable
{

    public Excellent()
    {
    }

    public Excellent(Teams teams, String comments)
    {
        this.teams = teams;
        this.comments = comments;
    }

    public Integer getEid()
    {
        return eid;
    }

    public void setEid(Integer eid)
    {
        this.eid = eid;
    }

    public Teams getTeams()
    {
        return teams;
    }

    public void setTeams(Teams teams)
    {
        this.teams = teams;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    private Integer eid;
    private Teams teams;
    private String comments;
}
