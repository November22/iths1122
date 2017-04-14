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
	
	@Query("select album from HsAlbum album where album.albumId = :albumId and album.userId = :userId" )
	public HsAlbum findByAlbumIdAndUesrId(@Param("albumId")String albumId , @Param("userId")String userId);
	
	
	/**
	 * 根据用户的ID和对应的相册ID，删除一个相册
	 * ****考虑如果拿到用户的ID和相册名，那么都可以删除相册了，如果进行校验
	 * 如果将user的id通过session来获取，不通过前台传入，那么，前台传入的userid就是无效的
	 * @param albumId
	 * @param userId
	 * @return
	 */
	@Modifying
	@Query(value = "delete from hs_album where user_id = :userId and album_id = :albumId" , nativeQuery = true)
	public int deleteAlbumByUserIdAndAlbumId(@Param("albumId")String albumId , @Param("userId")String userId);
	
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
			+ " where album.albumId = :albumId and album.userId = :userId")
	public int update(@Param("albumName")String albumName ,
			@Param("description")String description ,@Param("albumId")String albumId , @Param("userId")String userId);
	
}
