package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Lesao;
import com.example.SISTIME.model.repository.LesaoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LesaoService {

    @Autowired
    private LesaoRepository repository;

    public List<Lesao> getLesao(){
       return repository.findAll();
    }

    public Optional<Lesao> getLesaoById(long id){
        return repository.findById(id);
    }

    @Transactional
    public Lesao create(@Valid Lesao lesao){
        return repository.save(lesao);
    }

    @Transactional
    public void delete(Lesao lesao){
        repository.delete(lesao);
    }
}























