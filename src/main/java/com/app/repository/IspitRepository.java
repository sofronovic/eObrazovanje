package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Ispit;

public interface IspitRepository extends JpaRepository<Ispit, Long>{
	public Ispit findIspitByTip(String tip);

}
