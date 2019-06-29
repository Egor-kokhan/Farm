package com.pet.project.farmapp.repository;

import com.pet.project.farmapp.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
