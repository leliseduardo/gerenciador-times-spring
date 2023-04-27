package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.PartidaDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Partida;
import com.example.SISTIME.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/partidas")
@RequiredArgsConstructor
public class PartidaController {
    private final PartidaService service;

    @GetMapping
    public ResponseEntity get(){
        List<Partida> partidas = service.getPartida();
        return ResponseEntity.ok(partidas.stream().map(PartidaDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Partida> partida = service.getPartidaById(id);

        if(!partida.isPresent()){
            return new ResponseEntity("Partida não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(partida.map(PartidaDto::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody PartidaDto dto){
        try {
            Partida partida = converter(dto);
            partida = service.create(partida);
            return new ResponseEntity(partida, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/id")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody PartidaDto dto){
        if(!service.getPartidaById(id).isPresent()){
            return new ResponseEntity("Partida não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Partida partida = converter(dto);
            partida.setId(id);
            service.create(partida);
            return ResponseEntity.ok(partida);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        Optional<Partida> partida = service.getPartidaById(id);
        if(!partida.isPresent()){
            return new ResponseEntity("Partida não encontrado", HttpStatus.NOT_FOUND);
        }
        try{
            service.delete(partida.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Partida converter(PartidaDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Partida partida = modelMapper.map(dto, Partida.class);
        return partida;
    }
}

















