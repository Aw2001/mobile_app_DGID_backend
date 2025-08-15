package com.springAPI.SpringProject.model.parcelle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.commune.Commune;
import com.springAPI.SpringProject.model.section.Section;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "touteslesparcelles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parcelle {
    @Id
    @Column(name = "nicad", nullable = false, length = 50)
    private String nicad;

    @JsonIgnore
    @Column(name = "objectid_1")
    private Double objectid1;

    @Column(name = "num_parc", length = 50)
    private String numParc;

    @JsonIgnore
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

    @JsonIgnore
    @Column(name = "shape_leng", precision = 38, scale = 2)
    private BigDecimal shapeLeng;

    @JsonIgnore
    @Column(name = "cod_sect", length = 50)
    private String codSect;

    @JsonIgnore
    @Column(name = "syscol_1", length = 50)
    private String syscol1;

    @JsonIgnore
    @Column(name = "shape_le_1", precision = 38, scale = 2)
    private BigDecimal shapeLe1;

    @JsonIgnore
    @Column(name = "shape_area", precision = 38, scale = 2)
    private BigDecimal shapeArea;

    @JsonIgnore
    @Column(name = "shape_area_1", precision = 38, scale = 2)
    private BigDecimal shapeArea1;

    @JsonIgnore
    @Column(name = "ancienne_identifiant_section", length = 50)
    private String identifiantSection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_identifiant")
    @JsonIgnore
    private Section section;


    @OneToMany(mappedBy = "parcelle", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Bien> biens;



}