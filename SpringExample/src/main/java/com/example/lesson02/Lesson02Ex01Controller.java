package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController//ResponseBody가 붙어있음 (ResponseBody + controller)
public class Lesson02Ex01Controller {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	//url : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		return usedGoodsBO.getUsedGoodsList();//response => json
		
	}
}
