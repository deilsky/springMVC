package com.deilsky.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.deilsky.springmvc.utils.FileUtil;
import com.deilsky.springmvc.utils.JSON;

@RequestMapping("/default/manager")
@Controller
public class DefaultController {

	@RequestMapping("/login")
	public void login() {
	}

	@RequestMapping("/index")
	public void index() {

	}

	@RequestMapping("/upload")
	public void upload() {

	}

	@RequestMapping("/uploadFile")
	@ResponseBody
	public JSON uploadFile(MultipartHttpServletRequest request) throws IOException {
		Map<String, MultipartFile> map = request.getFileMap();
		ArrayList<String> list = new ArrayList<String>();
		for (String key : map.keySet()) {
			MultipartFile mf = map.get(key);
			System.out.println("key:" + key + ",value" + mf.getName() + "_" + mf.getOriginalFilename());
			String path = FileUtil.upload(mf, request);
			list.add(path);
		}
		System.out.println(list.toString());
		return JSON.getInstance().setStatus(200);
	}
}
