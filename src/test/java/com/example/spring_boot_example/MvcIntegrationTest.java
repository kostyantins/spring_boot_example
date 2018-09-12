package com.example.spring_boot_example;

import com.example.spring_boot_example.controller.CarController;
import com.example.spring_boot_example.exception.CarNotFoundException;
import com.example.spring_boot_example.model.Car;
import com.example.spring_boot_example.services.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class MvcIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CarService carService;

    @Test
    public void testMvc() throws Exception {

        given(carService.getCarDetails(anyString()))
                .willReturn(new Car("prius", "hybrid"));

        mockMvc
                .perform(MockMvcRequestBuilders.get("/cars/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("prius"))
                .andExpect(jsonPath("type").value("hybrid"));
    }

    @Test
    public void testMvc_CarNotFound() throws Exception {

        given(carService.getCarDetails(anyString()))
                .willThrow(new CarNotFoundException());

        mockMvc
                .perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isNotFound());
    }
}
