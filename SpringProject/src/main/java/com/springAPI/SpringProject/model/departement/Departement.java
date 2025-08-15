package com.springAPI.SpringProject.model.departement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springAPI.SpringProject.model.commune.Commune;
import com.springAPI.SpringProject.model.region.Region;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "touslesdepartements")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "touslesdepartements_id_gen")
    @SequenceGenerator(name = "touslesdepartements_id_gen", sequenceName = "limite_departements_senegal4326_gid_seq", allocationSize = 1)
    @Column(name = "gid", nullable = false)
    private Integer id;

    @Column(name = "code")
    private Double code;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "theme", length = 2)
    private String theme;

    @Column(name = "pays", length = 2)
    private String pays;

    @Column(name = "iduu", length = 36)
    private String iduu;

    @Column(name = "sum_superf", precision = 38, scale = 2)
    private BigDecimal sumSuperf;

    @Column(name = "shape_leng", precision = 38, scale = 2)
    private BigDecimal shapeLeng;

    @Column(name = "shape_le_1", precision = 38, scale = 2)
    private BigDecimal shapeLe1;

    @Column(name = "shape_area", precision = 38, scale = 2)
    private BigDecimal shapeArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonBackReference
    private Region region;


    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Commune> communes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCode() {
        return code;
    }

    public void setCode(Double code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getIduu() {
        return iduu;
    }

    public void setIduu(String iduu) {
        this.iduu = iduu;
    }

    public BigDecimal getSumSuperf() {
        return sumSuperf;
    }

    public void setSumSuperf(BigDecimal sumSuperf) {
        this.sumSuperf = sumSuperf;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }


}