package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.LesaoJogadorDto;
import com.example.SISTIME.model.entity.Lesao;
import com.example.SISTIME.model.entity.LesaoJogador;
import com.example.SISTIME.service.LesaoJogadorService;
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
@RequestMapping("/api/v1/lesoes-jogador")
@RequiredArgsConstructor
public class LesaoJogadorController {

    private final LesaoJogadorService service;

    @GetMapping
    public ResponseEntity get(){
        List<LesaoJogador> lesoesJogador = service.getLesaoJogador();
        return ResponseEntity.ok(lesoesJogador.stream().map(LesaoJogadorDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<LesaoJogador> lesaoJogador = service.getLesaoJogadorById(id);

        if(!lesaoJogador.isPresent()){
            return new ResponseEntity("LesaoJogador não encontrado", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(lesaoJogador.map(LesaoJogadorDto::create));
    }
}



















