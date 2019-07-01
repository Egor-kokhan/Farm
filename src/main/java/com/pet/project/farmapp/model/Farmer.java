package com.pet.project.farmapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "farm_id", nullable = false)
    private Long farmId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "age", nullable = false)
    private String age;

    @Column(name = "work_experience")
    private String workExperience;

    @Column(name = 	"salary")
    private Long salary;

}