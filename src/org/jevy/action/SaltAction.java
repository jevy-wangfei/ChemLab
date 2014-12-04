// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SaltAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.StringParseDouble;

public class SaltAction extends ActionSupport
{

    public SaltAction()
    {
        enid = 2;
    }

    public String execute()
    {
        StringParseDouble ps = new StringParseDouble();
        Double na[] = ps.parse(this.na);
        Double nh[] = ps.parse(this.nh);
        Double w[] = ps.parse(this.w);
        Double ag[] = ps.parse(this.ag);
        Double oh[] = ps.parse(this.oh);
        Student stu = (Student)ActionContext.getContext().getSession().get("student");
        org.jevy.model.Teams team = (new GetTeamByStudent()).getTeams(enid, stu);
        Data data = new Data();
        DataDAO dataDAO = new DataDAO();
        for(int i = 0; i < na.length; i++)
            if(na[i].doubleValue() != 0.0D && cag != 0.0D && coh != 0.0D)
            {
                data.setData1(na[i]);
                data.setData2(nh[i]);
                data.setData3(w[i]);
                data.setData4(ag[i]);
                data.setData5(oh[i]);
                data.setData6(Double.valueOf(cag));
                data.setData7(Double.valueOf(coh));
                data.setLabel((new StringBuilder("salt")).append(i).toString());
                data.setTeams(team);
                dataDAO.save(data);
            }

        return "success";
    }

    public String[] getNa()
    {
        return na;
    }

    public void setNa(String na[])
    {
        this.na = na;
    }

    public String[] getNh()
    {
        return nh;
    }

    public void setNh(String nh[])
    {
        this.nh = nh;
    }

    public String[] getW()
    {
        return w;
    }

    public void setW(String w[])
    {
        this.w = w;
    }

    public String[] getAg()
    {
        return ag;
    }

    public void setAg(String ag[])
    {
        this.ag = ag;
    }

    public String[] getOh()
    {
        return oh;
    }

    public void setOh(String oh[])
    {
        this.oh = oh;
    }

    public double getCag()
    {
        return cag;
    }

    public void setCag(double cag)
    {
        this.cag = cag;
    }

    public double getCoh()
    {
        return coh;
    }

    public void setCoh(double coh)
    {
        this.coh = coh;
    }

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    String na[];
    String nh[];
    String w[];
    String ag[];
    String oh[];
    double cag;
    double coh;
    int enid;
}
