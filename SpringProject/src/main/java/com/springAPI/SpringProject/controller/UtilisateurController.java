package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/add")
    public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurEnregistre = utilisateurService.enregistrerUtilisateur(utilisateur);
        return ResponseEntity.ok(utilisateurEnregistre);
    }
}
