package com.springAPI.SpringProject.model.bienRecense;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.recensement.Recensement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tousleslocauxrecenses")
public class BienRecense {

    @EmbeddedId
    @Column(nullable = false, unique = true)
    private BienRecenseId id;

    public BienRecenseId getId() {
        return id;
    }

    public void setId(BienRecenseId id) {
        this.id = id;
    }

    public Bien getBienRecense() {
        return bienRecense;
    }

    public void setBienRecense(Bien bienRecense) {
        this.bienRecense = bienRecense;
    }

    public Recensement getRecensement() {
        return recensement;
    }

    public void setRecensement(Recensement recensement) {
        this.recensement = recensement;
    }

    @MapsId("identifiantLocal")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name  = "identifiant_local", nullable = false)
    @JsonIgnore
    private Bien bienRecense;


    @MapsId("identifiantRecensement")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identifiant_recensement")
    @JsonIgnore
    private Recensement recensement;

    public void setBien(Bien bienRecense) {
        this.bienRecense = bienRecense;
    }

}
