package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.dto.UtilisateurDto;
import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.service.UtilisateurService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurEnregistre = utilisateurService.enregistrerUtilisateur(utilisateur);
        return ResponseEntity.ok(utilisateurEnregistre);
    }

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @GetMapping("/me")
    public ResponseEntity<Utilisateur> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Utilisateur currentUser = (Utilisateur) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<Utilisateur>> allUsers() {
        List<Utilisateur> users = utilisateurService.allUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/all/agents")
    public ResponseEntity<List<Utilisateur>> allAgents() {
        List<Utilisateur> users = utilisateurService.getAgents();
        return ResponseEntity.ok(users);
    }

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @GetMapping("/{email}")

    public ResponseEntity<UtilisateurDto> getUtilisateurByEmail(@PathVariable String email) {
        UtilisateurDto user = utilisateurService.getUtilisateurByEmail(email);
        return ResponseEntity.ok(user);
    }

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @GetMapping("/initial/{username}")
    public ResponseEntity<String> getFirstNameAndLastName(@PathVariable String username) {
        String users = utilisateurService.getFirstNameAndLastName(username);
        return ResponseEntity.ok(users);
    }



    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @GetMapping("/getEmail/{username}")
    public ResponseEntity<String> getEmail(@PathVariable String username) {
        return ResponseEntity.ok(utilisateurService.getEmailByUsername(username));
    }

}
