// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StyreneAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.StringParseDouble;

public class StyreneAction extends ActionSupport
{

    public StyreneAction()
    {
    }

    public String execute()
    {
        if(tid == 0)
        {
            Student stu = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(5, stu);
            tid = team.getTid().intValue();
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        StringParseDouble ps = new StringParseDouble();
        Double reactorTemper[] = ps.parse(this.reactorTemper);
        Double benQuality[] = ps.parse(this.benQuality);
        Double waterQuality[] = ps.parse(this.waterQuality);
        Double hyLayer[] = ps.parse(this.hyLayer);
        Double waterLayer[] = ps.parse(this.waterLayer);
        Double benResP[] = ps.parse(this.benResP);
        Double styreneResP[] = ps.parse(this.styreneResP);
        DataDAO dataDAO = new DataDAO();
        for(int i = 0; i < reactorTemper.length; i++)
            if(reactorTemper[i].doubleValue() != 0.0D || hyLayer[i].doubleValue() != 0.0D || waterLayer[i].doubleValue() != 0.0D)
            {
                Data data = new Data();
                data.setLabel((new StringBuilder("styrene")).append(i).toString());
                data.setData1(Double.valueOf(reactorTemper[i].doubleValue()));
                data.setData2(Double.valueOf(benQuality[i].doubleValue()));
                data.setData3(Double.valueOf(waterQuality[i].doubleValue()));
                data.setData4(Double.valueOf(hyLayer[i].doubleValue()));
                data.setData5(Double.valueOf(waterLayer[i].doubleValue()));
                data.setData6(Double.valueOf(benResP[i].doubleValue()));
                data.setData7(Double.valueOf(0.0D));
                data.setData8(Double.valueOf(styreneResP[i].doubleValue()));
                data.setData9(Double.valueOf(0.0D));
                data.setTeams(team);
                dataDAO.save(data);
            }

        return "success";
    }

    public String[] getReactorTemper()
    {
        return reactorTemper;
    }

    public void setReactorTemper(String reactorTemper[])
    {
        this.reactorTemper = reactorTemper;
    }

    public String[] getBenQuality()
    {
        return benQuality;
    }

    public void setBenQuality(String benQuality[])
    {
        this.benQuality = benQuality;
    }

    public String[] getWaterQuality()
    {
        return waterQuality;
    }

    public void setWaterQuality(String waterQuality[])
    {
        this.waterQuality = waterQuality;
    }

    public String[] getHyLayer()
    {
        return hyLayer;
    }

    public void setHyLayer(String hyLayer[])
    {
        this.hyLayer = hyLayer;
    }

    public String[] getWaterLayer()
    {
        return waterLayer;
    }

    public void setWaterLayer(String waterLayer[])
    {
        this.waterLayer = waterLayer;
    }

    public String[] getBenResP()
    {
        return benResP;
    }

    public void setBenResP(String benResP[])
    {
        this.benResP = benResP;
    }

    public String[] getBenRes()
    {
        return benRes;
    }

    public void setBenRes(String benRes[])
    {
        this.benRes = benRes;
    }

    public String[] getStyreneResP()
    {
        return styreneResP;
    }

    public void setStyreneResP(String styreneResP[])
    {
        this.styreneResP = styreneResP;
    }

    public String[] getStyreneRes()
    {
        return styreneRes;
    }

    public void setStyreneRes(String styreneRes[])
    {
        this.styreneRes = styreneRes;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    public Teams getTeam()
    {
        return team;
    }

    public void setTeam(Teams team)
    {
        this.team = team;
    }

    private static final long serialVersionUID = 0xa91e1cf38cddbb8dL;
    String reactorTemper[];
    String benQuality[];
    String waterQuality[];
    String hyLayer[];
    String waterLayer[];
    String benResP[];
    String benRes[];
    String styreneResP[];
    String styreneRes[];
    int tid;
    Teams team;
}
