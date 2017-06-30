package com.deilsky.springmvc.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.deilsky.springmvc.dao.BaseDao;
import com.deilsky.springmvc.entity.Manager;
import com.deilsky.springmvc.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Resource
	private BaseDao<Manager> baseDao;

	@Override
	public Manager getManagerByUserName(String userName) {
		String hql = "from Manager where userName = ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(userName);
		return baseDao.getEntity(hql, param);
	}

	@Override
	public Manager getManagerByUserNameAndPassWord(Manager e) {
		String hql = "from Manager where userName = ? and passWord = ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(e.getUserName());
		param.add(e.getPassWord());
		return baseDao.getEntity(hql, param);
	}

}
