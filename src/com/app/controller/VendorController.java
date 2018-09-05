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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.models.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.VendorUtil;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;

	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private ServletContext sc;
    @Autowired
	private VendorUtil venUtil;
	
	@RequestMapping("/regVendor")
	public String showRegister() {
		return "VendorRegister";
	}
	@RequestMapping (value="saveVendor",method=RequestMethod.POST)
	public String saveven(@RequestParam("fObj")CommonsMultipartFile file,@ModelAttribute("Vendor") Vendor ven,ModelMap map)
	{   
		int venId=service.saveVendor(ven);
		String info="saved with:"+venId+" successfully";
		map.addAttribute("msg",info);
		String flag=commonUtil.sendEmail(ven.getVenEmail(),"Hello Vendor You Have registered with TrollyHub","your id is: "+venId,file);
		return "VendorRegister";
	}
	@RequestMapping("delVendor")
	public String delven(@RequestParam("venId")int venId)
	{
	    service.deleteVendor(venId); 
		return "redirect:getAllVens";
	}
	
    @RequestMapping("editVendor")
    public String editven(@RequestParam("venId")int venId,ModelMap map)
    {
        Vendor ven=service.getVendorById(venId);
        map.addAttribute("ven",ven);
    	return "VendorDataEdit";
    }
    @RequestMapping(value="updateVen",method=RequestMethod.POST)
    public String updateven(@ModelAttribute Vendor ven){
    	service.updateVendor(ven);
    	return "redirect:getAllVens";
    }
	@RequestMapping("getAllVens")
	public String getData(ModelMap map)
	{
	    List<Vendor> vens=service.getAllVendors();
	    map.addAttribute("vens",vens);
		return "VendorData";
	}
	
	@RequestMapping("/venExcel")
	public String doExcelExport(ModelMap map){
		List<Vendor> venList=service.getAllVendors();
		map.addAttribute("venList",venList);
		return "VenExcelView";
	}
	//8. Location PDF Export
	@RequestMapping("/venPdf")
	public String doPdfExport(ModelMap map){
		List<Vendor> venList=service.getAllVendors();
		map.addAttribute("venList",venList);
		return "VenPdfView";
	}
	@RequestMapping("venReport")
	public String generateCharts(){
		String path= sc.getRealPath("/");
		List<Object[]> data=service.getVenTypeAndCount();
		venUtil.generatePieChart(path, data);
		venUtil.generateBarChart(path, data);
		return "VendorReports";
	}
}