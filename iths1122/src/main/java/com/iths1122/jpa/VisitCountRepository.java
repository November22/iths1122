package com.iths1122.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsVisitCount;

public interface VisitCountRepository extends JpaRepository<HsVisitCount, String>{
	
	/**
	 * 根据ip地址查询访问对象
	 * @param ipAddr
	 * @return
	 */
	@Query("select visitCount from HsVisitCount visitCount where visitCount.ip = :ipAddr")
	public HsVisitCount findByIpAddr(@Param("ipAddr")String ipAddr);
	
	/**
	 * 统计访问者的数量
	 * @return
	 */
	@Query(value = "select count(vc_id) from hs_visit_count" ,nativeQuery = true)
	public int countVisitor();
}
