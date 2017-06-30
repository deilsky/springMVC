package com.deilsky.springmvc.service;

import com.deilsky.springmvc.entity.Manager;

public interface ManagerService {
	Manager getManagerByUserName(String userName);
	Manager getManagerByUserNameAndPassWord(Manager e);
}
