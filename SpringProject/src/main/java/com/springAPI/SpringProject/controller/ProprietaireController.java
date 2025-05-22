package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.proprietaire.Proprietaire;
import com.springAPI.SpringProject.service.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proprietaires")
public class ProprietaireController {
    @Autowired
    private ProprietaireService proprietaireService;

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Proprietaire> ajouterProprietaire(@RequestBody Proprietaire proprietaire) {
        Proprietaire proprietaireEnregistre = proprietaireService.enregistrerProprietaire(proprietaire);
        return ResponseEntity.ok(proprietaireEnregistre);
    }

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Proprietaire> modifierProprietaire(@RequestBody Proprietaire proprietaire) {
        Proprietaire proprietaireMisAJour = proprietaireService.mettreAJourProprietaire(proprietaire);
        return ResponseEntity.ok(proprietaireMisAJour);
    }

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @GetMapping("/research/{id}")
    public Proprietaire getProprietaire(@PathVariable String id) {
        return proprietaireService.rechercherProprietaire(id);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/count")
    public Long getNumberOfProprietaires() {
        return proprietaireService.getNumberOfProprietaire();
    }
}
