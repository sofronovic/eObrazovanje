package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Dokument;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {
	
}
