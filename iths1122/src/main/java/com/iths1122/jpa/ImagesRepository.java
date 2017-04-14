package com.iths1122.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsImages;

/**
 * 相片表的dao
 * @author iths
 *
 */
public interface ImagesRepository extends JpaRepository<HsImages, String>{
	
	/**
	 * 根据相册的id查找图片
	 * @param albumId
	 * @return
	 */
	@Query(value = "select * from hs_images where album_id = :albumId " , nativeQuery = true)
	public List<HsImages> findAllByAlbumId(@Param("albumId")String albumId);
	
	/**
	 * 根据相册ID和图片id删除图片
	 * @param imgId
	 * @param albumId
	 * @return
	 */
	@Modifying
	@Query(value = "delete from hs_images where image_id = :imgId and album_id = :albumId" , nativeQuery = true)
	public int deleteByImageIdAndAlbumId(@Param("imgId")String imgId, @Param("albumId")String albumId);
	
	/**
	 * 根据相册表的id和图片id，确定照片的，从而修改名称
	 * @param imgId
	 * @param albumId
	 * @return
	 */
	@Modifying
	@Query(value = "update hs_images "
			+ " set image_name = :imgName "
			+ " where image_id = :imgId and album_id = :albumId" ,nativeQuery = true)
	public int updateImagsNameByImageIdAndAlbumId(@Param("imgName") String imgName ,
			@Param("imgId")String imgId, @Param("albumId")String albumId);
	
}	
