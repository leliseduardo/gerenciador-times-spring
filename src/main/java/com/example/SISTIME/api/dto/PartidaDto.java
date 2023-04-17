package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Partida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDto {

    private long id;
    private LocalDate data;
    private LocalTime hora;
    private String placar;
    private long idCampeonato;
    private long idEstadio;
    private long idTimeAdversario;
    private long idTecnico;

    public static PartidaDto create(Partida partida){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(partida, PartidaDto.class);
    }
}
