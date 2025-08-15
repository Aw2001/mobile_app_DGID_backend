package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.section.Section;
import com.springAPI.SpringProject.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> getAllSections() {
        return sectionRepository.findAllSection();
    }
    public List<String> getSectionByCommuneName(String communeName) {
        return sectionRepository.findSectionByCommuneName(communeName);
    }
}
