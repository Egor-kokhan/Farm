package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.FarmerDto;

import java.util.List;

/**
 * /farmer/list
 * /farmer/cowlist
 * /farmer/add
 * /farmer/update
 * /farmer/delete
 *
 *   List<FarmDto> getAll();
 *   FarmDto getById(long id);
 *   void create(FarmDto farmDto);
 *   void delete(long id);
 *   void update(FarmDto farmDto, long id);
 */
public interface FarmerService {
    List<FarmerDto> getAll();

}
