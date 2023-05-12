package com.example.SISTIME.api.controller;


import com.example.SISTIME.api.dto.RelacionadoDto;
import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Relacionado;
import com.example.SISTIME.service.RelacionadosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/relacionados")
@RequiredArgsConstructor
@Api(tags="API de Relacionados na Partida")
public class RelacionadoController {
    private final RelacionadosService service;

    @GetMapping
    @ApiOperation("Obter todas os jogadores relacionados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Jogadores relacionados encontrados")
    })
    public ResponseEntity get(){
        List<Relacionado> relacionados = service.getRelacionados();
        return ResponseEntity.ok(relacionados.stream().map(RelacionadoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Obter detalhes de Jogadores relacionados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Jogadores relacionados encontrados"),
            @ApiResponse(code = 404, message = "Jogadores relacionados não encontrados")
    })
    public ResponseEntity getById(@PathVariable long id){
        Optional<Relacionado> relacionados = service.getRelacionadosById(id);

        if(!relacionados.isPresent()){
            return new ResponseEntity("Jogadores relacionados não encontrados", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(relacionados.map(RelacionadoDto::create));
    }

    @PostMapping()
    @ApiOperation("Salvar novos Jogadores relacionados")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Jogadores relacionados salvos com sucesso"),
            @ApiResponse(code = 400, message = "Erro ao salvar Jogadores relacionaods")
    })
    public ResponseEntity post(@RequestBody RelacionadoDto dto){
        try{
            Relacionado relacionado = converter(dto);
            relacionado = service.salvar(relacionado);
            return new ResponseEntity(relacionado, HttpStatus.CREATED);
        } catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Editar Jogadores relacionaods")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Jogadores relacionados editados com sucesso"),
            @ApiResponse(code = 404, message = "Jogadores relacionados não encontrados"),
            @ApiResponse(code = 400, message = "Erro ao salvar Jogadores relacionados")
    })
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody RelacionadoDto dto){
        if(!service.getRelacionadosById(id).isPresent()){
            return new ResponseEntity("Jogadores relacionados não encontrados", HttpStatus.NOT_FOUND);
        }
        try{
            Relacionado relacionado = converter(dto);
            relacionado.setId(id);
            service.salvar(relacionado);
            return ResponseEntity.ok(relacionado);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("id")
    @ApiOperation("Deletar Jogadores relacionados")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Jogadores relacionados deletados com sucesso"),
            @ApiResponse(code = 404, message = "Jogadores relacionados não encontrados"),
            @ApiResponse(code = 400, message = "Erro ao deletar Jogadores relacionados")
    })
    public ResponseEntity excluir(@PathVariable("id") long id) {
        Optional<Relacionado> relacionados = service.getRelacionadosById(id);
        if (!relacionados.isPresent()) {
            return new ResponseEntity<>("Jogadores relacionados não encontrados", HttpStatus.NOT_FOUND);
        }
        try {
            service.excluir(relacionados.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    private Relacionado converter(RelacionadoDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Relacionado relacionado = modelMapper.map(dto, Relacionado.class);
        return relacionado;
    }
}
