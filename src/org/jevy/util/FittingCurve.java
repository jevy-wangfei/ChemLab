// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FittingCurve.java

package org.jevy.util;

import java.util.*;
import org.jfree.data.xy.XYSeries;

// Referenced classes of package org.jevy.util:
//            ListMaxMin, CO2SaturatedVapor

public class FittingCurve
{

    public FittingCurve()
    {
        list = null;
        times = 2;
    }

    public List getCoefficient()
    {
        List res = getCurveEquation((List)list.get(1), (List)list.get(0), times);
        return res;
    }

    public XYSeries getXYSeries(XYSeries s1)
    {
        List list = getCoefficient();
        ListMaxMin maxMin = new ListMaxMin();
        List vList = (List)this.list.get(1);
        double max = maxMin.getMax(vList);
        double min = maxMin.getMin(vList);
        double step = max - min;
        double x = min;
        double step2 = step / 800D;
        for(int i = 0; i < 800; i++)
        {
            x += step2;
            int num = list.size() - 1;
            double temp = 0.0D;
            for(int j = 0; j < list.size(); j++)
                temp += Math.pow(x, num - j) * ((Double)list.get(j)).doubleValue();

            s1.add(x, temp);
        }

        return s1;
    }

    public double getPressOfVapor(double vapor)
    {
        double res = 0.0D;
        List saturatedVapor = (new CO2SaturatedVapor()).getSaturatedVapor();
        List coefficient = getCurveEquation((List)saturatedVapor.get(1), (List)saturatedVapor.get(0), 4);
        int num = coefficient.size() - 1;
        for(int j = 0; j < coefficient.size(); j++)
            res += Math.pow(vapor, num - j) * ((Double)coefficient.get(j)).doubleValue();

        return res;
    }

    public List getCurveEquation(List x, List y, int m)
    {
        if(x.size() != y.size() || x.size() <= m + 1)
            return new ArrayList();
        List result = new ArrayList();
        List S = new ArrayList();
        List T = new ArrayList();
        for(int i = 0; i <= 2 * m; i++)
        {
            double si = 0.0D;
            for(Iterator iterator = x.iterator(); iterator.hasNext();)
            {
                double xx = ((Double)iterator.next()).doubleValue();
                si += Math.pow(xx, i);
            }

            S.add(Double.valueOf(si));
        }

        for(int j = 0; j <= m; j++)
        {
            double ti = 0.0D;
            for(int k = 0; k < y.size(); k++)
                ti += ((Double)y.get(k)).doubleValue() * Math.pow(((Double)x.get(k)).doubleValue(), j);

            T.add(Double.valueOf(ti));
        }

        double matrix[][] = new double[m + 1][m + 2];
        for(int k = 0; k < m + 1; k++)
        {
            double matrixi[] = matrix[k];
            for(int q = 0; q < m + 1; q++)
                matrixi[q] = ((Double)S.get(k + q)).doubleValue();

            matrixi[m + 1] = ((Double)T.get(k)).doubleValue();
        }

        matrix = matrixConvert(matrix);
        result = MatrixCalcu(matrix);
        return result;
    }

    public double[][] matrixConvert(double d[][])
    {
        for(int i = 0; i < d.length - 1; i++)
        {
            double dd1[] = d[i];
            double num1 = dd1[i];
            for(int j = i; j < d.length - 1; j++)
            {
                double dd2[] = d[j + 1];
                double num2 = dd2[i];
                for(int k = 0; k < dd2.length; k++)
                    dd2[k] = dd2[k] * num1 - dd1[k] * num2;

            }

        }

        return d;
    }

    public List MatrixCalcu(double d[][])
    {
        int i = d.length - 1;
        int j = d[0].length - 1;
        List list = new ArrayList();
        double res = d[i][j] / d[i][j - 1];
        list.add(Double.valueOf(res));
        for(int k = i - 1; k >= 0; k--)
        {
            double num = d[k][j];
            for(int q = j - 1; q > k; q--)
                num -= d[k][q] * ((Double)list.get(j - 1 - q)).doubleValue();

            res = num / d[k][k];
            list.add(Double.valueOf(res));
        }

        return list;
    }

    public void setData(List list)
    {
        this.list = list;
    }

    public List getData()
    {
        return list;
    }

    public int getTimes()
    {
        return times;
    }

    public void setTimes(int times)
    {
        this.times = times;
    }

    List list;
    int times;
}
