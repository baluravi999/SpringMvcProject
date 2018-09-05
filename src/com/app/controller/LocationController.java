package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.models.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;

@Controller
public class LocationController {
	
	@Autowired
	private ILocationService service;
	@Autowired
	private ServletContext sc;
    @Autowired
	private LocationUtil locUtil;
    
	@RequestMapping("/regLocation")
	public String showRegister() {
		return "LocationRegister";
	}
	@RequestMapping (value="saveLoc",method=RequestMethod.POST)
	public String upadteLoc(@ModelAttribute("location") Location loc,ModelMap map)
	{
		int locId=service.saveLocation(loc);
		String info="saved with:"+locId+" successfully";
		map.addAttribute("msg",info);
		return "LocationRegister";
	}
	@RequestMapping("delLocation")
	public String delLoc(@RequestParam("locId")int locId)
	{
	    service.deleteLocation(locId); 
		return "redirect:getAllLocs";
	}
	
    @RequestMapping("editLocation")
    public String editLoc(@RequestParam("locId")int locId,ModelMap map)
    {
        Location loc=service.getLocationById(locId);
        map.addAttribute("loc",loc);
    	return "LocationDataEdit";
    }
    @RequestMapping(value="updateLoc",method=RequestMethod.POST)
    public String updateLoc(@ModelAttribute Location loc){
    	service.updateLocation(loc);
    	return "redirect:getAllLocs";
    }
	@RequestMapping("getAllLocs")
	public String getData(ModelMap map)
	{
	    List<Location> locs=service.getAllLocations();
	    map.addAttribute("locs",locs);
		return "LocationData";
	}
	@RequestMapping("/locExcel")
	public String doExcelExport(ModelMap map){
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locList", locList);
		return "LocExcelView";
	}
	//8. Location PDF Export
	@RequestMapping("/locPdf")
	public String doPdfExport(ModelMap map){
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locList", locList);
		return "LocPdfView";
	}
	@RequestMapping("locReport")
	public String generateCharts(){
		String path= sc.getRealPath("/");
		List<Object[]> data=service.getLocTypeAndCount();
		locUtil.generatePieChart(path, data);
		locUtil.generateBarChart(path, data);
		return "LocationReports";
	}
}