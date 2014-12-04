// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StyreneResultAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.service.StyreneData;
import org.jevy.util.GetTeamByStudent;

public class StyreneResultAction extends ActionSupport
{

    public StyreneResultAction()
    {
    }

    public String execute()
    {
        Teams team = null;
        if(tid == 0)
        {
            Student stu = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(5, stu);
            tid = team.getTid().intValue();
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        java.util.List res = (new StyreneData()).getStyreneData(tid);
        ActionContext.getContext().put("res", res);
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

    private static final long serialVersionUID = 0xcb29d8f77d1c0a52L;
    int tid;
}
