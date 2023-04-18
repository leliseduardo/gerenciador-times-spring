package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Relacionados;
import com.example.SISTIME.model.repository.RelacionadosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelacionadosService {

    @Autowired
    private RelacionadosRepository repository;

    public List<Relacionados> getRelacionados(){
        return repository.findAll();
    }

    public Optional<Relacionados> getRelacionadosById(long id){
        return repository.findById(id);
    }

    @Transactional
    public Relacionados create(@Valid Relacionados relacionados){
        return repository.save(relacionados);
    }

    @Transactional
    public void delete(Relacionados relacionados){
        repository.delete(relacionados);
    }
}






























