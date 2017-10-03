package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {

}
