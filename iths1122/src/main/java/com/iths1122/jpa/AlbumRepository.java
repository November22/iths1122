package com.iths1122.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iths1122.model.HsAlbum;

public interface AlbumRepository extends JpaRepository<HsAlbum, String>{
	
}
