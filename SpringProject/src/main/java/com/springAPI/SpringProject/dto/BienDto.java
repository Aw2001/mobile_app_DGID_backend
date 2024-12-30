package com.springAPI.SpringProject.dto;

import com.springAPI.SpringProject.model.parcelle.Parcelle;
import com.springAPI.SpringProject.model.proprietaire.Proprietaire;
import jakarta.persistence.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class BienDto {

    private String identifiant;
    private Double superficie;
    private String proprieteEnLocation;
    private String adresse;
    private String quartier;
    private String village;
    private String numPorteAdm;
    private String codeDeRueAdm;
    private String nomRue;
    private String typeLot;
    private Integer niveauLot;
    private String localisationLot;
    private String situationLot;
    private String numLot;
    private Double valeurLocativeAnnuelle;
    private Double valeurLocativeAnnuelleSaisie;
    private String numTitreFoncier;
    private LocalDate dateAcquisition;
    private String typeOccupation;
    private String autreTypeOccupation;
    private LocalDate dateDelivranceTypeOccupation;
    private String usagee;
    private String numCompteurSde;
    private String numCompteurSenelec;
    private List<String> photoUrl;
    private String typeConstruction;
    private String toiture;
    private String typeCloture;
    private String etatCloture;
    private String typeRevetement;
    private String etatRevetement;
    private String situationRoute;
    private String typeRoute;
    private String garage;
    private String qualitePorteFenetre;
    private String typeCarrelage;
    private String menuiserie;
    private String conceptionPieces;
    private String appareilsSanitaires;
    private String parkingInterieur;
    private Integer nbAscenseurs;
    private Integer nbSalleBain;
    private Integer nbSalleEau;
    private Integer nbPieceReception;
    private Integer nbTotalPiece;
    private Integer nbEtage;
    private String confort;
    private Double valeurLocativeMensuelle;
    private Double valeurLocativeMensuelleSaisie;
    private String escalier;
    private String videOrdure;
    private String monteCharge;
    private String groupeElectrogene;
    private String dependanceIsolee;
    private String garageSouterrain;
    private String systemeClimatisation;
    private String systemeDomotique;
    private String balcon;
    private String terrasse;
    private String systemeSurveillance;
    private String amenagementPaysager;
    private String jardin;
    private String piscine;
    private String coursDeTennis;
    private String coursGazonnee;
    private String terrainGolf;
    private String autre;
    private String angle;
    private String eclairagePublic;
    private String murEnCiment;
    private String attributsArchitecturaux;
    private String trottoir;
    private String nomVoirie;
    private String typeVoirie;
    private String nomAutreVoirie;
    private String typeParcelle;
    private String commentaire;
    private String idProprietaire;
    private String idParcelle;


    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public String getProprieteEnLocation() {
        return proprieteEnLocation;
    }

    public void setProprieteEnLocation(String proprieteEnLocation) {
        this.proprieteEnLocation = proprieteEnLocation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
    public String getNumPorteAdm() {
        return numPorteAdm;
    }

    public void setNumPorteAdm(String numPorteAdm) {
        this.numPorteAdm = numPorteAdm;
    }

    public String getCodeDeRueAdm() {
        return codeDeRueAdm;
    }

    public void setCodeDeRueAdm(String codeDeRueAdm) {
        this.codeDeRueAdm = codeDeRueAdm;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getTypeLot() {
        return typeLot;
    }

    public void setTypeLot(String typeLot) {
        this.typeLot = typeLot;
    }

    public Integer getNiveauLot() {
        return niveauLot;
    }

    public void setNiveauLot(Integer niveauLot) {
        this.niveauLot = niveauLot;
    }

    public String getLocalisationLot() {
        return localisationLot;
    }

    public void setLocalisationLot(String localisationLot) {
        this.localisationLot = localisationLot;
    }

    public String getSituationLot() {
        return situationLot;
    }

    public void setSituationLot(String situationLot) {
        this.situationLot = situationLot;
    }

    public String getNumLot() {
        return numLot;
    }

    public void setNumLot(String numLot) {
        this.numLot = numLot;
    }

    public Double getValeurLocativeAnnuelle() {
        return valeurLocativeAnnuelle;
    }

    public void setValeurLocativeAnnuelle(Double valeurLocativeAnnuelle) {
        this.valeurLocativeAnnuelle = valeurLocativeAnnuelle;
    }

    public Double getValeurLocativeAnnuelleSaisie() {
        return valeurLocativeAnnuelleSaisie;
    }

    public void setValeurLocativeAnnuelleSaisie(Double valeurLocativeAnnuelleSaisie) {
        this.valeurLocativeAnnuelleSaisie = valeurLocativeAnnuelleSaisie;
    }

    public String getNumTitreFoncier() {
        return numTitreFoncier;
    }

    public void setNumTitreFoncier(String numTitreFoncier) {
        this.numTitreFoncier = numTitreFoncier;
    }

    public LocalDate getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(LocalDate dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public String getTypeOccupation() {
        return typeOccupation;
    }

    public void setTypeOccupation(String typeOccupation) {
        this.typeOccupation = typeOccupation;
    }

    public String getAutreTypeOccupation() {
        return autreTypeOccupation;
    }

    public void setAutreTypeOccupation(String autreTypeOccupation) {
        this.autreTypeOccupation = autreTypeOccupation;
    }

    public LocalDate getDateDelivranceTypeOccupation() {
        return dateDelivranceTypeOccupation;
    }

    public void setDateDelivranceTypeOccupation(LocalDate dateDelivranceTypeOccupation) {
        this.dateDelivranceTypeOccupation = dateDelivranceTypeOccupation;
    }

    public String getUsagee() {
        return usagee;
    }

    public void setUsagee(String usagee) {
        this.usagee = usagee;
    }

    public String getNumCompteurSde() {
        return numCompteurSde;
    }

    public void setNumCompteurSde(String numCompteurSde) {
        this.numCompteurSde = numCompteurSde;
    }

    public String getNumCompteurSenelec() {
        return numCompteurSenelec;
    }

    public void setNumCompteurSenelec(String numCompteurSenelec) {
        this.numCompteurSenelec = numCompteurSenelec;
    }

    public List<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(List<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTypeConstruction() {
        return typeConstruction;
    }

    public void setTypeConstruction(String typeConstruction) {
        this.typeConstruction = typeConstruction;
    }

    public String getToiture() {
        return toiture;
    }

    public void setToiture(String toiture) {
        this.toiture = toiture;
    }

    public String getTypeCloture() {
        return typeCloture;
    }

    public void setTypeCloture(String typeCloture) {
        this.typeCloture = typeCloture;
    }

    public String getEtatCloture() {
        return etatCloture;
    }

    public void setEtatCloture(String etatCloture) {
        this.etatCloture = etatCloture;
    }

    public String getTypeRevetement() {
        return typeRevetement;
    }

    public void setTypeRevetement(String typeRevetement) {
        this.typeRevetement = typeRevetement;
    }

    public String getEtatRevetement() {
        return etatRevetement;
    }

    public void setEtatRevetement(String etatRevetement) {
        this.etatRevetement = etatRevetement;
    }

    public String getSituationRoute() {
        return situationRoute;
    }

    public void setSituationRoute(String situationRoute) {
        this.situationRoute = situationRoute;
    }

    public String getTypeRoute() {
        return typeRoute;
    }

    public void setTypeRoute(String typeRoute) {
        this.typeRoute = typeRoute;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getQualitePorteFenetre() {
        return qualitePorteFenetre;
    }

    public void setQualitePorteFenetre(String qualitePorteFenetre) {
        this.qualitePorteFenetre = qualitePorteFenetre;
    }

    public String getTypeCarrelage() {
        return typeCarrelage;
    }

    public void setTypeCarrelage(String typeCarrelage) {
        this.typeCarrelage = typeCarrelage;
    }

    public String getMenuiserie() {
        return menuiserie;
    }

    public void setMenuiserie(String menuiserie) {
        this.menuiserie = menuiserie;
    }

    public String getConceptionPieces() {
        return conceptionPieces;
    }

    public void setConceptionPieces(String conceptionPieces) {
        this.conceptionPieces = conceptionPieces;
    }

    public String getAppareilsSanitaires() {
        return appareilsSanitaires;
    }

    public void setAppareilsSanitaires(String appareilsSanitaires) {
        this.appareilsSanitaires = appareilsSanitaires;
    }

    public String getParkingInterieur() {
        return parkingInterieur;
    }

    public void setParkingInterieur(String parkingInterieur) {
        this.parkingInterieur = parkingInterieur;
    }

    public Integer getNbAscenseurs() {
        return nbAscenseurs;
    }

    public void setNbAscenseurs(Integer nbAscenseurs) {
        this.nbAscenseurs = nbAscenseurs;
    }

    public Integer getNbSalleBain() {
        return nbSalleBain;
    }

    public void setNbSalleBain(Integer nbSalleBain) {
        this.nbSalleBain = nbSalleBain;
    }

    public Integer getNbSalleEau() {
        return nbSalleEau;
    }

    public void setNbSalleEau(Integer nbSalleEau) {
        this.nbSalleEau = nbSalleEau;
    }

    public Integer getNbPieceReception() {
        return nbPieceReception;
    }

    public void setNbPieceReception(Integer nbPieceReception) {
        this.nbPieceReception = nbPieceReception;
    }
    public Integer getNbTotalPiece() {
        return nbTotalPiece;
    }

    public void setNbTotalPiece(Integer nbTotalPiece) {
        this.nbTotalPiece = nbTotalPiece;
    }

    public Integer getNbEtage() {
        return nbEtage;
    }

    public void setNbEtage(Integer nbEtage) {
        this.nbEtage = nbEtage;
    }

    public String getConfort() {
        return confort;
    }

    public void setConfort(String confort) {
        this.confort = confort;
    }

    public Double getValeurLocativeMensuelle() {
        return valeurLocativeMensuelle;
    }

    public void setValeurLocativeMensuelle(Double valeurLocativeMensuelle) {
        this.valeurLocativeMensuelle = valeurLocativeMensuelle;
    }
    public Double getValeurLocativeMensuelleSaisie() {
        return valeurLocativeMensuelleSaisie;
    }

    public void setValeurLocativeMensuelleSaisie(Double valeurLocativeMensuelleSaisie) {
        this.valeurLocativeMensuelleSaisie = valeurLocativeMensuelleSaisie;
    }
    public String getEscalier() {
        return escalier;
    }

    public void setEscalier(String escalier) {
        this.escalier = escalier;
    }

    public String getVideOrdure() {
        return videOrdure;
    }

    public void setVideOrdure(String videOrdure) {
        this.videOrdure = videOrdure;
    }

    public String getMonteCharge() {
        return monteCharge;
    }

    public void setMonteCharge(String monteCharge) {
        this.monteCharge = monteCharge;
    }

    public String getGroupeElectrogene() {
        return groupeElectrogene;
    }

    public void setGroupeElectrogene(String groupeElectrogene) {
        this.groupeElectrogene = groupeElectrogene;
    }

    public String getDependanceIsolee() {
        return dependanceIsolee;
    }

    public void setDependanceIsolee(String dependanceIsolee) {
        this.dependanceIsolee = dependanceIsolee;
    }

    public String getGarageSouterrain() {
        return garageSouterrain;
    }

    public void setGarageSouterrain(String garageSouterrain) {
        this.garageSouterrain = garageSouterrain;
    }

    public String getSystemeClimatisation() {
        return systemeClimatisation;
    }

    public void setSystemeClimatisation(String systemeClimatisation) {
        this.systemeClimatisation = systemeClimatisation;
    }

    public String getSystemeDomotique() {
        return systemeDomotique;
    }

    public void setSystemeDomotique(String systemeDomotique) {
        this.systemeDomotique = systemeDomotique;
    }

    public String getBalcon() {
        return balcon;
    }

    public void setBalcon(String balcon) {
        this.balcon = balcon;
    }

    public String getTerrasse() {
        return terrasse;
    }

    public void setTerrasse(String terrasse) {
        this.terrasse = terrasse;
    }

    public String getSystemeSurveillance() {
        return systemeSurveillance;
    }

    public void setSystemeSurveillance(String systemeSurveillance) {
        this.systemeSurveillance = systemeSurveillance;
    }

    public String getAmenagementPaysager() {
        return amenagementPaysager;
    }

    public void setAmenagementPaysager(String amenagementPaysager) {
        this.amenagementPaysager = amenagementPaysager;
    }

    public String getJardin() {
        return jardin;
    }

    public void setJardin(String jardin) {
        this.jardin = jardin;
    }

    public String getPiscine() {
        return piscine;
    }

    public void setPiscine(String piscine) {
        this.piscine = piscine;
    }

    public String getCoursDeTennis() {
        return coursDeTennis;
    }

    public void setCoursDeTennis(String coursDeTennis) {
        this.coursDeTennis = coursDeTennis;
    }

    public String getCoursGazonnee() {
        return coursGazonnee;
    }

    public void setCoursGazonnee(String coursGazonnee) {
        this.coursGazonnee = coursGazonnee;
    }

    public String getTerrainGolf() {
        return terrainGolf;
    }

    public void setTerrainGolf(String terrainGolf) {
        this.terrainGolf = terrainGolf;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }


    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getEclairagePublic() {
        return eclairagePublic;
    }

    public void setEclairagePublic(String eclairagePublic) {
        this.eclairagePublic = eclairagePublic;
    }

    public String getMurEnCiment() {
        return murEnCiment;
    }

    public void setMurEnCiment(String murEnCiment) {
        this.murEnCiment = murEnCiment;
    }

    public String getAttributsArchitecturaux() {
        return attributsArchitecturaux;
    }

    public void setAttributsArchitecturaux(String attributsArchitecturaux) {
        this.attributsArchitecturaux = attributsArchitecturaux;
    }

    public String getTrottoir() {
        return trottoir;
    }

    public void setTrottoir(String trottoir) {
        this.trottoir = trottoir;
    }

    public String getNomVoirie() {
        return nomVoirie;
    }

    public void setNomVoirie(String nomVoirie) {
        this.nomVoirie = nomVoirie;
    }

    public String getTypeVoirie() {
        return typeVoirie;
    }

    public void setTypeVoirie(String typeVoirie) {
        this.typeVoirie = typeVoirie;
    }

    public String getNomAutreVoirie() {
        return nomAutreVoirie;
    }

    public void setNomAutreVoirie(String nomAutreVoirie) {
        this.nomAutreVoirie = nomAutreVoirie;
    }

    public String getTypeParcelle() {
        return typeParcelle;
    }

    public void setTypeParcelle(String typeParcelle) {
        this.typeParcelle = typeParcelle;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(String idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getIdParcelle() {
        return idParcelle;
    }

    public void setIdParcelle(String idParcelle) {
        this.idParcelle = idParcelle;
    }


}
