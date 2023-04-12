package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Estadio;
import com.example.SISTIME.model.repository.EstadioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository repository;

    public List<Estadio> getEstadio() {
        return repository.findAll();
    }

    public Optional<Estadio> getById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Estadio create(@Valid Estadio estadio){
        return repository.save(estadio);
    }

    public void delete(Estadio estadio){
        repository.delete(estadio);
    }
}





















