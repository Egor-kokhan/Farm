package com.pet.project.farmapp.controller;

import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/farm",produces = APPLICATION_JSON_VALUE)
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<FarmDto>> getFarms(){
        List<FarmDto> farms = farmService.getAll();
        return ResponseEntity.ok(farms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmDto> getById(@PathVariable Long id) {
        FarmDto farmDto = farmService.getById(id);
        return ResponseEntity.ok(farmDto);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FarmDto farmDto){
        farmService.create(farmDto);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FarmDto farmDto, @PathVariable long id){
        farmService.update(farmDto,id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        farmService.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
