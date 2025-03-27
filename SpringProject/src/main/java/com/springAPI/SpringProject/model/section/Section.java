package com.springAPI.SpringProject.model.section;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springAPI.SpringProject.model.commune.Commune;
import com.springAPI.SpringProject.model.parcelle.Parcelle;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "touteslessections")
public class Section {
    @Id
    @Column(name = "identifiant", nullable = false, length = 50)
    private String identifiant;

    @Column(name = "objectid_1")
    private Double objectid1;

    @Column(name = "objectid")
    private Double objectid;

    @Column(name = "join_count")
    private Double joinCount;

    @Column(name = "target_fid")
    private Double targetFid;

    @Column(name = "numero_sec", length = 50)
    private String numeroSec;

    @Column(name = "shape_leng")
    private BigDecimal shapeLeng;

    @Column(name = "shape_le_1")
    private BigDecimal shapeLe1;

    @Column(name = "shape_area")
    private BigDecimal shapeArea;

    @Column(name = "nom_commune", length = 50)
    private String nom_commune;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commune_id")
    @JsonBackReference
    private Commune commune;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Parcelle> parcelles;


    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Double getObjectid1() {
        return objectid1;
    }

    public void setObjectid1(Double objectid1) {
        this.objectid1 = objectid1;
    }

    public Double getObjectid() {
        return objectid;
    }

    public void setObjectid(Double objectid) {
        this.objectid = objectid;
    }

    public Double getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Double joinCount) {
        this.joinCount = joinCount;
    }

    public Double getTargetFid() {
        return targetFid;
    }

    public void setTargetFid(Double targetFid) {
        this.targetFid = targetFid;
    }

    public String getNumeroSec() {
        return numeroSec;
    }

    public void setNumeroSec(String numeroSec) {
        this.numeroSec = numeroSec;
    }

    public BigDecimal getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(BigDecimal shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public BigDecimal getShapeLe1() {
        return shapeLe1;
    }

    public void setShapeLe1(BigDecimal shapeLe1) {
        this.shapeLe1 = shapeLe1;
    }

    public BigDecimal getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(BigDecimal shapeArea) {
        this.shapeArea = shapeArea;
    }

    public String getCommune() {
        return nom_commune;
    }

    public void setCommune(String commune) {
        this.nom_commune = commune;
    }


}