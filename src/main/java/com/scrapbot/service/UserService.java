package com.scrapbot.service;

import java.util.List;
import java.util.Optional;

import com.scrapbot.entity.User;

public interface UserService {

	/** * 사용자 목록 조회 * @return */
	public List<User> selectUserList();

	/** * 사용자 조회 * @param uid * @return */
	public Optional<User> selectUser(Long id);

	/** * 사용자 등록 * @param user */
	public void insertUser(User user);

	/** * 사용자 정보 수정 * @param user */
	public void updateUser(User user);

	/** * 사용자 삭제 * @param uid */
	public void deleteUser(Long id);

}
