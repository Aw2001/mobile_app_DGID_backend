package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.dto.RecensementUtilisateurDto;
import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateur;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateurId;
import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.repository.RecensementRepository;
import com.springAPI.SpringProject.repository.RecensementUtilisateurRepository;
import com.springAPI.SpringProject.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecensementUtilisateurService {

    @Autowired
    private final RecensementUtilisateurRepository recensementUtilisateurRepository;
    @Autowired
    private final RecensementRepository recensementRepository;
    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public RecensementUtilisateurService(RecensementUtilisateurRepository recensementUtilisateurRepository,
                                            RecensementRepository recensementRepository,
                                            UtilisateurRepository utilisateurRepository) {
        this.recensementUtilisateurRepository = recensementUtilisateurRepository;
        this.recensementRepository = recensementRepository;
        this.utilisateurRepository = utilisateurRepository;
    }


    public RecensementUtilisateur enregistrerRecensementUtilisateur(RecensementUtilisateurDto dto) {
        // Vérification des entités
        Recensement recensement = recensementRepository.findByNumRecensement(dto.getIdentifiantRecensement());
        Utilisateur utilisateur = utilisateurRepository.findByEmail(dto.getIdentifiantUtilisateur());

        // Création de l'association
        RecensementUtilisateurId id = new RecensementUtilisateurId();
        id.setIdentifiantRecensement(dto.getIdentifiantRecensement());
        id.setIdentifiantUtilisateur(dto.getIdentifiantUtilisateur());

        RecensementUtilisateur recensementUtilisateur = new RecensementUtilisateur();
        recensementUtilisateur.setId(id);
        recensementUtilisateur.setRecensement(recensement);
        recensementUtilisateur.setUtilisateur(utilisateur);

        return recensementUtilisateurRepository.save(recensementUtilisateur);
    }

    public List<Recensement> getAllRecensementUtilisateur(String email) {
        return recensementUtilisateurRepository.findRecensementsUtilisateurActifs(email);
    }
    
    public RecensementUtilisateur modifierRecensementUtilisateur(RecensementUtilisateurDto dto, String ancienRecensementId, String ancienUtilisateurId) {
        // Vérification de l'existence de l'association à modifier
        RecensementUtilisateurId ancienId = new RecensementUtilisateurId();
        ancienId.setIdentifiantRecensement(ancienRecensementId);
        ancienId.setIdentifiantUtilisateur(ancienUtilisateurId);
        
        RecensementUtilisateur recensementUtilisateur = recensementUtilisateurRepository.findById(ancienId)
                .orElseThrow(() -> new RuntimeException("Association RecensementUtilisateur non trouvée"));
        
        // Vérification des nouvelles entités
        Recensement nouveauRecensement = recensementRepository.findByNumRecensement(dto.getIdentifiantRecensement());
        if (nouveauRecensement == null) {
            throw new RuntimeException("Recensement non trouvé avec l'identifiant: " + dto.getIdentifiantRecensement());
        }
        
        Utilisateur nouveauUtilisateur = utilisateurRepository.findByEmail(dto.getIdentifiantUtilisateur());
        if (nouveauUtilisateur == null) {
            throw new RuntimeException("Utilisateur non trouvé avec l'email: " + dto.getIdentifiantUtilisateur());
        }
        
        // Suppression de l'ancienne association
        recensementUtilisateurRepository.delete(recensementUtilisateur);
        
        // Création de la nouvelle association
        RecensementUtilisateurId nouveauId = new RecensementUtilisateurId();
        nouveauId.setIdentifiantRecensement(dto.getIdentifiantRecensement());
        nouveauId.setIdentifiantUtilisateur(dto.getIdentifiantUtilisateur());
        
        RecensementUtilisateur nouveauRecensementUtilisateur = new RecensementUtilisateur();
        nouveauRecensementUtilisateur.setId(nouveauId);
        nouveauRecensementUtilisateur.setRecensement(nouveauRecensement);
        nouveauRecensementUtilisateur.setUtilisateur(nouveauUtilisateur);
        
        return recensementUtilisateurRepository.save(nouveauRecensementUtilisateur);
    }
}
