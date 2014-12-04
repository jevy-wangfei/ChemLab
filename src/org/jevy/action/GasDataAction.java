// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GasDataAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.service.GasData;
import org.jevy.util.GetTeamByStudent;

public class GasDataAction extends ActionSupport
{

    public GasDataAction()
    {
    }

    public String execute()
    {
        if(tid == 0)
        {
            Student stu = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(enid, stu);
            tid = team.getTid().intValue();
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        java.util.List gasRes = (new GasData()).getExperimentData(team);
        ActionContext.getContext().put("gasRes", gasRes);
        ActionContext.getContext().put("gasBase", gasRes);
        ActionContext.getContext().put("students", team.getStudents());
        ActionContext.getContext().put("team", team);
        return "success";
    }

    public Teams getTeam()
    {
        return team;
    }

    public void setTeam(Teams team)
    {
        this.team = team;
    }

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    Teams team;
    int enid;
    int tid;
}
