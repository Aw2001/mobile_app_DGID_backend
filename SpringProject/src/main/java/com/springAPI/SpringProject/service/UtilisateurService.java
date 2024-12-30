package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {

        return utilisateurRepository.save(utilisateur);
    }
}
