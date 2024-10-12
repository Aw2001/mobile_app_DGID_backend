package com.springAPI.SpringProject.model.region;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.springAPI.SpringProject.deserializer.GeometryDeserializer;
import com.springAPI.SpringProject.serializer.GeometrySerializer;
import jakarta.persistence.*;

import java.math.BigDecimal;

import org.locationtech.jts.geom.Geometry;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_id_gen")
    @SequenceGenerator(name = "region_id_gen", sequenceName = "region_fatick_gid_seq", allocationSize = 1)
    @Column(name = "gid", nullable = false)
    private Integer id;

    @Column(name = "objectid")
    private Double objectid;

    @Column(name = "reg", length = 11)
    private String reg;

    @Column(name = "shape_leng")
    private BigDecimal shapeLeng;

    @Column(name = "shape_area")
    private BigDecimal shapeArea;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "geom", columnDefinition = "geometry")
    private Geometry geom;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getObjectid() {
        return objectid;
    }

    public void setObjectid(Double objectid) {
        this.objectid = objectid;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public BigDecimal getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(BigDecimal shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public BigDecimal getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(BigDecimal shapeArea) {
        this.shapeArea = shapeArea;
    }

    public Geometry getGeom() { return geom; }

    public void setGeom(Geometry geom) { this.geom = geom; }

}