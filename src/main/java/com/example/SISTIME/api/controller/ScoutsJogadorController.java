package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.ScoutsJogadorDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.ScoutsJogador;
import com.example.SISTIME.service.ScoutsJogadorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody ScoutsJogadorDto dto){
        try{
            ScoutsJogador scoutsJogador = converter(dto);
            scoutsJogador = service.create(scoutsJogador);
            return new ResponseEntity(scoutsJogador, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private ScoutsJogador converter(ScoutsJogadorDto dto){
        ModelMapper modelMapper = new ModelMapper();
        ScoutsJogador scoutsJogador = modelMapper.map(dto, ScoutsJogador.class);
        return scoutsJogador;
    }
}
