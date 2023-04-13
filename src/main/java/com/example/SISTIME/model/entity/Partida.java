package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate data;
    private LocalDateTime hora;
    private String placar;

    @NotNull
    @ManyToOne
    private Campeonato campeonato;
    @NotNull
    @ManyToOne
    private Estadio estadio;
    @NotNull
    @ManyToOne
    private TimeAdversario timeAdversario;
    @NotNull
    @ManyToOne
    private Tecnico tecnico;
}
