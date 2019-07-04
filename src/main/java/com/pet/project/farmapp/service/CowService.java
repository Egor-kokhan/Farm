package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.CowDto;

import java.util.List;

/**
 * /farm/list
 * /farm/add
 * /farm/update
 * /farm/delete
 *     FarmerDto getById(long id);
 *     void create(FarmerDto farmerDto);
 *     void delete(long id);
 *     void update(FarmerDto farmerDto, long id);
 */
public interface CowService {
    List<CowDto> getAll();
    CowDto getById(long id);
    void create(CowDto cowDto);
    void delete(long id);
    void update(CowDto cowDto, long id);
}
