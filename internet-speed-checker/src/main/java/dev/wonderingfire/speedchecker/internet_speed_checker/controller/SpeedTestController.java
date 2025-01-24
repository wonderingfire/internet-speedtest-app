package dev.wonderingfire.speedchecker.internet_speed_checker.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.wonderingfire.speedchecker.internet_speed_checker.model.InternetSpeed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/speed")
@Slf4j
public class SpeedTestController {

    private final String FLASK_HOST = "http://127.0.0.1:5000";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InternetSpeed> getInternetSpeed() {
        return getInternetSpeedResponseEntity(FLASK_HOST +"/internet_speed");
    }

    @GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InternetSpeed> getInternetSpeedTest() {
        return getInternetSpeedResponseEntity(FLASK_HOST + "/internet_speed_testdata");
    }

    private ResponseEntity<InternetSpeed> getInternetSpeedResponseEntity(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        log.info("Triggered {}", uri);
        return ResponseEntity.ok(Optional.of(restTemplate.getForObject(uri, String.class))
                .map(s -> {
                    try {
                        return mapper.readValue(s, InternetSpeed.class);
                    } catch (JsonProcessingException e) {
                        log.error("Error parsing internet speed response");
                        return new InternetSpeed();
                    }
                }).orElse(new InternetSpeed()));
    }


}
