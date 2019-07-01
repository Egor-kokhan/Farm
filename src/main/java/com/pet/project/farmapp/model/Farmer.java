package com.pet.project.farmapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Farmer {

    @Id
    @SequenceGenerator( name = "jpaFarmerSequence", sequenceName = "farmer_id_seq",allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaFarmerSequence")
    @Column(name = "id", nullable = false)
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "farmer_id")
    private Set<Cow> cows;
}