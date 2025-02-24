package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.parcelle.Parcelle;
import com.springAPI.SpringProject.service.ParcelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parcelles")
public class ParcelleController {
    @Autowired
    ParcelleService parcelleService;

    @GetMapping("/all")
    public List<Parcelle> getAllParcelles() {
        return parcelleService.getAllParcelles();
    }

    @GetMapping("/bySection")
    public List<String> getParcellesBySectionNumSec(@RequestParam String sectionNumSec, @RequestParam String region, @RequestParam String nomDepart, @RequestParam String nomCommun) {
        return parcelleService.getAllParcellesBySectionNumSec(sectionNumSec, region, nomDepart, nomCommun);
    }
}
