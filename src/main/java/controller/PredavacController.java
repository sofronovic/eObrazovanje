package controller;

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

import dto.PredavacDTO;
import model.Predavac;
import model.TipPredavaca;
import service.PredavacService;

@RestController
@RequestMapping(value="api/predavaci")
public class PredavacController {
	
	@Autowired
	private PredavacService predavacService;
	
	@Autowired
	private TipPredavacaService tipPredavacaService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PredavacDTO>> getAllPredavaci(){
		
		List<Predavac> predavaci = predavacService.findAll();
		List<PredavacDTO> predavacDTO = new ArrayList<>();
		for (Predavac p : predavaci) {
			predavacDTO.add(new PredavacDTO(p));
		}
		return new ResponseEntity<>(predavacDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Predavac>> getPredavaciPage(Pageable page){
		Page<Predavac> pagePredavaci = predavacService.findAll(page);
		List<Predavac> predavaci = new ArrayList<>();
		for (Predavac p : pagePredavaci) {
			predavaci.add(p);
		}
		return new ResponseEntity<>(predavaci, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredavacDTO> getPredavac(@PathVariable Long id){
		
		Predavac predavac = predavacService.findOne(id);
		if (predavac == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new PredavacDTO(predavac), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredavacDTO> savePredavac(@RequestBody PredavacDTO predavacDTO){
		
		if(predavacDTO.getTipPredavaca() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		TipPredavaca tipPredavaca = tipPredavacaService.findOne(predavacDTO.getTipPredavaca().getId());
		if (tipPredavaca == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Predavac p = new Predavac();
		p.setTipPredavaca(tipPredavaca);
		
		p = predavacService.save(p);
		return new ResponseEntity<>(new PredavacDTO(p), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PredavacDTO> updatePredavac(@RequestBody PredavacDTO predavacDTO){
		
		Predavac predavac = predavacService.findOne(predavacDTO.getId());
		if (predavac == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	    predavac = predavacService.save(predavac);
	    return new ResponseEntity<>(new PredavacDTO(predavac), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredavac(@PathVariable Long id){
		Predavac predavac = predavacService.findOne(id);
		if (predavac != null){
			predavacService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
}
