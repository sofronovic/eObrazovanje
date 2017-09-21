package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.StudijskiProgram;
import com.app.service.StudijskiProgramService;

@RestController
@RequestMapping(value = "api/studijskiProgrami")
public class StudijskiProgramController {
	
	@Autowired
	private StudijskiProgramService studijskiProgramService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudijskiProgram>> getAllStudijskiProgrami(){
		List<StudijskiProgram> studijskiProgrami = studijskiProgramService.findAll();
		
		return new ResponseEntity<>(studijskiProgrami, HttpStatus.OK);
	}
	
/*	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudijskiProgram>> getStudijskiProgramiPage(Pageable page){
		Page<StudijskiProgram> pageStudijskiProgrami = studijskiProgramService.findAll(page);
		List<StudijskiProgram> studijskiProggrami = new ArrayList<>();
		for(StudijskiProgram s : pageStudijskiProgrami){
			studijskiProggrami.add(s);
		}
		return new ResponseEntity<>(studijskiProggrami, HttpStatus.OK);
	}*/
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudijskiProgram> getStudijskiProgram(@PathVariable Long id){
		StudijskiProgram studijskiProgram = studijskiProgramService.findOne(id);
		if(studijskiProgram == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studijskiProgram, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudijskiProgram> saveStudijskiProgram(@RequestBody StudijskiProgram studijskiProgram){
		studijskiProgram = studijskiProgramService.save(studijskiProgram);
		
		return new ResponseEntity<>(studijskiProgram, HttpStatus.CREATED);
	}
	
	

	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudijskiProgram> updateStudijskiProgram(@RequestBody StudijskiProgram s){
		StudijskiProgram studijskiProgram = studijskiProgramService.findOne(s.getId()); 
		if (studijskiProgram == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		studijskiProgram = studijskiProgramService.save(studijskiProgram);
		return new ResponseEntity<>(studijskiProgram, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudijskiProgram(@PathVariable Long id){
		StudijskiProgram studijskiProgram = studijskiProgramService.findOne(id);
		if (studijskiProgram != null){
			studijskiProgramService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	

}
