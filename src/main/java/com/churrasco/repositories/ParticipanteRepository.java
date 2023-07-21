package com.churrasco.repositories;

import com.churrasco.entities.participante.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

}
