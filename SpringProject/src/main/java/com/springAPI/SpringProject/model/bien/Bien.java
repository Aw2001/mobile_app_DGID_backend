package com.springAPI.SpringProject.model.bien;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springAPI.SpringProject.model.image.Image;
import com.springAPI.SpringProject.model.bienLoue.BienLoue;
import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.model.parcelle.Parcelle;
import com.springAPI.SpringProject.model.proprietaire.Proprietaire;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import java.time.LocalDate;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tousleslocaux")
public class Bien {
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

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Parcelle getParcelle() {
        return parcelle;
    }

    public void setParcelle(Parcelle parcelle) {
        this.parcelle = parcelle;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<BienLoue> getBienLoues() {
        return bienLoues;
    }

    public void setBienLoues(List<BienLoue> bienLoues) {
        this.bienLoues = bienLoues;
    }

    public List<BienRecense> getBienRecenses() {
        return bienRecenses;
    }

    public void setBienRecenses(List<BienRecense> bienRecenses) {
        this.bienRecenses = bienRecenses;
    }

    @Id
    @Column(name = "identifiant", nullable = false, unique = true, length = 50)
    private String identifiant;

    @JsonIgnore
    @Column(name = "superficie")
    private Double superficie;

   @JsonIgnore
    @Column(name = "propriete_en_location", length = 50)
    private String proprieteEnLocation;

   @JsonIgnore
    @Column(name = "adresse")
    private String adresse;

   @JsonIgnore
    @Column(name = "quartier")
    private String quartier;

   @JsonIgnore
    @Column(name = "village")
    private String village;

   @JsonIgnore
    @Column(name = "num_porte_adm", length = 50)
    private String numPorteAdm;

   @JsonIgnore
    @Column(name = "code_de_rue_adm", length = 50)
    private String codeDeRueAdm;

   @JsonIgnore
    @Column(name = "nom_rue")
    private String nomRue;

   @JsonIgnore
    @Column(name = "type_lot", length = 50)
    private String typeLot;

   @JsonIgnore
    @Column(name = "niveau_lot")
    private Integer niveauLot;

   @JsonIgnore
    @Column(name = "localisation_lot", length = 50)
    private String localisationLot;

   @JsonIgnore
    @Column(name = "situation_lot", length = 50)
    private String situationLot;

   @JsonIgnore
    @Column(name = "num_lot", length = 50)
    private String numLot;

   @JsonIgnore
    @Column(name = "valeur_locative_annuelle")
    private Double valeurLocativeAnnuelle;

   @JsonIgnore
    @Column(name = "valeur_locative_annuelle_saisie")
    private Double valeurLocativeAnnuelleSaisie;

   @JsonIgnore
    @Column(name = "num_titre_foncier", length = 50)
    private String numTitreFoncier;

   @JsonIgnore
    @Column(name = "date_acquisition")
    private LocalDate dateAcquisition;

   @JsonIgnore
    @Column(name = "type_occupation", length = 50)
    private String typeOccupation;

   @JsonIgnore
    @Column(name = "autre_type_occupation", length = 50)
    private String autreTypeOccupation;

   @JsonIgnore
    @Column(name = "date_delivrance_type_occupation")
    private LocalDate dateDelivranceTypeOccupation;

   @JsonIgnore
    @Column(name = "usagee", length = 50)
    private String usagee;

   @JsonIgnore
    @Column(name = "num_compteur_sde", length = 50)
    private String numCompteurSde;

   @JsonIgnore
    @Column(name = "num_compteur_senelec", length = 50)
    private String numCompteurSenelec;

   @JsonIgnore
    @Column(name = "type_construction", length = 50)
    private String typeConstruction;

   @JsonIgnore
    @Column(name = "toiture", length = 50)
    private String toiture;

   @JsonIgnore
    @Column(name = "type_cloture", length = 50)
    private String typeCloture;

   @JsonIgnore
    @Column(name = "etat_cloture", length = 50)
    private String etatCloture;

   @JsonIgnore
    @Column(name = "type_revetement", length = 50)
    private String typeRevetement;

   @JsonIgnore
    @Column(name = "etat_revetement", length = 50)
    private String etatRevetement;

   @JsonIgnore
    @Column(name = "situation_route", length = 50)
    private String situationRoute;

   @JsonIgnore
    @Column(name = "type_route", length = 50)
    private String typeRoute;

   @JsonIgnore
    @Column(name = "garage", length = 50)
    private String garage;

   @JsonIgnore
    @Column(name = "qualite_porte_fenetre", length = 50)
    private String qualitePorteFenetre;

   @JsonIgnore
    @Column(name = "type_carrelage", length = 50)
    private String typeCarrelage;

   @JsonIgnore
    @Column(name = "menuiserie", length = 50)
    private String menuiserie;

   @JsonIgnore
    @Column(name = "conception_pieces", length = 50)
    private String conceptionPieces;

   @JsonIgnore
    @Column(name = "appareils_sanitaires", length = 50)
    private String appareilsSanitaires;

   @JsonIgnore
    @Column(name = "parking_interieur", length = 50)
    private String parkingInterieur;

   @JsonIgnore
    @Column(name = "nb_ascenseurs")
    private Integer nbAscenseurs;

   @JsonIgnore
    @Column(name = "nb_salle_bain")
    private Integer nbSalleBain;

   @JsonIgnore
    @Column(name = "nb_salle_eau")
    private Integer nbSalleEau;

   @JsonIgnore
    @Column(name = "nb_piece_reception")
    private Integer nbPieceReception;

   @JsonIgnore
    @Column(name = "nb_total_piece")
    private Integer nbTotalPiece;

   @JsonIgnore
    @Column(name = "nb_etage")
    private Integer nbEtage;

   @JsonIgnore
    @Column(name = "confort", length = 50)
    private String confort;

   @JsonIgnore
    @Column(name = "valeur_locative_mensuelle")
    private Double valeurLocativeMensuelle;

   @JsonIgnore
    @Column(name = "valeur_locative_mensuelle_saisie")
    private Double valeurLocativeMensuelleSaisie;

   @JsonIgnore
    @Column(name = "escalier", length = 10)
    private String escalier;

   @JsonIgnore
    @Column(name = "vide_ordure", length = 10)
    private String videOrdure;

   @JsonIgnore
    @Column(name = "monte_charge", length = 10)
    private String monteCharge;

   @JsonIgnore
    @Column(name = "groupe_electrogene", length = 10)
    private String groupeElectrogene;

   @JsonIgnore
    @Column(name = "dependance_isolee", length = 10)
    private String dependanceIsolee;

   @JsonIgnore
    @Column(name = "garage_souterrain", length = 10)
    private String garageSouterrain;

   @JsonIgnore
    @Column(name = "systeme_climatisation", length = 10)
    private String systemeClimatisation;

   @JsonIgnore
    @Column(name = "systeme_domotique", length = 10)
    private String systemeDomotique;

   @JsonIgnore
    @Column(name = "balcon", length = 10)
    private String balcon;

   @JsonIgnore
    @Column(name = "terrasse", length = 10)
    private String terrasse;

   @JsonIgnore
    @Column(name = "systeme_surveillance", length = 10)
    private String systemeSurveillance;

   @JsonIgnore
    @Column(name = "amenagement_paysager", length = 10)
    private String amenagementPaysager;

   @JsonIgnore
    @Column(name = "jardin", length = 10)
    private String jardin;

   @JsonIgnore
    @Column(name = "piscine", length = 10)
    private String piscine;

   @JsonIgnore
    @Column(name = "cours_de_tennis", length = 10)
    private String coursDeTennis;

   @JsonIgnore
    @Column(name = "cours_gazonnee", length = 10)
    private String coursGazonnee;

   @JsonIgnore
    @Column(name = "terrain_golf", length = 10)
    private String terrainGolf;

   @JsonIgnore
    @Column(name = "autre", length = 10)
    private String autre;

   @JsonIgnore
    @Column(name = "angle", length = 10)
    private String angle;

   @JsonIgnore
    @Column(name = "eclairage_public", length = 10)
    private String eclairagePublic;

   @JsonIgnore
    @Column(name = "mur_en_ciment", length = 10)
    private String murEnCiment;

   @JsonIgnore
    @Column(name = "attributs_architecturaux", length = 10)
    private String attributsArchitecturaux;

   @JsonIgnore
    @Column(name = "trottoir", length = 10)
    private String trottoir;

   @JsonIgnore
    @Column(name = "nom_voirie", length = 50)
    private String nomVoirie;

   @JsonIgnore
    @Column(name = "type_voirie", length = 50)
    private String typeVoirie;

   @JsonIgnore
    @Column(name = "nom_autre_voirie", length = 50)
    private String nomAutreVoirie;

   @JsonIgnore
    @Column(name = "type_parcelle", length = 100)
    private String typeParcelle;

   @JsonIgnore
    @Column(name = "commentaire", length = Integer.MAX_VALUE)
    private String commentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prop_id")
    private Proprietaire proprietaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nicad_parcelle")
    private Parcelle parcelle;


    @OneToMany(mappedBy = "bien", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Image> images;


    @OneToMany(mappedBy = "bienLoue", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BienLoue> bienLoues;


    @OneToMany(mappedBy = "bienRecense", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BienRecense> bienRecenses;



}