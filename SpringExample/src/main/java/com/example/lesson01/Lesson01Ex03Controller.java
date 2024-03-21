package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//JSP 화면으로 보내는 컨트롤
@Controller
public class Lesson01Ex03Controller { //ResponseBody가 있으면 안됨! -> @RestConroller도 안됨
	//url: http://localhost/lesson01/ex03
	
	@RequestMapping("/lesson01/ex03")//(요청!!)
	public String ex03() {
		//return되는 String은 jsp의 경로이다 (@ResponseBody 없을 때)
		//prefix: /WEB-INF.jsp/
		//surfix:  		  				    .jsp
		//responseBody가 없으면 아래를 경로라고 생각하고 찾아가게 됨
		//return "/WEB-INF/jsp/lesson01/ex03.jsp"; -> 404 error 발생
		return "lesson01/ex03"; //response jsp view 경(응답!!)
		
	}
}
