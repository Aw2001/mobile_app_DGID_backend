package com.springAPI.SpringProject.repository;


import com.springAPI.SpringProject.model.departement.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    //methode pour lister tous les départements
    @Query("SELECT d from Departement d")
    List<Departement> findAllDepartements();

    //methode pour lister tous les départements d'une région
    @Query("SELECT DISTINCT d.nom FROM Departement d WHERE d.region.nom = :regionName")
    List<String> findByRegion(@Param("regionName") String regionName);

}
