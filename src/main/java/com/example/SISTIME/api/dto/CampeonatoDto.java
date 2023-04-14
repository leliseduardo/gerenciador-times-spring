package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Campeonato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampeonatoDto {

    private long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String campeao;
    private long idTemporada;

    public static CampeonatoDto create(Campeonato campeonato){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(campeonato, CampeonatoDto.class);
    }
}





















