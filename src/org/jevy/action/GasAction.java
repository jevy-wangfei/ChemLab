// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GasAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.util.GetTeamByStudent;

public class GasAction extends ActionSupport
{

    public GasAction()
    {
        y = 0.0D;
    }

    public String execute()
    {
        ActionContext ctx = ActionContext.getContext();
        Student student = (Student)ctx.getSession().get("student");
        setTeam((new GetTeamByStudent()).getTeams(enid, student));
        if(sysPress == 0.0D)
        {
            return "success";
        } else
        {
            Data da = new Data();
            da.setLabel("gas");
            da.setTeams(team);
            da.setData1(Double.valueOf(balanceTemper));
            da.setData2(Double.valueOf(g1));
            da.setData3(Double.valueOf(g2));
            da.setData4(Double.valueOf(g3));
            da.setData5(Double.valueOf(ngas));
            da.setData6(Double.valueOf(yy));
            da.setData7(Double.valueOf(y));
            da.setData8(Double.valueOf(nliqude));
            da.setData9(Double.valueOf(x));
            da.setData10(Double.valueOf(baseatm * 1000D));
            da.setData11(Double.valueOf(sysPress * 1000D));
            da.setData12(Double.valueOf(temperature));
            da.setData13(Double.valueOf(voltage));
            DataDAO daDAO = new DataDAO();
            daDAO.save(da);
            return "success";
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

    public double getBaseatm()
    {
        return baseatm;
    }

    public void setBaseatm(double baseatm)
    {
        this.baseatm = baseatm;
    }

    public double getSysPress()
    {
        return sysPress;
    }

    public void setSysPress(double sysPress)
    {
        this.sysPress = sysPress;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }

    public double getVoltage()
    {
        return voltage;
    }

    public void setVoltage(double voltage)
    {
        this.voltage = voltage;
    }

    public double getBalanceTemper()
    {
        return balanceTemper;
    }

    public void setBalanceTemper(double balanceTemper)
    {
        this.balanceTemper = balanceTemper;
    }

    public double getG1()
    {
        return g1;
    }

    public void setG1(double g1)
    {
        this.g1 = g1;
    }

    public double getG2()
    {
        return g2;
    }

    public void setG2(double g2)
    {
        this.g2 = g2;
    }

    public double getG3()
    {
        return g3;
    }

    public void setG3(double g3)
    {
        this.g3 = g3;
    }

    public double getNgas()
    {
        return ngas;
    }

    public void setNgas(double ngas)
    {
        this.ngas = ngas;
    }

    public double getYy()
    {
        return yy;
    }

    public void setYy(double yy)
    {
        this.yy = yy;
    }

    public Teams getTeam()
    {
        return team;
    }

    public void setTeam(Teams team)
    {
        this.team = team;
    }

    public double getNliqude()
    {
        return nliqude;
    }

    public void setNliqude(double nliqude)
    {
        this.nliqude = nliqude;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    int enid;
    double baseatm;
    double sysPress;
    double temperature;
    double voltage;
    double balanceTemper;
    double g1;
    double g2;
    double g3;
    double ngas;
    double yy;
    double y;
    double nliqude;
    double x;
    Teams team;
}
