package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.bien.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BienRepository extends JpaRepository<Bien, String> {
    Bien save(Bien bien);

    @Query("SELECT b FROM Bien b WHERE b.identifiant = :identifiant")
    Bien findByIdentifiant(@Param("identifiant") String identifiant);

    @Query("SELECT b FROM Bien b")
    List<Bien> findBiens();

    @Query("SELECT COUNT(b) FROM Bien b")
    long countBiens();

    @Query("SELECT b from Bien b WHERE b.parcelle.nicad = :nicad")
    List<Bien> findBienByNicad(@Param("nicad") String nicad);
}
