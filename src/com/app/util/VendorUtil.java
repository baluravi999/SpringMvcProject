package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class VendorUtil {
	public void generatePieChart(String path,List<Object[]> data)
	{
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data){
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
		}
		JFreeChart chart=ChartFactory.createPieChart3D("VendorReport",dataset,true,true,false);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportPieVen.jpg"),chart,300,300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
public void generateBarChart(String path,List<Object[]> data)
{
	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	for(Object[] ob:data){
		dataset.setValue(new Double(ob[1].toString()),ob[0].toString(),"");
	}
	JFreeChart chart=ChartFactory.createBarChart3D("VendorReport","VendorTypes","Count",dataset);
	try {
		ChartUtilities.saveChartAsJPEG(new File(path+"/reportBarVen.jpg"),chart,300,300);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}