package com.springAPI.SpringProject.model.decret;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "decret")
public class Decret {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "decret_id_gen")
    @SequenceGenerator(name = "decret_id_gen", sequenceName = "decret_id_decret_seq", allocationSize = 1)
    @Column(name = "id_decret", nullable = false)
    private Long id;

    @Column(name = "region")
    private String region;

    @Column(name = "commune")
    private String commune;

    @Column(name = "secteur")
    private String secteur;

    @Column(name = "prix_terrain")
    private Double prixTerrain;

    @Column(name = "departement")
    private String departement;

    @Column(name = "cav", length = 29)
    private String cav;

    @Column(name = "zone_", length = 50)
    private String zone;

}