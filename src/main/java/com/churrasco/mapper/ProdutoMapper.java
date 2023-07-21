package com.churrasco.mapper;

import com.churrasco.dto.ProdutoDTO;
import com.churrasco.entities.produto.Produto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoMapper {
    public Produto mapProdutoDTOToProduto(ProdutoDTO dto) {
        Produto produto = new Produto(dto.getNome(), dto.getPreco(), dto.getConsumoPorPessoa());
        return produto;
    }
}
