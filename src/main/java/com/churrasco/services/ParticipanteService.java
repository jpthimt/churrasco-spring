package com.churrasco.services;

import com.churrasco.entities.participante.Participante;

import java.util.List;

public interface ParticipanteService {
    public List<Participante> listarParticipantes();
    public Participante buscarParticipantePorId(Integer id);
    public Participante addParticipante(Participante participante);
    public void atualizaParticipante(Participante participante);
    public void removeParticipantePorId(Integer id);
}
