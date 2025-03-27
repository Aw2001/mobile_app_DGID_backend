package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.service.DecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/decret")
public class DecretController {
    @Autowired
    private DecretService decretService;

    @GetMapping("/secteurs")
    public ResponseEntity<List<String>> getSecteurs(
            @RequestParam String commune
    ) {
        List<String> secteurs = decretService.getAllSecteursByCommune(commune);
        return ResponseEntity.ok(secteurs);
    }

    @GetMapping("/prixTerrain")
    public Double getPrixTerrain(@RequestParam String secteur, @RequestParam String zone) {
        return decretService.getPrixTerrainBySecteurAndZone(secteur, zone);

    }
    @GetMapping("/departements")
    public ResponseEntity<List<String>> getDepartements(@RequestParam String region) {
        List<String> departements = decretService.getDepartementsByRegion(region);
        return ResponseEntity.ok(departements);
    }

    @GetMapping("/communes")
    public ResponseEntity<List<String>> getCommunes(@RequestParam String departement) {
        List<String> communes = decretService.getCommuneByDepartement(departement);
        return ResponseEntity.ok(communes);
    }

    @GetMapping("/zones")
    public ResponseEntity<List<String>> getZones(@RequestParam String secteur) {
        List<String> zones = decretService.getZoneBySecteur(secteur);
        return ResponseEntity.ok(zones);
    }
}
