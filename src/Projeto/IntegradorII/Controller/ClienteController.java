/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Controller;

import Projeto.IntegradorII.DAO.ClienteDAO;
import Projeto.IntegradorII.Model.Cliente;

/**
 *
 * @author felip
 */
public class ClienteController {        
     public static boolean inserir(
        String nome,
        String sobreNome,
        String cpf,
        String email,
        String telefone,
        String dataNasc,
        String sexo,
        String estadoCivil,
        String cep,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String Estado){
 
        
        Cliente cliente = new Cliente(nome, sobreNome, cpf, email, telefone, dataNasc,
           sexo, estadoCivil, cep, logradouro, numero, complemento, bairro, cidade, Estado);
    
      //return true ;
      return ClienteDAO.inserir(cliente);
    }
}
