package com.springAPI.SpringProject.model.bareme;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "baremepriximmeublecollectif")
public class BaremePrixImmeubleCollectif {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baremepriximmeublecollectif_id_gen")
    @SequenceGenerator(name = "baremepriximmeublecollectif_id_gen", sequenceName = "baremepriximmeublecollectif_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "categorie")
    private String categorie;

    @Column(name = "prix")
    private Double prix;

}