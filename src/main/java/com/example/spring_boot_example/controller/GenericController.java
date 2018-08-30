package com.example.spring_boot_example.controller;

import com.example.spring_boot_example.dao.GenericDao;
import com.example.spring_boot_example.model.Clusters;
import com.example.spring_boot_example.repository.ClusterRepository;
import com.example.spring_boot_example.repository.GeoZoneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@Component
//@Scope(value = "prototype") //for creating multiply objects cos spring using singleton by default
public class GenericController {

    @Autowired
    private GenericDao<Clusters> clustersGenericDao;

    public void createEntity() {
        clustersGenericDao.create(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));
    }
}
