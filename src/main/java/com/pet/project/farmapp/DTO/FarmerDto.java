package com.pet.project.farmapp.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FarmerDto {
    private Long id;

    @Size(min = 4, max = 20)
    @NotNull
    private String name;

    @Size(min = 4, max = 20)
    @NotNull
    private Long farmId;

    @Size(min = 14,max = 20)
    @NotNull
    private String phone;

    @Size(max = 100)
    private String age;

    @Size(max = 100)
    private Long workExperience;

    private Long salary;
}