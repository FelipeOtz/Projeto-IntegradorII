/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.DAO;

import Projeto.IntegradorII.Connection.Conexao;
import Projeto.IntegradorII.Model.Cliente;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
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
public class ClienteDAO {

    public static boolean inserir(Cliente cliente) {
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");
        boolean retorno = false;
        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("insert into clientes(nome, sobrenome, cpf, sexo, email, datanascimento, estadocivil, telefone, cep, logradouro, numero, complemento, bairro, cidade, estado) "
                    + "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getSobrenome());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getSexo());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, formatoData.format(cliente.getDataNasc()));
            comando.setString(7, cliente.getEstadoCivil());
            comando.setString(8, cliente.getTelefone());
            comando.setString(9, cliente.getCep());
            comando.setString(10, cliente.getLogradouro());
            comando.setString(11, cliente.getNumero());
            comando.setString(12, cliente.getComplemento());
            comando.setString(13, cliente.getBairro());
            comando.setString(14, cliente.getCidade());
            comando.setString(15, cliente.getEstado());

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

    public static boolean alterar(Cliente cliente) {
        boolean retorno = false;

        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");
        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("UPDATE clientes SET nome = ?, sobrenome = ?, cpf = ?, sexo = ?, email = ?, datanascimento = ?, estadocivil = ?, "
                    + "telefone = ?, cep = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ? WHERE id_cliente = ?");

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getSobrenome());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getSexo());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, formatoData.format(cliente.getDataNasc()));
            comando.setString(7, cliente.getEstadoCivil());
            comando.setString(8, cliente.getTelefone());
            comando.setString(9, cliente.getCep());
            comando.setString(10, cliente.getLogradouro());
            comando.setString(11, cliente.getNumero());
            comando.setString(12, cliente.getComplemento());
            comando.setString(13, cliente.getBairro());
            comando.setString(14, cliente.getCidade());
            comando.setString(15, cliente.getEstado());
            comando.setInt(16, cliente.getCodigo());

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

    public static boolean delete(Cliente cliente) {
        boolean retorno = false;

        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");

            comando.setInt(1, cliente.getCodigo());

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

    public static List<Cliente> pesquisar(String filtroProc) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList();
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");

        try {
            if (filtroProc.equals("")) {
                comando = conexao.prepareStatement("SELECT * FROM clientes");
            } else {
                comando = conexao.prepareStatement("SELECT * FROM clientes WHERE nome LIKE '%" + filtroProc + "%';");
            }

            rs = comando.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setSobreNome(rs.getString(3));
                cliente.setCpf(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setTelefone(rs.getString(6));
                cliente.setDataNasc(rs.getDate(7));
                cliente.setSexo(rs.getString(8));
                cliente.setEstadoCivil(rs.getString(9));
                cliente.setCep(rs.getString(10));
                cliente.setLogradouro(rs.getString(11));
                cliente.setNumero(rs.getString(12));
                cliente.setComplemento(rs.getString(13));
                cliente.setBairro(rs.getString(14));
                cliente.setCidade(rs.getString(15));
                cliente.setEstado(rs.getString(16));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clientes;

    }

    public static List<Cliente> pesquisarPorId(int id) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList();
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");

        try {

            comando = conexao.prepareStatement("SELECT * FROM clientes WHERE id_cliente = ?;");
            
            comando.setInt(1, id);

            rs = comando.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobreNome(rs.getString("sobrenome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setDataNasc(rs.getDate("datanascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEstadoCivil(rs.getString("estadocivil"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clientes;

    }
    
    public static List<Cliente> pesquisarPorCPF(String cpf) {

        Connection conexao = Conexao.abreConexao();
        PreparedStatement comando;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList();
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");

        try {

            comando = conexao.prepareStatement("SELECT * FROM clientes WHERE cpf = ?;");
            
            comando.setString(1, cpf);

            rs = comando.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setSobreNome(rs.getString(3));
                cliente.setCpf(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setTelefone(rs.getString(6));
                cliente.setDataNasc(rs.getDate(7));
                cliente.setSexo(rs.getString(8));
                cliente.setEstadoCivil(rs.getString(9));
                cliente.setCep(rs.getString(10));
                cliente.setLogradouro(rs.getString(11));
                cliente.setNumero(rs.getString(12));
                cliente.setComplemento(rs.getString(13));
                cliente.setBairro(rs.getString(14));
                cliente.setCidade(rs.getString(15));
                cliente.setEstado(rs.getString(16));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clientes;

    }

}
