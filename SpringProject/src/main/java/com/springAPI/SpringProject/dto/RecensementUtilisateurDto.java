package com.springAPI.SpringProject.dto;

public class RecensementUtilisateurDto {
    private String identifiantRecensement;
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
}

