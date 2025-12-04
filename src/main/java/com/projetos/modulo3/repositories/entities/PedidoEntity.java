package com.projetos.modulo3.repositories.entities;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class PedidoEntity {
    private Integer id;
    private String produto;
    private int qtd;
    private String cep;
    private Date data;
    private String status;

    public PedidoEntity(int id, String produto, int qtd, String cep, Date data, String status) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
        this.cep = cep;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
     public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
