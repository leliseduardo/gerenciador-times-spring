package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.PosicaoJogador;
import com.example.SISTIME.model.repository.PosicaoJogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosicaoJogadorService {

    @Autowired
    private PosicaoJogadorRepository repository;

    public List<PosicaoJogador> getPosicaoJogador(){
        return repository.findAll();
    }

    public Optional<PosicaoJogador> getPosicaoJogadorById(long id){
        return repository.findById(id);
    }

    public PosicaoJogador create(@Valid PosicaoJogador posicaoJogador){
        return repository.save(posicaoJogador);
    }

    public void delete(PosicaoJogador posicaoJogador){
        repository.delete(posicaoJogador);
    }
}























