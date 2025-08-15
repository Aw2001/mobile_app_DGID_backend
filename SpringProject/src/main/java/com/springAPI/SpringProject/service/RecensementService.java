package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.repository.RecensementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecensementService {
    @Autowired
    private RecensementRepository recensementRepository;

    public Recensement enregistrerRecensement(Recensement recensement) {
        return recensementRepository.save(recensement);
    }

    public List<Recensement> getAllRecensementsActifs() {
        return recensementRepository.findRecensementsActifs();
    }

    public List<Recensement> getAllRecensements() {
        return recensementRepository.findRecensements();
    }

    public long getNumberOfRecensements() {
        return recensementRepository.countRecensements();
    }
    
    /**
     * Modifie un recensement existant
     * @param numRecensement le numéro du recensement à modifier
     * @param recensementDetails les nouvelles données du recensement
     * @return le recensement modifié ou null si le recensement n'existe pas
     */
    public Recensement modifierRecensement(String numRecensement, Recensement recensementDetails) {
        Recensement recensementExistant = recensementRepository.findByNumRecensement(numRecensement);
        
        if (recensementExistant == null) {
            return null;
        }
        
        // Mise à jour des champs du recensement
        if (recensementDetails.getMethodeRecensement() != null) {
            recensementExistant.setMethodeRecensement(recensementDetails.getMethodeRecensement());
        }
        if (recensementDetails.getEtat() != null) {
            recensementExistant.setEtat(recensementDetails.getEtat());
        }
        if (recensementDetails.getService() != null) {
            recensementExistant.setService(recensementDetails.getService());
        }
        if (recensementDetails.getTypeService() != null) {
            recensementExistant.setTypeService(recensementDetails.getTypeService());
        }
        if (recensementDetails.getDateDebut() != null) {
            recensementExistant.setDateDebut(recensementDetails.getDateDebut());
        }
        if (recensementDetails.getDateFin() != null) {
            recensementExistant.setDateFin(recensementDetails.getDateFin());
        }
        if (recensementDetails.getCommentaire() != null) {
            recensementExistant.setCommentaire(recensementDetails.getCommentaire());
        }
        if (recensementDetails.getRegion() != null) {
            recensementExistant.setRegion(recensementDetails.getRegion());
        }
        if (recensementDetails.getDepartement() != null) {
            recensementExistant.setDepartement(recensementDetails.getDepartement());
        }
        if (recensementDetails.getCommune() != null) {
            recensementExistant.setCommune(recensementDetails.getCommune());
        }
        if (recensementDetails.getSection() != null) {
            recensementExistant.setSection(recensementDetails.getSection());
        }
        if (recensementDetails.getTitre() != null) {
            recensementExistant.setTitre(recensementDetails.getTitre());
        }
        
        // Enregistrement des modifications
        return recensementRepository.save(recensementExistant);
    }
}
