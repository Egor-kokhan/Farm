package com.pet.project.farmapp.controller;

import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.DTO.FarmerDto;
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

    private final FarmService service;

    @Autowired
    public FarmController(FarmService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<FarmDto>> getAll(){
        List<FarmDto> farms = service.getAll();
        return ResponseEntity.ok(farms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmDto> getById(@PathVariable Long id) {
        FarmDto farmDto = service.getById(id);
        return ResponseEntity.ok(farmDto);
    }

    @GetMapping("/farmerlist/{id}")
    public ResponseEntity<List<FarmerDto>> getAllFarmersByFarmId(@PathVariable Long id){
        List<FarmerDto> farmers = service.getAllFarmersByFarmId(id);
        return ResponseEntity.ok(farmers);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FarmDto farmDto){
        service.create(farmDto);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FarmDto farmDto, @PathVariable long id){
        service.update(farmDto,id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
