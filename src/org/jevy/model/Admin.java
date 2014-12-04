// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Admin.java

package org.jevy.model;

import java.io.Serializable;

public class Admin
    implements Serializable
{

    public Admin()
    {
    }

    public Admin(String loginname, String password)
    {
        this.loginname = loginname;
        this.password = password;
    }

    public Integer getAid()
    {
        return aid;
    }

    public void setAid(Integer aid)
    {
        this.aid = aid;
    }

    public String getLoginname()
    {
        return loginname;
    }

    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    private Integer aid;
    private String loginname;
    private String password;
}
