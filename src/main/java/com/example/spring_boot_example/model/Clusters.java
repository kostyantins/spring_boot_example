package com.example.spring_boot_example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Clusters")
public class Clusters {

    public Clusters(Integer clusterID, String clusterName, String clusterShortName, Double experimentalAreaPercentage, Integer isDeleted, String lastChangedOn) {
        this.clusterID = clusterID;
        this.clusterName = clusterName;
        this.clusterShortName = clusterShortName;
        this.experimentalAreaPercentage = experimentalAreaPercentage;
        this.isDeleted = isDeleted;
        this.lastChangedOn = lastChangedOn;
    }

    public Clusters() {
    }

    @Id
    @Column(name = "clusterid")
    private Integer clusterID;

    @Column(name = "clustername")
    private String clusterName;

    @Column(name = "clustershortname")
    private String clusterShortName;

    @Column(name = "experimentalareapercentage")
    private Double experimentalAreaPercentage;

    @Column(name = "isdeleted")
    private Integer isDeleted;

    @Column(name = "lastchangedon")
    private String lastChangedOn;
}
