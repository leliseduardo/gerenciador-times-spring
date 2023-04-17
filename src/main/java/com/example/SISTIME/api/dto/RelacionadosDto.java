package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Relacionados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelacionadosDto {

    private long id;
    private boolean titular;
    private String saiu;
    private String entrou;
    private long idPartida;
    private long idJogador;

    public static RelacionadosDto create(Relacionados relacionados){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(relacionados, RelacionadosDto.class);
    }
}
