package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Relacionados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private boolean titular;
    @NotBlank
    private String saiu;
    @NotBlank
    private String entrou;

    @NotNull
    @ManyToOne
    private Partida partida;

    @NotNull
    @ManyToOne
    private Jogador jogador;
}
