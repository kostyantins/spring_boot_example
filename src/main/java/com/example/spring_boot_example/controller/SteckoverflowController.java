package com.example.spring_boot_example.controller;

import com.example.spring_boot_example.model.SteckoverflowWebcite;
import com.example.spring_boot_example.services.StackExchangeClient;
import com.example.spring_boot_example.services.StackoverflowService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/steckoverflow")
public class SteckoverflowController {

    @Autowired
    private StackoverflowService stackoverflowService;

    @Autowired
    private StackExchangeClient stackExchangeClient;

    @RequestMapping
    public List<SteckoverflowWebcite> getListOfProviders(){
        return stackoverflowService.findAll();
    }

    public Response getListOfProviders_(){
        return stackExchangeClient.getSites_WithRestAssured();
    }
}
