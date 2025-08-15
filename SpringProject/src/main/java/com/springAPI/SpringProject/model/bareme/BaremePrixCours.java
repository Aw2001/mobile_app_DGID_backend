package com.springAPI.SpringProject.model.bareme;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "baremeprixcours")
public class BaremePrixCours {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baremeprixcours_id_gen")
    @SequenceGenerator(name = "baremeprixcours_id_gen", sequenceName = "baremeprixcours_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "categorie", length = 50)
    private String categorie;

    @Column(name = "prix")
    private Double prix;

}