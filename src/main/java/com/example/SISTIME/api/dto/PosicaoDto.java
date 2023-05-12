package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PosicaoDto {
    private Long id;
    private String nome;
    private String areaCampo;
    private String ladoCampo;
    private String sigla;

    public static PosicaoDto create(Posicao posicao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(posicao, PosicaoDto.class);
    }
}
