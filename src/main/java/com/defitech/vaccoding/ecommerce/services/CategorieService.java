package com.defitech.vaccoding.ecommerce.services;

import com.defitech.vaccoding.ecommerce.entities.Categorie;
import com.defitech.vaccoding.ecommerce.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie createCategorie(Categorie data){
        if(data.getLibelle().isEmpty()) throw new RuntimeException("Le libele de la catégorie ne peut êtr vide");
        return  categorieRepository.save(data);
    }

    public Categorie updateCategorie(Categorie data){
        if (data.getId()<=0) throw new RuntimeException("ID incorrecte;");
        Optional<Categorie> fetch = categorieRepository.findById(data.getId());
        if (!fetch.isPresent()) throw new RuntimeException("Categorie avec cet ID n'existe pas!");
        fetch.get().setLibelle(data.getLibelle());
       return categorieRepository.save(fetch.get());
    }

    public void deleteCategorie(int id){
        if (id<=0) throw new RuntimeException("ID incorrecte;");
        categorieRepository.deleteById(id);
    }

    public List<Categorie> listCategorie(){
        return  categorieRepository.findAll();
    }

    public Categorie getCategorie(int id){
        return categorieRepository.findById(id).get();
    }
}
