package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Posicao;
import com.example.SISTIME.model.repository.PosicaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosicaoService {

    @Autowired
    private PosicaoRepository repository;

    public List<Posicao> getPosicao(){
        return repository.findAll();
    }

    public Optional<Posicao> getPosicaoById(long id){
        return repository.findById(id);
    }

    public Posicao create(@Valid Posicao posicao){
        return repository.save(posicao);
    }

    public void delete(Posicao posicao){
        repository.delete(posicao);
    }
}





























