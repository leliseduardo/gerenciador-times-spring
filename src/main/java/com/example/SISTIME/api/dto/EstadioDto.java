package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Estadio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadioDto {

    private long id;
    private String nome;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public static EstadioDto create(Estadio estadio){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(estadio, EstadioDto.class)
    }
}
