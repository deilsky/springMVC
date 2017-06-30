package com.deilsky.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deilsky.springmvc.entity.Manager;
import com.deilsky.springmvc.service.ManagerService;
import com.deilsky.springmvc.utils.CookieUtil;
import com.deilsky.springmvc.utils.EncryptUtils;
import com.deilsky.springmvc.utils.JSON;

@RequestMapping("/default/manager/manager")
@Controller
public class ManagerController {
	@Resource
	private ManagerService managerService;

	@RequestMapping("/loginDo")
	@ResponseBody
	public JSON loginDo(@RequestBody Manager m, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int status = 200;
		String msg = "成功";
		Manager manager = managerService.getManagerByUserName(m.getUserName());
		if (manager != null) {
			String encry = manager.getEncryption();
			String pass = EncryptUtils.encryptByMD5(m.getPassWord(), encry);
			manager = new Manager();
			m.setPassWord(pass);
			manager = managerService.getManagerByUserNameAndPassWord(m);
			if (manager != null) {
				manager.setPassWord(null);
				request.getSession().setAttribute("data", manager);
				CookieUtil.addCookie(response, "id", manager.getIdCard(), 20 * 60);
			} else {
				status = 202;
				msg = "密码不正确！";
			}
		} else {
			status = 201;
			msg = "该用户不存在!";
		}
		return JSON.getInstance().setStatus(status).setMsg(msg);
	}

	@RequestMapping("/loginOut")
	public String loginout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("data");
		CookieUtil.addCookie(response, "id", null, 60 * 20);
		return "default/manager/login";
	}
	public static void main(String[] args) throws Exception {
		System.out.println(EncryptUtils.encryptByMD5("123456", "admin").substring(0, 31).toUpperCase());
	}
}
