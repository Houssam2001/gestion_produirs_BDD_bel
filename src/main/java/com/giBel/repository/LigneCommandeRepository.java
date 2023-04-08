package com.giBel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.giBel.entities.LigneCommande;
import com.giBel.entities.LigneCommandeCle;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,LigneCommandeCle> {

	@Query("select sum(ligne.quantite*ligne.produit.prix) as total from LigneCommande ligne where ligne.id.idCommande=:idCommande")
	public double calculerTotal(@Param("idCommande")Long idCommande);
}
