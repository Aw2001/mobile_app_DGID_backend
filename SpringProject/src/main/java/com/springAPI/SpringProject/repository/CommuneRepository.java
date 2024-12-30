package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.commune.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Integer> {

    @Query("SELECT c from Commune c")
    List<Commune> findAllCommunes();

    @Query("SELECT c.nomCommun from Commune c WHERE c.departement.nom = :departementName")
    List<String>findCommuneByDepartementName(@Param("departementName") String departementName);
}
