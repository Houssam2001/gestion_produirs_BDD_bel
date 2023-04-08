package com.giBel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.giBel.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
	
	public Produit findByDesignation(@Param("designation") String designation);

	@Query("select p from Produit p where p.designation like %:mc%")
	public List<Produit> findAllByMotCle(@Param("mc") String mc);
	
	@Transactional
	@Modifying
	@Query("update Produit p set p.designation=:designation, p.prix=:prix, p.photo=:photo where p.code=:code")
	public void metAJourProduitById(@Param("code")Long code,@Param("designation")String designation,@Param("prix")double prix,@Param("photo")String photo);

}
