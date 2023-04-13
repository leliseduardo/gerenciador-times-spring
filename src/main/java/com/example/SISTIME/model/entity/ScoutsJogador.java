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
public class ScoutsJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PositiveOrZero
    private int desarmes;
    @PositiveOrZero
    private int faltasCometidas;
    @PositiveOrZero
    private int golContra;
    @PositiveOrZero
    private int cartaoAmarelo;
    @PositiveOrZero
    private int cartaoVermelho;
    @PositiveOrZero
    private int faltaSofrida;
    @PositiveOrZero
    private int passeIncompleto;
    @PositiveOrZero
    private int assistencia;
    @PositiveOrZero
    private int finalizacaoTrave;
    @PositiveOrZero
    private int finalizacaoDefendida;
    @PositiveOrZero
    private int finalizacaoFora;
    @PositiveOrZero
    private int gol;
    @PositiveOrZero
    private int impedimento;
    @PositiveOrZero
    private int penaltiPerdido;
    @PositiveOrZero
    private int penaltiSofrido;
    @PositiveOrZero
    private int penaltiCometido;
    @PositiveOrZero
    private int jogosSemSofrerGols;
    @PositiveOrZero
    private int defesaDificil;
    @PositiveOrZero
    private int defesaPenalti;
    @PositiveOrZero
    private int golSofrido;

    @NotNull
    @ManyToOne
    private Jogador jogador;

    @NotNull
    @ManyToOne
    private Partida partida;
}



















