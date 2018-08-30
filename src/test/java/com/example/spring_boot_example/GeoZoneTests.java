package com.example.spring_boot_example;


import com.example.spring_boot_example.controller.SomeController;
import com.example.spring_boot_example.util.ApiTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoZoneTests extends ApiTestRunner {

    @Autowired
    private SomeController someController;

    @After
    public void prepareDB() {
        someController
                .restoreDB_();
    }

    @Test
    public void create() {
        someController
                .createData()
                .deleteData();
    }
}
