package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.ScoutsJogador;
import com.example.SISTIME.model.repository.ScoutsJogadorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoutsJogadorService {

    @Autowired
    private ScoutsJogadorRepository repository;

    public List<ScoutsJogador> getScoutsJogador(){
        return repository.findAll();
    }

    public Optional<ScoutsJogador> getScoutsJogadorById(long id){
        return repository.findById(id);
    }

    @Transactional
    public ScoutsJogador create(@Valid ScoutsJogador scoutsJogador){
        return repository.save(scoutsJogador);
    }

    @Transactional
    public void delete(ScoutsJogador scoutsJogador){
        repository.delete(scoutsJogador);
    }
}



















