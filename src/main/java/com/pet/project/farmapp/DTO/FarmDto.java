package com.pet.project.farmapp.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FarmDto{

    private Long id;

    @Size(min = 4, max = 20, message = "Имя должно быть от 4 до 20 символов")
    @NotNull
    private String name;
}
