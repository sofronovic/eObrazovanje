package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.model.Predavac;
import com.app.repository.PredavacRepository;

@Service
public class PredavacService {
	
	@Autowired
	PredavacRepository predavacRepository;
	
	public Predavac findOne(Long id){
		return predavacRepository.findOne(id);
	}
	
	public List<Predavac> findAll(){
		return predavacRepository.findAll();
	}
	
	public Page<Predavac> findAll(Pageable page){
		return predavacRepository.findAll(page);
	}
	
	public Predavac save(Predavac predavac){
		return predavacRepository.save(predavac);
	}
	
	public void remove(Long id){
		predavacRepository.delete(id);
	}
}
