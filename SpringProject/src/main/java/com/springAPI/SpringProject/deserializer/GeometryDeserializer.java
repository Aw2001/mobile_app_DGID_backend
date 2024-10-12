package com.springAPI.SpringProject.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.geojson.GeoJsonReader;

import java.io.IOException;

public class GeometryDeserializer extends JsonDeserializer<Geometry> {

    @Override
    public Geometry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            // Lecture de la géométrie à partir de GeoJSON
            String geoJson = p.getText();
            GeoJsonReader reader = new GeoJsonReader();
            return reader.read(geoJson);
        } catch (Exception e) {
            throw new IOException("Impossible de désérialiser la géométrie à partir de GeoJSON", e);
        }
    }
}
