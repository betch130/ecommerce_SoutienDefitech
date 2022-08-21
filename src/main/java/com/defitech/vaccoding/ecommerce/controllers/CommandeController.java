package com.defitech.vaccoding.ecommerce.controllers;

import com.defitech.vaccoding.ecommerce.entities.Commande;
import com.defitech.vaccoding.ecommerce.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/commandes")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping
    public ResponseEntity<?> createCommande(@RequestBody Commande data){
        return ResponseEntity.ok().body(commandeService.createCommande(data));
    }
    @PutMapping
    public ResponseEntity<?>  updateCommande(@RequestBody Commande data){
        return ResponseEntity.ok().body(commandeService.updateCommande(data));
    }
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable("id") int id){
        commandeService.deleteCommande(id);
    }
    @GetMapping
    public ResponseEntity<?>  listCommande(){
        return  ResponseEntity.ok().body(commandeService.listCommande());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCommande(@PathVariable("id") int id ){
        return  ResponseEntity.ok().body(commandeService.getCommande(id));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> entity= new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
