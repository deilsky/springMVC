package com.deilsky.springmvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deilsky.springmvc.service.ShopperService;
import com.deilsky.springmvc.utils.BootStrapModel;
import com.deilsky.springmvc.utils.PageModel;

@RequestMapping("/default/manager/shopper")
@Controller
public class ShopperController {
	@Resource
	private ShopperService shopperService;

	@RequestMapping("/index")
	public void index() {
	}

	@RequestMapping("/bootData")
	@ResponseBody
	public BootStrapModel bootData(int offset, int limit, String search, String sort, String order) {
		PageModel pageModel = new PageModel(offset, limit);
		pageModel = shopperService.getShopperPageModel(pageModel, search, order, sort);
		return new BootStrapModel(pageModel);
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id,Model model){
		
		return "default/manager/shopper/edit";
	}
}