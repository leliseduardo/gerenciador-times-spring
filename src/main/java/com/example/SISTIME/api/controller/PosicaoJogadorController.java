package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.PosicaoJogadorDto;
import com.example.SISTIME.model.entity.PosicaoJogador;
import com.example.SISTIME.service.PosicaoJogadorService;
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
@RequestMapping("/api/v1/posicoes-jogador")
@RequiredArgsConstructor
public class PosicaoJogadorController {

    private final PosicaoJogadorService service;

    @GetMapping
    public ResponseEntity get(){
        List<PosicaoJogador> posicoesJogador = service.getPosicaoJogador();
        return ResponseEntity.ok(posicoesJogador.stream().map(PosicaoJogadorDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<PosicaoJogador> posicaoJogador = service.getPosicaoJogadorById(id);

        if(!posicaoJogador.isPresent()){
            return new ResponseEntity("PosicaoJogador não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(posicaoJogador.map(PosicaoJogadorDto::create));
    }
}
