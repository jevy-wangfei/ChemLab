// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExcellentComAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;
import org.jevy.model.*;

public class ExcellentComAction extends ActionSupport
{

    public ExcellentComAction()
    {
    }

    public String execute()
    {
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

        ActionContext.getContext().put("exname", ex.getTeams().getExname());
        ActionContext.getContext().put("comment", ex);
        ActionContext.getContext().put("haveFavorite", getText("haveFavorite"));
        return "input";
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
