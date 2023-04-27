package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.TemporadaDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Temporada;
import com.example.SISTIME.service.TemporadaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/temporadas")
@RequiredArgsConstructor
public class TemporadaController {
    private final TemporadaService service;

    @GetMapping
    public ResponseEntity get(){
        List<Temporada> temporadas = service.getTemporada();
        return ResponseEntity.ok(temporadas.stream().map(TemporadaDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Temporada> temporada = service.getTemporadaById(id);

        if(!temporada.isPresent()){
            return new ResponseEntity("Temporada não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(temporada.map(TemporadaDto::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody TemporadaDto dto){
        try{
            Temporada temporada = converter(dto);
            temporada = service.create(temporada);
            return new ResponseEntity(temporada, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/id")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody TemporadaDto dto){
        if(!service.getTemporadaById(id).isPresent()){
            return new ResponseEntity("Temporada não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Temporada temporada = converter(dto);
            temporada.setId(id);
            service.create(temporada);
            return ResponseEntity.ok(temporada);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        Optional<Temporada> temporada = service.getTemporadaById(id);
        if(!temporada.isPresent()){
            return new ResponseEntity("Temporada não encontrado", HttpStatus.NOT_FOUND);
        }
        try{
            service.delete(temporada.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Temporada converter(TemporadaDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Temporada temporada = modelMapper.map(dto, Temporada.class);
        return temporada;
    }
}
