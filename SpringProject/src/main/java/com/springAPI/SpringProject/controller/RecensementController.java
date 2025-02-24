package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.service.RecensementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recensements")
public class RecensementController {
    @Autowired
    private RecensementService recensementService;

    @PostMapping("/add")
    public ResponseEntity<Recensement> creerRecensement(@RequestBody Recensement recensement) {
        Recensement recensementEnregistre = recensementService.enregistrerRecensement(recensement);
        return ResponseEntity.ok(recensementEnregistre);
    }

    //lister les recensements actifs
    @GetMapping("/all/actifs")

    public ResponseEntity<List<Recensement>> listerRecensementsActifs() {
        System.out.println("Le controller");
        List<Recensement> recensements = recensementService.getAllRecensementsActifs();
        return ResponseEntity.ok(recensements);
    }

    //lister les recensements actifs en fonction de l'utilisateur connecté
}
