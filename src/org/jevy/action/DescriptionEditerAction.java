// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DescriptionEditerAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.jevy.model.*;

public class DescriptionEditerAction extends ActionSupport
{

    public DescriptionEditerAction()
    {
    }

    public String execute()
    {
        org.jevy.model.Exname exname = (new ExnameDAO()).findById(Integer.valueOf(enid));
        List list = new ArrayList();
        list = (new DescriptionDAO()).findByProperty("exname", exname);
        Description des = null;
        if(list.size() > 0)
            des = (Description)list.get(0);
        ActionContext.getContext().put("exname", exname);
        if(des != null)
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

    int enid;
}
