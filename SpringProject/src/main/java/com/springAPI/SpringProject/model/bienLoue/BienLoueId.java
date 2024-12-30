package com.springAPI.SpringProject.model.bienLoue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class BienLoueId implements java.io.Serializable {
    private static final long serialVersionUID = -6958869728850856204L;
    @Column(name = "identifiant_local", nullable = false)
    private String identifiantLocal;

    @Column(name = "identifiant_locataire", nullable = false)
    private String identifiantLocataire;

    public String getIdentifiantLocal() {
        return identifiantLocal;
    }

    public void setIdentifiantLocal(String identifiantLocal) {
        this.identifiantLocal = identifiantLocal;
    }

    public String getIdentifiantLocataire() {
        return identifiantLocataire;
    }

    public void setIdentifiantLocataire(String identifiantLocataire) {
        this.identifiantLocataire = identifiantLocataire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BienLoueId entity = (BienLoueId) o;
        return Objects.equals(this.identifiantLocal, entity.identifiantLocal) &&
                Objects.equals(this.identifiantLocataire, entity.identifiantLocataire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiantLocal, identifiantLocataire);
    }

}