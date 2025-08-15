package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.image.Image;
import com.springAPI.SpringProject.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    private ImageService imageService;
    
    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @PostMapping("/add/{idBien}")
    public ResponseEntity<String> uploadImage(@PathVariable String idBien, @RequestParam("file") MultipartFile file) {
        try {
            Image image = imageService.enregistrerImage(idBien, file);
            return ResponseEntity.ok("Image uploaded successfully for Bien ID: " + idBien);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload image: " + e.getMessage());
        }
    }

    //@PreAuthorize("hasAnyRole('AGENT', 'ADMIN')")
    @GetMapping("/research/{idBien}")
    public List<Image> researchImage(@PathVariable String idBien) {
        return imageService.findImageById(idBien);
    }
}
