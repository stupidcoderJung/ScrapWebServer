package com.scrapbot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrapbot.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	// all user search
	List<User> findAll();
	
	// 기사 id값으로 user search
	Optional<User> findById(int id);
	
	// 신문사별로 기사정보 search
	// 하이버네이트는 명명규칙이 중요한가 보다 findBy + 테이블컬럼명 + Like 이렇게해야 기능작동됨.
	// List<User> findByNewcompanyLike(String name);
	
	
	//List<NewsArticle> findByMailEndingWith(String mail);

}

