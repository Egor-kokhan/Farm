package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.DTO.FarmerDto;

import java.util.List;

/**
 * /farm/list
 * /farm/cowlist
 * /farm/farmerlist
 * /farm/add
 * /farm/update
 * /farm/delete
 */

public interface FarmService {
    List<FarmDto> getAll();
    List<FarmerDto> getAllFarmersByFarmId(long id);
    //TODO List<Cow> getAllCowsByFarmId(long id)
    FarmDto getById(long id);
    void create(FarmDto farmDto);
    void delete(long id);
    void update(FarmDto farmDto, long id);
}
