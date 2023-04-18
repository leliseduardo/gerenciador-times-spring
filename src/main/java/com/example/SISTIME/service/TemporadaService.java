package com.example.SISTIME.service;


import com.example.SISTIME.model.entity.Temporada;
import com.example.SISTIME.model.repository.TemporadaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemporadaService {

    @Autowired
    private TemporadaRepository repository;

    public List<Temporada> getTemporada(){
        return repository.findAll();
    }

    public Optional<Temporada> getTemporadaById(long id){
        return repository.findById(id);
    }

    @Transactional
    public Temporada create(@Valid Temporada temporada){
        return repository.save(temporada);
    }

    @Transactional
    public void delete(Temporada temporada){
        repository.delete(temporada);
    }
}























