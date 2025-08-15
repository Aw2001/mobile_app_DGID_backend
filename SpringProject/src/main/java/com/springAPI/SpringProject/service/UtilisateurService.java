package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.dto.UtilisateurDto;
import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {

        if(utilisateurRepository.findByUsername(utilisateur.getUsername()) == null) {
            return utilisateurRepository.save(utilisateur);
        } else {
            return null;
        }

    }

    public UtilisateurService(UtilisateurRepository userRepository, EmailService emailService) {
        this.utilisateurRepository = userRepository;
    }

    public List<Utilisateur> allUsers() {
        List<Utilisateur> users = new ArrayList<>();
        utilisateurRepository.findAll().forEach(users::add);
        return users;
    }
    public Utilisateur getUtilisateurByIdentifiant(String email) {
        return utilisateurRepository.findByIdentifiant(email).orElseThrow(() -> new RuntimeException("Aucun user trouve"));
    }

    public Utilisateur getUtilisateurByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }

    public UtilisateurDto getUtilisateurByEmail(String email) {
        Utilisateur user = utilisateurRepository.findByEmail(email);
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setUsername(user.getUsername());
        utilisateurDto.setEmail(user.getIdentifiant());
        utilisateurDto.setNom(user.getNom());
        utilisateurDto.setPrenom(user.getPrenom());
        utilisateurDto.setRole(user.getRole());
        return utilisateurDto;
    }

    public String getFirstNameAndLastName(String username) {
        return utilisateurRepository.returnFirstNameAndLastName(username);
    }

    public String getEmailByUsername(String username) {
        return utilisateurRepository.returnEmail(username);
    }

    public List<Utilisateur> getAgents() {
        return utilisateurRepository.returnAgents();
    }

}
