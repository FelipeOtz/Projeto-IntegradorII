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
public class RelatorioSintetico {

    public RelatorioSintetico(int idVenda, String cliente, String cpf, Date dataVenda, double totalVenda, String operador) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.cpf = cpf;
        this.dataVenda = dataVenda;
        this.totalVenda = totalVenda;
        this.operador = operador;
    }

    private int idVenda;
    private String cliente;
    private String cpf;
    private Date dataVenda;
    private double totalVenda;
    private String operador;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

}
