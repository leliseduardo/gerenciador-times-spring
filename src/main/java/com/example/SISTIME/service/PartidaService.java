package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Partida;
import com.example.SISTIME.model.repository.PartidaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository repository;

    public List<Partida> getPartida(){
        return repository.findAll();
    }

    public Optional<Partida> getPartidaById(long id){
        return repository.findById(id);
    }

    @Transactional
    public Partida create(@Valid Partida partida){
        return repository.save(partida);
    }

    @Transactional
    public void delete(Partida partida){
        repository.delete(partida);
    }
}



























