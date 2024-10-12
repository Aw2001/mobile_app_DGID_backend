package com.springAPI.SpringProject.service;

import com.springAPI.SpringProject.model.region.Region;
import com.springAPI.SpringProject.repository.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    // Récupérer toutes les régions
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    // Récupérer les informations spécifiques (geom, shape_leng, shape_area) d'une région par son ID
    public Map<String, Object> getRegionDetailsById(int id) {
        Optional<Region> region = regionRepository.findById(id);

        if (region.isPresent()) {
            Region reg = region.get();
            Map<String, Object> regionDetails = new HashMap<>();

            // Ajouter un test de la sérialisation manuelle du champ geom
            Geometry geom = reg.getGeom();
            System.out.println("Vérification de la géométrie : " + geom.toString());

            // Test : Sérialisation manuelle du champ geom
            try {
                GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
                String geoJson = geoJsonWriter.write(geom);
                regionDetails.put("geom", geoJson);  // Utiliser la conversion GeoJSON manuelle
            } catch (Exception e) {
                System.err.println("Erreur lors de la sérialisation du champ geom : " + e.getMessage());
                regionDetails.put("geom", "Erreur lors de la sérialisation");
            }


            regionDetails.put("nom_region", reg.getReg());
            regionDetails.put("objectid", reg.getObjectid());
            regionDetails.put("shape_length", reg.getShapeLeng());
            regionDetails.put("shape_area", reg.getShapeArea());
            return regionDetails;
        } else {
            throw new EntityNotFoundException("Région avec ID " + id + " non trouvée");
        }
    }
}
