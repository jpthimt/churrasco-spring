package com.churrasco.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProdutoDTOTeste {
    ProdutoDTO produtoDTO = new ProdutoDTO();

    @BeforeEach
    void beforeEach() {
        produtoDTO = new ProdutoDTO();
    }

    @Test
    void produtoVazio() {
        assertNotNull(produtoDTO);
    }

    @Test
    void setProduto(){
        produtoDTO = new ProdutoDTO(1,"Picanha", 50.00, 0.5, "kg");
        assertNotNull(produtoDTO.getId());
        assertNotNull(produtoDTO.getNome());
        assertNotNull(produtoDTO.getPreco());
        assertNotNull(produtoDTO.getConsumoPorPessoa());
        assertNotNull(produtoDTO.getTipoUnidade());
        assertNotNull(produtoDTO.getQuantidade());
    }
}
