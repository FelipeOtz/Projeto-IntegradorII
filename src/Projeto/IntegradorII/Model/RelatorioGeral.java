/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Model;

/**
 *
 * @author felip
 */
public class RelatorioGeral {

    public RelatorioGeral(int totalVendas, double foturamento) {
        this.totalVendas = totalVendas;
        this.foturamento = foturamento;
    }
    private int totalVendas;
    private double foturamento;

    public RelatorioGeral() {
    }


    public int getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(int totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getFoturamento() {
        return foturamento;
    }

    public void setFoturamento(double foturamento) {
        this.foturamento = foturamento;
    }
    
}
