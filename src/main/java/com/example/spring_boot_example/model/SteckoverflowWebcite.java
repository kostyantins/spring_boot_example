package com.example.spring_boot_example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Data
public class SteckoverflowWebcite {

    private int id;
    private String faviconUrl;
    private String siteUrl;
    private String name;

    public SteckoverflowWebcite(int id, String faviconUrl, String siteUrl, String name) {
        this.id = id;
        this.faviconUrl = faviconUrl;
        this.siteUrl = siteUrl;
        this.name = name;
    }
}
