package com.example.SISTIME.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LesaoJogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataLesao;
    @ManyToOne
    private Jogador jogador;
    @ManyToOne
    private Lesao lesao;
    @ManyToOne
    private Medico medicoResponsavel;
}
