package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.LesaoJogador;
import com.example.SISTIME.model.repository.LesaoJogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LesaoJogadorService {

    @Autowired
    private LesaoJogadorRepository repository;

    public List<LesaoJogador> getLesaoJogador(){
        return repository.findAll();
    }

    public Optional<LesaoJogador> getLesaoJogadorById(long id) {
        return repository.findById(id);
    }

    public LesaoJogador create(@Valid LesaoJogador lesaoJogador){
        return repository.save(lesaoJogador);
    }

    public void delete(LesaoJogador lesaoJogador){
        repository.delete(lesaoJogador);
    }
}















