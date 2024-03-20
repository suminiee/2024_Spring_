package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")//메소드 위에 붙은 path보다 먼저 읽혀진다.
@Controller//spring bean 등
public class Lesson01Ex01Controller {
	//url: http://localhost:8080/lesson01/ex01/1
	//String을 브라우저에 출력
	
	@ResponseBody//리턴되는 값은 response body에 넣어지고, HTML 응
	@RequestMapping("/1")
	public String ex01_1() {	
		return "<h2>문자열을 ResponseBody에 보내는 예제<h2>";
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 30);
		map.put("라즈베리", 222);
		map.put("바나나", 12);
		map.put("딸기", 16);
		
		//map을 리턴하면 JSON이 된다.
		//web
		return map;
	}
}
