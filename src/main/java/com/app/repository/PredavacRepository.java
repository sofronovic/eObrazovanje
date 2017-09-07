package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Predavac;

public interface PredavacRepository extends JpaRepository<Predavac, Long>{
	
}
