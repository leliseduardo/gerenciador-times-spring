package com.example.SISTIME.api.controller;


import com.example.SISTIME.api.dto.MedicoDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Medico;
import com.example.SISTIME.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody MedicoDto dto){
        try {
            Medico medico = converter(dto);
            medico = service.create(medico);
            return new ResponseEntity(medico, HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Medico converter(MedicoDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Medico medico = modelMapper.map(dto, Medico.class);
        return medico;
    }
}
