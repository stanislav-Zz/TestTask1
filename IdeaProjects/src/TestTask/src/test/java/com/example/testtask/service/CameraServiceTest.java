package com.example.testtask.service;

import com.example.testtask.dto.CameraDto;
import com.example.testtask.model.Camera;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CameraServiceTest {
    private CameraService cameraService;
    @Mock
    private RestTemplate restTemplate;
    private static final String SOURCE_DATA_URL = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";

    private static final String JSON = "{\"cameras\":[{\"id\":1,\"sourceDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"," +
            "\"tokenDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"},{\"id\":2,\"sourceDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"," +
            "\"tokenDataUrl\":\"http://www.mocky.io/v2/5c51b9dd3400003252129fb5\"}]}";
    @Before
    public void setup() {
        when(restTemplate.getForObject(SOURCE_DATA_URL, String.class)).thenReturn(JSON);
        cameraService = new CameraService(restTemplate);
    }
    @Test
    void getCameras() {
        List<Camera> cameraList = Arrays.asList(new Camera(), new Camera());
        when(restTemplate.getForObject(SOURCE_DATA_URL, List.class)).thenReturn(cameraList);

        // Act
        List<CameraDto> result = cameraService.getCameras();

        // Assert
        assertEquals(cameraList.size(), result.size());
        for (int i = 0; i < cameraList.size(); i++) {
            assertEquals(cameraService.cameraToCameraDto(cameraList.get(i)), result.get(i));
        }
    }
}


