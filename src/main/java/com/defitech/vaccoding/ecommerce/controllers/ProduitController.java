package com.defitech.vaccoding.ecommerce.controllers;

import com.defitech.vaccoding.ecommerce.entities.Produit;
import com.defitech.vaccoding.ecommerce.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @PostMapping
    public ResponseEntity<?> createProduit(@RequestBody Produit data){
        return ResponseEntity.ok().body(produitService.createProduit(data));
    }
    @PutMapping
    public ResponseEntity<?>  updateProduit(@RequestBody Produit data){
        return ResponseEntity.ok().body(produitService.updateProduit(data));
    }
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable("id") int id){
        produitService.deleteProduit(id);
    }
    @GetMapping
    public ResponseEntity<?>  listProduit(){
        return  ResponseEntity.ok().body(produitService.listProduit());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduit(@PathVariable("id") int id ){
        return  ResponseEntity.ok().body(produitService.getProduit(id));
    }
}
