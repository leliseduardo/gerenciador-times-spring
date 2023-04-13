package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ScoutsPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PositiveOrZero
    private int posseDeBola;
    @PositiveOrZero
    private int impedimentos;
    @PositiveOrZero
    private int cruzamentos;
    @PositiveOrZero
    private int escanteios;

    @NotNull
    @ManyToOne
    private Partida partida;
}
