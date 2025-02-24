package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.dto.RecensementUtilisateurDto;
import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateur;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateurId;
import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.repository.RecensementRepository;
import com.springAPI.SpringProject.repository.RecensementUtilisateurRepository;
import com.springAPI.SpringProject.repository.UtilisateurRepository;
import com.springAPI.SpringProject.service.RecensementUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recensementUtilisateurs")
public class RecensementUtilisateurController {

    @Autowired
    private RecensementUtilisateurService recensementUtilisateurService;

    @PostMapping("/add")
    public ResponseEntity<RecensementUtilisateur> creerRecensementUtilisateur(@RequestBody RecensementUtilisateurDto dto) {

        RecensementUtilisateur recensementUtilisateurEnregistre = recensementUtilisateurService.enregistrerRecensementUtilisateur(dto);
        return ResponseEntity.ok(recensementUtilisateurEnregistre);

    }

    @GetMapping("/all/{email}")
    public ResponseEntity<List<Recensement>> getAllRecensementUtilisateur(@PathVariable String email) {
        List<Recensement> recensements = recensementUtilisateurService.getAllRecensementUtilisateur(email);
        int count = recensements.size();
        System.out.println(count);
        return ResponseEntity.ok(recensements);
    }
}
