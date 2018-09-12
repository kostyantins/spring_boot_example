package com.example.spring_boot_example.repository;

import com.example.spring_boot_example.entity.GeoZones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GeoZoneRepository extends JpaRepository<GeoZones, Integer> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * " +
            "       FROM GeoZones" +
            "       WHERE GeoZoneName = :name" ,nativeQuery = true)
        List<GeoZones> findAllByName(String name);
}
