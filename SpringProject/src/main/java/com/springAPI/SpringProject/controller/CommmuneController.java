package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.commune.Commune;
import com.springAPI.SpringProject.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/communes")
public class CommmuneController {

    @Autowired
    private CommuneService communeService;

    @GetMapping("/all")
    public List<Commune> getAllCommunes() {
        return communeService.getAllCommunes();
    }

    @GetMapping("/byDepartement")
    public List<String> getCommuneByDepartementName(@RequestParam String departementName) {
        return communeService.getCommuneByDepartementName(departementName);
    }
}
