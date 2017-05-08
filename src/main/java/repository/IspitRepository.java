package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Ispit;

public interface IspitRepository extends JpaRepository<Ispit, Long>{
	public Ispit findIspitByType(String tip);

}
