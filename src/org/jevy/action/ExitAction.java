// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExitAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class ExitAction extends ActionSupport
{

    public ExitAction()
    {
    }

    public String execute()
    {
        ActionContext.getContext().getSession().remove("student");
        return "success";
    }
}
