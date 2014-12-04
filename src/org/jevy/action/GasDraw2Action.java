// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GasDraw2Action.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.jevy.model.*;
import org.jevy.service.GasData;
import org.jevy.util.EthanolVaporLiquidEquilibrium;
import org.jevy.util.GetTeamByStudent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class GasDraw2Action extends ActionSupport
{

    public GasDraw2Action()
    {
    }

    public JFreeChart getChart()
    {
        if(tid == 0)
        {
            student = (Student)ActionContext.getContext().getSession().get("student");
            team = (new GetTeamByStudent()).getTeams(2, student);
        } else
        {
            team = (new TeamsDAO()).findById(Integer.valueOf(tid));
        }
        chart = ChartFactory.createXYLineChart((new StringBuilder(String.valueOf(getText("gasLiquid")))).append("x-y").toString(), (new StringBuilder("x")).append(getText("mooreShares")).toString(), (new StringBuilder("y")).append(getText("mooreShares")).toString(), getXYDataset(), PlotOrientation.VERTICAL, true, false, false);
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
        yAxis.setLowerMargin(0.0D);
        yAxis.setLowerBound(0.0D);
        yAxis.setUpperBound(1.0D);
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setUpperBound(1.0D);
        xAxis.setLowerBound(0.0D);
        return chart;
    }

    public XYDataset getXYDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        EthanolVaporLiquidEquilibrium evlData = new EthanolVaporLiquidEquilibrium();
        List x = (List)evlData.getEthanolVaporLiquidLiquid().get(1);
        List y = (List)evlData.getEthanolVaporLiquidGas().get(1);
        XYSeries xy = new XYSeries((new StringBuilder(String.valueOf(getText("gasPhase")))).append("x-y").toString());
        xy.add(0.0D, 0.0D);
        for(int i = 0; i < x.size(); i++)
            xy.add((Number)x.get(i), (Number)y.get(i));

        xy.add(1.0D, 1.0D);
        dataset.addSeries(xy);
        XYSeries stan = new XYSeries((new StringBuilder(String.valueOf(getText("liquidPhase")))).append("x-y").toString());
        stan.add(0.0D, 0.0D);
        stan.add(1.0D, 1.0D);
        dataset.addSeries(stan);
        List gasData = (new GasData()).getExperimentData2(team);
        XYSeries exper = new XYSeries(getText("exprData"));
        for(int j = 0; j < gasData.size(); j++)
            exper.add((Number)((List)gasData.get(j)).get(2), (Number)((List)gasData.get(j)).get(3));

        dataset.addSeries(exper);
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

    private JFreeChart chart;
    private Student student;
    int tid;
    Teams team;
}
