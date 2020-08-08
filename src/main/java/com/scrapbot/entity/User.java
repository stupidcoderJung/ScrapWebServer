package com.scrapbot.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String kakaoID;
	
	@ElementCollection
	private List<String> keywords=new ArrayList<String>();

	@ManyToMany
	@JoinTable(name = "news_set", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "newscompany_id"))
	private Set<NewsCompany> newsCompanySet;
	
	@Column
	private String grade;
	
	
}

