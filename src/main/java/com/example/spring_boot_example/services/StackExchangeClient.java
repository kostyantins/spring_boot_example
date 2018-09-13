package com.example.spring_boot_example.services;

import com.example.spring_boot_example.model.SiteDto;
import com.example.spring_boot_example.model.SitesDto;
import io.restassured.response.Response;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static io.restassured.RestAssured.given;

@Component
public class StackExchangeClient {

    private HttpClient httpClient = HttpClientBuilder.create().build();
    private ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<SiteDto> getSites() {
        final String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=5&filter=!2*nS3dguV(Y)xKGRu8YcH";
        try {
            SitesDto response = restTemplate.getForObject(new URI(url), SitesDto.class);
            return response.getItems();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Response getSites_WithRestAssured() {
        final String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=5&filter=!2*nS3dguV(Y)xKGRu8YcH";

        return given()
                .get(url);
    }
}
