package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LesaoJogadorDto {
    private Long id;
    private LocalDate dataLesao;
    private Long jogadorId;
    private Long lesaoId;
    private Long medicoResponsavelId;

    public static LesaoJogadorDto create(LesaoJogador lesaoJogador) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(lesaoJogador, LesaoJogadorDto.class);
    }
}
