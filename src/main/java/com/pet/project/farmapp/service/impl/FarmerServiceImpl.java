package com.pet.project.farmapp.service.impl;

import com.pet.project.farmapp.DTO.FarmerDto;
import com.pet.project.farmapp.mapper.FarmAppMapper;
import com.pet.project.farmapp.model.Farmer;
import com.pet.project.farmapp.repository.FarmerRepository;
import com.pet.project.farmapp.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmAppMapper mapper;
    private final FarmerRepository farmerRepository;

    @Autowired
    public FarmerServiceImpl(FarmAppMapper mapper, FarmerRepository farmerRepository) {
        this.mapper = mapper;
        this.farmerRepository = farmerRepository;
    }


    @Override
    @Transactional
    public List<FarmerDto> getAll() {
        List<Farmer> farmers = farmerRepository.findAll();
        return mapper.convertFarmerListToFarmerDtoList(farmers);
    }
}
