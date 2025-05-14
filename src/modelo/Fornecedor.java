/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Senai
 */
public class Fornecedor {
    
    private String id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private String nomeRepresentante;
    private String condicoesPagamento;
    private String prazoMedioEntrega;
    private String statusFornecimento;
    
    private String[] colunas = new String[]{"ID", "NOME", "CNPJ", "NOMEFANTASIA", "TELEFONE"};

    public Fornecedor() {
    }

    public Fornecedor(String id, String nome, String cnpj, String telefone, String razaoSocial, String nomeFantasia, String inscricaoEstadual, String nomeRepresentante, String condicoesPagamento, String prazoMedioEntrega, String statusFornecimento) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeRepresentante = nomeRepresentante;
        this.condicoesPagamento = condicoesPagamento;
        this.prazoMedioEntrega = prazoMedioEntrega;
        this.statusFornecimento = statusFornecimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCondicoesPagamento() {
        return condicoesPagamento;
    }

    public void setCondicoesPagamento(String condicoesPagamento) {
        this.condicoesPagamento = condicoesPagamento;
    }

    public String getPrazoMedioEntrega() {
        return prazoMedioEntrega;
    }

    public void setPrazoMedioEntrega(String prazoMedioEntrega) {
        this.prazoMedioEntrega = prazoMedioEntrega;
    }

    public String getStatusFornecimento() {
        return statusFornecimento;
    }

    public void setStatusFornecimento(String statusFornecimento) {
        this.statusFornecimento = statusFornecimento;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
}
