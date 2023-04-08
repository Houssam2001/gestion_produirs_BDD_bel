package com.giBel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LigneCommandeCle {
	
	@Column(name="code_produit")
	private long code;
	@Column(name="id_commande")
	private long idCommande;
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	
}
