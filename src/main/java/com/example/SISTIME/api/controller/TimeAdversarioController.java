package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.TimeAdversarioDto;
import com.example.SISTIME.model.entity.TimeAdversario;
import com.example.SISTIME.service.TimeAdversarioService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/v1/times-adversarios")
@RequiredArgsConstructor
public class TimeAdversarioController {
    private final TimeAdversarioService service;

    @GetMapping
    public ResponseEntity get(){
        List<TimeAdversario> timesAdversarios = service.getTimeAdversario();
        return ResponseEntity.ok(timesAdversarios.stream().map(TimeAdversarioDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<TimeAdversario> timeAdversario = service.getTimeAdversarioById(id);

        if(!timeAdversario.isPresent()){
            return new ResponseEntity("TimeAdversario não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(timeAdversario.map(TimeAdversarioDto::create));
    }
}
