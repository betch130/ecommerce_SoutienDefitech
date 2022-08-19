package com.defitech.vaccoding.ecommerce.services;

import com.defitech.vaccoding.ecommerce.entities.Categorie;
import com.defitech.vaccoding.ecommerce.entities.Client;
import com.defitech.vaccoding.ecommerce.repositories.CategorieRepository;
import com.defitech.vaccoding.ecommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client data){
        return  clientRepository.save(data);
    }

    public Client updateClient(Client data){
        if (data.getId()<=0) throw new RuntimeException("ID incorrecte;");
        Optional<Client> fetch = clientRepository.findById(data.getId());
        if (!fetch.isPresent()) throw new RuntimeException("Client avec cet ID n'existe pas!");
        fetch.get().setNom(data.getNom());
        fetch.get().setPrenom(data.getPrenom());
        fetch.get().setDate_naissance(data.getDate_naissance());
        fetch.get().setAdresse(data.getAdresse());
        fetch.get().setTel(data.getTel());
        fetch.get().setSexe(data.getSexe());
        fetch.get().setEmail(data.getEmail());
       return clientRepository.save(fetch.get());
    }

    public void deleteClient(int id){
        if (id<=0) throw new RuntimeException("ID incorrecte;");
        clientRepository.deleteById(id);
    }

    public List<Client> listClient(){
        return  clientRepository.findAll();
    }

    public Client getClient(int id){
        return clientRepository.findById(id).get();
    }
}
