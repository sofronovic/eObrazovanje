package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Dokument;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {
	
}
