package com.giBel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.giBel.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Long>{

	public Commande findByIdCommande(@Param("idCommande")Long idCommande);
}
