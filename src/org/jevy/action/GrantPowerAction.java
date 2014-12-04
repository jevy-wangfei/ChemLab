// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GrantPowerAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.jevy.model.Admin;
import org.jevy.model.AdminDAO;

public class GrantPowerAction extends ActionSupport
{

    public GrantPowerAction()
    {
    }

    public String execute()
    {
        AdminDAO adDAO = new AdminDAO();
        java.util.List list = null;
        if(loginName == null || password == null)
            list = adDAO.findAll();
        else
        if(loginName != null && password != null)
        {
            Admin ad = new Admin();
            ad.setLoginname(loginName);
            ad.setPassword(password);
            adDAO.save(ad);
            list = adDAO.findAll();
        }
        ActionContext.getContext().put("ad", list);
        return "success";
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    String loginName;
    String password;
}
