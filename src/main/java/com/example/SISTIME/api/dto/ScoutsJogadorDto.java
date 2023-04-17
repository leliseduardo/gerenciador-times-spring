package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.ScoutsJogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoutsJogadorDto {

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
    private long idJogador;
    private long idPartida;

    public static ScoutsJogadorDto crate(ScoutsJogador scoutsJogador){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(scoutsJogador, ScoutsJogadorDto.class);
    }
}
