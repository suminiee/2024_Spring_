package com.memo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component //spring bean
public class PermissionInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		//요청 Url path 꺼내기 
		String uri = request.getRequestURI();//path를 보는 방법 (url vs uri)
		log.info("[@@@@@@@@@@@@@@@ preHandle] uri path : {}", uri);
		
		return true; //컨트롤러 수행
	}
}
