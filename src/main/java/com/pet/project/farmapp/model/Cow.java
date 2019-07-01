package com.pet.project.farmapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Cow {

    @Id
    @SequenceGenerator( name = "jpaCowSequence", sequenceName = "cow_id_seq",allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaCowSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "farmer_id", nullable = false)
    private Long farmerId;

    @Column(name = "weight", nullable = false)
    private Long weight;

    @Column(name = "age", nullable = false)
    private Long age;

    @Column(name = "is_healthy",nullable = false)
    private boolean isHealthy;
}
