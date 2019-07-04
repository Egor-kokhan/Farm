package com.pet.project.farmapp.service;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.DTO.FarmerDto;

import java.util.List;

/**
 * /farm/list
 * /farm/{id}
 * /farm/{id}/farmer/list
 * /farm/{id}/cow/list
 * /farm/{id}/cow/cost
 * /farm/(post)
 * /farm/{id}(put)
 * /farm/{id}(delete)
 *
 * Формула и условия для вычисления стоимости коровы:
 * Должна быть здоровой
 * Возраст от 3 до 12 лет (включительно)
 * кг 115р
 *
 */

public interface FarmService {
    List<FarmDto> getAll();
    FarmDto getById(long id);
    List<FarmerDto> getAllFarmersByFarmId(long id);
    List<CowDto> getAllCowsByFarmId(long id);
    Long getCowsCostByFarmId(long id);
    void create(FarmDto farmDto);
    void update(FarmDto farmDto, long id);
    void delete(long id);
}
