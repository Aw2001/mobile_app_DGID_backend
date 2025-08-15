package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.dto.BienDto;
import com.springAPI.SpringProject.model.bien.Bien;
import com.springAPI.SpringProject.model.bienRecense.BienRecense;
import com.springAPI.SpringProject.model.bienRecense.BienRecenseId;
import com.springAPI.SpringProject.model.parcelle.Parcelle;
import com.springAPI.SpringProject.model.proprietaire.Proprietaire;
import com.springAPI.SpringProject.model.recensement.Recensement;
import com.springAPI.SpringProject.model.recensementUtilisateur.RecensementUtilisateur;
import com.springAPI.SpringProject.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BienService {
    @Autowired
    private BienRepository bienRepository;

    @Autowired
    private RecensementUtilisateurRepository recensementUtilisateurRepository;
    @Autowired
    private RecensementRepository recensementRepository;

    @Autowired
    private BienRecenseRepository bienRecenseRepository;

    @Autowired
    private ParcelleRepository parcelleRepository;

    @Autowired
    private ProprietaireRepository proprietaireRepository;

    public Bien enregistrerBien(String recensementId, BienDto dto) {
        Bien bien = new Bien();
        Bien bienSauvegarde = new Bien();
        Parcelle parcelle = new Parcelle();
        Proprietaire proprietaire = new Proprietaire();

        // Valider l'ID fourni
        if (dto.getIdentifiant() == null || dto.getIdentifiant().isEmpty()) {

            throw new IllegalArgumentException("L'identifiant du bien est obligatoire");

        } else if (bienRepository.findByIdentifiant(dto.getIdentifiant()) == null) {
            Recensement recensement = recensementRepository.findByNumRecensement(recensementId);

            // Récupérer la parcelle existante
            if( (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) || (dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty()) ){

                if ((dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) && (dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty())) {
                    parcelle = parcelleRepository.findById(dto.getIdParcelle())
                            .orElseThrow(() -> new RuntimeException("Parcelle non trouvé"));
                    proprietaire = proprietaireRepository.findById(dto.getIdProprietaire())
                            .orElseThrow(() -> new RuntimeException("Proprietaire non trouvé"));
                    setBien(bien,dto);
                    bien.setParcelle(parcelle);
                    bien.setProprietaire(proprietaire);
                }
                else if (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) {
                    parcelle = parcelleRepository.findById(dto.getIdParcelle())
                            .orElseThrow(() -> new RuntimeException("Parcelle non trouvé"));
                    setBien(bien,dto);
                    bien.setParcelle(parcelle);
                } else {
                    proprietaire = proprietaireRepository.findById(dto.getIdProprietaire())
                            .orElseThrow(() -> new RuntimeException("Proprietaire non trouvé"));
                    setBien(bien,dto);
                    bien.setProprietaire(proprietaire);
                }


            } else  {
                setBien(bien,dto);
            }

            bienSauvegarde = bienRepository.save(bien);
            // Création de l'association
            BienRecenseId id = new BienRecenseId();
            id.setIdentifiantLocal(dto.getIdentifiant());
            id.setIdentifiantRecensement(recensementId);

            //Créer une entrée dans BienRecense
            BienRecense bienRecense = new BienRecense();
            bienRecense.setId(id);
            bienRecense.setBien(bienSauvegarde);
            bienRecense.setRecensement(recensement);
            bienRecenseRepository.save(bienRecense);
            return bienSauvegarde;

        } else {
            System.out.println("Ce bien existe déjà");
            return null;
        }

    }

    public Bien saveBien(BienDto dto) {
        Bien bien = new Bien();
        Bien bienSauvegarde = new Bien();
        Parcelle parcelle = new Parcelle();
        Proprietaire proprietaire = new Proprietaire();

        // Valider l'ID fourni
        if (dto.getIdentifiant() == null || dto.getIdentifiant().isEmpty()) {

            throw new IllegalArgumentException("L'identifiant du bien est obligatoire");

        } else if (bienRepository.findByIdentifiant(dto.getIdentifiant()) == null) {


            // Récupérer la parcelle existante
            if( (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) || (dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty()) ){

                if ((dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) && (dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty())) {
                    parcelle = parcelleRepository.findById(dto.getIdParcelle())
                            .orElseThrow(() -> new RuntimeException("Parcelle non trouvé"));
                    proprietaire = proprietaireRepository.findById(dto.getIdProprietaire())
                            .orElseThrow(() -> new RuntimeException("Proprietaire non trouvé"));
                    setBien(bien,dto);
                    bien.setParcelle(parcelle);
                    bien.setProprietaire(proprietaire);
                }
                else if (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) {
                    parcelle = parcelleRepository.findById(dto.getIdParcelle())
                            .orElseThrow(() -> new RuntimeException("Parcelle non trouvé"));
                    setBien(bien,dto);
                    bien.setParcelle(parcelle);
                } else {
                    proprietaire = proprietaireRepository.findById(dto.getIdProprietaire())
                            .orElseThrow(() -> new RuntimeException("Proprietaire non trouvé"));
                    setBien(bien,dto);
                    bien.setProprietaire(proprietaire);
                }


            } else  {
                setBien(bien,dto);
            }

            bienSauvegarde = bienRepository.save(bien);
            return bienSauvegarde;

        } else {
            System.out.println("Ce bien existe déjà");
            return null;
        }

    }

    public Bien modifierBien(String recensementId, BienDto dto) {

        if (dto.getIdentifiant() == null || dto.getIdentifiant().isEmpty()) {
            throw new IllegalArgumentException("L'identifiant du bien est obligatoire");
        } else {

            Bien bienExistant = bienRepository.findByIdentifiant(dto.getIdentifiant());
            if(bienExistant == null) {
                System.out.println("Le bien n'existe pas");
                return null;
            } else {
                // Trouver le recensement actif
                RecensementUtilisateur recensementUtilisateur = recensementUtilisateurRepository
                        .findByRecensementId(recensementId)
                        .orElseThrow(() -> new RuntimeException("Aucun recensement actif trouvé pour l'utilisateur avec ID : " + recensementId));
                Recensement recensement = recensementUtilisateur.getRecensement();


                // Mise à jour des champs non nuls depuis le DTO
                BeanUtils.copyProperties(dto, bienExistant, getNullOrEmptyPropertyNames(dto));
                if ( (dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty()) ||  (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) ) {
                    if ((dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty()) && (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty())) {
                        // Récupérer le propriétaire
                        Proprietaire proprietaire = proprietaireRepository.findByNumIdentifiant(dto.getIdProprietaire());
                        Parcelle parcelle = parcelleRepository.findByNicad(dto.getIdParcelle());
                        bienExistant.setParcelle(parcelle);
                        bienExistant.setProprietaire(proprietaire);


                    } else if (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) {
                        Parcelle parcelle = parcelleRepository.findByNicad(dto.getIdParcelle());
                        bienExistant.setParcelle(parcelle);
                    } else {
                        Proprietaire proprietaire = proprietaireRepository.findByNumIdentifiant(dto.getIdProprietaire());
                        bienExistant.setProprietaire(proprietaire);
                    }
                }


                // Sauvegarder le bien
                Bien bienSauvegarde = bienRepository.save(bienExistant);

                // Création de l'association
                BienRecenseId id = new BienRecenseId();
                System.out.println(dto.getIdentifiant());
                System.out.println(recensementId);
                System.out.println(bienSauvegarde.getToiture());
                id.setIdentifiantLocal(dto.getIdentifiant());
                id.setIdentifiantRecensement(recensementId);
                // Enregistrer une entrée dans BienRecense
                BienRecense bienRecense = new BienRecense();

                bienRecense.setId(id);
                bienRecense.setBien(bienSauvegarde);
                bienRecense.setRecensement(recensement);
                bienRecenseRepository.save(bienRecense);
                return bienSauvegarde;
            }
        }
        // Récupérer le bien existant

    }

    public Bien updateBien(BienDto dto) {

        if (dto.getIdentifiant() == null || dto.getIdentifiant().isEmpty()) {
            throw new IllegalArgumentException("L'identifiant du bien est obligatoire");
        } else {

            Bien bienExistant = bienRepository.findByIdentifiant(dto.getIdentifiant());
            if(bienExistant == null) {
                System.out.println("Le bien n'existe pas");
                return null;
            } else {

                // Mise à jour des champs non nuls depuis le DTO
                BeanUtils.copyProperties(dto, bienExistant, getNullOrEmptyPropertyNames(dto));
                if ( (dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty()) ||  (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) ) {
                    if ((dto.getIdProprietaire() != null && !dto.getIdProprietaire().isEmpty()) && (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty())) {
                        // Récupérer le propriétaire
                        Proprietaire proprietaire = proprietaireRepository.findByNumIdentifiant(dto.getIdProprietaire());
                        Parcelle parcelle = parcelleRepository.findByNicad(dto.getIdParcelle());
                        bienExistant.setParcelle(parcelle);
                        bienExistant.setProprietaire(proprietaire);


                    } else if (dto.getIdParcelle() != null && !dto.getIdParcelle().isEmpty()) {
                        Parcelle parcelle = parcelleRepository.findByNicad(dto.getIdParcelle());
                        bienExistant.setParcelle(parcelle);
                    } else {
                        Proprietaire proprietaire = proprietaireRepository.findByNumIdentifiant(dto.getIdProprietaire());
                        bienExistant.setProprietaire(proprietaire);
                    }
                }


                // Sauvegarder le bien
                Bien bienSauvegarde = bienRepository.save(bienExistant);

                return bienSauvegarde;
            }
        }
        // Récupérer le bien existant

    }

    public String[] getNullOrEmptyPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);

        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(java.beans.PropertyDescriptor::getName)
                .filter(propertyName -> {

                    Object propertyValue = wrappedSource.getPropertyValue(propertyName);
                    return propertyValue == null ||
                            (propertyValue instanceof String && ((String) propertyValue).isEmpty()) ||
                            propertyName.equals("idParcelle");
                })
                .toArray(String[]::new);
    }


    public Optional<Bien> rechercherBien (String identifiant) {
        Optional<Bien> bienTrouve = bienRepository
                .findById(identifiant);
        return bienTrouve;
    }

    private void setBien(Bien bien, BienDto dto) {
        bien.setIdentifiant(dto.getIdentifiant());
        bien.setSuperficie(dto.getSuperficie());
        bien.setProprieteEnLocation(dto.getProprieteEnLocation());
        bien.setAdresse(dto.getAdresse());
        bien.setQuartier(dto.getQuartier());
        bien.setVillage(dto.getVillage());
        bien.setNumPorteAdm(dto.getNumPorteAdm());
        bien.setCodeDeRueAdm(dto.getCodeDeRueAdm());
        bien.setNomRue(dto.getNomRue());
        bien.setTypeLot(dto.getTypeLot());
        bien.setNiveauLot(dto.getNiveauLot());
        bien.setLocalisationLot(dto.getLocalisationLot());
        bien.setSituationLot(dto.getSituationLot());
        bien.setNumLot(dto.getNumLot());
        bien.setValeurLocativeAnnuelle(dto.getValeurLocativeAnnuelle());
        bien.setValeurLocativeAnnuelleSaisie(dto.getValeurLocativeAnnuelleSaisie());
        bien.setNumTitreFoncier(dto.getNumTitreFoncier());
        bien.setDateAcquisition(dto.getDateAcquisition());
        bien.setTypeOccupation(dto.getTypeOccupation());
        bien.setAutreTypeOccupation(dto.getAutreTypeOccupation());
        bien.setDateDelivranceTypeOccupation(dto.getDateDelivranceTypeOccupation());
        bien.setUsagee(dto.getUsagee());
        bien.setNumCompteurSde(dto.getNumCompteurSde());
        bien.setNumCompteurSenelec(dto.getNumCompteurSenelec());
        bien.setTypeConstruction(dto.getTypeConstruction());
        bien.setToiture(dto.getToiture());
        bien.setTypeCloture(dto.getTypeCloture());
        bien.setEtatCloture(dto.getEtatCloture());
        bien.setTypeRevetement(dto.getTypeRevetement());
        bien.setEtatRevetement(dto.getEtatRevetement());
        bien.setSituationRoute(dto.getSituationRoute());
        bien.setTypeRoute(dto.getTypeRoute());
        bien.setGarage(dto.getGarage());
        bien.setQualitePorteFenetre(dto.getQualitePorteFenetre());
        bien.setTypeCarrelage(dto.getTypeCarrelage());
        bien.setMenuiserie(dto.getMenuiserie());
        bien.setConceptionPieces(dto.getConceptionPieces());
        bien.setAppareilsSanitaires(dto.getAppareilsSanitaires());
        bien.setParkingInterieur(dto.getParkingInterieur());
        bien.setNbAscenseurs(dto.getNbAscenseurs());
        bien.setNbSalleBain(dto.getNbSalleBain());
        bien.setNbSalleEau(dto.getNbSalleEau());
        bien.setNbPieceReception(dto.getNbPieceReception());
        bien.setNbTotalPiece(dto.getNbTotalPiece());
        bien.setNbEtage(dto.getNbEtage());
        bien.setConfort(dto.getConfort());
        bien.setValeurLocativeMensuelle(dto.getValeurLocativeMensuelle());
        bien.setValeurLocativeMensuelleSaisie(dto.getValeurLocativeMensuelleSaisie());
        bien.setEscalier(dto.getEscalier());
        bien.setVideOrdure(dto.getVideOrdure());
        bien.setMonteCharge(dto.getMonteCharge());
        bien.setGroupeElectrogene(dto.getGroupeElectrogene());
        bien.setDependanceIsolee(dto.getDependanceIsolee());
        bien.setGarageSouterrain(dto.getGarageSouterrain());
        bien.setSystemeClimatisation(dto.getSystemeClimatisation());
        bien.setSystemeDomotique(dto.getSystemeDomotique());
        bien.setBalcon(dto.getBalcon());
        bien.setTerrasse(dto.getTerrasse());
        bien.setSystemeSurveillance(dto.getSystemeSurveillance());
        bien.setAmenagementPaysager(dto.getAmenagementPaysager());
        bien.setJardin(dto.getJardin());
        bien.setPiscine(dto.getPiscine());
        bien.setCoursDeTennis(dto.getCoursDeTennis());
        bien.setCoursGazonnee(dto.getCoursGazonnee());
        bien.setTerrainGolf(dto.getTerrainGolf());
        bien.setAutre(dto.getAutre());
        bien.setAngle(dto.getAngle());
        bien.setEclairagePublic(dto.getEclairagePublic());
        bien.setMurEnCiment(dto.getMurEnCiment());
        bien.setAttributsArchitecturaux(dto.getAttributsArchitecturaux());
        bien.setTrottoir(dto.getTrottoir());
        bien.setNomVoirie(dto.getNomVoirie());
        bien.setTypeVoirie(dto.getTypeVoirie());
        bien.setNomAutreVoirie(dto.getNomAutreVoirie());
        bien.setTypeParcelle(dto.getTypeParcelle());
        bien.setCommentaire(dto.getCommentaire());
    }

    public List<Bien> getAllBiens() {
        return bienRepository.findBiens();
    }

    public Long getNumberOfBien() {
        return bienRepository.countBiens();
    }

    public List<Bien> getAllBienByNicad(String nicad) {
        return bienRepository.findBienByNicad(nicad);
    }
}
