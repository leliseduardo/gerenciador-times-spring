package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.ScoutsPartida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoutsPartidaDto {

    private long id;
    private int posseDeBola;
    private int impedimentos;
    private int cruzamentos;
    private int escanteios;
    private long idPartida;

    public static ScoutsPartidaDto create(ScoutsPartida scoutsPartida){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(scoutsPartida, ScoutsPartidaDto.class);
    }
}
