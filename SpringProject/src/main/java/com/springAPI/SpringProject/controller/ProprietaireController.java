package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.proprietaire.Proprietaire;
import com.springAPI.SpringProject.service.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proprietaires")
public class ProprietaireController {
    @Autowired
    private ProprietaireService proprietaireService;

    @PostMapping("/add")
    public ResponseEntity<Proprietaire> ajouterProprietaire(@RequestBody Proprietaire proprietaire) {
        Proprietaire proprietaireEnregistre = proprietaireService.enregistrerProprietaire(proprietaire);
        return ResponseEntity.ok(proprietaireEnregistre);
    }

    @PutMapping("/update")
    public ResponseEntity<Proprietaire> modifierProprietaire(@RequestBody Proprietaire proprietaire) {
        Proprietaire proprietaireMisAJour = proprietaireService.mettreAJourProprietaire(proprietaire);
        return ResponseEntity.ok(proprietaireMisAJour);
    }

    @GetMapping("/research/{id}")
    public Proprietaire getProprietaire(@PathVariable String id) {
        return proprietaireService.rechercherProprietaire(id);
    }
}
