package com.defitech.vaccoding.ecommerce.controllers;

import com.defitech.vaccoding.ecommerce.entities.Categorie;
import com.defitech.vaccoding.ecommerce.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categories")
@CrossOrigin("*")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping
    public ResponseEntity<?> createCategorie(@RequestBody Categorie data){
        return ResponseEntity.ok().body(categorieService.createCategorie(data));
    }
    @PutMapping
    public ResponseEntity<?>  updateCategorie(@RequestBody Categorie data){
        return ResponseEntity.ok().body(categorieService.updateCategorie(data));
    }
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable("id") int id){
        categorieService.deleteCategorie(id);
    }
    @GetMapping
    public ResponseEntity<?>  listCategorie(){
        return  ResponseEntity.ok().body(categorieService.listCategorie());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategorie(@PathVariable("id") int id ){
        return  ResponseEntity.ok().body(categorieService.getCategorie(id));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> entity= new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
