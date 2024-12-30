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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
