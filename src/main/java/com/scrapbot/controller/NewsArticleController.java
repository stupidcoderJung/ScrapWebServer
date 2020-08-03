package com.scrapbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scrapbot.entity.daos.NewsArticleDAO;
import com.scrapbot.entity.entities.NewsArticle;
import com.scrapbot.repository.NewsArticleRepository;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "api/", method = RequestMethod.GET)
public class NewsArticleController {
	@Autowired
	private NewsArticleRepository newsArticleRepository;
	
    @GetMapping("articles")
    public List<NewsArticle> getArticle() {
//    	NewsArticleDAO dao = new NewsArticleDAO();
//		return dao.getNews();
    	System.out.println("woodo king22");
    	return newsArticleRepository.findAll();
    }
}