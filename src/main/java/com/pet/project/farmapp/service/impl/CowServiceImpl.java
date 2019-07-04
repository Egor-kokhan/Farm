package com.pet.project.farmapp.service.impl;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.controller.exceptions.ElasticException;
import com.pet.project.farmapp.mapper.FarmAppMapper;
import com.pet.project.farmapp.model.Cow;
import com.pet.project.farmapp.repository.CowRepository;
import com.pet.project.farmapp.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CowServiceImpl implements CowService{

    private final CowRepository cowRepository;

    private final FarmAppMapper mapper;

    @Autowired
    public CowServiceImpl(CowRepository cowRepository, FarmAppMapper mapper) {
        this.cowRepository = cowRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public List<CowDto> getAll() {
        return mapper.convertCowListToCowDtoList(cowRepository.findAll());
    }

    @Override
    @Transactional
    public CowDto getById(long id) {
        if(!cowRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Корова не найдена. Введите корректный id.");
        }
        return mapper.cowToCowDto(cowRepository.getOne(id));
    }

    @Override
    @Transactional
    public void create(CowDto cowDto) {
        Cow newCow = mapper.cowDtoToCow(cowDto);
        cowRepository.save(newCow);
    }

    @Override
    @Transactional
    public void delete(long id) {
        if(!cowRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Корова не найдена. Введите корректный id.");
        }
        cowRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(CowDto cowDto, long id) {
        if(!cowRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Корова не найдена. Введите корректный id.");
        }
        Cow cow = cowRepository.getOne(id);
        if (cowDto.getFarmerId() != null) {
            cow.setFarmerId(cowDto.getFarmerId());
        }
        if (cowDto.getWeight() != null) {
            cow.setWeight(cowDto.getWeight());
        }
        if (cowDto.getAge() != null) {
            cow.setAge(cowDto.getAge());
        }
        if (cowDto.isHealthy()) {
            cow.setHealthy(true);
        }
        cowRepository.save(cow);
    }
}
