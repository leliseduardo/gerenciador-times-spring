package com.example.SISTIME.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tecnico extends Pessoa{

    private LocalDate dataDeContratacao;
    private LocalDate dataDeDemissao;
}
