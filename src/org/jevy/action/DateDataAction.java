// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DateDataAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;

public class DateDataAction extends ActionSupport
{

    public DateDataAction()
    {
    }

    public String execute()
    {
        ExnameDAO exDAO = new ExnameDAO();
        Exname ex = exDAO.findById(Integer.valueOf(enid));
        List teams = (new TeamsDAO()).findByEnid(ex.getEnid().intValue());
        Set set = new HashSet();
        Map map;
        for(Iterator iterator = teams.iterator(); iterator.hasNext(); set.add(map))
        {
            Teams t = (Teams)iterator.next();
            map = new HashMap();
            int basMonth = (t.getDate().getYear() + 1900) * 12 + 3;
            int highMonth = (t.getDate().getYear() + 1900) * 12 + 15;
            int month = (t.getDate().getYear() + 1900) * 12 + t.getDate().getMonth();
            if(month >= basMonth && month < highMonth)
                if(t.getDate().getMonth() < 3)
                {
                    int y1 = (t.getDate().getYear() - 1) + 1900;
                    int y2 = t.getDate().getYear() + 1900;
                    map.put("date", (new StringBuilder(String.valueOf(y1))).append("-3-").append(y2).append("-2").toString());
                    map.put("date2", (new StringBuilder(String.valueOf(y1))).append(".3-").append(y2).append(".2").toString());
                } else
                if(t.getDate().getMonth() >= 3)
                {
                    int y1 = t.getDate().getYear() + 1900;
                    int y2 = t.getDate().getYear() + 1901;
                    map.put("date", (new StringBuilder(String.valueOf(y1))).append("-3-").append(y2).append("-2").toString());
                    map.put("date2", (new StringBuilder(String.valueOf(y1))).append(".3-").append(y2).append(".2").toString());
                }
            map.put("enid", (new StringBuilder(String.valueOf(enid))).toString());
        }

        ActionContext ctx = ActionContext.getContext();
        ctx.put("dateTeam", set);
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

    private String exname;
    private int enid;
}
