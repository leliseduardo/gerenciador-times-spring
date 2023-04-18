package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.PartidaDto;
import com.example.SISTIME.model.entity.Partida;
import com.example.SISTIME.service.PartidaService;
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
@RequestMapping("/api/v1/partidas")
@RequiredArgsConstructor
public class PartidaController {
    private final PartidaService service;

    @GetMapping
    public ResponseEntity get(){
        List<Partida> partidas = service.getPartida();
        return ResponseEntity.ok(partidas.stream().map(PartidaDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Partida> partida = service.getPartidaById(id);

        if(!partida.isPresent()){
            return new ResponseEntity("Partida não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(partida.map(PartidaDto::create));
    }
}
