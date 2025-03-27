package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.service.BaremePrixImmeubleIndividuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baremePrixImmeubleIndividuel")
public class BaremePrixImmeubleIndividuelController {
    @Autowired
    private BaremePrixImmeubleIndividuelService baremePrixImmeubleIndividuelService;

    @GetMapping("/prix")
    public Double getPrix(@RequestParam String region, @RequestParam String categorie) {
        return baremePrixImmeubleIndividuelService.getPrixImmeubleByRegionAndCategorie(region, categorie);
    }
}
