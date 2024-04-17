package com.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(@RequestParam("loginId") String loginId) {
		//중복 체크 - DB
		
		
		
		//
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicated_id", true);
		return result;
		
	}
 }
