package com.example.SISTIME.service;

import com.example.SISTIME.model.entity.TimeAdversario;
import com.example.SISTIME.model.repository.TimeAdversarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeAdversarioService {

    @Autowired
    private TimeAdversarioRepository repository;

    public List<TimeAdversario> getTimeAdversario(){
        return repository.findAll();
    }

    public Optional<TimeAdversario> getTimeAdversarioById(long id){
        return repository.findById(id);
    }

    @Transactional
    public TimeAdversario create(@Valid TimeAdversario timeAdversario){
        return repository.save(timeAdversario);
    }

    @Transactional
    public void delete(TimeAdversario timeAdversario){
        repository.delete(timeAdversario);
    }


}




















