// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StyreneData.java

package org.jevy.service;

import java.util.*;
import org.jevy.model.*;
import org.jevy.resmodel.StyreneResModel;
import org.jevy.util.RetainedFraction;

public class StyreneData
{

    public StyreneData()
    {
        ph2o = 0.99406000000000005D;
        pben = 0.86699999999999999D;
        Mh2o = 18.02D;
        Mben = 106.17D;
        Mstyrene = 104.17D;
    }

    public List getStyreneData(int tid)
    {
        List list = new ArrayList();
        Teams team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        Set datas = team.getDatas();
        RetainedFraction rf = new RetainedFraction();
        StyreneResModel model;
        for(Iterator iterator = datas.iterator(); iterator.hasNext(); list.add(model))
        {
            Data da = (Data)iterator.next();
            model = new StyreneResModel();
            model.setReactorTemper(da.getData1().doubleValue());
            model.setBenQuality(rf.retained4(da.getData2().doubleValue() * pben));
            model.setWaterQuality(rf.retained4(da.getData3().doubleValue() * ph2o));
            model.setHyLayer(da.getData4().doubleValue());
            model.setWaterLayer(da.getData5().doubleValue());
            model.setBenResP(da.getData6().doubleValue());
            model.setBenRes(rf.retained4((da.getData6().doubleValue() * da.getData2().doubleValue() * pben) / 100D));
            model.setStyreneResP(da.getData8().doubleValue());
            model.setStyreneRes(rf.retained4((da.getData8().doubleValue() * da.getData2().doubleValue() * pben) / 100D));
            double RF = getRF(da.getData2().doubleValue() * pben, da.getData4().doubleValue(), da.getData6().doubleValue());
            double FF = getFF(da.getData2().doubleValue() * pben);
            double P = getP(da.getData4().doubleValue(), da.getData8().doubleValue());
            double A = getA(RF, FF);
            double S = getS(P, RF);
            model.setA(rf.retained4(A));
            model.setS(rf.retained4(S));
            model.setY(rf.retained4(getY(A, S)));
            model.setDid(da.getDid().intValue());
        }

        return list;
    }

    public double getRF(double benQuality, double hyLayer, double benResP)
    {
        return benQuality - (hyLayer * benResP) / 100D;
    }

    public double getP(double hyLayer, double styreneResP)
    {
        return (hyLayer * styreneResP) / 100D;
    }

    public double getFF(double benQuality)
    {
        return benQuality;
    }

    public double getA(double RF, double FF)
    {
        return RF / FF;
    }

    public double getS(double P, double RF)
    {
        return P / Mstyrene / (RF / Mben);
    }

    public double getY(double A, double S)
    {
        return A * S;
    }

    String reactorTemper[];
    String benQuality[];
    String waterQuality[];
    String hyLayer[];
    String waterLayer[];
    String benResP[];
    String benRes[];
    String styreneResP[];
    String styreneRes[];
    double ph2o;
    double pben;
    double Mh2o;
    double Mben;
    double Mstyrene;
}
