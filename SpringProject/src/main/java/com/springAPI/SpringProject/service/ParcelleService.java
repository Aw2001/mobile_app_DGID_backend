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

    public List<String> getAllParcellesBySectionNumSec(String sectionNumSec) {
        return parcelleRepository.findAllParcellesBySectionNumSec(sectionNumSec);
    }
}
