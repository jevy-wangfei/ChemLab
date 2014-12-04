// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SaltData.java

package org.jevy.service;

import java.util.*;
import org.jevy.model.*;
import org.jevy.resmodel.SaltResModel;
import org.jevy.util.RetainedFraction;

public class SaltData
{

    public SaltData()
    {
    }

    public List getSaltData(int tid)
    {
        List list = new ArrayList();
        Teams team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        Set datas = team.getDatas();
        SaltResModel saltRes;
        for(Iterator iterator = datas.iterator(); iterator.hasNext(); list.add(saltRes))
        {
            Data da = (Data)iterator.next();
            saltRes = new SaltResModel();
            saltRes.setNa(da.getData1().doubleValue());
            saltRes.setNh(da.getData2().doubleValue());
            saltRes.setW(da.getData3().doubleValue());
            saltRes.setAg(da.getData4().doubleValue());
            saltRes.setOh(da.getData5().doubleValue());
            saltRes.setCag(da.getData6().doubleValue());
            saltRes.setCoh(da.getData7().doubleValue());
            saltRes.setResNa(getResNa(da.getData4().doubleValue(), da.getData5().doubleValue(), da.getData3().doubleValue(), da.getData6().doubleValue(), da.getData7().doubleValue()));
            saltRes.setResNh(getResNh(da.getData5().doubleValue(), da.getData3().doubleValue(), da.getData7().doubleValue()));
            saltRes.setDid(da.getDid().intValue());
        }

        return list;
    }

    public double getResNa(double ag, double oh, double w, double cag, double coh)
    {
        return (new RetainedFraction()).retained4((1461D * (cag * ag - coh * oh)) / (w * 10D));
    }

    public double getResNh(double oh, double w, double coh)
    {
        return (new RetainedFraction()).retained4((1337.25D * coh * oh) / (w * 10D));
    }
}
