package com.springAPI.SpringProject.dto;
import lombok.Getter;
import lombok.Setter;


public class RegisterUserDto {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    public String getTypePlateforme() {
        return typePlateforme;
    }

    public void setTypePlateforme(String typePlateforme) {
        this.typePlateforme = typePlateforme;
    }
    private String email;
    private String prenom;
    private String nom;
    private String username;
    private String password;
    private String role;
    private String typePlateforme;



}
