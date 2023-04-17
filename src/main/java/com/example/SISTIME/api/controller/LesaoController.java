package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.LesaoDto;
import com.example.SISTIME.model.entity.Lesao;
import com.example.SISTIME.service.LesaoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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
}



















