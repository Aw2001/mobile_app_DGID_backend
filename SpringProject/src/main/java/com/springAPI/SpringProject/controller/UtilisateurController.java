package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.dto.UtilisateurDto;
import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/add")
    public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurEnregistre = utilisateurService.enregistrerUtilisateur(utilisateur);
        return ResponseEntity.ok(utilisateurEnregistre);
    }

    @GetMapping("/me")
    public ResponseEntity<Utilisateur> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Utilisateur currentUser = (Utilisateur) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<Utilisateur>> allUsers() {
        List<Utilisateur> users = utilisateurService.allUsers();
        return ResponseEntity.ok(users);
    }



    @GetMapping("/{email}")

    public ResponseEntity<UtilisateurDto> getUtilisateurByEmail(@PathVariable String email) {
        UtilisateurDto user = utilisateurService.getUtilisateurByEmail(email);
        return ResponseEntity.ok(user);
    }
}
