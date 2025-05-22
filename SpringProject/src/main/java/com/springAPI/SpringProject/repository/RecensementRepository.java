package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.recensement.Recensement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecensementRepository extends JpaRepository<Recensement, String> {

    Recensement save(Recensement recensement);

    // Méthode pour rechercher un recensement par son numéro
    @Query("SELECT r FROM Recensement r WHERE r.numRecensement = :numRecensement")
    Recensement findByNumRecensement(@Param("numRecensement") String numRecensement);

    //lister les recensements à compléter ou actif
    @Query("SELECT r FROM Recensement r where r.etat = 'A compléter' ")
    List<Recensement> findRecensementsActifs();

    @Query("SELECT r FROM Recensement r")
    List<Recensement> findRecensements();

    //nombre de recensements créés
    @Query("SELECT COUNT(r) FROM Recensement r")
    long countRecensements();
}
