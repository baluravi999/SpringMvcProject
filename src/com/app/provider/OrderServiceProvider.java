package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.models.Customer;
import com.app.models.Order;
import com.app.service.ICustomerService;
import com.app.service.IOrderService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/order")
public class OrderServiceProvider {
	
	@Autowired
	private ICustomerService custService;
	
	@Autowired
	private CustomerValidator custValidator;
	
	@Autowired
	private JsonUtil jsonUtil;
	
	@Autowired
	private IOrderService OrderService;
	
	@Path("/saveOrder")
	@POST
	public String saveOrder( 
			@HeaderParam("user") String email,
			@HeaderParam("pwd")  String password,
			@HeaderParam("token")String accToken,
			String OrderJson){

		//reject empty or null values

		if(null==email || "".equals(email.trim())){
			return "Invalid Username provided";
		}
		if(null==password || "".equals(password.trim())){
			return "Invalid password provided";
		}
		if(null==accToken || "".equals(accToken.trim())){
			return "Invalid Token povided";
		}
		if(null == OrderJson || "".equals(OrderJson.trim())){
			return "Empty Order detials (JSON) provided";
		}

		//read customer based on email Id
		Customer cust=custService.getCustomerByEmail(email);
		
		if(cust==null){
			return "User not exist in application";
		}
		
		//is type Consumer ??
		if(custValidator.isCustSeller(cust)){
			return "Customer can not perform this operatin(has no authority) because Sellar, should be Consumer";
		}
		
		//check pwd,token
		if(custValidator.isPwdAndTokenValid(password, accToken, cust)){
			return "Invalid Password/Token details in request";
		}
		
		/*Order Save Process*/
		
		Object ob=jsonUtil.convertJsonToObject(OrderJson, Order.class);
		
		if(ob==null){
			return "Invalid Order-JSON Format is provided";
		}
		
		//if valid continue
		Order ord=null;
		if(ob instanceof Order){
			ord=(Order)ob;
		}
		
		if(ord==null){
			return "data may not be Order ..";
		}
		
		//set cust id to Order obj
		ord.setCustId(cust.getCustId());
		
		int OrderId=OrderService.saveOrder(ord);
		
		return "Order Saved with id:"+OrderId;
	}
}