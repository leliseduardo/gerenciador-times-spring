package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.TecnicoDto;
import com.example.SISTIME.model.entity.Tecnico;
import com.example.SISTIME.service.TecnicoService;
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
@RequestMapping("/api/v1/tecnicos")
@RequiredArgsConstructor
public class TecnicoController {
    private final TecnicoService service;

    @GetMapping
    public ResponseEntity get(){
        List<Tecnico> tecnicos = service.getTecnico();
        return ResponseEntity.ok(tecnicos.stream().map(TecnicoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Tecnico> tecnico = service.getTecnicoById(id);

        if(!tecnico.isPresent()){
            return new ResponseEntity("Tecnico não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(tecnico.map(TecnicoDto::create));
    }
}
