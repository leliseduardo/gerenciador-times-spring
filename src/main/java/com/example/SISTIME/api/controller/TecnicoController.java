package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.TecnicoDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Tecnico;
import com.example.SISTIME.service.TecnicoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody TecnicoDto dto){
        try{
            Tecnico tecnico = converter(dto);
            tecnico = service.create(tecnico);
            return new ResponseEntity(tecnico, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/id")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody TecnicoDto dto){
        if(!service.getTecnicoById(id).isPresent()){
            return new ResponseEntity("Tecnico não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Tecnico tecnico = converter(dto);
            tecnico.setId(id);
            service.create(tecnico);
            return ResponseEntity.ok(tecnico);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        Optional<Tecnico> tecnico = service.getTecnicoById(id);
        if(!tecnico.isPresent()){
            return new ResponseEntity("Tecnico não encontrado", HttpStatus.NOT_FOUND);
        }
        try{
            service.delete(tecnico.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Tecnico converter(TecnicoDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Tecnico tecnico = modelMapper.map(dto, Tecnico.class);
        return tecnico;
    }
}
