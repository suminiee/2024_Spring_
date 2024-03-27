package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")

@Controller // jsp 화면으로 가는 경우 @ResponseBody 사용 절대 안함!
public class Lesson04Ex01Controller {
	@Autowired
	private UserBO userBO;

	//회원 가입 화면
	//http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET) //@GetMapping("add-user-view")랑 같은 의미
	public String addUserView() {
		return "lesson04/addUser"; //jsp경로
	}
	
	//http://localhost/lesson04/ex01/add-user //view에서 넘겨주는 것
	//요즘엔 postMapping쓰라는 추세
	@PostMapping("/add-user") //post만 받을 수 있게 됨 
	public String addUser(
			@RequestParam("name") String name,//form에서 name속성이 있는 것을 쓰면 됨
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required = false) String introduce //null 허용
			) {
		
		//DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser";//회원가입 성공 시 이동하는 페이지
	}
	
	//최근에 가입된 한 명의 유저를 보는 화면 
	//http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) { //model : view 화면에 데이터를 넘겨주는 객체 
		//DB select
		User user = userBO.getLatestUser();
		
		//model 주머니에 담는다 => jsp에서 꺼내서 쓴다
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입된 유저 정보");
		
		
		return "lesson04/latestUser";
	}
}
