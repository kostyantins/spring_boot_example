package com.example.spring_boot_example.controller;

import com.example.spring_boot_example.entity.Clusters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClusterController {

    @GetMapping ("/clusters/{name}")
    private Clusters getClusters (@PathVariable String name){
        return null;
    }
}
