package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.CampeonatoDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Campeonato;
import com.example.SISTIME.service.CampeonatoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/campeonato")
@RequiredArgsConstructor
public class CampeonatoController {

    private final CampeonatoService service;

    @GetMapping
    public ResponseEntity get() {
        List<Campeonato> campeonatos = service.getCampeonato();
        return ResponseEntity.ok(campeonatos.stream().map(c -> CampeonatoDto.create(c)).collect(Collectors.toList()));
        //return ResponseEntity.ok(campeonatos.stream().map(CampeonatoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") long id){

        Optional<Campeonato> campeonato = service.getById(id);

        if(!campeonato.isPresent()){
            return new ResponseEntity("Campeonato não encontrado", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(campeonato.map(c -> CampeonatoDto.create(c)));
        //return ResponseEntity.ok(campeonato.map(CampeonatoDto::create);
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody CampeonatoDto dto){
        try{
            Campeonato campeonato = converter(dto);
            campeonato = service.create(campeonato);
            return new ResponseEntity(campeonato, HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("/id") long id, @RequestBody CampeonatoDto dto){
        if(!service.getById(id).isPresent()){
            return new ResponseEntity("Campeonato não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Campeonato campeonato = converter(dto);
            campeonato.setId(id);
            service.create(campeonato);
            return ResponseEntity.ok(campeonato);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Campeonato converter(CampeonatoDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Campeonato campeonato = modelMapper.map(dto, Campeonato.class);
        return campeonato;
    }
}





































