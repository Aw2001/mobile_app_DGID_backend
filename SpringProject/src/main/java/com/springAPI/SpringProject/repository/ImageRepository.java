package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    Image save(Image image);

    @Query("SELECT i FROM Image i WHERE i.bien.identifiant = :identifiant")
    List<Image> findByIdentifiantBien(@Param("identifiant") String identifiant);
}
