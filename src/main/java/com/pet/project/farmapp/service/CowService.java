package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.CowDto;

import java.util.List;

/**
 * /farm/list
 * /farm/add
 * /farm/update
 * /farm/delete
 */
public interface CowService {
    List<CowDto> getAll();
}
