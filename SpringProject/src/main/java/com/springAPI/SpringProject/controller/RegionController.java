package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.region.Region;
import com.springAPI.SpringProject.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    // Endpoint pour récupérer toutes les régions
    @GetMapping("/all")
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    // Endpoint pour récupérer geom, shape_leng et shape_area d'une région spécifique
    @GetMapping("/{id}/details")
    public Map<String, Object> getRegionDetailsById(@PathVariable int id) {
        return regionService.getRegionDetailsById(id);
    }
}

