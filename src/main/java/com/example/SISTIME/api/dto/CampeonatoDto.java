package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Campeonato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  CampeonatoDto {
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String campeao;
    private Long temporadaId;

    public static CampeonatoDto create(Campeonato campeonato) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(campeonato, CampeonatoDto.class);
    }
}
