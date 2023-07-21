package com.churrasco.services.impl;

import com.churrasco.entities.participante.Participante;
import com.churrasco.repositories.ParticipanteRepository;
import com.churrasco.services.ParticipanteService;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Override
    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    @Override
    public Participante buscarParticipantePorId(Integer id) {
        Optional<Participante> participante = participanteRepository.findById(id);
        return participante.orElse(null);
    }

    @Override
    public Participante addParticipante(Participante participante) {
        participante.setId(null);
        return participanteRepository.save(participante);
    }

    @Override
    public void atualizaParticipante(Participante participante) {
        Participante atual = this.buscarParticipantePorId(participante.getId());
        atual.setNome(participante.getNome());
        atual.setNome(participante.getNome());
        atual.setDataNasc(participante.getDataNasc());
        participanteRepository.save(atual);
    }

    @Override
    public void removeParticipantePorId(Integer id) {
        participanteRepository.deleteById(id);
    }
}
