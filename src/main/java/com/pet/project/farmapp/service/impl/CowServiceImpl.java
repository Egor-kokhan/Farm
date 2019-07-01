package com.pet.project.farmapp.service.impl;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.mapper.FarmAppMapper;
import com.pet.project.farmapp.repository.CowRepository;
import com.pet.project.farmapp.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CowServiceImpl implements CowService {

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
}
