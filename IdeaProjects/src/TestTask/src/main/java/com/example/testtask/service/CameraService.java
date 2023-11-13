package com.example.testtask.service;

import com.example.testtask.dto.CameraDto;
import com.example.testtask.model.Camera;
import com.example.testtask.model.SourceData;
import com.example.testtask.model.TokenData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CameraService {
    private final RestTemplate restTemplate;

    public CameraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private static final String SOURCE_DATA_URL = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";


    public List<CameraDto> getCameras() {

        List<Camera> cameraList = restTemplate.getForObject(SOURCE_DATA_URL, List.class);
        List<CameraDto> cameraDtoList = new ArrayList<>();
        if (cameraList != null) {
            cameraList.parallelStream().forEach(camera -> {
                cameraDtoList.add(cameraToCameraDto(camera));
            });
        }

        return cameraDtoList;
    }

    CameraDto cameraToCameraDto(Camera camera) {
        CameraDto dto = new CameraDto();
        dto.setId(camera.getId());
        dto.setUrlType(camera.getSourceDataUrl().getUrlType());
        dto.setVideoUrl(camera.getSourceDataUrl().getVideoUrl());
        dto.setValue(camera.getTokenDataUrl().getValue());
        dto.setTtl(camera.getTokenDataUrl().getTtl());

        return dto;
    }

}

