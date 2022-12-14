package com.defitech.vaccoding.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private double montant;
    @Column(nullable = false)
    private LocalDateTime datePaiement;
    @Column(nullable = false)
    private String typePaiement;
    @ManyToOne
    @JoinColumn(name = "commande_id",nullable = false)
    private Commande commande;
}
