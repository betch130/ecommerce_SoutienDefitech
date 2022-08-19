package com.defitech.vaccoding.ecommerce.services;

import com.defitech.vaccoding.ecommerce.entities.Categorie;
import com.defitech.vaccoding.ecommerce.entities.Produit;
import com.defitech.vaccoding.ecommerce.repositories.CategorieRepository;
import com.defitech.vaccoding.ecommerce.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieService categorieService;

    public Produit createProduit(Produit data){
        if(data.getLibelle().isEmpty()) throw new RuntimeException("Le libele du produit ne peut être vide");
        if ((data.getPrix()<=0)) throw new RuntimeException("Le prix ne peut pas être inférieur ou égale à 0.");
        Categorie fetch=categorieService.getCategorie(data.getCategorie().getId());
        data.setCategorie(fetch);
        return  produitRepository.save(data);
    }

    public Produit updateProduit(Produit data){
        if (data.getId()<=0) throw new RuntimeException("ID incorrecte;");
        if ((data.getPrix()<=0)) throw new RuntimeException("Le prix ne peut pas être inférieur ou égale à 0.");
        Optional<Produit> fetch = produitRepository.findById(data.getId());
        if (!fetch.isPresent()) throw new RuntimeException("Produit avec cet ID n'existe pas!");
        fetch.get().setLibelle(data.getLibelle());
        fetch.get().setPrix(data.getPrix());
        fetch.get().setQuantite(data.getQuantite());
        fetch.get().setCategorie(categorieService.getCategorie(data.getCategorie().getId()));
       return produitRepository.save(fetch.get());
    }

    public void deleteProduit(int id){
        if (id<=0) throw new RuntimeException("ID incorrecte;");
        produitRepository.deleteById(id);
    }

    public List<Produit> listProduit(){
        return  produitRepository.findAll();
    }

    public Produit getProduit(int id){
        return produitRepository.findById(id).get();
    }
}
