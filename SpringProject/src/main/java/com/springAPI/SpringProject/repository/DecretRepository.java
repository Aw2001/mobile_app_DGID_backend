package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.decret.Decret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecretRepository extends JpaRepository<Decret, Long> {


    @Query("SELECT d.prixTerrain FROM Decret d WHERE d.region = :region AND d.departement = :departement AND d.commune = :commune AND d.secteur = :secteur AND d.zone = :zone")
    Double findPrixTerrainBySecteurAndZone(@Param("region") String region, @Param("departement") String departement, @Param("commune") String commune, @Param("secteur") String secteur, @Param("zone") String zone);

    @Query("SELECT DISTINCT d.departement FROM Decret d WHERE d.region = :region")
    List<String> findDepartementByRegion(@Param("region") String region);

    @Query("SELECT DISTINCT d.commune FROM Decret d WHERE d.departement = :departement")
    List<String> findCommuneByDepartement(@Param("departement") String departement);

    @Query("SELECT DISTINCT d.secteur FROM Decret d WHERE d.commune = :commune")
    List<String> findSecteursByCommune(
            @Param("commune") String commune
    );

    @Query("SELECT DISTINCT d.zone FROM Decret d WHERE d.region = :region AND d.departement = :departement AND d.commune = :commune AND d.secteur = :secteur")
    List<String> findZoneBySecteur(@Param("region") String region, @Param("departement") String departement, @Param("commune") String commune, @Param("secteur") String secteur);


}
