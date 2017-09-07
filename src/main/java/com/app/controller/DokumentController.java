package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DokumentDTO;
import com.app.model.Dokument;
import com.app.model.Student;
import com.app.service.DokumentService;
import com.app.service.StudentService;

@RestController
@RequestMapping(value = "api/dokumenti")
public class DokumentController {
	
	@Autowired
	private DokumentService dokumentService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<DokumentDTO>> getAllDocuments(){
		
		List<Dokument> dokumenti = dokumentService.findAll();
		List<DokumentDTO> dokumentDTO = new ArrayList<>();
		for(Dokument d : dokumenti){
			dokumentDTO.add(new DokumentDTO(d));
		}
		
		return new ResponseEntity<>(dokumentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DokumentDTO> getDocument(@PathVariable Long id){
		
		Dokument dokument = dokumentService.findOne(id);
		if(dokument == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new DokumentDTO(dokument), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DokumentDTO> saveDocument(@RequestBody DokumentDTO dokumentDTO){
		
		if(dokumentDTO.getStudent() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findOne(dokumentDTO.getStudent().getId());
		if (student == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Dokument dokument = new Dokument();
		dokument.setNaziv(dokumentDTO.getNaziv());
		dokument.setStudent(student);
		
		dokument = dokumentService.save(dokument);
		return new ResponseEntity<>(new DokumentDTO(dokument), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<DokumentDTO> updateStudent(@RequestBody DokumentDTO dokumentDTO){
		
		Dokument dokument = dokumentService.findOne(dokumentDTO.getId()); 
		if (dokument == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		dokument.setNaziv(dokumentDTO.getNaziv());
		
		dokument = dokumentService.save(dokument);
		return new ResponseEntity<>(new DokumentDTO(dokument), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDocument(@PathVariable Long id){
		
		Dokument dokument = dokumentService.findOne(id);
		if (dokument != null){
			dokumentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
