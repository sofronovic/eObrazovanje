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

import com.app.dto.PredavanjePredmetaDTO;
import com.app.model.Predavac;
import com.app.model.PredavanjePredmeta;
import com.app.service.PredavacService;
import com.app.service.PredavanjePredmetaService;

@RestController
@RequestMapping(value="api/predavanjePredmeta")
public class PredavanjePredmetaController {
	
	@Autowired
	private PredavanjePredmetaService predavanjePredmetaService;
	
	@Autowired
	private PredavacService predavacService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PredavanjePredmetaDTO>> getAllPredavanjeP(){
		List<PredavanjePredmeta> predavanjeP = predavanjePredmetaService.findAll();
		List<PredavanjePredmetaDTO> ppDTO = new ArrayList<>();
		for (PredavanjePredmeta p : predavanjeP) {
			ppDTO.add(new PredavanjePredmetaDTO(p));
		}
		return new ResponseEntity<>(ppDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PredavanjePredmeta>> getPredavanjePPage(Pageable page){
		Page<PredavanjePredmeta> pagePP = predavanjePredmetaService.findAll(page);
		List<PredavanjePredmeta> predavanjeP = new ArrayList<>();
		for (PredavanjePredmeta p : pagePP) {
			predavanjeP.add(p);
		}
		return new ResponseEntity<>(predavanjeP, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<PredavanjePredmetaDTO> getPredavanjeP(@PathVariable Long id){
		PredavanjePredmeta predavanjeP = predavanjePredmetaService.findOne(id);
		if (predavanjeP == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new PredavanjePredmetaDTO(predavanjeP), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredavanjePredmetaDTO> savePredavanjeP(@RequestBody PredavanjePredmetaDTO predavanjePredmetaDTO){
		
		if(predavanjePredmetaDTO.getPredavac() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Predavac predavac = predavacService.findOne(predavanjePredmetaDTO.getPredavac().getId());
		if(predavac == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		PredavanjePredmeta pp = new PredavanjePredmeta();
		pp.setPredavac(predavac);
		
		pp = predavanjePredmetaService.save(pp);
		return new ResponseEntity<>(new PredavanjePredmetaDTO(pp), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PredavanjePredmetaDTO> updatePredavanjeP(@RequestBody PredavanjePredmetaDTO predavanjePredmetaDTO){
		
		PredavanjePredmeta predavanjeP = predavanjePredmetaService.findOne(predavanjePredmetaDTO.getId());
		if(predavanjeP == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		predavanjeP = predavanjePredmetaService.save(predavanjeP);
		return new ResponseEntity<>(new PredavanjePredmetaDTO(predavanjeP), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredavanjeP(@PathVariable Long id){
		PredavanjePredmeta predavanjeP = predavanjePredmetaService.findOne(id);
		if (predavanjeP != null){
			predavanjePredmetaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
