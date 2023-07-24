package com.churrasco.entities.produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProdutoTeste {
    Produto produto = new Produto();

    @BeforeEach
    void beforeEach() {
        produto = new Produto();
    }

    @Test
    void produtoVazio() {
        assertNotNull(produto);
    }

    @Test
    void setProduto(){
        produto = new Produto("Picanha", 50.00, 0.5, "kg");
        assertNotNull(produto.getNome());
        assertNotNull(produto.getPreco());
        assertNotNull(produto.getConsumoPorPessoa());
        assertNotNull(produto.getTipoUnidade());
        assertNotNull(produto.getQuantidade());
    }

    @Test
    void setIdProduto() {
        produto.setId(1);
        assertNotNull(produto.getId());
    }

//    @Test
//    void setNomeProduto() {
//        produto.setNome("Picanha");
//        assertNotNull(produto.getNome());
//    }
//
//    @Test
//    void setPrecoProduto() {
//        produto.setPreco(50.00);
//        assertNotNull(produto.getPreco());
//    }
//
//    @Test
//    void setConsumoPorPessoaProduto() {
//        produto.setConsumoPorPessoa(0.5);
//        assertNotNull(produto.getConsumoPorPessoa());
//    }
//
//    @Test
//    void setTipoUnidadeProduto() {
//        produto.setTipoUnidade("kg");
//        assertNotNull(produto.getTipoUnidade());
//    }
//
//    @Test
//    void setQuantidadeProdutoZero() {
//        assertEquals(0.0, produto.getQuantidade());
//    }
//
//    @Test
//    void setQuantidadeProduto() {
//        produto.setQuantidade(1.0);
//        assertNotNull(produto.getQuantidade());
//    }

}
