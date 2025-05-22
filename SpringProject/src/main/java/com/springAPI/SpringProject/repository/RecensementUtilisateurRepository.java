package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateur;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateurId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecensementUtilisateurRepository extends JpaRepository<RecensementUtilisateur, RecensementUtilisateurId> {

    @Query("SELECT ru FROM RecensementUtilisateur ru WHERE ru.recensement.numRecensement = :recensementId")
    Optional<RecensementUtilisateur> findByRecensementId(@Param("recensementId") String recensementId);

    RecensementUtilisateur save(RecensementUtilisateur recensementUtilisateur);

    @Query("SELECT ru.recensement FROM RecensementUtilisateur ru " +
            "WHERE ru.utilisateur.identifiant = :email ")
    List<Recensement> findRecensementsUtilisateurActifs(@Param("email") String email);



}
