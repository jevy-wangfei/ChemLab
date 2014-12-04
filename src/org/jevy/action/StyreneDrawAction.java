// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StyreneDrawAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.jevy.model.*;
import org.jevy.resmodel.StyreneResModel;
import org.jevy.service.StyreneData;
import org.jevy.util.GetTeamByStudent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class StyreneDrawAction extends ActionSupport
{

    public StyreneDrawAction()
    {
    }

    public JFreeChart getChart()
    {
        if(tid == 0)
        {
            student = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(5, student);
            tid = team.getTid().intValue();
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        chart = ChartFactory.createXYLineChart(getText("styreneProducts"), "\u2103", "%", getXYDataset(), PlotOrientation.VERTICAL, true, false, false);
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
        yAxis.setUpperBound(1.0D);
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setLowerBound(500D);
        xAxis.setUpperBound(650D);
        return chart;
    }

    public XYDataset getXYDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries serA = new XYSeries(getText("a"));
        XYSeries serS = new XYSeries(getText("S"));
        XYSeries serY = new XYSeries(getText("Y"));
        List list = (new StyreneData()).getStyreneData(tid);
        StyreneResModel model;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); serY.add(model.getReactorTemper(), model.getY()))
        {
            model = (StyreneResModel)iterator.next();
            serA.add(model.getReactorTemper(), model.getA());
            serS.add(model.getReactorTemper(), model.getS());
        }

        dataset.addSeries(serA);
        dataset.addSeries(serS);
        dataset.addSeries(serY);
        dataset.setIntervalWidth(5D);
        return dataset;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    int tid;
    private static final long serialVersionUID = 1L;
    private JFreeChart chart;
    private Student student;
    Teams team;
}
