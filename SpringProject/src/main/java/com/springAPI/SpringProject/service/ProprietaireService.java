package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.proprietaire.Proprietaire;
import com.springAPI.SpringProject.repository.ProprietaireRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import java.beans.FeatureDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ProprietaireService {
    @Autowired
    private ProprietaireRepository proprietaireRepository;

    public Proprietaire enregistrerProprietaire(Proprietaire proprietaire) {
        if(proprietaire.getNumIdentifiant() == null || proprietaire.getNumIdentifiant().isEmpty()) {
            throw new IllegalArgumentException("L'identifiant ne peut pas être null ou vide.");
        } else {
            return proprietaireRepository.save(proprietaire);
        }
    }

    public Proprietaire mettreAJourProprietaire(Proprietaire proprietaire) {
        Proprietaire proprietaireExistant = proprietaireRepository.findById(proprietaire.getNumIdentifiant())
                .orElseThrow(() -> new EntityNotFoundException("Propriétaire introuvable"));

        // Copier uniquement les champs non-nuls depuis le nouvel objet
        BeanUtils.copyProperties(proprietaire, proprietaireExistant, getNullOrEmptyPropertyNames(proprietaire));

        return proprietaireRepository.save(proprietaireExistant);
    }

    public String[] getNullOrEmptyPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);

        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(java.beans.PropertyDescriptor::getName)
                .filter(propertyName -> {
                    Object propertyValue = wrappedSource.getPropertyValue(propertyName);
                    return propertyValue == null ||
                            (propertyValue instanceof String && ((String) propertyValue).isEmpty());
                })
                .toArray(String[]::new);
    }

    public Proprietaire rechercherProprietaire(String id) {
        Proprietaire proprietaireExistant = proprietaireRepository.findByNumIdentifiant(id);
        System.out.println(proprietaireExistant);

        return proprietaireExistant;

    }
    public Long getNumberOfProprietaire() {
        return proprietaireRepository.countProprietaire();
    }
}
