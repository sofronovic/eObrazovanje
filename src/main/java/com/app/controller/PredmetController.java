package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PredmetDTO;
import com.app.model.Predmet;
import com.app.model.Student;
import com.app.model.StudijskiProgram;
import com.app.service.PredmetService;
import com.app.service.StudijskiProgramService;

@RestController
@RequestMapping(value = "api/predmeti")
public class PredmetController {
	
	@Autowired
	private PredmetService predmetService;

	@Autowired
	private  StudijskiProgramService studProgramService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Predmet>> getAllSubjects() {
		List<Predmet> subjects = predmetService.findAll();
		
		return new ResponseEntity<>(subjects, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Predmet> getSubject(@PathVariable Long id){
		Predmet subject = predmetService.findOne(id);
		if(subject == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(subject, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredmetDTO> saveSubject(@RequestBody PredmetDTO subjectDTO){

		StudijskiProgram studijskiProgram = studProgramService.findOne(subjectDTO.getStudijskiProgram().getId());
		Predmet p = new Predmet();
		p.setNaziv(subjectDTO.getNaziv());
		p.setOznaka(subjectDTO.getOznaka());
		p.setECTS(subjectDTO.getECTS());
		p.setStudijskiProgram(studijskiProgram);
		
		p = predmetService.save(p);
		
		return new ResponseEntity<>(new PredmetDTO(p), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Predmet> updateSubject(@RequestBody Predmet s){
		Predmet subject = predmetService.findOne(s.getId()); 
		if (subject == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		subject = predmetService.save(subject);
		return new ResponseEntity<>(subject, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSubject(@PathVariable Long id){
		Predmet subject = predmetService.findOne(id); 
		if (subject != null){
			predmetService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
