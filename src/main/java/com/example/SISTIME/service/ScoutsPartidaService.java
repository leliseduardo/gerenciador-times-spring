package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.ScoutsPartida;
import com.example.SISTIME.model.repository.ScoutsPartidaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoutsPartidaService {

    @Autowired
    private ScoutsPartidaRepository repository;

    public List<ScoutsPartida> getScoutsPartida(){
        return repository.findAll();
    }

    public Optional<ScoutsPartida> getScoutsPartidaById(long id){
        return repository.findById(id);
    }

    @Transactional
    public ScoutsPartida create(@Valid ScoutsPartida scoutsPartida){
        return repository.save(scoutsPartida);
    }

    @Transactional
    public void delete(ScoutsPartida scoutsPartida){
        repository.delete(scoutsPartida);
    }
}
























