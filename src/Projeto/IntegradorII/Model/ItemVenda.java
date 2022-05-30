/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Model;

/**
 *
 * @author felip
 */
public class ItemVenda {

    @Override
    public String toString() {
        return "ItemVenda{" + "id_produto=" + id_produto + ", quantidade=" + quantidade + ", total_produto=" + total_produto + '}';
    }
    private int id_item_venda;
    private int id_venda;
    private int id_produto;
    private int quantidade;
    private double total_produto;

    public int getId_item_venda() {
        return id_item_venda;
    }

    public void setId_item_venda(int id_item_venda) {
        this.id_item_venda = id_item_venda;
    }
   
    
    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal_produto() {
        return total_produto;
    }

    public void setTotal_produto(double total_produto) {
        this.total_produto = total_produto;
    }
    
}
