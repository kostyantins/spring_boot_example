package com.example.spring_boot_example.repository;


import com.example.spring_boot_example.model.Clusters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClusterRepository extends JpaRepository<Clusters, Integer> {

    @Transactional
    @Modifying
    @Query(value = "USE master\n" +
            "ALTER DATABASE EnterpriseDB\n" +
            "SET SINGLE_USER\n" +
            "WITH ROLLBACK IMMEDIATE\n" +
            "RESTORE DATABASE EnterpriseDB\n" +
            "FROM  DISK = N'd:\\GIT\\kernel\\automation_test_framework\\test\\automation_test_framework\\src\\main\\resources\\db_beckups\\EnterpriseDB_2018-08-29_clean.bak'\n" +
            "WITH  FILE = 1\n" +
            ",  NOUNLOAD\n" +
            ",  REPLACE\n" +
            ",  STATS = 5\n" +
            "ALTER DATABASE EnterpriseDB\n" +
            "SET MULTI_USER",nativeQuery = true)
    void restore();

    @Transactional
    @Modifying
    @Query(value = "SELECT * " +
            "       FROM Clusters" +
            "       WHERE ClusterName = :name" ,nativeQuery = true)
   List<Clusters> findAllByName(@Param("name") String name);
}
