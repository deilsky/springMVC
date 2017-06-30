package com.deilsky.springmvc.service;

import com.deilsky.springmvc.utils.PageModel;

public interface ShopperService {
	PageModel getShopperPageModel(PageModel pageModel, String key,String order,String sort);
}
