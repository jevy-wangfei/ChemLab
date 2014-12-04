// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SaltResultAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.service.SaltData;
import org.jevy.util.GetTeamByStudent;

public class SaltResultAction extends ActionSupport
{

    public SaltResultAction()
    {
    }

    public String execute()
    {
        if(tid == 0)
        {
            Student stu = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(2, stu);
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        ActionContext.getContext().put("students", team.getStudents());
        java.util.List saltRes = (new SaltData()).getSaltData(team.getTid().intValue());
        ActionContext.getContext().put("saltResult", saltRes);
        ActionContext.getContext().put("team", team);
        return "success";
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    int tid;
    Teams team;
}
