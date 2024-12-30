package com.springAPI.SpringProject.model.recensementUtilisateur;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecensementUtilisateurId implements Serializable {
    private static final long serialVersionUID = -6958869728850856204L;

    @Column(name = "identifiant_recensement", nullable = false)
    private String identifiantRecensement;

    @Column(name = "identifiant_utilisateur", nullable = false)
    private String identifiantUtilisateur;

    public String getIdentifiantRecensement() {
        return identifiantRecensement;
    }

    public void setIdentifiantRecensement(String identifiantRecensement) {
        this.identifiantRecensement = identifiantRecensement;
    }

    public String getIdentifiantUtilisateur() {
        return identifiantUtilisateur;
    }

    public void setIdentifiantUtilisateur(String identifiantUtilisateur) {
        this.identifiantUtilisateur = identifiantUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateurId entity = (com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateurId) o;
        return Objects.equals(this.identifiantRecensement, entity.identifiantRecensement) &&
                Objects.equals(this.identifiantUtilisateur, entity.identifiantUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiantRecensement, identifiantUtilisateur);
    }


}
