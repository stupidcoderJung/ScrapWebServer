package com.scrapbot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scrapbot.entity.daos.NewsArticleDAO;
import com.scrapbot.entity.entities.NewsArticle;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "api/", method = RequestMethod.GET)
public class NewsArticleController {
    @GetMapping("articles")
    public List<NewsArticle> getArticle() {
		NewsArticleDAO dao = new NewsArticleDAO();
//		ArrayList<String> articlesNames= new ArrayList<>();
//		dao.getNews().forEach(article->{
//			articlesNames.add(article.getTitle());
//		});
		return dao.getNews();
    }
}