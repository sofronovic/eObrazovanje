
package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.model.Ispit;
import com.app.repository.IspitRepository;

@Service
public class IspitService {
	
	@Autowired
	private IspitRepository ispitRepository;
	
	public Ispit findOne(Long id){
		return ispitRepository.findOne(id);
	}
	
	public List<Ispit> findAll(){
		return ispitRepository.findAll();
	}
	
	public Page<Ispit> findAll(Pageable page){
		return ispitRepository.findAll(page);
	}
	
	
	public Ispit save(Ispit ispit){
		return ispitRepository.save(ispit);
	}
	
	public void remove(Long id){
		ispitRepository.delete(id);
	}

}
