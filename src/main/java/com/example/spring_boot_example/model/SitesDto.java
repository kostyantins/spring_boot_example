package com.example.spring_boot_example.model;

import lombok.Data;

import java.util.List;

@Data
public class SitesDto {
    private List<SiteDto> items;
}
