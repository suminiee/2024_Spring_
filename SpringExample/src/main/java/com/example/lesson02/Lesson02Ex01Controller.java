package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//ResponseBody가 붙어있음 (ResponseBody + controller)

public class Lesson02Ex01Controller {
	//url : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		return ;//response => json
		
	}
}
