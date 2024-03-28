package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	//http://localhost/lesson04/quiz01/add-seller-view
	//seller 작성하는 페이지 
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "/lesson04/addSeller";
	}
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature
			) {
		
		//DB Insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "/lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String latestSellerInfoView(Model model, @RequestParam(value = "id", required = false) Integer id) {
		
		//DB select
//		Seller seller = sellerBO.getLatestSellerInfo();
//		Seller seller = sellerBO.getSellerInfo(id);
		Seller seller = null;
		
		if (id == null) {
			seller = sellerBO.getLatestSellerInfo();
		} else {
			seller = sellerBO.getSellerInfo(id);
		}

		
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		
		return "/lesson04/sellerInfo";
	}
}
