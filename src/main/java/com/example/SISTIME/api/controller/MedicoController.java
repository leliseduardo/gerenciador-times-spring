package com.example.SISTIME.api.controller;


import com.example.SISTIME.api.dto.MedicoDto;
import com.example.SISTIME.model.entity.Medico;
import com.example.SISTIME.service.MedicoService;
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
@RequestMapping("/api/v1/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService service;

    @GetMapping
    public ResponseEntity get(){
        List<Medico> medicos = service.getMedico();
        return ResponseEntity.ok(medicos.stream().map(MedicoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Medico> medico = service.getMedicoById(id);

        if(!medico.isPresent()){
            return new ResponseEntity("Medico não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(medico.map(MedicoDto::create));
    }
}
