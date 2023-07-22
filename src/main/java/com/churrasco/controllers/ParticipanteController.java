package com.churrasco.controllers;

import com.churrasco.dto.ParticipanteDTO;
import com.churrasco.entities.participante.Participante;
import com.churrasco.mapper.ParticipanteMapper;
import com.churrasco.services.ParticipanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private ParticipanteMapper participanteMapper;

    @GetMapping
    public ResponseEntity<List<Participante>> listarParticipantes(){
        List<Participante> participantes = participanteService.listarParticipantes();
        return ResponseEntity.ok().body(participantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participante> buscarParticipantePorId(@PathVariable Integer id){
        Participante participante = participanteService.buscarParticipantePorId(id);
        return ResponseEntity.ok().body(participante);
    }

    @PostMapping
    public ResponseEntity<List<Participante>> addParticipante(@Valid @RequestBody List<ParticipanteDTO> dtoList){
        for (ParticipanteDTO dto: dtoList){
            participanteService.addParticipante(participanteMapper.mapParticipanteDTOToParticipante(dto));
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participante> atualizaParticipante(@Valid @RequestBody ParticipanteDTO dto, @PathVariable Integer id){
        Participante novoParticipante = participanteMapper.mapParticipanteDTOToParticipante(dto);
        novoParticipante.setId(id);
        participanteService.atualizaParticipante(novoParticipante);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeParticipanteId(@PathVariable Integer id){
        participanteService.removeParticipantePorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/valor")
    public String calculaPrecoIndividual(){
        return ("Valor individual: " +
                NumberFormat.getCurrencyInstance().format(participanteService.calculaValorIndividual()) +
                "\nValor total: " +
                NumberFormat.getCurrencyInstance().format(participanteService.calculaValorIndividual() * participanteService.listarParticipantes().size()));
    }
}
