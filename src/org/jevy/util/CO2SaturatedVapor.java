// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CO2SaturatedVapor.java

package org.jevy.util;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.XYSeries;

// Referenced classes of package org.jevy.util:
//            FittingCurve

public class CO2SaturatedVapor extends ActionSupport
{

    public CO2SaturatedVapor()
    {
        fc = new FittingCurve();
    }

    public XYSeries getCO2XYSeries20()
    {
        List standard20 = getCO2Data20();
        List listConvert = new ArrayList();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        for(int j = 0; j < ((List)standard20.get(1)).size(); j++)
            if(((Double)((List)standard20.get(1)).get(j)).doubleValue() >= 5D)
            {
                list1.add((Double)((List)standard20.get(0)).get(j));
                list2.add((Double)((List)standard20.get(1)).get(j));
            }

        listConvert.add(list1);
        listConvert.add(list2);
        XYSeries s11 = new XYSeries((new StringBuilder("20\u2103")).append(getText("standardLine")).toString());
        if(list2.size() <= 4 && list2.size() > 2)
        {
            fc.setTimes(2);
            fc.setData(listConvert);
            s11 = fc.getXYSeries(s11);
        } else
        {
            fc.setTimes(3);
            fc.setData(listConvert);
            s11 = fc.getXYSeries(s11);
        }
        listConvert.clear();
        list1.clear();
        list2.clear();
        list1.add(Double.valueOf(5.8716299999999997D));
        list2.add(Double.valueOf(5D));
        list1.add(Double.valueOf(5.9000000000000004D));
        list2.add(Double.valueOf(3.1000000000000001D));
        list1.add(Double.valueOf(5.8716299999999997D));
        list2.add(Double.valueOf(1.308182D));
        listConvert.add(list1);
        listConvert.add(list2);
        fc.setTimes(1);
        fc.setData(listConvert);
        s11 = fc.getXYSeries(s11);
        List listConvert2 = new ArrayList();
        List list12 = new ArrayList();
        List list22 = new ArrayList();
        for(int j = 0; j < ((List)standard20.get(1)).size(); j++)
            if(((Double)((List)standard20.get(1)).get(j)).doubleValue() <= 1.308182D)
            {
                list12.add((Double)((List)standard20.get(0)).get(j));
                list22.add((Double)((List)standard20.get(1)).get(j));
            }

        listConvert2.add(list12);
        listConvert2.add(list22);
        FittingCurve fc2 = new FittingCurve();
        if(list22.size() <= 4)
        {
            fc2.setTimes(2);
            fc2.setData(listConvert);
            s11 = fc2.getXYSeries(s11);
        } else
        {
            fc2.setTimes(3);
            fc2.setData(listConvert2);
            s11 = fc2.getXYSeries(s11);
        }
        return s11;
    }

    public XYSeries getCO2XYSeriesSaturatedVapor()
    {
        List vapor = getSaturatedVapor();
        fc.setTimes(7);
        fc.setData(vapor);
        XYSeries serVapor = new XYSeries((new StringBuilder(String.valueOf(getText("vapor")))).append(getText("votume")).toString());
        serVapor = fc.getXYSeries(serVapor);
        return serVapor;
    }

    public XYSeries getCO2Series31()
    {
        List sat31 = getCO2Data31();
        List listConvert31 = new ArrayList();
        List list131 = new ArrayList();
        List list231 = new ArrayList();
        for(int k = 0; k < ((List)sat31.get(1)).size(); k++)
            if(((Double)((List)sat31.get(1)).get(k)).doubleValue() <= 1.59091D)
            {
                list131.add((Double)((List)sat31.get(0)).get(k));
                list231.add((Double)((List)sat31.get(1)).get(k));
            }

        listConvert31.add(list131);
        listConvert31.add(list231);
        fc.setTimes(4);
        fc.setData(listConvert31);
        XYSeries ser311 = new XYSeries((new StringBuilder("31\u2103")).append(getText("standardLine")).toString());
        ser311 = fc.getXYSeries(ser311);
        list131.clear();
        list231.clear();
        listConvert31.clear();
        for(int k = 0; k < ((List)sat31.get(0)).size(); k++)
            if(((Double)((List)sat31.get(1)).get(k)).doubleValue() >= 1.59091D)
            {
                list131.add((Double)((List)sat31.get(0)).get(k));
                list231.add((Double)((List)sat31.get(1)).get(k));
            }

        listConvert31.add(list131);
        listConvert31.add(list231);
        fc.setTimes(4);
        fc.setData(listConvert31);
        ser311 = fc.getXYSeries(ser311);
        return ser311;
    }

    public XYSeries getCO2Series40()
    {
        List sat40 = getCO2Data40();
        fc.setTimes(3);
        fc.setData(sat40);
        XYSeries ser40 = new XYSeries((new StringBuilder("40\u2103")).append(getText("standardLine")).toString());
        ser40 = fc.getXYSeries(ser40);
        return ser40;
    }

    public List getCO2Data20()
    {
        double press[] = {
            2.5D, 3D, 4D, 5D, 5.8716299999999997D, 5.8716299999999997D, 6.2000000000000002D, 8D, 10D, 15D, 
            20D, 30D, 40D
        };
        double vapor[] = {
            18.879999999999999D, 15.1D, 10.25D, 7.1100000000000003D, 5D, 1.308182D, 1.2989999999999999D, 1.2145999999999999D, 1.1722999999999999D, 1.1021000000000001D, 
            1.0631999999999999D, 1.0108999999999999D, 0.97709999999999997D
        };
        List listPress = ArrayASList(press);
        List listVapor = ArrayASList(vapor);
        List list = new ArrayList();
        list.add(listPress);
        list.add(listVapor);
        return list;
    }

    public List getCO2Data50()
    {
        double press[] = {
            2D, 2.5D, 3D, 4D, 5D, 6D, 8D, 10D, 15D, 20D, 
            30D, 40D
        };
        double vapor[] = {
            28.07D, 21.93D, 17.82D, 12.66D, 9.4990000000000006D, 7.3860000000000001D, 4.5510000000000002D, 2.581D, 1.3779999999999999D, 1.3220000000000001D, 
            1.119D, 1.073D
        };
        List listPress = ArrayASList(press);
        List listVapor = ArrayASList(vapor);
        List list = new ArrayList();
        list.add(listPress);
        list.add(listVapor);
        return list;
    }

    public List getCO2Data31()
    {
        double press[] = {
            13.17225D, 12.159000000000001D, 11.652575000000001D, 11.14575D, 10.1325D, 9.6258750000000006D, 9.1192499999999992D, 8.6126249999999995D, 8.1059999999999999D, 7.5993750000000002D, 
            7.5780500000000002D, 7.4467249999999998D, 7.3764599999999998D, 7.3561589999999999D, 7.3460619999999999D, 7.3257969999999997D, 7.2953999999999999D, 7.2244719999999996D, 7.1434119999999997D, 7.0420870000000004D, 
            6.8901000000000003D, 6.8394370000000002D, 6.7887750000000002D, 6.636787D, 6.4847999999999999D, 6.3834749999999998D, 6.2821499999999997D, 5.9781750000000002D, 5.8261880000000001D, 5.5728749999999998D, 
            5.3702249999999996D, 5.1675750000000003D
        };
        double vapor[] = {
            1.21136D, 1.21136D, 1.21136D, 1.25D, 1.2727269999999999D, 1.318182D, 1.34091D, 1.3636360000000001D, 1.4090910000000001D, 1.5313639999999999D, 
            1.59091D, 1.818182D, 2.2159D, 2.4999699999999998D, 2.7272400000000001D, 2.95451D, 3.1817799999999998D, 3.4090500000000001D, 3.63632D, 3.8635899999999999D, 
            4.0908600000000002D, 4.31813D, 4.5453999999999999D, 4.7726699999999997D, 4.9999399999999996D, 5.2272100000000004D, 5.4544800000000002D, 5.9090999999999996D, 6.3636359999999996D, 6.8181799999999999D, 
            7.2727269999999997D, 7.7272730000000003D
        };
        List listPress = ArrayASList(press);
        List listVapor = ArrayASList(vapor);
        List list = new ArrayList();
        list.add(listPress);
        list.add(listVapor);
        return list;
    }

    public List getCO2Data40()
    {
        double press[] = {
            2.5D, 3D, 4D, 5D, 6D, 8D, 10D
        };
        double vapor[] = {
            20.949999999999999D, 16.960000000000001D, 11.91D, 8.8230000000000004D, 6.6870000000000003D, 3.5670000000000002D, 1.6419999999999999D
        };
        List listPress = ArrayASList(press);
        List listVapor = ArrayASList(vapor);
        List list = new ArrayList();
        list.add(listPress);
        list.add(listVapor);
        return list;
    }

    public List getSaturatedVapor()
    {
        double press[] = {
            3.0398000000000001D, 4.0529999999999999D, 4.5595999999999997D, 5.0663D, 5.5728999999999997D, 5.8769D, 6.0796000000000001D, 7.0027999999999997D, 7.1089000000000002D, 7.2061000000000002D, 
            7.2000000000000002D, 7.3764599999999998D, 7.3561949999999996D, 7.3460599999999996D, 7.2953999999999999D, 7.1940999999999997D, 7.0927499999999997D, 6.9913999999999996D, 6.8901000000000003D, 6.78878D, 
            6.5861000000000001D, 6.3834749999999998D, 6.2821499999999997D, 5.8768500000000001D, 5.775525D, 5.6235369999999998D, 5.3702249999999996D, 5.2689000000000004D, 5.1675750000000003D, 5.0409189999999997D, 
            4.8635999999999999D, 4.8129369999999998D, 4.6862810000000001D, 4.6102869999999996D, 4.4583000000000004D, 4.2999999999999998D
        };
        double vapor[] = {
            1.0D, 1.0909D, 1.1364000000000001D, 1.1818D, 1.2726999999999999D, 1.3182D, 1.3635999999999999D, 1.5900000000000001D, 1.6664000000000001D, 1.8182D, 
            2D, 2.2159D, 2.2726999999999999D, 2.5D, 2.7271999999999998D, 2.9544999999999999D, 3.1818D, 3.4091D, 3.6364000000000001D, 3.8635899999999999D, 
            4.0908600000000002D, 4.31813D, 4.5453999999999999D, 4.9999399999999996D, 5.2272100000000004D, 5.4544800000000002D, 5.6817500000000001D, 5.9090199999999999D, 6.1362899999999998D, 6.3635599999999997D, 
            6.5908300000000004D, 6.8181000000000003D, 7.0453700000000001D, 7.27264D, 7.4999099999999999D, 7.7271799999999997D
        };
        List listPress = ArrayASList(press);
        List listVapor = ArrayASList(vapor);
        List list = new ArrayList();
        list.add(listPress);
        list.add(listVapor);
        return list;
    }

    public List ArrayASList(double data[])
    {
        List list = new ArrayList();
        for(int i = 0; i < data.length; i++)
            list.add(Double.valueOf(data[i]));

        return list;
    }

    public List co2SaturatedVapor()
    {
        List co2Presure = new ArrayList();
        List co2Volume = new ArrayList();
        List co2SaturatedVapor = new ArrayList();
        double A = 7.7633099999999997D;
        double B = 1566.0799999999999D;
        double C = 97.870000000000005D;
        double Ps = 0.0D;
        double v = 0.0D;
        for(int temper = 150; temper <= 450; temper++)
        {
            double temp = (double)temper * 0.10000000000000001D + 273.14999999999998D;
            Ps = Math.pow(10D, A - B / (temp + C));
            v = ((8.3140000000000001D * temp) / Ps) * 0.01D;
            co2Presure.add(Double.valueOf(Ps / 1000D));
            co2Volume.add(Double.valueOf(v));
        }

        co2SaturatedVapor.add(co2Volume);
        co2SaturatedVapor.add(co2Presure);
        return co2SaturatedVapor;
    }

    private static final long serialVersionUID = 0x13eea9280940c036L;
    FittingCurve fc;
}
