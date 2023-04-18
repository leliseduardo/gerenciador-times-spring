package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.EstadioDto;
import com.example.SISTIME.model.entity.Estadio;
import com.example.SISTIME.service.EstadioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/api/v1/estadios")
@RequiredArgsConstructor
public class EstadioController {

    private final EstadioService service;

    @GetMapping
    public ResponseEntity get(){
        List<Estadio> estadios = service.getEstadio();

        return ResponseEntity.ok(estadios.stream().map(EstadioDto::create).collect(Collectors.toList()));
        //return ResponseEntity.ok(estadios.stream().map(c -> EstadioDto.create(c)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") long id){
        Optional<Estadio> estadio = service.getById(id);

        if(!estadio.isPresent()){
            return new ResponseEntity("Estádio não encontrado", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(estadio.map(EstadioDto::create));
        //return ResponseEntity.ok(estadio.map(c -> EstadioDto.create(c)));
    }

    private Estadio converter(EstadioDto dto){
        
    }
}


















