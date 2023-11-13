package com.example.testtask.restController;

import com.example.testtask.dto.CameraDto;
import com.example.testtask.model.Camera;
import com.example.testtask.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cameras")
public class Controller {

    @Autowired
    private CameraService cameraService;

    @GetMapping
    public List<CameraDto> getCameras() {
        return cameraService.getCameras();
    }

}
