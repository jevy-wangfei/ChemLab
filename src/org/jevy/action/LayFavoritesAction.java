// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LayFavoritesAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;

public class LayFavoritesAction extends ActionSupport
{

    public LayFavoritesAction()
    {
    }

    public String execute()
    {
        List list = new ArrayList(0);
        if(tid == 0)
        {
            List excs = (new ExcellentDAO()).findAll();
            Map map;
            for(Iterator iterator = excs.iterator(); iterator.hasNext(); list.add(map))
            {
                Excellent ex = (Excellent)iterator.next();
                map = new HashMap();
                map.put("exname", ex.getTeams().getExname().getExname());
                map.put("tid", ex.getTeams().getTid());
                map.put("enid", ex.getTeams().getExname().getEnid());
                map.put("member", ex.getTeams().getStudents());
                map.put("tname", ex.getTeams().getTname());
                map.put("date", ex.getTeams().getDate());
                map.put("eid", ex.getEid());
            }

            ActionContext.getContext().put("favorites", list);
            return "success";
        } else
        {
            Excellent exc = (new ExcellentDAO()).findById(Integer.valueOf(tid));
            ActionContext.getContext().put("excellent", exc);
            enid = (new TeamsDAO()).findById(Integer.valueOf(tid)).getExname().getEnid().intValue();
            return "favoriteDetail";
        }
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
