package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.region.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    //Méthode pour lister toutes les régions
    @Query("SELECT r FROM Region r")
    List<Region> findAllRegions();
}
