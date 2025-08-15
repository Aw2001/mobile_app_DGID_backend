package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.departement.Departement;
import com.springAPI.SpringProject.model.region.Region;
import com.springAPI.SpringProject.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    //Endpoint pour recupérer toutes les régions
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }


}
