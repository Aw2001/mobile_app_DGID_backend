package com.springAPI.SpringProject.model.bareme;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "baremepriximmeubleindividuel")
public class BaremePrixImmeubleIndividuel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baremepriximmeubleindividuel_id_gen")
    @SequenceGenerator(name = "baremepriximmeubleindividuel_id_gen", sequenceName = "baremepriximmeubleindividuel_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "cat")
    private String cat;

    @Column(name = "prix")
    private Double prix;

}
