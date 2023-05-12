package com.example.SISTIME.api.dto;

import com.example.SISTIME.model.entity.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDto {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String nacionalidade;
    private float altura;
    private float peso;
    private List<Long> ids_posicoes;

    public static JogadorDto create(Jogador jogador) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(jogador, JogadorDto.class);
    }

    public JogadorDto createDinamico(Jogador jogador) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(jogador, JogadorDto.class);
    }
}
