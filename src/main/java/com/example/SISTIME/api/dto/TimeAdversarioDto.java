package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.TimeAdversario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeAdversarioDto {

    private long id;
    private String nome;
    private String photoPath;

    public static TimeAdversarioDto create(TimeAdversario timeAdversario){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(timeAdversario, TimeAdversarioDto.class);
    }
}
