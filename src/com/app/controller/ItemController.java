package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.models.Item;
import com.app.service.IItemService;

@Controller
public class ItemController {
	@Autowired
	private IItemService service;

	@RequestMapping("/regItem")
	public String showRegister() {
		return "ItemRegister";
	}
	@RequestMapping (value="saveItem",method=RequestMethod.POST)
	public String saveitem(@ModelAttribute("Item") Item item,ModelMap map)
	{
		int itemId=service.saveItem(item);
		String info="saved with:"+itemId+" successfully";
		map.addAttribute("msg",info);
		return "ItemRegister";
	}
	@RequestMapping("delItem")
	public String delitem(@RequestParam("itemId")int itemId)
	{
	    service.deleteItem(itemId); 
		return "redirect:getAllItems";
	}
	
    @RequestMapping("editItem")
    public String edititem(@RequestParam("itemId")int itemId,ModelMap map)
    {
        Item item=service.getItemById(itemId);
        map.addAttribute("item",item);
    	return "ItemDataEdit";
    }
    @RequestMapping(value="updateItem",method=RequestMethod.POST)
    public String updateitem(@ModelAttribute Item item){
    	service.updateItem(item);
    	return "redirect:getAllItems";
    }
	@RequestMapping("getAllItems")
	public String getData(ModelMap map)
	{
	    List<Item> items=service.getAllItems();
	    map.addAttribute("items",items);
		return "ItemData";
	}
}