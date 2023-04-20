package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.RelacionadosDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Relacionados;
import com.example.SISTIME.service.RelacionadosService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody RelacionadosDto dto){
        try{
            Relacionados relacionados = converter(dto);
            relacionados = service.create(relacionados);
            return new ResponseEntity(relacionados, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/id")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody RelacionadosDto dto){
        if(!service.getRelacionadosById(id).isPresent()){
            return new ResponseEntity("Relacionados não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Relacionados relacionados = converter(dto);
            relacionados.setId(id);
            service.create(relacionados);
            return ResponseEntity.ok(relacionados);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Relacionados converter(RelacionadosDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Relacionados relacionados = modelMapper.map(dto, Relacionados.class);
        return relacionados;
    }
}
