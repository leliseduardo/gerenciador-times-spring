package com.example.SISTIME.api.dto;


import com.example.SISTIME.model.entity.LesaoJogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LesaoJogadorDto {

    private long id;
    private long idJogador;
    private long idLesao;

    public static LesaoJogadorDto create(LesaoJogador lesaoJogador){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(lesaoJogador, LesaoJogadorDto.class);
    }
}


























