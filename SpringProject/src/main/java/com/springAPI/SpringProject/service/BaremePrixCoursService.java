package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.repository.BaremePrixCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaremePrixCoursService {
    @Autowired
    private BaremePrixCoursRepository baremePrixCoursRepository;

    public Double getPrixCours(String region, String categorie) {
        return baremePrixCoursRepository.findPrixCoursByRegionAndCategorie(region, categorie);
    }
}
