package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.dto.BienDto;
import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.bienLoue.BienLoue;
import com.springAPI.SpringProject.model.bienLoue.BienLoueId;
import com.springAPI.SpringProject.model.locataire.Locataire;
import com.springAPI.SpringProject.repository.BienLoueRepository;
import com.springAPI.SpringProject.repository.BienRepository;
import com.springAPI.SpringProject.repository.LocataireRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class LocataireService {
    @Autowired
    private LocataireRepository locataireRepository;

    @Autowired
    private BienLoueRepository bienLoueRepository;

    @Autowired
    private BienRepository bienRepository;

    public Locataire enregistrerLocataire(String matriculeLocal, Locataire locataire) {

        if (locataire.getCni() == null || locataire.getCni().isEmpty()) {
            System.out.println("Le CNI est obligatoire");
            return null;
        } else {
            //nouveau locataire
            Locataire newLocataire= new Locataire();
            Locataire locataireEnregistre= new Locataire();

            //vérifier l'existence du bien
            Bien bienExistant = bienRepository.findByIdentifiant(matriculeLocal);
            if(bienExistant != null) {
                newLocataire.setCni(locataire.getCni());
                newLocataire.setNom(locataire.getNom());
                newLocataire.setPrenom(locataire.getPrenom());
                newLocataire.setTelephone(locataire.getTelephone());
                newLocataire.setTypeOccupation(locataire.getTypeOccupation());
                newLocataire.setDateSignatureContrat(locataire.getDateSignatureContrat());
                newLocataire.setLoyerAnnuel(locataire.getLoyerAnnuel());
                newLocataire.setNbPieceOccupe(locataire.getNbPieceOccupe());
                newLocataire.setActiviteEconomique(locataire.getActiviteEconomique());
                newLocataire.setDenomination(locataire.getDenomination());
                newLocataire.setCommentaire(locataire.getCommentaire());
                locataireEnregistre = locataireRepository.save(newLocataire);

                // Création de l'association
                BienLoueId id = new BienLoueId();
                id.setIdentifiantLocal(matriculeLocal);
                id.setIdentifiantLocataire(newLocataire.getCni());

                //Créer une entrée dans BienRecense
                BienLoue bienLoue= new BienLoue();
                bienLoue.setId(id);
                bienLoue.setBien(bienExistant);
                bienLoue.setLocataire(locataireEnregistre);
                bienLoueRepository.save(bienLoue);
                return locataireEnregistre;
            } else {
                return null;
            }
        }


    }
    public Locataire modifierLocataire(Locataire locataire) {

        if (locataire.getCni() == null || locataire.getCni().isEmpty()) {
            System.out.println("Le CNI est obligatoire");
            return null;
        } else {
            //vérifier l'existance du locataire
            Locataire locataireExistant = locataireRepository.findById(locataire.getCni())
                    .orElseThrow(() -> new RuntimeException("Le locataire n'existe pas"));
            if(locataireExistant != null) {

                // Mise à jour des champs non nuls depuis le DTO
                BeanUtils.copyProperties(locataire, locataireExistant, getNullPropertyNames(locataire));

                Locataire locataireSauvegarde = locataireRepository.save(locataireExistant);
                return locataireSauvegarde;
            } else {
                return null;
            }
        }


    }

    public Locataire rechercherLocataire (String id) {
        Locataire locataireTrouve = locataireRepository.findByCni(id);
        return locataireTrouve;
    }

    private String[] getNullPropertyNames(Object source) {
        BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

    public Long getNumberOfLocataire() {
        return locataireRepository.countLocataire();
    }
}
