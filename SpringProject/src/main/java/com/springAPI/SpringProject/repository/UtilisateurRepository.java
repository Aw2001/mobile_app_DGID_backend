package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {

    Utilisateur save(Utilisateur utilisateur);

    @Query("SELECT u FROM Utilisateur u WHERE u.identifiant = :identifiant")
    Utilisateur findByEmail(@Param("identifiant") String identifiant);

    Utilisateur findByUsername(String username);

    @Query("SELECT u.lastLogoutTime FROM Utilisateur u WHERE u.username = :username")
    Instant findLastLogoutByUsername(@Param("username") String username);


    Optional<Utilisateur> findByVerificationCode(String verificationCode);
    Optional<Utilisateur> findByIdentifiant(String email);

    @Query("SELECT u.prenom, u.nom FROM Utilisateur u WHERE u.username = :username")
    String returnFirstNameAndLastName(@Param("username") String username);

    @Query("SELECT u.identifiant FROM Utilisateur u WHERE u.username = :username")
    String returnEmail(@Param("username") String username);

    @Query("SELECT u FROM Utilisateur u WHERE u.typePlateforme = 'MOBILE'")
    List<Utilisateur> returnAgents();
}
