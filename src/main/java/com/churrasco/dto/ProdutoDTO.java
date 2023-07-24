package com.churrasco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private Integer id;

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 20, message = "Nome não pode ter mais de 20 caracteres")
    private String nome;

    @NotNull(message = "Preço não pode ser nulo")
    private Double preco;

    @NotNull(message = "Consumo por pessoa não pode ser nulo")
    private Double consumoPorPessoa;

    @NotNull(message = "Tipo de unidade não pode ser nulo")
    private String tipoUnidade;

    private Double quantidade;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer id, String nome, Double preco, Double consumoPorPessoa, String tipoUnidade) {
        setId(id);
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

    public void setConsumoPorPessoa(Double quantidadePorPessoa) {
        this.consumoPorPessoa = quantidadePorPessoa;
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
