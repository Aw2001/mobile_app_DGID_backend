package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.bareme.BaremePrixImmeubleIndividuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaremePrixImmeubleIndividuelRepository extends JpaRepository<BaremePrixImmeubleIndividuel, Long> {

    @Query("SELECT b.prix FROM BaremePrixImmeubleIndividuel b WHERE b.region = :region AND b.cat = :categorie")
    Double findPrixImmeubleByRegionAndCategorie(@Param("region") String region, @Param("categorie") String categorie);
}
