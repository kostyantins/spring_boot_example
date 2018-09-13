package com.example.spring_boot_example.services;


import com.example.spring_boot_example.model.SiteDto;
import com.example.spring_boot_example.model.SteckoverflowWebcite;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class StackoverflowService {

    @Autowired
    private StackExchangeClient stackExchangeClient;

    public List<SteckoverflowWebcite> findAll() {
        return stackExchangeClient
                .getSites()
                .stream()
                .map(this::toSitesDto)
                .collect(toList());
    }

    private SteckoverflowWebcite toSitesDto(@NonNull SiteDto input) {
        return new SteckoverflowWebcite(1, input.getFaviconUrl(), input.getSiteUrl(), input.getName());
    }
}
