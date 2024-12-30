package com.springAPI.SpringProject.repository;

import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.model.bienRecense.BienRecenseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRecenseRepository extends JpaRepository<BienRecense, BienRecenseId> {

    BienRecense save(BienRecense bienRecense);
    List<BienRecense> findAll();
}
