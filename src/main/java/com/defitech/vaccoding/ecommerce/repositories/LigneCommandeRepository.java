package com.defitech.vaccoding.ecommerce.repositories;

import com.defitech.vaccoding.ecommerce.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

    @Query( "select l from LigneCommande l where l.produit.id=:idP   and l.commande.id=:idC")
    public LigneCommande fetchLigneCommande(@Param("idC") int idC,@Param("idP") int idP);
}