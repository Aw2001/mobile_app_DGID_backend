package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.repository.BaremePrixClotureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaremePrixClotureService {
    @Autowired
    private BaremePrixClotureRepository baremePrixClotureRepository;

    public Double getPrixCloture(String region, String categorie) {
        return baremePrixClotureRepository.findPrixClotureByRegionAndCategorie(region, categorie);
    }
}
