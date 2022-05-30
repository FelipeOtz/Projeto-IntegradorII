/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Controller;

import Projeto.IntegradorII.DAO.VendaDAO;
import Projeto.IntegradorII.Model.ItemVenda;
import Projeto.IntegradorII.Model.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author felip
 */
public class VendaController {

    public static boolean inserir(
            int idCliente,
            int idOperador,
            ArrayList<ItemVenda> itensVenda,
            double totalVenda,
            Date dataVenda
            ) {
        
        Venda venda = new Venda();
        venda.setIdCliente(idCliente);
        venda.setIdOperador(idOperador);
        venda.setItensVenda(itensVenda);
        venda.setTotalVenda(totalVenda);
        venda.setDataVenda(dataVenda);
        //return true ;
        return VendaDAO.inserir(venda);
        
    }
    
    public static List<Venda> pesquisar(String filtroProc){
        return VendaDAO.pesquisar(filtroProc);
    }

}
