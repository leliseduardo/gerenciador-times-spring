package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Temporada;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemporadaDto {

    private long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public static TemporadaDto create(Temporada temporada){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(temporada, TemporadaDto.class);
    }
}
