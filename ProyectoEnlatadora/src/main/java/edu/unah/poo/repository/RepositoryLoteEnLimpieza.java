package edu.unah.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Limpieza;
import edu.unah.poo.model.LoteEnLimpieza;

public interface RepositoryLoteEnLimpieza extends JpaRepository<LoteEnLimpieza, Integer> {
	public LoteEnLimpieza findById(int id);
	
	public List<LoteEnLimpieza> findByLimpieza(Limpieza limpieza);
}
