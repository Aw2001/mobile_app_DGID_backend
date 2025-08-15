package com.springAPI.SpringProject.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.geojson.GeoJsonWriter;

import java.io.IOException;

@JsonSerialize(using = GeometrySerializer.class)
public class GeometrySerializer extends JsonSerializer<Geometry> {

    @Override
    public void serialize(Geometry value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            // Utilisation de GeoJsonWriter pour convertir la géométrie en GeoJSON
            GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
            String geoJson = geoJsonWriter.write(value);
            gen.writeString(geoJson);
        } else {
            gen.writeNull();
        }
    }
}