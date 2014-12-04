// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TernaryWaterSalt.java

package org.jevy.util;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.XYSeries;

// Referenced classes of package org.jevy.util:
//            FittingCurve

public class TernaryWaterSalt extends ActionSupport
{

    public TernaryWaterSalt()
    {
    }

    public XYSeries getSaltCopiesPoint()
    {
        XYSeries ser = new XYSeries(getText("theoryData"));
        List Na = (List)getSaltCopies().get(0);
        List Nh = (List)getSaltCopies().get(1);
        for(int i = 0; i < Na.size(); i++)
            ser.add((Number)Nh.get(i), (Number)Na.get(i));

        return ser;
    }

    public XYSeries getSaltCopiesPoint2()
    {
        XYSeries ser = new XYSeries(getText("theoryData"));
        List Na = (List)getSaltCopies2().get(0);
        List Nh = (List)getSaltCopies2().get(1);
        for(int i = 0; i < Na.size(); i++)
            ser.add((Number)Nh.get(i), (Number)Na.get(i));

        return ser;
    }

    public XYSeries getSaltCopiesXYSeries()
    {
        XYSeries ser = new XYSeries(getText("theoryData"));
        FittingCurve fc = new FittingCurve();
        fc.setTimes(2);
        fc.setData(getSaltCopies());
        return fc.getXYSeries(ser);
    }

    public XYSeries getSaltCopiesXYSeries2()
    {
        XYSeries ser = new XYSeries(getText("theoryData"));
        FittingCurve fc = new FittingCurve();
        fc.setTimes(2);
        fc.setData(getSaltCopies2());
        return fc.getXYSeries(ser);
    }

    public List getSaltCopies()
    {
        double Na[] = {
            25.780000000000001D, 21.050000000000001D, 18.93D, 17.66D, 17.210000000000001D, 16.649999999999999D
        };
        double Nh[] = {
            0.0D, 7.915D, 12.380000000000001D, 14.93D, 16.390000000000001D, 17.420000000000002D
        };
        List NaList = ArrayASList(Na);
        List NhList = ArrayASList(Nh);
        List list = new ArrayList();
        list.add(NaList);
        list.add(NhList);
        return list;
    }

    public List getSaltCopies2()
    {
        double Na[] = {
            16.649999999999999D, 9.9640000000000004D, 7.2960000000000003D, 0.0D
        };
        double Nh[] = {
            17.420000000000002D, 20.98D, 22.879999999999999D, 28.559999999999999D
        };
        List NaList = ArrayASList(Na);
        List NhList = ArrayASList(Nh);
        List list = new ArrayList();
        list.add(NaList);
        list.add(NhList);
        return list;
    }

    public List ArrayASList(double data[])
    {
        List list = new ArrayList();
        for(int i = 0; i < data.length; i++)
            list.add(Double.valueOf(data[i]));

        return list;
    }
}
