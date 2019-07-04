package com.pet.project.farmapp.controller;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.DTO.FarmerDto;
import com.pet.project.farmapp.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<FarmerDto>> getAll(){
        List<FarmerDto> farmers = service.getAll();
        return ResponseEntity.ok(farmers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerDto> getById(@PathVariable Long id) {
        FarmerDto farmerDto = service.getById(id);
        return ResponseEntity.ok(farmerDto);
    }

    @GetMapping("/{id}/cow/list")
    public ResponseEntity<List<CowDto>> getAllCowsByFarmerId(@PathVariable Long id) {
        List<CowDto> cows = service.getAllCowsById(id);
        return ResponseEntity.ok(cows);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FarmerDto farmerDto){
        service.create(farmerDto);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FarmerDto farmerDto, @PathVariable long id){
        service.update(farmerDto,id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}













