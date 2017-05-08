package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import model.PohadjanjePredmeta;
import repository.PohadanjePredmetaRepository;

@Service
public class PohadjanjePredmetaService {

	@Autowired
	PohadanjePredmetaRepository pohadanjePRepository;
	
	public PohadjanjePredmeta findOne(Long id){
		return pohadanjePRepository.findOne(id);
	}
	
	public List<PohadjanjePredmeta> findAll(){
		return pohadanjePRepository.findAll();
	}
	
	public Page<PohadjanjePredmeta> findAll(Pageable page){
		return pohadanjePRepository.findAll(page);
	}
	
	
	public PohadjanjePredmeta save(PohadjanjePredmeta student){
		return pohadanjePRepository.save(student);
	}
	
	public void remove(Long id){
		pohadanjePRepository.delete(id);
	}
	
}
