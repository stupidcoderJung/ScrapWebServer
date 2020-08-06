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

import com.scrapbot.entity.entities.NewsArticle;
import com.scrapbot.service.NewsArticleService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value ="/api", method = RequestMethod.GET)
public class NewsArticleController {
//	@Autowired
//	private NewsArticleRepository newsArticleRepository;
	@Autowired
	private final NewsArticleService newsArticleService = null;
	
    @GetMapping("/articles")
    public List<NewsArticle> getArticle() {
    	System.out.println("woodo king22");
    	return newsArticleService.findAll();
    }
	
	@GetMapping("/articles/getById/{id}")
	public Map<String, Object> findById(@PathVariable("id") int id) {
		System.out.println("woodo good"); 
		Map<String, Object> response = new HashMap<>();

		Optional<NewsArticle> oUser = newsArticleService.findById(id);
		if(oUser.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("user", oUser.get());
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return response;
	}
	
	@GetMapping("/articles/getByName/{newcompany}")
	public List<NewsArticle> findOne(@PathVariable("newcompany") String newcompany){
		System.out.println("newcompany");
		
//		// get list 
//		List<NewsArticle> list1 = newsArticleService.findByNameLike("%ko"); 
//		System.out.println("*Find By Name*");
//
//		
		return newsArticleService.findByNewcompanyLike(newcompany);
	}
}