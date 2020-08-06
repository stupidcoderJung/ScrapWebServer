package com.scrapbot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scrapbot.entity.entities.NewsArticle;
import com.scrapbot.repository.NewsArticleRepository;

@Service
public class NewsArticleService {

	private final NewsArticleRepository newsArticleRepostitory;

	@Autowired
	public NewsArticleService(NewsArticleRepository newsArticleRepostitory) {
		this.newsArticleRepostitory = newsArticleRepostitory;
	}
  
	@Transactional(readOnly = true)
	public Optional<NewsArticle> findById(int id) {
		return newsArticleRepostitory.findById(id);
	}
  
  
	public List<NewsArticle> findAll(){  
		return newsArticleRepostitory.findAll();
	}

	public List<NewsArticle> findByNewcompanyLike(String newcompany) {
		// TODO Auto-generated method stub
		return newsArticleRepostitory.findByNewcompanyLike(newcompany);
	}
  
}