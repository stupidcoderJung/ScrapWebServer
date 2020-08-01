package com.scrapbot.entity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "articletable")
public class NewsArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name ="newcompany")
	private String newcompany;
	
	@Column(name ="title")
	private String title;
	
	@Column(name="topornot")
	private boolean topornot;
	
	@Column(name="pagenumber")
	private String pagenumber;
	
	@Column(name="urlpath")
	private String url;
	
//	@Column(columnDefinition="TEXT",name="text")
//	private String text;

//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewcompany() {
		return newcompany;
	}

	public void setNewcompany(String newcompany) {
		this.newcompany = newcompany;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isTopornot() {
		return topornot;
	}

	public void setTopornot(boolean topornot) {
		this.topornot = topornot;
	}

	public String getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(String pagenumber) {
		this.pagenumber = pagenumber;
	}
}
