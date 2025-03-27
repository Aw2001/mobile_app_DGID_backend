package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.bareme.BaremePrixCloture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaremePrixClotureRepository extends JpaRepository<BaremePrixCloture, Long> {

    @Query("SELECT b.prix FROM BaremePrixCloture b WHERE b.region = :region AND b.categorie = :categorie")
    Double findPrixClotureByRegionAndCategorie(@Param("region") String region, @Param("categorie") String categorie);
}
