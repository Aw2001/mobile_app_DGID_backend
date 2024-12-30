package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.commune.Commune;
import com.springAPI.SpringProject.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneService {
    @Autowired
    private CommuneRepository communeRepository;

    public List<Commune> getAllCommunes() {
        return communeRepository.findAll();
    }
    public List<String> getCommuneByDepartementName(String departementName) {
        return communeRepository.findCommuneByDepartementName(departementName);
    }
}
