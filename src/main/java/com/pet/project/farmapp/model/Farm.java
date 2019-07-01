package com.pet.project.farmapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Farm {

    @Id
    @SequenceGenerator( name = "jpaFarmSequence", sequenceName = "farm_id_seq",allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaFarmSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "farm_id")
    private Set<Farmer> farmers;
}
