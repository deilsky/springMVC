package com.deilsky.springmvc.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CommonInterceptor implements HandlerInterceptor {

	public String[]	allowUrls;
	public String	redirectUrl;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		if (null != allowUrls && allowUrls.length >= 1) {
			for (String url : allowUrls) {
				if (requestUrl.startsWith(url)) { return true; }
			}
		}
		Cookie cookieId = CookieUtil.getCookieByName(request, "id");
		if (cookieId != null) {
			if (StringUtils.isNotEmpty(cookieId.getValue())) {
				String id = cookieId.getValue();
				CookieUtil.addCookie(response, "id", id, 60 * 20);
			}
			return true;
		} else {
			StringBuffer defUrl = new StringBuffer();
			defUrl.append(request.getContextPath()).append(redirectUrl);
			response.sendRedirect(defUrl.toString());
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
