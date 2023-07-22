package com.churrasco.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class ParticipanteDTO implements Serializable {
    private Integer id;

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max=50, message = "Nome não pode ter mais de 50 caracteres")
    private String nome;

    @NotNull(message = "Data de nascimento não pode ser nula")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNasc;

    private Integer idade;

    public ParticipanteDTO() {
    }

    public ParticipanteDTO(Integer id, String nome, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        setIdade(dataNasc);
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(LocalDate dataNasc){
        this.idade = Period.between(dataNasc, LocalDate.now()).getYears();
    }
}
