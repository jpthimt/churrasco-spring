package com.churrasco.services.impl;

import com.churrasco.entities.produto.Produto;
import com.churrasco.repositories.ProdutoRepository;
import com.churrasco.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarProdutoPorId(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    @Override
    public Produto addProduto(Produto produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    @Override
    public void atualizarProduto(Produto produto) {
        Produto atual = this.buscarProdutoPorId(produto.getId());
        atual.setNome(produto.getNome());
        atual.setPreco(produto.getPreco());
        atual.setConsumoPorPessoa(produto.getConsumoPorPessoa());
        produtoRepository.save(atual);
    }

    @Override
    public void removeProdutoPorId(Integer id) {
        produtoRepository.deleteById(id);
    }
}
