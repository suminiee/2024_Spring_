package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson01/quiz02")
public class Lesson01Quiz02Controller {
	
	//http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1(){
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>() {
			{put("rate", 15); put("director", "봉준호"); put("time", 131); put("title", "기생충");}
		};
		list.add(map);
		map = new HashMap<String, Object>() {{put("rate", 0); put("director", "로베르토 베니니"); put("time", 116); put("title", "인생은 아름다워");}};
		list.add(map);
		map = new HashMap<String, Object>() {{put("rate", 12); put("director", "크리스토퍼 놀란"); put("time", 147); put("title", "인셉션");}};
		list.add(map);
		map = new HashMap<String, Object>() {{put("rate", 19); put("director", "윤종빈"); put("time", 133); put("title", "범죄와의 전쟁: 나쁜놈들 전성시대");}};
		list.add(map);
		return list;
	}
	
	//http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<ContentData> quiz02_2() {
		List<ContentData> list = new ArrayList<>();
		ContentData d1 = new ContentData();
		d1.setTitle("안녕하세요, 가입인사 드립니다");
		d1.setUser("marobina");
		d1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		list.add(d1);
		
		ContentData d2 = new ContentData();
		d2.setTitle("오타니");
		d2.setUser("marobina");
		d2.setContent("홈런");
		list.add(d2);
		
		return list;
	}
	
	//http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/3")
	public ResponseEntity<ContentData> quiz02_3() {
		ContentData d1 = new ContentData();
		d1.setTitle("안녕하세요, 가입인사 드립니다");
		d1.setUser("marobina");
		d1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(d1, HttpStatus.INTERNAL_SERVER_ERROR);//INTERNAL_SERVER_ERROR으로 하면 500오류로 설정가능
	}

	
}
