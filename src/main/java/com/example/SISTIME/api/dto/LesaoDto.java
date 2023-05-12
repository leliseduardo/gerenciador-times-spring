package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LesaoDto {
    private Long id;
    private String nome;
    private String gravidade;
    private String local;
    private String tipo;
    private Long tempoMedioDeTratamento;

    public static LesaoDto create(Lesao lesao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(lesao, LesaoDto.class);
    }
}
