package com.iths1122.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsUserinfo;

public interface UserInfoRepository extends JpaRepository<HsUserinfo, String>{
	
	@Query("select user from HsUserinfo user where user.email = :email and user.password = :password")
	public HsUserinfo findByUsernameAndPassword(@Param("email")String email, @Param("password")String password);

}
