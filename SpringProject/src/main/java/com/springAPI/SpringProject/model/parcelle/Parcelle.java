package com.springAPI.SpringProject.model.parcelle;

import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.commune.Commune;
import com.springAPI.SpringProject.model.section.Section;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "touteslesparcelles")
public class Parcelle {
    @Id
    @Column(name = "nicad", nullable = false, length = 50)
    private String nicad;

    @Column(name = "objectid_1")
    private Double objectid1;

    @Column(name = "num_parc", length = 50)
    private String numParc;

    @Column(name = "num_lot", length = 50)
    private String numLot;

    @Column(name = "nom_depart", length = 50)
    private String nomDepart;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "nom_commun", length = 50)
    private String nomCommun;

    @Column(name = "num_sect", length = 50)
    private String numSect;

    @Column(name = "shape_leng", precision = 38, scale = 2)
    private BigDecimal shapeLeng;

    @Column(name = "cod_sect", length = 50)
    private String codSect;

    @Column(name = "syscol_1", length = 50)
    private String syscol1;

    @Column(name = "shape_le_1", precision = 38, scale = 2)
    private BigDecimal shapeLe1;

    @Column(name = "shape_area", precision = 38, scale = 2)
    private BigDecimal shapeArea;

    @Column(name = "shape_area_1", precision = 38, scale = 2)
    private BigDecimal shapeArea1;

    @Column(name = "ancienne_identifiant_section", length = 50)
    private String identifiantSection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_identifiant")
    private Section section;

    @OneToMany(mappedBy = "parcelle", fetch = FetchType.LAZY)
    private List<Bien> biens;

    public String getNicad() {
        return nicad;
    }

    public void setNicad(String nicad) {
        this.nicad = nicad;
    }

    public Double getObjectid1() {
        return objectid1;
    }

    public void setObjectid1(Double objectid1) {
        this.objectid1 = objectid1;
    }

    public String getNumParc() {
        return numParc;
    }

    public void setNumParc(String numParc) {
        this.numParc = numParc;
    }

    public String getNumLot() {
        return numLot;
    }

    public void setNumLot(String numLot) {
        this.numLot = numLot;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNomCommun() {
        return nomCommun;
    }

    public void setNomCommun(String nomCommun) {
        this.nomCommun = nomCommun;
    }

    public String getNumSect() {
        return numSect;
    }

    public void setNumSect(String numSect) {
        this.numSect = numSect;
    }

    public BigDecimal getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(BigDecimal shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public String getCodSect() {
        return codSect;
    }

    public void setCodSect(String codSect) {
        this.codSect = codSect;
    }

    public String getSyscol1() {
        return syscol1;
    }

    public void setSyscol1(String syscol1) {
        this.syscol1 = syscol1;
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

    public BigDecimal getShapeArea1() {
        return shapeArea1;
    }

    public void setShapeArea1(BigDecimal shapeArea1) {
        this.shapeArea1 = shapeArea1;
    }

    public String getIdentifiantSection() {
        return identifiantSection;
    }

    public void setIdentifiantSection(String identifiantSection) {
        this.identifiantSection = identifiantSection;
    }

}