package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelacionadoDto {
    private Long id;
    private Boolean titular;
    private String saiu;
    private String entrou;
    private Long partidaId;
    private Long jogadorId;

    public static RelacionadoDto create(Relacionado relacionado) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(relacionado, RelacionadoDto.class);
    }
}
