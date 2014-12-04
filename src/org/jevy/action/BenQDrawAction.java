// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BenQDrawAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.*;
import org.jevy.model.*;
import org.jevy.service.BenData;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.RetainedFraction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class BenQDrawAction extends ActionSupport
{

    public BenQDrawAction()
    {
    }

    public JFreeChart getChart()
    {
        if(tid == 0)
        {
            student = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(4, student);
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        chart = ChartFactory.createXYLineChart((new StringBuilder(String.valueOf(getText("numOfBen")))).append("-").append(getText("affectToAbsorb")).toString(), " g", (new StringBuilder(String.valueOf(getText("wipeOff")))).append(" %").toString(), getXYDataset(), PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = (XYPlot)chart.getPlot();
        org.jfree.chart.renderer.xy.XYItemRenderer r = plot.getRenderer();
        if(r instanceof XYLineAndShapeRenderer)
        {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawOutlines(true);
        }
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setLowerMargin(3D);
        yAxis.setLowerBound(60D);
        yAxis.setUpperBound(100D);
        return chart;
    }

    public XYDataset getXYDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        System.out.println(team);
        List benRes = (new BenData()).getBenQualityData(team.getTid().intValue());
        XYSeries ser;
        for(Iterator iterator = benRes.iterator(); iterator.hasNext(); dataset.addSeries(ser))
        {
            Data da = (Data)iterator.next();
            ser = new XYSeries((new StringBuilder()).append(da.getData6()).append(" g").toString());
            ser.add(da.getData1().doubleValue(), getRemoval(da.getData7().doubleValue()));
            ser.add(da.getData2().doubleValue(), getRemoval(da.getData8().doubleValue()));
            ser.add(da.getData3().doubleValue(), getRemoval(da.getData9().doubleValue()));
            ser.add(da.getData4().doubleValue(), getRemoval(da.getData10().doubleValue()));
            ser.add(da.getData5().doubleValue(), getRemoval(da.getData11().doubleValue()));
        }

        return dataset;
    }

    public double getRemoval(double a)
    {
        double c = (a - 0.0063499999999999997D) / 0.58196999999999999D;
        return (new RetainedFraction()).retained4((1.0D - (50D * c) / 50D) * 100D);
    }

    public Teams getTeam()
    {
        return team;
    }

    public void setTeam(Teams team)
    {
        this.team = team;
    }

    public void setChart(JFreeChart chart)
    {
        this.chart = chart;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    private JFreeChart chart;
    private Teams team;
    private Student student;
    int tid;
}
