package com.springAPI.SpringProject.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "departements")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departements_id_gen")
    @SequenceGenerator(name = "departements_id_gen", sequenceName = "departements_fatick_gid_seq", allocationSize = 1)
    @Column(name = "gid", nullable = false)
    private Integer id;

    @Column(name = "objectid_1")
    private Double objectid1;

    @Column(name = "objectid")
    private Double objectid;

    @Column(name = "shape_leng")
    private BigDecimal shapeLeng;

    @Column(name = "nom_depart", length = 50)
    private String nomDepart;

    @Column(name = "shape_le_1")
    private BigDecimal shapeLe1;

    @Column(name = "shape_area")
    private BigDecimal shapeArea;

    @Column(name = "region", length = 11)
    private String region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(BigDecimal shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

/*
 TODO [Reverse Engineering] create field to map the 'geom' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "geom", columnDefinition = "geometry")
    private Object geom;
*/
}