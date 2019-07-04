package com.pet.project.farmapp.service.impl;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.DTO.FarmerDto;
import com.pet.project.farmapp.controller.exceptions.ElasticException;
import com.pet.project.farmapp.mapper.FarmAppMapper;
import com.pet.project.farmapp.model.Cow;
import com.pet.project.farmapp.model.Farmer;
import com.pet.project.farmapp.repository.CowRepository;
import com.pet.project.farmapp.repository.FarmerRepository;
import com.pet.project.farmapp.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmAppMapper mapper;
    private final FarmerRepository farmerRepository;
    private final CowRepository cowRepository;

    @Autowired
    public FarmerServiceImpl(FarmAppMapper mapper, FarmerRepository farmerRepository, CowRepository cowRepository) {
        this.mapper = mapper;
        this.farmerRepository = farmerRepository;
        this.cowRepository = cowRepository;
    }


    @Override
    @Transactional
    public List<FarmerDto> getAll() {
        List<Farmer> farmers = farmerRepository.findAll();
        return mapper.convertFarmerListToFarmerDtoList(farmers);
    }

    @Override
    @Transactional
    public List<CowDto> getAllCowsByFarmerId(long id) {
        if(!farmerRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Фермер не найден. Введите корректный id.");
        }
        List<Cow> cows = cowRepository.findAllByFarmerId(id);
        return mapper.convertCowListToCowDtoList(cows);
    }

    @Override
    @Transactional
    public FarmerDto getById(long id) {
        if(!farmerRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Фермер не найден. Введите корректный id.");
        }
        return mapper.farmerDtoToFarmer(farmerRepository.getOne(id));
    }

    @Override
    @Transactional
    public void create(FarmerDto farmerDto) {
        Farmer newFarmer = mapper.farmerToFarmerDto(farmerDto);
        farmerRepository.save(newFarmer);
    }

    @Override
    @Transactional
    public void delete(long id) {

        if(!farmerRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Фермер не найден. Введите корректный id.");
        }
        farmerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(FarmerDto farmerDto, long id) {
        if(!farmerRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND,"Фермер не найден. Введите корректный id.");
        }
        Farmer farmer = farmerRepository.getOne(id);
        if(farmerDto.getName()!= null){
            farmer.setName(farmerDto.getName());
        }
        if(farmerDto.getFarmId()!= null){
            farmer.setFarmId(farmerDto.getFarmId());
        }
        if(farmerDto.getPhone()!= null){
            farmer.setPhone(farmerDto.getPhone());
        }
        if(farmerDto.getAge()!= null){
            farmer.setAge(farmerDto.getAge());
        }
        if(farmerDto.getWorkExperience()!= null){
            farmer.setWorkExperience(farmerDto.getWorkExperience());
        }
        if(farmerDto.getSalary()!= null){
            farmer.setSalary(farmerDto.getSalary());
        }
        farmerRepository.save(farmer);

    }
}
