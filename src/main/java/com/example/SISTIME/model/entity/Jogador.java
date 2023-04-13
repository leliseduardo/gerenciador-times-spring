package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogador extends Pessoa{

    @NotBlank
    private String nacionalidade;
    @NotNull
    @DecimalMin("0.50")
    private float altura;
    @NotNull
    @DecimalMin("0.50")
    private float peso;
}
