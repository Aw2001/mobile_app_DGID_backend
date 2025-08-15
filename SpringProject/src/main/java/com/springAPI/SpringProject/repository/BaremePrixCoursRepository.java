package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.bareme.BaremePrixCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaremePrixCoursRepository extends JpaRepository<BaremePrixCours, Long> {

    @Query("SELECT b.prix FROM BaremePrixCours b WHERE b.region = :region AND b.categorie = :categorie")
    Double findPrixCoursByRegionAndCategorie(@Param("region") String region, @Param("categorie") String categorie);
}
