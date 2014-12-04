// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BenQResultAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;
import org.jevy.resmodel.BenResModel;
import org.jevy.service.BenData;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.RetainedFraction;

public class BenQResultAction extends ActionSupport
{

    public BenQResultAction()
    {
    }

    public String execute()
    {
        if(tid == 0)
        {
            Student stu = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(4, stu);
            tid = team.getTid().intValue();
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        java.util.Set allData = team.getDatas();
        List benTRes = new ArrayList();
        List dataList = (new BenData()).getBenQualityData(team.getTid().intValue());
        BenResModel model;
        for(Iterator iterator = dataList.iterator(); iterator.hasNext(); benTRes.add(model))
        {
            Data da = (Data)iterator.next();
            model = new BenResModel();
            model.setTime1(da.getData1().doubleValue());
            model.setTime2(da.getData2().doubleValue());
            model.setTime3(da.getData3().doubleValue());
            model.setTime4(da.getData4().doubleValue());
            model.setTime5(da.getData5().doubleValue());
            model.setTemperOrQ(da.getData6().doubleValue());
            model.setAbsorb1(da.getData7().doubleValue());
            model.setAbsorb2(da.getData8().doubleValue());
            model.setAbsorb3(da.getData9().doubleValue());
            model.setAbsorb4(da.getData10().doubleValue());
            model.setAbsorb5(da.getData11().doubleValue());
            model.setWipeoff1(getWipeoff(model.getAbsorb1()));
            model.setWipeoff2(getWipeoff(model.getAbsorb2()));
            model.setWipeoff3(getWipeoff(model.getAbsorb3()));
            model.setWipeoff4(getWipeoff(model.getAbsorb4()));
            model.setWipeoff5(getWipeoff(model.getAbsorb5()));
            model.setDid(da.getDid().intValue());
        }

        ActionContext.getContext().put("benQ", benTRes);
        ActionContext.getContext().put("benQ2", benTRes);
        return "success";
    }

    public double getWipeoff(double a)
    {
        double c = (a - 0.0063499999999999997D) / 0.58196999999999999D;
        return (new RetainedFraction()).retained4((1.0D - (50D * c) / 50D) * 100D);
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    int tid;
    Teams team;
}
