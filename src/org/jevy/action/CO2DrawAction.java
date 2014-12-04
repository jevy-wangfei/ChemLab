// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CO2DrawAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.jevy.model.*;
import org.jevy.resmodel.CO2ResModel;
import org.jevy.service.CO2Data;
import org.jevy.util.GetTeamByStudent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class CO2DrawAction extends ActionSupport {
	int tid;
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	private Student student;
	Teams team;
	
	public CO2DrawAction() {
	}

	public JFreeChart getChart() {
		if (tid == 0) {
			student = (Student) ActionContext.getContext().getSession()
					.get("student");
			team = (new GetTeamByStudent()).getTeams(2, student);
		} else {
			team = (new TeamsDAO()).findById(Integer.valueOf(tid));
		}
		chart = ChartFactory.createXYLineChart(getText("co2"), "v (pm^3/kg)",
				"P(MPa)", getXYDataset(), PlotOrientation.VERTICAL, true, true,
				false);
		XYPlot plot = (XYPlot) chart.getPlot();
		org.jfree.chart.renderer.xy.XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			renderer.setItemLabelsVisible(true);
			renderer.setBaseItemLabelsVisible(true);
			renderer.setDrawOutlines(true);
			plot.setRenderer(renderer);
		}
		FileInputStream is = null;
		String path = ServletActionContext.getServletContext().getRealPath(
				"/logo/co2.png");
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		java.awt.image.BufferedImage img = null;
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		plot.setBackgroundImage(img);
		ValueAxis yAxis = plot.getRangeAxis();
		yAxis.setLowerMargin(3D);
		yAxis.setLowerBound(2.9399999999999999D);
		yAxis.setUpperBound(9.8100000000000005D);
		ValueAxis xAxis = plot.getDomainAxis();
		xAxis.setUpperBound(12D);
		xAxis.setLowerBound(0.0D);
		return chart;
	}

	public XYDataset getXYDataset() {
		CO2Data co2Data = new CO2Data();
		List datas = co2Data.getData(3, team);
		XYSeriesCollection dataset = new XYSeriesCollection();
		for (int i = 0; i < datas.size(); i++) {
			List dalist = co2Data.co2DataCalculate((Set) datas.get(i));
			XYSeries s1 = new XYSeries((new StringBuilder(
					String.valueOf(((CO2ResModel) dalist.get(0)).getTemper())))
					.append("\u2103").toString());
			CO2ResModel d;
			for (Iterator iterator = dalist.iterator(); iterator.hasNext(); s1
					.add(d.getV(), d.getP()))
				d = (CO2ResModel) iterator.next();

			dataset.addSeries(s1);
		}

		dataset.setIntervalWidth(5D);
		return dataset;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}


}
