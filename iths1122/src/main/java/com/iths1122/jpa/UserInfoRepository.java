package com.iths1122.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iths1122.model.HsUserinfo;

public interface UserInfoRepository extends JpaRepository<HsUserinfo, String>{

}
