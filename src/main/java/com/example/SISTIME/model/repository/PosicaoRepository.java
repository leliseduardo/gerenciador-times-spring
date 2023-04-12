package com.example.SISTIME.model.repository;

import com.example.SISTIME.model.entity.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicaoRepository  extends JpaRepository<Posicao, Long> {
}
