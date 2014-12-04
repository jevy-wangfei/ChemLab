// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LayExname.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.jevy.model.ExnameDAO;

public class LayExname extends ActionSupport
{

    public LayExname()
    {
        listExname = null;
    }

    public String execute()
    {
        listExname = new ArrayList();
        ExnameDAO exname = new ExnameDAO();
        listExname = exname.findAll();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("exname", listExname);
        return "success";
    }

    public List getListExname()
    {
        return listExname;
    }

    public void setListExname(List listExname)
    {
        this.listExname = listExname;
    }

    List listExname;
}
