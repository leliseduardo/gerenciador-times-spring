package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Lesao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LesaoDto {

    private long id;
    private String nome;
    private String gravidade;
    private String local;
    private String tipo;
    private long tempoMedioDeTratamento;

    public static LesaoDto create(Lesao lesao){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(lesao, LesaoDto.class);
    }
}
























