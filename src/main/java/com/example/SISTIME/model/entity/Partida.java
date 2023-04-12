package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    private Campeonato campeonato;
    @ManyToOne
    private Estadio estadio;
    @ManyToOne
    private TimeAdversario timeAdversario;
    @ManyToOne
    private Tecnico tecnico;
}
