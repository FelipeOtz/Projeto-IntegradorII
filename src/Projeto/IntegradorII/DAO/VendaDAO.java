/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.DAO;

import Projeto.IntegradorII.Connection.Conexao;
import Projeto.IntegradorII.Model.ItemVenda;
import Projeto.IntegradorII.Model.Produto;
import Projeto.IntegradorII.Model.RelatorioAnalitico;
import Projeto.IntegradorII.Model.RelatorioGeral;
import Projeto.IntegradorII.Model.RelatorioSintetico;
import Projeto.IntegradorII.Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public static List<RelatorioSintetico> buscaRelatorioSintetico(String periodoInicial, String periodoFim) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");

        List<RelatorioSintetico> relatoriosSinteticos = new ArrayList();

        try {
            if (periodoInicial.equals("") || periodoFim.equals("")) {
                comando = conexao.prepareStatement("select vendas.id_venda, concat(clientes.nome, ' ' , clientes.sobrenome) as 'cliente', clientes.cpf as 'cpf_cliente', vendas.data_venda, vendas.total_venda, operadores.nome as 'operador' "
                        + "from vendas inner join clientes on vendas.id_cliente = clientes.id_cliente inner join operadores on vendas.id_operador = operadores.id_operador;");
            } else {
                comando = conexao.prepareStatement("select vendas.id_venda, concat(clientes.nome, ' ' , clientes.sobrenome) as 'cliente', clientes.cpf as 'cpf_cliente', vendas.data_venda, vendas.total_venda, operadores.nome as 'operador' "
                        + "from vendas inner join clientes on vendas.id_cliente = clientes.id_cliente inner join operadores on vendas.id_operador = operadores.id_operador "
                        + "where vendas.data_venda between '" + periodoInicial + "' and '" + periodoFim + "';");
            }

            rs = comando.executeQuery();

            while (rs.next()) {

                RelatorioSintetico relatorioSintetico = new RelatorioSintetico(
                        rs.getInt("id_venda"),
                        rs.getString("cliente"),
                        rs.getString("cpf_cliente"),
                        rs.getDate("data_venda"),
                        rs.getDouble("total_venda"),
                        rs.getString("operador"));

                relatoriosSinteticos.add(relatorioSintetico);

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

        return relatoriosSinteticos;
    }

    public static List<RelatorioAnalitico> buscaRelatorioAnalitico(int idVenda) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;

        List<RelatorioAnalitico> relatoriosAnaliticos = new ArrayList();

        try {

            comando = conexao.prepareStatement("select  itens_venda.fk_id_produto, produtos.nome as 'produto', produtos.marca, itens_venda.quantidade, produtos.preco as 'preco_unitario', itens_venda.total_produto\n"
                    + "from  itens_venda inner join produtos on itens_venda.fk_id_produto = produtos.id_produto where itens_venda.fk_id_venda = "+idVenda+" order by produto;");

            rs = comando.executeQuery();

            while (rs.next()) {

                RelatorioAnalitico relatorioAnalitico = new RelatorioAnalitico(
                        rs.getInt("fk_id_produto"),
                        rs.getString("produto"),
                        rs.getString("marca"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco_unitario"),
                        rs.getDouble("total_produto"));

                relatoriosAnaliticos.add(relatorioAnalitico);

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

        return relatoriosAnaliticos;
    }
    
    
    public static RelatorioGeral buscaRelatorioGeral() {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;
        RelatorioGeral relatorioGeral = new RelatorioGeral();

        try {

            comando = conexao.prepareStatement("select sum(total_venda) as 'faturamento', count(total_venda) as 'total' from vendas;");

            rs = comando.executeQuery();
            
            
            
            while (rs.next()) {
                relatorioGeral.setFoturamento( rs.getDouble("faturamento"));
                relatorioGeral.setTotalVendas( rs.getInt("total"));
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

        return relatorioGeral;
    }
}
