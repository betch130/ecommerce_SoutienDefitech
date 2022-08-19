package com.defitech.vaccoding.ecommerce.controllers;

import com.defitech.vaccoding.ecommerce.entities.Client;
import com.defitech.vaccoding.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client data){
        return ResponseEntity.ok().body(clientService.createClient(data));
    }
    @PutMapping
    public ResponseEntity<?>  updateClient(@RequestBody Client data){
        return ResponseEntity.ok().body(clientService.updateClient(data));
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") int id){
        clientService.deleteClient(id);
    }
    @GetMapping
    public ResponseEntity<?>  listClient(){
        return  ResponseEntity.ok().body(clientService.listClient());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") int id ){
        return  ResponseEntity.ok().body(clientService.getClient(id));
    }
}
