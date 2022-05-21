/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.DAO;

import Projeto.IntegradorII.Connection.Conexao;
import Projeto.IntegradorII.Model.Produto;
import Projeto.IntegradorII.Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class VendaDAO {

    public static boolean inserir(Venda venda) {
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");
        boolean retorno = false;
        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("insert into vendas (id_cliente, id_operador, data_venda, total_venda) "
                    + "values (?, ?, ?, ?)");
            
            comando.setInt(1, venda.getIdCliente());
            comando.setInt(2, venda.getIdOperador());
            comando.setString(3, formatoData.format(venda.getDataVenda()));
            comando.setDouble(4, venda.getValorTotal());
  
            comando.setInt(linhas, linhas);
            
            linhas = comando.executeUpdate();

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
}
