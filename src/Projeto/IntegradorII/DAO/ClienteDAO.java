/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.DAO;

import Projeto.IntegradorII.Connection.Conexao;
import Projeto.IntegradorII.Model.Cliente;
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
public class ClienteDAO {
    public static boolean inserir(Cliente cliente) {
        SimpleDateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd");
        boolean retorno = false;
        Connection conexao = Conexao.abreConexao();

        PreparedStatement comando;
        int linhas = 0;
        try {
            comando = conexao.prepareStatement("insert into produtos (nome, sobrenome, cpf, sexo, email, dataNascimento, estadoCivil, telefone, cep, logradouro, numero, complemento, bairro, cidade, estado) "
                    + "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getSobrenome());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getSexo());
            comando.setString(5, cliente.getEmail());
            comando.setString(6,formatoData.format(cliente.getDataNascimento()));       
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
}
