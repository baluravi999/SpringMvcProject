package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.models.Customer;
import com.app.models.Item;
import com.app.models.Order;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService service;
	@Autowired
	private CodeUtil codeUtil;
    @Autowired
	private CoDecUtil coDecUtil;
	@Autowired
    private CommonUtil commonUtil;
    
	@RequestMapping("/regCustomer")
	public String showRegister() {
		return "CustomerRegister";
	}
	@RequestMapping (value="saveCustomer",method=RequestMethod.POST)
	public String savecust(@ModelAttribute("Customer") Customer cust,ModelMap map)
	{
		String pwd=codeUtil.genPwd();
		String token=codeUtil.genToken();
		String encPwd=coDecUtil.doEncode(pwd);
		String encToken=coDecUtil.doEncode(token); 
		cust.setPassword(encPwd);
		cust.setAccToken(encToken);
		int custId=service.saveCustomer(cust);
		String info="saved with:"+custId+" successfully : email also sent";
		
		String minfo=info+" "+"customer password :" +" "+encPwd+"\t"+
				"customer Token :"+" "+encToken ;
		String flag=commonUtil.sendEmail(cust.getCustEmail(),"Registered as Customer",minfo,null);
		String message=cust.getCustId()+"Customer Register";
		//if(flag) message+=",email also sent";
		map.addAttribute("msg",info);
		return "CustomerRegister";
	}
	@RequestMapping("delCustomer")
	public String delcust(@RequestParam("custId")int custId)
	{
		service.deleteCustomer(custId); 
		return "redirect:getAllCustomers";
	}

	@RequestMapping("editCustomer")
	public String editcust(@RequestParam("custId")int custId,ModelMap map)
	{
		Customer cust=service.getCustomerById(custId);
		map.addAttribute("cust",cust);
		return "CustomerDataEdit";
	}
	@RequestMapping(value="updatecust",method=RequestMethod.POST)
	public String updatecust(@ModelAttribute Customer cust){
		service.updateCustomer(cust);
		return "redirect:getAllCustomers";
	}
	@RequestMapping("getAllCustomers")
	public String getData(ModelMap map)
	{
		List<Customer> custs=service.getAllCustomers();
		map.addAttribute("custs",custs);
		return "CustomerData";
	}
	@RequestMapping("getCustItems")
	public String showItems(@RequestParam("custId")int custId,ModelMap map)
	{
		List<Item> items=service.getCustItemsById(custId);
		map.addAttribute("items",items);
		return "CustomerItems";
	}
	@RequestMapping("getCustOrders")
	public String showOrders(@RequestParam("custId")int custId,ModelMap map)
	{
		List<Order> orders=service.getCustOrdersById(custId);
		map.addAttribute("orders",orders);
		return "CustomerOrders";
	}
}