package com.churrasco.controllers;

import com.churrasco.dto.ProdutoDTO;
import com.churrasco.entities.produto.Produto;
import com.churrasco.mapper.ProdutoMapper;
import com.churrasco.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Integer id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<List<Produto>> addProduto(@Valid @RequestBody List<ProdutoDTO> dtoList){
        for (ProdutoDTO dto: dtoList){
            produtoService.addProduto(produtoMapper.mapProdutoDTOToProduto(dto));
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@Valid @RequestBody ProdutoDTO dto, @PathVariable Integer id) {
        Produto novoProduto = produtoMapper.mapProdutoDTOToProduto(dto);
        novoProduto.setId(id);
        produtoService.atualizarProduto(novoProduto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProdutoId(@PathVariable Integer id) {
        produtoService.removeProdutoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/quantidade")
    public String quantidadeProdutos() {
        StringBuilder res = new StringBuilder();
        produtoService.quantidadeProdutos();
        List<Produto> produtos = produtoService.listarProdutos();
        for(Produto produto : produtos){
            res.append("Produto: ").append(produto.getNome()).append("Quantidade: ").append(produto.getQuantidade()).append("\n");
        }
        return res.toString();
    }
}
