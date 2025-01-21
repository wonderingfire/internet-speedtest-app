package dev.wonderingfire.speedchecker.internet_speed_checker.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import dev.wonderingfire.speedchecker.internet_speed_checker.model.InternetSpeed;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/speed")
@Slf4j
public class SpeedTestController {


    @GetMapping(value = "/helloWorld")
    public String getCountries() {
        String uri = "http://127.0.0.1:5000/hello_world";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(uri, String.class);
        return response;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InternetSpeed> getInternetSpeed() {
        String uri = "http://127.0.0.1:5000/internet_speed";
        RestTemplate restTemplate = new RestTemplate();
        InternetSpeed speed = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            log.info("Will call the endpoint...");
            String responseStr = restTemplate.getForObject(uri, String.class);
            if (responseStr == null) {
                log.warn("Received null response from the endpoint");
                // Optionally, create a default or empty InternetSpeed object here if desired.
                speed = new InternetSpeed();  // Provide a default or empty object if null
            } else {
                speed = mapper.readValue(responseStr, InternetSpeed.class);
            }
        } catch (Exception e) {
            log.error("An error occurred while fetching the internet speed", e);
            speed = new InternetSpeed();  // Default object to avoid null response

        }
        return ResponseEntity.ok(speed);
    }

    @GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InternetSpeed> getInternetSpeedTest() {
        String uri = "http://127.0.0.1:5000/internet_speed_testdata";
        RestTemplate restTemplate = new RestTemplate();
        InternetSpeed speed = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            log.info("Will call the endpoint..." + uri);
            String responseStr = restTemplate.getForObject(uri, String.class);
            if (responseStr == null) {
                log.warn("Received null response from the endpoint");
                // Optionally, create a default or empty InternetSpeed object here if desired.
                speed = new InternetSpeed();  // Provide a default or empty object if null
            } else {
                speed = mapper.readValue(responseStr, InternetSpeed.class);
            }
        } catch (Exception e) {
            log.error("An error occurred while fetching the internet speed", e);
            speed = new InternetSpeed();  // Default object to avoid null response

        }
        return ResponseEntity.ok(speed);
    }

}
