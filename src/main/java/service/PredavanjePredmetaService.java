package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import model.PredavanjePredmeta;
import repository.PredavanjePredmetaRepository;

public class PredavanjePredmetaService {
	
	@Autowired
	PredavanjePredmetaRepository predavanjePredmetaRepository;
	
	public PredavanjePredmeta findOne(Long id)
	{
		return predavanjePredmetaRepository.findOne(id);
	}	
	
	public List<PredavanjePredmeta> findAll()
	{
		return predavanjePredmetaRepository.findAll();
	}
	
	public Page<PredavanjePredmeta> findAll(Pageable page)
	{
		return predavanjePredmetaRepository.findAll(page);
	}
	
	public PredavanjePredmeta save(PredavanjePredmeta p)
	{
		return predavanjePredmetaRepository.save(p);
	}
	
	public void remove(Long id)
	{
		predavanjePredmetaRepository.delete(id);
	}
}
