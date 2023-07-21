package com.churrasco.config;

import com.churrasco.entities.participante.Participante;
import com.churrasco.entities.produto.Produto;
import com.churrasco.repositories.ParticipanteRepository;
import com.churrasco.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Profile("test")
public class TestDatabase implements CommandLineRunner {
    @Autowired
    private ParticipanteRepository participanteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {
        Participante part1 = new Participante("Joao", LocalDate.parse("22/10/1990", formatter));
        Participante part2 = new Participante("Maria", LocalDate.parse("07/08/1987", formatter));
        Participante part3 = new Participante("Jose", LocalDate.parse("15/03/1995", formatter));
        participanteRepository.save(part1);
        participanteRepository.save(part2);
        participanteRepository.save(part3);

        Produto prod1 = new Produto("Carne", 49.00, 0.2);
        Produto prod2 = new Produto("Pao", 10.00, 0.1);
        Produto prod3 = new Produto("Linguiça", 24.00, 0.1);
        produtoRepository.save(prod1);
        produtoRepository.save(prod2);
        produtoRepository.save(prod3);
    }
}
