package com.springAPI.SpringProject.model.locataire;

import com.springAPI.SpringProject.model.bienLoue.BienLoue;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tousleslocataires")
public class Locataire {
    @Id
    @Column(name = "cni", nullable = false, unique = true, length = 20)
    private String cni;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "type_occupation", length = 50)
    private String typeOccupation;

    @Column(name = "date_signature_contrat")
    private LocalDate dateSignatureContrat;

    @Column(name = "loyer_annuel")
    private Double loyerAnnuel;

    @Column(name = "nb_piece_occupe")
    private Integer nbPieceOccupe;

    @Column(name = "activite_economique", length = 50)
    private String activiteEconomique;

    @Column(name = "commentaire", length = Integer.MAX_VALUE)
    private String commentaire;

    @Column(name = "denomination", length = 50)
    private String denomination;

    @OneToMany(mappedBy = "locataire", fetch = FetchType.LAZY)
    private List<BienLoue> bienLoues;

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeOccupation() {
        return typeOccupation;
    }

    public void setTypeOccupation(String typeOccupation) {
        this.typeOccupation = typeOccupation;
    }

    public LocalDate getDateSignatureContrat() {
        return dateSignatureContrat;
    }

    public void setDateSignatureContrat(LocalDate dateSignatureContrat) {
        this.dateSignatureContrat = dateSignatureContrat;
    }

    public Double getLoyerAnnuel() {
        return loyerAnnuel;
    }

    public void setLoyerAnnuel(Double loyerAnnuel) {
        this.loyerAnnuel = loyerAnnuel;
    }

    public Integer getNbPieceOccupe() {
        return nbPieceOccupe;
    }

    public void setNbPieceOccupe(Integer nbPieceOccupe) {
        this.nbPieceOccupe = nbPieceOccupe;
    }

    public String getActiviteEconomique() {
        return activiteEconomique;
    }

    public void setActiviteEconomique(String activiteEconomique) {
        this.activiteEconomique = activiteEconomique;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public List<BienLoue> getBienLoues() {
        return bienLoues;
    }

    public void setBienLoues(List<BienLoue> bienLoues) {
        this.bienLoues = bienLoues;
    }


}