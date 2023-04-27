package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.PosicaoDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Posicao;
import com.example.SISTIME.service.PosicaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posicoes")
@RequiredArgsConstructor
public class PosicaoController {

    private final PosicaoService service;

    @GetMapping
    public ResponseEntity get(){
        List<Posicao> posicoes = service.getPosicao();
        return ResponseEntity.ok(posicoes.stream().map(PosicaoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Posicao> posicao = service.getPosicaoById(id);

        if(!posicao.isPresent()){
            return new ResponseEntity("Posicao não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(posicao.map(PosicaoDto::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody PosicaoDto dto){
        try{
            Posicao posicao = converter(dto);
            posicao = service.create(posicao);
            return new ResponseEntity(posicao, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody PosicaoDto dto){
        if(!service.getPosicaoById(id).isPresent()){
            return new ResponseEntity("Posicao não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Posicao posicao = converter(dto);
            posicao.setId(id);
            service.create(posicao);
            return ResponseEntity.ok(posicao);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        Optional<Posicao> posicao = service.getPosicaoById(id);
        if(!posicao.isPresent()){
            return new ResponseEntity("Posicao não encontrado", HttpStatus.NOT_FOUND);
        }
        try{
            service.delete(posicao.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Posicao converter(PosicaoDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Posicao posicao = modelMapper.map(dto, Posicao.class);
        return posicao;
    }
}
