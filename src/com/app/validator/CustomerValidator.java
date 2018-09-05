package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.models.Customer;
import com.app.util.CoDecUtil;

@Component
public class CustomerValidator {
	
	@Autowired
	private CoDecUtil codecUtil;
	
	public boolean isPwdAndTokenValid(String reqPwd,String reqToken,Customer cust){
		
		boolean isValid=false;
		
		//read encoded values from DB object
		String encPwd=cust.getPassword();
		String encToken=cust.getAccToken();
		
		//do decode
		String dbPwd=codecUtil.doDecode(encPwd);
		String dbToken=codecUtil.doDecode(encToken);
		
		//compare req and db values 
		if(dbPwd.equals(reqPwd) && dbToken.equals(reqToken)){
			isValid=true;
		}
		
		return isValid;
	}
	
	public boolean isCustSeller(Customer cust){
		return "Seller".equalsIgnoreCase(cust.getCustType());
	}
	
	public boolean isCustConsumer(Customer cust){
		return "Consumer".equalsIgnoreCase(cust.getCustType());
	}	
}