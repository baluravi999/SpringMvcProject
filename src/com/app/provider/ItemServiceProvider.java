package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.models.Customer;
import com.app.models.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;


@Component
@Path("/item")
public class ItemServiceProvider {
	
	@Autowired
	private ICustomerService custService;
	
	@Autowired
	private CustomerValidator custValidator;
	
	@Autowired
	private JsonUtil jsonUtil;
	
	@Autowired
	private IItemService itemService;
	
	@Path("/saveItem")
	@POST
	public String saveItem( 
			@HeaderParam("user") String email,
			@HeaderParam("pwd")  String password,
			@HeaderParam("token")String accToken,
			String itemJson){

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
		if(null == itemJson || "".equals(itemJson.trim())){
			return "Empty Item detials (JSON) provided";
		}

		//read customer based on email Id
		Customer cust=custService.getCustomerByEmail(email);
		
		if(cust==null){
			return "User not exist in application";
		}
		
		//is type seller ??
		if(!custValidator.isCustSeller(cust)){
			return "Customer can not perform this operatin(has no authority) because Sellar, should be Seller";
		}
		
		//check pwd,token
		if(custValidator.isPwdAndTokenValid(password, accToken, cust)){
			return "Invalid Password/Token details in request";
		}
		
		/*Item Save Process*/
		
		Object ob=jsonUtil.convertJsonToObject(itemJson, Item.class);
		
		if(ob==null){
			return "Invalid Item-JSON Format is provided";
		}
		
		//if valid continue
		Item itm=null;
		if(ob instanceof Item){
			itm=(Item)ob;
		}
		
		if(itm==null){
			return "data may not be item ..";
		}
		
		//set cust id to item obj
		itm.setCustId(cust.getCustId());
		
		int itemId=itemService.saveItem(itm);
		
		return "Item Saved with id:"+itemId;
	}
}