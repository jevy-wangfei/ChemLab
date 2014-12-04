// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeletePowerAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionSupport;
import org.jevy.model.AdminDAO;

public class DeletePowerAction extends ActionSupport
{

    public DeletePowerAction()
    {
    }

    public String execute()
    {
        AdminDAO adDAO = new AdminDAO();
        adDAO.delete(adDAO.findById(Integer.valueOf(aid)));
        return "success";
    }

    public int getAid()
    {
        return aid;
    }

    public void setAid(int aid)
    {
        this.aid = aid;
    }

    int aid;
}
