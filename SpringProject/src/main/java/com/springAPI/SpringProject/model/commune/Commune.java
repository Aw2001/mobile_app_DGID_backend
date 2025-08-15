package com.springAPI.SpringProject.model.commune;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springAPI.SpringProject.model.departement.Departement;
import com.springAPI.SpringProject.model.section.Section;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "touteslescommunes")
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "touteslescommunes_id_gen")
    @SequenceGenerator(name = "touteslescommunes_id_gen", sequenceName = "communes_fatick_gid_seq", allocationSize = 1)
    @Column(name = "gid", nullable = false)
    private Integer id;

    @Column(name = "objectid")
    private Double objectid;

    @Column(name = "objectid_1")
    private Double objectid1;

    @Column(name = "nom_commun", length = 50)
    private String nomCommun;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "shape_leng", precision = 38, scale = 2)
    private BigDecimal shapeLeng;

    @Column(name = "nom_depart", length = 50)
    private String nomDepart;

    @Column(name = "shape_le_1", precision = 38, scale = 2)
    private BigDecimal shapeLe1;

    @Column(name = "shape_area", precision = 38, scale = 2)
    private BigDecimal shapeArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_id")
    @JsonBackReference
    private Departement departement;

    @OneToMany(mappedBy = "commune", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Section> sections;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getObjectid() {
        return objectid;
    }

    public void setObjectid(Double objectid) {
        this.objectid = objectid;
    }

    public Double getObjectid1() {
        return objectid1;
    }

    public void setObjectid1(Double objectid1) {
        this.objectid1 = objectid1;
    }

    public String getNomCommun() {
        return nomCommun;
    }

    public void setNomCommun(String nomCommun) {
        this.nomCommun = nomCommun;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}