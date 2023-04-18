package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.RelacionadosDto;
import com.example.SISTIME.model.entity.Relacionados;
import com.example.SISTIME.service.RelacionadosService;
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
@RequestMapping("/api/v1/relacionados")
@RequiredArgsConstructor
public class RelacionadosController {
    private final RelacionadosService service;

    @GetMapping
    public ResponseEntity get(){
        List<Relacionados> relacionados = service.getRelacionados();
        return ResponseEntity.ok(relacionados.stream().map(RelacionadosDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Relacionados> relacionados = service.getRelacionadosById(id);

        if(!relacionados.isPresent()){
            return new ResponseEntity("Relacionados não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(relacionados.map(RelacionadosDto::create));
    }
}
