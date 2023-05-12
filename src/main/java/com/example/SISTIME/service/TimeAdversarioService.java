package com.example.SISTIME.service;

import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.TimeAdversario;
import com.example.SISTIME.model.repository.TimeAdversarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TimeAdversarioService {

    private TimeAdversarioRepository repository;

    public TimeAdversarioService(TimeAdversarioRepository repository){
        this.repository = repository;
    }

    public List<TimeAdversario> getTimeAdversario() {
        return repository.findAll();
    }

    public Optional<TimeAdversario> getTimeAdversarioById (Long id) {
        return repository.findById(id);
    }

    @Transactional
    public TimeAdversario salvar(TimeAdversario timeAdversario) {
        validar(timeAdversario);
        return repository.save(timeAdversario);
    }

    @Transactional
    public void excluir(TimeAdversario timeAdversario) {
        Objects.requireNonNull(timeAdversario.getId());
        repository.delete(timeAdversario);
    }

    public void validar(TimeAdversario timeAdversario) {
        if (timeAdversario.getNome() == null || timeAdversario.getNome().trim().equals("")) {
            throw new RegraNegocioException("Nome inválido");
        }
    }
}
