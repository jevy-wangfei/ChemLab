// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TeacherLogin.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.*;
import org.jevy.model.Admin;
import org.jevy.model.AdminDAO;

public class TeacherLogin extends ActionSupport
{

    public TeacherLogin()
    {
    }

    public String execute()
    {
        List list = new ArrayList();
        list = (new AdminDAO()).adminLogin(loginName, password);
        if(list.size() > 0)
        {
            ActionContext.getContext().getSession().put("teacher", (Admin)list.get(0));
            return "success";
        } else
        {
            System.out.println("TeacherLogin().teacehr=null");
            return "input";
        }
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
