package com.churrasco.services;

import com.churrasco.entities.produto.Produto;

import java.util.List;

public interface ProdutoService {
    public List<Produto> listarProdutos();
    public Produto buscarProdutoPorId(Integer id);
    public void addProduto(Produto produto);
    public void atualizarProduto(Produto produto);
    public void removeProdutoPorId(Integer id);
    public void quantidadeProdutos();
}
