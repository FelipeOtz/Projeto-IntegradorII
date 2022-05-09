/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.DAO;

import Projeto.IntegradorII.Connection.Conexao;
import Projeto.IntegradorII.Model.Cliente;
import Projeto.IntegradorII.Model.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class ProdutoDAO {

    public static boolean inserir(Produto produto) {
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");
        boolean retorno = false;
        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("insert into produtos (nome, marca, setor, tipo, cor, estoque, preco, tamanho, unidade, validade, descricao) "
                    + "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getMarca());
            comando.setString(3, produto.getSetor());
            comando.setString(4, produto.getTipo());
            comando.setString(5, produto.getCor());
            comando.setInt(6, produto.getEstoque());
            comando.setDouble(7, produto.getPreco());
            comando.setDouble(8, produto.getTamanho());
            comando.setString(9, produto.getUnidade());
            comando.setString(10, formatoData.format(produto.getValidade()));
            comando.setString(11, produto.getDescricao());

            linhas = comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (linhas > 0) {
            retorno = true;
        }

        if (conexao != null) {
            Conexao.fechaConexao(conexao);
        }

        return retorno;
    }

    public static boolean alterar(Produto produto) {
        boolean retorno = false;

        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");
        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("UPDATE produtos SET nome = ?, marca = ?, setor = ?, tipo = ?, cor = ?, estoque = ?, preco = ?, tamanho = ?, unidade = ?, validade = ?, descricao = ? WHERE id_produto = ?");

            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getMarca());
            comando.setString(3, produto.getSetor());
            comando.setString(4, produto.getTipo());
            comando.setString(5, produto.getCor());
            comando.setInt(6, produto.getEstoque());
            comando.setDouble(7, produto.getPreco());
            comando.setDouble(8, produto.getTamanho());
            comando.setString(9, produto.getUnidade());
            comando.setString(10, formatoData.format(produto.getValidade()));
            comando.setString(11, produto.getDescricao());
            comando.setInt(12, produto.getCodigo());

            linhas = comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (linhas > 0) {
            retorno = true;
        }

        if (conexao != null) {
            Conexao.fechaConexao(conexao);
        }

        return retorno;

    }

    public static boolean delete(Produto produto) {
        boolean retorno = false;

        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("DELETE FROM produtos WHERE id_produto = ?");

            comando.setInt(1, produto.getCodigo());

            linhas = comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (linhas > 0) {
            retorno = true;
        }

        if (conexao != null) {
            Conexao.fechaConexao(conexao);
        }

        return retorno;
    }

    public static List<Produto> pesquisar(String filtroProc) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;

        List< Produto> produtos = new ArrayList();
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");

        try {
            if (filtroProc.equals("")) {
                comando = conexao.prepareStatement("SELECT * FROM produtos");
            } else {
                comando = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE '%" + filtroProc + "%';");
            }

            rs = comando.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setSetor(rs.getString("setor"));
                produto.setTipo(rs.getString("tipo"));
                produto.setCor(rs.getString("cor"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTamanho(rs.getDouble("tamanho"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setValidade(rs.getDate("validade"));
                produto.setDescricao(rs.getString("descricao"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return produtos;

    }

    public static List<Produto> pesquisarPorId(int Id) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;

        List< Produto> produtos = new ArrayList();

        try {
            comando = conexao.prepareStatement("SELECT * FROM produtos WHERE id_produto = ?");
            
            comando.setInt(1, Id);
            
            rs = comando.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setSetor(rs.getString("setor"));
                produto.setTipo(rs.getString("tipo"));
                produto.setCor(rs.getString("cor"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTamanho(rs.getDouble("tamanho"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setValidade(rs.getDate("validade"));
                produto.setDescricao(rs.getString("descricao"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return produtos;

    }
}
