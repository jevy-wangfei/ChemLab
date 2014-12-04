// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LayTeamAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;

public class LayTeamAction extends ActionSupport
{

    public LayTeamAction()
    {
    }

    public String execute()
    {
        ExnameDAO exDAO = new ExnameDAO();
        Exname ex = exDAO.findById(Integer.valueOf(enid));
        List teams = (new TeamsDAO()).findByEnid(ex.getEnid().intValue());
        Set set = new HashSet();
        String dates[] = date.split("-");
        int beYear = Integer.parseInt(dates[0]);
        int beMonth = Integer.parseInt(dates[1]);
        int endYear = Integer.parseInt(dates[2]);
        int endMonth = Integer.parseInt(dates[3]);
        int begin = beYear * 12 + beMonth;
        int end = endYear * 12 + endMonth;
        for(Iterator iterator = teams.iterator(); iterator.hasNext();)
        {
            Teams t = (Teams)iterator.next();
            int nowMon = (t.getDate().getYear() + 1900) * 12 + t.getDate().getMonth();
            if(nowMon > begin && nowMon < end)
                set.add(t);
        }

        ActionContext ctx = ActionContext.getContext();
        ctx.put("teams", set);
        ctx.put("date1", date);
        ctx.put("date2", date);
        return "success";
    }

    public String getExname()
    {
        return exname;
    }

    public void setExname(String exname)
    {
        this.exname = exname;
    }

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    private String exname;
    private int enid;
    String date;
}
