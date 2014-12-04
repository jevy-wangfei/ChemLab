// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SetStuLoginTime2Action.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class SetStuLoginTime2Action extends ActionSupport
{

    public SetStuLoginTime2Action()
    {
    }

    public String execute()
    {
        ActionContext.getContext().getSession().put("setTime", setTime);
        return "success";
    }

    public String getSetTime()
    {
        return setTime;
    }

    public void setSetTime(String setTime)
    {
        this.setTime = setTime;
    }

    public String setTime;
}
