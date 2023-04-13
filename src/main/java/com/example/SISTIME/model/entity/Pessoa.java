package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String login;
    @NotBlank
    private String senha;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    private String cpf;
    @NotBlank
    private String telefone;
    @NotBlank
    private String logradouro;
    @NotNull
    @Min(1)
    private Integer numero;
    @NotBlank
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String uf;
    @NotBlank
    private String cep;
}
