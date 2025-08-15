package com.springAPI.SpringProject.service;


import com.springAPI.SpringProject.model.departement.Departement;
import com.springAPI.SpringProject.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement> getAllDepartements() {
        return departementRepository.findAllDepartements();
    }

    public List<String> getDepartementsByRegionName(String regionName) {
        return departementRepository.findByRegion(regionName);
    }
}
