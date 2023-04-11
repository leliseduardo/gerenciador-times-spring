package com.example.SISTIME.model.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    private Jogador jogador;
    @ManyToOne
    private Lesao lesao;
}
