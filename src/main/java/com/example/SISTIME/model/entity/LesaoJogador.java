package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LesaoJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    private Jogador jogador;
    @NotNull
    @ManyToOne
    private Lesao lesao;
}
