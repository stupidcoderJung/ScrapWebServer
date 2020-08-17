package com.scrapbot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableList;
import com.scrapbot.entity.NewsArticle;
import com.scrapbot.repository.NewsArticleRepository;
import com.scrapbot.service.NewsArticleService;

@Service
public class NewsArticleServiceImpl implements NewsArticleService{

	@Autowired
	NewsArticleRepository newsArticleRepostitory;

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<NewsArticle> selectNewsArticleList() {
		// TODO Auto-generated method stub
		return ImmutableList.copyOf(newsArticleRepostitory.findAll());
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Optional<NewsArticle> selectNewsArticle(Long id) {
		// TODO Auto-generated method stub
		return newsArticleRepostitory.findById(id);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void insertArticle(NewsArticle newsArticle) {
		// TODO Auto-generated method stub
		newsArticleRepostitory.save(newsArticle);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void updateArticle(NewsArticle newsArticle) {
		// TODO Auto-generated method stub
		newsArticleRepostitory.save(newsArticle);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub
		newsArticleRepostitory.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<NewsArticle> findByNewcompanyContaining(String newcompany) {
		// TODO Auto-generated method stub
		return ImmutableList.copyOf(newsArticleRepostitory.findByNewcompanyContaining(newcompany));
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<NewsArticle> findByRegdateIs(String regdate) {
		// TODO Auto-generated method stub
		return ImmutableList.copyOf(newsArticleRepostitory.findByRegdateIs(regdate));
	}

	
  
}