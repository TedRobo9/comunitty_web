package com.uacity.web.controller;

import com.uacity.web.domain.Menu;
import com.uacity.web.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller  
@RequestMapping("/")
public class MainCotroller {
	
	@Autowired
	private MenuService menuService;
	
	List<Menu> datalist = null;

	@RequestMapping(value="index" , method = RequestMethod.GET)
	public String index(){
		System.out.println("index>>>>>>>>>>>>>>>>");
		return "index";
	}

	@RequestMapping(value="store" , method = RequestMethod.GET)
	public String store(){
		System.out.println("index>>>>>>>>>>>>>>>>");
		return "store_list";
	}

	@RequestMapping(value="/list" , method = RequestMethod.GET)
	@ResponseBody 
	public Map<String, Object> list(){ 
		System.out.println("getAll menu>>>>>>>>>>>>>>>>");
		if(datalist == null){
			datalist =  menuService.getTopMenu();
		}
		Map<String, Object> modelMap = new HashMap<String, Object>();  
        modelMap.put("data", datalist); 
        modelMap.put("success", "true");  
        return modelMap;
	}
	
	
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
