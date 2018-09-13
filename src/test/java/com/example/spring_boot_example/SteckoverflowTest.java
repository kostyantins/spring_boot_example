package com.example.spring_boot_example;

import com.example.spring_boot_example.controller.SteckoverflowController;
import com.example.spring_boot_example.model.SteckoverflowWebcite;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SteckoverflowTest {

    @Autowired
    private SteckoverflowController steckoverflowController;

    @Test
    public void testSteckoverflow (){

        List<SteckoverflowWebcite> result = steckoverflowController.getListOfProviders();

        assertThat(result.get(0).getName()).isEqualTo("Stack Overflow");
    }

    @Test
    public void testSteckoverflow_ (){

        Response response = steckoverflowController.getListOfProviders_();

        String response01 = response.jsonPath().getString("items.name");

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response01).containsIgnoringCase("Stack Overflow");
    }
}
