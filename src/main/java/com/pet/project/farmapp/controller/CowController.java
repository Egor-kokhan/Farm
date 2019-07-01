package com.pet.project.farmapp.controller;


import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/cow",produces = APPLICATION_JSON_VALUE)
public class CowController {

    private final CowService service;

    @Autowired
    public CowController(CowService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CowDto>> getCows(){
        List<CowDto> cows = service.getAll();
        return ResponseEntity.ok(cows);
    }
}
