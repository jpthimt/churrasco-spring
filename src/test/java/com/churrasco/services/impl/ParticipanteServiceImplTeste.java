package com.churrasco.services.impl;

import com.churrasco.entities.participante.Participante;
import com.churrasco.repositories.ParticipanteRepository;
import com.churrasco.repositories.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class ParticipanteServiceImplTeste {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private ParticipanteServiceImpl participanteService;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoServiceImpl produtoService;

    @Test
    void ListarParticipantes() {
        assertNotNull(participanteRepository.findAll());
    }

    @Test
    void buscarParticipantePorId() {
        assertNotNull(participanteRepository.findById(1));
    }

    @Test
    void addParticipante() {
        Integer cont = participanteService.listarParticipantes().size();
        Participante part = new Participante("Joao", LocalDate.parse("22/10/1990", formatter));
        participanteService.addParticipante(part);
        assertTrue(cont < participanteService.listarParticipantes().size());
    }

    @Test
    void atualizaParticipante() {
        Participante part = new Participante("Joao", LocalDate.parse("22/10/1990", formatter));
        part = participanteRepository.save(part);
        part.setNome("Maria");
        participanteService.atualizaParticipante(part);
        assertEquals("Maria", part.getNome());
    }

    @Test
    void removeParticipantePorId() {
        Integer cont = participanteService.listarParticipantes().size();
        participanteService.removeParticipantePorId(1);
        assertTrue(cont > participanteService.listarParticipantes().size());
    }

    @Test
    void calculaValorIndividual(){
        Double valor = participanteService.calculaValorIndividual();
        assertNotEquals(0.0, valor);
    }

}
