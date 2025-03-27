package com.springAPI.SpringProject.model.utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "touslesutilisateurs")

public class Utilisateur implements UserDetails {


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

    public void setUsername(String username) {
        this.username = username;
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

    public Instant getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(Instant lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public LocalDateTime getVerificationCodeExpiresAt() {
        return verificationCodeExpiresAt;
    }

    public void setVerificationCodeExpiresAt(LocalDateTime verificationCodeExpiresAt) {
        this.verificationCodeExpiresAt = verificationCodeExpiresAt;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<RecensementUtilisateur> getRecensementUtilisateurs() {
        return recensementUtilisateurs;
    }

    public void setRecensementUtilisateurs(List<RecensementUtilisateur> recensementUtilisateurs) {
        this.recensementUtilisateurs = recensementUtilisateurs;
    }

    //email
    @Id
    @Column(name = "identifiant_utilisateur", nullable = false, unique = true, length = 50)
    private String identifiant;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "last_log_out_time")
    private Instant lastLogoutTime;

    @Column(name = "verification_code")
    private String verificationCode;
    @Column(name = "verification_expiration")
    private LocalDateTime verificationCodeExpiresAt;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean enabled;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    private List<RecensementUtilisateur> recensementUtilisateurs;

    public Utilisateur(String identifiant, String prenom, String nom, String username, String password, String role) {
        this.identifiant = identifiant;
        this.prenom = prenom;
        this.nom = nom;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Utilisateur() {}



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    //TODO: add proper boolean checks
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
}
