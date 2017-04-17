package com.iths1122.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsShare;

public interface ShareRepository extends JpaRepository<HsShare, String>{
	
	/**
	 * 根据用户id，查找所有的分享
	 * @param userId
	 * @return
	 */
	@Query("select share from HsShare share where share.userId = :userId")
	public List<HsShare> findAllByUserId(@Param("userId")String userId);
	
	/**
	 * 根据分享ID和用户ID删除一个分享
	 * @param shareId
	 * @param userId
	 * @return
	 */
	@Modifying
	@Query(value = "delete from hs_share where share_id = :shareId and user_id = :userId" ,nativeQuery = true)
	public int deleteByShareIdAndUserId(@Param("shareId")String shareId , @Param("userId")String userId);
}
