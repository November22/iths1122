package com.iths1122.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsImages;

public interface ImagesRepository extends JpaRepository<HsImages, String>{
	
	@Modifying
	@Query("update HsImages img "
			+ " set "
			+ " img.imageName = :imageName , img.imageUrl = :imageUrl "
			+ " where img.imageId = :imageId")
	public int update(@Param("imageName")String imgName,
			@Param("imageUrl")String imgUrl ,@Param("imageId")String imageId);
}	
