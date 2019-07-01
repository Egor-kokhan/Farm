package com.pet.project.farmapp.repository;

import com.pet.project.farmapp.model.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CowRepository extends JpaRepository<Cow, Long> {
    List<Cow> findAllByFarmerId(Long id);
}
