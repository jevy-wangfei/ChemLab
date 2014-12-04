// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Description.java

package org.jevy.model;

import java.io.Serializable;

// Referenced classes of package org.jevy.model:
//            Exname

public class Description
    implements Serializable
{

    public Description()
    {
    }

    public Description(Exname exname, String contents)
    {
        this.exname = exname;
        this.contents = contents;
    }

    public Integer getDid()
    {
        return did;
    }

    public void setDid(Integer did)
    {
        this.did = did;
    }

    public Exname getExname()
    {
        return exname;
    }

    public void setExname(Exname exname)
    {
        this.exname = exname;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    private Integer did;
    private Exname exname;
    private String contents;
}
