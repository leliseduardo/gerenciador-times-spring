package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogador extends Pessoa{

    private String nacionalidade;
    private float altura;
    private float peso;
}
