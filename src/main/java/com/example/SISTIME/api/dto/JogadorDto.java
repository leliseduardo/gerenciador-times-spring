package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Jogador;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class JogadorDto {

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
    private String nacionalidade;
    private float altura;
    private float peso;

    public static JogadorDto create(Jogador jogador){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(jogador, JogadorDto.class);
    }
}
