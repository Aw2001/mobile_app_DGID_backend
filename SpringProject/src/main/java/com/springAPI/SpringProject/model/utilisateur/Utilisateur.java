package com.springAPI.SpringProject.model.utilisateur;

import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateur;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "touslesutilisateurs")
public class Utilisateur {

    //email
    @Id
    @Column(name = "identifiant", nullable = false, unique = true, length = 50)
    private String identifiant;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "login", length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "role", length = 50)
    private String role;

    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    private List<RecensementUtilisateur> recensementUtilisateurs;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<RecensementUtilisateur> getRecensementUtilisateurs() {
        return recensementUtilisateurs;
    }

    public void setRecensementUtilisateurs(List<RecensementUtilisateur> recensementUtilisateurs) {
        this.recensementUtilisateurs = recensementUtilisateurs;
    }
}
