package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.DTO.FarmerDto;

import java.util.List;

/**
 * /farmer
 * /farmer/{id}
 * /farmer/{id}/cow
 * /farmer/(post)
 * /farmer/{id}(put)
 * /farmer/{id}(delete)
 *
 */
public interface FarmerService {
    List<FarmerDto> getAll();
    List<CowDto> getAllCowsByFarmerId(long id);
    FarmerDto getById(long id);
    void create(FarmerDto farmerDto);
    void delete(long id);
    void update(FarmerDto farmerDto, long id);
}
