package com.scrapbot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrapbot.entity.entities.NewsArticle;


@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long>{

}
