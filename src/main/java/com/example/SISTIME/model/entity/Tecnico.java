package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tecnico extends Pessoa{

    @NotNull
    private LocalDate dataContratacao;
    @NotNull
    private LocalDate dataDemissao;
}
