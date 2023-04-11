package com.example.SISTIME.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ScoutsPardida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int posseDeBola;
    private int impedimentos;
    private int cruzamentos;
    private int escanteios;
}
