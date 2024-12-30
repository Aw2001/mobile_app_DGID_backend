package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.departement.Departement;
import com.springAPI.SpringProject.repository.DepartementRepository;
import com.springAPI.SpringProject.model.region.Region;
import com.springAPI.SpringProject.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    // Récupérer toutes les régions
    public List<Region> getAllRegions() {
        List<Region> regions = regionRepository.findAllRegions();
        return regions;
    }

}
