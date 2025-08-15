package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.bienLoue.BienLoue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienLoueRepository extends JpaRepository<BienLoue, String> {
    BienLoue save(BienLoue bienLoue);

    List<BienLoue> findAll();
}
