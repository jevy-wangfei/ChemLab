// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EditTeamAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;

public class EditTeamAction extends ActionSupport
{

    public EditTeamAction()
    {
    }

    public String execute()
    {
        TeamsDAO tDAO = new TeamsDAO();
        Teams team = tDAO.findById(Integer.valueOf(tid));
        Set teams = (new ExnameDAO()).findById(Integer.valueOf(enid)).getTeamses();
        Set students = team.getStudents();
        Map teamMap = new HashMap();
        Date date = tDAO.findById(Integer.valueOf(tid)).getDate();
        int basMonth = (date.getYear() + 1900) * 12 + 3;
        int highMonth = (date.getYear() + 1900) * 12 + 15;
        for(Iterator iterator = teams.iterator(); iterator.hasNext();)
        {
            Teams tm = (Teams)iterator.next();
            int month = (tm.getDate().getYear() + 1900) * 12 + tm.getDate().getMonth();
            if(month >= basMonth && month < highMonth)
                teamMap.put(tm.getTid(), tm.getTname());
        }

        ActionContext.getContext().put("team", team);
        ActionContext.getContext().put("students", students);
        ActionContext.getContext().put("teamMap", teamMap);
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

    private static final long serialVersionUID = 0xdb62d449b20b1c22L;
    int tid;
    int enid;
}
