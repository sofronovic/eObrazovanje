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

import dto.IspitDTO;
import model.Ispit;
import model.PohadjanjePredmeta;
import model.Student;
import service.IspitService;
import service.PohadjanjePredmetaService;
import service.StudentService;

@RestController
@RequestMapping(value = "api/ispiti")
public class IspitController {
	
	@Autowired
	private IspitService ispitService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PohadjanjePredmetaService pohadjanjePService;
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public ResponseEntity<List<IspitDTO>> getAllExams(){
		
		List<Ispit> exams = ispitService.findAll();
		List<IspitDTO> examsDTO = new ArrayList<>();
		for(Ispit i : exams){
			examsDTO.add(new IspitDTO(i));
		}
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<IspitDTO> getExam(@PathVariable Long id){
		
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new IspitDTO(ispit), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<IspitDTO> saveExam(@RequestBody IspitDTO ispitDTO){
		
		if(ispitDTO.getStudent() == null || ispitDTO.getPohadjanjePredmeta() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findOne(ispitDTO.getStudent().getId());
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePService.findOne(ispitDTO.getPohadjanjePredmeta().getId());

		if (student == null || pohadjanjePredmeta == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Ispit ispit = new Ispit();
		ispit.setTip(ispitDTO.getTip());
		ispit.setOcena(ispitDTO.getOcena());
		ispit.setBodovi(ispitDTO.getBodovi());
		ispit.setStudent(student);
		ispit.setPohadjanjePredmeta(pohadjanjePredmeta);
		
		ispit = ispitService.save(ispit);
		return new ResponseEntity<>(new IspitDTO(ispit), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<IspitDTO> updateExam(@RequestBody IspitDTO ispitDTO){
		
		Ispit ispit = ispitService.findOne(ispitDTO.getId());
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ispit.setTip(ispitDTO.getTip());
		ispit.setBodovi(ispitDTO.getBodovi());
		ispit.setOcena(ispitDTO.getOcena());
		
		ispit = ispitService.save(ispit);
		return new ResponseEntity<>(new IspitDTO(ispit), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExam(@PathVariable Long id){
		
		Ispit ispit = ispitService.findOne(id);
		
		if(ispit !=null){
			ispitService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
