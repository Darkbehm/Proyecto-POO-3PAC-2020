package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Limpieza;

public interface RepositoryLimpieza extends JpaRepository<Limpieza, Integer> {
	public Limpieza findById(int id);
}
