package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.TipPredavaca;

public interface TipPredavacaRepository extends JpaRepository<TipPredavaca, Long> {
	public TipPredavaca findTipPredavacaByNaziv(String naizv);

}
