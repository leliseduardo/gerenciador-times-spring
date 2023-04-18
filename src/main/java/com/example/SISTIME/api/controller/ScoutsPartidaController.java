package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.ScoutsPartidaDto;
import com.example.SISTIME.model.entity.ScoutsPartida;
import com.example.SISTIME.service.ScoutsPartidaService;
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
@RequestMapping("/api/v1/scouts-partida")
@RequiredArgsConstructor
public class ScoutsPartidaController {
    private final ScoutsPartidaService service;

    @GetMapping
    public ResponseEntity get(){
        List<ScoutsPartida> scoutsPartida = service.getScoutsPartida();
        return ResponseEntity.ok(scoutsPartida.stream().map(ScoutsPartidaDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<ScoutsPartida> scoutsPartida = service.getScoutsPartidaById(id);

        if(!scoutsPartida.isPresent()){
            return new ResponseEntity("ScoutsPartida não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(scoutsPartida.map(ScoutsPartidaDto::create));
    }
}
