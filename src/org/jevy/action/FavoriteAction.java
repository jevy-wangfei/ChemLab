// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FavoriteAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionSupport;
import org.jevy.model.*;

public class FavoriteAction extends ActionSupport
{

    public FavoriteAction()
    {
    }

    public String execute()
    {
        if(eid == 0)
        {
            Excellent exc = new Excellent();
            exc.setComments(content);
            Teams team = (new TeamsDAO()).findById(Integer.valueOf(tid));
            enid = team.getExname().getEnid().intValue();
            exc.setTeams(team);
            (new ExcellentDAO()).save(exc);
            return "success";
        } else
        {
            ExcellentDAO exDAO = new ExcellentDAO();
            Excellent ex = exDAO.findById(Integer.valueOf(eid));
            ex.setComments(content);
            Teams team = (new TeamsDAO()).findById(Integer.valueOf(tid));
            enid = team.getExname().getEnid().intValue();
            ex.setTeams(team);
            exDAO.update(ex);
            return "success";
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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    public int getEid()
    {
        return eid;
    }

    public void setEid(int eid)
    {
        this.eid = eid;
    }

    int tid;
    int enid;
    int eid;
    String content;
}
