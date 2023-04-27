package com.example.SISTIME.api.controller;

import com.example.SISTIME.api.dto.TimeAdversarioDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.TimeAdversario;
import com.example.SISTIME.service.TimeAdversarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody TimeAdversarioDto dto){
        try{
            TimeAdversario timeAdversario = converter(dto);
            timeAdversario = service.create(timeAdversario);
            return new ResponseEntity(timeAdversario, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody TimeAdversarioDto dto){
        if(!service.getTimeAdversarioById(id).isPresent()){
            return new ResponseEntity("TimeAdversario não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            TimeAdversario timeAdversario = converter(dto);
            timeAdversario.setId(id);
            service.create(timeAdversario);
            return ResponseEntity.ok(timeAdversario);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        Optional<TimeAdversario> timeAdversario = service.getTimeAdversarioById(id);
        if(!timeAdversario.isPresent()){
            return new ResponseEntity("TimeAdversario não encontrado", HttpStatus.NOT_FOUND);
        }
        try{
            service.delete(timeAdversario.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private TimeAdversario converter(TimeAdversarioDto dto){
        ModelMapper modelMapper = new ModelMapper();
        TimeAdversario timeAdversario = modelMapper.map(dto, TimeAdversario.class);
        return timeAdversario;
    }
}
