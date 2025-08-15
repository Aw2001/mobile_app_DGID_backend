package com.springAPI.SpringProject.model.recensementUtilisateur;

import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import jakarta.persistence.*;

@Entity
@Table(name = "touslesutilisateursdesrecensements")
public class RecensementUtilisateur {
    @EmbeddedId
    @Column(nullable = false, unique = true)
    private RecensementUtilisateurId id;

    @MapsId("identifiantRecensement")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name  = "identifiant_recensement", nullable = false)
    private Recensement recensement;


    @MapsId("identifiantUtilisateur")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identifiant_utilisateur")
    private Utilisateur utilisateur;

    public RecensementUtilisateurId getId() {
        return id;
    }

    public void setId(RecensementUtilisateurId id) {
        this.id = id;
    }

    public Recensement getRecensement() {
        return recensement;
    }

    public void setRecensement(Recensement recensement) {
        this.recensement = recensement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}

