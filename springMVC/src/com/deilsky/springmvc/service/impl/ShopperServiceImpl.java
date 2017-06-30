package com.deilsky.springmvc.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.deilsky.springmvc.dao.BaseDao;
import com.deilsky.springmvc.entity.Shopper;
import com.deilsky.springmvc.service.ShopperService;
import com.deilsky.springmvc.utils.PageModel;

@Service
public class ShopperServiceImpl implements ShopperService {
	@Resource
	private BaseDao<Shopper> baseDao;

	@Override
	public PageModel getShopperPageModel(PageModel pageModel, String key, String order, String sort) {
		StringBuffer sql = new StringBuffer("select id,userName,sex,realName,mobile,birth,date_format(regTime,'%y-%m-%d %T') as regTime from t_shopper ");
		ArrayList<Object> param = new ArrayList<Object>();
		if (StringUtils.isNotEmpty(key)) {
			sql.append("where userName like ? or mobile like ? ");
			param.add("%" + key + "%");
			param.add("%" + key + "%");
		}
		if (StringUtils.isNotEmpty(sort)) {
			sql.append("order by ").append(sort).append(" ").append(order);
		}

		return baseDao.getPageModelByConditions(pageModel, sql.toString(), param);
	}
}
