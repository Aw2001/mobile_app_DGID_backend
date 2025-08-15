package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.locataire.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, String> {

    public Locataire save(Locataire locataire);

    @Query("SELECT l from Locataire l WHERE l.cni= :cni")
    Locataire findByCni(@Param("cni") String cni);

    @Query("SELECT COUNT(l) FROM Locataire l")
    long countLocataire();
}
