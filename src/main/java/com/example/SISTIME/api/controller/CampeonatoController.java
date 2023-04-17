package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.CampeonatoDto;
import com.example.SISTIME.model.entity.Campeonato;
import com.example.SISTIME.service.CampeonatoService;
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
@RequestMapping("/api/v1/campeonato")
@RequiredArgsConstructor
public class CampeonatoController {

    private final CampeonatoService service;

    @GetMapping
    public ResponseEntity get() {
        List<Campeonato> campeonatos = service.getCampeonato();
        return ResponseEntity.ok(campeonatos.stream().map(c -> CampeonatoDto.create(c)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") long id){

        Optional<Campeonato> campeonato = service.getById(id);

        if(!campeonato.isPresent()){
            return new ResponseEntity("Campeonato não encontrado", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(campeonato.map(c -> CampeonatoDto.create(c)));
    }
}
















