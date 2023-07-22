package com.churrasco.services.impl;

import com.churrasco.entities.participante.Participante;
import com.churrasco.entities.produto.Produto;
import com.churrasco.repositories.ParticipanteRepository;
import com.churrasco.repositories.ProdutoRepository;
import com.churrasco.services.ParticipanteService;
import com.churrasco.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

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
    public void addParticipante(Participante participante) {
        participante.setId(null);
        participanteRepository.save(participante);
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

    @Override
    public Double calculaValorIndividual() {
        int cont = this.listarParticipantes().size();
        double valorTotal = 0.0;
        double valorIndividual;
        produtoService.quantidadeProdutos();
        List<Produto> produtos = produtoRepository.findAll();
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco()*produto.getQuantidade();
        }
        valorIndividual = valorTotal/cont;
        return BigDecimal.valueOf(valorIndividual).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}
