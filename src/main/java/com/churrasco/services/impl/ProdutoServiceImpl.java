package com.churrasco.services.impl;

import com.churrasco.entities.produto.Produto;
import com.churrasco.repositories.ParticipanteRepository;
import com.churrasco.repositories.ProdutoRepository;
import com.churrasco.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

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
    public void addProduto(Produto produto) {
        produto.setId(null);
        produtoRepository.save(produto);
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

    @Override
    public void quantidadeProdutos() {
        Integer cont = participanteRepository.findAll().size();
        double qtd;
        List<Produto> produtos = produtoRepository.findAll();
        for (Produto produto : produtos) {
            if(produto.getTipoUnidade().equals("kg")){
                qtd = produto.getConsumoPorPessoa() * cont;
                produto.setQuantidade(BigDecimal.valueOf(qtd).setScale(2, RoundingMode.HALF_UP).doubleValue());
                produtoRepository.save(produto);
            }else{
                qtd = Math.ceil(produto.getConsumoPorPessoa() * cont);
                produto.setQuantidade(BigDecimal.valueOf(qtd).setScale(3, RoundingMode.HALF_UP).doubleValue());
                produtoRepository.save(produto);
            }
        }
    }
}
