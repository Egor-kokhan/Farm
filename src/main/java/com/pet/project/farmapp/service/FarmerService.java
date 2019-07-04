package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.DTO.FarmerDto;

import java.util.List;

/**
 * /farmer/list
 * /farmer/cowlist
 * /farmer/add
 * /farmer/update
 * /farmer/delete
 *
 */
public interface FarmerService {
    List<FarmerDto> getAll();
    List<CowDto> getAllCowsById(long id);
    FarmerDto getById(long id);
    void create(FarmerDto farmerDto);
    void delete(long id);
    void update(FarmerDto farmerDto, long id);
}
