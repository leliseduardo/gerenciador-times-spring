package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
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

    private int posseDeBola;
    private int impedimentos;
    private int cruzamentos;
    private int escanteios;

    @ManyToOne
    private Partida partida;
}
