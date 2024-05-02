package com.memo.interceptor;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component //spring bean
public class PermissionInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		//요청 Url path 꺼내기 
		String uri = request.getRequestURI();//path를 보는 방법 (url vs uri)
		log.info("[@@@@@@@@@@@@@@@ preHandle] uri path : {}", uri);
		
		//로그인 여부 
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		//비로그인 && /post => 로그인 페이지로 이동, 컨트롤러 수행 방지 
		if (userId == null && uri.startsWith("/post")) {
			response.sendRedirect("/user/sign-in-view");
			return false; //원래 요청에 대해 컨트롤러 수행 x
		}
		
		//로그인 && /user => 글목록 페이지로 이동, 컨트롤러 수행 방지 //이런 방식이라면 로그아웃(/user/logout)일때 무한으로 리다이렉트되게됨. 
		if (userId != null && uri.startsWith("/user")) {
			response.sendRedirect("/post/post-list-view");
			return false;
		}
		
		return true; //컨트롤러 수행
	}
	
	//후처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) {
		//ModelAndView가 존재하는 것은 jsp가 html로 변환되기 전
		log.info("[############### postHandle]");
	}
	
	//후처리
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		
		//jsp가 html로 변환된 후
		log.info("[$$$$$$$$$$$$ afterCompletion]");
	}
}
