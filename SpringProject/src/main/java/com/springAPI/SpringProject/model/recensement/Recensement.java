package com.springAPI.SpringProject.model.recensement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springAPI.SpringProject.model.bienLoue.BienLoue;
import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateur;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "touslesrecensements")
public class Recensement {
    @Id
    @Column(name = "num_recensement", length = 50, unique = true, nullable = false)
    private String numRecensement;

    @Column(name = "methode_recensement", length = 50)
    private String methodeRecensement;

    @Column(name = "etat", length = 50)
    private String etat;

    @Column(name = "service", length = 50)
    private String service;

    @Column(name = "type_service", length = 50)
    private String typeService;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "commentaire", columnDefinition = "TEXT")
    private String commentaire;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "departement", length = 50)
    private String departement;

    @Column(name = "commune", length = 50)
    private String commune;

    @Column(name = "section", length = 50)
    private String section;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Column(name = "titre", length = 50)
    private String titre;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateCreation;

    @JsonIgnore
    @OneToMany(mappedBy = "recensement", fetch = FetchType.LAZY)
    private List<BienRecense> bienRecenses;

    @JsonIgnore
    @OneToMany(mappedBy = "recensement", fetch = FetchType.LAZY)
    private List<RecensementUtilisateur> recensementUtilisateurs;

    // Getters and Setters
    public String getNumRecensement() {
        return numRecensement;
    }

    public void setNumRecensement(String numRecensement) {
        this.numRecensement = numRecensement;
    }

    public String getMethodeRecensement() {
        return methodeRecensement;
    }

    public void setMethodeRecensement(String methodeRecensement) {
        this.methodeRecensement = methodeRecensement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<BienRecense> getBienRecenses() {
        return bienRecenses;
    }

    public void setBienRecenses(List<BienRecense> bienRecenses) {
        this.bienRecenses = bienRecenses;
    }

    public List<RecensementUtilisateur> getRecensementUtilisateurs() {
        return recensementUtilisateurs;
    }

    public void setRecensementUtilisateurs(List<RecensementUtilisateur> recensementUtilisateurs) {
        this.recensementUtilisateurs = recensementUtilisateurs;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

}
