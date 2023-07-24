package com.churrasco.entities.participante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticipanteTeste {
    Participante participante = new Participante();

    @BeforeEach
    void beforeEach() {
        participante = new Participante();
    }

    @Test
    void participanteVazio() {
        assertNotNull(participante);
    }

    @Test
    void setParticipante(){
        participante = new Participante("João", LocalDate.of(1990, 1, 1));
        assertNotNull(participante.getNome());
        assertNotNull(participante.getDataNasc());
        assertNotNull(participante.getIdade());
    }

    @Test
    void setIdParticipante() {
        participante.setId(1);
        assertNotNull(participante.getId());
    }

//    @Test
//    void setNomeParticipante() {
//        participante.setNome("João");
//        assertNotNull(participante.getNome());
//    }
//
//    @Test
//    void setDataNascParticipante() {
//        participante.setDataNasc(LocalDate.of(1990, 1, 1));
//        assertNotNull(participante.getDataNasc());
//    }
//
//    @Test
//    void setIdadeParticipante() {
//        participante.setIdade(LocalDate.of(1990, 1, 1));
//        assertNotNull(participante.getIdade());
//    }

}
