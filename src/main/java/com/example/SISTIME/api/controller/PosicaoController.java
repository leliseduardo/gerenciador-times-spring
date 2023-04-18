package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.PosicaoDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Posicao;
import com.example.SISTIME.service.PosicaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody PosicaoDto dto){
        try{
            Posicao posicao = converter(dto);
            posicao = service.create(posicao);
            return new ResponseEntity(posicao, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Posicao converter(PosicaoDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Posicao posicao = modelMapper.map(dto, Posicao.class);
        return posicao;
    }
}
