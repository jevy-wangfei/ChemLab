// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeleteFavorites.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionSupport;
import org.jevy.model.ExcellentDAO;

public class DeleteFavorites extends ActionSupport
{

    public DeleteFavorites()
    {
    }

    public String execute()
    {
        ExcellentDAO excellentDAO = new ExcellentDAO();
        excellentDAO.delete(excellentDAO.findById(Integer.valueOf(eid)));
        return "success";
    }

    public int getEid()
    {
        return eid;
    }

    public void setEid(int eid)
    {
        this.eid = eid;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    int eid;
    int tid;
}
