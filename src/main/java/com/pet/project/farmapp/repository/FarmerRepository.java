package com.pet.project.farmapp.repository;

import com.pet.project.farmapp.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    List<Farmer> findAllByFarmId(Long id);
}