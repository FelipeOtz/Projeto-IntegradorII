/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.DAO;

import Projeto.IntegradorII.Connection.Conexao;
import Projeto.IntegradorII.Model.ItemVenda;
import Projeto.IntegradorII.Model.Produto;
import Projeto.IntegradorII.Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author felip
 */
public class VendaDAO {

    public static boolean inserir(Venda venda) {
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");
        boolean retorno = false;
        Connection conexao = Conexao.abreConexao();
        ResultSet rs = null;

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("insert into vendas (id_cliente, id_operador, data_venda, total_venda) "
                    + "values (?, ?, ?, ?)");

            comando.setInt(1, venda.getIdCliente());
            comando.setInt(2, venda.getIdOperador());
            comando.setString(3, formatoData.format(venda.getDataVenda()));
            comando.setDouble(4, venda.getTotalVenda());

            linhas = comando.executeUpdate();
            
            
            
            comando = conexao.prepareStatement("SELECT LAST_INSERT_ID();");
            
            rs = comando.executeQuery();
            
           int ultimoId = 0;
            
            while (rs.next()) {
                 ultimoId = rs.getInt("LAST_INSERT_ID()");
            }
                    
            
            comando = conexao.prepareStatement("insert into itens_venda (fk_id_venda, fk_id_produto, quantidade, total_produto) "
                    + "values (?, ?, ?, ?)");   
            
            System.out.println(ultimoId);
            
            ArrayList<ItemVenda> itensVenda = venda.getItensVenda();
            
            
            for (ItemVenda itemVenda : itensVenda) {
               comando.setInt(1, ultimoId);
               comando.setInt(2, itemVenda.getId_produto());
               comando.setInt(3, itemVenda.getQuantidade());
               comando.setDouble(4, itemVenda.getTotal_produto());
               linhas = comando.executeUpdate();
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (linhas > 0) {
            retorno = true;
        }

        if (conexao != null) {
            Conexao.fechaConexao(conexao);
        }

        return retorno;
    }

    public static List<Venda> pesquisar(String filtroProc) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;

        List<Venda> vendas = new ArrayList();

        try {
             if (filtroProc.equals("")) {
                comando = conexao.prepareStatement("SELECT * FROM vendas");
            } else {
                comando = conexao.prepareStatement("SELECT * FROM vendas WHERE nome LIKE '%" + filtroProc + "%';");
            }

            rs = comando.executeQuery();

            while (rs.next()) {

                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("id_venda"));
                venda.setIdCliente(rs.getInt("id_cliente"));
                venda.setIdOperador(rs.getInt("id_operador"));
                venda.setDataVenda(rs.getDate("id_operador"));
                venda.setValorTotal(rs.getDouble("total_venda"));
                vendas.add(venda);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vendas;
    }
}
