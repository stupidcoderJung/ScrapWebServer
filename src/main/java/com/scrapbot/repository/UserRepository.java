package com.scrapbot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scrapbot.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	// kakaoid
	//List<User> findByKakaoid(String kakaoid);

	
	// 신문사별로 기사정보 search
	// 하이버네이트는 명명규칙이 중요한가 보다 findBy + 테이블컬럼명 + Like 이렇게해야 기능작동됨.
	// List<User> findByNewcompanyLike(String name);
	
	
	//List<NewsArticle> findByMailEndingWith(String mail);

}

