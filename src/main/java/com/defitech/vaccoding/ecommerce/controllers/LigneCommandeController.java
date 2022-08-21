package com.defitech.vaccoding.ecommerce.controllers;

import com.defitech.vaccoding.ecommerce.entities.LigneCommande;
import com.defitech.vaccoding.ecommerce.services.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ligneCommandes")
@CrossOrigin("*")
public class LigneCommandeController {
    @Autowired
    private LigneCommandeService ligneCommandeService;

    @PostMapping
    public ResponseEntity<?> createLigneCommande(@RequestBody LigneCommande data){
        return ResponseEntity.ok().body(ligneCommandeService.createLigneCommande(data));
    }
    @PutMapping
    public ResponseEntity<?>  updateLigneCommande(@RequestBody LigneCommande data){
        return ResponseEntity.ok().body(ligneCommandeService.updateLigneCommande(data));
    }
    @DeleteMapping("/{id}")
    public void deleteLigneCommande(@PathVariable("id") long id){
        ligneCommandeService.deleteLigneCommande(id);
    }
    @GetMapping
    public ResponseEntity<?>  listLigneCommande(){
        return  ResponseEntity.ok().body(ligneCommandeService.listLigneCommande());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getLigneCommande(@PathVariable("id") long id ){
        return  ResponseEntity.ok().body(ligneCommandeService.getLigneCommande(id));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> entity= new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
