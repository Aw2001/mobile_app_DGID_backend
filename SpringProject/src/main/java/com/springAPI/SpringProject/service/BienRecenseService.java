package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.repository.BienRecenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BienRecenseService {
    @Autowired
    private BienRecenseRepository bienRecenseRepository;

    public BienRecense enregistrerBienRecense(BienRecense bienRecense) {
        return bienRecenseRepository.save(bienRecense);
    }
}
