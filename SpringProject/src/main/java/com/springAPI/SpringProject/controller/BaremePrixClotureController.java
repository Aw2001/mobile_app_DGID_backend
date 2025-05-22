package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.service.BaremePrixClotureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baremePrixCloture")
public class BaremePrixClotureController {
    @Autowired
    private BaremePrixClotureService baremePrixClotureService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/prix")
    public Double getPrixCloture(@RequestParam String region, @RequestParam String categorie) {
        return baremePrixClotureService.getPrixCloture(region, categorie);
    }
}
