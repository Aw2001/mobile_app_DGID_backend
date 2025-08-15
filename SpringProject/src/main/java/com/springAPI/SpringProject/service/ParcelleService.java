package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.parcelle.Parcelle;
import com.springAPI.SpringProject.repository.ParcelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelleService {

    @Autowired
    private ParcelleRepository parcelleRepository;

    public List<Parcelle> getAllParcelles() {
        return parcelleRepository.findAllParcelles();
    }

    public List<String> getAllParcellesBySectionNumSec(String sectionNumSec, String region, String nomDepart, String nomCommun) {
        return parcelleRepository.findAllParcellesBySectionNumSec(sectionNumSec, region, nomDepart, nomCommun);
    }
}
