/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Model;

import java.util.Date;

/**
 *
 * @author felip
 */
public class RelatorioAnalitico {

    public RelatorioAnalitico(int idProduto, String nome, String marca, int quantidade, double precoUnitario, double totalProduto) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.totalProduto = totalProduto;
    }

    private int idProduto;
    private String nome;
    private String marca;
    private int quantidade;
    private double precoUnitario;
    private double totalProduto;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(double totalProduto) {
        this.totalProduto = totalProduto;
    }

}
