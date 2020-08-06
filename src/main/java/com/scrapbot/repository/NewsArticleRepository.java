package com.scrapbot.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrapbot.entity.entities.NewsArticle;


@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long>{
	List<NewsArticle> findAll();
	Optional<NewsArticle> findById(int id);
	
	List<NewsArticle> findByNewcompanyLike(String name);
	//List<NewsArticle> findByMailEndingWith(String mail);

//	Optional<NewsArticle> findByName(String name);
	
	//List<NewsArticle> findAllByNameContains(String name);
}

