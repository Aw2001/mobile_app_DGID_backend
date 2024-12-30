package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.service.RecensementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recensements")
public class RecensementController {
    @Autowired
    private RecensementService recensementService;

    @PostMapping("/add")
    public ResponseEntity<Recensement> creerRecensement(@RequestBody Recensement recensement) {
        Recensement recensementEnregistre = recensementService.enregistrerRecensement(recensement);
        return ResponseEntity.ok(recensementEnregistre);
    }
}
