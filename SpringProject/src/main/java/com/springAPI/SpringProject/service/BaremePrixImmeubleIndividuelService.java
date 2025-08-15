package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.repository.BaremePrixImmeubleIndividuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaremePrixImmeubleIndividuelService {
    @Autowired
    private BaremePrixImmeubleIndividuelRepository baremePrixImmeubleIndividuelRepository;

    public Double getPrixImmeubleByRegionAndCategorie(String region, String categorie) {
        return baremePrixImmeubleIndividuelRepository.findPrixImmeubleByRegionAndCategorie(region, categorie);
    }
}
