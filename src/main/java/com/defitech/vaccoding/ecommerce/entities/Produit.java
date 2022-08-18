package com.defitech.vaccoding.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private double prix;
    private long quantite;
    @ManyToOne
    @JoinColumn(name = "categorie_id",nullable=true)
    private Categorie categorie;
}
