package com.giBel.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Commande {
	
	@Id
	private long idCommande;
	private Date dateCommande;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="commande")
	private List<LigneCommande> ligneCommandes;
	public long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}
	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	public Commande() {
		super();
	}
	
	
	
	

}
