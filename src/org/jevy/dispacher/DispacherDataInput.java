// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DispacherDataInput.java

package org.jevy.dispacher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DispacherDataInput extends ActionSupport
{

    public DispacherDataInput()
    {
        enid = 0;
    }

    public String execute()
    {
        ActionContext ctx = ActionContext.getContext();
        if(enid == 1)
        {
            ctx.put("enid", Integer.valueOf(enid));
            ctx.put("exnameTag", "gass");
            return "gase";
        }
        if(enid == 2)
        {
            ctx.put("enid", Integer.valueOf(enid));
            ctx.put("exnameTag", "salt");
            return "salt";
        }
        if(enid == 3)
        {
            ctx.put("enid", Integer.valueOf(enid));
            ctx.put("exnameTag", "co2");
            return "co2";
        }
        if(enid == 4)
        {
            ctx.put("enid", Integer.valueOf(enid));
            ctx.put("exnameTag", "ben");
            return "ben";
        }
        if(enid == 5)
        {
            ctx.put("enid", Integer.valueOf(enid));
            ctx.put("exnameTag", "styrene");
            return "styrene";
        } else
        {
            return "input";
        }
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
