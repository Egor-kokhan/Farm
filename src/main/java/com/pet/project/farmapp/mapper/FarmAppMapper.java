package com.pet.project.farmapp.mapper;

import com.pet.project.farmapp.DTO.CowDto;
import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.DTO.FarmerDto;
import com.pet.project.farmapp.model.Cow;
import com.pet.project.farmapp.model.Farm;
import com.pet.project.farmapp.model.Farmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmAppMapper {
    Farm farmToFarmDto(FarmDto dto);

    FarmDto farmDtoToFarm(Farm entity);

    List<FarmDto> convertFarmListToFarmDtoList(List<Farm> list);

    Farmer farmerToFarmerDto(FarmerDto dto);

    FarmerDto farmerDtoToFarmer(Farmer entity);

    List<FarmerDto> convertFarmerListToFarmerDtoList(List<Farmer> list);

    Cow cowDtoToCow(CowDto dto);

    CowDto cowToCowDto(Cow entity);

    List<CowDto> convertCowListToCowDtoList(List<Cow> list);
}
