// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GasDrawAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
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

public class GasDrawAction extends ActionSupport
{

    public GasDrawAction()
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
        chart = ChartFactory.createXYLineChart((new StringBuilder(String.valueOf(getText("gasLiquid")))).append(" ").append(getText("mooreShares")).append("-").append("t(\u2103)").toString(), getText("mooreShares"), "t(\u2103)", getXYDataset(), PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = (XYPlot)chart.getPlot();
        org.jfree.chart.renderer.xy.XYItemRenderer r = plot.getRenderer();
        if(r instanceof XYLineAndShapeRenderer)
        {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawOutlines(true);
        }
        FileInputStream is = null;
        String path = ServletActionContext.getServletContext().getRealPath("/logo/gasRight.png");
        try
        {
            is = new FileInputStream(path);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        java.awt.image.BufferedImage img = null;
        try
        {
            img = ImageIO.read(is);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        plot.setBackgroundImage(img);
        plot.setBackgroundImageAlignment(8);
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setLowerMargin(3D);
        yAxis.setLowerBound(75D);
        yAxis.setUpperBound(100D);
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setUpperBound(1.0D);
        xAxis.setLowerBound(0.0D);
        return chart;
    }

    public XYDataset getXYDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        EthanolVaporLiquidEquilibrium evlData = new EthanolVaporLiquidEquilibrium();
        List gasData = (new GasData()).getExperimentData2(team);
        XYSeries x = new XYSeries((new StringBuilder(String.valueOf(getText("liquidPhase")))).append(getText("exprData")).toString());
        XYSeries y = new XYSeries((new StringBuilder(String.valueOf(getText("gasPhase")))).append(getText("exprData")).toString());
        for(int i = 0; i < gasData.size(); i++)
        {
            x.add((Number)((List)gasData.get(i)).get(2), (Number)((List)gasData.get(i)).get(0));
            y.add((Number)((List)gasData.get(i)).get(3), (Number)((List)gasData.get(i)).get(0));
        }

        dataset.addSeries(y);
        dataset.addSeries(x);
        dataset.addSeries(evlData.getEthanolVaperLiquidGasPoint());
        dataset.addSeries(evlData.getEthanolVaperLiquidLiquidPoint());
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
    Teams team;
    int tid;
}
