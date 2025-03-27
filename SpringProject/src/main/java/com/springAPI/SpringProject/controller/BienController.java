package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.dto.BienDto;
import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.service.BienService;
import com.springAPI.SpringProject.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/biens")

public class BienController {
    @Autowired
    private BienService bienService;

    @PostMapping("/add")
    public ResponseEntity<Bien> creerBien(
        @RequestParam String recensementId,
        @RequestBody BienDto dto) {

        Bien bienEnregistre = bienService.enregistrerBien(recensementId, dto);
        return ResponseEntity.ok(bienEnregistre);
    }

    @PutMapping("/update")
    public ResponseEntity<Bien> modifierBien(@RequestParam ("recensementId") String recensementId,
                                             @RequestBody BienDto dto) {
        Bien bienMisAJour = bienService.modifierBien(recensementId, dto);
        return ResponseEntity.ok(bienMisAJour);

    }


    @GetMapping("/research/{identifiant}")
    public Optional<Bien> rechercherBien(@PathVariable String identifiant) {
        return bienService.rechercherBien(identifiant);
    }

    @GetMapping("/all")
    public List<Bien> getAllBien() {
        return bienService.getAllBiens();
    }


}
