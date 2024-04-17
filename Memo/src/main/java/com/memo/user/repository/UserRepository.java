package com.memo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public UserEntity findByLoginId(String loginId);
}
