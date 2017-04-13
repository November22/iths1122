package com.iths1122.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsAlbum;

/**
 * 相册表的DAO
 * @author iths
 *
 */
public interface AlbumRepository extends JpaRepository<HsAlbum, String>{
	
	/**
	 * 查找属于该用户的所有相册
	 * @param userId
	 * @return
	 */
	@Query(value = "select * from hs_album where user_id = :userId" , nativeQuery = true )
	public List<HsAlbum> findAllByUserId(@Param("userId")String userId);
	
	/**
	 * 根据相册id，修改相册信息
	 * @param albumName
	 * @param description
	 * @param albumId
	 * @return
	 */
	@Modifying
	@Query("update HsAlbum album "
			+ " set "
			+ " album.albumName = :albumName ,album.description = :description "
			+ " where album.albumId = :albumId")
	public int update(@Param("albumName")String albumName ,
			@Param("description")String description ,@Param("albumId")String albumId);
	
}
