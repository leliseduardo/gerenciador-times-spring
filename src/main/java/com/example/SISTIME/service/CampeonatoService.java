package com.example.SISTIME.service;

import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Campeonato;
import com.example.SISTIME.model.repository.CampeonatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository repository;

    public List<Campeonato> getCampeonato() {
        return repository.findAll();
    }

    public Optional<Campeonato> getById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Campeonato create(Campeonato campeonato){
        validar(campeonato);
        return repository.save(campeonato);
    }

    @Transactional
    public void delete(Campeonato campeonato){
        Objects.requireNonNull(campeonato.getId());
        repository.delete(campeonato);
    }

    private void validar(Campeonato campeonato){
        if(campeonato.getNome() == null || campeonato.getNome().trim().equals("")){
            throw new RegraNegocioException("Nome inválido");
        }

        if(campeonato.getTemporada() == null || campeonato.getTemporada().getId() == null || campeonato.getTemporada().getId() == 0) {
            throw new RegraNegocioException("Temporada inválida");
        }
    }
}























