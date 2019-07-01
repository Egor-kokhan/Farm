package com.pet.project.farmapp.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * private Long id;
 *
 *     @Column(name = "farmer_id", nullable = false)
 *     private Long farmerId;
 *
 *     @Column(name = "weight", nullable = false)
 *     private Long weight;
 *
 *     @Column(name = "age", nullable = false)
 *     private Long age;
 *
 *     @Column(name = "is_healthy",nullable = false)
 *     private boolean isHealthy;
 */
@Data @NoArgsConstructor @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CowDto {

    private Long id;

    @NotNull
    private Long farmerId;

    @Size(max = 1000)
    @NotNull
    private Long weight;

    @Size(max = 40)
    @NotNull
    private Long age;

    @NotNull
    private boolean isHealthy;
}
