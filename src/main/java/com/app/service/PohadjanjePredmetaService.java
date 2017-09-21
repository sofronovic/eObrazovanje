
package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.model.Pohadjanje;
import com.app.repository.PohadanjePredmetaRepository;

@Service
public class PohadjanjePredmetaService {

	@Autowired
	PohadanjePredmetaRepository pohadanjePRepository;
	
	public Pohadjanje findOne(Long id){
		return pohadanjePRepository.findOne(id);
	}
	
	public List<Pohadjanje> findAll(){
		return pohadanjePRepository.findAll();
	}
	
	public Page<Pohadjanje> findAll(Pageable page){
		return pohadanjePRepository.findAll(page);
	}
	
	
	public Pohadjanje save(Pohadjanje student){
		return pohadanjePRepository.save(student);
	}
	
	public void remove(Long id){
		pohadanjePRepository.delete(id);
	}
	
}
