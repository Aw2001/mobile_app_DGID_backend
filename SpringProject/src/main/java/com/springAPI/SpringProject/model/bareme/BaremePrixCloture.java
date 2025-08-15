package com.springAPI.SpringProject.model.bareme;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "baremeprixcloture")
public class BaremePrixCloture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baremeprixcloture_id_gen")
    @SequenceGenerator(name = "baremeprixcloture_id_gen", sequenceName = "baremeprixcloture_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "categorie", length = 50)
    private String categorie;

    @Column(name = "prix")
    private Double prix;

}