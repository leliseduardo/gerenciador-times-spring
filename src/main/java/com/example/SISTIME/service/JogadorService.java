package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Jogador;
import com.example.SISTIME.model.repository.JogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repository;

    public List<Jogador> getJogador(){
        return repository.findAll();
    }

    public Optional<Jogador> getJogadorById(long id){
        return repository.findById(id);
    }

    public Jogador create(@Valid Jogador jogador){
        return repository.save(jogador);
    }

    public void delete(Jogador jogador){
        repository.delete(jogador);
    }
}
