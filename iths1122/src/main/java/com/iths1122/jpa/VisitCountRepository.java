package com.iths1122.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iths1122.model.HsVisitCount;

public interface VisitCountRepository extends JpaRepository<HsVisitCount, String>{

}
