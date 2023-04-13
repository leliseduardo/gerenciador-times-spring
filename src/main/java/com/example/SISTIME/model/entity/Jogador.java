package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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
    @PositiveOrZero
    private float altura;
    @PositiveOrZero
    private float peso;
}
