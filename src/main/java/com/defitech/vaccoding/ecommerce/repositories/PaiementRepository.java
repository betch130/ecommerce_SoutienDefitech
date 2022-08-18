package com.defitech.vaccoding.ecommerce.repositories;

import com.defitech.vaccoding.ecommerce.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
}