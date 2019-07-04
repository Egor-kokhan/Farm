package com.pet.project.farmapp.controller;


import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<CowDto> getById(@PathVariable Long id) {
        CowDto cow = service.getById(id);
        return ResponseEntity.ok(cow);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CowDto cowDto){
        service.create(cowDto);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CowDto cowDto, @PathVariable long id){
        service.update(cowDto,id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
