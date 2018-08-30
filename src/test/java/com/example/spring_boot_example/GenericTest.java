package com.example.spring_boot_example;

import com.example.spring_boot_example.controller.GenericController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenericTest {

    @Autowired
    private GenericController genericController;

    @Test
    public void create() {
        genericController.createEntity();
    }

}
