package com.memo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "Hello world!";
	}
	
	@GetMapping("/test2")
	@ResponseBody
	public Map<String, Object> test2() {
		Map<String, Object> map = new HashMap<>();
		map.put("qwer", 111);
		map.put("aaa", 222);
		map.put("ddd", 112);
		return map;
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "test/test3";
	}
	
//	@GetMapping("/test4")
//	@ResponseBody
//	public List<Map<String, Object>> test4() {
//		return;
//	}
}
