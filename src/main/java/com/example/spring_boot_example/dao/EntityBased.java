package com.example.spring_boot_example.dao;

import com.example.spring_boot_example.repository.ClusterRepository;
import com.example.spring_boot_example.repository.GeoZoneRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class EntityBased {

    @Autowired
    public ClusterRepository clusterRepository;
    @Autowired
    public GeoZoneRepository geoZoneRepository;
}
