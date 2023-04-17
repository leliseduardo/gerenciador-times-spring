package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Tecnico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoDto {

    private long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private LocalDate dataContratacao;
    private LocalDate dataDemissao;

    public static TecnicoDto create(Tecnico tecnico){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tecnico, TecnicoDto.class);
    }
}
