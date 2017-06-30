package com.deilsky.springmvc.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static String uploadFile(HttpServletRequest request) throws IOException {
		String baseDir = "/userfiles/resources/";
		// String fileName = new String(request.getParameter("qqfile").getBytes("ISO8859-1"),"UTF-8");
		String fileName = request.getParameter("qqfile");
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		suffix = suffix.toLowerCase();
		StringBuffer path = new StringBuffer();
		path.append(baseDir);
		String tmpStr = request.getSession().getServletContext().getRealPath(baseDir + suffix);
		File file = new File(tmpStr);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String dateStr = sdf.format(date);
		StringBuffer newName = new StringBuffer(suffix.toUpperCase());
		newName.append(dateStr);
		newName.append(".");
		newName.append(suffix);
		File newFile = new File(tmpStr + "/" + newName.toString());
		FileUtils.copyInputStreamToFile(request.getInputStream(), newFile);
		path.append(suffix);
		path.append("/");
		path.append(newName.toString());
		return path.toString();
	}

	public static String upload(MultipartFile data, HttpServletRequest request) throws IOException {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		// Date date = new Date();
		String newFileName = null;
		if (data != null && !data.isEmpty()) {
			String realPath = request.getSession().getServletContext().getRealPath("/userfiles/resources/upload/");
			FileUtils.copyInputStreamToFile(data.getInputStream(), new File(realPath, data.getOriginalFilename()));
			String fileName = data.getOriginalFilename();
			newFileName = fileName;
			return "userfiles/resources/upload/" + newFileName;
		} else {
			return null;
		}
	}
}
