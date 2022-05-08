/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Controller;

import Projeto.IntegradorII.DAO.ClienteDAO;
import Projeto.IntegradorII.Model.Cliente;
import java.util.Date;
import java.util.List;

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
        Date dataNasc,
        String sexo,
        String estadoCivil,
        String cep,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String Estado){
 
        
        Cliente cliente = new Cliente();
        
         cliente.setNome(nome);
         cliente.setSobreNome(sobreNome);
         cliente.setCpf(cpf);
         cliente.setEmail(email);
         cliente.setTelefone(telefone);
         cliente.setDataNasc(dataNasc);
         cliente.setSexo(sexo);
         cliente.setEstadoCivil(estadoCivil);
         cliente.setCep(cep);
         cliente.setLogradouro(logradouro);
         cliente.setNumero(numero);
         cliente.setComplemento(complemento);
         cliente.setBairro(bairro);
         cliente.setCidade(cidade);
         cliente.setEstado(Estado);
      //return true ;
      return ClienteDAO.inserir(cliente);
    }
     public static boolean alterar(
        
        int id,
        String nome,
        String sobreNome,
        String cpf,
        String email,
        String telefone,
        Date dataNasc,
        String sexo,
        String estadoCivil,
        String cep,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String Estado)
     {
         Cliente cliente = new Cliente();
         
         cliente.setCodigo(id);
         cliente.setNome(nome);
         cliente.setSobreNome(sobreNome);
         cliente.setCpf(cpf);
         cliente.setEmail(email);
         cliente.setTelefone(telefone);
         cliente.setDataNasc(dataNasc);
         cliente.setSexo(sexo);
         cliente.setEstadoCivil(estadoCivil);
         cliente.setCep(cep);
         cliente.setLogradouro(logradouro);
         cliente.setNumero(numero);
         cliente.setComplemento(complemento);
         cliente.setBairro(bairro);
         cliente.setCidade(cidade);
         cliente.setEstado(Estado);
         
         
    
      //return true ;
      return ClienteDAO.alterar(cliente); 
     }
     
     public static boolean delete(
            int id
    ) {

        Cliente cliente = new Cliente();

        cliente.setCodigo(id);

        return ClienteDAO.delete(cliente);
        
    }
     
     public static List<Cliente> pesquisar(String filtroproc) {

        return ClienteDAO.pesquisar(filtroproc);
        
    }
     
     

}
