package com.springAPI.SpringProject.model.bienRecense;

import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.recensement.Recensement;
import jakarta.persistence.*;

@Entity
@Table(name = "tousleslocauxrecenses")
public class BienRecense {
    @EmbeddedId
    @Column(nullable = false, unique = true)
    private BienRecenseId id;

    @MapsId("identifiantLocal")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name  = "identifiant_local", nullable = false)
    private Bien bienRecense;

    @MapsId("identifiantRecensement")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identifiant_recensement")
    private Recensement recensement;

    public BienRecenseId getId() {
        return id;
    }

    public void setId(BienRecenseId id) {
        this.id = id;
    }

    public Bien getBienRecense() {
        return bienRecense;
    }

    public void setBien(Bien bienRecense) {
        this.bienRecense = bienRecense;
    }

    public Recensement getRecensement() {
        return recensement;
    }

    public void setRecensement(Recensement recensement) {
        this.recensement = recensement;
    }

}
