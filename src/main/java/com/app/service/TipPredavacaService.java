package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.model.TipPredavaca;
import com.app.repository.TipPredavacaRepository;

@Service
public class TipPredavacaService {
	

	@Autowired
	TipPredavacaRepository tipPredavacaRepository;
	
	public TipPredavaca findOne(Long id){
		return tipPredavacaRepository.findOne(id);
	}
	
	public List<TipPredavaca> findAll(){
		return tipPredavacaRepository.findAll();
	}
	
	public Page<TipPredavaca> findAll(Pageable page){
		return tipPredavacaRepository.findAll(page);
	}
	
	
	public TipPredavaca save(TipPredavaca tipPredavaca){
		return tipPredavacaRepository.save(tipPredavaca);
	}
	
	public void remove(Long id){
		tipPredavacaRepository.delete(id);
	}
	

}
