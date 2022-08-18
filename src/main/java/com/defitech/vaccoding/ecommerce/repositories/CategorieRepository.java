package com.defitech.vaccoding.ecommerce.repositories;

import com.defitech.vaccoding.ecommerce.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}