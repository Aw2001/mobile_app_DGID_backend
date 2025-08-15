package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {

    @Query("SELECT s from Section s")
    List<Section> findAllSection();

    @Query("SELECT DISTINCT s.numeroSec from Section s WHERE s.commune.nomCommun = :communeName")
    List<String> findSectionByCommuneName(@Param("communeName") String communeName);
}
