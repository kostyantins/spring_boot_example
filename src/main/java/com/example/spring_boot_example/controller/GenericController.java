package com.example.spring_boot_example.controller;

import com.example.spring_boot_example.dao.GenericDao;
import com.example.spring_boot_example.entity.Clusters;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
