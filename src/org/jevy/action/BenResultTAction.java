// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BenResultTAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.util.GetTeamByStudent;

public class BenResultTAction extends ActionSupport
{

    public BenResultTAction()
    {
    }

    public String execute()
    {
        if(tid == 0)
        {
            Student stu = (Student)ActionContext.getContext().getSession().get("student");
            tid = (new GetTeamByStudent()).getTeams(4, stu).getTid().intValue();
        }
        Teams team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        ActionContext.getContext().put("students", team.getStudents());
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
}
