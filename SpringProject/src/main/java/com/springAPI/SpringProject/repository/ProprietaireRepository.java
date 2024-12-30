package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.proprietaire.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {

    Proprietaire save(Proprietaire proprietaire);

    @Query("SELECT p from Proprietaire p WHERE p.numIdentifiant= :numIdentifiant")
    Proprietaire findByNumIdentifiant(@Param("numIdentifiant") String numIdentifiant);

}
