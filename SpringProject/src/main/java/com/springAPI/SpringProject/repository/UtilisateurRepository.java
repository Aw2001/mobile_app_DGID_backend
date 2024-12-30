package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    Utilisateur save(Utilisateur utilisateur);

    @Query("SELECT u FROM Utilisateur u WHERE u.identifiant = :identifiant")
    Utilisateur findByIdentifiant(@Param("identifiant") String identifiant);
}
