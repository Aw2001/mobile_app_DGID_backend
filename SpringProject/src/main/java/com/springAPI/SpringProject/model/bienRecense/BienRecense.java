package com.springAPI.SpringProject.model.bienRecense;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.recensement.Recensement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "tousleslocauxrecenses")
public class BienRecense {
    @Setter
    @EmbeddedId
    @Column(nullable = false, unique = true)
    private BienRecenseId id;

    @MapsId("identifiantLocal")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name  = "identifiant_local", nullable = false)
    @JsonIgnore
    private Bien bienRecense;

    @Setter
    @MapsId("identifiantRecensement")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identifiant_recensement")
    @JsonIgnore
    private Recensement recensement;

    public void setBien(Bien bienRecense) {
        this.bienRecense = bienRecense;
    }

}
