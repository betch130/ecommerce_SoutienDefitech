package com.defitech.vaccoding.ecommerce.services;

import com.defitech.vaccoding.ecommerce.entities.Client;
import com.defitech.vaccoding.ecommerce.entities.Commande;
import com.defitech.vaccoding.ecommerce.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientService clientService;

    public Commande createCommande(Commande data){
        if(data.getClient()==null) throw new RuntimeException("L'ID du client ne peut pas être null");
        if(data.getClient().getId()<=0) throw new RuntimeException("L'ID du client est incorrecte");
        if ((data.getMontant()<=0)) throw new RuntimeException("Le montant de la commande ne peut pas être égale à 0.");
        Client fetch=clientService.getClient(data.getClient().getId());
        data.setClient(fetch);
        return  commandeRepository.save(data);
    }

    public Commande updateCommande(Commande data){
        if (data.getId()<=0) throw new RuntimeException("ID incorrecte;");
        if ((data.getMontant()<=0)) throw new RuntimeException("Le montant de la commande ne peut pas être égale à 0.");
        Optional<Commande> fetch = commandeRepository.findById(data.getId());
        if (!fetch.isPresent()) throw new RuntimeException("Commande avec cet ID n'existe pas!");
        fetch.get().setMontant(data.getMontant());
        fetch.get().setDateTime(data.getDateTime());
        fetch.get().setClient(clientService.getClient(data.getClient().getId()));
       return commandeRepository.save(fetch.get());
    }

    public void deleteCommande(int id){
        if (id<=0) throw new RuntimeException("ID incorrecte;");
        commandeRepository.deleteById(id);
    }

    public List<Commande> listCommande(){
        return  commandeRepository.findAll();
    }

    public Commande getCommande(int id){
        return commandeRepository.findById(id).get();
    }
}
