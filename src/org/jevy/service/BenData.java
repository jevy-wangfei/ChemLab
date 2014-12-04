// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BenData.java

package org.jevy.service;

import java.util.List;
import org.jevy.model.DataDAO;

public class BenData
{

    public BenData()
    {
        dataDAO = new DataDAO();
    }

    public List getBenTemperData(int tid)
    {
        return dataDAO.getBenTemperData(tid);
    }

    public List getBenQualityData(int tid)
    {
        return dataDAO.getBenQualityData(tid);
    }

    DataDAO dataDAO;
}
