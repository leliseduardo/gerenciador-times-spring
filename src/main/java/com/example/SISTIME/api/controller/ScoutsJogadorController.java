package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.ScoutsJogadorDto;
import com.example.SISTIME.model.entity.ScoutsJogador;
import com.example.SISTIME.service.ScoutsJogadorService;
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
@RequestMapping("/api/v1/scouts-jogador")
@RequiredArgsConstructor
public class ScoutsJogadorController {
    private final ScoutsJogadorService service;

    @GetMapping
    public ResponseEntity get(){
        List<ScoutsJogador> scoutsJogador = service.getScoutsJogador();
        return ResponseEntity.ok(scoutsJogador.stream().map(ScoutsJogadorDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<ScoutsJogador> scoutsJogador = service.getScoutsJogadorById(id);

        if(!scoutsJogador.isPresent()){
            return new ResponseEntity("ScoutsJogador não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(scoutsJogador.map(ScoutsJogadorDto::create));
    }
}
