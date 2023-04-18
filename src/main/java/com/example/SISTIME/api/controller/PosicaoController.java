package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.PosicaoDto;
import com.example.SISTIME.model.entity.Posicao;
import com.example.SISTIME.service.PosicaoService;
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
@RequestMapping("/api/v1/posicoes")
@RequiredArgsConstructor
public class PosicaoController {

    private final PosicaoService service;

    @GetMapping
    public ResponseEntity get(){
        List<Posicao> posicoes = service.getPosicao();
        return ResponseEntity.ok(posicoes.stream().map(PosicaoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Posicao> posicao = service.getPosicaoById(id);

        if(!posicao.isPresent()){
            return new ResponseEntity("Posicao não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(posicao.map(PosicaoDto::create));
    }
}
