package com.churrasco.mapper;

import com.churrasco.dto.ParticipanteDTO;
import com.churrasco.entities.participante.Participante;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteMapper {
    public Participante mapParticipanteDTOToParticipante(ParticipanteDTO dto) {
        return new Participante(dto.getNome(), dto.getDataNasc());
    }
}