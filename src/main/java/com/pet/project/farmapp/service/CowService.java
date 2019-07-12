package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.CowDto;

import java.util.List;

/**
 *
 * /cow
 * /cow/{id}
 * /cow/(post)
 * /cow/{id}(put)
 * /cow/{id}(delete)
 *
 */
public interface CowService {
    List<CowDto> getAll();
    CowDto getById(long id);
    void create(CowDto cowDto);
    void delete(long id);
    void update(CowDto cowDto, long id);
}
