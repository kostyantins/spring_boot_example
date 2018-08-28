package com.example.spring_boot_example.repository;


import com.example.spring_boot_example.model.Clusters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClusterRepository extends JpaRepository<Clusters, Integer> {
}
