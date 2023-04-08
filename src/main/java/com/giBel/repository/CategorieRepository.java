package com.giBel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.giBel.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
	
	@Query("select c from Categorie c where c.nom like %:mc%")
	public List<Categorie> findAllByMotCle(@Param("mc")String mc);
	
	@Transactional
	@Modifying
	@Query("update Categorie c set c.nom = :nom, c.description = :description where c.id = :id")
	public void metAJourCategorie(@Param("id")Long id,@Param("nom")String nom,@Param("description")String description);

}
