package com.iths1122.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iths1122.model.HsAlbum;

public interface ArticleRepository extends JpaRepository<HsAlbum, String>{
	
}
