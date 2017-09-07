package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.model.PredavanjePredmeta;
import com.app.repository.PredavanjePredmetaRepository;

@Service
public class PredavanjePredmetaService {
	
	@Autowired
	PredavanjePredmetaRepository predavanjePredmetaRepository;
	
	public List<PredavanjePredmeta> findAll(){
		return predavanjePredmetaRepository.findAll();
	}
	
	public PredavanjePredmeta findOne(Long id){
		return predavanjePredmetaRepository.findOne(id);
	}
	
	public Page<PredavanjePredmeta> findAll(Pageable page){
		return predavanjePredmetaRepository.findAll(page);
	}
	
	public PredavanjePredmeta save(PredavanjePredmeta predavanjePredmeta){
		return predavanjePredmetaRepository.save(predavanjePredmeta);
	}
	
	public void remove(Long id){
		predavanjePredmetaRepository.delete(id);
	}
	
}
