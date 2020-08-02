package com.scrapbot.entity.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "news_company")
public class NewsCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String companyName;
	
	@Column
	private String companyIdOnNaver;


	@ManyToMany(mappedBy = "newsCompanySet")
	Set<User> userSet;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyIdOnNaver() {
		return companyIdOnNaver;
	}


	public void setCompanyIdOnNaver(String companyIdOnNaver) {
		this.companyIdOnNaver = companyIdOnNaver;
	}


	public Set<User> getUserSet() {
		return userSet;
	}


	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}


	
	
}
