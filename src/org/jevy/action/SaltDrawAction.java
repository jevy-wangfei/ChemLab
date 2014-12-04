// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SaltDrawAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;
import org.jevy.resmodel.SaltResModel;
import org.jevy.service.SaltData;
import org.jevy.util.GetTeamByStudent;
import org.jevy.util.TernaryWaterSalt;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class SaltDrawAction extends ActionSupport
{

    public SaltDrawAction()
    {
    }

    public JFreeChart getChart()
    {
        Teams team = null;
        if(tid == 0)
        {
            student = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(2, student);
            tid = team.getTid().intValue();
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
            tid = team.getTid().intValue();
        }
        chart = ChartFactory.createXYLineChart(getText("waterSalt"), "NaCl", "NH3Cl", getXYDataset(), PlotOrientation.VERTICAL, true, false, false);
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
        yAxis.setLowerBound(0.0D);
        yAxis.setUpperBound(30D);
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setUpperBound(30D);
        xAxis.setLowerBound(0.0D);
        return chart;
    }

    public XYDataset getXYDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        TernaryWaterSalt salt = new TernaryWaterSalt();
        dataset.addSeries(salt.getSaltCopiesXYSeries());
        dataset.addSeries(salt.getSaltCopiesXYSeries2());
        List data = (new SaltData()).getSaltData(tid);
        XYSeries ser = new XYSeries(getText("exprData"));
        SaltResModel model;
        for(Iterator iterator = data.iterator(); iterator.hasNext(); ser.add(model.getResNa(), model.getResNh()))
            model = (SaltResModel)iterator.next();

        dataset.addSeries(ser);
        return dataset;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    private static final long serialVersionUID = 0xeeaf29849a3caa8L;
    private JFreeChart chart;
    private Student student;
    int tid;
}
