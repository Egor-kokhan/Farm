package com.pet.project.farmapp.controller;

import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.DTO.FarmerDto;
import com.pet.project.farmapp.model.Farmer;
import com.pet.project.farmapp.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/farmer",produces = APPLICATION_JSON_VALUE)
public class FarmerController {

    private final FarmerService service;

    @Autowired
    public FarmerController(FarmerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<FarmerDto>> getFarmers(){
        List<FarmerDto> farmers = service.getAll();
        return ResponseEntity.ok(farmers);
    }

}
