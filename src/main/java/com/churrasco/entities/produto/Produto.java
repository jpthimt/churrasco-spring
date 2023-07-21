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

    public Produto() {
    }

    public Produto(String nome, Double preco, Double consumoPorPessoa) {
        this.nome = nome;
        this.preco = preco;
        this.consumoPorPessoa = consumoPorPessoa;
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
}
