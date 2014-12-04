// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UpdateTeamAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.jevy.model.*;

public class UpdateTeamAction extends ActionSupport
{

    public UpdateTeamAction()
    {
    }

    public String execute()
    {
        TeamsDAO teamDAO = new TeamsDAO();
        teamDAO.updateTeamStudent(tid, sid, reTeam);
        java.util.List team = teamDAO.findByEnid(teamDAO.findById(Integer.valueOf(tid)).getExname().getEnid().intValue());
        ActionContext.getContext().put("teams", team);
        return "success";
    }

    public int getReTeam()
    {
        return reTeam;
    }

    public void setReTeam(int reTeam)
    {
        this.reTeam = reTeam;
    }

    public int getSid()
    {
        return sid;
    }

    public void setSid(int sid)
    {
        this.sid = sid;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    int reTeam;
    int sid;
    int tid;
}
