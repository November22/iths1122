package com.iths1122.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsLeaveWord;

public interface LeaveWordRepository extends JpaRepository<HsLeaveWord, String>{
	
	@Query("select leaveWord from HsLeaveWord leaveWord where leaveWord.userId = :userId")
	public List<HsLeaveWord> findAllByUserId(@Param("userId")String userId);
}
