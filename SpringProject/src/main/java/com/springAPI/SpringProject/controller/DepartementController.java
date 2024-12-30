package com.springAPI.SpringProject.controller;


import com.springAPI.SpringProject.model.departement.Departement;
import com.springAPI.SpringProject.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping("/all")
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/byRegion")
    public List<String> getAllDepartementsByRegionName(@RequestParam String regionName) {
        return departementService.getDepartementsByRegionName(regionName);
    }
}
