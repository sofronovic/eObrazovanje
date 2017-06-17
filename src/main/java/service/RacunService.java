package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import model.Racun;
import repository.RacunRepository;



public class RacunService {

	@Autowired
	RacunRepository racunRepository;
	
	public Racun findOne(Long id)
	{
		return racunRepository.findOne(id);
	}
	
	public List<Racun> findAll()
	{
		return racunRepository.findAll();
	}
	
	public Page<Racun> findAll(Pageable page)
	{
		return racunRepository.findAll(page);
	}
	
	public Racun save(Racun racun)
	{
		return racunRepository.save(racun);
	}
	
	public void remove(Long id)
	{
		racunRepository.delete(id);
	}
	
}
