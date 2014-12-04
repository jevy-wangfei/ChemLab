// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CO2Action.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;
import org.jevy.util.*;

public class CO2Action extends ActionSupport
{

    public CO2Action()
    {
    }

    public String execute()
    {
        StringParseDouble parse = new StringParseDouble();
        StringParseInt parseInt = new StringParseInt();
        Double baseT = parse.parse(this.baseT);
        Double baseP = parse.parse(this.baseP);
        int enid = parseInt.parse(this.enid);
        Double t = parse.parse(this.t);
        Double p1[] = parse.parse(this.p1);
        Double dh1[] = parse.parse(this.dh1);
        Double h = parse.parse(this.h);
        ActionContext ctx = ActionContext.getContext();
        Student student = (Student)ctx.getSession().get("student");
        java.util.Set teams = null;
        if(student != null)
            teams = student.getTeamses();
        org.jevy.model.Teams userTeam = (new GetTeamByStudent()).getTeams(3, student);
        List data = new ArrayList();
        for(int i = 0; i < p1.length; i++)
            if(p1[i].doubleValue() != 0.0D && dh1[i].doubleValue() != 0.0D)
            {
                Data data2 = new Data();
                data2.setTeams(userTeam);
                data2.setLabel("co2");
                data2.setData2(t);
                data2.setData3(dh1[i]);
                data2.setData4(p1[i]);
                data2.setData5(h);
                data.add(data2);
            }

        DataDAO dataDAO = new DataDAO();
        for(int i = 0; i < data.size(); i++)
            dataDAO.save(data.get(i));

        return "success";
    }

    public String getBaseT()
    {
        return baseT;
    }

    public void setBaseT(String baseT)
    {
        this.baseT = baseT;
    }

    public String getBaseP()
    {
        return baseP;
    }

    public void setBaseP(String baseP)
    {
        this.baseP = baseP;
    }

    public String getEnid()
    {
        return enid;
    }

    public void setEnid(String enid)
    {
        this.enid = enid;
    }

    public String getExnameTag()
    {
        return exnameTag;
    }

    public void setExnameTag(String exnameTag)
    {
        this.exnameTag = exnameTag;
    }

    public String getT()
    {
        return t;
    }

    public void setT(String t)
    {
        this.t = t;
    }

    public String[] getP1()
    {
        return p1;
    }

    public void setP1(String p1[])
    {
        this.p1 = p1;
    }

    public String[] getDh1()
    {
        return dh1;
    }

    public void setDh1(String dh1[])
    {
        this.dh1 = dh1;
    }

    public String getH()
    {
        return h;
    }

    public void setH(String h)
    {
        this.h = h;
    }

    private static final long serialVersionUID = 1L;
    private String baseT;
    private String baseP;
    private String enid;
    private String exnameTag;
    private String h;
    private String t;
    private String p1[];
    private String dh1[];
}
