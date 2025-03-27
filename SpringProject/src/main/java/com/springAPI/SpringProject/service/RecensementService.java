package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.repository.RecensementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecensementService {
    @Autowired
    private RecensementRepository recensementRepository;

    public Recensement enregistrerRecensement(Recensement recensement) {
        return recensementRepository.save(recensement);
    }

    public List<Recensement> getAllRecensementsActifs() {
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeee");
        return recensementRepository.findRecensementsActifs();
    }
    public long getNumberOfRecensements() {
        return recensementRepository.countRecensements();
    }
}
