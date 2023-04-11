package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private int desarmes;
    private int faltasCometidas;
    private int golContra;
    private int cartaoAmarelo;
    private int cartaoVermelho;
    private int faltaSofrida;
    private int passeIncompleto;
    private int assistencia;
    private int finalizacaoTrave;
    private int finalizacaoDefendida;
    private int finalizacaoFora;
    private int gol;
    private int impedimento;
    private int penaltiPerdido;
    private int penaltiSofrido;
    private int penaltiCometido;
    private int jogosSemSofrerGols;
    private int defesaDificil;
    private int defesaPenalti;
    private int golSofrido;
}



















