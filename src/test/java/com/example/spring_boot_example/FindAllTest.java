package com.example.spring_boot_example;


import com.example.spring_boot_example.controller.SomeController;
import com.example.spring_boot_example.model.Clusters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindAllTest {

    @Autowired
    private SomeController someController;

    @Test
    public void create() {
        List<Clusters> a = someController
                .getAll();

        System.out.println(a.get(0).getClusterName());
    }
}
