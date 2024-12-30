package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.recensement.Recensement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecensementRepository extends JpaRepository<Recensement, String> {

    Recensement save(Recensement recensement);

    // Méthode pour rechercher un recensement par son numéro
    @Query("SELECT r FROM Recensement r WHERE r.numRecensement = :numRecensement")
    Recensement findByNumRecensement(@Param("numRecensement") String numRecensement);
}
