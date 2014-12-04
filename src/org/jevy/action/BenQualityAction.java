// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BenQualityAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.StringParseDouble;

public class BenQualityAction extends ActionSupport
{

    public BenQualityAction()
    {
    }

    public String execute()
    {
        StringParseDouble sPd = new StringParseDouble();
        Double g[] = sPd.parse(this.g);
        Double ab1[] = sPd.parse(this.ab1);
        Double ab2[] = sPd.parse(this.ab2);
        Double ab3[] = sPd.parse(this.ab3);
        Double ab4[] = sPd.parse(this.ab4);
        Double ab5[] = sPd.parse(this.ab5);
        Student stu = (Student)ActionContext.getContext().getSession().get("student");
        System.out.println((new StringBuilder("BenTemperAction.execute() student:")).append(stu).toString());
        org.jevy.model.Teams team = (new GetTeamByStudent()).getTeams(4, stu);
        System.out.println((new StringBuilder("BenTemperAction.execute() team:")).append(team).toString());
        Data data = new Data();
        DataDAO dataDAO = new DataDAO();
        int temperLength = 0;
        for(int k = 0; k < g.length; k++)
        {
            if(g[k].doubleValue() != 0.0D)
                continue;
            temperLength = k;
            break;
        }

        for(int i = 0; i < temperLength; i++)
        {
            data.setLabel((new StringBuilder("benQ")).append(i).toString());
            data.setData1(Double.valueOf(time1));
            data.setData2(Double.valueOf(time2));
            data.setData3(Double.valueOf(time3));
            data.setData4(Double.valueOf(time4));
            data.setData5(Double.valueOf(time5));
            data.setData6(g[i]);
            data.setData7(ab1[i]);
            data.setData8(ab2[i]);
            data.setData9(ab3[i]);
            data.setData10(ab4[i]);
            data.setData11(ab5[i]);
            data.setTeams(team);
            dataDAO.save(data);
        }

        return "success";
    }

    public String g[];
    public double time1;
    public double time2;
    public double time3;
    public double time4;
    public double time5;
    public String ab1[];
    public String ab2[];
    public String ab3[];
    public String ab4[];
    public String ab5[];
}
