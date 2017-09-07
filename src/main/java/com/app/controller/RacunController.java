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

import com.app.dto.RacunDTO;
import com.app.model.Racun;
import com.app.service.RacunService;


@RestController
@RequestMapping(value="api/racuni")
public class RacunController {

	@Autowired
	private RacunService racunService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<RacunDTO>> getAllRacuni()
	{
		List<Racun> racuni = racunService.findAll();
		List<RacunDTO> racuniDTO = new ArrayList<>();
		for(Racun r: racuni)
		{
			racuniDTO.add(new RacunDTO(r));
		}
		return new ResponseEntity<>(racuniDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Racun>> getRacuniPage(Pageable page)
	{
		Page<Racun> pageRacuni = racunService.findAll(page);
		List<Racun> racuni = new ArrayList<>();
		for(Racun r: pageRacuni)
		{
			racuni.add(r);
		}
		return new ResponseEntity<>(racuni, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<RacunDTO> getRacun(@PathVariable Long id)
	{
		Racun racun = racunService.findOne(id);
		if(racun == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new RacunDTO(racun), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<RacunDTO> saveRacun(@RequestBody RacunDTO racunDTO)
	{
		
		
		Racun r = new Racun();
		r.setBrojRacuna(racunDTO.getBrojRacuna());
		r.setBrojModela(racunDTO.getBrojModela());
		r.setPozivNaBroj(racunDTO.getPozivNaBroj());
		r.setStanje(racunDTO.getStanje());
		r = racunService.save(r);
		
		return new ResponseEntity<>(new RacunDTO(r), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<RacunDTO> updateRacun(@RequestBody RacunDTO racunDTO)
	{
		Racun racun = racunService.findOne(racunDTO.getId());
		if(racun == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		racun.setBrojRacuna(racunDTO.getBrojRacuna());
		racun.setBrojModela(racunDTO.getBrojModela());
		racun.setPozivNaBroj(racunDTO.getPozivNaBroj());
		racun.setStanje(racunDTO.getStanje());
		racun = racunService.save(racun);
		return new ResponseEntity<>(new RacunDTO(racun), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable long id)
	{
		Racun racun = racunService.findOne(id);
		if(racun != null)
		{
			racunService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

