package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.FarmDto;

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
    FarmDto getById(long id);
    void create(FarmDto farmDto);
    void delete(long id);
    void update(FarmDto farmDto, long id);
}
