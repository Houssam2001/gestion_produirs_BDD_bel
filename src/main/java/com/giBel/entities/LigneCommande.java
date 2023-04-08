package com.giBel.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class LigneCommande {
	
	@EmbeddedId
	private LigneCommandeCle id;
	private int quantite;
	@ManyToOne
	@MapsId("idCommande")
	@JoinColumn(name="id_commande")
	private Commande commande;
	@ManyToOne
	@MapsId("code")
	@JoinColumn(name="code_produit")
	private Produit produit;
	public LigneCommandeCle getId() {
		return id;
	}
	public void setId(LigneCommandeCle id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public LigneCommande() {
		super();
	}
	
	
}
