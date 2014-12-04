// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LayTeamDispacherAction.java

package org.jevy.dispacher;

import com.opensymphony.xwork2.ActionSupport;

public class LayTeamDispacherAction extends ActionSupport
{

    public LayTeamDispacherAction()
    {
    }

    public String execute()
    {
        if(exId == 3)
            return "co2";
        else
            return "success";
    }

    public int getExId()
    {
        return exId;
    }

    public void setExId(int exId)
    {
        this.exId = exId;
    }

    public int exId;
}
