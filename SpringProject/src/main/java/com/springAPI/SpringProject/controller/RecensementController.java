package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.service.RecensementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recensements")
public class RecensementController {
    @Autowired
    private RecensementService recensementService;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Recensement> creerRecensement(@RequestBody Recensement recensement) {
        Recensement recensementEnregistre = recensementService.enregistrerRecensement(recensement);
        return ResponseEntity.ok(recensementEnregistre);
    }

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    //lister les recensements actifs
    @GetMapping("/all/actifs")

    public ResponseEntity<List<Recensement>> listerRecensementsActifs() {
        List<Recensement> recensements = recensementService.getAllRecensementsActifs();
        return ResponseEntity.ok(recensements);
    }
    @GetMapping("/all")

    public ResponseEntity<List<Recensement>> listerRecensements() {

        List<Recensement> recensements = recensementService.getAllRecensements();
        return ResponseEntity.ok(recensements);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/count")
    public Long getNumberOfRecensements(){
        return recensementService.getNumberOfRecensements();
    }

    //lister les recensements actifs en fonction de l'utilisateur connecté
    
    /**
     * Modifier un recensement existant
     * @param numRecensement le numéro du recensement à modifier
     * @param recensementDetails les nouvelles données du recensement
     * @return le recensement modifié ou une erreur 404 si le recensement n'existe pas
     */
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{numRecensement}")
    public ResponseEntity<?> modifierRecensement(@PathVariable String numRecensement, @RequestBody Recensement recensementDetails) {
        Recensement recensementModifie = recensementService.modifierRecensement(numRecensement, recensementDetails);
        
        if (recensementModifie == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(recensementModifie);
    }
}
