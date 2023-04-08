package com.giBel.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code;
	@Column(name="designation", length=25)
	private String designation;
	private double prix;
	@ManyToOne
	private Categorie categorie;
	@Column(name="photo", length=50)
	private String photo;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="produit")
	private List<LigneCommande> ligneCommandes;

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}
	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	public Produit(String designation, double prix, Categorie categorie, String photo) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
		this.photo = photo;
	}
	public Produit() {
		super();
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}
