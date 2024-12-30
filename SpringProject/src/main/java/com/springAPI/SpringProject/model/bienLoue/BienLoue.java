package com.springAPI.SpringProject.model.bienLoue;

import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.locataire.Locataire;
import jakarta.persistence.*;

@Entity
@Table(name = "tousleslocauxloues")
public class BienLoue {
    @EmbeddedId
    @Column(nullable = false, unique = true)
    private BienLoueId id;

    @MapsId("identifiantLocal")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identifiant_local", nullable = false)
    private Bien bienLoue;

    @MapsId("identifiantLocataire")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identifiant_locataire", nullable = false)
    private Locataire locataire;

    public BienLoueId getId() {
        return id;
    }

    public void setId(BienLoueId id) {
        this.id = id;
    }

    public Bien getBienLoue() {
        return bienLoue;
    }

    public void setBien(Bien bienLoue) {
        this.bienLoue = bienLoue;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }


}