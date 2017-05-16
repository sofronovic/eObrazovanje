package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Predavac;

public interface PredavacRepository extends JpaRepository<Predavac, Long>{
	
}
