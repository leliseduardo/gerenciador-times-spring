package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.JogadorDto;
import com.example.SISTIME.model.entity.Jogador;
import com.example.SISTIME.service.JogadorService;
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
@RequestMapping("/api/v1/jogadores")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService service;

    @GetMapping
    public ResponseEntity get(){
        List<Jogador> jogadores = service.getJogador();
        return ResponseEntity.ok(jogadores.stream().map(JogadorDto::create).collect(Collectors.toList()));
//        return ResponseEntity.ok(jogadores.stream().map(c -> JogadorDto.create(c)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Jogador> jogador = service.getJogadorById(id);

        if(!jogador.isPresent()){
            return new ResponseEntity("Jogador não encontrado", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(jogador.map(JogadorDto::create));
//        return ResponseEntity.ok(jogador.map(c -> JogadorDto.create(c)));
    }
}

















