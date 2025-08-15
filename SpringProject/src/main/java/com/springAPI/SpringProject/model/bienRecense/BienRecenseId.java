package com.springAPI.SpringProject.model.bienRecense;

import com.springAPI.SpringProject.model.bienLoue.BienLoueId;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BienRecenseId implements Serializable {
    private static final long serialVersionUID = -6958869728850856204L;
    @Column(name = "identifiant_local", nullable = false)
    private String identifiantLocal;

    @Column(name = "identifiant_recensement", nullable = false)
    private String identifiantRecensement;

    public String getIdentifiantLocal() {
        return identifiantLocal;
    }

    public void setIdentifiantLocal(String identifiantLocal) {
        this.identifiantLocal = identifiantLocal;
    }

    public String getIdentifiantRecensement() {
        return identifiantRecensement;
    }

    public void setIdentifiantRecensement(String identifiantRecensement) {
        this.identifiantRecensement = identifiantRecensement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BienRecenseId entity = (BienRecenseId) o;
        return Objects.equals(this.identifiantLocal, entity.identifiantLocal) &&
                Objects.equals(this.identifiantRecensement, entity.identifiantRecensement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiantLocal, identifiantRecensement);
    }


}

