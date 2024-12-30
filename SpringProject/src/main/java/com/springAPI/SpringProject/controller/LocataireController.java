package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.locataire.Locataire;
import com.springAPI.SpringProject.service.LocataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locataires")
public class LocataireController {

    @Autowired
    private LocataireService locataireService;

    @PostMapping("/add")
    public ResponseEntity<Locataire> creerLocataire(@RequestParam String matricule, @RequestBody Locataire locataire) {
        Locataire locataireEnregistre = locataireService.enregistrerLocataire(matricule, locataire);
        return ResponseEntity.ok(locataireEnregistre);
    }

    @PutMapping("/update")
    public ResponseEntity<Locataire> modifierLocataire(@RequestBody Locataire locataire) {
        Locataire locataireMisAjour = locataireService.modifierLocataire(locataire);
        return ResponseEntity.ok(locataireMisAjour);
    }

    @GetMapping("/research/{id}")
    public Locataire rechercherLocataire(@PathVariable String id) {
        return locataireService.rechercherLocataire(id);
    }
}
