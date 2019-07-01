package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.FarmerDto;

import java.util.List;

/**
 * /farmer/list
 * /farmer/cowlist
 * /farmer/add
 * /farmer/update
 * /farmer/delete
 */
public interface FarmerService {
    List<FarmerDto> getAll();
}
