package com.churrasco.dto;

import com.churrasco.entities.participante.Participante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticipanteDTOTeste {
    ParticipanteDTO participanteDTO = new ParticipanteDTO();

    @BeforeEach
    void beforeEach() {
        participanteDTO = new ParticipanteDTO();
    }

    @Test
    void participanteVazio() {
        assertNotNull(participanteDTO);
    }

    @Test
    void setParticipante(){
        participanteDTO = new ParticipanteDTO(1, "João", LocalDate.of(1990, 1, 1));
        assertNotNull(participanteDTO.getId());
        assertNotNull(participanteDTO.getNome());
        assertNotNull(participanteDTO.getDataNasc());
        assertNotNull(participanteDTO.getIdade());
    }

}
