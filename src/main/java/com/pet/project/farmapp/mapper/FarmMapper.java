package com.pet.project.farmapp.mapper;

import com.pet.project.farmapp.DTO.FarmDto;
import com.pet.project.farmapp.model.Farm;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmMapper {
    Farm farmToFarmDto(FarmDto dto);

    FarmDto farmDtoToFarm(Farm entity);

    List<FarmDto> convertFarmListToFarmDtoList(List<Farm> list);

}
