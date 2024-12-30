package com.springAPI.SpringProject.model.proprietaire;

import com.springAPI.SpringProject.model.bien.Bien;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "touslesproprietaires")
public class Proprietaire {
    @Id
    @Column(name = "num_identifiant", nullable = false, unique = true, length = 50)
    private String numIdentifiant;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "type_identifiant", length = 50)
    private String typeIdentifiant;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "lieu_naissance")
    private String lieuNaissance;

    @Column(name = "date_delivrance_identifiant")
    private LocalDate dateDelivranceIdentifiant;

    @Column(name = "date_expiration_identifiant")
    private LocalDate dateExpirationIdentifiant;

    @Column(name = "statut", length = 50)
    private String statut;

    @Column(name = "salarie", length = 20)
    private String salarie;

    @Column(name = "civilite", length = 20)
    private String civilite;

    @Column(name = "ninea", length = 50)
    private String ninea;

    @Column(name = "rencontre", length = 20)
    private String rencontre;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "telephone_contribuable", length = 50)
    private String telephoneContribuable;


    @Column(name = "valeur_locative_proprietaire")
    private Double valeurLocativeProprietaire;

    @Column(name = "enregistre", length = 20)
    private String enregistre;

    @Column(name = "pensionne", length = 20)
    private String pensionne;

    @Column(name = "autre_propriete", length = 20)
    private String autrePropriete;

    @Column(name = "commentaire", length = Integer.MAX_VALUE)
    private String commentaire;

    @OneToMany(mappedBy = "proprietaire", fetch = FetchType.LAZY)
    private List<Bien> biens;

    public String getNumIdentifiant() {
        return numIdentifiant;
    }

    public void setNumIdentifiant(String numIdentifiant) {
        this.numIdentifiant = numIdentifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTypeIdentifiant() {
        return typeIdentifiant;
    }

    public void setTypeIdentifiant(String typeIdentifiant) {
        this.typeIdentifiant = typeIdentifiant;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public LocalDate getDateDelivranceIdentifiant() {
        return dateDelivranceIdentifiant;
    }

    public void setDateDelivranceIdentifiant(LocalDate dateDelivranceIdentifiant) {
        this.dateDelivranceIdentifiant = dateDelivranceIdentifiant;
    }

    public LocalDate getDateExpirationIdentifiant() {
        return dateExpirationIdentifiant;
    }

    public void setDateExpirationIdentifiant(LocalDate dateExpirationIdentifiant) {
        this.dateExpirationIdentifiant = dateExpirationIdentifiant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSalarie() {
        return salarie;
    }

    public void setSalarie(String salarie) {
        this.salarie = salarie;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getRencontre() {
        return rencontre;
    }

    public void setRencontre(String rencontre) {
        this.rencontre = rencontre;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephoneContribuable() {
        return telephoneContribuable;
    }

    public void setTelephoneContribuable(String telephoneContribuable) {
        this.telephoneContribuable = telephoneContribuable;
    }
    public Double getValeurLocativeProprietaire() {
        return valeurLocativeProprietaire;
    }

    public void setValeurLocativeProprietaire(Double valeurLocativeProprietaire) {
        this.valeurLocativeProprietaire = valeurLocativeProprietaire;
    }

    public String getEnregistre() {
        return enregistre;
    }

    public void setEnregistre(String enregistre) {
        this.enregistre = enregistre;
    }

    public String getPensionne() {
        return pensionne;
    }

    public void setPensionne(String pensionne) {
        this.pensionne = pensionne;
    }

    public String getAutrePropriete() {
        return autrePropriete;
    }

    public void setAutrePropriete(String autrePropriete) {
        this.autrePropriete = autrePropriete;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public List<Bien> getBiens() {
        return biens;
    }

    public void setBiens(List<Bien> biens) {
        this.biens = biens;
    }

}