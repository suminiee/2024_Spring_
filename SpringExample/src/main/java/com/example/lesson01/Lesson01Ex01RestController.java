package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller + @ResponseBody
@RequestMapping("/lesson01/ex01")
public class Lesson01Ex01RestController {
	
	//http://localhost8080:/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestController를 사용해 String을 반환한다.<h3>";
	}
	
	//http://localhost8080:/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa","1111");
		map.put("bbb","2222");
		map.put("ccc","3333");
		return map;
	}
	
	//http://localhost8080:/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data();//일반 java bean
		data.setId(100);
		data.setName("오타니");
		return data;//일반 bean 객체도 JSON으로 반환됨.
		
	}
	
	//http://localhost8080:/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(17);
		data.setName("오타니 쇼헤이");
		
		return new ResponseEntity<>(data, HttpStatus.OK);//INTERNAL_SERVER_ERROR으로 하면 500오류로 설정가능
	}
	
}
