package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.TemporadaDto;
import com.example.SISTIME.model.entity.Temporada;
import com.example.SISTIME.service.TemporadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/temporadas")
@RequiredArgsConstructor
public class TemporadaController {
    private final TemporadaService service;

    @GetMapping
    public ResponseEntity get(){
        List<Temporada> temporadas = service.getTemporada();
        return ResponseEntity.ok(temporadas.stream().map(TemporadaDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Temporada> temporada = service.getTemporadaById(id);

        if(!temporada.isPresent()){
            return new ResponseEntity("Temporada não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(temporada.map(TemporadaDto::create));
    }
}
