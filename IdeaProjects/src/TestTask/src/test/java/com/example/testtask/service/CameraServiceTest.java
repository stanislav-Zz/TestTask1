package com.example.testtask.service;

import com.example.testtask.dto.CameraDto;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CameraServiceTest {
    private CameraService cameraService;
    @Mock
    private RestTemplate restTemplate;
    private static final String SOURCE_DATA_URL = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";

    private static final String JSON = "{\"cameras\":[{\"id\":1,\"sourceDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"," +
            "\"tokenDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"},{\"id\":2,\"sourceDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"," +
            "\"tokenDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"}]}";
    @Before
    public void setup() {
        when(restTemplate.getForObject(SOURCE_DATA_URL, any())).thenReturn(JSON);
        cameraService = new CameraService(restTemplate);
    }
    @Test
    void getCameras() {
        List<CameraDto> list = cameraService.getCameras();

    }


}