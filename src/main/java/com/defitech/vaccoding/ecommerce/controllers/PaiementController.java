package com.defitech.vaccoding.ecommerce.controllers;

import com.defitech.vaccoding.ecommerce.entities.Paiement;
import com.defitech.vaccoding.ecommerce.services.PaiementService;
import com.defitech.vaccoding.ecommerce.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paiements")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @PostMapping
    public ResponseEntity<?> createPaiement(@RequestBody Paiement data){
        return ResponseEntity.ok().body(paiementService.createPaiement(data));
    }
    @PutMapping
    public ResponseEntity<?>  updatePaiement(@RequestBody Paiement data){
        return ResponseEntity.ok().body(paiementService.updatePaiement(data));
    }
    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable("id") int id){
        paiementService.deletePaiement(id);
    }
    @GetMapping
    public ResponseEntity<?>  listPaiement(){
        return  ResponseEntity.ok().body(paiementService.listPaiement());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPaiement(@PathVariable("id") int id ){
        return  ResponseEntity.ok().body(paiementService.getPaiement(id));
    }
}
