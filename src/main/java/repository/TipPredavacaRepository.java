package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.TipPredavaca;

public interface TipPredavacaRepository extends JpaRepository<TipPredavaca, Long> {
	public TipPredavaca findTipPredavacaByNaziv(String naizv);

}
