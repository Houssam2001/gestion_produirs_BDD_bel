package com.giBel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.giBel.entities.Categorie;
import com.giBel.entities.Commande;
import com.giBel.entities.LigneCommande;
import com.giBel.entities.Produit;
import com.giBel.repository.CategorieRepository;
import com.giBel.repository.CommandeRepository;
import com.giBel.repository.LigneCommandeRepository;
import com.giBel.repository.ProduitRepository;

@Controller
public class ProduitController {
	
	@Autowired
	private ProduitRepository prdRepository;
	@Autowired
	private CategorieRepository catRepository;
	@Autowired
	private CommandeRepository cmdRepository;
	@Autowired
	private LigneCommandeRepository ligneRepository;
	
	@GetMapping("/ajouter")
	public String ajouterProduit(Model model) {
		
		model.addAttribute("newProduit",new Produit());
		model.addAttribute("listeCats",catRepository.findAll());
		return "formAjout";
	}
	
	@PostMapping("/save")
	public String saveProduit(@ModelAttribute Produit newProduit) {
		
		prdRepository.save(newProduit);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String afficheProduits(@RequestParam(name="mc", defaultValue="") String mc,Model model) {
		
		List<Produit> liste;
		if(mc=="")
			liste=prdRepository.findAll();
		else
			liste=prdRepository.findAllByMotCle(mc);
			model.addAttribute("list",liste);
		return "produits";
	}
	@GetMapping("/test")
	public String test(@RequestParam String designation, Model model) {
		
		Produit p=prdRepository.findByDesignation(designation);
		model.addAttribute("p",p);
		return "test";
	}
	
	@GetMapping("/supprimer")
	public String supprimerProduit(@RequestParam long code) {
		
		prdRepository.deleteById(code);
		return "redirect:/";
	}
	
	@GetMapping("/editer")
	public String editerProduit(@RequestParam long code,Model model) {
		
		Optional<Produit> prd=prdRepository.findById(code);
		model.addAttribute("prd",prd);
		model.addAttribute("listeCats",catRepository.findAll());
		return "formEdit";
	}
	
	@GetMapping("/update")
	public String modifierProduit(@RequestParam long code,@RequestParam String designation,@RequestParam double prix,@RequestParam String photo) {
		
		prdRepository.metAJourProduitById(code, designation, prix, photo);
		return "redirect:/";
	}
	
	@GetMapping("/categories")
	public String afficheCategories(@RequestParam(name="mc", defaultValue="") String mc,Model model) {
		
		List<Categorie> liste;
		if(mc=="")
			liste=catRepository.findAll();
		else
			liste=catRepository.findAllByMotCle(mc);
			model.addAttribute("list",liste);
		return "categories";
	}
	
	@GetMapping("/ajouterCategorie")
	public String ajouterCategorie(Model model) {
		
		model.addAttribute("newCat",new Categorie());
		return "formAjoutCat";
	}

	@PostMapping("/saveCat")
	public String saveCategorie(@ModelAttribute Categorie newCat) {
		
		catRepository.save(newCat);
		return "redirect:/categories";
	}
	
	@GetMapping("/supprimerCat")
	public String supprimerCategorie(@RequestParam long id) {
		
		catRepository.deleteById(id);
		return "redirect:/categories";
	}
	
	@GetMapping("/editerCat")
	public String editerCategorie(@RequestParam long id,Model model) {
		
		Optional<Categorie> cat=catRepository.findById(id);
		model.addAttribute("cat",cat);
		return "formEditCat";
	}
	@GetMapping("/updateCat")
	public String modifierCategorie(@RequestParam long id,@RequestParam String nom,@RequestParam String description) {
		
		catRepository.metAJourCategorie(id, nom, description);
		return "redirect:/categories";
	}
	
	@GetMapping("/index")
	public String afficheAccueil() {
		
		return "accueil";
	}
	@GetMapping("/consulter")
	public String consulterDetailsCommande() {
		
		return "formConsult";
	}
	@PostMapping("/detailsCommande")
	public String afficheDetailsCommande(@RequestParam("idCommande")long idCommande,Model model) {
		Commande cmd=cmdRepository.findByIdCommande(idCommande);
		List<LigneCommande> details=cmd.getLigneCommandes();
		//double total=ligneRepository.calculerTotal(idCommande);
		double s=0;
		int i;
		for(i=0;i<details.size();i++)
			s=s+details.get(i).getQuantite()*details.get(i).getProduit().getPrix();
		model.addAttribute("details",details);
		model.addAttribute("cmd",cmd);
		//model.addAttribute("total", total);
		model.addAttribute("s",s);
		return "detailsCommande";
	}
}
