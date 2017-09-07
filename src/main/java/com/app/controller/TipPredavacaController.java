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
import com.app.model.TipPredavaca;
import com.app.service.TipPredavacaService;

@RestController
@RequestMapping(value = "api/tipoviPredavaca")
public class TipPredavacaController {
	
	@Autowired
	private TipPredavacaService tipPredavacaService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<TipPredavaca>> getAllTipoviPredavaca(){
		List<TipPredavaca> tipoviPredavaca = tipPredavacaService.findAll();
		
		return new ResponseEntity<>(tipoviPredavaca, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipPredavaca>> getTipoviPredavacaPage(Pageable page){
		Page<TipPredavaca> pageTipoviPredavaca = tipPredavacaService.findAll(page);
		List<TipPredavaca> tipoviPredavaca = new ArrayList<>();
		for(TipPredavaca s : pageTipoviPredavaca){
			tipoviPredavaca.add(s);
		}
		return new ResponseEntity<>(tipoviPredavaca, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TipPredavaca> getTipPredavaca(@PathVariable Long id){
		TipPredavaca tipPredavaca = tipPredavacaService.findOne(id);
		if(tipPredavaca == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tipPredavaca, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TipPredavaca> saveTipPredavaca(@RequestBody TipPredavaca tipPredavaca){
		TipPredavaca t = new TipPredavaca();
		t = tipPredavacaService.save(t);
		
		return new ResponseEntity<>(tipPredavaca, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TipPredavaca> updateTipPredavaca(@RequestBody TipPredavaca t){
		TipPredavaca tipPredavaca = tipPredavacaService.findOne(t.getId()); 
		if (tipPredavaca == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		tipPredavaca = tipPredavacaService.save(tipPredavaca);
		return new ResponseEntity<>(tipPredavaca, HttpStatus.OK);	
	}
	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTipPredavaca(@PathVariable Long id){
		TipPredavaca tipPredavaca = tipPredavacaService.findOne(id);
		if (tipPredavaca != null){
			tipPredavacaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	

}
