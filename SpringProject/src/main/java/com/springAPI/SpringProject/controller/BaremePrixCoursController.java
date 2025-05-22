package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.service.BaremePrixCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baremePrixCours")
public class BaremePrixCoursController {
    @Autowired
    private BaremePrixCoursService baremePrixCoursService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/prix")
    public Double getPrixCours(@RequestParam String region, @RequestParam String categorie) {
        return baremePrixCoursService.getPrixCours(region, categorie);
    }
}
