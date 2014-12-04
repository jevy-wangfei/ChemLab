// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GasData.java

package org.jevy.service;

import com.opensymphony.xwork2.ActionContext;
import java.util.*;
import org.jevy.model.*;
import org.jevy.resmodel.GasResModel;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.RetainedFraction;

public class GasData
{

    public GasData()
    {
        A = 12.291700000000001D;
        B = 3803.98D;
        C = -41.68D;
        AA = 11.683400000000001D;
        BB = 3816.4400000000001D;
        CC = -46.130000000000003D;
        g12g11 = 932.53999999999996D;
        g21g22 = 4189.6599999999999D;
    }

    public List getExperimentData(Teams team)
    {
        if(team == null)
        {
            ActionContext ctx = ActionContext.getContext();
            Student student = (Student)ctx.getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(1, student);
        }
        Set da = team.getDatas();
        List list0 = new ArrayList();
        GasResModel model;
        for(Iterator iterator = da.iterator(); iterator.hasNext(); list0.add(model))
        {
            Data data = (Data)iterator.next();
            double sysPress = data.getData11().doubleValue();
            double balanceTemper = data.getData1().doubleValue();
            double g1 = data.getData2().doubleValue();
            double g2 = data.getData3().doubleValue();
            double g3 = data.getData4().doubleValue();
            double ngas = data.getData5().doubleValue();
            double yy = data.getData6().doubleValue();
            double temp1 = 18D * yy * 0.01D * (g3 - g1);
            double temp2 = 18D * (g3 - g2) - 28D * yy * 0.01D * (g2 - g1);
            double y = (temp1 / temp2) * 100D;
            double nliquid = data.getData8().doubleValue();
            double x = data.getData9().doubleValue();
            double V1 = getVolEthanol(balanceTemper);
            double V2 = getVolWater(balanceTemper);
            double R = 8.3140000000000001D;
            double T = 273.14999999999998D + balanceTemper;
            double M12 = (V2 * Math.exp(-g12g11 / (R * T))) / V1;
            double M21 = (V1 * Math.exp(-g21g22 / (R * T))) / V2;
            double x1 = x * 0.01D;
            double x2 = 1.0D - x1;
            double r1cal = Math.pow(2.7182818284590451D, -Math.log(x1 + M12 * x2) + x2 * (M12 / (x1 + M12 * x2) - M21 / (M12 * x1 + x2)));
            double r2cal = Math.pow(2.7182818284590451D, -Math.log(x2 + M21 * x1) + x1 * (M21 / (x2 + M21 * x1) - M12 / (M12 * x2 + x1)));
            double P1 = getP0Ethanol(T);
            double P2 = getP0Water(T);
            double y1cal = (r1cal * x1 * P1) / sysPress;
            double y2cal = (r2cal * x2 * P2) / sysPress;
            double r1ex = (sysPress * y * 0.01D) / (x1 * P1);
            double r2ex = (sysPress * (1.0D - y * 0.01D)) / (x2 * P2);
            double y1ex = y * 0.01D;
            RetainedFraction refr = new RetainedFraction();
            model = new GasResModel();
            model.setBalanceTemper(balanceTemper);
            model.setSysPress(sysPress * 0.001D);
            model.setG1(refr.retained4(g1));
            model.setG2(refr.retained4(g2));
            model.setG3(refr.retained4(g3));
            model.setNgas(refr.retained4(ngas));
            model.setYy(refr.retained4(yy));
            model.setY(refr.retained4(y));
            model.setNliquid(nliquid);
            model.setX1(refr.retained4(x));
            model.setY1ex(refr.retained4(y1ex));
            model.setY1cal(refr.retained4(y1cal));
            model.setR1ex(refr.retained4(r1ex));
            model.setR1cal(refr.retained4(r1cal));
            model.setR2ex(refr.retained4(r2ex));
            model.setR2cal(refr.retained4(r2cal));
            model.setDid(data.getDid().intValue());
        }

        return list0;
    }

    public List getExperimentData2(Teams team)
    {
        if(team == null)
        {
            ActionContext ctx = ActionContext.getContext();
            Student student = (Student)ctx.getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(1, student);
        }
        Set da = team.getDatas();
        List list0 = new ArrayList();
        List list1;
        for(Iterator iterator = da.iterator(); iterator.hasNext(); list0.add(list1))
        {
            Data data = (Data)iterator.next();
            list1 = new ArrayList();
            double sysPress = data.getData11().doubleValue();
            double balanceTemper = data.getData1().doubleValue();
            double g1 = data.getData2().doubleValue();
            double g2 = data.getData3().doubleValue();
            double g3 = data.getData4().doubleValue();
            double ngas = data.getData5().doubleValue();
            double yy = data.getData6().doubleValue();
            double temp1 = 18D * yy * 0.01D * (g3 - g1);
            double temp2 = 18D * (g3 - g2) - 28D * yy * 0.01D * (g2 - g1);
            double y = (temp1 / temp2) * 100D;
            double nliquid = data.getData8().doubleValue();
            double x = data.getData9().doubleValue();
            double V1 = getVolEthanol(balanceTemper);
            double V2 = getVolWater(balanceTemper);
            double R = 8.3140000000000001D;
            double T = 273.14999999999998D + balanceTemper;
            double M12 = (V2 * Math.exp(-g12g11 / (R * T))) / V1;
            double M21 = (V1 * Math.exp(-g21g22 / (R * T))) / V2;
            double x1 = x * 0.01D;
            double x2 = 1.0D - x1;
            double r1cal = Math.pow(2.7182818284590451D, -Math.log(x1 + M12 * x2) + x2 * (M12 / (x1 + M12 * x2) - M21 / (M12 * x1 + x2)));
            double r2cal = Math.pow(2.7182818284590451D, -Math.log(x2 + M21 * x1) + x1 * (M21 / (x2 + M21 * x1) - M12 / (M12 * x2 + x1)));
            double P1 = getP0Ethanol(T);
            double P2 = getP0Water(T);
            double y1cal = (r1cal * x1 * P1) / sysPress;
            double y2cal = (r2cal * x2 * P2) / sysPress;
            double r1ex = (sysPress * y * 0.01D) / (x1 * P1);
            double r2ex = (sysPress * (1.0D - y * 0.01D)) / (x2 * P2);
            double y1ex = y * 0.01D;
            RetainedFraction refr = new RetainedFraction();
            list1.add(Double.valueOf(balanceTemper));
            list1.add(Double.valueOf(refr.retained4(y * 0.01D)));
            list1.add(Double.valueOf(refr.retained4(x1)));
            list1.add(Double.valueOf(refr.retained4(y1ex)));
            list1.add(Double.valueOf(refr.retained4(y1cal)));
            list1.add(Double.valueOf(refr.retained4(r1ex)));
            list1.add(Double.valueOf(refr.retained4(r1cal)));
            list1.add(Double.valueOf(refr.retained4(r2ex)));
            list1.add(Double.valueOf(refr.retained4(r2cal)));
        }

        return list0;
    }

    public double getVolEthanol(double temper)
    {
        double res = 0.0D;
        if(temper >= 80D && temper <= 90D)
            res = 61.969999999999999D + ((temper - 80D) * 1.0399999999999991D) / 10D;
        if(temper >= 90D && temper <= 100D)
            res = 63.009999999999998D + ((temper - 90D) * 1.1100000000000065D) / 10D;
        return res;
    }

    public double getVolWater(double temper)
    {
        double res = 0.0D;
        if(temper >= 80D && temper <= 90D)
            res = 18.52D + ((temper - 80D) * 0.12999999999999901D) / 10D;
        if(temper >= 90D && temper <= 100D)
            res = 18.649999999999999D + ((temper - 90D) * 0.14000000000000057D) / 10D;
        return res;
    }

    public double getP0Ethanol(double T)
    {
        return Math.pow(2.7182818284590451D, A - B / (C + T)) * 100D;
    }

    public double getP0Water(double T)
    {
        return Math.pow(2.7182818284590451D, AA - BB / (CC + T)) * 100D;
    }

    double A;
    double B;
    double C;
    double AA;
    double BB;
    double CC;
    double g12g11;
    double g21g22;
}
