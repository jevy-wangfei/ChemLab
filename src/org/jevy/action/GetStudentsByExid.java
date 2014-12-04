// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetStudentsByExid.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import org.jevy.service.GetByExnameService;

public class GetStudentsByExid extends ActionSupport
{

    public GetStudentsByExid()
    {
    }

    public String execute()
    {
        GetByExnameService getByExname = new GetByExnameService();
        System.out.println((new StringBuilder("GetByExnameAction.exNameId:")).append(exId).toString());
        String student[][] = getByExname.getAllByExname(exId);
        ActionContext ctx = ActionContext.getContext();
        ctx.put("student", student);
        return "success";
    }

    public String getExname()
    {
        return exname;
    }

    public void setExname(String exname)
    {
        this.exname = exname;
    }

    public int getExId()
    {
        return exId;
    }

    public void setExId(int exId)
    {
        this.exId = exId;
    }

    private String exname;
    private int exId;
}
