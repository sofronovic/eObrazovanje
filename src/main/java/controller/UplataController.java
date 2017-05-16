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

import dto.UplataDTO;
import model.Student;
import model.Uplata;
import service.StudentService;
import service.UplataService;


@RestController
@RequestMapping(value="api/uplate")
public class UplataController {

	
	@Autowired
	private UplataService uplataService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<UplataDTO>> getAllUplate() {
		List<Uplata> uplate = uplataService.findAll();
		List<UplataDTO> uplataDTO = new ArrayList<>();
		for(Uplata d : uplate)
		{
			uplataDTO.add(new UplataDTO(d));
		}
		return new ResponseEntity<>(uplataDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Uplata>> getUplatePage(Pageable page){
		Page<Uplata> pageUplate = uplataService.findAll(page);
		List<Uplata> uplate = new ArrayList<>();
		for(Uplata u : pageUplate){
			uplate.add(u);
		}
		return new ResponseEntity<>(uplate, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UplataDTO> getUplata(@PathVariable Long id){
		Uplata uplate = uplataService.findOne(id);
		if(uplate == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UplataDTO(uplate), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<UplataDTO> saveUplata(@RequestBody UplataDTO uplataDTO){
		
		if(uplataDTO.getStudent() == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findOne(uplataDTO.getStudent().getId());
		if(student == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Uplata u = new Uplata();
		u.setOpis(uplataDTO.getOpis());
		u.setIznos(uplataDTO.getIznos());
		u.setDatum(uplataDTO.getDatum());
		u.setStudent(student);
		
		u = uplataService.save(u);
		return new ResponseEntity<>(new UplataDTO(u), HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<UplataDTO> updateUplata(@RequestBody UplataDTO uplataDTO){
		
		Uplata uplata = uplataService.findOne(uplataDTO.getId()); 
		if (uplata == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		uplata.setIznos(uplataDTO.getIznos());
		uplata.setOpis(uplataDTO.getOpis());
		uplata.setDatum(uplataDTO.getDatum());
		uplata = uplataService.save(uplata);
		return new ResponseEntity<>(new UplataDTO(uplata), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Uplata uplata = uplataService.findOne(id);
		if (uplata != null){
			uplataService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
