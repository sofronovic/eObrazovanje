package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.model.StudijskiProgram;
import com.app.repository.StudijskiProgramRepository;

@Service
public class StudijskiProgramService {

	@Autowired
	private StudijskiProgramRepository studijskiProgramRepository;
	
	public StudijskiProgram findOne(Long id){
		return studijskiProgramRepository.findOne(id);
	}
	
	public List<StudijskiProgram> findAll(){
		return studijskiProgramRepository.findAll();
	}
	
	public Page<StudijskiProgram> findAll(Pageable page){
		return studijskiProgramRepository.findAll(page);
	}
	
	public StudijskiProgram save(StudijskiProgram studijskiProgram){
		return studijskiProgramRepository.save(studijskiProgram);
	}
	
	public void remove(Long id){
		studijskiProgramRepository.delete(id);
	}
}
