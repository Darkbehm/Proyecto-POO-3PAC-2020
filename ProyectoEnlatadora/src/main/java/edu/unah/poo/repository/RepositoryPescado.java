package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Pescado;

public interface RepositoryPescado extends JpaRepository<Pescado, Integer> {
	public Pescado findById(int id);
}
