package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    private long id;
    private String login;
    private String senha;
    private String nome;
}
