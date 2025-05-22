package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.bareme.BaremePrixImmeubleCollectif;
import com.springAPI.SpringProject.service.BaremePrixImmeubleCollectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baremePrixImmeubleCollectif")
public class BaremePrixImmeubleCollectifController {
    @Autowired
    private BaremePrixImmeubleCollectifService baremePrixImmeubleCollectifService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/prix")
    public Double getPrix(@RequestParam String region, @RequestParam String categorie) {
        return baremePrixImmeubleCollectifService.getPrixByRegionAndCategorie(region, categorie);
    }
}
