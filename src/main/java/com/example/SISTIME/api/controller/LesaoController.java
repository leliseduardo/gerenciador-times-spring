package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.LesaoDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Lesao;
import com.example.SISTIME.service.LesaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.KeyStore;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/lesoes")
@RequiredArgsConstructor
public class LesaoController {

    private final LesaoService service;

    @GetMapping
    public ResponseEntity get(){
        List<Lesao> lesoes = service.getLesao();
        return ResponseEntity.ok(lesoes.stream().map(LesaoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Lesao> lesao = service.getLesaoById(id);

        if(!lesao.isPresent()){
            return new ResponseEntity("Lesao não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(lesao.map(LesaoDto::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody LesaoDto dto){
        try {
            Lesao lesao = converter(dto);
            lesao = service.create(lesao);
            return new ResponseEntity(lesao, HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/id")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody LesaoDto dto){
        if(!service.getLesaoById(id).isPresent()){
            return new ResponseEntity("Lesao não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Lesao lesao = converter(dto);
            lesao.setId(id);
            service.create(lesao);
            return ResponseEntity.ok(lesao);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{/id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        Optional<Lesao> lesao = service.getLesaoById(id);
        if(!lesao.isPresent()){
            return new ResponseEntity("Lesao não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            service.delete(lesao.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Lesao converter(LesaoDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Lesao lesao = modelMapper.map(dto, Lesao.class);
        return lesao;
    }
}



















