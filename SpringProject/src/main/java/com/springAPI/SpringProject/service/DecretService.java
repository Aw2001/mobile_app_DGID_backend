package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.repository.DecretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecretService {
    @Autowired
    private DecretRepository decretRepository;

    public List<String> getAllSecteursByCommune(String commune) {
        return decretRepository.findSecteursByCommune(commune);

    }

    public Double getPrixTerrainBySecteurAndZone(String secteur, String zone) {
        return decretRepository.findPrixTerrainBySecteurAndZone(secteur, zone);
    }

    public List<String> getCommuneByDepartement(String departement) {
        return decretRepository.findCommuneByDepartement(departement);
    }

    public List<String> getZoneBySecteur(String secteur) {
        return decretRepository.findZoneBySecteur(secteur);
    }

    public List<String> getDepartementsByRegion(String region) {
        return decretRepository.findDepartementByRegion(region);
    }
}
