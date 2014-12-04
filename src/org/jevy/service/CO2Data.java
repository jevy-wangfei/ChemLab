// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CO2Data.java

package org.jevy.service;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;
import org.jevy.resmodel.CO2ResModel;
import org.jevy.util.Retained;

public class CO2Data extends ActionSupport
{

    public CO2Data()
    {
    }

    public List getData(int enid, Teams team)
    {
        List CO2Group = (new DataDAO()).getCO2Group(team.getTid().intValue());
        Set data = team.getDatas();
        List d = new ArrayList(0);
        for(int i = 0; i < CO2Group.size(); i++)
        {
            Set groupData = new HashSet();
            for(Iterator iterator = data.iterator(); iterator.hasNext();)
            {
                Data da = (Data)iterator.next();
                if(((Data)CO2Group.get(i)).getData2().equals(da.getData2()))
                    groupData.add(da);
            }

            d.add(groupData);
        }

        return d;
    }

    public List co2DataCalculate(Set data)
    {
        List list0 = new ArrayList();
        if(data != null)
        {
            CO2ResModel model;
            for(Iterator iterator = data.iterator(); iterator.hasNext(); list0.add(model))
            {
                Data da = (Data)iterator.next();
                double dh = da.getData3().doubleValue();
                double p = da.getData4().doubleValue();
                double temper = da.getData2().doubleValue();
                model = new CO2ResModel();
                model.setTemper(Retained.retained4(temper));
                model.setP(Retained.retained4(p));
                model.setDh(Retained.retained4(dh));
                double v = (dh * 0.01D) / getK(da.getData5().doubleValue());
                model.setV(Retained.retained4(v * 1000D));
                model.setDid(da.getDid().intValue());
            }

        }
        return list0;
    }

    public double getK(double h)
    {
        return (h * 1000D) / 124D;
    }

    public int getEnid()
    {
        return enid;
    }

    public void setEnid(int enid)
    {
        this.enid = enid;
    }

    public int getTeamId()
    {
        return teamId;
    }

    public void setTeamId(int teamId)
    {
        this.teamId = teamId;
    }

    private static final long serialVersionUID = 1L;
    private int enid;
    private int teamId;
}
