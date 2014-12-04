// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CO2DataAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;
import org.jevy.service.CO2Data;
import org.jevy.util.GetTeamByStudent;

public class CO2DataAction extends ActionSupport
{

    public CO2DataAction()
    {
    }

    public String execute()
    {
        Teams team = null;
        ActionContext ctx = ActionContext.getContext();
        Student student = null;
        if(tid == 0)
        {
            student = (Student)ctx.getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(3, student);
            tid = team.getTid().intValue();
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        Set students = team.getStudents();
        ctx.put("students", students);
        CO2Data co2Data = new CO2Data();
        List datas = co2Data.getData(3, team);
        for(int i = 0; i < datas.size(); i++)
        {
            int j = i + 1;
            ctx.put((new StringBuilder("data")).append(j).toString(), co2Data.co2DataCalculate((Set)datas.get(i)));
        }

        ctx.put("student", student);
        ctx.put("team", team);
        return "success";
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

    private static final long serialVersionUID = 0xdc9ec130aa31c646L;
    int enid;
    int tid;
}
