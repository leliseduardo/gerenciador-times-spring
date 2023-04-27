package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.LesaoJogadorDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.LesaoJogador;
import com.example.SISTIME.service.LesaoJogadorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/lesoes-jogador")
@RequiredArgsConstructor
public class LesaoJogadorController {

    private final LesaoJogadorService service;

    @GetMapping
    public ResponseEntity get(){
        List<LesaoJogador> lesoesJogador = service.getLesaoJogador();
        return ResponseEntity.ok(lesoesJogador.stream().map(LesaoJogadorDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<LesaoJogador> lesaoJogador = service.getLesaoJogadorById(id);

        if(!lesaoJogador.isPresent()){
            return new ResponseEntity("LesaoJogador não encontrado", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(lesaoJogador.map(LesaoJogadorDto::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody LesaoJogadorDto dto){
        try {
            LesaoJogador lesaoJogador = converter(dto);
            lesaoJogador = service.create(lesaoJogador);
            return new ResponseEntity(lesaoJogador, HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody LesaoJogadorDto dto){
        if(!service.getLesaoJogadorById(id).isPresent()){
            return new ResponseEntity("LesaoJogador não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            LesaoJogador lesaoJogador = converter(dto);
            lesaoJogador.setId(id);
            service.create(lesaoJogador);
            return ResponseEntity.ok(lesaoJogador);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        Optional<LesaoJogador> lesaoJogador = service.getLesaoJogadorById(id);
        if(!lesaoJogador.isPresent()){
            return new ResponseEntity("LesaoJogador não encontrado", HttpStatus.NOT_FOUND);
        }
        try{
            service.delete(lesaoJogador.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private LesaoJogador converter(LesaoJogadorDto dto){
        ModelMapper modelMapper = new ModelMapper();
        LesaoJogador lesaoJogador = modelMapper.map(dto, LesaoJogador.class);
        return lesaoJogador;
    }
}



















