package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.section.Section;
import com.springAPI.SpringProject.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/byCommune")
    public List<String> getAllSectionsByCommune(@RequestParam String communeName) {
        return sectionService.getSectionByCommuneName(communeName);
    }
}
