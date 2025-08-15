package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.service.BienRecenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bienrecenses")
public class BienRecenseController {

    @Autowired
    BienRecenseService bienRecenseService;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<BienRecense> creerBienRecense(@RequestBody BienRecense bienRecense) {
        BienRecense bienRecenseEnregistrer = bienRecenseService.enregistrerBienRecense(bienRecense);
        return ResponseEntity.ok(bienRecenseEnregistrer);
    }
}
