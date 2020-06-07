package com.ems.bdsqlitefull.pojo;

import java.io.Serializable;

// POJO - Plain Old Java Objects
public class Cliente implements Serializable {
    private int id;
    private String cpf;
    private String telefone;
    private String nome;
    private String email;
    private String descricao;


    /**
     * Método construtor vazio
     */
    public Cliente() {
    }

    /**
     * Método construtor da classe com assinatura
     *
     * @param cpf
     * @param telefone
     * @param nome
     * @param email
     * @param descricao
     */
    public Cliente(String cpf, String telefone, String nome, String email, String descricao) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    /**
     * Método construtor da classe com assinatura
     *
     * @param id
     * @param cpf
     * @param telefone
     * @param nome
     * @param email
     * @param descricao
     */
    public Cliente(int id, String cpf, String telefone, String nome, String email, String descricao) {
        this.id = id;
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    /**
     * Método sobrescrito para retornar o nome do aluno na ListView
     *
     * @return
     */
    @Override
    public String toString() {
        return nome;
    }

    /**
     * Método que retorna todos os dados de uma só vez
     *
     * @return
     */
    public String getDados() {
        return "ID: " + id + "\n" +
                "CPF: " + cpf + "\n" +
                "Telefone: " + telefone + "\n" +
                "Nome: " + nome + "\n" +
                "E-mail: " + email + "\n" +
                "Descrição: " + descricao;
    }


}