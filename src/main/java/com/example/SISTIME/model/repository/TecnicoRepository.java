package com.example.SISTIME.model.repository;

import com.example.SISTIME.model.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Long> {
}
