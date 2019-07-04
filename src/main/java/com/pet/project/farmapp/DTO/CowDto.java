package com.pet.project.farmapp.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
