// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EthanolVaporLiquidEquilibrium.java

package org.jevy.util;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.XYSeries;

// Referenced classes of package org.jevy.util:
//            FittingCurve

public class EthanolVaporLiquidEquilibrium extends ActionSupport
{

    public EthanolVaporLiquidEquilibrium()
    {
        fc = new FittingCurve();
    }

    public XYSeries getEthanolVaporLiquidLiquidSeries()
    {
        XYSeries ser = new XYSeries((new StringBuilder(String.valueOf(getText("liquidPhase")))).append(getText("theoryData")).toString());
        fc.setTimes(7);
        fc.setData(getEthanolVaporLiquidLiquid());
        ser = fc.getXYSeries(ser);
        return ser;
    }

    public XYSeries getEthanolVaperLiquidLiquidPoint()
    {
        XYSeries ser2 = new XYSeries((new StringBuilder(String.valueOf(getText("liquidPhase")))).append(getText("theoryData")).toString());
        for(int i = 0; i < ((List)getEthanolVaporLiquidLiquid().get(0)).size(); i++)
            ser2.add((Number)((List)getEthanolVaporLiquidLiquid().get(1)).get(i), (Number)((List)getEthanolVaporLiquidLiquid().get(0)).get(i));

        return ser2;
    }

    public XYSeries getEthanolVaporLiquidGasSeries()
    {
        XYSeries ser = new XYSeries((new StringBuilder(String.valueOf(getText("gasPhase")))).append(getText("theoryData")).toString());
        fc.setTimes(5);
        fc.setData(getEthanolVaporLiquidGas());
        ser = fc.getXYSeries(ser);
        return ser;
    }

    public XYSeries getEthanolVaperLiquidGasPoint()
    {
        XYSeries ser2 = new XYSeries((new StringBuilder(String.valueOf(getText("gasPhase")))).append(getText("theoryData")).toString());
        for(int i = 0; i < ((List)getEthanolVaporLiquidGas().get(0)).size(); i++)
            ser2.add((Number)((List)getEthanolVaporLiquidGas().get(1)).get(i), (Number)((List)getEthanolVaporLiquidGas().get(0)).get(i));

        return ser2;
    }

    public List getEthanolVaporLiquidLiquid()
    {
        double temper[] = {
            100D, 95.5D, 89D, 86.700000000000003D, 85.299999999999997D, 84.099999999999994D, 82.700000000000003D, 82.299999999999997D, 81.5D, 80.700000000000003D, 
            79.799999999999997D, 79.700000000000003D, 79.299999999999997D, 78.739999999999995D, 78.409999999999997D, 78.150000000000006D
        };
        double liquid[] = {
            0.0D, 0.019D, 0.072099999999999997D, 0.096600000000000005D, 0.12379999999999999D, 0.1661D, 0.23369999999999999D, 0.26079999999999998D, 0.32729999999999998D, 0.39650000000000002D, 
            0.50790000000000002D, 0.51980000000000004D, 0.57320000000000004D, 0.67630000000000001D, 0.74719999999999998D, 0.89429999999999998D
        };
        List listTemper = ArrayASList(temper);
        List listLiquid = ArrayASList(liquid);
        List list = new ArrayList();
        list.add(listTemper);
        list.add(listLiquid);
        return list;
    }

    public List getEthanolVaporLiquidGas()
    {
        double temper[] = {
            100D, 95.5D, 89D, 86.700000000000003D, 85.299999999999997D, 84.099999999999994D, 82.700000000000003D, 82.299999999999997D, 81.5D, 80.700000000000003D, 
            79.799999999999997D, 79.700000000000003D, 79.299999999999997D, 78.739999999999995D, 78.409999999999997D, 78.150000000000006D
        };
        double gas[] = {
            0.0D, 0.17000000000000001D, 0.3891D, 0.4375D, 0.47039999999999998D, 0.50890000000000002D, 0.54449999999999998D, 0.55800000000000005D, 0.58260000000000001D, 0.61219999999999997D, 
            0.65639999999999998D, 0.65990000000000004D, 0.68410000000000004D, 0.73850000000000005D, 0.78149999999999997D, 0.89429999999999998D
        };
        List listTemper = ArrayASList(temper);
        List listGas = ArrayASList(gas);
        List list = new ArrayList();
        list.add(listTemper);
        list.add(listGas);
        return list;
    }

    public List ArrayASList(double data[])
    {
        List list = new ArrayList();
        for(int i = 0; i < data.length; i++)
            list.add(Double.valueOf(data[i]));

        return list;
    }

    public static void main(String args1[])
    {
    }

    private static final long serialVersionUID = 1L;
    FittingCurve fc;
}
