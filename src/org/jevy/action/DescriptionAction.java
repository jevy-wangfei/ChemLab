// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DescriptionAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Iterator;
import java.util.Set;
import org.jevy.model.*;

public class DescriptionAction extends ActionSupport
{

    public DescriptionAction()
    {
    }

    public String execute()
    {
        Exname exname = (new ExnameDAO()).findById(Integer.valueOf(enid));
        DescriptionDAO desDAO = new DescriptionDAO();
        Set deses = exname.getDescriptions();
        Description des = new Description();
        if(!deses.isEmpty())
        {
            for(Iterator iterator = deses.iterator(); iterator.hasNext(); desDAO.update(des))
            {
                Description dess = (Description)iterator.next();
                des.setContents(content);
                des.setExname(exname);
                des.setDid(dess.getDid());
            }

        } else
        {
            des.setContents(content);
            des.setExname(exname);
            desDAO.save(des);
        }
        return "success";
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    String content;
    int enid;
}
