package com.example.SISTIME.model.repository;

import com.example.SISTIME.model.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository  extends JpaRepository<Medico, Long> {
}
