package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Tecnico;
import com.example.SISTIME.model.repository.TecnicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;


    public List<Tecnico> getTecnico(){
        return repository.findAll();
    }

    public Optional<Tecnico> getTecnicoById(long id){
        return repository.findById(id);
    }

    @Transactional
    public Tecnico create(@Valid Tecnico tecnico){
        return repository.save(tecnico);
    }

    @Transactional
    public void delete(Tecnico tecnico){
        repository.delete(tecnico);
    }
}



























