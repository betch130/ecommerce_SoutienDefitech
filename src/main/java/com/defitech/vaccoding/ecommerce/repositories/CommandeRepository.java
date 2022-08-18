package com.defitech.vaccoding.ecommerce.repositories;

import com.defitech.vaccoding.ecommerce.entities.Commande;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
@OpenAPIDefinition
@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}