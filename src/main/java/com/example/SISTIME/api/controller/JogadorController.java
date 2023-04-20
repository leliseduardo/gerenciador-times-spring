package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.JogadorDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Jogador;
import com.example.SISTIME.service.JogadorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody JogadorDto dto){
        try{
            Jogador jogador = converter(dto);
            jogador = service.create(jogador);
            return new ResponseEntity(jogador, HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("id")
    public ResponseEntity atualizar(@PathVariable("/id") long id, @RequestBody JogadorDto dto){
        if(!service.getJogadorById(id).isPresent()){
            return new ResponseEntity("Jogador não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Jogador jogador = converter(dto);
            jogador.setId(id);
            service.create(jogador);
            return ResponseEntity.ok(jogador);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Jogador converter(JogadorDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Jogador jogador = modelMapper.map(dto, Jogador.class);
        return jogador;
    }
}

















