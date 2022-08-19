package com.defitech.vaccoding.ecommerce.services;

import com.defitech.vaccoding.ecommerce.entities.Categorie;
import com.defitech.vaccoding.ecommerce.entities.Commande;
import com.defitech.vaccoding.ecommerce.entities.Paiement;
import com.defitech.vaccoding.ecommerce.repositories.CategorieRepository;
import com.defitech.vaccoding.ecommerce.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private CommandeService commandeService;

    public Paiement createPaiement(Paiement data){
        if(data.getCommande()==null) throw new RuntimeException("La commande ne peut être vide");
        if ((data.getMontant()<=0)) throw new RuntimeException("Le montant ne peut pas être inférieur ou égale à 0.");
        Commande fetch=commandeService.getCommande(data.getCommande().getId());
        data.setCommande(fetch);
        return  paiementRepository.save(data);
    }

    public Paiement updatePaiement(Paiement data){
        if (data.getId()<=0) throw new RuntimeException("ID incorrecte;");
        if ((data.getMontant()<=0)) throw new RuntimeException("Le montant ne peut pas être inférieur ou égale à 0.");
        Optional<Paiement> fetch = paiementRepository.findById(data.getId());
        if (!fetch.isPresent()) throw new RuntimeException("Paiement avec cet ID n'existe pas!");
        fetch.get().setDatePaiement(data.getDatePaiement());
        fetch.get().setTypePaiement(data.getTypePaiement());
        fetch.get().setMontant(data.getMontant());
        fetch.get().setCommande(commandeService.getCommande(data.getId()));
       return paiementRepository.save(fetch.get());
    }

    public void deletePaiement(int id){
        if (id<=0) throw new RuntimeException("ID incorrecte;");
        paiementRepository.deleteById(id);
    }

    public List<Paiement> listPaiement(){
        return  paiementRepository.findAll();
    }

    public Paiement getPaiement(int id){
        return paiementRepository.findById(id).get();
    }
}
