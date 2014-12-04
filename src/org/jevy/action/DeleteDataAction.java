// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeleteDataAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.jevy.model.*;

public class DeleteDataAction extends ActionSupport
{

    public DeleteDataAction()
    {
    }

    public String execute()
    {
        DataDAO dataDAO = new DataDAO();
        Data data = dataDAO.findById(Integer.valueOf(did));
        Teams team = null;
        if(data != null)
        {
            team = data.getTeams();
            tid = team.getTid().intValue();
            dataDAO.delete(data);
        } else
        {
            ActionContext.getContext().put("error", "the data you deleted is not exiest!");
            return "input";
        }
        return "success";
    }

    public int getDid()
    {
        return did;
    }

    public void setDid(int did)
    {
        this.did = did;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    int did;
    int tid;
}
