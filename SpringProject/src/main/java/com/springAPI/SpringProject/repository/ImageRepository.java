package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    Image save(Image image);
}
