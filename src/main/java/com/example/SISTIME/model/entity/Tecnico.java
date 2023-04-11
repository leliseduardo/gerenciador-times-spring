package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tecnico extends Pessoa{

    private LocalDate dataContratacao;
    private LocalDate dataDemissao;
}
