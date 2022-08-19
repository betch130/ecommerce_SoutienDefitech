package com.defitech.vaccoding.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LigneCommande {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produit_id",nullable = false,updatable = false)
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commande_id",nullable = false,updatable = false)
    private Commande commande;
    @Column(nullable = false)
    private long quantite;


}
