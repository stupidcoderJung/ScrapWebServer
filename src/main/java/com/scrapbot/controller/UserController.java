package com.scrapbot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scrapbot.entity.User;
import com.scrapbot.service.UserService;

import io.swagger.annotations.Api;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@Api(value = "UserController", description = "USER API")
@RequestMapping(value ="/api", method = RequestMethod.GET)
public class UserController {
	
	@Autowired
	private final UserService userService = null;
	
    @GetMapping("/user")
    public List<User> getArticle() {
    	System.out.println("woodo here");
    	return userService.findAll();
    }
	
	@GetMapping("/user/getById/{id}")
	public Map<String, Object> findById(@PathVariable("id") int id) {
		System.out.println("woodo2");
		
		
		Map<String, Object> response = new HashMap<>();

		Optional<User> oUser = userService.findById(id);
		if(oUser.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("user", oUser.get());
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return response;
	}
}
