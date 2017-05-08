package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import model.Dokument;
import repository.DokumentRepository;

@Service
public class DokumentService {

	@Autowired
	private DokumentRepository dokumentRepository;
	
	public Dokument findOne(Long id){
		return dokumentRepository.findOne(id);
	}
	
	public List<Dokument> findAll(){
		return dokumentRepository.findAll();
	}
	
	public Page<Dokument> findAll(Pageable page){
		return dokumentRepository.findAll(page);
	}
	
	
	public Dokument save(Dokument dokument){
		return dokumentRepository.save(dokument);
	}
	
	public void remove(Long id){
		dokumentRepository.delete(id);
	}

}
