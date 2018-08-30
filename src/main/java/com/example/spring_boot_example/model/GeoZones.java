package com.example.spring_boot_example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Geozones")
public class GeoZones {

    public GeoZones(Integer geoZoneID, String geoZoneName, Integer regionalDirectionID, Integer clusterID, Integer massiveFormationTypeID, Integer isDeleted, String lastChangedOn) {
        this.geoZoneID = geoZoneID;
        this.geoZoneName = geoZoneName;
        this.regionalDirectionID = regionalDirectionID;
        this.clusterID = clusterID;
        this.massiveFormationTypeID = massiveFormationTypeID;
        this.isDeleted = isDeleted;
        this.lastChangedOn = lastChangedOn;
    }

    public GeoZones() {
    }

    @Id
    @Column(name = "geozoneid")
    private Integer geoZoneID;

    @Column(name = "geozonename")
    private String geoZoneName;

    @Column(name = "regionaldirectionid")
    private Integer regionalDirectionID;

    @Column(name = "clusterid")
    private Integer clusterID;

    @Column(name = "massiveformationtypeid")
    private Integer massiveFormationTypeID;

    @Column(name = "isdeleted")
    private Integer isDeleted;

    @Column(name = "lastchangedon")
    private String lastChangedOn;
}
