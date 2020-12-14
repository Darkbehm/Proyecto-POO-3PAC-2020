package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.LoteMateriaPrima;

public interface RepositoryLoteMateriaPrima extends JpaRepository<LoteMateriaPrima, Integer> {
	public  LoteMateriaPrima findById(int id);
}
