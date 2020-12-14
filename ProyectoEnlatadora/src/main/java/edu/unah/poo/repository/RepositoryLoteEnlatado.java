package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.unah.poo.model.LoteEnlatado;

public interface RepositoryLoteEnlatado extends JpaRepository<LoteEnlatado, Integer> {
	public  LoteEnlatado findById(int id);
}
