package com.churrasco.mapper;

import com.churrasco.dto.ParticipanteDTO;
import com.churrasco.entities.participante.Participante;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteMapper {
    public Participante mapParticipanteDTOToParticipante(ParticipanteDTO dto) {
        Participante participante = new Participante(dto.getNome(), dto.getDataNasc());
        return participante;
    }
}
