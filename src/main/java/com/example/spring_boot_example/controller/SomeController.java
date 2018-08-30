package com.example.spring_boot_example.controller;

import com.example.spring_boot_example.dao.GenericDao;
import com.example.spring_boot_example.model.Clusters;
import com.example.spring_boot_example.model.GeoZones;
import com.example.spring_boot_example.repository.ClusterRepository;
import com.example.spring_boot_example.repository.GeoZoneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Getter
@Setter
@Component //important to have such annotation
public class SomeController {

    @Autowired
    public ClusterRepository clusterRepository;
    @Autowired
    public GeoZoneRepository geoZoneRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public static GeoZones geoZones;
    public static Clusters clusters;

    public SomeController createData() {
        clusters = clusterRepository.save(new Clusters(7, "Test", "G", 10.00, 0, ""));
        geoZones = geoZoneRepository.save(new GeoZones(125, "Test", 11, 7, 2, 0, ""));
        return this;
    }

    public SomeController deleteData() {
        geoZoneRepository.delete(geoZones);
        clusterRepository.delete(clusters);
        return this;
    }

    public List<Clusters> getAll() {
        return clusterRepository.findAllByName("Західний");
    }

    //execute native quarry #1
    public SomeController restoreDB() {
        EntityManager session = entityManagerFactory.createEntityManager();
        try {
            session
                    .createNativeQuery("USE master\n" +
                            "ALTER DATABASE EnterpriseDB\n" +
                            "SET SINGLE_USER\n" +
                            "WITH ROLLBACK IMMEDIATE\n" +
                            "RESTORE DATABASE EnterpriseDB\n" +
                            "FROM  DISK = N'd:\\GIT\\kernel\\automation_test_framework\\test\\automation_test_framework\\src\\main\\resources\\db_beckups\\EnterpriseDB_2018-08-29_clean.bak'\n" +
                            "WITH  FILE = 1\n" +
                            ",  NOUNLOAD\n" +
                            ",  REPLACE\n" +
                            ",  STATS = 5\n" +
                            "ALTER DATABASE EnterpriseDB \n" +
                            "SET MULTI_USER\n")
                    //TODO find the reason why executeUpdate() method doesn't work
                    .getSingleResult();

            return this;
        } catch (Exception e) {
            //here should be some logger
            System.out.println("Some problem with restore DB");
            return null;
        } finally {
            if (session.isOpen()) session.close();
        }
    }

    //execute native quarry #2 (the realization in the ClusterRepository, also better one)
    public void restoreDB_() {
        clusterRepository.restore();
    }
}
