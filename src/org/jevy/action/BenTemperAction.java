// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BenTemperAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.StringParseDouble;

public class BenTemperAction extends ActionSupport
{

    public BenTemperAction()
    {
    }

    public String execute()
    {
        StringParseDouble sPd = new StringParseDouble();
        Double temper1[] = sPd.parse(this.temper1);
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
        for(int k = 0; k < temper1.length; k++)
        {
            if(temper1[k].doubleValue() != 0.0D)
                continue;
            temperLength = k;
            break;
        }

        for(int i = 0; i < temperLength; i++)
        {
            data.setLabel((new StringBuilder("benT")).append(i).toString());
            data.setData1(Double.valueOf(time1));
            data.setData2(Double.valueOf(time2));
            data.setData3(Double.valueOf(time3));
            data.setData4(Double.valueOf(time4));
            data.setData5(Double.valueOf(time5));
            data.setData6(temper1[i]);
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

    public String[] getTemper1()
    {
        return temper1;
    }

    public void setTemper1(String temper1[])
    {
        this.temper1 = temper1;
    }

    public double getTime1()
    {
        return time1;
    }

    public void setTime1(double time1)
    {
        this.time1 = time1;
    }

    public double getTime2()
    {
        return time2;
    }

    public void setTime2(double time2)
    {
        this.time2 = time2;
    }

    public double getTime3()
    {
        return time3;
    }

    public void setTime3(double time3)
    {
        this.time3 = time3;
    }

    public double getTime4()
    {
        return time4;
    }

    public void setTime4(double time4)
    {
        this.time4 = time4;
    }

    public double getTime5()
    {
        return time5;
    }

    public void setTime5(double time5)
    {
        this.time5 = time5;
    }

    public String[] getAb1()
    {
        return ab1;
    }

    public void setAb1(String ab1[])
    {
        this.ab1 = ab1;
    }

    public String[] getAb2()
    {
        return ab2;
    }

    public void setAb2(String ab2[])
    {
        this.ab2 = ab2;
    }

    public String[] getAb3()
    {
        return ab3;
    }

    public void setAb3(String ab3[])
    {
        this.ab3 = ab3;
    }

    public String[] getAb4()
    {
        return ab4;
    }

    public void setAb4(String ab4[])
    {
        this.ab4 = ab4;
    }

    public String[] getAb5()
    {
        return ab5;
    }

    public void setAb5(String ab5[])
    {
        this.ab5 = ab5;
    }

    private static final long serialVersionUID = 0x1ba7913e2cd26b66L;
    public String temper1[];
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
