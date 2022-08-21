package com.defitech.vaccoding.ecommerce.services;

import com.defitech.vaccoding.ecommerce.entities.Categorie;
import com.defitech.vaccoding.ecommerce.entities.Commande;
import com.defitech.vaccoding.ecommerce.entities.LigneCommande;
import com.defitech.vaccoding.ecommerce.entities.Produit;
import com.defitech.vaccoding.ecommerce.repositories.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CommandeService commandeService;

    public LigneCommande createLigneCommande(LigneCommande data){
       if(data.getCommande()==null) throw new RuntimeException("La commande de votre ligne commande ne peut être null ! ");
       if(data.getProduit()==null) throw new RuntimeException("La ligne commande ne contient pas de produit!");
       LigneCommande l=ligneCommandeRepository.fetchLigneCommande(data.getCommande().getId(),data.getProduit().getId());
       if (l!=null) throw new RuntimeException("Désolé vous ne pouvez pas enregistrer un produit deux fois pour une même commande.");
        Commande commandeFetch= commandeService.getCommande(data.getCommande().getId());
        Produit produitFetch=produitService.getProduit(data.getProduit().getId());
        data.setCommande(commandeFetch);
        data.setProduit(produitFetch);
        return  ligneCommandeRepository.save(data);
    }

    public LigneCommande updateLigneCommande(LigneCommande data){
        if (data.getId()<=0) throw new RuntimeException("ID incorrecte;");
        Optional<LigneCommande> l=ligneCommandeRepository.findById(data.getId());
        if (l.isEmpty()) throw new RuntimeException("Désolé pas de ligne commande avec cet id.");
        l.get().setQuantite(data.getQuantite());
        return  ligneCommandeRepository.save(data);
    }

    public void deleteLigneCommande(long id){
        if (id<=0) throw new RuntimeException("ID incorrecte;");
        ligneCommandeRepository.deleteById(id);
    }

    public List<LigneCommande> listLigneCommande(){
        return  ligneCommandeRepository.findAll();
    }

    public LigneCommande getLigneCommande(long id){
        return ligneCommandeRepository.findById(id).get();
    }
}
