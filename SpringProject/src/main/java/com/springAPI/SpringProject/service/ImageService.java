package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.image.Image;
import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.repository.BienRepository;
import com.springAPI.SpringProject.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private BienRepository bienRepository;

    public Image enregistrerImage(String idBien, MultipartFile file) throws IOException {
        System.out.println("imageeeeeeeeeeee");
        Bien bienTrouve = bienRepository.findById(idBien)
                .orElseThrow(() -> new RuntimeException("Bien non trouvé"));
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setFileType(file.getContentType());
        image.setImageData(file.getBytes());
        image.setBien(bienTrouve);

        return imageRepository.save(image);
    }

    @Transactional
    public List<Image> findImageById(String idBien) {
        return imageRepository.findByIdentifiantBien(idBien);
    }
}
