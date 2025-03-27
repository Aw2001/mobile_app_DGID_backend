package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.repository.BaremePrixImmeubleCollectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaremePrixImmeubleCollectifService {
    @Autowired
    private BaremePrixImmeubleCollectifRepository baremePrixImmeubleCollectifRepository;

    public Double getPrixByRegionAndCategorie (String region, String categorie){
        return baremePrixImmeubleCollectifRepository.findPrixImmeubleByRegionAndCategorie(region,categorie);
    }
}
