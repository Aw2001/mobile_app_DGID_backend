package com.springAPI.SpringProject.controller;

import com.springAPI.SpringProject.model.image.Image;
import com.springAPI.SpringProject.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/add/{idBien}")
    public ResponseEntity<String> uploadImage(@PathVariable String idBien, @RequestParam("file") MultipartFile file) {
        try {
            Image image = imageService.enregistrerImage(idBien, file);
            return ResponseEntity.ok("Image uploaded successfully for Bien ID: " + idBien);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload image: " + e.getMessage());
        }
    }
}
