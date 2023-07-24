package com.churrasco.entities.produto;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Double consumoPorPessoa;

    @Column(nullable = false)
    private String tipoUnidade;

    @Column(nullable = false)
    private Double quantidade;

    public Produto() {
        this.quantidade = 0.0;
    }

    public Produto(String nome, Double preco, Double consumoPorPessoa, String tipoUnidade) {
        setNome(nome);
        setPreco(preco);
        setConsumoPorPessoa(consumoPorPessoa);
        setTipoUnidade(tipoUnidade);
        setQuantidade(0.0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getConsumoPorPessoa() {
        return consumoPorPessoa;
    }

    public void setConsumoPorPessoa(Double consumoPorPessoa) {
        this.consumoPorPessoa = consumoPorPessoa;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
