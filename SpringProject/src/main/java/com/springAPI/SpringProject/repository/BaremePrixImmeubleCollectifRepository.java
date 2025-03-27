package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.bareme.BaremePrixImmeubleCollectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaremePrixImmeubleCollectifRepository extends JpaRepository<BaremePrixImmeubleCollectif, Long> {

    @Query("SELECT b.prix FROM BaremePrixImmeubleCollectif b WHERE b.region = :region AND b.categorie = :categorie")
    Double findPrixImmeubleByRegionAndCategorie(@Param("region") String region, @Param("categorie") String categorie);
}
