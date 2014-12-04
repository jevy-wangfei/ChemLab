// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Teams.java

package org.jevy.model;

import java.io.Serializable;
import java.util.*;

// Referenced classes of package org.jevy.model:
//            Exname

public class Teams
    implements Serializable
{

    public Teams()
    {
        datas = new HashSet(0);
        basicdatas = new HashSet(0);
        students = new HashSet(0);
        excellents = new HashSet(0);
    }

    public Teams(Exname exname, String tname, Date date, Set datas, Set basicdatas, Set students, Set excellents)
    {
        this.datas = new HashSet(0);
        this.basicdatas = new HashSet(0);
        this.students = new HashSet(0);
        this.excellents = new HashSet(0);
        this.exname = exname;
        this.tname = tname;
        this.date = date;
        this.datas = datas;
        this.basicdatas = basicdatas;
        this.students = students;
        this.excellents = excellents;
    }

    public Integer getTid()
    {
        return tid;
    }

    public void setTid(Integer tid)
    {
        this.tid = tid;
    }

    public Exname getExname()
    {
        return exname;
    }

    public void setExname(Exname exname)
    {
        this.exname = exname;
    }

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Set getDatas()
    {
        return datas;
    }

    public void setDatas(Set datas)
    {
        this.datas = datas;
    }

    public Set getBasicdatas()
    {
        return basicdatas;
    }

    public void setBasicdatas(Set basicdatas)
    {
        this.basicdatas = basicdatas;
    }

    public Set getStudents()
    {
        return students;
    }

    public void setStudents(Set students)
    {
        this.students = students;
    }

    public Set getExcellents()
    {
        return excellents;
    }

    public void setExcellents(Set excellents)
    {
        this.excellents = excellents;
    }

    private Integer tid;
    private Exname exname;
    private String tname;
    private Date date;
    private Set datas;
    private Set basicdatas;
    private Set students;
    private Set excellents;
}
