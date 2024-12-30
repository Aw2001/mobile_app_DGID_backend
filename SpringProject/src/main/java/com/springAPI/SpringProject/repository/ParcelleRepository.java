package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.parcelle.Parcelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelleRepository extends JpaRepository<Parcelle, String> {

    @Query("SELECT p from Parcelle p")
    List<Parcelle> findAllParcelles();

    @Query("SELECT p.nicad from Parcelle p WHERE p.section.numeroSec = :sectionNumSec")
    List<String> findAllParcellesBySectionNumSec(@Param("sectionNumSec") String sectionNumSec);

    @Query("SELECT p from Parcelle p WHERE p.nicad= :nicad")
    Parcelle findByNicad(@Param("nicad") String nicad);

}
