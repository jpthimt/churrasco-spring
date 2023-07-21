package com.churrasco.controllers;

import com.churrasco.dto.ProdutoDTO;
import com.churrasco.entities.produto.Produto;
import com.churrasco.mapper.ProdutoMapper;
import com.churrasco.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<Produto> addProduto(@Valid @RequestBody ProdutoDTO dto) throws URISyntaxException {
        Produto novoProduto = produtoService.addProduto(produtoMapper.mapProdutoDTOToProduto(dto));
        return ResponseEntity.created(new URI("/produtos/" + novoProduto.getId())).body(novoProduto);
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
}
