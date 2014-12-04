// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CommentAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.*;
import org.jevy.model.*;
import org.jevy.util.GetTeamByStudent;

public class CommentAction extends ActionSupport
{

    public CommentAction()
    {
    }

    public String execute()
    {
        if(tid == 0)
        {
            Student stu = (Student)ActionContext.getContext().getSession().get("student");
            tid = (new GetTeamByStudent()).getTeams(enid, stu).getTid().intValue();
        }
        ExcellentDAO exDAO = new ExcellentDAO();
        Set exs = (new TeamsDAO()).findById(Integer.valueOf(tid)).getExcellents();
        if(exs.isEmpty())
        {
            System.out.println((new StringBuilder("ExcellentComAction().execute() tid:")).append(tid).append(exs).toString());
            return "success";
        }
        Excellent ex = null;
        for(Iterator iterator = exs.iterator(); iterator.hasNext();)
        {
            Excellent ex1 = (Excellent)iterator.next();
            ex = ex1;
        }

        ActionContext.getContext().put("com", ex.getComments());
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

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    int tid;
    int enid;
}
