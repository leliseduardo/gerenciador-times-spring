package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.PosicaoJogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicaoJogadorDto {

    private long id;
    private long idJogador;
    private long idPosicao;

    public static PosicaoJogadorDto create(PosicaoJogador posicaoJogador){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(posicaoJogador, PosicaoJogadorDto.class);
    }
}
