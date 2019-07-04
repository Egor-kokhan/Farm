package com.pet.project.farmapp.service.impl;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.DTO.FarmerDto;
import com.pet.project.farmapp.controller.exceptions.ElasticException;
import com.pet.project.farmapp.mapper.FarmAppMapper;
import com.pet.project.farmapp.model.Cow;
import com.pet.project.farmapp.model.Farm;
import com.pet.project.farmapp.model.Farmer;
import com.pet.project.farmapp.repository.CowRepository;
import com.pet.project.farmapp.repository.FarmRepository;
import com.pet.project.farmapp.repository.FarmerRepository;
import com.pet.project.farmapp.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FarmerRepository farmerRepository;
    private final CowRepository cowRepository;
    private final FarmAppMapper mapper;


    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository, FarmerRepository farmerRepository, FarmAppMapper mapper,CowRepository cowRepository) {
        this.farmRepository = farmRepository;
        this.farmerRepository = farmerRepository;
        this.cowRepository = cowRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public List<FarmDto> getAll() {
        return mapper.convertFarmListToFarmDtoList(farmRepository.findAll());
    }

    @Override
    @Transactional
    public List<FarmerDto> getAllFarmersByFarmId(long id) {
        if(!farmRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Ферма не найдена. Введите корректный id.");
        }
        List<Farmer> farmersDto = farmerRepository.findAllByFarmId(id);
        return mapper.convertFarmerListToFarmerDtoList(farmersDto);
    }

    @Override
    @Transactional
    public List<CowDto> getAllCowsByFarmId(long id) {
        List<Cow> cows = getCowsByFarmId(id);
        return mapper.convertCowListToCowDtoList(cows);
    }

    @Override
    @Transactional
    public Long getCowsCostByFarmId(long id) {
        List<Cow> cows = getCowsByFarmId(id);
        Long totalCost = 0L;
        for (Cow cow : cows) {
            if(cow.isHealthy()&&cow.getAge()<=12&&cow.getAge()>=3){
                totalCost += cow.getWeight()*115;
            }
        }
        return totalCost;
    }

    @Override
    @Transactional
    public FarmDto getById(long id) {
        if(!farmRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Ферма не найдена. Введите корректный id.");
        }
        Farm farm = farmRepository.getOne(id);
        return mapper.farmDtoToFarm(farm);
    }

    @Override
    @Transactional
    public void create(FarmDto farmDto) {
        Farm farm = mapper.farmToFarmDto(farmDto);
        farmRepository.save(farm);
    }

    @Override
    @Transactional
    public void update(FarmDto farmDto, long id) {
        if(!farmRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Ферма не найдена. Введите корректный id.");
        }
        Farm farm = farmRepository.getOne(id);
        if (farmDto.getName() != null) {
            farm.setName(farmDto.getName());
        }
        farmRepository.save(farm);
    }

    @Override
    @Transactional
    public void delete(long id) {
        if(!farmRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Ферма не найдена. Введите корректный id.");
        }
        farmRepository.deleteById(id);
    }


    private List<Cow> getCowsByFarmId(long id) {
        if(!farmRepository.existsById(id)){
            throw new ElasticException(HttpStatus.NOT_FOUND, "Ферма не найдена. Введите корректный id.");
        }
        List<Farmer> farmers = farmerRepository.findAllByFarmId(id);
        ArrayList<Long> farmersId = new ArrayList<>();
        for (Farmer farmer : farmers) {
            farmersId.add(farmer.getId());
        }
        return cowRepository.findAllByFarmerIdIn(farmersId);
    }

}
