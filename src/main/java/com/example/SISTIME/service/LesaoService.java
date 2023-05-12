package com.example.SISTIME.service;

import com.example.SISTIME.exception.RegraNegocioException;
import com.example.SISTIME.model.entity.Lesao;
import com.example.SISTIME.model.repository.LesaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LesaoService {

    private LesaoRepository repository;

    public LesaoService(LesaoRepository repository){
        this.repository = repository;
    }

    public List<Lesao> getLesoes() {
        return repository.findAll();
    }

    public Optional<Lesao> getLesaoById (Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Lesao salvar(Lesao lesao) {
        validar(lesao);
        return repository.save(lesao);
    }

    @Transactional
    public void excluir(Lesao lesao) {
        Objects.requireNonNull(lesao.getId());
        repository.delete(lesao);
    }

    public void validar(Lesao lesao) {
        if (lesao.getNome() == null || lesao.getNome().trim().equals("")) {
            throw new RegraNegocioException("Nome inválido");
        }

        if (lesao.getGravidade() == null || lesao.getGravidade().trim().equals("")) {
            throw new RegraNegocioException("Gravidade inválida");
        }

        if (lesao.getLocal() == null || lesao.getLocal().trim().equals("")) {
            throw new RegraNegocioException("Local inválido");
        }

        if (lesao.getTipo() == null || lesao.getTipo().trim().equals("")) {
            throw new RegraNegocioException("Tipo inválido");
        }

        if (lesao.getTempoMedioDeTratamento() == null || lesao.getTempoMedioDeTratamento() == 0) {
            throw new RegraNegocioException("Tempo Médio de Tratamento inválido");
        }
    }
}
