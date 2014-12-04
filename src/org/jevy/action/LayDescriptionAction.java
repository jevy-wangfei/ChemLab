// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LayDescriptionAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.jevy.model.*;

public class LayDescriptionAction extends ActionSupport
{

    public LayDescriptionAction()
    {
    }

    public String execute()
    {
        org.jevy.model.Exname exname = (new ExnameDAO()).findById(Integer.valueOf(enid));
        Description des = (Description)(new DescriptionDAO()).findByProperty("exname", exname).get(0);
        ActionContext.getContext().put("description", des);
        ActionContext.getContext().put("exname", exname);
        ActionContext.getContext().put("des", des.getContents());
        return "success";
    }

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    private static final long serialVersionUID = 1L;
    int enid;
}
