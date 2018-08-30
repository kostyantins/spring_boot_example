package com.example.spring_boot_example;

import com.example.spring_boot_example.controller.SomeController;
import com.example.spring_boot_example.model.Clusters;
import com.example.spring_boot_example.util.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClusterTests extends ApiTestRunner {

    @Autowired
    private SomeController someController;

    @Test
    public void create() {
        Clusters clusters = someController.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));
    }

    @Test
    public void delete() {
        Clusters clusters = someController.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));
        someController.clusterRepository.delete(clusters);
    }

    @Test
    public void update() {
        Clusters clusters = someController.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));
        Clusters clusters_ = someController.clusterRepository.save(new Clusters(125, "Полтава", "KK", 15.00, 0, ""));
    }

    @Test
    public void get() {
        Clusters clusters = someController.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));

        List<Clusters> clusters_ = someController.clusterRepository.findAll();
        System.out.println(clusters_.get(0).getClusterName());

        Optional<Clusters> id_ = someController.clusterRepository.findById(125);
        System.out.println(id_.get().getClusterName());

    }
}
