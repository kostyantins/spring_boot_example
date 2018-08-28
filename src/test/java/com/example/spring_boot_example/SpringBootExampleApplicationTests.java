package com.example.spring_boot_example;

import com.example.spring_boot_example.model.Clusters;
import com.example.spring_boot_example.repository.ClusterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExampleApplicationTests {

    @Autowired
    private ClusterRepository clusterRepository;

    @Test
    public void create() {
        Clusters clusters = this.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));
    }

    @Test
    public void delete() {
        Clusters clusters = this.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));
        this.clusterRepository.delete(clusters);
    }

    @Test
    public void update() {
        Clusters clusters = this.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));
        Clusters clusters_ = this.clusterRepository.save(new Clusters(125, "Полтава", "KK", 15.00, 0, ""));
    }

    @Test
    public void get() {
        Clusters clusters = this.clusterRepository.save(new Clusters(125, "Полтава-Південь", "ПП", 10.00, 0, ""));

        List<Clusters> clusters_ = this.clusterRepository.findAll();
        System.out.println(clusters_.get(0).getClusterName());

        Optional<Clusters> id_ = this.clusterRepository.findById(125);
        System.out.println(id_.get().getClusterName());

    }
}
