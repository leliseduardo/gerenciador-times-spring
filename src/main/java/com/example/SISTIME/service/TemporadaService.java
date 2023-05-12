package com.example.SISTIME.service;

import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Temporada;
import com.example.SISTIME.model.repository.TemporadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TemporadaService {

    private TemporadaRepository repository;

    public TemporadaService(TemporadaRepository repository){
        this.repository = repository;
    }

    public List<Temporada> getTemporada() {
        return repository.findAll();
    }

    public Optional<Temporada> getTemporadaById (Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Temporada salvar(Temporada temporada) {
        validar(temporada);
        return repository.save(temporada);
    }

    @Transactional
    public void excluir(Temporada temporada) {
        Objects.requireNonNull(temporada.getId());
        repository.delete(temporada);
    }

    public void validar(Temporada temporada) {
        if (temporada.getDescricao() == null || temporada.getDescricao().trim().equals("")) {
            throw new RegraNegocioException("Descricao inválido");
        }
    }
}
