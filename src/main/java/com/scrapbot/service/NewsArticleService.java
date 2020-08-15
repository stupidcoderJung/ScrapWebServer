package com.scrapbot.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.scrapbot.entity.NewsArticle;

public interface NewsArticleService {

	/** * 기사 목록 조회 * @return */
	public List<NewsArticle> selectNewsArticleList();

	/** * 기사 조회 * @param id * @return */
	public Optional<NewsArticle> selectNewsArticle(Long id);

	/** * 기사 등록 * @param user */
	public void insertArticle(NewsArticle newsArticle);

	/** * 기사 정보 수정 * @param user */
	public void updateArticle(NewsArticle newsArticle);

	/** * 기사 삭제 * @param id */
	public void deleteArticle(Long id);
	
	/** * 신문사 별로 목록 조회 * @param newcompany */
	public List<NewsArticle> findByNewcompanyContaining(String newcompany);
	
	/** * 날짜 별로 목록 조회 * @param localDate */
	public List<NewsArticle> findByRegdateContaining(String date);


}
