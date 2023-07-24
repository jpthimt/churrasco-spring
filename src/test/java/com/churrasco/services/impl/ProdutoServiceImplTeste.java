package com.churrasco.services.impl;

import com.churrasco.entities.participante.Participante;
import com.churrasco.entities.produto.Produto;
import com.churrasco.repositories.ParticipanteRepository;
import com.churrasco.repositories.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoServiceImplTeste    {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    private ProdutoServiceImpl produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Test
    void listarProdutos() {
        assertNotNull(produtoRepository.findAll());
    }

    @Test
    void buscarProdutoPorId() {
        assertNotNull(produtoRepository.findById(1));
    }

    @Test
    void addProduto() {
        Integer cont = produtoService.listarProdutos().size();
        Produto prod = new Produto("Carne", 10.0, 0.5, "kg");
        produtoService.addProduto(prod);
        assertTrue(cont < produtoService.listarProdutos().size());
    }

    @Test
    void atualizaProduto(){
        Produto prod = new Produto("Carne", 10.0, 0.5, "kg");
        prod = produtoRepository.save(prod);
        prod.setNome("Picanha");
        produtoService.atualizarProduto(prod);
        assertEquals("Picanha", prod.getNome());
    }

    @Test
    void removeProdutoPorId(){
        Integer cont = produtoService.listarProdutos().size();
        produtoService.removeProdutoPorId(1);
        assertTrue(cont > produtoService.listarProdutos().size());
    }

    @Test
    void quantidadeProdutos(){
        Produto prod = new Produto("Carne", 10.0, 0.5, "kg");
        prod = produtoRepository.save(prod);
        produtoService.quantidadeProdutos();
        assertNotNull(prod.getQuantidade());
    }

}
