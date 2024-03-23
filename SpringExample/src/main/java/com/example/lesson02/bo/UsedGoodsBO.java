package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service //spring bean이 됨. 
public class UsedGoodsBO {
	
	@Autowired //DI -> 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; //스프링이 채워줌(빈 객체가 아님!)
	
	
	//input: (컨트롤러로부터 받아온다)
	//output: (컨트롤러한테 준다) List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
	}
}
