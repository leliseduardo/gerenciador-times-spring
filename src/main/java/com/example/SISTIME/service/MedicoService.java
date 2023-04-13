package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.Medico;
import com.example.SISTIME.model.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public List<Medico> getMedico(){
        return repository.findAll();
    }

    public Optional<Medico> getMEdicoById(long id){
        return repository.findById(id);
    }

    public Medico create(@Valid Medico medico){
       return repository.save(medico);
    }

    public void delete(Medico medico){
        repository.delete(medico);
    }
}



















